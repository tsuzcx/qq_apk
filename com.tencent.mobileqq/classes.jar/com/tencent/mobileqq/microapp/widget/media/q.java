package com.tencent.mobileqq.microapp.widget.media;

import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import org.json.JSONException;
import org.json.JSONObject;

final class q
  implements TVK_IMediaPlayer.OnInfoListener
{
  q(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(this.a.a, 2, "video player PLAYER_INFO_START_BUFFERING--------------");
      }
      try
      {
        paramTVK_IMediaPlayer = new JSONObject();
        paramTVK_IMediaPlayer.put("data", this.a.b);
        this.a.c.evaluteJs("WeixinJSBridge.subscribeHandler(\"onVideoLoadStart\", " + paramTVK_IMediaPlayer + "," + this.a.d + ")");
      }
      catch (JSONException paramTVK_IMediaPlayer)
      {
        paramTVK_IMediaPlayer.printStackTrace();
      }
      continue;
      if (QLog.isColorLevel()) {
        QLog.d(this.a.a, 2, "video player PLAYER_INFO_ENDOF_BUFFERING--------------");
      }
      try
      {
        paramTVK_IMediaPlayer = new JSONObject();
        paramTVK_IMediaPlayer.put("data", this.a.b);
        this.a.c.evaluteJs("WeixinJSBridge.subscribeHandler(\"onVideoLoadedData\", " + paramTVK_IMediaPlayer + "," + this.a.d + ")");
      }
      catch (JSONException paramTVK_IMediaPlayer)
      {
        paramTVK_IMediaPlayer.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.q
 * JD-Core Version:    0.7.0.1
 */