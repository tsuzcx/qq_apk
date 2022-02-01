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
      ServiceWebview localServiceWebview = this.a.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WeixinJSBridge.subscribeHandler(\"onVideoWaiting\", ");
      localStringBuilder.append(paramTVK_IMediaPlayer);
      localStringBuilder.append(",");
      localStringBuilder.append(this.a.d);
      localStringBuilder.append(")");
      localServiceWebview.evaluteJs(localStringBuilder.toString());
    }
    catch (JSONException paramTVK_IMediaPlayer)
    {
      paramTVK_IMediaPlayer.printStackTrace();
    }
    paramTVK_IMediaPlayer = this.a;
    paramTVK_IMediaPlayer.f = true;
    MiniAppVideoPlayer.c(paramTVK_IMediaPlayer).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.l
 * JD-Core Version:    0.7.0.1
 */