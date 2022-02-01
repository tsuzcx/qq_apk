package cooperation.qzone.contentbox;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import cooperation.qzone.util.QZLog;

class QZoneMsgManager$3
  implements Runnable
{
  QZoneMsgManager$3(QZoneMsgManager paramQZoneMsgManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    EntityManager localEntityManager = this.val$app.getEntityManagerFactory().createEntityManager();
    try
    {
      localEntityManager.drop(QZoneMsgEntityNew.class);
      return;
    }
    catch (Throwable localThrowable)
    {
      QZLog.e("QZoneMsgManager", 1, localThrowable, new Object[0]);
      return;
    }
    finally
    {
      if (localEntityManager != null) {
        localEntityManager.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager.3
 * JD-Core Version:    0.7.0.1
 */