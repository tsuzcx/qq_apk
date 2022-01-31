import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.QQAppInterface;

public final class reu
  implements Runnable
{
  public reu(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    RecentDataListManager.a().a(this.a, BaseApplicationImpl.sApplication, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     reu
 * JD-Core Version:    0.7.0.1
 */