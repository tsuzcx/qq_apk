package cooperation.qzone.contentbox;

import aukn;
import auko;
import bhcq;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.contentbox.model.QZoneMsgEntityNew;
import cooperation.qzone.util.QZLog;

public class QZoneMsgManager$2
  implements Runnable
{
  public QZoneMsgManager$2(bhcq parambhcq, QZoneMsgEntityNew paramQZoneMsgEntityNew) {}
  
  public void run()
  {
    Object localObject3 = null;
    aukn localaukn2 = null;
    localaukn1 = localaukn2;
    localObject1 = localObject3;
    for (;;)
    {
      try
      {
        localQQAppInterface = this.this$0.a();
        if (localQQAppInterface != null) {
          continue;
        }
        localaukn1 = localaukn2;
        localObject1 = localObject3;
        QZLog.e("QZoneMsgManager", "saveMsgToDB error app == null");
        if (0 != 0) {
          throw new NullPointerException();
        }
      }
      catch (Throwable localThrowable)
      {
        QQAppInterface localQQAppInterface;
        localObject1 = localaukn1;
        QZLog.e("QZoneMsgManager", 1, localThrowable, new Object[0]);
        if (localaukn1 == null) {
          continue;
        }
        localaukn1.a();
        return;
      }
      finally
      {
        if (localObject1 == null) {
          continue;
        }
        ((aukn)localObject1).a();
      }
      return;
      localaukn1 = localaukn2;
      localObject1 = localObject3;
      this.a.writeArkNewsToBuffer();
      localaukn1 = localaukn2;
      localObject1 = localObject3;
      localaukn2 = localQQAppInterface.getEntityManagerFactory().createEntityManager();
      localaukn1 = localaukn2;
      localObject1 = localaukn2;
      if (this.a.getStatus() == 1000)
      {
        localaukn1 = localaukn2;
        localObject1 = localaukn2;
        localaukn2.a(this.a);
        if (localaukn2 != null) {
          localaukn2.a();
        }
      }
      else
      {
        localaukn1 = localaukn2;
        localObject1 = localaukn2;
        localaukn2.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.contentbox.QZoneMsgManager.2
 * JD-Core Version:    0.7.0.1
 */