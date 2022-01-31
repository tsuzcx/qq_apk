package com.tencent.mobileqq.microapp.widget.media;

import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.microapp.appbrand.utils.a;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCompletionListener;
import org.json.JSONObject;

final class m
  implements TVK_IMediaPlayer.OnCompletionListener
{
  m(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (this.a.p) {
      a.a(new n(this));
    }
    try
    {
      paramTVK_IMediaPlayer = new JSONObject();
      paramTVK_IMediaPlayer.put("data", this.a.b);
      this.a.c.evaluteJs("WeixinJSBridge.subscribeHandler(\"onVideoEnded\", " + paramTVK_IMediaPlayer + "," + this.a.d + ")");
      a.a(new o(this));
      return;
    }
    catch (Exception paramTVK_IMediaPlayer)
    {
      paramTVK_IMediaPlayer.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.m
 * JD-Core Version:    0.7.0.1
 */