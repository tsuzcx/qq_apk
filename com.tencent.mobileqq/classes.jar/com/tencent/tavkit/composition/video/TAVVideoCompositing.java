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
  public static boolean LOG_VERBOSE = false;
  private final String TAG = "TAVVideoCompositing@" + Integer.toHexString(hashCode());
  @Nullable
  private CIContext ciContext;
  @NonNull
  private final TAVVideoMixEffect.Filter defaultVideoMixFilter = new DefaultVideoMixFilter();
  @NonNull
  private final HashMap<String, TAVVideoEffect.Filter> globalFilterMap = new HashMap();
  @NonNull
  private final HashMap<String, TAVVideoMixEffect.Filter> mixFilterMap = new HashMap();
  @Nullable
  private Thread renderThread;
  @Nullable
  private CompositingReportSession reportSession;
  @NonNull
  private final HashMap<String, TAVVideoEffect.Filter> sourceFilterMap = new HashMap();
  @NonNull
  private final HashMap<String, TAVVideoTransition.Filter> transitionFilterMap = new HashMap();
  private boolean tryPostReleaseDone = false;
  
  private CIImage applyClipSourceEffect(RenderInfo paramRenderInfo, @NonNull CIImage paramCIImage, List<TAVVideoEffect> paramList)
  {
    Object localObject = paramCIImage;
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        localObject = paramCIImage;
      }
    }
    else {
      return localObject;
    }
    paramList = paramList.iterator();
    for (;;)
    {
      localObject = paramCIImage;
      if (!paramList.hasNext()) {
        break;
      }
      localObject = (TAVVideoEffect)paramList.next();
      TAVVideoEffect.Filter localFilter = getSourceFilter((TAVVideoEffect)localObject);
      if (localFilter != null) {
        paramCIImage = localFilter.apply((TAVVideoEffect)localObject, paramCIImage, paramRenderInfo);
      }
    }
  }
  
  private CIImage applyCompositionSourceEffect(RenderInfo paramRenderInfo, CIImage paramCIImage, TAVVideoEffect paramTAVVideoEffect)
  {
    TAVVideoEffect.Filter localFilter = getSourceFilter(paramTAVVideoEffect);
    if (localFilter == null) {
      return paramCIImage;
    }
    return localFilter.apply(paramTAVVideoEffect, paramCIImage, paramRenderInfo);
  }
  
  private void applySourceTransform(TAVVideoConfiguration paramTAVVideoConfiguration, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    if (LOG_VERBOSE) {
      Logger.v(this.TAG, "applySourceTransform() called with: config = [" + paramTAVVideoConfiguration + "]");
    }
    if (paramTAVVideoConfiguration.frameEnable()) {
      paramCIImage.applyFillInFrame(paramTAVVideoConfiguration.getFrame(), paramTAVVideoConfiguration.getContentMode());
    }
    for (;;)
    {
      paramCIImage.safeApplyTransform(paramTAVVideoConfiguration.getTransform());
      return;
      if (paramTAVVideoConfiguration.getFrame() == TAVVideoConfiguration.FIX_RENDER_SIZE) {
        paramCIImage.applyFixInSize(paramRenderInfo.getRenderSize(), paramTAVVideoConfiguration.getContentMode());
      }
    }
  }
  
  private CIImage compositingImages(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest, TAVVideoCompositionInstruction paramTAVVideoCompositionInstruction)
  {
    if (this.ciContext == null)
    {
      localObject1 = null;
      return localObject1;
    }
    Object localObject1 = this.sourceFilterMap.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TAVVideoEffect.Filter)((Iterator)localObject1).next();
      if ((localObject2 instanceof TAVAttachTimeRangeSourceEffect.TimeAttachFilter)) {
        ((TAVAttachTimeRangeSourceEffect.TimeAttachFilter)localObject2).attachPositionTime(paramAsynchronousVideoCompositionRequest.getCompositionTime());
      }
    }
    Object localObject2 = new RenderInfo(paramAsynchronousVideoCompositionRequest.getCompositionTime(), paramAsynchronousVideoCompositionRequest.getRenderContext().getSize(), this.ciContext);
    Object localObject3 = convertToImageCollection(paramAsynchronousVideoCompositionRequest, (RenderInfo)localObject2, paramTAVVideoCompositionInstruction);
    paramAsynchronousVideoCompositionRequest = getVideoMixFilter(paramTAVVideoCompositionInstruction, paramTAVVideoCompositionInstruction.getVideoMixEffect());
    if (paramAsynchronousVideoCompositionRequest != null) {}
    for (localObject1 = paramAsynchronousVideoCompositionRequest.apply(paramTAVVideoCompositionInstruction.getVideoMixEffect(), (ImageCollection)localObject3, (RenderInfo)localObject2);; localObject1 = null)
    {
      paramAsynchronousVideoCompositionRequest = (AsynchronousVideoCompositionRequest)localObject1;
      if (localObject1 == null) {
        paramAsynchronousVideoCompositionRequest = this.defaultVideoMixFilter.apply(null, (ImageCollection)localObject3, (RenderInfo)localObject2);
      }
      localObject3 = getGlobalFilter(paramTAVVideoCompositionInstruction.getGlobalVideoEffect());
      localObject1 = paramAsynchronousVideoCompositionRequest;
      if (localObject3 == null) {
        break;
      }
      return ((TAVVideoEffect.Filter)localObject3).apply(paramTAVVideoCompositionInstruction.getGlobalVideoEffect(), paramAsynchronousVideoCompositionRequest, (RenderInfo)localObject2);
    }
  }
  
  @Nullable
  private CIImage convertLayerToImage(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest, RenderInfo paramRenderInfo, TAVVideoCompositionLayerInstruction paramTAVVideoCompositionLayerInstruction, TAVVideoEffect paramTAVVideoEffect)
  {
    Object localObject = null;
    if (!paramTAVVideoCompositionLayerInstruction.getTimeRange().containsTime(paramRenderInfo.getTime())) {
      paramAsynchronousVideoCompositionRequest = (AsynchronousVideoCompositionRequest)localObject;
    }
    do
    {
      return paramAsynchronousVideoCompositionRequest;
      CIImage localCIImage = paramTAVVideoCompositionLayerInstruction.getImageSource().sourceImageAtTime(paramRenderInfo.getTime().sub(paramTAVVideoCompositionLayerInstruction.getTimeRange().getStart()), paramRenderInfo.getRenderSize());
      localObject = localCIImage;
      if (localCIImage == null)
      {
        paramAsynchronousVideoCompositionRequest = getImageWithRequest(paramAsynchronousVideoCompositionRequest, paramTAVVideoCompositionLayerInstruction);
        localObject = paramAsynchronousVideoCompositionRequest;
        if (LOG_VERBOSE)
        {
          Logger.v(this.TAG, "convertLayerToImage: begin sourceImage by request, sourceImage = " + paramAsynchronousVideoCompositionRequest);
          localObject = paramAsynchronousVideoCompositionRequest;
        }
      }
      if (localObject == null)
      {
        Logger.w(this.TAG, "convertLayerToImage: begin sourceImage by request, sourceImage is null ");
        return null;
      }
      ((CIImage)localObject).applyPreferRotation(paramTAVVideoCompositionLayerInstruction.getVideoConfiguration().getPreferRotation());
      applySourceTransform(paramTAVVideoCompositionLayerInstruction.getVideoConfiguration(), (CIImage)localObject, paramRenderInfo);
      paramRenderInfo = applyCompositionSourceEffect(paramRenderInfo, applyClipSourceEffect(paramRenderInfo, (CIImage)localObject, paramTAVVideoCompositionLayerInstruction.getVideoConfiguration().getEffects()), paramTAVVideoEffect);
      paramAsynchronousVideoCompositionRequest = paramRenderInfo;
    } while (!LOG_VERBOSE);
    Logger.v(this.TAG, "convertLayerToImage: end, returned: " + paramRenderInfo);
    return paramRenderInfo;
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
        if ((localCIImage != null) && (!localCIImage.isCanvasImage())) {
          localImageCollection.addChannelImage(localCIImage, ((TAVVideoCompositionLayerInstruction)localObject2).getImageSource());
        }
      }
    }
    localIterator = paramTAVVideoCompositionInstruction.getOverlayLayers().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (TAVVideoCompositionLayerInstruction)localIterator.next();
      localObject2 = convertLayerToImage(paramAsynchronousVideoCompositionRequest, paramRenderInfo, (TAVVideoCompositionLayerInstruction)localObject1, paramTAVVideoCompositionInstruction.getSourceVideoEffect());
      if ((localObject2 != null) && (!((CIImage)localObject2).isCanvasImage())) {
        localImageCollection.addOverlayImage((CIImage)localObject2, ((TAVVideoCompositionLayerInstruction)localObject1).getImageSource());
      }
    }
    if (LOG_VERBOSE) {
      Logger.d(this.TAG, "convertToImageCollection: result imageCollection = " + localImageCollection);
    }
    return localImageCollection;
  }
  
  @Nullable
  private TAVVideoEffect.Filter getGlobalFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    if ((paramTAVVideoEffect == null) || (TextUtils.isEmpty(paramTAVVideoEffect.effectId()))) {
      return null;
    }
    String str = paramTAVVideoEffect.effectId();
    if (this.globalFilterMap.containsKey(str)) {
      return (TAVVideoEffect.Filter)this.globalFilterMap.get(str);
    }
    paramTAVVideoEffect = paramTAVVideoEffect.createFilter();
    this.globalFilterMap.put(str, paramTAVVideoEffect);
    return paramTAVVideoEffect;
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
  private TAVVideoEffect.Filter getSourceFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    if ((paramTAVVideoEffect == null) || (TextUtils.isEmpty(paramTAVVideoEffect.effectId()))) {
      return null;
    }
    String str = paramTAVVideoEffect.effectId();
    if (this.sourceFilterMap.containsKey(str)) {
      return (TAVVideoEffect.Filter)this.sourceFilterMap.get(str);
    }
    paramTAVVideoEffect = paramTAVVideoEffect.createFilter();
    this.sourceFilterMap.put(str, paramTAVVideoEffect);
    return paramTAVVideoEffect;
  }
  
  @Nullable
  private TAVVideoMixEffect.Filter getVideoMixFilter(TAVVideoCompositionInstruction paramTAVVideoCompositionInstruction, TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    if ((paramTAVVideoMixEffect == null) || (TextUtils.isEmpty(paramTAVVideoMixEffect.effectId()))) {
      return null;
    }
    paramTAVVideoMixEffect = paramTAVVideoMixEffect.effectId();
    if (this.mixFilterMap.containsKey(paramTAVVideoMixEffect)) {
      return (TAVVideoMixEffect.Filter)this.mixFilterMap.get(paramTAVVideoMixEffect);
    }
    paramTAVVideoCompositionInstruction = paramTAVVideoCompositionInstruction.getVideoMixEffect().createFilter();
    this.mixFilterMap.put(paramTAVVideoMixEffect, paramTAVVideoCompositionInstruction);
    return paramTAVVideoCompositionInstruction;
  }
  
  private void reportMemory()
  {
    if (MemoryReportHelper.isInIntervalTime()) {
      return;
    }
    String str1 = MemoryReportHelper.appendReportKey(this.sourceFilterMap.values());
    String str2 = MemoryReportHelper.appendReportKey(this.mixFilterMap.values());
    String str3 = MemoryReportHelper.appendReportKey(this.globalFilterMap.values());
    str1 = "sourceFilter:[" + str1 + "], mixFilter:[" + str2 + "], globalFilter:[" + str3 + "]";
    MemoryReportHelper.getInstance().tick(str1);
  }
  
  private void tryPostReleaseToRenderThread()
  {
    if (this.tryPostReleaseDone) {}
    do
    {
      return;
      this.tryPostReleaseDone = true;
    } while (!(this.renderThread instanceof HandlerThread));
    new Handler(((HandlerThread)this.renderThread).getLooper()).post(new TAVVideoCompositing.1(this));
  }
  
  public void cancelAllPendingVideoCompositionRequests() {}
  
  public void release()
  {
    if ((this.renderThread != null) && (!Thread.currentThread().equals(this.renderThread)))
    {
      Logger.e(this.TAG, "release: 当前线程非渲染线程！currentThread = " + Thread.currentThread().getName() + ", renderThread = " + this.renderThread.getName());
      tryPostReleaseToRenderThread();
      return;
    }
    this.tryPostReleaseDone = false;
    Logger.d(this.TAG, "release: begin, currentThread = " + Thread.currentThread().getName());
    if (this.ciContext != null) {
      this.ciContext.release();
    }
    Iterator localIterator = this.transitionFilterMap.values().iterator();
    while (localIterator.hasNext()) {
      ((TAVVideoTransition.Filter)localIterator.next()).release();
    }
    localIterator = this.sourceFilterMap.values().iterator();
    while (localIterator.hasNext()) {
      ((TAVVideoEffect.Filter)localIterator.next()).release();
    }
    localIterator = this.mixFilterMap.values().iterator();
    while (localIterator.hasNext()) {
      ((TAVVideoMixEffect.Filter)localIterator.next()).release();
    }
    localIterator = this.globalFilterMap.values().iterator();
    while (localIterator.hasNext()) {
      ((TAVVideoEffect.Filter)localIterator.next()).release();
    }
    this.transitionFilterMap.clear();
    this.sourceFilterMap.clear();
    this.mixFilterMap.clear();
    this.globalFilterMap.clear();
    ThreadLocalTextureCache.getInstance().release();
    if (this.reportSession != null)
    {
      this.reportSession.flush();
      this.reportSession = null;
    }
    Logger.d(this.TAG, "release: end, currentThread = " + Thread.currentThread().getName());
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
    if (this.reportSession == null) {
      this.reportSession = new CompositingReportSession(paramAsynchronousVideoCompositionRequest.getRenderContext().getSize().width, paramAsynchronousVideoCompositionRequest.getRenderContext().getSize().height);
    }
    long l = System.nanoTime();
    if (LOG_VERBOSE) {
      Logger.d(this.TAG, "startVideoCompositionRequest: begin, currentThread = " + Thread.currentThread().getName() + ", request = [" + paramAsynchronousVideoCompositionRequest + "]");
    }
    if (this.ciContext == null) {
      this.ciContext = new CIContext(paramAsynchronousVideoCompositionRequest.getRenderContext().getRenderContext());
    }
    if (this.renderThread == null) {
      this.renderThread = Thread.currentThread();
    }
    Object localObject = paramAsynchronousVideoCompositionRequest.getVideoCompositionInstruction();
    if (!(localObject instanceof TAVVideoCompositionInstruction))
    {
      Logger.e(this.TAG, "startVideoCompositionRequest: end, " + "instruction not instanceof TAVVideoCompositionInstruction");
      this.reportSession.tickFailed();
      paramAsynchronousVideoCompositionRequest.finishWithError(new ErrorMsg(10086, "instruction not instanceof TAVVideoCompositionInstruction"));
      return;
    }
    BenchUtil.benchStart("compositingImages");
    localObject = compositingImages(paramAsynchronousVideoCompositionRequest, (TAVVideoCompositionInstruction)localObject);
    BenchUtil.benchEnd("compositingImages");
    BenchUtil.benchStart("renderToSampleBuffer");
    reportMemory();
    if (localObject != null)
    {
      localObject = this.ciContext.renderToSampleBuffer((CIImage)localObject, paramAsynchronousVideoCompositionRequest.getCompositionTime(), paramAsynchronousVideoCompositionRequest.getRenderContext().getRenderContext());
      if (LOG_VERBOSE) {
        Logger.d(this.TAG, "startVideoCompositionRequest: end, resultPixels = [" + localObject + "]");
      }
      this.reportSession.tickSuccess(System.nanoTime() - l);
      paramAsynchronousVideoCompositionRequest.finishWithComposedVideoFrame((CMSampleBuffer)localObject);
    }
    for (;;)
    {
      BenchUtil.benchEnd("renderToSampleBuffer");
      return;
      Logger.e(this.TAG, "startVideoCompositionRequest: end, " + "destImage is null ");
      this.reportSession.tickFailed();
      paramAsynchronousVideoCompositionRequest.finishWithError(new ErrorMsg(10086, "destImage is null "));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.TAVVideoCompositing
 * JD-Core Version:    0.7.0.1
 */