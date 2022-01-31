package dov.com.qq.im;

import ajya;
import android.app.Activity;
import bcql;
import bigp;
import bjrk;
import bjrl;
import com.tencent.common.app.BaseApplicationImpl;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout;

public class QIMCameraCaptureUnit$7
  implements Runnable
{
  public QIMCameraCaptureUnit$7(bigp parambigp, int paramInt) {}
  
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
          bcql.a(BaseApplicationImpl.getApplication(), ajya.a(2131709775), 1).a();
          Activity localActivity = this.this$0.jdField_a_of_type_Bjrl.a();
          if ((localActivity != null) && (!localActivity.isFinishing())) {
            this.this$0.jdField_a_of_type_Bjrk.a(2);
          }
        } while (!this.this$0.h);
        this.this$0.K();
        return;
        if ((this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.a()) && (this.this$0.h))
        {
          this.this$0.b(null, false);
          return;
        }
        bcql.a(BaseApplicationImpl.getContext(), this.this$0.jdField_a_of_type_JavaLangString, 0).a();
        this.this$0.g();
        this.this$0.L();
      } while (!this.this$0.h);
      this.this$0.J();
      return;
      bcql.a(BaseApplicationImpl.getContext(), ajya.a(2131709777), 0).a();
    } while (!this.this$0.h);
    this.this$0.J();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.7
 * JD-Core Version:    0.7.0.1
 */