package com.tencent.qqcamerakit.preview;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.qqcamerakit.common.QLog;
import java.nio.FloatBuffer;

public class GPUBaseFilter
{
  private static final FloatBuffer jdField_a_of_type_JavaNioFloatBuffer = GlUtil.a(jdField_a_of_type_ArrayOfFloat);
  public static float[] a;
  public static final float[] b;
  public int a;
  private final String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  protected int b;
  private final String jdField_b_of_type_JavaLangString;
  private FloatBuffer jdField_b_of_type_JavaNioFloatBuffer = GlUtil.a(jdField_b_of_type_ArrayOfFloat);
  private int c;
  
  static
  {
    jdField_a_of_type_ArrayOfFloat = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
    jdField_b_of_type_ArrayOfFloat = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  }
  
  public GPUBaseFilter()
  {
    this("uniform mat4 uMVPMatrix;\nuniform mat4 uTextureMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n    gl_Position = uMVPMatrix * aPosition;\n    vTextureCoord = (uTextureMatrix * aTextureCoord).xy;\n}\n", "precision mediump float;\n\nvarying vec2 vTextureCoord;\nuniform sampler2D uTexture;\n\nvoid main() {\n    gl_FragColor = texture2D(uTexture, vTextureCoord);\n}\n");
  }
  
  public GPUBaseFilter(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = 3553;
    this.jdField_b_of_type_Int = 101;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = 3553;
    this.jdField_b_of_type_Int = 101;
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (paramInt < 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to locate '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("' in program");
      QLog.a("GPUBaseFilter", 1, new RuntimeException(localStringBuilder.toString()), new Object[0]);
    }
  }
  
  public static void a(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError ");
      localStringBuilder.append(i);
      QLog.a("GPUBaseFilter", 1, new RuntimeException(localStringBuilder.toString()), new Object[0]);
    }
  }
  
  public static float[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = paramInt3;
    float f2 = paramInt4;
    float f3 = f1 / f2;
    float f4 = paramInt1 / paramInt2;
    if (f3 < f4)
    {
      f1 = f4 * f2 / f1;
    }
    else
    {
      if (f3 > f4)
      {
        f2 = f1 / (f4 * f2);
        f1 = 1.0F;
        break label73;
      }
      f1 = 1.0F;
    }
    f2 = 1.0F;
    label73:
    float[] arrayOfFloat = new float[16];
    Matrix.setIdentityM(arrayOfFloat, 0);
    Matrix.scaleM(arrayOfFloat, 0, f1, f2, 1.0F);
    return arrayOfFloat;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.c = GlUtil.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    if (this.c == 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed creating program ");
      localStringBuilder.append(getClass().getSimpleName());
      QLog.a("GPUBaseFilter", 1, new RuntimeException(localStringBuilder.toString()), new Object[0]);
    }
    this.jdField_a_of_type_Boolean = true;
    b();
  }
  
  public void a(int paramInt, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    a("onDrawFrame start");
    int m = a();
    float[] arrayOfFloat = paramArrayOfFloat1;
    if (paramArrayOfFloat1 == null)
    {
      arrayOfFloat = new float[16];
      Matrix.setIdentityM(arrayOfFloat, 0);
    }
    paramArrayOfFloat1 = paramArrayOfFloat2;
    if (paramArrayOfFloat2 == null)
    {
      paramArrayOfFloat1 = new float[16];
      Matrix.setIdentityM(paramArrayOfFloat1, 0);
    }
    GLES20.glUseProgram(m);
    a("glUseProgram");
    int i = GLES20.glGetAttribLocation(m, "aPosition");
    a(i, "aPosition");
    int j = GLES20.glGetAttribLocation(m, "aTextureCoord");
    a(j, "aTextureCoord");
    int k = GLES20.glGetUniformLocation(m, "uMVPMatrix");
    a(k, "uMVPMatrix");
    m = GLES20.glGetUniformLocation(m, "uTextureMatrix");
    a(m, "uTextureMatrix");
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 8, jdField_a_of_type_JavaNioFloatBuffer);
    a("glVertexAttribPointer aPosition");
    GLES20.glEnableVertexAttribArray(i);
    a("glEnableVertexAttribArray mPositionHandle");
    GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, this.jdField_b_of_type_JavaNioFloatBuffer);
    a("glVertexAttribPointer mTextureHandle");
    GLES20.glEnableVertexAttribArray(j);
    a("glEnableVertexAttribArray mTextureHandle");
    GLES20.glUniformMatrix4fv(k, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(m, 1, false, arrayOfFloat, 0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.jdField_a_of_type_Int, paramInt);
    c();
    GLES20.glDrawArrays(5, 0, 4);
    a("glDrawArrays");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.jdField_a_of_type_Int, 0);
  }
  
  protected void b() {}
  
  protected void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqcamerakit.preview.GPUBaseFilter
 * JD-Core Version:    0.7.0.1
 */