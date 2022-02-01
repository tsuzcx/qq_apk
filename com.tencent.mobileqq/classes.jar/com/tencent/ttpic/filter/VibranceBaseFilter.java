package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.util.FeatureUtils;

public class VibranceBaseFilter
  extends BaseFilter
{
  private static final String FRAGMENT_SHADER = "precision mediump float;\nvec3 ContrastSaturationBrightness(vec3 color, float con)\n{\n  const float AvgLumR = 0.5;\n  const float AvgLumG = 0.5;\n  const float AvgLumB = 0.5;\n\tvec3 AvgLumin = vec3(AvgLumR, AvgLumG, AvgLumB);\n\tvec3 conColor = mix(AvgLumin, color, con);\n\treturn conColor;\n}\n\nvec4 lut(vec4 color, sampler2D lutSampler) {\n     float blueColor = color.b * 63.0;\n     vec2 quad1 = vec2(0.0,0.0);\n     quad1.y = floor(floor(blueColor) / 8.0);\n     quad1.x = floor(blueColor) - (quad1.y * 8.0);\n     \n     vec2 quad2;\n     quad2.y = floor(ceil(blueColor) / 8.0);\n     quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n     \n     vec2 texPos1;\n     texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.r);\n     texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.g);\n     \n     vec2 texPos2;\n     texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.r);\n     texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.g);\n     \n     vec4 newColor1 = texture2D(lutSampler, texPos1);\n     vec4 newColor2 = texture2D(lutSampler, texPos2);\n     \n     vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n     return vec4(newColor.rgb, color.w);\n }\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D brightness_lut;\nuniform sampler2D vibrance_lut;\nuniform float contrast;\nuniform float saturation;\nuniform float brightness;\nvarying vec2 textureCoordinate;\nvoid main() {\n  vec4 original = texture2D(inputImageTexture, textureCoordinate);\n  // 先做饱和度LUT，再做亮度、对比度调节，否则会出现问题\n  vec4 lutColor = lut(original, vibrance_lut);\n  original = mix(original, lutColor, 2.0 * abs(saturation - 0.5));\n  \n  float brightColor_r = texture2D(brightness_lut, vec2(original.r, brightness)).r;\n  float brightColor_g = texture2D(brightness_lut, vec2(original.g, brightness)).g;\n  float brightColor_b = texture2D(brightness_lut, vec2(original.b, brightness)).b;\n  vec3 contrastColor = ContrastSaturationBrightness(vec3(brightColor_r, brightColor_g, brightColor_b), contrast);\n  gl_FragColor = vec4(contrastColor, original.a);\n}\n";
  private Bitmap brightnessLutBitmap;
  private int[] lutTex = new int[3];
  private float mBrightness;
  private float mContrast;
  private float mSaturation = 0.5F;
  private Bitmap vibranceLeftLutBitmap;
  private Bitmap vibranceRightLutBitmap;
  
  public VibranceBaseFilter()
  {
    super("precision mediump float;\nvec3 ContrastSaturationBrightness(vec3 color, float con)\n{\n  const float AvgLumR = 0.5;\n  const float AvgLumG = 0.5;\n  const float AvgLumB = 0.5;\n\tvec3 AvgLumin = vec3(AvgLumR, AvgLumG, AvgLumB);\n\tvec3 conColor = mix(AvgLumin, color, con);\n\treturn conColor;\n}\n\nvec4 lut(vec4 color, sampler2D lutSampler) {\n     float blueColor = color.b * 63.0;\n     vec2 quad1 = vec2(0.0,0.0);\n     quad1.y = floor(floor(blueColor) / 8.0);\n     quad1.x = floor(blueColor) - (quad1.y * 8.0);\n     \n     vec2 quad2;\n     quad2.y = floor(ceil(blueColor) / 8.0);\n     quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n     \n     vec2 texPos1;\n     texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.r);\n     texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.g);\n     \n     vec2 texPos2;\n     texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.r);\n     texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * color.g);\n     \n     vec4 newColor1 = texture2D(lutSampler, texPos1);\n     vec4 newColor2 = texture2D(lutSampler, texPos2);\n     \n     vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n     return vec4(newColor.rgb, color.w);\n }\n \nuniform sampler2D inputImageTexture;\nuniform sampler2D brightness_lut;\nuniform sampler2D vibrance_lut;\nuniform float contrast;\nuniform float saturation;\nuniform float brightness;\nvarying vec2 textureCoordinate;\nvoid main() {\n  vec4 original = texture2D(inputImageTexture, textureCoordinate);\n  // 先做饱和度LUT，再做亮度、对比度调节，否则会出现问题\n  vec4 lutColor = lut(original, vibrance_lut);\n  original = mix(original, lutColor, 2.0 * abs(saturation - 0.5));\n  \n  float brightColor_r = texture2D(brightness_lut, vec2(original.r, brightness)).r;\n  float brightColor_g = texture2D(brightness_lut, vec2(original.g, brightness)).g;\n  float brightColor_b = texture2D(brightness_lut, vec2(original.b, brightness)).b;\n  vec3 contrastColor = ContrastSaturationBrightness(vec3(brightColor_r, brightColor_g, brightColor_b), contrast);\n  gl_FragColor = vec4(contrastColor, original.a);\n}\n");
    initParams();
    this.brightnessLutBitmap = FeatureUtils.getEncryptedBitmap("assets://luts/", FeatureManager.getResourceDir(), "brightness_lut.png");
    this.vibranceLeftLutBitmap = FeatureUtils.getEncryptedBitmap("assets://luts/", FeatureManager.getResourceDir(), "vibrance_left_lut.png");
    this.vibranceRightLutBitmap = FeatureUtils.getEncryptedBitmap("assets://luts/", FeatureManager.getResourceDir(), "vibrance_right_lut.png");
  }
  
  private void initParams()
  {
    setParameters(0.5F, 0.5F, 0.5F);
    addParam(new UniformParam.TextureParam("brightness_lut", 0, 33985));
    addParam(new UniformParam.TextureParam("vibrance_lut", 0, 33986));
  }
  
  private void updateSatTex(float paramFloat)
  {
    if (paramFloat < 0.5D)
    {
      addParam(new UniformParam.TextureParam("vibrance_lut", this.lutTex[1], 33986));
      return;
    }
    addParam(new UniformParam.TextureParam("vibrance_lut", this.lutTex[2], 33986));
  }
  
  public void apply()
  {
    int[] arrayOfInt = this.lutTex;
    GlUtil.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    GlUtil.loadTexture(this.lutTex[0], this.brightnessLutBitmap);
    GlUtil.loadTexture(this.lutTex[1], this.vibranceLeftLutBitmap);
    GlUtil.loadTexture(this.lutTex[2], this.vibranceRightLutBitmap);
    addParam(new UniformParam.TextureParam("brightness_lut", this.lutTex[0], 33985));
    updateSatTex(this.mSaturation);
    super.apply();
  }
  
  public void clearGLSLSelf()
  {
    super.clearGLSLSelf();
    int[] arrayOfInt = this.lutTex;
    GlUtil.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    BitmapUtils.recycle(this.brightnessLutBitmap);
    BitmapUtils.recycle(this.vibranceLeftLutBitmap);
    BitmapUtils.recycle(this.vibranceRightLutBitmap);
  }
  
  public Frame render(Frame paramFrame)
  {
    if ((this.mBrightness == 0.5F) && (this.mContrast == 1.0F) && (this.mSaturation == 0.5F)) {
      return paramFrame;
    }
    return super.RenderProcess(paramFrame.getTextureId(), paramFrame.width, paramFrame.height);
  }
  
  public void setBrightness(float paramFloat)
  {
    paramFloat = (paramFloat + 1.0F) / 2.0F;
    addParam(new UniformParam.FloatParam("brightness", paramFloat));
    this.mBrightness = paramFloat;
  }
  
  public void setContrast(float paramFloat)
  {
    paramFloat = paramFloat / 2.0F + 1.0F;
    addParam(new UniformParam.FloatParam("contrast", paramFloat));
    this.mContrast = paramFloat;
  }
  
  public void setParameters(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    addParam(new UniformParam.FloatParam("brightness", paramFloat1));
    addParam(new UniformParam.FloatParam("contrast", paramFloat2 + 0.5F));
    addParam(new UniformParam.FloatParam("saturation", paramFloat3));
    this.mSaturation = paramFloat3;
    updateSatTex(this.mSaturation);
  }
  
  public void setSaturation(float paramFloat)
  {
    paramFloat = (paramFloat + 1.0F) / 2.0F;
    addParam(new UniformParam.FloatParam("saturation", paramFloat));
    this.mSaturation = paramFloat;
    updateSatTex(this.mSaturation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.VibranceBaseFilter
 * JD-Core Version:    0.7.0.1
 */