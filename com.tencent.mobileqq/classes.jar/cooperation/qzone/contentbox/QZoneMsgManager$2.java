package cooperation.qzone.contentbox;

import awbw;
import awbx;
import bjer;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import cooperation.qzone.util.QZLog;

public class QZoneMsgManager$2
  implements Runnable
{
  public QZoneMsgManager$2(bjer parambjer, QZoneMsgEntityNew paramQZoneMsgEntityNew) {}
  
  public void run()
  {
    Object localObject3 = null;
    awbw localawbw2 = null;
    localawbw1 = localawbw2;
    localObject1 = localObject3;
    for (;;)
    {
      try
      {
        localQQAppInterface = this.this$0.a();
        if (localQQAppInterface != null) {
          continue;
        }
        localawbw1 = localawbw2;
        localObject1 = localObject3;
        QZLog.e("QZoneMsgManager", "saveMsgToDB error app == null");
        if (0 != 0) {
          throw new NullPointerException();
        }
      }
      catch (Throwable localThrowable)
      {
        QQAppInterface localQQAppInterface;
        localObject1 = localawbw1;
        QZLog.e("QZoneMsgManager", 1, localThrowable, new Object[0]);
        if (localawbw1 == null) {
          continue;
        }
        localawbw1.a();
        return;
      }
      finally
      {
        if (localObject1 == null) {
          continue;
        }
        ((awbw)localObject1).a();
      }
      return;
      localawbw1 = localawbw2;
      localObject1 = localObject3;
      this.a.writeArkNewsToBuffer();
      localawbw1 = localawbw2;
      localObject1 = localObject3;
      localawbw2 = localQQAppInterface.getEntityManagerFactory().createEntityManager();
      localawbw1 = localawbw2;
      localObject1 = localawbw2;
      if (this.a.getStatus() == 1000)
      {
        localawbw1 = localawbw2;
        localObject1 = localawbw2;
        localawbw2.a(this.a);
        if (localawbw2 != null) {
          localawbw2.a();
        }
      }
      else
      {
        localawbw1 = localawbw2;
        localObject1 = localawbw2;
        localawbw2.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager.2
 * JD-Core Version:    0.7.0.1
 */