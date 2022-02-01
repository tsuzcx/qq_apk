package com.tencent.open.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.open.api.impl.WebViewOpenSdkApiImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class WebViewOpenSdkApi
{
  @ConfigInject(configPath="Business/opensdk-api/src/main/resources/Inject_web_view_open_sdk_api.yml", version=1)
  private static ArrayList<Class<? extends IWebViewOpenSdkApi>> a = new ArrayList();
  private static WebViewOpenSdkApi c;
  private IWebViewOpenSdkApi b;
  
  static
  {
    a.add(WebViewOpenSdkApiImpl.class);
  }
  
  public WebViewOpenSdkApi()
  {
    try
    {
      this.b = ((IWebViewOpenSdkApi)((Class)a.get(0)).newInstance());
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("newInstance error:");
      localStringBuilder.append(localException);
      QLog.i("WebViewOpenSdkApi", 1, localStringBuilder.toString());
    }
  }
  
  public static WebViewOpenSdkApi a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new WebViewOpenSdkApi();
        }
      }
      finally {}
    }
    return c;
  }
  
  public Object a(Activity paramActivity, AppRuntime paramAppRuntime, Object paramObject, Intent paramIntent)
  {
    if (b()) {
      return null;
    }
    return this.b.a(paramActivity, paramAppRuntime, paramObject, paramIntent);
  }
  
  public Object a(String paramString)
  {
    if (b()) {
      return null;
    }
    return this.b.a(paramString);
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    if (b()) {
      return;
    }
    this.b.a(paramActivity, paramBundle);
  }
  
  public void a(Context paramContext, Object paramObject)
  {
    if (b()) {
      return;
    }
    this.b.a(paramContext, paramObject);
  }
  
  public void a(Bundle paramBundle, Activity paramActivity, String paramString1, String paramString2)
  {
    if (b()) {
      return;
    }
    this.b.a(paramBundle, paramActivity, paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, Activity paramActivity, String paramString5)
  {
    if (b()) {
      return;
    }
    this.b.a(paramString1, paramString2, paramString3, paramString4, paramLong, paramActivity, paramString5);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (b()) {
      return;
    }
    this.b.a(paramString1, paramString2, paramBoolean);
  }
  
  protected boolean b()
  {
    if (this.b == null)
    {
      QLog.i("WebViewOpenSdkApi", 1, "api instance is null,return");
      return true;
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    if (b()) {
      return false;
    }
    return this.b.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.api.WebViewOpenSdkApi
 * JD-Core Version:    0.7.0.1
 */