package com.tencent.mobileqq.webprocess;

import ajxh;
import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class PreloadService$PreloadImpl
{
  private void a()
  {
    int i = SwiftWebAccelerator.a().a();
    if ((i & 0x2) == 0)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("_accelerator_mode_", i | 0x2);
      SwiftWebAccelerator.a().a(localBundle);
    }
  }
  
  protected List a()
  {
    return null;
  }
  
  public void a(AppInterface arg1)
  {
    if (((!PreloadService.jdField_a_of_type_Boolean) && (PreloadService.a(???))) || ((!PreloadService.jdField_b_of_type_Boolean) && (PreloadService.b(???)))) {}
    label182:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("PreloadService", 2, "preload webview engine");
          }
          l1 = System.currentTimeMillis();
          if (!PreloadService.a(???)) {
            break label182;
          }
          PreloadService.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(???, null, null, a());
        }
        catch (Exception ???)
        {
          long l1;
          long l2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("PreloadService", 2, "preload error:" + ???.toString());
          return;
        }
        synchronized (PreloadService.jdField_a_of_type_JavaLangObject)
        {
          PreloadService.jdField_a_of_type_JavaLangObject.notifyAll();
          PreloadService.jdField_a_of_type_Boolean = true;
          l2 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.i("QQBrowser", 2, "Pre_Load_async_create_webview_engine, cost=" + (l2 - l1));
          }
          if (QLog.isColorLevel()) {
            QLog.d("PreloadService", 2, "asyncPreload end");
          }
          return;
        }
        if (PreloadService.b(???))
        {
          PreloadService.jdField_b_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(???, null, null, a());
          PreloadService.jdField_b_of_type_Boolean = true;
        }
      }
    }
    QLog.d("PreloadService", 2, "async preload:already inited.");
  }
  
  public void a(AppInterface paramAppInterface, Context paramContext, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadService", 2, "asyncPreload app = " + paramAppInterface);
    }
    if (paramAppInterface == null) {
      return;
    }
    a();
    ThreadManager.postImmediately(new ajxh(this, paramAppInterface), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.PreloadService.PreloadImpl
 * JD-Core Version:    0.7.0.1
 */