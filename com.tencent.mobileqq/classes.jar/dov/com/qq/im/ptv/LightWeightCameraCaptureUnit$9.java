package dov.com.qq.im.ptv;

import ajyc;
import android.app.Activity;
import bcpw;
import bjoz;
import bjqt;
import bjqu;
import com.tencent.common.app.BaseApplicationImpl;

public class LightWeightCameraCaptureUnit$9
  implements Runnable
{
  public LightWeightCameraCaptureUnit$9(bjoz parambjoz, int paramInt) {}
  
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
        bcpw.a(BaseApplicationImpl.getApplication(), ajyc.a(2131706089), 1).a();
        localActivity = this.this$0.jdField_a_of_type_Bjqu.a();
      } while ((localActivity == null) || (localActivity.isFinishing()));
      this.this$0.jdField_a_of_type_Bjqt.a(2);
      return;
    case 102: 
      bcpw.a(BaseApplicationImpl.getContext(), ajyc.a(2131706087), 0).a();
      return;
    }
    bcpw.a(BaseApplicationImpl.getContext(), ajyc.a(2131706073), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.9
 * JD-Core Version:    0.7.0.1
 */