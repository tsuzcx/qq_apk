package com.tencent.qqmini.sdk.core.plugins;

import android.os.SystemClock;
import android.text.TextUtils;
import behp;
import bekr;
import belj;
import belk;
import bell;
import betc;
import bezb;
import bezd;
import bezi;
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
  
  RequestJsPlugin$1(RequestJsPlugin paramRequestJsPlugin, String paramString, RequestJsPlugin.RequestTask paramRequestTask, bekr parambekr) {}
  
  public void onRequestFailed(int paramInt, String paramString)
  {
    Object localObject = (RequestJsPlugin.RequestTask)RequestJsPlugin.access$000(this.this$0).remove(Integer.valueOf(this.val$request.mTaskId));
    long l;
    String str;
    if (localObject != null)
    {
      l = SystemClock.elapsedRealtime() - ((RequestJsPlugin.RequestTask)localObject).mRequestCreatedMillis;
      betc.b("[mini] http.RequestJsPlugin", "[request httpCallBack][minigame timecost=" + l + "ms],[code=" + paramInt + "][url=" + this.val$request.mUrl + "][callbackId=" + this.val$req.jdField_b_of_type_Int + "][params=" + this.val$req.jdField_b_of_type_JavaLangString + "]");
      str = RequestJsPlugin.access$100(((RequestJsPlugin.RequestTask)localObject).mUrl);
      betc.a("[mini] http.RequestJsPlugin", "httpCallBack second level domain " + str);
      if (!this.this$0.mIsMiniGame) {
        break label349;
      }
      localObject = "1";
    }
    for (;;)
    {
      bezi.a(this.this$0.mMiniAppInfo, 628, null, null, null, paramInt, (String)localObject, l, str);
      bezb.a(this.this$0.mMiniAppInfo, paramInt, 0L, l);
      bezd.a(this.this$0.mMiniAppInfo, this.val$url, 0L, l, paramInt);
      betc.d("[mini] http.RequestJsPlugin", "--fail--- url: " + this.val$request.mUrl + " taskId=" + this.val$request.mTaskId + " resCode=" + paramInt);
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
          this.val$req.a.a("onRequestTaskStateChange", ((JSONObject)localObject).toString(), 0);
          return;
          label349:
          localObject = "0";
          break;
          belk.a("request", (JSONObject)localObject, paramInt);
        }
        return;
      }
      catch (Throwable paramString) {}
    }
  }
  
  public void onRequestHeadersReceived(int paramInt, Map<String, List<String>> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", this.val$url);
      localJSONObject.put("requestTaskId", this.val$request.mTaskId);
      localJSONObject.put("header", belj.a(paramMap));
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
      betc.d("[mini] http.RequestJsPlugin", "headersReceived exception, url: " + this.val$request.mUrl, paramMap);
    }
  }
  
  public void onRequestSucceed(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    Object localObject1 = (RequestJsPlugin.RequestTask)RequestJsPlugin.access$000(this.this$0).remove(Integer.valueOf(this.val$request.mTaskId));
    long l2;
    if (localObject1 != null)
    {
      l2 = SystemClock.elapsedRealtime() - ((RequestJsPlugin.RequestTask)localObject1).mRequestCreatedMillis;
      betc.b("[mini] http.RequestJsPlugin", "[request httpCallBack][minigame timecost=" + l2 + "ms],[code=" + paramInt + "][url=" + this.val$request.mUrl + "][callbackId=" + this.val$req.jdField_b_of_type_Int + "][params=" + this.val$req.jdField_b_of_type_JavaLangString + "]");
      localObject2 = RequestJsPlugin.access$100(((RequestJsPlugin.RequestTask)localObject1).mUrl);
      betc.a("[mini] http.RequestJsPlugin", "httpCallBack second level domain " + (String)localObject2);
      if (!this.this$0.mIsMiniGame) {
        break label436;
      }
      localObject1 = "1";
    }
    for (;;)
    {
      bezi.a(this.this$0.mMiniAppInfo, 628, null, null, null, paramInt, (String)localObject1, l2, (String)localObject2);
      localObject1 = this.this$0.mMiniAppInfo;
      long l1;
      if (paramArrayOfByte != null)
      {
        l1 = paramArrayOfByte.length;
        label215:
        bezb.a((MiniAppInfo)localObject1, paramInt, l1, l2);
        localObject1 = this.this$0.mMiniAppInfo;
        localObject2 = this.val$url;
        if (paramArrayOfByte == null) {
          break label449;
        }
        l1 = paramArrayOfByte.length;
        label249:
        bezd.a((MiniAppInfo)localObject1, (String)localObject2, l1, l2, paramInt);
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
            ((JSONObject)localObject2).put("header", belj.a(paramMap));
          }
          ((JSONObject)localObject2).put("statusCode", paramInt);
          ((JSONObject)localObject2).put("state", "success");
          ((JSONObject)localObject2).put("errMsg", "ok");
          if (paramArrayOfByte != null)
          {
            if (!"arraybuffer".equals(this.val$request.mResponseType)) {
              break label578;
            }
            if (!this.this$0.mIsMiniGame) {
              break label455;
            }
            bell.a(this.this$0.mMiniAppContext, paramArrayOfByte, bell.a, "data", (JSONObject)localObject2);
          }
        }
        for (;;)
        {
          ((JSONObject)localObject1).put("res", localObject2);
          this.val$req.a.a("onRequestTaskStateChange", ((JSONObject)localObject2).toString(), 0);
          return;
          label436:
          localObject1 = "0";
          break;
          l1 = 0L;
          break label215;
          label449:
          l1 = 0L;
          break label249;
          label455:
          bell.a(this.this$0.mMiniAppContext, paramArrayOfByte, bell.jdField_b_of_type_Int, "data", (JSONObject)localObject2);
          continue;
          try
          {
            paramMap = new JSONObject();
            paramMap.put("state", "fail");
            paramMap.put("statusCode", "-1");
            paramMap.put("requestTaskId", this.val$request.mTaskId);
            paramMap.put("errMsg", "exception：" + paramArrayOfByte.getMessage());
            this.val$req.a.a("onRequestTaskStateChange", paramMap.toString(), 0);
            betc.d("[mini] http.RequestJsPlugin", "httpCallBack exception:", paramArrayOfByte);
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
            betc.d("[mini] http.RequestJsPlugin", "url: " + this.val$request.mUrl + "--mResponseType error ---" + this.val$request.mResponseType);
            paramArrayOfByte = new JSONObject();
            paramArrayOfByte.put("state", "fail");
            paramArrayOfByte.put("statusCode", -1);
            paramArrayOfByte.put("requestTaskId", this.val$request.mTaskId);
            this.val$req.a.a("onRequestTaskStateChange", paramArrayOfByte.toString(), 0);
            return;
          }
          catch (Throwable paramMap)
          {
            break label568;
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