package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC05115;
import com.tencent.qqmini.sdk.report.MiniProgramLpReportDC05116;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class FileJsPlugin$3$1
  implements DownloaderProxy.DownloadListener
{
  FileJsPlugin$3$1(FileJsPlugin.3 param3) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("download failed! [minigame timecost:");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - this.a.val$startMS);
    ((StringBuilder)localObject).append("ms]");
    QMLog.d("FileJsPlugin", ((StringBuilder)localObject).toString());
    try
    {
      FileJsPlugin.access$100(this.a.this$0).remove(this.a.val$downloadId);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("downloadTaskId", this.a.val$downloadId);
      ((JSONObject)localObject).put("state", "fail");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Download Failed.");
      localStringBuilder.append(paramString);
      ((JSONObject)localObject).put("errMsg", localStringBuilder.toString());
      this.a.val$req.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", ((JSONObject)localObject).toString(), 0);
    }
    catch (Exception paramString)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("download onDownloadFailed failed.");
      ((StringBuilder)localObject).append(paramString);
      QMLog.e("FileJsPlugin", ((StringBuilder)localObject).toString());
    }
    FileJsPlugin.access$200(this.a.this$0, System.currentTimeMillis() - this.a.val$startMS, paramInt);
    MiniProgramLpReportDC05115.reportDownloadResult(FileJsPlugin.access$300(this.a.this$0), 0, System.currentTimeMillis() - this.a.val$startMS, true);
    MiniProgramLpReportDC05116.reportOneHttpOrDownloadRequest(FileJsPlugin.access$400(this.a.this$0), this.a.val$downloadUrl, System.currentTimeMillis() - this.a.val$startMS, paramInt, 0);
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap)
  {
    FileJsPlugin.access$000(this.a.this$0, paramMap, this.a.val$downloadId, this.a.val$req);
  }
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("downloadTaskId", this.a.val$downloadId);
      localJSONObject.put("progress", (int)(paramFloat * 100.0F));
      localJSONObject.put("totalBytesWritten", paramLong1);
      localJSONObject.put("totalBytesExpectedToWrite", paramLong2);
      localJSONObject.put("state", "progressUpdate");
      this.a.val$req.jsService.evaluateSubscribeJS("onDownloadTaskStateChange", localJSONObject.toString(), 0);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download onDownloadProgress failed.");
      localStringBuilder.append(localThrowable);
      QMLog.e("FileJsPlugin", localStringBuilder.toString());
    }
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("download Succeed! [minigame downloadTaskId:");
    localStringBuilder.append(this.a.val$downloadId);
    localStringBuilder.append(", timecost:");
    localStringBuilder.append(System.currentTimeMillis() - this.a.val$startMS);
    localStringBuilder.append("ms] + filePath=");
    localStringBuilder.append(this.a.val$filePath);
    QMLog.d("FileJsPlugin", localStringBuilder.toString());
    FileJsPlugin.access$500(this.a.this$0, paramInt, paramString, paramDownloadResult, this.a.val$filePath, this.a.val$miniAppFileManager, this.a.val$fileType, this.a.val$downloadId, this.a.val$req, this.a.val$reqParamObj, this.a.val$tmpFilePath, this.a.val$startMS, this.a.val$downloadUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.3.1
 * JD-Core Version:    0.7.0.1
 */