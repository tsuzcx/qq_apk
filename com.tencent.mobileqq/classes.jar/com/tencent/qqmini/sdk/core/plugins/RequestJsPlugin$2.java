package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import bdcy;
import bdcz;
import bdfz;
import bdgq;
import bdgr;
import bdnw;
import bdsu;
import com.tencent.qqmini.sdk.core.proxy.WebSocketProxy.WebSocketListener;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class RequestJsPlugin$2
  implements WebSocketProxy.WebSocketListener
{
  RequestJsPlugin$2(RequestJsPlugin paramRequestJsPlugin, bdfz parambdfz, RequestJsPlugin.WebsocketRequestTask paramWebsocketRequestTask) {}
  
  public void onClose(int paramInt, String paramString)
  {
    bdnw.a("[mini] http.RequestJsPlugin", "---onClosed---");
    RequestJsPlugin.access$202(this.this$0, true);
    RequestJsPlugin.access$300(this.this$0, this.val$req, paramInt, paramString, this.val$websocketRequestTask.mTaskId, this.val$websocketRequestTask.mUrl);
  }
  
  public void onError(int paramInt, String paramString)
  {
    Object localObject = null;
    bdnw.d("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onFailure, socketId=" + this.val$websocketRequestTask.mTaskId + paramString);
    for (;;)
    {
      try
      {
        if ((paramString.equals("SSL handshake timed out")) || (paramString.equals("timeout")))
        {
          bdnw.d("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onFailure , timeout , send close state. socketId=" + this.val$websocketRequestTask.mTaskId);
          paramString = new JSONObject();
          paramString.put("socketTaskId", this.val$websocketRequestTask.mTaskId);
          paramString.put("state", "close");
          paramString.put("statusCode", paramInt);
          this.val$req.a.a("onSocketTaskStateChange", paramString.toString(), 0);
          paramString = localObject;
          if (this.this$0.mMiniAppContext != null) {
            paramString = this.this$0.mMiniAppContext.a();
          }
          if (paramString == null) {
            break;
          }
          bdsu.a(paramString, 634, null, null, null, 0, bdsu.a(paramString), 0L, RequestJsPlugin.access$100(this.val$websocketRequestTask.mUrl));
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
          bdnw.d("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onFailure socketId=" + this.val$websocketRequestTask.mTaskId + " errMsg=" + paramString);
          this.val$req.a.a("onSocketTaskStateChange", localJSONObject.toString(), 0);
        }
        else
        {
          paramString = "resposeCode=" + paramInt;
        }
      }
      catch (JSONException paramString)
      {
        bdnw.d("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onFailure exception:", paramString);
        return;
      }
    }
  }
  
  public void onMessage(String paramString, byte[] paramArrayOfByte)
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
          if (this.this$0.isGameRuntime)
          {
            bdgr.a(this.this$0.mMiniAppContext, paramArrayOfByte, bdgr.a, "data", localJSONObject);
            this.val$req.a.a("onSocketTaskStateChange", localJSONObject.toString(), 0);
            return;
          }
          bdgr.a(this.this$0.mMiniAppContext, paramArrayOfByte, bdgr.b, "data", localJSONObject);
          continue;
        }
        localJSONObject.put("isBuffer", false);
      }
      catch (Exception paramString)
      {
        paramString = paramString;
        bdnw.d("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onMessage exception:", paramString);
        return;
      }
      finally {}
      localJSONObject.put("data", new String(paramArrayOfByte, "UTF-8"));
    }
  }
  
  public void onOpen(int paramInt, Map<String, List<String>> paramMap)
  {
    String str = null;
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("socketTaskId", this.val$websocketRequestTask.mTaskId);
      ((JSONObject)localObject).put("state", "open");
      ((JSONObject)localObject).put("statusCode", paramInt);
      ((JSONObject)localObject).put("header", bdgq.a(paramMap));
      this.val$req.a.a("onSocketTaskStateChange", ((JSONObject)localObject).toString(), 0);
      if (this.this$0.mMiniAppContext != null) {}
      for (paramMap = this.this$0.mMiniAppContext.a();; paramMap = null)
      {
        if (paramMap != null)
        {
          localObject = bdsu.a(paramMap);
          if (this.val$websocketRequestTask != null) {
            str = this.val$websocketRequestTask.mUrl;
          }
          bdsu.a(paramMap, 632, null, null, null, 0, (String)localObject, 0L, RequestJsPlugin.access$100(str));
        }
        return;
      }
      return;
    }
    catch (JSONException paramMap)
    {
      bdnw.d("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onOpen error:", paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.RequestJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */