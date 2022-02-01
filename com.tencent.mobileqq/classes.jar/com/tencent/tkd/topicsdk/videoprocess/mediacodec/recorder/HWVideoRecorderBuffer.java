package com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder;

import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.decoder.flow.GlUtil;
import com.tencent.tkd.topicsdk.videoprocess.mediacodec.ttpic.GPUBaseFilter;

public class HWVideoRecorderBuffer
{
  private volatile int jdField_a_of_type_Int = 0;
  private GPUBaseFilter jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUBaseFilter;
  private int[] jdField_a_of_type_ArrayOfInt = new int[3];
  private Frame[] jdField_a_of_type_ArrayOfComTencentAekitOpenrenderInternalFrame = new Frame[3];
  private volatile int b = 0;
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
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUBaseFilter != null) {
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUBaseFilter.e();
    }
    GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    while (i < 3)
    {
      if (this.jdField_a_of_type_ArrayOfComTencentAekitOpenrenderInternalFrame[i] != null) {
        this.jdField_a_of_type_ArrayOfComTencentAekitOpenrenderInternalFrame[i].clear();
      }
      i += 1;
    }
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
      this.jdField_a_of_type_ArrayOfComTencentAekitOpenrenderInternalFrame[i].bindFrame(this.jdField_a_of_type_ArrayOfInt[i], this.c, this.d, 1.0D);
      GlUtil.a("bindFrame");
      this.jdField_a_of_type_ComTencentTkdTopicsdkVideoprocessMediacodecTtpicGPUBaseFilter.a(paramInt, null, null);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glFinish();
      a(true, 1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.videoprocess.mediacodec.recorder.HWVideoRecorderBuffer
 * JD-Core Version:    0.7.0.1
 */