package cooperation.qzone.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.Job;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.lang.reflect.Field;

public class QzoneBaseThread
{
  private BaseHandler handler;
  private HandlerThread thread;
  
  public QzoneBaseThread(String paramString, int paramInt)
  {
    this.thread = new HandlerThread(paramString, paramInt);
    this.thread.start();
    this.handler = new BaseHandler(this.thread.getLooper());
  }
  
  private Pair<Object, Runnable> breakRefChain(Runnable paramRunnable)
  {
    Object localObject1 = paramRunnable.getClass();
    Object localObject2;
    try
    {
      localObject2 = ((Class)localObject1).getDeclaredField("this$0");
      ((Field)localObject2).setAccessible(true);
      localObject1 = ((Field)localObject2).get(paramRunnable);
      try
      {
        ((Field)localObject2).set(paramRunnable, null);
      }
      catch (IllegalAccessException localIllegalAccessException1)
      {
        localObject2 = localObject1;
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        localObject2 = localObject1;
      }
      catch (NoSuchFieldException localNoSuchFieldException1)
      {
        localObject2 = localObject1;
      }
      localObject1 = localObject2;
    }
    catch (IllegalAccessException localIllegalAccessException2)
    {
      localObject2 = null;
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break label131;
      }
      QLog.d("ThreadManager", 2, "IllegalAccessException", localIllegalAccessException2);
      localObject1 = localObject2;
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      localObject2 = null;
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break label131;
      }
      QLog.d("ThreadManager", 2, "IllegalArgumentException", localIllegalArgumentException2);
      localObject1 = localObject2;
    }
    catch (NoSuchFieldException localNoSuchFieldException2)
    {
      localObject2 = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("ThreadManager", 2, "NoSuchFieldException", localNoSuchFieldException2);
      localObject1 = localObject2;
    }
    label131:
    return new Pair(localObject1, paramRunnable);
  }
  
  private Runnable buildJob(Runnable paramRunnable, boolean paramBoolean)
  {
    Object localObject = breakRefChain(paramRunnable);
    try
    {
      localObject = new Job(((Pair)localObject).first, (Runnable)((Pair)localObject).second, paramBoolean);
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("buildJob ");
      localStringBuilder.append(paramRunnable);
      QLog.e("ThreadManager", 1, localStringBuilder.toString(), localOutOfMemoryError);
    }
    return null;
  }
  
  public Handler getHandler()
  {
    return this.handler;
  }
  
  public HandlerThread getHandlerThread()
  {
    return this.thread;
  }
  
  public Looper getLooper()
  {
    return this.thread.getLooper();
  }
  
  public boolean isAlive()
  {
    return this.thread.isAlive();
  }
  
  public void post(Runnable paramRunnable)
  {
    postDelayed(paramRunnable, 0L);
  }
  
  public void postDelayed(Runnable paramRunnable, long paramLong)
  {
    this.handler.postDelayed(paramRunnable, paramLong);
  }
  
  public void postIrrevocableTask(Runnable paramRunnable)
  {
    postIrrevocableTask(paramRunnable, 0L);
  }
  
  public void postIrrevocableTask(Runnable paramRunnable, long paramLong)
  {
    postDelayed(buildJob(paramRunnable, true), paramLong);
  }
  
  public void removeTask(Runnable paramRunnable)
  {
    this.handler.removeCallbacks(paramRunnable);
  }
  
  public void setDaemon(boolean paramBoolean)
  {
    this.thread.setDaemon(paramBoolean);
  }
  
  public void start()
  {
    this.thread.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.thread.QzoneBaseThread
 * JD-Core Version:    0.7.0.1
 */