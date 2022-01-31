package com.tencent.mobileqq.webview.swift.utils;

import akqp;
import akqq;
import akqr;
import akqs;
import akqt;
import akqv;
import akqw;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.scheduler.SwiftBrowserStateMachineScheduler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class SwiftWebAccelerator
{
  private static SwiftWebAccelerator jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftWebAccelerator;
  public static final Object a;
  public int a;
  final SwiftBrowserStateMachineScheduler jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler = new SwiftBrowserStateMachineScheduler(new akqp(this));
  public boolean a;
  public int b = 0;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public static SwiftWebAccelerator a()
  {
    if (jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftWebAccelerator == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftWebAccelerator == null) {
        jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftWebAccelerator = new SwiftWebAccelerator();
      }
      return jdField_a_of_type_ComTencentMobileqqWebviewSwiftUtilsSwiftWebAccelerator;
    }
    finally {}
  }
  
  public static void b()
  {
    long l = System.currentTimeMillis();
    if (WebViewPluginEngine.a == null) {
      ThreadManager.postImmediately(new akqw(l), null, false);
    }
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int |= 0x1;
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    }
    for (boolean bool = BaseApplicationImpl.sApplication.getSharedPreferences("sp_x5_config_" + (String)localObject, 4).getBoolean("key_x5_init_sub_thread", true);; bool = true)
    {
      long l = System.currentTimeMillis();
      QLog.i("WebLog_SwiftWebAccelerator", 1, "initX5Environment start! " + bool);
      if (bool)
      {
        ThreadManager.postImmediately(new akqr(this, l, paramBundle), null, false);
        return -1;
      }
      SwiftWebAccelerator.TbsAccelerator.b();
      SwiftBrowserStatistics.C = System.currentTimeMillis() - l;
      QLog.i("WebLog_SwiftWebAccelerator", 1, "initX5Environment on main thread, cost " + SwiftBrowserStatistics.C + "ms.");
      return 1;
    }
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.i("WebLog_SwiftWebAccelerator", 1, "switch 2 RealWorld and cancel state machine schedule.");
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.b();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        Bundle localBundle = paramBundle;
        if (paramBundle == null) {
          localBundle = new Bundle();
        }
        this.b = localBundle.getInt("_accelerator_mode_", 0);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.b();
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSchedulerSwiftBrowserStateMachineScheduler.a(localBundle);
        QLog.i("WebLog_SwiftWebAccelerator", 1, "smartSchedule restart and new mode is " + this.b + ".");
        return;
      }
      QLog.i("WebLog_SwiftWebAccelerator", 1, "smartSchedule say no because is in real world now.");
      return;
    }
    new Handler(Looper.getMainLooper()).post(new akqq(this, paramBundle));
  }
  
  public int b(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int |= 0x2;
    long l = System.currentTimeMillis();
    SwiftReuseTouchWebView.a(BaseApplicationImpl.sApplication).b(true);
    SwiftBrowserStatistics.D = System.currentTimeMillis() - l;
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doMainStep_CreateWebView:create webview cost " + SwiftBrowserStatistics.D + "ms.");
    return 1;
  }
  
  public void b(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int |= 0x400;
    ThreadManager.postImmediately(new akqt(this, System.currentTimeMillis(), paramBundle), null, false);
  }
  
  public int c(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int |= 0x4;
    long l = System.currentTimeMillis();
    paramBundle = (String)WebAccelerateHelper.getInstance().getWebViewFeatureConfigs().get("preloadUrl");
    if ((!TextUtils.isEmpty(paramBundle)) && ((paramBundle.startsWith("http:")) || (paramBundle.startsWith("https:"))))
    {
      SwiftReuseTouchWebView localSwiftReuseTouchWebView = SwiftReuseTouchWebView.a(BaseApplicationImpl.sApplication);
      Intent localIntent = new Intent();
      localIntent.putExtra("ignoreLoginWeb", true);
      localSwiftReuseTouchWebView.setIntent(localIntent);
      localSwiftReuseTouchWebView.a(paramBundle);
      new Handler(Looper.getMainLooper()).postDelayed(new akqs(this, localSwiftReuseTouchWebView), 300L);
    }
    SwiftBrowserStatistics.E = System.currentTimeMillis() - l;
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doMainStep_WarnUpWebView:load " + paramBundle + ", cost " + SwiftBrowserStatistics.E + "ms.");
    return 1;
  }
  
  public void c(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int |= 0x800;
    ThreadManager.postImmediately(new akqv(this, System.currentTimeMillis()), null, false);
  }
  
  public int d(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int |= 0x10;
    long l = System.currentTimeMillis();
    paramBundle = (String)WebAccelerateHelper.getInstance().getWebViewFeatureConfigs().get("preloadUrl");
    if ((!TextUtils.isEmpty(paramBundle)) && ((paramBundle.startsWith("http:")) || (paramBundle.startsWith("https:"))))
    {
      SwiftBrowserCookieMonster localSwiftBrowserCookieMonster = SwiftBrowserCookieMonster.a(paramBundle);
      if (localSwiftBrowserCookieMonster != null) {
        localSwiftBrowserCookieMonster.a(paramBundle, null, null, null);
      }
    }
    QLog.i("WebLog_SwiftWebAccelerator", 1, "doMainStep_SetCookie:pre set cookie(" + paramBundle + "), cost " + (System.currentTimeMillis() - l) + "ms.");
    return 1;
  }
  
  public void d(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int |= 0x1000;
    b();
  }
  
  public int e(Bundle paramBundle)
  {
    this.jdField_a_of_type_Int |= 0x8;
    long l = System.currentTimeMillis();
    if (WebAccelerateHelper.preloadBrowserView == null)
    {
      WebAccelerateHelper.preInflaterBrowserView();
      SwiftBrowserStatistics.F = System.currentTimeMillis() - l;
      QLog.i("WebLog_SwiftWebAccelerator", 1, "doMainStep_CreateBrowserView, cost = " + SwiftBrowserStatistics.F + "ms.");
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator
 * JD-Core Version:    0.7.0.1
 */