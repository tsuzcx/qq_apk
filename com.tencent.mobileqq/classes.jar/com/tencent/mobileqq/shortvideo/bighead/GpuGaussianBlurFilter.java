package com.tencent.mobileqq.shortvideo.bighead;

import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import java.nio.FloatBuffer;

public class GpuGaussianBlurFilter
{
  public static final int FLOAT_SIZE_BYTES = 4;
  public static final String FRAGMENT_SHADER_3 = "const lowp int GAUSSIAN_SAMPLES = 9;\nuniform sampler2D inputImageTexture;\nuniform lowp float weight[GAUSSIAN_SAMPLES]; \n\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n\nvoid main()\n{\n\t lowp vec3 sum = vec3(0.0);\n   lowp vec4 fragColor=texture2D(inputImageTexture,textureCoordinate);\n\t\n    for (int i = 0; i < GAUSSIAN_SAMPLES; i++) {\n        sum += texture2D(inputImageTexture, blurCoordinates[i]).rgb * weight[i];\n    }\n\n    if(sum.r >= 0.79){\n\t      gl_FragColor = vec4(1.0,sum.gb,fragColor.a);\n    }else{\n         gl_FragColor = vec4(0.0,sum.gb,fragColor.a);\n    }\n}";
  public static final FloatBuffer TEXTURE_BUF = GlUtil.createFloatBuffer(TEXUTURE_COORDS);
  public static final float[] TEXUTURE_COORDS;
  public static final FloatBuffer VERTEXT_BUF;
  public static final float[] VERTEXT_COORDS = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  public static final String VERTEX_SHADER_3 = "precision highp float;\nattribute vec4 aPosition;\nattribute vec4 inputTextureCoordinate;\nconst int GAUSSIAN_SAMPLES = 9;\n\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\nuniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\n\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n\nvoid main()\n{\n\tgl_Position = uMVPMatrix * aPosition;\n\ttextureCoordinate = (uTextureMatrix * inputTextureCoordinate).xy;\n\tblurCoordinates[0] = textureCoordinate.xy + vec2(-texelWidthOffset,-texelHeightOffset);\n\tblurCoordinates[1] = textureCoordinate.xy + vec2(0,-texelHeightOffset);\n\tblurCoordinates[2] = textureCoordinate.xy + vec2(texelWidthOffset,-texelHeightOffset);\n\tblurCoordinates[3] = textureCoordinate.xy + vec2(-texelWidthOffset,0);\n\tblurCoordinates[4] = textureCoordinate.xy + vec2(0,0);\n\tblurCoordinates[5] = textureCoordinate.xy + vec2(texelWidthOffset,0);\n\tblurCoordinates[6] = textureCoordinate.xy + vec2(-texelWidthOffset,texelHeightOffset);\n\tblurCoordinates[7] = textureCoordinate.xy + vec2(0,texelHeightOffset);\n\tblurCoordinates[8] = textureCoordinate.xy + vec2(texelWidthOffset,texelHeightOffset);\n}\n";
  private float mHeightStepRatio = 1.0F;
  private boolean mIsInitialized;
  private float mOutputHeight;
  private float mOutputWidth;
  private int mProgram;
  public int mTextureType = 3553;
  private float[] mWeights;
  private float mWidthStepRatio = 1.0F;
  
  static
  {
    TEXUTURE_COORDS = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
    VERTEXT_BUF = GlUtil.createFloatBuffer(VERTEXT_COORDS);
  }
  
  public void destroy()
  {
    if (this.mIsInitialized)
    {
      this.mIsInitialized = false;
      GLES20.glDeleteProgram(this.mProgram);
      this.mProgram = 0;
    }
  }
  
