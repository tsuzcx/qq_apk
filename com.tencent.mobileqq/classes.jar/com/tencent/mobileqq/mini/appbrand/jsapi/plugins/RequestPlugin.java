package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.PageWebview;
import com.tencent.mobileqq.mini.http.RequestTask.Request;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.mini.websocket.WebsocketRequestTask;
import com.tencent.mobileqq.mini.websocket.WebsocketRequestTask.RequestParam;
import com.tencent.mobileqq.mini.webview.JsRuntime;
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
  private static final int MAX_SUPPORT_SOCKET_CONNECTION_SIZE = 2;
  private static final String OPERATE_REQUEST_TASK = "operateRequestTask";
  private static final String OPERATE_SOCKET_TASK = "operateSocketTask";
  private static final String STATE_COMPLETE = "complete";
  private static final String STATE_FAIL = "fail";
  private static final String STATE_OK = "ok";
  private static final Set<String> S_EVENT_MAP = new RequestPlugin.1();
  private static final String TAG = "[mini] http.RequestPlugin";
  private static final String WNS_CGI_REQUEST = "wnsCgiRequest";
  private static final String WNS_GROUP_REQUEST = "wnsGroupRequest";
  private int callbackId;
  private String event;
  private byte[] lock = new byte[0];
  private WeakReference<BaseJsPluginEngine> mEngineRef;
  private JsRuntime mJsRuntime;
  private ConcurrentHashMap<Integer, RequestTask.Request> requestMap = new ConcurrentHashMap();
  private SparseArray<WebsocketRequestTask> socketTaskList = new SparseArray();
  
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
  
  private String getUserAgent()
  {
    if ((this.jsPluginEngine != null) && (this.jsPluginEngine.appBrandRuntime != null) && (this.jsPluginEngine.appBrandRuntime.getCurPage() != null) && (this.jsPluginEngine.appBrandRuntime.getCurPage().getCurrentPageWebview() != null)) {
      return this.jsPluginEngine.appBrandRuntime.getCurPage().getCurrentPageWebview().getUserAgent();
    }
    return null;
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
          break label200;
        }
      }
      label200:
      for (paramString = paramString.getRequestParam().url;; paramString = null)
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
    //   0: ldc 35
    //   2: iconst_1
    //   3: new 100	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 302
    //   13: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_2
    //   17: invokestatic 307	com/tencent/mobileqq/minigame/utils/GameLog:cutString	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 309
    //   26: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 311
    //   36: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload 4
    //   41: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 156	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: ldc 8
    //   52: aload_1
    //   53: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifeq +388 -> 444
    //   59: aload_0
    //   60: monitorenter
    //   61: new 128	org/json/JSONObject
    //   64: dup
    //   65: aload_2
    //   66: invokespecial 317	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   69: astore 7
    //   71: aload 7
    //   73: ldc_w 319
    //   76: iconst_0
    //   77: invokevirtual 323	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   80: istore 6
    //   82: new 325	com/tencent/mobileqq/mini/http/RequestTask$Request
    //   85: dup
    //   86: aload 7
    //   88: aload_0
    //   89: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   92: invokestatic 331	com/tencent/mobileqq/mini/http/MiniappHttpUtil:getRequestReferer	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;)Ljava/lang/String;
    //   95: aload_0
    //   96: invokespecial 332	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:getUserAgent	()Ljava/lang/String;
    //   99: aload_0
    //   100: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   103: invokevirtual 335	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getNativeBufferPool	()Ljava/lang/Object;
    //   106: checkcast 337	com/tencent/mobileqq/triton/sdk/bridge/ITNativeBufferPool
    //   109: invokespecial 340	com/tencent/mobileqq/mini/http/RequestTask$Request:<init>	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/triton/sdk/bridge/ITNativeBufferPool;)V
    //   112: astore 7
    //   114: aload 7
    //   116: getfield 343	com/tencent/mobileqq/mini/http/RequestTask$Request:mUrl	Ljava/lang/String;
    //   119: astore 8
    //   121: aload_0
    //   122: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   125: getfield 203	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   128: invokevirtual 255	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   131: iload 6
    //   133: aload 8
    //   135: iconst_0
    //   136: invokevirtual 347	com/tencent/mobileqq/mini/apkg/ApkgInfo:isDomainValid	(ZLjava/lang/String;I)Z
    //   139: ifne +91 -> 230
    //   142: ldc 35
    //   144: iconst_1
    //   145: new 100	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 349
    //   155: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_1
    //   159: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc_w 351
    //   165: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: iload 4
    //   170: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: ldc_w 353
    //   176: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: aload 8
    //   181: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 356	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: aload_0
    //   191: aload_3
    //   192: aconst_null
    //   193: iload 4
    //   195: ldc_w 358
    //   198: ldc_w 359
    //   201: invokestatic 365	alpo:a	(I)Ljava/lang/String;
    //   204: invokespecial 367	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   207: ldc_w 358
    //   210: aconst_null
    //   211: ldc_w 368
    //   214: invokestatic 365	alpo:a	(I)Ljava/lang/String;
    //   217: invokestatic 374	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   220: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   223: astore 7
    //   225: aload_0
    //   226: monitorexit
    //   227: aload 7
    //   229: areturn
    //   230: aload_0
    //   231: getfield 72	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:requestMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   234: aload 7
    //   236: getfield 377	com/tencent/mobileqq/mini/http/RequestTask$Request:mTaskId	I
    //   239: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   242: aload 7
    //   244: invokevirtual 386	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   247: pop
    //   248: aload 7
    //   250: new 388	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$2
    //   253: dup
    //   254: aload_0
    //   255: aload 8
    //   257: aload 7
    //   259: aload_3
    //   260: iload 4
    //   262: aload_2
    //   263: invokespecial 391	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$2:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin;Ljava/lang/String;Lcom/tencent/mobileqq/mini/http/RequestTask$Request;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   266: putfield 395	com/tencent/mobileqq/mini/http/RequestTask$Request:mCallback	Lcom/tencent/mobileqq/mini/http/HttpCallBack;
    //   269: new 128	org/json/JSONObject
    //   272: dup
    //   273: aload_2
    //   274: invokespecial 317	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   277: astore 8
    //   279: aload 8
    //   281: ldc_w 397
    //   284: aload 7
    //   286: getfield 377	com/tencent/mobileqq/mini/http/RequestTask$Request:mTaskId	I
    //   289: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   292: pop
    //   293: aload 7
    //   295: invokestatic 403	com/tencent/mobileqq/mini/http/WxRequest:request	(Lcom/tencent/mobileqq/mini/http/RequestTask$Request;)Z
    //   298: ifeq +94 -> 392
    //   301: aload_0
    //   302: getfield 407	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   305: ifne +13 -> 318
    //   308: aload_0
    //   309: aload_3
    //   310: aload 8
    //   312: iload 4
    //   314: aload_1
    //   315: invokespecial 409	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   318: aload_1
    //   319: aload 8
    //   321: invokestatic 413	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   324: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   327: astore 7
    //   329: aload_0
    //   330: monitorexit
    //   331: aload 7
    //   333: areturn
    //   334: astore 7
    //   336: aload_0
    //   337: monitorexit
    //   338: aload 7
    //   340: athrow
    //   341: astore 7
    //   343: ldc 35
    //   345: iconst_1
    //   346: new 100	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   353: aload_1
    //   354: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: ldc_w 415
    //   360: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: aload 7
    //   368: invokestatic 285	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   371: aload_0
    //   372: aload_3
    //   373: aconst_null
    //   374: iload 4
    //   376: ldc_w 358
    //   379: invokespecial 417	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   382: aload_0
    //   383: aload_1
    //   384: aload_2
    //   385: aload_3
    //   386: iload 4
    //   388: invokespecial 419	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPlugin:handleNativeRequest	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)Ljava/lang/String;
    //   391: areturn
    //   392: aload_0
    //   393: getfield 407	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   396: ifne +13 -> 409
    //   399: aload_0
    //   400: aload_3
    //   401: aload 8
    //   403: iload 4
    //   405: aload_1
    //   406: invokespecial 417	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   409: aload_1
    //   410: aload 8
    //   412: invokestatic 421	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   415: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   418: astore 7
    //   420: aload_0
    //   421: monitorexit
    //   422: aload 7
    //   424: areturn
    //   425: astore 7
    //   427: ldc 35
    //   429: iconst_1
    //   430: aload 7
    //   432: iconst_0
    //   433: anewarray 423	java/lang/Object
    //   436: invokestatic 426	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   439: aload_0
    //   440: monitorexit
    //   441: goto -59 -> 382
    //   444: ldc 17
    //   446: aload_1
    //   447: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   450: ifeq +137 -> 587
    //   453: new 128	org/json/JSONObject
    //   456: dup
    //   457: aload_2
    //   458: invokespecial 317	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   461: astore 7
    //   463: aload 7
    //   465: ldc_w 397
    //   468: invokevirtual 429	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   471: istore 5
    //   473: aload 7
    //   475: ldc_w 431
    //   478: invokevirtual 434	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   481: astore 7
    //   483: aload_0
    //   484: getfield 72	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:requestMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   487: iload 5
    //   489: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   492: invokevirtual 437	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   495: ifeq -113 -> 382
    //   498: aload_0
    //   499: getfield 72	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:requestMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   502: iload 5
    //   504: invokestatic 383	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   507: invokevirtual 441	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   510: checkcast 325	com/tencent/mobileqq/mini/http/RequestTask$Request
    //   513: astore 8
    //   515: aload 8
    //   517: ifnull -135 -> 382
    //   520: ldc_w 443
    //   523: aload 7
    //   525: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   528: ifeq -146 -> 382
    //   531: aload 8
    //   533: invokestatic 446	com/tencent/mobileqq/mini/http/WxRequest:abort	(Lcom/tencent/mobileqq/mini/http/RequestTask$Request;)V
    //   536: aload_0
    //   537: getfield 407	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   540: ifne -158 -> 382
    //   543: aload_0
    //   544: aload_3
    //   545: aconst_null
    //   546: iload 4
    //   548: aload_1
    //   549: invokespecial 409	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   552: goto -170 -> 382
    //   555: astore 7
    //   557: ldc 35
    //   559: iconst_1
    //   560: new 100	java/lang/StringBuilder
    //   563: dup
    //   564: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   567: ldc_w 448
    //   570: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: aload 7
    //   575: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   578: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: invokestatic 149	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   584: goto -202 -> 382
    //   587: ldc 11
    //   589: aload_1
    //   590: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   593: ifeq +478 -> 1071
    //   596: aload_0
    //   597: aload_3
    //   598: putfield 83	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:mJsRuntime	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   601: aload_0
    //   602: aload_1
    //   603: putfield 453	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:event	Ljava/lang/String;
    //   606: aload_0
    //   607: iload 4
    //   609: putfield 455	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackId	I
    //   612: aload_0
    //   613: getfield 74	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:lock	[B
    //   616: astore 7
    //   618: aload 7
    //   620: monitorenter
    //   621: new 128	org/json/JSONObject
    //   624: dup
    //   625: aload_2
    //   626: invokespecial 317	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   629: astore 9
    //   631: aload 9
    //   633: ldc_w 319
    //   636: iconst_0
    //   637: invokevirtual 323	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   640: istore 6
    //   642: aload 9
    //   644: ldc_w 457
    //   647: aload_0
    //   648: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   651: getfield 203	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   654: invokevirtual 255	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   657: invokevirtual 461	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   660: getfield 467	com/tencent/mobileqq/mini/apkg/AppConfigInfo:networkTimeoutInfo	Lcom/tencent/mobileqq/mini/apkg/NetworkTimeoutInfo;
    //   663: getfield 472	com/tencent/mobileqq/mini/apkg/NetworkTimeoutInfo:connectSocket	I
    //   666: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   669: pop
    //   670: new 474	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$MiniAppWebsocketListener
    //   673: dup
    //   674: aload_0
    //   675: invokespecial 477	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$MiniAppWebsocketListener:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin;)V
    //   678: astore 8
    //   680: new 273	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask$RequestParam
    //   683: dup
    //   684: aload 9
    //   686: invokespecial 480	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask$RequestParam:<init>	(Lorg/json/JSONObject;)V
    //   689: astore 9
    //   691: aload 9
    //   693: getfield 276	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask$RequestParam:url	Ljava/lang/String;
    //   696: astore 10
    //   698: aload_0
    //   699: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   702: getfield 203	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   705: invokevirtual 255	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   708: iload 6
    //   710: aload 10
    //   712: iconst_1
    //   713: invokevirtual 347	com/tencent/mobileqq/mini/apkg/ApkgInfo:isDomainValid	(ZLjava/lang/String;I)Z
    //   716: ifne +254 -> 970
    //   719: ldc 35
    //   721: iconst_1
    //   722: new 100	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   729: ldc_w 482
    //   732: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: aload_1
    //   736: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: ldc_w 351
    //   742: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: iload 4
    //   747: invokevirtual 314	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   750: ldc_w 353
    //   753: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: aload 10
    //   758: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   764: invokestatic 356	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   767: aload_0
    //   768: aload_3
    //   769: aconst_null
    //   770: iload 4
    //   772: ldc_w 484
    //   775: ldc_w 485
    //   778: invokestatic 365	alpo:a	(I)Ljava/lang/String;
    //   781: invokespecial 367	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   784: aload 7
    //   786: monitorexit
    //   787: ldc 115
    //   789: areturn
    //   790: astore 8
    //   792: aload 7
    //   794: monitorexit
    //   795: aload 8
    //   797: athrow
    //   798: astore 7
    //   800: ldc 35
    //   802: iconst_1
    //   803: new 100	java/lang/StringBuilder
    //   806: dup
    //   807: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   810: aload_1
    //   811: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: ldc_w 415
    //   817: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   823: aload 7
    //   825: invokestatic 285	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   828: aload_0
    //   829: aload_0
    //   830: getfield 83	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:mJsRuntime	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   833: aconst_null
    //   834: iload 4
    //   836: aload_1
    //   837: invokespecial 417	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   840: new 273	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask$RequestParam
    //   843: dup
    //   844: new 128	org/json/JSONObject
    //   847: dup
    //   848: aload_2
    //   849: invokespecial 317	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   852: invokespecial 480	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask$RequestParam:<init>	(Lorg/json/JSONObject;)V
    //   855: getfield 276	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask$RequestParam:url	Ljava/lang/String;
    //   858: astore 7
    //   860: aload_0
    //   861: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   864: ifnull -482 -> 382
    //   867: aload_0
    //   868: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   871: getfield 203	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   874: ifnull -492 -> 382
    //   877: aload_0
    //   878: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   881: getfield 203	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   884: invokevirtual 255	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   887: ifnull -505 -> 382
    //   890: aload_0
    //   891: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   894: getfield 203	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   897: invokevirtual 255	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   900: getfield 261	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   903: ifnull -521 -> 382
    //   906: aload_0
    //   907: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   910: getfield 203	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   913: invokevirtual 255	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   916: getfield 261	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   919: sipush 632
    //   922: aconst_null
    //   923: aconst_null
    //   924: aconst_null
    //   925: iconst_1
    //   926: aload_0
    //   927: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   930: getfield 203	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   933: invokevirtual 255	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   936: getfield 261	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   939: invokestatic 267	com/tencent/mobileqq/mini/report/MiniReportManager:getAppType	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;)Ljava/lang/String;
    //   942: lconst_0
    //   943: aload 7
    //   945: invokestatic 88	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:getSecondLevelDomain	(Ljava/lang/String;)Ljava/lang/String;
    //   948: invokestatic 280	com/tencent/mobileqq/mini/report/MiniReportManager:reportEventType	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;)V
    //   951: goto -569 -> 382
    //   954: astore 7
    //   956: ldc 35
    //   958: iconst_2
    //   959: ldc_w 487
    //   962: aload 7
    //   964: invokestatic 285	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   967: goto -585 -> 382
    //   970: new 251	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask
    //   973: dup
    //   974: aload 9
    //   976: aload 8
    //   978: invokespecial 490	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask:<init>	(Lcom/tencent/mobileqq/mini/websocket/WebsocketRequestTask$RequestParam;Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$MiniAppWebsocketListener;)V
    //   981: astore 9
    //   983: aload_0
    //   984: getfield 79	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   987: aload 8
    //   989: getfield 493	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$MiniAppWebsocketListener:currSocketId	I
    //   992: aload 9
    //   994: invokevirtual 496	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   997: new 128	org/json/JSONObject
    //   1000: dup
    //   1001: aload_2
    //   1002: invokespecial 317	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1005: astore 9
    //   1007: aload 9
    //   1009: ldc 224
    //   1011: aload 8
    //   1013: getfield 493	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$MiniAppWebsocketListener:currSocketId	I
    //   1016: invokevirtual 228	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1019: pop
    //   1020: aload 9
    //   1022: ldc 117
    //   1024: new 100	java/lang/StringBuilder
    //   1027: dup
    //   1028: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   1031: aload_1
    //   1032: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: ldc_w 498
    //   1038: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1041: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1044: invokevirtual 235	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1047: pop
    //   1048: aload_0
    //   1049: aload_3
    //   1050: aload 9
    //   1052: iload 4
    //   1054: aload_1
    //   1055: invokespecial 409	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   1058: aload 9
    //   1060: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1063: astore 8
    //   1065: aload 7
    //   1067: monitorexit
    //   1068: aload 8
    //   1070: areturn
    //   1071: ldc 20
    //   1073: aload_1
    //   1074: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1077: ifeq +665 -> 1742
    //   1080: new 128	org/json/JSONObject
    //   1083: dup
    //   1084: aload_2
    //   1085: invokespecial 317	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1088: astore 7
    //   1090: aload 7
    //   1092: ldc_w 431
    //   1095: invokevirtual 434	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1098: astore 8
    //   1100: aload 7
    //   1102: ldc 224
    //   1104: invokevirtual 429	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1107: istore 5
    //   1109: ldc 232
    //   1111: aload 8
    //   1113: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1116: ifeq +198 -> 1314
    //   1119: aload_0
    //   1120: getfield 74	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:lock	[B
    //   1123: astore_2
    //   1124: aload_2
    //   1125: monitorenter
    //   1126: aload_0
    //   1127: getfield 79	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1130: ifnull +147 -> 1277
    //   1133: aload_0
    //   1134: getfield 79	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1137: invokevirtual 501	android/util/SparseArray:size	()I
    //   1140: ifeq +137 -> 1277
    //   1143: aload_0
    //   1144: getfield 79	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1147: iload 5
    //   1149: invokevirtual 249	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1152: checkcast 251	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask
    //   1155: astore 8
    //   1157: aload_0
    //   1158: getfield 79	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1161: iload 5
    //   1163: invokevirtual 504	android/util/SparseArray:remove	(I)V
    //   1166: aload 7
    //   1168: ldc 237
    //   1170: sipush 1000
    //   1173: invokevirtual 507	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1176: istore 5
    //   1178: aload 7
    //   1180: ldc 239
    //   1182: ldc_w 509
    //   1185: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1188: astore 7
    //   1190: aload 8
    //   1192: ifnull +12 -> 1204
    //   1195: aload 8
    //   1197: iload 5
    //   1199: aload 7
    //   1201: invokevirtual 515	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask:closeSocket	(ILjava/lang/String;)V
    //   1204: aload_0
    //   1205: getfield 407	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1208: ifeq +14 -> 1222
    //   1211: aload_0
    //   1212: aload_3
    //   1213: aconst_null
    //   1214: iload 4
    //   1216: ldc_w 516
    //   1219: invokespecial 409	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   1222: aload_1
    //   1223: aconst_null
    //   1224: invokestatic 413	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1227: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1230: astore_3
    //   1231: aload_2
    //   1232: monitorexit
    //   1233: aload_3
    //   1234: areturn
    //   1235: astore_3
    //   1236: aload_2
    //   1237: monitorexit
    //   1238: aload_3
    //   1239: athrow
    //   1240: astore_2
    //   1241: ldc 35
    //   1243: iconst_1
    //   1244: new 100	java/lang/StringBuilder
    //   1247: dup
    //   1248: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   1251: aload_1
    //   1252: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1255: ldc_w 415
    //   1258: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1264: aload_2
    //   1265: invokestatic 285	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1268: aload_1
    //   1269: aconst_null
    //   1270: invokestatic 421	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1273: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1276: areturn
    //   1277: aload_0
    //   1278: getfield 407	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1281: ifeq +17 -> 1298
    //   1284: aload_0
    //   1285: aload_3
    //   1286: aconst_null
    //   1287: iload 4
    //   1289: ldc_w 516
    //   1292: ldc_w 518
    //   1295: invokespecial 367	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   1298: aload_1
    //   1299: aconst_null
    //   1300: ldc_w 518
    //   1303: invokestatic 374	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1306: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1309: astore_3
    //   1310: aload_2
    //   1311: monitorexit
    //   1312: aload_3
    //   1313: areturn
    //   1314: ldc_w 520
    //   1317: aload 8
    //   1319: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1322: ifeq -940 -> 382
    //   1325: aload 7
    //   1327: ldc_w 522
    //   1330: aconst_null
    //   1331: invokevirtual 512	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1334: astore 8
    //   1336: aload 8
    //   1338: ifnull +200 -> 1538
    //   1341: aload_0
    //   1342: getfield 74	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:lock	[B
    //   1345: astore_2
    //   1346: aload_2
    //   1347: monitorenter
    //   1348: aload_0
    //   1349: getfield 79	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1352: ifnull +149 -> 1501
    //   1355: aload_0
    //   1356: getfield 79	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1359: invokevirtual 501	android/util/SparseArray:size	()I
    //   1362: ifeq +139 -> 1501
    //   1365: aload_0
    //   1366: getfield 79	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1369: iload 5
    //   1371: invokevirtual 249	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1374: checkcast 251	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask
    //   1377: astore 7
    //   1379: aload 7
    //   1381: ifnull +46 -> 1427
    //   1384: aload 7
    //   1386: aload 8
    //   1388: invokevirtual 525	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask:sendStringMessage	(Ljava/lang/String;)V
    //   1391: aload_0
    //   1392: getfield 407	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1395: ifeq +14 -> 1409
    //   1398: aload_0
    //   1399: aload_3
    //   1400: aconst_null
    //   1401: iload 4
    //   1403: ldc_w 527
    //   1406: invokespecial 409	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   1409: aload_1
    //   1410: aconst_null
    //   1411: invokestatic 413	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1414: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1417: astore_3
    //   1418: aload_2
    //   1419: monitorexit
    //   1420: aload_3
    //   1421: areturn
    //   1422: astore_3
    //   1423: aload_2
    //   1424: monitorexit
    //   1425: aload_3
    //   1426: athrow
    //   1427: ldc 35
    //   1429: iconst_1
    //   1430: new 100	java/lang/StringBuilder
    //   1433: dup
    //   1434: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   1437: aload_1
    //   1438: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1441: ldc_w 529
    //   1444: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1447: aload 8
    //   1449: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1452: ldc_w 531
    //   1455: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1458: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1461: invokestatic 149	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1464: aload_0
    //   1465: getfield 407	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1468: ifeq +17 -> 1485
    //   1471: aload_0
    //   1472: aload_3
    //   1473: aconst_null
    //   1474: iload 4
    //   1476: ldc_w 527
    //   1479: ldc_w 533
    //   1482: invokespecial 367	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   1485: aload_1
    //   1486: aconst_null
    //   1487: ldc_w 533
    //   1490: invokestatic 374	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1493: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1496: astore_3
    //   1497: aload_2
    //   1498: monitorexit
    //   1499: aload_3
    //   1500: areturn
    //   1501: aload_0
    //   1502: getfield 407	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1505: ifeq +17 -> 1522
    //   1508: aload_0
    //   1509: aload_3
    //   1510: aconst_null
    //   1511: iload 4
    //   1513: ldc_w 527
    //   1516: ldc_w 518
    //   1519: invokespecial 367	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   1522: aload_1
    //   1523: aconst_null
    //   1524: ldc_w 518
    //   1527: invokestatic 374	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1530: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1533: astore_3
    //   1534: aload_2
    //   1535: monitorexit
    //   1536: aload_3
    //   1537: areturn
    //   1538: aload 7
    //   1540: invokestatic 539	com/tencent/mobileqq/minigame/utils/NativeBuffer:hasNativeBuffer	(Lorg/json/JSONObject;)Z
    //   1543: ifeq -1161 -> 382
    //   1546: aload 7
    //   1548: ldc_w 522
    //   1551: aload_0
    //   1552: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1555: invokevirtual 335	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getNativeBufferPool	()Ljava/lang/Object;
    //   1558: checkcast 337	com/tencent/mobileqq/triton/sdk/bridge/ITNativeBufferPool
    //   1561: invokestatic 543	com/tencent/mobileqq/minigame/utils/NativeBuffer:unpackNativeBuffer	(Lorg/json/JSONObject;Ljava/lang/String;Lcom/tencent/mobileqq/triton/sdk/bridge/ITNativeBufferPool;)Lcom/tencent/mobileqq/minigame/utils/NativeBuffer;
    //   1564: astore_2
    //   1565: aload_2
    //   1566: ifnull +141 -> 1707
    //   1569: aload_2
    //   1570: getfield 546	com/tencent/mobileqq/minigame/utils/NativeBuffer:buf	[B
    //   1573: ifnull +134 -> 1707
    //   1576: aload_0
    //   1577: getfield 79	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1580: ifnull +127 -> 1707
    //   1583: aload_0
    //   1584: getfield 79	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1587: invokevirtual 501	android/util/SparseArray:size	()I
    //   1590: ifeq +117 -> 1707
    //   1593: aload_0
    //   1594: getfield 79	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1597: iload 5
    //   1599: invokevirtual 249	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1602: checkcast 251	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask
    //   1605: astore 7
    //   1607: aload 7
    //   1609: ifnull +39 -> 1648
    //   1612: aload 7
    //   1614: aload_2
    //   1615: getfield 546	com/tencent/mobileqq/minigame/utils/NativeBuffer:buf	[B
    //   1618: invokevirtual 550	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask:sendBinaryMessage	([B)V
    //   1621: aload_0
    //   1622: getfield 407	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1625: ifeq +14 -> 1639
    //   1628: aload_0
    //   1629: aload_3
    //   1630: aconst_null
    //   1631: iload 4
    //   1633: ldc_w 527
    //   1636: invokespecial 409	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   1639: aload_1
    //   1640: aconst_null
    //   1641: invokestatic 413	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1644: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1647: areturn
    //   1648: ldc 35
    //   1650: iconst_1
    //   1651: new 100	java/lang/StringBuilder
    //   1654: dup
    //   1655: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   1658: aload_1
    //   1659: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1662: ldc_w 552
    //   1665: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1668: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1671: invokestatic 149	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1674: aload_0
    //   1675: getfield 407	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1678: ifeq +17 -> 1695
    //   1681: aload_0
    //   1682: aload_3
    //   1683: aconst_null
    //   1684: iload 4
    //   1686: ldc_w 527
    //   1689: ldc_w 533
    //   1692: invokespecial 367	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   1695: aload_1
    //   1696: aconst_null
    //   1697: ldc_w 533
    //   1700: invokestatic 374	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1703: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1706: areturn
    //   1707: aload_0
    //   1708: getfield 407	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1711: ifeq +17 -> 1728
    //   1714: aload_0
    //   1715: aload_3
    //   1716: aconst_null
    //   1717: iload 4
    //   1719: ldc_w 527
    //   1722: ldc_w 518
    //   1725: invokespecial 367	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   1728: aload_1
    //   1729: aconst_null
    //   1730: ldc_w 518
    //   1733: invokestatic 374	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1736: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1739: astore_2
    //   1740: aload_2
    //   1741: areturn
    //   1742: ldc 38
    //   1744: aload_1
    //   1745: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1748: ifeq +61 -> 1809
    //   1751: aload_0
    //   1752: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1755: ifnonnull +6 -> 1761
    //   1758: ldc 115
    //   1760: areturn
    //   1761: aload_2
    //   1762: aload_3
    //   1763: aload_1
    //   1764: iload 4
    //   1766: aload_0
    //   1767: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1770: invokestatic 558	com/tencent/mobileqq/mini/entry/MiniAppUtils:performWnsCgiRequest	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;)V
    //   1773: goto -1391 -> 382
    //   1776: astore 7
    //   1778: ldc 35
    //   1780: iconst_1
    //   1781: new 100	java/lang/StringBuilder
    //   1784: dup
    //   1785: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   1788: aload_1
    //   1789: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1792: ldc_w 415
    //   1795: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1798: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1801: aload 7
    //   1803: invokestatic 285	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1806: goto -1424 -> 382
    //   1809: ldc 41
    //   1811: aload_1
    //   1812: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1815: ifeq -1433 -> 382
    //   1818: invokestatic 562	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1821: ifeq +33 -> 1854
    //   1824: ldc 35
    //   1826: iconst_2
    //   1827: new 100	java/lang/StringBuilder
    //   1830: dup
    //   1831: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   1834: aload_1
    //   1835: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1838: ldc_w 564
    //   1841: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1844: aload_2
    //   1845: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1848: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1851: invokestatic 567	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1854: aload_0
    //   1855: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1858: ifnull +270 -> 2128
    //   1861: aload_2
    //   1862: invokestatic 113	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1865: ifeq +6 -> 1871
    //   1868: goto +260 -> 2128
    //   1871: new 128	org/json/JSONObject
    //   1874: dup
    //   1875: aload_2
    //   1876: invokespecial 317	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1879: ldc_w 569
    //   1882: invokevirtual 434	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1885: astore 7
    //   1887: aload_0
    //   1888: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1891: getfield 203	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   1894: invokevirtual 255	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   1897: astore 8
    //   1899: aload 8
    //   1901: ifnull -1519 -> 382
    //   1904: aload 8
    //   1906: getfield 261	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1909: ifnull -1527 -> 382
    //   1912: aload 8
    //   1914: getfield 261	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1917: getfield 575	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1920: ifnull -1538 -> 382
    //   1923: aload 8
    //   1925: getfield 261	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1928: getfield 575	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1931: getfield 581	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   1934: ifnull -1552 -> 382
    //   1937: aload 7
    //   1939: ifnull -1557 -> 382
    //   1942: aload 7
    //   1944: aload 8
    //   1946: getfield 261	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1949: getfield 575	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1952: getfield 581	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   1955: invokevirtual 586	com/tencent/mobileqq/mini/sdk/EntryModel:getEntryHash	()Ljava/lang/String;
    //   1958: invokevirtual 141	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1961: ifeq +132 -> 2093
    //   1964: aload 8
    //   1966: getfield 261	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   1969: getfield 575	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   1972: getfield 581	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   1975: getfield 589	com/tencent/mobileqq/mini/sdk/EntryModel:isAdmin	Z
    //   1978: ifeq +115 -> 2093
    //   1981: aload_2
    //   1982: ldc_w 591
    //   1985: invokevirtual 594	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1988: ifeq +74 -> 2062
    //   1991: aload_2
    //   1992: ldc_w 591
    //   1995: aload 8
    //   1997: getfield 261	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   2000: getfield 575	com/tencent/mobileqq/mini/apkg/MiniAppConfig:launchParam	Lcom/tencent/mobileqq/mini/sdk/LaunchParam;
    //   2003: getfield 581	com/tencent/mobileqq/mini/sdk/LaunchParam:entryModel	Lcom/tencent/mobileqq/mini/sdk/EntryModel;
    //   2006: getfield 598	com/tencent/mobileqq/mini/sdk/EntryModel:uin	J
    //   2009: invokestatic 601	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2012: invokevirtual 605	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   2015: aload_3
    //   2016: aload_1
    //   2017: iload 4
    //   2019: aload_0
    //   2020: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2023: invokestatic 558	com/tencent/mobileqq/mini/entry/MiniAppUtils:performWnsCgiRequest	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;)V
    //   2026: goto -1644 -> 382
    //   2029: astore 7
    //   2031: ldc 35
    //   2033: iconst_1
    //   2034: new 100	java/lang/StringBuilder
    //   2037: dup
    //   2038: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   2041: aload_1
    //   2042: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2045: ldc_w 415
    //   2048: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2051: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2054: aload 7
    //   2056: invokestatic 285	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2059: goto -1677 -> 382
    //   2062: aload_0
    //   2063: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2066: aload_3
    //   2067: aload_1
    //   2068: aload_1
    //   2069: aconst_null
    //   2070: ldc_w 607
    //   2073: invokestatic 374	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   2076: iload 4
    //   2078: invokevirtual 611	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   2081: aload_1
    //   2082: aconst_null
    //   2083: ldc_w 607
    //   2086: invokestatic 374	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   2089: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2092: areturn
    //   2093: aload_0
    //   2094: getfield 197	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   2097: aload_3
    //   2098: aload_1
    //   2099: aload_1
    //   2100: aconst_null
    //   2101: ldc_w 613
    //   2104: invokestatic 374	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   2107: iload 4
    //   2109: invokevirtual 611	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   2112: aload_1
    //   2113: aconst_null
    //   2114: ldc_w 613
    //   2117: invokestatic 374	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   2120: invokevirtual 129	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2123: astore 7
    //   2125: aload 7
    //   2127: areturn
    //   2128: ldc 115
    //   2130: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2131	0	this	RequestPlugin
    //   0	2131	1	paramString1	String
    //   0	2131	3	paramJsRuntime	JsRuntime
    //   0	2131	4	paramInt	int
    //   471	1127	5	i	int
    //   80	629	6	bool	boolean
    //   69	263	7	localObject1	Object
    //   334	5	7	localObject2	Object
    //   341	26	7	localThrowable1	java.lang.Throwable
    //   418	5	7	str1	String
    //   425	6	7	localThrowable2	java.lang.Throwable
    //   461	63	7	localObject3	Object
    //   555	19	7	localException	Exception
    //   798	26	7	localThrowable3	java.lang.Throwable
    //   858	86	7	str2	String
    //   954	112	7	localThrowable4	java.lang.Throwable
    //   1088	525	7	localObject4	Object
    //   1776	26	7	localThrowable5	java.lang.Throwable
    //   1885	58	7	str3	String
    //   2029	26	7	localThrowable6	java.lang.Throwable
    //   2123	3	7	str4	String
    //   119	560	8	localObject5	Object
    //   790	222	8	localMiniAppWebsocketListener	RequestPlugin.MiniAppWebsocketListener
    //   1063	933	8	localObject6	Object
    //   629	430	9	localObject7	Object
    //   696	61	10	str5	String
    // Exception table:
    //   from	to	target	type
    //   61	227	334	finally
    //   230	269	334	finally
    //   269	318	334	finally
    //   318	329	334	finally
    //   329	331	334	finally
    //   336	338	334	finally
    //   392	409	334	finally
    //   409	420	334	finally
    //   420	422	334	finally
    //   427	441	334	finally
    //   59	61	341	java/lang/Throwable
    //   338	341	341	java/lang/Throwable
    //   269	318	425	java/lang/Throwable
    //   318	329	425	java/lang/Throwable
    //   392	409	425	java/lang/Throwable
    //   409	420	425	java/lang/Throwable
    //   453	515	555	java/lang/Exception
    //   520	552	555	java/lang/Exception
    //   621	787	790	finally
    //   792	795	790	finally
    //   970	1068	790	finally
    //   612	621	798	java/lang/Throwable
    //   795	798	798	java/lang/Throwable
    //   840	951	954	java/lang/Throwable
    //   1126	1190	1235	finally
    //   1195	1204	1235	finally
    //   1204	1222	1235	finally
    //   1222	1233	1235	finally
    //   1236	1238	1235	finally
    //   1277	1298	1235	finally
    //   1298	1312	1235	finally
    //   1080	1126	1240	java/lang/Throwable
    //   1238	1240	1240	java/lang/Throwable
    //   1314	1336	1240	java/lang/Throwable
    //   1341	1348	1240	java/lang/Throwable
    //   1425	1427	1240	java/lang/Throwable
    //   1538	1565	1240	java/lang/Throwable
    //   1569	1607	1240	java/lang/Throwable
    //   1612	1639	1240	java/lang/Throwable
    //   1639	1648	1240	java/lang/Throwable
    //   1648	1695	1240	java/lang/Throwable
    //   1695	1707	1240	java/lang/Throwable
    //   1707	1728	1240	java/lang/Throwable
    //   1728	1740	1240	java/lang/Throwable
    //   1348	1379	1422	finally
    //   1384	1409	1422	finally
    //   1409	1420	1422	finally
    //   1423	1425	1422	finally
    //   1427	1485	1422	finally
    //   1485	1499	1422	finally
    //   1501	1522	1422	finally
    //   1522	1536	1422	finally
    //   1751	1758	1776	java/lang/Throwable
    //   1761	1773	1776	java/lang/Throwable
    //   1854	1868	2029	java/lang/Throwable
    //   1871	1899	2029	java/lang/Throwable
    //   1904	1937	2029	java/lang/Throwable
    //   1942	2026	2029	java/lang/Throwable
    //   2062	2093	2029	java/lang/Throwable
    //   2093	2125	2029	java/lang/Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RequestPlugin
 * JD-Core Version:    0.7.0.1
 */