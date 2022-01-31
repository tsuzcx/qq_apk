package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.http.HttpCallBack;
import com.tencent.mobileqq.mini.http.MiniappHttpUtil;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

class FileJsPlugin$5
  extends HttpCallBack
{
  FileJsPlugin$5(FileJsPlugin paramFileJsPlugin, int paramInt, JsRuntime paramJsRuntime, long paramLong, WeakReference paramWeakReference, File paramFile) {}
  
  private void reportUploadResult(long paramLong, int paramInt)
  {
    if (this.this$0.isMiniGameRuntime()) {}
    for (String str = "1";; str = "0")
    {
      MiniReportManager.reportEventType(this.this$0.jsPluginEngine.appBrandRuntime.getApkgInfo().appConfig, 641, null, null, null, paramInt, str, paramLong, null);
      return;
    }
  }
  
  public void headersReceived(int paramInt, Map<String, List<String>> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uploadTaskId", this.val$uploadTaskId);
      localJSONObject.put("header", paramMap);
      localJSONObject.put("errMsg", "ok");
      localJSONObject.put("statusCode", paramInt);
      localJSONObject.put("state", "headersReceived");
      this.val$webview.evaluateSubcribeJS("onUploadTaskStateChange", localJSONObject.toString(), 0);
      return;
    }
    catch (Exception paramMap)
    {
      QLog.e("[mini] FileJsPlugin", 2, "httpUpload--headersReceived fail---");
    }
  }
  
  public void httpCallBack(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    QLog.d("[mini] FileJsPlugin", 1, "uploadTask httpCallBack! [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], resCode:" + paramInt);
    paramMap = (JsRuntime)this.val$webviewRef.get();
    if (paramMap == null) {
      return;
    }
    if (paramInt > 0) {}
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("uploadTaskId", this.val$uploadTaskId);
        localJSONObject.put("progress", 100);
        localJSONObject.put("totalBytesSent", this.val$uploadFile.length());
        localJSONObject.put("totalBytesExpectedToSend", this.val$uploadFile.length());
        localJSONObject.put("state", "progressUpdate");
        paramMap.evaluateSubcribeJS("onUploadTaskStateChange", localJSONObject.toString(), 0);
        if (paramArrayOfByte != null) {
          continue;
        }
        paramArrayOfByte = "";
        localJSONObject = new JSONObject();
        localJSONObject.put("data", paramArrayOfByte);
        localJSONObject.put("uploadTaskId", this.val$uploadTaskId);
        localJSONObject.put("statusCode", paramInt);
        localJSONObject.put("state", "success");
        paramMap.evaluateSubcribeJS("onUploadTaskStateChange", localJSONObject.toString(), 0);
      }
      catch (Throwable paramArrayOfByte)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("uploadTaskId", this.val$uploadTaskId);
          localJSONObject.put("state", "fail");
          localJSONObject.put("errMsg", paramArrayOfByte.getMessage());
          paramMap.evaluateSubcribeJS("onUploadTaskStateChange", localJSONObject.toString(), 0);
        }
        catch (Throwable paramArrayOfByte) {}
        continue;
      }
      reportUploadResult(System.currentTimeMillis() - this.val$startMS, paramInt);
      return;
      paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
      continue;
      paramArrayOfByte = new JSONObject();
      paramArrayOfByte.put("uploadTaskId", this.val$uploadTaskId);
      paramArrayOfByte.put("state", "fail");
      MiniappHttpUtil.fillErrMsg("uploadFile", paramArrayOfByte, paramInt);
      paramMap.evaluateSubcribeJS("onUploadTaskStateChange", paramArrayOfByte.toString(), 0);
    }
  }
  
  public void onProgressUpdate(int paramInt1, int paramInt2, int paramInt3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uploadTaskId", this.val$uploadTaskId);
      localJSONObject.put("totalBytesWritten", paramInt2);
      localJSONObject.put("totalBytesExpectedWrite", paramInt3);
      localJSONObject.put("totalBytesSent", paramInt2);
      localJSONObject.put("totalBytesExpectedToSend", paramInt3);
      localJSONObject.put("progress", paramInt1);
      localJSONObject.put("state", "progressUpdate");
      this.val$webview.evaluateSubcribeJS("onUploadTaskStateChange", localJSONObject.toString(), 0);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("[mini] FileJsPlugin", 2, "httpUpload--onProgressUpdate fail---");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */