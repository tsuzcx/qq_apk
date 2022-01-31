package cooperation.qzone.contentbox;

import awgf;
import awgg;
import bjiy;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import cooperation.qzone.util.QZLog;

public class QZoneMsgManager$2
  implements Runnable
{
  public QZoneMsgManager$2(bjiy parambjiy, QZoneMsgEntityNew paramQZoneMsgEntityNew) {}
  
  public void run()
  {
    awgf localawgf = null;
    Object localObject4 = null;
    localObject2 = localObject4;
    localObject1 = localawgf;
    for (;;)
    {
      try
      {
        localQQAppInterface = this.this$0.a();
        if (localQQAppInterface != null) {
          continue;
        }
        localObject2 = localObject4;
        localObject1 = localawgf;
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
        ((awgf)localObject1).a();
      }
      return;
      localObject2 = localObject4;
      localObject1 = localawgf;
      this.a.writeArkNewsToBuffer();
      localObject2 = localObject4;
      localObject1 = localawgf;
      localawgf = localQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject2 = localawgf;
      localObject1 = localawgf;
      if (this.a.getStatus() == 1000)
      {
        localObject2 = localawgf;
        localObject1 = localawgf;
        localawgf.a(this.a);
        if (localawgf != null) {
          localawgf.a();
        }
      }
      else
      {
        localObject2 = localawgf;
        localObject1 = localawgf;
        localawgf.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager.2
 * JD-Core Version:    0.7.0.1
 */