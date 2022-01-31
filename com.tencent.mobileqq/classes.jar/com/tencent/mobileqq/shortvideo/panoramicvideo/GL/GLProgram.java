package com.tencent.mobileqq.shortvideo.panoramicvideo.GL;

import android.content.Context;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

public abstract class GLProgram
{
  private String mFragmentShader;
  private int mProgramId;
  private String mVertexShader;
  private int maPositionHandle;
  private int maTextureCoordinateHandle;
  
  public GLProgram(Context paramContext, String paramString1, String paramString2)
  {
    this.mVertexShader = paramString1;
    this.mFragmentShader = paramString2;
  }
  
  public void create()
  {
    this.mProgramId = GlUtil.createProgram(this.mVertexShader, this.mFragmentShader);
    if (this.mProgramId == 0) {}
    do
    {
      return;
      this.maPositionHandle = GLES20.glGetAttribLocation(getProgramId(), "aPosition");
      GlUtil.checkGlError("glGetAttribLocation aPosition");
      if (this.maPositionHandle == -1) {
        throw new RuntimeException("Could not get attrib location for aPosition");
      }
      this.maTextureCoordinateHandle = GLES20.glGetAttribLocation(getProgramId(), "aTextureCoord");
      GlUtil.checkGlError("glGetAttribLocation aTextureCoord");
    } while (this.maTextureCoordinateHandle != -1);
    throw new RuntimeException("Could not get attrib location for aTextureCoord");
  }
  
  public int getPositionHandle()
  {
    return this.maPositionHandle;
  }
  
  public int getProgramId()
  {
    return this.mProgramId;
  }
  
  public int getTextureCoordinateHandle()
  {
    return this.maTextureCoordinateHandle;
  }
  
  public void onDestroy()
  {
    GLES20.glDeleteProgram(this.mProgramId);
  }
  
  public void use()
  {
    GLES20.glUseProgram(getProgramId());
    GlUtil.checkGlError("glUseProgram");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.panoramicvideo.GL.GLProgram
 * JD-Core Version:    0.7.0.1
 */