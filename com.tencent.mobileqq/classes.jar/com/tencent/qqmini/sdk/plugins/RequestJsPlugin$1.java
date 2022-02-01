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
    Object localObject = (RequestJsPlugin.RequestTask)RequestJsPlugin.access$000(this.this$0).remove(Integer.valueOf(this.val$request.mTaskId));
    RequestJsPlugin.access$100(this.this$0, paramInt, (RequestJsPlugin.RequestTask)localObject, this.val$request, this.val$req, this.val$url, 0, this.val$request.mMethod);
    QMLog.e("[mini] http.RequestJsPlugin", "--fail--- url: " + this.val$request.mUrl + " taskId=" + this.val$request.mTaskId + " resCode=" + paramInt);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("state", "fail");
      ((JSONObject)localObject).put("requestTaskId", this.val$request.mTaskId);
      if (!TextUtils.isEmpty(paramString)) {
        ((JSONObject)localObject).put("errMsg", paramString);
      }
      for (;;)
      {
        this.val$req.jsService.evaluateSubscribeJS("onRequestTaskStateChange", ((JSONObject)localObject).toString(), 0);
        return;
        MiniappHttpUtil.fillErrMsg("request", (JSONObject)localObject, paramInt);
      }
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public void onRequestHeadersReceived(int paramInt, Map<String, List<String>> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", this.val$url);
      localJSONObject.put("requestTaskId", this.val$request.mTaskId);
      localJSONObject.put("header", JSONUtil.headerToJson(paramMap));
      localJSONObject.put("errMsg", "ok");
      localJSONObject.put("statusCode", paramInt);
      localJSONObject.put("state", "headersReceived");
      if ((paramMap != null) && (paramMap.containsKey("Content-Type")))
      {
        paramMap = (List)paramMap.get("Content-Type");
        if ((paramMap != null) && (paramMap.size() > 0)) {
          this.contentType = ((String)paramMap.get(0));
        }
      }
      this.val$req.jsService.evaluateSubscribeJS("onRequestTaskStateChange", localJSONObject.toString(), 0);
      return;
    }
    catch (Exception paramMap)
    {
      QMLog.e("[mini] http.RequestJsPlugin", "headersReceived exception, url: " + this.val$request.mUrl, paramMap);
    }
  }
  
  public void onRequestSucceed(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    RequestJsPlugin.RequestTask localRequestTask1 = (RequestJsPlugin.RequestTask)RequestJsPlugin.access$000(this.this$0).remove(Integer.valueOf(this.val$request.mTaskId));
    RequestJsPlugin localRequestJsPlugin = this.this$0;
    RequestJsPlugin.RequestTask localRequestTask2 = this.val$request;
    RequestEvent localRequestEvent = this.val$req;
    String str = this.val$url;
    if (paramArrayOfByte != null) {}
    for (int i = paramArrayOfByte.length;; i = 0)
    {
      RequestJsPlugin.access$100(localRequestJsPlugin, paramInt, localRequestTask1, localRequestTask2, localRequestEvent, str, i, this.val$request.mMethod);
      RequestJsPlugin.access$200(this.this$0, paramInt, paramArrayOfByte, paramMap, this.val$url, this.val$request, this.val$req);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RequestJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */