package com.tencent.mobileqq.mini.widget.media;

import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameJsRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import org.json.JSONObject;

class MiniAppVideoPlayer$10
  implements TVK_IMediaPlayer.OnCompletionListener
{
  MiniAppVideoPlayer$10(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (this.this$0.isFullScreen) {
      AppBrandTask.runTaskOnUiThread(new MiniAppVideoPlayer.10.1(this));
    }
    if ((this.this$0.serviceWebview instanceof GameJsRuntime)) {
      MiniAppVideoPlayer.access$2900(this.this$0, "ended");
    }
    for (;;)
    {
      AppBrandTask.runTaskOnUiThread(new MiniAppVideoPlayer.10.2(this));
      return;
      try
      {
        paramTVK_IMediaPlayer = new JSONObject();
        paramTVK_IMediaPlayer.put("data", this.this$0.data);
        paramTVK_IMediaPlayer.put("videoId", this.this$0.videoId);
        this.this$0.serviceWebview.evaluateSubcribeJS("onVideoEnded", paramTVK_IMediaPlayer.toString(), this.this$0.webviewId);
        QLog.d("MiniAppVideoPlayer", 4, "evaluateSubcribeJS onVideoEnded = " + paramTVK_IMediaPlayer.toString());
      }
      catch (Exception paramTVK_IMediaPlayer)
      {
        paramTVK_IMediaPlayer.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.10
 * JD-Core Version:    0.7.0.1
 */