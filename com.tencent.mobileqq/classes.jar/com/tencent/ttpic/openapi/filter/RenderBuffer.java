package com.tencent.ttpic.openapi.filter;

import android.annotation.TargetApi;
import android.opengl.GLES20;
import android.opengl.GLES31;
import com.tencent.aekit.openrender.util.GlUtil;

public class RenderBuffer
{
  private int activeTexUnit = 0;
  private int frameBufferId = 0;
  private int height;
  private int initialTexId = 0;
  private boolean mTextureOutside = false;
  private int renderBufferId = 0;
  private int texId = 0;
  private boolean useRenderBuffer = true;
  private int width;
  
  public RenderBuffer(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    this.frameBufferId = arrayOfInt[0];
    GLES20.glBindFramebuffer(36160, this.frameBufferId);
    this.useRenderBuffer = true;
    GLES20.glGenRenderbuffers(1, arrayOfInt, 0);
    this.renderBufferId = arrayOfInt[0];
    GLES20.glBindRenderbuffer(36161, this.renderBufferId);
    GLES20.glRenderbufferStorage(36161, 33189, paramInt1, paramInt2);
    unbind();
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
  
  public RenderBuffer(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[1];
    this.width = paramInt1;
    this.height = paramInt2;
    this.useRenderBuffer = paramBoolean;
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    this.frameBufferId = arrayOfInt[0];
    GLES20.glBindFramebuffer(36160, this.frameBufferId);
    if (paramBoolean)
    {
      GLES20.glGenRenderbuffers(1, arrayOfInt, 0);
      this.renderBufferId = arrayOfInt[0];
      GLES20.glBindRenderbuffer(36161, this.renderBufferId);
      GLES20.glRenderbufferStorage(36161, 33189, paramInt1, paramInt2);
    }
    unbind();
  }
  
  public RenderBuffer(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.activeTexUnit = paramInt3;
    this.useRenderBuffer = paramBoolean;
    int[] arrayOfInt = new int[1];
    GLES20.glActiveTexture(paramInt3);
    this.texId = GlUtil.createTexture(3553);
    this.initialTexId = this.texId;
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    this.frameBufferId = arrayOfInt[0];
    GLES20.glBindFramebuffer(36160, this.frameBufferId);
    if (paramBoolean)
    {
      GLES20.glGenRenderbuffers(1, arrayOfInt, 0);
      this.renderBufferId = arrayOfInt[0];
      GLES20.glBindRenderbuffer(36161, this.renderBufferId);
      GLES20.glRenderbufferStorage(36161, 33189, paramInt1, paramInt2);
    }
    unbind();
  }
  
  @TargetApi(18)
  public RenderBuffer(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.activeTexUnit = paramInt3;
    this.useRenderBuffer = paramBoolean1;
    int[] arrayOfInt = new int[1];
    GLES20.glActiveTexture(paramInt3);
    this.texId = GlUtil.createTexture(3553);
    if (paramBoolean2) {
      GLES31.glTexStorage2D(3553, 1, 32856, paramInt1, paramInt2);
    } else {
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    }
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    this.frameBufferId = arrayOfInt[0];
    GLES20.glBindFramebuffer(36160, this.frameBufferId);
    if (paramBoolean1)
    {
      GLES20.glGenRenderbuffers(1, arrayOfInt, 0);
      this.renderBufferId = arrayOfInt[0];
      GLES20.glBindRenderbuffer(36161, this.renderBufferId);
      GLES20.glRenderbufferStorage(36161, 33189, paramInt1, paramInt2);
    }
    unbind();
  }
  
  public void bind()
  {
    GLES20.glViewport(0, 0, this.width, this.height);
    GLES20.glBindFramebuffer(36160, this.frameBufferId);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.texId, 0);
    if (this.useRenderBuffer) {
      GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, this.renderBufferId);
    }
  }
  
  public void destroy()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.frameBufferId;
    GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
    if (this.useRenderBuffer)
    {
      arrayOfInt[0] = this.renderBufferId;
      GLES20.glDeleteRenderbuffers(1, arrayOfInt, 0);
    }
    int i = this.texId;
    if (i > 0) {
      GlUtil.deleteTexture(i);
    }
  }
  
  public int getActiveTexUnit()
  {
    return this.activeTexUnit;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getTexId()
  {
    return this.texId;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void recoverInitialTexId()
  {
    this.texId = this.initialTexId;
  }
  
  public void setSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public void setTexId(int paramInt)
  {
    this.texId = paramInt;
  }
  
  public void setUserTextureId(int paramInt)
  {
    this.mTextureOutside = true;
    this.texId = paramInt;
  }
  
  public void unbind()
  {
    GLES20.glBindFramebuffer(36160, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.RenderBuffer
 * JD-Core Version:    0.7.0.1
 */