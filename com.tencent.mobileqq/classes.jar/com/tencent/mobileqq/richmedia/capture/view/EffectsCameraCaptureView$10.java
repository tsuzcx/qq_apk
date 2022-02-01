package com.tencent.mobileqq.richmedia.capture.view;

import baph;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import java.io.File;

class EffectsCameraCaptureView$10
  implements Runnable
{
  EffectsCameraCaptureView$10(EffectsCameraCaptureView paramEffectsCameraCaptureView, boolean paramBoolean, baph parambaph) {}
  
  public void run()
  {
    String str1;
    String str2;
    if (this.this$0.a != null)
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label120;
      }
      str1 = this.jdField_a_of_type_Baph.e + this.jdField_a_of_type_Baph.c + File.separator;
      str2 = this.jdField_a_of_type_Baph.e + this.jdField_a_of_type_Baph.b + File.separator;
      this.this$0.a.getBusinessOperation().setFaceDanceFilter(str1, str2);
    }
    for (;;)
    {
      this.this$0.a.getBusinessOperation().handleDanceFilterRestoreEvent();
      return;
      label120:
      str1 = this.jdField_a_of_type_Baph.e + this.jdField_a_of_type_Baph.c + File.separator;
      str2 = this.jdField_a_of_type_Baph.e + this.jdField_a_of_type_Baph.b + File.separator;
      String str3 = this.jdField_a_of_type_Baph.e + this.jdField_a_of_type_Baph.d + File.separator;
      this.this$0.a.getBusinessOperation().setQmcfPoseFilter(str1, str2, str3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView.10
 * JD-Core Version:    0.7.0.1
 */