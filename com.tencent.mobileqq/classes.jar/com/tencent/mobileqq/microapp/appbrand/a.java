package com.tencent.mobileqq.microapp.appbrand;

import Wallet.ApkgConfig;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.ComIPCUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.microapp.MiniAppInterface;
import com.tencent.mobileqq.microapp.apkg.MiniAppConfig;
import com.tencent.mobileqq.microapp.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.microapp.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.microapp.appbrand.page.AppBrandServiceEventInterface;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.microapp.sdk.MiniAppException;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.microapp.webview.BaseAppBrandWebview;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.StringUtil;
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
  public volatile com.tencent.mobileqq.microapp.a.c c;
  public BaseActivity d;
  public MiniAppInterface e;
  public k f;
  public AppBrandPageContainer g;
  public com.tencent.mobileqq.microapp.appbrand.a.a.f h;
  public ServiceWebview i;
  public boolean j;
  boolean k;
  public long l = -1L;
  
  public a(BaseActivity paramBaseActivity, k paramk, com.tencent.mobileqq.microapp.a.c paramc)
  {
    this.d = paramBaseActivity;
    this.c = paramc;
    this.f = paramk;
    this.g = new AppBrandPageContainer(paramBaseActivity, this);
    AppInterface localAppInterface = paramBaseActivity.getAppInterface();
    if ((localAppInterface instanceof MiniAppInterface)) {
      this.e = ((MiniAppInterface)localAppInterface);
    }
    if ((this.e != null) && (paramk != null) && (paramc != null) && (paramc.f != null) && (paramc.b != null))
    {
      this.b = paramc.f.getRuntimeType();
      this.a = paramc.d;
      this.h = new com.tencent.mobileqq.microapp.appbrand.a.a.f(paramBaseActivity, this);
      com.tencent.mobileqq.microapp.appbrand.b.c.a();
      return;
    }
    paramBaseActivity = new StringBuilder();
    paramBaseActivity.append("app params error, apkgInfo=");
    paramBaseActivity.append(paramc);
    paramBaseActivity.append(",appId=");
    paramBaseActivity.append(this.a);
    paramBaseActivity.append(",appInterface=");
    paramBaseActivity.append(this.e);
    paramBaseActivity.append(",appBrandRuntimeContainer=");
    paramBaseActivity.append(paramk);
    throw new MiniAppException(paramBaseActivity.toString());
  }
  
  public String a(String paramString1, String paramString2, BaseAppBrandWebview paramBaseAppBrandWebview, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleNativeRequest. eventName=");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(",jsonParams=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(",callbackId=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",webview=");
      ((StringBuilder)localObject).append(paramBaseAppBrandWebview);
      ((StringBuilder)localObject).append(" | ");
      ((StringBuilder)localObject).append(this);
      QLog.d("AppBrandRuntime", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.h;
    if (localObject != null) {
      return ((com.tencent.mobileqq.microapp.appbrand.a.a.f)localObject).a(paramString1, paramString2, paramBaseAppBrandWebview, paramInt);
    }
    return "";
  }
  
  public final void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cleanup. | ");
      localStringBuilder.append(this);
      QLog.d("AppBrandRuntime", 4, localStringBuilder.toString());
    }
    this.g.cleanup(false);
    this.h.f();
    com.tencent.mobileqq.microapp.appbrand.b.h.a().a(this.i, this.d);
  }
  
  public final void a(com.tencent.mobileqq.microapp.a.c paramc)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateApkgInfo. apkgInfo=");
      localStringBuilder.append(paramc);
      localStringBuilder.append(" | ");
      localStringBuilder.append(this);
      QLog.d("AppBrandRuntime", 4, localStringBuilder.toString());
    }
    if (paramc != null) {
      this.c = paramc;
    }
  }
  
  public final void a(MiniAppConfig paramMiniAppConfig)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResume. | ");
      ((StringBuilder)localObject).append(this);
      QLog.d("AppBrandRuntime", 4, ((StringBuilder)localObject).toString());
    }
    this.j = false;
    this.h.d();
    this.g.setVisibility(0);
    this.g.bringToFront();
    this.g.pageLinkedList.peek();
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("scene", paramMiniAppConfig.launchParam.scene);
      ((JSONObject)localObject).put("appId", this.a);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    a("onAppEnterForeground", ((JSONObject)localObject).toString());
    this.c.a(paramMiniAppConfig);
    com.tencent.mobileqq.microapp.appbrand.b.b.a().a(this.c);
    com.tencent.mobileqq.microapp.app.b.a().a("resumePlayer");
    f();
    d();
  }
  
  public final void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("reload. entryPath=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" | ");
      localStringBuilder.append(this);
      QLog.d("AppBrandRuntime", 4, localStringBuilder.toString());
    }
    a();
    a(paramString, true);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = String.format("WeixinJSBridge.subscribeHandler('%1$s',%2$s)", new Object[] { paramString1, paramString2 });
    } else {
      paramString1 = String.format("WeixinJSBridge.subscribeHandler('%1$s')", new Object[] { paramString1 });
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("evaluateServiceSubcribeJS. jsStr=");
      paramString2.append(paramString1);
      QLog.d("AppBrandRuntime", 4, paramString2.toString());
    }
    this.i.evaluteJs(paramString1);
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("evaluateServiceSubcribeJS. eventName=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",data=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",webviewId=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" | ");
      localStringBuilder.append(this);
      QLog.d("AppBrandRuntime", 4, localStringBuilder.toString());
    }
    this.i.evaluateSubcribeJS(paramString1, paramString2, paramInt);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startShare. content=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(",sharePicPath=");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(",entryPath=");
      ((StringBuilder)localObject1).append(paramString3);
      QLog.d("AppBrandRuntime", 4, ((StringBuilder)localObject1).toString());
    }
    String str1 = paramString2;
    String str2 = paramString1;
    String str4 = this.c.c;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[分享] 轻应用");
    ((StringBuilder)localObject1).append(this.c.c);
    String str5 = ((StringBuilder)localObject1).toString();
    String str6 = this.c.e;
    Object localObject2 = null;
    Object localObject3 = localObject2;
    localObject1 = str2;
    try
    {
      JSONObject localJSONObject = new JSONObject(this.c.f.config.desc_info);
      localObject3 = localObject2;
      localObject1 = str2;
      String str3 = localJSONObject.optString("share_low_url", "");
      localObject2 = str2;
      localObject3 = str3;
      localObject1 = str2;
      if (TextUtils.isEmpty(paramString1))
      {
        localObject3 = str3;
        localObject1 = str2;
        localObject2 = localJSONObject.optString("share_content");
      }
      paramString1 = (String)localObject2;
      localObject3 = str3;
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject3 = str3;
        localObject1 = localObject2;
        paramString1 = localJSONObject.optString("desc_info");
      }
      localObject3 = str3;
      localObject1 = paramString1;
      if (TextUtils.isEmpty(paramString2))
      {
        localObject3 = str3;
        localObject1 = paramString1;
        paramString2 = localJSONObject.optString("share_pic_url");
      }
      else
      {
        paramString2 = str1;
      }
      localObject3 = str3;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      paramString1 = (String)localObject1;
      paramString2 = str1;
    }
    localObject2 = new JSONObject();
    try
    {
      ((JSONObject)localObject2).put("appId", this.a);
      ((JSONObject)localObject2).put("entryPathInConfig", this.c.b.f);
      localObject1 = localObject3;
      if (!TextUtils.isEmpty(paramString3))
      {
        ((JSONObject)localObject2).put("entryPath", paramString3);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(localObject3);
        ((StringBuilder)localObject1).append("&path=");
        ((StringBuilder)localObject1).append(URLEncoder.encode(paramString3));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    catch (JSONException paramString3)
    {
      paramString3.printStackTrace();
      localObject1 = localObject3;
    }
    paramString3 = ((JSONObject)localObject2).toString();
    ShareMsgHelper.a(this.d, 1001, 1, "web_share", "", str6, str4, paramString1, str5, (String)localObject1, "web", paramString3, "micro_app", paramString2, null, null, null, null, null, null, null, null, 7, null, -1L);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAppCreate. fromReload=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",entryPath=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" | ");
      ((StringBuilder)localObject).append(this);
      QLog.d("AppBrandRuntime", 4, ((StringBuilder)localObject).toString());
    }
    this.j = false;
    this.k = false;
    this.h.a();
    this.h.c();
    Object localObject = paramString;
    if (!this.c.k(paramString)) {
      localObject = this.c.b.f;
    }
    this.i = com.tencent.mobileqq.microapp.appbrand.b.h.a().a(this.a);
    if (this.i.apkgInfo$5475ea27 == null) {
      this.i.apkgInfo$5475ea27 = this.c;
    }
    paramString = this.i;
    paramString.appBrandEventInterface = this;
    if (!paramBoolean)
    {
      paramString.initService$cfb2ece(this.c, null);
      this.g.launch((String)localObject, "appLaunch");
    }
    else
    {
      paramString.initService$cfb2ece(this.c, new b(this, (String)localObject));
    }
    com.tencent.mobileqq.microapp.app.b.a().a("resetPlayer");
  }
  
  public final void b()
  {
    if (this.k) {
      return;
    }
    this.k = true;
    Object localObject = this.f;
    if (localObject != null)
    {
      int m = ((k)localObject).c();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("finish. appRunTimeCount=");
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append(" | ");
        ((StringBuilder)localObject).append(this);
        QLog.d("AppBrandRuntime", 4, ((StringBuilder)localObject).toString());
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPause. | ");
      ((StringBuilder)localObject).append(this);
      QLog.d("AppBrandRuntime", 4, ((StringBuilder)localObject).toString());
    }
    this.j = true;
    this.h.e();
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("scene", 1001);
      ((JSONObject)localObject).put("appId", this.a);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    a("onAppEnterBackground", ((JSONObject)localObject).toString());
    e();
  }
  
  public void d()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject1.put("miniAppId", this.c.d);
      localJSONObject1.put("scene", this.c.f.launchParam.scene);
      localJSONObject2.put("page", com.tencent.mobileqq.microapp.a.c.n(this.g.getCurrentPage().getUrl()));
      this.l = VACDReportUtil.startReport(localJSONObject1.toString(), "MiniAppStat", "MiniAppVisitReport", "PageVisit", localJSONObject2.toString(), 0, null);
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
    ComIPCUtils.tryUpdateMiniApp(this.c.f.launchParam, this.c.f.config.mini_version, new c(this));
  }
  
  public void onServiceEvent(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if ("custom_event_onAppRouteDone".equals(paramString1)) {
      com.tencent.mobileqq.microapp.appbrand.b.a.a(new d(this));
    }
    int n = paramArrayOfInt.length;
    int m = 0;
    while (m < n)
    {
      int i1 = paramArrayOfInt[m];
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onServiceEvent. eventName=");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(",jsonParams=");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(",webviewIds=");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(" | ");
        ((StringBuilder)localObject).append(this);
        QLog.d("AppBrandRuntime", 4, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.g.findPageWebView(i1);
      if (localObject != null) {
        ((PageWebview)localObject).evaluateSubcribeJSInService(paramString1, paramString2, i1);
      }
      m += 1;
    }
  }
  
  public String onServiceNativeRequest(String paramString1, String paramString2, int paramInt)
  {
    if (!"reportIDKey".equals(paramString1))
    {
      if ("reportRealtimeAction".equals(paramString1)) {
        return "";
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onServiceNativeRequest eventName=");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(",jsonParams=");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(",callbackId=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" | ");
        localStringBuilder.append(this);
        QLog.d("AppBrandRuntime", 4, localStringBuilder.toString());
      }
      if (this.k) {
        return "";
      }
      try
      {
        boolean bool = "redirectTo".equals(paramString1);
        if (bool)
        {
          paramString1 = new JSONObject(paramString2).optString("url", "");
          if (TextUtils.isEmpty(paramString1)) {
            break label641;
          }
          com.tencent.mobileqq.microapp.appbrand.b.a.a(new e(this, paramString1));
          return "";
        }
        if ("navigateTo".equals(paramString1))
        {
          paramString1 = new JSONObject(paramString2).optString("url", "");
          paramString2 = com.tencent.mobileqq.microapp.a.c.b(paramString1, "url");
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("forwardUrl>>>>>>>>>> ");
            localStringBuilder.append(paramString2);
            QLog.i("AppBrandRuntime", 2, localStringBuilder.toString());
          }
          if ((com.tencent.mobileqq.microapp.a.c.a(this.c)) && (paramString1.startsWith("page/QQ/forward.html")))
          {
            bool = StringUtil.a(paramString2);
            if (!bool)
            {
              try
              {
                paramString1 = new String(Base64.decode(paramString2, 0));
                if (paramString1.startsWith("mqqapi"))
                {
                  MiniAppLauncher.launchMiniAppByScheme(this.d, paramString1);
                  return "";
                }
                if ((!paramString1.startsWith("http://")) && (!paramString1.startsWith("https://")))
                {
                  if (!QLog.isColorLevel()) {
                    break label644;
                  }
                  paramString2 = new StringBuilder();
                  paramString2.append("unexpected url ");
                  paramString2.append(paramString1);
                  QLog.w("AppBrandRuntime", 2, paramString2.toString());
                  return "";
                }
                paramString2 = new Intent(this.d, QQBrowserActivity.class);
                paramString2.putExtra("url", paramString1);
                this.d.startActivity(paramString2);
                return "";
              }
              catch (Throwable paramString1)
              {
                if (!QLog.isColorLevel()) {
                  break label644;
                }
              }
              paramString2 = new StringBuilder();
              paramString2.append("decode forwardUrl occur an exception ");
              paramString2.append(paramString1);
              QLog.e("AppBrandRuntime", 2, paramString2.toString());
              return "";
            }
          }
          if (TextUtils.isEmpty(paramString1)) {
            break label644;
          }
          com.tencent.mobileqq.microapp.appbrand.b.a.a(new f(this, paramString1));
          return "";
        }
        if ("navigateBack".equals(paramString1))
        {
          paramInt = new JSONObject(paramString2).optInt("delta", 0);
          if (paramInt <= 0) {
            break label647;
          }
          com.tencent.mobileqq.microapp.appbrand.b.a.a(new g(this, paramInt));
          return "";
        }
        if ("switchTab".equals(paramString1))
        {
          paramString1 = new JSONObject(paramString2).optString("url", "");
          if (TextUtils.isEmpty(paramString1)) {
            break label650;
          }
          com.tencent.mobileqq.microapp.appbrand.b.a.a(new h(this, paramString1));
          return "";
        }
        if ("reLaunch".equals(paramString1))
        {
          paramString1 = new JSONObject(paramString2).optString("url", "");
          if (!TextUtils.isEmpty(paramString1)) {
            com.tencent.mobileqq.microapp.appbrand.b.a.a(new i(this, paramString1));
          }
          return "";
        }
        return a(paramString1, paramString2, this.i, paramInt);
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    else
    {
      return "";
    }
    label641:
    return "";
    label644:
    return "";
    label647:
    return "";
    label650:
    return "";
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[appId=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(",versionType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(",isPause=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(",mFinished=");
    localStringBuilder.append(this.k);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.appbrand.a
 * JD-Core Version:    0.7.0.1
 */