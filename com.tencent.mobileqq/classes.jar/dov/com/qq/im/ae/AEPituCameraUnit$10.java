package dov.com.qq.im.ae;

import android.app.Activity;
import anzj;
import bofh;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class AEPituCameraUnit$10
  implements Runnable
{
  public AEPituCameraUnit$10(bofh parambofh, int paramInt) {}
  
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
        QQToast.a(BaseApplicationImpl.getApplication(), anzj.a(2131689680), 1).a();
        localActivity = this.this$0.a();
      } while ((localActivity == null) || (localActivity.isFinishing()));
      localActivity.finish();
      return;
    case 102: 
      QQToast.a(BaseApplicationImpl.getContext(), anzj.a(2131689681), 0).a();
      this.this$0.o();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), anzj.a(2131689679), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.10
 * JD-Core Version:    0.7.0.1
 */