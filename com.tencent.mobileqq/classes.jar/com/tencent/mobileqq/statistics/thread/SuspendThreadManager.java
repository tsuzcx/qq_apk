package com.tencent.mobileqq.statistics.thread;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.HandlerThread;
import android.os.Message;
import axnv;
import axuc;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class SuspendThreadManager
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long = 20L;
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private static axuc jdField_a_of_type_Axuc;
  private static volatile SuspendThreadManager jdField_a_of_type_ComTencentMobileqqStatisticsThreadSuspendThreadManager;
  private static ArrayList<Thread> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private static boolean jdField_a_of_type_Boolean;
  private static int jdField_b_of_type_Int = 3;
  private static ArrayList<Thread> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private static boolean jdField_b_of_type_Boolean;
  private static int jdField_c_of_type_Int = 3;
  private static ArrayList<Thread> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private static ArrayList<Thread> d = new ArrayList();
  private boolean jdField_c_of_type_Boolean;
  
  private SuspendThreadManager(String paramString)
  {
    jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread(paramString);
    jdField_a_of_type_AndroidOsHandlerThread.start();
    jdField_a_of_type_Axuc = new axuc(this, jdField_a_of_type_AndroidOsHandlerThread.getLooper());
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
  
  private void a(Thread paramThread)
  {
    if (!jdField_b_of_type_Boolean) {}
    for (int i = suspendThreadArt(b(paramThread), jdField_a_of_type_Int);; i = suspendThreadDalvik(b(paramThread)))
    {
      if (-1 == i) {
        QLog.i("TSManager", 1, "suspendThread Fail,thread = " + paramThread);
      }
      return;
    }
  }
  
  private static int b(Thread paramThread)
  {
    try
    {
      if (!jdField_b_of_type_Boolean)
      {
        paramThread = (Long)a(paramThread, "nativePeer");
        if (paramThread != null) {
          return paramThread.intValue();
        }
      }
      else if (jdField_b_of_type_Boolean)
      {
        paramThread = a(paramThread, "vmThread");
        if (paramThread != null)
        {
          paramThread = (Integer)b(paramThread, "vmData");
          if (paramThread != null)
          {
            int i = paramThread.intValue();
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
  
  private void b(Thread paramThread)
  {
    if (!jdField_b_of_type_Boolean) {}
    for (int i = resumeThreadArt(b(paramThread), jdField_a_of_type_Int);; i = resumeThreadDalvik(b(paramThread)))
    {
      if (-1 == i) {
        QLog.i("TSManager", 1, "resumeThread Fail,thread = " + paramThread);
      }
      return;
    }
  }
  
  private static Thread[] b()
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
  
  private static boolean d()
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
        break label80;
      }
    }
    label80:
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
  
  private native int nativeInit(boolean paramBoolean);
  
  private native int resumeThreadArt(int paramInt1, int paramInt2);
  
  private native int resumeThreadDalvik(int paramInt);
  
  private native int suspendThreadArt(int paramInt1, int paramInt2);
  
  private native int suspendThreadDalvik(int paramInt);
  
  public void a()
  {
    if ((!this.jdField_c_of_type_Boolean) && (jdField_a_of_type_Axuc != null) && (jdField_a_of_type_AndroidOsHandlerThread != null))
    {
      jdField_a_of_type_Axuc.obtainMessage(1).sendToTarget();
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = Boolean.valueOf(paramBoolean);
    jdField_a_of_type_Axuc.sendMessage(localMessage);
    localMessage = Message.obtain();
    localMessage.what = 4;
    jdField_a_of_type_Axuc.sendMessageDelayed(localMessage, jdField_a_of_type_Long);
  }
  
  public void b()
  {
    Object localObject = axnv.a();
    int i = ((SharedPreferences)localObject).getInt("suspendCrashCount", 0);
    localObject = ((SharedPreferences)localObject).edit();
    i += 1;
    QLog.d("TSManager", 1, "SuspendThreadManager has crashed " + i + " times");
    ((SharedPreferences.Editor)localObject).putInt("suspendCrashCount", i);
    if (i > jdField_b_of_type_Int) {
      ((SharedPreferences.Editor)localObject).putBoolean("force_disable_thread_suspend", true);
    }
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public void c()
  {
    if (!jdField_a_of_type_Boolean) {
      return;
    }
    if (jdField_a_of_type_Axuc.hasMessages(4)) {
      jdField_a_of_type_Axuc.removeMessages(4);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    jdField_a_of_type_Axuc.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.thread.SuspendThreadManager
 * JD-Core Version:    0.7.0.1
 */