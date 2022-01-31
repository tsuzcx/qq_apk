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

public class TTBeautyV5SmoothFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision mediump float;\n varying highp vec2 textureCoordinate;\n varying highp vec4 textureShift_1;\n varying highp vec4 textureShift_2;\n varying highp vec4 textureShift_3;\n varying highp vec4 textureShift_4;\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n uniform sampler2D lookUpCurve;\n uniform sampler2D lookUpFacecolor;\n uniform sampler2D lookUpLeft;\n uniform sampler2D lookUpRight;\n uniform highp float blurStrength;\n uniform highp float sharpenStrength;\n uniform highp float curveAdjustStrength;\n uniform highp float whitenStrength;\n uniform highp float skinMaskAlpha;\n uniform highp float lutLeftIntensity;\n uniform highp float lutRightIntensity;\n uniform highp float lutPosition;\n uniform highp float exposure;\n \n const mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n \n lowp vec3 lookup(vec3 color, sampler2D lutSampler) {\n     float blueColor = color.b * 63.0;\n     vec2 quad1 = vec2(0.0,0.0);\n     quad1.y = floor(floor(blueColor) / 8.0);\n     quad1.x = floor(blueColor) - (quad1.y * 8.0);\n     \n     vec2 quad2;\n     quad2.y = floor(ceil(blueColor) / 8.0);\n     quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n     \n     vec2 texPos1;\n     texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.r);\n     texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.g);\n     \n     vec2 texPos2;\n     texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.r);\n     texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.g);\n     \n     vec4 newColor1 = texture2D(lutSampler, texPos1);\n     vec4 newColor2 = texture2D(lutSampler, texPos2);\n     \n     vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n     return newColor.rgb;\n }\n \n void main()\n {\n     lowp vec4 iColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec4 meanColor = texture2D(inputImageTexture2, textureCoordinate);\n     lowp vec4 varColor = texture2D(inputImageTexture3, textureCoordinate);\n     \n     lowp float iSkinR = max(iColor.r, texture2D(lookUpCurve, vec2(iColor.r, 0.5)).r);\n     lowp float mSkinR = max(meanColor.r, texture2D(lookUpCurve, vec2(meanColor.r, 0.5)).r);\n     \n     // smooth\n     mediump float p = clamp((min(iSkinR, mSkinR - 0.1) - 0.2) * 4.0, 0.0, 1.0);\n     mediump float meanVar = (varColor.r + varColor.g + varColor.b) / 3.0;\n     mediump float diffFactor = (1.0 - meanVar / (meanVar + 0.1));\n     mediump float kMin = diffFactor * p;\n     lowp vec3 smoothColor = mix(iColor.rgb, meanColor.rgb, kMin * blurStrength);\n     \n     // sharpen\n     lowp vec3 sharpenColor = smoothColor.rgb;\n     if (sharpenStrength > 0.01) {\n         mediump vec3 sum = 0.25*iColor.rgb;\n         sum += 0.125 *texture2D(inputImageTexture,textureShift_1.xy).rgb;\n         sum += 0.125 *texture2D(inputImageTexture,textureShift_1.zw).rgb;\n         sum += 0.125 *texture2D(inputImageTexture,textureShift_2.xy).rgb;\n         sum += 0.125 *texture2D(inputImageTexture,textureShift_2.zw).rgb;\n         sum += 0.0625*texture2D(inputImageTexture,textureShift_3.xy).rgb;\n         sum += 0.0625*texture2D(inputImageTexture,textureShift_3.zw).rgb;\n         sum += 0.0625*texture2D(inputImageTexture,textureShift_4.xy).rgb;\n         sum += 0.0625*texture2D(inputImageTexture,textureShift_4.zw).rgb;\n         vec3 hPass = iColor.rgb - sum;\n         lowp vec3 sharpenResult = clamp(smoothColor + hPass.g + hPass.rgb * max(0.0, meanVar - 0.05) / (meanVar + 0.1), vec3(0.0), vec3(1.0));\n         sharpenColor = mix(smoothColor.rgb, sharpenResult.rgb, sharpenStrength);\n     }\n     \n     // curve adjust\n     lowp vec3 curveAdjustResult = sharpenColor.rgb;\n     curveAdjustResult.r = texture2D(lookUpCurve, vec2(sharpenColor.r, 0.5)).r;\n     curveAdjustResult.g = texture2D(lookUpCurve, vec2(sharpenColor.g, 0.5)).r;\n     curveAdjustResult.b = texture2D(lookUpCurve, vec2(sharpenColor.b, 0.5)).r;\n     lowp vec3 curveAdjustColor = mix(sharpenColor.rgb, curveAdjustResult.rgb, curveAdjustStrength);\n     curveAdjustColor = clamp(curveAdjustColor * exposure, vec3(0.0), vec3(1.0)); \n     \n     // whiten\n     lowp vec3 whitenResult = lookup(curveAdjustColor.rgb, lookUpFacecolor);\n     lowp vec3 whitenColor = mix(curveAdjustColor.rgb, whitenResult.rgb, whitenStrength);\n     \n     // lut\n     lowp vec3 lutColor = whitenColor.rgb;\n     if (textureCoordinate.x < lutPosition && lutLeftIntensity > 0.01) {\n         lowp vec3 lutLeftResult = lookup(whitenColor.rgb, lookUpLeft);\n         lutColor = mix(whitenColor.rgb, lutLeftResult.rgb, lutLeftIntensity);\n     } else if (textureCoordinate.x >= lutPosition && lutRightIntensity > 0.01) {\n         lowp vec3 lutRightResult = lookup(whitenColor.rgb, lookUpRight);\n         lutColor = mix(whitenColor.rgb, lutRightResult.rgb, lutRightIntensity);\n     }\n     \n     lowp vec3 resultColor = mix(lutColor.rgb, vec3(kMin), skinMaskAlpha);\n     gl_FragColor = vec4(resultColor, iColor.a);\n }\n";
  private static final String VERTEX_SHADER = "attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n uniform float texelWidthOffset;\n uniform float texelHeightOffset;\n \n varying vec2 textureCoordinate;\n varying vec4 textureShift_1;\n varying vec4 textureShift_2;\n varying vec4 textureShift_3;\n varying vec4 textureShift_4;\n \n void main(void)\n {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n     textureShift_1 = vec4(textureCoordinate + vec2(-texelWidthOffset,0.0),textureCoordinate + vec2(texelWidthOffset,0.0));\n     textureShift_2 = vec4(textureCoordinate + vec2(0.0,-texelHeightOffset),textureCoordinate + vec2(0.0,texelHeightOffset));\n     textureShift_3 = vec4(textureCoordinate + vec2(texelWidthOffset,texelHeightOffset),textureCoordinate + vec2(-texelWidthOffset,-texelHeightOffset));\n     textureShift_4 = vec4(textureCoordinate + vec2(-texelWidthOffset,texelHeightOffset),textureCoordinate + vec2(texelWidthOffset,-texelHeightOffset));\n }\n";
  public static boolean enableFacecolor = true;
  
