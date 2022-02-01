package com.tencent.tavkit.ciimage;

import android.graphics.Matrix;
import android.opengl.GLES20;
import com.tencent.tav.coremedia.TextureInfo;

public class GaosiBlurFilter
  extends BaseEffect
{
  private String FRAGMENT_SHADER = "uTexture;\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform int uRadius;\nuniform float uWidthOffset;\nuniform float uHeightOffset;\nmediump float getGaussWeight(mediump float currentPos, mediump float sigma) {\n    return 1.0 / sigma * exp(-(currentPos * currentPos) / (2.0 * sigma * sigma));\n}\nvoid main() {\n" + getGaussianSampleCode() + "}";
  private int heightOffsetHandle;
  protected boolean horizontal;
  private int radius;
  private int radiusHandle;
  private int widthOffsetHandle;
  
  public GaosiBlurFilter(boolean paramBoolean, int paramInt)
  {
    this.horizontal = paramBoolean;
    this.radius = paramInt;
  }
  
  private String getBoxSampleCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("   int diameter = 2 * uRadius + 1; \n").append("   vec4 sampleTex;\n").append("   vec3 col = vec3(0.0, 0.0, 0.0);  \n").append("   float weightSum = 0.0; \n").append("   for(int i = 0; i < diameter; i++) {\n").append("       vec2 offset = vec2(float(i - uRadius) * uWidthOffset, float(i - uRadius) * uHeightOffset);  \n").append("       sampleTex = vec4(texture2D(uTexture, vTextureCoord.st+offset));\n").append("       float index = float(i); \n").append("       float boxWeight = float(1.0) / float(diameter); \n").append("       col += sampleTex.rgb * boxWeight; \n").append("       weightSum += boxWeight;\n").append("   }   \n").append("   gl_FragColor = vec4(col / weightSum, sampleTex.a);   \n");
    return localStringBuilder.toString();
  }
  
  private String getGaussianSampleCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("   int diameter = 2 * uRadius + 1;  \n").append("   vec4 sampleTex;\n").append("   vec3 col = vec3(0.0, 0.0, 0.0);  \n").append("   float weightSum = 0.0; \n").append("   for(int i = 0; i < diameter; i++) {\n").append("       vec2 offset = vec2(float(i - uRadius) * uWidthOffset, float(i - uRadius) * uHeightOffset);  \n").append("       sampleTex = vec4(texture2D(uTexture, vTextureCoord.st+offset));\n").append("       float index = float(i); \n").append("       float gaussWeight = getGaussWeight(index - float(diameter - 1)/2.0,").append("           (float(diameter - 1)/2.0 + 1.0) / 2.0); \n").append("       col += sampleTex.rgb * gaussWeight; \n").append("       weightSum += gaussWeight;\n").append("   }   \n").append("   gl_FragColor = vec4(col / weightSum, sampleTex.a);   \n");
    return localStringBuilder.toString();
  }
  
  private String getStackSampleCode()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("int diameter = 2 * uRadius + 1;  \n").append("   vec4 sampleTex;\n").append("   vec3 col = vec3(0.0, 0.0, 0.0);  \n").append("   float weightSum = 0.0; \n").append("   for(int i = 0; i < diameter; i++) {\n").append("       vec2 offset = vec2(float(i - uRadius) * uWidthOffset, float(i - uRadius) * uHeightOffset);  \n").append("       sampleTex = vec4(texture2D(uTexture, vTextureCoord.st+offset));\n").append("       float index = float(i); \n").append("       float boxWeight = float(uRadius) + 1.0 - abs(index - float(uRadius)); \n").append("       col += sampleTex.rgb * boxWeight; \n").append("       weightSum += boxWeight;\n").append("   }   \n").append("   gl_FragColor = vec4(col / weightSum, sampleTex.a);   \n");
    return localStringBuilder.toString();
  }
  
  protected void beforeDraw(TextureInfo paramTextureInfo)
  {
    float f2 = 0.0F;
    GLES20.glUniform1i(this.radiusHandle, this.radius);
    int i = this.widthOffsetHandle;
    if (this.horizontal) {}
    for (float f1 = 0.0F;; f1 = 1.0F / paramTextureInfo.width)
    {
      GLES20.glUniform1f(i, f1);
      i = this.heightOffsetHandle;
      f1 = f2;
      if (this.horizontal) {
        f1 = 1.0F / paramTextureInfo.height;
      }
      GLES20.glUniform1f(i, f1);
      return;
    }
  }
  
  protected String getFragmentShaderCode(TextureInfo paramTextureInfo)
  {
    if (paramTextureInfo.textureType == 36197) {
      return " #extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES " + this.FRAGMENT_SHADER;
    }
    return "uniform sampler2D " + this.FRAGMENT_SHADER;
  }
  
  protected void initShader(TextureInfo paramTextureInfo)
  {
    super.initShader(paramTextureInfo);
    this.radiusHandle = GLES20.glGetUniformLocation(this.program, "uRadius");
    this.widthOffsetHandle = GLES20.glGetUniformLocation(this.program, "uWidthOffset");
    this.heightOffsetHandle = GLES20.glGetUniformLocation(this.program, "uHeightOffset");
  }
  
  public void scale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.xyMatrix == null) {
      this.xyMatrix = new Matrix();
    }
    this.xyMatrix.reset();
    this.xyMatrix.setScale(paramFloat1, paramFloat1);
    this.xyMatrix.postTranslate(paramFloat2, paramFloat3);
  }
  
  public void setRadius(int paramInt)
  {
    this.radius = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.GaosiBlurFilter
 * JD-Core Version:    0.7.0.1
 */