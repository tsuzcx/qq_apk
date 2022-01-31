package com.tencent.mobileqq.webview;

import ajyb;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.ProtoServlet;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.SosoPlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.SosoSrvAddrProvider;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.pb.webview.UrlQuery.UrlQueryReq;
import com.tencent.pb.webview.UrlQuery.UrlQueryRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class WebSecurityPlugin
  extends WebViewPlugin
{
  private static int jdField_a_of_type_Int = 20;
  private static long jdField_a_of_type_Long;
  public static String[] a;
  private static boolean b;
  public Handler a;
  WebView jdField_a_of_type_ComTencentSmttSdkWebView;
  String jdField_a_of_type_JavaLangString;
  private Set jdField_a_of_type_JavaUtilSet = new HashSet();
  private final BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new ajyb(this);
  boolean jdField_a_of_type_Boolean = true;
  private boolean c;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = SosoPlugin.jdField_a_of_type_ArrayOfJavaLangString;
  }
  
  public WebSecurityPlugin()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.mPluginNameSpace = "UrlSaveVerify";
  }
  
  private String a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return "";
    }
    if (paramIntent.getBooleanExtra("fromQrcode", false)) {
      return "mqq.qrcode";
    }
    if (paramIntent.getBooleanExtra("key_isFromQZone", false)) {
      return "mqq.qzone";
    }
    switch (paramIntent.getIntExtra("curtype", -1))
    {
    default: 
      return "";
    case 0: 
      return "mqq.c2c";
    case 1: 
      return "mqq.group";
    }
    return "mqq.discussion";
  }
  
  private String a(String paramString)
  {
    String str = paramString;
    if (this.jdField_a_of_type_Boolean) {
      str = a(this.mRuntime.a().getIntent(), paramString, SosoSrvAddrProvider.a());
    }
    return str;
  }
  
  private void a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.mRuntime == null))
    {
      QLog.e("WebSecurityPlugin", 1, "sendSSOReq url or runtime is empty");
      return;
    }
    Object localObject2 = new UrlQuery.UrlQueryReq();
    int i = paramString.length();
    if (i > 10240) {
      QLog.e("WebSecurityPlugin", 1, "This is illegal url, because the length " + i + " has been beyond the max length " + 10240);
    }
    for (Object localObject1 = paramString.substring(0, 10240);; localObject1 = paramString)
    {
      ((UrlQuery.UrlQueryReq)localObject2).bytes_url.set(ByteStringMicro.copyFrom(((String)localObject1).getBytes()));
      localObject1 = a(this.mRuntime.a().getIntent());
      if (localObject1 != null) {
        ((UrlQuery.UrlQueryReq)localObject2).bytes_qq_pf_to.set(ByteStringMicro.copyFrom(((String)localObject1).getBytes()));
      }
      localObject1 = new NewIntent(this.mRuntime.a(), ProtoServlet.class);
      ((NewIntent)localObject1).setWithouLogin(true);
      ((NewIntent)localObject1).putExtra("cmd", "UrlSecSvc.Webview");
      ((NewIntent)localObject1).putExtra("data", ((UrlQuery.UrlQueryReq)localObject2).toByteArray());
      ((NewIntent)localObject1).setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
      localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      if (localObject2 != null)
      {
        ((AppRuntime)localObject2).startServlet((NewIntent)localObject1);
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
        return;
      }
      QLog.e("WebSecurityPlugin", 1, "sendSSOReq app = null");
      return;
    }
  }
  
  public static boolean a()
  {
    boolean bool = false;
    long l = System.currentTimeMillis();
    Object localObject;
    if (l - jdField_a_of_type_Long > 1800000L)
    {
      jdField_a_of_type_Long = l;
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("sp_cgi_whitelist", 4).getString("max_verify_times", null);
      if (QLog.isColorLevel()) {
        QLog.i("WebSecurityPlugin", 1, "update max_verify_times : " + (String)localObject);
      }
      if (localObject == null) {}
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      if (((JSONObject)localObject).optInt("is_switch", 0) == 1) {
        bool = true;
      }
      b = bool;
      jdField_a_of_type_Int = ((JSONObject)localObject).optInt("limit_count", 20);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("WebSecurityPlugin", 1, "parse max verify config failed!", localJSONException);
      }
    }
    return b;
  }
  
  @TargetApi(11)
  public static boolean a(Context paramContext)
  {
    boolean bool = true;
    if (paramContext == null) {
      return false;
    }
    int i = paramContext.getSharedPreferences("webViewUrlCheckSp", 4).getInt("webViewUrlCheckSwitchKey", 0);
    QLog.d("WebSecurityPlugin", 1, "hasUrlSsoCheckSwitchOn isSSOCheckValidate = " + i);
    if (i == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  String a(Intent paramIntent, String paramString, SosoSrvAddrProvider paramSosoSrvAddrProvider)
  {
    if ((paramString.contains(URLEncoder.encode("/cgi-bin/httpconn?htcmd=0x6ff0080"))) || (paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
      return paramString;
    }
    try
    {
      String str = jdField_a_of_type_ArrayOfJavaLangString[new java.util.Random().nextInt(2)];
      paramSosoSrvAddrProvider = new StringBuilder();
      paramSosoSrvAddrProvider.append(str);
      paramSosoSrvAddrProvider.append("&u=");
      paramSosoSrvAddrProvider.append(URLEncoder.encode(paramString, "UTF-8"));
      paramSosoSrvAddrProvider.append("&wap=3");
      paramSosoSrvAddrProvider.append("&qq-pf-to=").append(a(paramIntent));
      str = paramIntent.getStringExtra("uin");
      if (!TextUtils.isEmpty(str)) {
        paramSosoSrvAddrProvider.append("&uin=").append(str);
      }
      for (;;)
      {
        paramIntent = paramIntent.getStringExtra("friendUin");
        if (!TextUtils.isEmpty(paramIntent)) {
          paramSosoSrvAddrProvider.append("&originuin=").append(paramIntent);
        }
        return paramSosoSrvAddrProvider.toString();
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
          paramSosoSrvAddrProvider.append("&uin=").append(this.jdField_a_of_type_JavaLangString);
        }
      }
      return paramString;
    }
    catch (UnsupportedEncodingException paramIntent)
    {
      paramIntent.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        QLog.e("WebSecurityPlugin", 1, "urlCheckObserver data == null");
      }
    }
    else
    {
      return;
    }
    Object localObject = new UrlQuery.UrlQueryRsp();
    for (;;)
    {
      try
      {
        ((UrlQuery.UrlQueryRsp)localObject).mergeFrom(paramBundle);
        if ((((UrlQuery.UrlQueryRsp)localObject).uint32_result.get() != 0) || (((UrlQuery.UrlQueryRsp)localObject).uint32_jump_result.get() < 1)) {
          break;
        }
        localObject = ((UrlQuery.UrlQueryRsp)localObject).bytes_jump_url.get().toStringUtf8();
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        if (this.mRuntime != null)
        {
          paramBundle = this.mRuntime.a();
          if (paramBundle == null) {
            break;
          }
          this.c = true;
          paramBundle.stopLoading();
          paramBundle.clearHistory();
          paramBundle.loadUrl((String)localObject);
          QLog.d("WebSecurityPlugin", 1, "onReceive jumpUrl = " + (String)localObject);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        QLog.e("WebSecurityPlugin", 1, "onReceive exception e = ", paramBundle);
        return;
      }
      paramBundle = null;
    }
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if (paramLong == 8589934594L)
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.c) {
        this.jdField_a_of_type_ComTencentSmttSdkWebView.clearHistory();
      }
    }
    do
    {
      for (;;)
      {
        return false;
        if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http")))
        {
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "web_safe", "url_safe_check", 0, 0, "", "", "", "");
          continue;
          if (paramLong == 8589934595L)
          {
            this.jdField_a_of_type_Boolean = true;
          }
          else
          {
            if (paramLong != 8589934593L) {
              break;
            }
            this.jdField_a_of_type_Boolean = false;
          }
        }
      }
    } while (paramLong != 8589934613L);
    if (this.mRuntime == null)
    {
      paramMap = null;
      label127:
      if (paramMap != null) {
        break label214;
      }
    }
    label214:
    for (paramMap = null;; paramMap = paramMap.getIntent())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramMap = a(paramMap);
      localStringBuilder.append(paramString).append("|");
      localStringBuilder.append(paramString).append("|");
      localStringBuilder.append(paramMap);
      DcReportUtil.a(null, "dc01985", localStringBuilder.toString(), true);
      break;
      paramMap = this.mRuntime.a();
      break label127;
    }
  }
  
  protected boolean handleSchemaRequest(String paramString1, String paramString2)
  {
    if (("http".equals(paramString2)) || ("https".equals(paramString2)))
    {
      if ((this.mRuntime != null) && (this.mRuntime.a() != null)) {
        break label48;
      }
      QLog.e("WebSecurityPlugin", 1, "handleSchemaRequest mRuntime empty");
    }
    label48:
    do
    {
      for (;;)
      {
        return false;
        paramString2 = BaseApplicationImpl.getApplication().getRuntime();
        if ((paramString2 != null) && (!paramString2.isLogin()))
        {
          QLog.e("WebSecurityPlugin", 1, "appRuntime.isLogin() is false!");
          return false;
        }
        if (this.jdField_a_of_type_JavaUtilSet.contains(paramString1))
        {
          QLog.d("WebSecurityPlugin", 1, "handleSchemaRequest url has checked, url = " + Util.c(paramString1, new String[0]));
          return false;
        }
        if ((a()) && (this.jdField_a_of_type_JavaUtilSet.size() >= jdField_a_of_type_Int))
        {
          QLog.d("WebSecurityPlugin", 1, "handleSchemaRequest url check times enough, url = " + Util.c(paramString1, new String[0]));
          return false;
        }
        if (AuthorizeConfig.a().b(paramString1))
        {
          if (QLog.isColorLevel())
          {
            QLog.d("WebSecurityPlugin", 2, "Url is on cig skip white list,the url:" + Util.b(paramString1, new String[0]));
            return false;
          }
        }
        else
        {
          if (a(this.mRuntime.a()))
          {
            if (this.c)
            {
              QLog.d("WebSecurityPlugin", 1, "handleSchemaRequest hasSSOChecked , url = " + Util.c(paramString1, new String[0]));
              return false;
            }
            a(paramString1);
            return false;
          }
          try
          {
            paramString2 = Uri.parse(paramString1);
            if ((paramString2 != null) && (paramString2.isHierarchical()))
            {
              paramString2 = paramString2.getHost();
              if ((!TextUtils.isEmpty(paramString2)) && (paramString2.endsWith(".qq.com")) && ((paramString1.contains(URLEncoder.encode("/cgi-bin/httpconn?htcmd=0x6ff0080"))) || (paramString1.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))))
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.i("WebSecurityPlugin", 2, "SosoPlugin: url contains /cgi-bin/httpconn?htcmd=0x6ff0080, url: " + Util.c(paramString1, new String[0]));
                return false;
              }
            }
          }
          catch (Exception paramString2)
          {
            QLog.e("WebSecurityPlugin", 1, "", paramString2);
            if (QLog.isColorLevel()) {
              QLog.d("WebSecurityPlugin", 2, "check url safety with old solution (<5.3)");
            }
            paramString2 = a(paramString1);
          }
        }
      }
    } while (paramString1.equalsIgnoreCase(paramString2));
    this.jdField_a_of_type_ComTencentSmttSdkWebView.loadUrl(paramString2);
    return true;
  }
  
  public void onAppRuntimeReady(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = paramAppInterface.getCurrentAccountUin();
  }
  
  protected void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramCustomWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.webview.WebSecurityPlugin
 * JD-Core Version:    0.7.0.1
 */