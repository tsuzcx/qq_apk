package dov.com.qq.im.ae;

import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class AEPituCameraUnit$44
  implements Runnable
{
  AEPituCameraUnit$44(AEPituCameraUnit paramAEPituCameraUnit, int paramInt) {}
  
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
        QQToast.a(BaseApplicationImpl.getApplication(), HardCodeUtil.a(2131689698), 1).a();
        localActivity = this.this$0.a();
      } while ((localActivity == null) || (localActivity.isFinishing()));
      localActivity.finish();
      return;
    case 102: 
      QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131689699), 0).a();
      this.this$0.e();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131689697), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AEPituCameraUnit.44
 * JD-Core Version:    0.7.0.1
 */