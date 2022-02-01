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
      if (BaseHandler.access$400(i)) {
        i = BaseHandler.regulalteCount.decrementAndGet();
      } else {
        i = BaseHandler.regulalteCount.get();
      }
      Object localObject = Looper.myLooper();
      if (localObject != null) {
        ((Looper)localObject).setMessageLogging(null);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resetPriority ThreadName:");
      ((StringBuilder)localObject).append(Thread.currentThread().getName());
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(") currentPriority: ");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(",changed:");
      ((StringBuilder)localObject).append(Process.getThreadPriority(Process.myTid()));
      ((StringBuilder)localObject).append(" regulated:");
      ((StringBuilder)localObject).append(i);
      QLog.i("BaseHandler", 1, ((StringBuilder)localObject).toString());
      return;
    }
    catch (Exception localException)
    {
      QLog.w("BaseHandler", 1, "", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.thread.BaseHandler.5
 * JD-Core Version:    0.7.0.1
 */