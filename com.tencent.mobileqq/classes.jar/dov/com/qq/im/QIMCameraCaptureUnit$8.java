package dov.com.qq.im;

import amtj;
import android.app.Activity;
import blhu;
import bnbo;
import bnbp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayoutNew;

public class QIMCameraCaptureUnit$8
  implements Runnable
{
  public QIMCameraCaptureUnit$8(blhu paramblhu, int paramInt) {}
  
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
          QQToast.a(BaseApplicationImpl.getApplication(), amtj.a(2131708876), 1).a();
          Activity localActivity = this.this$0.jdField_a_of_type_Bnbp.a();
          if ((localActivity != null) && (!localActivity.isFinishing())) {
            this.this$0.jdField_a_of_type_Bnbo.a(2);
          }
        } while (!this.this$0.g);
        this.this$0.C();
        return;
        if ((this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayoutNew.b()) && (this.this$0.g))
        {
          this.this$0.a(null, false);
          return;
        }
        QQToast.a(BaseApplicationImpl.getContext(), this.this$0.jdField_a_of_type_JavaLangString, 0).a();
        this.this$0.g();
        this.this$0.D();
      } while (!this.this$0.g);
      this.this$0.B();
      return;
      QQToast.a(BaseApplicationImpl.getContext(), amtj.a(2131708878), 0).a();
    } while (!this.this$0.g);
    this.this$0.B();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.8
 * JD-Core Version:    0.7.0.1
 */