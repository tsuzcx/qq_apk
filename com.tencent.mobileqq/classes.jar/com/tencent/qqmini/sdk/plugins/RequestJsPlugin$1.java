package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.core.utils.MiniappHttpUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class RequestJsPlugin$1
  implements RequestProxy.RequestListener
{
  String contentType;
  
  RequestJsPlugin$1(RequestJsPlugin paramRequestJsPlugin, String paramString, RequestJsPlugin.RequestTask paramRequestTask, RequestEvent paramRequestEvent) {}
  
  public void onRequestFailed(int paramInt, String paramString)
  {
    Object localObject1 = (RequestJsPlugin.RequestTask)RequestJsPlugin.access$000(this.this$0).remove(Integer.valueOf(this.val$request.mTaskId));
    Object localObject2 = this.this$0;
    RequestJsPlugin.RequestTask localRequestTask = this.val$request;
    RequestJsPlugin.access$100((RequestJsPlugin)localObject2, paramInt, (RequestJsPlugin.RequestTask)localObject1, localRequestTask, this.val$req, this.val$url, 0, localRequestTask.mMethod);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("--fail--- url: ");
    ((StringBuilder)localObject1).append(this.val$request.mUrl);
    ((StringBuilder)localObject1).append(" taskId=");
    ((StringBuilder)localObject1).append(this.val$request.mTaskId);
    ((StringBuilder)localObject1).append(" resCode=");
    ((StringBuilder)localObject1).append(paramInt);
    QMLog.e("[mini] http.RequestJsPlugin", ((StringBuilder)localObject1).toString());
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("state", "fail");
      ((JSONObject)localObject1).put("requestTaskId", this.val$request.mTaskId);
      if (!TextUtils.isEmpty(paramString))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" errCode: ");
        ((StringBuilder)localObject2).append(paramInt);
        ((JSONObject)localObject1).put("errMsg", ((StringBuilder)localObject2).toString());
      }
      else
      {
        MiniappHttpUtil.fillErrMsg("request", (JSONObject)localObject1, paramInt);
      }
      this.val$req.jsService.evaluateSubscribeJS("onRequestTaskStateChange", ((JSONObject)localObject1).toString(), 0);
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public void onRequestHeadersReceived(int paramInt, Map<String, List<String>> paramMap)
  {
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("url", this.val$url);
      ((JSONObject)localObject).put("requestTaskId", this.val$request.mTaskId);
      ((JSONObject)localObject).put("header", JSONUtil.headerToJson(paramMap));
      ((JSONObject)localObject).put("errMsg", "ok");
      ((JSONObject)localObject).put("statusCode", paramInt);
      ((JSONObject)localObject).put("state", "headersReceived");
      if ((paramMap != null) && (paramMap.containsKey("Content-Type")))
      {
        paramMap = (List)paramMap.get("Content-Type");
        if ((paramMap != null) && (paramMap.size() > 0)) {
          this.contentType = ((String)paramMap.get(0));
        }
      }
      this.val$req.jsService.evaluateSubscribeJS("onRequestTaskStateChange", ((JSONObject)localObject).toString(), 0);
      return;
    }
    catch (Exception paramMap)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("headersReceived exception, url: ");
      ((StringBuilder)localObject).append(this.val$request.mUrl);
      QMLog.e("[mini] http.RequestJsPlugin", ((StringBuilder)localObject).toString(), paramMap);
    }
  }
  
  public void onRequestSucceed(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    RequestJsPlugin.RequestTask localRequestTask1 = (RequestJsPlugin.RequestTask)RequestJsPlugin.access$000(this.this$0).remove(Integer.valueOf(this.val$request.mTaskId));
    RequestJsPlugin localRequestJsPlugin = this.this$0;
    RequestJsPlugin.RequestTask localRequestTask2 = this.val$request;
    RequestEvent localRequestEvent = this.val$req;
    String str = this.val$url;
    int i;
    if (paramArrayOfByte != null) {
      i = paramArrayOfByte.length;
    } else {
      i = 0;
    }
    RequestJsPlugin.access$100(localRequestJsPlugin, paramInt, localRequestTask1, localRequestTask2, localRequestEvent, str, i, this.val$request.mMethod);
    RequestJsPlugin.access$200(this.this$0, paramInt, paramArrayOfByte, paramMap, this.val$url, this.val$request, this.val$req);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RequestJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */