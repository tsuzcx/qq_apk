package com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.util.GlUtil;

public class RenderBuffer
{
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = true;
  private int b = 0;
  private int c = 0;
  private int d;
  private int e;
  
  public RenderBuffer(int paramInt1, int paramInt2, int paramInt3)
  {
    this(true, paramInt1, paramInt2, paramInt3);
  }
  
  private RenderBuffer(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.d = paramInt1;
    this.e = paramInt2;
    this.jdField_a_of_type_Boolean = paramBoolean;
    GLES20.glActiveTexture(paramInt3);
    this.jdField_a_of_type_Int = GlUtil.createTexture(3553);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    this.c = arrayOfInt[0];
    GLES20.glBindFramebuffer(36160, this.c);
    if (paramBoolean)
    {
      GLES20.glGenRenderbuffers(1, arrayOfInt, 0);
      this.b = arrayOfInt[0];
      GLES20.glBindRenderbuffer(36161, this.b);
      GLES20.glRenderbufferStorage(36161, 33189, paramInt1, paramInt2);
    }
    b();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    GLES20.glViewport(0, 0, this.d, this.e);
    GLES20.glBindFramebuffer(36160, this.c);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.jdField_a_of_type_Int, 0);
    if (this.jdField_a_of_type_Boolean) {
      GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.b);
    }
  }
  
  public void b()
  {
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public void c()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.c;
    GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
    if (this.jdField_a_of_type_Boolean)
    {
      arrayOfInt[0] = this.b;
      GLES20.glDeleteRenderbuffers(1, arrayOfInt, 0);
    }
    if (this.jdField_a_of_type_Int > 0) {
      GlUtil.deleteTexture(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic.RenderBuffer
 * JD-Core Version:    0.7.0.1
 */