package com.tencent.mobileqq.util;

import ajtd;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import azwc;
import azwd;
import azwe;
import azwf;
import azyb;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public abstract class FaceDecodeTask
{
  public static int a;
  protected static Looper a;
  private static azwe jdField_a_of_type_Azwe;
  protected static Object a;
  protected static ArrayList<FaceDecodeTask> a;
  protected static MqqHandler a;
  protected static FaceDecodeTask.FaceDecodeRunnable[] a;
  protected static Thread[] a;
  protected static int b;
  public static ArrayList<FaceDecodeTask> b;
  public Bitmap a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  public FaceInfo a;
  public WeakReference<azwd> a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_Int = 111;
    jdField_b_of_type_Int = 6;
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaUtilArrayList = new ArrayList(100);
  }
  
  public FaceDecodeTask(AppInterface paramAppInterface, FaceInfo paramFaceInfo, azwd paramazwd)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceInfo = paramFaceInfo;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramazwd);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public static azwe a()
  {
    azwe localazwe = new azwe();
    int i = Runtime.getRuntime().availableProcessors();
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDecodeTask", 2, "processor count:" + i);
    }
    if (i >= 4) {}
    do
    {
      return localazwe;
      localazwe.jdField_a_of_type_Int = (i + 1);
    } while (i > 2);
    localazwe.jdField_b_of_type_Int = 10;
    return localazwe;
  }
  
  public static FaceDecodeTask a(AppInterface paramAppInterface, FaceInfo paramFaceInfo, azwd paramazwd)
  {
    if (paramAppInterface == null) {}
    do
    {
      return null;
      if ((paramAppInterface instanceof QQAppInterface)) {
        return new azwf((QQAppInterface)paramAppInterface, paramFaceInfo, paramazwd);
      }
    } while (!(paramAppInterface instanceof NearbyAppInterface));
    return new azyb((NearbyAppInterface)paramAppInterface, paramFaceInfo, paramazwd);
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
        if (jdField_a_of_type_ArrayOfComTencentMobileqqUtilFaceDecodeTask$FaceDecodeRunnable != null)
        {
          i = 0;
          if (i < jdField_a_of_type_ArrayOfComTencentMobileqqUtilFaceDecodeTask$FaceDecodeRunnable.length)
          {
            if (jdField_a_of_type_ArrayOfComTencentMobileqqUtilFaceDecodeTask$FaceDecodeRunnable[i] != null) {
              jdField_a_of_type_ArrayOfComTencentMobileqqUtilFaceDecodeTask$FaceDecodeRunnable[i].a();
            }
          }
          else
          {
            jdField_a_of_type_ArrayOfComTencentMobileqqUtilFaceDecodeTask$FaceDecodeRunnable = null;
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
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          if (jdField_a_of_type_ArrayOfJavaLangThread == null)
          {
            jdField_a_of_type_AndroidOsLooper = Looper.getMainLooper();
            jdField_a_of_type_MqqOsMqqHandler = new azwc(jdField_a_of_type_AndroidOsLooper);
            String str = BaseApplicationImpl.processName;
            d();
            if (jdField_a_of_type_Azwe.jdField_a_of_type_Int != -2147483648) {
              jdField_b_of_type_Int = jdField_a_of_type_Azwe.jdField_a_of_type_Int;
            }
            if ((!TextUtils.isEmpty(str)) && (str.equals("com.tencent.mobileqq"))) {
              jdField_b_of_type_Int = 2;
            }
            jdField_a_of_type_JavaUtilArrayList = new ArrayList();
            jdField_a_of_type_ArrayOfJavaLangThread = new Thread[jdField_b_of_type_Int];
            jdField_a_of_type_ArrayOfComTencentMobileqqUtilFaceDecodeTask$FaceDecodeRunnable = new FaceDecodeTask.FaceDecodeRunnable[jdField_b_of_type_Int];
            int i = 0;
            try
            {
              if (i < jdField_a_of_type_ArrayOfJavaLangThread.length)
              {
                jdField_a_of_type_ArrayOfComTencentMobileqqUtilFaceDecodeTask$FaceDecodeRunnable[i] = new FaceDecodeTask.FaceDecodeRunnable(null);
                jdField_a_of_type_ArrayOfJavaLangThread[i] = ThreadManager.newFreeThread(jdField_a_of_type_ArrayOfComTencentMobileqqUtilFaceDecodeTask$FaceDecodeRunnable[i], "FaceDecodeThread", 5);
                if (ajtd.a().c()) {
                  jdField_a_of_type_ArrayOfJavaLangThread[i].setPriority(1);
                }
                if (jdField_a_of_type_ArrayOfJavaLangThread[i].getState() != Thread.State.NEW) {
                  break label252;
                }
                jdField_a_of_type_ArrayOfJavaLangThread[i].start();
                bool = true;
                if (QLog.isColorLevel()) {
                  QLog.i("Q.qqhead.FaceDecodeTask", 2, "initFaceDecodeThread, thread isStatusNew=" + bool);
                }
                i += 1;
                continue;
              }
            }
            catch (Throwable localThrowable)
            {
              QLog.e("Q.qqhead.FaceDecodeTask", 1, "initFaceDecodeThread", localThrowable);
              return;
            }
          }
          return;
        }
        label252:
        boolean bool = false;
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
      for (jdField_a_of_type_Azwe = a(); QLog.isColorLevel(); jdField_a_of_type_Azwe = new azwe())
      {
        QLog.i("Q.qqhead.FaceDecodeTask", 2, "initFaceDecodeThreadInfo, maxThreadCount=" + jdField_a_of_type_Azwe.jdField_a_of_type_Int + ",priority=" + jdField_a_of_type_Azwe.jdField_b_of_type_Int);
        return;
      }
    }
  }
  
  protected abstract void a();
  
  protected abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.util.FaceDecodeTask
 * JD-Core Version:    0.7.0.1
 */