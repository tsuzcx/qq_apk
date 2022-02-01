package com.tencent.qqmini.proxyimpl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack;

class MediaPlayerSuperImpl$1
  implements ISPlayerVideoView.IVideoViewCallBack
{
  MediaPlayerSuperImpl$1(MediaPlayerSuperImpl paramMediaPlayerSuperImpl) {}
  
  public void onSurfaceChanged(Object paramObject)
  {
    QLog.i(MediaPlayerSuperImpl.a(this.a), 1, "[onSurfaceChanged]");
  }
  
  public void onSurfaceCreated(Object paramObject)
  {
    QLog.i(MediaPlayerSuperImpl.a(this.a), 1, "[onSurfaceCreated]");
  }
  
  public void onSurfaceDestroy(Object paramObject)
  {
    QLog.i(MediaPlayerSuperImpl.a(this.a), 1, "[onSurfaceDestroy]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MediaPlayerSuperImpl.1
 * JD-Core Version:    0.7.0.1
 */