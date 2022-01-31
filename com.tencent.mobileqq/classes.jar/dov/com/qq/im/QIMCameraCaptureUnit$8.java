package dov.com.qq.im;

import bify;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout;

public class QIMCameraCaptureUnit$8
  implements Runnable
{
  public QIMCameraCaptureUnit$8(bify parambify, boolean paramBoolean1, LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.this$0.b(this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      if (!this.this$0.i) {
        this.this$0.e(true);
      }
    }
    for (;;)
    {
      this.this$0.h();
      if ((!this.b) || (!this.this$0.k)) {
        this.this$0.g();
      }
      return;
      this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.u();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.8
 * JD-Core Version:    0.7.0.1
 */