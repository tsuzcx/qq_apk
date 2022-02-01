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
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      while (i < localList.size())
      {
        paramTAVVideoMixEffect = (ImageCollection.TrackImagePair)localList.get(i);
        if ((paramTAVVideoMixEffect != null) && (paramTAVVideoMixEffect.getImage() != null))
        {
          paramImageCollection = paramTAVVideoMixEffect.getTrack().getExtraTrackInfo("pag_layer_index");
          int j;
          if ((paramImageCollection instanceof String)) {
            j = Integer.parseInt((String)paramImageCollection);
          } else {
            j = -1;
          }
          if (j != -1)
          {
            CIImage localCIImage = paramTAVVideoMixEffect.getImage();
            int k = (int)localCIImage.getSize().width;
            int m = (int)localCIImage.getSize().height;
            paramTAVVideoMixEffect = new StringBuilder();
            paramTAVVideoMixEffect.append(k);
            paramTAVVideoMixEffect.append("_");
            paramTAVVideoMixEffect.append(m);
            paramTAVVideoMixEffect = paramTAVVideoMixEffect.toString();
            paramImageCollection = (Integer)this.sizeKeys.get(paramTAVVideoMixEffect);
            if (paramImageCollection == null) {
              this.sizeKeys.put(paramTAVVideoMixEffect, Integer.valueOf(1));
            } else {
              this.sizeKeys.put(paramTAVVideoMixEffect, Integer.valueOf(paramImageCollection.intValue() + 1));
            }
            paramImageCollection = new StringBuilder();
            paramImageCollection.append(paramTAVVideoMixEffect);
            paramImageCollection.append("_");
            paramImageCollection.append(this.sizeKeys.get(paramTAVVideoMixEffect));
            String str = paramImageCollection.toString();
            paramImageCollection = (TextureInfo)this.textureMap.get(str);
            paramTAVVideoMixEffect = paramImageCollection;
            if (paramImageCollection == null)
            {
              this.renderContext.makeCurrent();
              paramTAVVideoMixEffect = CIContext.newTextureInfo(k, m);
              this.textureMap.put(str, paramTAVVideoMixEffect);
            }
            paramRenderInfo.getCiContext().convertImageToTexture(localCIImage, paramTAVVideoMixEffect);
            paramImageCollection = new StringBuilder();
            paramImageCollection.append("PAGImage::layerIndex: ");
            paramImageCollection.append(j);
            paramImageCollection.append(", renderSize: ");
            paramImageCollection.append(paramTAVVideoMixEffect.width);
            paramImageCollection.append(", ");
            paramImageCollection.append(paramTAVVideoMixEffect.height);
            paramImageCollection.append(", textureID: ");
            paramImageCollection.append(paramTAVVideoMixEffect.textureID);
            paramImageCollection.append(", textureKey: ");
            paramImageCollection.append(str);
            paramImageCollection.append(", context: ");
            paramImageCollection.append(this.renderContext.eglContext());
            TLog.d("TAVBigStickerOverlayEffect", paramImageCollection.toString());
            localArrayList.add(new TAVSourceImage(paramTAVVideoMixEffect, true, j));
          }
        }
        i += 1;
      }
    }
    paramTAVVideoMixEffect = this.stickerContext.renderSticker(paramRenderInfo.getTime().getTimeUs() / 1000L, localArrayList, this.renderContext.eglContext());
    this.renderContext.makeCurrent();
    if (paramTAVVideoMixEffect != null)
    {
      try
      {
        if (paramTAVVideoMixEffect.isNewFrame()) {
          this.stickerContext.getStickerTexture().awaitNewImage(1000L);
        }
      }
      catch (Exception paramImageCollection)
      {
        paramImageCollection.printStackTrace();
      }
      return new CIImage(paramTAVVideoMixEffect.getTextureInfo());
    }
    return null;
  }
  
  public String getReportKey()
  {
    ??? = this.stickerContext;
    if (??? != null) {
      synchronized (((TAVStickerRenderContext)???).getStickers())
      {
        Object localObject2 = this.stickerContext.getStickers().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          TAVSticker localTAVSticker = (TAVSticker)((Iterator)localObject2).next();
          if ((localTAVSticker != null) && (localTAVSticker.getTimeRange() != null) && (localTAVSticker.getTimeRange().containsTime(this.currentTime)))
          {
            localObject2 = this.this$0.reportKey;
            return localObject2;
          }
        }
      }
    }
    return null;
  }
  
  public void release()
  {
    Object localObject = this.renderContext;
    if (localObject != null) {
      ((RenderContext)localObject).makeCurrent();
    }
    localObject = this.stickerContext;
    if (localObject != null)
    {
      ((TAVStickerRenderContext)localObject).release();
      this.stickerContext = null;
    }
    localObject = this.textureMap;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TextureInfo)((Iterator)localObject).next()).release();
      }
      this.textureMap.clear();
    }
    localObject = this.sizeKeys;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("release cache.");
    ((StringBuilder)localObject).append(Log.getStackTraceString(new RuntimeException()));
    TLog.d("TAVBigStickerOverlayEffect", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavmovie.filter.TAVBigStickerOverlayEffect.StickerVideoCompositionMixerEffect
 * JD-Core Version:    0.7.0.1
 */