package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.network.http.RequestTask.Request;
import com.tencent.mobileqq.mini.network.websocket.WebsocketRequestTask;
import com.tencent.mobileqq.mini.network.websocket.WebsocketRequestTask.RequestParam;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.JsPluginParam;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestPlugin
  extends BaseJsPlugin
{
  private static final String CREATE_REQUEST_TASK = "createRequestTask";
  private static final String CREATE_SOCKET_TASK = "createSocketTask";
  public static final String EVENT_ON_REQUEST_TASK_STATE_CHANGE = "onRequestTaskStateChange";
  public static final String EVENT_SOCKET_TASK_STATE_CHANGE = "onSocketTaskStateChange";
  private static final String OPERATE_REQUEST_TASK = "operateRequestTask";
  private static final String OPERATE_SOCKET_TASK = "operateSocketTask";
  private static final String STATE_COMPLETE = "complete";
  private static final String STATE_FAIL = "fail";
  private static final String STATE_OK = "ok";
  private static final Set<String> S_EVENT_MAP = new RequestPlugin.1();
  private static final String TAG = "[mini] http.RequestPlugin";
  private static final String WNS_ADD_GROUP_APP = "addGroupApp";
  private static final String WNS_CGI_REQUEST = "wnsCgiRequest";
  private static final String WNS_GET_GROUP_APP_STATUS = "getGroupAppStatus";
  private static final String WNS_GROUP_REQUEST = "wnsGroupRequest";
  private int callbackId;
  private String event;
  private byte[] lock = new byte[0];
  private WeakReference<BaseJsPluginEngine> mEngineRef;
  private JsRuntime mJsRuntime;
  private ConcurrentHashMap<Integer, RequestTask.Request> requestMap = new ConcurrentHashMap();
  private SparseArray<WebsocketRequestTask> socketTaskList = new SparseArray();
  private String ua;
  
  private void callback(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder;
    if (paramJsRuntime != null)
    {
      localStringBuilder = new StringBuilder().append(paramString1).append(":").append(paramString2);
      if (!TextUtils.isEmpty(paramString3)) {
        break label104;
      }
    }
    label104:
    for (paramString1 = "";; paramString1 = " " + paramString3)
    {
      paramJSONObject = JSONUtil.append(paramJSONObject, "errMsg", paramString1).toString();
      paramJsRuntime.evaluateCallbackJs(paramInt, paramJSONObject);
      if (!"fail".equals(paramString2)) {
        break;
      }
      QLog.e("[mini] http.RequestPlugin", 1, "[callbackFail] " + paramJSONObject);
      return;
    }
    QLog.i("[mini] http.RequestPlugin", 1, "[callback] " + paramJSONObject);
  }
  
  private void callbackComplete(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt, String paramString)
  {
    callback(paramJsRuntime, paramJSONObject, paramInt, paramString, "complete", null);
  }
  
  private void callbackFail(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt, String paramString)
  {
    callback(paramJsRuntime, paramJSONObject, paramInt, paramString, "fail", null);
  }
  
  private void callbackFail(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt, String paramString1, String paramString2)
  {
    callback(paramJsRuntime, paramJSONObject, paramInt, paramString1, "fail", paramString2);
  }
  
  private void callbackOK(JsRuntime paramJsRuntime, JSONObject paramJSONObject, int paramInt, String paramString)
  {
    callback(paramJsRuntime, paramJSONObject, paramInt, paramString, "ok", null);
  }
  
  private String constructUA(String paramString, boolean paramBoolean)
  {
    int i = 0;
    Object localObject = paramString;
    String str;
    if (paramBoolean) {
      str = "";
    }
    for (;;)
    {
      try
      {
        int j = paramString.indexOf("(Linux;");
        int k = paramString.indexOf(")", j);
        localObject = str;
        if (j > 0)
        {
          localObject = str;
          if (k > j) {
            localObject = paramString.substring(j, k + 1);
          }
        }
        localObject = "Mozilla/5.0 " + (String)localObject + " AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/68.0.3440.91 Mobile Safari/537.36";
        paramString = new StringBuilder();
        j = ((String)localObject).length();
        if (i < j)
        {
          char c = ((String)localObject).charAt(i);
          if ((c <= '\037') || (c >= '')) {
            paramString.append(String.format("\\u%04x", new Object[] { Integer.valueOf(c) }));
          } else {
            paramString.append(c);
          }
        }
      }
      catch (Throwable paramString)
      {
        return "Mozilla/5.0 (Linux; Android 9; V1821A Build/PKQ1.181016.001; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/68.0.3440.91 Mobile Safari/537.36";
      }
      paramString = paramString.toString();
      return paramString;
      i += 1;
    }
  }
  
  private void getGroupAppStatus(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    if (this.jsPluginEngine == null)
    {
      QLog.e("[mini] http.RequestPlugin", 1, "getGroupAppStatus, jsPluginEngine=null");
      return;
    }
    try
    {
      String str = new JSONObject(paramString2).optString("entryDataHash");
      ApkgInfo localApkgInfo = this.jsPluginEngine.appBrandRuntime.getApkgInfo();
      if ((TextUtils.isEmpty(str)) || (!str.equals(localApkgInfo.appConfig.launchParam.entryModel.getEntryHash()))) {
        break label218;
      }
      if (localApkgInfo.appConfig.launchParam.entryModel.isAdmin)
      {
        long l = localApkgInfo.appConfig.launchParam.entryModel.uin;
        str = this.jsPluginEngine.appBrandRuntime.getApkgInfo().appId;
        TroopApplicationListUtil.getGroupAppStatus(this.jsPluginEngine, String.valueOf(l), str, new TroopApplicationListUtil.JsPluginParam(paramString1, paramString2, paramJsRuntime, paramInt));
        return;
      }
    }
    catch (Exception paramString2)
    {
      QLog.e("[mini] http.RequestPlugin", 1, "getGroupAppStatus, exception: " + Log.getStackTraceString(paramString2));
      this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, ApiUtil.wrapCallbackFail(paramString1, null, "native exception"), paramInt);
      return;
    }
    this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, ApiUtil.wrapCallbackFail(paramString1, null, "you are not group administrator"), paramInt);
    return;
    label218:
    this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, ApiUtil.wrapCallbackFail(paramString1, null, "entryDataHash is not vaild or you are not group administrator"), paramInt);
  }
  
  private int getMenshenToken(String paramString)
  {
    int i = 5381;
    if (!TextUtils.isEmpty(paramString))
    {
      int k = paramString.length();
      int j = 5381;
      i = 0;
      while (i < k)
      {
        j += (j << 5) + paramString.charAt(i);
        i += 1;
      }
      i = 0x7FFFFFFF & j;
    }
    return i;
  }
  
  private static String getSecondLevelDomain(String paramString)
  {
    if (paramString != null)
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        Object localObject = paramString.getHost();
        if (localObject != null)
        {
          paramString = ((String)localObject).split("\\.");
          if (paramString.length <= 3) {
            return localObject;
          }
          int j = paramString.length;
          localObject = new StringBuilder();
          int i = j - 3;
          while (i < j)
          {
            ((StringBuilder)localObject).append(paramString[i]);
            if (i != j - 1) {
              ((StringBuilder)localObject).append('.');
            }
            i += 1;
          }
          return ((StringBuilder)localObject).toString();
        }
      }
    }
    return null;
  }
  
  private String getSystemUA()
  {
    try
    {
      if (this.ua != null) {
        return this.ua;
      }
      this.ua = constructUA(System.getProperty("http.agent"), true);
      ThreadManagerV2.executeOnFileThread(new RequestPlugin.4(this));
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        this.ua = "AndroidQQ";
      }
    }
    return this.ua;
  }
  
  private String getUserAgent()
  {
    if ((this.jsPluginEngine != null) && (this.jsPluginEngine.getActivityContext() != null)) {
      return getSystemUA() + " QQ/MiniApp QQ/" + DeviceInfoUtil.getQQVersion();
    }
    return null;
  }
  
  private void handleAddToTroopApplicationList(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    if (this.jsPluginEngine == null)
    {
      QLog.e("[mini] http.RequestPlugin", 1, "handleAddToTroopApplicationList, jsPluginEngine=null");
      return;
    }
    String str3;
    try
    {
      String str1 = new JSONObject(paramString2).optString("method");
      try
      {
        if (this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.launchParam.entryModel != null)
        {
          i = 1;
          str3 = this.jsPluginEngine.appBrandRuntime.getApkgInfo().appId;
          if (i == 0) {
            break label221;
          }
          if (this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.launchParam.entryModel.isAdmin) {
            break label168;
          }
          this.jsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString1, ApiUtil.wrapCallbackFail(paramString1, null, "non-administrators"), paramInt);
        }
      }
      catch (Exception paramString1)
      {
        QLog.e("[mini] http.RequestPlugin", 1, "handleAddToTroopApplicationList exception: " + Log.getStackTraceString(paramString1));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      String str2;
      for (;;)
      {
        str2 = null;
        continue;
        int i = 0;
      }
      label168:
      long l = this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig.launchParam.entryModel.uin;
      TroopApplicationListUtil.addMiniAppToTroopApplicationList(this.jsPluginEngine, String.valueOf(l), str3, str2, new TroopApplicationListUtil.JsPluginParam(paramString1, paramString2, paramJsRuntime, paramInt));
      return;
    }
    label221:
    QIPCClientHelper.getInstance().callServer("MiniAppTransferModule", "query_user_troop_info", new Bundle(), new RequestPlugin.3(this, str3, paramString1, paramString2, paramJsRuntime, paramInt));
  }
  
  private void onCloseCallback(int paramInt1, String paramString, int paramInt2)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("socketTaskId", paramInt2);
      ((JSONObject)localObject).put("state", "close");
      ((JSONObject)localObject).put("code", paramInt1);
      ((JSONObject)localObject).put("reason", paramString);
      if (this.mJsRuntime != null) {
        this.mJsRuntime.evaluateSubcribeJS("onSocketTaskStateChange", ((JSONObject)localObject).toString(), 0);
      }
      paramString = (WebsocketRequestTask)this.socketTaskList.get(paramInt2);
      String str;
      if ((this.jsPluginEngine != null) && (this.jsPluginEngine.appBrandRuntime != null) && (this.jsPluginEngine.appBrandRuntime.getApkgInfo() != null) && (this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig != null))
      {
        localObject = this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig;
        str = MiniReportManager.getAppType(this.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig);
        if ((paramString == null) || (paramString.getRequestParam() == null)) {
          break label205;
        }
      }
      label205:
      for (paramString = paramString.getRequestParam().mOriginUrl;; paramString = null)
      {
        MiniReportManager.reportEventType((MiniAppConfig)localObject, 633, null, null, null, 0, str, 0L, getSecondLevelDomain(paramString));
        return;
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("[mini] http.RequestPlugin", 1, "MiniAppWebsocketListener onClose exception:", paramString);
    }
  }
  
  public BaseJsPluginEngine getEngine()
  {
    if ((this.mEngineRef != null) && (this.mEngineRef.get() != null)) {
      return (BaseJsPluginEngine)this.mEngineRef.get();
    }
    return null;
  }
  
  /* Error */
  public String handleNativeRequest(String paramString1, String arg2, JsRuntime paramJsRuntime, int paramInt)
  {
    // Byte code:
    //   0: ldc 38
    //   2: iconst_1
    //   3: new 121	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 485
    //   13: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_2
    //   17: invokestatic 490	com/tencent/mobileqq/minigame/utils/GameLog:cutString	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 492
    //   26: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 494
    //   36: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload 4
    //   41: invokevirtual 497	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 177	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: ldc 8
    //   52: aload_1
    //   53: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifeq +398 -> 454
    //   59: aload_0
    //   60: monitorenter
    //   61: new 149	org/json/JSONObject
    //   64: dup
    //   65: aload_2
    //   66: invokespecial 244	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   69: astore 7
    //   71: getstatic 503	com/tencent/mobileqq/mini/network/RequestStrategy:g	Lcom/tencent/mobileqq/mini/network/RequestStrategy;
    //   74: aload 7
    //   76: invokevirtual 507	com/tencent/mobileqq/mini/network/RequestStrategy:addHttpForwardingInfo	(Lorg/json/JSONObject;)Z
    //   79: pop
    //   80: aload 7
    //   82: ldc_w 509
    //   85: iconst_0
    //   86: invokevirtual 513	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   89: istore 6
    //   91: new 515	com/tencent/mobileqq/mini/network/http/RequestTask$Request
    //   94: dup
    //   95: aload 7
    //   97: aload_0
    //   98: getfield 239	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   101: invokestatic 521	com/tencent/mobileqq/mini/network/http/MiniappHttpUtil:getRequestReferer	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;)Ljava/lang/String;
    //   104: aload_0
    //   105: invokespecial 523	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:getUserAgent	()Ljava/lang/String;
    //   108: aload_3
    //   109: invokespecial 526	com/tencent/mobileqq/mini/network/http/RequestTask$Request:<init>	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;)V
    //   112: astore 7
    //   114: aload 7
    //   116: getfield 527	com/tencent/mobileqq/mini/network/http/RequestTask$Request:mOriginUrl	Ljava/lang/String;
    //   119: astore 8
    //   121: aload_0
    //   122: getfield 239	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   125: getfield 255	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   128: invokevirtual 261	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   131: iload 6
    //   133: aload 8
    //   135: iconst_0
    //   136: invokevirtual 531	com/tencent/mobileqq/mini/apkg/ApkgInfo:isDomainValid	(ZLjava/lang/String;I)Z
    //   139: ifne +91 -> 230
    //   142: ldc 38
    //   144: iconst_1
    //   145: new 121	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 533
    //   155: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_1
    //   159: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc_w 535
    //   165: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: iload 4
    //   170: invokevirtual 497	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: ldc_w 537
    //   176: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload 8
    //   181: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 540	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: aload_0
    //   191: aload_3
    //   192: aconst_null
    //   193: iload 4
    //   195: ldc_w 542
    //   198: ldc_w 543
    //   201: invokestatic 549	amtj:a	(I)Ljava/lang/String;
    //   204: invokespecial 551	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   207: ldc_w 542
    //   210: aconst_null
    //   211: ldc_w 552
    //   214: invokestatic 549	amtj:a	(I)Ljava/lang/String;
    //   217: invokestatic 323	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   220: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
    //   223: astore 7
    //   225: aload_0
    //   226: monitorexit
    //   227: aload 7
    //   229: areturn
    //   230: aload_0
    //   231: getfield 83	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:requestMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   234: aload 7
    //   236: getfield 555	com/tencent/mobileqq/mini/network/http/RequestTask$Request:mTaskId	I
    //   239: invokestatic 223	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   242: aload 7
    //   244: invokevirtual 558	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   247: pop
    //   248: aload 7
    //   250: new 560	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$2
    //   253: dup
    //   254: aload_0
    //   255: aload 7
    //   257: aload 8
    //   259: aload_3
    //   260: iload 4
    //   262: aload_2
    //   263: invokespecial 563	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$2:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin;Lcom/tencent/mobileqq/mini/network/http/RequestTask$Request;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   266: putfield 567	com/tencent/mobileqq/mini/network/http/RequestTask$Request:mCallback	Lcom/tencent/mobileqq/mini/network/http/HttpCallBack;
    //   269: new 149	org/json/JSONObject
    //   272: dup
    //   273: invokespecial 421	org/json/JSONObject:<init>	()V
    //   276: astore 9
    //   278: aload 9
    //   280: ldc_w 569
    //   283: aload 8
    //   285: invokevirtual 434	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   288: pop
    //   289: aload 9
    //   291: ldc_w 571
    //   294: aload 7
    //   296: getfield 555	com/tencent/mobileqq/mini/network/http/RequestTask$Request:mTaskId	I
    //   299: invokevirtual 427	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   302: pop
    //   303: aload 7
    //   305: invokestatic 577	com/tencent/mobileqq/mini/network/http/WxRequest:request	(Lcom/tencent/mobileqq/mini/network/http/RequestTask$Request;)Z
    //   308: ifeq +94 -> 402
    //   311: aload_0
    //   312: getfield 580	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   315: ifne +13 -> 328
    //   318: aload_0
    //   319: aload_3
    //   320: aload 9
    //   322: iload 4
    //   324: aload_1
    //   325: invokespecial 582	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   328: aload_1
    //   329: aload 9
    //   331: invokestatic 586	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   334: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
    //   337: astore 7
    //   339: aload_0
    //   340: monitorexit
    //   341: aload 7
    //   343: areturn
    //   344: astore 7
    //   346: aload_0
    //   347: monitorexit
    //   348: aload 7
    //   350: athrow
    //   351: astore 7
    //   353: ldc 38
    //   355: iconst_1
    //   356: new 121	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   363: aload_1
    //   364: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: ldc_w 588
    //   370: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: aload 7
    //   378: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   381: aload_0
    //   382: aload_3
    //   383: aconst_null
    //   384: iload 4
    //   386: ldc_w 542
    //   389: invokespecial 590	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   392: aload_0
    //   393: aload_1
    //   394: aload_2
    //   395: aload_3
    //   396: iload 4
    //   398: invokespecial 592	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPlugin:handleNativeRequest	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)Ljava/lang/String;
    //   401: areturn
    //   402: aload_0
    //   403: getfield 580	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   406: ifne +13 -> 419
    //   409: aload_0
    //   410: aload_3
    //   411: aload 9
    //   413: iload 4
    //   415: aload_1
    //   416: invokespecial 590	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   419: aload_1
    //   420: aload 9
    //   422: invokestatic 594	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   425: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
    //   428: astore 7
    //   430: aload_0
    //   431: monitorexit
    //   432: aload 7
    //   434: areturn
    //   435: astore 7
    //   437: ldc 38
    //   439: iconst_1
    //   440: aload 7
    //   442: iconst_0
    //   443: anewarray 217	java/lang/Object
    //   446: invokestatic 597	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   449: aload_0
    //   450: monitorexit
    //   451: goto -59 -> 392
    //   454: ldc 20
    //   456: aload_1
    //   457: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   460: ifeq +137 -> 597
    //   463: new 149	org/json/JSONObject
    //   466: dup
    //   467: aload_2
    //   468: invokespecial 244	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   471: astore 7
    //   473: aload 7
    //   475: ldc_w 571
    //   478: invokevirtual 600	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   481: istore 5
    //   483: aload 7
    //   485: ldc_w 602
    //   488: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   491: astore 7
    //   493: aload_0
    //   494: getfield 83	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:requestMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   497: iload 5
    //   499: invokestatic 223	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   502: invokevirtual 605	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   505: ifeq -113 -> 392
    //   508: aload_0
    //   509: getfield 83	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:requestMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   512: iload 5
    //   514: invokestatic 223	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   517: invokevirtual 609	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   520: checkcast 515	com/tencent/mobileqq/mini/network/http/RequestTask$Request
    //   523: astore 8
    //   525: aload 8
    //   527: ifnull -135 -> 392
    //   530: ldc_w 611
    //   533: aload 7
    //   535: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   538: ifeq -146 -> 392
    //   541: aload 8
    //   543: invokestatic 614	com/tencent/mobileqq/mini/network/http/WxRequest:abort	(Lcom/tencent/mobileqq/mini/network/http/RequestTask$Request;)V
    //   546: aload_0
    //   547: getfield 580	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   550: ifne -158 -> 392
    //   553: aload_0
    //   554: aload_3
    //   555: aconst_null
    //   556: iload 4
    //   558: aload_1
    //   559: invokespecial 582	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   562: goto -170 -> 392
    //   565: astore 7
    //   567: ldc 38
    //   569: iconst_1
    //   570: new 121	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   577: ldc_w 616
    //   580: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload 7
    //   585: invokevirtual 619	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   588: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   591: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   594: goto -202 -> 392
    //   597: ldc 11
    //   599: aload_1
    //   600: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   603: ifeq +487 -> 1090
    //   606: aload_0
    //   607: aload_3
    //   608: putfield 94	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:mJsRuntime	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   611: aload_0
    //   612: aload_1
    //   613: putfield 621	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:event	Ljava/lang/String;
    //   616: aload_0
    //   617: iload 4
    //   619: putfield 623	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackId	I
    //   622: aload_0
    //   623: getfield 85	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:lock	[B
    //   626: astore 7
    //   628: aload 7
    //   630: monitorenter
    //   631: new 149	org/json/JSONObject
    //   634: dup
    //   635: aload_2
    //   636: invokespecial 244	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   639: astore 9
    //   641: getstatic 503	com/tencent/mobileqq/mini/network/RequestStrategy:g	Lcom/tencent/mobileqq/mini/network/RequestStrategy;
    //   644: aload 9
    //   646: invokevirtual 507	com/tencent/mobileqq/mini/network/RequestStrategy:addHttpForwardingInfo	(Lorg/json/JSONObject;)Z
    //   649: pop
    //   650: aload 9
    //   652: ldc_w 509
    //   655: iconst_0
    //   656: invokevirtual 513	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   659: istore 6
    //   661: aload 9
    //   663: ldc_w 625
    //   666: aload_0
    //   667: getfield 239	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   670: getfield 255	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   673: invokevirtual 261	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   676: invokevirtual 629	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   679: getfield 635	com/tencent/mobileqq/mini/apkg/AppConfigInfo:networkTimeoutInfo	Lcom/tencent/mobileqq/mini/apkg/NetworkTimeoutInfo;
    //   682: getfield 640	com/tencent/mobileqq/mini/apkg/NetworkTimeoutInfo:connectSocket	I
    //   685: invokevirtual 427	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   688: pop
    //   689: new 642	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$MiniAppWebsocketListener
    //   692: dup
    //   693: aload_0
    //   694: invokespecial 643	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$MiniAppWebsocketListener:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin;)V
    //   697: astore 8
    //   699: new 460	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask$RequestParam
    //   702: dup
    //   703: aload 9
    //   705: invokespecial 646	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask$RequestParam:<init>	(Lorg/json/JSONObject;)V
    //   708: astore 9
    //   710: aload_0
    //   711: getfield 239	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   714: getfield 255	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   717: invokevirtual 261	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   720: iload 6
    //   722: aload 9
    //   724: getfield 463	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask$RequestParam:mOriginUrl	Ljava/lang/String;
    //   727: iconst_1
    //   728: invokevirtual 531	com/tencent/mobileqq/mini/apkg/ApkgInfo:isDomainValid	(ZLjava/lang/String;I)Z
    //   731: ifne +257 -> 988
    //   734: ldc 38
    //   736: iconst_1
    //   737: new 121	java/lang/StringBuilder
    //   740: dup
    //   741: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   744: ldc_w 648
    //   747: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: aload_1
    //   751: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: ldc_w 535
    //   757: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: iload 4
    //   762: invokevirtual 497	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   765: ldc_w 537
    //   768: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: aload 9
    //   773: getfield 463	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask$RequestParam:mOriginUrl	Ljava/lang/String;
    //   776: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   782: invokestatic 540	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   785: aload_0
    //   786: aload_3
    //   787: aconst_null
    //   788: iload 4
    //   790: ldc_w 650
    //   793: ldc_w 651
    //   796: invokestatic 549	amtj:a	(I)Ljava/lang/String;
    //   799: invokespecial 551	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   802: aload 7
    //   804: monitorexit
    //   805: ldc 136
    //   807: areturn
    //   808: astore 8
    //   810: aload 7
    //   812: monitorexit
    //   813: aload 8
    //   815: athrow
    //   816: astore 7
    //   818: ldc 38
    //   820: iconst_1
    //   821: new 121	java/lang/StringBuilder
    //   824: dup
    //   825: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   828: aload_1
    //   829: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: ldc_w 588
    //   835: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   841: aload 7
    //   843: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   846: aload_0
    //   847: aload_0
    //   848: getfield 94	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:mJsRuntime	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   851: aconst_null
    //   852: iload 4
    //   854: aload_1
    //   855: invokespecial 590	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   858: new 460	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask$RequestParam
    //   861: dup
    //   862: new 149	org/json/JSONObject
    //   865: dup
    //   866: aload_2
    //   867: invokespecial 244	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   870: invokespecial 646	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask$RequestParam:<init>	(Lorg/json/JSONObject;)V
    //   873: getfield 463	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask$RequestParam:mOriginUrl	Ljava/lang/String;
    //   876: astore 7
    //   878: aload_0
    //   879: getfield 239	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   882: ifnull -490 -> 392
    //   885: aload_0
    //   886: getfield 239	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   889: getfield 255	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   892: ifnull -500 -> 392
    //   895: aload_0
    //   896: getfield 239	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   899: getfield 255	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   902: invokevirtual 261	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   905: ifnull -513 -> 392
    //   908: aload_0
    //   909: getfield 239	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   912: getfield 255	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   915: invokevirtual 261	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   918: getfield 267	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   921: ifnull -529 -> 392
    //   924: aload_0
    //   925: getfield 239	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   928: getfield 255	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   931: invokevirtual 261	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   934: getfield 267	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   937: sipush 632
    //   940: aconst_null
    //   941: aconst_null
    //   942: aconst_null
    //   943: iconst_1
    //   944: aload_0
    //   945: getfield 239	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   948: getfield 255	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   951: invokevirtual 261	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   954: getfield 267	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   957: invokestatic 454	com/tencent/mobileqq/mini/report/MiniReportManager:getAppType	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;)Ljava/lang/String;
    //   960: lconst_0
    //   961: aload 7
    //   963: invokestatic 99	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:getSecondLevelDomain	(Ljava/lang/String;)Ljava/lang/String;
    //   966: invokestatic 467	com/tencent/mobileqq/mini/report/MiniReportManager:reportEventType	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;)V
    //   969: goto -577 -> 392
    //   972: astore 7
    //   974: ldc 38
    //   976: iconst_2
    //   977: ldc_w 653
    //   980: aload 7
    //   982: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   985: goto -593 -> 392
    //   988: new 448	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask
    //   991: dup
    //   992: aload 9
    //   994: aload 8
    //   996: invokespecial 656	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask:<init>	(Lcom/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask$RequestParam;Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$MiniAppWebsocketListener;)V
    //   999: astore 9
    //   1001: aload_0
    //   1002: getfield 90	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1005: aload 8
    //   1007: getfield 659	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$MiniAppWebsocketListener:currSocketId	I
    //   1010: aload 9
    //   1012: invokevirtual 662	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   1015: new 149	org/json/JSONObject
    //   1018: dup
    //   1019: aload_2
    //   1020: invokespecial 244	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1023: astore 9
    //   1025: aload 9
    //   1027: ldc_w 423
    //   1030: aload 8
    //   1032: getfield 659	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$MiniAppWebsocketListener:currSocketId	I
    //   1035: invokevirtual 427	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1038: pop
    //   1039: aload 9
    //   1041: ldc 138
    //   1043: new 121	java/lang/StringBuilder
    //   1046: dup
    //   1047: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1050: aload_1
    //   1051: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: ldc_w 664
    //   1057: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1060: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1063: invokevirtual 434	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1066: pop
    //   1067: aload_0
    //   1068: aload_3
    //   1069: aload 9
    //   1071: iload 4
    //   1073: aload_1
    //   1074: invokespecial 582	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   1077: aload 9
    //   1079: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1082: astore 8
    //   1084: aload 7
    //   1086: monitorexit
    //   1087: aload 8
    //   1089: areturn
    //   1090: ldc 23
    //   1092: aload_1
    //   1093: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1096: ifeq +660 -> 1756
    //   1099: new 149	org/json/JSONObject
    //   1102: dup
    //   1103: aload_2
    //   1104: invokespecial 244	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1107: astore 7
    //   1109: aload 7
    //   1111: ldc_w 602
    //   1114: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1117: astore 8
    //   1119: aload 7
    //   1121: ldc_w 423
    //   1124: invokevirtual 600	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1127: istore 5
    //   1129: ldc_w 431
    //   1132: aload 8
    //   1134: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1137: ifeq +200 -> 1337
    //   1140: aload_0
    //   1141: getfield 85	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:lock	[B
    //   1144: astore_2
    //   1145: aload_2
    //   1146: monitorenter
    //   1147: aload_0
    //   1148: getfield 90	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1151: ifnull +149 -> 1300
    //   1154: aload_0
    //   1155: getfield 90	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1158: invokevirtual 667	android/util/SparseArray:size	()I
    //   1161: ifeq +139 -> 1300
    //   1164: aload_0
    //   1165: getfield 90	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1168: iload 5
    //   1170: invokevirtual 446	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1173: checkcast 448	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask
    //   1176: astore 8
    //   1178: aload_0
    //   1179: getfield 90	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1182: iload 5
    //   1184: invokevirtual 670	android/util/SparseArray:remove	(I)V
    //   1187: aload 7
    //   1189: ldc_w 436
    //   1192: sipush 1000
    //   1195: invokevirtual 672	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1198: istore 5
    //   1200: aload 7
    //   1202: ldc_w 438
    //   1205: ldc_w 674
    //   1208: invokevirtual 677	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1211: astore 7
    //   1213: aload 8
    //   1215: ifnull +12 -> 1227
    //   1218: aload 8
    //   1220: iload 5
    //   1222: aload 7
    //   1224: invokevirtual 680	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask:closeSocket	(ILjava/lang/String;)V
    //   1227: aload_0
    //   1228: getfield 580	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1231: ifeq +14 -> 1245
    //   1234: aload_0
    //   1235: aload_3
    //   1236: aconst_null
    //   1237: iload 4
    //   1239: ldc_w 681
    //   1242: invokespecial 582	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   1245: aload_1
    //   1246: aconst_null
    //   1247: invokestatic 586	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1250: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1253: astore_3
    //   1254: aload_2
    //   1255: monitorexit
    //   1256: aload_3
    //   1257: areturn
    //   1258: astore_3
    //   1259: aload_2
    //   1260: monitorexit
    //   1261: aload_3
    //   1262: athrow
    //   1263: astore_2
    //   1264: ldc 38
    //   1266: iconst_1
    //   1267: new 121	java/lang/StringBuilder
    //   1270: dup
    //   1271: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1274: aload_1
    //   1275: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: ldc_w 588
    //   1281: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1287: aload_2
    //   1288: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1291: aload_1
    //   1292: aconst_null
    //   1293: invokestatic 594	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1296: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1299: areturn
    //   1300: aload_0
    //   1301: getfield 580	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1304: ifeq +17 -> 1321
    //   1307: aload_0
    //   1308: aload_3
    //   1309: aconst_null
    //   1310: iload 4
    //   1312: ldc_w 681
    //   1315: ldc_w 683
    //   1318: invokespecial 551	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   1321: aload_1
    //   1322: aconst_null
    //   1323: ldc_w 683
    //   1326: invokestatic 323	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1329: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1332: astore_3
    //   1333: aload_2
    //   1334: monitorexit
    //   1335: aload_3
    //   1336: areturn
    //   1337: ldc_w 685
    //   1340: aload 8
    //   1342: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1345: ifeq -953 -> 392
    //   1348: aload 7
    //   1350: ldc_w 687
    //   1353: aconst_null
    //   1354: invokevirtual 677	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1357: astore 8
    //   1359: aload 8
    //   1361: ifnull +200 -> 1561
    //   1364: aload_0
    //   1365: getfield 85	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:lock	[B
    //   1368: astore_2
    //   1369: aload_2
    //   1370: monitorenter
    //   1371: aload_0
    //   1372: getfield 90	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1375: ifnull +149 -> 1524
    //   1378: aload_0
    //   1379: getfield 90	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1382: invokevirtual 667	android/util/SparseArray:size	()I
    //   1385: ifeq +139 -> 1524
    //   1388: aload_0
    //   1389: getfield 90	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1392: iload 5
    //   1394: invokevirtual 446	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1397: checkcast 448	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask
    //   1400: astore 7
    //   1402: aload 7
    //   1404: ifnull +46 -> 1450
    //   1407: aload 7
    //   1409: aload 8
    //   1411: invokevirtual 690	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask:sendStringMessage	(Ljava/lang/String;)V
    //   1414: aload_0
    //   1415: getfield 580	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1418: ifeq +14 -> 1432
    //   1421: aload_0
    //   1422: aload_3
    //   1423: aconst_null
    //   1424: iload 4
    //   1426: ldc_w 692
    //   1429: invokespecial 582	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   1432: aload_1
    //   1433: aconst_null
    //   1434: invokestatic 586	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1437: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1440: astore_3
    //   1441: aload_2
    //   1442: monitorexit
    //   1443: aload_3
    //   1444: areturn
    //   1445: astore_3
    //   1446: aload_2
    //   1447: monitorexit
    //   1448: aload_3
    //   1449: athrow
    //   1450: ldc 38
    //   1452: iconst_1
    //   1453: new 121	java/lang/StringBuilder
    //   1456: dup
    //   1457: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1460: aload_1
    //   1461: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1464: ldc_w 694
    //   1467: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1470: aload 8
    //   1472: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1475: ldc_w 696
    //   1478: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1481: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1484: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1487: aload_0
    //   1488: getfield 580	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1491: ifeq +17 -> 1508
    //   1494: aload_0
    //   1495: aload_3
    //   1496: aconst_null
    //   1497: iload 4
    //   1499: ldc_w 692
    //   1502: ldc_w 698
    //   1505: invokespecial 551	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   1508: aload_1
    //   1509: aconst_null
    //   1510: ldc_w 698
    //   1513: invokestatic 323	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1516: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1519: astore_3
    //   1520: aload_2
    //   1521: monitorexit
    //   1522: aload_3
    //   1523: areturn
    //   1524: aload_0
    //   1525: getfield 580	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1528: ifeq +17 -> 1545
    //   1531: aload_0
    //   1532: aload_3
    //   1533: aconst_null
    //   1534: iload 4
    //   1536: ldc_w 692
    //   1539: ldc_w 683
    //   1542: invokespecial 551	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   1545: aload_1
    //   1546: aconst_null
    //   1547: ldc_w 683
    //   1550: invokestatic 323	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1553: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1556: astore_3
    //   1557: aload_2
    //   1558: monitorexit
    //   1559: aload_3
    //   1560: areturn
    //   1561: aload 7
    //   1563: invokestatic 703	com/tencent/mobileqq/minigame/utils/NativeBuffer:hasNativeBuffer	(Lorg/json/JSONObject;)Z
    //   1566: ifeq -1174 -> 392
    //   1569: aload 7
    //   1571: ldc_w 687
    //   1574: aload_3
    //   1575: invokestatic 707	com/tencent/mobileqq/minigame/utils/NativeBuffer:unpackNativeBuffer	(Lorg/json/JSONObject;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;)Lcom/tencent/mobileqq/minigame/utils/NativeBuffer;
    //   1578: astore_2
    //   1579: aload_2
    //   1580: ifnull +141 -> 1721
    //   1583: aload_2
    //   1584: getfield 710	com/tencent/mobileqq/minigame/utils/NativeBuffer:buf	[B
    //   1587: ifnull +134 -> 1721
    //   1590: aload_0
    //   1591: getfield 90	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1594: ifnull +127 -> 1721
    //   1597: aload_0
    //   1598: getfield 90	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1601: invokevirtual 667	android/util/SparseArray:size	()I
    //   1604: ifeq +117 -> 1721
    //   1607: aload_0
    //   1608: getfield 90	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1611: iload 5
    //   1613: invokevirtual 446	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1616: checkcast 448	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask
    //   1619: astore 7
    //   1621: aload 7
    //   1623: ifnull +39 -> 1662
    //   1626: aload 7
    //   1628: aload_2
    //   1629: getfield 710	com/tencent/mobileqq/minigame/utils/NativeBuffer:buf	[B
    //   1632: invokevirtual 714	com/tencent/mobileqq/mini/network/websocket/WebsocketRequestTask:sendBinaryMessage	([B)V
    //   1635: aload_0
    //   1636: getfield 580	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1639: ifeq +14 -> 1653
    //   1642: aload_0
    //   1643: aload_3
    //   1644: aconst_null
    //   1645: iload 4
    //   1647: ldc_w 692
    //   1650: invokespecial 582	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   1653: aload_1
    //   1654: aconst_null
    //   1655: invokestatic 586	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1658: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1661: areturn
    //   1662: ldc 38
    //   1664: iconst_1
    //   1665: new 121	java/lang/StringBuilder
    //   1668: dup
    //   1669: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1672: aload_1
    //   1673: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1676: ldc_w 716
    //   1679: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1682: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1685: invokestatic 170	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1688: aload_0
    //   1689: getfield 580	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1692: ifeq +17 -> 1709
    //   1695: aload_0
    //   1696: aload_3
    //   1697: aconst_null
    //   1698: iload 4
    //   1700: ldc_w 692
    //   1703: ldc_w 698
    //   1706: invokespecial 551	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   1709: aload_1
    //   1710: aconst_null
    //   1711: ldc_w 698
    //   1714: invokestatic 323	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1717: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1720: areturn
    //   1721: aload_0
    //   1722: getfield 580	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1725: ifeq +17 -> 1742
    //   1728: aload_0
    //   1729: aload_3
    //   1730: aconst_null
    //   1731: iload 4
    //   1733: ldc_w 692
    //   1736: ldc_w 683
    //   1739: invokespecial 551	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   1742: aload_1
    //   1743: aconst_null
    //   1744: ldc_w 683
    //   1747: invokestatic 323	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1750: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1753: astore_2
    //   1754: aload_2
    //   1755: areturn
    //   1756: ldc 44
    //   1758: aload_1
    //   1759: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1762: ifeq +61 -> 1823
    //   1765: aload_0
    //   1766: getfield 239	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1769: ifnonnull +6 -> 1775
    //   1772: ldc 136
    //   1774: areturn
    //   1775: aload_2
    //   1776: aload_3
    //   1777: aload_1
    //   1778: iload 4
    //   1780: aload_0
    //   1781: getfield 239	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1784: invokestatic 722	com/tencent/mobileqq/mini/entry/MiniAppUtils:performWnsCgiRequest	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;)V
    //   1787: goto -1395 -> 392
    //   1790: astore 7
    //   1792: ldc 38
    //   1794: iconst_1
    //   1795: new 121	java/lang/StringBuilder
    //   1798: dup
    //   1799: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1802: aload_1
    //   1803: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1806: ldc_w 588
    //   1809: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1812: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1815: aload 7
    //   1817: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1820: goto -1428 -> 392
    //   1823: ldc 50
    //   1825: aload_1
    //   1826: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1829: ifeq +312 -> 2141
    //   1832: invokestatic 726	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1835: ifeq +33 -> 1868
    //   1838: ldc 38
    //   1840: iconst_2
    //   1841: new 121	java/lang/StringBuilder
    //   1844: dup
    //   1845: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   1848: aload_1
    //   1849: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1852: ldc_w 728
    //   1855: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1858: aload_2
    //   1859: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1862: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1865: invokestatic 731	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1868: aload_0
    //   1869: getfield 239	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1872: ifnull +371 -> 2243
    //   1875: aload_2
    //   1876: invokestatic 134	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1879: ifeq +6 -> 1885
    //   1882: goto +361 -> 2243
    //   1885: new 149	org/json/JSONObject
    //   1888: dup
    //   1889: aload_2
    //   1890: invokespecial 244	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1893: ldc 246
    //   1895: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1898: astore 7
    //   1900: aload_0
    //   1901: getfield 239	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1904: getfield 255	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1907: invokevirtual 261	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1910: astore 8
    //   1912: aload 8
    //   1914: ifnull -1522 -> 392
    //   1917: aload 8
    //   1919: getfield 267	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1922: ifnull -1530 -> 392
    //   1925: aload 8
    //   1927: getfield 267	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1930: getfield 273	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1933: ifnull -1541 -> 392
    //   1936: aload 8
    //   1938: getfield 267	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1941: getfield 273	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1944: getfield 279	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   1947: ifnull -1555 -> 392
    //   1950: aload 7
    //   1952: ifnull -1560 -> 392
    //   1955: aload 7
    //   1957: aload 8
    //   1959: getfield 267	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1962: getfield 273	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1965: getfield 279	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   1968: invokevirtual 284	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   1971: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1974: ifeq +132 -> 2106
    //   1977: aload 8
    //   1979: getfield 267	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1982: getfield 273	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1985: getfield 279	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   1988: getfield 288	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   1991: ifeq +115 -> 2106
    //   1994: aload_2
    //   1995: ldc_w 733
    //   1998: invokevirtual 736	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2001: ifeq +74 -> 2075
    //   2004: aload_2
    //   2005: ldc_w 733
    //   2008: aload 8
    //   2010: getfield 267	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2013: getfield 273	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2016: getfield 279	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   2019: getfield 292	com/tencent/mobileqq/mini/sdk/EntryModel:uin	J
    //   2022: invokestatic 298	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2025: invokevirtual 740	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   2028: aload_3
    //   2029: aload_1
    //   2030: iload 4
    //   2032: aload_0
    //   2033: getfield 239	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2036: invokestatic 722	com/tencent/mobileqq/mini/entry/MiniAppUtils:performWnsCgiRequest	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;)V
    //   2039: goto -1647 -> 392
    //   2042: astore 7
    //   2044: ldc 38
    //   2046: iconst_1
    //   2047: new 121	java/lang/StringBuilder
    //   2050: dup
    //   2051: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   2054: aload_1
    //   2055: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2058: ldc_w 588
    //   2061: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2064: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2067: aload 7
    //   2069: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2072: goto -1680 -> 392
    //   2075: aload_0
    //   2076: getfield 239	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2079: aload_3
    //   2080: aload_1
    //   2081: aload_1
    //   2082: aconst_null
    //   2083: ldc_w 742
    //   2086: invokestatic 323	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   2089: iload 4
    //   2091: invokevirtual 327	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   2094: aload_1
    //   2095: aconst_null
    //   2096: ldc_w 742
    //   2099: invokestatic 323	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   2102: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2105: areturn
    //   2106: aload_0
    //   2107: getfield 239	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2110: aload_3
    //   2111: aload_1
    //   2112: aload_1
    //   2113: aconst_null
    //   2114: ldc_w 331
    //   2117: invokestatic 323	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   2120: iload 4
    //   2122: invokevirtual 327	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   2125: aload_1
    //   2126: aconst_null
    //   2127: ldc_w 331
    //   2130: invokestatic 323	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   2133: invokevirtual 150	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2136: astore 7
    //   2138: aload 7
    //   2140: areturn
    //   2141: ldc 41
    //   2143: aload_1
    //   2144: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2147: ifeq +45 -> 2192
    //   2150: ldc 38
    //   2152: iconst_2
    //   2153: new 121	java/lang/StringBuilder
    //   2156: dup
    //   2157: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   2160: aload_1
    //   2161: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2164: ldc_w 744
    //   2167: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2170: aload_2
    //   2171: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2174: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2177: invokestatic 731	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2180: aload_0
    //   2181: aload_1
    //   2182: aload_2
    //   2183: aload_3
    //   2184: iload 4
    //   2186: invokespecial 746	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:handleAddToTroopApplicationList	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)V
    //   2189: goto -1797 -> 392
    //   2192: ldc 47
    //   2194: aload_1
    //   2195: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2198: ifeq -1806 -> 392
    //   2201: ldc 38
    //   2203: iconst_2
    //   2204: new 121	java/lang/StringBuilder
    //   2207: dup
    //   2208: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   2211: aload_1
    //   2212: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2215: ldc_w 744
    //   2218: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2221: aload_2
    //   2222: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2225: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2228: invokestatic 731	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2231: aload_0
    //   2232: aload_1
    //   2233: aload_2
    //   2234: aload_3
    //   2235: iload 4
    //   2237: invokespecial 748	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:getGroupAppStatus	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)V
    //   2240: goto -1848 -> 392
    //   2243: ldc 136
    //   2245: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2246	0	this	RequestPlugin
    //   0	2246	1	paramString1	String
    //   0	2246	3	paramJsRuntime	JsRuntime
    //   0	2246	4	paramInt	int
    //   481	1131	5	i	int
    //   89	632	6	bool	boolean
    //   69	273	7	localObject1	Object
    //   344	5	7	localObject2	Object
    //   351	26	7	localThrowable1	Throwable
    //   428	5	7	str1	String
    //   435	6	7	localThrowable2	Throwable
    //   471	63	7	localObject3	Object
    //   565	19	7	localException	Exception
    //   816	26	7	localThrowable3	Throwable
    //   876	86	7	str2	String
    //   972	113	7	localThrowable4	Throwable
    //   1107	520	7	localObject4	Object
    //   1790	26	7	localThrowable5	Throwable
    //   1898	58	7	str3	String
    //   2042	26	7	localThrowable6	Throwable
    //   2136	3	7	str4	String
    //   119	579	8	localObject5	Object
    //   808	223	8	localMiniAppWebsocketListener	RequestPlugin.MiniAppWebsocketListener
    //   1082	927	8	localObject6	Object
    //   276	802	9	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   61	227	344	finally
    //   230	269	344	finally
    //   269	328	344	finally
    //   328	339	344	finally
    //   339	341	344	finally
    //   346	348	344	finally
    //   402	419	344	finally
    //   419	430	344	finally
    //   430	432	344	finally
    //   437	451	344	finally
    //   59	61	351	java/lang/Throwable
    //   348	351	351	java/lang/Throwable
    //   269	328	435	java/lang/Throwable
    //   328	339	435	java/lang/Throwable
    //   402	419	435	java/lang/Throwable
    //   419	430	435	java/lang/Throwable
    //   463	525	565	java/lang/Exception
    //   530	562	565	java/lang/Exception
    //   631	805	808	finally
    //   810	813	808	finally
    //   988	1087	808	finally
    //   622	631	816	java/lang/Throwable
    //   813	816	816	java/lang/Throwable
    //   858	969	972	java/lang/Throwable
    //   1147	1213	1258	finally
    //   1218	1227	1258	finally
    //   1227	1245	1258	finally
    //   1245	1256	1258	finally
    //   1259	1261	1258	finally
    //   1300	1321	1258	finally
    //   1321	1335	1258	finally
    //   1099	1147	1263	java/lang/Throwable
    //   1261	1263	1263	java/lang/Throwable
    //   1337	1359	1263	java/lang/Throwable
    //   1364	1371	1263	java/lang/Throwable
    //   1448	1450	1263	java/lang/Throwable
    //   1561	1579	1263	java/lang/Throwable
    //   1583	1621	1263	java/lang/Throwable
    //   1626	1653	1263	java/lang/Throwable
    //   1653	1662	1263	java/lang/Throwable
    //   1662	1709	1263	java/lang/Throwable
    //   1709	1721	1263	java/lang/Throwable
    //   1721	1742	1263	java/lang/Throwable
    //   1742	1754	1263	java/lang/Throwable
    //   1371	1402	1445	finally
    //   1407	1432	1445	finally
    //   1432	1443	1445	finally
    //   1446	1448	1445	finally
    //   1450	1508	1445	finally
    //   1508	1522	1445	finally
    //   1524	1545	1445	finally
    //   1545	1559	1445	finally
    //   1765	1772	1790	java/lang/Throwable
    //   1775	1787	1790	java/lang/Throwable
    //   1868	1882	2042	java/lang/Throwable
    //   1885	1912	2042	java/lang/Throwable
    //   1917	1950	2042	java/lang/Throwable
    //   1955	2039	2042	java/lang/Throwable
    //   2075	2106	2042	java/lang/Throwable
    //   2106	2138	2042	java/lang/Throwable
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    this.mEngineRef = new WeakReference(paramBaseJsPluginEngine);
    super.onCreate(paramBaseJsPluginEngine);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    int i = this.socketTaskList.size() - 1;
    for (;;)
    {
      if (i >= 0)
      {
        WebsocketRequestTask localWebsocketRequestTask = (WebsocketRequestTask)this.socketTaskList.valueAt(i);
        if (localWebsocketRequestTask != null) {}
        try
        {
          QLog.d("[mini] http.RequestPlugin", 1, "destory close socket, socket id " + this.socketTaskList.keyAt(i));
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("socketTaskId", this.socketTaskList.keyAt(i));
          localJSONObject.put("state", "close");
          localJSONObject.put("statusCode", 600);
          if (this.mJsRuntime != null) {
            this.mJsRuntime.evaluateSubcribeJS("onSocketTaskStateChange", localJSONObject.toString(), 0);
          }
          localWebsocketRequestTask.destory();
          this.socketTaskList.remove(i);
          i -= 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("[mini] http.RequestPlugin", 1, "onDestroy exception ", localException);
          }
        }
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RequestPlugin
 * JD-Core Version:    0.7.0.1
 */