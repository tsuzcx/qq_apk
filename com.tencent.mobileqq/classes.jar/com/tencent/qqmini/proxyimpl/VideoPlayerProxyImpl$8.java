package com.tencent.qqmini.proxyimpl;

import android.graphics.Bitmap;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCaptureImageListener;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnCaptureImageListener;

class VideoPlayerProxyImpl$8
  implements TVK_IMediaPlayer.OnCaptureImageListener
{
  VideoPlayerProxyImpl$8(VideoPlayerProxyImpl paramVideoPlayerProxyImpl, VideoPlayerProxy.OnCaptureImageListener paramOnCaptureImageListener) {}
  
  public void onCaptureImageFailed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2)
  {
    this.val$listener.onCaptureImageFailed(this.this$0);
  }
  
  public void onCaptureImageSucceed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    this.val$listener.onCaptureImageSucceed(this.this$0, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.VideoPlayerProxyImpl.8
 * JD-Core Version:    0.7.0.1
 */