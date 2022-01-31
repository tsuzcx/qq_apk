package dov.com.qq.im;

import ajyc;
import android.app.Activity;
import bcpw;
import bify;
import bjqt;
import bjqu;
import com.tencent.common.app.BaseApplicationImpl;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout;

public class QIMCameraCaptureUnit$7
  implements Runnable
{
  public QIMCameraCaptureUnit$7(bify parambify, int paramInt) {}
  
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
          bcpw.a(BaseApplicationImpl.getApplication(), ajyc.a(2131709764), 1).a();
          Activity localActivity = this.this$0.jdField_a_of_type_Bjqu.a();
          if ((localActivity != null) && (!localActivity.isFinishing())) {
            this.this$0.jdField_a_of_type_Bjqt.a(2);
          }
        } while (!this.this$0.h);
        this.this$0.K();
        return;
        if ((this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.a()) && (this.this$0.h))
        {
          this.this$0.b(null, false);
          return;
        }
        bcpw.a(BaseApplicationImpl.getContext(), this.this$0.jdField_a_of_type_JavaLangString, 0).a();
        this.this$0.g();
        this.this$0.L();
      } while (!this.this$0.h);
      this.this$0.J();
      return;
      bcpw.a(BaseApplicationImpl.getContext(), ajyc.a(2131709766), 0).a();
    } while (!this.this$0.h);
    this.this$0.J();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.7
 * JD-Core Version:    0.7.0.1
 */