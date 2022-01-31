package cooperation.qzone.thread;

import android.os.Looper;
import android.os.Process;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

final class BaseHandler$5
  implements Runnable
{
  public void run()
  {
    try
    {
      int i = ((Integer)BaseHandler.InitalPriority.get()).intValue();
      int j = Process.getThreadPriority(Process.myTid());
      long l = Thread.currentThread().getId();
      BaseHandler.isRegulated.set(Boolean.valueOf(false));
      BaseHandler.InitalPriority.remove();
      BaseHandler.access$400(i);
      if (BaseHandler.access$400(i)) {}
      for (i = BaseHandler.regulalteCount.decrementAndGet();; i = BaseHandler.regulalteCount.get())
      {
        Looper localLooper = Looper.myLooper();
        if (localLooper != null) {
          localLooper.setMessageLogging(null);
        }
        QLog.i("BaseHandler", 1, "resetPriority ThreadName:" + Thread.currentThread().getName() + "(" + l + ") currentPriority: " + j + ",changed:" + Process.getThreadPriority(Process.myTid()) + " regulated:" + i);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.w("BaseHandler", 1, "", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.thread.BaseHandler.5
 * JD-Core Version:    0.7.0.1
 */