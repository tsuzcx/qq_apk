package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.injector.IAbsBaseWebViewActivityInjector;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import cooperation.pluginbridge.BridgeHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class AbsBaseWebViewActivityImpl
  implements IAbsBaseWebViewActivityInjector
{
  protected volatile boolean a = false;
  
  private void b(Activity paramActivity)
  {
    if (!this.a)
    {
      this.a = true;
      paramActivity = paramActivity.getIntent().getStringExtra("url");
      if (WebSoUtils.b(paramActivity)) {
        ThreadManager.postImmediately(new AbsBaseWebViewActivityImpl.1(this, paramActivity), null, false);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent, TouchWebView paramTouchWebView)
  {
    if ((paramInt2 == -1) && (paramTouchWebView != null))
    {
      switch (paramInt1)
      {
      default: 
        return;
      }
      if (paramIntent == null) {
        return;
      }
      String str = paramIntent.getStringExtra("callbackSn");
      paramIntent = paramIntent.getStringExtra("result");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:window.JsBridge&&JsBridge.callback('");
      localStringBuilder.append(str);
      localStringBuilder.append("',{'r':0,'result':");
      localStringBuilder.append(paramIntent);
      localStringBuilder.append("});");
      paramTouchWebView.loadUrl(localStringBuilder.toString());
    }
  }
  
  public void a(Activity paramActivity)
  {
    b(paramActivity);
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    Object localObject = new Intent("tencent.notify.foreground");
    ((Intent)localObject).setPackage(MobileQQ.getContext().getPackageName());
    ((Intent)localObject).putExtra("selfuin", paramQBaseActivity.getAppRuntime().getAccount());
    ((Intent)localObject).putExtra("AccountInfoSync", "mobileqq.web");
    ((Intent)localObject).putExtra("classname", getClass().getName());
    paramQBaseActivity.sendBroadcast((Intent)localObject, "com.tencent.msg.permission.pushnotify");
    localObject = BridgeHelper.a(paramQBaseActivity, paramQBaseActivity.getAppRuntime().getAccount()).a("buscard_registerNFC");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || ("true".equals(localObject))) {
      ActivityLifecycle.onResume(paramQBaseActivity);
    }
  }
  
  public boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("mqqpa://resourceid/"));
  }
  
  public WebResourceResponse b(String paramString)
  {
    return (WebResourceResponse)((IPublicAccountH5AbilityPlugin)QRoute.api(IPublicAccountH5AbilityPlugin.class)).getWebResponse(paramString);
  }
  
  public void b(QBaseActivity paramQBaseActivity)
  {
    String str = BridgeHelper.a(paramQBaseActivity, paramQBaseActivity.getAppRuntime().getAccount()).a("buscard_registerNFC");
    if ((TextUtils.isEmpty(str)) || ("true".equals(str))) {
      ActivityLifecycle.onPause(paramQBaseActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.AbsBaseWebViewActivityImpl
 * JD-Core Version:    0.7.0.1
 */