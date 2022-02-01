package com.tencent.qqmini.sdk.plugins;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.core.utils.MiniappHttpUtil;
import com.tencent.qqmini.sdk.core.utils.NativeBuffer;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.EntryModel;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.NetworkTimeoutInfo;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC05115;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC05116;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.DomainUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class RequestJsPlugin
  extends BaseJsPlugin
{
  private static final int MAX_SUPPORT_SOCKET_CONNECTION_SIZE = 2;
  private static final String STATE_COMPLETE = "complete";
  private static final String STATE_FAIL = "fail";
  private static final String STATE_OK = "ok";
  private static final String TAG = "[mini] http.RequestJsPlugin";
  private static final String WNS_CGI_REQUEST = "wnsCgiRequest";
  private static final ArrayList<String> supportMethod = new ArrayList(Arrays.asList(new String[] { "OPTIONS", "GET", "HEAD", "POST", "PUT", "DELETE", "TRACE" }));
  private byte[] lock = new byte[0];
  private ConcurrentHashMap<Integer, RequestJsPlugin.RequestTask> requestMap = new ConcurrentHashMap();
  private boolean socketClosedCallbacked = false;
  private ConcurrentHashMap<Integer, RequestJsPlugin.WebsocketRequestTask> wsrequestMap = new ConcurrentHashMap();
  
  private void callback(RequestEvent paramRequestEvent, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    if (paramRequestEvent != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramString3 == null) {
        break label107;
      }
      paramString3 = localStringBuilder.append(paramString3).append(":").append(paramString1);
      if (!TextUtils.isEmpty(paramString2)) {
        break label116;
      }
    }
    label107:
    label116:
    for (paramString2 = "";; paramString2 = " " + paramString2)
    {
      paramJSONObject = JSONUtil.append(paramJSONObject, "errMsg", paramString2).toString();
      paramRequestEvent.evaluateCallbackJs(paramJSONObject);
      if (!"fail".equals(paramString1)) {
        break label141;
      }
      QMLog.e("[mini] http.RequestJsPlugin", "[callbackFail] " + paramJSONObject);
      return;
      paramString3 = paramRequestEvent.event;
      break;
    }
    label141:
    QMLog.i("[mini] http.RequestJsPlugin", "[callback] " + paramJSONObject);
  }
  
  private void callbackComplete(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    callback(paramRequestEvent, paramJSONObject, "complete", null, null);
  }
  
  private void callbackFail(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    callback(paramRequestEvent, paramJSONObject, "fail", null, null);
  }
  
  private void callbackFail(RequestEvent paramRequestEvent, JSONObject paramJSONObject, String paramString)
  {
    callback(paramRequestEvent, paramJSONObject, "fail", paramString, null);
  }
  
  private void callbackFail(RequestEvent paramRequestEvent, JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    callback(paramRequestEvent, paramJSONObject, "fail", paramString1, null);
  }
  
  private void callbackOK(RequestEvent paramRequestEvent, JSONObject paramJSONObject)
  {
    callback(paramRequestEvent, paramJSONObject, "ok", null, null);
  }
  
  private void callbackOK(RequestEvent paramRequestEvent, JSONObject paramJSONObject, String paramString)
  {
    callback(paramRequestEvent, paramJSONObject, "ok", null, paramString);
  }
  
  private void connectSocket(RequestEvent paramRequestEvent, WebSocketProxy paramWebSocketProxy, int paramInt, RequestJsPlugin.WebsocketRequestTask paramWebsocketRequestTask)
  {
    paramWebSocketProxy.connectSocket(paramWebsocketRequestTask.mTaskId, paramWebsocketRequestTask.mUrl, paramWebsocketRequestTask.mHeaders, paramWebsocketRequestTask.mMethod, paramInt, new RequestJsPlugin.2(this, paramRequestEvent, paramWebsocketRequestTask));
  }
  
  private boolean doRequest(RequestEvent paramRequestEvent, RequestJsPlugin.RequestTask paramRequestTask, String paramString, RequestProxy paramRequestProxy)
  {
    return paramRequestProxy.request(paramRequestTask.mUrl, paramRequestTask.mBody, paramRequestTask.mHeaders, paramRequestTask.mMethod, 60, new RequestJsPlugin.1(this, paramString, paramRequestTask, paramRequestEvent));
  }
  
  private boolean doWnsCgiRequest(RequestEvent paramRequestEvent)
  {
    String str = paramRequestEvent.jsonParams.replace("{groupId}", String.valueOf(this.mMiniAppInfo.launchParam.entryModel.uin));
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if (localChannelProxy != null)
    {
      localChannelProxy.wnsCgiRequest(new JSONObject(str), new RequestJsPlugin.5(this, paramRequestEvent));
      return false;
    }
    callbackFail(paramRequestEvent, null, "do not support wnsGroupRequest");
    return true;
  }
  
  private String getRequestReferer()
  {
    String str2 = "";
    String str1 = "debug";
    Object localObject = this.mMiniAppInfo;
    if (localObject != null)
    {
      str2 = ((MiniAppInfo)localObject).appId;
      str1 = ((MiniAppInfo)localObject).version;
    }
    localObject = str1;
    if (!MiniappHttpUtil.isRefererVersionValid(str1)) {
      localObject = "invalidVersion";
    }
    return "https://appservice.qq.com/" + str2 + "/" + (String)localObject + "/page-frame.html";
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
  
  private static void mergeHeaders(Map<String, String> paramMap, JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("header"))
    {
      paramJSONObject = paramJSONObject.optJSONObject("header");
      if (paramJSONObject != null) {
        paramMap.putAll(JSONUtil.toMap(paramJSONObject));
      }
    }
  }
  
  private void onCloseCallback(RequestEvent paramRequestEvent, int paramInt1, String paramString, int paramInt2)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("socketTaskId", paramInt2);
      ((JSONObject)localObject).put("state", "close");
      ((JSONObject)localObject).put("code", paramInt1);
      ((JSONObject)localObject).put("reason", paramString);
      paramRequestEvent.jsService.evaluateSubscribeJS("onSocketTaskStateChange", ((JSONObject)localObject).toString(), 0);
      paramRequestEvent = (RequestJsPlugin.WebsocketRequestTask)this.wsrequestMap.get(Integer.valueOf(paramInt2));
      paramString = this.mMiniAppInfo;
      localObject = MiniReportManager.getAppType(this.mMiniAppInfo);
      if (paramRequestEvent != null) {}
      for (paramRequestEvent = paramRequestEvent.mUrl;; paramRequestEvent = null)
      {
        MiniReportManager.reportEventType(paramString, 633, null, null, null, 0, (String)localObject, 0L, getSecondLevelDomain(paramRequestEvent));
        return;
      }
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      QMLog.e("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onClose exception:", paramRequestEvent);
    }
  }
  
  private void onConnectSocketError(int paramInt, String paramString, RequestJsPlugin.WebsocketRequestTask paramWebsocketRequestTask, RequestEvent paramRequestEvent)
  {
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    for (;;)
    {
      try
      {
        if ((((String)localObject).equals("SSL handshake timed out")) || (((String)localObject).equals("timeout")))
        {
          QMLog.e("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onFailure , timeout , send close state. socketId=" + paramWebsocketRequestTask.mTaskId);
          paramString = new JSONObject();
          paramString.put("socketTaskId", paramWebsocketRequestTask.mTaskId);
          paramString.put("state", "close");
          paramString.put("statusCode", paramInt);
          paramRequestEvent.jsService.evaluateSubscribeJS("onSocketTaskStateChange", paramString.toString(), 0);
          MiniReportManager.reportEventType(this.mMiniAppInfo, 634, null, null, null, 0, MiniReportManager.getAppType(this.mMiniAppInfo), 0L, getSecondLevelDomain(paramWebsocketRequestTask.mUrl));
          return;
        }
        localObject = new JSONObject();
        ((JSONObject)localObject).put("socketTaskId", paramWebsocketRequestTask.mTaskId);
        ((JSONObject)localObject).put("state", "error");
        paramString = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((paramString == null) || (!paramString.isConnected()))
        {
          paramString = "network is down";
          ((JSONObject)localObject).put("errMsg", "network is down");
          QMLog.e("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onFailure socketId=" + paramWebsocketRequestTask.mTaskId + " errMsg=" + paramString);
          paramRequestEvent.jsService.evaluateSubscribeJS("onSocketTaskStateChange", ((JSONObject)localObject).toString(), 0);
        }
        else
        {
          paramString = "resposeCode=" + paramInt;
        }
      }
      catch (JSONException paramString)
      {
        QMLog.e("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onFailure exception:", paramString);
        return;
      }
    }
  }
  
  private void onRequestSucceed(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap, String paramString, RequestJsPlugin.RequestTask paramRequestTask, RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject1.put("url", paramString);
        if (paramInt <= 0) {
          return;
        }
        localJSONObject2.put("requestTaskId", paramRequestTask.mTaskId);
        if (paramMap != null) {
          localJSONObject2.put("header", JSONUtil.headerToJson(paramMap));
        }
        localJSONObject2.put("statusCode", paramInt);
        localJSONObject2.put("state", "success");
        localJSONObject2.put("errMsg", "ok");
        if (paramArrayOfByte != null)
        {
          if (!"arraybuffer".equals(paramRequestTask.mResponseType)) {
            continue;
          }
          if (!this.mIsMiniGame) {
            continue;
          }
          NativeBuffer.packNativeBuffer(paramRequestEvent.jsService, paramArrayOfByte, NativeBuffer.TYPE_BUFFER_NATIVE, "data", localJSONObject2);
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        try
        {
          paramMap = new JSONObject();
          paramMap.put("state", "fail");
          paramMap.put("statusCode", "-1");
          paramMap.put("requestTaskId", paramRequestTask.mTaskId);
          paramMap.put("errMsg", "exception：" + paramArrayOfByte.getMessage());
          paramRequestEvent.jsService.evaluateSubscribeJS("onRequestTaskStateChange", paramMap.toString(), 0);
          QMLog.e("[mini] http.RequestJsPlugin", "httpCallBack exception:", paramArrayOfByte);
          return;
          if (!"text".equals(paramRequestTask.mResponseType)) {
            continue;
          }
          if ((paramArrayOfByte.length <= 3) || ((paramArrayOfByte[0] & 0xFF) != 239) || ((paramArrayOfByte[1] & 0xFF) != 187) || ((paramArrayOfByte[2] & 0xFF) != 191)) {
            continue;
          }
          paramArrayOfByte = new String(paramArrayOfByte, 3, paramArrayOfByte.length - 3, "UTF-8");
          localJSONObject2.put("data", paramArrayOfByte);
          continue;
          paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
          continue;
          QMLog.e("[mini] http.RequestJsPlugin", "url: " + paramRequestTask.mUrl + "--mResponseType error ---" + paramRequestTask.mResponseType);
          paramArrayOfByte = new JSONObject();
          paramArrayOfByte.put("state", "fail");
          paramArrayOfByte.put("statusCode", -1);
          paramArrayOfByte.put("requestTaskId", paramRequestTask.mTaskId);
          paramRequestEvent.jsService.evaluateSubscribeJS("onRequestTaskStateChange", paramArrayOfByte.toString(), 0);
          return;
        }
        catch (Throwable paramMap)
        {
          continue;
        }
      }
      localJSONObject1.put("res", localJSONObject2);
      paramRequestEvent.jsService.evaluateSubscribeJS("onRequestTaskStateChange", localJSONObject2.toString(), 0);
      return;
      NativeBuffer.packNativeBuffer(paramRequestEvent.jsService, paramArrayOfByte, NativeBuffer.TYPE_BUFFER_BASE64, "data", localJSONObject2);
    }
  }
  
  private String operateSocketClose(RequestEvent paramRequestEvent, JSONObject paramJSONObject, int paramInt)
  {
    synchronized (this.lock)
    {
      if ((this.wsrequestMap != null) && (this.wsrequestMap.size() != 0))
      {
        RequestJsPlugin.WebsocketRequestTask localWebsocketRequestTask = (RequestJsPlugin.WebsocketRequestTask)this.wsrequestMap.get(Integer.valueOf(paramInt));
        this.wsrequestMap.remove(Integer.valueOf(paramInt));
        int i = paramJSONObject.optInt("code", 1000);
        paramJSONObject = paramJSONObject.optString("reason", "Goodbye");
        WebSocketProxy localWebSocketProxy = (WebSocketProxy)ProxyManager.get(WebSocketProxy.class);
        if ((localWebSocketProxy != null) && (localWebsocketRequestTask != null)) {
          localWebSocketProxy.closeSocket(paramInt, i, paramJSONObject);
        }
        if (this.mIsMiniGame) {
          callbackOK(paramRequestEvent, null, "closeSocket");
        }
        paramRequestEvent = ApiUtil.wrapCallbackOk(paramRequestEvent.event, null).toString();
        return paramRequestEvent;
      }
      if (this.mIsMiniGame) {
        callbackFail(paramRequestEvent, null, "do not have this socket ", "closeSocket");
      }
      paramRequestEvent = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "do not have this socket ").toString();
      return paramRequestEvent;
    }
  }
  
  @NotNull
  private String operateSocketSend(RequestEvent paramRequestEvent, int paramInt, String paramString)
  {
    synchronized (this.lock)
    {
      if ((this.wsrequestMap != null) && (this.wsrequestMap.size() != 0))
      {
        RequestJsPlugin.WebsocketRequestTask localWebsocketRequestTask = (RequestJsPlugin.WebsocketRequestTask)this.wsrequestMap.get(Integer.valueOf(paramInt));
        WebSocketProxy localWebSocketProxy = (WebSocketProxy)ProxyManager.get(WebSocketProxy.class);
        if ((localWebsocketRequestTask != null) && (localWebSocketProxy != null))
        {
          localWebSocketProxy.send(paramInt, paramString);
          if (this.mIsMiniGame) {
            callbackOK(paramRequestEvent, null, "sendSocketMessage");
          }
          paramRequestEvent = ApiUtil.wrapCallbackOk(paramRequestEvent.event, null).toString();
          return paramRequestEvent;
        }
        QMLog.e("[mini] http.RequestJsPlugin", paramRequestEvent.event + " error, send msg:" + paramString + " on null socket instance");
        if (this.mIsMiniGame) {
          callbackFail(paramRequestEvent, null, "socket is null ", "sendSocketMessage");
        }
        paramRequestEvent = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "socket is null ").toString();
        return paramRequestEvent;
      }
    }
    if (this.mIsMiniGame) {
      callbackFail(paramRequestEvent, null, "do not have this socket ", "closeSocket");
    }
    paramRequestEvent = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "do not have this socket ").toString();
    return paramRequestEvent;
  }
  
  private String operateSocketSend(RequestEvent paramRequestEvent, JSONObject paramJSONObject, int paramInt)
  {
    String str1 = null;
    String str2 = paramJSONObject.optString("data", null);
    if (str2 != null) {
      str1 = operateSocketSend(paramRequestEvent, paramInt, str2);
    }
    while (!NativeBuffer.hasNativeBuffer(paramJSONObject)) {
      return str1;
    }
    return operateSocketSendWithNativeBuffer(paramRequestEvent, paramJSONObject, paramInt);
  }
  
  @NotNull
  private String operateSocketSendWithNativeBuffer(RequestEvent paramRequestEvent, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = NativeBuffer.unpackNativeBuffer(paramRequestEvent.jsService, paramJSONObject, "data");
    if ((paramJSONObject != null) && (paramJSONObject.buf != null) && (this.wsrequestMap != null) && (this.wsrequestMap.size() != 0))
    {
      RequestJsPlugin.WebsocketRequestTask localWebsocketRequestTask = (RequestJsPlugin.WebsocketRequestTask)this.wsrequestMap.get(Integer.valueOf(paramInt));
      WebSocketProxy localWebSocketProxy = (WebSocketProxy)ProxyManager.get(WebSocketProxy.class);
      if ((localWebsocketRequestTask != null) && (localWebSocketProxy != null))
      {
        localWebSocketProxy.send(paramInt, paramJSONObject.buf);
        if (this.mIsMiniGame) {
          callbackOK(paramRequestEvent, null);
        }
        return ApiUtil.wrapCallbackOk(paramRequestEvent.event, null).toString();
      }
      QMLog.e("[mini] http.RequestJsPlugin", paramRequestEvent.event + " error, send NativeBuffer on null socket instance");
      if (this.mIsMiniGame) {
        callbackFail(paramRequestEvent, null, "socket is null ", "sendSocketMessage");
      }
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "socket is null ").toString();
    }
    if (this.mIsMiniGame) {
      callbackFail(paramRequestEvent, null, "do not have this socket ", "closeSocket");
    }
    return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "do not have this socket ").toString();
  }
  
  private void reportRequestResult(int paramInt1, RequestJsPlugin.RequestTask paramRequestTask1, RequestJsPlugin.RequestTask paramRequestTask2, RequestEvent paramRequestEvent, String paramString1, int paramInt2, String paramString2)
  {
    long l;
    if (paramRequestTask1 != null)
    {
      l = SystemClock.elapsedRealtime() - paramRequestTask1.mRequestCreatedMillis;
      QMLog.i("[mini] http.RequestJsPlugin", "[request httpCallBack][minigame timecost=" + l + "ms],[code=" + paramInt1 + "][url=" + paramRequestTask2.mUrl + "][callbackId=" + paramRequestEvent.callbackId + "][params=" + paramRequestEvent.jsonParams + "]");
      paramRequestTask2 = getSecondLevelDomain(paramRequestTask1.mOriginUrl);
      QMLog.d("[mini] http.RequestJsPlugin", "httpCallBack second level domain " + paramRequestTask2);
      if (!this.mIsMiniGame) {
        break label193;
      }
    }
    label193:
    for (paramRequestTask1 = "1";; paramRequestTask1 = "0")
    {
      MiniReportManager.reportEventType(this.mMiniAppInfo, 628, null, null, null, paramInt1, paramRequestTask1, l, paramRequestTask2, paramString2, null, null, null);
      MiniProgramLpReportDC05115.reportHttpRequestResult(this.mMiniAppInfo, paramInt1, paramInt2, l);
      MiniProgramLpReportDC05116.reportOneHttpOrDownloadRequest(this.mMiniAppInfo, paramString1, paramInt2, l, paramInt1);
      return;
    }
  }
  
  @JsEvent({"addGroupApp"})
  public String addGroupApp(RequestEvent paramRequestEvent)
  {
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if (localChannelProxy != null)
    {
      localChannelProxy.addGroupApp(this.mMiniAppContext, new RequestJsPlugin.7(this, paramRequestEvent));
      return "";
    }
    callbackFail(paramRequestEvent, null, "do not support addGroupApp");
    return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "do not support addGroupApp").toString();
  }
  
  @JsEvent({"createRequestTask"})
  public String createRequestTask(RequestEvent paramRequestEvent)
  {
    boolean bool;
    String str2;
    try
    {
      try
      {
        Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
        ((RequestStrategyProxy)ProxyManager.get(RequestStrategyProxy.class)).addHttpForwardingInfo((JSONObject)localObject1);
        bool = ((JSONObject)localObject1).optBoolean("__skipDomainCheck__", false);
        localObject1 = new RequestJsPlugin.RequestTask(this, paramRequestEvent.jsService, (JSONObject)localObject1);
        str2 = ((RequestJsPlugin.RequestTask)localObject1).mOriginUrl;
        if ((((RequestJsPlugin.RequestTask)localObject1).mMethod != null) && (!supportMethod.contains(((RequestJsPlugin.RequestTask)localObject1).mMethod.toUpperCase())))
        {
          if (!this.mIsMiniGame) {
            callbackFail(paramRequestEvent, null, "request protocol error");
          }
          localObject1 = ApiUtil.wrapCallbackFail("createRequest", null, "request protocol error").toString();
          return localObject1;
        }
        if ((!TextUtils.isEmpty(str2)) && ((str2.startsWith("https://")) || (str2.startsWith("http://")))) {
          break label226;
        }
        if (!this.mIsMiniGame) {
          callbackFail(paramRequestEvent, null, "url is invalid");
        }
        localObject1 = ApiUtil.wrapCallbackFail("createRequest", null, "url is invalid").toString();
        return localObject1;
      }
      finally {}
      return "";
    }
    catch (Throwable localThrowable1)
    {
      QMLog.e("[mini] http.RequestJsPlugin", paramRequestEvent.event + " exception:", localThrowable1);
      callbackFail(paramRequestEvent, null, "createRequest");
    }
    for (;;)
    {
      label226:
      String str1;
      if (!DomainUtil.isDomainValid(this.mMiniAppInfo, bool, str2, 0))
      {
        QMLog.w("[mini] http.RequestJsPlugin", "check request DomainValid fail, callbackFail, event:" + paramRequestEvent.event + ", callbackId:" + paramRequestEvent.callbackId + ", url:" + str2);
        if (!this.mIsMiniGame) {
          callbackFail(paramRequestEvent, null, "url not in domain list, 请求域名不合法");
        }
        str1 = ApiUtil.wrapCallbackFail("createRequest", null, "url not in domain list, 请求域名不合法").toString();
        return str1;
      }
      this.requestMap.put(Integer.valueOf(str1.mTaskId), str1);
      try
      {
        JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
        localJSONObject.put("requestTaskId", str1.mTaskId);
        if (this.requestMap.size() > 200)
        {
          QMLog.d("[mini] http.RequestJsPlugin", "[httpRequest] too much request");
          if (!this.mIsMiniGame) {
            callbackFail(paramRequestEvent, localJSONObject);
          }
          str1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject).toString();
          return str1;
        }
        RequestProxy localRequestProxy = (RequestProxy)ProxyManager.get(RequestProxy.class);
        if (localRequestProxy == null)
        {
          QMLog.d("[mini] http.RequestJsPlugin", "[httpRequest] too much request");
          if (!this.mIsMiniGame) {
            callbackFail(paramRequestEvent, localJSONObject);
          }
          str1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject).toString();
          return str1;
        }
        if (doRequest(paramRequestEvent, str1, str2, localRequestProxy))
        {
          if (!this.mIsMiniGame) {
            callbackOK(paramRequestEvent, localJSONObject);
          }
          str1 = ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject).toString();
          return str1;
        }
      }
      catch (Throwable localThrowable2)
      {
        QMLog.e("[mini] http.RequestJsPlugin", "", localThrowable2);
      }
    }
  }
  
  @JsEvent({"createSocketTask"})
  public String createSocketTask(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject2;
      int j;
      synchronized (this.lock)
      {
        WebSocketProxy localWebSocketProxy1 = (WebSocketProxy)ProxyManager.get(WebSocketProxy.class);
        if (localWebSocketProxy1 == null)
        {
          QMLog.w("[mini] http.RequestJsPlugin", "not support web socket right now");
          callbackFail(paramRequestEvent, null, "not support web socket right now");
          return "";
        }
        localObject2 = new JSONObject(paramRequestEvent.jsonParams);
        ((RequestStrategyProxy)ProxyManager.get(RequestStrategyProxy.class)).addHttpForwardingInfo((JSONObject)localObject2);
        boolean bool = ((JSONObject)localObject2).optBoolean("__skipDomainCheck__", false);
        j = this.mApkgInfo.getAppConfigInfo().networkTimeoutInfo.connectSocket;
        localObject2 = new RequestJsPlugin.WebsocketRequestTask(this, (JSONObject)localObject2);
        if (!DomainUtil.isDomainValid(this.mMiniAppInfo, bool, ((RequestJsPlugin.WebsocketRequestTask)localObject2).mOriginUrl, 1))
        {
          QMLog.w("[mini] http.RequestJsPlugin", "check socket DomainValid fail, callbackFail, event:" + paramRequestEvent.event + ", callbackId:" + paramRequestEvent.callbackId + ", url:" + ((RequestJsPlugin.WebsocketRequestTask)localObject2).mUrl);
          callbackFail(paramRequestEvent, null, "请求域名不合法");
          return "";
        }
      }
      try
      {
        paramRequestEvent = new RequestJsPlugin.WebsocketRequestTask(this, new JSONObject(paramRequestEvent.jsonParams)).mUrl;
        MiniReportManager.reportEventType(this.mMiniAppInfo, 632, null, null, null, 1, MiniReportManager.getAppType(this.mMiniAppInfo), 0L, getSecondLevelDomain(paramRequestEvent));
        return "";
        int i = j;
        if (((RequestJsPlugin.WebsocketRequestTask)localObject2).mTimeout > j) {
          i = ((RequestJsPlugin.WebsocketRequestTask)localObject2).mTimeout;
        }
        connectSocket(paramRequestEvent, localWebSocketProxy2, i, (RequestJsPlugin.WebsocketRequestTask)localObject2);
        this.wsrequestMap.put(Integer.valueOf(((RequestJsPlugin.WebsocketRequestTask)localObject2).mTaskId), localObject2);
        Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
        ((JSONObject)localObject1).put("socketTaskId", ((RequestJsPlugin.WebsocketRequestTask)localObject2).mTaskId);
        ((JSONObject)localObject1).put("errMsg", paramRequestEvent.event + ":ok");
        callbackOK(paramRequestEvent, (JSONObject)localObject1);
        localObject1 = ((JSONObject)localObject1).toString();
        return localObject1;
      }
      catch (JSONException paramRequestEvent)
      {
        for (;;)
        {
          QMLog.e("[mini] http.RequestJsPlugin", "handleNativeRequest ", paramRequestEvent);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("[mini] http.RequestJsPlugin", paramRequestEvent.event + " exception:", localThrowable);
      callbackFail(paramRequestEvent, null);
    }
  }
  
  @JsEvent({"getGroupAppStatus"})
  public String getGroupAppStatus(RequestEvent paramRequestEvent)
  {
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if (localChannelProxy != null)
    {
      localChannelProxy.getGroupAppStatus(this.mMiniAppContext, paramRequestEvent.jsonParams, new RequestJsPlugin.6(this, paramRequestEvent));
      return "";
    }
    callbackFail(paramRequestEvent, null, "do not support wnsGroupRequest");
    return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "do not support getGroupAppStatus").toString();
  }
  
  @JsEvent({"operateRequestTask"})
  public String operateRequestTask(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      int i = ((JSONObject)localObject).optInt("requestTaskId");
      localObject = ((JSONObject)localObject).optString("operationType");
      if (this.requestMap.containsKey(Integer.valueOf(i)))
      {
        RequestJsPlugin.RequestTask localRequestTask = (RequestJsPlugin.RequestTask)this.requestMap.remove(Integer.valueOf(i));
        if ((localRequestTask != null) && ("abort".equals(localObject)))
        {
          ((RequestProxy)ProxyManager.get(RequestProxy.class)).abort(localRequestTask.mUrl);
          if (!this.mIsMiniGame) {
            callbackOK(paramRequestEvent, null);
          }
        }
      }
    }
    catch (Exception paramRequestEvent)
    {
      for (;;)
      {
        paramRequestEvent.printStackTrace();
        QMLog.e("[mini] http.RequestJsPlugin", "OPERATE_REQUEST_TASK : " + paramRequestEvent);
      }
    }
    return "";
  }
  
  @JsEvent({"operateSocketTask"})
  public String operateSocketTask(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      String str2 = ((JSONObject)localObject).optString("operationType");
      int i = ((JSONObject)localObject).optInt("socketTaskId");
      if ("close".equals(str2)) {
        return operateSocketClose(paramRequestEvent, (JSONObject)localObject, i);
      }
      if ("send".equals(str2))
      {
        localObject = operateSocketSend(paramRequestEvent, (JSONObject)localObject, i);
        paramRequestEvent = (RequestEvent)localObject;
        localObject = paramRequestEvent;
        if (paramRequestEvent != null) {}
      }
      else
      {
        return "";
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("[mini] http.RequestJsPlugin", paramRequestEvent.event + " exception:", localThrowable);
      String str1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
      return str1;
    }
  }
  
  @JsEvent({"wnsCgiRequest"})
  public String wnsCgiRequest(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject2 = new JSONObject(paramRequestEvent.jsonParams);
      JSONObject localJSONObject1 = localJSONObject2.optJSONObject("header");
      Object localObject = localJSONObject1;
      if (localJSONObject1 == null) {
        localObject = new JSONObject();
      }
      ((JSONObject)localObject).put("Referer", getRequestReferer());
      localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (localObject != null)
      {
        ((ChannelProxy)localObject).wnsCgiRequest(localJSONObject2, new RequestJsPlugin.4(this, paramRequestEvent));
        return "";
      }
      callbackFail(paramRequestEvent, null, "do not support wnsCgiRequest");
      localObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "do not support wnsCgiRequest").toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("[mini] http.RequestJsPlugin", paramRequestEvent.event + " exception:", localThrowable);
    }
    return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
  }
  
  @JsEvent({"wnsGroupRequest"})
  public String wnsGroupRequest(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).optString("entryDataHash");
      if ((this.mMiniAppInfo != null) && (this.mMiniAppInfo.launchParam != null) && (this.mMiniAppInfo.launchParam.entryModel != null) && (str != null))
      {
        if ((!str.equals(this.mMiniAppInfo.launchParam.entryModel.getEntryHash())) || (!this.mMiniAppInfo.launchParam.entryModel.isAdmin)) {
          break label135;
        }
        if (paramRequestEvent.jsonParams.contains("{groupId}"))
        {
          if (doWnsCgiRequest(paramRequestEvent)) {
            return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "do not support wnsGroupRequest").toString();
          }
        }
        else {
          paramRequestEvent.fail("groupId is null");
        }
      }
      for (;;)
      {
        return "";
        label135:
        paramRequestEvent.fail("entryDataHash is not vaild or you are not group administrator");
      }
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("[mini] http.RequestJsPlugin", paramRequestEvent.event + " exception:", localThrowable);
    }
  }
  
  @JsEvent({"wnsRequest"})
  public String wnsRequest(RequestEvent paramRequestEvent)
  {
    ThreadManager.getSubThreadHandler().post(new RequestJsPlugin.3(this, paramRequestEvent));
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RequestJsPlugin
 * JD-Core Version:    0.7.0.1
 */