package com.tencent.qqmini.miniapp.widget.media;

import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener.DownloadResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppLivePusher$5
  implements DownloaderProxy.DownloadListener
{
  MiniAppLivePusher$5(MiniAppLivePusher paramMiniAppLivePusher, String paramString1, String paramString2, RequestEvent paramRequestEvent, String paramString3, JSONObject paramJSONObject, String paramString4, DownloaderProxy paramDownloaderProxy) {}
  
  public void onDownloadFailed(int paramInt, String paramString)
  {
    MiniAppLivePusher.access$300(this.this$0).remove(this.val$downloadId, this.val$BGMUrl);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("playBGM - download onDownloadFailed failed:");
    ((StringBuilder)localObject).append(paramString);
    QMLog.e("MiniAppLivePusher", ((StringBuilder)localObject).toString());
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("livePusherId", this.this$0.livePusherId);
      ((JSONObject)localObject).put("errMsg", paramString);
      ((JSONObject)localObject).put("errCode", 10003);
      if (this.this$0.miniAppContextRef != null) {
        paramString = (IMiniAppContext)this.this$0.miniAppContextRef.get();
      } else {
        paramString = null;
      }
      if (paramString != null) {
        paramString.performAction(ServiceSubscribeEvent.obtain("onLivePusherError", ((JSONObject)localObject).toString(), this.this$0.webviewId));
      }
      this.val$req.jsService.evaluateSubscribeJS("onLivePusherError", ((JSONObject)localObject).toString(), this.this$0.webviewId);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void onDownloadHeadersReceived(int paramInt, Map<String, List<String>> paramMap) {}
  
  public void onDownloadProgress(float paramFloat, long paramLong1, long paramLong2)
  {
    if (MiniAppLivePusher.access$500(this.this$0))
    {
      QMLog.d("MiniAppLivePusher", "playBGM - download onDownloadProgress, abort");
      this.val$downloaderProxy.abort(this.val$BGMUrl);
    }
  }
  
  public void onDownloadSucceed(int paramInt, String paramString, DownloaderProxy.DownloadListener.DownloadResult paramDownloadResult)
  {
    MiniAppLivePusher.access$400(this.this$0, paramString, this.val$BGMUrl, this.val$BGMFilePath, this.val$downloadId, this.val$jsonObject, this.val$operateName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.media.MiniAppLivePusher.5
 * JD-Core Version:    0.7.0.1
 */