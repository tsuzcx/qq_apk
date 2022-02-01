package com.tencent.mobileqq.kandian.base.utils;

import android.os.Handler;
import android.os.Looper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

public class RIJThreadHandler
{
  private static Handler a;
  private static Handler b;
  private static ReadInJoySSOHandlerThread c;
  private static Queue<Integer> d = new LinkedBlockingQueue(100);
  private static String e = null;
  
  public static Handler a()
  {
    try
    {
      if (c == null)
      {
        c = new ReadInJoySSOHandlerThread("kandian_network_thread");
        c.start();
        a = new Handler(c.getLooper());
      }
      Handler localHandler = a;
      return localHandler;
    }
    finally {}
  }
  
  public static void a(int paramInt)
  {
    if (d == null) {
      d = new LinkedBlockingQueue(100);
    }
    if (!d.offer(Integer.valueOf(paramInt)))
    {
      d.poll();
      d.offer(Integer.valueOf(paramInt));
    }
  }
  
  public static void a(long paramLong)
  {
    c();
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("_");
    localStringBuilder.append(l);
    e = localStringBuilder.toString();
  }
  
  public static void a(String paramString, Runnable paramRunnable, ExecutorService paramExecutorService)
  {
    if ((paramExecutorService != null) && (!paramExecutorService.isShutdown()))
    {
      paramExecutorService.execute(paramRunnable);
      return;
    }
    QLog.d("RIJThreadHandler", 2, new Object[] { paramString, " runInSubThread failed, executorService is null or shutdown." });
  }
  
  public static Handler b()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new Handler(Looper.getMainLooper());
        }
      }
      finally {}
    }
    return b;
  }
  
  public static void c()
  {
    Queue localQueue = d;
    if (localQueue != null) {
      localQueue.clear();
    }
  }
  
  public static List<Integer> d()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = d;
    if (localObject != null)
    {
      localObject = ((Queue)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add((Integer)((Iterator)localObject).next());
      }
    }
    return localArrayList;
  }
  
  public static String e()
  {
    String str2 = e;
    String str1 = str2;
    if (str2 == null) {
      str1 = "0";
    }
    return str1;
  }
  
  public static boolean f()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler
 * JD-Core Version:    0.7.0.1
 */