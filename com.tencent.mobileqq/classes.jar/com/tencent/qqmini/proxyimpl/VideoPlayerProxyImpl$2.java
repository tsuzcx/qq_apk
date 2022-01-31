package com.tencent.qqmini.proxyimpl;

import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnControllerClickListener;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo.RecommadInfo;
import com.tencent.qqlive.mediaplayer.api.TVK_PlayerVideoInfo;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnControllerClickListener;

class VideoPlayerProxyImpl$2
  implements TVK_IMediaPlayer.OnControllerClickListener
{
  VideoPlayerProxyImpl$2(VideoPlayerProxyImpl paramVideoPlayerProxyImpl, VideoPlayerProxy.OnControllerClickListener paramOnControllerClickListener) {}
  
  public void onAttationClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    this.val$listener.onAttationClick(this.this$0);
  }
  
  public void onBackClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    this.val$listener.onBackClick(this.this$0);
  }
  
  public void onBackOnFullScreenClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    this.val$listener.onBackOnFullScreenClick(this.this$0);
  }
  
  public void onCacheClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    this.val$listener.onCacheClick(this.this$0);
  }
  
  public void onFeedbackClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    this.val$listener.onFeedbackClick(this.this$0);
  }
  
  public void onFullScreenClick(TVK_PlayerVideoInfo paramTVK_PlayerVideoInfo)
  {
    this.val$listener.onFullScreenClick(this.this$0);
  }
  
  public void onReopenClick(TVK_NetVideoInfo.RecommadInfo paramRecommadInfo) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoPlayerProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */