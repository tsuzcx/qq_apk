package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.List;
import mqq.app.AppRuntime;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;

public class QQApiPlugin
  extends WebViewPlugin
{
  Context a;
  ShareMsgImpl b;
  WebUiUtils.QQBrowserBaseActivityInterface c = null;
  ShareMsgImpl.ShareMsgImplListener d = new QQApiPlugin.1(this);
  
  public QQApiPlugin()
  {
    this.mPluginNameSpace = "QQApi";
  }
  
  private static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appids", paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("vkey=");
    localStringBuilder.append(paramString3);
    localStringBuilder.append(";uin=");
    localStringBuilder.append(paramString4);
    paramString3 = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      paramString4 = new StringBuilder();
      paramString4.append("<--httpRequest vookies=");
      paramString4.append(paramString3);
      paramString4.append(",appids=");
      paramString4.append(paramString2);
      QLog.d("gamecenter", 2, paramString4.toString());
    }
    paramString2 = new Bundle();
    paramString2.putString("Cookie", paramString3);
    try
    {
      paramContext = HttpUtil.openUrl(paramContext, paramString1, "POST", localBundle, paramString2);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("httpRequest: result:");
        paramString1.append(paramContext);
        QLog.i("gamecenter", 2, paramString1.toString());
      }
      return paramContext;
    }
    catch (IOException paramContext)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("httpRequest:");
        paramString1.append(paramContext.getMessage());
        QLog.i("gamecenter", 2, paramString1.toString());
      }
      return "{'ret': -105, 'data' : 'httpRequest::Http no response.'}";
      if (QLog.isColorLevel()) {
        QLog.i("gamecenter", 2, "httpRequest:ClientProtocolException");
      }
      return "{'ret': -104, 'data' : 'httpRequest:ClientProtocolException'}";
    }
    catch (ClientProtocolException paramContext)
    {
      label228:
      break label228;
    }
  }
  
  Activity a()
  {
    for (Activity localActivity = this.mRuntime.d(); (localActivity != null) && ((localActivity instanceof BasePluginActivity)); localActivity = ((BasePluginActivity)localActivity).getOutActivity()) {}
    return localActivity;
  }
  
  public String a(String paramString)
  {
    Object localObject = this.mRuntime.c().getAccount();
    if ((this.mRuntime.f() != null) && (this.mRuntime.f().getIntent() != null)) {
      paramString = a(BaseApplicationImpl.getApplication(), "https://cgi.connect.qq.com/api/get_openids_by_appids", paramString, this.mRuntime.f().getIntent().getStringExtra("vkey"), (String)localObject);
    } else {
      paramString = "";
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<--getOpenidBatch result");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQApi", 2, ((StringBuilder)localObject).toString());
    }
    return paramString;
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("launchAppWithTokens ");
      ((StringBuilder)localObject1).append(paramString3);
      QLog.d("gamecenter", 2, ((StringBuilder)localObject1).toString());
    }
    AppLaucherHelper localAppLaucherHelper = new AppLaucherHelper();
    Object localObject1 = null;
    Object localObject2;
    if (this.c == null)
    {
      localObject2 = this.a;
      if (!(localObject2 instanceof PublicFragmentActivityForTool))
      {
        if (!(localObject2 instanceof QBaseActivity)) {
          break label113;
        }
        localObject1 = (AppInterface)((QBaseActivity)localObject2).getAppRuntime();
        break label113;
      }
    }
    localObject1 = this.mRuntime.b();
    label113:
    if (localObject1 == null) {
      return;
    }
    int j = 268435456;
    try
    {
      k = Integer.parseInt(paramString4);
      if ((k & 0x4000000) == 67108864) {
        j = 335544320;
      }
      i = j;
      if ((k & 0x20000000) == 536870912) {
        i = j | 0x20000000;
      }
      j = i;
      if ((k & 0x400000) == 4194304) {
        j = i | 0x400000;
      }
      i = j;
    }
    catch (Exception paramString4)
    {
      int k;
      int i;
      label193:
      boolean bool;
      break label193;
    }
    i = 268435456;
    ReportController.b(null, "CliOper", "", "", "Game", "Launch_game", 0, 0, paramString1, "", "", "");
    paramString4 = new StringBuilder();
    paramString4.append("tencentwtlogin");
    paramString4.append(paramString1);
    paramString4.append("://");
    paramString4 = paramString4.toString();
    bool = "wtlogin".equals(paramString5);
    k = 0;
    j = k;
    if (bool)
    {
      paramString5 = this.a.getPackageManager();
      localObject2 = new Intent("android.intent.action.VIEW");
      ((Intent)localObject2).setData(Uri.parse(paramString4));
      j = k;
      if (paramString5 != null)
      {
        j = k;
        if (paramString5.queryIntentActivities((Intent)localObject2, 0).size() > 0) {
          j = 1;
        }
      }
    }
    if (j != 0)
    {
      if ((this.mRuntime != null) && (this.mRuntime.a() != null))
      {
        paramString2 = this.mRuntime.a().getUrl();
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(getClass().getSimpleName(), 2, "launchAppWithWlogin webview is null");
        }
        paramString2 = "";
      }
      localAppLaucherHelper.a(paramString4, this.a, paramString2, (AppInterface)localObject1, paramString1, paramString3, i, paramString6);
      return;
    }
    localAppLaucherHelper.a((AppInterface)localObject1, this.a, paramString1, paramString2, paramString3, i);
  }
  
  public void b(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("appID");
      String str1 = ((JSONObject)localObject).optString("paramsStr");
      String str2 = ((JSONObject)localObject).optString("packageName");
      String str3 = ((JSONObject)localObject).optString("flags");
      String str4 = ((JSONObject)localObject).optString("type");
      localObject = ((JSONObject)localObject).optString("subappid");
      a(paramString, str1, str2, str3, str4, (String)localObject);
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("launchAppWithTokens", 2, "parse params error");
      }
      paramString.printStackTrace();
    }
  }
  
  public void c(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString, 10);
      paramString = (SwiftBrowserMiscHandler)super.getBrowserComponent(32);
      if (paramString != null)
      {
        Message localMessage = paramString.c.obtainMessage(0, i, 0);
        paramString.c.sendMessage(localMessage);
      }
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("QQApi".equals(paramString2))
    {
      boolean bool1;
      if ((paramJsBridgeListener != null) && (paramJsBridgeListener.c)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      addOpenApiListenerIfNeeded(paramString3, paramJsBridgeListener);
      int i = paramVarArgs.length;
      boolean bool2 = "isAppInstalled".equals(paramString3);
      paramString2 = null;
      if ((bool2) && (i == 1))
      {
        paramString1 = Boolean.valueOf(PackageUtil.a(this.a, paramVarArgs[0]));
      }
      else if (("checkAppInstalled".equals(paramString3)) && (i == 1))
      {
        paramString1 = PackageUtil.b(this.a, paramVarArgs[0]);
      }
      else if (("checkAppInstalledBatch".equals(paramString3)) && (i == 1))
      {
        paramString1 = PackageUtil.c(this.a, paramVarArgs[0]);
      }
      else if (("isAppInstalledBatch".equals(paramString3)) && (i == 1))
      {
        paramString1 = PackageUtil.d(this.a, paramVarArgs[0]);
      }
      else if (("startAppWithPkgName".equals(paramString3)) && (i == 1))
      {
        paramString1 = Boolean.valueOf(PackageUtil.a(this.a, paramVarArgs[0], null));
      }
      else if (("startAppWithPkgNameAndOpenId".equals(paramString3)) && (i == 2))
      {
        paramString1 = Boolean.valueOf(PackageUtil.a(this.a, paramVarArgs[0], paramVarArgs[1]));
      }
      else if (("getOpenidBatch".equals(paramString3)) && (i == 1))
      {
        paramString1 = a(paramVarArgs[0]);
      }
      else if (("launchAppWithTokens".equals(paramString3)) && ((i == 1) || (i == 4)))
      {
        if (i == 1)
        {
          b(paramVarArgs[0]);
          paramString1 = paramString2;
        }
        else
        {
          paramString1 = paramString2;
          if (i == 4)
          {
            a(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2], paramVarArgs[3], null, "");
            paramString1 = paramString2;
          }
        }
      }
      else if (("getAppsVerionCodeBatch".equals(paramString3)) && (i == 1))
      {
        paramString1 = PackageUtil.e(this.a, paramVarArgs[0]);
      }
      else if (("setShareURL".equals(paramString3)) && (i == 1))
      {
        paramString1 = Boolean.valueOf(this.b.a(paramVarArgs[0]));
      }
      else if (("setShareInfo".equals(paramString3)) && (i == 1))
      {
        paramString1 = Boolean.valueOf(this.b.b(paramVarArgs[0]));
      }
      else if (("setToolHiddenFlags".equals(paramString3)) && (i == 1))
      {
        c(paramVarArgs[0]);
        paramString1 = paramString2;
      }
      else if (("shareMsg".equals(paramString3)) && (i == 1))
      {
        this.b.a(paramVarArgs[0], bool1);
        paramString1 = paramString2;
      }
      else if (("shareText".equals(paramString3)) && (i == 1))
      {
        this.b.d(paramVarArgs[0]);
        paramString1 = paramString2;
      }
      else if (("shareHypertext".equals(paramString3)) && (i == 1))
      {
        this.b.e(paramVarArgs[0]);
        paramString1 = paramString2;
      }
      else if (("sendPokeMsg".equals(paramString3)) && (i == 1))
      {
        this.b.f(paramVarArgs[0]);
        paramString1 = paramString2;
      }
      else
      {
        if ((!"shareArkMessage".equals(paramString3)) || (i != 1)) {
          break label678;
        }
        this.b.c(paramVarArgs[0]);
        paramString1 = paramString2;
      }
      if (bool1)
      {
        callJs4OpenApiIfNeeded(paramString3, 0, paramString1);
        return true;
      }
      paramJsBridgeListener.a(paramString1);
      return true;
    }
    label678:
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    this.b.a(paramIntent, paramByte, paramInt);
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.a = a();
    this.b = new ShareMsgImpl(this.a, this.mRuntime.d(), this.mRuntime.b(), this.d);
    this.b.a(this);
    WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.d());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.QQBrowserBaseActivityInterface))) {
      this.c = ((WebUiUtils.QQBrowserBaseActivityInterface)localWebUiBaseInterface);
    }
  }
  
  protected void onDestroy()
  {
    this.b.a();
    super.onDestroy();
  }
  
  public void setWebUiInterface(WebUiBaseInterface paramWebUiBaseInterface)
  {
    super.setWebUiInterface(paramWebUiBaseInterface);
    ShareMsgImpl localShareMsgImpl = this.b;
    if (localShareMsgImpl != null)
    {
      localShareMsgImpl.a(paramWebUiBaseInterface);
      this.b.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.QQApiPlugin
 * JD-Core Version:    0.7.0.1
 */