package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.core.utils.MiniappHttpUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy.UploadListener;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class FileJsPlugin$3
  implements UploaderProxy.UploadListener
{
  FileJsPlugin$3(FileJsPlugin paramFileJsPlugin, int paramInt, RequestEvent paramRequestEvent, long paramLong, File paramFile) {}
  
  private void reportUploadResult(long paramLong, int paramInt)
  {
    if (FileJsPlugin.access$600(this.this$0)) {}
    for (String str = "1";; str = "0")
    {
      MiniReportManager.reportEventType(FileJsPlugin.access$700(this.this$0), 641, null, null, null, paramInt, str, paramLong, null);
      return;
    }
  }
  
  public void onUploadFailed(int paramInt, String paramString)
  {
    paramString = new JSONObject();
    try
    {
      paramString.put("uploadTaskId", this.val$uploadTaskId);
      paramString.put("state", "fail");
      MiniappHttpUtil.fillErrMsg("uploadFile", paramString, paramInt);
      reportUploadResult(System.currentTimeMillis() - this.val$startMS, paramInt);
      this.val$req.jsService.evaluateSubscribeJS("onUploadTaskStateChange", paramString.toString(), 0);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void onUploadHeadersReceived(int paramInt, Map<String, List<String>> paramMap)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uploadTaskId", this.val$uploadTaskId);
      localJSONObject.put("header", paramMap);
      localJSONObject.put("errMsg", "ok");
      localJSONObject.put("statusCode", paramInt);
      localJSONObject.put("state", "headersReceived");
      this.val$req.jsService.evaluateSubscribeJS("onUploadTaskStateChange", localJSONObject.toString(), 0);
      return;
    }
    catch (Exception paramMap)
    {
      QMLog.e("FileJsPlugin", "httpUpload--headersReceived fail---");
    }
  }
  
  public void onUploadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("uploadTaskId", this.val$uploadTaskId);
      localJSONObject1.put("totalBytesWritten", paramLong1);
      localJSONObject1.put("totalBytesExpectedWrite", paramLong2);
      localJSONObject1.put("totalBytesSent", paramLong1);
      localJSONObject1.put("totalBytesExpectedToSend", paramLong2);
      localJSONObject1.put("progress", paramFloat);
      localJSONObject1.put("state", "progressUpdate");
      this.val$req.jsService.evaluateSubscribeJS("onUploadTaskStateChange", localJSONObject1.toString(), 0);
      return;
    }
    catch (Exception localException)
    {
      try
      {
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("uploadTaskId", this.val$uploadTaskId);
        localJSONObject2.put("state", "fail");
        localJSONObject2.put("errMsg", localException.getMessage());
        this.val$req.jsService.evaluateSubscribeJS("onUploadTaskStateChange", localJSONObject2.toString(), 0);
        return;
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  public void onUploadSucceed(int paramInt, byte[] paramArrayOfByte, Map<String, List<String>> paramMap)
  {
    for (;;)
    {
      try
      {
        paramMap = new JSONObject();
        paramMap.put("uploadTaskId", this.val$uploadTaskId);
        paramMap.put("progress", 100);
        paramMap.put("totalBytesSent", this.val$uploadFile.length());
        paramMap.put("totalBytesExpectedToSend", this.val$uploadFile.length());
        paramMap.put("state", "progressUpdate");
        this.val$req.jsService.evaluateSubscribeJS("onUploadTaskStateChange", paramMap.toString(), 0);
        if (paramArrayOfByte != null) {
          continue;
        }
        paramArrayOfByte = "";
        paramMap = new JSONObject();
        paramMap.put("data", paramArrayOfByte);
        paramMap.put("uploadTaskId", this.val$uploadTaskId);
        paramMap.put("statusCode", paramInt);
        paramMap.put("state", "success");
        this.val$req.jsService.evaluateSubscribeJS("onUploadTaskStateChange", paramMap.toString(), 0);
      }
      catch (Exception paramArrayOfByte)
      {
        QMLog.e("FileJsPlugin", "httpUpload--onUploadSucceed fail---");
        continue;
      }
      reportUploadResult(System.currentTimeMillis() - this.val$startMS, paramInt);
      return;
      paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */