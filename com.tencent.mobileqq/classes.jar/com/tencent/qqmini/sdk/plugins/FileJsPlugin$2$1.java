package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.JSONUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC05115;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC05116;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

class FileJsPlugin$2$1
  implements DownloaderProxy.DownloadListener
{
  FileJsPlugin$2$1(FileJsPlugin.2 param2) {}
  
  private void reportDownloadFileResult(long paramLong, int paramInt)
  {
    if (FileJsPlugin.access$600(this.this$1.this$0)) {}
    for (String str = "1";; str = "0")
    {
      MiniReportManager.reportEventType(FileJsPlugin.access$700(this.this$1.this$0), 640, null, null, null, paramInt, str, paramLong, null);
      return;
    }
  }
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    QMLog.d("FileJsPlugin", "download failed! [minigame timecost:" + (System.currentTimeMillis() - this.this$1.val$startMS) + "ms]");
    try
    {
      FileJsPlugin.access$100(this.this$1.this$0).remove(this.this$1.val$downloadId);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("downloadTaskId", this.this$1.val$downloadId);
      localJSONObject.put("state", "fail");
      localJSONObject.put("errMsg", "Download Failed." + paramString);
      this.this$1.val$req.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", localJSONObject.toString(), 0);
      reportDownloadFileResult(System.currentTimeMillis() - this.this$1.val$startMS, paramInt);
      MiniProgramLpReportDC05115.reportDownloadResult(FileJsPlugin.access$200(this.this$1.this$0), 0, System.currentTimeMillis() - this.this$1.val$startMS, true);
      MiniProgramLpReportDC05116.reportOneHttpOrDownloadRequest(FileJsPlugin.access$300(this.this$1.this$0), this.this$1.val$downloadUrl, System.currentTimeMillis() - this.this$1.val$startMS, paramInt, 0);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QMLog.e("FileJsPlugin", "download onDownloadFailed failed." + paramString);
      }
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap)
  {
    FileJsPlugin.access$000(this.this$1.this$0, paramMap, this.this$1.val$downloadId, this.this$1.val$req);
  }
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("downloadTaskId", this.this$1.val$downloadId);
      localJSONObject.put("progress", (int)(100.0F * paramFloat));
      localJSONObject.put("totalBytesWritten", paramLong1);
      localJSONObject.put("totalBytesExpectedToWrite", paramLong2);
      localJSONObject.put("state", "progressUpdate");
      this.this$1.val$req.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", localJSONObject.toString(), 0);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("FileJsPlugin", "download onDownloadProgress failed." + localThrowable);
    }
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    QMLog.d("FileJsPlugin", "download Succeed! [minigame downloadTaskId:" + this.this$1.val$downloadId + ", timecost:" + (System.currentTimeMillis() - this.this$1.val$startMS) + "ms] + filePath=" + this.this$1.val$filePath);
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(this.this$1.val$filePath))
        {
          localObject2 = new File(this.this$1.val$filePath);
          localObject1 = localObject2;
          if (!((File)localObject2).exists())
          {
            boolean bool = TextUtils.isEmpty(paramString);
            localObject1 = localObject2;
            if (bool) {}
          }
        }
      }
      catch (Exception paramString)
      {
        File localFile;
        QMLog.e("FileJsPlugin", "download onDownloadSucceed exception.", paramString);
        paramDownloadResult = new JSONObject();
        try
        {
          FileJsPlugin.access$100(this.this$1.this$0).remove(this.this$1.val$downloadId);
          paramDownloadResult.put("downloadTaskId", this.this$1.val$downloadId);
          paramDownloadResult.put("state", "fail");
          paramDownloadResult.put("errMsg", "Download Failed.");
          this.this$1.val$req.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", paramDownloadResult.toString(), 0);
        }
        catch (JSONException paramDownloadResult)
        {
          QMLog.e("FileJsPlugin", "download onDownloadSucceed callback fail exception.", paramString);
        }
        continue;
        QMLog.d("FileJsPlugin", "download failed, filepath not exists, tmpFile:" + this.this$1.val$tmpFilePath);
        FileJsPlugin.access$100(this.this$1.this$0).remove(this.this$1.val$downloadId);
        paramString = new JSONObject();
        paramString.put("downloadTaskId", this.this$1.val$downloadId);
        paramString.put("state", "fail");
        paramString.put("errMsg", "Download Failed: file not exists or can not read.");
        this.this$1.val$req.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", paramString.toString(), 0);
        continue;
      }
      try
      {
        localFile = new File(paramString);
        localObject1 = localObject2;
        if (localFile.exists())
        {
          localObject1 = localObject2;
          if (localFile.isFile())
          {
            localObject1 = localObject2;
            if (localFile.length() > 0L)
            {
              QMLog.w("FileJsPlugin", "download Succeed but target file not exists, try copy from download tmp file:" + paramString + ", length:" + localFile.length() + ", to:" + this.this$1.val$filePath);
              localObject1 = FileUtils.createFile(this.this$1.val$filePath);
              localObject2 = localObject1;
            }
          }
        }
        try
        {
          if ((FileUtils.copyFile(localFile, (File)localObject2)) && (((File)localObject2).exists()) && (((File)localObject2).length() == localFile.length()))
          {
            QMLog.i("FileJsPlugin", "copy from download tmp file:" + paramString + " success");
            localObject1 = localObject2;
            if ((!((File)localObject1).exists()) || (!((File)localObject1).canRead())) {
              continue;
            }
            localObject2 = FileJsPlugin.getOutFilePath(paramDownloadResult, this.this$1.val$filePath);
            this.this$1.val$miniAppFileManager.updateFolderSize(this.this$1.val$fileType, ((File)localObject1).length());
            paramString = new JSONObject();
            paramString.put("downloadTaskId", this.this$1.val$downloadId);
            paramString.put("progress", 100);
            paramString.put("totalBytesWritten", ((File)localObject1).length());
            paramString.put("totalBytesExpectedToWrite", ((File)localObject1).length());
            paramString.put("state", "progressUpdate");
            this.this$1.val$req.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", paramString.toString(), 0);
            QMLog.d("FileJsPlugin", "download success.");
            paramString = new JSONObject();
          }
        }
        catch (Throwable localThrowable1)
        {
          localObject1 = localObject2;
          localObject2 = localThrowable1;
        }
      }
      catch (Throwable localThrowable2)
      {
        localObject1 = localObject2;
        localObject2 = localThrowable2;
        continue;
      }
      try
      {
        paramDownloadResult = JSONUtil.headerToJson(paramDownloadResult.headers);
        paramString = paramDownloadResult;
      }
      catch (Exception paramDownloadResult)
      {
        QMLog.e("FileJsPlugin", "onDownloadSucceed headerJson error." + paramDownloadResult);
        continue;
        paramDownloadResult.put("filePath", this.this$1.val$reqParamObj.optString("filePath"));
        continue;
      }
      FileJsPlugin.access$100(this.this$1.this$0).remove(this.this$1.val$downloadId);
      paramDownloadResult = new JSONObject();
      paramDownloadResult.put("statusCode", 200);
      paramDownloadResult.put("downloadTaskId", this.this$1.val$downloadId);
      if ((!this.this$1.val$reqParamObj.isNull("filePath")) && (!TextUtils.isEmpty(this.this$1.val$reqParamObj.optString("filePath")))) {
        continue;
      }
      paramDownloadResult.put("tempFilePath", this.this$1.val$miniAppFileManager.getWxFilePath((String)localObject2));
      paramDownloadResult.put("header", paramString);
      paramDownloadResult.put("state", "success");
      this.this$1.val$req.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", paramDownloadResult.toString(), 0);
      reportDownloadFileResult(System.currentTimeMillis() - this.this$1.val$startMS, paramInt);
      MiniProgramLpReportDC05115.reportDownloadResult(FileJsPlugin.access$400(this.this$1.this$0), 0, System.currentTimeMillis() - this.this$1.val$startMS, false);
      MiniProgramLpReportDC05116.reportOneHttpOrDownloadRequest(FileJsPlugin.access$500(this.this$1.this$0), this.this$1.val$downloadUrl, System.currentTimeMillis() - this.this$1.val$startMS, paramInt, 0);
      return;
      localObject1 = localObject2;
      if (((File)localObject2).exists())
      {
        ((File)localObject2).delete();
        localObject1 = localObject2;
        continue;
        QMLog.e("FileJsPlugin", "try copy from download tmp file exception! tmp file:" + paramString, (Throwable)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */