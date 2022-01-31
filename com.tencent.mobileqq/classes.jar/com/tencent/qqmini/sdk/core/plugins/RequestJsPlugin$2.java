package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import bglu;
import bgok;
import bgpg;
import bhck;
import com.tencent.qqmini.sdk.core.proxy.WebSocketProxy.WebSocketListener;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class RequestJsPlugin$2
  implements WebSocketProxy.WebSocketListener
{
  RequestJsPlugin$2(RequestJsPlugin paramRequestJsPlugin, bgok parambgok, RequestJsPlugin.WebsocketRequestTask paramWebsocketRequestTask) {}
  
  public void onClose(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.d("[mini] http.RequestJsPlugin", "---onClosed---");
    RequestJsPlugin.access$202(this.this$0, true);
    RequestJsPlugin.access$300(this.this$0, this.val$req, paramInt2, paramString, this.val$websocketRequestTask.mTaskId);
  }
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.e("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onFailure, socketId=" + this.val$websocketRequestTask.mTaskId + paramString);
    for (;;)
    {
      try
      {
        if ((paramString.equals("SSL handshake timed out")) || (paramString.equals("timeout")))
        {
          QMLog.e("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onFailure , timeout , send close state. socketId=" + this.val$websocketRequestTask.mTaskId);
          paramString = new JSONObject();
          paramString.put("socketTaskId", this.val$websocketRequestTask.mTaskId);
          paramString.put("state", "close");
          paramString.put("statusCode", paramInt2);
          this.val$req.a.a("onSocketTaskStateChange", paramString.toString(), 0);
          bhck.a(this.this$0.mMiniAppInfo, 634, null, null, null, 0, bhck.a(this.this$0.mMiniAppInfo), 0L, RequestJsPlugin.access$100(this.val$websocketRequestTask.mUrl));
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
          QMLog.e("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onFailure socketId=" + this.val$websocketRequestTask.mTaskId + " errMsg=" + paramString);
          this.val$req.a.a("onSocketTaskStateChange", localJSONObject.toString(), 0);
        }
        else
        {
          paramString = "resposeCode=" + paramInt2;
        }
      }
      catch (JSONException paramString)
      {
        QMLog.e("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onFailure exception:", paramString);
        return;
      }
    }
  }
  
  public void onMessage(int paramInt, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("socketTaskId", this.val$websocketRequestTask.mTaskId);
      localJSONObject.put("state", "message");
      localJSONObject.put("errMsg", "ok");
      localJSONObject.put("isBuffer", false);
      localJSONObject.put("data", paramString);
      this.val$req.a.a("onSocketTaskStateChange", localJSONObject.toString(), 0);
      return;
    }
    catch (JSONException paramString)
    {
      paramString = paramString;
      QMLog.e("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onMessage exception:", paramString);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void onMessage(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 88	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 89	org/json/JSONObject:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc 91
    //   11: aload_0
    //   12: getfield 20	com/tencent/qqmini/sdk/core/plugins/RequestJsPlugin$2:val$websocketRequestTask	Lcom/tencent/qqmini/sdk/core/plugins/RequestJsPlugin$WebsocketRequestTask;
    //   15: getfield 48	com/tencent/qqmini/sdk/core/plugins/RequestJsPlugin$WebsocketRequestTask:mTaskId	I
    //   18: invokevirtual 95	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   21: pop
    //   22: aload_3
    //   23: ldc 97
    //   25: ldc 183
    //   27: invokevirtual 102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   30: pop
    //   31: aload_3
    //   32: ldc 168
    //   34: ldc 185
    //   36: invokevirtual 102	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   39: pop
    //   40: aload_3
    //   41: ldc 187
    //   43: iconst_1
    //   44: invokevirtual 190	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   47: pop
    //   48: aload_0
    //   49: getfield 16	com/tencent/qqmini/sdk/core/plugins/RequestJsPlugin$2:this$0	Lcom/tencent/qqmini/sdk/core/plugins/RequestJsPlugin;
    //   52: getfield 201	com/tencent/qqmini/sdk/core/plugins/RequestJsPlugin:mIsMiniGame	Z
    //   55: ifeq +40 -> 95
    //   58: aload_0
    //   59: getfield 16	com/tencent/qqmini/sdk/core/plugins/RequestJsPlugin$2:this$0	Lcom/tencent/qqmini/sdk/core/plugins/RequestJsPlugin;
    //   62: getfield 205	com/tencent/qqmini/sdk/core/plugins/RequestJsPlugin:mMiniAppContext	Lbglv;
    //   65: aload_2
    //   66: getstatic 209	bgpi:a	I
    //   69: ldc 192
    //   71: aload_3
    //   72: invokestatic 212	bgpi:a	(Lbglv;[BILjava/lang/String;Lorg/json/JSONObject;)V
    //   75: aload_0
    //   76: getfield 18	com/tencent/qqmini/sdk/core/plugins/RequestJsPlugin$2:val$req	Lbgok;
    //   79: getfield 110	bgok:a	Lbglu;
    //   82: ldc 112
    //   84: aload_3
    //   85: invokevirtual 113	org/json/JSONObject:toString	()Ljava/lang/String;
    //   88: iconst_0
    //   89: invokeinterface 118 4 0
    //   94: return
    //   95: aload_0
    //   96: getfield 16	com/tencent/qqmini/sdk/core/plugins/RequestJsPlugin$2:this$0	Lcom/tencent/qqmini/sdk/core/plugins/RequestJsPlugin;
    //   99: getfield 205	com/tencent/qqmini/sdk/core/plugins/RequestJsPlugin:mMiniAppContext	Lbglv;
    //   102: aload_2
    //   103: getstatic 215	bgpi:b	I
    //   106: ldc 192
    //   108: aload_3
    //   109: invokestatic 212	bgpi:a	(Lbglv;[BILjava/lang/String;Lorg/json/JSONObject;)V
    //   112: goto -37 -> 75
    //   115: astore_2
    //   116: ldc 28
    //   118: ldc 194
    //   120: aload_2
    //   121: invokestatic 177	com/tencent/qqmini/sdk/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   124: return
    //   125: astore_2
    //   126: aload_2
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	2
    //   0	128	1	paramInt	int
    //   0	128	2	paramArrayOfByte	byte[]
    //   7	102	3	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	75	115	java/lang/Exception
    //   75	94	115	java/lang/Exception
    //   95	112	115	java/lang/Exception
    //   0	75	125	finally
    //   75	94	125	finally
    //   95	112	125	finally
    //   116	124	125	finally
  }
  
  public void onOpen(int paramInt1, int paramInt2, Map<String, List<String>> paramMap)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("socketTaskId", this.val$websocketRequestTask.mTaskId);
      localJSONObject.put("state", "open");
      localJSONObject.put("statusCode", paramInt2);
      localJSONObject.put("header", bgpg.a(paramMap));
      this.val$req.a.a("onSocketTaskStateChange", localJSONObject.toString(), 0);
      bhck.a(this.this$0.mMiniAppInfo, 632, null, null, null, 0, bhck.a(this.this$0.mMiniAppInfo), 0L, RequestJsPlugin.access$100(this.val$websocketRequestTask.mUrl));
      return;
    }
    catch (JSONException paramMap)
    {
      QMLog.e("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onOpen error:", paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.RequestJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */