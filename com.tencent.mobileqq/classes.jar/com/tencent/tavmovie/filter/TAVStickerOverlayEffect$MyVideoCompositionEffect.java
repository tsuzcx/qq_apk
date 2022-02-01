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
    if (this.this$0.stickers != null)
    {
      if (this.this$0.stickers.isEmpty()) {
        return paramCIImage;
      }
      ArrayList localArrayList = new ArrayList();
      Object localObject = this.this$0.stickers.iterator();
      TAVSticker localTAVSticker;
      while (((Iterator)localObject).hasNext())
      {
        localTAVSticker = (TAVSticker)((Iterator)localObject).next();
        if (localTAVSticker.getTimeRange().containsTime(paramCMTime)) {
          localArrayList.add(localTAVSticker);
        }
      }
      if (localArrayList.isEmpty())
      {
        Log.d("TAVStickerOverlayEffect", "applyEffectHard: renderStickers.isEmpty()");
        releaseCloneRenderContext();
      }
      if ((this.this$0.realTimeReleaseEachSticker) && (this.cloneStickerContext != null) && (localArrayList.size() < this.cloneStickerContext.getStickerCount()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("applyEffectHard: renderStickers.size() = ");
        ((StringBuilder)localObject).append(localArrayList.size());
        ((StringBuilder)localObject).append(", cloneStickerContext.getStickerCount() = ");
        ((StringBuilder)localObject).append(this.cloneStickerContext.getStickerCount());
        Log.d("TAVStickerOverlayEffect", ((StringBuilder)localObject).toString());
        releaseCloneRenderContext();
      }
      int j = 0;
      localObject = localArrayList.iterator();
      TAVStickerRenderContext localTAVStickerRenderContext;
      do
      {
        i = j;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localTAVSticker = (TAVSticker)((Iterator)localObject).next();
        localTAVStickerRenderContext = this.cloneStickerContext;
      } while ((localTAVStickerRenderContext == null) || (localTAVStickerRenderContext.containSticker(localTAVSticker)));
      int i = 1;
      if ((i != 0) && (this.this$0.realTimeReleaseEachSticker)) {
        releaseCloneRenderContext();
      }
      renderByCloneContext(paramTAVStickerRenderContext, localArrayList, paramCIImage, paramCMTime, paramCIContext);
    }
    return paramCIImage;
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
    TAVStickerRenderContext localTAVStickerRenderContext = this.cloneStickerContext;
    if (localTAVStickerRenderContext != null)
    {
      localTAVStickerRenderContext.release();
      this.cloneStickerContext.removeAllStickers();
      this.cloneStickerContext = null;
    }
  }
  
  private void renderByCloneContext(@NonNull TAVStickerRenderContext paramTAVStickerRenderContext, List<TAVSticker> paramList, CIImage paramCIImage, CMTime paramCMTime, CIContext paramCIContext)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      if (this.cloneStickerContext == null) {
        this.cloneStickerContext = paramTAVStickerRenderContext.copy();
      }
      if (this.cloneStickerContext == null) {
        return;
      }
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
      if (paramTAVStickerRenderContext != null)
      {
        if (paramTAVStickerRenderContext.isNewFrame()) {
          this.cloneStickerContext.getStickerTexture().awaitNewImage(1000L);
        }
        new CIImage(paramTAVStickerRenderContext.getTextureInfo()).imageByCompositingOverImage(paramCIImage);
      }
    }
  }
  
  public CIImage apply(TAVVideoEffect paramTAVVideoEffect, CIImage paramCIImage, RenderInfo paramRenderInfo)
  {
    paramTAVVideoEffect = paramRenderInfo.getCiContext();
    if (this.stickerContext == null) {
      return paramCIImage;
    }
    this.currentTime = paramRenderInfo.getTime();
    if (this.this$0.realTimeReleaseStickerContext) {
      return applyEffectHard(this.stickerContext, paramCIImage, paramRenderInfo.getTime(), paramTAVVideoEffect);
    }
    this.stickerContext.setRenderSize(paramCIImage.getSize());
    CMSampleBuffer localCMSampleBuffer = this.stickerContext.renderSticker(paramRenderInfo.getTime().getTimeUs() / 1000L, null, paramTAVVideoEffect.getRenderContext().eglContext());
    paramTAVVideoEffect.getRenderContext().makeCurrent();
    if (noStickerRender(paramRenderInfo.getTime(), this.stickerContext.getStickers())) {
      return paramCIImage;
    }
    if (localCMSampleBuffer != null)
    {
      if (localCMSampleBuffer.isNewFrame()) {
        this.stickerContext.getStickerTexture().awaitNewImage(1000L);
      }
      paramTAVVideoEffect = localCMSampleBuffer.getTextureInfo();
      paramTAVVideoEffect.setMixAlpha(false);
      new CIImage(paramTAVVideoEffect).imageByCompositingOverImage(paramCIImage);
    }
    return paramCIImage;
  }
  
  public String getReportKey()
  {
    ArrayList localArrayList = new ArrayList();
    ??? = this.stickerContext;
    if (??? != null) {
      synchronized (((TAVStickerRenderContext)???).getStickers())
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
    if (!localCollection.isEmpty())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append(this.this$0.reportKey);
      ((StringBuilder)???).append(":[");
      ((StringBuilder)???).append(MemoryReportHelper.appendKeys(localCollection));
      ((StringBuilder)???).append("]");
      return ((StringBuilder)???).toString();
    }
    return null;
  }
  
  public void release()
  {
    releaseCloneRenderContext();
    if (this.stickerContext != null)
    {
      TAVStickerRenderContext localTAVStickerRenderContext1 = this.this$0.stickerContext;
      TAVStickerRenderContext localTAVStickerRenderContext2 = this.stickerContext;
      if (localTAVStickerRenderContext1 != localTAVStickerRenderContext2)
      {
        localTAVStickerRenderContext2.release();
        this.stickerContext = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavmovie.filter.TAVStickerOverlayEffect.MyVideoCompositionEffect
 * JD-Core Version:    0.7.0.1
 */