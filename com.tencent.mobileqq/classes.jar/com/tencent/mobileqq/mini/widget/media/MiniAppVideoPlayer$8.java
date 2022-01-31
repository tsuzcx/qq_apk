package com.tencent.mobileqq.mini.widget.media;

import android.os.Looper;
import android.util.Log;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameJsRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppVideoPlayer$8
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  MiniAppVideoPlayer$8(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    boolean bool = true;
    if (!this.this$0.playingBefore) {
      return;
    }
    if ((this.this$0.serviceWebview instanceof GameJsRuntime)) {
      MiniAppVideoPlayer.access$2600(this.this$0, "waiting");
    }
    for (;;)
    {
      MiniAppVideoPlayer.access$2702(this.this$0, false);
      MiniAppVideoPlayer.access$2800(this.this$0, false);
      this.this$0.playingBefore = true;
      if (!MiniAppVideoPlayer.access$2900(this.this$0)) {
        break;
      }
      if (MiniAppVideoPlayer.access$800(this.this$0).isPlaying()) {
        MiniAppVideoPlayer.access$800(this.this$0).pause();
      }
      AppBrandTask.runTaskOnUiThread(new MiniAppVideoPlayer.8.1(this));
      MiniAppVideoPlayer.access$2902(this.this$0, false);
      return;
      try
      {
        paramTVK_IMediaPlayer = new JSONObject();
        paramTVK_IMediaPlayer.put("videoId", this.this$0.videoId);
        paramTVK_IMediaPlayer.put("data", this.this$0.data);
        this.this$0.serviceWebview.evaluateSubcribeJS("onVideoWaiting", paramTVK_IMediaPlayer.toString(), this.this$0.webviewId);
      }
      catch (JSONException paramTVK_IMediaPlayer)
      {
        paramTVK_IMediaPlayer.printStackTrace();
      }
    }
    MiniAppVideoPlayer.access$800(this.this$0).start();
    this.this$0.postDelayed(new MiniAppVideoPlayer.8.2(this), 200L);
    if ((this.this$0.serviceWebview instanceof GameJsRuntime))
    {
      MiniAppVideoPlayer.access$2600(this.this$0, "play");
      MiniAppVideoPlayer.access$3000(this.this$0);
      AppBrandTask.runTaskOnUiThread(new MiniAppVideoPlayer.8.3(this));
      paramTVK_IMediaPlayer = new StringBuilder().append("onVideoPrepared: ").append(MiniAppVideoPlayer.access$800(this.this$0).getDuration()).append(" ").append(MiniAppVideoPlayer.access$800(this.this$0).getCurrentPostion()).append(" ");
      if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
        break label451;
      }
    }
    for (;;)
    {
      for (;;)
      {
        Log.i("MiniAppVideoPlayer", bool);
        MiniAppVideoPlayer.access$3700(this.this$0, 200L);
        return;
        try
        {
          paramTVK_IMediaPlayer = new JSONObject();
          paramTVK_IMediaPlayer.put("videoId", this.this$0.videoId);
          paramTVK_IMediaPlayer.put("data", this.this$0.data);
          this.this$0.serviceWebview.evaluateSubcribeJS("onVideoPlay", paramTVK_IMediaPlayer.toString(), this.this$0.webviewId);
          QLog.d("MiniAppVideoPlayer", 4, "OnVideoPreparedListener - onVideoPrepared evaluateSubcribeJS onVideoPlay = " + paramTVK_IMediaPlayer.toString());
        }
        catch (JSONException paramTVK_IMediaPlayer)
        {
          paramTVK_IMediaPlayer.printStackTrace();
        }
      }
      break;
      label451:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.8
 * JD-Core Version:    0.7.0.1
 */