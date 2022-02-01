package com.tencent.mobileqq.shortvideo.panoramicvideo.GL;

import android.opengl.GLES20;

public class FBO
{
  private int frameBuffer;
  private int frameBufferTexture;
  
  public static FBO newInstance()
  {
    return new FBO();
  }
  
  public void bind()
  {
    GLES20.glBindFramebuffer(36160, this.frameBuffer);
  }
  
  public FBO create(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt1 = new int[1];
    int[] arrayOfInt2 = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt1, 0);
    GLES20.glGenTextures(1, arrayOfInt2, 0);
    GLES20.glBindTexture(3553, arrayOfInt2[0]);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glBindFramebuffer(36160, arrayOfInt1[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, arrayOfInt2[0], 0);
    GLES20.glBindTexture(3553, 0);
    GLES20.glBindFramebuffer(36160, 0);
    this.frameBuffer = arrayOfInt1[0];
    this.frameBufferTexture = arrayOfInt2[0];
    return this;
  }
  
  public void destroy()
  {
    GLES20.glDeleteTextures(1, new int[] { this.frameBufferTexture }, 0);
    GLES20.glDeleteFramebuffers(1, new int[] { this.frameBuffer }, 0);
  }
  
  public int getFrameBuffer()
  {
    return this.frameBuffer;
  }
  
  public int getFrameBufferTextureId()
  {
    return this.frameBufferTexture;
  }
  
  public void unbind()
  {
    GLES20.glBindFramebuffer(36160, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.GL.FBO
 * JD-Core Version:    0.7.0.1
 */