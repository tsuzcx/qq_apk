package dov.com.qq.im.ae;

import alpo;
import android.app.Activity;
import bkle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class AEPituCameraUnit$13
  implements Runnable
{
  public AEPituCameraUnit$13(bkle parambkle, int paramInt) {}
  
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
        QQToast.a(BaseApplicationImpl.getApplication(), alpo.a(2131689786), 1).a();
        localActivity = this.this$0.a();
      } while ((localActivity == null) || (localActivity.isFinishing()));
      localActivity.finish();
      return;
    case 102: 
      QQToast.a(BaseApplicationImpl.getContext(), alpo.a(2131689787), 0).a();
      this.this$0.q();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), alpo.a(2131689785), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.13
 * JD-Core Version:    0.7.0.1
 */