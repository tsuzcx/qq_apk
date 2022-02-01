package com.tencent.ttpic.openapi.filter;

import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;

public class SkinColorAndContrastFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform int blendMode; \nuniform lowp float alpha;\nuniform lowp float imageContrastOpacity;\n\nvec4 blendColor(vec4 canvasColor, vec4 texColor)\n{\n  vec3 vOne = vec3(1.0, 1.0, 1.0);\n  vec3 vZero = vec3(0.0, 0.0, 0.0);\n  //revert pre multiply\n  if(texColor.a > 0.0){\n    texColor.rgb = texColor.rgb / texColor.a;\n  }\n  vec3 resultFore = texColor.rgb;\n  if (blendMode <= 1 || blendMode > 12){ //default, since used most, put on top\n\n  } else if (blendMode == 2) {  //multiply\n    resultFore = canvasColor.rgb * texColor.rgb;\n  } else if (blendMode == 3){    //screen\n    resultFore = vOne - (vOne - canvasColor.rgb) * (vOne - texColor.rgb);\n  } else if (blendMode == 4){    //overlay\n    resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n    if (canvasColor.r >= 0.5) {\n      resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n    }\n    if (canvasColor.g >= 0.5) {\n      resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n    }\n    if (canvasColor.b >= 0.5) {\n      resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n    }\n  } else if (blendMode == 5){    //hardlight\n    resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n    if (texColor.r >= 0.5) {\n      resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n    }\n    if (texColor.g >= 0.5) {\n      resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n    }\n    if (texColor.b >= 0.5) {\n      resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n    }\n  } else if (blendMode == 6){    //softlight\n    resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n    if (texColor.r >= 0.5) {\n      resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n    }\n    if (texColor.g >= 0.5) {\n      resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n    }\n    if (texColor.b >= 0.5) {\n      resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n    }\n  } else if (blendMode == 7){    //divide\n    resultFore = vOne;\n    if (texColor.r > 0.0) {\n      resultFore.r = canvasColor.r / texColor.r;\n    }\n    if (texColor.g > 0.0) {\n      resultFore.g = canvasColor.g / texColor.g;\n    }\n    if (texColor.b > 0.0) {\n      resultFore.b = canvasColor.b / texColor.b;\n    }\n    resultFore = min(vOne, resultFore);\n  } else if (blendMode == 8){    //add\n    resultFore = canvasColor.rgb + texColor.rgb;\n    resultFore = min(vOne, resultFore);\n  } else if (blendMode == 9){    //substract\n    resultFore = canvasColor.rgb - texColor.rgb;\n    resultFore = max(vZero, resultFore);\n  } else if (blendMode == 10){   //diff\n    resultFore = abs(canvasColor.rgb - texColor.rgb);\n  } else if (blendMode == 11){   //darken\n    resultFore = min(canvasColor.rgb, texColor.rgb);\n  } else if (blendMode == 12){   //lighten\n    resultFore = max(canvasColor.rgb, texColor.rgb);\n  }\n  //pre multiply for glBlendFunc\n  vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n  resultColor = vec4(resultColor.rgb * 1.0 + canvasColor.rgb * (1.0 - resultColor.a), 1.0);\n  return resultColor;\n}\n\nvec4 lut(vec4 inputColor) {\n  highp float blueColor = inputColor.b * 63.0;\n  highp vec2 quad1; \n  quad1.y = floor(floor(blueColor) / 8.0);\n  quad1.x = floor(blueColor) - (quad1.y * 8.0);\n  highp vec2 quad2;\n  quad2.y = floor(ceil(blueColor) / 8.0);\n  quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n  highp vec2 texPos1;\n  texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.r);\n  texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.g);\n  highp vec2 texPos2;\n  texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.r);\n  texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.g);\n  lowp vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\n  lowp vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\n  return mix(newColor1, newColor2, fract(blueColor));\n}\n\nvoid main() {\n   highp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n   lowp vec4 resultColor = textureColor; \n   if (alpha > 0.01) { \n       resultColor = mix(resultColor, lut(resultColor), alpha);\n   } \n   if (imageContrastOpacity < 0.99 || imageContrastOpacity > 1.01) { \n       resultColor = vec4(clamp(mix(vec3(0.5), resultColor.rgb, imageContrastOpacity), vec3(0.0), vec3(1.0)), resultColor.a);\n   } \n   if (blendMode >= 0) {\n       resultColor = blendColor(resultColor, texture2D(inputImageTexture3, textureCoordinate)); \n   } \n   gl_FragColor = resultColor;\n}\n";
  private float mAlpha = 0.0F;
  private boolean mBlendImage = false;
  private float mContrastOpacity = 1.0F;
  
