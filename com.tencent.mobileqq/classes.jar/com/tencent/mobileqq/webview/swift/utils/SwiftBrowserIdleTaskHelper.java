package com.tencent.mobileqq.webview.swift.utils;

import akch;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.biz.common.util.Util;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
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
  static WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private static final ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList(5);
  final MessageQueue.IdleHandler jdField_a_of_type_AndroidOsMessageQueue$IdleHandler = new akch(this);
  public boolean a;
  
  SwiftBrowserIdleTaskHelper()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static SwiftBrowserIdleTaskHelper a()
  {
    if (jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftBrowserIdleTaskHelper == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftBrowserIdleTaskHelper == null) {
        jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftBrowserIdleTaskHelper = new SwiftBrowserIdleTaskHelper();
      }
      return jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftBrowserIdleTaskHelper;
    }
    finally {}
  }
  
  static void a()
  {
    try
    {
      Util.a("downloadX5KernelIfNeeded");
      if (QbSdk.getTbsVersion(BaseApplicationImpl.getApplication().getApplicationContext()) == 0)
      {
        BrowserAppInterface localBrowserAppInterface = (BrowserAppInterface)jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localBrowserAppInterface != null)
        {
          String str = WebAccelerateHelper.getInstance().getTBSDpcParam();
          if ((str != null) && (str.charAt(0) == '1') && ("CN".equals(Locale.getDefault().getCountry())) && (TbsDownloader.needDownload(BaseApplication.getContext(), false)))
          {
            localBrowserAppInterface.a(false);
            QLog.i("SwiftBrowserIdleTaskHelper", 1, "call downloadX5Kernel on idle:download tbs.");
          }
        }
      }
      for (;;)
      {
        Util.b("downloadX5KernelIfNeeded");
        return;
        jdField_a_of_type_Int = 5;
        QLog.i("SwiftBrowserIdleTaskHelper", 1, "call downloadX5Kernel on idle: already has x5.");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("SwiftBrowserIdleTaskHelper", 1, "downloadX5Kernel error:" + localThrowable.getMessage());
      Util.b("downloadX5KernelIfNeeded");
    }
  }
  
  public static void a(BrowserAppInterface paramBrowserAppInterface)
  {
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBrowserAppInterface);
  }
  
  public void a(SwiftBrowserIdleTaskHelper.IdleTask paramIdleTask)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
      } while (((SwiftBrowserIdleTaskHelper.IdleTask)localIterator.next()).jdField_a_of_type_Int != paramIdleTask.jdField_a_of_type_Int);
    }
    do
    {
      return;
      jdField_a_of_type_JavaUtilArrayList.add(paramIdleTask);
    } while ((jdField_a_of_type_JavaUtilArrayList.isEmpty()) || (this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_Boolean = true;
    Looper.myQueue().addIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper
 * JD-Core Version:    0.7.0.1
 */