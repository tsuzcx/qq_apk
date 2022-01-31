package dov.com.qq.im;

import alud;
import android.app.Activity;
import bkms;
import bmhg;
import bmhh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout;

public class QIMCameraCaptureUnit$7
  implements Runnable
{
  public QIMCameraCaptureUnit$7(bkms parambkms, int paramInt) {}
  
  public void run()
  {
    switch (this.a)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          QQToast.a(BaseApplicationImpl.getApplication(), alud.a(2131710159), 1).a();
          Activity localActivity = this.this$0.jdField_a_of_type_Bmhh.a();
          if ((localActivity != null) && (!localActivity.isFinishing())) {
            this.this$0.jdField_a_of_type_Bmhg.a(2);
          }
        } while (!this.this$0.h);
        this.this$0.K();
        return;
        if ((this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.a()) && (this.this$0.h))
        {
          this.this$0.a(null, false);
          return;
        }
        QQToast.a(BaseApplicationImpl.getContext(), this.this$0.jdField_a_of_type_JavaLangString, 0).a();
        this.this$0.g();
        this.this$0.L();
      } while (!this.this$0.h);
      this.this$0.J();
      return;
      QQToast.a(BaseApplicationImpl.getContext(), alud.a(2131710161), 0).a();
    } while (!this.this$0.h);
    this.this$0.J();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.7
 * JD-Core Version:    0.7.0.1
 */