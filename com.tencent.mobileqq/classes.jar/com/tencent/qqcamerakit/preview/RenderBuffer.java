package com.tencent.qqcamerakit.preview;

import android.opengl.GLES20;

public class RenderBuffer
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private boolean f = true;
  private boolean g = false;
  private int h;
  private int i;
  
  public RenderBuffer(int paramInt1, int paramInt2, int paramInt3)
  {
    this(true, paramInt1, paramInt2, paramInt3);
  }
  
  public RenderBuffer(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.h = paramInt1;
    this.i = paramInt2;
    this.c = paramInt3;
    this.f = paramBoolean;
    int[] arrayOfInt = new int[1];
    GLES20.glActiveTexture(paramInt3);
    this.a = GlUtil.a(3553);
    this.b = this.a;
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
    e();
  }
  
  public int a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.h;
  }
  
  public int c()
  {
    return this.i;
  }
  
  public void d()
  {
    GLES20.glViewport(0, 0, this.h, this.i);
    GLES20.glBindFramebuffer(36160, this.e);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.a, 0);
    if (this.f) {
      GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.d);
    }
  }
  
  public void e()
  {
    GLES20.glBindFramebuffer(36160, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.preview.RenderBuffer
 * JD-Core Version:    0.7.0.1
 */