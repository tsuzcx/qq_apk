package com.tencent.qqperf.opt.suspendthread;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SuspendThreadManager
{
  public static int a = 0;
  private static int b;
  private static int c;
  private static int d;
  private static ArrayList<String> e = new ArrayList();
  private static ArrayList<String> f = new ArrayList();
  private static ArrayList<Thread> g = new ArrayList();
  private static ArrayList<Thread> h = new ArrayList();
  private static Map<Integer, Thread> i = new HashMap();
  private static Map<Thread, Integer> j = new HashMap();
  private static volatile SuspendThreadManager k;
  private static boolean l = false;
  private static long m = 20L;
  private static boolean n = false;
  private static int p = 3;
  private static int q = 3;
  private static boolean r = false;
  private static int s = 0;
  private static SuspendThreadManager.GuardThreadHandler t;
  private static HandlerThread u;
  private boolean o = false;
  
  private SuspendThreadManager(String paramString)
  {
    u = new HandlerThread(paramString);
    u.start();
    t = new SuspendThreadManager.GuardThreadHandler(this, u.getLooper());
  }
  
  private int a(Thread paramThread, int paramInt)
  {
    if (!n) {
      paramInt = resumeThreadArt(c(paramThread), paramInt);
    } else {
      paramInt = resumeThreadDalvik(c(paramThread));
    }
    if (-1 == paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resumeThread Fail,thread = ");
      localStringBuilder.append(paramThread);
      QLog.i("TSManager", 1, localStringBuilder.toString());
    }
    return paramInt;
  }
  
  public static SuspendThreadManager a()
  {
    if (k == null) {
      try
      {
        if (k == null) {
          k = new SuspendThreadManager("SuspendGuardThread");
        }
      }
      finally {}
    }
    return k;
  }
  
  private static Object a(Object paramObject, String paramString)
  {
    try
    {
      paramString = Thread.class.getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramObject = paramString.get(paramObject);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      QLog.d("TSManager", 1, "getPrivateField", paramObject);
    }
    return null;
  }
  
  private String a(Thread paramThread, String paramString)
  {
    if (paramThread != null)
    {
      paramThread = paramThread.getStackTrace();
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("reason:");
      localStringBuilder2.append(paramString);
      localStringBuilder2.append("\n");
      localStringBuilder1.append(localStringBuilder2.toString());
      int i1 = 0;
      while ((i1 < paramThread.length) && (i1 < 30))
      {
        localStringBuilder1.append(paramThread[i1].toString());
        localStringBuilder1.append("\n");
        i1 += 1;
      }
      return localStringBuilder1.toString();
    }
    return "";
  }
  
  private static Object b(Object paramObject, String paramString)
  {
    try
    {
      paramString = paramObject.getClass().getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramObject = paramString.get(paramObject);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      QLog.e("TSManager", 1, "getDalvikPrivateField", paramObject);
    }
    return null;
  }
  
  private void b(Thread paramThread)
  {
    int i1;
    if (!n)
    {
      int i2 = suspendThreadArt(c(paramThread), b);
      i1 = i2;
      if (i2 != 0)
      {
        i.put(Integer.valueOf(i2), paramThread);
        i1 = i2;
      }
    }
    else
    {
      i1 = suspendThreadDalvik(c(paramThread));
    }
    if (-1 == i1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("suspendThread Fail,thread = ");
      localStringBuilder.append(paramThread);
      QLog.i("TSManager", 1, localStringBuilder.toString());
    }
  }
  
  private static int c(Thread paramThread)
  {
    try
    {
      Object localObject = (Integer)j.get(paramThread);
      if ((localObject != null) && (((Integer)localObject).intValue() != 0)) {
        return ((Integer)localObject).intValue();
      }
      int i1;
      if (!n)
      {
        localObject = (Long)a(paramThread, "nativePeer");
        if (localObject != null)
        {
          i1 = ((Long)localObject).intValue();
          j.put(paramThread, Integer.valueOf(i1));
          return i1;
        }
      }
      else if (n)
      {
        localObject = a(paramThread, "vmThread");
        if (localObject != null)
        {
          localObject = (Integer)b(localObject, "vmData");
          if (localObject != null)
          {
            i1 = ((Integer)localObject).intValue();
            j.put(paramThread, Integer.valueOf(i1));
            return i1;
          }
        }
        return 0;
      }
    }
    catch (Throwable paramThread)
    {
      QLog.e("TSManager", 1, "getNativeThreadAddr", paramThread);
    }
    return -1;
  }
  
  private void d(boolean paramBoolean)
  {
    try
    {
      if (!h.isEmpty()) {
        break label265;
      }
      Thread[] arrayOfThread = w();
      i2 = arrayOfThread.length;
      i1 = 0;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        int i2;
        int i1;
        Object localObject3;
        label265:
        continue;
        label271:
        if (i1 < i2)
        {
          localObject3 = localThrowable[i1];
          if (localObject3 != null) {}
        }
      }
    }
    if ((!f.contains(localObject3.getName())) && (!g.contains(localObject3)) && (!localObject3.getName().contains("Binder")) && (!localObject3.getName().contains("RenderThread")) && (!localObject3.getName().contains("Automator")) && (!localObject3.getName().contains("thread_sp")) && (!localObject3.getName().contains("logWriteThread")) && (!localObject3.getName().contains("Bugly")))
    {
      if ((localObject3.isAlive()) && (paramBoolean) && (e.contains(localObject3.getName())))
      {
        a().b(localObject3);
        synchronized (h)
        {
          h.add(localObject3);
        }
      }
      if ((!paramBoolean) && (localObject3.isAlive()))
      {
        a().b(localObject3);
        synchronized (h)
        {
          h.add(localObject3);
        }
      }
    }
    i1 += 1;
    break label271;
    e(b);
  }
  
  private void e(int paramInt)
  {
    r = false;
    synchronized (h)
    {
      if (!h.isEmpty())
      {
        Iterator localIterator = h.iterator();
        while (localIterator.hasNext()) {
          if (a((Thread)localIterator.next(), paramInt) == 2) {
            r = true;
          }
        }
        h.clear();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private native int getContentThreadIdArt(int paramInt);
  
  private native int nativeInit(boolean paramBoolean, int paramInt);
  
  private native int resumeThreadArt(int paramInt1, int paramInt2);
  
  private native int resumeThreadDalvik(int paramInt);
  
  private native int suspendThreadArt(int paramInt1, int paramInt2);
  
  private native int suspendThreadDalvik(int paramInt);
  
  private static boolean v()
  {
    if ((Long)a(Thread.currentThread(), "nativePeer") != null)
    {
      QLog.i("TSManager", 1, "ART Mode");
      return false;
    }
    Object localObject = a(Thread.currentThread(), "vmThread");
    if (localObject != null)
    {
      localObject = (Integer)b(localObject, "vmData");
      int i1;
      if (localObject != null) {
        i1 = ((Integer)localObject).intValue();
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        QLog.i("TSManager", 1, "Dalvik Mode");
        return true;
      }
    }
    QLog.i("TSManager", 1, "default ART Mode");
    return false;
  }
  
  private static Thread[] w()
  {
    try
    {
      ThreadGroup localThreadGroup = Thread.currentThread().getThreadGroup();
      Thread[] arrayOfThread = new Thread[localThreadGroup.activeCount()];
      localThreadGroup.enumerate(arrayOfThread);
      return arrayOfThread;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("TSManager", 1, "getThreads", localThrowable);
    }
    return new Thread[0];
  }
  
  public void a(String paramString)
  {
    e.add(paramString);
  }
  
  public void b()
  {
    if (!this.o)
    {
      SuspendThreadManager.GuardThreadHandler localGuardThreadHandler = t;
      if ((localGuardThreadHandler != null) && (u != null))
      {
        localGuardThreadHandler.obtainMessage(1).sendToTarget();
        this.o = true;
      }
    }
  }
  
  public void c()
  {
    Object localObject = DeviceOptSwitch.a();
    int i1 = ((SharedPreferences)localObject).getInt("suspendCrashCount", 0);
    localObject = ((SharedPreferences)localObject).edit();
    i1 += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SuspendThreadManager has crashed ");
    localStringBuilder.append(i1);
    localStringBuilder.append(" times");
    QLog.d("TSManager", 1, localStringBuilder.toString());
    ((SharedPreferences.Editor)localObject).putInt("suspendCrashCount", i1);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void d()
  {
    if (!l)
    {
      QLog.i("TSManager", 1, "suspendThreads faild");
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    t.sendMessage(localMessage);
  }
  
  public void e()
  {
    if (!l)
    {
      QLog.i("TSManager", 1, "resumeThreads faild");
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    t.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.opt.suspendthread.SuspendThreadManager
 * JD-Core Version:    0.7.0.1
 */