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
  public static int a;
  private static long jdField_a_of_type_Long;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private static SuspendThreadManager.GuardThreadHandler jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager$GuardThreadHandler;
  private static volatile SuspendThreadManager jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager;
  private static ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static Map<Integer, Thread> jdField_a_of_type_JavaUtilMap;
  private static boolean jdField_a_of_type_Boolean;
  private static int jdField_b_of_type_Int;
  private static ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private static Map<Thread, Integer> jdField_b_of_type_JavaUtilMap;
  private static boolean jdField_b_of_type_Boolean;
  private static int jdField_c_of_type_Int;
  private static ArrayList<Thread> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private static int jdField_d_of_type_Int;
  private static ArrayList<Thread> jdField_d_of_type_JavaUtilArrayList = new ArrayList();
  private static boolean jdField_d_of_type_Boolean;
  private static int e;
  private static int f;
  private static int g;
  private boolean jdField_c_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_Boolean = false;
    jdField_a_of_type_Long = 20L;
    jdField_b_of_type_Boolean = false;
    e = 3;
    f = 3;
    jdField_d_of_type_Boolean = false;
    g = 0;
    jdField_a_of_type_Int = 0;
  }
  
  private SuspendThreadManager(String paramString)
  {
    jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread(paramString);
    jdField_a_of_type_AndroidOsHandlerThread.start();
    jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager$GuardThreadHandler = new SuspendThreadManager.GuardThreadHandler(this, jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  private int a(Thread paramThread, int paramInt)
  {
    if (!jdField_b_of_type_Boolean) {
      paramInt = resumeThreadArt(b(paramThread), paramInt);
    } else {
      paramInt = resumeThreadDalvik(b(paramThread));
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
    if (jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager == null) {
          jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager = new SuspendThreadManager("SuspendGuardThread");
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager;
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
      int i = 0;
      while ((i < paramThread.length) && (i < 30))
      {
        localStringBuilder1.append(paramThread[i].toString());
        localStringBuilder1.append("\n");
        i += 1;
      }
      return localStringBuilder1.toString();
    }
    return "";
  }
  
  private void a(int paramInt)
  {
    jdField_d_of_type_Boolean = false;
    synchronized (jdField_d_of_type_JavaUtilArrayList)
    {
      if (!jdField_d_of_type_JavaUtilArrayList.isEmpty())
      {
        Iterator localIterator = jdField_d_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext()) {
          if (a((Thread)localIterator.next(), paramInt) == 2) {
            jdField_d_of_type_Boolean = true;
          }
        }
        jdField_d_of_type_JavaUtilArrayList.clear();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void a(Thread paramThread)
  {
    int i;
    if (!jdField_b_of_type_Boolean)
    {
      int j = suspendThreadArt(b(paramThread), jdField_b_of_type_Int);
      i = j;
      if (j != 0)
      {
        jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(j), paramThread);
        i = j;
      }
    }
    else
    {
      i = suspendThreadDalvik(b(paramThread));
    }
    if (-1 == i)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("suspendThread Fail,thread = ");
      localStringBuilder.append(paramThread);
      QLog.i("TSManager", 1, localStringBuilder.toString());
    }
  }
  
  private void a(boolean paramBoolean)
  {
    try
    {
      if (!jdField_d_of_type_JavaUtilArrayList.isEmpty()) {
        break label264;
      }
      Thread[] arrayOfThread = a();
      j = arrayOfThread.length;
      i = 0;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        int j;
        int i;
        Object localObject3;
        label264:
        continue;
        label270:
        if (i < j)
        {
          localObject3 = localThrowable[i];
          if (localObject3 != null) {}
        }
      }
    }
    if ((!jdField_b_of_type_JavaUtilArrayList.contains(localObject3.getName())) && (!jdField_c_of_type_JavaUtilArrayList.contains(localObject3)) && (!localObject3.getName().contains("Binder")) && (!localObject3.getName().contains("RenderThread")) && (!localObject3.getName().contains("Automator")) && (!localObject3.getName().contains("thread_sp")) && (!localObject3.getName().contains("logWriteThread")) && (!localObject3.getName().contains("Bugly")))
    {
      if ((localObject3.isAlive()) && (paramBoolean) && (jdField_a_of_type_JavaUtilArrayList.contains(localObject3.getName())))
      {
        a().a(localObject3);
        synchronized (jdField_d_of_type_JavaUtilArrayList)
        {
          jdField_d_of_type_JavaUtilArrayList.add(localObject3);
        }
      }
      if ((!paramBoolean) && (localObject3.isAlive()))
      {
        a().a(localObject3);
        synchronized (jdField_d_of_type_JavaUtilArrayList)
        {
          jdField_d_of_type_JavaUtilArrayList.add(localObject3);
        }
      }
    }
    i += 1;
    break label270;
    a(jdField_b_of_type_Int);
  }
  
  private static Thread[] a()
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
  
  private static int b(Thread paramThread)
  {
    try
    {
      Object localObject = (Integer)jdField_b_of_type_JavaUtilMap.get(paramThread);
      if ((localObject != null) && (((Integer)localObject).intValue() != 0)) {
        return ((Integer)localObject).intValue();
      }
      int i;
      if (!jdField_b_of_type_Boolean)
      {
        localObject = (Long)a(paramThread, "nativePeer");
        if (localObject != null)
        {
          i = ((Long)localObject).intValue();
          jdField_b_of_type_JavaUtilMap.put(paramThread, Integer.valueOf(i));
          return i;
        }
      }
      else if (jdField_b_of_type_Boolean)
      {
        localObject = a(paramThread, "vmThread");
        if (localObject != null)
        {
          localObject = (Integer)b(localObject, "vmData");
          if (localObject != null)
          {
            i = ((Integer)localObject).intValue();
            jdField_b_of_type_JavaUtilMap.put(paramThread, Integer.valueOf(i));
            return i;
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
  
  private static boolean e()
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
      int i;
      if (localObject != null) {
        i = ((Integer)localObject).intValue();
      } else {
        i = 0;
      }
      if (i != 0)
      {
        QLog.i("TSManager", 1, "Dalvik Mode");
        return true;
      }
    }
    QLog.i("TSManager", 1, "default ART Mode");
    return false;
  }
  
  private native int getContentThreadIdArt(int paramInt);
  
  private native int nativeInit(boolean paramBoolean, int paramInt);
  
  private native int resumeThreadArt(int paramInt1, int paramInt2);
  
  private native int resumeThreadDalvik(int paramInt);
  
  private native int suspendThreadArt(int paramInt1, int paramInt2);
  
  private native int suspendThreadDalvik(int paramInt);
  
  public void a()
  {
    if (!this.jdField_c_of_type_Boolean)
    {
      SuspendThreadManager.GuardThreadHandler localGuardThreadHandler = jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager$GuardThreadHandler;
      if ((localGuardThreadHandler != null) && (jdField_a_of_type_AndroidOsHandlerThread != null))
      {
        localGuardThreadHandler.obtainMessage(1).sendToTarget();
        this.jdField_c_of_type_Boolean = true;
      }
    }
  }
  
  public void a(String paramString)
  {
    jdField_a_of_type_JavaUtilArrayList.add(paramString);
  }
  
  public void b()
  {
    Object localObject = DeviceOptSwitch.a();
    int i = ((SharedPreferences)localObject).getInt("suspendCrashCount", 0);
    localObject = ((SharedPreferences)localObject).edit();
    i += 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SuspendThreadManager has crashed ");
    localStringBuilder.append(i);
    localStringBuilder.append(" times");
    QLog.d("TSManager", 1, localStringBuilder.toString());
    ((SharedPreferences.Editor)localObject).putInt("suspendCrashCount", i);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void c()
  {
    if (!jdField_a_of_type_Boolean)
    {
      QLog.i("TSManager", 1, "suspendThreads faild");
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager$GuardThreadHandler.sendMessage(localMessage);
  }
  
  public void d()
  {
    if (!jdField_a_of_type_Boolean)
    {
      QLog.i("TSManager", 1, "resumeThreads faild");
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    jdField_a_of_type_ComTencentQqperfOptSuspendthreadSuspendThreadManager$GuardThreadHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.opt.suspendthread.SuspendThreadManager
 * JD-Core Version:    0.7.0.1
 */