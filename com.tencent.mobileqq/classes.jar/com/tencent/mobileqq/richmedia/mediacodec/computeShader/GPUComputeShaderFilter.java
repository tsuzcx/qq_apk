package com.tencent.mobileqq.richmedia.mediacodec.computeShader;

import android.annotation.SuppressLint;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.computeShader.GPUComputeShaderFilter
 * JD-Core Version:    0.7.0.1
 */