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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniAppWebsocketListener onFailure, socketId=");
    localStringBuilder.append(this.val$websocketRequestTask.mTaskId);
    localStringBuilder.append(paramString);
    QMLog.e("[mini] http.RequestJsPlugin", localStringBuilder.toString());
    RequestJsPlugin.access$500(this.this$0, paramInt2, paramString, this.val$websocketRequestTask, this.val$req);
  }
  
  /* Error */
  public void onMessage(int paramInt, String paramString)
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
    //   43: iconst_0
    //   44: invokevirtual 105	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   47: pop
    //   48: aload_3
    //   49: ldc 107
    //   51: aload_2
    //   52: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   55: pop
    //   56: aload_0
    //   57: getfield 18	com/tencent/qqmini/sdk/plugins/RequestJsPlugin$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   60: getfield 113	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsService	Lcom/tencent/qqmini/sdk/launcher/core/IJsService;
    //   63: ldc 115
    //   65: aload_3
    //   66: invokevirtual 116	org/json/JSONObject:toString	()Ljava/lang/String;
    //   69: iconst_0
    //   70: invokeinterface 122 4 0
    //   75: return
    //   76: astore_2
    //   77: goto +13 -> 90
    //   80: astore_2
    //   81: ldc 28
    //   83: ldc 124
    //   85: aload_2
    //   86: invokestatic 127	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   89: return
    //   90: aload_2
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	2
    //   0	92	1	paramInt	int
    //   0	92	2	paramString	String
    //   7	59	3	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	75	76	finally
    //   81	89	76	finally
    //   0	75	80	org/json/JSONException
  }
  
  /* Error */
  public void onMessage(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 82	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 83	org/json/JSONObject:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: ldc 85
    //   13: aload_0
    //   14: getfield 20	com/tencent/qqmini/sdk/plugins/RequestJsPlugin$2:val$websocketRequestTask	Lcom/tencent/qqmini/sdk/plugins/RequestJsPlugin$WebsocketRequestTask;
    //   17: getfield 48	com/tencent/qqmini/sdk/plugins/RequestJsPlugin$WebsocketRequestTask:mTaskId	I
    //   20: invokevirtual 89	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   23: pop
    //   24: aload 4
    //   26: ldc 91
    //   28: ldc 93
    //   30: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   33: pop
    //   34: aload 4
    //   36: ldc 98
    //   38: ldc 100
    //   40: invokevirtual 96	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   43: pop
    //   44: aload 4
    //   46: ldc 102
    //   48: iconst_1
    //   49: invokevirtual 105	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   52: pop
    //   53: aload_0
    //   54: getfield 16	com/tencent/qqmini/sdk/plugins/RequestJsPlugin$2:this$0	Lcom/tencent/qqmini/sdk/plugins/RequestJsPlugin;
    //   57: invokestatic 134	com/tencent/qqmini/sdk/plugins/RequestJsPlugin:access$600	(Lcom/tencent/qqmini/sdk/plugins/RequestJsPlugin;)Z
    //   60: istore_3
    //   61: iload_3
    //   62: ifeq +24 -> 86
    //   65: aload_0
    //   66: getfield 18	com/tencent/qqmini/sdk/plugins/RequestJsPlugin$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   69: getfield 113	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsService	Lcom/tencent/qqmini/sdk/launcher/core/IJsService;
    //   72: aload_2
    //   73: getstatic 139	com/tencent/qqmini/sdk/core/utils/NativeBuffer:TYPE_BUFFER_NATIVE	I
    //   76: ldc 107
    //   78: aload 4
    //   80: invokestatic 143	com/tencent/qqmini/sdk/core/utils/NativeBuffer:packNativeBuffer	(Lcom/tencent/qqmini/sdk/launcher/core/IJsService;[BILjava/lang/String;Lorg/json/JSONObject;)V
    //   83: goto +21 -> 104
    //   86: aload_0
    //   87: getfield 18	com/tencent/qqmini/sdk/plugins/RequestJsPlugin$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   90: getfield 113	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsService	Lcom/tencent/qqmini/sdk/launcher/core/IJsService;
    //   93: aload_2
    //   94: getstatic 146	com/tencent/qqmini/sdk/core/utils/NativeBuffer:TYPE_BUFFER_BASE64	I
    //   97: ldc 107
    //   99: aload 4
    //   101: invokestatic 143	com/tencent/qqmini/sdk/core/utils/NativeBuffer:packNativeBuffer	(Lcom/tencent/qqmini/sdk/launcher/core/IJsService;[BILjava/lang/String;Lorg/json/JSONObject;)V
    //   104: aload_0
    //   105: getfield 18	com/tencent/qqmini/sdk/plugins/RequestJsPlugin$2:val$req	Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;
    //   108: getfield 113	com/tencent/qqmini/sdk/launcher/core/model/RequestEvent:jsService	Lcom/tencent/qqmini/sdk/launcher/core/IJsService;
    //   111: ldc 115
    //   113: aload 4
    //   115: invokevirtual 116	org/json/JSONObject:toString	()Ljava/lang/String;
    //   118: iconst_0
    //   119: invokeinterface 122 4 0
    //   124: return
    //   125: astore_2
    //   126: goto +13 -> 139
    //   129: astore_2
    //   130: ldc 28
    //   132: ldc 124
    //   134: aload_2
    //   135: invokestatic 127	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   138: return
    //   139: aload_2
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	2
    //   0	141	1	paramInt	int
    //   0	141	2	paramArrayOfByte	byte[]
    //   60	2	3	bool	boolean
    //   7	107	4	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	61	125	finally
    //   65	83	125	finally
    //   86	104	125	finally
    //   104	124	125	finally
    //   130	138	125	finally
    //   0	61	129	java/lang/Exception
    //   65	83	129	java/lang/Exception
    //   86	104	129	java/lang/Exception
    //   104	124	129	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RequestJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */