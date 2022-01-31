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
import com.tencent.mobileqq.minigame.manager.GameLoadManager;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
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
  private int callbackId;
  private String event;
  private byte[] lock = new byte[0];
  private WeakReference<BaseJsPluginEngine> mEngineRef;
  private JsRuntime mJsRuntime;
  private ITTEngine mTTEngine = GameLoadManager.g().getGameEngine();
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
    //   3: new 113	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 315
    //   13: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_2
    //   17: invokestatic 320	com/tencent/mobileqq/minigame/utils/GameLog:cutString	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc_w 322
    //   26: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc_w 324
    //   36: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload 4
    //   41: invokevirtual 327	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 169	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: ldc 8
    //   52: aload_1
    //   53: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   56: ifeq +378 -> 434
    //   59: aload_0
    //   60: monitorenter
    //   61: new 141	org/json/JSONObject
    //   64: dup
    //   65: aload_2
    //   66: invokespecial 330	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   69: astore 7
    //   71: aload 7
    //   73: ldc_w 332
    //   76: iconst_0
    //   77: invokevirtual 336	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   80: istore 6
    //   82: new 338	com/tencent/mobileqq/mini/http/RequestTask$Request
    //   85: dup
    //   86: aload 7
    //   88: aload_0
    //   89: getfield 210	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   92: invokestatic 344	com/tencent/mobileqq/mini/http/MiniappHttpUtil:getRequestReferer	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;)Ljava/lang/String;
    //   95: aload_0
    //   96: invokespecial 345	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:getUserAgent	()Ljava/lang/String;
    //   99: invokespecial 348	com/tencent/mobileqq/mini/http/RequestTask$Request:<init>	(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V
    //   102: astore 7
    //   104: aload 7
    //   106: getfield 351	com/tencent/mobileqq/mini/http/RequestTask$Request:mUrl	Ljava/lang/String;
    //   109: astore 8
    //   111: aload_0
    //   112: getfield 210	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   115: getfield 216	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   118: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   121: iload 6
    //   123: aload 8
    //   125: iconst_0
    //   126: invokevirtual 355	com/tencent/mobileqq/mini/apkg/ApkgInfo:isDomainValid	(ZLjava/lang/String;I)Z
    //   129: ifne +91 -> 220
    //   132: ldc 35
    //   134: iconst_1
    //   135: new 113	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 357
    //   145: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_1
    //   149: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: ldc_w 359
    //   155: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: iload 4
    //   160: invokevirtual 327	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: ldc_w 361
    //   166: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 8
    //   171: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 364	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: aload_0
    //   181: aload_3
    //   182: aconst_null
    //   183: iload 4
    //   185: ldc_w 366
    //   188: ldc_w 367
    //   191: invokestatic 373	ajjy:a	(I)Ljava/lang/String;
    //   194: invokespecial 375	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   197: ldc_w 366
    //   200: aconst_null
    //   201: ldc_w 376
    //   204: invokestatic 373	ajjy:a	(I)Ljava/lang/String;
    //   207: invokestatic 382	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   210: invokevirtual 142	org/json/JSONObject:toString	()Ljava/lang/String;
    //   213: astore 7
    //   215: aload_0
    //   216: monitorexit
    //   217: aload 7
    //   219: areturn
    //   220: aload_0
    //   221: getfield 71	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:requestMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   224: aload 7
    //   226: getfield 385	com/tencent/mobileqq/mini/http/RequestTask$Request:mTaskId	I
    //   229: invokestatic 391	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   232: aload 7
    //   234: invokevirtual 394	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   237: pop
    //   238: aload 7
    //   240: new 396	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$2
    //   243: dup
    //   244: aload_0
    //   245: aload 8
    //   247: aload 7
    //   249: aload_3
    //   250: iload 4
    //   252: aload_2
    //   253: invokespecial 399	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$2:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin;Ljava/lang/String;Lcom/tencent/mobileqq/mini/http/RequestTask$Request;Lcom/tencent/mobileqq/mini/webview/JsRuntime;ILjava/lang/String;)V
    //   256: putfield 403	com/tencent/mobileqq/mini/http/RequestTask$Request:mCallback	Lcom/tencent/mobileqq/mini/http/HttpCallBack;
    //   259: new 141	org/json/JSONObject
    //   262: dup
    //   263: aload_2
    //   264: invokespecial 330	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   267: astore 8
    //   269: aload 8
    //   271: ldc_w 405
    //   274: aload 7
    //   276: getfield 385	com/tencent/mobileqq/mini/http/RequestTask$Request:mTaskId	I
    //   279: invokevirtual 241	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   282: pop
    //   283: aload 7
    //   285: invokestatic 411	com/tencent/mobileqq/mini/http/WxRequest:request	(Lcom/tencent/mobileqq/mini/http/RequestTask$Request;)Z
    //   288: ifeq +94 -> 382
    //   291: aload_0
    //   292: getfield 415	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   295: ifne +13 -> 308
    //   298: aload_0
    //   299: aload_3
    //   300: aload 8
    //   302: iload 4
    //   304: aload_1
    //   305: invokespecial 417	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   308: aload_1
    //   309: aload 8
    //   311: invokestatic 421	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   314: invokevirtual 142	org/json/JSONObject:toString	()Ljava/lang/String;
    //   317: astore 7
    //   319: aload_0
    //   320: monitorexit
    //   321: aload 7
    //   323: areturn
    //   324: astore 7
    //   326: aload_0
    //   327: monitorexit
    //   328: aload 7
    //   330: athrow
    //   331: astore 7
    //   333: ldc 35
    //   335: iconst_1
    //   336: new 113	java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   343: aload_1
    //   344: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: ldc_w 423
    //   350: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: aload 7
    //   358: invokestatic 298	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   361: aload_0
    //   362: aload_3
    //   363: aconst_null
    //   364: iload 4
    //   366: ldc_w 366
    //   369: invokespecial 425	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   372: aload_0
    //   373: aload_1
    //   374: aload_2
    //   375: aload_3
    //   376: iload 4
    //   378: invokespecial 427	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPlugin:handleNativeRequest	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;I)Ljava/lang/String;
    //   381: areturn
    //   382: aload_0
    //   383: getfield 415	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   386: ifne +13 -> 399
    //   389: aload_0
    //   390: aload_3
    //   391: aload 8
    //   393: iload 4
    //   395: aload_1
    //   396: invokespecial 425	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   399: aload_1
    //   400: aload 8
    //   402: invokestatic 429	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   405: invokevirtual 142	org/json/JSONObject:toString	()Ljava/lang/String;
    //   408: astore 7
    //   410: aload_0
    //   411: monitorexit
    //   412: aload 7
    //   414: areturn
    //   415: astore 7
    //   417: ldc 35
    //   419: iconst_1
    //   420: aload 7
    //   422: iconst_0
    //   423: anewarray 431	java/lang/Object
    //   426: invokestatic 434	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   429: aload_0
    //   430: monitorexit
    //   431: goto -59 -> 372
    //   434: ldc 17
    //   436: aload_1
    //   437: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   440: ifeq +137 -> 577
    //   443: new 141	org/json/JSONObject
    //   446: dup
    //   447: aload_2
    //   448: invokespecial 330	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   451: astore 7
    //   453: aload 7
    //   455: ldc_w 405
    //   458: invokevirtual 437	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   461: istore 5
    //   463: aload 7
    //   465: ldc_w 439
    //   468: invokevirtual 442	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   471: astore 7
    //   473: aload_0
    //   474: getfield 71	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:requestMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   477: iload 5
    //   479: invokestatic 391	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   482: invokevirtual 445	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   485: ifeq -113 -> 372
    //   488: aload_0
    //   489: getfield 71	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:requestMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   492: iload 5
    //   494: invokestatic 391	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   497: invokevirtual 449	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   500: checkcast 338	com/tencent/mobileqq/mini/http/RequestTask$Request
    //   503: astore 8
    //   505: aload 8
    //   507: ifnull -135 -> 372
    //   510: ldc_w 451
    //   513: aload 7
    //   515: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   518: ifeq -146 -> 372
    //   521: aload 8
    //   523: invokestatic 454	com/tencent/mobileqq/mini/http/WxRequest:abort	(Lcom/tencent/mobileqq/mini/http/RequestTask$Request;)V
    //   526: aload_0
    //   527: getfield 415	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   530: ifne -158 -> 372
    //   533: aload_0
    //   534: aload_3
    //   535: aconst_null
    //   536: iload 4
    //   538: aload_1
    //   539: invokespecial 417	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   542: goto -170 -> 372
    //   545: astore 7
    //   547: ldc 35
    //   549: iconst_1
    //   550: new 113	java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   557: ldc_w 456
    //   560: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload 7
    //   565: invokevirtual 459	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   568: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   574: goto -202 -> 372
    //   577: ldc 11
    //   579: aload_1
    //   580: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   583: ifeq +478 -> 1061
    //   586: aload_0
    //   587: aload_3
    //   588: putfield 94	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:mJsRuntime	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   591: aload_0
    //   592: aload_1
    //   593: putfield 461	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:event	Ljava/lang/String;
    //   596: aload_0
    //   597: iload 4
    //   599: putfield 463	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackId	I
    //   602: aload_0
    //   603: getfield 73	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:lock	[B
    //   606: astore 7
    //   608: aload 7
    //   610: monitorenter
    //   611: new 141	org/json/JSONObject
    //   614: dup
    //   615: aload_2
    //   616: invokespecial 330	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   619: astore 9
    //   621: aload 9
    //   623: ldc_w 332
    //   626: iconst_0
    //   627: invokevirtual 336	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   630: istore 6
    //   632: aload 9
    //   634: ldc_w 465
    //   637: aload_0
    //   638: getfield 210	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   641: getfield 216	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   644: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   647: invokevirtual 469	com/tencent/mobileqq/mini/apkg/ApkgInfo:getAppConfigInfo	()Lcom/tencent/mobileqq/mini/apkg/AppConfigInfo;
    //   650: getfield 475	com/tencent/mobileqq/mini/apkg/AppConfigInfo:networkTimeoutInfo	Lcom/tencent/mobileqq/mini/apkg/NetworkTimeoutInfo;
    //   653: getfield 480	com/tencent/mobileqq/mini/apkg/NetworkTimeoutInfo:connectSocket	I
    //   656: invokevirtual 241	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   659: pop
    //   660: new 482	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$MiniAppWebsocketListener
    //   663: dup
    //   664: aload_0
    //   665: invokespecial 485	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$MiniAppWebsocketListener:<init>	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin;)V
    //   668: astore 8
    //   670: new 286	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask$RequestParam
    //   673: dup
    //   674: aload 9
    //   676: invokespecial 488	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask$RequestParam:<init>	(Lorg/json/JSONObject;)V
    //   679: astore 9
    //   681: aload 9
    //   683: getfield 289	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask$RequestParam:url	Ljava/lang/String;
    //   686: astore 10
    //   688: aload_0
    //   689: getfield 210	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   692: getfield 216	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   695: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   698: iload 6
    //   700: aload 10
    //   702: iconst_1
    //   703: invokevirtual 355	com/tencent/mobileqq/mini/apkg/ApkgInfo:isDomainValid	(ZLjava/lang/String;I)Z
    //   706: ifne +254 -> 960
    //   709: ldc 35
    //   711: iconst_1
    //   712: new 113	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   719: ldc_w 490
    //   722: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: aload_1
    //   726: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: ldc_w 359
    //   732: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: iload 4
    //   737: invokevirtual 327	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   740: ldc_w 361
    //   743: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: aload 10
    //   748: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   754: invokestatic 364	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   757: aload_0
    //   758: aload_3
    //   759: aconst_null
    //   760: iload 4
    //   762: ldc_w 492
    //   765: ldc_w 493
    //   768: invokestatic 373	ajjy:a	(I)Ljava/lang/String;
    //   771: invokespecial 375	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   774: aload 7
    //   776: monitorexit
    //   777: ldc 128
    //   779: areturn
    //   780: astore 8
    //   782: aload 7
    //   784: monitorexit
    //   785: aload 8
    //   787: athrow
    //   788: astore 7
    //   790: ldc 35
    //   792: iconst_1
    //   793: new 113	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   800: aload_1
    //   801: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: ldc_w 423
    //   807: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   813: aload 7
    //   815: invokestatic 298	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   818: aload_0
    //   819: aload_0
    //   820: getfield 94	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:mJsRuntime	Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   823: aconst_null
    //   824: iload 4
    //   826: aload_1
    //   827: invokespecial 425	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   830: new 286	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask$RequestParam
    //   833: dup
    //   834: new 141	org/json/JSONObject
    //   837: dup
    //   838: aload_2
    //   839: invokespecial 330	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   842: invokespecial 488	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask$RequestParam:<init>	(Lorg/json/JSONObject;)V
    //   845: getfield 289	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask$RequestParam:url	Ljava/lang/String;
    //   848: astore 7
    //   850: aload_0
    //   851: getfield 210	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   854: ifnull -482 -> 372
    //   857: aload_0
    //   858: getfield 210	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   861: getfield 216	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   864: ifnull -492 -> 372
    //   867: aload_0
    //   868: getfield 210	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   871: getfield 216	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   874: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   877: ifnull -505 -> 372
    //   880: aload_0
    //   881: getfield 210	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   884: getfield 216	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   887: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   890: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   893: ifnull -521 -> 372
    //   896: aload_0
    //   897: getfield 210	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   900: getfield 216	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   903: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   906: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   909: sipush 632
    //   912: aconst_null
    //   913: aconst_null
    //   914: aconst_null
    //   915: iconst_1
    //   916: aload_0
    //   917: getfield 210	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   920: getfield 216	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:appBrandRuntime	Lcom/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime;
    //   923: invokevirtual 268	com/tencent/mobileqq/mini/appbrand/BaseAppBrandRuntime:getApkgInfo	()Lcom/tencent/mobileqq/mini/apkg/ApkgInfo;
    //   926: getfield 274	com/tencent/mobileqq/mini/apkg/ApkgInfo:appConfig	Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;
    //   929: invokestatic 280	com/tencent/mobileqq/mini/report/MiniReportManager:getAppType	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;)Ljava/lang/String;
    //   932: lconst_0
    //   933: aload 7
    //   935: invokestatic 99	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:getSecondLevelDomain	(Ljava/lang/String;)Ljava/lang/String;
    //   938: invokestatic 293	com/tencent/mobileqq/mini/report/MiniReportManager:reportEventType	(Lcom/tencent/mobileqq/mini/apkg/MiniAppConfig;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;)V
    //   941: goto -569 -> 372
    //   944: astore 7
    //   946: ldc 35
    //   948: iconst_2
    //   949: ldc_w 495
    //   952: aload 7
    //   954: invokestatic 298	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   957: goto -585 -> 372
    //   960: new 264	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask
    //   963: dup
    //   964: aload 9
    //   966: aload 8
    //   968: invokespecial 498	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask:<init>	(Lcom/tencent/mobileqq/mini/websocket/WebsocketRequestTask$RequestParam;Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$MiniAppWebsocketListener;)V
    //   971: astore 9
    //   973: aload_0
    //   974: getfield 78	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   977: aload 8
    //   979: getfield 501	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$MiniAppWebsocketListener:currSocketId	I
    //   982: aload 9
    //   984: invokevirtual 504	android/util/SparseArray:put	(ILjava/lang/Object;)V
    //   987: new 141	org/json/JSONObject
    //   990: dup
    //   991: aload_2
    //   992: invokespecial 330	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   995: astore 9
    //   997: aload 9
    //   999: ldc 237
    //   1001: aload 8
    //   1003: getfield 501	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin$MiniAppWebsocketListener:currSocketId	I
    //   1006: invokevirtual 241	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1009: pop
    //   1010: aload 9
    //   1012: ldc 130
    //   1014: new 113	java/lang/StringBuilder
    //   1017: dup
    //   1018: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1021: aload_1
    //   1022: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1025: ldc_w 506
    //   1028: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1031: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1034: invokevirtual 248	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1037: pop
    //   1038: aload_0
    //   1039: aload_3
    //   1040: aload 9
    //   1042: iload 4
    //   1044: aload_1
    //   1045: invokespecial 417	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   1048: aload 9
    //   1050: invokevirtual 142	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1053: astore 8
    //   1055: aload 7
    //   1057: monitorexit
    //   1058: aload 8
    //   1060: areturn
    //   1061: ldc 20
    //   1063: aload_1
    //   1064: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1067: ifeq +664 -> 1731
    //   1070: new 141	org/json/JSONObject
    //   1073: dup
    //   1074: aload_2
    //   1075: invokespecial 330	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1078: astore 7
    //   1080: aload 7
    //   1082: ldc_w 439
    //   1085: invokevirtual 442	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   1088: astore 8
    //   1090: aload 7
    //   1092: ldc 237
    //   1094: invokevirtual 437	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   1097: istore 5
    //   1099: ldc 245
    //   1101: aload 8
    //   1103: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1106: ifeq +198 -> 1304
    //   1109: aload_0
    //   1110: getfield 73	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:lock	[B
    //   1113: astore_2
    //   1114: aload_2
    //   1115: monitorenter
    //   1116: aload_0
    //   1117: getfield 78	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1120: ifnull +147 -> 1267
    //   1123: aload_0
    //   1124: getfield 78	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1127: invokevirtual 509	android/util/SparseArray:size	()I
    //   1130: ifeq +137 -> 1267
    //   1133: aload_0
    //   1134: getfield 78	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1137: iload 5
    //   1139: invokevirtual 262	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1142: checkcast 264	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask
    //   1145: astore 8
    //   1147: aload_0
    //   1148: getfield 78	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1151: iload 5
    //   1153: invokevirtual 512	android/util/SparseArray:remove	(I)V
    //   1156: aload 7
    //   1158: ldc 250
    //   1160: sipush 1000
    //   1163: invokevirtual 515	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   1166: istore 5
    //   1168: aload 7
    //   1170: ldc 252
    //   1172: ldc_w 517
    //   1175: invokevirtual 520	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1178: astore 7
    //   1180: aload 8
    //   1182: ifnull +12 -> 1194
    //   1185: aload 8
    //   1187: iload 5
    //   1189: aload 7
    //   1191: invokevirtual 523	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask:closeSocket	(ILjava/lang/String;)V
    //   1194: aload_0
    //   1195: getfield 415	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1198: ifeq +14 -> 1212
    //   1201: aload_0
    //   1202: aload_3
    //   1203: aconst_null
    //   1204: iload 4
    //   1206: ldc_w 524
    //   1209: invokespecial 417	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   1212: aload_1
    //   1213: aconst_null
    //   1214: invokestatic 421	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1217: invokevirtual 142	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1220: astore_3
    //   1221: aload_2
    //   1222: monitorexit
    //   1223: aload_3
    //   1224: areturn
    //   1225: astore_3
    //   1226: aload_2
    //   1227: monitorexit
    //   1228: aload_3
    //   1229: athrow
    //   1230: astore_2
    //   1231: ldc 35
    //   1233: iconst_1
    //   1234: new 113	java/lang/StringBuilder
    //   1237: dup
    //   1238: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1241: aload_1
    //   1242: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: ldc_w 423
    //   1248: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1251: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1254: aload_2
    //   1255: invokestatic 298	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1258: aload_1
    //   1259: aconst_null
    //   1260: invokestatic 429	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1263: invokevirtual 142	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1266: areturn
    //   1267: aload_0
    //   1268: getfield 415	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1271: ifeq +17 -> 1288
    //   1274: aload_0
    //   1275: aload_3
    //   1276: aconst_null
    //   1277: iload 4
    //   1279: ldc_w 524
    //   1282: ldc_w 526
    //   1285: invokespecial 375	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   1288: aload_1
    //   1289: aconst_null
    //   1290: ldc_w 526
    //   1293: invokestatic 382	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1296: invokevirtual 142	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1299: astore_3
    //   1300: aload_2
    //   1301: monitorexit
    //   1302: aload_3
    //   1303: areturn
    //   1304: ldc_w 528
    //   1307: aload 8
    //   1309: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1312: ifeq -940 -> 372
    //   1315: aload 7
    //   1317: ldc_w 530
    //   1320: aconst_null
    //   1321: invokevirtual 520	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1324: astore 8
    //   1326: aload 8
    //   1328: ifnull +200 -> 1528
    //   1331: aload_0
    //   1332: getfield 73	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:lock	[B
    //   1335: astore_2
    //   1336: aload_2
    //   1337: monitorenter
    //   1338: aload_0
    //   1339: getfield 78	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1342: ifnull +149 -> 1491
    //   1345: aload_0
    //   1346: getfield 78	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1349: invokevirtual 509	android/util/SparseArray:size	()I
    //   1352: ifeq +139 -> 1491
    //   1355: aload_0
    //   1356: getfield 78	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1359: iload 5
    //   1361: invokevirtual 262	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1364: checkcast 264	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask
    //   1367: astore 7
    //   1369: aload 7
    //   1371: ifnull +46 -> 1417
    //   1374: aload 7
    //   1376: aload 8
    //   1378: invokevirtual 533	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask:sendStringMessage	(Ljava/lang/String;)V
    //   1381: aload_0
    //   1382: getfield 415	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1385: ifeq +14 -> 1399
    //   1388: aload_0
    //   1389: aload_3
    //   1390: aconst_null
    //   1391: iload 4
    //   1393: ldc_w 535
    //   1396: invokespecial 417	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   1399: aload_1
    //   1400: aconst_null
    //   1401: invokestatic 421	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1404: invokevirtual 142	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1407: astore_3
    //   1408: aload_2
    //   1409: monitorexit
    //   1410: aload_3
    //   1411: areturn
    //   1412: astore_3
    //   1413: aload_2
    //   1414: monitorexit
    //   1415: aload_3
    //   1416: athrow
    //   1417: ldc 35
    //   1419: iconst_1
    //   1420: new 113	java/lang/StringBuilder
    //   1423: dup
    //   1424: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1427: aload_1
    //   1428: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: ldc_w 537
    //   1434: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1437: aload 8
    //   1439: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1442: ldc_w 539
    //   1445: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1448: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1451: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1454: aload_0
    //   1455: getfield 415	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1458: ifeq +17 -> 1475
    //   1461: aload_0
    //   1462: aload_3
    //   1463: aconst_null
    //   1464: iload 4
    //   1466: ldc_w 535
    //   1469: ldc_w 541
    //   1472: invokespecial 375	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   1475: aload_1
    //   1476: aconst_null
    //   1477: ldc_w 541
    //   1480: invokestatic 382	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1483: invokevirtual 142	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1486: astore_3
    //   1487: aload_2
    //   1488: monitorexit
    //   1489: aload_3
    //   1490: areturn
    //   1491: aload_0
    //   1492: getfield 415	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1495: ifeq +17 -> 1512
    //   1498: aload_0
    //   1499: aload_3
    //   1500: aconst_null
    //   1501: iload 4
    //   1503: ldc_w 535
    //   1506: ldc_w 526
    //   1509: invokespecial 375	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   1512: aload_1
    //   1513: aconst_null
    //   1514: ldc_w 526
    //   1517: invokestatic 382	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1520: invokevirtual 142	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1523: astore_3
    //   1524: aload_2
    //   1525: monitorexit
    //   1526: aload_3
    //   1527: areturn
    //   1528: aload 7
    //   1530: invokestatic 547	com/tencent/mobileqq/minigame/utils/NativeBuffer:hasNativeBuffer	(Lorg/json/JSONObject;)Z
    //   1533: ifeq -1161 -> 372
    //   1536: aload 7
    //   1538: ldc_w 530
    //   1541: aload_0
    //   1542: getfield 90	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:mTTEngine	Lcom/tencent/mobileqq/triton/sdk/ITTEngine;
    //   1545: invokeinterface 553 1 0
    //   1550: invokestatic 557	com/tencent/mobileqq/minigame/utils/NativeBuffer:unpackNativeBuffer	(Lorg/json/JSONObject;Ljava/lang/String;Lcom/tencent/mobileqq/triton/sdk/bridge/ITNativeBufferPool;)Lcom/tencent/mobileqq/minigame/utils/NativeBuffer;
    //   1553: astore_2
    //   1554: aload_2
    //   1555: ifnull +141 -> 1696
    //   1558: aload_2
    //   1559: getfield 560	com/tencent/mobileqq/minigame/utils/NativeBuffer:buf	[B
    //   1562: ifnull +134 -> 1696
    //   1565: aload_0
    //   1566: getfield 78	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1569: ifnull +127 -> 1696
    //   1572: aload_0
    //   1573: getfield 78	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1576: invokevirtual 509	android/util/SparseArray:size	()I
    //   1579: ifeq +117 -> 1696
    //   1582: aload_0
    //   1583: getfield 78	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:socketTaskList	Landroid/util/SparseArray;
    //   1586: iload 5
    //   1588: invokevirtual 262	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   1591: checkcast 264	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask
    //   1594: astore 7
    //   1596: aload 7
    //   1598: ifnull +39 -> 1637
    //   1601: aload 7
    //   1603: aload_2
    //   1604: getfield 560	com/tencent/mobileqq/minigame/utils/NativeBuffer:buf	[B
    //   1607: invokevirtual 564	com/tencent/mobileqq/mini/websocket/WebsocketRequestTask:sendBinaryMessage	([B)V
    //   1610: aload_0
    //   1611: getfield 415	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1614: ifeq +14 -> 1628
    //   1617: aload_0
    //   1618: aload_3
    //   1619: aconst_null
    //   1620: iload 4
    //   1622: ldc_w 535
    //   1625: invokespecial 417	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;)V
    //   1628: aload_1
    //   1629: aconst_null
    //   1630: invokestatic 421	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackOk	(Ljava/lang/String;Lorg/json/JSONObject;)Lorg/json/JSONObject;
    //   1633: invokevirtual 142	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1636: areturn
    //   1637: ldc 35
    //   1639: iconst_1
    //   1640: new 113	java/lang/StringBuilder
    //   1643: dup
    //   1644: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1647: aload_1
    //   1648: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1651: ldc_w 566
    //   1654: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1657: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1660: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1663: aload_0
    //   1664: getfield 415	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1667: ifeq +17 -> 1684
    //   1670: aload_0
    //   1671: aload_3
    //   1672: aconst_null
    //   1673: iload 4
    //   1675: ldc_w 535
    //   1678: ldc_w 541
    //   1681: invokespecial 375	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   1684: aload_1
    //   1685: aconst_null
    //   1686: ldc_w 541
    //   1689: invokestatic 382	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1692: invokevirtual 142	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1695: areturn
    //   1696: aload_0
    //   1697: getfield 415	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:isGameRuntime	Z
    //   1700: ifeq +17 -> 1717
    //   1703: aload_0
    //   1704: aload_3
    //   1705: aconst_null
    //   1706: iload 4
    //   1708: ldc_w 535
    //   1711: ldc_w 526
    //   1714: invokespecial 375	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:callbackFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Lorg/json/JSONObject;ILjava/lang/String;Ljava/lang/String;)V
    //   1717: aload_1
    //   1718: aconst_null
    //   1719: ldc_w 526
    //   1722: invokestatic 382	com/tencent/mobileqq/mini/util/ApiUtil:wrapCallbackFail	(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;)Lorg/json/JSONObject;
    //   1725: invokevirtual 142	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1728: astore_2
    //   1729: aload_2
    //   1730: areturn
    //   1731: ldc 38
    //   1733: aload_1
    //   1734: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1737: ifeq -1365 -> 372
    //   1740: aload_0
    //   1741: getfield 210	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1744: ifnonnull +6 -> 1750
    //   1747: ldc 128
    //   1749: areturn
    //   1750: aload_2
    //   1751: aload_3
    //   1752: aload_1
    //   1753: iload 4
    //   1755: aload_0
    //   1756: getfield 210	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/RequestPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   1759: invokestatic 572	com/tencent/mobileqq/mini/entry/MiniAppUtils:performWnsCgiRequest	(Ljava/lang/String;Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;ILcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;)V
    //   1762: goto -1390 -> 372
    //   1765: astore 7
    //   1767: ldc 35
    //   1769: iconst_1
    //   1770: new 113	java/lang/StringBuilder
    //   1773: dup
    //   1774: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   1777: aload_1
    //   1778: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1781: ldc_w 423
    //   1784: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1787: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1790: aload 7
    //   1792: invokestatic 298	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1795: goto -1423 -> 372
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1798	0	this	RequestPlugin
    //   0	1798	1	paramString1	String
    //   0	1798	3	paramJsRuntime	JsRuntime
    //   0	1798	4	paramInt	int
    //   461	1126	5	i	int
    //   80	619	6	bool	boolean
    //   69	253	7	localObject1	Object
    //   324	5	7	localObject2	Object
    //   331	26	7	localThrowable1	java.lang.Throwable
    //   408	5	7	str1	String
    //   415	6	7	localThrowable2	java.lang.Throwable
    //   451	63	7	localObject3	Object
    //   545	19	7	localException	Exception
    //   788	26	7	localThrowable3	java.lang.Throwable
    //   848	86	7	str2	String
    //   944	112	7	localThrowable4	java.lang.Throwable
    //   1078	524	7	localObject4	Object
    //   1765	26	7	localThrowable5	java.lang.Throwable
    //   109	560	8	localObject5	Object
    //   780	222	8	localMiniAppWebsocketListener	RequestPlugin.MiniAppWebsocketListener
    //   1053	385	8	localObject6	Object
    //   619	430	9	localObject7	Object
    //   686	61	10	str3	String
    // Exception table:
    //   from	to	target	type
    //   61	217	324	finally
    //   220	259	324	finally
    //   259	308	324	finally
    //   308	319	324	finally
    //   319	321	324	finally
    //   326	328	324	finally
    //   382	399	324	finally
    //   399	410	324	finally
    //   410	412	324	finally
    //   417	431	324	finally
    //   59	61	331	java/lang/Throwable
    //   328	331	331	java/lang/Throwable
    //   259	308	415	java/lang/Throwable
    //   308	319	415	java/lang/Throwable
    //   382	399	415	java/lang/Throwable
    //   399	410	415	java/lang/Throwable
    //   443	505	545	java/lang/Exception
    //   510	542	545	java/lang/Exception
    //   611	777	780	finally
    //   782	785	780	finally
    //   960	1058	780	finally
    //   602	611	788	java/lang/Throwable
    //   785	788	788	java/lang/Throwable
    //   830	941	944	java/lang/Throwable
    //   1116	1180	1225	finally
    //   1185	1194	1225	finally
    //   1194	1212	1225	finally
    //   1212	1223	1225	finally
    //   1226	1228	1225	finally
    //   1267	1288	1225	finally
    //   1288	1302	1225	finally
    //   1070	1116	1230	java/lang/Throwable
    //   1228	1230	1230	java/lang/Throwable
    //   1304	1326	1230	java/lang/Throwable
    //   1331	1338	1230	java/lang/Throwable
    //   1415	1417	1230	java/lang/Throwable
    //   1528	1554	1230	java/lang/Throwable
    //   1558	1596	1230	java/lang/Throwable
    //   1601	1628	1230	java/lang/Throwable
    //   1628	1637	1230	java/lang/Throwable
    //   1637	1684	1230	java/lang/Throwable
    //   1684	1696	1230	java/lang/Throwable
    //   1696	1717	1230	java/lang/Throwable
    //   1717	1729	1230	java/lang/Throwable
    //   1338	1369	1412	finally
    //   1374	1399	1412	finally
    //   1399	1410	1412	finally
    //   1413	1415	1412	finally
    //   1417	1475	1412	finally
    //   1475	1489	1412	finally
    //   1491	1512	1412	finally
    //   1512	1526	1412	finally
    //   1740	1747	1765	java/lang/Throwable
    //   1750	1762	1765	java/lang/Throwable
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RequestPlugin
 * JD-Core Version:    0.7.0.1
 */