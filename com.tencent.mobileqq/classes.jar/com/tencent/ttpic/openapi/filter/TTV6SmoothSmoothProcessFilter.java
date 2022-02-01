package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureBitmapParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.initializer.MaskImagesInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;

public class TTV6SmoothSmoothProcessFilter
  extends BaseFilter
{
  public static final String FRAGMENT_SHADER = "precision mediump float;\nvarying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n uniform sampler2D lookUpCurve;\n uniform sampler2D lookUpFacecolor;\n uniform sampler2D lookUpLeft;\n uniform sampler2D lookUpRight;\n uniform lowp float skinMaskBackgroundAlpha;\n uniform lowp float blurAlpha;\n uniform lowp float sharpenAlpha;\n uniform highp float widthOffset;\n uniform highp float heightOffset;\n uniform highp float curveAdjustStrength;\n uniform highp float whitenStrength;\n uniform highp float lutLeftIntensity;\n uniform highp float lutRightIntensity;\n uniform highp float lutPosition;\n uniform highp float exposure;\n vec3 rgb2hsv(lowp vec3 c) { \n   lowp vec4 K = vec4(0.0, -0.33333, 0.66667, -1.0);\n   highp vec4 p = mix(vec4(c.bg, K.wz), vec4(c.gb, K.xy), step(c.b, c.g));\n   highp vec4 q = mix(vec4(p.xyw, c.r), vec4(c.r, p.yzx), step(p.x, c.r));\n   highp float d = q.x - min(q.w, q.y);\n   highp float e = 1.0e-10;\n   float s = 0.0;\n   lowp vec3 hsv = vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), s, q.x);\n   return hsv;\n }\n lowp vec3 lookup(vec3 color, sampler2D lutSampler) {\n   float blueColor = color.b * 63.0;\n   vec2 quad1 = vec2(0.0,0.0);\n   quad1.y = floor(floor(blueColor) / 8.0);\n   quad1.x = floor(blueColor) - (quad1.y * 8.0);\n     \n   vec2 quad2;\n   quad2.y = floor(ceil(blueColor) / 8.0);\n   quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n     \n   vec2 texPos1;\n   texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.r);\n   texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.g);\n     \n   vec2 texPos2;\n   texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.r);\n   texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.g);\n     \n   vec4 newColor1 = texture2D(lutSampler, texPos1);\n   vec4 newColor2 = texture2D(lutSampler, texPos2);\n     \n   vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n   return newColor.rgb;\n }\n void main() { \n   lowp vec4 iColor = texture2D(inputImageTexture, textureCoordinate);\n   lowp vec3 resultColor = iColor.rgb;\n   lowp vec4 faceSkinMask = texture2D(inputImageTexture3, textureCoordinate);\n   lowp vec4 meanColor = texture2D(inputImageTexture2, textureCoordinate);\n   if(blurAlpha > 0.0) { \n      mediump float tmp_p1 = clamp((min(iColor.r, meanColor.r - 0.1) - 0.2) * 4.0, 0.0, 1.0);\n      mediump float p = max(faceSkinMask.r, tmp_p1);\n      vec3 hsvSpace = rgb2hsv(meanColor.rgb);\n      float hue = hsvSpace.x;\n      float value = hsvSpace.z;\n      float tmp_p2 = 1.0;\n      float white = meanColor.r + meanColor.g + meanColor.b;\n      if ((0.18 <= hue && hue <= 0.89) || value <= 0.2) { \n         tmp_p2 = 0.0;\n      } \n      if (0.16 < hue && hue < 0.18) { \n         tmp_p2 = min(tmp_p2, (hue - 0.16) * 50.0);\n      } \n      if (0.89 < hue && hue < 0.91) { \n         tmp_p2 = min(tmp_p2, (0.91 - hue) * 50.0);\n      } \n      if (0.2 < value && value < 0.3) { \n         tmp_p2 = min(tmp_p2, (0.3 - value) * 10.0);\n      } \n      float tmp_p = min(tmp_p1, tmp_p2); \n      float p_alpha = 1.0;\n      if(tmp_p > 0.8)\n      {\n        p_alpha = 1.0; \n      }\n      else if(tmp_p > 0.5)\n      {\n        p_alpha = 0.9; \n      }\n      else if(tmp_p > 0.1)\n      {\n        p_alpha = 0.5; \n      }\n      else\n      {\n        p_alpha = 0.08;\n      }  \n      lowp float skinMaskVal = max(faceSkinMask.b, skinMaskBackgroundAlpha * p_alpha);\n      lowp float meanVar = meanColor.a;\n      lowp float theta = 0.1;\n      mediump float kMin = (1.0 - meanVar / (meanVar + theta)) * p * blurAlpha;\n      resultColor = mix(iColor.rgb, meanColor.rgb, kMin * skinMaskVal);\n    } \n    if (sharpenAlpha>0.0) { \n      highp float sum = iColor.g;\n      sum += texture2D(inputImageTexture, textureCoordinate + vec2(-widthOffset, 0.0)).g;\n      sum += texture2D(inputImageTexture, textureCoordinate + vec2(widthOffset, 0.0)).g;\n      sum += texture2D(inputImageTexture, textureCoordinate + vec2(0.0, -heightOffset)).g;\n      sum += texture2D(inputImageTexture, textureCoordinate + vec2(0.0, heightOffset)).g;\n      sum *= 0.2;\n      highp vec3 sharpenResult = clamp(resultColor + 2.0 * (iColor.g - sum), 0.0, 1.0);\n      resultColor = mix(resultColor, sharpenResult, sharpenAlpha);\n    }\n    \n    lowp vec3 sharpenColor = resultColor;\n    \n    // curve adjust\n    lowp vec3 curveAdjustResult = sharpenColor.rgb;\n    curveAdjustResult.r = texture2D(lookUpCurve, vec2(sharpenColor.r, 0.5)).r;\n    curveAdjustResult.g = texture2D(lookUpCurve, vec2(sharpenColor.g, 0.5)).r;\n    curveAdjustResult.b = texture2D(lookUpCurve, vec2(sharpenColor.b, 0.5)).r;\n    lowp vec3 curveAdjustColor = mix(sharpenColor.rgb, curveAdjustResult.rgb, curveAdjustStrength);\n    curveAdjustColor = clamp(curveAdjustColor * exposure, vec3(0.0), vec3(1.0)); \n     \n    // whiten\n    lowp vec3 whitenResult = lookup(curveAdjustColor.rgb, lookUpFacecolor);\n    lowp vec3 whitenColor = mix(curveAdjustColor.rgb, whitenResult.rgb, whitenStrength);\n     \n    // lut\n    lowp vec3 lutColor = whitenColor.rgb;\n    if (textureCoordinate.x < lutPosition && lutLeftIntensity > 0.01) {\n        lowp vec3 lutLeftResult = lookup(whitenColor.rgb, lookUpLeft);\n        lutColor = mix(whitenColor.rgb, lutLeftResult.rgb, lutLeftIntensity);\n    } else if (textureCoordinate.x >= lutPosition && lutRightIntensity > 0.01) {\n        lowp vec3 lutRightResult = lookup(whitenColor.rgb, lookUpRight);\n        lutColor = mix(whitenColor.rgb, lutRightResult.rgb, lutRightIntensity);\n    }\n     \n    resultColor = lutColor;\n     \n    gl_FragColor = vec4(resultColor, iColor.a);\n   \n }\n";
  public static final String VERTEX_SHADER = "attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n void main() { \n   gl_Position = position;\n   textureCoordinate = inputTextureCoordinate.xy;\n }\n";
  private float whitenStrength = 1.0F;
  
  public TTV6SmoothSmoothProcessFilter()
  {
    super("attribute vec4 position;\n attribute vec2 inputTextureCoordinate;\n varying vec2 textureCoordinate;\n void main() { \n   gl_Position = position;\n   textureCoordinate = inputTextureCoordinate.xy;\n }\n", "precision mediump float;\nvarying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n uniform sampler2D lookUpCurve;\n uniform sampler2D lookUpFacecolor;\n uniform sampler2D lookUpLeft;\n uniform sampler2D lookUpRight;\n uniform lowp float skinMaskBackgroundAlpha;\n uniform lowp float blurAlpha;\n uniform lowp float sharpenAlpha;\n uniform highp float widthOffset;\n uniform highp float heightOffset;\n uniform highp float curveAdjustStrength;\n uniform highp float whitenStrength;\n uniform highp float lutLeftIntensity;\n uniform highp float lutRightIntensity;\n uniform highp float lutPosition;\n uniform highp float exposure;\n vec3 rgb2hsv(lowp vec3 c) { \n   lowp vec4 K = vec4(0.0, -0.33333, 0.66667, -1.0);\n   highp vec4 p = mix(vec4(c.bg, K.wz), vec4(c.gb, K.xy), step(c.b, c.g));\n   highp vec4 q = mix(vec4(p.xyw, c.r), vec4(c.r, p.yzx), step(p.x, c.r));\n   highp float d = q.x - min(q.w, q.y);\n   highp float e = 1.0e-10;\n   float s = 0.0;\n   lowp vec3 hsv = vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), s, q.x);\n   return hsv;\n }\n lowp vec3 lookup(vec3 color, sampler2D lutSampler) {\n   float blueColor = color.b * 63.0;\n   vec2 quad1 = vec2(0.0,0.0);\n   quad1.y = floor(floor(blueColor) / 8.0);\n   quad1.x = floor(blueColor) - (quad1.y * 8.0);\n     \n   vec2 quad2;\n   quad2.y = floor(ceil(blueColor) / 8.0);\n   quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n     \n   vec2 texPos1;\n   texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.r);\n   texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.g);\n     \n   vec2 texPos2;\n   texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.r);\n   texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.g);\n     \n   vec4 newColor1 = texture2D(lutSampler, texPos1);\n   vec4 newColor2 = texture2D(lutSampler, texPos2);\n     \n   vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n   return newColor.rgb;\n }\n void main() { \n   lowp vec4 iColor = texture2D(inputImageTexture, textureCoordinate);\n   lowp vec3 resultColor = iColor.rgb;\n   lowp vec4 faceSkinMask = texture2D(inputImageTexture3, textureCoordinate);\n   lowp vec4 meanColor = texture2D(inputImageTexture2, textureCoordinate);\n   if(blurAlpha > 0.0) { \n      mediump float tmp_p1 = clamp((min(iColor.r, meanColor.r - 0.1) - 0.2) * 4.0, 0.0, 1.0);\n      mediump float p = max(faceSkinMask.r, tmp_p1);\n      vec3 hsvSpace = rgb2hsv(meanColor.rgb);\n      float hue = hsvSpace.x;\n      float value = hsvSpace.z;\n      float tmp_p2 = 1.0;\n      float white = meanColor.r + meanColor.g + meanColor.b;\n      if ((0.18 <= hue && hue <= 0.89) || value <= 0.2) { \n         tmp_p2 = 0.0;\n      } \n      if (0.16 < hue && hue < 0.18) { \n         tmp_p2 = min(tmp_p2, (hue - 0.16) * 50.0);\n      } \n      if (0.89 < hue && hue < 0.91) { \n         tmp_p2 = min(tmp_p2, (0.91 - hue) * 50.0);\n      } \n      if (0.2 < value && value < 0.3) { \n         tmp_p2 = min(tmp_p2, (0.3 - value) * 10.0);\n      } \n      float tmp_p = min(tmp_p1, tmp_p2); \n      float p_alpha = 1.0;\n      if(tmp_p > 0.8)\n      {\n        p_alpha = 1.0; \n      }\n      else if(tmp_p > 0.5)\n      {\n        p_alpha = 0.9; \n      }\n      else if(tmp_p > 0.1)\n      {\n        p_alpha = 0.5; \n      }\n      else\n      {\n        p_alpha = 0.08;\n      }  \n      lowp float skinMaskVal = max(faceSkinMask.b, skinMaskBackgroundAlpha * p_alpha);\n      lowp float meanVar = meanColor.a;\n      lowp float theta = 0.1;\n      mediump float kMin = (1.0 - meanVar / (meanVar + theta)) * p * blurAlpha;\n      resultColor = mix(iColor.rgb, meanColor.rgb, kMin * skinMaskVal);\n    } \n    if (sharpenAlpha>0.0) { \n      highp float sum = iColor.g;\n      sum += texture2D(inputImageTexture, textureCoordinate + vec2(-widthOffset, 0.0)).g;\n      sum += texture2D(inputImageTexture, textureCoordinate + vec2(widthOffset, 0.0)).g;\n      sum += texture2D(inputImageTexture, textureCoordinate + vec2(0.0, -heightOffset)).g;\n      sum += texture2D(inputImageTexture, textureCoordinate + vec2(0.0, heightOffset)).g;\n      sum *= 0.2;\n      highp vec3 sharpenResult = clamp(resultColor + 2.0 * (iColor.g - sum), 0.0, 1.0);\n      resultColor = mix(resultColor, sharpenResult, sharpenAlpha);\n    }\n    \n    lowp vec3 sharpenColor = resultColor;\n    \n    // curve adjust\n    lowp vec3 curveAdjustResult = sharpenColor.rgb;\n    curveAdjustResult.r = texture2D(lookUpCurve, vec2(sharpenColor.r, 0.5)).r;\n    curveAdjustResult.g = texture2D(lookUpCurve, vec2(sharpenColor.g, 0.5)).r;\n    curveAdjustResult.b = texture2D(lookUpCurve, vec2(sharpenColor.b, 0.5)).r;\n    lowp vec3 curveAdjustColor = mix(sharpenColor.rgb, curveAdjustResult.rgb, curveAdjustStrength);\n    curveAdjustColor = clamp(curveAdjustColor * exposure, vec3(0.0), vec3(1.0)); \n     \n    // whiten\n    lowp vec3 whitenResult = lookup(curveAdjustColor.rgb, lookUpFacecolor);\n    lowp vec3 whitenColor = mix(curveAdjustColor.rgb, whitenResult.rgb, whitenStrength);\n     \n    // lut\n    lowp vec3 lutColor = whitenColor.rgb;\n    if (textureCoordinate.x < lutPosition && lutLeftIntensity > 0.01) {\n        lowp vec3 lutLeftResult = lookup(whitenColor.rgb, lookUpLeft);\n        lutColor = mix(whitenColor.rgb, lutLeftResult.rgb, lutLeftIntensity);\n    } else if (textureCoordinate.x >= lutPosition && lutRightIntensity > 0.01) {\n        lowp vec3 lutRightResult = lookup(whitenColor.rgb, lookUpRight);\n        lutColor = mix(whitenColor.rgb, lutRightResult.rgb, lutRightIntensity);\n    }\n     \n    resultColor = lutColor;\n     \n    gl_FragColor = vec4(resultColor, iColor.a);\n   \n }\n");
    initParams();
  }
  
  private void initParams()
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.FloatParam("skinMaskBackgroundAlpha", 0.0F));
    addParam(new UniformParam.FloatParam("blurAlpha", 0.67F));
    addParam(new UniformParam.FloatParam("sharpenAlpha", 1.2F));
    addParam(new UniformParam.FloatParam("widthOffset", 0.0F));
    addParam(new UniformParam.FloatParam("heightOffset", 0.0F));
    addParam(new UniformParam.TextureParam("lookUpCurve", 0, 33988));
    Bitmap localBitmap = FeatureManager.Features.MASK_IMAGES.decodeFaceColorBitmap();
    AEOpenRenderConfig.checkStrictMode(BitmapUtils.isLegal(localBitmap), "facecolor.png not valid");
    addParam(new UniformParam.TextureBitmapParam("lookUpFacecolor", localBitmap, 33989, true));
    addParam(new UniformParam.TextureParam("lookUpLeft", 0, 33990));
    addParam(new UniformParam.TextureParam("lookUpRight", 0, 33991));
    addParam(new UniformParam.FloatParam("curveAdjustStrength", 1.0F));
    addParam(new UniformParam.FloatParam("whitenStrength", this.whitenStrength));
    addParam(new UniformParam.FloatParam("lutLeftIntensity", 0.8F));
    addParam(new UniformParam.FloatParam("lutRightIntensity", 0.8F));
    addParam(new UniformParam.FloatParam("lutPosition", 1.01F));
    addParam(new UniformParam.FloatParam("exposure", 1.0F));
  }
  
  public void setBlurAlpha(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("blurAlpha", 0.67F * paramFloat));
    addParam(new UniformParam.FloatParam("skinMaskBackgroundAlpha", Math.max(0.0F, Math.min(1.0F, (paramFloat - 0.7F) * 2.0F))));
  }
  
  public void setExposureValue(int paramInt)
  {
    if (paramInt > 50)
    {
      addParam(new UniformParam.FloatParam("exposure", 0.0136F * (paramInt - 50) + 1.0F));
      return;
    }
    addParam(new UniformParam.FloatParam("exposure", 0.01F * paramInt + 0.5F));
  }
  
  public void setLookUpCurve(int paramInt)
  {
    addParam(new UniformParam.TextureParam("lookUpCurve", paramInt, 33988));
  }
  
  public void setLookUpLeft(int paramInt)
  {
    addParam(new UniformParam.TextureParam("lookUpLeft", paramInt, 33990));
  }
  
  public void setLookUpRight(int paramInt)
  {
    addParam(new UniformParam.TextureParam("lookUpRight", paramInt, 33991));
  }
  
  public void setLutLeftIntensity(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("lutLeftIntensity", paramFloat));
  }
  
  public void setLutPosition(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("lutPosition", paramFloat));
  }
  
  public void setLutRightIntensity(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("lutRightIntensity", paramFloat));
  }
  
  public void setSharpenAlpha(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("sharpenAlpha", paramFloat));
  }
  
  public void setTextureOffset(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatParam("widthOffset", paramFloat1));
    addParam(new UniformParam.FloatParam("heightOffset", paramFloat2));
  }
  
  public void setTextures(int paramInt1, int paramInt2)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt1, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", paramInt2, 33987));
  }
  
  public void setWhitenStrength(float paramFloat)
  {
    this.whitenStrength = paramFloat;
    addParam(new UniformParam.FloatParam("whitenStrength", this.whitenStrength));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.TTV6SmoothSmoothProcessFilter
 * JD-Core Version:    0.7.0.1
 */