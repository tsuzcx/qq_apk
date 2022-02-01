package dov.com.qq.im.ae;

import amtj;
import android.app.Activity;
import bljy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

public class AEPituCameraUnit$34
  implements Runnable
{
  public AEPituCameraUnit$34(bljy parambljy, int paramInt) {}
  
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
        QQToast.a(BaseApplicationImpl.getApplication(), amtj.a(2131689679), 1).a();
        localActivity = this.this$0.a();
      } while ((localActivity == null) || (localActivity.isFinishing()));
      localActivity.finish();
      return;
    case 102: 
      QQToast.a(BaseApplicationImpl.getContext(), amtj.a(2131689680), 0).a();
      this.this$0.J();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), amtj.a(2131689678), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.34
 * JD-Core Version:    0.7.0.1
 */