package com.tencent.mobileqq.statistics.thread;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import android.os.Message;
import bcad;
import bcgk;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SuspendThreadManager
{
  public static int a;
  private static long jdField_a_of_type_Long = 20L;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private static bcgk jdField_a_of_type_Bcgk;
  private static volatile SuspendThreadManager jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager;
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
  private static int e = 3;
  private static int f = 3;
  private static int g;
  private boolean jdField_c_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_JavaUtilMap = new HashMap();
  }
  
  private SuspendThreadManager(String paramString)
  {
    jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread(paramString);
    jdField_a_of_type_AndroidOsHandlerThread.start();
    jdField_a_of_type_Bcgk = new bcgk(this, jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  private int a(Thread paramThread, int paramInt)
  {
    if (!jdField_b_of_type_Boolean) {}
    for (paramInt = resumeThreadArt(b(paramThread), paramInt);; paramInt = resumeThreadDalvik(b(paramThread)))
    {
      if (-1 == paramInt) {
        QLog.i("TSManager", 1, "resumeThread Fail,thread = " + paramThread);
      }
      return paramInt;
    }
  }
  
  public static SuspendThreadManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager == null) {
        jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager = new SuspendThreadManager("SuspendGuardThread");
      }
      return jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager;
    }
    finally {}
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reason:" + paramString + "\n");
      int i = 0;
      while ((i < paramThread.length) && (i < 30))
      {
        localStringBuilder.append(paramThread[i].toString());
        localStringBuilder.append("\n");
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private void a(int paramInt)
  {
    jdField_d_of_type_Boolean = false;
    synchronized (jdField_d_of_type_JavaUtilArrayList)
    {
      if (jdField_d_of_type_JavaUtilArrayList.isEmpty()) {
        break label71;
      }
      Iterator localIterator = jdField_d_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (a((Thread)localIterator.next(), paramInt) == 2) {
          jdField_d_of_type_Boolean = true;
        }
      }
    }
    jdField_d_of_type_JavaUtilArrayList.clear();
    label71:
  }
  
  private void a(Thread paramThread)
  {
    int j;
    if (!jdField_b_of_type_Boolean)
    {
      j = suspendThreadArt(b(paramThread), jdField_b_of_type_Int);
      i = j;
      if (j != 0) {
        jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(j), paramThread);
      }
    }
    for (int i = j;; i = suspendThreadDalvik(b(paramThread)))
    {
      if (-1 == i) {
        QLog.i("TSManager", 1, "suspendThread Fail,thread = " + paramThread);
      }
      return;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int j;
    int i;
    Object localObject3;
    try
    {
      if (!jdField_d_of_type_JavaUtilArrayList.isEmpty()) {
        break label204;
      }
      Thread[] arrayOfThread = a();
      j = arrayOfThread.length;
      i = 0;
    }
    catch (Throwable localThrowable)
    {
      a(jdField_b_of_type_Int);
    }
    if ((!jdField_b_of_type_JavaUtilArrayList.contains(localObject3.getName())) && (!jdField_c_of_type_JavaUtilArrayList.contains(localObject3)) && (!localObject3.getName().contains("Binder")) && (!localObject3.getName().contains("RenderThread")) && (!localObject3.getName().contains("Automator")) && (!localObject3.getName().contains("thread_sp")) && (!localObject3.getName().contains("logWriteThread")) && (!localObject3.getName().contains("Bugly"))) {
      if ((localObject3.isAlive()) && (paramBoolean) && (jdField_a_of_type_JavaUtilArrayList.contains(localObject3.getName())))
      {
        a().a(localObject3);
        synchronized (jdField_d_of_type_JavaUtilArrayList)
        {
          jdField_d_of_type_JavaUtilArrayList.add(localObject3);
        }
      }
    }
    label277:
    for (;;)
    {
      label204:
      return;
      if ((!paramBoolean) && (localObject3.isAlive()))
      {
        a().a(localObject3);
        synchronized (jdField_d_of_type_JavaUtilArrayList)
        {
          jdField_d_of_type_JavaUtilArrayList.add(localObject3);
        }
      }
      for (;;)
      {
        if (i >= j) {
          break label277;
        }
        localObject3 = localObject2[i];
        if (localObject3 != null) {
          break;
        }
        i += 1;
      }
    }
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
    int i;
    try
    {
      localObject = (Integer)jdField_b_of_type_JavaUtilMap.get(paramThread);
      if ((localObject != null) && (((Integer)localObject).intValue() != 0)) {
        return ((Integer)localObject).intValue();
      }
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
    }
    catch (Throwable paramThread)
    {
      QLog.e("TSManager", 1, "getNativeThreadAddr", paramThread);
    }
    while (!jdField_b_of_type_Boolean) {
      return -1;
    }
    Object localObject = a(paramThread, "vmThread");
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
      if (localObject == null) {
        break label86;
      }
    }
    label86:
    for (int i = ((Integer)localObject).intValue();; i = 0)
    {
      if (i != 0)
      {
        QLog.i("TSManager", 1, "Dalvik Mode");
        return true;
      }
      QLog.i("TSManager", 1, "default ART Mode");
      return false;
    }
  }
  
  private native int getContentThreadIdArt(int paramInt);
  
  private native int nativeInit(boolean paramBoolean, int paramInt);
  
  private native int resumeThreadArt(int paramInt1, int paramInt2);
  
  private native int resumeThreadDalvik(int paramInt);
  
  private native int suspendThreadArt(int paramInt1, int paramInt2);
  
  private native int suspendThreadDalvik(int paramInt);
  
  public void a()
  {
    if ((!this.jdField_c_of_type_Boolean) && (jdField_a_of_type_Bcgk != null) && (jdField_a_of_type_AndroidOsHandlerThread != null))
    {
      jdField_a_of_type_Bcgk.obtainMessage(1).sendToTarget();
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  public void a(String paramString)
  {
    jdField_a_of_type_JavaUtilArrayList.add(paramString);
  }
  
  public void b()
  {
    Object localObject = bcad.a();
    int i = ((SharedPreferences)localObject).getInt("suspendCrashCount", 0);
    localObject = ((SharedPreferences)localObject).edit();
    i += 1;
    QLog.d("TSManager", 1, "SuspendThreadManager has crashed " + i + " times");
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
    jdField_a_of_type_Bcgk.sendMessage(localMessage);
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
    jdField_a_of_type_Bcgk.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.thread.SuspendThreadManager
 * JD-Core Version:    0.7.0.1
 */