import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class tfs
  implements Runnable
{
  public tfs(QQLSActivity paramQQLSActivity) {}
  
  public void run()
  {
    try
    {
      if (QQLSActivity.a(this.a) == 1)
      {
        BaseApplicationImpl.getContext().unregisterReceiver(this.a.a);
        QQLSActivity.a(this.a, 0);
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "unRegisterScreenListener");
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("QQLSActivity", 2, "unRegisterScreenListener:" + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tfs
 * JD-Core Version:    0.7.0.1
 */