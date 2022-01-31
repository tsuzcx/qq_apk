package com.tencent.mobileqq.util;

import ajlh;
import ajli;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadOptimizer;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public abstract class FaceDecodeTask
{
  public static int a;
  protected static Looper a;
  private static FaceDecodeTask.FaceDecodeThreadInfo jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$FaceDecodeThreadInfo;
  protected static Object a;
  public static ArrayList a;
  protected static MqqHandler a;
  protected static ajli[] a;
  protected static Thread[] a;
  protected static int b;
  public static ArrayList b;
  public Bitmap a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public FaceInfo a;
  public WeakReference a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_Int = 111;
    jdField_b_of_type_Int = 6;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaUtilArrayList = new ArrayList(100);
  }
  
  public FaceDecodeTask(AppInterface paramAppInterface, FaceInfo paramFaceInfo, FaceDecodeTask.DecodeCompletionListener paramDecodeCompletionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo = paramFaceInfo;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDecodeCompletionListener);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public static FaceDecodeTask.FaceDecodeThreadInfo a()
  {
    FaceDecodeTask.FaceDecodeThreadInfo localFaceDecodeThreadInfo = new FaceDecodeTask.FaceDecodeThreadInfo();
    int i = Runtime.getRuntime().availableProcessors();
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDecodeTask", 2, "processor count:" + i);
    }
    if (i >= 4) {}
    do
    {
      return localFaceDecodeThreadInfo;
      localFaceDecodeThreadInfo.jdField_a_of_type_Int = (i + 1);
    } while (i > 2);
    localFaceDecodeThreadInfo.jdField_b_of_type_Int = 10;
    return localFaceDecodeThreadInfo;
  }
  
  public static FaceDecodeTask a(AppInterface paramAppInterface, FaceInfo paramFaceInfo, FaceDecodeTask.DecodeCompletionListener paramDecodeCompletionListener)
  {
    if (paramAppInterface == null) {}
    do
    {
      return null;
      if ((paramAppInterface instanceof QQAppInterface)) {
        return new FaceDecodeTaskImpl((QQAppInterface)paramAppInterface, paramFaceInfo, paramDecodeCompletionListener);
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    return new NearByFaceDecodeTask((NearbyAppInterface)paramAppInterface, paramFaceInfo, paramDecodeCompletionListener);
  }
  
  public static void a(FaceDecodeTask paramFaceDecodeTask)
  {
    if ((paramFaceDecodeTask == null) || (paramFaceDecodeTask.a()))
    {
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder().append("execute, decodeTaskInfo is expired, type=");
        if (paramFaceDecodeTask == null) {
          break label57;
        }
      }
      label57:
      for (paramFaceDecodeTask = paramFaceDecodeTask.getClass().getSimpleName();; paramFaceDecodeTask = "")
      {
        QLog.w("Q.qqhead.FaceDecodeTask", 2, paramFaceDecodeTask);
        return;
      }
    }
    c();
    synchronized (jdField_a_of_type_JavaUtilArrayList)
    {
      jdField_a_of_type_JavaUtilArrayList.add(paramFaceDecodeTask);
      jdField_a_of_type_JavaUtilArrayList.notify();
      return;
    }
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDecodeTask", 2, "closeFaceDecodeThread");
    }
    for (;;)
    {
      int i;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_b_of_type_JavaUtilArrayList != null) {
          jdField_b_of_type_JavaUtilArrayList.clear();
        }
        if (jdField_a_of_type_MqqOsMqqHandler != null) {
          jdField_a_of_type_MqqOsMqqHandler.removeMessages(jdField_a_of_type_Int);
        }
        if (jdField_a_of_type_ArrayOfAjli != null)
        {
          i = 0;
          if (i < jdField_a_of_type_ArrayOfAjli.length)
          {
            if (jdField_a_of_type_ArrayOfAjli[i] != null) {
              jdField_a_of_type_ArrayOfAjli[i].a();
            }
          }
          else
          {
            jdField_a_of_type_ArrayOfAjli = null;
            jdField_a_of_type_ArrayOfJavaLangThread = null;
          }
        }
        else
        {
          if (jdField_a_of_type_JavaUtilArrayList != null) {}
          synchronized (jdField_a_of_type_JavaUtilArrayList)
          {
            jdField_a_of_type_JavaUtilArrayList.clear();
            jdField_a_of_type_JavaUtilArrayList.notifyAll();
            jdField_a_of_type_JavaUtilArrayList = null;
            jdField_a_of_type_AndroidOsLooper = null;
            jdField_a_of_type_MqqOsMqqHandler = null;
            return;
          }
        }
      }
      i += 1;
    }
  }
  
  private static void c()
  {
    if (jdField_a_of_type_ArrayOfJavaLangThread == null) {
      for (;;)
      {
        int i;
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          if (jdField_a_of_type_ArrayOfJavaLangThread == null)
          {
            jdField_a_of_type_AndroidOsLooper = Looper.getMainLooper();
            jdField_a_of_type_MqqOsMqqHandler = new ajlh(jdField_a_of_type_AndroidOsLooper);
            String str = BaseApplicationImpl.processName;
            d();
            if (jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$FaceDecodeThreadInfo.jdField_a_of_type_Int != -2147483648) {
              jdField_b_of_type_Int = jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$FaceDecodeThreadInfo.jdField_a_of_type_Int;
            }
            if ((!TextUtils.isEmpty(str)) && (str.equals("com.tencent.mobileqq"))) {
              jdField_b_of_type_Int = 2;
            }
            jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            jdField_a_of_type_ArrayOfJavaLangThread = new Thread[jdField_b_of_type_Int];
            jdField_a_of_type_ArrayOfAjli = new ajli[jdField_b_of_type_Int];
            i = 0;
            if (i < jdField_a_of_type_ArrayOfJavaLangThread.length)
            {
              jdField_a_of_type_ArrayOfAjli[i] = new ajli(null);
              jdField_a_of_type_ArrayOfJavaLangThread[i] = ThreadManager.newFreeThread(jdField_a_of_type_ArrayOfAjli[i], "FaceDecodeThread", 5);
              if (ThreadOptimizer.a().c()) {
                jdField_a_of_type_ArrayOfJavaLangThread[i].setPriority(1);
              }
              if (jdField_a_of_type_ArrayOfJavaLangThread[i].getState() != Thread.State.NEW) {
                break label235;
              }
              jdField_a_of_type_ArrayOfJavaLangThread[i].start();
              bool = true;
              if (!QLog.isColorLevel()) {
                break label240;
              }
              QLog.i("Q.qqhead.FaceDecodeTask", 2, "initFaceDecodeThread, thread isStatusNew=" + bool);
              break label240;
            }
          }
          return;
        }
        label235:
        boolean bool = false;
        continue;
        label240:
        i += 1;
      }
    }
  }
  
  private static void d()
  {
    if (TextUtils.isEmpty(BaseApplicationImpl.processName)) {}
    for (;;)
    {
      return;
      if (BaseApplicationImpl.processName.equals("com.tencent.mobileqq:tool")) {}
      for (jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$FaceDecodeThreadInfo = a(); QLog.isColorLevel(); jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$FaceDecodeThreadInfo = new FaceDecodeTask.FaceDecodeThreadInfo())
      {
        QLog.i("Q.qqhead.FaceDecodeTask", 2, "initFaceDecodeThreadInfo, maxThreadCount=" + jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$FaceDecodeThreadInfo.jdField_a_of_type_Int + ",priority=" + jdField_a_of_type_ComTencentMobileqqUtilFaceDecodeTask$FaceDecodeThreadInfo.jdField_b_of_type_Int);
        return;
      }
    }
  }
  
  public abstract void a();
  
  protected abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceDecodeTask
 * JD-Core Version:    0.7.0.1
 */