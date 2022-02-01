package com.tencent.mobileqq.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.SoftKeyboardObserver;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import cooperation.qzone.report.lp.LpReportInfo_dc04171;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.QzoneStringMatcher;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebSecurityPluginV2
  extends WebViewPlugin
{
  String a = null;
  String b;
  boolean c = true;
  boolean d = true;
  SoftKeyboardObserver e;
  TroopMemberApiClient f;
  private int g;
  private WebSecurityPluginV2.URLCheckParams h;
  private ArrayList<String> i = new ArrayList();
  
  public WebSecurityPluginV2()
  {
    this.mPluginNameSpace = "UrlSaveVerifyV2";
  }
  
  private void a()
  {
    WebSecurityPluginV2.URLCheckParams localURLCheckParams = this.h;
    if (localURLCheckParams == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSecurityPluginV2", 2, "reportArkMsgOnPageFinish urlCheckParams is null");
      }
      return;
    }
    if (localURLCheckParams.i)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSecurityPluginV2", 2, "reportArkMsgOnPageFinish isPageFinish");
      }
      return;
    }
    b();
    localURLCheckParams = this.h;
    localURLCheckParams.i = true;
    this.g = this.f.a(localURLCheckParams, new WebSecurityPluginV2.2(this));
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.mRuntime != null)
    {
      if (this.mRuntime.a() == null) {
        return;
      }
      if (this.i.isEmpty())
      {
        if (!TextUtils.isEmpty(paramString2)) {
          this.i.add(paramString2);
        }
        return;
      }
      paramString2 = SwiftWebViewUtils.b(paramString1);
      if (("http".equals(paramString2)) || ("https".equals(paramString2)))
      {
        paramString2 = this.mRuntime.a().getHitTestResult();
        if ((paramString2 != null) && (paramString2.getType() == 0))
        {
          paramString2 = new StringBuilder();
          paramString2.append("shouldOverrideUrlLoading detect 302, url: ");
          paramString2.append(paramString1);
          QLog.i("WebSecurityPluginV2", 1, paramString2.toString());
          f(paramString1);
        }
      }
    }
  }
  
  private void b()
  {
    int j = this.i.size();
    if (j <= 0) {
      return;
    }
    String str = (String)this.i.get(j - 1);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(str);
    this.i = localArrayList;
  }
  
  private Object c(String paramString)
  {
    Object localObject;
    if (this.mRuntime != null) {
      localObject = this.mRuntime.d();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      localObject = ((Activity)localObject).getIntent();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      localObject = ((Intent)localObject).getStringExtra("url");
    } else {
      localObject = null;
    }
    if ((a((String)localObject)) && (b(paramString))) {
      return new WebResourceResponse("text/javascript", "utf-8", new ByteArrayInputStream("if(1===1){};".getBytes()));
    }
    return null;
  }
  
  private void c()
  {
    if (this.e == null)
    {
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView != null) {
        this.e = new SoftKeyboardObserver(localCustomWebView, new WebSecurityPluginV2.3(this));
      }
    }
  }
  
  private void d()
  {
    if ((this.mRuntime != null) && (this.mRuntime.d() != null))
    {
      Object localObject1 = this.mRuntime.d().getIntent();
      Object localObject2 = this.mRuntime.a();
      String str2;
      if (localObject2 != null) {
        str2 = ((CustomWebView)localObject2).getOriginalUrl();
      } else {
        str2 = "";
      }
      int j = 2;
      if (localObject1 != null)
      {
        if (((Intent)localObject1).getBooleanExtra("fromQrcode", false)) {}
        for (localObject1 = "mqq.qrcode";; localObject1 = "mqq.qzone")
        {
          break label360;
          if (!((Intent)localObject1).getBooleanExtra("key_isFromQZone", false)) {
            break;
          }
        }
        int m = ((Intent)localObject1).getIntExtra("uinType", -1);
        k = m;
        if (m == -1) {
          k = ((Intent)localObject1).getIntExtra("curtype", -1);
        }
        if (k != 0)
        {
          if (k != 1)
          {
            if ((k != 1000) && (k != 1001) && (k != 1004) && (k != 1005))
            {
              if (k != 3000)
              {
                QLog.d("WebSecurityPluginV2", 4, "reportSoftKeyboardToggled:unknow uinType");
              }
              else
              {
                str1 = ((Intent)localObject1).getStringExtra("dicussgroup_uin");
                localObject2 = ((Intent)localObject1).getStringExtra("friendUin");
                if (((Intent)localObject1).getBooleanExtra("is_send", false)) {
                  j = 1;
                }
                localObject1 = "mqq.discussion";
                k = j;
                j = 3;
                break label372;
              }
            }
            else
            {
              str1 = ((Intent)localObject1).getStringExtra("friend_uin");
              localObject2 = ((Intent)localObject1).getStringExtra("friendUin");
              if (((Intent)localObject1).getBooleanExtra("is_send", false)) {
                j = 1;
              }
              localObject1 = "";
              k = j;
              j = 1;
              break label372;
            }
          }
          else
          {
            str1 = ((Intent)localObject1).getStringExtra("groupUin");
            localObject2 = ((Intent)localObject1).getStringExtra("friendUin");
            if (((Intent)localObject1).getBooleanExtra("is_send", false)) {
              j = 1;
            } else {
              j = 2;
            }
            localObject1 = "mqq.group";
            k = j;
            j = 2;
            break label372;
          }
        }
        else
        {
          str1 = ((Intent)localObject1).getStringExtra("friend_uin");
          localObject2 = ((Intent)localObject1).getStringExtra("friendUin");
          if (((Intent)localObject1).getBooleanExtra("is_send", false)) {
            j = 1;
          }
          localObject1 = "mqq.c2c";
          k = j;
          j = 0;
          break label372;
        }
      }
      localObject1 = "";
      label360:
      localObject2 = "";
      String str1 = "";
      j = -1;
      int k = 0;
      label372:
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportSoftKeyboardToggled-- referer:");
        localStringBuilder.append(str2);
        localStringBuilder.append(" ,url:");
        localStringBuilder.append(this.b);
        localStringBuilder.append(" ,msgType:");
        localStringBuilder.append(j);
        localStringBuilder.append(",msgFrom:");
        localStringBuilder.append(k);
        localStringBuilder.append(",senderUin:");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(",chatId:");
        localStringBuilder.append(str1);
        localStringBuilder.append(",urlSource:");
        localStringBuilder.append((String)localObject1);
        QLog.d("WebSecurityPluginV2", 1, localStringBuilder.toString());
      }
      LpReportInfo_dc04171.report(this.b, str2, (String)localObject1, j, k, (String)localObject2, str1);
      return;
    }
    QLog.e("WebSecurityPluginV2", 1, "reportSoftKeyboardToggled mRuntime empty");
  }
  
  private boolean d(String paramString)
  {
    return AuthorizeConfig.a().h(paramString);
  }
  
  private boolean e(String paramString)
  {
    return AuthorizeConfig.a().i(paramString);
  }
  
  private String[] e()
  {
    Object localObject = AuthorizeConfig.a().c("ban_domain", "douyin.com,huoshan.com,changba.com,toutiao.com,xiguaapp.cn,xiguashipin.cn,365yg.com,snssdk.com,ixigua.com,toutiaocdn.net,music.163.com,weibo.cn,autohome.com.cn");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = ((String)localObject).split(",");
    if (localObject == null) {
      return null;
    }
    int j = 0;
    while (j < localObject.length)
    {
      if (TextUtils.isEmpty(localObject[j])) {
        localObject[j] = "";
      } else {
        localObject[j] = localObject[j].trim();
      }
      j += 1;
    }
    return localObject;
  }
  
  private void f(String paramString)
  {
    if ((!this.i.contains(paramString)) && (!TextUtils.isEmpty(paramString))) {
      this.i.add(paramString);
    }
  }
  
  void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebSecurityPluginV2", 2, new Object[] { "checkOperationBit ", Long.valueOf(paramLong) });
    }
    Object localObject1;
    if ((1L & paramLong) != 0L)
    {
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView != null)
      {
        try
        {
          if (localCustomWebView.getX5WebViewExtension() == null) {
            return;
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("forbid-input", "*");
          localCustomWebView.getX5WebViewExtension().setFakeLoginParams((Bundle)localObject1);
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("WebSecurityPluginV2", 2, "checkOperationBit success");
          return;
        }
        catch (Throwable localThrowable1)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        QLog.e("WebSecurityPluginV2", 2, "initWebviewExtension e:", localThrowable1);
      }
    }
    else if ((paramLong & 0x4) != 0L)
    {
      Object localObject3 = this.mRuntime.d().getIntent();
      Object localObject2 = this.mRuntime.a();
      localObject1 = "";
      String str;
      if (localObject2 != null) {
        str = ((CustomWebView)localObject2).getUrl();
      } else {
        str = "";
      }
      if (localObject3 != null) {
        localObject1 = ((Intent)localObject3).getStringExtra("url");
      }
      if (this.f != null) {
        try
        {
          localObject3 = SwiftBrowserStatistics.h((String)localObject1);
          ((Bundle)localObject3).putString("uin", this.mRuntime.b().getCurrentAccountUin());
          if (localObject2 != null)
          {
            localObject2 = ((CustomWebView)localObject2).getTitle();
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              ((Bundle)localObject3).putString("title", (String)localObject2);
            }
          }
          this.f.a(1, str, (String)localObject1, (Bundle)localObject3);
          return;
        }
        catch (Throwable localThrowable2)
        {
          QLog.e("WebSecurityPluginV2", 1, localThrowable2, new Object[0]);
        }
      }
    }
  }
  
  boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str = Utils.getDomin(paramString);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    str = str.toLowerCase();
    Object localObject1 = e();
    if (localObject1 != null)
    {
      if (localObject1.length == 0) {
        return false;
      }
      int k = localObject1.length;
      int j = 0;
      while (j < k)
      {
        Object localObject2 = localObject1[j];
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject2 = ((String)localObject2).toLowerCase();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(".");
          localStringBuilder.append((String)localObject2);
          if (str.endsWith(localStringBuilder.toString()))
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("match domain:");
              ((StringBuilder)localObject1).append(str);
              ((StringBuilder)localObject1).append(",webviewUrl=");
              ((StringBuilder)localObject1).append(paramString);
              QLog.d("WebSecurityPluginV2", 2, ((StringBuilder)localObject1).toString());
            }
            return true;
          }
          if (str.equals(localObject2))
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("match domain:");
              ((StringBuilder)localObject1).append(str);
              ((StringBuilder)localObject1).append(",webviewUrl=");
              ((StringBuilder)localObject1).append(paramString);
              QLog.d("WebSecurityPluginV2", 2, ((StringBuilder)localObject1).toString());
            }
            return true;
          }
        }
        j += 1;
      }
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    String str = AuthorizeConfig.a().c("call_app", "['https?://intent\\.music\\.163\\.com.+orpheus.*','^https?://([^/]+\\.)?thefatherofsalmon\\.com[/:].+','^https?://127\\.0\\.0\\.1[/:].+','^https?://0:0:0:0:0:0:0:1[/:].+','^https?://::1[/:].+']");
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    try
    {
      Object localObject = new JSONArray(str);
      int j = 0;
      while (j < ((JSONArray)localObject).length())
      {
        str = ((JSONArray)localObject).optString(j);
        if ((!TextUtils.isEmpty(str)) && (QzoneStringMatcher.isMatch(paramString, str)))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("isUrlInRegList match url:");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(" ,reg=");
            ((StringBuilder)localObject).append(str);
            QLog.d("WebSecurityPluginV2", 2, ((StringBuilder)localObject).toString());
          }
          return true;
        }
        j += 1;
      }
      return false;
    }
    catch (JSONException paramString)
    {
      QZLog.e("WebSecurityPluginV2", "isUrlInRegList json error.", paramString);
    }
    return false;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8L;
  }
  
  public long getWebViewSchemaByNameSpace(String paramString)
  {
    return 3L;
  }
  
  protected Object handleEvent(String paramString, long paramLong)
  {
    if (paramLong == 8L) {
      return c(paramString);
    }
    return super.handleEvent(paramString, paramLong);
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934594L) {
      a();
    } else if (paramLong == 8589934626L) {
      f(paramString);
    }
    return super.handleEvent(paramString, paramLong, paramMap);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (("UrlSaveVerifyV2".equals(paramString2)) && ("continueVisit".equals(paramString3)) && (paramVarArgs.length > 0)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("url");
        if (!TextUtils.isEmpty(paramJsBridgeListener))
        {
          paramString1 = this.mRuntime.a();
          if (paramString1 != null)
          {
            if (QLog.isColorLevel())
            {
              paramString2 = new StringBuilder();
              paramString2.append("continueVisit url=");
              paramString2.append(Util.b(paramJsBridgeListener, new String[0]));
              QLog.d("WebSecurityPluginV2", 2, paramString2.toString());
            }
            this.a = paramJsBridgeListener;
            paramString1.loadUrl(paramJsBridgeListener);
            return false;
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("WebSecurityPluginV2", 2, "jump url is null");
          return false;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        QLog.e("WebSecurityPluginV2", 1, paramJsBridgeListener.toString());
      }
    }
    return false;
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" url = ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" scheme = ");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("WebSecurityPluginV2springHb_", 2, ((StringBuilder)localObject1).toString());
    }
    boolean bool1 = "http".equals(paramString2);
    boolean bool4 = false;
    boolean bool3;
    if (!bool1)
    {
      bool3 = bool4;
      if (!"https".equals(paramString2)) {}
    }
    else
    {
      if ((this.mRuntime == null) || (this.mRuntime.d() == null)) {
        break label1142;
      }
      c();
      paramString2 = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramString2 != null) && (!paramString2.isLogin()))
      {
        QLog.e("WebSecurityPluginV2", 1, "appRuntime.isLogin() is false!");
        return false;
      }
      if (!AppNetConnInfo.isNetSupport())
      {
        QLog.e("WebSecurityPluginV2", 1, "no network");
        return false;
      }
    }
    for (;;)
    {
      Object localObject2;
      int j;
      try
      {
        paramString2 = QIPCClientHelper.getInstance().getClient().callServer("SpringHbIPCModule", "GetActivityPref", new Bundle()).data.getString("activity_pref");
        localObject1 = paramString2.split("\\|");
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("perfUrls ");
          ((StringBuilder)localObject2).append(Arrays.toString((Object[])localObject1));
          QLog.d("WebSecurityPluginV2springHb_SpringHbSecurity", 1, ((StringBuilder)localObject2).toString());
        }
        if (!TextUtils.isEmpty(paramString2))
        {
          j = 0;
          if (j < localObject1.length)
          {
            if (!paramString1.startsWith(localObject1[j])) {
              break label1155;
            }
            if (!QLog.isColorLevel()) {
              break label1153;
            }
            paramString2 = new StringBuilder();
            paramString2.append("isDisableSecurityCheck url=");
            paramString2.append(paramString1);
            QLog.d("springHb_SpringHbSecurity", 1, paramString2.toString());
            return false;
          }
        }
        else if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("notDisableSecurityCheck url=");
          paramString2.append(paramString1);
          QLog.d("springHb_SpringHbSecurity", 1, paramString2.toString());
        }
      }
      catch (Exception paramString2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("springHb_SpringHbSecurity", 2, "handleIsSecurityEnable e:", paramString2);
        }
      }
      this.b = paramString1;
      if (paramString1.equals(this.a))
      {
        this.a = null;
        if (QLog.isColorLevel()) {
          QLog.i("WebSecurityPluginV2", 2, "should pass check");
        }
        return false;
      }
      boolean bool2;
      if (this.d)
      {
        bool2 = d(paramString1);
        this.c = (e(paramString1) ^ true);
        this.d = false;
        paramString2 = (SwiftBrowserStatistics)getBrowserComponent(-2);
        if (paramString2 != null) {
          paramString2.aT = (bool2 ^ true);
        }
        bool1 = true;
      }
      else
      {
        bool1 = e(paramString1) ^ true;
        this.c = bool1;
        bool2 = true;
      }
      bool3 = bool4;
      if (bool1)
      {
        paramString2 = new StringBuilder();
        paramString2.append("now check url=");
        paramString2.append(Util.b(paramString1, new String[0]));
        paramString2.append(", async=");
        paramString2.append(bool2);
        QLog.i("UrlCheckLog", 1, paramString2.toString());
        if (this.f == null)
        {
          this.f = TroopMemberApiClient.a();
          this.f.e();
        }
        localObject2 = this.mRuntime.d().getIntent();
        Object localObject3;
        if (localObject2 != null)
        {
          paramString2 = this.mRuntime.a();
          if (paramString2 != null)
          {
            localObject1 = paramString2.getUrl();
            paramString2 = (String)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              paramString2 = ((Intent)localObject2).getStringExtra("url");
            }
          }
          else
          {
            paramString2 = "";
          }
          if (((Intent)localObject2).getBooleanExtra("fromQrcode", false)) {}
          for (localObject1 = "mqq.qrcode";; localObject1 = "mqq.qzone")
          {
            localObject2 = localObject1;
            localObject3 = paramString2;
            break label974;
            if (!((Intent)localObject2).getBooleanExtra("key_isFromQZone", false)) {
              break;
            }
          }
          k = ((Intent)localObject2).getIntExtra("uinType", -1);
          j = k;
          if (k == -1) {
            j = ((Intent)localObject2).getIntExtra("curtype", -1);
          }
          if (j != 0)
          {
            if (j != 1)
            {
              if ((j != 1000) && (j != 1001) && (j != 1004) && (j != 1005))
              {
                if (j != 3000)
                {
                  localObject2 = "";
                  localObject3 = paramString2;
                }
                else
                {
                  localObject1 = ((Intent)localObject2).getStringExtra("dicussgroup_uin");
                  str = ((Intent)localObject2).getStringExtra("friendUin");
                  if (((Intent)localObject2).getBooleanExtra("is_send", false)) {
                    j = 1;
                  } else {
                    j = 2;
                  }
                  localObject2 = "mqq.discussion";
                  localObject3 = paramString2;
                  paramString2 = str;
                  k = 3;
                  break label986;
                }
              }
              else
              {
                localObject1 = ((Intent)localObject2).getStringExtra("friend_uin");
                str = ((Intent)localObject2).getStringExtra("friendUin");
                if (((Intent)localObject2).getBooleanExtra("is_send", false)) {
                  j = 1;
                } else {
                  j = 2;
                }
                localObject2 = "";
                localObject3 = paramString2;
                paramString2 = str;
                k = 1;
                break label986;
              }
            }
            else
            {
              localObject1 = ((Intent)localObject2).getStringExtra("groupUin");
              str = ((Intent)localObject2).getStringExtra("friendUin");
              if (((Intent)localObject2).getBooleanExtra("is_send", false)) {
                j = 1;
              } else {
                j = 2;
              }
              localObject3 = paramString2;
              localObject2 = "mqq.group";
              paramString2 = str;
              k = 2;
              break label986;
            }
          }
          else
          {
            localObject1 = ((Intent)localObject2).getStringExtra("friend_uin");
            str = ((Intent)localObject2).getStringExtra("friendUin");
            if (((Intent)localObject2).getBooleanExtra("is_send", false)) {
              j = 1;
            } else {
              j = 2;
            }
            localObject3 = paramString2;
            localObject2 = "mqq.c2c";
            paramString2 = str;
            k = 0;
            break label986;
          }
        }
        else
        {
          localObject2 = "";
          localObject3 = localObject2;
        }
        label974:
        localObject1 = "";
        paramString2 = "";
        j = 0;
        int k = -1;
        label986:
        String str = this.mRuntime.d().getIntent().getStringExtra("h5_ark_app_name");
        a(paramString1, (String)localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("WebSecurityPluginV2", 2, new Object[] { " arkBusinessName =", str });
        }
        this.h = WebSecurityPluginV2.URLCheckParams.a(paramString1, k, j, paramString2, (String)localObject1, (String)localObject2, (String)localObject3, str, false, this.i);
        this.g = this.f.a(this.h, new WebSecurityPluginV2.1(this, paramString1, bool2));
        if (QLog.isColorLevel())
        {
          paramString2 = new StringBuilder();
          paramString2.append("sendSecurityCheck url=");
          paramString2.append(paramString1);
          QLog.d("WebSecurityPluginV2", 1, paramString2.toString());
        }
        bool3 = bool4;
        if (!bool2) {
          bool3 = true;
        }
      }
      return bool3;
      label1142:
      QLog.e("WebSecurityPluginV2", 1, "handleSchemaRequest mRuntime empty");
      return false;
      label1153:
      return false;
      label1155:
      j += 1;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.f;
    if (localObject != null)
    {
      ((TroopMemberApiClient)localObject).a(this.g);
      this.f.f();
    }
    localObject = this.e;
    if (localObject != null) {
      ((SoftKeyboardObserver)localObject).a();
    }
    this.i.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebSecurityPluginV2
 * JD-Core Version:    0.7.0.1
 */