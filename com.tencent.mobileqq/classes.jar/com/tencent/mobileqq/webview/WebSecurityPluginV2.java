package com.tencent.mobileqq.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
import com.tencent.mobileqq.webview.util.WebViewConstant;
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
  private int jdField_a_of_type_Int;
  SoftKeyboardObserver jdField_a_of_type_ComTencentBizSoftKeyboardObserver;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  private WebSecurityPluginV2.URLCheckParams jdField_a_of_type_ComTencentMobileqqWebviewWebSecurityPluginV2$URLCheckParams;
  String jdField_a_of_type_JavaLangString = null;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_a_of_type_Boolean = true;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = true;
  
  public WebSecurityPluginV2()
  {
    this.mPluginNameSpace = "UrlSaveVerifyV2";
  }
  
  private Object a(String paramString)
  {
    Object localObject;
    if (this.mRuntime != null) {
      localObject = this.mRuntime.a();
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
  
  private void a()
  {
    WebSecurityPluginV2.URLCheckParams localURLCheckParams = this.jdField_a_of_type_ComTencentMobileqqWebviewWebSecurityPluginV2$URLCheckParams;
    if (localURLCheckParams == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSecurityPluginV2", 2, "reportArkMsgOnPageFinish urlCheckParams is null");
      }
      return;
    }
    if (localURLCheckParams.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebSecurityPluginV2", 2, "reportArkMsgOnPageFinish isPageFinish");
      }
      return;
    }
    b();
    localURLCheckParams = this.jdField_a_of_type_ComTencentMobileqqWebviewWebSecurityPluginV2$URLCheckParams;
    localURLCheckParams.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(localURLCheckParams, new WebSecurityPluginV2.2(this));
  }
  
  private void a(String paramString)
  {
    if ((!this.jdField_a_of_type_JavaUtilArrayList.contains(paramString)) && (!TextUtils.isEmpty(paramString))) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (this.mRuntime != null)
    {
      if (this.mRuntime.a() == null) {
        return;
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
      {
        if (!TextUtils.isEmpty(paramString2)) {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramString2);
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
          a(paramString1);
        }
      }
    }
  }
  
  private String[] a()
  {
    Object localObject = AuthorizeConfig.a().a("ban_domain", "douyin.com,huoshan.com,changba.com,toutiao.com,xiguaapp.cn,xiguashipin.cn,365yg.com,snssdk.com,ixigua.com,toutiaocdn.net,music.163.com,weibo.cn,autohome.com.cn");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = ((String)localObject).split(",");
    if (localObject == null) {
      return null;
    }
    int i = 0;
    while (i < localObject.length)
    {
      if (TextUtils.isEmpty(localObject[i])) {
        localObject[i] = "";
      } else {
        localObject[i] = localObject[i].trim();
      }
      i += 1;
    }
    return localObject;
  }
  
  private void b()
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (i <= 0) {
      return;
    }
    String str = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i - 1);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(str);
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver == null)
    {
      CustomWebView localCustomWebView = this.mRuntime.a();
      if (localCustomWebView != null) {
        this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver = new SoftKeyboardObserver(localCustomWebView, new WebSecurityPluginV2.3(this, localCustomWebView));
      }
    }
  }
  
  private boolean c(String paramString)
  {
    return AuthorizeConfig.a().c(paramString);
  }
  
  private void d()
  {
    if ((this.mRuntime != null) && (this.mRuntime.a() != null))
    {
      Object localObject1 = this.mRuntime.a().getIntent();
      Object localObject2 = this.mRuntime.a();
      String str2;
      if (localObject2 != null) {
        str2 = ((CustomWebView)localObject2).getOriginalUrl();
      } else {
        str2 = "";
      }
      int i = 2;
      if (localObject1 != null)
      {
        if (((Intent)localObject1).getBooleanExtra("fromQrcode", false)) {}
        for (localObject1 = "mqq.qrcode";; localObject1 = "mqq.qzone")
        {
          break label377;
          if (!((Intent)localObject1).getBooleanExtra("key_isFromQZone", false)) {
            break;
          }
        }
        int k = ((Intent)localObject1).getIntExtra("uinType", -1);
        j = k;
        if (k == -1) {
          j = ((Intent)localObject1).getIntExtra("curtype", -1);
        }
        if (j != 0)
        {
          if (j != 1)
          {
            if ((j != 1000) && (j != 1001) && (j != 1004) && (j != 1005))
            {
              if (j != 3000)
              {
                QLog.d("WebSecurityPluginV2", 4, "reportSoftKeyboardToggled:unknow uinType");
              }
              else
              {
                str1 = ((Intent)localObject1).getStringExtra("dicussgroup_uin");
                localObject2 = ((Intent)localObject1).getStringExtra("friendUin");
                if (((Intent)localObject1).getBooleanExtra("is_send", false)) {
                  i = 1;
                }
                localObject1 = "mqq.discussion";
                j = i;
                i = 3;
                break label389;
              }
            }
            else
            {
              str1 = ((Intent)localObject1).getStringExtra("friend_uin");
              localObject2 = ((Intent)localObject1).getStringExtra("friendUin");
              if (((Intent)localObject1).getBooleanExtra("is_send", false)) {
                i = 1;
              }
              localObject1 = "";
              j = i;
              i = 1;
              break label389;
            }
          }
          else
          {
            str1 = ((Intent)localObject1).getStringExtra("groupUin");
            localObject2 = ((Intent)localObject1).getStringExtra("friendUin");
            if (((Intent)localObject1).getBooleanExtra("is_send", false)) {
              i = 1;
            } else {
              i = 2;
            }
            localObject1 = "mqq.group";
            j = i;
            i = 2;
            break label389;
          }
        }
        else
        {
          str1 = ((Intent)localObject1).getStringExtra("friend_uin");
          localObject2 = ((Intent)localObject1).getStringExtra("friendUin");
          if (((Intent)localObject1).getBooleanExtra("is_send", false)) {
            i = 1;
          }
          localObject1 = "mqq.c2c";
          j = i;
          i = 0;
          break label389;
        }
      }
      localObject1 = "";
      label377:
      localObject2 = "";
      String str1 = "";
      i = -1;
      int j = 0;
      label389:
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reportSoftKeyboardToggled-- referer:");
        localStringBuilder.append(str2);
        localStringBuilder.append(" ,url:");
        localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
        localStringBuilder.append(" ,msgType:");
        localStringBuilder.append(i);
        localStringBuilder.append(",msgFrom:");
        localStringBuilder.append(j);
        localStringBuilder.append(",senderUin:");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(",chatId:");
        localStringBuilder.append(str1);
        localStringBuilder.append(",urlSource:");
        localStringBuilder.append((String)localObject1);
        QLog.d("WebSecurityPluginV2", 1, localStringBuilder.toString());
      }
      LpReportInfo_dc04171.report(this.jdField_b_of_type_JavaLangString, str2, (String)localObject1, i, j, (String)localObject2, str1);
      return;
    }
    QLog.e("WebSecurityPluginV2", 1, "reportSoftKeyboardToggled mRuntime empty");
  }
  
  private boolean d(String paramString)
  {
    return AuthorizeConfig.a().d(paramString);
  }
  
  private boolean e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebSecurityPluginV2", 2, new Object[] { "isInWhiteList:url=", paramString });
    }
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = Uri.parse(paramString);
    if (TextUtils.isEmpty(paramString.getHost())) {
      return false;
    }
    paramString = paramString.getHost().toLowerCase();
    String[] arrayOfString = WebViewConstant.b;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (AuthorizeConfig.b(arrayOfString[i], paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
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
      Object localObject3 = this.mRuntime.a().getIntent();
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
      if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
        try
        {
          localObject3 = SwiftBrowserStatistics.a((String)localObject1);
          ((Bundle)localObject3).putString("uin", this.mRuntime.a().getCurrentAccountUin());
          if (localObject2 != null)
          {
            localObject2 = ((CustomWebView)localObject2).getTitle();
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              ((Bundle)localObject3).putString("title", (String)localObject2);
            }
          }
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(1, str, (String)localObject1, (Bundle)localObject3);
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
    Object localObject1 = a();
    if (localObject1 != null)
    {
      if (localObject1.length == 0) {
        return false;
      }
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
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
        i += 1;
      }
    }
    return false;
  }
  
  public boolean b(String paramString)
  {
    String str = AuthorizeConfig.a().a("call_app", "['https?://intent\\.music\\.163\\.com.+orpheus.*','^https?://([^/]+\\.)?thefatherofsalmon\\.com[/:].+','^https?://127\\.0\\.0\\.1[/:].+','^https?://0:0:0:0:0:0:0:1[/:].+','^https?://::1[/:].+']");
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    try
    {
      Object localObject = new JSONArray(str);
      int i = 0;
      while (i < ((JSONArray)localObject).length())
      {
        str = ((JSONArray)localObject).optString(i);
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
        i += 1;
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
      return a(paramString);
    }
    return super.handleEvent(paramString, paramLong);
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934594L) {
      a();
    } else if (paramLong == 8589934626L) {
      a(paramString);
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
            this.jdField_a_of_type_JavaLangString = paramJsBridgeListener;
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
      if ((this.mRuntime == null) || (this.mRuntime.a() == null)) {
        break label1158;
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
      int i;
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
          i = 0;
          if (i < localObject1.length)
          {
            if (!paramString1.startsWith(localObject1[i])) {
              break label1171;
            }
            if (!QLog.isColorLevel()) {
              break label1169;
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
      this.jdField_b_of_type_JavaLangString = paramString1;
      if (paramString1.equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaLangString = null;
        if (QLog.isColorLevel()) {
          QLog.i("WebSecurityPluginV2", 2, "should pass check");
        }
        return false;
      }
      boolean bool2;
      if (this.jdField_b_of_type_Boolean)
      {
        bool2 = c(paramString1);
        this.jdField_a_of_type_Boolean = (d(paramString1) ^ true);
        this.jdField_b_of_type_Boolean = false;
        paramString2 = (SwiftBrowserStatistics)getBrowserComponent(-2);
        if (paramString2 != null) {
          paramString2.y = (bool2 ^ true);
        }
        bool1 = true;
      }
      else
      {
        bool1 = d(paramString1) ^ true;
        this.jdField_a_of_type_Boolean = bool1;
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
        if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
        {
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = TroopMemberApiClient.a();
          this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a();
        }
        localObject2 = this.mRuntime.a().getIntent();
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
            break label990;
            if (!((Intent)localObject2).getBooleanExtra("key_isFromQZone", false)) {
              break;
            }
          }
          j = ((Intent)localObject2).getIntExtra("uinType", -1);
          i = j;
          if (j == -1) {
            i = ((Intent)localObject2).getIntExtra("curtype", -1);
          }
          if (i != 0)
          {
            if (i != 1)
            {
              if ((i != 1000) && (i != 1001) && (i != 1004) && (i != 1005))
              {
                if (i != 3000)
                {
                  localObject2 = "";
                  localObject3 = paramString2;
                }
                else
                {
                  localObject1 = ((Intent)localObject2).getStringExtra("dicussgroup_uin");
                  str = ((Intent)localObject2).getStringExtra("friendUin");
                  if (((Intent)localObject2).getBooleanExtra("is_send", false)) {
                    i = 1;
                  } else {
                    i = 2;
                  }
                  localObject2 = "mqq.discussion";
                  localObject3 = paramString2;
                  paramString2 = str;
                  j = 3;
                  break label1002;
                }
              }
              else
              {
                localObject1 = ((Intent)localObject2).getStringExtra("friend_uin");
                str = ((Intent)localObject2).getStringExtra("friendUin");
                if (((Intent)localObject2).getBooleanExtra("is_send", false)) {
                  i = 1;
                } else {
                  i = 2;
                }
                localObject2 = "";
                localObject3 = paramString2;
                paramString2 = str;
                j = 1;
                break label1002;
              }
            }
            else
            {
              localObject1 = ((Intent)localObject2).getStringExtra("groupUin");
              str = ((Intent)localObject2).getStringExtra("friendUin");
              if (((Intent)localObject2).getBooleanExtra("is_send", false)) {
                i = 1;
              } else {
                i = 2;
              }
              localObject3 = paramString2;
              localObject2 = "mqq.group";
              paramString2 = str;
              j = 2;
              break label1002;
            }
          }
          else
          {
            localObject1 = ((Intent)localObject2).getStringExtra("friend_uin");
            str = ((Intent)localObject2).getStringExtra("friendUin");
            if (((Intent)localObject2).getBooleanExtra("is_send", false)) {
              i = 1;
            } else {
              i = 2;
            }
            localObject3 = paramString2;
            localObject2 = "mqq.c2c";
            paramString2 = str;
            j = 0;
            break label1002;
          }
        }
        else
        {
          localObject2 = "";
          localObject3 = localObject2;
        }
        label990:
        localObject1 = "";
        paramString2 = "";
        i = 0;
        int j = -1;
        label1002:
        String str = this.mRuntime.a().getIntent().getStringExtra("h5_ark_app_name");
        a(paramString1, (String)localObject3);
        if (QLog.isColorLevel()) {
          QLog.d("WebSecurityPluginV2", 2, new Object[] { " arkBusinessName =", str });
        }
        this.jdField_a_of_type_ComTencentMobileqqWebviewWebSecurityPluginV2$URLCheckParams = WebSecurityPluginV2.URLCheckParams.a(paramString1, j, i, paramString2, (String)localObject1, (String)localObject2, (String)localObject3, str, false, this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqWebviewWebSecurityPluginV2$URLCheckParams, new WebSecurityPluginV2.1(this, paramString1, bool2));
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
      label1158:
      QLog.e("WebSecurityPluginV2", 1, "handleSchemaRequest mRuntime empty");
      return false;
      label1169:
      return false;
      label1171:
      i += 1;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
    if (localObject != null)
    {
      ((TroopMemberApiClient)localObject).a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    localObject = this.jdField_a_of_type_ComTencentBizSoftKeyboardObserver;
    if (localObject != null) {
      ((SoftKeyboardObserver)localObject).a();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebSecurityPluginV2
 * JD-Core Version:    0.7.0.1
 */