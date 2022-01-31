package dov.com.qq.im.ptv;

import ajjy;
import android.app.Activity;
import bbmy;
import bhxh;
import bhzb;
import bhzc;
import com.tencent.common.app.BaseApplicationImpl;

public class LightWeightCameraCaptureUnit$9
  implements Runnable
{
  public LightWeightCameraCaptureUnit$9(bhxh parambhxh, int paramInt) {}
  
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
        bbmy.a(BaseApplicationImpl.getApplication(), ajjy.a(2131640304), 1).a();
        localActivity = this.this$0.jdField_a_of_type_Bhzc.a();
      } while ((localActivity == null) || (localActivity.isFinishing()));
      this.this$0.jdField_a_of_type_Bhzb.a(2);
      return;
    case 102: 
      bbmy.a(BaseApplicationImpl.getContext(), ajjy.a(2131640302), 0).a();
      return;
    }
    bbmy.a(BaseApplicationImpl.getContext(), ajjy.a(2131640288), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.9
 * JD-Core Version:    0.7.0.1
 */