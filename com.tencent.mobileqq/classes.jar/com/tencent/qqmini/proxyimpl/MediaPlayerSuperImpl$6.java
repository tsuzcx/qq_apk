package com.tencent.qqmini.proxyimpl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;

class MediaPlayerSuperImpl$6
  implements ISuperPlayer.OnErrorListener
{
  MediaPlayerSuperImpl$6(MediaPlayerSuperImpl paramMediaPlayerSuperImpl, IMediaPlayer.OnErrorListener paramOnErrorListener) {}
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramISuperPlayer = MediaPlayerSuperImpl.a(this.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[startPlay] onError  module:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" errorType:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("  errorCode:");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("  extraInfo:");
    localStringBuilder.append(paramString);
    QLog.i(paramISuperPlayer, 1, localStringBuilder.toString());
    return this.a.onError(this.b, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MediaPlayerSuperImpl.6
 * JD-Core Version:    0.7.0.1
 */