package com.tencent.mobileqq.jsp;

import aeeh;
import aeel;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;
import com.tencent.mobileqq.vas.VasUserData;
import com.tencent.mobileqq.webview.swift.WebUiBaseInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.CrashStepStatsEntry;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.QQBrowserBaseActivityInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebStatisticsInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebviewReportSpeedInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class DataApiPlugin
  extends WebViewPlugin
{
  AuthorizeConfig jdField_a_of_type_ComTencentBizAuthorizeConfig;
  TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient;
  public Client.onRemoteRespObserver a;
  private WebUiUtils.QQBrowserBaseActivityInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface;
  private WebUiUtils.WebStatisticsInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebStatisticsInterface;
  private WebUiUtils.WebUiMethodInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface;
  private WebUiUtils.WebviewReportSpeedInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebviewReportSpeedInterface;
  CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager;
  
  public DataApiPlugin()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver = new aeeh(this);
    this.mPluginNameSpace = "data";
  }
  
  private void a(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    long l = 0L;
    String str = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebStatisticsInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebviewReportSpeedInterface != null))
    {
      i = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebStatisticsInterface.a();
      l = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebviewReportSpeedInterface.getmClickTime();
    }
    try
    {
      paramArrayOfString = new JSONObject(paramArrayOfString[0]);
      int j = paramArrayOfString.getJSONObject("data").getInt("status");
      paramString = "onFirstLine";
      if ((j != 12) && (j != 13))
      {
        label87:
        if ((i < j) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQBrowser_report", 2, "try report web status, " + paramString + ", step: " + j + ", stepTime: " + (System.currentTimeMillis() - l) + ", totalTime: " + (System.currentTimeMillis() - l) + ", \n " + this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface.b());
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebStatisticsInterface == null) {
            break label288;
          }
          this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebStatisticsInterface.a(j);
          this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebStatisticsInterface.a(System.currentTimeMillis());
        }
        label216:
        while (str == null)
        {
          paramString = paramArrayOfString.optString("callback");
          if (!TextUtils.isEmpty(paramString)) {
            callJs(paramString, new String[] { "{\"result\": 0}" });
          }
          return;
          paramString = (SwiftBrowserStatistics)super.getBrowserComponent(-2);
          str = paramString;
          if (paramString == null) {
            break;
          }
          i = paramString.a.jdField_a_of_type_Int;
          l = paramString.b;
          str = paramString;
          break;
          paramString = "onPageFinished";
          break label87;
        }
        label282:
        label288:
        str.a.jdField_a_of_type_Int = j;
        str.a.jdField_a_of_type_Long = System.currentTimeMillis();
        switch (j)
        {
        }
      }
      for (;;)
      {
        str.H = (str.a.jdField_a_of_type_Long - l);
        break label216;
        str.I = (str.a.jdField_a_of_type_Long - l);
        break label216;
        str.J = (str.a.jdField_a_of_type_Long - l);
        break label216;
        if (j != 12) {
          break label282;
        }
        paramString = "onPageVisible";
        break;
      }
      return;
    }
    catch (JSONException paramString) {}
  }
  
  private void b(String paramString)
  {
    Object localObject = this.mRuntime.a();
    if ((TextUtils.isEmpty(paramString)) || (!((AppInterface)localObject).isLogin())) {}
    String str1;
    do
    {
      do
      {
        return;
        str1 = ((AppInterface)localObject).getAccount();
        localObject = CookieManager.getInstance().getCookie(paramString);
      } while ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).contains("uin=")));
      String str2 = SwiftBrowserCookieMonster.a(str1);
      str1 = Util.b(paramString);
      QLog.e("DataApiPlugin", 1, "can not find uin from " + Util.b(paramString, new String[0]) + ", dump cookie: " + Util.c((String)localObject, new String[0]));
      if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager == null)
      {
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
      }
      localObject = String.format("%s=%s; PATH=/; DOMAIN=.%s; Max-Age=21600;", new Object[] { "uin", str2, str1 });
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramString, (String)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("DataApiPlugin", 2, "set uin cookie for host " + str1 + ", cookie : " + Util.c((String)localObject, new String[0]));
  }
  
  private void b(String paramString1, String paramString2)
  {
    Object localObject = this.mRuntime.a();
    if ((TextUtils.isEmpty(paramString1)) || (!((AppInterface)localObject).isLogin())) {}
    do
    {
      do
      {
        return;
        str = ((AppInterface)localObject).getAccount();
        localObject = CookieManager.getInstance().getCookie(paramString1);
      } while ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).contains("p_uin=")));
      String str = SwiftBrowserCookieMonster.a(str);
      QLog.e("DataApiPlugin", 1, "can not find p_uin from " + Util.b(paramString1, new String[0]) + ", dump cookie: " + Util.c((String)localObject, new String[0]));
      if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager == null)
      {
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
      }
      localObject = String.format("%s=%s; PATH=/; DOMAIN=.%s; Max-Age=21600;", new Object[] { "p_uin", str, paramString2 });
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramString1, (String)localObject);
    } while (!QLog.isColorLevel());
    QLog.i("DataApiPlugin", 2, "set p_uin cookie for host " + paramString2 + ", cookie: " + Util.c((String)localObject, new String[0]));
  }
  
  public void a(String paramString)
  {
    String str1;
    int i;
    String str2;
    JSONObject localJSONObject;
    String str3;
    SharedPreferences localSharedPreferences;
    SharedPreferences.Editor localEditor;
    String str4;
    Object localObject1;
    int k;
    int j;
    String str5;
    try
    {
      str1 = VasUserData.a(this.mRuntime.a(), "ticketInterval");
      if (TextUtils.isEmpty(str1)) {
        break label971;
      }
      i = Integer.parseInt(str1);
      localObject2 = new JSONObject(paramString);
      str2 = ((JSONObject)localObject2).optString("callback");
      localJSONObject = new JSONObject();
      if (!this.mRuntime.a().isLogin())
      {
        localJSONObject.put("result", -2);
        localJSONObject.put("message", "用户未登录");
        callJs(str2, new String[] { localJSONObject.toString() });
        return;
      }
      str3 = this.mRuntime.a().getCurrentAccountUin();
      localSharedPreferences = this.mRuntime.a().getApplication().getSharedPreferences(str3 + "_get_ticket_interval", 0);
      localEditor = localSharedPreferences.edit();
      if (this.jdField_a_of_type_ComTencentSmttSdkCookieManager == null)
      {
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager = CookieManager.getInstance();
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setAcceptCookie(true);
      }
      if (this.jdField_a_of_type_ComTencentBizAuthorizeConfig == null) {
        this.jdField_a_of_type_ComTencentBizAuthorizeConfig = AuthorizeConfig.a();
      }
      str4 = this.mRuntime.a().getUrl();
      str1 = null;
      localObject1 = null;
      paramString = null;
      k = 0;
      j = 0;
      str5 = ((JSONObject)localObject2).optString("key");
      if (!TextUtils.isEmpty(str5)) {
        break label328;
      }
      localJSONObject.put("result", -2);
      localJSONObject.put("message", "参数key为空");
      callJs(str2, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString)
    {
      if (!QLog.isColorLevel()) {
        break label978;
      }
    }
    QLog.e("DataApiPlugin", 2, "updateLoginInfo error: " + paramString.getMessage());
    return;
    label328:
    Object localObject2 = new WUserSigInfo();
    long l;
    if ("skey".equals(str5))
    {
      l = localSharedPreferences.getLong("skey", 0L);
      if (System.currentTimeMillis() - l > i * 1000)
      {
        localEditor.putLong("skey", System.currentTimeMillis());
        localEditor.commit();
        i = j;
        if (!this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(str4)) {
          break label979;
        }
        i = 4096;
        break label979;
      }
    }
    label971:
    label978:
    label979:
    label982:
    for (;;)
    {
      if (i == 0)
      {
        localJSONObject.put("result", -2);
        localJSONObject.put("message", "权限不足");
        callJs(str2, new String[] { localJSONObject.toString() });
        return;
        localJSONObject.put("result", 1);
        localJSONObject.put("message", "频率过快");
        callJs(str2, new String[] { localJSONObject.toString() });
        return;
        if ("pskey".equals(str5))
        {
          str1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.d(str4);
          l = localSharedPreferences.getLong("pskey_" + str1, 0L);
          if (System.currentTimeMillis() - l > i * 1000)
          {
            localEditor.putLong("pskey_" + str1, System.currentTimeMillis());
            localEditor.commit();
            i = k;
            if (TextUtils.isEmpty(str1)) {
              break label982;
            }
            ((WUserSigInfo)localObject2)._domains.add(str1);
            i = 1048576;
            break label982;
          }
          localJSONObject.put("result", 1);
          localJSONObject.put("message", "频率过快");
          callJs(str2, new String[] { localJSONObject.toString() });
          return;
        }
        paramString = (String)localObject1;
        if ("pt4_token".equals(str5))
        {
          localObject1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.e(str4);
          l = localSharedPreferences.getLong("pt4_token_" + (String)localObject1, 0L);
          if (System.currentTimeMillis() - l > i * 1000)
          {
            localEditor.putLong("pt4_token_" + (String)localObject1, System.currentTimeMillis());
            localEditor.commit();
            paramString = (String)localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              ((WUserSigInfo)localObject2)._domains.add(String.format(Locale.getDefault(), "(%d)%s", new Object[] { Integer.valueOf(134217728), localObject1 }));
              i = 135266304;
              paramString = (String)localObject1;
            }
          }
          else
          {
            localJSONObject.put("result", 1);
            localJSONObject.put("message", "频率过快");
            callJs(str2, new String[] { localJSONObject.toString() });
          }
        }
      }
      else
      {
        localObject1 = new WtloginHelper(this.mRuntime.a().getApplication());
        ((WtloginHelper)localObject1).setCallSource(30);
        ((WtloginHelper)localObject1).SetListener(new aeel(this, str4, str2, str1, paramString));
        ((WtloginHelper)localObject1).GetStWithoutPasswd(str3, 16L, 16L, 1L, i, (WUserSigInfo)localObject2);
        return;
      }
      i = 0;
      continue;
      i = 28800;
      break;
      return;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("result", -2);
      localJSONObject.put("message", paramString2);
      callJs(paramString1, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("DataApiPlugin", 2, "updateLoginInfo error: " + paramString1.getMessage());
    }
  }
  
  public void a(String paramString1, WUserSigInfo paramWUserSigInfo, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (paramWUserSigInfo == null)
    {
      a(paramString2, "get WUserSigInfo = null");
      return;
    }
    int i = 0;
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    String str = Util.a(paramString1, 1);
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if ((paramInt & 0x1000) != 0)
    {
      localObject2 = null;
      localObject3 = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 4096);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject2;
        if (((Ticket)localObject3)._sig != null) {
          localObject1 = new String(((Ticket)localObject3)._sig);
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label404;
      }
      j = -2;
      localStringBuilder.append("skey获取失败;");
      label112:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label444;
      }
      QLog.i("DataApiPlugin", 1, Util.c("skey=" + (String)localObject1, new String[0]));
      label154:
      i = j;
      if (localObject3 != null)
      {
        QLog.i("DataApiPlugin", 1, "last refresh skey time: " + ((Ticket)localObject3)._create_time);
        localStringBuilder.append("skey create time: " + ((Ticket)localObject3)._create_time);
        i = j;
      }
    }
    if (((0x100000 & paramInt) != 0) && ((0x8000000 & paramInt) == 0))
    {
      localObject2 = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 1048576);
      if ((localObject2 == null) || (((Ticket)localObject2)._pskey_map == null))
      {
        i = -2;
        localStringBuilder.append("pskey获取失败;Ticket = null or ticket._pskey_map = null");
        label280:
        if ((0x8000000 & paramInt) == 0) {
          break label812;
        }
        paramWUserSigInfo = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 1048576);
        if (paramWUserSigInfo != null) {
          break label662;
        }
        paramInt = -2;
        localStringBuilder.append("pt4token获取失败;Ticket = null");
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject();
        paramString1.put("result", paramInt);
        if (paramInt < 0) {
          paramString1.put("message", localStringBuilder.toString());
        }
        callJs(paramString2, new String[] { paramString1.toString() });
        return;
      }
      catch (Exception paramString1) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("DataApiPlugin", 2, "updateLoginInfo error: " + paramString1.getMessage());
      return;
      label404:
      localObject2 = String.format("skey=%1$s; PATH=/; DOMAIN=.%2$s;", new Object[] { localObject1, str });
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramString1, (String)localObject2);
      b(paramString1);
      break label112;
      label444:
      QLog.e("DataApiPlugin", 1, "skey is null!");
      break label154;
      localObject3 = (byte[])((Ticket)localObject2)._pskey_map.get(paramString3);
      localObject1 = new String();
      if (localObject3 != null) {
        localObject1 = new String((byte[])localObject3);
      }
      for (;;)
      {
        QLog.i("DataApiPlugin", 1, "last refresh pskey time: " + ((Ticket)localObject2)._create_time);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label603;
        }
        i = -2;
        localStringBuilder.append("pskey获取失败;pskey = null, create time: " + ((Ticket)localObject2)._create_time);
        break;
        QLog.e("DataApiPlugin", 1, "onDoneGetTicket pskey_map not contain domain: " + paramString3);
      }
      label603:
      localObject1 = "p_skey=" + (String)localObject1 + "; PATH=/; DOMAIN=." + paramString3 + ';';
      this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramString1, (String)localObject1);
      b(paramString1, paramString3);
      break label280;
      label662:
      paramString3 = new String((byte[])paramWUserSigInfo._pt4token_map.get(paramString4));
      QLog.i("DataApiPlugin", 1, "last refresh pt4token time: " + paramWUserSigInfo._create_time);
      if (TextUtils.isEmpty(paramString3))
      {
        paramInt = -2;
        localStringBuilder.append("pt4token获取失败;pt4token = null, create time: " + paramWUserSigInfo._create_time);
      }
      for (;;)
      {
        paramWUserSigInfo = "pt4_token=" + paramString3 + "; PATH=/; DOMAIN=." + paramString4 + ';';
        this.jdField_a_of_type_ComTencentSmttSdkCookieManager.setCookie(paramString1, paramWUserSigInfo);
        break;
        paramInt = i;
      }
      label812:
      paramInt = i;
    }
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 26
    //   2: aload_3
    //   3: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +5230 -> 5236
    //   9: ldc_w 510
    //   12: aload 4
    //   14: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifeq +1145 -> 1162
    //   20: aload 5
    //   22: arraylength
    //   23: iconst_1
    //   24: if_icmpne +1138 -> 1162
    //   27: new 51	org/json/JSONObject
    //   30: dup
    //   31: aload 5
    //   33: iconst_0
    //   34: aaload
    //   35: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   38: ldc 125
    //   40: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 11
    //   45: aload_0
    //   46: getfield 176	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   49: invokevirtual 323	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   52: invokevirtual 328	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   55: astore 5
    //   57: aload 5
    //   59: ifnull +5232 -> 5291
    //   62: aload 5
    //   64: ldc_w 512
    //   67: invokevirtual 515	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   70: ifeq +5221 -> 5291
    //   73: aload 5
    //   75: invokestatic 519	com/tencent/biz/common/offline/HtmlOffline:c	(Ljava/lang/String;)Ljava/lang/String;
    //   78: astore 5
    //   80: aload_0
    //   81: getfield 176	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   84: invokevirtual 181	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   87: astore 17
    //   89: aload 5
    //   91: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   94: ifne +11 -> 105
    //   97: aload 17
    //   99: invokevirtual 186	com/tencent/common/app/AppInterface:isLogin	()Z
    //   102: ifne +29 -> 131
    //   105: aload 11
    //   107: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +21 -> 131
    //   113: aload_0
    //   114: aload 11
    //   116: iconst_1
    //   117: anewarray 137	java/lang/String
    //   120: dup
    //   121: iconst_0
    //   122: ldc_w 521
    //   125: aastore
    //   126: invokevirtual 142	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   129: iconst_1
    //   130: ireturn
    //   131: aload_0
    //   132: getfield 315	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   135: ifnonnull +10 -> 145
    //   138: aload_0
    //   139: invokestatic 320	com/tencent/biz/AuthorizeConfig:a	()Lcom/tencent/biz/AuthorizeConfig;
    //   142: putfield 315	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   145: aload_0
    //   146: getfield 315	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   149: aload 5
    //   151: invokevirtual 522	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;)Ljava/lang/String;
    //   154: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   157: ifne +915 -> 1072
    //   160: iconst_1
    //   161: istore 6
    //   163: aload_0
    //   164: getfield 315	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   167: aload 5
    //   169: invokevirtual 362	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;)Z
    //   172: istore 9
    //   174: aload_0
    //   175: getfield 315	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   178: aload 5
    //   180: invokevirtual 525	com/tencent/biz/AuthorizeConfig:f	(Ljava/lang/String;)Ljava/lang/String;
    //   183: astore 13
    //   185: aload_0
    //   186: getfield 315	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   189: aload 5
    //   191: invokevirtual 386	com/tencent/biz/AuthorizeConfig:e	(Ljava/lang/String;)Ljava/lang/String;
    //   194: astore 16
    //   196: aload_0
    //   197: getfield 315	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   200: aload 5
    //   202: invokevirtual 370	com/tencent/biz/AuthorizeConfig:d	(Ljava/lang/String;)Ljava/lang/String;
    //   205: astore 18
    //   207: aload 17
    //   209: iconst_2
    //   210: invokevirtual 529	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   213: checkcast 531	mqq/manager/TicketManager
    //   216: astore 14
    //   218: new 51	org/json/JSONObject
    //   221: dup
    //   222: invokespecial 278	org/json/JSONObject:<init>	()V
    //   225: astore 12
    //   227: aload 17
    //   229: invokevirtual 189	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   232: astore 15
    //   234: aload 12
    //   236: ldc 238
    //   238: aload 15
    //   240: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   243: pop
    //   244: aload 17
    //   246: invokevirtual 299	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   249: new 78	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   256: getstatic 537	mqq/app/Constants$PropertiesKey:nickName	Lmqq/app/Constants$PropertiesKey;
    //   259: invokevirtual 538	mqq/app/Constants$PropertiesKey:toString	()Ljava/lang/String;
    //   262: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload 15
    //   267: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokevirtual 541	mqq/app/MobileQQ:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   276: astore_1
    //   277: aload_1
    //   278: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   281: ifeq +5005 -> 5286
    //   284: invokestatic 547	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   287: invokevirtual 553	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   290: astore_2
    //   291: aload_2
    //   292: new 78	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 555
    //   302: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload 15
    //   307: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 561	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   316: aconst_null
    //   317: ldc_w 563
    //   320: iconst_1
    //   321: anewarray 137	java/lang/String
    //   324: dup
    //   325: iconst_0
    //   326: aload 15
    //   328: aastore
    //   329: aconst_null
    //   330: invokevirtual 569	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   333: astore_2
    //   334: aload_2
    //   335: ifnull +4945 -> 5280
    //   338: aload_2
    //   339: astore_3
    //   340: aload_2
    //   341: invokeinterface 574 1 0
    //   346: ifeq +4934 -> 5280
    //   349: aload_2
    //   350: astore_3
    //   351: aload_2
    //   352: aload_2
    //   353: ldc_w 576
    //   356: invokeinterface 579 2 0
    //   361: invokeinterface 583 2 0
    //   366: astore 4
    //   368: aload_2
    //   369: astore_3
    //   370: aload 4
    //   372: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   375: ifne +4902 -> 5277
    //   378: aload_2
    //   379: astore_3
    //   380: new 137	java/lang/String
    //   383: dup
    //   384: aload 4
    //   386: invokevirtual 587	java/lang/String:getBytes	()[B
    //   389: ldc_w 589
    //   392: invokespecial 592	java/lang/String:<init>	([BLjava/lang/String;)V
    //   395: invokestatic 595	com/tencent/mobileqq/utils/SecurityUtile:b	(Ljava/lang/String;)Ljava/lang/String;
    //   398: astore 4
    //   400: aload 4
    //   402: astore_1
    //   403: aload_1
    //   404: astore 4
    //   406: aload_2
    //   407: astore_3
    //   408: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   411: ifeq +34 -> 445
    //   414: aload_2
    //   415: astore_3
    //   416: ldc 213
    //   418: iconst_2
    //   419: new 78	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   426: ldc_w 597
    //   429: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload_1
    //   433: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 253	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   442: aload_1
    //   443: astore 4
    //   445: aload 4
    //   447: astore_3
    //   448: aload_2
    //   449: ifnull +12 -> 461
    //   452: aload_2
    //   453: invokeinterface 600 1 0
    //   458: aload 4
    //   460: astore_3
    //   461: aload 12
    //   463: ldc_w 602
    //   466: aload_3
    //   467: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   470: pop
    //   471: iload 6
    //   473: ifeq +3 -> 476
    //   476: iload 9
    //   478: ifeq +566 -> 1044
    //   481: aload_0
    //   482: aload 5
    //   484: invokespecial 472	com/tencent/mobileqq/jsp/DataApiPlugin:b	(Ljava/lang/String;)V
    //   487: aload 5
    //   489: invokestatic 211	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;)Ljava/lang/String;
    //   492: astore_1
    //   493: aload_0
    //   494: getfield 228	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   497: ifnonnull +18 -> 515
    //   500: aload_0
    //   501: invokestatic 195	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   504: putfield 228	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   507: aload_0
    //   508: getfield 228	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   511: iconst_1
    //   512: invokevirtual 232	com/tencent/smtt/sdk/CookieManager:setAcceptCookie	(Z)V
    //   515: aload 14
    //   517: aload 15
    //   519: invokeinterface 605 2 0
    //   524: astore_2
    //   525: aload 12
    //   527: ldc_w 342
    //   530: aload_2
    //   531: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   534: pop
    //   535: aload_2
    //   536: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   539: ifne +89 -> 628
    //   542: ldc_w 470
    //   545: iconst_2
    //   546: anewarray 236	java/lang/Object
    //   549: dup
    //   550: iconst_0
    //   551: aload_2
    //   552: aastore
    //   553: dup
    //   554: iconst_1
    //   555: aload_1
    //   556: aastore
    //   557: invokestatic 242	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   560: astore_1
    //   561: aload_0
    //   562: getfield 228	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   565: aload 5
    //   567: aload_1
    //   568: invokevirtual 246	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   571: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   574: ifeq +54 -> 628
    //   577: ldc 213
    //   579: iconst_2
    //   580: new 78	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   587: ldc_w 607
    //   590: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: aload_1
    //   594: iconst_0
    //   595: anewarray 137	java/lang/String
    //   598: invokestatic 223	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   601: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: ldc_w 609
    //   607: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: aload 5
    //   612: iconst_0
    //   613: anewarray 137	java/lang/String
    //   616: invokestatic 218	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   619: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   628: aload 18
    //   630: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   633: ifne +144 -> 777
    //   636: aload_0
    //   637: aload 5
    //   639: aload 18
    //   641: invokespecial 497	com/tencent/mobileqq/jsp/DataApiPlugin:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   644: aload 14
    //   646: aload 15
    //   648: aload 18
    //   650: invokeinterface 613 3 0
    //   655: astore_1
    //   656: aload_1
    //   657: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   660: ifne +117 -> 777
    //   663: aload 12
    //   665: ldc_w 615
    //   668: aload_1
    //   669: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   672: pop
    //   673: new 78	java/lang/StringBuilder
    //   676: dup
    //   677: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   680: ldc_w 490
    //   683: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: aload_1
    //   687: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: ldc_w 492
    //   693: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: aload 18
    //   698: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: bipush 59
    //   703: invokevirtual 495	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   706: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: astore_1
    //   710: aload_0
    //   711: getfield 228	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   714: aload 5
    //   716: aload_1
    //   717: invokevirtual 246	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   720: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   723: ifeq +54 -> 777
    //   726: ldc 213
    //   728: iconst_2
    //   729: new 78	java/lang/StringBuilder
    //   732: dup
    //   733: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   736: ldc_w 607
    //   739: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: aload_1
    //   743: iconst_0
    //   744: anewarray 137	java/lang/String
    //   747: invokestatic 223	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   750: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: ldc_w 609
    //   756: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: aload 5
    //   761: iconst_0
    //   762: anewarray 137	java/lang/String
    //   765: invokestatic 218	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   768: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   774: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   777: aload 16
    //   779: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   782: ifne +132 -> 914
    //   785: aload 17
    //   787: aload 16
    //   789: invokestatic 617	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:b	(Lmqq/app/AppRuntime;Ljava/lang/String;)Ljava/lang/String;
    //   792: astore_1
    //   793: aload_1
    //   794: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   797: ifne +117 -> 914
    //   800: aload 12
    //   802: ldc_w 384
    //   805: aload_1
    //   806: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   809: pop
    //   810: new 78	java/lang/StringBuilder
    //   813: dup
    //   814: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   817: ldc_w 506
    //   820: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: aload_1
    //   824: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: ldc_w 492
    //   830: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: aload 16
    //   835: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: bipush 59
    //   840: invokevirtual 495	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   843: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   846: astore_1
    //   847: aload_0
    //   848: getfield 228	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   851: aload 5
    //   853: aload_1
    //   854: invokevirtual 246	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   857: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   860: ifeq +54 -> 914
    //   863: ldc 213
    //   865: iconst_2
    //   866: new 78	java/lang/StringBuilder
    //   869: dup
    //   870: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   873: ldc_w 607
    //   876: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: aload_1
    //   880: iconst_0
    //   881: anewarray 137	java/lang/String
    //   884: invokestatic 223	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   887: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   890: ldc_w 609
    //   893: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: aload 5
    //   898: iconst_0
    //   899: anewarray 137	java/lang/String
    //   902: invokestatic 218	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   905: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   911: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   914: aload 13
    //   916: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   919: ifne +125 -> 1044
    //   922: aload 14
    //   924: aload 15
    //   926: invokeinterface 620 2 0
    //   931: astore_1
    //   932: aload_1
    //   933: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   936: ifne +108 -> 1044
    //   939: new 78	java/lang/StringBuilder
    //   942: dup
    //   943: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   946: ldc_w 622
    //   949: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: aload_1
    //   953: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: ldc_w 492
    //   959: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: aload 13
    //   964: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: ldc_w 624
    //   970: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   976: astore_1
    //   977: aload_0
    //   978: getfield 228	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   981: aload 5
    //   983: aload_1
    //   984: invokevirtual 246	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   987: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   990: ifeq +54 -> 1044
    //   993: ldc 213
    //   995: iconst_2
    //   996: new 78	java/lang/StringBuilder
    //   999: dup
    //   1000: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1003: ldc_w 607
    //   1006: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1009: aload_1
    //   1010: iconst_0
    //   1011: anewarray 137	java/lang/String
    //   1014: invokestatic 223	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   1017: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: ldc_w 609
    //   1023: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: aload 5
    //   1028: iconst_0
    //   1029: anewarray 137	java/lang/String
    //   1032: invokestatic 218	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   1035: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1038: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1041: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1044: aload 11
    //   1046: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1049: ifne +21 -> 1070
    //   1052: aload_0
    //   1053: aload 11
    //   1055: iconst_1
    //   1056: anewarray 137	java/lang/String
    //   1059: dup
    //   1060: iconst_0
    //   1061: aload 12
    //   1063: invokevirtual 292	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1066: aastore
    //   1067: invokevirtual 142	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1070: iconst_1
    //   1071: ireturn
    //   1072: iconst_0
    //   1073: istore 6
    //   1075: goto -912 -> 163
    //   1078: astore 4
    //   1080: aconst_null
    //   1081: astore_2
    //   1082: aload_2
    //   1083: astore_3
    //   1084: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1087: ifeq +35 -> 1122
    //   1090: aload_2
    //   1091: astore_3
    //   1092: ldc 213
    //   1094: iconst_2
    //   1095: new 78	java/lang/StringBuilder
    //   1098: dup
    //   1099: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1102: ldc_w 626
    //   1105: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1108: aload 4
    //   1110: invokestatic 630	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1113: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1119: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1122: aload_1
    //   1123: astore_3
    //   1124: aload_2
    //   1125: ifnull -664 -> 461
    //   1128: aload_2
    //   1129: invokeinterface 600 1 0
    //   1134: aload_1
    //   1135: astore_3
    //   1136: goto -675 -> 461
    //   1139: astore_1
    //   1140: aload_1
    //   1141: invokevirtual 633	org/json/JSONException:printStackTrace	()V
    //   1144: goto -74 -> 1070
    //   1147: astore_1
    //   1148: aconst_null
    //   1149: astore_3
    //   1150: aload_3
    //   1151: ifnull +9 -> 1160
    //   1154: aload_3
    //   1155: invokeinterface 600 1 0
    //   1160: aload_1
    //   1161: athrow
    //   1162: ldc_w 635
    //   1165: aload 4
    //   1167: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1170: ifeq +25 -> 1195
    //   1173: new 637	aeei
    //   1176: dup
    //   1177: aload_0
    //   1178: aload 5
    //   1180: iconst_0
    //   1181: aaload
    //   1182: invokespecial 640	aeei:<init>	(Lcom/tencent/mobileqq/jsp/DataApiPlugin;Ljava/lang/String;)V
    //   1185: bipush 8
    //   1187: aconst_null
    //   1188: iconst_1
    //   1189: invokestatic 646	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1192: goto -122 -> 1070
    //   1195: ldc_w 648
    //   1198: aload 4
    //   1200: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1203: ifeq +259 -> 1462
    //   1206: aload_0
    //   1207: getfield 176	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1210: invokevirtual 651	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1213: invokevirtual 657	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   1216: astore_1
    //   1217: aload_1
    //   1218: ldc_w 659
    //   1221: iconst_m1
    //   1222: invokevirtual 665	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1225: istore 6
    //   1227: new 51	org/json/JSONObject
    //   1230: dup
    //   1231: invokespecial 278	org/json/JSONObject:<init>	()V
    //   1234: astore_2
    //   1235: aload_0
    //   1236: getfield 176	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1239: invokevirtual 181	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1242: invokevirtual 189	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1245: astore_3
    //   1246: new 51	org/json/JSONObject
    //   1249: dup
    //   1250: aload 5
    //   1252: iconst_0
    //   1253: aaload
    //   1254: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1257: ldc 125
    //   1259: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1262: astore 4
    //   1264: aload_2
    //   1265: ldc 238
    //   1267: aload_3
    //   1268: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1271: pop
    //   1272: iload 6
    //   1274: iconst_m1
    //   1275: if_icmpne +62 -> 1337
    //   1278: aload_2
    //   1279: ldc_w 667
    //   1282: ldc_w 669
    //   1285: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1288: pop
    //   1289: aload 4
    //   1291: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1294: ifne -224 -> 1070
    //   1297: aload_0
    //   1298: aload 4
    //   1300: iconst_1
    //   1301: anewarray 137	java/lang/String
    //   1304: dup
    //   1305: iconst_0
    //   1306: aload_2
    //   1307: invokevirtual 292	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1310: aastore
    //   1311: invokevirtual 142	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1314: goto -244 -> 1070
    //   1317: astore_1
    //   1318: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1321: ifeq -251 -> 1070
    //   1324: ldc 213
    //   1326: iconst_2
    //   1327: ldc_w 671
    //   1330: aload_1
    //   1331: invokestatic 675	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1334: goto -264 -> 1070
    //   1337: iload 6
    //   1339: iconst_1
    //   1340: if_icmpne +47 -> 1387
    //   1343: aload_2
    //   1344: ldc_w 677
    //   1347: aload_1
    //   1348: ldc_w 679
    //   1351: invokevirtual 682	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1354: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1357: pop
    //   1358: aload_2
    //   1359: ldc_w 667
    //   1362: ldc_w 684
    //   1365: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1368: pop
    //   1369: aload_2
    //   1370: ldc_w 686
    //   1373: aload_1
    //   1374: ldc_w 688
    //   1377: invokevirtual 682	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1380: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1383: pop
    //   1384: goto -95 -> 1289
    //   1387: iload 6
    //   1389: sipush 3000
    //   1392: if_icmpne +32 -> 1424
    //   1395: aload_2
    //   1396: ldc_w 690
    //   1399: aload_1
    //   1400: ldc_w 690
    //   1403: invokevirtual 682	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1406: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1409: pop
    //   1410: aload_2
    //   1411: ldc_w 667
    //   1414: ldc_w 692
    //   1417: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1420: pop
    //   1421: goto -52 -> 1369
    //   1424: aload_1
    //   1425: ldc_w 694
    //   1428: invokevirtual 682	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1431: astore_3
    //   1432: aload_3
    //   1433: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1436: ifne +12 -> 1448
    //   1439: aload_2
    //   1440: ldc_w 694
    //   1443: aload_3
    //   1444: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1447: pop
    //   1448: aload_2
    //   1449: ldc_w 667
    //   1452: ldc_w 696
    //   1455: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1458: pop
    //   1459: goto -90 -> 1369
    //   1462: ldc_w 698
    //   1465: aload 4
    //   1467: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1470: ifeq +102 -> 1572
    //   1473: new 51	org/json/JSONObject
    //   1476: dup
    //   1477: aload 5
    //   1479: iconst_0
    //   1480: aaload
    //   1481: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1484: astore_2
    //   1485: aload_2
    //   1486: ldc 125
    //   1488: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1491: astore_1
    //   1492: aload_2
    //   1493: ldc 238
    //   1495: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1498: astore_2
    //   1499: aload_2
    //   1500: aload_0
    //   1501: getfield 176	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1504: invokevirtual 181	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1507: invokevirtual 189	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1510: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1513: ifeq -443 -> 1070
    //   1516: aload_1
    //   1517: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1520: ifne -450 -> 1070
    //   1523: new 700	android/os/Bundle
    //   1526: dup
    //   1527: invokespecial 701	android/os/Bundle:<init>	()V
    //   1530: astore_3
    //   1531: aload_3
    //   1532: ldc 238
    //   1534: aload_2
    //   1535: invokevirtual 704	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1538: ldc_w 706
    //   1541: aload_1
    //   1542: aload_0
    //   1543: getfield 24	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   1546: getfield 710	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   1549: aload_3
    //   1550: invokestatic 715	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   1553: astore_1
    //   1554: invokestatic 720	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   1557: aload_1
    //   1558: invokevirtual 723	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	(Landroid/os/Bundle;)V
    //   1561: goto -491 -> 1070
    //   1564: astore_1
    //   1565: aload_1
    //   1566: invokevirtual 633	org/json/JSONException:printStackTrace	()V
    //   1569: goto -499 -> 1070
    //   1572: ldc_w 725
    //   1575: aload 4
    //   1577: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1580: ifeq +364 -> 1944
    //   1583: aload 5
    //   1585: arraylength
    //   1586: iconst_1
    //   1587: if_icmpne +357 -> 1944
    //   1590: new 51	org/json/JSONObject
    //   1593: dup
    //   1594: aload 5
    //   1596: iconst_0
    //   1597: aaload
    //   1598: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1601: astore 5
    //   1603: aload 5
    //   1605: ldc_w 727
    //   1608: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1611: astore_3
    //   1612: aload 5
    //   1614: ldc 125
    //   1616: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1619: astore 4
    //   1621: aload_3
    //   1622: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1625: ifne +23 -> 1648
    //   1628: aload_3
    //   1629: ldc_w 729
    //   1632: invokevirtual 515	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1635: ifne +46 -> 1681
    //   1638: aload_3
    //   1639: ldc_w 731
    //   1642: invokevirtual 515	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1645: ifne +36 -> 1681
    //   1648: aload 4
    //   1650: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1653: ifne +3641 -> 5294
    //   1656: aload_0
    //   1657: aload 4
    //   1659: iconst_2
    //   1660: anewarray 137	java/lang/String
    //   1663: dup
    //   1664: iconst_0
    //   1665: ldc_w 733
    //   1668: aastore
    //   1669: dup
    //   1670: iconst_1
    //   1671: ldc_w 735
    //   1674: aastore
    //   1675: invokevirtual 142	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1678: goto +3616 -> 5294
    //   1681: aconst_null
    //   1682: astore_1
    //   1683: aload 5
    //   1685: ldc_w 737
    //   1688: invokevirtual 740	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1691: astore 11
    //   1693: aload 11
    //   1695: ifnull +72 -> 1767
    //   1698: new 700	android/os/Bundle
    //   1701: dup
    //   1702: invokespecial 701	android/os/Bundle:<init>	()V
    //   1705: astore_2
    //   1706: aload 11
    //   1708: invokevirtual 744	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   1711: astore 12
    //   1713: aload_2
    //   1714: astore_1
    //   1715: aload 12
    //   1717: invokeinterface 749 1 0
    //   1722: ifeq +45 -> 1767
    //   1725: aload 12
    //   1727: invokeinterface 753 1 0
    //   1732: invokestatic 756	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1735: astore_1
    //   1736: aload 11
    //   1738: aload_1
    //   1739: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1742: astore 13
    //   1744: aload 13
    //   1746: ifnull -33 -> 1713
    //   1749: aload_2
    //   1750: aload_1
    //   1751: aload 13
    //   1753: invokevirtual 704	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1756: goto -43 -> 1713
    //   1759: astore_1
    //   1760: aload_1
    //   1761: invokevirtual 633	org/json/JSONException:printStackTrace	()V
    //   1764: goto -694 -> 1070
    //   1767: aload 5
    //   1769: ldc_w 758
    //   1772: invokevirtual 740	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1775: astore_2
    //   1776: aload_2
    //   1777: ifnull +160 -> 1937
    //   1780: ldc_w 760
    //   1783: aload_2
    //   1784: ldc_w 762
    //   1787: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1790: invokevirtual 765	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1793: ifeq +144 -> 1937
    //   1796: ldc_w 760
    //   1799: astore_2
    //   1800: new 700	android/os/Bundle
    //   1803: dup
    //   1804: invokespecial 701	android/os/Bundle:<init>	()V
    //   1807: astore 5
    //   1809: aload_0
    //   1810: getfield 228	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   1813: ifnonnull +18 -> 1831
    //   1816: aload_0
    //   1817: invokestatic 195	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   1820: putfield 228	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   1823: aload_0
    //   1824: getfield 228	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   1827: iconst_1
    //   1828: invokevirtual 232	com/tencent/smtt/sdk/CookieManager:setAcceptCookie	(Z)V
    //   1831: aload_0
    //   1832: getfield 228	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   1835: aload_3
    //   1836: invokevirtual 198	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   1839: astore 11
    //   1841: aload 11
    //   1843: ifnull +70 -> 1913
    //   1846: aload 5
    //   1848: ldc_w 767
    //   1851: aload 11
    //   1853: invokevirtual 704	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1856: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1859: ifeq +54 -> 1913
    //   1862: ldc 213
    //   1864: iconst_2
    //   1865: new 78	java/lang/StringBuilder
    //   1868: dup
    //   1869: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   1872: ldc_w 769
    //   1875: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1878: aload 11
    //   1880: iconst_0
    //   1881: anewarray 137	java/lang/String
    //   1884: invokestatic 223	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   1887: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1890: ldc_w 771
    //   1893: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1896: aload_3
    //   1897: iconst_0
    //   1898: anewarray 137	java/lang/String
    //   1901: invokestatic 218	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   1904: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1907: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1910: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1913: new 773	aeej
    //   1916: dup
    //   1917: aload_0
    //   1918: aload_3
    //   1919: aload_2
    //   1920: aload_1
    //   1921: aload 5
    //   1923: aload 4
    //   1925: invokespecial 776	aeej:<init>	(Lcom/tencent/mobileqq/jsp/DataApiPlugin;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;Ljava/lang/String;)V
    //   1928: iconst_5
    //   1929: aconst_null
    //   1930: iconst_1
    //   1931: invokestatic 646	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1934: goto -864 -> 1070
    //   1937: ldc_w 778
    //   1940: astore_2
    //   1941: goto -141 -> 1800
    //   1944: ldc_w 780
    //   1947: aload 4
    //   1949: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1952: ifeq +137 -> 2089
    //   1955: aload 5
    //   1957: arraylength
    //   1958: iconst_1
    //   1959: if_icmpne +130 -> 2089
    //   1962: new 51	org/json/JSONObject
    //   1965: dup
    //   1966: aload 5
    //   1968: iconst_0
    //   1969: aaload
    //   1970: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1973: astore_1
    //   1974: aload_1
    //   1975: ldc 125
    //   1977: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1980: astore_2
    //   1981: aload_2
    //   1982: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1985: ifne -915 -> 1070
    //   1988: ldc_w 782
    //   1991: aload_1
    //   1992: ldc_w 330
    //   1995: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1998: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2001: ifeq +23 -> 2024
    //   2004: aload_0
    //   2005: aload_2
    //   2006: iconst_1
    //   2007: anewarray 137	java/lang/String
    //   2010: dup
    //   2011: iconst_0
    //   2012: getstatic 786	com/tencent/mobileqq/activity/QQBrowserActivity:c	I
    //   2015: invokestatic 788	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   2018: aastore
    //   2019: invokevirtual 142	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2022: iconst_1
    //   2023: ireturn
    //   2024: aconst_null
    //   2025: astore_1
    //   2026: aload_0
    //   2027: getfield 176	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2030: invokevirtual 651	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   2033: astore_3
    //   2034: aload_3
    //   2035: ifnull +14 -> 2049
    //   2038: aload_3
    //   2039: invokevirtual 657	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   2042: ldc_w 790
    //   2045: invokevirtual 682	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   2048: astore_1
    //   2049: aload_1
    //   2050: ifnonnull +31 -> 2081
    //   2053: ldc_w 792
    //   2056: astore_1
    //   2057: aload_0
    //   2058: aload_2
    //   2059: iconst_1
    //   2060: anewarray 137	java/lang/String
    //   2063: dup
    //   2064: iconst_0
    //   2065: aload_1
    //   2066: aastore
    //   2067: invokevirtual 142	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2070: goto -1000 -> 1070
    //   2073: astore_1
    //   2074: aload_1
    //   2075: invokevirtual 633	org/json/JSONException:printStackTrace	()V
    //   2078: goto -1008 -> 1070
    //   2081: aload_1
    //   2082: invokestatic 793	com/tencent/biz/common/util/Util:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2085: astore_1
    //   2086: goto -29 -> 2057
    //   2089: ldc_w 795
    //   2092: aload 4
    //   2094: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2097: ifeq +126 -> 2223
    //   2100: aload 5
    //   2102: arraylength
    //   2103: iconst_1
    //   2104: if_icmpne +119 -> 2223
    //   2107: new 51	org/json/JSONObject
    //   2110: dup
    //   2111: aload 5
    //   2113: iconst_0
    //   2114: aaload
    //   2115: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2118: astore_1
    //   2119: aload_1
    //   2120: ldc_w 797
    //   2123: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2126: astore_2
    //   2127: aload_1
    //   2128: ldc 125
    //   2130: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2133: astore_1
    //   2134: aload_2
    //   2135: ifnonnull +3139 -> 5274
    //   2138: ldc_w 792
    //   2141: astore_2
    //   2142: invokestatic 547	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2145: ldc_w 799
    //   2148: invokevirtual 803	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   2151: checkcast 805	android/text/ClipboardManager
    //   2154: astore_3
    //   2155: aload_3
    //   2156: ifnull +32 -> 2188
    //   2159: aload_3
    //   2160: aload_2
    //   2161: invokevirtual 809	android/text/ClipboardManager:setText	(Ljava/lang/CharSequence;)V
    //   2164: aload_1
    //   2165: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2168: ifne +18 -> 2186
    //   2171: aload_0
    //   2172: aload_1
    //   2173: iconst_1
    //   2174: anewarray 137	java/lang/String
    //   2177: dup
    //   2178: iconst_0
    //   2179: ldc_w 811
    //   2182: aastore
    //   2183: invokevirtual 142	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2186: iconst_1
    //   2187: ireturn
    //   2188: aload_1
    //   2189: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2192: ifne -1122 -> 1070
    //   2195: aload_0
    //   2196: aload_1
    //   2197: iconst_1
    //   2198: anewarray 137	java/lang/String
    //   2201: dup
    //   2202: iconst_0
    //   2203: ldc_w 813
    //   2206: aastore
    //   2207: invokevirtual 142	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2210: goto -1140 -> 1070
    //   2213: astore_2
    //   2214: aconst_null
    //   2215: astore_1
    //   2216: aload_2
    //   2217: invokevirtual 633	org/json/JSONException:printStackTrace	()V
    //   2220: goto -32 -> 2188
    //   2223: ldc_w 815
    //   2226: aload 4
    //   2228: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2231: ifeq +123 -> 2354
    //   2234: aload 5
    //   2236: arraylength
    //   2237: iconst_1
    //   2238: if_icmpne +116 -> 2354
    //   2241: new 51	org/json/JSONObject
    //   2244: dup
    //   2245: aload 5
    //   2247: iconst_0
    //   2248: aaload
    //   2249: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2252: ldc 125
    //   2254: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2257: astore_2
    //   2258: aload_2
    //   2259: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2262: ifne -1192 -> 1070
    //   2265: invokestatic 547	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2268: ldc_w 799
    //   2271: invokevirtual 803	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   2274: checkcast 805	android/text/ClipboardManager
    //   2277: astore_1
    //   2278: aload_1
    //   2279: ifnull +2988 -> 5267
    //   2282: aload_1
    //   2283: invokevirtual 819	android/text/ClipboardManager:getText	()Ljava/lang/CharSequence;
    //   2286: astore_1
    //   2287: aload_1
    //   2288: ifnull +2979 -> 5267
    //   2291: aload_1
    //   2292: invokeinterface 822 1 0
    //   2297: astore_1
    //   2298: aload_0
    //   2299: aload_2
    //   2300: iconst_1
    //   2301: anewarray 137	java/lang/String
    //   2304: dup
    //   2305: iconst_0
    //   2306: aload_1
    //   2307: invokestatic 793	com/tencent/biz/common/util/Util:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2310: aastore
    //   2311: invokevirtual 142	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2314: goto -1244 -> 1070
    //   2317: astore_1
    //   2318: ldc 213
    //   2320: iconst_1
    //   2321: new 78	java/lang/StringBuilder
    //   2324: dup
    //   2325: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   2328: ldc_w 824
    //   2331: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2334: aload_1
    //   2335: invokevirtual 337	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2338: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2341: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2344: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2347: aload_1
    //   2348: invokevirtual 825	java/lang/Exception:printStackTrace	()V
    //   2351: goto -1281 -> 1070
    //   2354: ldc_w 827
    //   2357: aload 4
    //   2359: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2362: ifeq +203 -> 2565
    //   2365: aload 5
    //   2367: arraylength
    //   2368: iconst_1
    //   2369: if_icmpne +196 -> 2565
    //   2372: new 51	org/json/JSONObject
    //   2375: dup
    //   2376: aload 5
    //   2378: iconst_0
    //   2379: aaload
    //   2380: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2383: astore_1
    //   2384: aload_1
    //   2385: ldc_w 829
    //   2388: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2391: astore_2
    //   2392: aload_1
    //   2393: ldc_w 831
    //   2396: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2399: astore_3
    //   2400: aload_1
    //   2401: ldc_w 833
    //   2404: iconst_1
    //   2405: invokevirtual 837	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2408: istore 9
    //   2410: aload_1
    //   2411: ldc 125
    //   2413: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2416: astore 4
    //   2418: new 51	org/json/JSONObject
    //   2421: dup
    //   2422: invokespecial 278	org/json/JSONObject:<init>	()V
    //   2425: astore 5
    //   2427: aload_2
    //   2428: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2431: ifne +109 -> 2540
    //   2434: aload_3
    //   2435: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2438: ifne +102 -> 2540
    //   2441: aload_0
    //   2442: getfield 176	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2445: invokevirtual 181	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   2448: astore_1
    //   2449: aload_1
    //   2450: instanceof 839
    //   2453: ifeq +2809 -> 5262
    //   2456: aload_1
    //   2457: checkcast 839	com/tencent/mobileqq/app/QQAppInterface
    //   2460: astore_1
    //   2461: aload_1
    //   2462: aload_2
    //   2463: aload_3
    //   2464: iload 9
    //   2466: invokestatic 844	com/tencent/mobileqq/statistics/DcReportUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2469: aload 5
    //   2471: ldc_w 280
    //   2474: iconst_0
    //   2475: invokevirtual 284	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2478: pop
    //   2479: aload 5
    //   2481: ldc_w 286
    //   2484: ldc_w 846
    //   2487: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2490: pop
    //   2491: aload 4
    //   2493: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2496: ifne -1426 -> 1070
    //   2499: aload_0
    //   2500: aload 4
    //   2502: iconst_1
    //   2503: anewarray 137	java/lang/String
    //   2506: dup
    //   2507: iconst_0
    //   2508: aload 5
    //   2510: invokevirtual 292	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2513: aastore
    //   2514: invokevirtual 142	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2517: goto -1447 -> 1070
    //   2520: astore_1
    //   2521: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2524: ifeq -1454 -> 1070
    //   2527: ldc 213
    //   2529: iconst_2
    //   2530: aload_1
    //   2531: invokevirtual 337	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2534: invokestatic 848	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2537: goto -1467 -> 1070
    //   2540: aload 5
    //   2542: ldc_w 280
    //   2545: iconst_m1
    //   2546: invokevirtual 284	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2549: pop
    //   2550: aload 5
    //   2552: ldc_w 286
    //   2555: ldc_w 850
    //   2558: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2561: pop
    //   2562: goto -71 -> 2491
    //   2565: ldc_w 852
    //   2568: aload 4
    //   2570: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2573: ifeq +473 -> 3046
    //   2576: aload 5
    //   2578: arraylength
    //   2579: iconst_1
    //   2580: if_icmpne +466 -> 3046
    //   2583: new 51	org/json/JSONObject
    //   2586: dup
    //   2587: aload 5
    //   2589: iconst_0
    //   2590: aaload
    //   2591: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2594: astore_1
    //   2595: aload_1
    //   2596: ldc_w 854
    //   2599: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2602: astore_3
    //   2603: aload_1
    //   2604: ldc_w 856
    //   2607: invokevirtual 58	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2610: astore_1
    //   2611: aload_0
    //   2612: getfield 176	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2615: invokevirtual 181	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   2618: astore_2
    //   2619: ldc_w 858
    //   2622: aload_3
    //   2623: invokevirtual 765	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2626: ifeq +232 -> 2858
    //   2629: aload_1
    //   2630: ldc_w 860
    //   2633: ldc_w 792
    //   2636: invokevirtual 862	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2639: astore_3
    //   2640: aload_1
    //   2641: ldc_w 864
    //   2644: invokevirtual 866	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2647: astore 4
    //   2649: aload_1
    //   2650: ldc_w 868
    //   2653: invokevirtual 866	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2656: astore 5
    //   2658: aload_1
    //   2659: ldc_w 870
    //   2662: invokevirtual 866	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2665: astore 11
    //   2667: aload_1
    //   2668: ldc_w 872
    //   2671: ldc_w 792
    //   2674: invokevirtual 862	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2677: astore 12
    //   2679: aload_1
    //   2680: ldc_w 874
    //   2683: iconst_0
    //   2684: invokevirtual 877	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2687: istore 6
    //   2689: aload_1
    //   2690: ldc_w 879
    //   2693: iconst_1
    //   2694: invokevirtual 877	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2697: istore 7
    //   2699: aload_1
    //   2700: ldc_w 881
    //   2703: iconst_0
    //   2704: invokevirtual 877	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2707: istore 8
    //   2709: aload_1
    //   2710: ldc_w 883
    //   2713: ldc_w 792
    //   2716: invokevirtual 862	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2719: astore 13
    //   2721: aload_1
    //   2722: ldc_w 885
    //   2725: ldc_w 792
    //   2728: invokevirtual 862	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2731: astore 14
    //   2733: aload_1
    //   2734: ldc_w 887
    //   2737: ldc_w 792
    //   2740: invokevirtual 862	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2743: astore 15
    //   2745: aload_1
    //   2746: ldc_w 889
    //   2749: ldc_w 792
    //   2752: invokevirtual 862	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2755: astore 16
    //   2757: aconst_null
    //   2758: astore_1
    //   2759: aload_2
    //   2760: instanceof 839
    //   2763: ifeq +8 -> 2771
    //   2766: aload_2
    //   2767: checkcast 839	com/tencent/mobileqq/app/QQAppInterface
    //   2770: astore_1
    //   2771: aload_2
    //   2772: invokevirtual 186	com/tencent/common/app/AppInterface:isLogin	()Z
    //   2775: ifeq +53 -> 2828
    //   2778: aload_1
    //   2779: aload 4
    //   2781: aload_3
    //   2782: aload 12
    //   2784: aload 5
    //   2786: aload 11
    //   2788: iload 6
    //   2790: iload 7
    //   2792: iload 8
    //   2794: aload 13
    //   2796: aload 14
    //   2798: aload 15
    //   2800: aload 16
    //   2802: invokestatic 894	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2805: goto -1735 -> 1070
    //   2808: astore_1
    //   2809: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2812: ifeq -1742 -> 1070
    //   2815: ldc 213
    //   2817: iconst_2
    //   2818: aload_1
    //   2819: invokevirtual 895	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2822: invokestatic 848	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2825: goto -1755 -> 1070
    //   2828: aload_1
    //   2829: aload 4
    //   2831: aload_3
    //   2832: aload 12
    //   2834: aload 5
    //   2836: aload 11
    //   2838: iload 6
    //   2840: iload 7
    //   2842: iload 8
    //   2844: aload 13
    //   2846: aload 14
    //   2848: aload 15
    //   2850: aload 16
    //   2852: invokestatic 897	com/tencent/mobileqq/statistics/ReportController:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2855: goto -1785 -> 1070
    //   2858: ldc_w 899
    //   2861: aload_3
    //   2862: invokevirtual 765	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2865: ifeq +163 -> 3028
    //   2868: aload_1
    //   2869: ldc_w 901
    //   2872: invokevirtual 866	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2875: astore_3
    //   2876: aload_1
    //   2877: ldc_w 903
    //   2880: iconst_1
    //   2881: invokevirtual 837	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2884: istore 9
    //   2886: aload_1
    //   2887: ldc_w 905
    //   2890: iconst_1
    //   2891: invokevirtual 837	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2894: istore 10
    //   2896: aload_1
    //   2897: ldc_w 907
    //   2900: iconst_0
    //   2901: invokevirtual 877	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2904: istore 6
    //   2906: aload_1
    //   2907: ldc_w 909
    //   2910: iconst_0
    //   2911: invokevirtual 877	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2914: istore 7
    //   2916: new 911	java/util/HashMap
    //   2919: dup
    //   2920: invokespecial 912	java/util/HashMap:<init>	()V
    //   2923: astore 4
    //   2925: aload_1
    //   2926: ldc_w 914
    //   2929: invokevirtual 740	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2932: astore_1
    //   2933: aload_1
    //   2934: ifnull +53 -> 2987
    //   2937: aload_1
    //   2938: invokevirtual 744	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   2941: astore 5
    //   2943: aload 5
    //   2945: ifnull +42 -> 2987
    //   2948: aload 5
    //   2950: invokeinterface 749 1 0
    //   2955: ifeq +32 -> 2987
    //   2958: aload 5
    //   2960: invokeinterface 753 1 0
    //   2965: checkcast 137	java/lang/String
    //   2968: astore 11
    //   2970: aload 4
    //   2972: aload 11
    //   2974: aload_1
    //   2975: aload 11
    //   2977: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2980: invokevirtual 917	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2983: pop
    //   2984: goto -41 -> 2943
    //   2987: aconst_null
    //   2988: astore_1
    //   2989: aload_2
    //   2990: invokevirtual 186	com/tencent/common/app/AppInterface:isLogin	()Z
    //   2993: ifeq +8 -> 3001
    //   2996: aload_2
    //   2997: invokevirtual 189	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   3000: astore_1
    //   3001: aconst_null
    //   3002: invokestatic 922	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   3005: aload_1
    //   3006: aload_3
    //   3007: iload 10
    //   3009: iload 6
    //   3011: i2l
    //   3012: iload 7
    //   3014: i2l
    //   3015: aload 4
    //   3017: ldc_w 792
    //   3020: iload 9
    //   3022: invokevirtual 925	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   3025: goto -1955 -> 1070
    //   3028: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3031: ifeq -1961 -> 1070
    //   3034: ldc 213
    //   3036: iconst_2
    //   3037: ldc_w 927
    //   3040: invokestatic 848	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3043: goto -1973 -> 1070
    //   3046: ldc_w 929
    //   3049: aload 4
    //   3051: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3054: ifeq +175 -> 3229
    //   3057: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3060: ifeq +12 -> 3072
    //   3063: ldc 213
    //   3065: iconst_2
    //   3066: ldc_w 929
    //   3069: invokestatic 253	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3072: new 51	org/json/JSONObject
    //   3075: dup
    //   3076: aload 5
    //   3078: iconst_0
    //   3079: aaload
    //   3080: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3083: astore_2
    //   3084: aload_2
    //   3085: ldc 125
    //   3087: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3090: astore_1
    //   3091: aload_2
    //   3092: ldc 238
    //   3094: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3097: astore_2
    //   3098: aload_1
    //   3099: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3102: ifne +109 -> 3211
    //   3105: new 700	android/os/Bundle
    //   3108: dup
    //   3109: invokespecial 701	android/os/Bundle:<init>	()V
    //   3112: astore_3
    //   3113: aload_2
    //   3114: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3117: ifne +75 -> 3192
    //   3120: aload_3
    //   3121: ldc 238
    //   3123: aload_2
    //   3124: invokevirtual 704	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3127: ldc_w 931
    //   3130: aload_1
    //   3131: aload_0
    //   3132: getfield 24	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   3135: getfield 710	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   3138: aload_3
    //   3139: invokestatic 715	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   3142: astore_1
    //   3143: invokestatic 720	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   3146: aload_1
    //   3147: invokevirtual 723	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	(Landroid/os/Bundle;)V
    //   3150: goto -2080 -> 1070
    //   3153: astore_1
    //   3154: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3157: ifeq -2087 -> 1070
    //   3160: ldc 213
    //   3162: iconst_2
    //   3163: new 78	java/lang/StringBuilder
    //   3166: dup
    //   3167: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   3170: ldc_w 933
    //   3173: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3176: aload_1
    //   3177: invokevirtual 895	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   3180: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3183: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3186: invokestatic 848	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3189: goto -2119 -> 1070
    //   3192: aload_3
    //   3193: ldc 238
    //   3195: aload_0
    //   3196: getfield 176	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3199: invokevirtual 181	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   3202: invokevirtual 189	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   3205: invokevirtual 704	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3208: goto -81 -> 3127
    //   3211: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3214: ifeq -2144 -> 1070
    //   3217: ldc 213
    //   3219: iconst_2
    //   3220: ldc_w 935
    //   3223: invokestatic 253	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3226: goto -2156 -> 1070
    //   3229: ldc_w 937
    //   3232: aload 4
    //   3234: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3237: ifeq +116 -> 3353
    //   3240: aload 5
    //   3242: arraylength
    //   3243: iconst_1
    //   3244: if_icmpne +109 -> 3353
    //   3247: new 51	org/json/JSONObject
    //   3250: dup
    //   3251: aload 5
    //   3253: iconst_0
    //   3254: aaload
    //   3255: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3258: ldc 125
    //   3260: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3263: astore_1
    //   3264: aload_1
    //   3265: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3268: ifne -2198 -> 1070
    //   3271: aload_0
    //   3272: aload_1
    //   3273: iconst_1
    //   3274: anewarray 137	java/lang/String
    //   3277: dup
    //   3278: iconst_0
    //   3279: new 78	java/lang/StringBuilder
    //   3282: dup
    //   3283: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   3286: ldc_w 939
    //   3289: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3292: getstatic 942	com/tencent/common/config/AppSetting:jdField_a_of_type_Int	I
    //   3295: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3298: ldc_w 944
    //   3301: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3304: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3307: aastore
    //   3308: invokevirtual 142	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3311: goto -2241 -> 1070
    //   3314: astore_1
    //   3315: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3318: ifeq -2248 -> 1070
    //   3321: ldc 213
    //   3323: iconst_2
    //   3324: new 78	java/lang/StringBuilder
    //   3327: dup
    //   3328: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   3331: ldc_w 946
    //   3334: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3337: aload_1
    //   3338: invokevirtual 895	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   3341: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3344: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3347: invokestatic 848	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3350: goto -2280 -> 1070
    //   3353: ldc_w 948
    //   3356: aload 4
    //   3358: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3361: ifeq +520 -> 3881
    //   3364: aload 5
    //   3366: arraylength
    //   3367: iconst_1
    //   3368: if_icmpne +513 -> 3881
    //   3371: new 51	org/json/JSONObject
    //   3374: dup
    //   3375: aload 5
    //   3377: iconst_0
    //   3378: aaload
    //   3379: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3382: astore_1
    //   3383: aload_1
    //   3384: ldc 125
    //   3386: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3389: astore_3
    //   3390: aload_1
    //   3391: ldc_w 950
    //   3394: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3397: astore_1
    //   3398: aload_1
    //   3399: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3402: ifne +1854 -> 5256
    //   3405: aload_1
    //   3406: invokevirtual 953	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   3409: astore 4
    //   3411: aload_0
    //   3412: getfield 176	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3415: invokevirtual 181	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   3418: astore_2
    //   3419: aload_2
    //   3420: ifnull +1836 -> 5256
    //   3423: aload_2
    //   3424: invokevirtual 186	com/tencent/common/app/AppInterface:isLogin	()Z
    //   3427: ifeq +1829 -> 5256
    //   3430: aload_2
    //   3431: invokevirtual 189	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   3434: astore_1
    //   3435: aload_2
    //   3436: iconst_2
    //   3437: invokevirtual 529	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3440: checkcast 531	mqq/manager/TicketManager
    //   3443: astore_2
    //   3444: aload_2
    //   3445: aload_1
    //   3446: aload 4
    //   3448: invokeinterface 613 3 0
    //   3453: astore 13
    //   3455: aload_2
    //   3456: aload_1
    //   3457: aload 4
    //   3459: invokeinterface 956 3 0
    //   3464: astore 5
    //   3466: aload 13
    //   3468: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3471: ifne +1785 -> 5256
    //   3474: new 78	java/lang/StringBuilder
    //   3477: dup
    //   3478: bipush 111
    //   3480: invokespecial 958	java/lang/StringBuilder:<init>	(I)V
    //   3483: astore_2
    //   3484: aload_1
    //   3485: invokevirtual 961	java/lang/String:length	()I
    //   3488: bipush 10
    //   3490: if_icmpge +32 -> 3522
    //   3493: aload_1
    //   3494: invokevirtual 961	java/lang/String:length	()I
    //   3497: istore 6
    //   3499: iload 6
    //   3501: bipush 10
    //   3503: if_icmpge +19 -> 3522
    //   3506: aload_2
    //   3507: bipush 48
    //   3509: invokevirtual 495	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3512: pop
    //   3513: iload 6
    //   3515: iconst_1
    //   3516: iadd
    //   3517: istore 6
    //   3519: goto -20 -> 3499
    //   3522: aload_2
    //   3523: aload_1
    //   3524: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3527: pop
    //   3528: invokestatic 195	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   3531: astore 11
    //   3533: aload 11
    //   3535: iconst_1
    //   3536: invokevirtual 232	com/tencent/smtt/sdk/CookieManager:setAcceptCookie	(Z)V
    //   3539: new 78	java/lang/StringBuilder
    //   3542: dup
    //   3543: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   3546: ldc_w 729
    //   3549: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3552: aload 4
    //   3554: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3557: bipush 47
    //   3559: invokevirtual 495	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3562: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3565: astore 12
    //   3567: new 78	java/lang/StringBuilder
    //   3570: dup
    //   3571: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   3574: ldc 255
    //   3576: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3579: aload_2
    //   3580: invokevirtual 964	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   3583: ldc_w 492
    //   3586: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3589: aload 4
    //   3591: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3594: bipush 59
    //   3596: invokevirtual 495	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3599: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3602: astore 14
    //   3604: aload 11
    //   3606: aload 12
    //   3608: aload 14
    //   3610: invokevirtual 246	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   3613: ldc_w 792
    //   3616: astore_1
    //   3617: ldc_w 792
    //   3620: astore_2
    //   3621: aload 13
    //   3623: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3626: ifne +49 -> 3675
    //   3629: new 78	java/lang/StringBuilder
    //   3632: dup
    //   3633: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   3636: ldc_w 490
    //   3639: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3642: aload 13
    //   3644: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3647: ldc_w 492
    //   3650: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3653: aload 4
    //   3655: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3658: bipush 59
    //   3660: invokevirtual 495	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3663: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3666: astore_1
    //   3667: aload 11
    //   3669: aload 12
    //   3671: aload_1
    //   3672: invokevirtual 246	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   3675: aload 5
    //   3677: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3680: ifne +49 -> 3729
    //   3683: new 78	java/lang/StringBuilder
    //   3686: dup
    //   3687: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   3690: ldc_w 506
    //   3693: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3696: aload 5
    //   3698: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3701: ldc_w 492
    //   3704: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3707: aload 4
    //   3709: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3712: bipush 59
    //   3714: invokevirtual 495	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3717: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3720: astore_2
    //   3721: aload 11
    //   3723: aload 12
    //   3725: aload_2
    //   3726: invokevirtual 246	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   3729: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3732: ifeq +1564 -> 5296
    //   3735: ldc 213
    //   3737: iconst_2
    //   3738: new 78	java/lang/StringBuilder
    //   3741: dup
    //   3742: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   3745: ldc_w 607
    //   3748: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3751: aload 14
    //   3753: iconst_0
    //   3754: anewarray 137	java/lang/String
    //   3757: invokestatic 223	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3760: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3763: aload_1
    //   3764: iconst_0
    //   3765: anewarray 137	java/lang/String
    //   3768: invokestatic 223	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3771: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3774: aload_2
    //   3775: iconst_0
    //   3776: anewarray 137	java/lang/String
    //   3779: invokestatic 223	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3782: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3785: ldc_w 609
    //   3788: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3791: aload 12
    //   3793: iconst_0
    //   3794: anewarray 137	java/lang/String
    //   3797: invokestatic 218	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3800: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3803: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3806: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3809: goto +1487 -> 5296
    //   3812: aload_3
    //   3813: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3816: ifne -2746 -> 1070
    //   3819: aload_0
    //   3820: aload_3
    //   3821: iconst_1
    //   3822: anewarray 137	java/lang/String
    //   3825: dup
    //   3826: iconst_0
    //   3827: new 78	java/lang/StringBuilder
    //   3830: dup
    //   3831: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   3834: ldc_w 966
    //   3837: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3840: iload 6
    //   3842: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3845: ldc_w 944
    //   3848: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3851: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3854: aastore
    //   3855: invokevirtual 142	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3858: goto -2788 -> 1070
    //   3861: astore_1
    //   3862: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3865: ifeq -2795 -> 1070
    //   3868: ldc 213
    //   3870: iconst_2
    //   3871: ldc_w 968
    //   3874: aload_1
    //   3875: invokestatic 675	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3878: goto -2808 -> 1070
    //   3881: ldc_w 970
    //   3884: aload 4
    //   3886: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3889: ifeq +13 -> 3902
    //   3892: aload_0
    //   3893: aload_2
    //   3894: aload 5
    //   3896: invokespecial 972	com/tencent/mobileqq/jsp/DataApiPlugin:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3899: goto -2829 -> 1070
    //   3902: ldc_w 974
    //   3905: aload 4
    //   3907: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3910: ifeq +137 -> 4047
    //   3913: aconst_null
    //   3914: astore_2
    //   3915: aload_2
    //   3916: astore_1
    //   3917: new 51	org/json/JSONObject
    //   3920: dup
    //   3921: aload 5
    //   3923: iconst_0
    //   3924: aaload
    //   3925: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3928: astore_3
    //   3929: aload_2
    //   3930: astore_1
    //   3931: aload_3
    //   3932: ldc 125
    //   3934: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3937: astore_2
    //   3938: aload_2
    //   3939: astore_1
    //   3940: aload_3
    //   3941: ldc 238
    //   3943: invokevirtual 866	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3946: astore_3
    //   3947: aload_2
    //   3948: astore_1
    //   3949: invokestatic 720	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   3952: invokevirtual 976	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Z
    //   3955: ifeq -2885 -> 1070
    //   3958: aload_2
    //   3959: astore_1
    //   3960: new 700	android/os/Bundle
    //   3963: dup
    //   3964: invokespecial 701	android/os/Bundle:<init>	()V
    //   3967: astore 4
    //   3969: aload_2
    //   3970: astore_1
    //   3971: aload 4
    //   3973: ldc 238
    //   3975: aload_3
    //   3976: invokevirtual 704	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3979: aload_2
    //   3980: astore_1
    //   3981: ldc_w 978
    //   3984: aload_2
    //   3985: aload_0
    //   3986: getfield 24	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver	Lcom/tencent/mobileqq/emosm/Client$onRemoteRespObserver;
    //   3989: getfield 710	com/tencent/mobileqq/emosm/Client$onRemoteRespObserver:key	I
    //   3992: aload 4
    //   3994: invokestatic 715	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   3997: astore_3
    //   3998: aload_2
    //   3999: astore_1
    //   4000: invokestatic 720	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   4003: aload_3
    //   4004: invokevirtual 723	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	(Landroid/os/Bundle;)V
    //   4007: goto -2937 -> 1070
    //   4010: astore_2
    //   4011: aload_1
    //   4012: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4015: ifne -2945 -> 1070
    //   4018: aload_0
    //   4019: aload_1
    //   4020: iconst_1
    //   4021: anewarray 137	java/lang/String
    //   4024: dup
    //   4025: iconst_0
    //   4026: ldc_w 980
    //   4029: iconst_1
    //   4030: anewarray 236	java/lang/Object
    //   4033: dup
    //   4034: iconst_0
    //   4035: aload_2
    //   4036: aastore
    //   4037: invokestatic 242	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4040: aastore
    //   4041: invokevirtual 142	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4044: goto -2974 -> 1070
    //   4047: ldc_w 982
    //   4050: aload 4
    //   4052: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4055: ifeq +128 -> 4183
    //   4058: new 51	org/json/JSONObject
    //   4061: dup
    //   4062: aload 5
    //   4064: iconst_0
    //   4065: aaload
    //   4066: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4069: astore_1
    //   4070: ldc_w 984
    //   4073: aload_1
    //   4074: ldc_w 986
    //   4077: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4080: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4083: ifeq +24 -> 4107
    //   4086: aload_0
    //   4087: getfield 176	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4090: invokevirtual 651	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   4093: astore_2
    //   4094: aload_2
    //   4095: ifnull +12 -> 4107
    //   4098: aload_2
    //   4099: iconst_m1
    //   4100: invokevirtual 989	android/app/Activity:setResult	(I)V
    //   4103: aload_2
    //   4104: invokevirtual 992	android/app/Activity:finish	()V
    //   4107: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4110: ifeq -3040 -> 1070
    //   4113: ldc 213
    //   4115: iconst_2
    //   4116: new 78	java/lang/StringBuilder
    //   4119: dup
    //   4120: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   4123: ldc_w 994
    //   4126: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4129: aload_1
    //   4130: invokevirtual 997	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4133: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4136: invokestatic 848	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4139: goto -3069 -> 1070
    //   4142: astore_1
    //   4143: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4146: ifeq +13 -> 4159
    //   4149: ldc 213
    //   4151: iconst_2
    //   4152: ldc_w 999
    //   4155: aload_1
    //   4156: invokestatic 675	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4159: aload_0
    //   4160: getfield 176	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4163: invokevirtual 651	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   4166: astore_1
    //   4167: aload_1
    //   4168: ifnull -3098 -> 1070
    //   4171: aload_1
    //   4172: iconst_0
    //   4173: invokevirtual 989	android/app/Activity:setResult	(I)V
    //   4176: aload_1
    //   4177: invokevirtual 992	android/app/Activity:finish	()V
    //   4180: goto -3110 -> 1070
    //   4183: ldc_w 1001
    //   4186: aload 4
    //   4188: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4191: ifeq +380 -> 4571
    //   4194: aload 5
    //   4196: arraylength
    //   4197: iconst_1
    //   4198: if_icmpne +373 -> 4571
    //   4201: new 51	org/json/JSONObject
    //   4204: dup
    //   4205: aload 5
    //   4207: iconst_0
    //   4208: aaload
    //   4209: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4212: astore_3
    //   4213: aload_3
    //   4214: ldc 125
    //   4216: invokevirtual 866	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4219: astore_2
    //   4220: aload_3
    //   4221: ldc_w 1003
    //   4224: invokevirtual 866	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4227: astore 4
    //   4229: aload_3
    //   4230: ldc_w 950
    //   4233: invokevirtual 866	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4236: astore_1
    //   4237: aload_0
    //   4238: getfield 315	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4241: ifnonnull +10 -> 4251
    //   4244: aload_0
    //   4245: invokestatic 320	com/tencent/biz/AuthorizeConfig:a	()Lcom/tencent/biz/AuthorizeConfig;
    //   4248: putfield 315	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4251: iconst_0
    //   4252: istore 10
    //   4254: iload 10
    //   4256: istore 9
    //   4258: aload 4
    //   4260: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4263: ifne +71 -> 4334
    //   4266: iload 10
    //   4268: istore 9
    //   4270: aload_1
    //   4271: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4274: ifne +60 -> 4334
    //   4277: new 78	java/lang/StringBuilder
    //   4280: dup
    //   4281: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   4284: ldc_w 729
    //   4287: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4290: aload_1
    //   4291: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4294: ldc_w 1005
    //   4297: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4300: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4303: astore_1
    //   4304: ldc_w 1007
    //   4307: aload 4
    //   4309: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4312: ifeq +67 -> 4379
    //   4315: aload_3
    //   4316: ldc_w 1009
    //   4319: invokevirtual 866	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4322: astore_3
    //   4323: aload_0
    //   4324: getfield 315	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4327: aload_1
    //   4328: aload_3
    //   4329: invokevirtual 1012	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4332: istore 9
    //   4334: iload 9
    //   4336: ifeq +228 -> 4564
    //   4339: ldc_w 1014
    //   4342: astore_1
    //   4343: aload_0
    //   4344: aload_2
    //   4345: iconst_1
    //   4346: anewarray 137	java/lang/String
    //   4349: dup
    //   4350: iconst_0
    //   4351: aload_1
    //   4352: aastore
    //   4353: invokevirtual 142	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4356: goto -3286 -> 1070
    //   4359: astore_1
    //   4360: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4363: ifeq -3293 -> 1070
    //   4366: ldc 213
    //   4368: iconst_2
    //   4369: ldc_w 1016
    //   4372: aload_1
    //   4373: invokestatic 675	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4376: goto -3306 -> 1070
    //   4379: ldc_w 342
    //   4382: aload 4
    //   4384: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4387: ifeq +16 -> 4403
    //   4390: aload_0
    //   4391: getfield 315	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4394: aload_1
    //   4395: invokevirtual 362	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;)Z
    //   4398: istore 9
    //   4400: goto -66 -> 4334
    //   4403: ldc_w 1018
    //   4406: aload 4
    //   4408: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4411: ifeq +23 -> 4434
    //   4414: aload_0
    //   4415: getfield 315	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4418: aload_1
    //   4419: invokevirtual 522	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4422: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4425: ifne +877 -> 5302
    //   4428: iconst_1
    //   4429: istore 9
    //   4431: goto -97 -> 4334
    //   4434: ldc_w 368
    //   4437: aload 4
    //   4439: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4442: ifeq +23 -> 4465
    //   4445: aload_0
    //   4446: getfield 315	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4449: aload_1
    //   4450: invokevirtual 370	com/tencent/biz/AuthorizeConfig:d	(Ljava/lang/String;)Ljava/lang/String;
    //   4453: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4456: ifne +852 -> 5308
    //   4459: iconst_1
    //   4460: istore 9
    //   4462: goto -128 -> 4334
    //   4465: ldc_w 1020
    //   4468: aload 4
    //   4470: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4473: ifeq +25 -> 4498
    //   4476: aload_3
    //   4477: ldc_w 1020
    //   4480: invokevirtual 866	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4483: astore_3
    //   4484: aload_0
    //   4485: getfield 315	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4488: aload_1
    //   4489: aload_3
    //   4490: invokevirtual 1022	com/tencent/biz/AuthorizeConfig:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4493: istore 9
    //   4495: goto -161 -> 4334
    //   4498: ldc_w 384
    //   4501: aload 4
    //   4503: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4506: ifeq +23 -> 4529
    //   4509: aload_0
    //   4510: getfield 315	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4513: aload_1
    //   4514: invokevirtual 386	com/tencent/biz/AuthorizeConfig:e	(Ljava/lang/String;)Ljava/lang/String;
    //   4517: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4520: ifne +794 -> 5314
    //   4523: iconst_1
    //   4524: istore 9
    //   4526: goto -192 -> 4334
    //   4529: iload 10
    //   4531: istore 9
    //   4533: ldc_w 1024
    //   4536: aload 4
    //   4538: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4541: ifeq -207 -> 4334
    //   4544: aload_0
    //   4545: getfield 315	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4548: aload_1
    //   4549: invokevirtual 525	com/tencent/biz/AuthorizeConfig:f	(Ljava/lang/String;)Ljava/lang/String;
    //   4552: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4555: ifne +765 -> 5320
    //   4558: iconst_1
    //   4559: istore 9
    //   4561: goto -227 -> 4334
    //   4564: ldc_w 1026
    //   4567: astore_1
    //   4568: goto -225 -> 4343
    //   4571: ldc_w 1028
    //   4574: aload 4
    //   4576: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4579: ifeq +110 -> 4689
    //   4582: new 51	org/json/JSONObject
    //   4585: dup
    //   4586: aload 5
    //   4588: iconst_0
    //   4589: aaload
    //   4590: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4593: astore_1
    //   4594: aload_1
    //   4595: ldc_w 280
    //   4598: iconst_0
    //   4599: invokevirtual 837	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   4602: istore 9
    //   4604: aload_0
    //   4605: getfield 1030	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4608: ifnonnull +17 -> 4625
    //   4611: aload_0
    //   4612: invokestatic 1035	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4615: putfield 1030	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4618: aload_0
    //   4619: getfield 1030	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4622: invokevirtual 1037	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   4625: aload_0
    //   4626: getfield 1030	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4629: iload 9
    //   4631: invokevirtual 1039	com/tencent/biz/troop/TroopMemberApiClient:a	(Z)V
    //   4634: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4637: ifeq -3567 -> 1070
    //   4640: ldc 213
    //   4642: iconst_2
    //   4643: new 78	java/lang/StringBuilder
    //   4646: dup
    //   4647: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   4650: ldc_w 1041
    //   4653: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4656: aload_1
    //   4657: invokevirtual 997	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4660: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4663: invokestatic 848	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4666: goto -3596 -> 1070
    //   4669: astore_1
    //   4670: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4673: ifeq -3603 -> 1070
    //   4676: ldc 213
    //   4678: iconst_2
    //   4679: ldc_w 999
    //   4682: aload_1
    //   4683: invokestatic 675	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4686: goto -3616 -> 1070
    //   4689: ldc_w 1043
    //   4692: aload 4
    //   4694: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4697: ifeq +146 -> 4843
    //   4700: new 51	org/json/JSONObject
    //   4703: dup
    //   4704: aload 5
    //   4706: iconst_0
    //   4707: aaload
    //   4708: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4711: astore_1
    //   4712: aload_1
    //   4713: ldc_w 1045
    //   4716: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4719: astore_2
    //   4720: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4723: ifeq +29 -> 4752
    //   4726: ldc 213
    //   4728: iconst_2
    //   4729: new 78	java/lang/StringBuilder
    //   4732: dup
    //   4733: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   4736: ldc_w 1047
    //   4739: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4742: aload_2
    //   4743: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4746: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4749: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4752: aload_0
    //   4753: getfield 68	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface	Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebUiMethodInterface;
    //   4756: invokeinterface 1048 1 0
    //   4761: astore_2
    //   4762: aload_2
    //   4763: ifnull -3693 -> 1070
    //   4766: aload_2
    //   4767: invokevirtual 1051	com/tencent/biz/pubaccount/CustomWebView:a	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   4770: astore_2
    //   4771: aload_2
    //   4772: iconst_1
    //   4773: anewarray 137	java/lang/String
    //   4776: dup
    //   4777: iconst_0
    //   4778: ldc_w 1053
    //   4781: aastore
    //   4782: invokevirtual 1058	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	([Ljava/lang/String;)V
    //   4785: aload_2
    //   4786: ldc_w 1053
    //   4789: invokevirtual 1061	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   4792: astore_2
    //   4793: aload_2
    //   4794: ifnull -3724 -> 1070
    //   4797: aload_2
    //   4798: instanceof 1063
    //   4801: ifeq -3731 -> 1070
    //   4804: aload_2
    //   4805: checkcast 1063	com/tencent/biz/webviewplugin/UrlCheckPlugin
    //   4808: aload_1
    //   4809: ldc_w 1065
    //   4812: invokevirtual 64	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4815: aload_1
    //   4816: ldc_w 1067
    //   4819: invokevirtual 64	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4822: aload_1
    //   4823: ldc_w 1069
    //   4826: invokevirtual 64	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4829: invokevirtual 1072	com/tencent/biz/webviewplugin/UrlCheckPlugin:a	(III)V
    //   4832: goto -3762 -> 1070
    //   4835: astore_1
    //   4836: aload_1
    //   4837: invokevirtual 633	org/json/JSONException:printStackTrace	()V
    //   4840: goto -3770 -> 1070
    //   4843: ldc_w 1074
    //   4846: aload 4
    //   4848: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4851: ifeq +130 -> 4981
    //   4854: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4857: ifeq +30 -> 4887
    //   4860: ldc 213
    //   4862: iconst_2
    //   4863: new 78	java/lang/StringBuilder
    //   4866: dup
    //   4867: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   4870: ldc_w 1076
    //   4873: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4876: aload 5
    //   4878: invokevirtual 997	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4881: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4884: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4887: aload 5
    //   4889: ifnull -3819 -> 1070
    //   4892: aload 5
    //   4894: arraylength
    //   4895: ifle -3825 -> 1070
    //   4898: new 51	org/json/JSONObject
    //   4901: dup
    //   4902: aload 5
    //   4904: iconst_0
    //   4905: aaload
    //   4906: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4909: astore_1
    //   4910: aload_1
    //   4911: ldc_w 1078
    //   4914: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4917: astore_2
    //   4918: aload_1
    //   4919: ldc 125
    //   4921: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4924: astore_1
    //   4925: aload_1
    //   4926: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4929: ifne -3859 -> 1070
    //   4932: aload_2
    //   4933: invokestatic 1081	com/tencent/mobileqq/nearby/NearbyURLSafeUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4936: astore_2
    //   4937: new 51	org/json/JSONObject
    //   4940: dup
    //   4941: invokespecial 278	org/json/JSONObject:<init>	()V
    //   4944: astore_3
    //   4945: aload_3
    //   4946: ldc_w 1083
    //   4949: aload_2
    //   4950: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4953: pop
    //   4954: aload_0
    //   4955: aload_1
    //   4956: iconst_1
    //   4957: anewarray 137	java/lang/String
    //   4960: dup
    //   4961: iconst_0
    //   4962: aload_3
    //   4963: invokevirtual 292	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4966: aastore
    //   4967: invokevirtual 142	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4970: goto -3900 -> 1070
    //   4973: astore_1
    //   4974: aload_1
    //   4975: invokevirtual 633	org/json/JSONException:printStackTrace	()V
    //   4978: goto -3908 -> 1070
    //   4981: ldc_w 1085
    //   4984: aload 4
    //   4986: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4989: ifeq +130 -> 5119
    //   4992: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4995: ifeq +30 -> 5025
    //   4998: ldc 213
    //   5000: iconst_2
    //   5001: new 78	java/lang/StringBuilder
    //   5004: dup
    //   5005: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   5008: ldc_w 1087
    //   5011: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5014: aload 5
    //   5016: invokevirtual 997	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   5019: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5022: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5025: aload 5
    //   5027: ifnull -3957 -> 1070
    //   5030: aload 5
    //   5032: arraylength
    //   5033: ifle -3963 -> 1070
    //   5036: new 51	org/json/JSONObject
    //   5039: dup
    //   5040: aload 5
    //   5042: iconst_0
    //   5043: aaload
    //   5044: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5047: astore_1
    //   5048: aload_1
    //   5049: ldc_w 1089
    //   5052: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5055: astore_2
    //   5056: aload_1
    //   5057: ldc 125
    //   5059: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5062: astore_1
    //   5063: aload_1
    //   5064: invokestatic 135	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5067: ifne -3997 -> 1070
    //   5070: aload_2
    //   5071: invokestatic 1090	com/tencent/mobileqq/nearby/NearbyURLSafeUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   5074: astore_2
    //   5075: new 51	org/json/JSONObject
    //   5078: dup
    //   5079: invokespecial 278	org/json/JSONObject:<init>	()V
    //   5082: astore_3
    //   5083: aload_3
    //   5084: ldc_w 1092
    //   5087: aload_2
    //   5088: invokevirtual 291	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5091: pop
    //   5092: aload_0
    //   5093: aload_1
    //   5094: iconst_1
    //   5095: anewarray 137	java/lang/String
    //   5098: dup
    //   5099: iconst_0
    //   5100: aload_3
    //   5101: invokevirtual 292	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5104: aastore
    //   5105: invokevirtual 142	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   5108: goto -4038 -> 1070
    //   5111: astore_1
    //   5112: aload_1
    //   5113: invokevirtual 633	org/json/JSONException:printStackTrace	()V
    //   5116: goto -4046 -> 1070
    //   5119: ldc_w 1094
    //   5122: aload 4
    //   5124: invokevirtual 346	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5127: ifeq -4057 -> 1070
    //   5130: new 51	org/json/JSONObject
    //   5133: dup
    //   5134: aload 5
    //   5136: iconst_0
    //   5137: aaload
    //   5138: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5141: ldc_w 1096
    //   5144: invokevirtual 129	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5147: astore_1
    //   5148: aload_0
    //   5149: getfield 1030	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   5152: ifnonnull +17 -> 5169
    //   5155: aload_0
    //   5156: invokestatic 1035	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   5159: putfield 1030	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   5162: aload_0
    //   5163: getfield 1030	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   5166: invokevirtual 1037	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   5169: aload_0
    //   5170: getfield 1030	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   5173: iconst_1
    //   5174: aload_1
    //   5175: invokevirtual 1099	com/tencent/biz/troop/TroopMemberApiClient:a	(ZLjava/lang/String;)V
    //   5178: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5181: ifeq -4111 -> 1070
    //   5184: ldc 213
    //   5186: iconst_2
    //   5187: new 78	java/lang/StringBuilder
    //   5190: dup
    //   5191: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   5194: ldc_w 1101
    //   5197: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5200: aload 5
    //   5202: iconst_0
    //   5203: aaload
    //   5204: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5207: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5210: invokestatic 848	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   5213: goto -4143 -> 1070
    //   5216: astore_1
    //   5217: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5220: ifeq -4150 -> 1070
    //   5223: ldc 213
    //   5225: iconst_2
    //   5226: ldc_w 1103
    //   5229: aload_1
    //   5230: invokestatic 675	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5233: goto -4163 -> 1070
    //   5236: iconst_0
    //   5237: ireturn
    //   5238: astore_2
    //   5239: goto -3023 -> 2216
    //   5242: astore_1
    //   5243: goto -4093 -> 1150
    //   5246: astore 4
    //   5248: goto -4166 -> 1082
    //   5251: astore 4
    //   5253: goto -4171 -> 1082
    //   5256: iconst_1
    //   5257: istore 6
    //   5259: goto -1447 -> 3812
    //   5262: aconst_null
    //   5263: astore_1
    //   5264: goto -2803 -> 2461
    //   5267: ldc_w 792
    //   5270: astore_1
    //   5271: goto -2973 -> 2298
    //   5274: goto -3132 -> 2142
    //   5277: goto -4874 -> 403
    //   5280: aload_1
    //   5281: astore 4
    //   5283: goto -4838 -> 445
    //   5286: aload_1
    //   5287: astore_3
    //   5288: goto -4827 -> 461
    //   5291: goto -5211 -> 80
    //   5294: iconst_1
    //   5295: ireturn
    //   5296: iconst_0
    //   5297: istore 6
    //   5299: goto -1487 -> 3812
    //   5302: iconst_0
    //   5303: istore 9
    //   5305: goto -971 -> 4334
    //   5308: iconst_0
    //   5309: istore 9
    //   5311: goto -977 -> 4334
    //   5314: iconst_0
    //   5315: istore 9
    //   5317: goto -983 -> 4334
    //   5320: iconst_0
    //   5321: istore 9
    //   5323: goto -989 -> 4334
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5326	0	this	DataApiPlugin
    //   0	5326	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	5326	2	paramString1	String
    //   0	5326	3	paramString2	String
    //   0	5326	4	paramString3	String
    //   0	5326	5	paramVarArgs	String[]
    //   161	5137	6	i	int
    //   2697	316	7	j	int
    //   2707	136	8	k	int
    //   172	5150	9	bool1	boolean
    //   2894	1636	10	bool2	boolean
    //   43	3679	11	localObject1	Object
    //   225	3567	12	localObject2	Object
    //   183	3460	13	str1	String
    //   216	3536	14	localObject3	Object
    //   232	2617	15	str2	String
    //   194	2657	16	str3	String
    //   87	699	17	localAppInterface	AppInterface
    //   205	492	18	str4	String
    // Exception table:
    //   from	to	target	type
    //   291	334	1078	java/lang/Exception
    //   27	57	1139	org/json/JSONException
    //   62	80	1139	org/json/JSONException
    //   80	105	1139	org/json/JSONException
    //   105	129	1139	org/json/JSONException
    //   131	145	1139	org/json/JSONException
    //   145	160	1139	org/json/JSONException
    //   163	291	1139	org/json/JSONException
    //   452	458	1139	org/json/JSONException
    //   461	471	1139	org/json/JSONException
    //   481	515	1139	org/json/JSONException
    //   515	628	1139	org/json/JSONException
    //   628	777	1139	org/json/JSONException
    //   777	914	1139	org/json/JSONException
    //   914	1044	1139	org/json/JSONException
    //   1044	1070	1139	org/json/JSONException
    //   1128	1134	1139	org/json/JSONException
    //   1154	1160	1139	org/json/JSONException
    //   1160	1162	1139	org/json/JSONException
    //   291	334	1147	finally
    //   1246	1272	1317	org/json/JSONException
    //   1278	1289	1317	org/json/JSONException
    //   1289	1314	1317	org/json/JSONException
    //   1343	1369	1317	org/json/JSONException
    //   1369	1384	1317	org/json/JSONException
    //   1395	1421	1317	org/json/JSONException
    //   1424	1448	1317	org/json/JSONException
    //   1448	1459	1317	org/json/JSONException
    //   1473	1561	1564	org/json/JSONException
    //   1590	1648	1759	org/json/JSONException
    //   1648	1678	1759	org/json/JSONException
    //   1683	1693	1759	org/json/JSONException
    //   1698	1713	1759	org/json/JSONException
    //   1715	1744	1759	org/json/JSONException
    //   1749	1756	1759	org/json/JSONException
    //   1767	1776	1759	org/json/JSONException
    //   1780	1796	1759	org/json/JSONException
    //   1800	1831	1759	org/json/JSONException
    //   1831	1841	1759	org/json/JSONException
    //   1846	1913	1759	org/json/JSONException
    //   1913	1934	1759	org/json/JSONException
    //   1962	2022	2073	org/json/JSONException
    //   2026	2034	2073	org/json/JSONException
    //   2038	2049	2073	org/json/JSONException
    //   2057	2070	2073	org/json/JSONException
    //   2081	2086	2073	org/json/JSONException
    //   2107	2134	2213	org/json/JSONException
    //   2241	2278	2317	java/lang/Exception
    //   2282	2287	2317	java/lang/Exception
    //   2291	2298	2317	java/lang/Exception
    //   2298	2314	2317	java/lang/Exception
    //   2372	2461	2520	java/lang/Exception
    //   2461	2491	2520	java/lang/Exception
    //   2491	2517	2520	java/lang/Exception
    //   2540	2562	2520	java/lang/Exception
    //   2583	2757	2808	org/json/JSONException
    //   2759	2771	2808	org/json/JSONException
    //   2771	2805	2808	org/json/JSONException
    //   2828	2855	2808	org/json/JSONException
    //   2858	2933	2808	org/json/JSONException
    //   2937	2943	2808	org/json/JSONException
    //   2948	2984	2808	org/json/JSONException
    //   2989	3001	2808	org/json/JSONException
    //   3001	3025	2808	org/json/JSONException
    //   3028	3043	2808	org/json/JSONException
    //   3072	3127	3153	org/json/JSONException
    //   3127	3150	3153	org/json/JSONException
    //   3192	3208	3153	org/json/JSONException
    //   3211	3226	3153	org/json/JSONException
    //   3247	3311	3314	org/json/JSONException
    //   3371	3419	3861	org/json/JSONException
    //   3423	3499	3861	org/json/JSONException
    //   3506	3513	3861	org/json/JSONException
    //   3522	3613	3861	org/json/JSONException
    //   3621	3675	3861	org/json/JSONException
    //   3675	3729	3861	org/json/JSONException
    //   3729	3809	3861	org/json/JSONException
    //   3812	3858	3861	org/json/JSONException
    //   3917	3929	4010	org/json/JSONException
    //   3931	3938	4010	org/json/JSONException
    //   3940	3947	4010	org/json/JSONException
    //   3949	3958	4010	org/json/JSONException
    //   3960	3969	4010	org/json/JSONException
    //   3971	3979	4010	org/json/JSONException
    //   3981	3998	4010	org/json/JSONException
    //   4000	4007	4010	org/json/JSONException
    //   4058	4094	4142	java/lang/Exception
    //   4098	4107	4142	java/lang/Exception
    //   4107	4139	4142	java/lang/Exception
    //   4201	4251	4359	org/json/JSONException
    //   4258	4266	4359	org/json/JSONException
    //   4270	4334	4359	org/json/JSONException
    //   4343	4356	4359	org/json/JSONException
    //   4379	4400	4359	org/json/JSONException
    //   4403	4428	4359	org/json/JSONException
    //   4434	4459	4359	org/json/JSONException
    //   4465	4495	4359	org/json/JSONException
    //   4498	4523	4359	org/json/JSONException
    //   4533	4558	4359	org/json/JSONException
    //   4582	4625	4669	java/lang/Exception
    //   4625	4666	4669	java/lang/Exception
    //   4700	4752	4835	org/json/JSONException
    //   4752	4762	4835	org/json/JSONException
    //   4766	4793	4835	org/json/JSONException
    //   4797	4832	4835	org/json/JSONException
    //   4898	4970	4973	org/json/JSONException
    //   5036	5108	5111	org/json/JSONException
    //   5130	5169	5216	java/lang/Exception
    //   5169	5213	5216	java/lang/Exception
    //   2142	2155	5238	org/json/JSONException
    //   2159	2186	5238	org/json/JSONException
    //   340	349	5242	finally
    //   351	368	5242	finally
    //   370	378	5242	finally
    //   380	400	5242	finally
    //   408	414	5242	finally
    //   416	442	5242	finally
    //   1084	1090	5242	finally
    //   1092	1122	5242	finally
    //   340	349	5246	java/lang/Exception
    //   351	368	5246	java/lang/Exception
    //   370	378	5246	java/lang/Exception
    //   380	400	5246	java/lang/Exception
    //   408	414	5251	java/lang/Exception
    //   416	442	5251	java/lang/Exception
  }
  
  protected void onCreate()
  {
    super.onCreate();
    WebIPCOperator.a().a(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
    WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebStatisticsInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebStatisticsInterface = ((WebUiUtils.WebStatisticsInterface)localWebUiBaseInterface);
    }
    localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface = ((WebUiUtils.WebUiMethodInterface)localWebUiBaseInterface);
    }
    localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebviewReportSpeedInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebviewReportSpeedInterface = ((WebUiUtils.WebviewReportSpeedInterface)localWebUiBaseInterface);
    }
    localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.a());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.QQBrowserBaseActivityInterface))) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface = ((WebUiUtils.QQBrowserBaseActivityInterface)localWebUiBaseInterface);
    }
  }
  
  protected void onDestroy()
  {
    WebIPCOperator.a().b(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$onRemoteRespObserver);
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DataApiPlugin
 * JD-Core Version:    0.7.0.1
 */