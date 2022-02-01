package com.tencent.mobileqq.qqlive.player;

import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView.IVideoViewCallback;
import com.tencent.mobileqq.qqlive.view.TPPlayerVideoView;
import com.tencent.qphone.base.util.QLog;

class AsyncMediaPlayerManager$1
  implements ITPPlayerVideoView.IVideoViewCallback
{
  AsyncMediaPlayerManager$1(AsyncMediaPlayerManager paramAsyncMediaPlayerManager) {}
  
  public void onSurfaceChanged(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i(AsyncMediaPlayerManager.c(this.a), 1, "OnSurfaceChanged");
    }
  }
  
  public void onSurfaceCreated(Object paramObject)
  {
    if ((AsyncMediaPlayerManager.a(this.a) != null) && (AsyncMediaPlayerManager.b(this.a) != null))
    {
      AsyncMediaPlayerManager.a(this.a).a(AsyncMediaPlayerManager.b(this.a).getViewSurface());
      if (QLog.isColorLevel()) {
        QLog.i(AsyncMediaPlayerManager.c(this.a), 1, "onSurfaceCreated: player setSurface");
      }
    }
  }
  
  public void onSurfaceDestroy(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i(AsyncMediaPlayerManager.c(this.a), 1, "OnSurfaceDestroy");
    }
    if (AsyncMediaPlayerManager.a(this.a) != null) {
      AsyncMediaPlayerManager.a(this.a).a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.player.AsyncMediaPlayerManager.1
 * JD-Core Version:    0.7.0.1
 */