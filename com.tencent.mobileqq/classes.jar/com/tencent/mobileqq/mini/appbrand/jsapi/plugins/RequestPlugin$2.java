package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.os.SystemClock;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.network.http.HttpCallBack;
import com.tencent.mobileqq.mini.network.http.MiniappHttpUtil;
import com.tencent.mobileqq.mini.network.http.RequestTask.Request;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05115;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05116;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.util.JSONUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.minigame.utils.NativeBuffer;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class RequestPlugin$2
  extends HttpCallBack
{
  String contentType;
  
  RequestPlugin$2(RequestPlugin paramRequestPlugin, RequestTask.Request paramRequest, String paramString1, JsRuntime paramJsRuntime, int paramInt, String paramString2) {}
  
  public void headersReceived(int paramInt, Map<String, List<String>> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("requestTaskId", this.val$request.mTaskId);
      localJSONObject.put("url", this.val$url);
      localJSONObject.put("errMsg", "ok");
      localJSONObject.put("statusCode", paramInt);
      localJSONObject.put("state", "headersReceived");
      localJSONObject.put("header", JSONUtil.headerToJson(paramMap));
      if ((paramMap != null) && (paramMap.containsKey("Content-Type")))
      {
        paramMap = (List)paramMap.get("Content-Type");
        if ((paramMap != null) && (paramMap.size() > 0)) {
          this.contentType = ((String)paramMap.get(0));
        }
      }
      this.val$jsRuntime.evaluateSubcribeJS("onRequestTaskStateChange", localJSONObject.toString(), 0);
      return;
    }
    catch (Exception paramMap)
    {
      QLog.e("[mini] http.RequestPlugin", 2, "headersReceived exception, url: " + this.val$request.mOriginUrl, paramMap);
    }
  }
  
  public void httpCallBack(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    localObject2 = (RequestTask.Request)RequestPlugin.access$300(this.this$0).remove(Integer.valueOf(this.val$request.mTaskId));
    long l2;
    Object localObject3;
    Object localObject1;
    if (localObject2 != null)
    {
      l2 = SystemClock.elapsedRealtime() - ((RequestTask.Request)localObject2).mRequestCreatedMillis;
      localObject3 = new StringBuilder().append("[request httpCallBack][minigame timecost=").append(l2).append("ms],[code=").append(paramInt).append("][url=").append(this.val$request.mUrl).append("][callbackId=").append(this.val$callbackId).append("][params=");
      if ((this.val$jsonParams == null) || (this.val$jsonParams.length() <= 1024)) {
        break label537;
      }
      localObject1 = this.val$jsonParams.substring(0, 1024);
    }
    for (;;)
    {
      QLog.i("[mini] http.RequestPlugin", 1, (String)localObject1 + "]");
      localObject2 = RequestPlugin.access$100(((RequestTask.Request)localObject2).mOriginUrl);
      QLog.d("[mini] http.RequestPlugin", 2, new Object[] { "httpCallBack second level domain ", localObject2 });
      label238:
      long l1;
      if ((this.this$0.jsPluginEngine != null) && (this.this$0.jsPluginEngine.appBrandRuntime != null) && (this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo() != null))
      {
        if (this.this$0.isMiniGameRuntime())
        {
          localObject1 = "1";
          MiniReportManager.reportEventType(this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig, 628, null, null, null, paramInt, (String)localObject1, l2, (String)localObject2);
          localObject1 = this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig;
          if (paramArrayOfByte == null) {
            break label554;
          }
          l1 = paramArrayOfByte.length;
          label297:
          MiniProgramLpReportDC05115.reportHttpRequestResult((MiniAppConfig)localObject1, paramInt, l1, l2);
          localObject1 = this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig;
          localObject2 = this.val$url;
          if (paramArrayOfByte == null) {
            break label560;
          }
          l1 = paramArrayOfByte.length;
          label340:
          MiniProgramLpReportDC05116.reportOneHttpOrDownloadRequest((MiniAppConfig)localObject1, (String)localObject2, l1, l2, paramInt, null);
        }
      }
      else
      {
        localObject3 = this.this$0.getEngine();
        localObject1 = new JSONObject();
        localObject2 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject1).put("url", this.val$url);
        if ((localObject3 != null) && (paramInt > 0))
        {
          ((JSONObject)localObject2).put("requestTaskId", this.val$request.mTaskId);
          ((JSONObject)localObject2).put("statusCode", paramInt);
          ((JSONObject)localObject2).put("state", "success");
          ((JSONObject)localObject2).put("errMsg", "ok");
          if (paramMap != null) {
            ((JSONObject)localObject2).put("header", JSONUtil.headerToJson(paramMap));
          }
          if (paramArrayOfByte != null)
          {
            if (!"arraybuffer".equals(this.val$request.mResponseType)) {
              break label682;
            }
            if (!this.this$0.isGameRuntime) {
              break label566;
            }
            NativeBuffer.packNativeBuffer(paramArrayOfByte, NativeBuffer.TYPE_BUFFER_NATIVE, "data", (JSONObject)localObject2, this.val$jsRuntime);
          }
        }
        for (;;)
        {
          ((JSONObject)localObject1).put("res", localObject2);
          this.val$jsRuntime.evaluateSubcribeJS("onRequestTaskStateChange", ((JSONObject)localObject2).toString(), 0);
          return;
          label537:
          localObject1 = this.val$jsonParams;
          break;
          localObject1 = "0";
          break label238;
          label554:
          l1 = 0L;
          break label297;
          label560:
          l1 = 0L;
          break label340;
          label566:
          NativeBuffer.packNativeBuffer(paramArrayOfByte, NativeBuffer.TYPE_BUFFER_BASE64, "data", (JSONObject)localObject2, null);
          continue;
          try
          {
            paramMap = new JSONObject();
            paramMap.put("state", "fail");
            paramMap.put("statusCode", "-1");
            paramMap.put("requestTaskId", this.val$request.mTaskId);
            paramMap.put("errMsg", "exception：" + paramArrayOfByte.getMessage());
            this.val$jsRuntime.evaluateSubcribeJS("onRequestTaskStateChange", paramMap.toString(), 0);
            QLog.e("[mini] http.RequestPlugin", 1, "httpCallBack exception:", paramArrayOfByte);
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
            GameLog.getInstance().e("[mini] http.RequestPlugin", "url: " + this.val$request.mUrl + "--mResponseType error ---" + this.val$request.mResponseType);
            paramArrayOfByte = new JSONObject();
            paramArrayOfByte.put("requestTaskId", this.val$request.mTaskId);
            paramArrayOfByte.put("state", "fail");
            paramArrayOfByte.put("statusCode", -1);
            this.val$jsRuntime.evaluateSubcribeJS("onRequestTaskStateChange", paramArrayOfByte.toString(), 0);
            continue;
            QLog.e("[mini] http.RequestPlugin", 1, "--fail--- url: " + this.val$request.mUrl + " taskId=" + this.val$request.mTaskId + " resCode=" + paramInt);
            paramArrayOfByte = new JSONObject();
            paramArrayOfByte.put("state", "fail");
            paramArrayOfByte.put("requestTaskId", this.val$request.mTaskId);
            MiniappHttpUtil.fillErrMsg("request", paramArrayOfByte, paramInt);
            this.val$jsRuntime.evaluateSubcribeJS("onRequestTaskStateChange", paramArrayOfByte.toString(), 0);
            return;
          }
          catch (Throwable paramMap)
          {
            break label671;
          }
        }
      }
      catch (Throwable paramArrayOfByte) {}
    }
  }
  
  public void onProgressUpdate(int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RequestPlugin.2
 * JD-Core Version:    0.7.0.1
 */