  public void drawTexture(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    int i = this.mProgram;
    float[] arrayOfFloat = paramArrayOfFloat1;
    if (paramArrayOfFloat1 == null) {
      arrayOfFloat = BigHeadBuckler.sGIdentity;
    }
    paramArrayOfFloat1 = paramArrayOfFloat2;
    if (paramArrayOfFloat2 == null) {
      paramArrayOfFloat1 = BigHeadBuckler.sGIdentity;
    }
    GLES20.glUseProgram(i);
    int j = GLES20.glGetAttribLocation(i, "aPosition");
    int k = GLES20.glGetAttribLocation(i, "inputTextureCoordinate");
    int m = GLES20.glGetUniformLocation(i, "uMVPMatrix");
    int n = GLES20.glGetUniformLocation(i, "uTextureMatrix");
    GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, VERTEXT_BUF);
    GLES20.glEnableVertexAttribArray(j);
    GLES20.glVertexAttribPointer(k, 2, 5126, false, 8, TEXTURE_BUF);
    GLES20.glEnableVertexAttribArray(k);
    GLES20.glUniformMatrix4fv(m, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(n, 1, false, arrayOfFloat, 0);
    GLES20.glUniform1fv(GLES20.glGetUniformLocation(i, "weight"), this.mWeights.length, this.mWeights, 0);
    j = GLES20.glGetUniformLocation(i, "texelWidthOffset");
    k = GLES20.glGetUniformLocation(i, "texelHeightOffset");
    GLES20.glUniform1f(j, this.mWidthStepRatio / this.mOutputWidth);
    GLES20.glUniform1f(k, this.mHeightStepRatio / this.mOutputHeight);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.mTextureType, paramInt);
    GLES20.glUniform1i(GLES20.glGetUniformLocation(i, "inputImageTexture"), 0);
    GLES20.glDrawArrays(5, 0, 4);
    paramInt = GLES20.glGetError();
    if (paramInt != 0) {
      throw new RuntimeException("error =" + paramInt);
    }
  }
  
  public void init(int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    if (this.mIsInitialized) {
      return;
    }
    this.mWeights = paramArrayOfFloat;
    this.mProgram = GlUtil.createProgram("precision highp float;\nattribute vec4 aPosition;\nattribute vec4 inputTextureCoordinate;\nconst int GAUSSIAN_SAMPLES = 9;\n\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\nuniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\n\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n\nvoid main()\n{\n\tgl_Position = uMVPMatrix * aPosition;\n\ttextureCoordinate = (uTextureMatrix * inputTextureCoordinate).xy;\n\tblurCoordinates[0] = textureCoordinate.xy + vec2(-texelWidthOffset,-texelHeightOffset);\n\tblurCoordinates[1] = textureCoordinate.xy + vec2(0,-texelHeightOffset);\n\tblurCoordinates[2] = textureCoordinate.xy + vec2(texelWidthOffset,-texelHeightOffset);\n\tblurCoordinates[3] = textureCoordinate.xy + vec2(-texelWidthOffset,0);\n\tblurCoordinates[4] = textureCoordinate.xy + vec2(0,0);\n\tblurCoordinates[5] = textureCoordinate.xy + vec2(texelWidthOffset,0);\n\tblurCoordinates[6] = textureCoordinate.xy + vec2(-texelWidthOffset,texelHeightOffset);\n\tblurCoordinates[7] = textureCoordinate.xy + vec2(0,texelHeightOffset);\n\tblurCoordinates[8] = textureCoordinate.xy + vec2(texelWidthOffset,texelHeightOffset);\n}\n", "const lowp int GAUSSIAN_SAMPLES = 9;\nuniform sampler2D inputImageTexture;\nuniform lowp float weight[GAUSSIAN_SAMPLES]; \n\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n\nvoid main()\n{\n\t lowp vec3 sum = vec3(0.0);\n   lowp vec4 fragColor=texture2D(inputImageTexture,textureCoordinate);\n\t\n    for (int i = 0; i < GAUSSIAN_SAMPLES; i++) {\n        sum += texture2D(inputImageTexture, blurCoordinates[i]).rgb * weight[i];\n    }\n\n    if(sum.r >= 0.79){\n\t      gl_FragColor = vec4(1.0,sum.gb,fragColor.a);\n    }else{\n         gl_FragColor = vec4(0.0,sum.gb,fragColor.a);\n    }\n}");
    if (paramArrayOfFloat.length != 9) {
      throw new RuntimeException("参数错误");
    }
    if (this.mProgram == 0) {
      new RuntimeException("failed creating program " + getClass().getSimpleName()).printStackTrace();
    }
    this.mOutputWidth = paramInt1;
    this.mOutputHeight = paramInt2;
    this.mIsInitialized = true;
  }
  
  public void setStepRatio(float paramFloat1, float paramFloat2)
  {
    this.mWidthStepRatio = paramFloat1;
    this.mHeightStepRatio = paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.bighead.GpuGaussianBlurFilter
 * JD-Core Version:    0.7.0.1
 */