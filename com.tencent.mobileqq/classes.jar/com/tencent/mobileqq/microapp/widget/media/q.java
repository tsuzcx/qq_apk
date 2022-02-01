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
    StringBuilder localStringBuilder;
    if (paramInt != 21)
    {
      if (paramInt == 22)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.a.a, 2, "video player PLAYER_INFO_ENDOF_BUFFERING--------------");
        }
        try
        {
          paramTVK_IMediaPlayer = new JSONObject();
          paramTVK_IMediaPlayer.put("data", this.a.b);
          paramObject = this.a.c;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("WeixinJSBridge.subscribeHandler(\"onVideoLoadedData\", ");
          localStringBuilder.append(paramTVK_IMediaPlayer);
          localStringBuilder.append(",");
          localStringBuilder.append(this.a.d);
          localStringBuilder.append(")");
          paramObject.evaluteJs(localStringBuilder.toString());
        }
        catch (JSONException paramTVK_IMediaPlayer)
        {
          paramTVK_IMediaPlayer.printStackTrace();
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.a, 2, "video player PLAYER_INFO_START_BUFFERING--------------");
      }
      try
      {
        paramTVK_IMediaPlayer = new JSONObject();
        paramTVK_IMediaPlayer.put("data", this.a.b);
        paramObject = this.a.c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("WeixinJSBridge.subscribeHandler(\"onVideoLoadStart\", ");
        localStringBuilder.append(paramTVK_IMediaPlayer);
        localStringBuilder.append(",");
        localStringBuilder.append(this.a.d);
        localStringBuilder.append(")");
        paramObject.evaluteJs(localStringBuilder.toString());
      }
      catch (JSONException paramTVK_IMediaPlayer)
      {
        paramTVK_IMediaPlayer.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.q
 * JD-Core Version:    0.7.0.1
 */