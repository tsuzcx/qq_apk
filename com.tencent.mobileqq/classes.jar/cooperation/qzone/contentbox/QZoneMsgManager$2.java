package cooperation.qzone.contentbox;

import atmp;
import atmq;
import bfug;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import cooperation.qzone.util.QZLog;

public class QZoneMsgManager$2
  implements Runnable
{
  public QZoneMsgManager$2(bfug parambfug, QZoneMsgEntityNew paramQZoneMsgEntityNew) {}
  
  public void run()
  {
    atmp localatmp = null;
    Object localObject4 = null;
    localObject2 = localObject4;
    localObject1 = localatmp;
    for (;;)
    {
      try
      {
        localQQAppInterface = this.this$0.a();
        if (localQQAppInterface != null) {
          continue;
        }
        localObject2 = localObject4;
        localObject1 = localatmp;
        QZLog.e("QZoneMsgManager", "saveMsgToDB error app == null");
        if (0 != 0) {
          throw new NullPointerException();
        }
      }
      catch (Throwable localThrowable)
      {
        QQAppInterface localQQAppInterface;
        localObject1 = localObject2;
        QZLog.e("QZoneMsgManager", 1, localThrowable, new Object[0]);
        return;
      }
      finally
      {
        if (localObject1 == null) {
          continue;
        }
        ((atmp)localObject1).a();
      }
      return;
      localObject2 = localObject4;
      localObject1 = localatmp;
      this.a.writeArkNewsToBuffer();
      localObject2 = localObject4;
      localObject1 = localatmp;
      localatmp = localQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject2 = localatmp;
      localObject1 = localatmp;
      if (this.a.getStatus() == 1000)
      {
        localObject2 = localatmp;
        localObject1 = localatmp;
        localatmp.a(this.a);
        if (localatmp != null) {
          localatmp.a();
        }
      }
      else
      {
        localObject2 = localatmp;
        localObject1 = localatmp;
        localatmp.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager.2
 * JD-Core Version:    0.7.0.1
 */