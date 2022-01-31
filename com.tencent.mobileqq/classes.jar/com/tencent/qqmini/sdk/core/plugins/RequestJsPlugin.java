package com.tencent.qqmini.sdk.core.plugins;

import android.net.Uri;
import android.text.TextUtils;
import bdcy;
import bdcz;
import bdfx;
import bdfz;
import bdgg;
import bdgq;
import bdgr;
import bdml;
import bdmz;
import bdnw;
import bdsu;
import bdyo;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.RequestProxy;
import com.tencent.qqmini.sdk.core.proxy.WebSocketProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
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
  protected boolean isGameRuntime;
  private byte[] lock = new byte[0];
  private bdcz mMiniAPpContext;
  private ConcurrentHashMap<Integer, RequestJsPlugin.RequestTask> requestMap = new ConcurrentHashMap();
  private boolean socketClosedCallbacked;
  private ConcurrentHashMap<Integer, RequestJsPlugin.WebsocketRequestTask> wsrequestMap = new ConcurrentHashMap();
  
  private void callback(bdfz parambdfz, JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    if (parambdfz != null)
    {
      if (paramString3 != null)
      {
        paramJSONObject = bdgq.a(paramJSONObject, "errMsg", paramString3).toString();
        parambdfz.a(paramJSONObject);
        if (!"fail".equals(paramString1)) {
          break label137;
        }
        bdnw.d("[mini] http.RequestJsPlugin", "[callbackFail] " + paramJSONObject);
      }
    }
    else {
      return;
    }
    paramString3 = new StringBuilder().append(parambdfz.jdField_a_of_type_JavaLangString).append(":").append(paramString1);
    if (TextUtils.isEmpty(paramString2)) {}
    for (paramString2 = "";; paramString2 = " " + paramString2)
    {
      paramString3 = paramString2;
      break;
    }
    label137:
    bdnw.b("[mini] http.RequestJsPlugin", "[callback] " + paramJSONObject);
  }
  
  private void callbackComplete(bdfz parambdfz, JSONObject paramJSONObject)
  {
    callback(parambdfz, paramJSONObject, "complete", null, null);
  }
  
  private void callbackFail(bdfz parambdfz, JSONObject paramJSONObject)
  {
    callback(parambdfz, paramJSONObject, "fail", null, null);
  }
  
  private void callbackFail(bdfz parambdfz, JSONObject paramJSONObject, String paramString)
  {
    callback(parambdfz, paramJSONObject, "fail", paramString, null);
  }
  
  private void callbackFail(bdfz parambdfz, JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    callback(parambdfz, paramJSONObject, "fail", paramString1, null);
  }
  
  private void callbackOK(bdfz parambdfz, JSONObject paramJSONObject)
  {
    callback(parambdfz, paramJSONObject, "ok", null, null);
  }
  
  private void callbackOK(bdfz parambdfz, JSONObject paramJSONObject, String paramString)
  {
    callback(parambdfz, paramJSONObject, "ok", null, paramString);
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
  
  private void onCloseCallback(bdfz parambdfz, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("socketTaskId", paramInt2);
      localJSONObject.put("state", "close");
      localJSONObject.put("code", paramInt1);
      localJSONObject.put("reason", paramString1);
      parambdfz.jdField_a_of_type_Bdcy.a("onSocketTaskStateChange", localJSONObject.toString(), 0);
      if (this.mMiniAppContext != null) {}
      for (parambdfz = this.mMiniAppContext.a();; parambdfz = null)
      {
        if (parambdfz != null) {
          bdsu.a(parambdfz, 633, null, null, null, 0, bdsu.a(parambdfz), 0L, getSecondLevelDomain(paramString2));
        }
        return;
      }
      return;
    }
    catch (JSONException parambdfz)
    {
      bdnw.d("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onClose exception:", parambdfz);
    }
  }
  
  public String createRequestTask(bdfz parambdfz)
  {
    boolean bool;
    String str2;
    try
    {
      try
      {
        Object localObject1 = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
        bool = ((JSONObject)localObject1).optBoolean("__skipDomainCheck__", false);
        localObject1 = new RequestJsPlugin.RequestTask(this, (JSONObject)localObject1);
        str2 = ((RequestJsPlugin.RequestTask)localObject1).mUrl;
        if ((((RequestJsPlugin.RequestTask)localObject1).mMethod != null) && ("CONNECT".equals(((RequestJsPlugin.RequestTask)localObject1).mMethod.toUpperCase())))
        {
          if (!this.isGameRuntime) {
            callbackFail(parambdfz, null, "CONNECT method is no support");
          }
          localObject1 = bdgg.a("createRequest", null, "CONNECT method is no support").toString();
          return localObject1;
        }
        if ((!TextUtils.isEmpty(str2)) && ((str2.startsWith("https://")) || (str2.startsWith("http://")))) {
          break label207;
        }
        if (!this.isGameRuntime) {
          callbackFail(parambdfz, null, "url is invalid");
        }
        localObject1 = bdgg.a("createRequest", null, "url is invalid").toString();
        return localObject1;
      }
      finally {}
      return "";
    }
    catch (Throwable localThrowable1)
    {
      bdnw.d("[mini] http.RequestJsPlugin", parambdfz.jdField_a_of_type_JavaLangString + " exception:", localThrowable1);
      callbackFail(parambdfz, null, "createRequest");
    }
    for (;;)
    {
      label207:
      String str1;
      if (!bdyo.a(this.mMiniAppInfo, bool, str2, 0))
      {
        bdnw.c("[mini] http.RequestJsPlugin", "check request DomainValid fail, callbackFail, event:" + parambdfz.jdField_a_of_type_JavaLangString + ", callbackId:" + parambdfz.jdField_b_of_type_Int + ", url:" + str2);
        if (!this.isGameRuntime) {
          callbackFail(parambdfz, null, "url not in domain list, 请求域名不合法");
        }
        str1 = bdgg.a("createRequest", null, "url not in domain list, 请求域名不合法").toString();
        return str1;
      }
      this.requestMap.put(Integer.valueOf(str1.mTaskId), str1);
      try
      {
        JSONObject localJSONObject = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
        localJSONObject.put("requestTaskId", str1.mTaskId);
        if (this.requestMap.size() > 200)
        {
          bdnw.a("[mini] http.RequestJsPlugin", "[httpRequest] too much request");
          if (!this.isGameRuntime) {
            callbackFail(parambdfz, localJSONObject);
          }
          str1 = bdgg.b(parambdfz.jdField_a_of_type_JavaLangString, localJSONObject).toString();
          return str1;
        }
        RequestProxy localRequestProxy = (RequestProxy)ProxyManager.get(RequestProxy.class);
        if (localRequestProxy == null)
        {
          bdnw.a("[mini] http.RequestJsPlugin", "[httpRequest] too much request");
          if (!this.isGameRuntime) {
            callbackFail(parambdfz, localJSONObject);
          }
          str1 = bdgg.b(parambdfz.jdField_a_of_type_JavaLangString, localJSONObject).toString();
          return str1;
        }
        if (localRequestProxy.request(str1.mUrl, str1.mBody, str1.mHeaders, str1.mMethod, 60, new RequestJsPlugin.1(this, str2, str1, parambdfz)))
        {
          if (!this.isGameRuntime) {
            callbackOK(parambdfz, localJSONObject);
          }
          str1 = bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, localJSONObject).toString();
          return str1;
        }
      }
      catch (Throwable localThrowable2)
      {
        bdnw.d("[mini] http.RequestJsPlugin", "", localThrowable2);
      }
    }
  }
  
  public String createSocketTask(bdfz parambdfz)
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
          bdnw.c("[mini] http.RequestJsPlugin", "not support web socket right now");
          callbackFail(parambdfz, null, "not support web socket right now");
          return "";
        }
        localObject3 = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
        boolean bool = ((JSONObject)localObject3).optBoolean("__skipDomainCheck__", false);
        j = this.mApkgInfo.a().a.jdField_b_of_type_Int;
        localObject3 = new RequestJsPlugin.WebsocketRequestTask(this, (JSONObject)localObject3);
        if (!bdyo.a(this.mMiniAppInfo, bool, ((RequestJsPlugin.WebsocketRequestTask)localObject3).mUrl, 1))
        {
          bdnw.c("[mini] http.RequestJsPlugin", "check socket DomainValid fail, callbackFail, event:" + parambdfz.jdField_a_of_type_JavaLangString + ", callbackId:" + parambdfz.jdField_b_of_type_Int + ", url:" + ((RequestJsPlugin.WebsocketRequestTask)localObject3).mUrl);
          callbackFail(parambdfz, null, "请求域名不合法");
          return "";
        }
      }
      try
      {
        if (this.mMiniAppContext != null)
        {
          localMiniAppInfo = this.mMiniAppContext.a();
          if (localMiniAppInfo != null)
          {
            parambdfz = new RequestJsPlugin.WebsocketRequestTask(this, new JSONObject(parambdfz.jdField_b_of_type_JavaLangString)).mUrl;
            bdsu.a(localMiniAppInfo, 632, null, null, null, 1, bdsu.a(localMiniAppInfo), 0L, getSecondLevelDomain(parambdfz));
          }
        }
      }
      catch (JSONException parambdfz)
      {
        for (;;)
        {
          bdnw.d("[mini] http.RequestJsPlugin", "handleNativeRequest ", parambdfz);
        }
      }
    }
    catch (Throwable localThrowable)
    {
      bdnw.d("[mini] http.RequestJsPlugin", parambdfz.jdField_a_of_type_JavaLangString + " exception:", localThrowable);
      callbackFail(parambdfz, null);
    }
    for (;;)
    {
      return "";
      int i = j;
      if (((RequestJsPlugin.WebsocketRequestTask)localObject3).mTimeout > j) {
        i = ((RequestJsPlugin.WebsocketRequestTask)localObject3).mTimeout;
      }
      localObject1.connectSocket(((RequestJsPlugin.WebsocketRequestTask)localObject3).mUrl, ((RequestJsPlugin.WebsocketRequestTask)localObject3).mHeaders, ((RequestJsPlugin.WebsocketRequestTask)localObject3).mMethod, i, new RequestJsPlugin.2(this, parambdfz, (RequestJsPlugin.WebsocketRequestTask)localObject3));
      this.wsrequestMap.put(Integer.valueOf(((RequestJsPlugin.WebsocketRequestTask)localObject3).mTaskId), localObject3);
      Object localObject2 = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      ((JSONObject)localObject2).put("socketTaskId", ((RequestJsPlugin.WebsocketRequestTask)localObject3).mTaskId);
      ((JSONObject)localObject2).put("errMsg", parambdfz.jdField_a_of_type_JavaLangString + ":ok");
      callbackOK(parambdfz, (JSONObject)localObject2);
      localObject2 = ((JSONObject)localObject2).toString();
      return localObject2;
      MiniAppInfo localMiniAppInfo = null;
    }
  }
  
  public void onCreate(bdcz parambdcz)
  {
    super.onCreate(parambdcz);
    this.mMiniAPpContext = parambdcz;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public String operateRequestTask(bdfz parambdfz)
  {
    try
    {
      Object localObject = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      int i = ((JSONObject)localObject).optInt("requestTaskId");
      localObject = ((JSONObject)localObject).optString("operationType");
      if (this.requestMap.containsKey(Integer.valueOf(i)))
      {
        RequestJsPlugin.RequestTask localRequestTask = (RequestJsPlugin.RequestTask)this.requestMap.remove(Integer.valueOf(i));
        if ((localRequestTask != null) && ("abort".equals(localObject)))
        {
          ((RequestProxy)ProxyManager.get(RequestProxy.class)).abort(localRequestTask.mUrl);
          if (!this.isGameRuntime) {
            callbackOK(parambdfz, null);
          }
        }
      }
    }
    catch (Exception parambdfz)
    {
      for (;;)
      {
        bdnw.d("[mini] http.RequestJsPlugin", "OPERATE_REQUEST_TASK : " + parambdfz);
      }
    }
    return "";
  }
  
  public String operateSocketTask(bdfz parambdfz)
  {
    int i;
    WebSocketProxy localWebSocketProxy;
    try
    {
      Object localObject3 = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      ??? = ((JSONObject)localObject3).optString("operationType");
      i = ((JSONObject)localObject3).optInt("socketTaskId");
      if ("close".equals(???)) {
        synchronized (this.lock)
        {
          if ((this.wsrequestMap != null) && (this.wsrequestMap.size() != 0))
          {
            localObject8 = (RequestJsPlugin.WebsocketRequestTask)this.wsrequestMap.get(Integer.valueOf(i));
            this.wsrequestMap.remove(Integer.valueOf(i));
            i = ((JSONObject)localObject3).optInt("code", 1000);
            localObject3 = ((JSONObject)localObject3).optString("reason", "Goodbye");
            localWebSocketProxy = (WebSocketProxy)ProxyManager.get(WebSocketProxy.class);
            if (localWebSocketProxy != null) {
              localWebSocketProxy.closeSocket(((RequestJsPlugin.WebsocketRequestTask)localObject8).mUrl, i, (String)localObject3);
            }
            if (this.isGameRuntime) {
              callbackOK(parambdfz, null, "closeSocket");
            }
            localObject3 = bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, null).toString();
            return localObject3;
          }
          if (this.isGameRuntime) {
            callbackFail(parambdfz, null, "do not have this socket ", "closeSocket");
          }
          localObject3 = bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, null, "do not have this socket ").toString();
          return localObject3;
        }
      }
      if (!"send".equals(localThrowable)) {
        break label751;
      }
    }
    catch (Throwable localThrowable)
    {
      bdnw.d("[mini] http.RequestJsPlugin", parambdfz.jdField_a_of_type_JavaLangString + " exception:", localThrowable);
      return bdgg.b(parambdfz.jdField_a_of_type_JavaLangString, null).toString();
    }
    Object localObject8 = localObject4.optString("data", null);
    Object localObject7;
    if (localObject8 != null)
    {
      synchronized (this.lock)
      {
        if ((this.wsrequestMap == null) || (this.wsrequestMap.size() == 0)) {
          break label487;
        }
        Object localObject5 = (RequestJsPlugin.WebsocketRequestTask)this.wsrequestMap.get(Integer.valueOf(i));
        localWebSocketProxy = (WebSocketProxy)ProxyManager.get(WebSocketProxy.class);
        if ((localObject5 != null) && (localWebSocketProxy != null))
        {
          localWebSocketProxy.send(((RequestJsPlugin.WebsocketRequestTask)localObject5).mUrl, (String)localObject8);
          if (this.isGameRuntime) {
            callbackOK(parambdfz, null, "sendSocketMessage");
          }
          localObject5 = bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, null).toString();
          return localObject5;
        }
      }
      bdnw.d("[mini] http.RequestJsPlugin", parambdfz.jdField_a_of_type_JavaLangString + " error, send msg:" + (String)localObject8 + " on null socket instance");
      if (this.isGameRuntime) {
        callbackFail(parambdfz, null, "socket is null ", "sendSocketMessage");
      }
      localObject7 = bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, null, "socket is null ").toString();
      return localObject7;
      label487:
      if (this.isGameRuntime) {
        callbackFail(parambdfz, null, "do not have this socket ", "closeSocket");
      }
      localObject7 = bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, null, "do not have this socket ").toString();
      return localObject7;
    }
    if (bdgr.a((JSONObject)localObject7))
    {
      ??? = bdgr.a(this.mMiniAppContext, (JSONObject)localObject7, "data");
      if ((??? != null) && (((bdgr)???).a != null) && (this.wsrequestMap != null) && (this.wsrequestMap.size() != 0))
      {
        localObject7 = (RequestJsPlugin.WebsocketRequestTask)this.wsrequestMap.get(Integer.valueOf(i));
        localObject8 = (WebSocketProxy)ProxyManager.get(WebSocketProxy.class);
        if ((localObject7 != null) && (localObject8 != null))
        {
          ((WebSocketProxy)localObject8).send(((RequestJsPlugin.WebsocketRequestTask)localObject7).mUrl, ((bdgr)???).a);
          if (this.isGameRuntime) {
            callbackOK(parambdfz, null);
          }
          return bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, null).toString();
        }
        bdnw.d("[mini] http.RequestJsPlugin", parambdfz.jdField_a_of_type_JavaLangString + " error, send NativeBuffer on null socket instance");
        if (this.isGameRuntime) {
          callbackFail(parambdfz, null, "socket is null ", "sendSocketMessage");
        }
        return bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, null, "socket is null ").toString();
      }
      if (this.isGameRuntime) {
        callbackFail(parambdfz, null, "do not have this socket ", "closeSocket");
      }
      ??? = bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, null, "do not have this socket ").toString();
      return ???;
    }
    label751:
    return "";
  }
  
  public String wnsCgiRequest(bdfz parambdfz)
  {
    try
    {
      JSONObject localJSONObject2 = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      JSONObject localJSONObject1 = localJSONObject2.optJSONObject("header");
      Object localObject = localJSONObject1;
      if (localJSONObject1 == null) {
        localObject = new JSONObject();
      }
      ((JSONObject)localObject).put("Referer", getRequestReferer());
      localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (localObject != null)
      {
        ((ChannelProxy)localObject).wnsCgiRequest(localJSONObject2, new RequestJsPlugin.4(this, parambdfz));
        return "";
      }
      if (this.isGameRuntime) {
        callbackFail(parambdfz, null, "do not support wnsCgiRequest");
      }
      localObject = bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, null, "do not support wnsCgiRequest").toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      bdnw.d("[mini] http.RequestJsPlugin", parambdfz.jdField_a_of_type_JavaLangString + " exception:", localThrowable);
    }
    return bdgg.b(parambdfz.jdField_a_of_type_JavaLangString, null).toString();
  }
  
  public String wnsRequest(bdfz parambdfz)
  {
    try
    {
      JSONObject localJSONObject2 = new JSONObject(parambdfz.jdField_b_of_type_JavaLangString);
      JSONObject localJSONObject1 = localJSONObject2.optJSONObject("header");
      Object localObject = localJSONObject1;
      if (localJSONObject1 == null) {
        localObject = new JSONObject();
      }
      ((JSONObject)localObject).put("Referer", getRequestReferer());
      localObject = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
      if (localObject != null)
      {
        ((ChannelProxy)localObject).wnsCgiRequest(localJSONObject2, new RequestJsPlugin.3(this, parambdfz));
        return "";
      }
      if (this.isGameRuntime) {
        callbackFail(parambdfz, null, "do not support wnsRequest");
      }
      localObject = bdgg.a(parambdfz.jdField_a_of_type_JavaLangString, null, "do not support wnsRequest").toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      bdnw.d("[mini] http.RequestJsPlugin", parambdfz.jdField_a_of_type_JavaLangString + " exception:", localThrowable);
    }
    return bdgg.b(parambdfz.jdField_a_of_type_JavaLangString, null).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.RequestJsPlugin
 * JD-Core Version:    0.7.0.1
 */