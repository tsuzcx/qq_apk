package com.tencent.tavmovie.filter;

import android.util.Log;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import com.tencent.tavkit.composition.video.ImageCollection;
import com.tencent.tavkit.composition.video.ImageCollection.TrackImagePair;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import com.tencent.tavkit.report.IReportable;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.log.TLog;
import com.tencent.tavsticker.model.TAVSourceImage;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerTexture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class TAVBigStickerOverlayEffect$StickerVideoCompositionMixerEffect
  implements TAVVideoMixEffect.Filter, IReportable
{
  private CMTime currentTime = CMTime.CMTimeZero;
  private RenderContext renderContext;
  private HashMap<String, Integer> sizeKeys = new HashMap();
  private TAVStickerRenderContext stickerContext;
  private HashMap<String, TextureInfo> textureMap = new HashMap();
  
  private TAVBigStickerOverlayEffect$StickerVideoCompositionMixerEffect(TAVBigStickerOverlayEffect paramTAVBigStickerOverlayEffect, TAVStickerRenderContext paramTAVStickerRenderContext)
  {
    this.stickerContext = paramTAVStickerRenderContext;
  }
  
  public CIImage apply(TAVVideoMixEffect paramTAVVideoMixEffect, ImageCollection paramImageCollection, RenderInfo paramRenderInfo)
  {
    List localList = paramImageCollection.getVideoChannelImages();
    this.stickerContext.setRenderSize(paramRenderInfo.getRenderSize());
    ArrayList localArrayList = new ArrayList();
    this.currentTime = paramRenderInfo.getTime();
    this.renderContext = paramRenderInfo.getCiContext().getRenderContext();
    this.sizeKeys.clear();
    int i;
    if ((localList != null) && (!localList.isEmpty()))
    {
      i = 0;
      if (i < localList.size())
      {
        paramTAVVideoMixEffect = (ImageCollection.TrackImagePair)localList.get(i);
        if ((paramTAVVideoMixEffect != null) && (paramTAVVideoMixEffect.getImage() != null))
        {
          paramImageCollection = paramTAVVideoMixEffect.getTrack().getExtraTrackInfo("pag_layer_index");
          if (!(paramImageCollection instanceof String)) {
            break label531;
          }
        }
      }
    }
    label531:
    for (int j = Integer.parseInt((String)paramImageCollection);; j = -1)
    {
      if (j == -1)
      {
        i += 1;
        break;
      }
      CIImage localCIImage = paramTAVVideoMixEffect.getImage();
      int k = (int)localCIImage.getSize().width;
      int m = (int)localCIImage.getSize().height;
      paramTAVVideoMixEffect = k + "_" + m;
      paramImageCollection = (Integer)this.sizeKeys.get(paramTAVVideoMixEffect);
      if (paramImageCollection == null) {
        this.sizeKeys.put(paramTAVVideoMixEffect, Integer.valueOf(1));
      }
      for (;;)
      {
        String str = paramTAVVideoMixEffect + "_" + this.sizeKeys.get(paramTAVVideoMixEffect);
        paramImageCollection = (TextureInfo)this.textureMap.get(str);
        paramTAVVideoMixEffect = paramImageCollection;
        if (paramImageCollection == null)
        {
          this.renderContext.makeCurrent();
          paramTAVVideoMixEffect = CIContext.newTextureInfo(k, m);
          this.textureMap.put(str, paramTAVVideoMixEffect);
        }
        paramRenderInfo.getCiContext().convertImageToTexture(localCIImage, paramTAVVideoMixEffect);
        TLog.d("TAVBigStickerOverlayEffect", "PAGImage::layerIndex: " + j + ", renderSize: " + paramTAVVideoMixEffect.width + ", " + paramTAVVideoMixEffect.height + ", textureID: " + paramTAVVideoMixEffect.textureID + ", textureKey: " + str + ", context: " + this.renderContext.eglContext());
        localArrayList.add(new TAVSourceImage(paramTAVVideoMixEffect, true, j));
        break;
        this.sizeKeys.put(paramTAVVideoMixEffect, Integer.valueOf(paramImageCollection.intValue() + 1));
      }
      paramTAVVideoMixEffect = this.stickerContext.renderSticker(paramRenderInfo.getTime().getTimeUs() / 1000L, localArrayList, this.renderContext.eglContext());
      this.renderContext.makeCurrent();
      if (paramTAVVideoMixEffect != null) {
        try
        {
          if (paramTAVVideoMixEffect.isNewFrame()) {
            this.stickerContext.getStickerTexture().awaitNewImage(1000L);
          }
          return new CIImage(paramTAVVideoMixEffect.getTextureInfo());
        }
        catch (Exception paramImageCollection)
        {
          for (;;)
          {
            paramImageCollection.printStackTrace();
          }
        }
      }
      return null;
    }
  }
  
  public String getReportKey()
  {
    if (this.stickerContext != null) {
      synchronized (this.stickerContext.getStickers())
      {
        Object localObject1 = this.stickerContext.getStickers().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          TAVSticker localTAVSticker = (TAVSticker)((Iterator)localObject1).next();
          if ((localTAVSticker != null) && (localTAVSticker.getTimeRange() != null) && (localTAVSticker.getTimeRange().containsTime(this.currentTime)))
          {
            localObject1 = this.this$0.reportKey;
            return localObject1;
          }
        }
      }
    }
    return null;
  }
  
  public void release()
  {
    if (this.renderContext != null) {
      this.renderContext.makeCurrent();
    }
    if (this.stickerContext != null)
    {
      this.stickerContext.release();
      this.stickerContext = null;
    }
    if (this.textureMap != null)
    {
      Iterator localIterator = this.textureMap.values().iterator();
      while (localIterator.hasNext()) {
        ((TextureInfo)localIterator.next()).release();
      }
      this.textureMap.clear();
    }
    if (this.sizeKeys != null) {
      this.sizeKeys.clear();
    }
    TLog.d("TAVBigStickerOverlayEffect", "release cache." + Log.getStackTraceString(new RuntimeException()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavmovie.filter.TAVBigStickerOverlayEffect.StickerVideoCompositionMixerEffect
 * JD-Core Version:    0.7.0.1
 */