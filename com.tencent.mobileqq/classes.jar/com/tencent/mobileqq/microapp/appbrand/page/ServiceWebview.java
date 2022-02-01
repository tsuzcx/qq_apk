package com.tencent.mobileqq.microapp.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.appbrand.a.a;
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
  
  public void initService$cfb2ece(c paramc, a.a parama)
  {
    initJSGlobalConfig();
    if (QLog.isColorLevel()) {
      QLog.i("PageWebview111", 2, "---start getWAServiceJSStr----");
    }
    evaluteJs(paramc.f(), new ServiceWebview.1(this, parama, paramc));
  }
  
  @JavascriptInterface
  public String invokeHandler(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("invokeHandler|service: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" |data: ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" |id:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("AppBrandServiceEventInterface", 2, ((StringBuilder)localObject).toString());
    localObject = this.appBrandEventInterface;
    if (localObject != null) {
      return ((AppBrandServiceEventInterface)localObject).onServiceNativeRequest(paramString1, paramString2, paramInt);
    }
    return "";
  }
  
  public void loadAppServiceJs(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.apkgInfo$5475ea27 == null) {
      return;
    }
    paramString = this.apkgInfo$5475ea27.d(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ((this.appServiceJsLoadFlagMap.get(paramString) != null) && (((Boolean)this.appServiceJsLoadFlagMap.get(paramString)).booleanValue())) {
      return;
    }
    String str = this.apkgInfo$5475ea27.f(paramString);
    if (TextUtils.isEmpty(str)) {
      return;
    }
    evaluteJs(str, new ServiceWebview.2(this, paramString));
  }
  
  @JavascriptInterface
  public void publishHandler(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("publishHandler|service: ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" |str2: ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(" |str3:");
    ((StringBuilder)localObject).append(paramString3);
    QLog.d("AppBrandServiceEventInterface", 2, ((StringBuilder)localObject).toString());
    localObject = this.appBrandEventInterface;
    if (localObject != null) {
      ((AppBrandServiceEventInterface)localObject).onServiceEvent(paramString1, paramString2, c.o(paramString3));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview
 * JD-Core Version:    0.7.0.1
 */