package com.tencent.mobileqq.richmedia.mediacodec.recorder;

import android.opengl.GLES20;
import com.tencent.filter.Frame;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUBaseFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;

public class HWVideoRecorderBuffer
{
  private volatile int jdField_a_of_type_Int;
  private GPUBaseFilter jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter;
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private Frame[] jdField_a_of_type_ArrayOfComTencentFilterFrame = new Frame[3];
  private volatile int b;
  private int c;
  private int d;
  
  public int a()
  {
    if (Math.min(1, this.jdField_a_of_type_Int - this.b) == 1)
    {
      int i = this.b;
      return this.jdField_a_of_type_ArrayOfInt[(i % 3)];
    }
    return -1;
  }
  
  public void a()
  {
    int i = 0;
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.c();
    GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    while (i < 3)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentFilterFrame[i] != null) {
        this.jdField_a_of_type_ArrayOfComTencentFilterFrame[i].clear();
      }
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 0;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter = new GPUBaseFilter();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a();
    GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    while (i < 3)
    {
      this.jdField_a_of_type_ArrayOfComTencentFilterFrame[i] = new Frame();
      i += 1;
    }
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Int += paramInt;
        return;
      }
      finally {}
      this.b += paramInt;
    }
  }
  
  public boolean a(int paramInt)
  {
    if (Math.min(1, 3 - (this.jdField_a_of_type_Int - this.b)) == 1)
    {
      int i = this.jdField_a_of_type_Int % 3;
      this.jdField_a_of_type_ArrayOfComTencentFilterFrame[i].bindFrame(this.jdField_a_of_type_ArrayOfInt[i], this.c, this.d, 1.0D);
      GlUtil.a("bindFrame");
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRendererGPUBaseFilter.a(paramInt, null, null);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glFinish();
      a(true, 1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorderBuffer
 * JD-Core Version:    0.7.0.1
 */