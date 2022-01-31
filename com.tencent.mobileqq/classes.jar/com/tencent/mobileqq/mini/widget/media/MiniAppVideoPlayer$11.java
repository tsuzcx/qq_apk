package com.tencent.mobileqq.mini.widget.media;

import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameJsRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppVideoPlayer$11
  implements TVK_IMediaPlayer.OnErrorListener
{
  MiniAppVideoPlayer$11(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    QLog.e("MiniAppVideoPlayer", 1, "video onError: model=" + paramInt1 + " what=" + paramInt2 + " extra=" + paramInt3 + " detailInfo=" + paramString);
    if ((this.this$0.serviceWebview instanceof GameJsRuntime))
    {
      MiniAppVideoPlayer.access$2900(this.this$0, "error");
      return true;
    }
    try
    {
      paramTVK_IMediaPlayer = new JSONObject();
      paramTVK_IMediaPlayer.put("videoId", this.this$0.videoId);
      paramTVK_IMediaPlayer.put("data", this.this$0.data);
      this.this$0.serviceWebview.evaluateSubcribeJS("onVideoError", paramTVK_IMediaPlayer.toString(), this.this$0.webviewId);
      QLog.d("MiniAppVideoPlayer", 4, "evaluateSubcribeJS onVideoError = " + paramTVK_IMediaPlayer.toString());
      return true;
    }
    catch (JSONException paramTVK_IMediaPlayer)
    {
      paramTVK_IMediaPlayer.printStackTrace();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.11
 * JD-Core Version:    0.7.0.1
 */