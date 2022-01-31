package dov.com.qq.im;

import ajjy;
import android.app.Activity;
import bbmy;
import bhdi;
import bhzb;
import bhzc;
import com.tencent.common.app.BaseApplicationImpl;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraSegmentCaptureButtonLayout;

public class QIMCameraCaptureUnit$7
  implements Runnable
{
  public QIMCameraCaptureUnit$7(bhdi parambhdi, int paramInt) {}
  
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
          bbmy.a(BaseApplicationImpl.getApplication(), ajjy.a(2131643979), 1).a();
          Activity localActivity = this.this$0.jdField_a_of_type_Bhzc.a();
          if ((localActivity != null) && (!localActivity.isFinishing())) {
            this.this$0.jdField_a_of_type_Bhzb.a(2);
          }
        } while (!this.this$0.h);
        this.this$0.M();
        return;
        if ((this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraSegmentCaptureButtonLayout.a()) && (this.this$0.h))
        {
          this.this$0.b(null, false);
          return;
        }
        bbmy.a(BaseApplicationImpl.getContext(), this.this$0.jdField_a_of_type_JavaLangString, 0).a();
        this.this$0.g();
        this.this$0.N();
      } while (!this.this$0.h);
      this.this$0.L();
      return;
      bbmy.a(BaseApplicationImpl.getContext(), ajjy.a(2131643981), 0).a();
    } while (!this.this$0.h);
    this.this$0.L();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.7
 * JD-Core Version:    0.7.0.1
 */