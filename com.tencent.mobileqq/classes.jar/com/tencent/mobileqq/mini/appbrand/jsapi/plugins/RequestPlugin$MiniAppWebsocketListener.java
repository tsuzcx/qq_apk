package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import bgnt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.NativeBuffer;
import com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestPlugin$MiniAppWebsocketListener
  extends WebSocketListener
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
    RequestPlugin.access$200(this.this$0, paramInt, paramString, this.currSocketId);
  }
  
  public void onClosed(WebSocket paramWebSocket, int paramInt, String paramString)
  {
    QLog.d("[mini] http.RequestPlugin", 1, "---onClosed---" + paramString);
    this.socketClosedCallbacked = true;
    RequestPlugin.access$200(this.this$0, paramInt, paramString, this.currSocketId);
  }
  
  public void onFailure(WebSocket paramWebSocket, Throwable paramThrowable, @Nullable Response paramResponse)
  {
    int i = this.currSocketId;
    if (paramResponse != null)
    {
      paramWebSocket = Integer.valueOf(paramResponse.code());
      QLog.e("[mini] http.RequestPlugin", 1, new Object[] { "[minigame][socket] MiniAppWebsocketListener onFailure, socketId=", Integer.valueOf(i), "response code=", paramWebSocket, paramThrowable });
      if (paramThrowable == null) {
        break label343;
      }
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        if ((paramThrowable.getMessage() != null) && ((paramThrowable.getMessage().equals("SSL handshake timed out")) || (paramThrowable.getMessage().equals("timeout"))))
        {
          QLog.e("[mini] http.RequestPlugin", 1, new Object[] { "[minigame][socket] MiniAppWebsocketListener onFailure , timeout , send close state. socketId=", Integer.valueOf(this.currSocketId) });
          paramWebSocket = new JSONObject();
          paramWebSocket.put("socketTaskId", this.currSocketId);
          paramWebSocket.put("state", "close");
          if (paramResponse == null)
          {
            i = 600;
            paramWebSocket.put("statusCode", i);
            if (RequestPlugin.access$000(this.this$0) != null) {
              RequestPlugin.access$000(this.this$0).evaluateSubcribeJS("onSocketTaskStateChange", paramWebSocket.toString(), 0);
            }
            if ((this.this$0.jsPluginEngine != null) && (this.this$0.jsPluginEngine.appBrandRuntime != null) && (this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo() != null) && (this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig != null))
            {
              localObject1 = this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig;
              localObject2 = MiniReportManager.getAppType(this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig);
              if ((paramResponse == null) || (paramResponse.request() == null)) {
                break label533;
              }
              paramWebSocket = paramResponse.request().url().toString();
              MiniReportManager.reportEventType((MiniAppConfig)localObject1, 634, null, null, null, 0, (String)localObject2, 0L, RequestPlugin.access$100(paramWebSocket));
            }
            return;
            paramWebSocket = "";
            break;
          }
          i = paramResponse.code();
          continue;
        }
        label343:
        Object localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("socketTaskId", this.currSocketId);
        ((JSONObject)localObject1).put("state", "error");
        if ((bgnt.b(BaseApplicationImpl.getContext()) == 0) || (bgnt.b(BaseApplicationImpl.getContext()) == -1))
        {
          paramWebSocket = "network is down";
          ((JSONObject)localObject1).put("errMsg", "network is down");
          QLog.e("[mini] http.RequestPlugin", 1, new Object[] { "[minigame][socket] MiniAppWebsocketListener onFailure socketId=", Integer.valueOf(this.currSocketId), " errMsg=", paramWebSocket });
          if (RequestPlugin.access$000(this.this$0) == null) {
            continue;
          }
          RequestPlugin.access$000(this.this$0).evaluateSubcribeJS("onSocketTaskStateChange", ((JSONObject)localObject1).toString(), 0);
          continue;
        }
        localObject2 = new StringBuilder().append("resposeCode=");
      }
      catch (JSONException paramWebSocket)
      {
        QLog.e("[mini] http.RequestPlugin", 1, "MiniAppWebsocketListener onFailure exception:", paramThrowable);
        return;
      }
      if (paramResponse == null) {}
      for (paramWebSocket = "-1";; paramWebSocket = Integer.valueOf(i))
      {
        paramWebSocket = paramWebSocket;
        break;
        i = paramResponse.code();
      }
      label533:
      paramWebSocket = null;
    }
  }
  
  public void onMessage(WebSocket paramWebSocket, String paramString)
  {
    try
    {
      paramWebSocket = new JSONObject();
      paramWebSocket.put("socketTaskId", this.currSocketId);
      paramWebSocket.put("state", "message");
      paramWebSocket.put("errMsg", "ok");
      paramWebSocket.put("isBuffer", false);
      paramWebSocket.put("data", paramString);
      if (RequestPlugin.access$000(this.this$0) != null) {
        RequestPlugin.access$000(this.this$0).evaluateSubcribeJS("onSocketTaskStateChange", paramWebSocket.toString(), 0);
      }
      return;
    }
    catch (JSONException paramWebSocket)
    {
      paramWebSocket = paramWebSocket;
      QLog.e("[mini] http.RequestPlugin", 1, "MiniAppWebsocketListener onMessage exception:", paramWebSocket);
      return;
    }
    finally {}
  }
  
  public void onMessage(WebSocket paramWebSocket, ByteString paramByteString)
  {
    try
    {
      paramWebSocket = new JSONObject();
      paramWebSocket.put("socketTaskId", this.currSocketId);
      paramWebSocket.put("state", "message");
      paramWebSocket.put("errMsg", "ok");
      paramWebSocket.put("isBuffer", true);
      if (this.this$0.isGameRuntime) {
        NativeBuffer.packNativeBuffer(paramByteString.toByteArray(), NativeBuffer.TYPE_BUFFER_NATIVE, "data", paramWebSocket, (ITNativeBufferPool)this.this$0.jsPluginEngine.getNativeBufferPool());
      }
      while (RequestPlugin.access$000(this.this$0) != null)
      {
        RequestPlugin.access$000(this.this$0).evaluateSubcribeJS("onSocketTaskStateChange", paramWebSocket.toString(), 0);
        return;
        NativeBuffer.packNativeBuffer(paramByteString.toByteArray(), NativeBuffer.TYPE_BUFFER_BASE64, "data", paramWebSocket, null);
      }
      return;
    }
    catch (JSONException paramWebSocket)
    {
      paramWebSocket = paramWebSocket;
      QLog.e("[mini] http.RequestPlugin", 1, "MiniAppWebsocketListener onMessage exception:", paramWebSocket);
      return;
    }
    finally {}
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
          paramWebSocket = paramResponse.request().url().toString();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RequestPlugin.MiniAppWebsocketListener
 * JD-Core Version:    0.7.0.1
 */