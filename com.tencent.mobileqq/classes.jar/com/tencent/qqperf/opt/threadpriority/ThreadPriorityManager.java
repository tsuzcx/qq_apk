package com.tencent.qqperf.opt.threadpriority;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ThreadPriorityManager
{
  private static int a = 1;
  private static HashMap<Long, Integer> b = new HashMap(40);
  private static Handler c = new ThreadPriorityManager.1(ThreadManager.getSubThreadLooper());
  
  public static void a(boolean paramBoolean)
  {
    Handler localHandler = c;
    int i;
    if (paramBoolean) {
      i = 2;
    } else {
      i = 1;
    }
    localHandler.sendEmptyMessage(i);
  }
  
  private static void c()
  {
    c.removeMessages(1);
    c.sendEmptyMessageDelayed(1, 30000L);
    if (b.size() > 0) {
      return;
    }
    Thread[] arrayOfThread = d();
    if (arrayOfThread.length < 2)
    {
      c.removeMessages(1);
      return;
    }
    Thread localThread1 = Looper.getMainLooper().getThread();
    Thread localThread2 = ThreadManager.getSubThread();
    int j = arrayOfThread.length;
    int i = 0;
    while (i < j)
    {
      Thread localThread3 = arrayOfThread[i];
      if ((localThread3 != null) && (localThread1 != null) && (localThread2 != null) && (localThread3.getId() != localThread2.getId()) && (localThread3.getId() != localThread1.getId()) && (localThread3.isAlive())) {}
      try
      {
        l = localThread3.getId();
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        long l;
        label165:
        label168:
        label172:
        break label168;
      }
      try
      {
        b.put(Long.valueOf(l), Integer.valueOf(localThread3.getPriority()));
        localThread3.setPriority(a);
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        break label165;
      }
      break label172;
      l = -1L;
      if (l != -1L) {
        b.remove(Long.valueOf(l));
      }
      i += 1;
    }
  }
  
  private static Thread[] d()
  {
    try
    {
      ThreadGroup localThreadGroup = Thread.currentThread().getThreadGroup();
      Thread[] arrayOfThread = new Thread[localThreadGroup.activeCount()];
      localThreadGroup.enumerate(arrayOfThread);
      return arrayOfThread;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThreadPriorityManager", 2, "", localException);
      }
    }
    return new Thread[0];
  }
  
  private static void e()
  {
    if (b.size() <= 0) {
      return;
    }
    Thread[] arrayOfThread = d();
    int m = arrayOfThread.length;
    int j = 0;
    int k;
    for (int i = 0; j < m; i = k)
    {
      Thread localThread = arrayOfThread[j];
      k = i;
      if (localThread != null)
      {
        k = i;
        if (localThread.isAlive())
        {
          Integer localInteger = (Integer)b.get(Long.valueOf(localThread.getId()));
          if (localInteger != null) {
            i = localInteger.intValue();
          }
          if ((i == 0) || (i > 10) || (i < 1)) {}
        }
      }
      try
      {
        localThread.setPriority(i);
        k = i;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        break label118;
      }
      localThread.setPriority(5);
      k = i;
      break label128;
      label118:
      QLog.e("ThreadPriorityManager", 1, "setPriority error");
      k = i;
      label128:
      j += 1;
    }
    b.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager
 * JD-Core Version:    0.7.0.1
 */