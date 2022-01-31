package cooperation.qzone.contentbox;

import atmp;
import atmq;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import cooperation.qzone.util.QZLog;

public class QZoneMsgManager$3
  implements Runnable
{
  public void run()
  {
    atmp localatmp = this.a.getEntityManagerFactory().createEntityManager();
    try
    {
      localatmp.a(QZoneMsgEntityNew.class);
      return;
    }
    catch (Throwable localThrowable)
    {
      QZLog.e("QZoneMsgManager", 1, localThrowable, new Object[0]);
      return;
    }
    finally
    {
      if (localatmp != null) {
        localatmp.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager.3
 * JD-Core Version:    0.7.0.1
 */