package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.taveffect.core.TAVTextureInfo;
import com.tencent.taveffect.effects.BaseEffect;
import com.tencent.taveffect.effects.LookupFilter;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class TavLutEffect$LutEffectFilter
  implements BaseEffectNode.Filter
{
  private TextureInfo jdField_a_of_type_ComTencentTavCoremediaTextureInfo;
  private BaseEffect jdField_a_of_type_ComTencentTaveffectEffectsBaseEffect;
  
  TavLutEffect$LutEffectFilter(TavLutEffect paramTavLutEffect)
  {
    if ((TavLutEffect.a(paramTavLutEffect) != null) && (!TavLutEffect.a(paramTavLutEffect).isRecycled()))
    {
      this.jdField_a_of_type_ComTencentTaveffectEffectsBaseEffect = new LookupFilter(TavLutEffect.a(paramTavLutEffect), TavLutEffect.a(paramTavLutEffect));
      return;
    }
    b();
  }
  
  @NonNull
  private TAVTextureInfo a(TextureInfo paramTextureInfo)
  {
    return new TAVTextureInfo(paramTextureInfo.textureID, paramTextureInfo.textureType, paramTextureInfo.width, paramTextureInfo.height, null, 0);
  }
  
  private void b()
  {
    if (TextUtils.isEmpty(TavLutEffect.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavLutEffect))) {}
    do
    {
      return;
      TavLutEffect.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavLutEffect, BitmapFactory.decodeFile(TavLutEffect.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavLutEffect)));
    } while (TavLutEffect.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavLutEffect) == null);
    this.jdField_a_of_type_ComTencentTaveffectEffectsBaseEffect = new LookupFilter(TavLutEffect.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavLutEffect));
  }
  
  @NonNull
  TextureInfo a(TAVTextureInfo paramTAVTextureInfo)
  {
    return new TextureInfo(paramTAVTextureInfo.textureID, paramTAVTextureInfo.textureType, paramTAVTextureInfo.width, paramTAVTextureInfo.height, null, 0);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentTaveffectEffectsBaseEffect != null)
    {
      this.jdField_a_of_type_ComTencentTaveffectEffectsBaseEffect.release();
      this.jdField_a_of_type_ComTencentTaveffectEffectsBaseEffect = null;
    }
    if ((this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo != null) && (!this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo.isReleased())) {
      this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo.release();
    }
  }
  
  public void a(@NotNull ImageParams paramImageParams, @NotNull RenderInfo paramRenderInfo)
  {
    if (this.jdField_a_of_type_ComTencentTaveffectEffectsBaseEffect == null) {}
    for (;;)
    {
      return;
      if ((TavLutEffect.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavLutEffect) == null) || (TavLutEffect.a(this.jdField_a_of_type_ComTencentQqminiProxyimplTavkitpluginApiproxyTavLutEffect).containsTime(paramRenderInfo.getTime())))
      {
        paramRenderInfo = paramRenderInfo.getCiContext();
        int i = 0;
        while (i < paramImageParams.a.size())
        {
          ImageParams.ImageTrackPair localImageTrackPair = (ImageParams.ImageTrackPair)paramImageParams.a.get(i);
          Object localObject = localImageTrackPair.a();
          int j = (int)((CIImage)localObject).getSize().width;
          int k = (int)((CIImage)localObject).getSize().height;
          this.jdField_a_of_type_ComTencentTaveffectEffectsBaseEffect.setRendererWidth(j);
          this.jdField_a_of_type_ComTencentTaveffectEffectsBaseEffect.setRendererHeight(k);
          if (this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo == null)
          {
            paramRenderInfo.getRenderContext().makeCurrent();
            this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo = CIContext.newTextureInfo(j, k);
          }
          if ((this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo.width != j) || (this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo.height != k))
          {
            paramRenderInfo.getRenderContext().makeCurrent();
            this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo.release();
            this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo = CIContext.newTextureInfo(j, k);
          }
          paramRenderInfo.convertImageToTexture((CIImage)localObject, this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo);
          localObject = a(this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo);
          localObject = a(this.jdField_a_of_type_ComTencentTaveffectEffectsBaseEffect.applyFilter((TAVTextureInfo)localObject));
          ((TextureInfo)localObject).setTextureMatrix(this.jdField_a_of_type_ComTencentTavCoremediaTextureInfo.getTextureMatrix());
          localImageTrackPair.a(new CIImage((TextureInfo)localObject));
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavLutEffect.LutEffectFilter
 * JD-Core Version:    0.7.0.1
 */