  public TTBeautyV5SmoothFilter()
  {
    super("attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n uniform float texelWidthOffset;\n uniform float texelHeightOffset;\n \n varying vec2 textureCoordinate;\n varying vec4 textureShift_1;\n varying vec4 textureShift_2;\n varying vec4 textureShift_3;\n varying vec4 textureShift_4;\n \n void main(void)\n {\n     gl_Position = position;\n     textureCoordinate = inputTextureCoordinate.xy;\n     textureShift_1 = vec4(textureCoordinate + vec2(-texelWidthOffset,0.0),textureCoordinate + vec2(texelWidthOffset,0.0));\n     textureShift_2 = vec4(textureCoordinate + vec2(0.0,-texelHeightOffset),textureCoordinate + vec2(0.0,texelHeightOffset));\n     textureShift_3 = vec4(textureCoordinate + vec2(texelWidthOffset,texelHeightOffset),textureCoordinate + vec2(-texelWidthOffset,-texelHeightOffset));\n     textureShift_4 = vec4(textureCoordinate + vec2(-texelWidthOffset,texelHeightOffset),textureCoordinate + vec2(texelWidthOffset,-texelHeightOffset));\n }\n", "precision mediump float;\n varying highp vec2 textureCoordinate;\n varying highp vec4 textureShift_1;\n varying highp vec4 textureShift_2;\n varying highp vec4 textureShift_3;\n varying highp vec4 textureShift_4;\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2;\n uniform sampler2D inputImageTexture3;\n uniform sampler2D lookUpCurve;\n uniform sampler2D lookUpFacecolor;\n uniform sampler2D lookUpLeft;\n uniform sampler2D lookUpRight;\n uniform highp float blurStrength;\n uniform highp float sharpenStrength;\n uniform highp float curveAdjustStrength;\n uniform highp float whitenStrength;\n uniform highp float skinMaskAlpha;\n uniform highp float lutLeftIntensity;\n uniform highp float lutRightIntensity;\n uniform highp float lutPosition;\n uniform highp float exposure;\n \n const mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n \n lowp vec3 lookup(vec3 color, sampler2D lutSampler) {\n     float blueColor = color.b * 63.0;\n     vec2 quad1 = vec2(0.0,0.0);\n     quad1.y = floor(floor(blueColor) / 8.0);\n     quad1.x = floor(blueColor) - (quad1.y * 8.0);\n     \n     vec2 quad2;\n     quad2.y = floor(ceil(blueColor) / 8.0);\n     quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n     \n     vec2 texPos1;\n     texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.r);\n     texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.g);\n     \n     vec2 texPos2;\n     texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.r);\n     texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.g);\n     \n     vec4 newColor1 = texture2D(lutSampler, texPos1);\n     vec4 newColor2 = texture2D(lutSampler, texPos2);\n     \n     vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n     return newColor.rgb;\n }\n \n void main()\n {\n     lowp vec4 iColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp vec4 meanColor = texture2D(inputImageTexture2, textureCoordinate);\n     lowp vec4 varColor = texture2D(inputImageTexture3, textureCoordinate);\n     \n     lowp float iSkinR = max(iColor.r, texture2D(lookUpCurve, vec2(iColor.r, 0.5)).r);\n     lowp float mSkinR = max(meanColor.r, texture2D(lookUpCurve, vec2(meanColor.r, 0.5)).r);\n     \n     // smooth\n     mediump float p = clamp((min(iSkinR, mSkinR - 0.1) - 0.2) * 4.0, 0.0, 1.0);\n     mediump float meanVar = (varColor.r + varColor.g + varColor.b) / 3.0;\n     mediump float diffFactor = (1.0 - meanVar / (meanVar + 0.1));\n     mediump float kMin = diffFactor * p;\n     lowp vec3 smoothColor = mix(iColor.rgb, meanColor.rgb, kMin * blurStrength);\n     \n     // sharpen\n     lowp vec3 sharpenColor = smoothColor.rgb;\n     if (sharpenStrength > 0.01) {\n         mediump vec3 sum = 0.25*iColor.rgb;\n         sum += 0.125 *texture2D(inputImageTexture,textureShift_1.xy).rgb;\n         sum += 0.125 *texture2D(inputImageTexture,textureShift_1.zw).rgb;\n         sum += 0.125 *texture2D(inputImageTexture,textureShift_2.xy).rgb;\n         sum += 0.125 *texture2D(inputImageTexture,textureShift_2.zw).rgb;\n         sum += 0.0625*texture2D(inputImageTexture,textureShift_3.xy).rgb;\n         sum += 0.0625*texture2D(inputImageTexture,textureShift_3.zw).rgb;\n         sum += 0.0625*texture2D(inputImageTexture,textureShift_4.xy).rgb;\n         sum += 0.0625*texture2D(inputImageTexture,textureShift_4.zw).rgb;\n         vec3 hPass = iColor.rgb - sum;\n         lowp vec3 sharpenResult = clamp(smoothColor + hPass.g + hPass.rgb * max(0.0, meanVar - 0.05) / (meanVar + 0.1), vec3(0.0), vec3(1.0));\n         sharpenColor = mix(smoothColor.rgb, sharpenResult.rgb, sharpenStrength);\n     }\n     \n     // curve adjust\n     lowp vec3 curveAdjustResult = sharpenColor.rgb;\n     curveAdjustResult.r = texture2D(lookUpCurve, vec2(sharpenColor.r, 0.5)).r;\n     curveAdjustResult.g = texture2D(lookUpCurve, vec2(sharpenColor.g, 0.5)).r;\n     curveAdjustResult.b = texture2D(lookUpCurve, vec2(sharpenColor.b, 0.5)).r;\n     lowp vec3 curveAdjustColor = mix(sharpenColor.rgb, curveAdjustResult.rgb, curveAdjustStrength);\n     curveAdjustColor = clamp(curveAdjustColor * exposure, vec3(0.0), vec3(1.0)); \n     \n     // whiten\n     lowp vec3 whitenResult = lookup(curveAdjustColor.rgb, lookUpFacecolor);\n     lowp vec3 whitenColor = mix(curveAdjustColor.rgb, whitenResult.rgb, whitenStrength);\n     \n     // lut\n     lowp vec3 lutColor = whitenColor.rgb;\n     if (textureCoordinate.x < lutPosition && lutLeftIntensity > 0.01) {\n         lowp vec3 lutLeftResult = lookup(whitenColor.rgb, lookUpLeft);\n         lutColor = mix(whitenColor.rgb, lutLeftResult.rgb, lutLeftIntensity);\n     } else if (textureCoordinate.x >= lutPosition && lutRightIntensity > 0.01) {\n         lowp vec3 lutRightResult = lookup(whitenColor.rgb, lookUpRight);\n         lutColor = mix(whitenColor.rgb, lutRightResult.rgb, lutRightIntensity);\n     }\n     \n     lowp vec3 resultColor = mix(lutColor.rgb, vec3(kMin), skinMaskAlpha);\n     gl_FragColor = vec4(resultColor, iColor.a);\n }\n");
    addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.TextureParam("lookUpCurve", 0, 33988));
    Bitmap localBitmap = FeatureManager.Features.MASK_IMAGES.decodeFaceColorBitmap();
    AEOpenRenderConfig.checkStrictMode(BitmapUtils.isLegal(localBitmap), "facecolor.png not valid");
    addParam(new UniformParam.TextureBitmapParam("lookUpFacecolor", localBitmap, 33989, true));
    addParam(new UniformParam.TextureParam("lookUpLeft", 0, 33990));
    addParam(new UniformParam.TextureParam("lookUpRight", 0, 33991));
    addParam(new UniformParam.FloatParam("texelWidthOffset", 0.0F));
    addParam(new UniformParam.FloatParam("texelHeightOffset", 0.0F));
    addParam(new UniformParam.FloatParam("blurStrength", 0.0F));
    addParam(new UniformParam.FloatParam("sharpenStrength", 0.0F));
    addParam(new UniformParam.FloatParam("curveAdjustStrength", 1.0F));
    if (enableFacecolor) {}
    for (float f = 1.0F;; f = 0.0F)
    {
      addParam(new UniformParam.FloatParam("whitenStrength", f));
      addParam(new UniformParam.FloatParam("skinMaskAlpha", 0.0F));
      addParam(new UniformParam.FloatParam("lutLeftIntensity", 0.8F));
      addParam(new UniformParam.FloatParam("lutRightIntensity", 0.8F));
      addParam(new UniformParam.FloatParam("lutPosition", 1.01F));
      addParam(new UniformParam.FloatParam("exposure", 1.0F));
      return;
    }
  }
  
  public void setBlurStrength(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("blurStrength", paramFloat));
  }
  
  public void setBlurTexture(int paramInt)
  {
    if (enableFacecolor) {}
    for (float f = 1.0F;; f = 0.0F)
    {
      addParam(new UniformParam.FloatParam("whitenStrength", f));
      addParam(new UniformParam.TextureParam("inputImageTexture2", paramInt, 33986));
      return;
    }
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
  
  public void setSharpenSize(float paramFloat1, float paramFloat2)
  {
    addParam(new UniformParam.FloatParam("texelWidthOffset", 1.0F / paramFloat1));
    addParam(new UniformParam.FloatParam("texelHeightOffset", 1.0F / paramFloat2));
  }
  
  public void setSharpenStrength(float paramFloat)
  {
    addParam(new UniformParam.FloatParam("sharpenStrength", paramFloat));
  }
  
  public void setShowBorderTexture(int paramInt)
  {
    addParam(new UniformParam.TextureParam("inputImageTexture3", paramInt, 33987));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.TTBeautyV5SmoothFilter
 * JD-Core Version:    0.7.0.1
 */