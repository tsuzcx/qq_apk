package cooperation.ilive.player;

import com.tencent.livesdk.livesdkplayer.IMediaPlayerMgr.OnSurfaceChangeListener;
import com.tencent.livesdk.livesdkplayer.renderview.ITPPlayerVideoViewBase;
import com.tencent.livesdk.livesdkplayer.renderview.ITPPlayerVideoViewBase.IVideoViewCallback;
import com.tencent.thumbplayer.utils.TPLogUtil;

class AsyncMediaPlayerManager$1
  implements ITPPlayerVideoViewBase.IVideoViewCallback
{
  AsyncMediaPlayerManager$1(AsyncMediaPlayerManager paramAsyncMediaPlayerManager) {}
  
  public void onSurfaceChanged(Object paramObject)
  {
    TPLogUtil.i(AsyncMediaPlayerManager.c(this.a), "OnSurfaceChanged");
  }
  
  public void onSurfaceCreated(Object paramObject)
  {
    if ((AsyncMediaPlayerManager.a(this.a) != null) && (AsyncMediaPlayerManager.b(this.a) != null))
    {
      AsyncMediaPlayerManager.a(this.a).a(AsyncMediaPlayerManager.b(this.a).getViewSurface());
      TPLogUtil.i(AsyncMediaPlayerManager.c(this.a), "onSurfaceCreated: player setSurface");
      if (AsyncMediaPlayerManager.d(this.a) != null) {
        AsyncMediaPlayerManager.d(this.a).onSurfaceCreated();
      }
    }
  }
  
  public void onSurfaceDestroy(Object paramObject)
  {
    TPLogUtil.i(AsyncMediaPlayerManager.c(this.a), "OnSurfaceDestroy");
    if (AsyncMediaPlayerManager.a(this.a) != null) {
      AsyncMediaPlayerManager.a(this.a).a(null);
    }
    if (AsyncMediaPlayerManager.d(this.a) != null) {
      AsyncMediaPlayerManager.d(this.a).onSurfaceDestroyed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.player.AsyncMediaPlayerManager.1
 * JD-Core Version:    0.7.0.1
 */