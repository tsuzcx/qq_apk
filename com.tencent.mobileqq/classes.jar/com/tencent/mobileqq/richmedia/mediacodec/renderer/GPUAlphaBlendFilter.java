package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import java.nio.FloatBuffer;

public class GPUAlphaBlendFilter
  extends GPUBaseFilter
{
  private static final FloatBuffer a;
  private static final FloatBuffer b;
  
  static
  {
    jdField_a_of_type_JavaNioFloatBuffer = GlUtil.a(jdField_a_of_type_ArrayOfFloat);
    jdField_b_of_type_JavaNioFloatBuffer = GlUtil.a(jdField_b_of_type_ArrayOfFloat);
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
    GLES20.glVertexAttribPointer(j, 2, 5126, false, 8, jdField_b_of_type_JavaNioFloatBuffer);
    a("glVertexAttribPointer mTextureHandle");
    GLES20.glEnableVertexAttribArray(j);
    a("glEnableVertexAttribArray mTextureHandle");
    GLES20.glUniformMatrix4fv(k, 1, false, paramArrayOfFloat1, 0);
    GLES20.glUniformMatrix4fv(m, 1, false, arrayOfFloat, 0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.c, paramInt);
    f();
    GLES20.glEnable(3042);
    GLES20.glBlendFunc(1, 771);
    GLES20.glDrawArrays(5, 0, 4);
    a("glDrawArrays");
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(this.c, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUAlphaBlendFilter
 * JD-Core Version:    0.7.0.1
 */