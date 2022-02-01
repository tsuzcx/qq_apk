package cooperation.qzone.contentbox;

import bmyi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import cooperation.qzone.util.QZLog;

public class QZoneMsgManager$2
  implements Runnable
{
  public QZoneMsgManager$2(bmyi parambmyi, QZoneMsgEntityNew paramQZoneMsgEntityNew) {}
  
  public void run()
  {
    EntityManager localEntityManager = null;
    Object localObject4 = null;
    localObject2 = localObject4;
    localObject1 = localEntityManager;
    for (;;)
    {
      try
      {
        localQQAppInterface = this.this$0.a();
        if (localQQAppInterface != null) {
          continue;
        }
        localObject2 = localObject4;
        localObject1 = localEntityManager;
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
        ((EntityManager)localObject1).close();
      }
      return;
      localObject2 = localObject4;
      localObject1 = localEntityManager;
      this.a.writeArkNewsToBuffer();
      localObject2 = localObject4;
      localObject1 = localEntityManager;
      localEntityManager = localQQAppInterface.a().createEntityManager();
      localObject2 = localEntityManager;
      localObject1 = localEntityManager;
      if (this.a.getStatus() == 1000)
      {
        localObject2 = localEntityManager;
        localObject1 = localEntityManager;
        localEntityManager.persist(this.a);
        if (localEntityManager != null) {
          localEntityManager.close();
        }
      }
      else
      {
        localObject2 = localEntityManager;
        localObject1 = localEntityManager;
        localEntityManager.update(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager.2
 * JD-Core Version:    0.7.0.1
 */