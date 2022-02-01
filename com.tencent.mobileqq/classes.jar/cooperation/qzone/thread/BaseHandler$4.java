package cooperation.qzone.thread;

import android.os.Process;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

final class BaseHandler$4
  implements Runnable
{
  public void run()
  {
    try
    {
      long l = Thread.currentThread().getId();
      int j = Process.getThreadPriority(Process.myTid());
      BaseHandler.InitalPriority.set(Integer.valueOf(j));
      BaseHandler.isRegulated.set(Boolean.valueOf(true));
      if (BaseHandler.access$400(BaseHandler.access$300(Thread.currentThread().getName()))) {}
      for (int i = BaseHandler.regulalteCount.incrementAndGet();; i = BaseHandler.regulalteCount.get())
      {
        QLog.i("BaseHandler", 1, "regultorPriority ThreadName:" + Thread.currentThread().getName() + "(" + Long.valueOf(l) + ") currentPriority: " + j + ",changed:" + Process.getThreadPriority(Process.myTid()) + " regulated:" + i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.thread.BaseHandler.4
 * JD-Core Version:    0.7.0.1
 */