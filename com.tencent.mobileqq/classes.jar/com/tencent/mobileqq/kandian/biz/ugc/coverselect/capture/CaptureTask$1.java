package com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;

class CaptureTask$1
  implements CaptureTask.OnCaptureCallback
{
  CaptureTask$1(CaptureTask paramCaptureTask, Bitmap[] paramArrayOfBitmap) {}
  
  public void a()
  {
    CaptureTask.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask);
    if (CaptureTask.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask) <= 3)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCaptureFailed try angin tryCount:");
        localStringBuilder.append(CaptureTask.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask));
        localStringBuilder.append("  CaptureTask:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask);
        QLog.d("CaptureTask", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask.a(null);
    }
  }
  
  public void a(Bitmap paramBitmap, CaptureTask paramCaptureTask)
  {
    this.jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[0] = paramBitmap;
    CaptureTask.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcCoverselectCaptureCaptureTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.coverselect.capture.CaptureTask.1
 * JD-Core Version:    0.7.0.1
 */