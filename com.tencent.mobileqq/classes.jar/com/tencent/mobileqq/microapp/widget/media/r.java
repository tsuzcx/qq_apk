package com.tencent.mobileqq.microapp.widget.media;

import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnSeekCompleteListener;
import org.json.JSONException;
import org.json.JSONObject;

final class r
  implements TVK_IMediaPlayer.OnSeekCompleteListener
{
  r(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onSeekComplete(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    try
    {
      paramTVK_IMediaPlayer = new JSONObject();
      paramTVK_IMediaPlayer.put("data", this.a.b);
      this.a.c.evaluteJs("WeixinJSBridge.subscribeHandler(\"onVideoSeeked\", " + paramTVK_IMediaPlayer + "," + this.a.d + ")");
      return;
    }
    catch (JSONException paramTVK_IMediaPlayer)
    {
      paramTVK_IMediaPlayer.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.r
 * JD-Core Version:    0.7.0.1
 */