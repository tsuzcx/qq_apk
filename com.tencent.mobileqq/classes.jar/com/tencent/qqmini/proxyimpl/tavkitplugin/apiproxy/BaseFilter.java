package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import com.tencent.autotemplate.TAVAutomaticRenderContext;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavkit.utils.ListUtils;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSourceImage;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerMode;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

abstract class BaseFilter
  implements BaseEffectNode.Filter
{
  final TAVStickerRenderContext a;
  private HashMap<String, TextureInfo> b = new HashMap();
  
  BaseFilter(TAVStickerRenderContext paramTAVStickerRenderContext)
  {
    this.a = paramTAVStickerRenderContext;
  }
  
  private CIImage a(CIImage paramCIImage, RenderInfo paramRenderInfo, TextureInfo paramTextureInfo)
  {
    paramTextureInfo = new TAVSourceImage(paramTextureInfo, true, 0);
    long l = paramRenderInfo.getTime().getTimeUs() / 1000L;
    TAVStickerRenderContext localTAVStickerRenderContext = this.a;
    if ((localTAVStickerRenderContext instanceof TAVAutomaticRenderContext)) {
      paramRenderInfo = ((TAVAutomaticRenderContext)localTAVStickerRenderContext).renderStickerChainWithTexture(l, ListUtils.listWithObjects(new TAVSourceImage[] { paramTextureInfo }));
    } else {
      paramRenderInfo = localTAVStickerRenderContext.renderSticker(l, ListUtils.listWithObjects(new TAVSourceImage[] { paramTextureInfo }), paramRenderInfo.getCiContext().getRenderContext().eglContext());
    }
    paramTextureInfo = paramCIImage;
    if (paramRenderInfo != null) {
      paramTextureInfo = a(paramCIImage, a(paramRenderInfo));
    }
    return paramTextureInfo;
  }
  
  static boolean a(CMTime paramCMTime, List<TAVSticker> paramList)
  {
    paramList = paramList.iterator();
    int j;
    int i;
    do
    {
      boolean bool = paramList.hasNext();
      j = 0;
      if (!bool) {
        break;
      }
      TAVSticker localTAVSticker = (TAVSticker)paramList.next();
      CMTimeRange localCMTimeRange = localTAVSticker.getTimeRange();
      if ((localCMTimeRange != null) && (!localCMTimeRange.containsTime(paramCMTime))) {
        i = 0;
      } else {
        i = 1;
      }
      if (localTAVSticker.getMode() == TAVStickerMode.INACTIVE) {
        j = 1;
      }
    } while ((i == 0) || (j == 0));
    return true;
    return false;
  }
  
  TextureInfo a(CIImage paramCIImage, RenderInfo paramRenderInfo, int paramInt)
  {
    String str = a(paramCIImage, paramInt);
    TextureInfo localTextureInfo2 = (TextureInfo)this.b.get(str);
    TextureInfo localTextureInfo1 = localTextureInfo2;
    if (localTextureInfo2 == null)
    {
      localTextureInfo1 = CIContext.newTextureInfo(paramCIImage.getSize());
      this.b.put(str, localTextureInfo1);
    }
    paramRenderInfo.getCiContext().convertImageToTexture(paramCIImage, localTextureInfo1);
    return localTextureInfo1;
  }
  
  @NotNull
  CIImage a(CMSampleBuffer paramCMSampleBuffer)
  {
    paramCMSampleBuffer = paramCMSampleBuffer.getTextureInfo();
    paramCMSampleBuffer.setMixAlpha(false);
    return new CIImage(paramCMSampleBuffer);
  }
  
  abstract CIImage a(CIImage paramCIImage1, CIImage paramCIImage2);
  
  String a(CIImage paramCIImage, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("index-");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(paramCIImage.getSize().width);
    localStringBuilder.append("_");
    localStringBuilder.append(paramCIImage.getSize().height);
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    Iterator localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      ((TextureInfo)localIterator.next()).release();
    }
    this.b.clear();
    this.a.release();
  }
  
  public void a(@NotNull ImageParams paramImageParams, @NotNull RenderInfo paramRenderInfo)
  {
    if (a(paramRenderInfo.getTime(), this.a.getStickers()))
    {
      if (paramImageParams.a.isEmpty()) {
        return;
      }
      this.a.setRenderSize(paramRenderInfo.getRenderSize());
      paramImageParams = paramImageParams.a;
      int i = 0;
      while (i < paramImageParams.size())
      {
        ImageParams.ImageTrackPair localImageTrackPair = (ImageParams.ImageTrackPair)paramImageParams.get(i);
        CIImage localCIImage = localImageTrackPair.b();
        localImageTrackPair.a(new CIImage(a(a(localCIImage, paramRenderInfo, a(localCIImage, paramRenderInfo, i)), paramRenderInfo, i)));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.BaseFilter
 * JD-Core Version:    0.7.0.1
 */