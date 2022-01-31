package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bglu;
import bgok;
import bgph;
import bhck;
import com.tencent.qqmini.sdk.core.proxy.UploaderProxy.UploadListener;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class FileJsPlugin$3
  implements UploaderProxy.UploadListener
{
  FileJsPlugin$3(FileJsPlugin paramFileJsPlugin, int paramInt, bgok parambgok, long paramLong, File paramFile) {}
  
  private void reportUploadResult(long paramLong, int paramInt)
  {
    if (this.this$0.mIsMiniGame) {}
    for (String str = "1";; str = "0")
    {
      bhck.a(this.this$0.mMiniAppInfo, 641, null, null, null, paramInt, str, paramLong, null);
      return;
    }
  }
  
  public void onUploadFailed(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uploadTaskId", this.val$uploadTaskId);
      localJSONObject.put("statusCode", paramInt);
      localJSONObject.put("state", "fail:" + paramInt);
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("errMsg", paramString);
      }
      for (;;)
      {
        reportUploadResult(System.currentTimeMillis() - this.val$startMS, paramInt);
        this.val$req.a.a("onUploadTaskStateChange", localJSONObject.toString(), 0);
        return;
        bgph.a("uploadFile", localJSONObject, paramInt);
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
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
      this.val$req.a.a("onUploadTaskStateChange", localJSONObject.toString(), 0);
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
      this.val$req.a.a("onUploadTaskStateChange", localJSONObject1.toString(), 0);
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
        this.val$req.a.a("onUploadTaskStateChange", localJSONObject2.toString(), 0);
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
        this.val$req.a.a("onUploadTaskStateChange", paramMap.toString(), 0);
        if (paramArrayOfByte != null) {
          continue;
        }
        paramArrayOfByte = "";
        paramMap = new JSONObject();
        paramMap.put("data", paramArrayOfByte);
        paramMap.put("uploadTaskId", this.val$uploadTaskId);
        paramMap.put("statusCode", paramInt);
        paramMap.put("state", "success");
        this.val$req.a.a("onUploadTaskStateChange", paramMap.toString(), 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */