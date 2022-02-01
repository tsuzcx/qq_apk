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
    TPLogUtil.i(AsyncMediaPlayerManager.a(this.a), "OnSurfaceChanged");
  }
  
  public void onSurfaceCreated(Object paramObject)
  {
    if ((AsyncMediaPlayerManager.a(this.a) != null) && (AsyncMediaPlayerManager.a(this.a) != null))
    {
      AsyncMediaPlayerManager.a(this.a).a(AsyncMediaPlayerManager.a(this.a).getViewSurface());
      TPLogUtil.i(AsyncMediaPlayerManager.a(this.a), "onSurfaceCreated: player setSurface");
      if (AsyncMediaPlayerManager.a(this.a) != null) {
        AsyncMediaPlayerManager.a(this.a).onSurfaceCreated();
      }
    }
  }
  
  public void onSurfaceDestroy(Object paramObject)
  {
    TPLogUtil.i(AsyncMediaPlayerManager.a(this.a), "OnSurfaceDestroy");
    if (AsyncMediaPlayerManager.a(this.a) != null) {
      AsyncMediaPlayerManager.a(this.a).a(null);
    }
    if (AsyncMediaPlayerManager.a(this.a) != null) {
      AsyncMediaPlayerManager.a(this.a).onSurfaceDestroyed();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.player.AsyncMediaPlayerManager.1
 * JD-Core Version:    0.7.0.1
 */