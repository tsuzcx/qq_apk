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

class FileJsPlugin$2$1
  implements DownloaderProxy.DownloadListener
{
  FileJsPlugin$2$1(FileJsPlugin.2 param2) {}
  
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
      FileJsPlugin.access$200(this.this$1.this$0, System.currentTimeMillis() - this.this$1.val$startMS, paramInt);
      MiniProgramLpReportDC05115.reportDownloadResult(FileJsPlugin.access$300(this.this$1.this$0), 0, System.currentTimeMillis() - this.this$1.val$startMS, true);
      MiniProgramLpReportDC05116.reportOneHttpOrDownloadRequest(FileJsPlugin.access$400(this.this$1.this$0), this.this$1.val$downloadUrl, System.currentTimeMillis() - this.this$1.val$startMS, paramInt, 0);
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
    FileJsPlugin.access$500(this.this$1.this$0, paramInt, paramString, paramDownloadResult, this.this$1.val$filePath, this.this$1.val$miniAppFileManager, this.this$1.val$fileType, this.this$1.val$downloadId, this.this$1.val$req, this.this$1.val$reqParamObj, this.this$1.val$tmpFilePath, this.this$1.val$startMS, this.this$1.val$downloadUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.2.1
 * JD-Core Version:    0.7.0.1
 */