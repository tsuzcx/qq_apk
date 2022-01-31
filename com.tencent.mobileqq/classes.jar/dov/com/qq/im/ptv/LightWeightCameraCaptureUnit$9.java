package dov.com.qq.im.ptv;

import ajya;
import android.app.Activity;
import bcql;
import bjpq;
import bjrk;
import bjrl;
import com.tencent.common.app.BaseApplicationImpl;

public class LightWeightCameraCaptureUnit$9
  implements Runnable
{
  public LightWeightCameraCaptureUnit$9(bjpq parambjpq, int paramInt) {}
  
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
        bcql.a(BaseApplicationImpl.getApplication(), ajya.a(2131706100), 1).a();
        localActivity = this.this$0.jdField_a_of_type_Bjrl.a();
      } while ((localActivity == null) || (localActivity.isFinishing()));
      this.this$0.jdField_a_of_type_Bjrk.a(2);
      return;
    case 102: 
      bcql.a(BaseApplicationImpl.getContext(), ajya.a(2131706098), 0).a();
      return;
    }
    bcql.a(BaseApplicationImpl.getContext(), ajya.a(2131706084), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.9
 * JD-Core Version:    0.7.0.1
 */