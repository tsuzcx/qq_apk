package com.tencent.ttpic.openapi.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.UniformParam.FloatParam;
import com.tencent.aekit.openrender.UniformParam.IntParam;
import com.tencent.aekit.openrender.UniformParam.TextureParam;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.filter.GLSLRender;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.openapi.initializer.MaskImagesInitializer;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;

public class FaceColorCombineFilter
  extends VideoFilterBase
{
  private static final String FRAGMENT_SHADER = "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform float exposure;\nuniform int brightness;\n\nvec3 lookupTable(vec3 inputColor) {\n  float blueColor = inputColor.b * 63.0;\n  vec2 quad1; \n  quad1.y = floor(floor(blueColor) / 8.0);\n  quad1.x = floor(blueColor) - (quad1.y * 8.0);\n  vec2 quad2;\n  quad2.y = floor(ceil(blueColor) / 8.0);\n  quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n  vec2 texPos1;\n  texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.r);\n  texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.g);\n  vec2 texPos2;\n  texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.r);\n  texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.g);\n  vec4 newColor1 = texture2D(inputImageTexture3, texPos1);\n  vec4 newColor2 = texture2D(inputImageTexture3, texPos2);\n  vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n  return newColor.rgb;\n}\n\nvoid main() {\n  vec4 color = texture2D(inputImageTexture, textureCoordinate);\n  if (brightness == 1) {\n    color.r = texture2D(inputImageTexture2, vec2(color.r, 0.5)).r;\n    color.g = texture2D(inputImageTexture2, vec2(color.g, 0.5)).r;\n    color.b = texture2D(inputImageTexture2, vec2(color.b, 0.5)).r;\n  }\n  gl_FragColor = vec4(lookupTable(min(vec3(1.0), max(vec3(0.0), color.rgb * exposure))), color.a);\n}\n";
  private int counter = 5;
  private int curveTexture = 0;
  private int enableBrightness;
  private int facecolorTexture;
  private boolean isMaskLoad = false;
  private int[] lastCurve = new int[256];
  private boolean lastStable = true;
  private int[] mTextures = new int[2];
  
  public FaceColorCombineFilter()
  {
    super("precision mediump float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate;\n}", "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform float exposure;\nuniform int brightness;\n\nvec3 lookupTable(vec3 inputColor) {\n  float blueColor = inputColor.b * 63.0;\n  vec2 quad1; \n  quad1.y = floor(floor(blueColor) / 8.0);\n  quad1.x = floor(blueColor) - (quad1.y * 8.0);\n  vec2 quad2;\n  quad2.y = floor(ceil(blueColor) / 8.0);\n  quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n  vec2 texPos1;\n  texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.r);\n  texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.g);\n  vec2 texPos2;\n  texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.r);\n  texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.g);\n  vec4 newColor1 = texture2D(inputImageTexture3, texPos1);\n  vec4 newColor2 = texture2D(inputImageTexture3, texPos2);\n  vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n  return newColor.rgb;\n}\n\nvoid main() {\n  vec4 color = texture2D(inputImageTexture, textureCoordinate);\n  if (brightness == 1) {\n    color.r = texture2D(inputImageTexture2, vec2(color.r, 0.5)).r;\n    color.g = texture2D(inputImageTexture2, vec2(color.g, 0.5)).r;\n    color.b = texture2D(inputImageTexture2, vec2(color.b, 0.5)).r;\n  }\n  gl_FragColor = vec4(lookupTable(min(vec3(1.0), max(vec3(0.0), color.rgb * exposure))), color.a);\n}\n");
    initParams();
  }
  
  private void loadMaskBitmap()
  {
    if (this.isMaskLoad) {
      return;
    }
    Bitmap localBitmap = FeatureManager.Features.MASK_IMAGES.decodeFaceColorBitmap();
    if (BitmapUtils.isLegal(localBitmap))
    {
      GlUtil.loadTexture(this.facecolorTexture, localBitmap);
      localBitmap.recycle();
      this.isMaskLoad = true;
    }
    addParam(new UniformParam.TextureParam("inputImageTexture3", this.facecolorTexture, 33987));
  }
  
  private void setTextureParam(int paramInt1, int paramInt2)
  {
    paramInt2 += 2;
    String str = "inputImageTexture" + paramInt2;
    int i = GLES20.glGetUniformLocation(getProgramIds(), str);
    if (i >= 0)
    {
      GLES20.glActiveTexture(33984 + paramInt2);
      GLES20.glBindTexture(3553, paramInt1);
      GLES20.glTexParameterf(3553, 10240, 9728.0F);
      GLES20.glTexParameterf(3553, 10241, 9728.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glUniform1i(i, paramInt2);
    }
  }
  
  public void ApplyGLSLFilter()
  {
    if (this.mIsApplied) {
      return;
    }
    super.ApplyGLSLFilter();
    GLES20.glGenTextures(this.mTextures.length, this.mTextures, 0);
    this.curveTexture = this.mTextures[0];
    this.facecolorTexture = this.mTextures[1];
    loadMaskBitmap();
    this.mIsApplied = true;
  }
  
  public void clearGLSLSelf()
  {
    GLES20.glDeleteTextures(this.mTextures.length, this.mTextures, 0);
    super.clearGLSLSelf();
    this.mIsApplied = false;
  }
  
  public void enableBrightness(int paramInt)
  {
    this.enableBrightness = paramInt;
    addParam(new UniformParam.IntParam("brightness", paramInt));
  }
  
  public void initParams()
  {
    int i = 0;
    while (i < 256)
    {
      this.lastCurve[i] = i;
      i += 1;
    }
    addParam(new UniformParam.TextureParam("inputImageTexture3", 0, 33987));
    addParam(new UniformParam.FloatParam("exposure", 1.0F));
    addParam(new UniformParam.IntParam("brightness", 1));
  }
  
  public String printParamInfo()
  {
    return "FaceColorCombineFilter {enableBrightness=" + this.enableBrightness + ", isMaskLoad=" + this.isMaskLoad + '}';
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    loadMaskBitmap();
    setTextureParam(this.curveTexture, 0);
    return super.renderTexture(paramInt1, paramInt2, paramInt3);
  }
  
  public void setExposureValue(float paramFloat)
  {
    if (paramFloat > 50.0F)
    {
      addParam(new UniformParam.FloatParam("exposure", 0.0136F * (paramFloat - 50.0F) + 1.0F));
      return;
    }
    addParam(new UniformParam.FloatParam("exposure", 0.01F * paramFloat + 0.5F));
  }
  
  public void updateCurve(int[] paramArrayOfInt, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    if (paramBoolean)
    {
      this.lastStable = true;
      while (i < 256)
      {
        this.lastCurve[i] = paramArrayOfInt[i];
        i += 1;
      }
    }
    if (paramArrayOfInt[''] == this.lastCurve['']) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if ((this.lastStable) && (!paramBoolean)) {
        this.counter = 5;
      }
      this.lastStable = paramBoolean;
      if (paramBoolean) {
        break;
      }
      this.counter = Math.max(1, this.counter - 1);
      int[] arrayOfInt = new int[256];
      i = j;
      while (i < 256)
      {
        arrayOfInt[i] = ((paramArrayOfInt[i] - this.lastCurve[i]) / this.counter + this.lastCurve[i]);
        this.lastCurve[i] = arrayOfInt[i];
        i += 1;
      }
    }
    GLSLRender.nativeTextCure(this.lastCurve, this.curveTexture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.FaceColorCombineFilter
 * JD-Core Version:    0.7.0.1
 */