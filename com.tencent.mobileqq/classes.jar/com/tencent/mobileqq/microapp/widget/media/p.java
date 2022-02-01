package com.tencent.mobileqq.microapp.widget.media;

import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import org.json.JSONException;
import org.json.JSONObject;

final class p
  implements TVK_IMediaPlayer.OnErrorListener
{
  p(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    try
    {
      paramTVK_IMediaPlayer = new JSONObject();
      paramTVK_IMediaPlayer.put("data", this.a.b);
      this.a.c.evaluteJs("WeixinJSBridge.subscribeHandler(\"onVideoError\", " + paramTVK_IMediaPlayer + "," + this.a.d + ")");
      return true;
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
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.p
 * JD-Core Version:    0.7.0.1
 */