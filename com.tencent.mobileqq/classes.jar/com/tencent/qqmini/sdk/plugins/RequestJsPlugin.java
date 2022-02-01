package com.tencent.qqmini.sdk.plugins;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
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
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.qqmini.sdk.utils.DomainUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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
  
  private boolean doRequest(RequestEvent paramRequestEvent, RequestJsPlugin.RequestTask paramRequestTask, String paramString, RequestProxy paramRequestProxy)
  {
    return paramRequestProxy.request(paramRequestTask.mUrl, paramRequestTask.mBody, paramRequestTask.mHeaders, paramRequestTask.mMethod, 60, new RequestJsPlugin.1(this, paramString, paramRequestTask, paramRequestEvent));
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
      Object localObject3;
      int j;
      synchronized (this.lock)
      {
        WebSocketProxy localWebSocketProxy = (WebSocketProxy)ProxyManager.get(WebSocketProxy.class);
        if (localWebSocketProxy == null)
        {
          QMLog.w("[mini] http.RequestJsPlugin", "not support web socket right now");
          callbackFail(paramRequestEvent, null, "not support web socket right now");
          return "";
        }
        localObject3 = new JSONObject(paramRequestEvent.jsonParams);
        ((RequestStrategyProxy)ProxyManager.get(RequestStrategyProxy.class)).addHttpForwardingInfo((JSONObject)localObject3);
        boolean bool = ((JSONObject)localObject3).optBoolean("__skipDomainCheck__", false);
        j = this.mApkgInfo.getAppConfigInfo().networkTimeoutInfo.connectSocket;
        localObject3 = new RequestJsPlugin.WebsocketRequestTask(this, (JSONObject)localObject3);
        if (!DomainUtil.isDomainValid(this.mMiniAppInfo, bool, ((RequestJsPlugin.WebsocketRequestTask)localObject3).mOriginUrl, 1))
        {
          QMLog.w("[mini] http.RequestJsPlugin", "check socket DomainValid fail, callbackFail, event:" + paramRequestEvent.event + ", callbackId:" + paramRequestEvent.callbackId + ", url:" + ((RequestJsPlugin.WebsocketRequestTask)localObject3).mUrl);
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
        if (((RequestJsPlugin.WebsocketRequestTask)localObject3).mTimeout > j) {
          i = ((RequestJsPlugin.WebsocketRequestTask)localObject3).mTimeout;
        }
        localObject1.connectSocket(((RequestJsPlugin.WebsocketRequestTask)localObject3).mTaskId, ((RequestJsPlugin.WebsocketRequestTask)localObject3).mUrl, ((RequestJsPlugin.WebsocketRequestTask)localObject3).mHeaders, ((RequestJsPlugin.WebsocketRequestTask)localObject3).mMethod, i, new RequestJsPlugin.2(this, paramRequestEvent, (RequestJsPlugin.WebsocketRequestTask)localObject3));
        this.wsrequestMap.put(Integer.valueOf(((RequestJsPlugin.WebsocketRequestTask)localObject3).mTaskId), localObject3);
        Object localObject2 = new JSONObject(paramRequestEvent.jsonParams);
        ((JSONObject)localObject2).put("socketTaskId", ((RequestJsPlugin.WebsocketRequestTask)localObject3).mTaskId);
        ((JSONObject)localObject2).put("errMsg", paramRequestEvent.event + ":ok");
        callbackOK(paramRequestEvent, (JSONObject)localObject2);
        localObject2 = ((JSONObject)localObject2).toString();
        return localObject2;
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
    int i;
    WebSocketProxy localWebSocketProxy;
    try
    {
      Object localObject3 = new JSONObject(paramRequestEvent.jsonParams);
      ??? = ((JSONObject)localObject3).optString("operationType");
      i = ((JSONObject)localObject3).optInt("socketTaskId");
      if ("close".equals(???)) {
        synchronized (this.lock)
        {
          if ((this.wsrequestMap != null) && (this.wsrequestMap.size() != 0))
          {
            localObject8 = (RequestJsPlugin.WebsocketRequestTask)this.wsrequestMap.get(Integer.valueOf(i));
            this.wsrequestMap.remove(Integer.valueOf(i));
            int j = ((JSONObject)localObject3).optInt("code", 1000);
            localObject3 = ((JSONObject)localObject3).optString("reason", "Goodbye");
            localWebSocketProxy = (WebSocketProxy)ProxyManager.get(WebSocketProxy.class);
            if ((localWebSocketProxy != null) && (localObject8 != null)) {
              localWebSocketProxy.closeSocket(i, j, (String)localObject3);
            }
            if (this.mIsMiniGame) {
              callbackOK(paramRequestEvent, null, "closeSocket");
            }
            localObject3 = ApiUtil.wrapCallbackOk(paramRequestEvent.event, null).toString();
            return localObject3;
          }
          if (this.mIsMiniGame) {
            callbackFail(paramRequestEvent, null, "do not have this socket ", "closeSocket");
          }
          localObject3 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "do not have this socket ").toString();
          return localObject3;
        }
      }
      if (!"send".equals(localThrowable)) {
        break label770;
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("[mini] http.RequestJsPlugin", paramRequestEvent.event + " exception:", localThrowable);
      return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
    }
    Object localObject8 = localObject4.optString("data", null);
    Object localObject7;
    if (localObject8 != null)
    {
      synchronized (this.lock)
      {
        if ((this.wsrequestMap == null) || (this.wsrequestMap.size() == 0)) {
          break label503;
        }
        Object localObject5 = (RequestJsPlugin.WebsocketRequestTask)this.wsrequestMap.get(Integer.valueOf(i));
        localWebSocketProxy = (WebSocketProxy)ProxyManager.get(WebSocketProxy.class);
        if ((localObject5 != null) && (localWebSocketProxy != null))
        {
          localWebSocketProxy.send(i, (String)localObject8);
          if (this.mIsMiniGame) {
            callbackOK(paramRequestEvent, null, "sendSocketMessage");
          }
          localObject5 = ApiUtil.wrapCallbackOk(paramRequestEvent.event, null).toString();
          return localObject5;
        }
      }
      QMLog.e("[mini] http.RequestJsPlugin", paramRequestEvent.event + " error, send msg:" + (String)localObject8 + " on null socket instance");
      if (this.mIsMiniGame) {
        callbackFail(paramRequestEvent, null, "socket is null ", "sendSocketMessage");
      }
      localObject7 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "socket is null ").toString();
      return localObject7;
      label503:
      if (this.mIsMiniGame) {
        callbackFail(paramRequestEvent, null, "do not have this socket ", "closeSocket");
      }
      localObject7 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "do not have this socket ").toString();
      return localObject7;
    }
    if (NativeBuffer.hasNativeBuffer((JSONObject)localObject7))
    {
      ??? = NativeBuffer.unpackNativeBuffer(paramRequestEvent.jsService, (JSONObject)localObject7, "data");
      if ((??? != null) && (((NativeBuffer)???).buf != null) && (this.wsrequestMap != null) && (this.wsrequestMap.size() != 0))
      {
        localObject7 = (RequestJsPlugin.WebsocketRequestTask)this.wsrequestMap.get(Integer.valueOf(i));
        localObject8 = (WebSocketProxy)ProxyManager.get(WebSocketProxy.class);
        if ((localObject7 != null) && (localObject8 != null))
        {
          ((WebSocketProxy)localObject8).send(i, ((NativeBuffer)???).buf);
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
      ??? = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "do not have this socket ").toString();
      return ???;
    }
    label770:
    return "";
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
    label246:
    for (;;)
    {
      try
      {
        String str = new JSONObject(paramRequestEvent.jsonParams).optString("entryDataHash");
        if ((this.mMiniAppInfo != null) && (this.mMiniAppInfo.launchParam != null) && (this.mMiniAppInfo.launchParam.entryModel != null) && (str != null))
        {
          if ((!str.equals(this.mMiniAppInfo.launchParam.entryModel.getEntryHash())) || (!this.mMiniAppInfo.launchParam.entryModel.isAdmin)) {
            break label246;
          }
          if (!paramRequestEvent.jsonParams.contains("{groupId}")) {
            continue;
          }
          str = paramRequestEvent.jsonParams.replace("{groupId}", String.valueOf(this.mMiniAppInfo.launchParam.entryModel.uin));
          ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
          if (localChannelProxy != null) {
            localChannelProxy.wnsCgiRequest(new JSONObject(str), new RequestJsPlugin.5(this, paramRequestEvent));
          }
        }
        else
        {
          return "";
        }
        callbackFail(paramRequestEvent, null, "do not support wnsGroupRequest");
        return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "do not support wnsGroupRequest").toString();
        paramRequestEvent.fail("groupId is null");
        continue;
        paramRequestEvent.fail("entryDataHash is not vaild or you are not group administrator");
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("[mini] http.RequestJsPlugin", paramRequestEvent.event + " exception:", localThrowable);
        return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
      }
    }
  }
  
  @JsEvent({"wnsRequest"})
  public String wnsRequest(RequestEvent paramRequestEvent)
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
        ((ChannelProxy)localObject).wnsCgiRequest(localJSONObject2, new RequestJsPlugin.3(this, paramRequestEvent));
        return "";
      }
      callbackFail(paramRequestEvent, null, "do not support wnsRequest");
      localObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null, "do not support wnsRequest").toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("[mini] http.RequestJsPlugin", paramRequestEvent.event + " exception:", localThrowable);
    }
    return ApiUtil.wrapCallbackFail(paramRequestEvent.event, null).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RequestJsPlugin
 * JD-Core Version:    0.7.0.1
 */