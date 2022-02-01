import android.os.Handler;
import android.os.Looper;
import com.tencent.av.wtogether.util.TheadUtils.3;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class mzu
{
  public static <V> V a(Handler paramHandler, Callable<V> paramCallable)
  {
    if (paramHandler.getLooper().getThread() == Thread.currentThread()) {
      try
      {
        paramHandler = paramCallable.call();
        return paramHandler;
      }
      catch (Exception paramHandler)
      {
        throw new RuntimeException(paramHandler);
      }
    }
    mzw localmzw = new mzw();
    mzv localmzv = new mzv();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    paramHandler.post(new TheadUtils.3(localmzw, paramCallable, localmzv, localCountDownLatch));
    a(localCountDownLatch);
    if (localmzv.a != null)
    {
      paramHandler = new RuntimeException(localmzv.a);
      paramHandler.setStackTrace(a(localmzv.a.getStackTrace(), paramHandler.getStackTrace()));
      throw paramHandler;
    }
    return localmzw.a;
  }
  
  public static void a(Handler paramHandler, Runnable paramRunnable)
  {
    a(paramHandler, new mzy(paramRunnable));
  }
  
  public static void a(CountDownLatch paramCountDownLatch)
  {
    a(new mzx(paramCountDownLatch));
  }
  
  public static void a(mzz parammzz)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        parammzz.a();
        if (i != 0) {
          Thread.currentThread().interrupt();
        }
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        i = 1;
      }
    }
  }
  
  static StackTraceElement[] a(StackTraceElement[] paramArrayOfStackTraceElement1, StackTraceElement[] paramArrayOfStackTraceElement2)
  {
    StackTraceElement[] arrayOfStackTraceElement = new StackTraceElement[paramArrayOfStackTraceElement1.length + paramArrayOfStackTraceElement2.length];
    System.arraycopy(paramArrayOfStackTraceElement1, 0, arrayOfStackTraceElement, 0, paramArrayOfStackTraceElement1.length);
    System.arraycopy(paramArrayOfStackTraceElement2, 0, arrayOfStackTraceElement, paramArrayOfStackTraceElement1.length, paramArrayOfStackTraceElement2.length);
    return arrayOfStackTraceElement;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mzu
 * JD-Core Version:    0.7.0.1
 */