package com.tencent.mobileqq.microapp.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.mobileqq.microapp.appbrand.a.a;
import com.tencent.mobileqq.microapp.b.a;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ServiceWebview
  extends BaseAppBrandWebview
{
  public AppBrandServiceEventInterface appBrandEventInterface;
  private HashMap appServiceJsLoadFlagMap = new HashMap();
  
  public ServiceWebview(Context paramContext)
  {
    super(paramContext);
    addJavascriptInterface(this, "WeixinJSCore");
  }
  
  public void clearUp()
  {
    removeJavascriptInterface("WeixinJSCore");
  }
  
  public void initService(f paramf, a.a parama)
  {
    initJSGlobalConfig();
    if (QLog.isColorLevel()) {
      QLog.i("PageWebview111", 2, "---start getWAServiceJSStr----");
    }
    evaluteJs(paramf.g(), new ServiceWebview.1(this, parama, paramf));
  }
  
  @JavascriptInterface
  public String invokeHandler(String paramString1, String paramString2, int paramInt)
  {
    QLog.d("AppBrandServiceEventInterface", 2, "invokeHandler|service: " + paramString1 + " |data: " + paramString2 + " |id:" + paramInt);
    if (this.appBrandEventInterface != null) {
      return this.appBrandEventInterface.onServiceNativeRequest(paramString1, paramString2, paramInt);
    }
    return "";
  }
  
  public void loadAppServiceJs(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.apkgInfo == null);
        paramString = this.apkgInfo.d(paramString);
      } while ((TextUtils.isEmpty(paramString)) || ((this.appServiceJsLoadFlagMap.get(paramString) != null) && (((Boolean)this.appServiceJsLoadFlagMap.get(paramString)).booleanValue())));
      str = this.apkgInfo.f(paramString);
    } while (TextUtils.isEmpty(str));
    evaluteJs(str, new ServiceWebview.2(this, paramString));
  }
  
  @JavascriptInterface
  public void publishHandler(String paramString1, String paramString2, String paramString3)
  {
    QLog.d("AppBrandServiceEventInterface", 2, "publishHandler|service: " + paramString1 + " |str2: " + paramString2 + " |str3:" + paramString3);
    if (this.appBrandEventInterface != null) {
      this.appBrandEventInterface.onServiceEvent(paramString1, paramString2, a.g(paramString3));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview
 * JD-Core Version:    0.7.0.1
 */