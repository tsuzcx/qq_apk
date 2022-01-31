package com.tencent.qqmini.sdk.core.plugins;

import android.net.Uri;
import android.text.TextUtils;
import bghn;
import bgjw;
import bgkd;
import bgki;
import bgkz;
import bglb;
import bgyd;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.core.proxy.WebSocketProxy;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.NetworkTimeoutInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DomainUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestJsPlugin
  extends BaseJsPlugin
{
  private static final int MAX_SUPPORT_SOCKET_CONNECTION_SIZE = 2;
  private static final String STATE_COMPLETE = "complete";
  private static final String STATE_FAIL = "fail";
  private static final String STATE_OK = "ok";
  private static final String TAG = "[mini] http.RequestJsPlugin";
  private static final String WNS_CGI_REQUEST = "wnsCgiRequest";
  public static AtomicInteger sRequestId = new AtomicInteger();
  public static AtomicInteger sWebSocketRequestId = new AtomicInteger();
  private static final ArrayList<String> supportMethod = new ArrayList(Arrays.asList(new String[] { "OPTIONS", "GET", "HEAD", "POST", "PUT", "DELETE", "TRACE" }));
  private byte[] lock = new byte[0];
  private ConcurrentHashMap<Integer, RequestJsPlugin.RequestTask> requestMap = new ConcurrentHashMap();
  private boolean socketClosedCallbacked;
  private ConcurrentHashMap<Integer, RequestJsPlugin.WebsocketRequestTask> wsrequestMap = new ConcurrentHashMap();
  
  private void callback(bgkd parambgkd, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    if (parambgkd != null)
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
      paramJSONObject = bgkz.a(paramJSONObject, "errMsg", paramString2).toString();
      parambgkd.a(paramJSONObject);
      if (!"fail".equals(paramString1)) {
        break label141;
      }
      QMLog.e("[mini] http.RequestJsPlugin", "[callbackFail] " + paramJSONObject);
      return;
      paramString3 = parambgkd.jdField_a_of_type_JavaLangString;
      break;
    }
    label141:
    QMLog.i("[mini] http.RequestJsPlugin", "[callback] " + paramJSONObject);
  }
  
  private void callbackComplete(bgkd parambgkd, JSONObject paramJSONObject)
  {
    callback(parambgkd, paramJSONObject, "complete", null, null);
  }
  
  private void callbackFail(bgkd parambgkd, JSONObject paramJSONObject)
  {
    callback(parambgkd, paramJSONObject, "fail", null, null);
  }
  
  private void callbackFail(bgkd parambgkd, JSONObject paramJSONObject, String paramString)
  {
    callback(parambgkd, paramJSONObject, "fail", paramString, null);
  }
  
  private void callbackFail(bgkd parambgkd, JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    callback(parambgkd, paramJSONObject, "fail", paramString1, null);
  }
  
  private void callbackOK(bgkd parambgkd, JSONObject paramJSONObject)
  {
    callback(parambgkd, paramJSONObject, "ok", null, null);
  }
  
  private void callbackOK(bgkd parambgkd, JSONObject paramJSONObject, String paramString)
  {
    callback(parambgkd, paramJSONObject, "ok", null, paramString);
  }
  
  private String getRequestReferer()
  {
    Object localObject1 = "";
    String str = "debug";
    Object localObject2 = this.mMiniAppInfo;
    if (localObject2 != null)
    {
      localObject1 = ((MiniAppInfo)localObject2).appId;
      str = ((MiniAppInfo)localObject2).version;
    }
    localObject2 = new StringBuilder().append("https://appservice.qq.com/").append((String)localObject1).append("/");
    localObject1 = str;
    if (TextUtils.isEmpty(str)) {
      localObject1 = "debug";
    }
    return (String)localObject1 + "/page-frame.html";
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
  
  private void onCloseCallback(bgkd parambgkd, int paramInt1, String paramString, int paramInt2)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("socketTaskId", paramInt2);
      ((JSONObject)localObject).put("state", "close");
      ((JSONObject)localObject).put("code", paramInt1);
      ((JSONObject)localObject).put("reason", paramString);
      parambgkd.jdField_a_of_type_Bghn.a("onSocketTaskStateChange", ((JSONObject)localObject).toString(), 0);
      parambgkd = (RequestJsPlugin.WebsocketRequestTask)this.wsrequestMap.get(Integer.valueOf(paramInt2));
      paramString = this.mMiniAppInfo;
      localObject = bgyd.a(this.mMiniAppInfo);
      if (parambgkd != null) {}
      for (parambgkd = parambgkd.mUrl;; parambgkd = null)
      {
        bgyd.a(paramString, 633, null, null, null, 0, (String)localObject, 0L, getSecondLevelDomain(parambgkd));
        return;
      }
      return;
    }
    catch (JSONException parambgkd)
    {
      QMLog.e("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onClose exception:", parambgkd);
    }
  }
  
  public String createRequestTask(bgkd parambgkd)
  {
    boolean bool;
    String str2;
    try
    {
      try
      {
        Object localObject1 = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString);
        bool = ((JSONObject)localObject1).optBoolean("__skipDomainCheck__", false);
        localObject1 = new RequestJsPlugin.RequestTask(this, (JSONObject)localObject1);
        str2 = ((RequestJsPlugin.RequestTask)localObject1).mUrl;
        if ((((RequestJsPlugin.RequestTask)localObject1).mMethod != null) && (!supportMethod.contains(((RequestJsPlugin.RequestTask)localObject1).mMethod.toUpperCase())))
        {
          if (!this.mIsMiniGame) {
            callbackFail(parambgkd, null, "request protocol error");
          }
          localObject1 = bgki.a("createRequest", null, "request protocol error").toString();
          return localObject1;
        }
        if ((!TextUtils.isEmpty(str2)) && ((str2.startsWith("https://")) || (str2.startsWith("http://")))) {
          break label207;
        }
        if (!this.mIsMiniGame) {
          callbackFail(parambgkd, null, "url is invalid");
        }
        localObject1 = bgki.a("createRequest", null, "url is invalid").toString();
        return localObject1;
      }
      finally {}
      return "";
    }
    catch (Throwable localThrowable1)
    {
      QMLog.e("[mini] http.RequestJsPlugin", parambgkd.jdField_a_of_type_JavaLangString + " exception:", localThrowable1);
      callbackFail(parambgkd, null, "createRequest");
    }
    for (;;)
    {
      label207:
      String str1;
      if (!DomainUtil.isDomainValid(this.mMiniAppInfo, bool, str2, 0))
      {
        QMLog.w("[mini] http.RequestJsPlugin", "check request DomainValid fail, callbackFail, event:" + parambgkd.jdField_a_of_type_JavaLangString + ", callbackId:" + parambgkd.jdField_b_of_type_Int + ", url:" + str2);
        if (!this.mIsMiniGame) {
          callbackFail(parambgkd, null, "url not in domain list, 请求域名不合法");
        }
        str1 = bgki.a("createRequest", null, "url not in domain list, 请求域名不合法").toString();
        return str1;
      }
      this.requestMap.put(Integer.valueOf(str1.mTaskId), str1);
      try
      {
        JSONObject localJSONObject = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString);
        localJSONObject.put("requestTaskId", str1.mTaskId);
        if (this.requestMap.size() > 200)
        {
          QMLog.d("[mini] http.RequestJsPlugin", "[httpRequest] too much request");
          if (!this.mIsMiniGame) {
            callbackFail(parambgkd, localJSONObject);
          }
          str1 = bgki.b(parambgkd.jdField_a_of_type_JavaLangString, localJSONObject).toString();
          return str1;
        }
        RequestProxy localRequestProxy = (RequestProxy)ProxyManager.get(RequestProxy.class);
        if (localRequestProxy == null)
        {
          QMLog.d("[mini] http.RequestJsPlugin", "[httpRequest] too much request");
          if (!this.mIsMiniGame) {
            callbackFail(parambgkd, localJSONObject);
          }
          str1 = bgki.b(parambgkd.jdField_a_of_type_JavaLangString, localJSONObject).toString();
          return str1;
        }
        if (localRequestProxy.request(str1.mUrl, str1.mBody, str1.mHeaders, str1.mMethod, 60, new RequestJsPlugin.1(this, str2, str1, parambgkd)))
        {
          if (!this.mIsMiniGame) {
            callbackOK(parambgkd, localJSONObject);
          }
          str1 = bgki.a(parambgkd.jdField_a_of_type_JavaLangString, localJSONObject).toString();
          return str1;
        }
      }
      catch (Throwable localThrowable2)
      {
        QMLog.e("[mini] http.RequestJsPlugin", "", localThrowable2);
      }
    }
  }
  
  public String createSocketTask(bgkd parambgkd)
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
          callbackFail(parambgkd, null, "not support web socket right now");
          return "";
        }
        localObject3 = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString);
        boolean bool = ((JSONObject)localObject3).optBoolean("__skipDomainCheck__", false);
        j = this.mApkgInfo.a().networkTimeoutInfo.connectSocket;
        localObject3 = new RequestJsPlugin.WebsocketRequestTask(this, (JSONObject)localObject3);
        if (!DomainUtil.isDomainValid(this.mMiniAppInfo, bool, ((RequestJsPlugin.WebsocketRequestTask)localObject3).mUrl, 1))
        {
          QMLog.w("[mini] http.RequestJsPlugin", "check socket DomainValid fail, callbackFail, event:" + parambgkd.jdField_a_of_type_JavaLangString + ", callbackId:" + parambgkd.jdField_b_of_type_Int + ", url:" + ((RequestJsPlugin.WebsocketRequestTask)localObject3).mUrl);
          callbackFail(parambgkd, null, "请求域名不合法");
          return "";
        }
      }
      try
      {
        parambgkd = new RequestJsPlugin.WebsocketRequestTask(this, new JSONObject(parambgkd.jdField_b_of_type_JavaLangString)).mUrl;
        bgyd.a(this.mMiniAppInfo, 632, null, null, null, 1, bgyd.a(this.mMiniAppInfo), 0L, getSecondLevelDomain(parambgkd));
        return "";
        int i = j;
        if (((RequestJsPlugin.WebsocketRequestTask)localObject3).mTimeout > j) {
          i = ((RequestJsPlugin.WebsocketRequestTask)localObject3).mTimeout;
        }
        localObject1.connectSocket(((RequestJsPlugin.WebsocketRequestTask)localObject3).mTaskId, ((RequestJsPlugin.WebsocketRequestTask)localObject3).mUrl, ((RequestJsPlugin.WebsocketRequestTask)localObject3).mHeaders, ((RequestJsPlugin.WebsocketRequestTask)localObject3).mMethod, i, new RequestJsPlugin.2(this, parambgkd, (RequestJsPlugin.WebsocketRequestTask)localObject3));
        this.wsrequestMap.put(Integer.valueOf(((RequestJsPlugin.WebsocketRequestTask)localObject3).mTaskId), localObject3);
        Object localObject2 = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject2).put("socketTaskId", ((RequestJsPlugin.WebsocketRequestTask)localObject3).mTaskId);
        ((JSONObject)localObject2).put("errMsg", parambgkd.jdField_a_of_type_JavaLangString + ":ok");
        callbackOK(parambgkd, (JSONObject)localObject2);
        localObject2 = ((JSONObject)localObject2).toString();
        return localObject2;
      }
      catch (JSONException parambgkd)
      {
        for (;;)
        {
          QMLog.e("[mini] http.RequestJsPlugin", "handleNativeRequest ", parambgkd);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("[mini] http.RequestJsPlugin", parambgkd.jdField_a_of_type_JavaLangString + " exception:", localThrowable);
      callbackFail(parambgkd, null);
    }
  }
  
  public String operateRequestTask(bgkd parambgkd)
  {
    try
    {
      Object localObject = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString);
      int i = ((JSONObject)localObject).optInt("requestTaskId");
      localObject = ((JSONObject)localObject).optString("operationType");
      if (this.requestMap.containsKey(Integer.valueOf(i)))
      {
        RequestJsPlugin.RequestTask localRequestTask = (RequestJsPlugin.RequestTask)this.requestMap.remove(Integer.valueOf(i));
        if ((localRequestTask != null) && ("abort".equals(localObject)))
        {
          ((RequestProxy)ProxyManager.get(RequestProxy.class)).abort(localRequestTask.mUrl);
          if (!this.mIsMiniGame) {
            callbackOK(parambgkd, null);
          }
        }
      }
    }
    catch (Exception parambgkd)
    {
      for (;;)
      {
        QMLog.e("[mini] http.RequestJsPlugin", "OPERATE_REQUEST_TASK : " + parambgkd);
      }
    }
    return "";
  }
  
  public String operateSocketTask(bgkd parambgkd)
  {
    int i;
    WebSocketProxy localWebSocketProxy;
    try
    {
      Object localObject3 = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString);
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
              callbackOK(parambgkd, null, "closeSocket");
            }
            localObject3 = bgki.a(parambgkd.jdField_a_of_type_JavaLangString, null).toString();
            return localObject3;
          }
          if (this.mIsMiniGame) {
            callbackFail(parambgkd, null, "do not have this socket ", "closeSocket");
          }
          localObject3 = bgki.a(parambgkd.jdField_a_of_type_JavaLangString, null, "do not have this socket ").toString();
          return localObject3;
        }
      }
      if (!"send".equals(localThrowable)) {
        break label766;
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("[mini] http.RequestJsPlugin", parambgkd.jdField_a_of_type_JavaLangString + " exception:", localThrowable);
      return bgki.b(parambgkd.jdField_a_of_type_JavaLangString, null).toString();
    }
    Object localObject8 = localObject4.optString("data", null);
    Object localObject7;
    if (localObject8 != null)
    {
      synchronized (this.lock)
      {
        if ((this.wsrequestMap == null) || (this.wsrequestMap.size() == 0)) {
          break label499;
        }
        Object localObject5 = (RequestJsPlugin.WebsocketRequestTask)this.wsrequestMap.get(Integer.valueOf(i));
        localWebSocketProxy = (WebSocketProxy)ProxyManager.get(WebSocketProxy.class);
        if ((localObject5 != null) && (localWebSocketProxy != null))
        {
          localWebSocketProxy.send(i, (String)localObject8);
          if (this.mIsMiniGame) {
            callbackOK(parambgkd, null, "sendSocketMessage");
          }
          localObject5 = bgki.a(parambgkd.jdField_a_of_type_JavaLangString, null).toString();
          return localObject5;
        }
      }
      QMLog.e("[mini] http.RequestJsPlugin", parambgkd.jdField_a_of_type_JavaLangString + " error, send msg:" + (String)localObject8 + " on null socket instance");
      if (this.mIsMiniGame) {
        callbackFail(parambgkd, null, "socket is null ", "sendSocketMessage");
      }
      localObject7 = bgki.a(parambgkd.jdField_a_of_type_JavaLangString, null, "socket is null ").toString();
      return localObject7;
      label499:
      if (this.mIsMiniGame) {
        callbackFail(parambgkd, null, "do not have this socket ", "closeSocket");
      }
      localObject7 = bgki.a(parambgkd.jdField_a_of_type_JavaLangString, null, "do not have this socket ").toString();
      return localObject7;
    }
    if (bglb.a((JSONObject)localObject7))
    {
      ??? = bglb.a(this.mMiniAppContext, (JSONObject)localObject7, "data");
      if ((??? != null) && (((bglb)???).a != null) && (this.wsrequestMap != null) && (this.wsrequestMap.size() != 0))
      {
        localObject7 = (RequestJsPlugin.WebsocketRequestTask)this.wsrequestMap.get(Integer.valueOf(i));
        localObject8 = (WebSocketProxy)ProxyManager.get(WebSocketProxy.class);
        if ((localObject7 != null) && (localObject8 != null))
        {
          ((WebSocketProxy)localObject8).send(i, ((bglb)???).a);
          if (this.mIsMiniGame) {
            callbackOK(parambgkd, null);
          }
          return bgki.a(parambgkd.jdField_a_of_type_JavaLangString, null).toString();
        }
        QMLog.e("[mini] http.RequestJsPlugin", parambgkd.jdField_a_of_type_JavaLangString + " error, send NativeBuffer on null socket instance");
        if (this.mIsMiniGame) {
          callbackFail(parambgkd, null, "socket is null ", "sendSocketMessage");
        }
        return bgki.a(parambgkd.jdField_a_of_type_JavaLangString, null, "socket is null ").toString();
      }
      if (this.mIsMiniGame) {
        callbackFail(parambgkd, null, "do not have this socket ", "closeSocket");
      }
      ??? = bgki.a(parambgkd.jdField_a_of_type_JavaLangString, null, "do not have this socket ").toString();
      return ???;
    }
    label766:
    return "";
  }
  
  public String wnsCgiRequest(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject2 = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString);
      JSONObject localJSONObject1 = localJSONObject2.optJSONObject("header");
      Object localObject = localJSONObject1;
      if (localJSONObject1 == null) {
        localObject = new JSONObject();
      }
      ((JSONObject)localObject).put("Referer", getRequestReferer());
      localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (localObject != null)
      {
        ((ChannelProxy)localObject).wnsCgiRequest(localJSONObject2, new RequestJsPlugin.4(this, parambgkd));
        return "";
      }
      if (this.mIsMiniGame) {
        callbackFail(parambgkd, null, "do not support wnsCgiRequest");
      }
      localObject = bgki.a(parambgkd.jdField_a_of_type_JavaLangString, null, "do not support wnsCgiRequest").toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("[mini] http.RequestJsPlugin", parambgkd.jdField_a_of_type_JavaLangString + " exception:", localThrowable);
    }
    return bgki.b(parambgkd.jdField_a_of_type_JavaLangString, null).toString();
  }
  
  public String wnsRequest(bgkd parambgkd)
  {
    try
    {
      JSONObject localJSONObject2 = new JSONObject(parambgkd.jdField_b_of_type_JavaLangString);
      JSONObject localJSONObject1 = localJSONObject2.optJSONObject("header");
      Object localObject = localJSONObject1;
      if (localJSONObject1 == null) {
        localObject = new JSONObject();
      }
      ((JSONObject)localObject).put("Referer", getRequestReferer());
      localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (localObject != null)
      {
        ((ChannelProxy)localObject).wnsCgiRequest(localJSONObject2, new RequestJsPlugin.3(this, parambgkd));
        return "";
      }
      if (this.mIsMiniGame) {
        callbackFail(parambgkd, null, "do not support wnsRequest");
      }
      localObject = bgki.a(parambgkd.jdField_a_of_type_JavaLangString, null, "do not support wnsRequest").toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("[mini] http.RequestJsPlugin", parambgkd.jdField_a_of_type_JavaLangString + " exception:", localThrowable);
    }
    return bgki.b(parambgkd.jdField_a_of_type_JavaLangString, null).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.RequestJsPlugin
 * JD-Core Version:    0.7.0.1
 */