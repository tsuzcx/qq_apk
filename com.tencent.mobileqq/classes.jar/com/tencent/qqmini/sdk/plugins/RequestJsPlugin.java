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
        paramString3 = paramRequestEvent.event;
      }
      localStringBuilder.append(paramString3);
      localStringBuilder.append(":");
      localStringBuilder.append(paramString1);
      if (TextUtils.isEmpty(paramString2))
      {
        paramString2 = "";
      }
      else
      {
        paramString3 = new StringBuilder();
        paramString3.append(" ");
        paramString3.append(paramString2);
        paramString2 = paramString3.toString();
      }
      localStringBuilder.append(paramString2);
      paramJSONObject = JSONUtil.append(paramJSONObject, "errMsg", localStringBuilder.toString()).toString();
      paramRequestEvent.evaluateCallbackJs(paramJSONObject);
      if ("fail".equals(paramString1))
      {
        paramRequestEvent = new StringBuilder();
        paramRequestEvent.append("[callbackFail] ");
        paramRequestEvent.append(paramJSONObject);
        QMLog.e("[mini] http.RequestJsPlugin", paramRequestEvent.toString());
        return;
      }
      paramRequestEvent = new StringBuilder();
      paramRequestEvent.append("[callback] ");
      paramRequestEvent.append(paramJSONObject);
      QMLog.i("[mini] http.RequestJsPlugin", paramRequestEvent.toString());
    }
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
    Object localObject1 = this.mMiniAppInfo;
    String str;
    if (localObject1 != null)
    {
      str = ((MiniAppInfo)localObject1).appId;
      localObject1 = ((MiniAppInfo)localObject1).version;
    }
    else
    {
      str = "";
      localObject1 = "debug";
    }
    Object localObject2 = localObject1;
    if (!MiniappHttpUtil.isRefererVersionValid((String)localObject1)) {
      localObject2 = "invalidVersion";
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("https://appservice.qq.com/");
    ((StringBuilder)localObject1).append(str);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("/page-frame.html");
    return ((StringBuilder)localObject1).toString();
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
    for (;;)
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
        if (paramRequestEvent != null)
        {
          paramRequestEvent = paramRequestEvent.mUrl;
          MiniReportManager.reportEventType(paramString, 633, null, null, null, 0, (String)localObject, 0L, getSecondLevelDomain(paramRequestEvent));
          return;
        }
      }
      catch (JSONException paramRequestEvent)
      {
        QMLog.e("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onClose exception:", paramRequestEvent);
        return;
      }
      paramRequestEvent = null;
    }
  }
  
  private void onConnectSocketError(int paramInt, String paramString, RequestJsPlugin.WebsocketRequestTask paramWebsocketRequestTask, RequestEvent paramRequestEvent)
  {
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      try
      {
        boolean bool = paramString.equals("SSL handshake timed out");
        if ((!bool) && (!paramString.equals("timeout")))
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("socketTaskId", paramWebsocketRequestTask.mTaskId);
          localJSONObject.put("state", "error");
          paramString = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
          if ((paramString != null) && (paramString.isConnected()))
          {
            paramString = new StringBuilder();
            paramString.append("resposeCode=");
            paramString.append(paramInt);
            paramString = paramString.toString();
          }
          else
          {
            paramString = "network is down";
            localJSONObject.put("errMsg", "network is down");
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("MiniAppWebsocketListener onFailure socketId=");
          localStringBuilder.append(paramWebsocketRequestTask.mTaskId);
          localStringBuilder.append(" errMsg=");
          localStringBuilder.append(paramString);
          QMLog.e("[mini] http.RequestJsPlugin", localStringBuilder.toString());
          paramRequestEvent.jsService.evaluateSubscribeJS("onSocketTaskStateChange", localJSONObject.toString(), 0);
        }
        else
        {
          paramString = new StringBuilder();
          paramString.append("MiniAppWebsocketListener onFailure , timeout , send close state. socketId=");
          paramString.append(paramWebsocketRequestTask.mTaskId);
          QMLog.e("[mini] http.RequestJsPlugin", paramString.toString());
          paramString = new JSONObject();
          paramString.put("socketTaskId", paramWebsocketRequestTask.mTaskId);
          paramString.put("state", "close");
          paramString.put("statusCode", paramInt);
          paramRequestEvent.jsService.evaluateSubscribeJS("onSocketTaskStateChange", paramString.toString(), 0);
        }
        MiniReportManager.reportEventType(this.mMiniAppInfo, 634, null, null, null, 0, MiniReportManager.getAppType(this.mMiniAppInfo), 0L, getSecondLevelDomain(paramWebsocketRequestTask.mUrl));
        return;
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
    label521:
    label535:
    for (;;)
    {
      try
      {
        localJSONObject1.put("url", paramString);
        if (paramInt > 0)
        {
          localJSONObject2.put("requestTaskId", paramRequestTask.mTaskId);
          if (paramMap != null) {
            localJSONObject2.put("header", JSONUtil.headerToJson(paramMap));
          }
          localJSONObject2.put("statusCode", paramInt);
          localJSONObject2.put("state", "success");
          localJSONObject2.put("errMsg", "ok");
          if (paramArrayOfByte == null) {
            break label535;
          }
          boolean bool = "arraybuffer".equals(paramRequestTask.mResponseType);
          if (bool)
          {
            if (this.mIsMiniGame)
            {
              NativeBuffer.packNativeBuffer(paramRequestEvent.jsService, paramArrayOfByte, NativeBuffer.TYPE_BUFFER_NATIVE, "data", localJSONObject2);
              break label535;
            }
            NativeBuffer.packNativeBuffer(paramRequestEvent.jsService, paramArrayOfByte, NativeBuffer.TYPE_BUFFER_BASE64, "data", localJSONObject2);
            break label535;
          }
          if ("text".equals(paramRequestTask.mResponseType))
          {
            paramInt = paramArrayOfByte.length;
            if ((paramInt > 3) && ((paramArrayOfByte[0] & 0xFF) == 239) && ((paramArrayOfByte[1] & 0xFF) == 187) && ((paramArrayOfByte[2] & 0xFF) == 191)) {
              paramInt = paramArrayOfByte.length;
            }
          }
          try
          {
            paramArrayOfByte = new String(paramArrayOfByte, 3, paramInt - 3, "UTF-8");
            continue;
            paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
            localJSONObject2.put("data", paramArrayOfByte);
            continue;
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("url: ");
            paramArrayOfByte.append(paramRequestTask.mUrl);
            paramArrayOfByte.append("--mResponseType error ---");
            paramArrayOfByte.append(paramRequestTask.mResponseType);
            QMLog.e("[mini] http.RequestJsPlugin", paramArrayOfByte.toString());
            paramArrayOfByte = new JSONObject();
            paramArrayOfByte.put("state", "fail");
            paramArrayOfByte.put("statusCode", -1);
            paramArrayOfByte.put("requestTaskId", paramRequestTask.mTaskId);
            paramRequestEvent.jsService.evaluateSubscribeJS("onRequestTaskStateChange", paramArrayOfByte.toString(), 0);
            return;
            localJSONObject1.put("res", localJSONObject2);
            paramRequestEvent.jsService.evaluateSubscribeJS("onRequestTaskStateChange", localJSONObject2.toString(), 0);
            return;
          }
          catch (Throwable paramArrayOfByte) {}
        }
        try
        {
          paramMap = new JSONObject();
          paramMap.put("state", "fail");
          paramMap.put("statusCode", "-1");
          paramMap.put("requestTaskId", paramRequestTask.mTaskId);
          paramString = new StringBuilder();
          paramString.append("exception：");
          paramString.append(paramArrayOfByte.getMessage());
          paramMap.put("errMsg", paramString.toString());
          paramRequestEvent.jsService.evaluateSubscribeJS("onRequestTaskStateChange", paramMap.toString(), 0);
          QMLog.e("[mini] http.RequestJsPlugin", "httpCallBack exception:", paramArrayOfByte);
          return;
        }
        catch (Throwable paramMap)
        {
          break label521;
        }
      }
      catch (Throwable paramArrayOfByte) {}
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
        Object localObject = (RequestJsPlugin.WebsocketRequestTask)this.wsrequestMap.get(Integer.valueOf(paramInt));
        WebSocketProxy localWebSocketProxy = (WebSocketProxy)ProxyManager.get(WebSocketProxy.class);
        if ((localObject != null) && (localWebSocketProxy != null))
        {
          localWebSocketProxy.send(paramInt, paramString);
          if (this.mIsMiniGame) {
            callbackOK(paramRequestEvent, null, "sendSocketMessage");
          }
          paramRequestEvent = ApiUtil.wrapCallbackOk(paramRequestEvent.event, null).toString();
          return paramRequestEvent;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramRequestEvent.event);
        ((StringBuilder)localObject).append(" error, send msg:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" on null socket instance");
        QMLog.e("[mini] http.RequestJsPlugin", ((StringBuilder)localObject).toString());
        if (this.mIsMiniGame) {
          callbackFail(paramRequestEvent, null, "socket is null ", "sendSocketMessage");
        }
        paramRequestEvent = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "socket is null ").toString();
        return paramRequestEvent;
      }
      if (this.mIsMiniGame) {
        callbackFail(paramRequestEvent, null, "do not have this socket ", "closeSocket");
      }
      paramRequestEvent = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "do not have this socket ").toString();
      return paramRequestEvent;
    }
  }
  
  private String operateSocketSend(RequestEvent paramRequestEvent, JSONObject paramJSONObject, int paramInt)
  {
    String str = paramJSONObject.optString("data", null);
    if (str != null) {
      return operateSocketSend(paramRequestEvent, paramInt, str);
    }
    if (NativeBuffer.hasNativeBuffer(paramJSONObject)) {
      return operateSocketSendWithNativeBuffer(paramRequestEvent, paramJSONObject, paramInt);
    }
    return null;
  }
  
  @NotNull
  private String operateSocketSendWithNativeBuffer(RequestEvent paramRequestEvent, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = NativeBuffer.unpackNativeBuffer(paramRequestEvent.jsService, paramJSONObject, "data");
    if ((paramJSONObject != null) && (paramJSONObject.buf != null))
    {
      Object localObject = this.wsrequestMap;
      if ((localObject != null) && (((ConcurrentHashMap)localObject).size() != 0))
      {
        localObject = (RequestJsPlugin.WebsocketRequestTask)this.wsrequestMap.get(Integer.valueOf(paramInt));
        WebSocketProxy localWebSocketProxy = (WebSocketProxy)ProxyManager.get(WebSocketProxy.class);
        if ((localObject != null) && (localWebSocketProxy != null))
        {
          localWebSocketProxy.send(paramInt, paramJSONObject.buf);
          if (this.mIsMiniGame) {
            callbackOK(paramRequestEvent, null);
          }
          return ApiUtil.wrapCallbackOk(paramRequestEvent.event, null).toString();
        }
        paramJSONObject = new StringBuilder();
        paramJSONObject.append(paramRequestEvent.event);
        paramJSONObject.append(" error, send NativeBuffer on null socket instance");
        QMLog.e("[mini] http.RequestJsPlugin", paramJSONObject.toString());
        if (this.mIsMiniGame) {
          callbackFail(paramRequestEvent, null, "socket is null ", "sendSocketMessage");
        }
        return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "socket is null ").toString();
      }
    }
    if (this.mIsMiniGame) {
      callbackFail(paramRequestEvent, null, "do not have this socket ", "closeSocket");
    }
    return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "do not have this socket ").toString();
  }
  
  private void reportRequestResult(int paramInt1, RequestJsPlugin.RequestTask paramRequestTask1, RequestJsPlugin.RequestTask paramRequestTask2, RequestEvent paramRequestEvent, String paramString1, int paramInt2, String paramString2)
  {
    if (paramRequestTask1 != null)
    {
      long l1 = SystemClock.elapsedRealtime() - paramRequestTask1.mRequestCreatedMillis;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[request httpCallBack][minigame timecost=");
      localStringBuilder.append(l1);
      localStringBuilder.append("ms],[code=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("][url=");
      localStringBuilder.append(paramRequestTask2.mUrl);
      localStringBuilder.append("][callbackId=");
      localStringBuilder.append(paramRequestEvent.callbackId);
      localStringBuilder.append("][params=");
      localStringBuilder.append(paramRequestEvent.jsonParams);
      localStringBuilder.append("]");
      QMLog.i("[mini] http.RequestJsPlugin", localStringBuilder.toString());
      paramRequestTask2 = getSecondLevelDomain(paramRequestTask1.mOriginUrl);
      paramRequestTask1 = new StringBuilder();
      paramRequestTask1.append("httpCallBack second level domain ");
      paramRequestTask1.append(paramRequestTask2);
      QMLog.d("[mini] http.RequestJsPlugin", paramRequestTask1.toString());
      if (this.mIsMiniGame) {
        paramRequestTask1 = "1";
      } else {
        paramRequestTask1 = "0";
      }
      MiniReportManager.reportEventType(this.mMiniAppInfo, 628, null, null, null, paramInt1, paramRequestTask1, l1, paramRequestTask2, paramString2, null, null, null);
      paramRequestTask1 = this.mMiniAppInfo;
      long l2 = paramInt2;
      MiniProgramLpReportDC05115.reportHttpRequestResult(paramRequestTask1, paramInt1, l2, l1);
      MiniProgramLpReportDC05116.reportOneHttpOrDownloadRequest(this.mMiniAppInfo, paramString1, l2, l1, paramInt1);
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
    try
    {
      Object localObject3;
      try
      {
        Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
        ((RequestStrategyProxy)ProxyManager.get(RequestStrategyProxy.class)).addHttpForwardingInfo((JSONObject)localObject1);
        boolean bool = ((JSONObject)localObject1).optBoolean("__skipDomainCheck__", false);
        localObject3 = new RequestJsPlugin.RequestTask(this, paramRequestEvent.jsService, (JSONObject)localObject1);
        localObject1 = ((RequestJsPlugin.RequestTask)localObject3).mOriginUrl;
        if ((((RequestJsPlugin.RequestTask)localObject3).mMethod != null) && (!supportMethod.contains(((RequestJsPlugin.RequestTask)localObject3).mMethod.toUpperCase())))
        {
          if (!this.mIsMiniGame) {
            callbackFail(paramRequestEvent, null, "request protocol error");
          }
          localObject1 = ApiUtil.wrapCallbackFail("createRequest", null, "request protocol error").toString();
          return localObject1;
        }
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((((String)localObject1).startsWith("https://")) || (((String)localObject1).startsWith("http://"))))
        {
          if (!DomainUtil.isDomainValid(this.mMiniAppInfo, bool, (String)localObject1, 0))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("check request DomainValid fail, callbackFail, event:");
            ((StringBuilder)localObject3).append(paramRequestEvent.event);
            ((StringBuilder)localObject3).append(", callbackId:");
            ((StringBuilder)localObject3).append(paramRequestEvent.callbackId);
            ((StringBuilder)localObject3).append(", url:");
            ((StringBuilder)localObject3).append((String)localObject1);
            QMLog.w("[mini] http.RequestJsPlugin", ((StringBuilder)localObject3).toString());
            if (!this.mIsMiniGame) {
              callbackFail(paramRequestEvent, null, "url not in domain list, 请求域名不合法");
            }
            localObject1 = ApiUtil.wrapCallbackFail("createRequest", null, "url not in domain list, 请求域名不合法").toString();
            return localObject1;
          }
          this.requestMap.put(Integer.valueOf(((RequestJsPlugin.RequestTask)localObject3).mTaskId), localObject3);
          try
          {
            JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
            localJSONObject.put("requestTaskId", ((RequestJsPlugin.RequestTask)localObject3).mTaskId);
            if (this.requestMap.size() > 200)
            {
              QMLog.d("[mini] http.RequestJsPlugin", "[httpRequest] too much request");
              if (!this.mIsMiniGame) {
                callbackFail(paramRequestEvent, localJSONObject);
              }
              localObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject).toString();
              return localObject1;
            }
            RequestProxy localRequestProxy = (RequestProxy)ProxyManager.get(RequestProxy.class);
            if (localRequestProxy == null)
            {
              QMLog.d("[mini] http.RequestJsPlugin", "[httpRequest] too much request");
              if (!this.mIsMiniGame) {
                callbackFail(paramRequestEvent, localJSONObject);
              }
              localObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, localJSONObject).toString();
              return localObject1;
            }
            if (doRequest(paramRequestEvent, (RequestJsPlugin.RequestTask)localObject3, (String)localObject1, localRequestProxy))
            {
              if (!this.mIsMiniGame) {
                callbackOK(paramRequestEvent, localJSONObject);
              }
              localObject1 = ApiUtil.wrapCallbackOk(paramRequestEvent.event, localJSONObject).toString();
              return localObject1;
            }
          }
          catch (Throwable localThrowable1)
          {
            QMLog.e("[mini] http.RequestJsPlugin", "", localThrowable1);
          }
        }
        else
        {
          if (!this.mIsMiniGame) {
            callbackFail(paramRequestEvent, null, "url is invalid");
          }
          String str = ApiUtil.wrapCallbackFail("createRequest", null, "url is invalid").toString();
          return str;
        }
      }
      finally {}
      return "";
    }
    catch (Throwable localThrowable2)
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramRequestEvent.event);
      ((StringBuilder)localObject3).append(" exception:");
      QMLog.e("[mini] http.RequestJsPlugin", ((StringBuilder)localObject3).toString(), localThrowable2);
      callbackFail(paramRequestEvent, null, "createRequest");
    }
  }
  
  @JsEvent({"createSocketTask"})
  public String createSocketTask(RequestEvent paramRequestEvent)
  {
    try
    {
      synchronized (this.lock)
      {
        Object localObject3 = (WebSocketProxy)ProxyManager.get(WebSocketProxy.class);
        if (localObject3 == null)
        {
          QMLog.w("[mini] http.RequestJsPlugin", "not support web socket right now");
          callbackFail(paramRequestEvent, null, "not support web socket right now");
          return "";
        }
        Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
        ((RequestStrategyProxy)ProxyManager.get(RequestStrategyProxy.class)).addHttpForwardingInfo((JSONObject)localObject1);
        boolean bool = ((JSONObject)localObject1).optBoolean("__skipDomainCheck__", false);
        int j = this.mApkgInfo.getAppConfigInfo().networkTimeoutInfo.connectSocket;
        localObject1 = new RequestJsPlugin.WebsocketRequestTask(this, (JSONObject)localObject1);
        if (!DomainUtil.isDomainValid(this.mMiniAppInfo, bool, ((RequestJsPlugin.WebsocketRequestTask)localObject1).mOriginUrl, 1))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("check socket DomainValid fail, callbackFail, event:");
          ((StringBuilder)localObject3).append(paramRequestEvent.event);
          ((StringBuilder)localObject3).append(", callbackId:");
          ((StringBuilder)localObject3).append(paramRequestEvent.callbackId);
          ((StringBuilder)localObject3).append(", url:");
          ((StringBuilder)localObject3).append(((RequestJsPlugin.WebsocketRequestTask)localObject1).mUrl);
          QMLog.w("[mini] http.RequestJsPlugin", ((StringBuilder)localObject3).toString());
          callbackFail(paramRequestEvent, null, "请求域名不合法");
          return "";
        }
        int i = j;
        if (((RequestJsPlugin.WebsocketRequestTask)localObject1).mTimeout > j) {
          i = ((RequestJsPlugin.WebsocketRequestTask)localObject1).mTimeout;
        }
        connectSocket(paramRequestEvent, (WebSocketProxy)localObject3, i, (RequestJsPlugin.WebsocketRequestTask)localObject1);
        this.wsrequestMap.put(Integer.valueOf(((RequestJsPlugin.WebsocketRequestTask)localObject1).mTaskId), localObject1);
        localObject3 = new JSONObject(paramRequestEvent.jsonParams);
        ((JSONObject)localObject3).put("socketTaskId", ((RequestJsPlugin.WebsocketRequestTask)localObject1).mTaskId);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramRequestEvent.event);
        ((StringBuilder)localObject1).append(":ok");
        ((JSONObject)localObject3).put("errMsg", ((StringBuilder)localObject1).toString());
        callbackOK(paramRequestEvent, (JSONObject)localObject3);
        localObject1 = ((JSONObject)localObject3).toString();
        return localObject1;
      }
      StringBuilder localStringBuilder;
      return "";
    }
    catch (Throwable localThrowable)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRequestEvent.event);
      localStringBuilder.append(" exception:");
      QMLog.e("[mini] http.RequestJsPlugin", localStringBuilder.toString(), localThrowable);
      callbackFail(paramRequestEvent, null);
      try
      {
        paramRequestEvent = new RequestJsPlugin.WebsocketRequestTask(this, new JSONObject(paramRequestEvent.jsonParams)).mUrl;
        MiniReportManager.reportEventType(this.mMiniAppInfo, 632, null, null, null, 1, MiniReportManager.getAppType(this.mMiniAppInfo), 0L, getSecondLevelDomain(paramRequestEvent));
      }
      catch (JSONException paramRequestEvent)
      {
        QMLog.e("[mini] http.RequestJsPlugin", "handleNativeRequest ", paramRequestEvent);
      }
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
      localObject = new JSONObject(paramRequestEvent.jsonParams);
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
      paramRequestEvent.printStackTrace();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OPERATE_REQUEST_TASK : ");
      ((StringBuilder)localObject).append(paramRequestEvent);
      QMLog.e("[mini] http.RequestJsPlugin", ((StringBuilder)localObject).toString());
    }
    return "";
  }
  
  @JsEvent({"operateSocketTask"})
  public String operateSocketTask(RequestEvent paramRequestEvent)
  {
    try
    {
      Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      localObject2 = ((JSONObject)localObject1).optString("operationType");
      int i = ((JSONObject)localObject1).optInt("socketTaskId");
      if ("close".equals(localObject2)) {
        return operateSocketClose(paramRequestEvent, (JSONObject)localObject1, i);
      }
      if ("send".equals(localObject2))
      {
        localObject1 = operateSocketSend(paramRequestEvent, (JSONObject)localObject1, i);
        if (localObject1 != null) {
          return localObject1;
        }
      }
      return "";
    }
    catch (Throwable localThrowable)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramRequestEvent.event);
      ((StringBuilder)localObject2).append(" exception:");
      QMLog.e("[mini] http.RequestJsPlugin", ((StringBuilder)localObject2).toString(), localThrowable);
    }
    return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
  }
  
  @JsEvent(isSync=false, value={"wnsCgiRequest"})
  public String wnsCgiRequest(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramRequestEvent.jsonParams);
      localObject2 = localJSONObject.optJSONObject("header");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new JSONObject();
      }
      ((JSONObject)localObject1).put("Referer", getRequestReferer());
      localObject1 = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (localObject1 != null)
      {
        ((ChannelProxy)localObject1).wnsCgiRequest(localJSONObject, new RequestJsPlugin.4(this, paramRequestEvent));
        return "";
      }
      callbackFail(paramRequestEvent, null, "do not support wnsCgiRequest");
      localObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "do not support wnsCgiRequest").toString();
      return localObject1;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramRequestEvent.event);
      ((StringBuilder)localObject2).append(" exception:");
      QMLog.e("[mini] http.RequestJsPlugin", ((StringBuilder)localObject2).toString(), localThrowable);
    }
    return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
  }
  
  @JsEvent({"wnsGroupRequest"})
  public String wnsGroupRequest(RequestEvent paramRequestEvent)
  {
    try
    {
      String str = new JSONObject(paramRequestEvent.jsonParams).optString("entryDataHash");
      if ((this.mMiniAppInfo != null) && (this.mMiniAppInfo.launchParam != null) && (this.mMiniAppInfo.launchParam.entryModel != null) && (str != null)) {
        if ((str.equals(this.mMiniAppInfo.launchParam.entryModel.getEntryHash())) && (this.mMiniAppInfo.launchParam.entryModel.isAdmin))
        {
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
        else {
          paramRequestEvent.fail("entryDataHash is not vaild or you are not group administrator");
        }
      }
      return "";
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramRequestEvent.event);
      localStringBuilder.append(" exception:");
      QMLog.e("[mini] http.RequestJsPlugin", localStringBuilder.toString(), localThrowable);
    }
    return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
  }
  
  @JsEvent({"wnsRequest"})
  public String wnsRequest(RequestEvent paramRequestEvent)
  {
    ThreadManager.getSubThreadHandler().post(new RequestJsPlugin.3(this, paramRequestEvent));
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RequestJsPlugin
 * JD-Core Version:    0.7.0.1
 */