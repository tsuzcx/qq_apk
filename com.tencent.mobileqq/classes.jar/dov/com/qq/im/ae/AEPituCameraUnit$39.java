package dov.com.qq.im.ae;

import android.app.Activity;
import anvx;
import bmxa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class AEPituCameraUnit$39
  implements Runnable
{
  public AEPituCameraUnit$39(bmxa parambmxa, int paramInt) {}
  
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
        QQToast.a(BaseApplicationImpl.getApplication(), anvx.a(2131689687), 1).a();
        localActivity = this.this$0.a();
      } while ((localActivity == null) || (localActivity.isFinishing()));
      localActivity.finish();
      return;
    case 102: 
      QQToast.a(BaseApplicationImpl.getContext(), anvx.a(2131689688), 0).a();
      this.this$0.e();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), anvx.a(2131689686), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.39
 * JD-Core Version:    0.7.0.1
 */