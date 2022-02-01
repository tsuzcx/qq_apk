package com.tencent.mobileqq.mini.widget.media;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppVideoPlayer$12
  implements TVK_IMediaPlayer.OnInfoListener
{
  MiniAppVideoPlayer$12(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    QLog.i("MiniAppVideoPlayer", 1, "onInfo: " + paramInt + " " + paramObject);
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppVideoPlayer", 2, "video player PLAYER_INFO_START_BUFFERING--------------");
      }
      try
      {
        paramTVK_IMediaPlayer = new JSONObject();
        paramTVK_IMediaPlayer.put("data", this.this$0.data);
        this.this$0.serviceWebview.evaluateSubcribeJS("onVideoLoadStart", paramTVK_IMediaPlayer.toString(), this.this$0.webviewId);
        QLog.d("MiniAppVideoPlayer", 4, "evaluateSubcribeJS onVideoLoadStart = " + paramTVK_IMediaPlayer.toString());
      }
      catch (JSONException paramTVK_IMediaPlayer)
      {
        paramTVK_IMediaPlayer.printStackTrace();
      }
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppVideoPlayer", 2, "video player PLAYER_INFO_ENDOF_BUFFERING--------------");
      }
      try
      {
        paramTVK_IMediaPlayer = new JSONObject();
        paramTVK_IMediaPlayer.put("data", this.this$0.data);
        this.this$0.serviceWebview.evaluateSubcribeJS("onVideoLoadedData", paramTVK_IMediaPlayer.toString(), this.this$0.webviewId);
        QLog.d("MiniAppVideoPlayer", 4, "evaluateSubcribeJS onVideoLoadedData = " + paramTVK_IMediaPlayer.toString());
      }
      catch (JSONException paramTVK_IMediaPlayer)
      {
        paramTVK_IMediaPlayer.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.12
 * JD-Core Version:    0.7.0.1
 */