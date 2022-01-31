import android.os.Message;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.upgrade.UpgradeTIMWrapper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class scx
  implements Runnable
{
  scx(scu paramscu) {}
  
  public void run()
  {
    long l = SharedPreUtils.a(this.a.a.a.getApplication(), this.a.a.a.getCurrentAccountUin());
    if (System.currentTimeMillis() - l >= 86400000L)
    {
      localUpgradeTIMWrapper = UpgradeTIMWrapper.a();
      if (localUpgradeTIMWrapper != null)
      {
        localMessage = this.a.a.b.obtainMessage(1134045);
        localMessage.obj = localUpgradeTIMWrapper;
        this.a.a.a(new scy(this, localMessage));
      }
    }
    while (!QLog.isColorLevel())
    {
      UpgradeTIMWrapper localUpgradeTIMWrapper;
      Message localMessage;
      return;
    }
    QLog.e("UpgradeTIMWrapper", 2, "Conversation onReceiveShowTIMUpgradeTips smaller than 24 hours");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     scx
 * JD-Core Version:    0.7.0.1
 */