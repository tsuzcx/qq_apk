package cooperation.qzone.contentbox;

import awbw;
import awbx;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import cooperation.qzone.util.QZLog;

public class QZoneMsgManager$3
  implements Runnable
{
  public void run()
  {
    awbw localawbw = this.a.getEntityManagerFactory().createEntityManager();
    try
    {
      localawbw.a(QZoneMsgEntityNew.class);
      return;
    }
    catch (Throwable localThrowable)
    {
      QZLog.e("QZoneMsgManager", 1, localThrowable, new Object[0]);
      return;
    }
    finally
    {
      if (localawbw != null) {
        localawbw.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager.3
 * JD-Core Version:    0.7.0.1
 */