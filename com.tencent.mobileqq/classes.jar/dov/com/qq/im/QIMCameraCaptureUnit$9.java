package dov.com.qq.im;

import bmul;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayoutNew;

public class QIMCameraCaptureUnit$9
  implements Runnable
{
  public QIMCameraCaptureUnit$9(bmul parambmul, boolean paramBoolean1, LocalMediaInfo paramLocalMediaInfo, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.this$0.b(this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      if (!this.this$0.h) {
        this.this$0.c(true);
      }
    }
    for (;;)
    {
      this.this$0.s();
      if ((!this.b) || (!this.this$0.j)) {
        this.this$0.t();
      }
      return;
      this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayoutNew.t();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.9
 * JD-Core Version:    0.7.0.1
 */