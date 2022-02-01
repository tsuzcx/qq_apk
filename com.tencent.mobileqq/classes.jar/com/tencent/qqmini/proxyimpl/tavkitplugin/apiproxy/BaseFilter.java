package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

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
import com.tencent.tavsticker.model.TAVStickerTexture;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

abstract class BaseFilter
  implements BaseEffectNode.Filter
{
  final TAVStickerRenderContext jdField_a_of_type_ComTencentTavstickerCoreTAVStickerRenderContext = new TAVStickerRenderContext();
  private HashMap<String, TextureInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private CIImage a(CIImage paramCIImage, RenderInfo paramRenderInfo, TextureInfo paramTextureInfo)
  {
    paramTextureInfo = new TAVSourceImage(paramTextureInfo, true, 0);
    long l = paramRenderInfo.getTime().getTimeUs() / 1000L;
    paramTextureInfo = this.jdField_a_of_type_ComTencentTavstickerCoreTAVStickerRenderContext.renderSticker(l, ListUtils.listWithObjects(new TAVSourceImage[] { paramTextureInfo }), paramRenderInfo.getCiContext().getRenderContext().eglContext());
    paramRenderInfo = paramCIImage;
    if (paramTextureInfo != null) {
      paramRenderInfo = a(paramCIImage, a(paramTextureInfo));
    }
    return paramRenderInfo;
  }
  
  static boolean a(CMTime paramCMTime, List<TAVSticker> paramList)
  {
    paramList = paramList.iterator();
    label78:
    label81:
    while (paramList.hasNext())
    {
      TAVSticker localTAVSticker = (TAVSticker)paramList.next();
      CMTimeRange localCMTimeRange = localTAVSticker.getTimeRange();
      int i;
      if ((localCMTimeRange == null) || (localCMTimeRange.containsTime(paramCMTime)))
      {
        i = 1;
        if (localTAVSticker.getMode() != TAVStickerMode.INACTIVE) {
          break label78;
        }
      }
      for (int j = 1;; j = 0)
      {
        if ((i == 0) || (j == 0)) {
          break label81;
        }
        return true;
        i = 0;
        break;
      }
    }
    return false;
  }
  
  TextureInfo a(CIImage paramCIImage, RenderInfo paramRenderInfo, int paramInt)
  {
    String str = a(paramCIImage, paramInt);
    TextureInfo localTextureInfo2 = (TextureInfo)this.jdField_a_of_type_JavaUtilHashMap.get(str);
    TextureInfo localTextureInfo1 = localTextureInfo2;
    if (localTextureInfo2 == null)
    {
      localTextureInfo1 = CIContext.newTextureInfo(paramCIImage.getSize());
      this.jdField_a_of_type_JavaUtilHashMap.put(str, localTextureInfo1);
    }
    paramRenderInfo.getCiContext().convertImageToTexture(paramCIImage, localTextureInfo1);
    return localTextureInfo1;
  }
  
  @NotNull
  CIImage a(CMSampleBuffer paramCMSampleBuffer)
  {
    if (paramCMSampleBuffer.isNewFrame()) {
      this.jdField_a_of_type_ComTencentTavstickerCoreTAVStickerRenderContext.getStickerTexture().awaitNewImage(1000L);
    }
    paramCMSampleBuffer = paramCMSampleBuffer.getTextureInfo();
    paramCMSampleBuffer.setMixAlpha(false);
    return new CIImage(paramCMSampleBuffer);
  }
  
  abstract CIImage a(CIImage paramCIImage1, CIImage paramCIImage2);
  
  String a(CIImage paramCIImage, int paramInt)
  {
    return "index-" + paramInt + paramCIImage.getSize().width + "_" + paramCIImage.getSize().height;
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
    while (localIterator.hasNext()) {
      ((TextureInfo)localIterator.next()).release();
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_ComTencentTavstickerCoreTAVStickerRenderContext.release();
  }
  
  public void a(@NotNull ImageParams paramImageParams, @NotNull RenderInfo paramRenderInfo)
  {
    if ((!a(paramRenderInfo.getTime(), this.jdField_a_of_type_ComTencentTavstickerCoreTAVStickerRenderContext.getStickers())) || (paramImageParams.a.isEmpty())) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_ComTencentTavstickerCoreTAVStickerRenderContext.setRenderSize(paramRenderInfo.getRenderSize());
      paramImageParams = paramImageParams.a;
      int i = 0;
      while (i < paramImageParams.size())
      {
        ImageParams.ImageTrackPair localImageTrackPair = (ImageParams.ImageTrackPair)paramImageParams.get(i);
        CIImage localCIImage = localImageTrackPair.a();
        localImageTrackPair.a(new CIImage(a(a(localCIImage, paramRenderInfo, a(localCIImage, paramRenderInfo, i)), paramRenderInfo, i)));
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.BaseFilter
 * JD-Core Version:    0.7.0.1
 */