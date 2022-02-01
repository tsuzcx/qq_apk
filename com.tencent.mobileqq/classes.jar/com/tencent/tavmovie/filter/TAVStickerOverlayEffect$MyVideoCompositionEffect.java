package com.tencent.tavmovie.filter;

import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoEffect;
import com.tencent.tavkit.composition.video.TAVVideoEffect.Filter;
import com.tencent.tavkit.report.IReportable;
import com.tencent.tavkit.report.MemoryReportHelper;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import com.tencent.tavsticker.model.TAVStickerTexture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class TAVStickerOverlayEffect$MyVideoCompositionEffect
  implements TAVVideoEffect.Filter, IReportable
{
  @Nullable
  private TAVStickerRenderContext cloneStickerContext;
  private CMTime currentTime = CMTime.CMTimeZero;
  @Nullable
  private TAVStickerRenderContext stickerContext;
  
  private TAVStickerOverlayEffect$MyVideoCompositionEffect(TAVStickerOverlayEffect paramTAVStickerOverlayEffect, @NotNull TAVStickerRenderContext paramTAVStickerRenderContext)
  {
    this.stickerContext = paramTAVStickerRenderContext;
  }
  
  private CIImage applyEffectHard(@NonNull TAVStickerRenderContext paramTAVStickerRenderContext, CIImage paramCIImage, CMTime paramCMTime, CIContext paramCIContext)
  {
    if ((TAVStickerOverlayEffect.access$200(this.this$0) == null) || (TAVStickerOverlayEffect.access$200(this.this$0).isEmpty())) {
      return paramCIImage;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = TAVStickerOverlayEffect.access$200(this.this$0).iterator();
    TAVSticker localTAVSticker;
    while (localIterator.hasNext())
    {
      localTAVSticker = (TAVSticker)localIterator.next();
      if (localTAVSticker.getTimeRange().containsTime(paramCMTime)) {
        localArrayList.add(localTAVSticker);
      }
    }
    if (localArrayList.isEmpty())
    {
      Log.d("TAVStickerOverlayEffect", "applyEffectHard: renderStickers.isEmpty()");
      releaseCloneRenderContext();
    }
    if ((TAVStickerOverlayEffect.access$300(this.this$0)) && (this.cloneStickerContext != null) && (localArrayList.size() < this.cloneStickerContext.getStickerCount()))
    {
      Log.d("TAVStickerOverlayEffect", "applyEffectHard: renderStickers.size() = " + localArrayList.size() + ", cloneStickerContext.getStickerCount() = " + this.cloneStickerContext.getStickerCount());
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
      if ((i != 0) && (TAVStickerOverlayEffect.access$300(this.this$0))) {
        releaseCloneRenderContext();
      }
      renderByCloneContext(paramTAVStickerRenderContext, localArrayList, paramCIImage, paramCMTime, paramCIContext);
      return paramCIImage;
    }
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
    paramTAVVideoEffect = paramRenderInfo.getCiContext();
    if (this.stickerContext == null) {}
    CMSampleBuffer localCMSampleBuffer;
    do
    {
      return paramCIImage;
      this.currentTime = paramRenderInfo.getTime();
      if (TAVStickerOverlayEffect.access$100(this.this$0)) {
        return applyEffectHard(this.stickerContext, paramCIImage, paramRenderInfo.getTime(), paramTAVVideoEffect);
      }
      this.stickerContext.setRenderSize(paramCIImage.getSize());
      localCMSampleBuffer = this.stickerContext.renderSticker(paramRenderInfo.getTime().getTimeUs() / 1000L, null, paramTAVVideoEffect.getRenderContext().eglContext());
      paramTAVVideoEffect.getRenderContext().makeCurrent();
    } while ((noStickerRender(paramRenderInfo.getTime(), this.stickerContext.getStickers())) || (localCMSampleBuffer == null));
    if (localCMSampleBuffer.isNewFrame()) {
      this.stickerContext.getStickerTexture().awaitNewImage(1000L);
    }
    paramTAVVideoEffect = localCMSampleBuffer.getTextureInfo();
    paramTAVVideoEffect.setMixAlpha(false);
    new CIImage(paramTAVVideoEffect).imageByCompositingOverImage(paramCIImage);
    return paramCIImage;
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
      return this.this$0.reportKey + ":[" + MemoryReportHelper.appendKeys(localCollection) + "]";
    }
    return null;
  }
  
  public void release()
  {
    releaseCloneRenderContext();
    if ((this.stickerContext != null) && (TAVStickerOverlayEffect.access$400(this.this$0) != this.stickerContext))
    {
      this.stickerContext.release();
      this.stickerContext = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavmovie.filter.TAVStickerOverlayEffect.MyVideoCompositionEffect
 * JD-Core Version:    0.7.0.1
 */