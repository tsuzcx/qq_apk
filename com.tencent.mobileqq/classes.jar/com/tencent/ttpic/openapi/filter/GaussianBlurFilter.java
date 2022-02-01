package com.tencent.ttpic.openapi.filter;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.aekit.openrender.util.ProgramTools;
import com.tencent.aekit.openrender.util.ProgramTools.ProgramInfo;
import java.nio.FloatBuffer;

public class GaussianBlurFilter
{
  public static final int FLOAT_SIZE_BYTES = 4;
  private static final String FRAGMENT_SHADER = "precision mediump float;\nuniform sampler2D inputImageTexture;\nvarying highp vec2 textureCoordinate;\nconst lowp int GAUSSIAN_WEIGHT_NUMBERS = 11;\n\nuniform float weight[GAUSSIAN_WEIGHT_NUMBERS]; \nvarying vec2 blurCoordinates[21];\n\nvoid main()\n{\n    lowp vec3 sum = vec3(0.0);\n    lowp vec4 fragColor=texture2D(inputImageTexture,textureCoordinate);\n\n    sum += texture2D(inputImageTexture, textureCoordinate.xy).rgb * weight[0];\n\n    int medium = GAUSSIAN_WEIGHT_NUMBERS - 1;\n    for (int i = 1; i <= medium; i++) {\n        sum += texture2D(inputImageTexture, blurCoordinates[medium + i]).rgb * weight[i];\n        sum += texture2D(inputImageTexture, blurCoordinates[medium - i]).rgb * weight[i];\n    }\n\n    gl_FragColor = vec4(sum,fragColor.a);\n}";
  private static final FloatBuffer TEXTURE_BUF = GlUtil.createFloatBuffer(TEXUTURE_COORDS);
  public static final float[] TEXUTURE_COORDS;
  private static final FloatBuffer VERTEXT_BUF;
  public static final float[] VERTEXT_COORDS = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static final String VERTEXT_SHADER = "attribute vec4 aPosition;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nuniform float hOffset;\nuniform float vOffset;\n\nconst int GAUSSIAN_VERTICAL_SAMPLES = 21;\nvarying vec2 blurCoordinates[21];\n\nvoid main()\n{\n    gl_Position = aPosition;\n    textureCoordinate = inputTextureCoordinate.xy;\n    // Calculate the positions for the blur\n    int multiplier = 0;\n    vec2 blurStep;\n    vec2 singleStepOffset = vec2(hOffset, vOffset);\n    for (int i = 0; i < GAUSSIAN_VERTICAL_SAMPLES; i++) {\n        multiplier = (i - ((GAUSSIAN_VERTICAL_SAMPLES - 1) / 2));\n        blurStep = float(multiplier) * singleStepOffset;\n        blurCoordinates[i] = inputTextureCoordinate.xy + blurStep;\n    }\n}";
  private float horizontalRadiusRatio = 1.0F;
  private boolean mIsInitialized;
  private float mOutputHeight;
  private float mOutputWidth;
  private int mProgram;
  public int mTextureType = 3553;
  private float[] mWeights;
  private float verticalRadiusRatio = 1.0F;
  
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
  
  public void drawTexture(int paramInt)
  {
    if (this.mProgram == 0) {}
    do
    {
      return;
      int i = this.mProgram;
      GLES20.glUseProgram(i);
      int j = GLES20.glGetAttribLocation(i, "aPosition");
      int k = GLES20.glGetAttribLocation(i, "inputTextureCoordinate");
      GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, VERTEXT_BUF);
      GLES20.glEnableVertexAttribArray(j);
      GLES20.glVertexAttribPointer(k, 2, 5126, false, 8, TEXTURE_BUF);
      GLES20.glEnableVertexAttribArray(k);
      GLES20.glUniform1fv(GLES20.glGetUniformLocation(i, "weight"), this.mWeights.length, this.mWeights, 0);
      j = GLES20.glGetUniformLocation(i, "hOffset");
      k = GLES20.glGetUniformLocation(i, "vOffset");
      GLES20.glUniform1f(j, this.horizontalRadiusRatio / this.mOutputWidth);
      GLES20.glUniform1f(k, this.verticalRadiusRatio / this.mOutputHeight);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(this.mTextureType, paramInt);
      GLES20.glUniform1i(GLES20.glGetUniformLocation(i, "inputImageTexture"), 0);
      GLES20.glDrawArrays(5, 0, 4);
      paramInt = GLES20.glGetError();
    } while (paramInt == 0);
    throw new RuntimeException("error =" + paramInt);
  }
  
  public void init(int paramInt1, int paramInt2)
  {
    if (this.mIsInitialized) {
      return;
    }
    ProgramTools.ProgramInfo localProgramInfo = ProgramTools.createProgram("attribute vec4 aPosition;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nuniform float hOffset;\nuniform float vOffset;\n\nconst int GAUSSIAN_VERTICAL_SAMPLES = 21;\nvarying vec2 blurCoordinates[21];\n\nvoid main()\n{\n    gl_Position = aPosition;\n    textureCoordinate = inputTextureCoordinate.xy;\n    // Calculate the positions for the blur\n    int multiplier = 0;\n    vec2 blurStep;\n    vec2 singleStepOffset = vec2(hOffset, vOffset);\n    for (int i = 0; i < GAUSSIAN_VERTICAL_SAMPLES; i++) {\n        multiplier = (i - ((GAUSSIAN_VERTICAL_SAMPLES - 1) / 2));\n        blurStep = float(multiplier) * singleStepOffset;\n        blurCoordinates[i] = inputTextureCoordinate.xy + blurStep;\n    }\n}", "precision mediump float;\nuniform sampler2D inputImageTexture;\nvarying highp vec2 textureCoordinate;\nconst lowp int GAUSSIAN_WEIGHT_NUMBERS = 11;\n\nuniform float weight[GAUSSIAN_WEIGHT_NUMBERS]; \nvarying vec2 blurCoordinates[21];\n\nvoid main()\n{\n    lowp vec3 sum = vec3(0.0);\n    lowp vec4 fragColor=texture2D(inputImageTexture,textureCoordinate);\n\n    sum += texture2D(inputImageTexture, textureCoordinate.xy).rgb * weight[0];\n\n    int medium = GAUSSIAN_WEIGHT_NUMBERS - 1;\n    for (int i = 1; i <= medium; i++) {\n        sum += texture2D(inputImageTexture, blurCoordinates[medium + i]).rgb * weight[i];\n        sum += texture2D(inputImageTexture, blurCoordinates[medium - i]).rgb * weight[i];\n    }\n\n    gl_FragColor = vec4(sum,fragColor.a);\n}");
    if (localProgramInfo == null)
    {
      new RuntimeException("failed creating program " + getClass().getSimpleName()).printStackTrace();
      return;
    }
    this.mProgram = localProgramInfo.programId;
    this.mOutputWidth = paramInt1;
    this.mOutputHeight = paramInt2;
    this.mIsInitialized = true;
  }
  
  public boolean isInitSucc()
  {
    return this.mProgram != 0;
  }
  
  public void setStepRatio(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2)
  {
    this.horizontalRadiusRatio = paramFloat1;
    this.verticalRadiusRatio = paramFloat2;
    if (paramArrayOfFloat != null) {
      this.mWeights = paramArrayOfFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.GaussianBlurFilter
 * JD-Core Version:    0.7.0.1
 */