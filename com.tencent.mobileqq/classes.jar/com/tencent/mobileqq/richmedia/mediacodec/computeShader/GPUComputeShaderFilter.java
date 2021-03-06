package com.tencent.mobileqq.richmedia.mediacodec.computeShader;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.sveffects.SLog;

@SuppressLint({"NewApi"})
public class GPUComputeShaderFilter
{
  private static final String TAG = "GPUComputeShaderFilter";
  private String mComputeShader;
  private boolean mIsInitialized;
  private int mProgram;
  public int mTextureType;
  
  public GPUComputeShaderFilter(String paramString, int paramInt)
  {
    this.mComputeShader = paramString;
    this.mTextureType = paramInt;
  }
  
  public void checkGlError(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(": glError ");
      localStringBuilder.append(i);
      SLog.e("GPUComputeShaderFilter", new RuntimeException(localStringBuilder.toString()));
    }
  }
  
  public void checkLocation(int paramInt, String paramString)
  {
    if (paramInt < 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to locate '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("' in program");
      SLog.e("GPUComputeShaderFilter", new RuntimeException(localStringBuilder.toString()));
    }
  }
  
  public void destroy()
  {
    this.mIsInitialized = false;
    GLES20.glDeleteProgram(this.mProgram);
    this.mProgram = 0;
  }
  
  public int getAlignment16(int paramInt)
  {
    int i = paramInt % 16;
    if (i == 0) {
      return paramInt;
    }
    return paramInt + 16 - i;
  }
  
  public void init()
  {
    if (this.mIsInitialized) {
      return;
    }
    this.mProgram = GlUtil.createComputeProgram(this.mComputeShader);
    if (this.mProgram == 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed creating ComputeProgram ");
      localStringBuilder.append(getClass().getSimpleName());
      SLog.e("GPUComputeShaderFilter", new RuntimeException(localStringBuilder.toString()));
    }
    this.mIsInitialized = true;
  }
  
  public int useComputeProgram()
  {
    checkGlError("onDispatchComputePrepare");
    GLES20.glUseProgram(this.mProgram);
    checkGlError("glUseProgram");
    return this.mProgram;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUComputeShaderFilter
 * JD-Core Version:    0.7.0.1
 */