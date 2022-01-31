package com.tencent.qqmini.sdk.core.plugins;

import android.os.SystemClock;
import bdcy;
import bdcz;
import bdfz;
import bdgq;
import bdgr;
import bdnw;
import bdsn;
import bdsp;
import bdsu;
import com.tencent.qqmini.sdk.core.proxy.RequestProxy.RequestListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class RequestJsPlugin$1
  implements RequestProxy.RequestListener
{
  String contentType;
  
  RequestJsPlugin$1(RequestJsPlugin paramRequestJsPlugin, String paramString, RequestJsPlugin.RequestTask paramRequestTask, bdfz parambdfz) {}
  
  public void onRequestFailed(int paramInt, String paramString)
  {
    bdnw.d("[mini] http.RequestJsPlugin", "--fail--- url: " + this.val$request.mUrl + " taskId=" + this.val$request.mTaskId + " resCode=" + paramInt);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", "fail");
      localJSONObject.put("requestTaskId", this.val$request.mTaskId);
      localJSONObject.put("errMsg", paramString);
      this.val$req.a.a("onRequestTaskStateChange", localJSONObject.toString(), 0);
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
      localJSONObject.put("header", bdgq.a(paramMap));
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
      this.val$req.a.a("onRequestTaskStateChange", localJSONObject.toString(), 0);
      return;
    }
    catch (Exception paramMap)
    {
      bdnw.d("[mini] http.RequestJsPlugin", "headersReceived exception, url: " + this.val$request.mUrl, paramMap);
    }
  }
  
  public void onRequestSucceed(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    Object localObject1 = (RequestJsPlugin.RequestTask)RequestJsPlugin.access$000(this.this$0).remove(Integer.valueOf(this.val$request.mTaskId));
    long l2;
    String str;
    if (localObject1 != null)
    {
      l2 = SystemClock.elapsedRealtime() - ((RequestJsPlugin.RequestTask)localObject1).mRequestCreatedMillis;
      bdnw.b("[mini] http.RequestJsPlugin", "[request httpCallBack][minigame timecost=" + l2 + "ms],[code=" + paramInt + "][url=" + this.val$request.mUrl + "][callbackId=" + this.val$req.jdField_b_of_type_Int + "][params=" + this.val$req.jdField_b_of_type_JavaLangString + "]");
      str = RequestJsPlugin.access$100(((RequestJsPlugin.RequestTask)localObject1).mUrl);
      bdnw.a("[mini] http.RequestJsPlugin", "httpCallBack second level domain " + str);
      if (this.this$0.mMiniAppContext == null) {
        break label441;
      }
      localObject1 = this.this$0.mMiniAppContext.a();
    }
    for (;;)
    {
      label203:
      long l1;
      if (localObject1 != null)
      {
        if (this.this$0.mIsMiniGame)
        {
          localObject2 = "1";
          bdsu.a((MiniAppInfo)localObject1, 628, null, null, null, paramInt, (String)localObject2, l2, str);
          if (paramArrayOfByte == null) {
            break label455;
          }
          l1 = paramArrayOfByte.length;
          label230:
          bdsn.a((MiniAppInfo)localObject1, paramInt, l1, l2);
          localObject2 = this.val$url;
          if (paramArrayOfByte == null) {
            break label461;
          }
          l1 = paramArrayOfByte.length;
          label255:
          bdsp.a((MiniAppInfo)localObject1, (String)localObject2, l1, l2, paramInt);
        }
      }
      else
      {
        localObject1 = new JSONObject();
        localObject2 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject1).put("url", this.val$url);
        if (paramInt > 0)
        {
          ((JSONObject)localObject2).put("requestTaskId", this.val$request.mTaskId);
          if (paramMap != null) {
            ((JSONObject)localObject2).put("header", bdgq.a(paramMap));
          }
          ((JSONObject)localObject2).put("statusCode", paramInt);
          ((JSONObject)localObject2).put("state", "success");
          ((JSONObject)localObject2).put("errMsg", "ok");
          if (paramArrayOfByte != null)
          {
            if (!"arraybuffer".equals(this.val$request.mResponseType)) {
              break label590;
            }
            if (!this.this$0.isGameRuntime) {
              break label467;
            }
            bdgr.a(this.this$0.mMiniAppContext, paramArrayOfByte, bdgr.a, "data", (JSONObject)localObject2);
          }
        }
        for (;;)
        {
          ((JSONObject)localObject1).put("res", localObject2);
          this.val$req.a.a("onRequestTaskStateChange", ((JSONObject)localObject2).toString(), 0);
          return;
          label441:
          localObject1 = null;
          break;
          localObject2 = "0";
          break label203;
          label455:
          l1 = 0L;
          break label230;
          label461:
          l1 = 0L;
          break label255;
          label467:
          bdgr.a(this.this$0.mMiniAppContext, paramArrayOfByte, bdgr.jdField_b_of_type_Int, "data", (JSONObject)localObject2);
          continue;
          try
          {
            paramMap = new JSONObject();
            paramMap.put("state", "fail");
            paramMap.put("statusCode", "-1");
            paramMap.put("requestTaskId", this.val$request.mTaskId);
            paramMap.put("errMsg", "exception：" + paramArrayOfByte.getMessage());
            this.val$req.a.a("onRequestTaskStateChange", paramMap.toString(), 0);
            bdnw.d("[mini] http.RequestJsPlugin", "httpCallBack exception:", paramArrayOfByte);
            return;
            if ("text".equals(this.val$request.mResponseType))
            {
              if ((paramArrayOfByte.length > 3) && ((paramArrayOfByte[0] & 0xFF) == 239) && ((paramArrayOfByte[1] & 0xFF) == 187) && ((paramArrayOfByte[2] & 0xFF) == 191)) {}
              for (paramArrayOfByte = new String(paramArrayOfByte, 3, paramArrayOfByte.length - 3, "UTF-8");; paramArrayOfByte = new String(paramArrayOfByte, "UTF-8"))
              {
                ((JSONObject)localObject2).put("data", paramArrayOfByte);
                break;
              }
            }
            bdnw.d("[mini] http.RequestJsPlugin", "url: " + this.val$request.mUrl + "--mResponseType error ---" + this.val$request.mResponseType);
            paramArrayOfByte = new JSONObject();
            paramArrayOfByte.put("state", "fail");
            paramArrayOfByte.put("statusCode", -1);
            paramArrayOfByte.put("requestTaskId", this.val$request.mTaskId);
            this.val$req.a.a("onRequestTaskStateChange", paramArrayOfByte.toString(), 0);
            return;
          }
          catch (Throwable paramMap)
          {
            break label580;
          }
        }
      }
      catch (Throwable paramArrayOfByte) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.RequestJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */