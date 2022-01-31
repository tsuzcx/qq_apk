package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import behp;
import bekr;
import belj;
import bell;
import betc;
import bezi;
import com.tencent.qqmini.sdk.core.proxy.WebSocketProxy.WebSocketListener;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class RequestJsPlugin$2
  implements WebSocketProxy.WebSocketListener
{
  RequestJsPlugin$2(RequestJsPlugin paramRequestJsPlugin, bekr parambekr, RequestJsPlugin.WebsocketRequestTask paramWebsocketRequestTask) {}
  
  public void onClose(int paramInt1, int paramInt2, String paramString)
  {
    betc.a("[mini] http.RequestJsPlugin", "---onClosed---");
    RequestJsPlugin.access$202(this.this$0, true);
    RequestJsPlugin.access$300(this.this$0, this.val$req, paramInt2, paramString, this.val$websocketRequestTask.mTaskId);
  }
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    betc.d("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onFailure, socketId=" + this.val$websocketRequestTask.mTaskId + paramString);
    for (;;)
    {
      try
      {
        if ((paramString.equals("SSL handshake timed out")) || (paramString.equals("timeout")))
        {
          betc.d("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onFailure , timeout , send close state. socketId=" + this.val$websocketRequestTask.mTaskId);
          paramString = new JSONObject();
          paramString.put("socketTaskId", this.val$websocketRequestTask.mTaskId);
          paramString.put("state", "close");
          paramString.put("statusCode", paramInt2);
          this.val$req.a.a("onSocketTaskStateChange", paramString.toString(), 0);
          bezi.a(this.this$0.mMiniAppInfo, 634, null, null, null, 0, bezi.a(this.this$0.mMiniAppInfo), 0L, RequestJsPlugin.access$100(this.val$websocketRequestTask.mUrl));
          return;
        }
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("socketTaskId", this.val$websocketRequestTask.mTaskId);
        localJSONObject.put("state", "error");
        paramString = ((ConnectivityManager)this.this$0.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((paramString == null) || (!paramString.isConnected()))
        {
          paramString = "network is down";
          localJSONObject.put("errMsg", "network is down");
          betc.d("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onFailure socketId=" + this.val$websocketRequestTask.mTaskId + " errMsg=" + paramString);
          this.val$req.a.a("onSocketTaskStateChange", localJSONObject.toString(), 0);
        }
        else
        {
          paramString = "resposeCode=" + paramInt2;
        }
      }
      catch (JSONException paramString)
      {
        betc.d("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onFailure exception:", paramString);
        return;
      }
    }
  }
  
  public void onMessage(int paramInt, String paramString, byte[] paramArrayOfByte)
  {
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("socketTaskId", this.val$websocketRequestTask.mTaskId);
        localJSONObject.put("state", "message");
        localJSONObject.put("errMsg", "ok");
        if (paramString.equals("vnd.okhttp.websocket+binary"))
        {
          localJSONObject.put("isBuffer", true);
          if (this.this$0.mIsMiniGame)
          {
            bell.a(this.this$0.mMiniAppContext, paramArrayOfByte, bell.a, "data", localJSONObject);
            this.val$req.a.a("onSocketTaskStateChange", localJSONObject.toString(), 0);
            return;
          }
          bell.a(this.this$0.mMiniAppContext, paramArrayOfByte, bell.b, "data", localJSONObject);
          continue;
        }
        localJSONObject.put("isBuffer", false);
      }
      catch (Exception paramString)
      {
        paramString = paramString;
        betc.d("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onMessage exception:", paramString);
        return;
      }
      finally {}
      localJSONObject.put("data", new String(paramArrayOfByte, "UTF-8"));
    }
  }
  
  public void onOpen(int paramInt1, int paramInt2, Map<String, List<String>> paramMap)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("socketTaskId", this.val$websocketRequestTask.mTaskId);
      localJSONObject.put("state", "open");
      localJSONObject.put("statusCode", paramInt2);
      localJSONObject.put("header", belj.a(paramMap));
      this.val$req.a.a("onSocketTaskStateChange", localJSONObject.toString(), 0);
      bezi.a(this.this$0.mMiniAppInfo, 632, null, null, null, 0, bezi.a(this.this$0.mMiniAppInfo), 0L, RequestJsPlugin.access$100(this.val$websocketRequestTask.mUrl));
      return;
    }
    catch (JSONException paramMap)
    {
      betc.d("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onOpen error:", paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.RequestJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */