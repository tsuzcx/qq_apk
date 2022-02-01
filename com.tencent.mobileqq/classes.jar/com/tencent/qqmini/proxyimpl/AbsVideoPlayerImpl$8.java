package com.tencent.qqmini.proxyimpl;

import android.graphics.Bitmap;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnCaptureImageListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener;

class AbsVideoPlayerImpl$8
  implements TVK_IMediaPlayer.OnCaptureImageListener
{
  AbsVideoPlayerImpl$8(AbsVideoPlayerImpl paramAbsVideoPlayerImpl, AbsVideoPlayer.OnCaptureImageListener paramOnCaptureImageListener) {}
  
  public void onCaptureImageFailed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAbsVideoPlayer$OnCaptureImageListener.onCaptureImageFailed();
  }
  
  public void onCaptureImageSucceed(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAbsVideoPlayer$OnCaptureImageListener.onCaptureImageSucceed(paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AbsVideoPlayerImpl.8
 * JD-Core Version:    0.7.0.1
 */