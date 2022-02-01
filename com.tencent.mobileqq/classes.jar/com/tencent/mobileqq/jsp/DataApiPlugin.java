package com.tencent.mobileqq.jsp;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
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
  TroopMemberApiClient a;
  protected OnRemoteRespObserver b = new DataApiPlugin.1(this);
  AuthorizeConfig c;
  CookieManager d;
  private WebUiUtils.WebStatisticsInterface e = null;
  private WebUiUtils.WebUiMethodInterface f = null;
  private WebUiUtils.WebviewReportSpeedInterface g = null;
  private WebUiUtils.QQBrowserBaseActivityInterface h = null;
  
  public DataApiPlugin()
  {
    this.mPluginNameSpace = "data";
  }
  
  private void a(String paramString)
  {
    Object localObject = this.mRuntime.b();
    if (!TextUtils.isEmpty(paramString))
    {
      if (!((AppInterface)localObject).isLogin()) {
        return;
      }
      localObject = ((AppInterface)localObject).getAccount();
      String str1 = CookieManager.getInstance().getCookie(paramString);
      if ((!TextUtils.isEmpty(str1)) && (!str1.contains("uin=")))
      {
        String str2 = SwiftBrowserCookieMonster.a((String)localObject);
        localObject = Util.d(paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("can not find uin from ");
        localStringBuilder.append(Util.b(paramString, new String[0]));
        localStringBuilder.append(", dump cookie: ");
        localStringBuilder.append(Util.c(str1, new String[0]));
        QLog.e("DataApiPlugin", 1, localStringBuilder.toString());
        if (this.d == null)
        {
          this.d = CookieManager.getInstance();
          this.d.setAcceptCookie(true);
        }
        str1 = String.format("%s=%s; PATH=/; DOMAIN=.%s; Max-Age=21600;", new Object[] { "uin", str2, localObject });
        this.d.setCookie(paramString, str1);
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("set uin cookie for host ");
          paramString.append((String)localObject);
          paramString.append(", cookie : ");
          paramString.append(Util.c(str1, new String[0]));
          QLog.i("DataApiPlugin", 2, paramString.toString());
        }
      }
    }
  }
  
  private void a(String paramString, String[] paramArrayOfString)
  {
    paramString = this.e;
    int i;
    long l;
    SwiftBrowserStatistics localSwiftBrowserStatistics;
    if ((paramString != null) && (this.g != null))
    {
      i = paramString.getCurrentStep();
      l = this.g.getmClickTime();
      localSwiftBrowserStatistics = null;
    }
    else
    {
      localSwiftBrowserStatistics = (SwiftBrowserStatistics)super.getBrowserComponent(-2);
      if (localSwiftBrowserStatistics != null)
      {
        i = localSwiftBrowserStatistics.aW.b;
        l = localSwiftBrowserStatistics.c;
      }
      else
      {
        l = 0L;
        i = 0;
      }
    }
    for (;;)
    {
      int j;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramArrayOfString[0]);
        j = localJSONObject.getJSONObject("data").getInt("status");
        paramArrayOfString = "onFirstLine";
        paramString = "state_activity_first_line";
        if ((j != 12) && (j != 13))
        {
          if (localSwiftBrowserStatistics != null) {
            localSwiftBrowserStatistics.c(paramString);
          }
          if ((i < j) && (this.f != null))
          {
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("try report web status, ");
              paramString.append(paramArrayOfString);
              paramString.append(", step: ");
              paramString.append(j);
              paramString.append(", stepTime: ");
              paramString.append(System.currentTimeMillis() - l);
              paramString.append(", totalTime: ");
              paramString.append(System.currentTimeMillis() - l);
              paramString.append(", \n ");
              paramString.append(this.f.getCurrentUrl());
              QLog.d("QQBrowser_report", 2, paramString.toString());
            }
            if (this.e != null)
            {
              this.e.setCurrentStep(j);
              this.e.setStepTime(System.currentTimeMillis());
            }
            else if (localSwiftBrowserStatistics != null)
            {
              localSwiftBrowserStatistics.aW.b = j;
              localSwiftBrowserStatistics.aW.g = System.currentTimeMillis();
              if (j != 12)
              {
                if (j != 13)
                {
                  localSwiftBrowserStatistics.ak = (localSwiftBrowserStatistics.aW.g - l);
                }
                else
                {
                  localSwiftBrowserStatistics.am = (localSwiftBrowserStatistics.aW.g - l);
                  GameCenterActivity.reportStep(this.f.getCurrentUrl(), localSwiftBrowserStatistics.aW.b, true, localSwiftBrowserStatistics.aW.c);
                }
              }
              else {
                localSwiftBrowserStatistics.al = (localSwiftBrowserStatistics.aW.g - l);
              }
            }
          }
          paramString = localJSONObject.optString("callback");
          if (!TextUtils.isEmpty(paramString)) {
            callJs(paramString, new String[] { "{\"result\": 0}" });
          }
          return;
        }
      }
      catch (JSONException paramString)
      {
        return;
      }
      if (j == 12) {
        paramString = "onPageVisible";
      } else {
        paramString = "onPageFinished";
      }
      String str;
      if (j == 12)
      {
        str = "state_first_screen";
        paramArrayOfString = paramString;
        paramString = str;
      }
      else
      {
        str = "state_page_finished";
        paramArrayOfString = paramString;
        paramString = str;
      }
    }
  }
  
  private void c(String paramString1, String paramString2)
  {
    Object localObject = this.mRuntime.b();
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!((AppInterface)localObject).isLogin()) {
        return;
      }
      String str = ((AppInterface)localObject).getAccount();
      localObject = CookieManager.getInstance().getCookie(paramString1);
      if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).contains("p_uin=")))
      {
        str = SwiftBrowserCookieMonster.a(str);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("can not find p_uin from ");
        localStringBuilder.append(Util.b(paramString1, new String[0]));
        localStringBuilder.append(", dump cookie: ");
        localStringBuilder.append(Util.c((String)localObject, new String[0]));
        QLog.e("DataApiPlugin", 1, localStringBuilder.toString());
        if (this.d == null)
        {
          this.d = CookieManager.getInstance();
          this.d.setAcceptCookie(true);
        }
        localObject = String.format("%s=%s; PATH=/; DOMAIN=.%s; Max-Age=21600;", new Object[] { "p_uin", str, paramString2 });
        this.d.setCookie(paramString1, (String)localObject);
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("set p_uin cookie for host ");
          paramString1.append(paramString2);
          paramString1.append(", cookie: ");
          paramString1.append(Util.c((String)localObject, new String[0]));
          QLog.i("DataApiPlugin", 2, paramString1.toString());
        }
      }
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        localObject1 = VasUserData.a(this.mRuntime.b(), "ticketInterval");
        i = 28800;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          i = Integer.parseInt((String)localObject1);
        }
        paramString1 = new JSONObject(paramString1);
        str1 = paramString1.optString("callback");
        localObject2 = new JSONObject();
        boolean bool = this.mRuntime.b().isLogin();
        if (!bool)
        {
          ((JSONObject)localObject2).put("result", -2);
          ((JSONObject)localObject2).put("message", HardCodeUtil.a(2131900878));
          callJs(str1, new String[] { ((JSONObject)localObject2).toString() });
          return;
        }
        str2 = this.mRuntime.b().getCurrentAccountUin();
        localObject1 = this.mRuntime.b().getApplication();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(str2);
        ((StringBuilder)localObject3).append("_get_ticket_interval");
        Object localObject4 = ((MobileQQ)localObject1).getSharedPreferences(((StringBuilder)localObject3).toString(), 0);
        SharedPreferences.Editor localEditor = ((SharedPreferences)localObject4).edit();
        if (this.d != null) {
          break label1032;
        }
        this.d = CookieManager.getInstance();
        this.d.setAcceptCookie(true);
        if (this.c == null) {
          this.c = AuthorizeConfig.a();
        }
        paramString1 = paramString1.optString("key");
        if (TextUtils.isEmpty(paramString1))
        {
          ((JSONObject)localObject2).put("result", -2);
          ((JSONObject)localObject2).put("message", "参数key为空");
          callJs(str1, new String[] { ((JSONObject)localObject2).toString() });
          return;
        }
        localObject3 = new WUserSigInfo();
        bool = "skey".equals(paramString1);
        localObject1 = null;
        if (bool)
        {
          l = ((SharedPreferences)localObject4).getLong("skey", 0L);
          if (System.currentTimeMillis() - l > i * 1000)
          {
            localEditor.putLong("skey", System.currentTimeMillis());
            localEditor.commit();
            if (!this.c.a(paramString2)) {
              break label1035;
            }
            i = 4096;
            break label1037;
          }
          ((JSONObject)localObject2).put("result", 1);
          ((JSONObject)localObject2).put("message", HardCodeUtil.a(2131900879));
          callJs(str1, new String[] { ((JSONObject)localObject2).toString() });
          return;
        }
        if ("pskey".equals(paramString1))
        {
          paramString1 = this.c.e(paramString2);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("pskey_");
          localStringBuilder.append(paramString1);
          l = ((SharedPreferences)localObject4).getLong(localStringBuilder.toString(), 0L);
          if (System.currentTimeMillis() - l > i * 1000)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("pskey_");
            ((StringBuilder)localObject4).append(paramString1);
            localEditor.putLong(((StringBuilder)localObject4).toString(), System.currentTimeMillis());
            localEditor.commit();
            if (TextUtils.isEmpty(paramString1)) {
              break label1042;
            }
            ((WUserSigInfo)localObject3)._domains.add(paramString1);
            i = 1048576;
            break label1044;
          }
          ((JSONObject)localObject2).put("result", 1);
          ((JSONObject)localObject2).put("message", HardCodeUtil.a(2131900881));
          callJs(str1, new String[] { ((JSONObject)localObject2).toString() });
          return;
        }
        if (!"pt4_token".equals(paramString1)) {
          break label1054;
        }
        localObject1 = this.c.f(paramString2);
        paramString1 = new StringBuilder();
        paramString1.append("pt4_token_");
        paramString1.append((String)localObject1);
        long l = ((SharedPreferences)localObject4).getLong(paramString1.toString(), 0L);
        if (System.currentTimeMillis() - l > i * 1000)
        {
          paramString1 = new StringBuilder();
          paramString1.append("pt4_token_");
          paramString1.append((String)localObject1);
          localEditor.putLong(paramString1.toString(), System.currentTimeMillis());
          localEditor.commit();
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1047;
          }
          ((WUserSigInfo)localObject3)._domains.add(String.format(Locale.getDefault(), "(%d)%s", new Object[] { Integer.valueOf(134217728), localObject1 }));
          i = 135266304;
          break label1049;
        }
        ((JSONObject)localObject2).put("result", 1);
        ((JSONObject)localObject2).put("message", HardCodeUtil.a(2131900882));
        callJs(str1, new String[] { ((JSONObject)localObject2).toString() });
        return;
      }
      catch (Exception paramString1)
      {
        Object localObject1;
        String str1;
        Object localObject2;
        String str2;
        Object localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramString2 = new StringBuilder();
        paramString2.append("updateLoginInfo error: ");
        paramString2.append(paramString1.getMessage());
        QLog.e("DataApiPlugin", 2, paramString2.toString());
        return;
      }
      if (i == 0)
      {
        ((JSONObject)localObject2).put("result", -2);
        ((JSONObject)localObject2).put("message", HardCodeUtil.a(2131900880));
        callJs(str1, new String[] { ((JSONObject)localObject2).toString() });
        return;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("GetStWithoutPasswd|key=");
      ((StringBuilder)localObject2).append(i);
      QLog.d("DataApiPlugin", 1, ((StringBuilder)localObject2).toString());
      localObject2 = new WtloginHelper(this.mRuntime.b().getApplication());
      ((WtloginHelper)localObject2).setCallSource(30);
      ((WtloginHelper)localObject2).SetListener(new DataApiPlugin.GetKeyListener(this, paramString2, str1, paramString1, (String)localObject1));
      ((WtloginHelper)localObject2).GetStWithoutPasswd(str2, 16L, 16L, 1L, i, (WUserSigInfo)localObject3);
      return;
      label1032:
      continue;
      label1035:
      int i = 0;
      label1037:
      paramString1 = null;
      continue;
      label1042:
      i = 0;
      label1044:
      continue;
      label1047:
      i = 0;
      label1049:
      paramString1 = null;
      continue;
      label1054:
      paramString1 = null;
      i = 0;
    }
  }
  
  void a(String paramString1, WUserSigInfo paramWUserSigInfo, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (paramWUserSigInfo == null)
    {
      b(paramString2, "get WUserSigInfo = null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject3 = Util.a(paramString1, 1);
    Object localObject2;
    Object localObject1;
    int i;
    if ((paramInt & 0x1000) != 0)
    {
      localObject2 = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 4096);
      if ((localObject2 != null) && (((Ticket)localObject2)._sig != null)) {
        localObject1 = new String(((Ticket)localObject2)._sig);
      } else {
        localObject1 = null;
      }
      int j;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localStringBuilder.append("skey获取失败;");
        j = -2;
      }
      else
      {
        localObject3 = String.format("skey=%1$s; PATH=/; DOMAIN=.%2$s;", new Object[] { localObject1, localObject3 });
        this.d.setCookie(paramString1, (String)localObject3);
        a(paramString1);
        j = 0;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("skey=");
        ((StringBuilder)localObject3).append((String)localObject1);
        QLog.i("DataApiPlugin", 1, Util.c(((StringBuilder)localObject3).toString(), new String[0]));
      }
      else
      {
        QLog.e("DataApiPlugin", 1, "skey is null!");
      }
      i = j;
      if (localObject2 != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("last refresh skey time: ");
        ((StringBuilder)localObject1).append(((Ticket)localObject2)._create_time);
        QLog.i("DataApiPlugin", 1, ((StringBuilder)localObject1).toString());
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("skey create time: ");
        ((StringBuilder)localObject1).append(((Ticket)localObject2)._create_time);
        localStringBuilder.append(((StringBuilder)localObject1).toString());
        i = j;
      }
    }
    else
    {
      i = 0;
    }
    if (((paramInt & 0x100000) != 0) && ((paramInt & 0x8000000) == 0))
    {
      localObject2 = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 1048576);
      if ((localObject2 != null) && (((Ticket)localObject2)._pskey_map != null))
      {
        localObject3 = (byte[])((Ticket)localObject2)._pskey_map.get(paramString3);
        localObject1 = new String();
        if (localObject3 != null)
        {
          localObject1 = new String((byte[])localObject3);
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("onDoneGetTicket pskey_map not contain domain: ");
          ((StringBuilder)localObject3).append(paramString3);
          QLog.e("DataApiPlugin", 1, ((StringBuilder)localObject3).toString());
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("last refresh pskey time: ");
        ((StringBuilder)localObject3).append(((Ticket)localObject2)._create_time);
        QLog.i("DataApiPlugin", 1, ((StringBuilder)localObject3).toString());
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramString3 = new StringBuilder();
          paramString3.append("pskey获取失败;pskey = null, create time: ");
          paramString3.append(((Ticket)localObject2)._create_time);
          localStringBuilder.append(paramString3.toString());
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("p_skey=");
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("; PATH=/; DOMAIN=.");
          ((StringBuilder)localObject2).append(paramString3);
          ((StringBuilder)localObject2).append(';');
          localObject1 = ((StringBuilder)localObject2).toString();
          this.d.setCookie(paramString1, (String)localObject1);
          c(paramString1, paramString3);
          break label617;
        }
      }
      else
      {
        localStringBuilder.append("pskey获取失败;Ticket = null or ticket._pskey_map = null");
      }
      i = -2;
    }
    label617:
    if ((paramInt & 0x8000000) != 0)
    {
      paramString3 = WtloginHelper.GetUserSigInfoTicket(paramWUserSigInfo, 1048576);
      if (paramString3 == null)
      {
        localStringBuilder.append("pt4token获取失败;Ticket = null");
        paramInt = -2;
      }
      else
      {
        paramWUserSigInfo = new String((byte[])paramString3._pt4token_map.get(paramString4));
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("last refresh pt4token time: ");
        ((StringBuilder)localObject1).append(paramString3._create_time);
        QLog.i("DataApiPlugin", 1, ((StringBuilder)localObject1).toString());
        if (TextUtils.isEmpty(paramWUserSigInfo))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("pt4token获取失败;pt4token = null, create time: ");
          ((StringBuilder)localObject1).append(paramString3._create_time);
          localStringBuilder.append(((StringBuilder)localObject1).toString());
          paramInt = -2;
        }
        else
        {
          paramInt = i;
        }
        paramString3 = new StringBuilder();
        paramString3.append("pt4_token=");
        paramString3.append(paramWUserSigInfo);
        paramString3.append("; PATH=/; DOMAIN=.");
        paramString3.append(paramString4);
        paramString3.append(';');
        paramWUserSigInfo = paramString3.toString();
        this.d.setCookie(paramString1, paramWUserSigInfo);
      }
    }
    else
    {
      paramInt = i;
    }
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
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramWUserSigInfo = new StringBuilder();
        paramWUserSigInfo.append("updateLoginInfo error: ");
        paramWUserSigInfo.append(paramString1.getMessage());
        QLog.e("DataApiPlugin", 2, paramWUserSigInfo.toString());
      }
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
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("updateLoginInfo error: ");
        paramString2.append(paramString1.getMessage());
        QLog.e("DataApiPlugin", 2, paramString2.toString());
      }
    }
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 41
    //   2: aload_3
    //   3: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6: ifeq +5340 -> 5346
    //   9: ldc_w 537
    //   12: aload 4
    //   14: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifeq +1299 -> 1316
    //   20: aload 5
    //   22: arraylength
    //   23: iconst_1
    //   24: if_icmpne +1292 -> 1316
    //   27: new 188	org/json/JSONObject
    //   30: dup
    //   31: aload 5
    //   33: iconst_0
    //   34: aaload
    //   35: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   38: ldc_w 266
    //   41: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   44: astore 13
    //   46: aload_0
    //   47: getfield 51	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   50: invokevirtual 540	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   53: invokevirtual 545	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   56: astore_1
    //   57: aload_1
    //   58: astore 4
    //   60: aload_1
    //   61: ifnull +22 -> 83
    //   64: aload_1
    //   65: astore 4
    //   67: aload_1
    //   68: ldc_w 547
    //   71: invokevirtual 550	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   74: ifeq +9 -> 83
    //   77: aload_1
    //   78: invokestatic 553	com/tencent/biz/common/offline/HtmlOffline:f	(Ljava/lang/String;)Ljava/lang/String;
    //   81: astore 4
    //   83: aload_0
    //   84: getfield 51	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   87: invokevirtual 56	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   90: astore 18
    //   92: aload 4
    //   94: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: ifne +11 -> 108
    //   100: aload 18
    //   102: invokevirtual 68	com/tencent/common/app/AppInterface:isLogin	()Z
    //   105: ifne +29 -> 134
    //   108: aload 13
    //   110: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   113: ifne +21 -> 134
    //   116: aload_0
    //   117: aload 13
    //   119: iconst_1
    //   120: anewarray 86	java/lang/String
    //   123: dup
    //   124: iconst_0
    //   125: ldc_w 555
    //   128: aastore
    //   129: invokevirtual 274	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   132: iconst_1
    //   133: ireturn
    //   134: aload_0
    //   135: getfield 348	com/tencent/mobileqq/jsp/DataApiPlugin:c	Lcom/tencent/biz/AuthorizeConfig;
    //   138: ifnonnull +10 -> 148
    //   141: aload_0
    //   142: invokestatic 353	com/tencent/biz/AuthorizeConfig:a	()Lcom/tencent/biz/AuthorizeConfig;
    //   145: putfield 348	com/tencent/mobileqq/jsp/DataApiPlugin:c	Lcom/tencent/biz/AuthorizeConfig;
    //   148: aload_0
    //   149: getfield 348	com/tencent/mobileqq/jsp/DataApiPlugin:c	Lcom/tencent/biz/AuthorizeConfig;
    //   152: aload 4
    //   154: invokevirtual 382	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;)Z
    //   157: istore 9
    //   159: aload_0
    //   160: getfield 348	com/tencent/mobileqq/jsp/DataApiPlugin:c	Lcom/tencent/biz/AuthorizeConfig;
    //   163: aload 4
    //   165: invokevirtual 558	com/tencent/biz/AuthorizeConfig:p	(Ljava/lang/String;)Ljava/lang/String;
    //   168: astore 15
    //   170: aload_0
    //   171: getfield 348	com/tencent/mobileqq/jsp/DataApiPlugin:c	Lcom/tencent/biz/AuthorizeConfig;
    //   174: aload 4
    //   176: invokevirtual 404	com/tencent/biz/AuthorizeConfig:f	(Ljava/lang/String;)Ljava/lang/String;
    //   179: astore 12
    //   181: aload_0
    //   182: getfield 348	com/tencent/mobileqq/jsp/DataApiPlugin:c	Lcom/tencent/biz/AuthorizeConfig;
    //   185: aload 4
    //   187: invokevirtual 387	com/tencent/biz/AuthorizeConfig:e	(Ljava/lang/String;)Ljava/lang/String;
    //   190: astore 19
    //   192: aload 18
    //   194: iconst_2
    //   195: invokevirtual 562	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   198: checkcast 564	mqq/manager/TicketManager
    //   201: astore 16
    //   203: new 188	org/json/JSONObject
    //   206: dup
    //   207: invokespecial 307	org/json/JSONObject:<init>	()V
    //   210: astore 14
    //   212: aload 18
    //   214: invokevirtual 72	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   217: astore 17
    //   219: aload 14
    //   221: ldc 135
    //   223: aload 17
    //   225: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   228: pop
    //   229: aload 18
    //   231: invokevirtual 332	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   234: astore_1
    //   235: new 99	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   242: astore_2
    //   243: aload_2
    //   244: getstatic 570	mqq/app/Constants$PropertiesKey:nickName	Lmqq/app/Constants$PropertiesKey;
    //   247: invokevirtual 571	mqq/app/Constants$PropertiesKey:toString	()Ljava/lang/String;
    //   250: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_2
    //   255: aload 17
    //   257: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload_1
    //   262: aload_2
    //   263: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokevirtual 574	mqq/app/MobileQQ:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   269: astore_3
    //   270: aload_3
    //   271: astore_1
    //   272: aload_1
    //   273: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   276: ifeq +5079 -> 5355
    //   279: invokestatic 580	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   282: invokevirtual 586	com/tencent/qphone/base/util/BaseApplication:getContentResolver	()Landroid/content/ContentResolver;
    //   285: astore_2
    //   286: new 99	java/lang/StringBuilder
    //   289: dup
    //   290: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   293: astore 5
    //   295: aload 5
    //   297: ldc_w 588
    //   300: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload 5
    //   306: aload 17
    //   308: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload_2
    //   313: aload 5
    //   315: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 594	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   321: aconst_null
    //   322: ldc_w 596
    //   325: iconst_1
    //   326: anewarray 86	java/lang/String
    //   329: dup
    //   330: iconst_0
    //   331: aload 17
    //   333: aastore
    //   334: aconst_null
    //   335: invokevirtual 602	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   338: astore 5
    //   340: aload 5
    //   342: ifnull +171 -> 513
    //   345: aload 5
    //   347: astore_2
    //   348: aload 5
    //   350: invokeinterface 607 1 0
    //   355: ifeq +158 -> 513
    //   358: aload 5
    //   360: astore_2
    //   361: aload 5
    //   363: aload 5
    //   365: ldc_w 609
    //   368: invokeinterface 612 2 0
    //   373: invokeinterface 615 2 0
    //   378: astore 11
    //   380: aload 5
    //   382: astore_2
    //   383: aload 11
    //   385: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   388: istore 10
    //   390: iload 10
    //   392: ifne +45 -> 437
    //   395: aload 5
    //   397: astore_2
    //   398: aload 11
    //   400: invokevirtual 619	java/lang/String:getBytes	()[B
    //   403: astore 11
    //   405: aload 5
    //   407: astore_2
    //   408: new 86	java/lang/String
    //   411: dup
    //   412: aload 11
    //   414: ldc_w 621
    //   417: invokespecial 624	java/lang/String:<init>	([BLjava/lang/String;)V
    //   420: invokestatic 629	com/tencent/mobileqq/utils/SecurityUtile:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   423: astore_3
    //   424: aload_3
    //   425: astore_1
    //   426: goto +11 -> 437
    //   429: astore_2
    //   430: goto +74 -> 504
    //   433: astore_2
    //   434: goto +68 -> 502
    //   437: aload_1
    //   438: astore_3
    //   439: aload 5
    //   441: astore_2
    //   442: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   445: ifeq +70 -> 515
    //   448: aload 5
    //   450: astore_2
    //   451: new 99	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   458: astore_3
    //   459: aload 5
    //   461: astore_2
    //   462: aload_3
    //   463: ldc_w 631
    //   466: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload 5
    //   472: astore_2
    //   473: aload_3
    //   474: aload_1
    //   475: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload 5
    //   481: astore_2
    //   482: ldc 115
    //   484: iconst_2
    //   485: aload_3
    //   486: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: invokestatic 153	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   492: aload_1
    //   493: astore_3
    //   494: goto +21 -> 515
    //   497: astore_2
    //   498: goto +6 -> 504
    //   501: astore_2
    //   502: aload_3
    //   503: astore_1
    //   504: aload_2
    //   505: astore 11
    //   507: aload 5
    //   509: astore_3
    //   510: goto +34 -> 544
    //   513: aload_1
    //   514: astore_3
    //   515: aload_3
    //   516: astore_1
    //   517: aload 5
    //   519: ifnull +106 -> 625
    //   522: aload 5
    //   524: invokeinterface 634 1 0
    //   529: aload_3
    //   530: astore_1
    //   531: goto +94 -> 625
    //   534: astore_1
    //   535: aconst_null
    //   536: astore_2
    //   537: goto +76 -> 613
    //   540: astore 11
    //   542: aconst_null
    //   543: astore_3
    //   544: aload_3
    //   545: astore_2
    //   546: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   549: ifeq +51 -> 600
    //   552: aload_3
    //   553: astore_2
    //   554: new 99	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   561: astore 5
    //   563: aload_3
    //   564: astore_2
    //   565: aload 5
    //   567: ldc_w 636
    //   570: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload_3
    //   575: astore_2
    //   576: aload 5
    //   578: aload 11
    //   580: invokestatic 640	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   583: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: aload_3
    //   588: astore_2
    //   589: ldc 115
    //   591: iconst_2
    //   592: aload 5
    //   594: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   600: aload_3
    //   601: ifnull +4747 -> 5348
    //   604: aload_3
    //   605: invokeinterface 634 1 0
    //   610: goto +4738 -> 5348
    //   613: aload_2
    //   614: ifnull +9 -> 623
    //   617: aload_2
    //   618: invokeinterface 634 1 0
    //   623: aload_1
    //   624: athrow
    //   625: aload 14
    //   627: ldc_w 642
    //   630: aload_1
    //   631: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   634: pop
    //   635: iload 9
    //   637: ifeq +642 -> 1279
    //   640: aload_0
    //   641: aload 4
    //   643: invokespecial 482	com/tencent/mobileqq/jsp/DataApiPlugin:a	(Ljava/lang/String;)V
    //   646: aload 4
    //   648: invokestatic 97	com/tencent/biz/common/util/Util:d	(Ljava/lang/String;)Ljava/lang/String;
    //   651: astore_1
    //   652: aload_0
    //   653: getfield 125	com/tencent/mobileqq/jsp/DataApiPlugin:d	Lcom/tencent/smtt/sdk/CookieManager;
    //   656: ifnonnull +18 -> 674
    //   659: aload_0
    //   660: invokestatic 78	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   663: putfield 125	com/tencent/mobileqq/jsp/DataApiPlugin:d	Lcom/tencent/smtt/sdk/CookieManager;
    //   666: aload_0
    //   667: getfield 125	com/tencent/mobileqq/jsp/DataApiPlugin:d	Lcom/tencent/smtt/sdk/CookieManager;
    //   670: iconst_1
    //   671: invokevirtual 129	com/tencent/smtt/sdk/CookieManager:setAcceptCookie	(Z)V
    //   674: aload 16
    //   676: aload 17
    //   678: invokeinterface 645 2 0
    //   683: astore_2
    //   684: aload 14
    //   686: ldc_w 362
    //   689: aload_2
    //   690: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   693: pop
    //   694: aload_2
    //   695: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   698: ifne +99 -> 797
    //   701: ldc_w 480
    //   704: iconst_2
    //   705: anewarray 133	java/lang/Object
    //   708: dup
    //   709: iconst_0
    //   710: aload_2
    //   711: aastore
    //   712: dup
    //   713: iconst_1
    //   714: aload_1
    //   715: aastore
    //   716: invokestatic 139	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   719: astore_1
    //   720: aload_0
    //   721: getfield 125	com/tencent/mobileqq/jsp/DataApiPlugin:d	Lcom/tencent/smtt/sdk/CookieManager;
    //   724: aload 4
    //   726: aload_1
    //   727: invokevirtual 143	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   730: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   733: ifeq +64 -> 797
    //   736: new 99	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   743: astore_2
    //   744: aload_2
    //   745: ldc_w 647
    //   748: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: pop
    //   752: aload_2
    //   753: aload_1
    //   754: iconst_0
    //   755: anewarray 86	java/lang/String
    //   758: invokestatic 113	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   761: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: pop
    //   765: aload_2
    //   766: ldc_w 649
    //   769: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: pop
    //   773: aload_2
    //   774: aload 4
    //   776: iconst_0
    //   777: anewarray 86	java/lang/String
    //   780: invokestatic 109	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   783: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: pop
    //   787: ldc 115
    //   789: iconst_2
    //   790: aload_2
    //   791: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   794: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   797: aload 19
    //   799: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   802: ifne +166 -> 968
    //   805: aload_0
    //   806: aload 4
    //   808: aload 19
    //   810: invokespecial 520	com/tencent/mobileqq/jsp/DataApiPlugin:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   813: aload 16
    //   815: aload 17
    //   817: aload 19
    //   819: invokeinterface 653 3 0
    //   824: astore_1
    //   825: aload_1
    //   826: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   829: ifne +139 -> 968
    //   832: aload 14
    //   834: ldc_w 655
    //   837: aload_1
    //   838: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   841: pop
    //   842: new 99	java/lang/StringBuilder
    //   845: dup
    //   846: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   849: astore_2
    //   850: aload_2
    //   851: ldc_w 513
    //   854: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: pop
    //   858: aload_2
    //   859: aload_1
    //   860: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: pop
    //   864: aload_2
    //   865: ldc_w 515
    //   868: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: pop
    //   872: aload_2
    //   873: aload 19
    //   875: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: pop
    //   879: aload_2
    //   880: bipush 59
    //   882: invokevirtual 518	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   885: pop
    //   886: aload_2
    //   887: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   890: astore_1
    //   891: aload_0
    //   892: getfield 125	com/tencent/mobileqq/jsp/DataApiPlugin:d	Lcom/tencent/smtt/sdk/CookieManager;
    //   895: aload 4
    //   897: aload_1
    //   898: invokevirtual 143	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   901: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   904: ifeq +64 -> 968
    //   907: new 99	java/lang/StringBuilder
    //   910: dup
    //   911: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   914: astore_2
    //   915: aload_2
    //   916: ldc_w 647
    //   919: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: pop
    //   923: aload_2
    //   924: aload_1
    //   925: iconst_0
    //   926: anewarray 86	java/lang/String
    //   929: invokestatic 113	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   932: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: pop
    //   936: aload_2
    //   937: ldc_w 649
    //   940: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: pop
    //   944: aload_2
    //   945: aload 4
    //   947: iconst_0
    //   948: anewarray 86	java/lang/String
    //   951: invokestatic 109	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   954: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: pop
    //   958: ldc 115
    //   960: iconst_2
    //   961: aload_2
    //   962: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   965: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   968: aload 12
    //   970: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   973: ifne +154 -> 1127
    //   976: aload 18
    //   978: aload 12
    //   980: invokestatic 657	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:b	(Lmqq/app/AppRuntime;Ljava/lang/String;)Ljava/lang/String;
    //   983: astore_1
    //   984: aload_1
    //   985: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   988: ifne +139 -> 1127
    //   991: aload 14
    //   993: ldc_w 402
    //   996: aload_1
    //   997: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1000: pop
    //   1001: new 99	java/lang/StringBuilder
    //   1004: dup
    //   1005: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   1008: astore_2
    //   1009: aload_2
    //   1010: ldc_w 533
    //   1013: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1016: pop
    //   1017: aload_2
    //   1018: aload_1
    //   1019: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1022: pop
    //   1023: aload_2
    //   1024: ldc_w 515
    //   1027: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1030: pop
    //   1031: aload_2
    //   1032: aload 12
    //   1034: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: pop
    //   1038: aload_2
    //   1039: bipush 59
    //   1041: invokevirtual 518	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1044: pop
    //   1045: aload_2
    //   1046: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1049: astore_1
    //   1050: aload_0
    //   1051: getfield 125	com/tencent/mobileqq/jsp/DataApiPlugin:d	Lcom/tencent/smtt/sdk/CookieManager;
    //   1054: aload 4
    //   1056: aload_1
    //   1057: invokevirtual 143	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   1060: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1063: ifeq +64 -> 1127
    //   1066: new 99	java/lang/StringBuilder
    //   1069: dup
    //   1070: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   1073: astore_2
    //   1074: aload_2
    //   1075: ldc_w 647
    //   1078: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: pop
    //   1082: aload_2
    //   1083: aload_1
    //   1084: iconst_0
    //   1085: anewarray 86	java/lang/String
    //   1088: invokestatic 113	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   1091: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1094: pop
    //   1095: aload_2
    //   1096: ldc_w 649
    //   1099: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1102: pop
    //   1103: aload_2
    //   1104: aload 4
    //   1106: iconst_0
    //   1107: anewarray 86	java/lang/String
    //   1110: invokestatic 109	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   1113: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: pop
    //   1117: ldc 115
    //   1119: iconst_2
    //   1120: aload_2
    //   1121: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1124: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1127: aload 15
    //   1129: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1132: ifne +147 -> 1279
    //   1135: aload 16
    //   1137: aload 17
    //   1139: invokeinterface 660 2 0
    //   1144: astore_1
    //   1145: aload_1
    //   1146: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1149: ifne +130 -> 1279
    //   1152: new 99	java/lang/StringBuilder
    //   1155: dup
    //   1156: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   1159: astore_2
    //   1160: aload_2
    //   1161: ldc_w 662
    //   1164: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1167: pop
    //   1168: aload_2
    //   1169: aload_1
    //   1170: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1173: pop
    //   1174: aload_2
    //   1175: ldc_w 515
    //   1178: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1181: pop
    //   1182: aload_2
    //   1183: aload 15
    //   1185: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1188: pop
    //   1189: aload_2
    //   1190: ldc_w 664
    //   1193: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: pop
    //   1197: aload_2
    //   1198: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1201: astore_1
    //   1202: aload_0
    //   1203: getfield 125	com/tencent/mobileqq/jsp/DataApiPlugin:d	Lcom/tencent/smtt/sdk/CookieManager;
    //   1206: aload 4
    //   1208: aload_1
    //   1209: invokevirtual 143	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   1212: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1215: ifeq +64 -> 1279
    //   1218: new 99	java/lang/StringBuilder
    //   1221: dup
    //   1222: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   1225: astore_2
    //   1226: aload_2
    //   1227: ldc_w 647
    //   1230: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1233: pop
    //   1234: aload_2
    //   1235: aload_1
    //   1236: iconst_0
    //   1237: anewarray 86	java/lang/String
    //   1240: invokestatic 113	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   1243: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: pop
    //   1247: aload_2
    //   1248: ldc_w 649
    //   1251: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: pop
    //   1255: aload_2
    //   1256: aload 4
    //   1258: iconst_0
    //   1259: anewarray 86	java/lang/String
    //   1262: invokestatic 109	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   1265: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1268: pop
    //   1269: ldc 115
    //   1271: iconst_2
    //   1272: aload_2
    //   1273: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1276: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1279: aload 13
    //   1281: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1284: ifne +72 -> 1356
    //   1287: aload_0
    //   1288: aload 13
    //   1290: iconst_1
    //   1291: anewarray 86	java/lang/String
    //   1294: dup
    //   1295: iconst_0
    //   1296: aload 14
    //   1298: invokevirtual 325	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1301: aastore
    //   1302: invokevirtual 274	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1305: goto +51 -> 1356
    //   1308: astore_1
    //   1309: aload_1
    //   1310: invokevirtual 667	org/json/JSONException:printStackTrace	()V
    //   1313: goto +43 -> 1356
    //   1316: ldc_w 669
    //   1319: aload 4
    //   1321: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1324: ifeq +34 -> 1358
    //   1327: new 671	com/tencent/mobileqq/jsp/DataApiPlugin$2
    //   1330: dup
    //   1331: aload_0
    //   1332: aload 5
    //   1334: iconst_0
    //   1335: aaload
    //   1336: aload_0
    //   1337: getfield 51	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1340: invokevirtual 540	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:a	()Lcom/tencent/biz/pubaccount/CustomWebView;
    //   1343: invokevirtual 545	com/tencent/biz/pubaccount/CustomWebView:getUrl	()Ljava/lang/String;
    //   1346: invokespecial 674	com/tencent/mobileqq/jsp/DataApiPlugin$2:<init>	(Lcom/tencent/mobileqq/jsp/DataApiPlugin;Ljava/lang/String;Ljava/lang/String;)V
    //   1349: bipush 8
    //   1351: aconst_null
    //   1352: iconst_1
    //   1353: invokestatic 680	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1356: iconst_1
    //   1357: ireturn
    //   1358: ldc_w 682
    //   1361: aload 4
    //   1363: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1366: ifeq +260 -> 1626
    //   1369: aload_0
    //   1370: getfield 51	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1373: invokevirtual 685	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   1376: invokevirtual 691	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   1379: astore_1
    //   1380: aload_1
    //   1381: ldc_w 693
    //   1384: iconst_m1
    //   1385: invokevirtual 699	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   1388: istore 6
    //   1390: new 188	org/json/JSONObject
    //   1393: dup
    //   1394: invokespecial 307	org/json/JSONObject:<init>	()V
    //   1397: astore_2
    //   1398: aload_0
    //   1399: getfield 51	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1402: invokevirtual 56	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   1405: invokevirtual 72	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1408: astore_3
    //   1409: new 188	org/json/JSONObject
    //   1412: dup
    //   1413: aload 5
    //   1415: iconst_0
    //   1416: aaload
    //   1417: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1420: ldc_w 266
    //   1423: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1426: astore 4
    //   1428: aload_2
    //   1429: ldc 135
    //   1431: aload_3
    //   1432: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1435: pop
    //   1436: iload 6
    //   1438: iconst_m1
    //   1439: if_icmpne +17 -> 1456
    //   1442: aload_2
    //   1443: ldc_w 701
    //   1446: ldc_w 703
    //   1449: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1452: pop
    //   1453: goto +125 -> 1578
    //   1456: iload 6
    //   1458: iconst_1
    //   1459: if_icmpne +32 -> 1491
    //   1462: aload_2
    //   1463: ldc_w 705
    //   1466: aload_1
    //   1467: ldc_w 707
    //   1470: invokevirtual 710	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1473: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1476: pop
    //   1477: aload_2
    //   1478: ldc_w 701
    //   1481: ldc_w 712
    //   1484: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1487: pop
    //   1488: goto +75 -> 1563
    //   1491: iload 6
    //   1493: sipush 3000
    //   1496: if_icmpne +32 -> 1528
    //   1499: aload_2
    //   1500: ldc_w 714
    //   1503: aload_1
    //   1504: ldc_w 714
    //   1507: invokevirtual 710	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1510: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1513: pop
    //   1514: aload_2
    //   1515: ldc_w 701
    //   1518: ldc_w 716
    //   1521: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1524: pop
    //   1525: goto +38 -> 1563
    //   1528: aload_1
    //   1529: ldc_w 718
    //   1532: invokevirtual 710	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1535: astore_3
    //   1536: aload_3
    //   1537: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1540: ifne +12 -> 1552
    //   1543: aload_2
    //   1544: ldc_w 718
    //   1547: aload_3
    //   1548: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1551: pop
    //   1552: aload_2
    //   1553: ldc_w 701
    //   1556: ldc_w 720
    //   1559: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1562: pop
    //   1563: aload_2
    //   1564: ldc_w 722
    //   1567: aload_1
    //   1568: ldc_w 724
    //   1571: invokevirtual 710	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1574: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1577: pop
    //   1578: aload 4
    //   1580: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1583: ifne -227 -> 1356
    //   1586: aload_0
    //   1587: aload 4
    //   1589: iconst_1
    //   1590: anewarray 86	java/lang/String
    //   1593: dup
    //   1594: iconst_0
    //   1595: aload_2
    //   1596: invokevirtual 325	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1599: aastore
    //   1600: invokevirtual 274	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1603: goto -247 -> 1356
    //   1606: astore_1
    //   1607: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1610: ifeq -254 -> 1356
    //   1613: ldc 115
    //   1615: iconst_2
    //   1616: ldc_w 726
    //   1619: aload_1
    //   1620: invokestatic 730	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1623: goto -267 -> 1356
    //   1626: ldc_w 732
    //   1629: aload 4
    //   1631: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1634: ifeq +111 -> 1745
    //   1637: new 188	org/json/JSONObject
    //   1640: dup
    //   1641: aload 5
    //   1643: iconst_0
    //   1644: aaload
    //   1645: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1648: astore_2
    //   1649: aload_2
    //   1650: ldc_w 266
    //   1653: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1656: astore_1
    //   1657: aload_2
    //   1658: ldc 135
    //   1660: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1663: astore_2
    //   1664: aload_2
    //   1665: aload_0
    //   1666: getfield 51	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1669: invokevirtual 56	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   1672: invokevirtual 72	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   1675: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1678: ifeq -322 -> 1356
    //   1681: aload_1
    //   1682: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1685: ifne -329 -> 1356
    //   1688: new 734	android/os/Bundle
    //   1691: dup
    //   1692: invokespecial 735	android/os/Bundle:<init>	()V
    //   1695: astore_3
    //   1696: aload_3
    //   1697: ldc 135
    //   1699: aload_2
    //   1700: invokevirtual 738	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1703: ldc_w 740
    //   1706: aload_1
    //   1707: aload_0
    //   1708: getfield 39	com/tencent/mobileqq/jsp/DataApiPlugin:b	Lcom/tencent/mobileqq/emosm/OnRemoteRespObserver;
    //   1711: getfield 744	com/tencent/mobileqq/emosm/OnRemoteRespObserver:key	I
    //   1714: aload_3
    //   1715: invokestatic 749	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   1718: astore_1
    //   1719: ldc_w 751
    //   1722: invokestatic 757	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1725: checkcast 751	com/tencent/mobileqq/emosm/api/IWebIPCOperatorApi
    //   1728: aload_1
    //   1729: invokeinterface 761 2 0
    //   1734: goto -378 -> 1356
    //   1737: astore_1
    //   1738: aload_1
    //   1739: invokevirtual 667	org/json/JSONException:printStackTrace	()V
    //   1742: goto -386 -> 1356
    //   1745: ldc_w 763
    //   1748: aload 4
    //   1750: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1753: istore 9
    //   1755: ldc_w 765
    //   1758: astore_1
    //   1759: iload 9
    //   1761: ifeq +135 -> 1896
    //   1764: aload 5
    //   1766: arraylength
    //   1767: iconst_1
    //   1768: if_icmpne +128 -> 1896
    //   1771: new 188	org/json/JSONObject
    //   1774: dup
    //   1775: aload 5
    //   1777: iconst_0
    //   1778: aaload
    //   1779: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1782: astore_2
    //   1783: aload_2
    //   1784: ldc_w 266
    //   1787: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1790: astore_3
    //   1791: aload_3
    //   1792: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1795: ifne -439 -> 1356
    //   1798: ldc_w 767
    //   1801: aload_2
    //   1802: ldc_w 355
    //   1805: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1808: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1811: ifeq +23 -> 1834
    //   1814: aload_0
    //   1815: aload_3
    //   1816: iconst_1
    //   1817: anewarray 86	java/lang/String
    //   1820: dup
    //   1821: iconst_0
    //   1822: getstatic 772	com/tencent/mobileqq/activity/QQBrowserActivity:sQQBrowserActivityCounter	I
    //   1825: invokestatic 774	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   1828: aastore
    //   1829: invokevirtual 274	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1832: iconst_1
    //   1833: ireturn
    //   1834: aload_0
    //   1835: getfield 51	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   1838: invokevirtual 685	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   1841: astore_2
    //   1842: aload_2
    //   1843: ifnull +3515 -> 5358
    //   1846: aload_2
    //   1847: invokevirtual 691	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   1850: ldc_w 776
    //   1853: invokevirtual 710	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   1856: astore_2
    //   1857: goto +3 -> 1860
    //   1860: aload_2
    //   1861: ifnonnull +6 -> 1867
    //   1864: goto +8 -> 1872
    //   1867: aload_2
    //   1868: invokestatic 778	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;)Ljava/lang/String;
    //   1871: astore_1
    //   1872: aload_0
    //   1873: aload_3
    //   1874: iconst_1
    //   1875: anewarray 86	java/lang/String
    //   1878: dup
    //   1879: iconst_0
    //   1880: aload_1
    //   1881: aastore
    //   1882: invokevirtual 274	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1885: goto -529 -> 1356
    //   1888: astore_1
    //   1889: aload_1
    //   1890: invokevirtual 667	org/json/JSONException:printStackTrace	()V
    //   1893: goto -537 -> 1356
    //   1896: ldc_w 780
    //   1899: aload 4
    //   1901: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1904: ifeq +137 -> 2041
    //   1907: aload 5
    //   1909: arraylength
    //   1910: iconst_1
    //   1911: if_icmpne +130 -> 2041
    //   1914: new 188	org/json/JSONObject
    //   1917: dup
    //   1918: aload 5
    //   1920: iconst_0
    //   1921: aaload
    //   1922: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1925: astore_1
    //   1926: aload_1
    //   1927: ldc_w 782
    //   1930: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1933: astore_3
    //   1934: aload_1
    //   1935: ldc_w 266
    //   1938: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1941: astore_1
    //   1942: aload_3
    //   1943: astore_2
    //   1944: aload_3
    //   1945: ifnonnull +7 -> 1952
    //   1948: ldc_w 765
    //   1951: astore_2
    //   1952: invokestatic 580	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1955: ldc_w 784
    //   1958: invokevirtual 788	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1961: checkcast 790	android/text/ClipboardManager
    //   1964: astore 4
    //   1966: aload_1
    //   1967: astore_3
    //   1968: aload 4
    //   1970: ifnull +46 -> 2016
    //   1973: aload 4
    //   1975: aload_2
    //   1976: invokevirtual 794	android/text/ClipboardManager:setText	(Ljava/lang/CharSequence;)V
    //   1979: aload_1
    //   1980: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1983: ifne +18 -> 2001
    //   1986: aload_0
    //   1987: aload_1
    //   1988: iconst_1
    //   1989: anewarray 86	java/lang/String
    //   1992: dup
    //   1993: iconst_0
    //   1994: ldc_w 796
    //   1997: aastore
    //   1998: invokevirtual 274	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2001: iconst_1
    //   2002: ireturn
    //   2003: astore_2
    //   2004: goto +6 -> 2010
    //   2007: astore_2
    //   2008: aconst_null
    //   2009: astore_1
    //   2010: aload_2
    //   2011: invokevirtual 667	org/json/JSONException:printStackTrace	()V
    //   2014: aload_1
    //   2015: astore_3
    //   2016: aload_3
    //   2017: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2020: ifne -664 -> 1356
    //   2023: aload_0
    //   2024: aload_3
    //   2025: iconst_1
    //   2026: anewarray 86	java/lang/String
    //   2029: dup
    //   2030: iconst_0
    //   2031: ldc_w 798
    //   2034: aastore
    //   2035: invokevirtual 274	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2038: goto -682 -> 1356
    //   2041: ldc_w 800
    //   2044: aload 4
    //   2046: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2049: ifeq +140 -> 2189
    //   2052: aload 5
    //   2054: arraylength
    //   2055: iconst_1
    //   2056: if_icmpne +133 -> 2189
    //   2059: new 188	org/json/JSONObject
    //   2062: dup
    //   2063: aload 5
    //   2065: iconst_0
    //   2066: aaload
    //   2067: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2070: ldc_w 266
    //   2073: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2076: astore_3
    //   2077: aload_3
    //   2078: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2081: ifne -725 -> 1356
    //   2084: invokestatic 580	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2087: ldc_w 784
    //   2090: invokevirtual 788	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   2093: checkcast 790	android/text/ClipboardManager
    //   2096: astore 4
    //   2098: aload_1
    //   2099: astore_2
    //   2100: aload 4
    //   2102: ifnull +25 -> 2127
    //   2105: aload 4
    //   2107: invokevirtual 804	android/text/ClipboardManager:getText	()Ljava/lang/CharSequence;
    //   2110: astore 4
    //   2112: aload_1
    //   2113: astore_2
    //   2114: aload 4
    //   2116: ifnull +11 -> 2127
    //   2119: aload 4
    //   2121: invokeinterface 807 1 0
    //   2126: astore_2
    //   2127: aload_0
    //   2128: aload_3
    //   2129: iconst_1
    //   2130: anewarray 86	java/lang/String
    //   2133: dup
    //   2134: iconst_0
    //   2135: aload_2
    //   2136: invokestatic 778	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;)Ljava/lang/String;
    //   2139: aastore
    //   2140: invokevirtual 274	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2143: goto -787 -> 1356
    //   2146: astore_1
    //   2147: new 99	java/lang/StringBuilder
    //   2150: dup
    //   2151: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   2154: astore_2
    //   2155: aload_2
    //   2156: ldc_w 809
    //   2159: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2162: pop
    //   2163: aload_2
    //   2164: aload_1
    //   2165: invokevirtual 455	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2168: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2171: pop
    //   2172: ldc 115
    //   2174: iconst_1
    //   2175: aload_2
    //   2176: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2179: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2182: aload_1
    //   2183: invokevirtual 810	java/lang/Exception:printStackTrace	()V
    //   2186: goto -830 -> 1356
    //   2189: ldc_w 812
    //   2192: aload 4
    //   2194: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2197: ifeq +207 -> 2404
    //   2200: aload 5
    //   2202: arraylength
    //   2203: iconst_1
    //   2204: if_icmpne +200 -> 2404
    //   2207: new 188	org/json/JSONObject
    //   2210: dup
    //   2211: aload 5
    //   2213: iconst_0
    //   2214: aaload
    //   2215: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2218: astore_1
    //   2219: aload_1
    //   2220: ldc_w 814
    //   2223: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2226: astore_2
    //   2227: aload_1
    //   2228: ldc_w 816
    //   2231: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2234: astore_3
    //   2235: aload_1
    //   2236: ldc_w 818
    //   2239: iconst_1
    //   2240: invokevirtual 822	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2243: istore 9
    //   2245: aload_1
    //   2246: ldc_w 266
    //   2249: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2252: astore 4
    //   2254: new 188	org/json/JSONObject
    //   2257: dup
    //   2258: invokespecial 307	org/json/JSONObject:<init>	()V
    //   2261: astore 5
    //   2263: aload_2
    //   2264: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2267: ifne +66 -> 2333
    //   2270: aload_3
    //   2271: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2274: ifne +59 -> 2333
    //   2277: aload_0
    //   2278: getfield 51	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2281: invokevirtual 56	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   2284: astore_1
    //   2285: aload_1
    //   2286: instanceof 824
    //   2289: ifeq +3074 -> 5363
    //   2292: aload_1
    //   2293: checkcast 824	com/tencent/mobileqq/app/QQAppInterface
    //   2296: astore_1
    //   2297: goto +3 -> 2300
    //   2300: aload_1
    //   2301: aload_2
    //   2302: aload_3
    //   2303: iload 9
    //   2305: invokestatic 829	com/tencent/mobileqq/statistics/DcReportUtil:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Z)V
    //   2308: aload 5
    //   2310: ldc_w 309
    //   2313: iconst_0
    //   2314: invokevirtual 313	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2317: pop
    //   2318: aload 5
    //   2320: ldc_w 315
    //   2323: ldc_w 831
    //   2326: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2329: pop
    //   2330: goto +25 -> 2355
    //   2333: aload 5
    //   2335: ldc_w 309
    //   2338: iconst_m1
    //   2339: invokevirtual 313	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   2342: pop
    //   2343: aload 5
    //   2345: ldc_w 315
    //   2348: ldc_w 833
    //   2351: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   2354: pop
    //   2355: aload 4
    //   2357: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2360: ifne -1004 -> 1356
    //   2363: aload_0
    //   2364: aload 4
    //   2366: iconst_1
    //   2367: anewarray 86	java/lang/String
    //   2370: dup
    //   2371: iconst_0
    //   2372: aload 5
    //   2374: invokevirtual 325	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2377: aastore
    //   2378: invokevirtual 274	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   2381: goto -1025 -> 1356
    //   2384: astore_1
    //   2385: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2388: ifeq -1032 -> 1356
    //   2391: ldc 115
    //   2393: iconst_2
    //   2394: aload_1
    //   2395: invokevirtual 455	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2398: invokestatic 835	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2401: goto -1045 -> 1356
    //   2404: ldc_w 837
    //   2407: aload 4
    //   2409: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2412: ifeq +475 -> 2887
    //   2415: aload 5
    //   2417: arraylength
    //   2418: iconst_1
    //   2419: if_icmpne +468 -> 2887
    //   2422: new 188	org/json/JSONObject
    //   2425: dup
    //   2426: aload 5
    //   2428: iconst_0
    //   2429: aaload
    //   2430: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2433: astore_1
    //   2434: aload_1
    //   2435: ldc_w 839
    //   2438: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2441: astore_3
    //   2442: aload_1
    //   2443: ldc_w 841
    //   2446: invokevirtual 194	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2449: astore_1
    //   2450: aload_0
    //   2451: getfield 51	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2454: invokevirtual 56	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   2457: astore_2
    //   2458: ldc_w 843
    //   2461: aload_3
    //   2462: invokevirtual 846	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2465: ifeq +213 -> 2678
    //   2468: aload_1
    //   2469: ldc_w 848
    //   2472: ldc_w 765
    //   2475: invokevirtual 850	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2478: astore_3
    //   2479: aload_1
    //   2480: ldc_w 852
    //   2483: invokevirtual 854	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2486: astore 4
    //   2488: aload_1
    //   2489: ldc_w 856
    //   2492: invokevirtual 854	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2495: astore 5
    //   2497: aload_1
    //   2498: ldc_w 858
    //   2501: invokevirtual 854	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2504: astore 11
    //   2506: aload_1
    //   2507: ldc_w 860
    //   2510: ldc_w 765
    //   2513: invokevirtual 850	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2516: astore 12
    //   2518: aload_1
    //   2519: ldc_w 862
    //   2522: iconst_0
    //   2523: invokevirtual 865	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2526: istore 6
    //   2528: aload_1
    //   2529: ldc_w 867
    //   2532: iconst_1
    //   2533: invokevirtual 865	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2536: istore 7
    //   2538: aload_1
    //   2539: ldc_w 869
    //   2542: iconst_0
    //   2543: invokevirtual 865	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2546: istore 8
    //   2548: aload_1
    //   2549: ldc_w 871
    //   2552: ldc_w 765
    //   2555: invokevirtual 850	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2558: astore 13
    //   2560: aload_1
    //   2561: ldc_w 873
    //   2564: ldc_w 765
    //   2567: invokevirtual 850	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2570: astore 14
    //   2572: aload_1
    //   2573: ldc_w 875
    //   2576: ldc_w 765
    //   2579: invokevirtual 850	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2582: astore 15
    //   2584: aload_1
    //   2585: ldc_w 877
    //   2588: ldc_w 765
    //   2591: invokevirtual 850	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   2594: astore 16
    //   2596: aload_2
    //   2597: instanceof 824
    //   2600: ifeq +2768 -> 5368
    //   2603: aload_2
    //   2604: checkcast 824	com/tencent/mobileqq/app/QQAppInterface
    //   2607: astore_1
    //   2608: goto +3 -> 2611
    //   2611: aload_2
    //   2612: invokevirtual 68	com/tencent/common/app/AppInterface:isLogin	()Z
    //   2615: ifeq +33 -> 2648
    //   2618: aload_1
    //   2619: aload 4
    //   2621: aload_3
    //   2622: aload 12
    //   2624: aload 5
    //   2626: aload 11
    //   2628: iload 6
    //   2630: iload 7
    //   2632: iload 8
    //   2634: aload 13
    //   2636: aload 14
    //   2638: aload 15
    //   2640: aload 16
    //   2642: invokestatic 882	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2645: goto -1289 -> 1356
    //   2648: aload_1
    //   2649: aload 4
    //   2651: aload_3
    //   2652: aload 12
    //   2654: aload 5
    //   2656: aload 11
    //   2658: iload 6
    //   2660: iload 7
    //   2662: iload 8
    //   2664: aload 13
    //   2666: aload 14
    //   2668: aload 15
    //   2670: aload 16
    //   2672: invokestatic 884	com/tencent/mobileqq/statistics/ReportController:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2675: goto -1319 -> 1356
    //   2678: ldc_w 886
    //   2681: aload_3
    //   2682: invokevirtual 846	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2685: ifeq +164 -> 2849
    //   2688: aload_1
    //   2689: ldc_w 888
    //   2692: invokevirtual 854	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2695: astore_3
    //   2696: aload_1
    //   2697: ldc_w 890
    //   2700: iconst_1
    //   2701: invokevirtual 822	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2704: istore 9
    //   2706: aload_1
    //   2707: ldc_w 892
    //   2710: iconst_1
    //   2711: invokevirtual 822	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   2714: istore 10
    //   2716: aload_1
    //   2717: ldc_w 894
    //   2720: iconst_0
    //   2721: invokevirtual 865	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2724: istore 6
    //   2726: aload_1
    //   2727: ldc_w 896
    //   2730: iconst_0
    //   2731: invokevirtual 865	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2734: istore 7
    //   2736: new 898	java/util/HashMap
    //   2739: dup
    //   2740: invokespecial 899	java/util/HashMap:<init>	()V
    //   2743: astore 4
    //   2745: aload_1
    //   2746: ldc_w 901
    //   2749: invokevirtual 904	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   2752: astore_1
    //   2753: aload_1
    //   2754: ifnull +53 -> 2807
    //   2757: aload_1
    //   2758: invokevirtual 908	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   2761: astore 5
    //   2763: aload 5
    //   2765: ifnull +42 -> 2807
    //   2768: aload 5
    //   2770: invokeinterface 913 1 0
    //   2775: ifeq +32 -> 2807
    //   2778: aload 5
    //   2780: invokeinterface 917 1 0
    //   2785: checkcast 86	java/lang/String
    //   2788: astore 11
    //   2790: aload 4
    //   2792: aload 11
    //   2794: aload_1
    //   2795: aload 11
    //   2797: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2800: invokevirtual 920	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2803: pop
    //   2804: goto -41 -> 2763
    //   2807: aload_2
    //   2808: invokevirtual 68	com/tencent/common/app/AppInterface:isLogin	()Z
    //   2811: ifeq +2562 -> 5373
    //   2814: aload_2
    //   2815: invokevirtual 72	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   2818: astore_1
    //   2819: goto +3 -> 2822
    //   2822: aconst_null
    //   2823: invokestatic 925	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2826: aload_1
    //   2827: aload_3
    //   2828: iload 10
    //   2830: iload 6
    //   2832: i2l
    //   2833: iload 7
    //   2835: i2l
    //   2836: aload 4
    //   2838: ldc_w 765
    //   2841: iload 9
    //   2843: invokevirtual 929	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   2846: goto -1490 -> 1356
    //   2849: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2852: ifeq -1496 -> 1356
    //   2855: ldc 115
    //   2857: iconst_2
    //   2858: ldc_w 931
    //   2861: invokestatic 835	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2864: goto -1508 -> 1356
    //   2867: astore_1
    //   2868: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2871: ifeq -1515 -> 1356
    //   2874: ldc 115
    //   2876: iconst_2
    //   2877: aload_1
    //   2878: invokevirtual 932	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2881: invokestatic 835	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2884: goto -1528 -> 1356
    //   2887: ldc_w 934
    //   2890: aload 4
    //   2892: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2895: ifeq +190 -> 3085
    //   2898: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2901: ifeq +12 -> 2913
    //   2904: ldc 115
    //   2906: iconst_2
    //   2907: ldc_w 934
    //   2910: invokestatic 153	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2913: new 188	org/json/JSONObject
    //   2916: dup
    //   2917: aload 5
    //   2919: iconst_0
    //   2920: aaload
    //   2921: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   2924: astore_2
    //   2925: aload_2
    //   2926: ldc_w 266
    //   2929: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2932: astore_1
    //   2933: aload_2
    //   2934: ldc 135
    //   2936: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   2939: astore_2
    //   2940: aload_1
    //   2941: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2944: ifne +78 -> 3022
    //   2947: new 734	android/os/Bundle
    //   2950: dup
    //   2951: invokespecial 735	android/os/Bundle:<init>	()V
    //   2954: astore_3
    //   2955: aload_2
    //   2956: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2959: ifne +13 -> 2972
    //   2962: aload_3
    //   2963: ldc 135
    //   2965: aload_2
    //   2966: invokevirtual 738	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2969: goto +19 -> 2988
    //   2972: aload_3
    //   2973: ldc 135
    //   2975: aload_0
    //   2976: getfield 51	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   2979: invokevirtual 56	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   2982: invokevirtual 72	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   2985: invokevirtual 738	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2988: ldc_w 936
    //   2991: aload_1
    //   2992: aload_0
    //   2993: getfield 39	com/tencent/mobileqq/jsp/DataApiPlugin:b	Lcom/tencent/mobileqq/emosm/OnRemoteRespObserver;
    //   2996: getfield 744	com/tencent/mobileqq/emosm/OnRemoteRespObserver:key	I
    //   2999: aload_3
    //   3000: invokestatic 749	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   3003: astore_1
    //   3004: ldc_w 751
    //   3007: invokestatic 757	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3010: checkcast 751	com/tencent/mobileqq/emosm/api/IWebIPCOperatorApi
    //   3013: aload_1
    //   3014: invokeinterface 761 2 0
    //   3019: goto -1663 -> 1356
    //   3022: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3025: ifeq -1669 -> 1356
    //   3028: ldc 115
    //   3030: iconst_2
    //   3031: ldc_w 938
    //   3034: invokestatic 153	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3037: goto -1681 -> 1356
    //   3040: astore_1
    //   3041: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3044: ifeq -1688 -> 1356
    //   3047: new 99	java/lang/StringBuilder
    //   3050: dup
    //   3051: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   3054: astore_2
    //   3055: aload_2
    //   3056: ldc_w 940
    //   3059: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3062: pop
    //   3063: aload_2
    //   3064: aload_1
    //   3065: invokevirtual 932	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   3068: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3071: pop
    //   3072: ldc 115
    //   3074: iconst_2
    //   3075: aload_2
    //   3076: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3079: invokestatic 835	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3082: goto -1726 -> 1356
    //   3085: ldc_w 942
    //   3088: aload 4
    //   3090: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3093: ifeq +131 -> 3224
    //   3096: aload 5
    //   3098: arraylength
    //   3099: iconst_1
    //   3100: if_icmpne +124 -> 3224
    //   3103: new 188	org/json/JSONObject
    //   3106: dup
    //   3107: aload 5
    //   3109: iconst_0
    //   3110: aaload
    //   3111: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3114: ldc_w 266
    //   3117: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3120: astore_1
    //   3121: aload_1
    //   3122: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3125: ifne -1769 -> 1356
    //   3128: new 99	java/lang/StringBuilder
    //   3131: dup
    //   3132: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   3135: astore_2
    //   3136: aload_2
    //   3137: ldc_w 944
    //   3140: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3143: pop
    //   3144: aload_2
    //   3145: invokestatic 948	com/tencent/common/config/AppSetting:d	()I
    //   3148: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3151: pop
    //   3152: aload_2
    //   3153: ldc_w 950
    //   3156: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3159: pop
    //   3160: aload_0
    //   3161: aload_1
    //   3162: iconst_1
    //   3163: anewarray 86	java/lang/String
    //   3166: dup
    //   3167: iconst_0
    //   3168: aload_2
    //   3169: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3172: aastore
    //   3173: invokevirtual 274	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3176: goto -1820 -> 1356
    //   3179: astore_1
    //   3180: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3183: ifeq -1827 -> 1356
    //   3186: new 99	java/lang/StringBuilder
    //   3189: dup
    //   3190: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   3193: astore_2
    //   3194: aload_2
    //   3195: ldc_w 952
    //   3198: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3201: pop
    //   3202: aload_2
    //   3203: aload_1
    //   3204: invokevirtual 932	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   3207: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3210: pop
    //   3211: ldc 115
    //   3213: iconst_2
    //   3214: aload_2
    //   3215: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3218: invokestatic 835	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3221: goto -1865 -> 1356
    //   3224: ldc_w 954
    //   3227: aload 4
    //   3229: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3232: ifeq +619 -> 3851
    //   3235: aload 5
    //   3237: arraylength
    //   3238: iconst_1
    //   3239: if_icmpne +612 -> 3851
    //   3242: new 188	org/json/JSONObject
    //   3245: dup
    //   3246: aload 5
    //   3248: iconst_0
    //   3249: aaload
    //   3250: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3253: astore_2
    //   3254: aload_2
    //   3255: ldc_w 266
    //   3258: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3261: astore_3
    //   3262: aload_2
    //   3263: ldc_w 956
    //   3266: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3269: astore_2
    //   3270: aload_2
    //   3271: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3274: ifne +2117 -> 5391
    //   3277: aload_2
    //   3278: invokevirtual 959	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   3281: astore 4
    //   3283: aload_0
    //   3284: getfield 51	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   3287: invokevirtual 56	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:b	()Lcom/tencent/common/app/AppInterface;
    //   3290: astore_2
    //   3291: aload_2
    //   3292: ifnull +2099 -> 5391
    //   3295: aload_2
    //   3296: invokevirtual 68	com/tencent/common/app/AppInterface:isLogin	()Z
    //   3299: ifeq +2092 -> 5391
    //   3302: aload_2
    //   3303: invokevirtual 72	com/tencent/common/app/AppInterface:getAccount	()Ljava/lang/String;
    //   3306: astore 11
    //   3308: aload_2
    //   3309: iconst_2
    //   3310: invokevirtual 562	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3313: checkcast 564	mqq/manager/TicketManager
    //   3316: astore 5
    //   3318: aload 5
    //   3320: aload 11
    //   3322: aload 4
    //   3324: invokeinterface 653 3 0
    //   3329: astore_2
    //   3330: aload 5
    //   3332: aload 11
    //   3334: aload 4
    //   3336: invokeinterface 962 3 0
    //   3341: astore 5
    //   3343: aload_2
    //   3344: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3347: ifne +2044 -> 5391
    //   3350: new 99	java/lang/StringBuilder
    //   3353: dup
    //   3354: bipush 111
    //   3356: invokespecial 964	java/lang/StringBuilder:<init>	(I)V
    //   3359: astore 13
    //   3361: aload 11
    //   3363: invokevirtual 967	java/lang/String:length	()I
    //   3366: bipush 10
    //   3368: if_icmpge +34 -> 3402
    //   3371: aload 11
    //   3373: invokevirtual 967	java/lang/String:length	()I
    //   3376: istore 6
    //   3378: iload 6
    //   3380: bipush 10
    //   3382: if_icmpge +20 -> 3402
    //   3385: aload 13
    //   3387: bipush 48
    //   3389: invokevirtual 518	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3392: pop
    //   3393: iload 6
    //   3395: iconst_1
    //   3396: iadd
    //   3397: istore 6
    //   3399: goto -21 -> 3378
    //   3402: aload 13
    //   3404: aload 11
    //   3406: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3409: pop
    //   3410: invokestatic 78	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   3413: astore 11
    //   3415: aload 11
    //   3417: iconst_1
    //   3418: invokevirtual 129	com/tencent/smtt/sdk/CookieManager:setAcceptCookie	(Z)V
    //   3421: new 99	java/lang/StringBuilder
    //   3424: dup
    //   3425: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   3428: astore 12
    //   3430: aload 12
    //   3432: ldc_w 969
    //   3435: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3438: pop
    //   3439: aload 12
    //   3441: aload 4
    //   3443: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3446: pop
    //   3447: aload 12
    //   3449: bipush 47
    //   3451: invokevirtual 518	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3454: pop
    //   3455: aload 12
    //   3457: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3460: astore 12
    //   3462: new 99	java/lang/StringBuilder
    //   3465: dup
    //   3466: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   3469: astore 14
    //   3471: aload 14
    //   3473: ldc_w 284
    //   3476: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3479: pop
    //   3480: aload 14
    //   3482: aload 13
    //   3484: invokevirtual 972	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   3487: pop
    //   3488: aload 14
    //   3490: ldc_w 515
    //   3493: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3496: pop
    //   3497: aload 14
    //   3499: aload 4
    //   3501: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3504: pop
    //   3505: aload 14
    //   3507: bipush 59
    //   3509: invokevirtual 518	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3512: pop
    //   3513: aload 14
    //   3515: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3518: astore 13
    //   3520: aload 11
    //   3522: aload 12
    //   3524: aload 13
    //   3526: invokevirtual 143	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   3529: aload_2
    //   3530: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3533: ifne +1845 -> 5378
    //   3536: new 99	java/lang/StringBuilder
    //   3539: dup
    //   3540: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   3543: astore 14
    //   3545: aload 14
    //   3547: ldc_w 513
    //   3550: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3553: pop
    //   3554: aload 14
    //   3556: aload_2
    //   3557: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3560: pop
    //   3561: aload 14
    //   3563: ldc_w 515
    //   3566: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3569: pop
    //   3570: aload 14
    //   3572: aload 4
    //   3574: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3577: pop
    //   3578: aload 14
    //   3580: bipush 59
    //   3582: invokevirtual 518	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3585: pop
    //   3586: aload 14
    //   3588: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3591: astore_2
    //   3592: aload 11
    //   3594: aload 12
    //   3596: aload_2
    //   3597: invokevirtual 143	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   3600: goto +3 -> 3603
    //   3603: aload 5
    //   3605: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3608: ifne +61 -> 3669
    //   3611: new 99	java/lang/StringBuilder
    //   3614: dup
    //   3615: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   3618: astore_1
    //   3619: aload_1
    //   3620: ldc_w 533
    //   3623: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3626: pop
    //   3627: aload_1
    //   3628: aload 5
    //   3630: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3633: pop
    //   3634: aload_1
    //   3635: ldc_w 515
    //   3638: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3641: pop
    //   3642: aload_1
    //   3643: aload 4
    //   3645: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3648: pop
    //   3649: aload_1
    //   3650: bipush 59
    //   3652: invokevirtual 518	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3655: pop
    //   3656: aload_1
    //   3657: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3660: astore_1
    //   3661: aload 11
    //   3663: aload 12
    //   3665: aload_1
    //   3666: invokevirtual 143	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   3669: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3672: ifeq +1713 -> 5385
    //   3675: new 99	java/lang/StringBuilder
    //   3678: dup
    //   3679: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   3682: astore 4
    //   3684: aload 4
    //   3686: ldc_w 647
    //   3689: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3692: pop
    //   3693: aload 4
    //   3695: aload 13
    //   3697: iconst_0
    //   3698: anewarray 86	java/lang/String
    //   3701: invokestatic 113	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3704: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3707: pop
    //   3708: aload 4
    //   3710: aload_2
    //   3711: iconst_0
    //   3712: anewarray 86	java/lang/String
    //   3715: invokestatic 113	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3718: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3721: pop
    //   3722: aload 4
    //   3724: aload_1
    //   3725: iconst_0
    //   3726: anewarray 86	java/lang/String
    //   3729: invokestatic 113	com/tencent/biz/common/util/Util:c	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3732: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3735: pop
    //   3736: aload 4
    //   3738: ldc_w 649
    //   3741: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3744: pop
    //   3745: aload 4
    //   3747: aload 12
    //   3749: iconst_0
    //   3750: anewarray 86	java/lang/String
    //   3753: invokestatic 109	com/tencent/biz/common/util/Util:b	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   3756: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3759: pop
    //   3760: ldc 115
    //   3762: iconst_2
    //   3763: aload 4
    //   3765: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3768: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3771: goto +1614 -> 5385
    //   3774: aload_3
    //   3775: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3778: ifne -2422 -> 1356
    //   3781: new 99	java/lang/StringBuilder
    //   3784: dup
    //   3785: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   3788: astore_1
    //   3789: aload_1
    //   3790: ldc_w 974
    //   3793: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3796: pop
    //   3797: aload_1
    //   3798: iload 6
    //   3800: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3803: pop
    //   3804: aload_1
    //   3805: ldc_w 950
    //   3808: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3811: pop
    //   3812: aload_0
    //   3813: aload_3
    //   3814: iconst_1
    //   3815: anewarray 86	java/lang/String
    //   3818: dup
    //   3819: iconst_0
    //   3820: aload_1
    //   3821: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3824: aastore
    //   3825: invokevirtual 274	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3828: goto -2472 -> 1356
    //   3831: astore_1
    //   3832: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3835: ifeq -2479 -> 1356
    //   3838: ldc 115
    //   3840: iconst_2
    //   3841: ldc_w 976
    //   3844: aload_1
    //   3845: invokestatic 730	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3848: goto -2492 -> 1356
    //   3851: ldc_w 978
    //   3854: aload 4
    //   3856: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3859: ifeq +13 -> 3872
    //   3862: aload_0
    //   3863: aload_2
    //   3864: aload 5
    //   3866: invokespecial 980	com/tencent/mobileqq/jsp/DataApiPlugin:a	(Ljava/lang/String;[Ljava/lang/String;)V
    //   3869: goto -2513 -> 1356
    //   3872: ldc_w 982
    //   3875: aload 4
    //   3877: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3880: ifeq +139 -> 4019
    //   3883: new 188	org/json/JSONObject
    //   3886: dup
    //   3887: aload 5
    //   3889: iconst_0
    //   3890: aaload
    //   3891: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3894: astore_1
    //   3895: aload_1
    //   3896: ldc_w 266
    //   3899: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3902: astore_2
    //   3903: aload_1
    //   3904: ldc 135
    //   3906: invokevirtual 854	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3909: astore_1
    //   3910: ldc_w 751
    //   3913: invokestatic 757	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3916: checkcast 751	com/tencent/mobileqq/emosm/api/IWebIPCOperatorApi
    //   3919: invokeinterface 985 1 0
    //   3924: ifeq -2568 -> 1356
    //   3927: new 734	android/os/Bundle
    //   3930: dup
    //   3931: invokespecial 735	android/os/Bundle:<init>	()V
    //   3934: astore_3
    //   3935: aload_3
    //   3936: ldc 135
    //   3938: aload_1
    //   3939: invokevirtual 738	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3942: ldc_w 987
    //   3945: aload_2
    //   3946: aload_0
    //   3947: getfield 39	com/tencent/mobileqq/jsp/DataApiPlugin:b	Lcom/tencent/mobileqq/emosm/OnRemoteRespObserver;
    //   3950: getfield 744	com/tencent/mobileqq/emosm/OnRemoteRespObserver:key	I
    //   3953: aload_3
    //   3954: invokestatic 749	com/tencent/mobileqq/emosm/DataFactory:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/os/Bundle;)Landroid/os/Bundle;
    //   3957: astore_1
    //   3958: ldc_w 751
    //   3961: invokestatic 757	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   3964: checkcast 751	com/tencent/mobileqq/emosm/api/IWebIPCOperatorApi
    //   3967: aload_1
    //   3968: invokeinterface 761 2 0
    //   3973: goto -2617 -> 1356
    //   3976: astore_1
    //   3977: goto +6 -> 3983
    //   3980: astore_1
    //   3981: aconst_null
    //   3982: astore_2
    //   3983: aload_2
    //   3984: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3987: ifne -2631 -> 1356
    //   3990: aload_0
    //   3991: aload_2
    //   3992: iconst_1
    //   3993: anewarray 86	java/lang/String
    //   3996: dup
    //   3997: iconst_0
    //   3998: ldc_w 989
    //   4001: iconst_1
    //   4002: anewarray 133	java/lang/Object
    //   4005: dup
    //   4006: iconst_0
    //   4007: aload_1
    //   4008: aastore
    //   4009: invokestatic 139	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4012: aastore
    //   4013: invokevirtual 274	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4016: goto -2660 -> 1356
    //   4019: ldc_w 991
    //   4022: aload 4
    //   4024: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4027: ifeq +134 -> 4161
    //   4030: new 188	org/json/JSONObject
    //   4033: dup
    //   4034: aload 5
    //   4036: iconst_0
    //   4037: aaload
    //   4038: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4041: astore_1
    //   4042: ldc_w 993
    //   4045: aload_1
    //   4046: ldc_w 995
    //   4049: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4052: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4055: ifeq +24 -> 4079
    //   4058: aload_0
    //   4059: getfield 51	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4062: invokevirtual 685	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   4065: astore_2
    //   4066: aload_2
    //   4067: ifnull +12 -> 4079
    //   4070: aload_2
    //   4071: iconst_m1
    //   4072: invokevirtual 998	android/app/Activity:setResult	(I)V
    //   4075: aload_2
    //   4076: invokevirtual 1001	android/app/Activity:finish	()V
    //   4079: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4082: ifeq -2726 -> 1356
    //   4085: new 99	java/lang/StringBuilder
    //   4088: dup
    //   4089: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   4092: astore_2
    //   4093: aload_2
    //   4094: ldc_w 1003
    //   4097: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4100: pop
    //   4101: aload_2
    //   4102: aload_1
    //   4103: invokevirtual 1006	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4106: pop
    //   4107: ldc 115
    //   4109: iconst_2
    //   4110: aload_2
    //   4111: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4114: invokestatic 835	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4117: goto -2761 -> 1356
    //   4120: astore_1
    //   4121: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4124: ifeq +13 -> 4137
    //   4127: ldc 115
    //   4129: iconst_2
    //   4130: ldc_w 1008
    //   4133: aload_1
    //   4134: invokestatic 730	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4137: aload_0
    //   4138: getfield 51	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   4141: invokevirtual 685	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   4144: astore_1
    //   4145: aload_1
    //   4146: ifnull -2790 -> 1356
    //   4149: aload_1
    //   4150: iconst_0
    //   4151: invokevirtual 998	android/app/Activity:setResult	(I)V
    //   4154: aload_1
    //   4155: invokevirtual 1001	android/app/Activity:finish	()V
    //   4158: goto -2802 -> 1356
    //   4161: ldc_w 1010
    //   4164: aload 4
    //   4166: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4169: ifeq +337 -> 4506
    //   4172: aload 5
    //   4174: arraylength
    //   4175: iconst_1
    //   4176: if_icmpne +330 -> 4506
    //   4179: new 188	org/json/JSONObject
    //   4182: dup
    //   4183: aload 5
    //   4185: iconst_0
    //   4186: aaload
    //   4187: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4190: astore_1
    //   4191: aload_1
    //   4192: ldc_w 266
    //   4195: invokevirtual 854	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4198: astore_2
    //   4199: aload_1
    //   4200: ldc_w 1012
    //   4203: invokevirtual 854	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4206: astore_3
    //   4207: aload_1
    //   4208: ldc_w 956
    //   4211: invokevirtual 854	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4214: astore 4
    //   4216: aload_0
    //   4217: getfield 348	com/tencent/mobileqq/jsp/DataApiPlugin:c	Lcom/tencent/biz/AuthorizeConfig;
    //   4220: ifnonnull +10 -> 4230
    //   4223: aload_0
    //   4224: invokestatic 353	com/tencent/biz/AuthorizeConfig:a	()Lcom/tencent/biz/AuthorizeConfig;
    //   4227: putfield 348	com/tencent/mobileqq/jsp/DataApiPlugin:c	Lcom/tencent/biz/AuthorizeConfig;
    //   4230: aload_3
    //   4231: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4234: ifne +1175 -> 5409
    //   4237: aload 4
    //   4239: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4242: ifne +1167 -> 5409
    //   4245: new 99	java/lang/StringBuilder
    //   4248: dup
    //   4249: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   4252: astore 5
    //   4254: aload 5
    //   4256: ldc_w 969
    //   4259: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4262: pop
    //   4263: aload 5
    //   4265: aload 4
    //   4267: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4270: pop
    //   4271: aload 5
    //   4273: ldc_w 1014
    //   4276: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4279: pop
    //   4280: aload 5
    //   4282: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4285: astore 4
    //   4287: ldc_w 1015
    //   4290: aload_3
    //   4291: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4294: ifeq +26 -> 4320
    //   4297: aload_1
    //   4298: ldc_w 1017
    //   4301: invokevirtual 854	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4304: astore_1
    //   4305: aload_0
    //   4306: getfield 348	com/tencent/mobileqq/jsp/DataApiPlugin:c	Lcom/tencent/biz/AuthorizeConfig;
    //   4309: aload 4
    //   4311: aload_1
    //   4312: invokevirtual 1020	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4315: istore 9
    //   4317: goto +1080 -> 5397
    //   4320: ldc_w 362
    //   4323: aload_3
    //   4324: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4327: ifeq +17 -> 4344
    //   4330: aload_0
    //   4331: getfield 348	com/tencent/mobileqq/jsp/DataApiPlugin:c	Lcom/tencent/biz/AuthorizeConfig;
    //   4334: aload 4
    //   4336: invokevirtual 382	com/tencent/biz/AuthorizeConfig:a	(Ljava/lang/String;)Z
    //   4339: istore 9
    //   4341: goto +1056 -> 5397
    //   4344: ldc_w 385
    //   4347: aload_3
    //   4348: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4351: ifeq +20 -> 4371
    //   4354: aload_0
    //   4355: getfield 348	com/tencent/mobileqq/jsp/DataApiPlugin:c	Lcom/tencent/biz/AuthorizeConfig;
    //   4358: aload 4
    //   4360: invokevirtual 387	com/tencent/biz/AuthorizeConfig:e	(Ljava/lang/String;)Ljava/lang/String;
    //   4363: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4366: istore 9
    //   4368: goto +1032 -> 5400
    //   4371: ldc_w 1022
    //   4374: aload_3
    //   4375: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4378: ifeq +26 -> 4404
    //   4381: aload_1
    //   4382: ldc_w 1022
    //   4385: invokevirtual 854	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   4388: astore_1
    //   4389: aload_0
    //   4390: getfield 348	com/tencent/mobileqq/jsp/DataApiPlugin:c	Lcom/tencent/biz/AuthorizeConfig;
    //   4393: aload 4
    //   4395: aload_1
    //   4396: invokevirtual 1024	com/tencent/biz/AuthorizeConfig:e	(Ljava/lang/String;Ljava/lang/String;)Z
    //   4399: istore 9
    //   4401: goto +996 -> 5397
    //   4404: ldc_w 402
    //   4407: aload_3
    //   4408: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4411: ifeq +20 -> 4431
    //   4414: aload_0
    //   4415: getfield 348	com/tencent/mobileqq/jsp/DataApiPlugin:c	Lcom/tencent/biz/AuthorizeConfig;
    //   4418: aload 4
    //   4420: invokevirtual 404	com/tencent/biz/AuthorizeConfig:f	(Ljava/lang/String;)Ljava/lang/String;
    //   4423: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4426: istore 9
    //   4428: goto +972 -> 5400
    //   4431: ldc_w 1026
    //   4434: aload_3
    //   4435: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4438: ifeq +971 -> 5409
    //   4441: aload_0
    //   4442: getfield 348	com/tencent/mobileqq/jsp/DataApiPlugin:c	Lcom/tencent/biz/AuthorizeConfig;
    //   4445: aload 4
    //   4447: invokevirtual 558	com/tencent/biz/AuthorizeConfig:p	(Ljava/lang/String;)Ljava/lang/String;
    //   4450: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4453: istore 9
    //   4455: goto +945 -> 5400
    //   4458: iload 9
    //   4460: ifeq +955 -> 5415
    //   4463: ldc_w 1028
    //   4466: astore_1
    //   4467: goto +3 -> 4470
    //   4470: aload_0
    //   4471: aload_2
    //   4472: iconst_1
    //   4473: anewarray 86	java/lang/String
    //   4476: dup
    //   4477: iconst_0
    //   4478: aload_1
    //   4479: aastore
    //   4480: invokevirtual 274	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4483: goto -3127 -> 1356
    //   4486: astore_1
    //   4487: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4490: ifeq -3134 -> 1356
    //   4493: ldc 115
    //   4495: iconst_2
    //   4496: ldc_w 1030
    //   4499: aload_1
    //   4500: invokestatic 730	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4503: goto -3147 -> 1356
    //   4506: ldc_w 1032
    //   4509: aload 4
    //   4511: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4514: ifeq +116 -> 4630
    //   4517: new 188	org/json/JSONObject
    //   4520: dup
    //   4521: aload 5
    //   4523: iconst_0
    //   4524: aaload
    //   4525: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4528: astore_1
    //   4529: aload_1
    //   4530: ldc_w 309
    //   4533: iconst_0
    //   4534: invokevirtual 822	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   4537: istore 9
    //   4539: aload_0
    //   4540: getfield 1034	com/tencent/mobileqq/jsp/DataApiPlugin:a	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4543: ifnonnull +17 -> 4560
    //   4546: aload_0
    //   4547: invokestatic 1039	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4550: putfield 1034	com/tencent/mobileqq/jsp/DataApiPlugin:a	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4553: aload_0
    //   4554: getfield 1034	com/tencent/mobileqq/jsp/DataApiPlugin:a	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4557: invokevirtual 1041	com/tencent/biz/troop/TroopMemberApiClient:e	()V
    //   4560: aload_0
    //   4561: getfield 1034	com/tencent/mobileqq/jsp/DataApiPlugin:a	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   4564: iload 9
    //   4566: invokevirtual 1043	com/tencent/biz/troop/TroopMemberApiClient:a	(Z)V
    //   4569: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4572: ifeq -3216 -> 1356
    //   4575: new 99	java/lang/StringBuilder
    //   4578: dup
    //   4579: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   4582: astore_2
    //   4583: aload_2
    //   4584: ldc_w 1045
    //   4587: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4590: pop
    //   4591: aload_2
    //   4592: aload_1
    //   4593: invokevirtual 1006	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4596: pop
    //   4597: ldc 115
    //   4599: iconst_2
    //   4600: aload_2
    //   4601: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4604: invokestatic 835	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4607: goto -3251 -> 1356
    //   4610: astore_1
    //   4611: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4614: ifeq -3258 -> 1356
    //   4617: ldc 115
    //   4619: iconst_2
    //   4620: ldc_w 1008
    //   4623: aload_1
    //   4624: invokestatic 730	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   4627: goto -3271 -> 1356
    //   4630: ldc_w 1047
    //   4633: aload 4
    //   4635: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4638: ifeq +152 -> 4790
    //   4641: new 188	org/json/JSONObject
    //   4644: dup
    //   4645: aload 5
    //   4647: iconst_0
    //   4648: aaload
    //   4649: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4652: astore_1
    //   4653: aload_1
    //   4654: ldc_w 1049
    //   4657: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4660: astore_2
    //   4661: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4664: ifeq +35 -> 4699
    //   4667: new 99	java/lang/StringBuilder
    //   4670: dup
    //   4671: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   4674: astore_3
    //   4675: aload_3
    //   4676: ldc_w 1051
    //   4679: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4682: pop
    //   4683: aload_3
    //   4684: aload_2
    //   4685: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4688: pop
    //   4689: ldc 115
    //   4691: iconst_2
    //   4692: aload_3
    //   4693: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4696: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4699: aload_0
    //   4700: getfield 28	com/tencent/mobileqq/jsp/DataApiPlugin:f	Lcom/tencent/mobileqq/webviewplugin/WebUiUtils$WebUiMethodInterface;
    //   4703: invokeinterface 1054 1 0
    //   4708: astore_2
    //   4709: aload_2
    //   4710: ifnull -3354 -> 1356
    //   4713: aload_2
    //   4714: invokevirtual 1058	com/tencent/biz/pubaccount/CustomWebView:getPluginEngine	()Lcom/tencent/mobileqq/webview/swift/WebViewPluginEngine;
    //   4717: astore_2
    //   4718: aload_2
    //   4719: iconst_1
    //   4720: anewarray 86	java/lang/String
    //   4723: dup
    //   4724: iconst_0
    //   4725: ldc_w 1060
    //   4728: aastore
    //   4729: invokevirtual 1065	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:a	([Ljava/lang/String;)V
    //   4732: aload_2
    //   4733: ldc_w 1060
    //   4736: invokevirtual 1068	com/tencent/mobileqq/webview/swift/WebViewPluginEngine:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;
    //   4739: astore_2
    //   4740: aload_2
    //   4741: ifnull -3385 -> 1356
    //   4744: aload_2
    //   4745: instanceof 1070
    //   4748: ifeq -3392 -> 1356
    //   4751: aload_2
    //   4752: checkcast 1070	com/tencent/biz/webviewplugin/UrlCheckPlugin
    //   4755: aload_1
    //   4756: ldc_w 1072
    //   4759: invokevirtual 200	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4762: aload_1
    //   4763: ldc_w 1074
    //   4766: invokevirtual 200	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4769: aload_1
    //   4770: ldc_w 1076
    //   4773: invokevirtual 200	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   4776: invokevirtual 1079	com/tencent/biz/webviewplugin/UrlCheckPlugin:a	(III)V
    //   4779: goto -3423 -> 1356
    //   4782: astore_1
    //   4783: aload_1
    //   4784: invokevirtual 667	org/json/JSONException:printStackTrace	()V
    //   4787: goto -3431 -> 1356
    //   4790: ldc_w 1081
    //   4793: aload 4
    //   4795: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4798: ifeq +137 -> 4935
    //   4801: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4804: ifeq +36 -> 4840
    //   4807: new 99	java/lang/StringBuilder
    //   4810: dup
    //   4811: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   4814: astore_1
    //   4815: aload_1
    //   4816: ldc_w 1083
    //   4819: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4822: pop
    //   4823: aload_1
    //   4824: aload 5
    //   4826: invokevirtual 1006	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4829: pop
    //   4830: ldc 115
    //   4832: iconst_2
    //   4833: aload_1
    //   4834: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4837: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4840: aload 5
    //   4842: ifnull -3486 -> 1356
    //   4845: aload 5
    //   4847: arraylength
    //   4848: ifle -3492 -> 1356
    //   4851: new 188	org/json/JSONObject
    //   4854: dup
    //   4855: aload 5
    //   4857: iconst_0
    //   4858: aaload
    //   4859: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   4862: astore_1
    //   4863: aload_1
    //   4864: ldc_w 1085
    //   4867: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4870: astore_2
    //   4871: aload_1
    //   4872: ldc_w 266
    //   4875: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   4878: astore_1
    //   4879: aload_1
    //   4880: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4883: ifne -3527 -> 1356
    //   4886: aload_2
    //   4887: invokestatic 1089	com/tencent/mobileqq/nearby/NearbyURLSafeUtil:b	(Ljava/lang/String;)Ljava/lang/String;
    //   4890: astore_2
    //   4891: new 188	org/json/JSONObject
    //   4894: dup
    //   4895: invokespecial 307	org/json/JSONObject:<init>	()V
    //   4898: astore_3
    //   4899: aload_3
    //   4900: ldc_w 1091
    //   4903: aload_2
    //   4904: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4907: pop
    //   4908: aload_0
    //   4909: aload_1
    //   4910: iconst_1
    //   4911: anewarray 86	java/lang/String
    //   4914: dup
    //   4915: iconst_0
    //   4916: aload_3
    //   4917: invokevirtual 325	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4920: aastore
    //   4921: invokevirtual 274	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   4924: goto -3568 -> 1356
    //   4927: astore_1
    //   4928: aload_1
    //   4929: invokevirtual 667	org/json/JSONException:printStackTrace	()V
    //   4932: goto -3576 -> 1356
    //   4935: ldc_w 1093
    //   4938: aload 4
    //   4940: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4943: ifeq +137 -> 5080
    //   4946: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4949: ifeq +36 -> 4985
    //   4952: new 99	java/lang/StringBuilder
    //   4955: dup
    //   4956: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   4959: astore_1
    //   4960: aload_1
    //   4961: ldc_w 1095
    //   4964: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4967: pop
    //   4968: aload_1
    //   4969: aload 5
    //   4971: invokevirtual 1006	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4974: pop
    //   4975: ldc 115
    //   4977: iconst_2
    //   4978: aload_1
    //   4979: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4982: invokestatic 236	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4985: aload 5
    //   4987: ifnull -3631 -> 1356
    //   4990: aload 5
    //   4992: arraylength
    //   4993: ifle -3637 -> 1356
    //   4996: new 188	org/json/JSONObject
    //   4999: dup
    //   5000: aload 5
    //   5002: iconst_0
    //   5003: aaload
    //   5004: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5007: astore_1
    //   5008: aload_1
    //   5009: ldc_w 1097
    //   5012: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5015: astore_2
    //   5016: aload_1
    //   5017: ldc_w 266
    //   5020: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5023: astore_1
    //   5024: aload_1
    //   5025: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5028: ifne -3672 -> 1356
    //   5031: aload_2
    //   5032: invokestatic 1098	com/tencent/mobileqq/nearby/NearbyURLSafeUtil:c	(Ljava/lang/String;)Ljava/lang/String;
    //   5035: astore_2
    //   5036: new 188	org/json/JSONObject
    //   5039: dup
    //   5040: invokespecial 307	org/json/JSONObject:<init>	()V
    //   5043: astore_3
    //   5044: aload_3
    //   5045: ldc_w 1100
    //   5048: aload_2
    //   5049: invokevirtual 324	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   5052: pop
    //   5053: aload_0
    //   5054: aload_1
    //   5055: iconst_1
    //   5056: anewarray 86	java/lang/String
    //   5059: dup
    //   5060: iconst_0
    //   5061: aload_3
    //   5062: invokevirtual 325	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5065: aastore
    //   5066: invokevirtual 274	com/tencent/mobileqq/jsp/DataApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   5069: goto -3713 -> 1356
    //   5072: astore_1
    //   5073: aload_1
    //   5074: invokevirtual 667	org/json/JSONException:printStackTrace	()V
    //   5077: goto -3721 -> 1356
    //   5080: ldc_w 1102
    //   5083: aload 4
    //   5085: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5088: ifeq +115 -> 5203
    //   5091: new 188	org/json/JSONObject
    //   5094: dup
    //   5095: aload 5
    //   5097: iconst_0
    //   5098: aaload
    //   5099: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5102: ldc_w 1104
    //   5105: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5108: astore_1
    //   5109: aload_0
    //   5110: getfield 1034	com/tencent/mobileqq/jsp/DataApiPlugin:a	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   5113: ifnonnull +17 -> 5130
    //   5116: aload_0
    //   5117: invokestatic 1039	com/tencent/biz/troop/TroopMemberApiClient:a	()Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   5120: putfield 1034	com/tencent/mobileqq/jsp/DataApiPlugin:a	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   5123: aload_0
    //   5124: getfield 1034	com/tencent/mobileqq/jsp/DataApiPlugin:a	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   5127: invokevirtual 1041	com/tencent/biz/troop/TroopMemberApiClient:e	()V
    //   5130: aload_0
    //   5131: getfield 1034	com/tencent/mobileqq/jsp/DataApiPlugin:a	Lcom/tencent/biz/troop/TroopMemberApiClient;
    //   5134: iconst_1
    //   5135: aload_1
    //   5136: invokevirtual 1107	com/tencent/biz/troop/TroopMemberApiClient:a	(ZLjava/lang/String;)V
    //   5139: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5142: ifeq -3786 -> 1356
    //   5145: new 99	java/lang/StringBuilder
    //   5148: dup
    //   5149: invokespecial 100	java/lang/StringBuilder:<init>	()V
    //   5152: astore_1
    //   5153: aload_1
    //   5154: ldc_w 1109
    //   5157: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5160: pop
    //   5161: aload_1
    //   5162: aload 5
    //   5164: iconst_0
    //   5165: aaload
    //   5166: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5169: pop
    //   5170: ldc 115
    //   5172: iconst_2
    //   5173: aload_1
    //   5174: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5177: invokestatic 835	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   5180: goto -3824 -> 1356
    //   5183: astore_1
    //   5184: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5187: ifeq -3831 -> 1356
    //   5190: ldc 115
    //   5192: iconst_2
    //   5193: ldc_w 1111
    //   5196: aload_1
    //   5197: invokestatic 730	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5200: goto -3844 -> 1356
    //   5203: ldc_w 1113
    //   5206: aload 4
    //   5208: invokevirtual 366	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5211: ifeq -3855 -> 1356
    //   5214: aload_0
    //   5215: getfield 51	com/tencent/mobileqq/jsp/DataApiPlugin:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime;
    //   5218: invokevirtual 685	com/tencent/mobileqq/webview/swift/WebViewPlugin$PluginRuntime:d	()Landroid/app/Activity;
    //   5221: astore_1
    //   5222: aload_1
    //   5223: ifnull -3867 -> 1356
    //   5226: aload_1
    //   5227: invokevirtual 691	android/app/Activity:getIntent	()Landroid/content/Intent;
    //   5230: astore_1
    //   5231: new 188	org/json/JSONObject
    //   5234: dup
    //   5235: aload 5
    //   5237: iconst_0
    //   5238: aaload
    //   5239: invokespecial 190	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   5242: astore_3
    //   5243: aload_3
    //   5244: ldc_w 1115
    //   5247: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5250: astore_2
    //   5251: aload_3
    //   5252: ldc_w 1117
    //   5255: invokevirtual 269	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   5258: astore_3
    //   5259: aload_2
    //   5260: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5263: ifne +31 -> 5294
    //   5266: aload_1
    //   5267: ifnull +27 -> 5294
    //   5270: aload_1
    //   5271: ldc_w 1119
    //   5274: aload_2
    //   5275: invokevirtual 1123	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5278: pop
    //   5279: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5282: ifeq +12 -> 5294
    //   5285: ldc 115
    //   5287: iconst_2
    //   5288: ldc_w 1125
    //   5291: invokestatic 153	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5294: aload_3
    //   5295: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5298: ifne -3942 -> 1356
    //   5301: aload_1
    //   5302: ifnull -3946 -> 1356
    //   5305: aload_1
    //   5306: ldc_w 1127
    //   5309: aload_3
    //   5310: invokevirtual 1123	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   5313: pop
    //   5314: invokestatic 146	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5317: ifeq -3961 -> 1356
    //   5320: ldc 115
    //   5322: iconst_2
    //   5323: ldc_w 1129
    //   5326: invokestatic 153	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5329: goto -3973 -> 1356
    //   5332: astore_1
    //   5333: ldc 115
    //   5335: iconst_2
    //   5336: ldc_w 1131
    //   5339: aload_1
    //   5340: invokestatic 1133	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5343: goto -3987 -> 1356
    //   5346: iconst_0
    //   5347: ireturn
    //   5348: goto -4723 -> 625
    //   5351: astore_1
    //   5352: goto -4739 -> 613
    //   5355: goto -4730 -> 625
    //   5358: aconst_null
    //   5359: astore_2
    //   5360: goto -3500 -> 1860
    //   5363: aconst_null
    //   5364: astore_1
    //   5365: goto -3065 -> 2300
    //   5368: aconst_null
    //   5369: astore_1
    //   5370: goto -2759 -> 2611
    //   5373: aconst_null
    //   5374: astore_1
    //   5375: goto -2553 -> 2822
    //   5378: ldc_w 765
    //   5381: astore_2
    //   5382: goto -1779 -> 3603
    //   5385: iconst_0
    //   5386: istore 6
    //   5388: goto -1614 -> 3774
    //   5391: iconst_1
    //   5392: istore 6
    //   5394: goto -1620 -> 3774
    //   5397: goto -939 -> 4458
    //   5400: iload 9
    //   5402: iconst_1
    //   5403: ixor
    //   5404: istore 9
    //   5406: goto -9 -> 5397
    //   5409: iconst_0
    //   5410: istore 9
    //   5412: goto -954 -> 4458
    //   5415: ldc_w 1135
    //   5418: astore_1
    //   5419: goto -949 -> 4470
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5422	0	this	DataApiPlugin
    //   0	5422	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	5422	2	paramString1	String
    //   0	5422	3	paramString2	String
    //   0	5422	4	paramString3	String
    //   0	5422	5	paramVarArgs	String[]
    //   1388	4005	6	i	int
    //   2536	298	7	j	int
    //   2546	117	8	k	int
    //   157	5254	9	bool1	boolean
    //   388	2441	10	bool2	boolean
    //   378	128	11	localObject1	Object
    //   540	39	11	localException	Exception
    //   2504	1158	11	localObject2	Object
    //   179	3569	12	localObject3	Object
    //   44	3652	13	localObject4	Object
    //   210	3377	14	localObject5	Object
    //   168	2501	15	str1	String
    //   201	2470	16	localObject6	Object
    //   217	921	17	str2	String
    //   90	887	18	localAppInterface	AppInterface
    //   190	684	19	str3	String
    // Exception table:
    //   from	to	target	type
    //   408	424	429	java/lang/Exception
    //   398	405	433	java/lang/Exception
    //   442	448	497	java/lang/Exception
    //   451	459	497	java/lang/Exception
    //   462	470	497	java/lang/Exception
    //   473	479	497	java/lang/Exception
    //   482	492	497	java/lang/Exception
    //   348	358	501	java/lang/Exception
    //   361	380	501	java/lang/Exception
    //   383	390	501	java/lang/Exception
    //   286	340	534	finally
    //   286	340	540	java/lang/Exception
    //   27	57	1308	org/json/JSONException
    //   67	83	1308	org/json/JSONException
    //   83	108	1308	org/json/JSONException
    //   108	132	1308	org/json/JSONException
    //   134	148	1308	org/json/JSONException
    //   148	270	1308	org/json/JSONException
    //   272	286	1308	org/json/JSONException
    //   522	529	1308	org/json/JSONException
    //   604	610	1308	org/json/JSONException
    //   617	623	1308	org/json/JSONException
    //   623	625	1308	org/json/JSONException
    //   625	635	1308	org/json/JSONException
    //   640	674	1308	org/json/JSONException
    //   674	797	1308	org/json/JSONException
    //   797	968	1308	org/json/JSONException
    //   968	1127	1308	org/json/JSONException
    //   1127	1279	1308	org/json/JSONException
    //   1279	1305	1308	org/json/JSONException
    //   1409	1436	1606	org/json/JSONException
    //   1442	1453	1606	org/json/JSONException
    //   1462	1488	1606	org/json/JSONException
    //   1499	1525	1606	org/json/JSONException
    //   1528	1552	1606	org/json/JSONException
    //   1552	1563	1606	org/json/JSONException
    //   1563	1578	1606	org/json/JSONException
    //   1578	1603	1606	org/json/JSONException
    //   1637	1734	1737	org/json/JSONException
    //   1771	1832	1888	org/json/JSONException
    //   1834	1842	1888	org/json/JSONException
    //   1846	1857	1888	org/json/JSONException
    //   1867	1872	1888	org/json/JSONException
    //   1872	1885	1888	org/json/JSONException
    //   1952	1966	2003	org/json/JSONException
    //   1973	2001	2003	org/json/JSONException
    //   1914	1942	2007	org/json/JSONException
    //   2059	2098	2146	java/lang/Exception
    //   2105	2112	2146	java/lang/Exception
    //   2119	2127	2146	java/lang/Exception
    //   2127	2143	2146	java/lang/Exception
    //   2207	2297	2384	java/lang/Exception
    //   2300	2330	2384	java/lang/Exception
    //   2333	2355	2384	java/lang/Exception
    //   2355	2381	2384	java/lang/Exception
    //   2422	2608	2867	org/json/JSONException
    //   2611	2645	2867	org/json/JSONException
    //   2648	2675	2867	org/json/JSONException
    //   2678	2753	2867	org/json/JSONException
    //   2757	2763	2867	org/json/JSONException
    //   2768	2804	2867	org/json/JSONException
    //   2807	2819	2867	org/json/JSONException
    //   2822	2846	2867	org/json/JSONException
    //   2849	2864	2867	org/json/JSONException
    //   2913	2969	3040	org/json/JSONException
    //   2972	2988	3040	org/json/JSONException
    //   2988	3019	3040	org/json/JSONException
    //   3022	3037	3040	org/json/JSONException
    //   3103	3176	3179	org/json/JSONException
    //   3242	3291	3831	org/json/JSONException
    //   3295	3378	3831	org/json/JSONException
    //   3385	3393	3831	org/json/JSONException
    //   3402	3600	3831	org/json/JSONException
    //   3603	3669	3831	org/json/JSONException
    //   3669	3771	3831	org/json/JSONException
    //   3774	3828	3831	org/json/JSONException
    //   3903	3973	3976	org/json/JSONException
    //   3883	3903	3980	org/json/JSONException
    //   4030	4066	4120	java/lang/Exception
    //   4070	4079	4120	java/lang/Exception
    //   4079	4117	4120	java/lang/Exception
    //   4179	4230	4486	org/json/JSONException
    //   4230	4317	4486	org/json/JSONException
    //   4320	4341	4486	org/json/JSONException
    //   4344	4368	4486	org/json/JSONException
    //   4371	4401	4486	org/json/JSONException
    //   4404	4428	4486	org/json/JSONException
    //   4431	4455	4486	org/json/JSONException
    //   4470	4483	4486	org/json/JSONException
    //   4517	4560	4610	java/lang/Exception
    //   4560	4607	4610	java/lang/Exception
    //   4641	4699	4782	org/json/JSONException
    //   4699	4709	4782	org/json/JSONException
    //   4713	4740	4782	org/json/JSONException
    //   4744	4779	4782	org/json/JSONException
    //   4851	4924	4927	org/json/JSONException
    //   4996	5069	5072	org/json/JSONException
    //   5091	5130	5183	java/lang/Exception
    //   5130	5180	5183	java/lang/Exception
    //   5214	5222	5332	java/lang/Exception
    //   5226	5266	5332	java/lang/Exception
    //   5270	5294	5332	java/lang/Exception
    //   5294	5301	5332	java/lang/Exception
    //   5305	5329	5332	java/lang/Exception
    //   348	358	5351	finally
    //   361	380	5351	finally
    //   383	390	5351	finally
    //   398	405	5351	finally
    //   408	424	5351	finally
    //   442	448	5351	finally
    //   451	459	5351	finally
    //   462	470	5351	finally
    //   473	479	5351	finally
    //   482	492	5351	finally
    //   546	552	5351	finally
    //   554	563	5351	finally
    //   565	574	5351	finally
    //   576	587	5351	finally
    //   589	600	5351	finally
  }
  
  protected void onCreate()
  {
    super.onCreate();
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.b);
    WebUiBaseInterface localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.d());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebStatisticsInterface))) {
      this.e = ((WebUiUtils.WebStatisticsInterface)localWebUiBaseInterface);
    }
    localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.d());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebUiMethodInterface))) {
      this.f = ((WebUiUtils.WebUiMethodInterface)localWebUiBaseInterface);
    }
    localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.d());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.WebviewReportSpeedInterface))) {
      this.g = ((WebUiUtils.WebviewReportSpeedInterface)localWebUiBaseInterface);
    }
    localWebUiBaseInterface = this.mRuntime.a(this.mRuntime.d());
    if ((localWebUiBaseInterface != null) && ((localWebUiBaseInterface instanceof WebUiUtils.QQBrowserBaseActivityInterface))) {
      this.h = ((WebUiUtils.QQBrowserBaseActivityInterface)localWebUiBaseInterface);
    }
  }
  
  protected void onDestroy()
  {
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.b);
    TroopMemberApiClient localTroopMemberApiClient = this.a;
    if (localTroopMemberApiClient != null) {
      localTroopMemberApiClient.f();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.DataApiPlugin
 * JD-Core Version:    0.7.0.1
 */