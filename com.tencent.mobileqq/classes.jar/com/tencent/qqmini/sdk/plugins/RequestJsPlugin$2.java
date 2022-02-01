package com.tencent.qqmini.sdk.plugins;

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
    RequestJsPlugin.access$302(this.this$0, true);
    RequestJsPlugin.access$400(this.this$0, this.val$req, paramInt2, paramString, this.val$websocketRequestTask.mTaskId);
  }
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    QMLog.e("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onFailure, socketId=" + this.val$websocketRequestTask.mTaskId + paramString);
    RequestJsPlugin.access$500(this.this$0, paramInt2, paramString, this.val$websocketRequestTask, this.val$req);
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
    //   0: new 82	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 83	org/json/JSONObject:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: ldc 85
    //   11: aload_0
    //   12: getfield 20	com/tencent/qqmini/sdk/plugins/RequestJsPlugin$2:val$websocketRequestTask	Lcom/tencent/qqmini/sdk/plugins/RequestJsPlugin$WebsocketRequestTask;
    //   15: getfield 48	com/tencent/qqmini/sdk/plugins/RequestJsPlugin$WebsocketRequestTask:mTaskId	I
    //   18: invokevirtual 89	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   21: pop
    //   22: aload_3
    //   23: ldc 91
    //   25: ldc 93
    //   27: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   30: pop
    //   31: aload_3
    //   32: ldc 98
    //   34: ldc 100
    //   36: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   39: pop
    //   40: aload_3
    //   41: ldc 102
    //   43: iconst_1
    //   44: invokevirtual 105	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   47: pop
    //   48: aload_0
    //   49: getfield 16	com/tencent/qqmini/sdk/plugins/RequestJsPlugin$2:this$0	Lcom/tencent/qqmini/sdk/plugins/RequestJsPlugin;
    //   52: invokestatic 134	com/tencent/qqmini/sdk/plugins/RequestJsPlugin:access$600	(Lcom/tencent/qqmini/sdk/plugins/RequestJsPlugin;)Z
    //   55: ifeq +40 -> 95
    //   58: aload_0
    //   59: getfield 18	com/tencent/qqmini/sdk/plugins/RequestJsPlugin$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   62: getfield 113	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsService	Lcom/tencent/qqmini/sdk/launcher/core/IJsService;
    //   65: aload_2
    //   66: getstatic 139	com/tencent/qqmini/sdk/core/utils/NativeBuffer:TYPE_BUFFER_NATIVE	I
    //   69: ldc 107
    //   71: aload_3
    //   72: invokestatic 143	com/tencent/qqmini/sdk/core/utils/NativeBuffer:packNativeBuffer	(Lcom/tencent/qqmini/sdk/launcher/core/IJsService;[BILjava/lang/String;Lorg/json/JSONObject;)V
    //   75: aload_0
    //   76: getfield 18	com/tencent/qqmini/sdk/plugins/RequestJsPlugin$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   79: getfield 113	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsService	Lcom/tencent/qqmini/sdk/launcher/core/IJsService;
    //   82: ldc 115
    //   84: aload_3
    //   85: invokevirtual 116	org/json/JSONObject:toString	()Ljava/lang/String;
    //   88: iconst_0
    //   89: invokeinterface 122 4 0
    //   94: return
    //   95: aload_0
    //   96: getfield 18	com/tencent/qqmini/sdk/plugins/RequestJsPlugin$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   99: getfield 113	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsService	Lcom/tencent/qqmini/sdk/launcher/core/IJsService;
    //   102: aload_2
    //   103: getstatic 146	com/tencent/qqmini/sdk/core/utils/NativeBuffer:TYPE_BUFFER_BASE64	I
    //   106: ldc 107
    //   108: aload_3
    //   109: invokestatic 143	com/tencent/qqmini/sdk/core/utils/NativeBuffer:packNativeBuffer	(Lcom/tencent/qqmini/sdk/launcher/core/IJsService;[BILjava/lang/String;Lorg/json/JSONObject;)V
    //   112: goto -37 -> 75
    //   115: astore_2
    //   116: ldc 28
    //   118: ldc 124
    //   120: aload_2
    //   121: invokestatic 127	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
      MiniReportManager.reportEventType(RequestJsPlugin.access$700(this.this$0), 632, null, null, null, 0, MiniReportManager.getAppType(RequestJsPlugin.access$800(this.this$0)), 0L, RequestJsPlugin.access$900(this.val$websocketRequestTask.mUrl));
      return;
    }
    catch (JSONException paramMap)
    {
      QMLog.e("[mini] http.RequestJsPlugin", "MiniAppWebsocketListener onOpen error:", paramMap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RequestJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */