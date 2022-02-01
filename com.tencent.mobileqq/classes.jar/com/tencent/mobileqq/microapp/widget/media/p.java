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
      paramString = this.a.c;
      paramObject = new StringBuilder();
      paramObject.append("WeixinJSBridge.subscribeHandler(\"onVideoError\", ");
      paramObject.append(paramTVK_IMediaPlayer);
      paramObject.append(",");
      paramObject.append(this.a.d);
      paramObject.append(")");
      paramString.evaluteJs(paramObject.toString());
    }
    catch (JSONException paramTVK_IMediaPlayer)
    {
      paramTVK_IMediaPlayer.printStackTrace();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.p
 * JD-Core Version:    0.7.0.1
 */