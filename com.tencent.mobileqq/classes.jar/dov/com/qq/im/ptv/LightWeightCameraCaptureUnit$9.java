package dov.com.qq.im.ptv;

import android.app.Activity;
import anni;
import bows;
import boym;
import boyn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class LightWeightCameraCaptureUnit$9
  implements Runnable
{
  public LightWeightCameraCaptureUnit$9(bows parambows, int paramInt) {}
  
  public void run()
  {
    switch (this.a)
    {
    default: 
    case 101: 
    case 104: 
      Activity localActivity;
      do
      {
        return;
        QQToast.a(BaseApplicationImpl.getApplication(), anni.a(2131704895), 1).a();
        localActivity = this.this$0.jdField_a_of_type_Boyn.a();
      } while ((localActivity == null) || (localActivity.isFinishing()));
      this.this$0.jdField_a_of_type_Boym.a(2);
      return;
    case 102: 
      QQToast.a(BaseApplicationImpl.getContext(), anni.a(2131704893), 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), anni.a(2131704879), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.9
 * JD-Core Version:    0.7.0.1
 */