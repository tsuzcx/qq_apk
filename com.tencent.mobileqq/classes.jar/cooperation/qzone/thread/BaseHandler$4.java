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
      int i;
      if (BaseHandler.access$400(BaseHandler.access$300(Thread.currentThread().getName()))) {
        i = BaseHandler.regulalteCount.incrementAndGet();
      } else {
        i = BaseHandler.regulalteCount.get();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("regultorPriority ThreadName:");
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append("(");
      localStringBuilder.append(Long.valueOf(l));
      localStringBuilder.append(") currentPriority: ");
      localStringBuilder.append(j);
      localStringBuilder.append(",changed:");
      localStringBuilder.append(Process.getThreadPriority(Process.myTid()));
      localStringBuilder.append(" regulated:");
      localStringBuilder.append(i);
      QLog.i("BaseHandler", 1, localStringBuilder.toString());
      return;
    }
    catch (Exception localException)
    {
      QLog.w("BaseHandler", 1, "", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.thread.BaseHandler.4
 * JD-Core Version:    0.7.0.1
 */