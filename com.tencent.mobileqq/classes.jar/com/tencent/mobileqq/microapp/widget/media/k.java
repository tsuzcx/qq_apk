package com.tencent.mobileqq.microapp.widget.media;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnControllerClickListener;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo.RecommadInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import java.lang.ref.WeakReference;

final class k
  implements TVK_IMediaPlayer.OnControllerClickListener
{
  k(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void onAttationClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo) {}
  
  public void onBackClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    QLog.d(this.a.a, 2, "video player onBackClick");
    if ((Activity)this.a.m.get() == null) {
      return;
    }
    if (this.a.p) {
      this.a.g();
    }
  }
  
  public void onBackOnFullScreenClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    QLog.d(this.a.a, 2, "video player onBackOnFullScreenClick");
    if ((Activity)this.a.m.get() == null) {
      return;
    }
    if (this.a.p) {
      this.a.g();
    }
  }
  
  public void onCacheClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo) {}
  
  public void onFeedbackClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo) {}
  
  public void onFullScreenClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    if (this.a.p)
    {
      this.a.g();
      return;
    }
    MiniAppVideoPlayer.b(this.a);
  }
  
  public void onReopenClick(TVK_NetVideoInfo.RecommadInfo paramRecommadInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.media.k
 * JD-Core Version:    0.7.0.1
 */