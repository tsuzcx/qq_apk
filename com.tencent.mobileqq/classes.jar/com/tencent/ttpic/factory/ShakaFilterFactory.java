package com.tencent.ttpic.factory;

import android.text.TextUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.filter.HorizontalSkewFilter;
import com.tencent.ttpic.filter.ShakaCustomFilter;
import com.tencent.ttpic.filter.ShakaFilterBase;
import com.tencent.ttpic.filter.ShakaFlipFilter;
import com.tencent.ttpic.filter.ShakaNineTileFilter;
import com.tencent.ttpic.filter.ShakaOffsetAlphaBlendFilter;
import com.tencent.ttpic.filter.ShakaTripleFadeTransformFilter;
import com.tencent.ttpic.filter.ShakaUpDownFilter;
import com.tencent.ttpic.model.ShakaEffectItem;

public class ShakaFilterFactory
{
  public static ShakaFilterBase create(ShakaEffectItem paramShakaEffectItem)
  {
    if (paramShakaEffectItem == null) {
      return null;
    }
    int i = paramShakaEffectItem.getFilterType();
    if (i == ShakaFilterFactory.FILTER_TYPE.TRIPLE_FADE_TRANSFORM.value) {
      return new ShakaTripleFadeTransformFilter();
    }
    if (i == ShakaFilterFactory.FILTER_TYPE.OFFSET_ALPHA_BLEND.value) {
      return new ShakaOffsetAlphaBlendFilter();
    }
    if (i == ShakaFilterFactory.FILTER_TYPE.NINE_TILE.value) {
      return new ShakaNineTileFilter();
    }
    if (i == ShakaFilterFactory.FILTER_TYPE.FLIP.value) {
      return new ShakaFlipFilter();
    }
    if (i == ShakaFilterFactory.FILTER_TYPE.UP_DOWN.value) {
      return new ShakaUpDownFilter();
    }
    if (i == ShakaFilterFactory.FILTER_TYPE.DISTORTION.value) {
      return new HorizontalSkewFilter();
    }
    if (i == ShakaFilterFactory.FILTER_TYPE.CUSTOM.value)
    {
      String str1;
      if (!TextUtils.isEmpty(paramShakaEffectItem.getCustomEffectVertexShader())) {
        str1 = FileUtils.loadSdCardFileString(paramShakaEffectItem.getCustomEffectVertexShader());
      } else {
        str1 = "precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}";
      }
      String str2;
      if (!TextUtils.isEmpty(paramShakaEffectItem.getCustomEffectFragmentShader())) {
        str2 = FileUtils.loadSdCardFileString(paramShakaEffectItem.getCustomEffectFragmentShader());
      } else {
        str2 = " precision highp float;\n varying vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n \n void main(void) {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }";
      }
      return new ShakaCustomFilter(str1, str2, paramShakaEffectItem.getUniformList());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.factory.ShakaFilterFactory
 * JD-Core Version:    0.7.0.1
 */