package dov.com.qq.im.ptv;

import alpo;
import android.app.Activity;
import bmba;
import bmcu;
import bmcv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class LightWeightCameraCaptureUnit$9
  implements Runnable
{
  public LightWeightCameraCaptureUnit$9(bmba parambmba, int paramInt) {}
  
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
        QQToast.a(BaseApplicationImpl.getApplication(), alpo.a(2131706472), 1).a();
        localActivity = this.this$0.jdField_a_of_type_Bmcv.a();
      } while ((localActivity == null) || (localActivity.isFinishing()));
      this.this$0.jdField_a_of_type_Bmcu.a(2);
      return;
    case 102: 
      QQToast.a(BaseApplicationImpl.getContext(), alpo.a(2131706470), 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), alpo.a(2131706456), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.9
 * JD-Core Version:    0.7.0.1
 */