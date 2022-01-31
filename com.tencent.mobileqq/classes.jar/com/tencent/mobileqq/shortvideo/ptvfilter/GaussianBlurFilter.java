package com.tencent.mobileqq.shortvideo.ptvfilter;

import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import java.nio.FloatBuffer;

public class GaussianBlurFilter
{
  private static final FloatBuffer jdField_a_of_type_JavaNioFloatBuffer = GlUtil.a(jdField_a_of_type_ArrayOfFloat);
  public static final float[] a;
  private static final FloatBuffer jdField_b_of_type_JavaNioFloatBuffer = GlUtil.a(jdField_b_of_type_ArrayOfFloat);
  public static final float[] b;
  private float jdField_a_of_type_Float;
  public int a;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float jdField_c_of_type_Float = 1.0F;
  private float[] jdField_c_of_type_ArrayOfFloat;
  private float d = 1.0F;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    jdField_b_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  }
  
  public GaussianBlurFilter()
  {
    this.jdField_a_of_type_Int = 3553;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_b_of_type_Int == 0) {}
    do
    {
      return;
      int i = this.jdField_b_of_type_Int;
      GLES20.glUseProgram(i);
      int j = GLES20.glGetAttribLocation(i, "aPosition");
      int k = GLES20.glGetAttribLocation(i, "inputTextureCoordinate");
      GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, jdField_a_of_type_JavaNioFloatBuffer);
      GLES20.glEnableVertexAttribArray(j);
      GLES20.glVertexAttribPointer(k, 2, 5126, false, 8, jdField_b_of_type_JavaNioFloatBuffer);
      GLES20.glEnableVertexAttribArray(k);
      GLES20.glUniform1fv(GLES20.glGetUniformLocation(i, "weight"), this.jdField_c_of_type_ArrayOfFloat.length, this.jdField_c_of_type_ArrayOfFloat, 0);
      j = GLES20.glGetUniformLocation(i, "hOffset");
      k = GLES20.glGetUniformLocation(i, "vOffset");
      GLES20.glUniform1f(j, this.jdField_c_of_type_Float / this.jdField_a_of_type_Float);
      GLES20.glUniform1f(k, this.d / this.jdField_b_of_type_Float);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(this.jdField_a_of_type_Int, paramInt);
      GLES20.glUniform1i(GLES20.glGetUniformLocation(i, "inputImageTexture"), 0);
      GLES20.glDrawArrays(5, 0, 4);
      paramInt = GLES20.glGetError();
    } while (paramInt == 0);
    throw new RuntimeException("error =" + paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Int = GlUtil.a("attribute vec4 aPosition;\nattribute vec4 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\n\nuniform float hOffset;\nuniform float vOffset;\n\nconst int GAUSSIAN_VERTICAL_SAMPLES = 21;\nvarying vec2 blurCoordinates[21];\n\nvoid main()\n{\n    gl_Position = aPosition;\n    textureCoordinate = inputTextureCoordinate.xy;\n    // Calculate the positions for the blur\n    int multiplier = 0;\n    vec2 blurStep;\n    vec2 singleStepOffset = vec2(hOffset, vOffset);\n    for (int i = 0; i < GAUSSIAN_VERTICAL_SAMPLES; i++) {\n        multiplier = (i - ((GAUSSIAN_VERTICAL_SAMPLES - 1) / 2));\n        blurStep = float(multiplier) * singleStepOffset;\n        blurCoordinates[i] = inputTextureCoordinate.xy + blurStep;\n    }\n}", "precision mediump float;\nuniform sampler2D inputImageTexture;\nvarying highp vec2 textureCoordinate;\nconst lowp int GAUSSIAN_WEIGHT_NUMBERS = 11;\n\nuniform float weight[GAUSSIAN_WEIGHT_NUMBERS]; \nvarying vec2 blurCoordinates[21];\n\nvoid main()\n{\n    lowp vec3 sum = vec3(0.0);\n    lowp vec4 fragColor=texture2D(inputImageTexture,textureCoordinate);\n\n    sum += texture2D(inputImageTexture, textureCoordinate.xy).rgb * weight[0];\n\n    int medium = GAUSSIAN_WEIGHT_NUMBERS - 1;\n    for (int i = 1; i <= medium; i++) {\n        sum += texture2D(inputImageTexture, blurCoordinates[medium + i]).rgb * weight[i];\n        sum += texture2D(inputImageTexture, blurCoordinates[medium - i]).rgb * weight[i];\n    }\n\n    gl_FragColor = vec4(sum,fragColor.a);\n}");
    if (this.jdField_b_of_type_Int == 0) {
      new RuntimeException("failed creating program " + getClass().getSimpleName()).printStackTrace();
    }
    this.jdField_a_of_type_Float = paramInt1;
    this.jdField_b_of_type_Float = paramInt2;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2)
  {
    this.jdField_c_of_type_Float = paramFloat1;
    this.d = paramFloat2;
    if (paramArrayOfFloat != null) {
      this.jdField_c_of_type_ArrayOfFloat = paramArrayOfFloat;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Int != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ptvfilter.GaussianBlurFilter
 * JD-Core Version:    0.7.0.1
 */