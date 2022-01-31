package com.tencent.mobileqq.microapp.appbrand;

import Wallet.ApkgConfig;
import agwb;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import baic;
import baip;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.microapp.MiniAppInterface;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.appbrand.a.a.y;
import com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.microapp.appbrand.page.AppBrandServiceEventInterface;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.microapp.appbrand.ui.AppBrandUI;
import com.tencent.mobileqq.microapp.appbrand.utils.p;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.microapp.sdk.MiniAppException;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.microapp.ui.NavigationBar;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements AppBrandServiceEventInterface
{
  public String a;
  public int b;
  public volatile com.tencent.mobileqq.microapp.apkg.f c;
  public BaseActivity d;
  public MiniAppInterface e;
  public k f;
  public AppBrandPageContainer g;
  public y h;
  public ServiceWebview i;
  public boolean j;
  boolean k;
  public long l = -1L;
  
  public a(BaseActivity paramBaseActivity, k paramk, com.tencent.mobileqq.microapp.apkg.f paramf)
  {
    this.d = paramBaseActivity;
    this.c = paramf;
    this.f = paramk;
    this.g = new AppBrandPageContainer(paramBaseActivity, this);
    AppInterface localAppInterface = paramBaseActivity.getAppInterface();
    if ((localAppInterface instanceof MiniAppInterface)) {
      this.e = ((MiniAppInterface)localAppInterface);
    }
    if ((this.e == null) || (paramk == null) || (paramf == null) || (paramf.f == null) || (paramf.b == null)) {
      throw new MiniAppException("app params error, apkgInfo=" + paramf + ",appId=" + this.a + ",appInterface=" + this.e + ",appBrandRuntimeContainer=" + paramk);
    }
    this.b = paramf.f.getRuntimeType();
    this.a = paramf.d;
    this.h = new y(paramBaseActivity, this);
    com.tencent.mobileqq.microapp.appbrand.utils.c.a();
  }
  
  public String a(String paramString1, String paramString2, BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 4, "handleNativeRequest. eventName=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramBaseAppBrandWebview + " | " + this);
    }
    if (this.h != null) {
      return this.h.a(paramString1, paramString2, paramBaseAppBrandWebview, paramInt);
    }
    return "";
  }
  
  public final void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 4, "cleanup. | " + this);
    }
    this.g.cleanup(false);
    this.h.f();
    p.a().a(this.i, this.d);
  }
  
  public final void a(MiniAppConfig paramMiniAppConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 4, "onResume. | " + this);
    }
    this.j = false;
    this.h.d();
    this.g.setVisibility(0);
    this.g.bringToFront();
    Object localObject = (AbsAppBrandPage)this.g.pageLinkedList.peek();
    if (localObject != null)
    {
      localObject = ((AbsAppBrandPage)localObject).getNavBar();
      if (localObject != null) {
        ((NavigationBar)localObject).d();
      }
    }
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("scene", paramMiniAppConfig.launchParam.scene);
      ((JSONObject)localObject).put("appId", this.a);
      a("onAppEnterForeground", ((JSONObject)localObject).toString());
      this.c.a(paramMiniAppConfig);
      com.tencent.mobileqq.microapp.appbrand.utils.b.a().b(this.c);
      com.tencent.mobileqq.microapp.app.b.a().a("resumePlayer");
      f();
      d();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public final void a(com.tencent.mobileqq.microapp.apkg.f paramf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 4, "updateApkgInfo. apkgInfo=" + paramf + " | " + this);
    }
    if (paramf != null) {
      this.c = paramf;
    }
  }
  
  public final void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 4, "reload. entryPath=" + paramString + " | " + this);
    }
    a();
    a(paramString, true);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {}
    for (paramString1 = String.format("WeixinJSBridge.subscribeHandler('%1$s',%2$s)", new Object[] { paramString1, paramString2 });; paramString1 = String.format("WeixinJSBridge.subscribeHandler('%1$s')", new Object[] { paramString1 }))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AppBrandRuntime", 4, "evaluateServiceSubcribeJS. jsStr=" + paramString1);
      }
      this.i.evaluteJs(paramString1);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 4, "evaluateServiceSubcribeJS. eventName=" + paramString1 + ",data=" + paramString2 + ",webviewId=" + paramInt + " | " + this);
    }
    this.i.evaluateSubcribeJS(paramString1, paramString2, paramInt);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 4, "startShare. content=" + paramString1 + ",sharePicPath=" + paramString2 + ",entryPath=" + paramString3);
    }
    String str2 = this.c.c;
    String str3 = "[分享] 轻应用" + this.c.c;
    String str4 = this.c.e;
    try
    {
      localJSONObject = new JSONObject(this.c.f.config.desc_info);
      localObject2 = localJSONObject.optString("share_low_url", "");
      localObject1 = paramString1;
      localObject3 = paramString1;
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        Object localObject3;
        label183:
        Object localObject2 = null;
        localObject1 = paramString1;
        localJSONException1.printStackTrace();
        paramString1 = (String)localObject2;
        str1 = paramString2;
      }
    }
    try
    {
      if (TextUtils.isEmpty(paramString1))
      {
        localObject3 = paramString1;
        localObject1 = localJSONObject.optString("share_content");
      }
      localObject3 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label407;
      }
      localObject3 = localObject1;
      paramString1 = localJSONObject.optString("desc_info");
    }
    catch (JSONException paramString1)
    {
      localObject1 = str1;
      str1 = paramString1;
      break label366;
      paramString1 = (String)localObject1;
      break label183;
    }
    localObject1 = paramString2;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString2)) {
          localObject1 = localJSONObject.optString("share_pic_url");
        }
        localObject3 = localObject1;
        localObject1 = paramString1;
        paramString1 = (String)localObject2;
        localObject2 = new JSONObject();
      }
      catch (JSONException localJSONException2)
      {
        String str1;
        localObject1 = paramString1;
        continue;
      }
      try
      {
        ((JSONObject)localObject2).put("appId", this.a);
        ((JSONObject)localObject2).put("entryPathInConfig", this.c.b.b);
        paramString2 = paramString1;
        if (!TextUtils.isEmpty(paramString3))
        {
          ((JSONObject)localObject2).put("entryPath", paramString3);
          paramString2 = paramString1 + "&path=" + URLEncoder.encode(paramString3);
        }
        paramString1 = paramString2;
      }
      catch (JSONException paramString2)
      {
        paramString2.printStackTrace();
      }
    }
    paramString2 = ((JSONObject)localObject2).toString();
    baic.a(this.d, 1001, 1, "web_share", "", str4, str2, (String)localObject1, str3, paramString1, "web", paramString2, "micro_app", (String)localObject3, null, null, null, null, null, null, null, null, 7, null, -1L);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 4, "onAppCreate. fromReload=" + paramBoolean + ",entryPath=" + paramString + " | " + this);
    }
    this.j = false;
    this.k = false;
    this.h.a();
    this.h.c();
    String str = paramString;
    if (!this.c.k(paramString)) {
      str = this.c.b.b;
    }
    this.i = p.a().a(this.a);
    if (this.i.apkgInfo == null) {
      this.i.apkgInfo = this.c;
    }
    this.i.appBrandEventInterface = this;
    if (!paramBoolean)
    {
      this.i.initService(this.c, null);
      this.g.launch(str, "appLaunch");
    }
    for (;;)
    {
      com.tencent.mobileqq.microapp.app.b.a().a("resetPlayer");
      return;
      this.i.initService(this.c, new b(this, str));
    }
  }
  
  public final void b()
  {
    if (this.k) {
      return;
    }
    this.k = true;
    if (this.f != null)
    {
      int m = this.f.c();
      if (QLog.isColorLevel()) {
        QLog.d("AppBrandRuntime", 4, "finish. appRunTimeCount=" + m + " | " + this);
      }
      if (m == 1)
      {
        this.f.e();
        return;
      }
      this.f.c(this);
    }
    a();
  }
  
  public final void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 4, "onPause. | " + this);
    }
    this.j = true;
    this.h.e();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("scene", 1001);
      localJSONObject.put("appId", this.a);
      a("onAppEnterBackground", localJSONObject.toString());
      e();
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void d()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject1.put("miniAppId", this.c.d);
      localJSONObject1.put("scene", this.c.f.launchParam.scene);
      localJSONObject2.put("page", com.tencent.mobileqq.microapp.b.a.c(this.g.getCurrentPage().getUrl()));
      this.l = VACDReportUtil.a(localJSONObject1.toString(), "MiniAppStat", "MiniAppVisitReport", "PageVisit", localJSONObject2.toString(), 0, null);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void e()
  {
    VACDReportUtil.endReport(this.l, "MiniAppEnd", null, 0, null);
  }
  
  public void f()
  {
    agwb.a(this.c.f.launchParam, this.c.f.config.mini_version, new c(this));
  }
  
  public final void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 4, "moveAppBrandToBack. | " + this);
    }
    if ((this.d instanceof AppBrandUI))
    {
      ((AppBrandUI)this.d).a(true, true);
      return;
    }
    this.d.moveTaskToBack(true);
  }
  
  public void onServiceEvent(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if ("custom_event_onAppRouteDone".equals(paramString1)) {
      com.tencent.mobileqq.microapp.appbrand.utils.a.a(new d(this));
    }
    int n = paramArrayOfInt.length;
    int m = 0;
    while (m < n)
    {
      int i1 = paramArrayOfInt[m];
      if (QLog.isColorLevel()) {
        QLog.d("AppBrandRuntime", 4, "onServiceEvent. eventName=" + paramString1 + ",jsonParams=" + paramString2 + ",webviewIds=" + i1 + " | " + this);
      }
      PageWebview localPageWebview = this.g.findPageWebView(i1);
      if (localPageWebview != null) {
        localPageWebview.evaluateSubcribeJSInService(paramString1, paramString2, i1);
      }
      m += 1;
    }
  }
  
  public String onServiceNativeRequest(String paramString1, String paramString2, int paramInt)
  {
    if (("reportIDKey".equals(paramString1)) || ("reportRealtimeAction".equals(paramString1))) {
      return "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppBrandRuntime", 4, "onServiceNativeRequest eventName=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + " | " + this);
    }
    if (this.k) {
      return "";
    }
    for (;;)
    {
      try
      {
        if ("redirectTo".equals(paramString1))
        {
          paramString1 = new JSONObject(paramString2).optString("url", "");
          if (TextUtils.isEmpty(paramString1)) {
            break label584;
          }
          com.tencent.mobileqq.microapp.appbrand.utils.a.a(new e(this, paramString1));
          break label584;
        }
        if (!"navigateTo".equals(paramString1)) {
          break;
        }
        paramString1 = new JSONObject(paramString2).optString("url", "");
        paramString2 = com.tencent.mobileqq.microapp.b.a.a(paramString1, "url");
        if (QLog.isColorLevel()) {
          QLog.i("AppBrandRuntime", 2, "forwardUrl>>>>>>>>>> " + paramString2);
        }
        if ((!com.tencent.mobileqq.microapp.apkg.f.a(this.c)) || (!paramString1.startsWith("page/QQ/forward.html"))) {
          break label407;
        }
        boolean bool = baip.a(paramString2);
        if (bool) {
          break label407;
        }
        try
        {
          paramString1 = new String(Base64.decode(paramString2, 0));
          if (paramString1.startsWith("mqqapi"))
          {
            MiniAppLauncher.launchMiniAppByScheme(this.d, paramString1);
            return "";
          }
          if ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://")))
          {
            paramString2 = new Intent(this.d, QQBrowserActivity.class);
            paramString2.putExtra("url", paramString1);
            this.d.startActivity(paramString2);
            continue;
          }
        }
        catch (Throwable paramString1)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("AppBrandRuntime", 2, "decode forwardUrl occur an exception " + paramString1);
          continue;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
        return "";
      }
      QLog.w("AppBrandRuntime", 2, "unexpected url " + paramString1);
      continue;
      label407:
      if (!TextUtils.isEmpty(paramString1)) {
        com.tencent.mobileqq.microapp.appbrand.utils.a.a(new f(this, paramString1));
      }
    }
    if ("navigateBack".equals(paramString1))
    {
      paramInt = new JSONObject(paramString2).optInt("delta", 0);
      if (paramInt > 0) {
        com.tencent.mobileqq.microapp.appbrand.utils.a.a(new g(this, paramInt));
      }
    }
    else
    {
      if ("switchTab".equals(paramString1))
      {
        paramString1 = new JSONObject(paramString2).optString("url", "");
        if (TextUtils.isEmpty(paramString1)) {
          break label590;
        }
        com.tencent.mobileqq.microapp.appbrand.utils.a.a(new h(this, paramString1));
        break label590;
      }
      if ("reLaunch".equals(paramString1))
      {
        paramString1 = new JSONObject(paramString2).optString("url", "");
        if (!TextUtils.isEmpty(paramString1)) {
          com.tencent.mobileqq.microapp.appbrand.utils.a.a(new i(this, paramString1));
        }
        return "";
      }
      return a(paramString1, paramString2, this.i, paramInt);
      label584:
      return "";
    }
    return "";
    label590:
    return "";
  }
  
  public String toString()
  {
    return "[appId=" + this.a + ",versionType=" + this.b + ",isPause=" + this.j + ",mFinished=" + this.k + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a
 * JD-Core Version:    0.7.0.1
 */