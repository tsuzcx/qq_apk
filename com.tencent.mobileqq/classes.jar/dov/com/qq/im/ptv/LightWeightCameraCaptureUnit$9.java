package dov.com.qq.im.ptv;

import alud;
import android.app.Activity;
import bmfm;
import bmhg;
import bmhh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class LightWeightCameraCaptureUnit$9
  implements Runnable
{
  public LightWeightCameraCaptureUnit$9(bmfm parambmfm, int paramInt) {}
  
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
        QQToast.a(BaseApplicationImpl.getApplication(), alud.a(2131706484), 1).a();
        localActivity = this.this$0.jdField_a_of_type_Bmhh.a();
      } while ((localActivity == null) || (localActivity.isFinishing()));
      this.this$0.jdField_a_of_type_Bmhg.a(2);
      return;
    case 102: 
      QQToast.a(BaseApplicationImpl.getContext(), alud.a(2131706482), 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), alud.a(2131706468), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ptv.LightWeightCameraCaptureUnit.9
 * JD-Core Version:    0.7.0.1
 */