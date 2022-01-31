package com.tencent.qqmini.sdk.core.plugins;

import android.net.Uri;
import android.text.TextUtils;
import begy;
import bejy;
import beka;
import bekg;
import beks;
import beku;
import bequ;
import berj;
import besl;
import beyr;
import bffv;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.core.proxy.WebSocketProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
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
  
  private void callback(beka parambeka, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    if (parambeka != null)
    {
      if (paramString3 != null)
      {
        paramJSONObject = beks.a(paramJSONObject, "errMsg", paramString3).toString();
        parambeka.a(paramJSONObject);
        if (!"fail".equals(paramString1)) {
          break label137;
        }
        besl.d("[mini] http.RequestJsPlugin", "[callbackFail] " + paramJSONObject);
      }
    }
    else {
      return;
    }
    paramString3 = new StringBuilder().append(parambeka.jdField_a_of_type_JavaLangString).append(":").append(paramString1);
    if (TextUtils.isEmpty(paramString2)) {}
    for (paramString2 = "";; paramString2 = " " + paramString2)
    {
      paramString3 = paramString2;
      break;
    }
    label137:
    besl.b("[mini] http.RequestJsPlugin", "[callback] " + paramJSONObject);
  }
  
  private void callbackComplete(beka parambeka, JSONObject paramJSONObject)
  {
    callback(parambeka, paramJSONObject, "complete", null, null);
  }
  
  private void callbackFail(beka parambeka, JSONObject paramJSONObject)
  {
    callback(parambeka, paramJSONObject, "fail", null, null);
  }
  
  private void callbackFail(beka parambeka, JSONObject paramJSONObject, String paramString)
  {
    callback(parambeka, paramJSONObject, "fail", paramString, null);
  }
  
  private void callbackFail(beka parambeka, JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    callback(parambeka, paramJSONObject, "fail", paramString1, null);
  }
  
  private void callbackOK(beka parambeka, JSONObject paramJSONObject)
  {
    callback(parambeka, paramJSONObject, "ok", null, null);
  }
  
  private void callbackOK(beka parambeka, JSONObject paramJSONObject, String paramString)
  {
    callback(parambeka, paramJSONObject, "ok", null, paramString);
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
  
  private void onCloseCallback(beka parambeka, int paramInt1, String paramString, int paramInt2)
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("socketTaskId", paramInt2);
      ((JSONObject)localObject).put("state", "close");
      ((JSONObject)localObject).put("code", paramInt1);
      ((JSONObject)localObject).put("reason", paramString);
      parambeka.jdField_a_of_type_Begy.a("onSocketTaskStateChange", ((JSONObject)localObject).toString(), 0);
      parambeka = (RequestJsPlugin.WebsocketRequestTask)this.wsrequestMap.get(Integer.valueOf(paramInt2));
      paramString = this.mMiniAppInfo;
      localObject = beyr.a(this.mMiniAppInfo);
      if (parambeka != null) {}
      for (parambeka = parambeka.mUrl;; parambeka = null)
      {
        beyr.a(paramString, 633, null, null, null, 0, (String)localObject, 0L, getSecondLevelDomain(parambeka));
        return;
      }
      return;
    }
    catch (JSONException parambeka)
    {
      besl.d("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onClose exception:", parambeka);
    }
  }
  
  public String createRequestTask(beka parambeka)
  {
    boolean bool;
    String str2;
    try
    {
      try
      {
        Object localObject1 = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
        bool = ((JSONObject)localObject1).optBoolean("__skipDomainCheck__", false);
        localObject1 = new RequestJsPlugin.RequestTask(this, (JSONObject)localObject1);
        str2 = ((RequestJsPlugin.RequestTask)localObject1).mUrl;
        if ((((RequestJsPlugin.RequestTask)localObject1).mMethod != null) && (!supportMethod.contains(((RequestJsPlugin.RequestTask)localObject1).mMethod.toUpperCase())))
        {
          if (!this.mIsMiniGame) {
            callbackFail(parambeka, null, "request protocol error");
          }
          localObject1 = bekg.a("createRequest", null, "request protocol error").toString();
          return localObject1;
        }
        if ((!TextUtils.isEmpty(str2)) && ((str2.startsWith("https://")) || (str2.startsWith("http://")))) {
          break label207;
        }
        if (!this.mIsMiniGame) {
          callbackFail(parambeka, null, "url is invalid");
        }
        localObject1 = bekg.a("createRequest", null, "url is invalid").toString();
        return localObject1;
      }
      finally {}
      return "";
    }
    catch (Throwable localThrowable1)
    {
      besl.d("[mini] http.RequestJsPlugin", parambeka.jdField_a_of_type_JavaLangString + " exception:", localThrowable1);
      callbackFail(parambeka, null, "createRequest");
    }
    for (;;)
    {
      label207:
      String str1;
      if (!bffv.a(this.mMiniAppInfo, bool, str2, 0))
      {
        besl.c("[mini] http.RequestJsPlugin", "check request DomainValid fail, callbackFail, event:" + parambeka.jdField_a_of_type_JavaLangString + ", callbackId:" + parambeka.jdField_b_of_type_Int + ", url:" + str2);
        if (!this.mIsMiniGame) {
          callbackFail(parambeka, null, "url not in domain list, 请求域名不合法");
        }
        str1 = bekg.a("createRequest", null, "url not in domain list, 请求域名不合法").toString();
        return str1;
      }
      this.requestMap.put(Integer.valueOf(str1.mTaskId), str1);
      try
      {
        JSONObject localJSONObject = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
        localJSONObject.put("requestTaskId", str1.mTaskId);
        if (this.requestMap.size() > 200)
        {
          besl.a("[mini] http.RequestJsPlugin", "[httpRequest] too much request");
          if (!this.mIsMiniGame) {
            callbackFail(parambeka, localJSONObject);
          }
          str1 = bekg.b(parambeka.jdField_a_of_type_JavaLangString, localJSONObject).toString();
          return str1;
        }
        RequestProxy localRequestProxy = (RequestProxy)ProxyManager.get(RequestProxy.class);
        if (localRequestProxy == null)
        {
          besl.a("[mini] http.RequestJsPlugin", "[httpRequest] too much request");
          if (!this.mIsMiniGame) {
            callbackFail(parambeka, localJSONObject);
          }
          str1 = bekg.b(parambeka.jdField_a_of_type_JavaLangString, localJSONObject).toString();
          return str1;
        }
        if (localRequestProxy.request(str1.mUrl, str1.mBody, str1.mHeaders, str1.mMethod, 60, new RequestJsPlugin.1(this, str2, str1, parambeka)))
        {
          if (!this.mIsMiniGame) {
            callbackOK(parambeka, localJSONObject);
          }
          str1 = bekg.a(parambeka.jdField_a_of_type_JavaLangString, localJSONObject).toString();
          return str1;
        }
      }
      catch (Throwable localThrowable2)
      {
        besl.d("[mini] http.RequestJsPlugin", "", localThrowable2);
      }
    }
  }
  
  public String createSocketTask(beka parambeka)
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
          besl.c("[mini] http.RequestJsPlugin", "not support web socket right now");
          callbackFail(parambeka, null, "not support web socket right now");
          return "";
        }
        localObject3 = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
        boolean bool = ((JSONObject)localObject3).optBoolean("__skipDomainCheck__", false);
        j = this.mApkgInfo.a().a.jdField_b_of_type_Int;
        localObject3 = new RequestJsPlugin.WebsocketRequestTask(this, (JSONObject)localObject3);
        if (!bffv.a(this.mMiniAppInfo, bool, ((RequestJsPlugin.WebsocketRequestTask)localObject3).mUrl, 1))
        {
          besl.c("[mini] http.RequestJsPlugin", "check socket DomainValid fail, callbackFail, event:" + parambeka.jdField_a_of_type_JavaLangString + ", callbackId:" + parambeka.jdField_b_of_type_Int + ", url:" + ((RequestJsPlugin.WebsocketRequestTask)localObject3).mUrl);
          callbackFail(parambeka, null, "请求域名不合法");
          return "";
        }
      }
      try
      {
        parambeka = new RequestJsPlugin.WebsocketRequestTask(this, new JSONObject(parambeka.jdField_b_of_type_JavaLangString)).mUrl;
        beyr.a(this.mMiniAppInfo, 632, null, null, null, 1, beyr.a(this.mMiniAppInfo), 0L, getSecondLevelDomain(parambeka));
        return "";
        int i = j;
        if (((RequestJsPlugin.WebsocketRequestTask)localObject3).mTimeout > j) {
          i = ((RequestJsPlugin.WebsocketRequestTask)localObject3).mTimeout;
        }
        localObject1.connectSocket(((RequestJsPlugin.WebsocketRequestTask)localObject3).mTaskId, ((RequestJsPlugin.WebsocketRequestTask)localObject3).mUrl, ((RequestJsPlugin.WebsocketRequestTask)localObject3).mHeaders, ((RequestJsPlugin.WebsocketRequestTask)localObject3).mMethod, i, new RequestJsPlugin.2(this, parambeka, (RequestJsPlugin.WebsocketRequestTask)localObject3));
        this.wsrequestMap.put(Integer.valueOf(((RequestJsPlugin.WebsocketRequestTask)localObject3).mTaskId), localObject3);
        Object localObject2 = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
        ((JSONObject)localObject2).put("socketTaskId", ((RequestJsPlugin.WebsocketRequestTask)localObject3).mTaskId);
        ((JSONObject)localObject2).put("errMsg", parambeka.jdField_a_of_type_JavaLangString + ":ok");
        callbackOK(parambeka, (JSONObject)localObject2);
        localObject2 = ((JSONObject)localObject2).toString();
        return localObject2;
      }
      catch (JSONException parambeka)
      {
        for (;;)
        {
          besl.d("[mini] http.RequestJsPlugin", "handleNativeRequest ", parambeka);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      besl.d("[mini] http.RequestJsPlugin", parambeka.jdField_a_of_type_JavaLangString + " exception:", localThrowable);
      callbackFail(parambeka, null);
    }
  }
  
  public String operateRequestTask(beka parambeka)
  {
    try
    {
      Object localObject = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
      int i = ((JSONObject)localObject).optInt("requestTaskId");
      localObject = ((JSONObject)localObject).optString("operationType");
      if (this.requestMap.containsKey(Integer.valueOf(i)))
      {
        RequestJsPlugin.RequestTask localRequestTask = (RequestJsPlugin.RequestTask)this.requestMap.remove(Integer.valueOf(i));
        if ((localRequestTask != null) && ("abort".equals(localObject)))
        {
          ((RequestProxy)ProxyManager.get(RequestProxy.class)).abort(localRequestTask.mUrl);
          if (!this.mIsMiniGame) {
            callbackOK(parambeka, null);
          }
        }
      }
    }
    catch (Exception parambeka)
    {
      for (;;)
      {
        besl.d("[mini] http.RequestJsPlugin", "OPERATE_REQUEST_TASK : " + parambeka);
      }
    }
    return "";
  }
  
  public String operateSocketTask(beka parambeka)
  {
    int i;
    WebSocketProxy localWebSocketProxy;
    try
    {
      Object localObject3 = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
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
              callbackOK(parambeka, null, "closeSocket");
            }
            localObject3 = bekg.a(parambeka.jdField_a_of_type_JavaLangString, null).toString();
            return localObject3;
          }
          if (this.mIsMiniGame) {
            callbackFail(parambeka, null, "do not have this socket ", "closeSocket");
          }
          localObject3 = bekg.a(parambeka.jdField_a_of_type_JavaLangString, null, "do not have this socket ").toString();
          return localObject3;
        }
      }
      if (!"send".equals(localThrowable)) {
        break label766;
      }
    }
    catch (Throwable localThrowable)
    {
      besl.d("[mini] http.RequestJsPlugin", parambeka.jdField_a_of_type_JavaLangString + " exception:", localThrowable);
      return bekg.b(parambeka.jdField_a_of_type_JavaLangString, null).toString();
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
            callbackOK(parambeka, null, "sendSocketMessage");
          }
          localObject5 = bekg.a(parambeka.jdField_a_of_type_JavaLangString, null).toString();
          return localObject5;
        }
      }
      besl.d("[mini] http.RequestJsPlugin", parambeka.jdField_a_of_type_JavaLangString + " error, send msg:" + (String)localObject8 + " on null socket instance");
      if (this.mIsMiniGame) {
        callbackFail(parambeka, null, "socket is null ", "sendSocketMessage");
      }
      localObject7 = bekg.a(parambeka.jdField_a_of_type_JavaLangString, null, "socket is null ").toString();
      return localObject7;
      label499:
      if (this.mIsMiniGame) {
        callbackFail(parambeka, null, "do not have this socket ", "closeSocket");
      }
      localObject7 = bekg.a(parambeka.jdField_a_of_type_JavaLangString, null, "do not have this socket ").toString();
      return localObject7;
    }
    if (beku.a((JSONObject)localObject7))
    {
      ??? = beku.a(this.mMiniAppContext, (JSONObject)localObject7, "data");
      if ((??? != null) && (((beku)???).a != null) && (this.wsrequestMap != null) && (this.wsrequestMap.size() != 0))
      {
        localObject7 = (RequestJsPlugin.WebsocketRequestTask)this.wsrequestMap.get(Integer.valueOf(i));
        localObject8 = (WebSocketProxy)ProxyManager.get(WebSocketProxy.class);
        if ((localObject7 != null) && (localObject8 != null))
        {
          ((WebSocketProxy)localObject8).send(i, ((beku)???).a);
          if (this.mIsMiniGame) {
            callbackOK(parambeka, null);
          }
          return bekg.a(parambeka.jdField_a_of_type_JavaLangString, null).toString();
        }
        besl.d("[mini] http.RequestJsPlugin", parambeka.jdField_a_of_type_JavaLangString + " error, send NativeBuffer on null socket instance");
        if (this.mIsMiniGame) {
          callbackFail(parambeka, null, "socket is null ", "sendSocketMessage");
        }
        return bekg.a(parambeka.jdField_a_of_type_JavaLangString, null, "socket is null ").toString();
      }
      if (this.mIsMiniGame) {
        callbackFail(parambeka, null, "do not have this socket ", "closeSocket");
      }
      ??? = bekg.a(parambeka.jdField_a_of_type_JavaLangString, null, "do not have this socket ").toString();
      return ???;
    }
    label766:
    return "";
  }
  
  public String wnsCgiRequest(beka parambeka)
  {
    try
    {
      JSONObject localJSONObject2 = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
      JSONObject localJSONObject1 = localJSONObject2.optJSONObject("header");
      Object localObject = localJSONObject1;
      if (localJSONObject1 == null) {
        localObject = new JSONObject();
      }
      ((JSONObject)localObject).put("Referer", getRequestReferer());
      localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (localObject != null)
      {
        ((ChannelProxy)localObject).wnsCgiRequest(localJSONObject2, new RequestJsPlugin.4(this, parambeka));
        return "";
      }
      if (this.mIsMiniGame) {
        callbackFail(parambeka, null, "do not support wnsCgiRequest");
      }
      localObject = bekg.a(parambeka.jdField_a_of_type_JavaLangString, null, "do not support wnsCgiRequest").toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      besl.d("[mini] http.RequestJsPlugin", parambeka.jdField_a_of_type_JavaLangString + " exception:", localThrowable);
    }
    return bekg.b(parambeka.jdField_a_of_type_JavaLangString, null).toString();
  }
  
  public String wnsRequest(beka parambeka)
  {
    try
    {
      JSONObject localJSONObject2 = new JSONObject(parambeka.jdField_b_of_type_JavaLangString);
      JSONObject localJSONObject1 = localJSONObject2.optJSONObject("header");
      Object localObject = localJSONObject1;
      if (localJSONObject1 == null) {
        localObject = new JSONObject();
      }
      ((JSONObject)localObject).put("Referer", getRequestReferer());
      localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (localObject != null)
      {
        ((ChannelProxy)localObject).wnsCgiRequest(localJSONObject2, new RequestJsPlugin.3(this, parambeka));
        return "";
      }
      if (this.mIsMiniGame) {
        callbackFail(parambeka, null, "do not support wnsRequest");
      }
      localObject = bekg.a(parambeka.jdField_a_of_type_JavaLangString, null, "do not support wnsRequest").toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      besl.d("[mini] http.RequestJsPlugin", parambeka.jdField_a_of_type_JavaLangString + " exception:", localThrowable);
    }
    return bekg.b(parambeka.jdField_a_of_type_JavaLangString, null).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.RequestJsPlugin
 * JD-Core Version:    0.7.0.1
 */