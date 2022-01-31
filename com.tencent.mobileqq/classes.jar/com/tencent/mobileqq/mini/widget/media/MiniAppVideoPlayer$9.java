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

class MiniAppVideoPlayer$9
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  MiniAppVideoPlayer$9(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    boolean bool = true;
    if ((!this.this$0.playingBefore) || (this.this$0.isPageOnBackground)) {
      return;
    }
    if ((this.this$0.serviceWebview instanceof GameJsRuntime)) {
      MiniAppVideoPlayer.access$2900(this.this$0, "waiting");
    }
    for (;;)
    {
      MiniAppVideoPlayer.access$3002(this.this$0, false);
      MiniAppVideoPlayer.access$3100(this.this$0, false);
      this.this$0.playingBefore = true;
      if (!MiniAppVideoPlayer.access$3200(this.this$0)) {
        break;
      }
      if (MiniAppVideoPlayer.access$1100(this.this$0).isPlaying()) {
        MiniAppVideoPlayer.access$1100(this.this$0).pause();
      }
      AppBrandTask.runTaskOnUiThread(new MiniAppVideoPlayer.9.1(this));
      MiniAppVideoPlayer.access$3202(this.this$0, false);
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
    MiniAppVideoPlayer.access$1100(this.this$0).start();
    this.this$0.postDelayed(new MiniAppVideoPlayer.9.2(this), 200L);
    if ((this.this$0.serviceWebview instanceof GameJsRuntime))
    {
      MiniAppVideoPlayer.access$2900(this.this$0, "play");
      MiniAppVideoPlayer.access$3300(this.this$0);
      AppBrandTask.runTaskOnUiThread(new MiniAppVideoPlayer.9.3(this));
      paramTVK_IMediaPlayer = new StringBuilder().append("onVideoPrepared: ").append(MiniAppVideoPlayer.access$1100(this.this$0).getDuration()).append(" ").append(MiniAppVideoPlayer.access$1100(this.this$0).getCurrentPostion()).append(" ");
      if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
        break label461;
      }
    }
    for (;;)
    {
      for (;;)
      {
        Log.i("MiniAppVideoPlayer", bool);
        MiniAppVideoPlayer.access$4000(this.this$0, 200L);
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
      label461:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.9
 * JD-Core Version:    0.7.0.1
 */