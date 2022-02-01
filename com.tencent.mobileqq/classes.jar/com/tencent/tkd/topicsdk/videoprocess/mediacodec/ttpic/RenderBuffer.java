package com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.util.GlUtil;

public class RenderBuffer
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private boolean d = true;
  private int e;
  private int f;
  
  public RenderBuffer(int paramInt1, int paramInt2, int paramInt3)
  {
    this(true, paramInt1, paramInt2, paramInt3);
  }
  
  private RenderBuffer(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.e = paramInt1;
    this.f = paramInt2;
    this.d = paramBoolean;
    GLES20.glActiveTexture(paramInt3);
    this.a = GlUtil.createTexture(3553);
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
    c();
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void b()
  {
    GLES20.glViewport(0, 0, this.e, this.f);
    GLES20.glBindFramebuffer(36160, this.c);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.a, 0);
    if (this.d) {
      GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.b);
    }
  }
  
  public void c()
  {
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public void d()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.c;
    GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
    if (this.d)
    {
      arrayOfInt[0] = this.b;
      GLES20.glDeleteRenderbuffers(1, arrayOfInt, 0);
    }
    int i = this.a;
    if (i > 0) {
      GlUtil.deleteTexture(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic.RenderBuffer
 * JD-Core Version:    0.7.0.1
 */