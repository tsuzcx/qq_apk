package com.tencent.mobileqq.mini.widget.media;

import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppVideoPlayer$13
  implements TVK_IMediaPlayer.OnSeekCompleteListener
{
  MiniAppVideoPlayer$13(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    AppBrandTask.runTaskOnUiThread(new MiniAppVideoPlayer.13.1(this));
    try
    {
      paramTVK_IMediaPlayer = new JSONObject();
      paramTVK_IMediaPlayer.put("data", this.this$0.data);
      this.this$0.serviceWebview.evaluateSubcribeJS("onVideoSeeked", paramTVK_IMediaPlayer.toString(), this.this$0.webviewId);
      QLog.d("MiniAppVideoPlayer", 4, "evaluateSubcribeJS onVideoSeeked = " + paramTVK_IMediaPlayer.toString());
      return;
    }
    catch (JSONException paramTVK_IMediaPlayer)
    {
      paramTVK_IMediaPlayer.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.13
 * JD-Core Version:    0.7.0.1
 */