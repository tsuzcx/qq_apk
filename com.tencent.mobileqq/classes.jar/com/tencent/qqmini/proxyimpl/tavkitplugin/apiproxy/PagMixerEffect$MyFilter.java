package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.util.Log;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import com.tencent.tavkit.composition.video.RenderInfo;
import com.tencent.tavsticker.core.TAVStickerRenderContext;
import com.tencent.tavsticker.model.TAVSourceImage;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerTexture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class PagMixerEffect$MyFilter
  implements BaseEffectNode.Filter
{
  private RenderContext jdField_a_of_type_ComTencentTavDecoderRenderContext;
  private final TAVStickerRenderContext jdField_a_of_type_ComTencentTavstickerCoreTAVStickerRenderContext = new TAVStickerRenderContext();
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashMap<String, TextureInfo> b = new HashMap();
  
  public PagMixerEffect$MyFilter(List<TAVSticker> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TAVSticker localTAVSticker = (TAVSticker)paramList.next();
      this.jdField_a_of_type_ComTencentTavstickerCoreTAVStickerRenderContext.loadSticker(localTAVSticker);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentTavDecoderRenderContext != null) {
      this.jdField_a_of_type_ComTencentTavDecoderRenderContext.makeCurrent();
    }
    if (this.jdField_a_of_type_ComTencentTavstickerCoreTAVStickerRenderContext != null) {
      this.jdField_a_of_type_ComTencentTavstickerCoreTAVStickerRenderContext.release();
    }
    if (this.b != null)
    {
      Iterator localIterator = this.b.values().iterator();
      while (localIterator.hasNext()) {
        ((TextureInfo)localIterator.next()).release();
      }
      this.b.clear();
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    Logger.d("PagMixerEffect", "release cache." + Log.getStackTraceString(new RuntimeException()));
  }
  
  public void a(@NotNull ImageParams paramImageParams, @NotNull RenderInfo paramRenderInfo)
  {
    if (!BaseFilter.a(paramRenderInfo.getTime(), this.jdField_a_of_type_ComTencentTavstickerCoreTAVStickerRenderContext.getStickers())) {
      return;
    }
    this.jdField_a_of_type_ComTencentTavstickerCoreTAVStickerRenderContext.setRenderSize(paramRenderInfo.getRenderSize());
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentTavDecoderRenderContext = paramRenderInfo.getCiContext().getRenderContext();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    int i;
    Object localObject1;
    Object localObject2;
    if (!paramImageParams.a.isEmpty())
    {
      i = 0;
      if (i < paramImageParams.a.size())
      {
        localObject1 = (ImageParams.ImageTrackPair)paramImageParams.a.get(i);
        if (localObject1 != null)
        {
          localObject2 = ((ImageParams.ImageTrackPair)localObject1).a().getExtraTrackInfo("layerIndex");
          if (!(localObject2 instanceof Integer)) {
            break label582;
          }
        }
      }
    }
    label582:
    for (int j = ((Integer)localObject2).intValue();; j = i)
    {
      CIImage localCIImage = ((ImageParams.ImageTrackPair)localObject1).a();
      int k = (int)localCIImage.getSize().width;
      int m = (int)localCIImage.getSize().height;
      localObject1 = k + "_" + m;
      localObject2 = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
      if (localObject2 == null) {
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, Integer.valueOf(1));
      }
      for (;;)
      {
        String str = (String)localObject1 + "_" + this.jdField_a_of_type_JavaUtilHashMap.get(localObject1);
        localObject2 = (TextureInfo)this.b.get(str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          this.jdField_a_of_type_ComTencentTavDecoderRenderContext.makeCurrent();
          localObject1 = CIContext.newTextureInfo(k, m);
          this.b.put(str, localObject1);
        }
        paramRenderInfo.getCiContext().convertImageToTexture(localCIImage, (TextureInfo)localObject1);
        Logger.d("PagMixerEffect", "PAGImage::layerIndex: " + j + ", renderSize: " + ((TextureInfo)localObject1).width + ", " + ((TextureInfo)localObject1).height + ", textureID: " + ((TextureInfo)localObject1).textureID + ", textureKey: " + str + ", context: " + this.jdField_a_of_type_ComTencentTavDecoderRenderContext.eglContext());
        localArrayList.add(new TAVSourceImage((TextureInfo)localObject1, true, j));
        i += 1;
        break;
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, Integer.valueOf(((Integer)localObject2).intValue() + 1));
      }
      long l = paramRenderInfo.getTime().getTimeUs() / 1000L;
      paramRenderInfo = this.jdField_a_of_type_ComTencentTavstickerCoreTAVStickerRenderContext.renderSticker(l, localArrayList, this.jdField_a_of_type_ComTencentTavDecoderRenderContext.eglContext());
      this.jdField_a_of_type_ComTencentTavDecoderRenderContext.makeCurrent();
      if (paramRenderInfo == null) {
        break;
      }
      try
      {
        if (paramRenderInfo.isNewFrame()) {
          this.jdField_a_of_type_ComTencentTavstickerCoreTAVStickerRenderContext.getStickerTexture().awaitNewImage(1000L);
        }
        paramRenderInfo = paramRenderInfo.getTextureInfo();
        paramImageParams.a.clear();
        paramRenderInfo = new ImageParams.ImageTrackPair(new CIImage(paramRenderInfo), null);
        paramImageParams.a.add(paramRenderInfo);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Logger.e("PagMixerEffect", "apply: ", localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.PagMixerEffect.MyFilter
 * JD-Core Version:    0.7.0.1
 */