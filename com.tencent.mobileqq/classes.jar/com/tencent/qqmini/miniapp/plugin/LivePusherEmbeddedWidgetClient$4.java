package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

class LivePusherEmbeddedWidgetClient$4
  implements DownloaderProxy.DownloadListener
{
  LivePusherEmbeddedWidgetClient$4(LivePusherEmbeddedWidgetClient paramLivePusherEmbeddedWidgetClient, String paramString1, String paramString2, int paramInt, String paramString3, JSONObject paramJSONObject, String paramString4, DownloaderProxy paramDownloaderProxy) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    LivePusherEmbeddedWidgetClient.access$400(this.this$0, paramString, this.val$downloadId, this.val$bgmUrl, this.val$viewId);
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    if (LivePusherEmbeddedWidgetClient.access$600(this.this$0))
    {
      QMLog.d("miniapp-embedded-live-pusher", "playBGM - download onDownloadProgress, abort");
      this.val$downloaderProxy.abort(this.val$bgmUrl);
    }
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    LivePusherEmbeddedWidgetClient.access$500(this.this$0, paramInt, paramString, this.val$bgmFilePath, this.val$downloadId, this.val$jsonObject, this.val$type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.LivePusherEmbeddedWidgetClient.4
 * JD-Core Version:    0.7.0.1
 */