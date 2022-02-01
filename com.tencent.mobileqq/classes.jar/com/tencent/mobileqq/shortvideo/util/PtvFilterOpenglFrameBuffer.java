package com.tencent.mobileqq.shortvideo.util;

import android.opengl.GLES20;

public class PtvFilterOpenglFrameBuffer
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[1];
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt = new int[1];
  private int[] c = new int[1];
  private int[] d = new int[1];
  
  public static void a(String paramString) {}
  
  private void d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      GLES20.glGenRenderbuffers(1, this.c, 0);
      a("glGenRenderbuffers:Depth");
      GLES20.glBindRenderbuffer(36161, this.c[0]);
      a("glBindRenderbuffer:Depth");
      if (this.jdField_b_of_type_Boolean)
      {
        GLES20.glRenderbufferStorage(36161, 35056, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        a("glRenderbufferStorage:Depth[packed]");
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.c[0]);
        a("glFramebufferRenderbuffer:Depth[packed]");
        GLES20.glFramebufferRenderbuffer(36160, 36128, 36161, this.c[0]);
        a("glFramebufferRenderbuffer:Stencil[packed]");
        this.d[0] = this.c[0];
      }
    }
    else
    {
      return;
    }
    GLES20.glRenderbufferStorage(36161, 33189, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    a("glRenderbufferStorage:Depth");
    GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.c[0]);
    a("glFramebufferRenderbuffer:Depth");
    this.d[0] = 0;
  }
  
  public void a()
  {
    GLES20.glBindFramebuffer(36160, this.jdField_b_of_type_ArrayOfInt[0]);
  }
  
  public void a(int paramInt)
  {
    a();
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt, 0);
    a("glFramebufferTexture2D");
    paramInt = GLES20.glCheckFramebufferStatus(36160);
    if (paramInt != 36053) {
      a("glCheckFramebufferStatus: status=" + paramInt);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt3;
    GLES20.glActiveTexture(33987);
    GLES20.glBindTexture(3553, paramInt1);
    a("glBindTexture");
    GLES20.glTexParameteri(3553, 10240, 9728);
    a("glTexParameteri");
    GLES20.glTexParameteri(3553, 10241, 9728);
    a("glTexParameteri");
    GLES20.glTexParameteri(3553, 10242, 33071);
    a("glTexParameteri");
    GLES20.glTexParameteri(3553, 10243, 33071);
    a("glTexParameteri");
    GLES20.glTexImage2D(3553, 0, 6408, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0, 6408, 5121, null);
    a("glTexImage2D");
    GLES20.glBindTexture(3553, 0);
    a("glBindTexture");
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    a("glIsTexture");
    GLES20.glGenFramebuffers(1, this.jdField_b_of_type_ArrayOfInt, 0);
    a("glGenFramebuffers");
    GLES20.glBindFramebuffer(36160, this.jdField_b_of_type_ArrayOfInt[0]);
    a("glBindFramebuffer");
    d();
    return true;
  }
  
  public void b()
  {
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public void c()
  {
    b();
    if (this.jdField_a_of_type_Boolean) {
      GLES20.glDeleteRenderbuffers(1, this.c, 0);
    }
    GLES20.glDeleteFramebuffers(1, this.jdField_b_of_type_ArrayOfInt, 0);
    this.jdField_b_of_type_ArrayOfInt[0] = 0;
    this.c[0] = 0;
    this.d[0] = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.PtvFilterOpenglFrameBuffer
 * JD-Core Version:    0.7.0.1
 */