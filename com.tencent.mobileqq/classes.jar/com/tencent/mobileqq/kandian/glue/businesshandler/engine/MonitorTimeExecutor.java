package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Handler;
import android.os.SystemClock;
import android.util.SparseBooleanArray;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.QQCatchedExceptionReporter;
import com.tencent.qqperf.tools.ThreadTraceHelper;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MonitorTimeExecutor
  extends ThreadPoolExecutor
{
  private static boolean a = false;
  private static long b = 5000L;
  private static long c = 30000L;
  private static Handler f;
  private static volatile ThreadPoolExecutor g;
  private SparseBooleanArray d = new SparseBooleanArray();
  private MonitorTimeExecutor.TimeTrackedRunnable e;
  
  private MonitorTimeExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, new ReadInJoyThreadFactory(), new MonitorTimeExecutor.1());
  }
  
  private static String a(Thread paramThread)
  {
    if (paramThread == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("|");
    localStringBuilder.append("pub");
    localStringBuilder.append("|");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append("|");
    localStringBuilder.append(Build.VERSION.RELEASE);
    localStringBuilder.append("|");
    localStringBuilder.append("monitorThread=");
    localStringBuilder.append(paramThread.getName());
    localStringBuilder.append(",tid=");
    localStringBuilder.append(paramThread.getId());
    localStringBuilder.append(",state=");
    localStringBuilder.append(paramThread.getState());
    localStringBuilder.append(ThreadTraceHelper.a());
    localStringBuilder.append(ThreadTraceHelper.b());
    return localStringBuilder.toString();
  }
  
  public static ExecutorService a()
  {
    if (g == null) {
      try
      {
        if (g == null)
        {
          MonitorTimeExecutor localMonitorTimeExecutor = new MonitorTimeExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
          b(localMonitorTimeExecutor);
          g = localMonitorTimeExecutor;
        }
      }
      finally {}
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[newThreadExecutor]: ");
    localStringBuilder.append(g);
    QLog.i("MonitorTimeExecutor", 1, localStringBuilder.toString());
    return g;
  }
  
  private static boolean a(StringBuilder paramStringBuilder, String paramString)
  {
    QLog.d("MonitorTimeExecutor", 2, "[dumpAllJavaStacks] ");
    for (;;)
    {
      int i;
      try
      {
        Thread[] arrayOfThread = new Thread[Thread.activeCount()];
        Thread.enumerate(arrayOfThread);
        i = 0;
        int j = arrayOfThread.length;
        if (i < j)
        {
          Object localObject = arrayOfThread[i];
          if (localObject != null)
          {
            paramStringBuilder.append("Name:");
            paramStringBuilder.append(((Thread)localObject).getName());
            paramStringBuilder.append("\n");
            paramStringBuilder.append("State:");
            paramStringBuilder.append(((Thread)localObject).getState());
            paramStringBuilder.append("\n");
            paramStringBuilder.append("Tid:");
            paramStringBuilder.append(((Thread)localObject).getId());
            paramStringBuilder.append("\n");
            if (((Thread)localObject).isAlive())
            {
              localObject = ((Thread)localObject).getStackTrace();
              int k = localObject.length;
              j = 0;
              if (j < k)
              {
                paramStringBuilder.append(localObject[j].toString());
                paramStringBuilder.append("\n");
                j += 1;
                continue;
              }
              paramStringBuilder.append("\n");
            }
          }
        }
        else
        {
          paramStringBuilder.append("\n");
          paramStringBuilder.append(paramString);
          return true;
        }
      }
      catch (Exception paramStringBuilder)
      {
        QLog.e("MonitorTimeExecutor", 1, "[dumpAllJavaStacks] failed ", paramStringBuilder);
        return false;
      }
      i += 1;
    }
  }
  
  private static void b(MonitorTimeExecutor paramMonitorTimeExecutor)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[startWatching] for ");
    localStringBuilder.append(paramMonitorTimeExecutor);
    QLog.i("MonitorTimeExecutor", 1, localStringBuilder.toString());
    if (!((Boolean)RIJSPUtils.b("sp_key_kandian_thread_pool_monitor_enable", Boolean.valueOf(false))).booleanValue())
    {
      QLog.i("MonitorTimeExecutor", 1, "[startWatching] won't start since monitor disabled");
      return;
    }
    b = ((Long)RIJSPUtils.b("sp_key_kandian_thread_pool_check_period", Long.valueOf(5000L))).longValue();
    c = ((Long)RIJSPUtils.b("sp_key_kandian_thread_pool_time_out_threshold", Long.valueOf(30000L))).longValue();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[startWatching] CHECK_PERIOD=");
    localStringBuilder.append(b);
    localStringBuilder.append(" THRESHOLD=");
    localStringBuilder.append(c);
    QLog.i("MonitorTimeExecutor", 1, localStringBuilder.toString());
    if (f == null) {
      f = new Handler(ThreadManager.getFileThreadLooper());
    }
    f.post(new MonitorTimeExecutor.WatchDogRunnable(paramMonitorTimeExecutor, null));
  }
  
  private static void c(MonitorTimeExecutor paramMonitorTimeExecutor)
  {
    MonitorTimeExecutor.TimeTrackedRunnable localTimeTrackedRunnable = paramMonitorTimeExecutor.b();
    if ((localTimeTrackedRunnable != null) && (MonitorTimeExecutor.TimeTrackedRunnable.a(localTimeTrackedRunnable) > 0L))
    {
      long l = SystemClock.uptimeMillis() - MonitorTimeExecutor.TimeTrackedRunnable.a(localTimeTrackedRunnable);
      Object localObject1;
      if (a)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[run] currentTask=");
        ((StringBuilder)localObject1).append(localTimeTrackedRunnable);
        ((StringBuilder)localObject1).append(" running for ");
        ((StringBuilder)localObject1).append(l);
        ((StringBuilder)localObject1).append("ms");
        QLog.d("MonitorTimeExecutor", 2, ((StringBuilder)localObject1).toString());
      }
      if ((l > c) && (!Debug.isDebuggerConnected()))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[run] time limit exceed!, task=");
        ((StringBuilder)localObject1).append(localTimeTrackedRunnable);
        QLog.e("MonitorTimeExecutor", 1, ((StringBuilder)localObject1).toString());
        if (paramMonitorTimeExecutor.d.get(localTimeTrackedRunnable.b().hashCode(), false))
        {
          QLog.i("MonitorTimeExecutor", 1, "[checkBlockingState] skip task since already reported");
          return;
        }
        String str = a(localTimeTrackedRunnable.a());
        localObject1 = str;
        try
        {
          Object localObject2 = ThreadTraceHelper.a("kandian");
          localObject1 = str;
          int i = ThreadTraceHelper.a(BaseApplication.getContext(), (String)localObject2, str);
          if (i == 1)
          {
            localObject1 = str;
            Object localObject3 = new StringBuilder();
            localObject1 = str;
            ((StringBuilder)localObject3).append("[checkBlockingState] trace dumped: ");
            localObject1 = str;
            ((StringBuilder)localObject3).append((String)localObject2);
            localObject1 = str;
            QLog.i("MonitorTimeExecutor", 1, ((StringBuilder)localObject3).toString());
            localObject1 = str;
            localObject3 = new FileInputStream((String)localObject2);
            localObject1 = str;
            str = Util.a((InputStream)localObject3);
            localObject1 = str;
            ((FileInputStream)localObject3).close();
            localObject1 = str;
            Util.b((String)localObject2);
            localObject1 = str;
          }
          else
          {
            localObject1 = str;
            localObject2 = new StringBuilder();
            localObject1 = str;
            ((StringBuilder)localObject2).append("[checkBlockingState] dump thread result: ");
            localObject1 = str;
            ((StringBuilder)localObject2).append(i);
            localObject1 = str;
            QLog.e("MonitorTimeExecutor", 1, ((StringBuilder)localObject2).toString());
            localObject1 = str;
            localObject2 = new StringBuilder();
            localObject1 = str;
            if (a((StringBuilder)localObject2, str))
            {
              localObject1 = str;
              str = ((StringBuilder)localObject2).toString();
              localObject1 = str;
            }
            else
            {
              localObject1 = str;
              QLog.d("MonitorTimeExecutor", 2, "[dumpAllJavaStacks] failed");
              localObject1 = str;
            }
          }
        }
        catch (Exception localException)
        {
          QLog.e("MonitorTimeExecutor", 1, "[checkBlockingState] ", localException);
        }
        QQCatchedExceptionReporter.reportQQCatchedException(new MonitorTimeExecutor.KandianTaskRunningTooLongException(null), "", (String)localObject1);
        paramMonitorTimeExecutor.d.put(localTimeTrackedRunnable.b().hashCode(), true);
      }
    }
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable paramThrowable)
  {
    super.afterExecute(paramRunnable, paramThrowable);
    if (this.e == paramRunnable) {
      this.e = null;
    }
  }
  
  public MonitorTimeExecutor.TimeTrackedRunnable b()
  {
    return this.e;
  }
  
  protected void beforeExecute(Thread paramThread, Runnable paramRunnable)
  {
    super.beforeExecute(paramThread, paramRunnable);
    if ((paramRunnable instanceof MonitorTimeExecutor.TimeTrackedRunnable)) {
      this.e = ((MonitorTimeExecutor.TimeTrackedRunnable)paramRunnable);
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    super.execute(new MonitorTimeExecutor.TimeTrackedRunnable(paramRunnable, null));
  }
  
  public void shutdown()
  {
    QLog.i("MonitorTimeExecutor", 1, "[shutdown]");
  }
  
  public List<Runnable> shutdownNow()
  {
    QLog.i("MonitorTimeExecutor", 1, "[shutdownNow]");
    return Collections.emptyList();
  }
  
  public Future<?> submit(Runnable paramRunnable)
  {
    return super.submit(new MonitorTimeExecutor.TimeTrackedRunnable(paramRunnable, null));
  }
  
  public <T> Future<T> submit(Runnable paramRunnable, T paramT)
  {
    return super.submit(new MonitorTimeExecutor.TimeTrackedRunnable(paramRunnable, null), paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.MonitorTimeExecutor
 * JD-Core Version:    0.7.0.1
 */