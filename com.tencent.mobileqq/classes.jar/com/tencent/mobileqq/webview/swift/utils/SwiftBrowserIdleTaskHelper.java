package com.tencent.mobileqq.webview.swift.utils;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.util.ITbsDownloader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsDownloader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class SwiftBrowserIdleTaskHelper
{
  private static int jdField_a_of_type_Int;
  private static long jdField_a_of_type_Long;
  private static SwiftBrowserIdleTaskHelper jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftBrowserIdleTaskHelper;
  static WeakReference<ITbsDownloader> jdField_a_of_type_JavaLangRefWeakReference;
  private static final ArrayList<SwiftBrowserIdleTaskHelper.IdleTask> jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  final MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new SwiftBrowserIdleTaskHelper.1(this);
  boolean jdField_a_of_type_Boolean = false;
  
  public static SwiftBrowserIdleTaskHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftBrowserIdleTaskHelper == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftBrowserIdleTaskHelper == null) {
          jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftBrowserIdleTaskHelper = new SwiftBrowserIdleTaskHelper();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftBrowserIdleTaskHelper;
  }
  
  static void a()
  {
    try
    {
      Util.a("downloadX5KernelIfNeeded");
      ITbsDownloader localITbsDownloader = (ITbsDownloader)jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localITbsDownloader != null)
      {
        localObject = WebAccelerateHelper.getInstance().getTBSDpcParam();
        if ((localObject != null) && (((String)localObject).charAt(0) == '1') && ("CN".equals(Locale.getDefault().getCountry())))
        {
          if (TbsDownloader.needDownload(BaseApplication.getContext(), false, false, new SwiftBrowserIdleTaskHelper.2()))
          {
            localITbsDownloader.a(false);
            QLog.i("SwiftBrowserIdleTaskHelper", 1, "call downloadX5Kernel on idle:download tbs.");
          }
        }
        else
        {
          jdField_a_of_type_Int = 5;
          QLog.i("SwiftBrowserIdleTaskHelper", 1, "call downloadX5Kernel on idle: no need download tbs.");
        }
      }
      Util.b("downloadX5KernelIfNeeded");
      return;
    }
    catch (Throwable localThrowable)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadX5Kernel error:");
      ((StringBuilder)localObject).append(localThrowable.getMessage());
      QLog.e("SwiftBrowserIdleTaskHelper", 1, ((StringBuilder)localObject).toString());
      Util.b("downloadX5KernelIfNeeded");
    }
  }
  
  public static void a(ITbsDownloader paramITbsDownloader)
  {
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramITbsDownloader);
  }
  
  public void a(SwiftBrowserIdleTaskHelper.IdleTask paramIdleTask)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        if (((SwiftBrowserIdleTaskHelper.IdleTask)localIterator.next()).jdField_a_of_type_Int == paramIdleTask.jdField_a_of_type_Int) {
          return;
        }
      }
      jdField_a_of_type_JavaUtilArrayList.add(paramIdleTask);
      if ((!jdField_a_of_type_JavaUtilArrayList.isEmpty()) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      SwiftBrowserIdleTaskHelper.IdleTask localIdleTask = (SwiftBrowserIdleTaskHelper.IdleTask)localIterator.next();
      if (localIdleTask.jdField_a_of_type_Int == paramInt)
      {
        jdField_a_of_type_JavaUtilArrayList.remove(localIdleTask);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper
 * JD-Core Version:    0.7.0.1
 */