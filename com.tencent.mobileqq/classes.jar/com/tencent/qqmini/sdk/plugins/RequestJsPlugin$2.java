package com.tencent.qqmini.sdk.plugins;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.WebSocketProxy.WebSocketListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class RequestJsPlugin$2
  implements WebSocketProxy.WebSocketListener
{
  RequestJsPlugin$2(RequestJsPlugin paramRequestJsPlugin, RequestEvent paramRequestEvent, RequestJsPlugin.WebsocketRequestTask paramWebsocketRequestTask) {}
  
  public void onClose(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.d("[mini] http.RequestJsPlugin", "---onClosed---");
    RequestJsPlugin.access$1302(this.this$0, true);
    RequestJsPlugin.access$1400(this.this$0, this.val$req, paramInt2, paramString, this.val$websocketRequestTask.mTaskId);
  }
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.e("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onFailure, socketId=" + this.val$websocketRequestTask.mTaskId + paramString);
    Object localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    for (;;)
    {
      try
      {
        if ((((String)localObject).equals("SSL handshake timed out")) || (((String)localObject).equals("timeout")))
        {
          QMLog.e("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onFailure , timeout , send close state. socketId=" + this.val$websocketRequestTask.mTaskId);
          paramString = new JSONObject();
          paramString.put("socketTaskId", this.val$websocketRequestTask.mTaskId);
          paramString.put("state", "close");
          paramString.put("statusCode", paramInt2);
          this.val$req.jsService.evaluateSubscribeJS("onSocketTaskStateChange", paramString.toString(), 0);
          MiniReportManager.reportEventType(RequestJsPlugin.access$1600(this.this$0), 634, null, null, null, 0, MiniReportManager.getAppType(RequestJsPlugin.access$1700(this.this$0)), 0L, RequestJsPlugin.access$100(this.val$websocketRequestTask.mUrl));
          return;
        }
        localObject = new JSONObject();
        ((JSONObject)localObject).put("socketTaskId", this.val$websocketRequestTask.mTaskId);
        ((JSONObject)localObject).put("state", "error");
        paramString = ((ConnectivityManager)RequestJsPlugin.access$1500(this.this$0).getSystemService("connectivity")).getActiveNetworkInfo();
        if ((paramString == null) || (!paramString.isConnected()))
        {
          paramString = "network is down";
          ((JSONObject)localObject).put("errMsg", "network is down");
          QMLog.e("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onFailure socketId=" + this.val$websocketRequestTask.mTaskId + " errMsg=" + paramString);
          this.val$req.jsService.evaluateSubscribeJS("onSocketTaskStateChange", ((JSONObject)localObject).toString(), 0);
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
      this.val$req.jsService.evaluateSubscribeJS("onSocketTaskStateChange", localJSONObject.toString(), 0);
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
    //   0: new 90	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 91	org/json/JSONObject:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc 93
    //   11: aload_0
    //   12: getfield 20	com/tencent/qqmini/sdk/plugins/RequestJsPlugin$2:val$websocketRequestTask	Lcom/tencent/qqmini/sdk/plugins/RequestJsPlugin$WebsocketRequestTask;
    //   15: getfield 48	com/tencent/qqmini/sdk/plugins/RequestJsPlugin$WebsocketRequestTask:mTaskId	I
    //   18: invokevirtual 97	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   21: pop
    //   22: aload_3
    //   23: ldc 99
    //   25: ldc 191
    //   27: invokevirtual 104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   30: pop
    //   31: aload_3
    //   32: ldc 176
    //   34: ldc 193
    //   36: invokevirtual 104	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   39: pop
    //   40: aload_3
    //   41: ldc 195
    //   43: iconst_1
    //   44: invokevirtual 198	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   47: pop
    //   48: aload_0
    //   49: getfield 16	com/tencent/qqmini/sdk/plugins/RequestJsPlugin$2:this$0	Lcom/tencent/qqmini/sdk/plugins/RequestJsPlugin;
    //   52: invokestatic 209	com/tencent/qqmini/sdk/plugins/RequestJsPlugin:access$1800	(Lcom/tencent/qqmini/sdk/plugins/RequestJsPlugin;)Z
    //   55: ifeq +40 -> 95
    //   58: aload_0
    //   59: getfield 16	com/tencent/qqmini/sdk/plugins/RequestJsPlugin$2:this$0	Lcom/tencent/qqmini/sdk/plugins/RequestJsPlugin;
    //   62: invokestatic 213	com/tencent/qqmini/sdk/plugins/RequestJsPlugin:access$1900	(Lcom/tencent/qqmini/sdk/plugins/RequestJsPlugin;)Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   65: aload_2
    //   66: getstatic 218	com/tencent/qqmini/sdk/core/utils/NativeBuffer:TYPE_BUFFER_NATIVE	I
    //   69: ldc 200
    //   71: aload_3
    //   72: invokestatic 222	com/tencent/qqmini/sdk/core/utils/NativeBuffer:packNativeBuffer	(Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;[BILjava/lang/String;Lorg/json/JSONObject;)V
    //   75: aload_0
    //   76: getfield 18	com/tencent/qqmini/sdk/plugins/RequestJsPlugin$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   79: getfield 112	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsService	Lcom/tencent/qqmini/sdk/launcher/core/IJsService;
    //   82: ldc 114
    //   84: aload_3
    //   85: invokevirtual 115	org/json/JSONObject:toString	()Ljava/lang/String;
    //   88: iconst_0
    //   89: invokeinterface 121 4 0
    //   94: return
    //   95: aload_0
    //   96: getfield 16	com/tencent/qqmini/sdk/plugins/RequestJsPlugin$2:this$0	Lcom/tencent/qqmini/sdk/plugins/RequestJsPlugin;
    //   99: invokestatic 225	com/tencent/qqmini/sdk/plugins/RequestJsPlugin:access$2000	(Lcom/tencent/qqmini/sdk/plugins/RequestJsPlugin;)Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;
    //   102: aload_2
    //   103: getstatic 228	com/tencent/qqmini/sdk/core/utils/NativeBuffer:TYPE_BUFFER_BASE64	I
    //   106: ldc 200
    //   108: aload_3
    //   109: invokestatic 222	com/tencent/qqmini/sdk/core/utils/NativeBuffer:packNativeBuffer	(Lcom/tencent/qqmini/sdk/launcher/core/IMiniAppContext;[BILjava/lang/String;Lorg/json/JSONObject;)V
    //   112: goto -37 -> 75
    //   115: astore_2
    //   116: ldc 28
    //   118: ldc 202
    //   120: aload_2
    //   121: invokestatic 185	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
      localJSONObject.put("header", JSONUtil.headerToJson(paramMap));
      this.val$req.jsService.evaluateSubscribeJS("onSocketTaskStateChange", localJSONObject.toString(), 0);
      MiniReportManager.reportEventType(RequestJsPlugin.access$2100(this.this$0), 632, null, null, null, 0, MiniReportManager.getAppType(RequestJsPlugin.access$2200(this.this$0)), 0L, RequestJsPlugin.access$100(this.val$websocketRequestTask.mUrl));
      return;
    }
    catch (JSONException paramMap)
    {
      QMLog.e("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onOpen error:", paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RequestJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */