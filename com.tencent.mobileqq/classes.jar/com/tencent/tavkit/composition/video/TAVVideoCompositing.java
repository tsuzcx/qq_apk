package com.tencent.tavkit.composition.video;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.tav.core.compositing.AsynchronousVideoCompositionRequest;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.compositing.VideoCompositionRenderContext;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.ErrorMsg;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.ciimage.ThreadLocalTextureCache;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.report.CompositingReportSession;
import com.tencent.tavkit.report.MemoryReportHelper;
import com.tencent.tavkit.utils.BenchUtil;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TAVVideoCompositing
  implements VideoCompositing
{
  @Nullable
  private CIContext ciContext;
  private final TAVVideoMixEffect.Filter defaultVideoMixFilter;
  private final HashMap<String, TAVVideoEffect.Filter> globalFilterMap;
  private final String mTAG;
  private final HashMap<String, TAVVideoMixEffect.Filter> mixFilterMap;
  @Nullable
  private Thread renderThread;
  @Nullable
  private CompositingReportSession reportSession;
  private final HashMap<String, TAVVideoEffect.Filter> sourceFilterMap;
  private final HashMap<String, TAVVideoTransition.Filter> transitionFilterMap;
  private boolean tryPostReleaseDone;
  
  public TAVVideoCompositing()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TAVVideoCompositing@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.mTAG = localStringBuilder.toString();
    this.transitionFilterMap = new HashMap();
    this.sourceFilterMap = new HashMap();
    this.mixFilterMap = new HashMap();
    this.globalFilterMap = new HashMap();
    this.defaultVideoMixFilter = new DefaultVideoMixFilter();
    this.tryPostReleaseDone = false;
  }
  
  private CIImage applyClipSourceEffect(RenderInfo paramRenderInfo, @NonNull CIImage paramCIImage, List<TAVVideoEffect> paramList)
  {
    Object localObject = paramCIImage;
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return paramCIImage;
      }
      paramList = paramList.iterator();
      for (;;)
      {
        localObject = paramCIImage;
        if (!paramList.hasNext()) {
          break;
        }
        localObject = (TAVVideoEffect)paramList.next();
        TAVVideoEffect.Filter localFilter = getSourceFilter((TAVVideoEffect)localObject, paramRenderInfo);
        if (localFilter != null) {
          paramCIImage = localFilter.apply((TAVVideoEffect)localObject, paramCIImage, paramRenderInfo);
        }
      }
    }
    return localObject;
  }
  
  private CIImage applyCompositionSourceEffect(RenderInfo paramRenderInfo, CIImage paramCIImage, TAVVideoEffect paramTAVVideoEffect)
  {
    TAVVideoEffect.Filter localFilter = getSourceFilter(paramTAVVideoEffect, paramRenderInfo);
    if (localFilter == null) {
      return paramCIImage;
    }
    return localFilter.apply(paramTAVVideoEffect, paramCIImage, paramRenderInfo);
  }
  
  private void applySourceTransform(TAVVideoConfiguration paramTAVVideoConfiguration, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    String str = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("applySourceTransform() called with: config = [");
    localStringBuilder.append(paramTAVVideoConfiguration);
    localStringBuilder.append("]");
    Logger.v(str, localStringBuilder.toString());
    if (paramTAVVideoConfiguration.frameEnable()) {
      paramCIImage.imageApplyFillInFrame(paramTAVVideoConfiguration.getFrame(), paramTAVVideoConfiguration.getContentMode());
    } else if (paramTAVVideoConfiguration.getFrame() == TAVVideoConfiguration.FIX_RENDER_SIZE) {
      paramCIImage.applyFixInSize(paramRenderInfo.getRenderSize(), paramTAVVideoConfiguration.getContentMode());
    }
    paramCIImage.safeApplyTransform(paramTAVVideoConfiguration.getTransform());
  }
  
  private void attachTimeToSourceFilters(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest)
  {
    Iterator localIterator = this.sourceFilterMap.values().iterator();
    while (localIterator.hasNext())
    {
      TAVVideoEffect.Filter localFilter = (TAVVideoEffect.Filter)localIterator.next();
      if ((localFilter instanceof TAVAttachTimeRangeSourceEffect.TimeAttachFilter)) {
        ((TAVAttachTimeRangeSourceEffect.TimeAttachFilter)localFilter).attachPositionTime(paramAsynchronousVideoCompositionRequest.getCompositionTime());
      }
    }
  }
  
  private CIImage compositingImages(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest, TAVVideoCompositionInstruction paramTAVVideoCompositionInstruction)
  {
    if (this.ciContext == null) {
      return null;
    }
    attachTimeToSourceFilters(paramAsynchronousVideoCompositionRequest);
    RenderInfo localRenderInfo = new RenderInfo(paramAsynchronousVideoCompositionRequest.getCompositionTime(), paramAsynchronousVideoCompositionRequest.getRenderContext().getSize(), this.ciContext);
    Object localObject2 = convertToImageCollection(paramAsynchronousVideoCompositionRequest, localRenderInfo, paramTAVVideoCompositionInstruction);
    paramAsynchronousVideoCompositionRequest = getVideoMixFilter(paramTAVVideoCompositionInstruction, paramTAVVideoCompositionInstruction.getVideoMixEffect());
    if (paramAsynchronousVideoCompositionRequest != null) {
      localObject1 = paramAsynchronousVideoCompositionRequest.apply(paramTAVVideoCompositionInstruction.getVideoMixEffect(), (ImageCollection)localObject2, localRenderInfo);
    } else {
      localObject1 = null;
    }
    paramAsynchronousVideoCompositionRequest = (AsynchronousVideoCompositionRequest)localObject1;
    if (localObject1 == null) {
      paramAsynchronousVideoCompositionRequest = this.defaultVideoMixFilter.apply(null, (ImageCollection)localObject2, localRenderInfo);
    }
    if (paramAsynchronousVideoCompositionRequest == null) {
      return null;
    }
    localObject2 = getGlobalFilter(paramTAVVideoCompositionInstruction.getGlobalVideoEffect(), localRenderInfo);
    Object localObject1 = paramAsynchronousVideoCompositionRequest;
    if (localObject2 != null) {
      localObject1 = ((TAVVideoEffect.Filter)localObject2).apply(paramTAVVideoCompositionInstruction.getGlobalVideoEffect(), paramAsynchronousVideoCompositionRequest, localRenderInfo);
    }
    return localObject1;
  }
  
  @Nullable
  private CIImage convertLayerToImage(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest, RenderInfo paramRenderInfo, TAVVideoCompositionLayerInstruction paramTAVVideoCompositionLayerInstruction, TAVVideoEffect paramTAVVideoEffect)
  {
    if (!paramTAVVideoCompositionLayerInstruction.getTimeRange().containsTime(paramRenderInfo.getTime())) {
      return null;
    }
    Object localObject2 = paramTAVVideoCompositionLayerInstruction.getImageSource().sourceImageAtTime(paramRenderInfo.getTime().sub(paramTAVVideoCompositionLayerInstruction.getTimeRange().getStart()), paramRenderInfo.getRenderSize());
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = getImageWithRequest(paramAsynchronousVideoCompositionRequest, paramTAVVideoCompositionLayerInstruction);
      paramAsynchronousVideoCompositionRequest = this.mTAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("convertLayerToImage: begin sourceImage by request, sourceImage = ");
      ((StringBuilder)localObject2).append(localObject1);
      Logger.v(paramAsynchronousVideoCompositionRequest, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 == null)
    {
      Logger.w(this.mTAG, "convertLayerToImage: begin sourceImage by request, sourceImage is null ");
      return null;
    }
    paramRenderInfo.addTrack(paramTAVVideoCompositionLayerInstruction.getImageSource());
    ((CIImage)localObject1).applyPreferRotation(paramTAVVideoCompositionLayerInstruction.getVideoConfiguration().getPreferRotation());
    applySourceTransform(paramTAVVideoCompositionLayerInstruction.getVideoConfiguration(), (CIImage)localObject1, paramRenderInfo);
    paramAsynchronousVideoCompositionRequest = applyCompositionSourceEffect(paramRenderInfo, applyClipSourceEffect(paramRenderInfo, (CIImage)localObject1, paramTAVVideoCompositionLayerInstruction.getVideoConfiguration().getEffects()), paramTAVVideoEffect);
    paramRenderInfo = this.mTAG;
    paramTAVVideoCompositionLayerInstruction = new StringBuilder();
    paramTAVVideoCompositionLayerInstruction.append("convertLayerToImage: end, returned: ");
    paramTAVVideoCompositionLayerInstruction.append(paramAsynchronousVideoCompositionRequest);
    Logger.v(paramRenderInfo, paramTAVVideoCompositionLayerInstruction.toString());
    return paramAsynchronousVideoCompositionRequest;
  }
  
  @NonNull
  private ImageCollection convertToImageCollection(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest, RenderInfo paramRenderInfo, TAVVideoCompositionInstruction paramTAVVideoCompositionInstruction)
  {
    ImageCollection localImageCollection = new ImageCollection();
    Iterator localIterator = paramTAVVideoCompositionInstruction.getChannelLayers().iterator();
    Object localObject1;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = ((List)localIterator.next()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TAVVideoCompositionLayerInstruction)((Iterator)localObject1).next();
        CIImage localCIImage = convertLayerToImage(paramAsynchronousVideoCompositionRequest, paramRenderInfo, (TAVVideoCompositionLayerInstruction)localObject2, paramTAVVideoCompositionInstruction.getSourceVideoEffect());
        if (localCIImage != null) {
          localImageCollection.addChannelImage(localCIImage, ((TAVVideoCompositionLayerInstruction)localObject2).getImageSource());
        }
      }
    }
    localIterator = paramTAVVideoCompositionInstruction.getOverlayLayers().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (TAVVideoCompositionLayerInstruction)localIterator.next();
      localObject2 = convertLayerToImage(paramAsynchronousVideoCompositionRequest, paramRenderInfo, (TAVVideoCompositionLayerInstruction)localObject1, paramTAVVideoCompositionInstruction.getSourceVideoEffect());
      if (localObject2 != null) {
        localImageCollection.addOverlayImage((CIImage)localObject2, ((TAVVideoCompositionLayerInstruction)localObject1).getImageSource());
      }
    }
    paramAsynchronousVideoCompositionRequest = this.mTAG;
    paramRenderInfo = new StringBuilder();
    paramRenderInfo.append("convertToImageCollection: result imageCollection = ");
    paramRenderInfo.append(localImageCollection);
    Logger.v(paramAsynchronousVideoCompositionRequest, paramRenderInfo.toString());
    return localImageCollection;
  }
  
  private TAVVideoEffect.Filter createFilter(TAVVideoEffect paramTAVVideoEffect, RenderInfo paramRenderInfo)
  {
    if ((paramTAVVideoEffect instanceof BaseVideoEffect)) {
      return ((BaseVideoEffect)paramTAVVideoEffect).createFilter(paramRenderInfo);
    }
    return paramTAVVideoEffect.createFilter();
  }
  
  @Nullable
  private TAVVideoEffect.Filter getGlobalFilter(TAVVideoEffect paramTAVVideoEffect, RenderInfo paramRenderInfo)
  {
    if ((paramTAVVideoEffect != null) && (!TextUtils.isEmpty(paramTAVVideoEffect.effectId())))
    {
      String str = paramTAVVideoEffect.effectId();
      if (this.globalFilterMap.containsKey(str)) {
        return (TAVVideoEffect.Filter)this.globalFilterMap.get(str);
      }
      paramTAVVideoEffect = createFilter(paramTAVVideoEffect, paramRenderInfo);
      this.globalFilterMap.put(str, paramTAVVideoEffect);
      return paramTAVVideoEffect;
    }
    return null;
  }
  
  @Nullable
  private CIImage getImageWithRequest(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest, TAVVideoCompositionLayerInstruction paramTAVVideoCompositionLayerInstruction)
  {
    paramAsynchronousVideoCompositionRequest = paramAsynchronousVideoCompositionRequest.sourceFrameByTrackID(paramTAVVideoCompositionLayerInstruction.getTrackID());
    if ((paramAsynchronousVideoCompositionRequest != null) && (paramAsynchronousVideoCompositionRequest.getTextureInfo() != null)) {
      return new CIImage(paramAsynchronousVideoCompositionRequest.getTextureInfo());
    }
    return null;
  }
  
  @Nullable
  private TAVVideoEffect.Filter getSourceFilter(TAVVideoEffect paramTAVVideoEffect, RenderInfo paramRenderInfo)
  {
    if ((paramTAVVideoEffect != null) && (!TextUtils.isEmpty(paramTAVVideoEffect.effectId())))
    {
      String str = paramTAVVideoEffect.effectId();
      if (this.sourceFilterMap.containsKey(str)) {
        return (TAVVideoEffect.Filter)this.sourceFilterMap.get(str);
      }
      paramTAVVideoEffect = createFilter(paramTAVVideoEffect, paramRenderInfo);
      this.sourceFilterMap.put(str, paramTAVVideoEffect);
      return paramTAVVideoEffect;
    }
    return null;
  }
  
  @Nullable
  private TAVVideoMixEffect.Filter getVideoMixFilter(TAVVideoCompositionInstruction paramTAVVideoCompositionInstruction, TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    if ((paramTAVVideoMixEffect != null) && (!TextUtils.isEmpty(paramTAVVideoMixEffect.effectId())))
    {
      paramTAVVideoMixEffect = paramTAVVideoMixEffect.effectId();
      if (this.mixFilterMap.containsKey(paramTAVVideoMixEffect)) {
        return (TAVVideoMixEffect.Filter)this.mixFilterMap.get(paramTAVVideoMixEffect);
      }
      paramTAVVideoCompositionInstruction = paramTAVVideoCompositionInstruction.getVideoMixEffect().createFilter();
      this.mixFilterMap.put(paramTAVVideoMixEffect, paramTAVVideoCompositionInstruction);
      return paramTAVVideoCompositionInstruction;
    }
    return null;
  }
  
  private void release(Releasable paramReleasable)
  {
    if (paramReleasable != null) {
      paramReleasable.release();
    }
  }
  
  private void release(Collection<? extends Releasable> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      release((Releasable)paramCollection.next());
    }
  }
  
  private void reportMemory()
  {
    if (MemoryReportHelper.isInIntervalTime()) {
      return;
    }
    String str1 = MemoryReportHelper.appendReportKey(this.sourceFilterMap.values());
    String str2 = MemoryReportHelper.appendReportKey(this.mixFilterMap.values());
    String str3 = MemoryReportHelper.appendReportKey(this.globalFilterMap.values());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sourceFilter:[");
    localStringBuilder.append(str1);
    localStringBuilder.append("], mixFilter:[");
    localStringBuilder.append(str2);
    localStringBuilder.append("], globalFilter:[");
    localStringBuilder.append(str3);
    localStringBuilder.append("]");
    str1 = localStringBuilder.toString();
    MemoryReportHelper.getInstance().tick(str1);
  }
  
  private void tryPostReleaseToRenderThread()
  {
    if (this.tryPostReleaseDone) {
      return;
    }
    this.tryPostReleaseDone = true;
    Thread localThread = this.renderThread;
    if ((localThread instanceof HandlerThread)) {
      new Handler(((HandlerThread)localThread).getLooper()).post(new TAVVideoCompositing.1(this));
    }
  }
  
  public void cancelAllPendingVideoCompositionRequests() {}
  
  public void release()
  {
    if ((this.renderThread != null) && (!Thread.currentThread().equals(this.renderThread)))
    {
      localObject = this.mTAG;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("release: 当前线程非渲染线程！currentThread = ");
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append(", renderThread = ");
      localStringBuilder.append(this.renderThread.getName());
      Logger.e((String)localObject, localStringBuilder.toString());
      tryPostReleaseToRenderThread();
      return;
    }
    this.tryPostReleaseDone = false;
    Object localObject = this.mTAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("release: begin, currentThread = ");
    localStringBuilder.append(Thread.currentThread().getName());
    Logger.d((String)localObject, localStringBuilder.toString());
    release(this.ciContext);
    release(this.transitionFilterMap.values());
    release(this.sourceFilterMap.values());
    release(this.mixFilterMap.values());
    release(this.globalFilterMap.values());
    this.transitionFilterMap.clear();
    this.sourceFilterMap.clear();
    this.mixFilterMap.clear();
    this.globalFilterMap.clear();
    release(ThreadLocalTextureCache.getInstance());
    localObject = this.reportSession;
    if (localObject != null)
    {
      ((CompositingReportSession)localObject).flush();
      this.reportSession = null;
    }
    localObject = this.mTAG;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("release: end, currentThread = ");
    localStringBuilder.append(Thread.currentThread().getName());
    Logger.d((String)localObject, localStringBuilder.toString());
  }
  
  public void renderContextChanged(VideoCompositionRenderContext paramVideoCompositionRenderContext) {}
  
  public HashMap<String, Object> requiredPixelBufferAttributesForRenderContext()
  {
    return null;
  }
  
  public HashMap<String, Object> sourcePixelBufferAttributes()
  {
    return null;
  }
  
  public void startVideoCompositionRequest(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest)
  {
    if (this.reportSession == null)
    {
      localObject1 = paramAsynchronousVideoCompositionRequest.getRenderContext().getSize();
      this.reportSession = new CompositingReportSession(((CGSize)localObject1).width, ((CGSize)localObject1).height);
    }
    long l = System.nanoTime();
    Object localObject1 = this.mTAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("startVideoCompositionRequest: begin, currentThread = ");
    ((StringBuilder)localObject2).append(Thread.currentThread().getName());
    ((StringBuilder)localObject2).append(", request = [");
    ((StringBuilder)localObject2).append(paramAsynchronousVideoCompositionRequest);
    ((StringBuilder)localObject2).append("]");
    Logger.v((String)localObject1, ((StringBuilder)localObject2).toString());
    if (this.ciContext == null) {
      this.ciContext = new CIContext(paramAsynchronousVideoCompositionRequest.getRenderContext().getRenderContext());
    }
    if (this.renderThread == null) {
      this.renderThread = Thread.currentThread();
    }
    localObject1 = paramAsynchronousVideoCompositionRequest.getVideoCompositionInstruction();
    if (!(localObject1 instanceof TAVVideoCompositionInstruction))
    {
      localObject1 = this.mTAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startVideoCompositionRequest: end, ");
      ((StringBuilder)localObject2).append("instruction not instanceof TAVVideoCompositionInstruction");
      Logger.e((String)localObject1, ((StringBuilder)localObject2).toString());
      this.reportSession.tickFailed();
      paramAsynchronousVideoCompositionRequest.finishWithError(new ErrorMsg(10086, "instruction not instanceof TAVVideoCompositionInstruction"));
      return;
    }
    BenchUtil.benchStart("compositingImages");
    localObject1 = compositingImages(paramAsynchronousVideoCompositionRequest, (TAVVideoCompositionInstruction)localObject1);
    BenchUtil.benchEnd("compositingImages");
    BenchUtil.benchStart("renderToSampleBuffer");
    reportMemory();
    if (localObject1 != null)
    {
      localObject1 = this.ciContext.convertToSampleBuffer((CIImage)localObject1, paramAsynchronousVideoCompositionRequest.getCompositionTime(), paramAsynchronousVideoCompositionRequest.getRenderContext().getRenderContext());
      localObject2 = this.mTAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startVideoCompositionRequest: end, resultPixels = [");
      localStringBuilder.append(localObject1);
      localStringBuilder.append("]");
      Logger.v((String)localObject2, localStringBuilder.toString());
      this.reportSession.tickSuccess(System.nanoTime() - l);
      paramAsynchronousVideoCompositionRequest.finishWithComposedVideoFrame((CMSampleBuffer)localObject1);
    }
    else
    {
      localObject1 = this.mTAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startVideoCompositionRequest: end, ");
      ((StringBuilder)localObject2).append("destImage is null ");
      Logger.e((String)localObject1, ((StringBuilder)localObject2).toString());
      this.reportSession.tickFailed();
      paramAsynchronousVideoCompositionRequest.finishWithError(new ErrorMsg(10086, "destImage is null "));
    }
    BenchUtil.benchEnd("renderToSampleBuffer");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.TAVVideoCompositing
 * JD-Core Version:    0.7.0.1
 */