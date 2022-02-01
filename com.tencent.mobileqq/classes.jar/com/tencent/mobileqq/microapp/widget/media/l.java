package com.tencent.mobileqq.microapp.widget.media;

import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;
import org.json.JSONException;
import org.json.JSONObject;

final class l
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  l(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (!this.a.f) {
      return;
    }
    try
    {
      paramTVK_IMediaPlayer = new JSONObject();
      paramTVK_IMediaPlayer.put("data", this.a.b);
      this.a.c.evaluteJs("WeixinJSBridge.subscribeHandler(\"onVideoWaiting\", " + paramTVK_IMediaPlayer + "," + this.a.d + ")");
      this.a.f = true;
      MiniAppVideoPlayer.c(this.a).start();
      return;
    }
    catch (JSONException paramTVK_IMediaPlayer)
    {
      for (;;)
      {
        paramTVK_IMediaPlayer.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.l
 * JD-Core Version:    0.7.0.1
 */