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

class FileJsPlugin$4
  implements UploaderProxy.UploadListener
{
  FileJsPlugin$4(FileJsPlugin paramFileJsPlugin, int paramInt, RequestEvent paramRequestEvent, long paramLong, File paramFile) {}
  
  private void reportUploadResult(long paramLong, int paramInt)
  {
    String str;
    if (FileJsPlugin.access$600(this.this$0)) {
      str = "1";
    } else {
      str = "0";
    }
    MiniReportManager.reportEventType(FileJsPlugin.access$700(this.this$0), 641, null, null, null, paramInt, str, paramLong, null);
  }
  
  public void onUploadFailed(int paramInt, String paramString)
  {
    paramString = new JSONObject();
    try
    {
      paramString.put("uploadTaskId", this.val$uploadTaskId);
      paramString.put("state", "fail");
      MiniappHttpUtil.fillErrMsg("uploadFile", paramString, paramInt);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    reportUploadResult(System.currentTimeMillis() - this.val$startMS, paramInt);
    this.val$req.jsService.evaluateSubscribeJS("onUploadTaskStateChange", paramString.toString(), 0);
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
      label73:
      break label73;
    }
    QMLog.e("FileJsPlugin", "httpUpload--headersReceived fail---");
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
    try
    {
      paramMap = new JSONObject();
      paramMap.put("uploadTaskId", this.val$uploadTaskId);
      paramMap.put("progress", 100);
      paramMap.put("totalBytesSent", this.val$uploadFile.length());
      paramMap.put("totalBytesExpectedToSend", this.val$uploadFile.length());
      paramMap.put("state", "progressUpdate");
      this.val$req.jsService.evaluateSubscribeJS("onUploadTaskStateChange", paramMap.toString(), 0);
      if (paramArrayOfByte == null) {
        paramArrayOfByte = "";
      } else {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
      }
      paramMap = new JSONObject();
      paramMap.put("data", paramArrayOfByte);
      paramMap.put("uploadTaskId", this.val$uploadTaskId);
      paramMap.put("statusCode", paramInt);
      paramMap.put("state", "success");
      this.val$req.jsService.evaluateSubscribeJS("onUploadTaskStateChange", paramMap.toString(), 0);
    }
    catch (Exception paramArrayOfByte)
    {
      label171:
      break label171;
    }
    QMLog.e("FileJsPlugin", "httpUpload--onUploadSucceed fail---");
    reportUploadResult(System.currentTimeMillis() - this.val$startMS, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */