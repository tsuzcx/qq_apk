package dov.com.qq.im.ptv;

import android.app.Activity;
import anzj;
import bpyn;
import bqah;
import bqai;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class LightWeightCameraCaptureUnit$9
  implements Runnable
{
  public LightWeightCameraCaptureUnit$9(bpyn parambpyn, int paramInt) {}
  
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
        QQToast.a(BaseApplicationImpl.getApplication(), anzj.a(2131705002), 1).a();
        localActivity = this.this$0.jdField_a_of_type_Bqai.a();
      } while ((localActivity == null) || (localActivity.isFinishing()));
      this.this$0.jdField_a_of_type_Bqah.a(2);
      return;
    case 102: 
      QQToast.a(BaseApplicationImpl.getContext(), anzj.a(2131705000), 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), anzj.a(2131704986), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.9
 * JD-Core Version:    0.7.0.1
 */