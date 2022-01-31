package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import bbev;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.ws.WebSocket;
import com.squareup.okhttp.ws.WebSocketListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.NativeBuffer;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import okio.Buffer;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestPlugin$MiniAppWebsocketListener
  implements WebSocketListener
{
  public int currSocketId;
  private boolean socketClosedCallbacked;
  public WebSocket webSocket;
  
  public RequestPlugin$MiniAppWebsocketListener(RequestPlugin paramRequestPlugin) {}
  
  public void onActivelyClose(int paramInt, String paramString)
  {
    if (this.socketClosedCallbacked)
    {
      QLog.d("[mini] http.RequestPlugin", 1, "onClose has been called, return. ");
      return;
    }
    QLog.d("[mini] http.RequestPlugin", 1, "---onActivelyClose---" + paramString);
    this.socketClosedCallbacked = true;
    RequestPlugin.access$300(this.this$0, paramInt, paramString, this.currSocketId);
  }
  
  public void onClose(int paramInt, String paramString)
  {
    QLog.d("[mini] http.RequestPlugin", 1, "---onClosed---" + paramString);
    this.socketClosedCallbacked = true;
    RequestPlugin.access$300(this.this$0, paramInt, paramString, this.currSocketId);
  }
  
  public void onFailure(IOException paramIOException, Response paramResponse)
  {
    Object localObject2 = null;
    QLog.e("[mini] http.RequestPlugin", 1, "MiniAppWebsocketListener onFailure, socketId=" + this.currSocketId, paramIOException);
    if (paramIOException != null) {}
    int i;
    Object localObject4;
    try
    {
      if ((paramIOException.getMessage() != null) && ((paramIOException.getMessage().equals("SSL handshake timed out")) || (paramIOException.getMessage().equals("timeout"))))
      {
        QLog.e("[mini] http.RequestPlugin", 1, "MiniAppWebsocketListener onFailure , timeout , send close state. socketId=" + this.currSocketId);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("socketTaskId", this.currSocketId);
        ((JSONObject)localObject1).put("state", "close");
        if (paramResponse == null)
        {
          i = 600;
          ((JSONObject)localObject1).put("statusCode", i);
          if (RequestPlugin.access$000(this.this$0) != null) {
            RequestPlugin.access$000(this.this$0).evaluateSubcribeJS("onSocketTaskStateChange", ((JSONObject)localObject1).toString(), 0);
          }
        }
      }
      for (;;)
      {
        if ((this.this$0.jsPluginEngine == null) || (this.this$0.jsPluginEngine.appBrandRuntime == null) || (this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo() == null) || (this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig == null)) {
          return;
        }
        Object localObject3 = this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig;
        localObject4 = MiniReportManager.getAppType(this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig);
        localObject1 = localObject2;
        if (paramResponse != null)
        {
          localObject1 = localObject2;
          if (paramResponse.request() != null) {
            localObject1 = paramResponse.request().urlString();
          }
        }
        MiniReportManager.reportEventType((MiniAppConfig)localObject3, 634, null, null, null, 0, (String)localObject4, 0L, RequestPlugin.access$100((String)localObject1));
        return;
        i = paramResponse.code();
        break;
        localObject3 = new JSONObject();
        ((JSONObject)localObject3).put("socketTaskId", this.currSocketId);
        ((JSONObject)localObject3).put("state", "error");
        if ((bbev.b(BaseApplicationImpl.getContext()) != 0) && (bbev.b(BaseApplicationImpl.getContext()) != -1)) {
          break label473;
        }
        localObject1 = "network is down";
        ((JSONObject)localObject3).put("errMsg", "network is down");
        QLog.e("[mini] http.RequestPlugin", 1, "MiniAppWebsocketListener onFailure socketId=" + this.currSocketId + " errMsg=" + (String)localObject1);
        if (RequestPlugin.access$000(this.this$0) != null) {
          RequestPlugin.access$000(this.this$0).evaluateSubcribeJS("onSocketTaskStateChange", ((JSONObject)localObject3).toString(), 0);
        }
      }
      localObject4 = new StringBuilder().append("resposeCode=");
    }
    catch (JSONException paramResponse)
    {
      QLog.e("[mini] http.RequestPlugin", 1, "MiniAppWebsocketListener onFailure exception:", paramIOException);
      return;
    }
    label473:
    if (paramResponse == null) {}
    for (Object localObject1 = "-1";; localObject1 = Integer.valueOf(i))
    {
      localObject1 = localObject1;
      break;
      i = paramResponse.code();
    }
  }
  
  public void onMessage(ResponseBody paramResponseBody)
  {
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("socketTaskId", this.currSocketId);
        localJSONObject.put("state", "message");
        localJSONObject.put("errMsg", "ok");
        MediaType localMediaType = paramResponseBody.contentType();
        if ((localMediaType != null) && (localMediaType.subtype().equals("vnd.okhttp.websocket+binary")))
        {
          localJSONObject.put("isBuffer", true);
          if (this.this$0.isGameRuntime)
          {
            NativeBuffer.packNativeBuffer(paramResponseBody.bytes(), NativeBuffer.TYPE_BUFFER_NATIVE, "data", localJSONObject, RequestPlugin.access$200(this.this$0).getNativeBufferPool());
            if (RequestPlugin.access$000(this.this$0) == null) {
              break;
            }
            RequestPlugin.access$000(this.this$0).evaluateSubcribeJS("onSocketTaskStateChange", localJSONObject.toString(), 0);
            return;
          }
          NativeBuffer.packNativeBuffer(paramResponseBody.bytes(), NativeBuffer.TYPE_BUFFER_BASE64, "data", localJSONObject, RequestPlugin.access$200(this.this$0).getNativeBufferPool());
          continue;
        }
        localJSONObject.put("isBuffer", false);
      }
      catch (JSONException paramResponseBody)
      {
        paramResponseBody = paramResponseBody;
        QLog.e("[mini] http.RequestPlugin", 1, "MiniAppWebsocketListener onMessage exception:", paramResponseBody);
        return;
      }
      finally {}
      localJSONObject.put("data", paramResponseBody.string());
    }
  }
  
  public void onOpen(WebSocket paramWebSocket, Response paramResponse)
  {
    Object localObject = null;
    this.webSocket = paramWebSocket;
    try
    {
      paramWebSocket = new JSONObject();
      paramWebSocket.put("socketTaskId", this.currSocketId);
      paramWebSocket.put("state", "open");
      paramWebSocket.put("statusCode", paramResponse.code());
      paramWebSocket.put("header", JSONUtil.headerToJson(paramResponse.headers().toMultimap()));
      if (RequestPlugin.access$000(this.this$0) != null) {
        RequestPlugin.access$000(this.this$0).evaluateSubcribeJS("onSocketTaskStateChange", paramWebSocket.toString(), 0);
      }
      if ((this.this$0.jsPluginEngine != null) && (this.this$0.jsPluginEngine.appBrandRuntime != null) && (this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo() != null) && (this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig != null))
      {
        MiniAppConfig localMiniAppConfig = this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig;
        String str = MiniReportManager.getAppType(this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig);
        paramWebSocket = localObject;
        if (paramResponse.request() != null) {
          paramWebSocket = paramResponse.request().urlString();
        }
        MiniReportManager.reportEventType(localMiniAppConfig, 632, null, null, null, 0, str, 0L, RequestPlugin.access$100(paramWebSocket));
      }
      return;
    }
    catch (JSONException paramWebSocket)
    {
      QLog.e("[mini] http.RequestPlugin", 1, "MiniAppWebsocketListener onOpen error:", paramWebSocket);
    }
  }
  
  public void onPong(Buffer paramBuffer) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RequestPlugin.MiniAppWebsocketListener
 * JD-Core Version:    0.7.0.1
 */