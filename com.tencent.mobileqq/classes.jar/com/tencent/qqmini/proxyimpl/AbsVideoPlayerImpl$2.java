package com.tencent.qqmini.proxyimpl;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnControllerClickListener;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo.RecommadInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnControllerClickListener;

class AbsVideoPlayerImpl$2
  implements TVK_IMediaPlayer.OnControllerClickListener
{
  AbsVideoPlayerImpl$2(AbsVideoPlayerImpl paramAbsVideoPlayerImpl, AbsVideoPlayer.OnControllerClickListener paramOnControllerClickListener) {}
  
  public void onAttationClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    this.a.onAttationClick(this.b);
  }
  
  public void onBackClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    this.a.onBackClick(this.b);
  }
  
  public void onBackOnFullScreenClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    this.a.onBackOnFullScreenClick(this.b);
  }
  
  public void onCacheClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    this.a.onCacheClick(this.b);
  }
  
  public void onFeedbackClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    this.a.onFeedbackClick(this.b);
  }
  
  public void onFullScreenClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    this.a.onFullScreenClick(this.b);
  }
  
  public void onReopenClick(TVK_NetVideoInfo.RecommadInfo paramRecommadInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AbsVideoPlayerImpl.2
 * JD-Core Version:    0.7.0.1
 */