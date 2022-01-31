package com.tencent.mobileqq.mini.widget.media;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnControllerClickListener;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo.RecommadInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import java.lang.ref.WeakReference;

class MiniAppVideoPlayer$8
  implements TVK_IMediaPlayer.OnControllerClickListener
{
  MiniAppVideoPlayer$8(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onAttationClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo) {}
  
  public void onBackClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    QLog.d("MiniAppVideoPlayer", 2, "video player onBackClick");
    if ((Activity)this.this$0.atyRef.get() == null) {}
    while (!this.this$0.isFullScreen) {
      return;
    }
    this.this$0.smallScreen();
  }
  
  public void onBackOnFullScreenClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    QLog.d("MiniAppVideoPlayer", 2, "video player onBackOnFullScreenClick");
    if ((Activity)this.this$0.atyRef.get() == null) {}
    while (!this.this$0.isFullScreen) {
      return;
    }
    this.this$0.smallScreen();
  }
  
  public void onCacheClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo) {}
  
  public void onFeedbackClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo) {}
  
  public void onFullScreenClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    if (this.this$0.isFullScreen)
    {
      this.this$0.smallScreen();
      return;
    }
    this.this$0.fullScreen();
  }
  
  public void onReopenClick(TVK_NetVideoInfo.RecommadInfo paramRecommadInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.MiniAppVideoPlayer.8
 * JD-Core Version:    0.7.0.1
 */