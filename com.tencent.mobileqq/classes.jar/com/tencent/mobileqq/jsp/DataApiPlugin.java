package com.tencent.mobileqq.jsp;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.Client.OnRemoteRespObserver;
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
  protected Client.OnRemoteRespObserver a;
  private WebUiUtils.QQBrowserBaseActivityInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$QQBrowserBaseActivityInterface = null;
  private WebUiUtils.WebStatisticsInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebStatisticsInterface = null;
  private WebUiUtils.WebUiMethodInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface = null;
  private WebUiUtils.WebviewReportSpeedInterface jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebviewReportSpeedInterface = null;
  CookieManager jdField_a_of_type_ComTencentSmttSdkCookieManager;
  
  public DataApiPlugin()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmClient$OnRemoteRespObserver = new DataApiPlugin.1(this);
    this.mPluginNameSpace = "data";
  }
  
  private void a(String paramString)
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
  
  private void a(String paramString, String[] paramArrayOfString)
  {
    int i = 0;
    long l = 0L;
    String str = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebStatisticsInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebviewReportSpeedInterface != null))
    {
      i = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebStatisticsInterface.getCurrentStep();
      l = this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebviewReportSpeedInterface.getmClickTime();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramArrayOfString[0]);
      int j = localJSONObject.getJSONObject("data").getInt("status");
      paramArrayOfString = "onFirstLine";
      paramString = "state_activity_first_line";
      if ((j != 12) && (j != 13))
      {
        if (str != null) {
          str.c(paramString);
        }
        if ((i < j) && (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQBrowser_report", 2, "try report web status, " + paramArrayOfString + ", step: " + j + ", stepTime: " + (System.currentTimeMillis() - l) + ", totalTime: " + (System.currentTimeMillis() - l) + ", \n " + this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface.getCurrentUrl());
          }
          if (this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebStatisticsInterface == null) {
            break label305;
          }
          this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebStatisticsInterface.setCurrentStep(j);
          this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebStatisticsInterface.setStepTime(System.currentTimeMillis());
        }
        label232:
        while (str == null)
        {
          paramString = localJSONObject.optString("callback");
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
          paramArrayOfString = "onPageFinished";
          break label441;
        }
        label299:
        label305:
        str.a.jdField_a_of_type_Int = j;
        str.a.jdField_a_of_type_Long = System.currentTimeMillis();
        switch (j)
        {
        }
      }
      for (;;)
      {
        str.ad = (str.a.jdField_a_of_type_Long - l);
        break label232;
        str.ae = (str.a.jdField_a_of_type_Long - l);
        break label232;
        str.af = (str.a.jdField_a_of_type_Long - l);
        str.a.a(this.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface.getCurrentUrl());
        break label232;
        if (j != 12) {
          break label299;
        }
        paramArrayOfString = "onPageVisible";
        label441:
        if (j == 12)
        {
          paramString = "state_first_screen";
          break;
        }
        paramString = "state_page_finished";
        break;
      }
      return;
    }
    catch (JSONException paramString) {}
  }
  
  private void c(String paramString1, String paramString2)
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
  
  void a(String paramString1, String paramString2)
  {
    String str1;
    int i;
    String str2;
    JSONObject localJSONObject;
    String str3;
    SharedPreferences localSharedPreferences;
    SharedPreferences.Editor localEditor;
    Object localObject1;
    int k;
    int j;
    String str4;
    try
    {
      str1 = VasUserData.a(this.mRuntime.a(), "ticketInterval");
      if (TextUtils.isEmpty(str1)) {
        break label998;
      }
      i = Integer.parseInt(str1);
      localObject2 = new JSONObject(paramString1);
      str2 = ((JSONObject)localObject2).optString("callback");
      localJSONObject = new JSONObject();
      if (!this.mRuntime.a().isLogin())
      {
        localJSONObject.put("result", -2);
        localJSONObject.put("message", HardCodeUtil.a(2131702768));
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
      str1 = null;
      localObject1 = null;
      paramString1 = null;
      k = 0;
      j = 0;
      str4 = ((JSONObject)localObject2).optString("key");
      if (!TextUtils.isEmpty(str4)) {
        break label320;
      }
      localJSONObject.put("result", -2);
      localJSONObject.put("message", "参数key为空");
      callJs(str2, new String[] { localJSONObject.toString() });
      return;
    }
    catch (Exception paramString1)
    {
      if (!QLog.isColorLevel()) {
        break label1005;
      }
    }
    QLog.e("DataApiPlugin", 2, "updateLoginInfo error: " + paramString1.getMessage());
    return;
    label320:
    Object localObject2 = new WUserSigInfo();
    long l;
    if ("skey".equals(str4))
    {
      l = localSharedPreferences.getLong("skey", 0L);
      if (System.currentTimeMillis() - l > i * 1000)
      {
        localEditor.putLong("skey", System.currentTimeMillis());
        localEditor.commit();
        i = j;
        if (!this.jdField_a_of_type_ComTencentBizAuthorizeConfig.a(paramString2)) {
          break label1006;
        }
        i = 4096;
        break label1006;
      }
    }
    label998:
    label1005:
    label1006:
    label1009:
    for (;;)
    {
      if (i == 0)
      {
        localJSONObject.put("result", -2);
        localJSONObject.put("message", HardCodeUtil.a(2131702770));
        callJs(str2, new String[] { localJSONObject.toString() });
        return;
        localJSONObject.put("result", 1);
        localJSONObject.put("message", HardCodeUtil.a(2131702769));
        callJs(str2, new String[] { localJSONObject.toString() });
        return;
        if ("pskey".equals(str4))
        {
          str1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.c(paramString2);
          l = localSharedPreferences.getLong("pskey_" + str1, 0L);
          if (System.currentTimeMillis() - l > i * 1000)
          {
            localEditor.putLong("pskey_" + str1, System.currentTimeMillis());
            localEditor.commit();
            i = k;
            if (TextUtils.isEmpty(str1)) {
              break label1009;
            }
            ((WUserSigInfo)localObject2)._domains.add(str1);
            i = 1048576;
            break label1009;
          }
          localJSONObject.put("result", 1);
          localJSONObject.put("message", HardCodeUtil.a(2131702771));
          callJs(str2, new String[] { localJSONObject.toString() });
          return;
        }
        paramString1 = (String)localObject1;
        if ("pt4_token".equals(str4))
        {
          localObject1 = this.jdField_a_of_type_ComTencentBizAuthorizeConfig.d(paramString2);
          l = localSharedPreferences.getLong("pt4_token_" + (String)localObject1, 0L);
          if (System.currentTimeMillis() - l > i * 1000)
          {
            localEditor.putLong("pt4_token_" + (String)localObject1, System.currentTimeMillis());
            localEditor.commit();
            paramString1 = (String)localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              ((WUserSigInfo)localObject2)._domains.add(String.format(Locale.getDefault(), "(%d)%s", new Object[] { Integer.valueOf(134217728), localObject1 }));
              i = 135266304;
              paramString1 = (String)localObject1;
            }
          }
          else
          {
            localJSONObject.put("result", 1);
            localJSONObject.put("message", HardCodeUtil.a(2131702772));
            callJs(str2, new String[] { localJSONObject.toString() });
          }
        }
      }
      else
      {
        QLog.d("DataApiPlugin", 1, "GetStWithoutPasswd|key=" + i);
        localObject1 = new WtloginHelper(this.mRuntime.a().getApplication());
        ((WtloginHelper)localObject1).setCallSource(30);
        ((WtloginHelper)localObject1).SetListener(new DataApiPlugin.GetKeyListener(this, paramString2, str2, str1, paramString1));
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
  
  void a(String paramString1, WUserSigInfo paramWUserSigInfo, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (paramWUserSigInfo == null)
    {
      b(paramString2, "get WUserSigInfo = null");
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
      a(paramString1);
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
      c(paramString1, paramString3);
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
  
  void b(String paramString1, String paramString2)
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
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 34
    //   2: aload_3
    //   3: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +4952 -> 4958
    //   9: ldc_w 525
    //   12: aload 4
    //   14: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifeq +1116 -> 1133
    //   20: aload 5
    //   22: arraylength
    //   23: iconst_1
    //   24: if_icmpne +1109 -> 1133
    //   27: new 166	org/json/JSONObject
    //   30: dup
    //   31: aload 5
    //   33: iconst_0
    //   34: aaload
    //   35: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   38: ldc 227
    //   40: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   43: astore 11
    //   45: aload_0
    //   46: getfield 44	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   49: invokevirtual 528	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   52: invokevirtual 533	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   55: astore 5
    //   57: aload 5
    //   59: ifnull +4954 -> 5013
    //   62: aload 5
    //   64: ldc_w 535
    //   67: invokevirtual 538	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   70: ifeq +4943 -> 5013
    //   73: aload 5
    //   75: invokestatic 541	com/tencent/biz/common/offline/HtmlOffline:c	(Ljava/lang/String;)Ljava/lang/String;
    //   78: astore 5
    //   80: aload_0
    //   81: getfield 44	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   84: invokevirtual 49	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   87: astore 17
    //   89: aload 5
    //   91: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   94: ifne +11 -> 105
    //   97: aload 17
    //   99: invokevirtual 61	com/tencent/common/app/AppInterface:isLogin	()Z
    //   102: ifne +29 -> 131
    //   105: aload 11
    //   107: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +21 -> 131
    //   113: aload_0
    //   114: aload 11
    //   116: iconst_1
    //   117: anewarray 79	java/lang/String
    //   120: dup
    //   121: iconst_0
    //   122: ldc_w 543
    //   125: aastore
    //   126: invokevirtual 235	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   129: iconst_1
    //   130: ireturn
    //   131: aload_0
    //   132: getfield 337	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   135: ifnonnull +10 -> 145
    //   138: aload_0
    //   139: invokestatic 342	com/tencent/biz/AuthorizeConfig:a	()Lcom/tencent/biz/AuthorizeConfig;
    //   142: putfield 337	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   145: aload_0
    //   146: getfield 337	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   149: aload 5
    //   151: invokevirtual 376	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;)Z
    //   154: istore 9
    //   156: aload_0
    //   157: getfield 337	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   160: aload 5
    //   162: invokevirtual 545	com/tencent/biz/AuthorizeConfig:e	(Ljava/lang/String;)Ljava/lang/String;
    //   165: astore 13
    //   167: aload_0
    //   168: getfield 337	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   171: aload 5
    //   173: invokevirtual 399	com/tencent/biz/AuthorizeConfig:d	(Ljava/lang/String;)Ljava/lang/String;
    //   176: astore 16
    //   178: aload_0
    //   179: getfield 337	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   182: aload 5
    //   184: invokevirtual 382	com/tencent/biz/AuthorizeConfig:c	(Ljava/lang/String;)Ljava/lang/String;
    //   187: astore 18
    //   189: aload 17
    //   191: iconst_2
    //   192: invokevirtual 549	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   195: checkcast 551	mqq/manager/TicketManager
    //   198: astore 14
    //   200: new 166	org/json/JSONObject
    //   203: dup
    //   204: invokespecial 296	org/json/JSONObject:<init>	()V
    //   207: astore 12
    //   209: aload 17
    //   211: invokevirtual 65	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   214: astore 15
    //   216: aload 12
    //   218: ldc 131
    //   220: aload 15
    //   222: invokevirtual 313	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   225: pop
    //   226: aload 17
    //   228: invokevirtual 321	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   231: new 95	java/lang/StringBuilder
    //   234: dup
    //   235: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   238: getstatic 557	mqq/app/Constants$PropertiesKey:nickName	Lmqq/app/Constants$PropertiesKey;
    //   241: invokevirtual 558	mqq/app/Constants$PropertiesKey:toString	()Ljava/lang/String;
    //   244: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: aload 15
    //   249: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokevirtual 561	mqq/app/MobileQQ:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   258: astore_1
    //   259: aload_1
    //   260: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   263: ifeq +4745 -> 5008
    //   266: invokestatic 567	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   269: invokevirtual 573	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   272: astore_2
    //   273: aload_2
    //   274: new 95	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   281: ldc_w 575
    //   284: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: aload 15
    //   289: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 581	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   298: aconst_null
    //   299: ldc_w 583
    //   302: iconst_1
    //   303: anewarray 79	java/lang/String
    //   306: dup
    //   307: iconst_0
    //   308: aload 15
    //   310: aastore
    //   311: aconst_null
    //   312: invokevirtual 589	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   315: astore_2
    //   316: aload_2
    //   317: ifnull +4685 -> 5002
    //   320: aload_2
    //   321: astore_3
    //   322: aload_2
    //   323: invokeinterface 594 1 0
    //   328: ifeq +4674 -> 5002
    //   331: aload_2
    //   332: astore_3
    //   333: aload_2
    //   334: aload_2
    //   335: ldc_w 596
    //   338: invokeinterface 599 2 0
    //   343: invokeinterface 602 2 0
    //   348: astore 4
    //   350: aload_2
    //   351: astore_3
    //   352: aload 4
    //   354: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   357: ifne +4642 -> 4999
    //   360: aload_2
    //   361: astore_3
    //   362: new 79	java/lang/String
    //   365: dup
    //   366: aload 4
    //   368: invokevirtual 606	java/lang/String:getBytes	()[B
    //   371: ldc_w 608
    //   374: invokespecial 611	java/lang/String:<init>	([BLjava/lang/String;)V
    //   377: invokestatic 616	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   380: astore 4
    //   382: aload 4
    //   384: astore_1
    //   385: aload_1
    //   386: astore 4
    //   388: aload_2
    //   389: astore_3
    //   390: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   393: ifeq +34 -> 427
    //   396: aload_2
    //   397: astore_3
    //   398: ldc 93
    //   400: iconst_2
    //   401: new 95	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   408: ldc_w 618
    //   411: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload_1
    //   415: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokestatic 149	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   424: aload_1
    //   425: astore 4
    //   427: aload 4
    //   429: astore_3
    //   430: aload_2
    //   431: ifnull +12 -> 443
    //   434: aload_2
    //   435: invokeinterface 621 1 0
    //   440: aload 4
    //   442: astore_3
    //   443: aload 12
    //   445: ldc_w 623
    //   448: aload_3
    //   449: invokevirtual 313	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   452: pop
    //   453: iload 9
    //   455: ifeq +566 -> 1021
    //   458: aload_0
    //   459: aload 5
    //   461: invokespecial 487	com/tencent/mobileqq/jsp/DataApiPlugin:a	(Ljava/lang/String;)V
    //   464: aload 5
    //   466: invokestatic 91	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;)Ljava/lang/String;
    //   469: astore_1
    //   470: aload_0
    //   471: getfield 121	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   474: ifnonnull +18 -> 492
    //   477: aload_0
    //   478: invokestatic 71	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   481: putfield 121	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   484: aload_0
    //   485: getfield 121	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   488: iconst_1
    //   489: invokevirtual 125	com/tencent/smtt/sdk/CookieManager:setAcceptCookie	(Z)V
    //   492: aload 14
    //   494: aload 15
    //   496: invokeinterface 626 2 0
    //   501: astore_2
    //   502: aload 12
    //   504: ldc_w 356
    //   507: aload_2
    //   508: invokevirtual 313	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   511: pop
    //   512: aload_2
    //   513: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   516: ifne +89 -> 605
    //   519: ldc_w 486
    //   522: iconst_2
    //   523: anewarray 129	java/lang/Object
    //   526: dup
    //   527: iconst_0
    //   528: aload_2
    //   529: aastore
    //   530: dup
    //   531: iconst_1
    //   532: aload_1
    //   533: aastore
    //   534: invokestatic 135	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   537: astore_1
    //   538: aload_0
    //   539: getfield 121	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   542: aload 5
    //   544: aload_1
    //   545: invokevirtual 139	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   548: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   551: ifeq +54 -> 605
    //   554: ldc 93
    //   556: iconst_2
    //   557: new 95	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   564: ldc_w 628
    //   567: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: aload_1
    //   571: iconst_0
    //   572: anewarray 79	java/lang/String
    //   575: invokestatic 110	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   578: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: ldc_w 630
    //   584: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload 5
    //   589: iconst_0
    //   590: anewarray 79	java/lang/String
    //   593: invokestatic 105	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   596: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   605: aload 18
    //   607: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   610: ifne +144 -> 754
    //   613: aload_0
    //   614: aload 5
    //   616: aload 18
    //   618: invokespecial 512	com/tencent/mobileqq/jsp/DataApiPlugin:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   621: aload 14
    //   623: aload 15
    //   625: aload 18
    //   627: invokeinterface 634 3 0
    //   632: astore_1
    //   633: aload_1
    //   634: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   637: ifne +117 -> 754
    //   640: aload 12
    //   642: ldc_w 636
    //   645: aload_1
    //   646: invokevirtual 313	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   649: pop
    //   650: new 95	java/lang/StringBuilder
    //   653: dup
    //   654: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   657: ldc_w 505
    //   660: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: aload_1
    //   664: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: ldc_w 507
    //   670: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload 18
    //   675: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: bipush 59
    //   680: invokevirtual 510	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   683: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   686: astore_1
    //   687: aload_0
    //   688: getfield 121	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   691: aload 5
    //   693: aload_1
    //   694: invokevirtual 139	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   697: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   700: ifeq +54 -> 754
    //   703: ldc 93
    //   705: iconst_2
    //   706: new 95	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   713: ldc_w 628
    //   716: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: aload_1
    //   720: iconst_0
    //   721: anewarray 79	java/lang/String
    //   724: invokestatic 110	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   727: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: ldc_w 630
    //   733: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: aload 5
    //   738: iconst_0
    //   739: anewarray 79	java/lang/String
    //   742: invokestatic 105	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   745: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   754: aload 16
    //   756: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   759: ifne +132 -> 891
    //   762: aload 17
    //   764: aload 16
    //   766: invokestatic 638	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:b	(Lmqq/app/AppRuntime;Ljava/lang/String;)Ljava/lang/String;
    //   769: astore_1
    //   770: aload_1
    //   771: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   774: ifne +117 -> 891
    //   777: aload 12
    //   779: ldc_w 397
    //   782: aload_1
    //   783: invokevirtual 313	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   786: pop
    //   787: new 95	java/lang/StringBuilder
    //   790: dup
    //   791: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   794: ldc_w 521
    //   797: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: aload_1
    //   801: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: ldc_w 507
    //   807: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: aload 16
    //   812: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: bipush 59
    //   817: invokevirtual 510	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   820: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   823: astore_1
    //   824: aload_0
    //   825: getfield 121	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   828: aload 5
    //   830: aload_1
    //   831: invokevirtual 139	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   834: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   837: ifeq +54 -> 891
    //   840: ldc 93
    //   842: iconst_2
    //   843: new 95	java/lang/StringBuilder
    //   846: dup
    //   847: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   850: ldc_w 628
    //   853: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: aload_1
    //   857: iconst_0
    //   858: anewarray 79	java/lang/String
    //   861: invokestatic 110	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   864: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: ldc_w 630
    //   870: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: aload 5
    //   875: iconst_0
    //   876: anewarray 79	java/lang/String
    //   879: invokestatic 105	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   882: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   888: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   891: aload 13
    //   893: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   896: ifne +125 -> 1021
    //   899: aload 14
    //   901: aload 15
    //   903: invokeinterface 641 2 0
    //   908: astore_1
    //   909: aload_1
    //   910: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   913: ifne +108 -> 1021
    //   916: new 95	java/lang/StringBuilder
    //   919: dup
    //   920: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   923: ldc_w 643
    //   926: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   929: aload_1
    //   930: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: ldc_w 507
    //   936: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: aload 13
    //   941: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: ldc_w 645
    //   947: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   953: astore_1
    //   954: aload_0
    //   955: getfield 121	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentSmttSdkCookieManager	Lcom/tencent/smtt/sdk/CookieManager;
    //   958: aload 5
    //   960: aload_1
    //   961: invokevirtual 139	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   964: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   967: ifeq +54 -> 1021
    //   970: ldc 93
    //   972: iconst_2
    //   973: new 95	java/lang/StringBuilder
    //   976: dup
    //   977: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   980: ldc_w 628
    //   983: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: aload_1
    //   987: iconst_0
    //   988: anewarray 79	java/lang/String
    //   991: invokestatic 110	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   994: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   997: ldc_w 630
    //   1000: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: aload 5
    //   1005: iconst_0
    //   1006: anewarray 79	java/lang/String
    //   1009: invokestatic 105	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   1012: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1015: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1018: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1021: aload 11
    //   1023: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1026: ifne +21 -> 1047
    //   1029: aload_0
    //   1030: aload 11
    //   1032: iconst_1
    //   1033: anewarray 79	java/lang/String
    //   1036: dup
    //   1037: iconst_0
    //   1038: aload 12
    //   1040: invokevirtual 314	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1043: aastore
    //   1044: invokevirtual 235	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1047: iconst_1
    //   1048: ireturn
    //   1049: astore 4
    //   1051: aconst_null
    //   1052: astore_2
    //   1053: aload_2
    //   1054: astore_3
    //   1055: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1058: ifeq +35 -> 1093
    //   1061: aload_2
    //   1062: astore_3
    //   1063: ldc 93
    //   1065: iconst_2
    //   1066: new 95	java/lang/StringBuilder
    //   1069: dup
    //   1070: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1073: ldc_w 647
    //   1076: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1079: aload 4
    //   1081: invokestatic 651	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1084: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1090: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1093: aload_1
    //   1094: astore_3
    //   1095: aload_2
    //   1096: ifnull -653 -> 443
    //   1099: aload_2
    //   1100: invokeinterface 621 1 0
    //   1105: aload_1
    //   1106: astore_3
    //   1107: goto -664 -> 443
    //   1110: astore_1
    //   1111: aload_1
    //   1112: invokevirtual 654	org/json/JSONException:printStackTrace	()V
    //   1115: goto -68 -> 1047
    //   1118: astore_1
    //   1119: aconst_null
    //   1120: astore_3
    //   1121: aload_3
    //   1122: ifnull +9 -> 1131
    //   1125: aload_3
    //   1126: invokeinterface 621 1 0
    //   1131: aload_1
    //   1132: athrow
    //   1133: ldc_w 656
    //   1136: aload 4
    //   1138: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1141: ifeq +35 -> 1176
    //   1144: new 658	com/tencent/mobileqq/jsp/DataApiPlugin$2
    //   1147: dup
    //   1148: aload_0
    //   1149: aload 5
    //   1151: iconst_0
    //   1152: aaload
    //   1153: aload_0
    //   1154: getfield 44	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1157: invokevirtual 528	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1160: invokevirtual 533	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   1163: invokespecial 661	com/tencent/mobileqq/jsp/DataApiPlugin$2:<init>	(Lcom/tencent/mobileqq/jsp/DataApiPlugin;Ljava/lang/String;Ljava/lang/String;)V
    //   1166: bipush 8
    //   1168: aconst_null
    //   1169: iconst_1
    //   1170: invokestatic 667	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1173: goto -126 -> 1047
    //   1176: ldc_w 669
    //   1179: aload 4
    //   1181: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1184: ifeq +259 -> 1443
    //   1187: aload_0
    //   1188: getfield 44	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1191: invokevirtual 672	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1194: invokevirtual 678	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   1197: astore_1
    //   1198: aload_1
    //   1199: ldc_w 680
    //   1202: iconst_m1
    //   1203: invokevirtual 686	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1206: istore 6
    //   1208: new 166	org/json/JSONObject
    //   1211: dup
    //   1212: invokespecial 296	org/json/JSONObject:<init>	()V
    //   1215: astore_2
    //   1216: aload_0
    //   1217: getfield 44	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1220: invokevirtual 49	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1223: invokevirtual 65	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1226: astore_3
    //   1227: new 166	org/json/JSONObject
    //   1230: dup
    //   1231: aload 5
    //   1233: iconst_0
    //   1234: aaload
    //   1235: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1238: ldc 227
    //   1240: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1243: astore 4
    //   1245: aload_2
    //   1246: ldc 131
    //   1248: aload_3
    //   1249: invokevirtual 313	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1252: pop
    //   1253: iload 6
    //   1255: iconst_m1
    //   1256: if_icmpne +62 -> 1318
    //   1259: aload_2
    //   1260: ldc_w 688
    //   1263: ldc_w 690
    //   1266: invokevirtual 313	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1269: pop
    //   1270: aload 4
    //   1272: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1275: ifne -228 -> 1047
    //   1278: aload_0
    //   1279: aload 4
    //   1281: iconst_1
    //   1282: anewarray 79	java/lang/String
    //   1285: dup
    //   1286: iconst_0
    //   1287: aload_2
    //   1288: invokevirtual 314	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1291: aastore
    //   1292: invokevirtual 235	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1295: goto -248 -> 1047
    //   1298: astore_1
    //   1299: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1302: ifeq -255 -> 1047
    //   1305: ldc 93
    //   1307: iconst_2
    //   1308: ldc_w 692
    //   1311: aload_1
    //   1312: invokestatic 696	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1315: goto -268 -> 1047
    //   1318: iload 6
    //   1320: iconst_1
    //   1321: if_icmpne +47 -> 1368
    //   1324: aload_2
    //   1325: ldc_w 698
    //   1328: aload_1
    //   1329: ldc_w 700
    //   1332: invokevirtual 703	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1335: invokevirtual 313	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1338: pop
    //   1339: aload_2
    //   1340: ldc_w 688
    //   1343: ldc_w 705
    //   1346: invokevirtual 313	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1349: pop
    //   1350: aload_2
    //   1351: ldc_w 707
    //   1354: aload_1
    //   1355: ldc_w 709
    //   1358: invokevirtual 703	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1361: invokevirtual 313	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1364: pop
    //   1365: goto -95 -> 1270
    //   1368: iload 6
    //   1370: sipush 3000
    //   1373: if_icmpne +32 -> 1405
    //   1376: aload_2
    //   1377: ldc_w 711
    //   1380: aload_1
    //   1381: ldc_w 711
    //   1384: invokevirtual 703	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1387: invokevirtual 313	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1390: pop
    //   1391: aload_2
    //   1392: ldc_w 688
    //   1395: ldc_w 713
    //   1398: invokevirtual 313	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1401: pop
    //   1402: goto -52 -> 1350
    //   1405: aload_1
    //   1406: ldc_w 715
    //   1409: invokevirtual 703	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1412: astore_3
    //   1413: aload_3
    //   1414: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1417: ifne +12 -> 1429
    //   1420: aload_2
    //   1421: ldc_w 715
    //   1424: aload_3
    //   1425: invokevirtual 313	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1428: pop
    //   1429: aload_2
    //   1430: ldc_w 688
    //   1433: ldc_w 717
    //   1436: invokevirtual 313	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1439: pop
    //   1440: goto -90 -> 1350
    //   1443: ldc_w 719
    //   1446: aload 4
    //   1448: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1451: ifeq +102 -> 1553
    //   1454: new 166	org/json/JSONObject
    //   1457: dup
    //   1458: aload 5
    //   1460: iconst_0
    //   1461: aaload
    //   1462: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1465: astore_2
    //   1466: aload_2
    //   1467: ldc 227
    //   1469: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1472: astore_1
    //   1473: aload_2
    //   1474: ldc 131
    //   1476: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1479: astore_2
    //   1480: aload_2
    //   1481: aload_0
    //   1482: getfield 44	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1485: invokevirtual 49	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   1488: invokevirtual 65	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1491: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1494: ifeq -447 -> 1047
    //   1497: aload_1
    //   1498: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1501: ifne -454 -> 1047
    //   1504: new 721	android/os/Bundle
    //   1507: dup
    //   1508: invokespecial 722	android/os/Bundle:<init>	()V
    //   1511: astore_3
    //   1512: aload_3
    //   1513: ldc 131
    //   1515: aload_2
    //   1516: invokevirtual 725	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1519: ldc_w 727
    //   1522: aload_1
    //   1523: aload_0
    //   1524: getfield 32	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentMobileqqEmosmClient$OnRemoteRespObserver	Lcom/tencent/mobileqq/emosm/Client$OnRemoteRespObserver;
    //   1527: getfield 731	com/tencent/mobileqq/emosm/Client$OnRemoteRespObserver:key	I
    //   1530: aload_3
    //   1531: invokestatic 736	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   1534: astore_1
    //   1535: invokestatic 741	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   1538: aload_1
    //   1539: invokevirtual 744	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	(Landroid/os/Bundle;)V
    //   1542: goto -495 -> 1047
    //   1545: astore_1
    //   1546: aload_1
    //   1547: invokevirtual 654	org/json/JSONException:printStackTrace	()V
    //   1550: goto -503 -> 1047
    //   1553: ldc_w 746
    //   1556: aload 4
    //   1558: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1561: ifeq +137 -> 1698
    //   1564: aload 5
    //   1566: arraylength
    //   1567: iconst_1
    //   1568: if_icmpne +130 -> 1698
    //   1571: new 166	org/json/JSONObject
    //   1574: dup
    //   1575: aload 5
    //   1577: iconst_0
    //   1578: aaload
    //   1579: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1582: astore_1
    //   1583: aload_1
    //   1584: ldc 227
    //   1586: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1589: astore_2
    //   1590: aload_2
    //   1591: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1594: ifne -547 -> 1047
    //   1597: ldc_w 748
    //   1600: aload_1
    //   1601: ldc_w 344
    //   1604: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1607: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1610: ifeq +23 -> 1633
    //   1613: aload_0
    //   1614: aload_2
    //   1615: iconst_1
    //   1616: anewarray 79	java/lang/String
    //   1619: dup
    //   1620: iconst_0
    //   1621: getstatic 753	com/tencent/mobileqq/activity/QQBrowserActivity:sQQBrowserActivityCounter	I
    //   1624: invokestatic 755	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1627: aastore
    //   1628: invokevirtual 235	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1631: iconst_1
    //   1632: ireturn
    //   1633: aconst_null
    //   1634: astore_1
    //   1635: aload_0
    //   1636: getfield 44	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1639: invokevirtual 672	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1642: astore_3
    //   1643: aload_3
    //   1644: ifnull +14 -> 1658
    //   1647: aload_3
    //   1648: invokevirtual 678	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   1651: ldc_w 757
    //   1654: invokevirtual 703	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1657: astore_1
    //   1658: aload_1
    //   1659: ifnonnull +31 -> 1690
    //   1662: ldc_w 759
    //   1665: astore_1
    //   1666: aload_0
    //   1667: aload_2
    //   1668: iconst_1
    //   1669: anewarray 79	java/lang/String
    //   1672: dup
    //   1673: iconst_0
    //   1674: aload_1
    //   1675: aastore
    //   1676: invokevirtual 235	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1679: goto -632 -> 1047
    //   1682: astore_1
    //   1683: aload_1
    //   1684: invokevirtual 654	org/json/JSONException:printStackTrace	()V
    //   1687: goto -640 -> 1047
    //   1690: aload_1
    //   1691: invokestatic 760	com/tencent/biz/common/util/Util:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1694: astore_1
    //   1695: goto -29 -> 1666
    //   1698: ldc_w 762
    //   1701: aload 4
    //   1703: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1706: ifeq +126 -> 1832
    //   1709: aload 5
    //   1711: arraylength
    //   1712: iconst_1
    //   1713: if_icmpne +119 -> 1832
    //   1716: new 166	org/json/JSONObject
    //   1719: dup
    //   1720: aload 5
    //   1722: iconst_0
    //   1723: aaload
    //   1724: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1727: astore_1
    //   1728: aload_1
    //   1729: ldc_w 764
    //   1732: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1735: astore_2
    //   1736: aload_1
    //   1737: ldc 227
    //   1739: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1742: astore_1
    //   1743: aload_2
    //   1744: ifnonnull +3252 -> 4996
    //   1747: ldc_w 759
    //   1750: astore_2
    //   1751: invokestatic 567	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1754: ldc_w 766
    //   1757: invokevirtual 770	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1760: checkcast 772	android/text/ClipboardManager
    //   1763: astore_3
    //   1764: aload_3
    //   1765: ifnull +32 -> 1797
    //   1768: aload_3
    //   1769: aload_2
    //   1770: invokevirtual 776	android/text/ClipboardManager:setText	(Ljava/lang/CharSequence;)V
    //   1773: aload_1
    //   1774: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1777: ifne +18 -> 1795
    //   1780: aload_0
    //   1781: aload_1
    //   1782: iconst_1
    //   1783: anewarray 79	java/lang/String
    //   1786: dup
    //   1787: iconst_0
    //   1788: ldc_w 778
    //   1791: aastore
    //   1792: invokevirtual 235	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1795: iconst_1
    //   1796: ireturn
    //   1797: aload_1
    //   1798: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1801: ifne -754 -> 1047
    //   1804: aload_0
    //   1805: aload_1
    //   1806: iconst_1
    //   1807: anewarray 79	java/lang/String
    //   1810: dup
    //   1811: iconst_0
    //   1812: ldc_w 780
    //   1815: aastore
    //   1816: invokevirtual 235	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1819: goto -772 -> 1047
    //   1822: astore_2
    //   1823: aconst_null
    //   1824: astore_1
    //   1825: aload_2
    //   1826: invokevirtual 654	org/json/JSONException:printStackTrace	()V
    //   1829: goto -32 -> 1797
    //   1832: ldc_w 782
    //   1835: aload 4
    //   1837: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1840: ifeq +123 -> 1963
    //   1843: aload 5
    //   1845: arraylength
    //   1846: iconst_1
    //   1847: if_icmpne +116 -> 1963
    //   1850: new 166	org/json/JSONObject
    //   1853: dup
    //   1854: aload 5
    //   1856: iconst_0
    //   1857: aaload
    //   1858: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1861: ldc 227
    //   1863: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1866: astore_2
    //   1867: aload_2
    //   1868: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1871: ifne -824 -> 1047
    //   1874: invokestatic 567	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1877: ldc_w 766
    //   1880: invokevirtual 770	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1883: checkcast 772	android/text/ClipboardManager
    //   1886: astore_1
    //   1887: aload_1
    //   1888: ifnull +3101 -> 4989
    //   1891: aload_1
    //   1892: invokevirtual 786	android/text/ClipboardManager:getText	()Ljava/lang/CharSequence;
    //   1895: astore_1
    //   1896: aload_1
    //   1897: ifnull +3092 -> 4989
    //   1900: aload_1
    //   1901: invokeinterface 789 1 0
    //   1906: astore_1
    //   1907: aload_0
    //   1908: aload_2
    //   1909: iconst_1
    //   1910: anewarray 79	java/lang/String
    //   1913: dup
    //   1914: iconst_0
    //   1915: aload_1
    //   1916: invokestatic 760	com/tencent/biz/common/util/Util:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1919: aastore
    //   1920: invokevirtual 235	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1923: goto -876 -> 1047
    //   1926: astore_1
    //   1927: ldc 93
    //   1929: iconst_1
    //   1930: new 95	java/lang/StringBuilder
    //   1933: dup
    //   1934: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   1937: ldc_w 791
    //   1940: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1943: aload_1
    //   1944: invokevirtual 351	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1947: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1950: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1953: invokestatic 119	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1956: aload_1
    //   1957: invokevirtual 792	java/lang/Exception:printStackTrace	()V
    //   1960: goto -913 -> 1047
    //   1963: ldc_w 794
    //   1966: aload 4
    //   1968: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1971: ifeq +203 -> 2174
    //   1974: aload 5
    //   1976: arraylength
    //   1977: iconst_1
    //   1978: if_icmpne +196 -> 2174
    //   1981: new 166	org/json/JSONObject
    //   1984: dup
    //   1985: aload 5
    //   1987: iconst_0
    //   1988: aaload
    //   1989: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1992: astore_1
    //   1993: aload_1
    //   1994: ldc_w 796
    //   1997: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2000: astore_2
    //   2001: aload_1
    //   2002: ldc_w 798
    //   2005: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2008: astore_3
    //   2009: aload_1
    //   2010: ldc_w 800
    //   2013: iconst_1
    //   2014: invokevirtual 804	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2017: istore 9
    //   2019: aload_1
    //   2020: ldc 227
    //   2022: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2025: astore 4
    //   2027: new 166	org/json/JSONObject
    //   2030: dup
    //   2031: invokespecial 296	org/json/JSONObject:<init>	()V
    //   2034: astore 5
    //   2036: aload_2
    //   2037: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2040: ifne +109 -> 2149
    //   2043: aload_3
    //   2044: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2047: ifne +102 -> 2149
    //   2050: aload_0
    //   2051: getfield 44	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2054: invokevirtual 49	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   2057: astore_1
    //   2058: aload_1
    //   2059: instanceof 806
    //   2062: ifeq +2922 -> 4984
    //   2065: aload_1
    //   2066: checkcast 806	com/tencent/mobileqq/app/QQAppInterface
    //   2069: astore_1
    //   2070: aload_1
    //   2071: aload_2
    //   2072: aload_3
    //   2073: iload 9
    //   2075: invokestatic 811	com/tencent/mobileqq/statistics/DcReportUtil:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2078: aload 5
    //   2080: ldc_w 298
    //   2083: iconst_0
    //   2084: invokevirtual 302	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2087: pop
    //   2088: aload 5
    //   2090: ldc_w 304
    //   2093: ldc_w 813
    //   2096: invokevirtual 313	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2099: pop
    //   2100: aload 4
    //   2102: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2105: ifne -1058 -> 1047
    //   2108: aload_0
    //   2109: aload 4
    //   2111: iconst_1
    //   2112: anewarray 79	java/lang/String
    //   2115: dup
    //   2116: iconst_0
    //   2117: aload 5
    //   2119: invokevirtual 314	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2122: aastore
    //   2123: invokevirtual 235	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2126: goto -1079 -> 1047
    //   2129: astore_1
    //   2130: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2133: ifeq -1086 -> 1047
    //   2136: ldc 93
    //   2138: iconst_2
    //   2139: aload_1
    //   2140: invokevirtual 351	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2143: invokestatic 815	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2146: goto -1099 -> 1047
    //   2149: aload 5
    //   2151: ldc_w 298
    //   2154: iconst_m1
    //   2155: invokevirtual 302	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2158: pop
    //   2159: aload 5
    //   2161: ldc_w 304
    //   2164: ldc_w 817
    //   2167: invokevirtual 313	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2170: pop
    //   2171: goto -71 -> 2100
    //   2174: ldc_w 819
    //   2177: aload 4
    //   2179: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2182: ifeq +473 -> 2655
    //   2185: aload 5
    //   2187: arraylength
    //   2188: iconst_1
    //   2189: if_icmpne +466 -> 2655
    //   2192: new 166	org/json/JSONObject
    //   2195: dup
    //   2196: aload 5
    //   2198: iconst_0
    //   2199: aaload
    //   2200: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2203: astore_1
    //   2204: aload_1
    //   2205: ldc_w 821
    //   2208: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2211: astore_3
    //   2212: aload_1
    //   2213: ldc_w 823
    //   2216: invokevirtual 172	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2219: astore_1
    //   2220: aload_0
    //   2221: getfield 44	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2224: invokevirtual 49	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   2227: astore_2
    //   2228: ldc_w 825
    //   2231: aload_3
    //   2232: invokevirtual 828	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2235: ifeq +232 -> 2467
    //   2238: aload_1
    //   2239: ldc_w 830
    //   2242: ldc_w 759
    //   2245: invokevirtual 832	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2248: astore_3
    //   2249: aload_1
    //   2250: ldc_w 834
    //   2253: invokevirtual 836	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2256: astore 4
    //   2258: aload_1
    //   2259: ldc_w 838
    //   2262: invokevirtual 836	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2265: astore 5
    //   2267: aload_1
    //   2268: ldc_w 840
    //   2271: invokevirtual 836	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2274: astore 11
    //   2276: aload_1
    //   2277: ldc_w 842
    //   2280: ldc_w 759
    //   2283: invokevirtual 832	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2286: astore 12
    //   2288: aload_1
    //   2289: ldc_w 844
    //   2292: iconst_0
    //   2293: invokevirtual 847	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2296: istore 6
    //   2298: aload_1
    //   2299: ldc_w 849
    //   2302: iconst_1
    //   2303: invokevirtual 847	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2306: istore 7
    //   2308: aload_1
    //   2309: ldc_w 851
    //   2312: iconst_0
    //   2313: invokevirtual 847	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2316: istore 8
    //   2318: aload_1
    //   2319: ldc_w 853
    //   2322: ldc_w 759
    //   2325: invokevirtual 832	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2328: astore 13
    //   2330: aload_1
    //   2331: ldc_w 855
    //   2334: ldc_w 759
    //   2337: invokevirtual 832	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2340: astore 14
    //   2342: aload_1
    //   2343: ldc_w 857
    //   2346: ldc_w 759
    //   2349: invokevirtual 832	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2352: astore 15
    //   2354: aload_1
    //   2355: ldc_w 859
    //   2358: ldc_w 759
    //   2361: invokevirtual 832	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2364: astore 16
    //   2366: aconst_null
    //   2367: astore_1
    //   2368: aload_2
    //   2369: instanceof 806
    //   2372: ifeq +8 -> 2380
    //   2375: aload_2
    //   2376: checkcast 806	com/tencent/mobileqq/app/QQAppInterface
    //   2379: astore_1
    //   2380: aload_2
    //   2381: invokevirtual 61	com/tencent/common/app/AppInterface:isLogin	()Z
    //   2384: ifeq +53 -> 2437
    //   2387: aload_1
    //   2388: aload 4
    //   2390: aload_3
    //   2391: aload 12
    //   2393: aload 5
    //   2395: aload 11
    //   2397: iload 6
    //   2399: iload 7
    //   2401: iload 8
    //   2403: aload 13
    //   2405: aload 14
    //   2407: aload 15
    //   2409: aload 16
    //   2411: invokestatic 864	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2414: goto -1367 -> 1047
    //   2417: astore_1
    //   2418: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2421: ifeq -1374 -> 1047
    //   2424: ldc 93
    //   2426: iconst_2
    //   2427: aload_1
    //   2428: invokevirtual 865	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2431: invokestatic 815	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2434: goto -1387 -> 1047
    //   2437: aload_1
    //   2438: aload 4
    //   2440: aload_3
    //   2441: aload 12
    //   2443: aload 5
    //   2445: aload 11
    //   2447: iload 6
    //   2449: iload 7
    //   2451: iload 8
    //   2453: aload 13
    //   2455: aload 14
    //   2457: aload 15
    //   2459: aload 16
    //   2461: invokestatic 867	com/tencent/mobileqq/statistics/ReportController:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2464: goto -1417 -> 1047
    //   2467: ldc_w 869
    //   2470: aload_3
    //   2471: invokevirtual 828	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2474: ifeq +163 -> 2637
    //   2477: aload_1
    //   2478: ldc_w 871
    //   2481: invokevirtual 836	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2484: astore_3
    //   2485: aload_1
    //   2486: ldc_w 873
    //   2489: iconst_1
    //   2490: invokevirtual 804	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2493: istore 9
    //   2495: aload_1
    //   2496: ldc_w 875
    //   2499: iconst_1
    //   2500: invokevirtual 804	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2503: istore 10
    //   2505: aload_1
    //   2506: ldc_w 877
    //   2509: iconst_0
    //   2510: invokevirtual 847	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2513: istore 6
    //   2515: aload_1
    //   2516: ldc_w 879
    //   2519: iconst_0
    //   2520: invokevirtual 847	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2523: istore 7
    //   2525: new 881	java/util/HashMap
    //   2528: dup
    //   2529: invokespecial 882	java/util/HashMap:<init>	()V
    //   2532: astore 4
    //   2534: aload_1
    //   2535: ldc_w 884
    //   2538: invokevirtual 887	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2541: astore_1
    //   2542: aload_1
    //   2543: ifnull +53 -> 2596
    //   2546: aload_1
    //   2547: invokevirtual 891	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   2550: astore 5
    //   2552: aload 5
    //   2554: ifnull +42 -> 2596
    //   2557: aload 5
    //   2559: invokeinterface 896 1 0
    //   2564: ifeq +32 -> 2596
    //   2567: aload 5
    //   2569: invokeinterface 900 1 0
    //   2574: checkcast 79	java/lang/String
    //   2577: astore 11
    //   2579: aload 4
    //   2581: aload 11
    //   2583: aload_1
    //   2584: aload 11
    //   2586: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2589: invokevirtual 903	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2592: pop
    //   2593: goto -41 -> 2552
    //   2596: aconst_null
    //   2597: astore_1
    //   2598: aload_2
    //   2599: invokevirtual 61	com/tencent/common/app/AppInterface:isLogin	()Z
    //   2602: ifeq +8 -> 2610
    //   2605: aload_2
    //   2606: invokevirtual 65	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   2609: astore_1
    //   2610: aconst_null
    //   2611: invokestatic 908	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2614: aload_1
    //   2615: aload_3
    //   2616: iload 10
    //   2618: iload 6
    //   2620: i2l
    //   2621: iload 7
    //   2623: i2l
    //   2624: aload 4
    //   2626: ldc_w 759
    //   2629: iload 9
    //   2631: invokevirtual 912	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   2634: goto -1587 -> 1047
    //   2637: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2640: ifeq -1593 -> 1047
    //   2643: ldc 93
    //   2645: iconst_2
    //   2646: ldc_w 914
    //   2649: invokestatic 815	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2652: goto -1605 -> 1047
    //   2655: ldc_w 916
    //   2658: aload 4
    //   2660: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2663: ifeq +175 -> 2838
    //   2666: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2669: ifeq +12 -> 2681
    //   2672: ldc 93
    //   2674: iconst_2
    //   2675: ldc_w 916
    //   2678: invokestatic 149	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2681: new 166	org/json/JSONObject
    //   2684: dup
    //   2685: aload 5
    //   2687: iconst_0
    //   2688: aaload
    //   2689: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2692: astore_2
    //   2693: aload_2
    //   2694: ldc 227
    //   2696: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2699: astore_1
    //   2700: aload_2
    //   2701: ldc 131
    //   2703: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2706: astore_2
    //   2707: aload_1
    //   2708: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2711: ifne +109 -> 2820
    //   2714: new 721	android/os/Bundle
    //   2717: dup
    //   2718: invokespecial 722	android/os/Bundle:<init>	()V
    //   2721: astore_3
    //   2722: aload_2
    //   2723: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2726: ifne +75 -> 2801
    //   2729: aload_3
    //   2730: ldc 131
    //   2732: aload_2
    //   2733: invokevirtual 725	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2736: ldc_w 918
    //   2739: aload_1
    //   2740: aload_0
    //   2741: getfield 32	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentMobileqqEmosmClient$OnRemoteRespObserver	Lcom/tencent/mobileqq/emosm/Client$OnRemoteRespObserver;
    //   2744: getfield 731	com/tencent/mobileqq/emosm/Client$OnRemoteRespObserver:key	I
    //   2747: aload_3
    //   2748: invokestatic 736	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   2751: astore_1
    //   2752: invokestatic 741	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   2755: aload_1
    //   2756: invokevirtual 744	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	(Landroid/os/Bundle;)V
    //   2759: goto -1712 -> 1047
    //   2762: astore_1
    //   2763: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2766: ifeq -1719 -> 1047
    //   2769: ldc 93
    //   2771: iconst_2
    //   2772: new 95	java/lang/StringBuilder
    //   2775: dup
    //   2776: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2779: ldc_w 920
    //   2782: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2785: aload_1
    //   2786: invokevirtual 865	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2789: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2792: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2795: invokestatic 815	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2798: goto -1751 -> 1047
    //   2801: aload_3
    //   2802: ldc 131
    //   2804: aload_0
    //   2805: getfield 44	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2808: invokevirtual 49	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   2811: invokevirtual 65	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   2814: invokevirtual 725	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2817: goto -81 -> 2736
    //   2820: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2823: ifeq -1776 -> 1047
    //   2826: ldc 93
    //   2828: iconst_2
    //   2829: ldc_w 922
    //   2832: invokestatic 149	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2835: goto -1788 -> 1047
    //   2838: ldc_w 924
    //   2841: aload 4
    //   2843: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2846: ifeq +116 -> 2962
    //   2849: aload 5
    //   2851: arraylength
    //   2852: iconst_1
    //   2853: if_icmpne +109 -> 2962
    //   2856: new 166	org/json/JSONObject
    //   2859: dup
    //   2860: aload 5
    //   2862: iconst_0
    //   2863: aaload
    //   2864: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2867: ldc 227
    //   2869: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2872: astore_1
    //   2873: aload_1
    //   2874: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2877: ifne -1830 -> 1047
    //   2880: aload_0
    //   2881: aload_1
    //   2882: iconst_1
    //   2883: anewarray 79	java/lang/String
    //   2886: dup
    //   2887: iconst_0
    //   2888: new 95	java/lang/StringBuilder
    //   2891: dup
    //   2892: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2895: ldc_w 926
    //   2898: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2901: invokestatic 930	com/tencent/common/config/AppSetting:a	()I
    //   2904: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2907: ldc_w 932
    //   2910: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2913: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2916: aastore
    //   2917: invokevirtual 235	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2920: goto -1873 -> 1047
    //   2923: astore_1
    //   2924: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2927: ifeq -1880 -> 1047
    //   2930: ldc 93
    //   2932: iconst_2
    //   2933: new 95	java/lang/StringBuilder
    //   2936: dup
    //   2937: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   2940: ldc_w 934
    //   2943: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2946: aload_1
    //   2947: invokevirtual 865	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2950: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2953: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2956: invokestatic 815	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2959: goto -1912 -> 1047
    //   2962: ldc_w 936
    //   2965: aload 4
    //   2967: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2970: ifeq +521 -> 3491
    //   2973: aload 5
    //   2975: arraylength
    //   2976: iconst_1
    //   2977: if_icmpne +514 -> 3491
    //   2980: new 166	org/json/JSONObject
    //   2983: dup
    //   2984: aload 5
    //   2986: iconst_0
    //   2987: aaload
    //   2988: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2991: astore_1
    //   2992: aload_1
    //   2993: ldc 227
    //   2995: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2998: astore_3
    //   2999: aload_1
    //   3000: ldc_w 938
    //   3003: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3006: astore_1
    //   3007: aload_1
    //   3008: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3011: ifne +1967 -> 4978
    //   3014: aload_1
    //   3015: invokevirtual 941	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   3018: astore 4
    //   3020: aload_0
    //   3021: getfield 44	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3024: invokevirtual 49	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/common/app/AppInterface;
    //   3027: astore_2
    //   3028: aload_2
    //   3029: ifnull +1949 -> 4978
    //   3032: aload_2
    //   3033: invokevirtual 61	com/tencent/common/app/AppInterface:isLogin	()Z
    //   3036: ifeq +1942 -> 4978
    //   3039: aload_2
    //   3040: invokevirtual 65	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   3043: astore_1
    //   3044: aload_2
    //   3045: iconst_2
    //   3046: invokevirtual 549	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3049: checkcast 551	mqq/manager/TicketManager
    //   3052: astore_2
    //   3053: aload_2
    //   3054: aload_1
    //   3055: aload 4
    //   3057: invokeinterface 634 3 0
    //   3062: astore 13
    //   3064: aload_2
    //   3065: aload_1
    //   3066: aload 4
    //   3068: invokeinterface 944 3 0
    //   3073: astore 5
    //   3075: aload 13
    //   3077: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3080: ifne +1898 -> 4978
    //   3083: new 95	java/lang/StringBuilder
    //   3086: dup
    //   3087: bipush 111
    //   3089: invokespecial 946	java/lang/StringBuilder:<init>	(I)V
    //   3092: astore_2
    //   3093: aload_1
    //   3094: invokevirtual 949	java/lang/String:length	()I
    //   3097: bipush 10
    //   3099: if_icmpge +32 -> 3131
    //   3102: aload_1
    //   3103: invokevirtual 949	java/lang/String:length	()I
    //   3106: istore 6
    //   3108: iload 6
    //   3110: bipush 10
    //   3112: if_icmpge +19 -> 3131
    //   3115: aload_2
    //   3116: bipush 48
    //   3118: invokevirtual 510	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3121: pop
    //   3122: iload 6
    //   3124: iconst_1
    //   3125: iadd
    //   3126: istore 6
    //   3128: goto -20 -> 3108
    //   3131: aload_2
    //   3132: aload_1
    //   3133: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3136: pop
    //   3137: invokestatic 71	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   3140: astore 11
    //   3142: aload 11
    //   3144: iconst_1
    //   3145: invokevirtual 125	com/tencent/smtt/sdk/CookieManager:setAcceptCookie	(Z)V
    //   3148: new 95	java/lang/StringBuilder
    //   3151: dup
    //   3152: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3155: ldc_w 951
    //   3158: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3161: aload 4
    //   3163: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3166: bipush 47
    //   3168: invokevirtual 510	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3171: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3174: astore 12
    //   3176: new 95	java/lang/StringBuilder
    //   3179: dup
    //   3180: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3183: ldc_w 273
    //   3186: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3189: aload_2
    //   3190: invokevirtual 954	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   3193: ldc_w 507
    //   3196: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3199: aload 4
    //   3201: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3204: bipush 59
    //   3206: invokevirtual 510	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3209: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3212: astore 14
    //   3214: aload 11
    //   3216: aload 12
    //   3218: aload 14
    //   3220: invokevirtual 139	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   3223: ldc_w 759
    //   3226: astore_1
    //   3227: ldc_w 759
    //   3230: astore_2
    //   3231: aload 13
    //   3233: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3236: ifne +49 -> 3285
    //   3239: new 95	java/lang/StringBuilder
    //   3242: dup
    //   3243: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3246: ldc_w 505
    //   3249: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3252: aload 13
    //   3254: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3257: ldc_w 507
    //   3260: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3263: aload 4
    //   3265: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3268: bipush 59
    //   3270: invokevirtual 510	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3273: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3276: astore_1
    //   3277: aload 11
    //   3279: aload 12
    //   3281: aload_1
    //   3282: invokevirtual 139	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   3285: aload 5
    //   3287: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3290: ifne +49 -> 3339
    //   3293: new 95	java/lang/StringBuilder
    //   3296: dup
    //   3297: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3300: ldc_w 521
    //   3303: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3306: aload 5
    //   3308: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3311: ldc_w 507
    //   3314: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3317: aload 4
    //   3319: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3322: bipush 59
    //   3324: invokevirtual 510	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3327: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3330: astore_2
    //   3331: aload 11
    //   3333: aload 12
    //   3335: aload_2
    //   3336: invokevirtual 139	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   3339: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3342: ifeq +1674 -> 5016
    //   3345: ldc 93
    //   3347: iconst_2
    //   3348: new 95	java/lang/StringBuilder
    //   3351: dup
    //   3352: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3355: ldc_w 628
    //   3358: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3361: aload 14
    //   3363: iconst_0
    //   3364: anewarray 79	java/lang/String
    //   3367: invokestatic 110	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3370: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3373: aload_1
    //   3374: iconst_0
    //   3375: anewarray 79	java/lang/String
    //   3378: invokestatic 110	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3381: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3384: aload_2
    //   3385: iconst_0
    //   3386: anewarray 79	java/lang/String
    //   3389: invokestatic 110	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3392: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3395: ldc_w 630
    //   3398: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3401: aload 12
    //   3403: iconst_0
    //   3404: anewarray 79	java/lang/String
    //   3407: invokestatic 105	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3410: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3413: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3416: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3419: goto +1597 -> 5016
    //   3422: aload_3
    //   3423: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3426: ifne -2379 -> 1047
    //   3429: aload_0
    //   3430: aload_3
    //   3431: iconst_1
    //   3432: anewarray 79	java/lang/String
    //   3435: dup
    //   3436: iconst_0
    //   3437: new 95	java/lang/StringBuilder
    //   3440: dup
    //   3441: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3444: ldc_w 956
    //   3447: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3450: iload 6
    //   3452: invokevirtual 195	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3455: ldc_w 932
    //   3458: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3461: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3464: aastore
    //   3465: invokevirtual 235	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3468: goto -2421 -> 1047
    //   3471: astore_1
    //   3472: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3475: ifeq -2428 -> 1047
    //   3478: ldc 93
    //   3480: iconst_2
    //   3481: ldc_w 958
    //   3484: aload_1
    //   3485: invokestatic 696	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3488: goto -2441 -> 1047
    //   3491: ldc_w 960
    //   3494: aload 4
    //   3496: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3499: ifeq +13 -> 3512
    //   3502: aload_0
    //   3503: aload_2
    //   3504: aload 5
    //   3506: invokespecial 962	com/tencent/mobileqq/jsp/DataApiPlugin:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3509: goto -2462 -> 1047
    //   3512: ldc_w 964
    //   3515: aload 4
    //   3517: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3520: ifeq +137 -> 3657
    //   3523: aconst_null
    //   3524: astore_2
    //   3525: aload_2
    //   3526: astore_1
    //   3527: new 166	org/json/JSONObject
    //   3530: dup
    //   3531: aload 5
    //   3533: iconst_0
    //   3534: aaload
    //   3535: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3538: astore_3
    //   3539: aload_2
    //   3540: astore_1
    //   3541: aload_3
    //   3542: ldc 227
    //   3544: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3547: astore_2
    //   3548: aload_2
    //   3549: astore_1
    //   3550: aload_3
    //   3551: ldc 131
    //   3553: invokevirtual 836	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3556: astore_3
    //   3557: aload_2
    //   3558: astore_1
    //   3559: invokestatic 741	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   3562: invokevirtual 966	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Z
    //   3565: ifeq -2518 -> 1047
    //   3568: aload_2
    //   3569: astore_1
    //   3570: new 721	android/os/Bundle
    //   3573: dup
    //   3574: invokespecial 722	android/os/Bundle:<init>	()V
    //   3577: astore 4
    //   3579: aload_2
    //   3580: astore_1
    //   3581: aload 4
    //   3583: ldc 131
    //   3585: aload_3
    //   3586: invokevirtual 725	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3589: aload_2
    //   3590: astore_1
    //   3591: ldc_w 968
    //   3594: aload_2
    //   3595: aload_0
    //   3596: getfield 32	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentMobileqqEmosmClient$OnRemoteRespObserver	Lcom/tencent/mobileqq/emosm/Client$OnRemoteRespObserver;
    //   3599: getfield 731	com/tencent/mobileqq/emosm/Client$OnRemoteRespObserver:key	I
    //   3602: aload 4
    //   3604: invokestatic 736	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   3607: astore_3
    //   3608: aload_2
    //   3609: astore_1
    //   3610: invokestatic 741	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	()Lcom/tencent/mobileqq/emosm/web/WebIPCOperator;
    //   3613: aload_3
    //   3614: invokevirtual 744	com/tencent/mobileqq/emosm/web/WebIPCOperator:a	(Landroid/os/Bundle;)V
    //   3617: goto -2570 -> 1047
    //   3620: astore_2
    //   3621: aload_1
    //   3622: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3625: ifne -2578 -> 1047
    //   3628: aload_0
    //   3629: aload_1
    //   3630: iconst_1
    //   3631: anewarray 79	java/lang/String
    //   3634: dup
    //   3635: iconst_0
    //   3636: ldc_w 970
    //   3639: iconst_1
    //   3640: anewarray 129	java/lang/Object
    //   3643: dup
    //   3644: iconst_0
    //   3645: aload_2
    //   3646: aastore
    //   3647: invokestatic 135	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3650: aastore
    //   3651: invokevirtual 235	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3654: goto -2607 -> 1047
    //   3657: ldc_w 972
    //   3660: aload 4
    //   3662: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3665: ifeq +128 -> 3793
    //   3668: new 166	org/json/JSONObject
    //   3671: dup
    //   3672: aload 5
    //   3674: iconst_0
    //   3675: aaload
    //   3676: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3679: astore_1
    //   3680: ldc_w 974
    //   3683: aload_1
    //   3684: ldc_w 976
    //   3687: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3690: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3693: ifeq +24 -> 3717
    //   3696: aload_0
    //   3697: getfield 44	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3700: invokevirtual 672	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3703: astore_2
    //   3704: aload_2
    //   3705: ifnull +12 -> 3717
    //   3708: aload_2
    //   3709: iconst_m1
    //   3710: invokevirtual 979	android/app/Activity:setResult	(I)V
    //   3713: aload_2
    //   3714: invokevirtual 982	android/app/Activity:finish	()V
    //   3717: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3720: ifeq -2673 -> 1047
    //   3723: ldc 93
    //   3725: iconst_2
    //   3726: new 95	java/lang/StringBuilder
    //   3729: dup
    //   3730: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3733: ldc_w 984
    //   3736: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3739: aload_1
    //   3740: invokevirtual 987	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3743: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3746: invokestatic 815	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3749: goto -2702 -> 1047
    //   3752: astore_1
    //   3753: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3756: ifeq +13 -> 3769
    //   3759: ldc 93
    //   3761: iconst_2
    //   3762: ldc_w 989
    //   3765: aload_1
    //   3766: invokestatic 696	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3769: aload_0
    //   3770: getfield 44	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3773: invokevirtual 672	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   3776: astore_1
    //   3777: aload_1
    //   3778: ifnull -2731 -> 1047
    //   3781: aload_1
    //   3782: iconst_0
    //   3783: invokevirtual 979	android/app/Activity:setResult	(I)V
    //   3786: aload_1
    //   3787: invokevirtual 982	android/app/Activity:finish	()V
    //   3790: goto -2743 -> 1047
    //   3793: ldc_w 991
    //   3796: aload 4
    //   3798: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3801: ifeq +349 -> 4150
    //   3804: aload 5
    //   3806: arraylength
    //   3807: iconst_1
    //   3808: if_icmpne +342 -> 4150
    //   3811: new 166	org/json/JSONObject
    //   3814: dup
    //   3815: aload 5
    //   3817: iconst_0
    //   3818: aaload
    //   3819: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3822: astore_3
    //   3823: aload_3
    //   3824: ldc 227
    //   3826: invokevirtual 836	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3829: astore_2
    //   3830: aload_3
    //   3831: ldc_w 993
    //   3834: invokevirtual 836	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3837: astore 4
    //   3839: aload_3
    //   3840: ldc_w 938
    //   3843: invokevirtual 836	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3846: astore_1
    //   3847: aload_0
    //   3848: getfield 337	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   3851: ifnonnull +10 -> 3861
    //   3854: aload_0
    //   3855: invokestatic 342	com/tencent/biz/AuthorizeConfig:a	()Lcom/tencent/biz/AuthorizeConfig;
    //   3858: putfield 337	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   3861: iconst_0
    //   3862: istore 10
    //   3864: iload 10
    //   3866: istore 9
    //   3868: aload 4
    //   3870: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3873: ifne +71 -> 3944
    //   3876: iload 10
    //   3878: istore 9
    //   3880: aload_1
    //   3881: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3884: ifne +60 -> 3944
    //   3887: new 95	java/lang/StringBuilder
    //   3890: dup
    //   3891: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   3894: ldc_w 951
    //   3897: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3900: aload_1
    //   3901: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3904: ldc_w 995
    //   3907: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3910: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3913: astore_1
    //   3914: ldc_w 997
    //   3917: aload 4
    //   3919: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3922: ifeq +67 -> 3989
    //   3925: aload_3
    //   3926: ldc_w 999
    //   3929: invokevirtual 836	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3932: astore_3
    //   3933: aload_0
    //   3934: getfield 337	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   3937: aload_1
    //   3938: aload_3
    //   3939: invokevirtual 1002	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   3942: istore 9
    //   3944: iload 9
    //   3946: ifeq +197 -> 4143
    //   3949: ldc_w 1004
    //   3952: astore_1
    //   3953: aload_0
    //   3954: aload_2
    //   3955: iconst_1
    //   3956: anewarray 79	java/lang/String
    //   3959: dup
    //   3960: iconst_0
    //   3961: aload_1
    //   3962: aastore
    //   3963: invokevirtual 235	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3966: goto -2919 -> 1047
    //   3969: astore_1
    //   3970: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3973: ifeq -2926 -> 1047
    //   3976: ldc 93
    //   3978: iconst_2
    //   3979: ldc_w 1006
    //   3982: aload_1
    //   3983: invokestatic 696	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3986: goto -2939 -> 1047
    //   3989: ldc_w 356
    //   3992: aload 4
    //   3994: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3997: ifeq +16 -> 4013
    //   4000: aload_0
    //   4001: getfield 337	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4004: aload_1
    //   4005: invokevirtual 376	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;)Z
    //   4008: istore 9
    //   4010: goto -66 -> 3944
    //   4013: ldc_w 380
    //   4016: aload 4
    //   4018: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4021: ifeq +23 -> 4044
    //   4024: aload_0
    //   4025: getfield 337	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4028: aload_1
    //   4029: invokevirtual 382	com/tencent/biz/AuthorizeConfig:c	(Ljava/lang/String;)Ljava/lang/String;
    //   4032: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4035: ifne +987 -> 5022
    //   4038: iconst_1
    //   4039: istore 9
    //   4041: goto -97 -> 3944
    //   4044: ldc_w 1008
    //   4047: aload 4
    //   4049: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4052: ifeq +25 -> 4077
    //   4055: aload_3
    //   4056: ldc_w 1008
    //   4059: invokevirtual 836	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4062: astore_3
    //   4063: aload_0
    //   4064: getfield 337	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4067: aload_1
    //   4068: aload_3
    //   4069: invokevirtual 1010	com/tencent/biz/AuthorizeConfig:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4072: istore 9
    //   4074: goto -130 -> 3944
    //   4077: ldc_w 397
    //   4080: aload 4
    //   4082: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4085: ifeq +23 -> 4108
    //   4088: aload_0
    //   4089: getfield 337	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4092: aload_1
    //   4093: invokevirtual 399	com/tencent/biz/AuthorizeConfig:d	(Ljava/lang/String;)Ljava/lang/String;
    //   4096: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4099: ifne +929 -> 5028
    //   4102: iconst_1
    //   4103: istore 9
    //   4105: goto -161 -> 3944
    //   4108: iload 10
    //   4110: istore 9
    //   4112: ldc_w 1012
    //   4115: aload 4
    //   4117: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4120: ifeq -176 -> 3944
    //   4123: aload_0
    //   4124: getfield 337	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizAuthorizeConfig	Lcom/tencent/biz/AuthorizeConfig;
    //   4127: aload_1
    //   4128: invokevirtual 545	com/tencent/biz/AuthorizeConfig:e	(Ljava/lang/String;)Ljava/lang/String;
    //   4131: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4134: ifne +900 -> 5034
    //   4137: iconst_1
    //   4138: istore 9
    //   4140: goto -196 -> 3944
    //   4143: ldc_w 1014
    //   4146: astore_1
    //   4147: goto -194 -> 3953
    //   4150: ldc_w 1016
    //   4153: aload 4
    //   4155: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4158: ifeq +110 -> 4268
    //   4161: new 166	org/json/JSONObject
    //   4164: dup
    //   4165: aload 5
    //   4167: iconst_0
    //   4168: aaload
    //   4169: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4172: astore_1
    //   4173: aload_1
    //   4174: ldc_w 298
    //   4177: iconst_0
    //   4178: invokevirtual 804	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   4181: istore 9
    //   4183: aload_0
    //   4184: getfield 1018	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4187: ifnonnull +17 -> 4204
    //   4190: aload_0
    //   4191: invokestatic 1023	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4194: putfield 1018	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4197: aload_0
    //   4198: getfield 1018	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4201: invokevirtual 1025	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   4204: aload_0
    //   4205: getfield 1018	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4208: iload 9
    //   4210: invokevirtual 1027	com/tencent/biz/troop/TroopMemberApiClient:a	(Z)V
    //   4213: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4216: ifeq -3169 -> 1047
    //   4219: ldc 93
    //   4221: iconst_2
    //   4222: new 95	java/lang/StringBuilder
    //   4225: dup
    //   4226: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   4229: ldc_w 1029
    //   4232: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4235: aload_1
    //   4236: invokevirtual 987	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4239: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4242: invokestatic 815	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4245: goto -3198 -> 1047
    //   4248: astore_1
    //   4249: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4252: ifeq -3205 -> 1047
    //   4255: ldc 93
    //   4257: iconst_2
    //   4258: ldc_w 989
    //   4261: aload_1
    //   4262: invokestatic 696	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4265: goto -3218 -> 1047
    //   4268: ldc_w 1031
    //   4271: aload 4
    //   4273: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4276: ifeq +146 -> 4422
    //   4279: new 166	org/json/JSONObject
    //   4282: dup
    //   4283: aload 5
    //   4285: iconst_0
    //   4286: aaload
    //   4287: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4290: astore_1
    //   4291: aload_1
    //   4292: ldc_w 1033
    //   4295: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4298: astore_2
    //   4299: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4302: ifeq +29 -> 4331
    //   4305: ldc 93
    //   4307: iconst_2
    //   4308: new 95	java/lang/StringBuilder
    //   4311: dup
    //   4312: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   4315: ldc_w 1035
    //   4318: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4321: aload_2
    //   4322: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4325: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4328: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4331: aload_0
    //   4332: getfield 21	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface	Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebUiMethodInterface;
    //   4335: invokeinterface 1038 1 0
    //   4340: astore_2
    //   4341: aload_2
    //   4342: ifnull -3295 -> 1047
    //   4345: aload_2
    //   4346: invokevirtual 1042	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   4349: astore_2
    //   4350: aload_2
    //   4351: iconst_1
    //   4352: anewarray 79	java/lang/String
    //   4355: dup
    //   4356: iconst_0
    //   4357: ldc_w 1044
    //   4360: aastore
    //   4361: invokevirtual 1049	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	([Ljava/lang/String;)V
    //   4364: aload_2
    //   4365: ldc_w 1044
    //   4368: invokevirtual 1052	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   4371: astore_2
    //   4372: aload_2
    //   4373: ifnull -3326 -> 1047
    //   4376: aload_2
    //   4377: instanceof 1054
    //   4380: ifeq -3333 -> 1047
    //   4383: aload_2
    //   4384: checkcast 1054	com/tencent/biz/webviewplugin/UrlCheckPlugin
    //   4387: aload_1
    //   4388: ldc_w 1056
    //   4391: invokevirtual 178	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4394: aload_1
    //   4395: ldc_w 1058
    //   4398: invokevirtual 178	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4401: aload_1
    //   4402: ldc_w 1060
    //   4405: invokevirtual 178	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4408: invokevirtual 1063	com/tencent/biz/webviewplugin/UrlCheckPlugin:a	(III)V
    //   4411: goto -3364 -> 1047
    //   4414: astore_1
    //   4415: aload_1
    //   4416: invokevirtual 654	org/json/JSONException:printStackTrace	()V
    //   4419: goto -3372 -> 1047
    //   4422: ldc_w 1065
    //   4425: aload 4
    //   4427: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4430: ifeq +130 -> 4560
    //   4433: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4436: ifeq +30 -> 4466
    //   4439: ldc 93
    //   4441: iconst_2
    //   4442: new 95	java/lang/StringBuilder
    //   4445: dup
    //   4446: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   4449: ldc_w 1067
    //   4452: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4455: aload 5
    //   4457: invokevirtual 987	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4460: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4463: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4466: aload 5
    //   4468: ifnull -3421 -> 1047
    //   4471: aload 5
    //   4473: arraylength
    //   4474: ifle -3427 -> 1047
    //   4477: new 166	org/json/JSONObject
    //   4480: dup
    //   4481: aload 5
    //   4483: iconst_0
    //   4484: aaload
    //   4485: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4488: astore_1
    //   4489: aload_1
    //   4490: ldc_w 1069
    //   4493: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4496: astore_2
    //   4497: aload_1
    //   4498: ldc 227
    //   4500: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4503: astore_1
    //   4504: aload_1
    //   4505: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4508: ifne -3461 -> 1047
    //   4511: aload_2
    //   4512: invokestatic 1072	com/tencent/mobileqq/nearby/NearbyURLSafeUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4515: astore_2
    //   4516: new 166	org/json/JSONObject
    //   4519: dup
    //   4520: invokespecial 296	org/json/JSONObject:<init>	()V
    //   4523: astore_3
    //   4524: aload_3
    //   4525: ldc_w 1074
    //   4528: aload_2
    //   4529: invokevirtual 313	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4532: pop
    //   4533: aload_0
    //   4534: aload_1
    //   4535: iconst_1
    //   4536: anewarray 79	java/lang/String
    //   4539: dup
    //   4540: iconst_0
    //   4541: aload_3
    //   4542: invokevirtual 314	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4545: aastore
    //   4546: invokevirtual 235	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4549: goto -3502 -> 1047
    //   4552: astore_1
    //   4553: aload_1
    //   4554: invokevirtual 654	org/json/JSONException:printStackTrace	()V
    //   4557: goto -3510 -> 1047
    //   4560: ldc_w 1076
    //   4563: aload 4
    //   4565: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4568: ifeq +130 -> 4698
    //   4571: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4574: ifeq +30 -> 4604
    //   4577: ldc 93
    //   4579: iconst_2
    //   4580: new 95	java/lang/StringBuilder
    //   4583: dup
    //   4584: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   4587: ldc_w 1078
    //   4590: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4593: aload 5
    //   4595: invokevirtual 987	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4598: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4601: invokestatic 217	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4604: aload 5
    //   4606: ifnull -3559 -> 1047
    //   4609: aload 5
    //   4611: arraylength
    //   4612: ifle -3565 -> 1047
    //   4615: new 166	org/json/JSONObject
    //   4618: dup
    //   4619: aload 5
    //   4621: iconst_0
    //   4622: aaload
    //   4623: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4626: astore_1
    //   4627: aload_1
    //   4628: ldc_w 1080
    //   4631: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4634: astore_2
    //   4635: aload_1
    //   4636: ldc 227
    //   4638: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4641: astore_1
    //   4642: aload_1
    //   4643: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4646: ifne -3599 -> 1047
    //   4649: aload_2
    //   4650: invokestatic 1081	com/tencent/mobileqq/nearby/NearbyURLSafeUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   4653: astore_2
    //   4654: new 166	org/json/JSONObject
    //   4657: dup
    //   4658: invokespecial 296	org/json/JSONObject:<init>	()V
    //   4661: astore_3
    //   4662: aload_3
    //   4663: ldc_w 1083
    //   4666: aload_2
    //   4667: invokevirtual 313	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4670: pop
    //   4671: aload_0
    //   4672: aload_1
    //   4673: iconst_1
    //   4674: anewarray 79	java/lang/String
    //   4677: dup
    //   4678: iconst_0
    //   4679: aload_3
    //   4680: invokevirtual 314	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4683: aastore
    //   4684: invokevirtual 235	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4687: goto -3640 -> 1047
    //   4690: astore_1
    //   4691: aload_1
    //   4692: invokevirtual 654	org/json/JSONException:printStackTrace	()V
    //   4695: goto -3648 -> 1047
    //   4698: ldc_w 1085
    //   4701: aload 4
    //   4703: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4706: ifeq +109 -> 4815
    //   4709: new 166	org/json/JSONObject
    //   4712: dup
    //   4713: aload 5
    //   4715: iconst_0
    //   4716: aaload
    //   4717: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4720: ldc_w 1087
    //   4723: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4726: astore_1
    //   4727: aload_0
    //   4728: getfield 1018	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4731: ifnonnull +17 -> 4748
    //   4734: aload_0
    //   4735: invokestatic 1023	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4738: putfield 1018	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4741: aload_0
    //   4742: getfield 1018	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4745: invokevirtual 1025	com/tencent/biz/troop/TroopMemberApiClient:a	()V
    //   4748: aload_0
    //   4749: getfield 1018	com/tencent/mobileqq/jsp/DataApiPlugin:jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4752: iconst_1
    //   4753: aload_1
    //   4754: invokevirtual 1090	com/tencent/biz/troop/TroopMemberApiClient:a	(ZLjava/lang/String;)V
    //   4757: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4760: ifeq -3713 -> 1047
    //   4763: ldc 93
    //   4765: iconst_2
    //   4766: new 95	java/lang/StringBuilder
    //   4769: dup
    //   4770: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   4773: ldc_w 1092
    //   4776: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4779: aload 5
    //   4781: iconst_0
    //   4782: aaload
    //   4783: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4786: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4789: invokestatic 815	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4792: goto -3745 -> 1047
    //   4795: astore_1
    //   4796: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4799: ifeq -3752 -> 1047
    //   4802: ldc 93
    //   4804: iconst_2
    //   4805: ldc_w 1094
    //   4808: aload_1
    //   4809: invokestatic 696	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4812: goto -3765 -> 1047
    //   4815: ldc_w 1096
    //   4818: aload 4
    //   4820: invokevirtual 360	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4823: ifeq -3776 -> 1047
    //   4826: aload_0
    //   4827: getfield 44	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4830: invokevirtual 672	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   4833: astore_1
    //   4834: aload_1
    //   4835: ifnull -3788 -> 1047
    //   4838: aload_1
    //   4839: invokevirtual 678	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   4842: astore_1
    //   4843: new 166	org/json/JSONObject
    //   4846: dup
    //   4847: aload 5
    //   4849: iconst_0
    //   4850: aaload
    //   4851: invokespecial 168	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4854: astore_3
    //   4855: aload_3
    //   4856: ldc_w 1098
    //   4859: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4862: astore_2
    //   4863: aload_3
    //   4864: ldc_w 1100
    //   4867: invokevirtual 230	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4870: astore_3
    //   4871: aload_2
    //   4872: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4875: ifne +31 -> 4906
    //   4878: aload_1
    //   4879: ifnull +27 -> 4906
    //   4882: aload_1
    //   4883: ldc_w 1102
    //   4886: aload_2
    //   4887: invokevirtual 1106	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4890: pop
    //   4891: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4894: ifeq +12 -> 4906
    //   4897: ldc 93
    //   4899: iconst_2
    //   4900: ldc_w 1108
    //   4903: invokestatic 149	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4906: aload_3
    //   4907: invokestatic 55	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4910: ifne -3863 -> 1047
    //   4913: aload_1
    //   4914: ifnull -3867 -> 1047
    //   4917: aload_1
    //   4918: ldc_w 1110
    //   4921: aload_3
    //   4922: invokevirtual 1106	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   4925: pop
    //   4926: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4929: ifeq -3882 -> 1047
    //   4932: ldc 93
    //   4934: iconst_2
    //   4935: ldc_w 1112
    //   4938: invokestatic 149	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4941: goto -3894 -> 1047
    //   4944: astore_1
    //   4945: ldc 93
    //   4947: iconst_2
    //   4948: ldc_w 1114
    //   4951: aload_1
    //   4952: invokestatic 1116	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4955: goto -3908 -> 1047
    //   4958: iconst_0
    //   4959: ireturn
    //   4960: astore_2
    //   4961: goto -3136 -> 1825
    //   4964: astore_1
    //   4965: goto -3844 -> 1121
    //   4968: astore 4
    //   4970: goto -3917 -> 1053
    //   4973: astore 4
    //   4975: goto -3922 -> 1053
    //   4978: iconst_1
    //   4979: istore 6
    //   4981: goto -1559 -> 3422
    //   4984: aconst_null
    //   4985: astore_1
    //   4986: goto -2916 -> 2070
    //   4989: ldc_w 759
    //   4992: astore_1
    //   4993: goto -3086 -> 1907
    //   4996: goto -3245 -> 1751
    //   4999: goto -4614 -> 385
    //   5002: aload_1
    //   5003: astore 4
    //   5005: goto -4578 -> 427
    //   5008: aload_1
    //   5009: astore_3
    //   5010: goto -4567 -> 443
    //   5013: goto -4933 -> 80
    //   5016: iconst_0
    //   5017: istore 6
    //   5019: goto -1597 -> 3422
    //   5022: iconst_0
    //   5023: istore 9
    //   5025: goto -1081 -> 3944
    //   5028: iconst_0
    //   5029: istore 9
    //   5031: goto -1087 -> 3944
    //   5034: iconst_0
    //   5035: istore 9
    //   5037: goto -1093 -> 3944
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5040	0	this	DataApiPlugin
    //   0	5040	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	5040	2	paramString1	String
    //   0	5040	3	paramString2	String
    //   0	5040	4	paramString3	String
    //   0	5040	5	paramVarArgs	String[]
    //   1206	3812	6	i	int
    //   2306	316	7	j	int
    //   2316	136	8	k	int
    //   154	4882	9	bool1	boolean
    //   2503	1606	10	bool2	boolean
    //   43	3289	11	localObject1	Object
    //   207	3195	12	localObject2	Object
    //   165	3088	13	str1	String
    //   198	3164	14	localObject3	Object
    //   214	2244	15	str2	String
    //   176	2284	16	str3	String
    //   87	676	17	localAppInterface	AppInterface
    //   187	487	18	str4	String
    // Exception table:
    //   from	to	target	type
    //   273	316	1049	java/lang/Exception
    //   27	57	1110	org/json/JSONException
    //   62	80	1110	org/json/JSONException
    //   80	105	1110	org/json/JSONException
    //   105	129	1110	org/json/JSONException
    //   131	145	1110	org/json/JSONException
    //   145	273	1110	org/json/JSONException
    //   434	440	1110	org/json/JSONException
    //   443	453	1110	org/json/JSONException
    //   458	492	1110	org/json/JSONException
    //   492	605	1110	org/json/JSONException
    //   605	754	1110	org/json/JSONException
    //   754	891	1110	org/json/JSONException
    //   891	1021	1110	org/json/JSONException
    //   1021	1047	1110	org/json/JSONException
    //   1099	1105	1110	org/json/JSONException
    //   1125	1131	1110	org/json/JSONException
    //   1131	1133	1110	org/json/JSONException
    //   273	316	1118	finally
    //   1227	1253	1298	org/json/JSONException
    //   1259	1270	1298	org/json/JSONException
    //   1270	1295	1298	org/json/JSONException
    //   1324	1350	1298	org/json/JSONException
    //   1350	1365	1298	org/json/JSONException
    //   1376	1402	1298	org/json/JSONException
    //   1405	1429	1298	org/json/JSONException
    //   1429	1440	1298	org/json/JSONException
    //   1454	1542	1545	org/json/JSONException
    //   1571	1631	1682	org/json/JSONException
    //   1635	1643	1682	org/json/JSONException
    //   1647	1658	1682	org/json/JSONException
    //   1666	1679	1682	org/json/JSONException
    //   1690	1695	1682	org/json/JSONException
    //   1716	1743	1822	org/json/JSONException
    //   1850	1887	1926	java/lang/Exception
    //   1891	1896	1926	java/lang/Exception
    //   1900	1907	1926	java/lang/Exception
    //   1907	1923	1926	java/lang/Exception
    //   1981	2070	2129	java/lang/Exception
    //   2070	2100	2129	java/lang/Exception
    //   2100	2126	2129	java/lang/Exception
    //   2149	2171	2129	java/lang/Exception
    //   2192	2366	2417	org/json/JSONException
    //   2368	2380	2417	org/json/JSONException
    //   2380	2414	2417	org/json/JSONException
    //   2437	2464	2417	org/json/JSONException
    //   2467	2542	2417	org/json/JSONException
    //   2546	2552	2417	org/json/JSONException
    //   2557	2593	2417	org/json/JSONException
    //   2598	2610	2417	org/json/JSONException
    //   2610	2634	2417	org/json/JSONException
    //   2637	2652	2417	org/json/JSONException
    //   2681	2736	2762	org/json/JSONException
    //   2736	2759	2762	org/json/JSONException
    //   2801	2817	2762	org/json/JSONException
    //   2820	2835	2762	org/json/JSONException
    //   2856	2920	2923	org/json/JSONException
    //   2980	3028	3471	org/json/JSONException
    //   3032	3108	3471	org/json/JSONException
    //   3115	3122	3471	org/json/JSONException
    //   3131	3223	3471	org/json/JSONException
    //   3231	3285	3471	org/json/JSONException
    //   3285	3339	3471	org/json/JSONException
    //   3339	3419	3471	org/json/JSONException
    //   3422	3468	3471	org/json/JSONException
    //   3527	3539	3620	org/json/JSONException
    //   3541	3548	3620	org/json/JSONException
    //   3550	3557	3620	org/json/JSONException
    //   3559	3568	3620	org/json/JSONException
    //   3570	3579	3620	org/json/JSONException
    //   3581	3589	3620	org/json/JSONException
    //   3591	3608	3620	org/json/JSONException
    //   3610	3617	3620	org/json/JSONException
    //   3668	3704	3752	java/lang/Exception
    //   3708	3717	3752	java/lang/Exception
    //   3717	3749	3752	java/lang/Exception
    //   3811	3861	3969	org/json/JSONException
    //   3868	3876	3969	org/json/JSONException
    //   3880	3944	3969	org/json/JSONException
    //   3953	3966	3969	org/json/JSONException
    //   3989	4010	3969	org/json/JSONException
    //   4013	4038	3969	org/json/JSONException
    //   4044	4074	3969	org/json/JSONException
    //   4077	4102	3969	org/json/JSONException
    //   4112	4137	3969	org/json/JSONException
    //   4161	4204	4248	java/lang/Exception
    //   4204	4245	4248	java/lang/Exception
    //   4279	4331	4414	org/json/JSONException
    //   4331	4341	4414	org/json/JSONException
    //   4345	4372	4414	org/json/JSONException
    //   4376	4411	4414	org/json/JSONException
    //   4477	4549	4552	org/json/JSONException
    //   4615	4687	4690	org/json/JSONException
    //   4709	4748	4795	java/lang/Exception
    //   4748	4792	4795	java/lang/Exception
    //   4826	4834	4944	java/lang/Exception
    //   4838	4878	4944	java/lang/Exception
    //   4882	4906	4944	java/lang/Exception
    //   4906	4913	4944	java/lang/Exception
    //   4917	4941	4944	java/lang/Exception
    //   1751	1764	4960	org/json/JSONException
    //   1768	1795	4960	org/json/JSONException
    //   322	331	4964	finally
    //   333	350	4964	finally
    //   352	360	4964	finally
    //   362	382	4964	finally
    //   390	396	4964	finally
    //   398	424	4964	finally
    //   1055	1061	4964	finally
    //   1063	1093	4964	finally
    //   322	331	4968	java/lang/Exception
    //   333	350	4968	java/lang/Exception
    //   352	360	4968	java/lang/Exception
    //   362	382	4968	java/lang/Exception
    //   390	396	4973	java/lang/Exception
    //   398	424	4973	java/lang/Exception
  }
  
  public void onCreate()
  {
    super.onCreate();
    WebIPCOperator.a().a(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$OnRemoteRespObserver);
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
  
  public void onDestroy()
  {
    WebIPCOperator.a().b(this.jdField_a_of_type_ComTencentMobileqqEmosmClient$OnRemoteRespObserver);
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient != null) {
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DataApiPlugin
 * JD-Core Version:    0.7.0.1
 */