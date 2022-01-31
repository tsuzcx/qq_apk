package com.tencent.mobileqq.richmedia.mediacodec.computeShader;

import android.annotation.SuppressLint;
import android.opengl.GLES20;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.sveffects.SLog;

@SuppressLint({"NewApi"})
public class GPUComputeShaderFilter
{
  public int a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public GPUComputeShaderFilter(String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    a("onDispatchComputePrepare");
    GLES20.glUseProgram(this.b);
    a("glUseProgram");
    return this.b;
  }
  
  public int a(int paramInt)
  {
    int i = paramInt % 16;
    if (i == 0) {
      return paramInt;
    }
    return paramInt + 16 - i;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.b = GlUtil.a(this.jdField_a_of_type_JavaLangString);
    if (this.b == 0) {
      SLog.a("GPUComputeShaderFilter", new RuntimeException("failed creating ComputeProgram " + getClass().getSimpleName()));
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt < 0) {
      SLog.a("GPUComputeShaderFilter", new RuntimeException("Unable to locate '" + paramString + "' in program"));
    }
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      int i = GLES20.glGetError();
      if (i == 0) {
        break;
      }
      SLog.a("GPUComputeShaderFilter", new RuntimeException(paramString + ": glError " + i));
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    GLES20.glDeleteProgram(this.b);
    this.b = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUComputeShaderFilter
 * JD-Core Version:    0.7.0.1
 */