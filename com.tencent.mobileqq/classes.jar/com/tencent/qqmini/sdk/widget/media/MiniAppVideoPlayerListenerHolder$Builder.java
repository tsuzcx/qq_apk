package com.tencent.qqmini.sdk.widget.media;

import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCompletionListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnControllerClickListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnErrorListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnInfoListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnSeekCompleteListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoPreparedListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoViewInitListener;

public class MiniAppVideoPlayerListenerHolder$Builder
{
  MiniAppVideoPlayerListenerHolder holder = new MiniAppVideoPlayerListenerHolder();
  
  public MiniAppVideoPlayerListenerHolder build()
  {
    return this.holder;
  }
  
  public Builder setOnCaptureImageListener(AbsVideoPlayer.OnCaptureImageListener paramOnCaptureImageListener)
  {
    this.holder.onCaptureImageListener = paramOnCaptureImageListener;
    return this;
  }
  
  public Builder setOnCompletionListener(AbsVideoPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.holder.onCompletionListener = paramOnCompletionListener;
    return this;
  }
  
  public Builder setOnControllerClickListener(AbsVideoPlayer.OnControllerClickListener paramOnControllerClickListener)
  {
    this.holder.onControllerClickListener = paramOnControllerClickListener;
    return this;
  }
  
  public Builder setOnErrorListener(AbsVideoPlayer.OnErrorListener paramOnErrorListener)
  {
    this.holder.onErrorListener = paramOnErrorListener;
    return this;
  }
  
  public Builder setOnInfoListener(AbsVideoPlayer.OnInfoListener paramOnInfoListener)
  {
    this.holder.onInfoListener = paramOnInfoListener;
    return this;
  }
  
  public Builder setOnSeekCompleteListener(AbsVideoPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.holder.onSeekCompleteListener = paramOnSeekCompleteListener;
    return this;
  }
  
  public Builder setOnVideoPreparedListener(AbsVideoPlayer.OnVideoPreparedListener paramOnVideoPreparedListener)
  {
    this.holder.onVideoPreparedListener = paramOnVideoPreparedListener;
    return this;
  }
  
  public Builder setOnVideoViewInitListener(AbsVideoPlayer.OnVideoViewInitListener paramOnVideoViewInitListener)
  {
    this.holder.onVideoViewInitListener = paramOnVideoViewInitListener;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayerListenerHolder.Builder
 * JD-Core Version:    0.7.0.1
 */