  public SkinColorAndContrastFilter()
  {
    super("precision highp float;\nvarying highp vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform int blendMode; \nuniform lowp float alpha;\nuniform lowp float imageContrastOpacity;\n\nvec4 blendColor(vec4 canvasColor, vec4 texColor)\n{\n  vec3 vOne = vec3(1.0, 1.0, 1.0);\n  vec3 vZero = vec3(0.0, 0.0, 0.0);\n  //revert pre multiply\n  if(texColor.a > 0.0){\n    texColor.rgb = texColor.rgb / texColor.a;\n  }\n  vec3 resultFore = texColor.rgb;\n  if (blendMode <= 1 || blendMode > 12){ //default, since used most, put on top\n\n  } else if (blendMode == 2) {  //multiply\n    resultFore = canvasColor.rgb * texColor.rgb;\n  } else if (blendMode == 3){    //screen\n    resultFore = vOne - (vOne - canvasColor.rgb) * (vOne - texColor.rgb);\n  } else if (blendMode == 4){    //overlay\n    resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n    if (canvasColor.r >= 0.5) {\n      resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n    }\n    if (canvasColor.g >= 0.5) {\n      resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n    }\n    if (canvasColor.b >= 0.5) {\n      resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n    }\n  } else if (blendMode == 5){    //hardlight\n    resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n    if (texColor.r >= 0.5) {\n      resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n    }\n    if (texColor.g >= 0.5) {\n      resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n    }\n    if (texColor.b >= 0.5) {\n      resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n    }\n  } else if (blendMode == 6){    //softlight\n    resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n    if (texColor.r >= 0.5) {\n      resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n    }\n    if (texColor.g >= 0.5) {\n      resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n    }\n    if (texColor.b >= 0.5) {\n      resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n    }\n  } else if (blendMode == 7){    //divide\n    resultFore = vOne;\n    if (texColor.r > 0.0) {\n      resultFore.r = canvasColor.r / texColor.r;\n    }\n    if (texColor.g > 0.0) {\n      resultFore.g = canvasColor.g / texColor.g;\n    }\n    if (texColor.b > 0.0) {\n      resultFore.b = canvasColor.b / texColor.b;\n    }\n    resultFore = min(vOne, resultFore);\n  } else if (blendMode == 8){    //add\n    resultFore = canvasColor.rgb + texColor.rgb;\n    resultFore = min(vOne, resultFore);\n  } else if (blendMode == 9){    //substract\n    resultFore = canvasColor.rgb - texColor.rgb;\n    resultFore = max(vZero, resultFore);\n  } else if (blendMode == 10){   //diff\n    resultFore = abs(canvasColor.rgb - texColor.rgb);\n  } else if (blendMode == 11){   //darken\n    resultFore = min(canvasColor.rgb, texColor.rgb);\n  } else if (blendMode == 12){   //lighten\n    resultFore = max(canvasColor.rgb, texColor.rgb);\n  }\n  //pre multiply for glBlendFunc\n  vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n  resultColor = vec4(resultColor.rgb * 1.0 + canvasColor.rgb * (1.0 - resultColor.a), 1.0);\n  return resultColor;\n}\n\nvec4 lut(vec4 inputColor) {\n  highp float blueColor = inputColor.b * 63.0;\n  highp vec2 quad1; \n  quad1.y = floor(floor(blueColor) / 8.0);\n  quad1.x = floor(blueColor) - (quad1.y * 8.0);\n  highp vec2 quad2;\n  quad2.y = floor(ceil(blueColor) / 8.0);\n  quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n  highp vec2 texPos1;\n  texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.r);\n  texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.g);\n  highp vec2 texPos2;\n  texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.r);\n  texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.g);\n  lowp vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\n  lowp vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\n  return mix(newColor1, newColor2, fract(blueColor));\n}\n\nvoid main() {\n   highp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n   lowp vec4 resultColor = textureColor; \n   if (alpha > 0.01) { \n       resultColor = mix(resultColor, lut(resultColor), alpha);\n   } \n   if (imageContrastOpacity < 0.99 || imageContrastOpacity > 1.01) { \n       resultColor = vec4(clamp(mix(vec3(0.5), resultColor.rgb, imageContrastOpacity), vec3(0.0), vec3(1.0)), resultColor.a);\n   } \n   if (blendMode >= 0) {\n       resultColor = blendColor(resultColor, texture2D(inputImageTexture3, textureCoordinate)); \n   } \n   gl_FragColor = resultColor;\n}\n");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.FloatParam("alpha", this.mAlpha));
    addParam(new UniformParam.FloatParam("imageContrastOpacity", this.mContrastOpacity));
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.IntParam("blendMode", -1));
  }
  
  private void updateContrastValue(float paramFloat)
  {
    this.mContrastOpacity = paramFloat;
    addParam(new UniformParam.FloatParam("imageContrastOpacity", this.mContrastOpacity));
  }
  
  public void clearBlendImage()
  {
    this.mBlendImage = false;
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.IntParam("blendMode", -1));
  }
  
  public boolean needRender()
  {
    return (this.mAlpha > 0.01F) || (Math.abs(this.mContrastOpacity - 1.0F) > 0.001D) || (this.mBlendImage);
  }
  
  public void setBlendImage(int paramInt1, int paramInt2)
  {
    this.mBlendImage = true;
    addParam(new UniformParam.TextureParam("inputImageTexture3", paramInt1, 33987));
    addParam(new UniformParam.IntParam("blendMode", paramInt2));
  }
  
  public void setContrastLevel(int paramInt)
  {
    if (paramInt > 0)
    {
      updateContrastValue(paramInt / 100.0F * 0.15F + 1.0F);
      return;
    }
    updateContrastValue(paramInt / 100.0F * 0.2F + 1.0F);
  }
  
  public void updateSkinColorValue(float paramFloat, int paramInt)
  {
    this.mAlpha = paramFloat;
    addParam(new UniformParam.FloatParam("alpha", this.mAlpha));
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.SkinColorAndContrastFilter
 * JD-Core Version:    0.7.0.1
 */