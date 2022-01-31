package com.tencent.mobileqq.shortvideo.videotransfer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import java.nio.FloatBuffer;

public class TransferInstFilter
  extends GPUBaseFilter
{
  private static final FloatBuffer a;
  private static final FloatBuffer b;
  private float[] c;
  private float[] d;
  private int e = -1;
  private int f = -1;
  private int g = -1;
  private int h = -1;
  private int i = -1;
  private int j = -1;
  private int k = -1;
  private int l = -1;
  private int m = -1;
  private int n = -1;
  private int o = 0;
  private int p = 0;
  private int q = 0;
  
  static
  {
    jdField_a_of_type_JavaNioFloatBuffer = GlUtil.a(jdField_a_of_type_ArrayOfFloat);
    jdField_b_of_type_JavaNioFloatBuffer = GlUtil.a(jdField_b_of_type_ArrayOfFloat);
  }
  
  public TransferInstFilter(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.o = paramInt3;
    this.p = paramInt1;
    this.q = paramInt2;
  }
  
  public boolean a(int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((this.o > this.q) || (this.o < this.p)) {}
    float[] arrayOfFloat;
    int i1;
    do
    {
      return false;
      a("onDrawFrame start");
      arrayOfFloat = paramArrayOfFloat1;
      if (paramArrayOfFloat1 == null) {
        arrayOfFloat = this.jdField_c_of_type_ArrayOfFloat;
      }
      paramArrayOfFloat1 = paramArrayOfFloat2;
      if (paramArrayOfFloat2 == null) {
        paramArrayOfFloat1 = this.d;
      }
      i1 = a();
    } while (i1 <= 0);
    GLES20.glUseProgram(i1);
    GLES20.glVertexAttribPointer(this.e, 2, 5126, false, 8, jdField_a_of_type_JavaNioFloatBuffer);
    a("glVertexAttribPointer mAttrPosition");
    GLES20.glEnableVertexAttribArray(this.e);
    a("glEnableVertexAttribArray mAttrPosition");
    GLES20.glVertexAttribPointer(this.f, 2, 5126, false, 8, jdField_b_of_type_JavaNioFloatBuffer);
    a("glVertexAttribPointer mAttrTextureCoord");
    GLES20.glEnableVertexAttribArray(this.f);
    a("glEnableVertexAttribArray mAttrTextureCoord");
    if (this.g >= 0)
    {
      GLES20.glUniformMatrix4fv(this.g, 1, false, paramArrayOfFloat1, 0);
      a("glUniformMatrix4fv mAttrMVPMatrix");
    }
    if (this.h >= 0)
    {
      GLES20.glUniformMatrix4fv(this.h, 1, false, arrayOfFloat, 0);
      a("glUniformMatrix4fv mAttrTextureMatrix");
    }
    if (paramInt1 >= 0)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(this.jdField_c_of_type_Int, paramInt1);
      GLES20.glUniform1i(this.i, 0);
    }
    if (paramInt2 >= 0)
    {
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(this.jdField_c_of_type_Int, paramInt2);
      GLES20.glUniform1i(this.j, 1);
    }
    GLES20.glUniform2f(this.k, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    a("glUniform2f mUniInputTextureSize");
    GLES20.glUniform2f(this.l, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    a("glUniform2f mUniInputTexture2Size");
    GLES20.glUniform1f(this.n, this.o);
    a("glUniform2f mUniCurrentTime");
    GLES20.glUniform2f(this.m, this.p, this.q - this.p);
    a("glUniform2f mUniTimeRange");
    f();
    GLES20.glDrawArrays(5, 0, 4);
    a("glDrawArrays");
    GLES20.glDisableVertexAttribArray(this.e);
    GLES20.glDisableVertexAttribArray(this.f);
    if (paramInt2 >= 0)
    {
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(this.jdField_c_of_type_Int, 0);
    }
    if (paramInt1 >= 0)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(this.jdField_c_of_type_Int, 0);
    }
    return true;
  }
  
  protected void c()
  {
    this.jdField_c_of_type_ArrayOfFloat = new float[16];
    Matrix.setIdentityM(this.jdField_c_of_type_ArrayOfFloat, 0);
    this.d = new float[16];
    Matrix.setIdentityM(this.d, 0);
    int i1 = a();
    if (i1 <= 0) {
      return;
    }
    GLES20.glUseProgram(i1);
    this.e = GLES20.glGetAttribLocation(i1, "position");
    a(this.e, "position");
    this.f = GLES20.glGetAttribLocation(i1, "inputTextureCoordinate");
    a(this.f, "inputTextureCoordinate");
    this.g = GLES20.glGetUniformLocation(i1, "uMVPMatrix");
    a(this.g, "uMVPMatrix");
    this.h = GLES20.glGetUniformLocation(i1, "uTextureMatrix");
    a(this.h, "uTextureMatrix");
    this.i = GLES20.glGetUniformLocation(i1, "inputImageTexture");
    a(this.i, "inputImageTexture");
    this.j = GLES20.glGetUniformLocation(i1, "inputImageTexture2");
    a(this.j, "inputImageTexture2");
    this.k = GLES20.glGetUniformLocation(i1, "inputImageTextureSize");
    a(this.k, "inputImageTextureSize");
    this.l = GLES20.glGetUniformLocation(i1, "inputImageTexture2Size");
    a(this.l, "inputImageTexture2Size");
    this.m = GLES20.glGetUniformLocation(i1, "timeRange");
    a(this.m, "timeRange");
    this.n = GLES20.glGetUniformLocation(i1, "time");
    a(this.n, "time");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.videotransfer.TransferInstFilter
 * JD-Core Version:    0.7.0.1
 */