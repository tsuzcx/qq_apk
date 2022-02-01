package com.tencent.weseevideo.composition.effectnode;

import android.graphics.PointF;
import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.autotemplate.filter.GaosiBlurFilter;
import com.tencent.autotemplate.filter.ScaleTextureFilter;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.tavkit.report.IReportable;
import com.tencent.tavkit.report.MemoryReportHelper;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerTexture;
import com.tencent.weseevideo.editor.sticker.IBlurStickerRenderContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class WSOverlayStickerMergedEffectNode$WsVideoCompositionEffect
  implements TAVVideoEffect.Filter, IReportable
{
  long applyEffectStartTime;
  @Nullable
  private TAVStickerRenderContext cloneStickerContext;
  private CMTime currentTime = CMTime.CMTimeZero;
  private GaosiBlurFilter horizontalBlurFilter = new GaosiBlurFilter(true, 20);
  private ScaleTextureFilter scaleBigTextureFilter = new ScaleTextureFilter();
  private ScaleTextureFilter scaleSmallTextureFilter = new ScaleTextureFilter();
  @Nullable
  private TAVStickerRenderContext stickerContext;
  private HashMap<String, TextureInfo> textureMap = new HashMap();
  private GaosiBlurFilter verticalBlurFilter = new GaosiBlurFilter(false, 20);
  
  private WSOverlayStickerMergedEffectNode$WsVideoCompositionEffect(WSOverlayStickerMergedEffectNode paramWSOverlayStickerMergedEffectNode, @NotNull TAVStickerRenderContext paramTAVStickerRenderContext)
  {
    this.stickerContext = paramTAVStickerRenderContext;
  }
  
  private CIImage applyEffectHard(@NonNull TAVStickerRenderContext paramTAVStickerRenderContext, CIImage paramCIImage, CMTime paramCMTime, CIContext paramCIContext)
  {
    if ((WSOverlayStickerMergedEffectNode.access$300(this.this$0) == null) || (WSOverlayStickerMergedEffectNode.access$400(this.this$0).isEmpty())) {
      return paramCIImage;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = WSOverlayStickerMergedEffectNode.access$500(this.this$0).iterator();
    TAVSticker localTAVSticker;
    while (localIterator.hasNext())
    {
      localTAVSticker = (TAVSticker)localIterator.next();
      if (localTAVSticker.getTimeRange().containsTime(paramCMTime)) {
        localArrayList.add(localTAVSticker);
      }
    }
    if (localArrayList.isEmpty()) {
      releaseCloneRenderContext();
    }
    if ((WSOverlayStickerMergedEffectNode.access$600(this.this$0)) && (this.cloneStickerContext != null) && (localArrayList.size() < this.cloneStickerContext.getStickerCount())) {
      releaseCloneRenderContext();
    }
    localIterator = localArrayList.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localTAVSticker = (TAVSticker)localIterator.next();
    } while ((this.cloneStickerContext == null) || (this.cloneStickerContext.containSticker(localTAVSticker)));
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (WSOverlayStickerMergedEffectNode.access$700(this.this$0))) {
        releaseCloneRenderContext();
      }
      renderByCloneContext(paramTAVStickerRenderContext, localArrayList, paramCIImage, paramCMTime, paramCIContext);
      return paramCIImage;
    }
  }
  
  private CIImage applyWithBlurStickerRenderContext(TAVStickerRenderContext paramTAVStickerRenderContext, TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    this.applyEffectStartTime = System.currentTimeMillis();
    paramTAVVideoEffect = paramRenderInfo.getCiContext();
    if (paramTAVStickerRenderContext == null) {}
    CMSampleBuffer localCMSampleBuffer;
    do
    {
      do
      {
        return paramCIImage;
        this.currentTime = paramRenderInfo.getTime();
        if (WSOverlayStickerMergedEffectNode.access$200(this.this$0)) {
          return applyEffectHard(paramTAVStickerRenderContext, paramCIImage, paramRenderInfo.getTime(), paramTAVVideoEffect);
        }
        this.stickerContext.setRenderSize(paramCIImage.getSize());
        localCMSampleBuffer = this.stickerContext.renderSticker(paramRenderInfo.getTime().getTimeUs() / 1000L, null, paramTAVVideoEffect.getRenderContext().eglContext());
        paramTAVVideoEffect.getRenderContext().makeCurrent();
        WSOverLayBlurManager.getInstance().updateSourceCIImage(paramCIImage, paramRenderInfo);
      } while (noStickerRender(paramRenderInfo.getTime(), paramTAVStickerRenderContext.getStickers()));
      this.applyEffectStartTime = System.currentTimeMillis();
    } while (localCMSampleBuffer == null);
    if (localCMSampleBuffer.isNewFrame()) {
      this.stickerContext.getStickerTexture().awaitNewImage(1000L);
    }
    paramTAVVideoEffect = localCMSampleBuffer.getTextureInfo();
    paramTAVVideoEffect.setMixAlpha(false);
    paramTAVVideoEffect = new CIImage(paramTAVVideoEffect);
    if (((IBlurStickerRenderContext)paramTAVStickerRenderContext).shouldRenderBlurSticker())
    {
      insertBlurCIImage(paramCIImage, paramRenderInfo, paramTAVVideoEffect);
      return paramCIImage;
    }
    paramTAVVideoEffect.imageByCompositingOverImage(paramCIImage);
    Log.d("blur_cost", String.format("------------------无马赛克渲染总耗时：%d%s", new Object[] { Long.valueOf(System.currentTimeMillis() - this.applyEffectStartTime), "------------------" }));
    return paramCIImage;
  }
  
  private CIImage applyWithTAVStickerRenderContext(TAVStickerRenderContext paramTAVStickerRenderContext, TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    paramTAVVideoEffect = paramRenderInfo.getCiContext();
    if (paramTAVStickerRenderContext == null) {}
    CMSampleBuffer localCMSampleBuffer;
    do
    {
      return paramCIImage;
      this.currentTime = paramRenderInfo.getTime();
      if (WSOverlayStickerMergedEffectNode.access$100(this.this$0)) {
        return applyEffectHard(paramTAVStickerRenderContext, paramCIImage, paramRenderInfo.getTime(), paramTAVVideoEffect);
      }
      this.stickerContext.setRenderSize(paramCIImage.getSize());
      localCMSampleBuffer = this.stickerContext.renderSticker(paramRenderInfo.getTime().getTimeUs() / 1000L, null, paramTAVVideoEffect.getRenderContext().eglContext());
      paramTAVVideoEffect.getRenderContext().makeCurrent();
    } while ((noStickerRender(paramRenderInfo.getTime(), paramTAVStickerRenderContext.getStickers())) || (localCMSampleBuffer == null));
    if (localCMSampleBuffer.isNewFrame()) {
      this.stickerContext.getStickerTexture().awaitNewImage(1000L);
    }
    paramTAVStickerRenderContext = localCMSampleBuffer.getTextureInfo();
    paramTAVStickerRenderContext.setMixAlpha(false);
    new CIImage(paramTAVStickerRenderContext).imageByCompositingOverImage(paramCIImage);
    return paramCIImage;
  }
  
  private TextureInfo extractTextureInfoFromCIImage(CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    return paramRenderInfo.getCiContext().convertImageToTexture(paramCIImage, getCacheTextureInfo((int)paramCIImage.getSize().width, (int)paramCIImage.getSize().height));
  }
  
  private TextureInfo getCacheTextureInfo(int paramInt1, int paramInt2)
  {
    String str = paramInt1 + "_" + paramInt2;
    TextureInfo localTextureInfo1 = null;
    if (this.textureMap.containsKey(str)) {
      localTextureInfo1 = (TextureInfo)this.textureMap.get(str);
    }
    TextureInfo localTextureInfo2 = localTextureInfo1;
    if (localTextureInfo1 == null)
    {
      localTextureInfo2 = CIContext.newTextureInfo(paramInt1, paramInt2);
      this.textureMap.put(str, localTextureInfo2);
    }
    return localTextureInfo2;
  }
  
  private void insertBlurCIImage(CIImage paramCIImage1, RenderInfo paramRenderInfo, CIImage paramCIImage2)
  {
    Object localObject2 = ((IBlurStickerRenderContext)this.stickerContext).getBlurStickers();
    Object localObject1 = extractTextureInfoFromCIImage(paramCIImage1, paramRenderInfo);
    int i = ((TextureInfo)localObject1).preferRotation;
    localObject1 = new CIImage(WSOverLayBlurManager.getInstance().getBlurredTextureInfo((TextureInfo)localObject1, paramRenderInfo, i, 10, 0.25F, this.horizontalBlurFilter, this.verticalBlurFilter, this.scaleSmallTextureFilter, this.scaleBigTextureFilter));
    ((CIImage)localObject1).applyPreferRotation(0);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (TAVSticker)((Iterator)localObject2).next();
      if (((TAVSticker)localObject3).getMode() == TAVStickerMode.INACTIVE)
      {
        CIImage localCIImage = new CIImage(((CIImage)localObject1).getDrawTextureInfo().clone());
        localCIImage.applyPreferRotation(0);
        localCIImage.applyFillInFrame(new CGRect(new PointF(0.0F, 0.0F), paramRenderInfo.getRenderSize()), TAVVideoConfiguration.TAVVideoConfigurationContentMode.aspectFill);
        localObject3 = WSOverLayBlurManager.getBlurRect(i, (TAVSticker)localObject3, localCIImage, paramRenderInfo);
        if (localCIImage.getDrawTextureInfo() != null)
        {
          float f1 = Math.min(localCIImage.getDrawTextureInfo().height, ((CGRect)localObject3).size.height);
          float f2 = Math.min(localCIImage.getDrawTextureInfo().width, ((CGRect)localObject3).size.width);
          ((CGRect)localObject3).origin.x = (((CGRect)localObject3).origin.x + ((CGRect)localObject3).size.width / 2.0F - f2 / 2.0F);
          ((CGRect)localObject3).origin.y = (((CGRect)localObject3).origin.y + ((CGRect)localObject3).size.height / 2.0F - f1 / 2.0F);
          ((CGRect)localObject3).size.width = f2;
          ((CGRect)localObject3).size.height = f1;
        }
        localCIImage.setFrame((CGRect)localObject3);
        localCIImage.imageByCompositingOverImage((CIImage)localObject1);
      }
    }
    if (isRenderNormalSticker()) {
      paramCIImage2.imageByCompositingOverImage((CIImage)localObject1);
    }
    ((CIImage)localObject1).imageByCompositingOverImage(paramCIImage1);
    ((CIImage)localObject1).clearSelfTexture();
  }
  
  private boolean isRenderNormalSticker()
  {
    if (this.stickerContext.getStickers().size() > ((IBlurStickerRenderContext)this.stickerContext).getBlurStickers().size())
    {
      Iterator localIterator = this.stickerContext.getStickers().iterator();
      while (localIterator.hasNext())
      {
        TAVSticker localTAVSticker = (TAVSticker)localIterator.next();
        if ((!((IBlurStickerRenderContext)this.stickerContext).getBlurStickers().contains(localTAVSticker)) && (localTAVSticker.getMode() == TAVStickerMode.INACTIVE)) {
          return true;
        }
      }
    }
    return false;
  }
  
  private boolean noStickerRender(CMTime paramCMTime, List<TAVSticker> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TAVSticker localTAVSticker = (TAVSticker)paramList.next();
      CMTimeRange localCMTimeRange = localTAVSticker.getTimeRange();
      if (((localCMTimeRange == null) || (localCMTimeRange.containsTime(paramCMTime))) && (localTAVSticker.getMode() == TAVStickerMode.INACTIVE)) {
        return false;
      }
    }
    return true;
  }
  
  private void releaseCloneRenderContext()
  {
    if (this.cloneStickerContext != null)
    {
      this.cloneStickerContext.release();
      this.cloneStickerContext.removeAllStickers();
      this.cloneStickerContext = null;
    }
  }
  
  private void renderByCloneContext(@NonNull TAVStickerRenderContext paramTAVStickerRenderContext, List<TAVSticker> paramList, CIImage paramCIImage, CMTime paramCMTime, CIContext paramCIContext)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      do
      {
        return;
        if (this.cloneStickerContext == null) {
          this.cloneStickerContext = paramTAVStickerRenderContext.copy();
        }
      } while (this.cloneStickerContext == null);
      paramTAVStickerRenderContext = paramList.iterator();
      while (paramTAVStickerRenderContext.hasNext())
      {
        paramList = (TAVSticker)paramTAVStickerRenderContext.next();
        if (!this.cloneStickerContext.containSticker(paramList)) {
          this.cloneStickerContext.loadSticker(paramList);
        }
      }
      this.cloneStickerContext.setRenderSize(paramCIImage.getSize());
      paramTAVStickerRenderContext = this.cloneStickerContext.renderSticker(paramCMTime.getTimeUs() / 1000L, null, paramCIContext.getRenderContext().eglContext());
      paramCIContext.getRenderContext().makeCurrent();
    } while (paramTAVStickerRenderContext == null);
    if (paramTAVStickerRenderContext.isNewFrame()) {
      this.cloneStickerContext.getStickerTexture().awaitNewImage(1000L);
    }
    new CIImage(paramTAVStickerRenderContext.getTextureInfo()).imageByCompositingOverImage(paramCIImage);
  }
  
  public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    if ((this.stickerContext instanceof IBlurStickerRenderContext)) {
      return applyWithBlurStickerRenderContext(this.stickerContext, paramTAVVideoEffect, paramCIImage, paramRenderInfo);
    }
    return applyWithTAVStickerRenderContext(this.stickerContext, paramTAVVideoEffect, paramCIImage, paramRenderInfo);
  }
  
  public String getReportKey()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.stickerContext != null) {
      synchronized (this.stickerContext.getStickers())
      {
        Iterator localIterator = this.stickerContext.getStickers().iterator();
        while (localIterator.hasNext())
        {
          TAVSticker localTAVSticker = (TAVSticker)localIterator.next();
          if ((localTAVSticker != null) && ((localTAVSticker.getTimeRange() == null) || (localTAVSticker.getTimeRange().containsTime(this.currentTime)))) {
            localArrayList.add(localTAVSticker.getStickerId());
          }
        }
      }
    }
    if (!localCollection.isEmpty()) {
      return WSOverlayStickerMergedEffectNode.access$800(this.this$0) + ":[" + MemoryReportHelper.appendKeys(localCollection) + "]";
    }
    return null;
  }
  
  public void release()
  {
    releaseCloneRenderContext();
    if ((this.stickerContext != null) && (this.this$0.getStickerContext() != this.stickerContext))
    {
      this.stickerContext.release();
      this.stickerContext = null;
    }
    if (this.verticalBlurFilter != null)
    {
      this.verticalBlurFilter.release();
      this.verticalBlurFilter = null;
    }
    if (this.horizontalBlurFilter != null)
    {
      this.horizontalBlurFilter.release();
      this.horizontalBlurFilter = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weseevideo.composition.effectnode.WSOverlayStickerMergedEffectNode.WsVideoCompositionEffect
 * JD-Core Version:    0.7.0.1
 */