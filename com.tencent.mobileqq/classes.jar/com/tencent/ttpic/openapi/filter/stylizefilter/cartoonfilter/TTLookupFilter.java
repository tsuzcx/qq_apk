package com.tencent.ttpic.openapi.filter.stylizefilter.cartoonfilter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.ttpic.openapi.filter.stylizefilter.TTStylizeFilter;
import java.util.Map;

public class TTLookupFilter
  extends TTStylizeFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\n varying vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2; // lookup texture\n \n uniform float intensity;\n \n void main()\n {\n    vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n    float blueColor = textureColor.b * 63.0;\n     \n    vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n     \n    vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n     \n    vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n    texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n     \n    vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n    texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n     \n    vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\n    vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\n    \n    vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    gl_FragColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity);\n }";
  private static final String VERTEX_SHADER = "precision highp float;\n attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main()\n {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }";
  
  public TTLookupFilter()
  {
    super("precision highp float;\n attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n \n void main()\n {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n }", "precision highp float;\n varying vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2; // lookup texture\n \n uniform float intensity;\n \n void main()\n {\n    vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n    float blueColor = textureColor.b * 63.0;\n     \n    vec2 quad1;\n    quad1.y = floor(floor(blueColor) / 8.0);\n    quad1.x = floor(blueColor) - (quad1.y * 8.0);\n     \n    vec2 quad2;\n    quad2.y = floor(ceil(blueColor) / 8.0);\n    quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n     \n    vec2 texPos1;\n    texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n    texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n     \n    vec2 texPos2;\n    texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n    texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n     \n    vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\n    vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\n    \n    vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n    gl_FragColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), intensity);\n }");
    updateIntensity(1.0F);
  }
  
  private void updateIntensity(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("intensity", paramFloat));
  }
  
  public void updateLutPaths(Map<String, String> paramMap)
  {
    if (paramMap != null)
    {
      if (paramMap.size() <= 0) {
        return;
      }
      updateBitmapTexture((String)paramMap.get("lut1"), "inputImageTexture2", 33986);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.cartoonfilter.TTLookupFilter
 * JD-Core Version:    0.7.0.1
 */