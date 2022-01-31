package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import android.opengl.GLES31;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

public class RenderBuffer
{
  private int jdField_a_of_type_Int = 0;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int f;
  private int g;
  
  public RenderBuffer(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    this.e = arrayOfInt[0];
    GLES20.glBindFramebuffer(36160, this.e);
    GLES20.glGenRenderbuffers(1, arrayOfInt, 0);
    this.d = arrayOfInt[0];
    GLES20.glBindRenderbuffer(36161, this.d);
    GLES20.glRenderbufferStorage(36161, 33189, paramInt1, paramInt2);
    c();
  }
  
  public RenderBuffer(int paramInt1, int paramInt2, int paramInt3)
  {
    this(true, paramInt1, paramInt2, paramInt3);
  }
  
  @TargetApi(18)
  public RenderBuffer(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this(true, paramInt1, paramInt2, paramInt3, paramBoolean);
  }
  
  public RenderBuffer(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_Boolean = paramBoolean;
    int[] arrayOfInt = new int[1];
    GLES20.glActiveTexture(paramInt3);
    this.jdField_a_of_type_Int = GlUtil.a(3553);
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    this.e = arrayOfInt[0];
    GLES20.glBindFramebuffer(36160, this.e);
    if (paramBoolean)
    {
      GLES20.glGenRenderbuffers(1, arrayOfInt, 0);
      this.d = arrayOfInt[0];
      GLES20.glBindRenderbuffer(36161, this.d);
      GLES20.glRenderbufferStorage(36161, 33189, paramInt1, paramInt2);
    }
    c();
  }
  
  @TargetApi(18)
  public RenderBuffer(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    int[] arrayOfInt = new int[1];
    GLES20.glActiveTexture(paramInt3);
    this.jdField_a_of_type_Int = GlUtil.a(3553);
    if (paramBoolean2) {
      GLES31.glTexStorage2D(3553, 1, 32856, paramInt1, paramInt2);
    }
    for (;;)
    {
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameteri(3553, 10242, 33071);
      GLES20.glTexParameteri(3553, 10243, 33071);
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      this.e = arrayOfInt[0];
      GLES20.glBindFramebuffer(36160, this.e);
      if (paramBoolean1)
      {
        GLES20.glGenRenderbuffers(1, arrayOfInt, 0);
        this.d = arrayOfInt[0];
        GLES20.glBindRenderbuffer(36161, this.d);
        GLES20.glRenderbufferStorage(36161, 33189, paramInt1, paramInt2);
      }
      c();
      return;
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int b()
  {
    return this.f;
  }
  
  public void b()
  {
    GLES20.glViewport(0, 0, this.f, this.g);
    GLES20.glBindFramebuffer(36160, this.e);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.jdField_a_of_type_Int, 0);
    if (this.jdField_a_of_type_Boolean) {
      GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.d);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int c()
  {
    return this.g;
  }
  
  public void c()
  {
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public void d()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.e;
    GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
    if (this.jdField_a_of_type_Boolean)
    {
      arrayOfInt[0] = this.d;
      GLES20.glDeleteRenderbuffers(1, arrayOfInt, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.renderer.RenderBuffer
 * JD-Core Version:    0.7.0.1
 */