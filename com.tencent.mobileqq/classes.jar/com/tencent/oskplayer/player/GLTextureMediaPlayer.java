package com.tencent.oskplayer.player;

import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.oskplayer.videorenderer.OnSurfaceSizeChangedListener;
import com.tencent.oskplayer.videorenderer.TextureSurfaceRenderer;
import com.tencent.oskplayer.videorenderer.VideoTextureRenderer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public class GLTextureMediaPlayer
  extends SegmentMediaPlayerProxy
{
  private static final String LOG_TAG = "GLTextureMediaPlayer";
  private TextureSurfaceRenderer videoRenderer;
  private Surface videoSurface;
  
  public GLTextureMediaPlayer(IMediaPlayer paramIMediaPlayer)
  {
    super(paramIMediaPlayer);
  }
  
  public OnSurfaceSizeChangedListener getSurfaceTextureListener()
  {
    return this.videoRenderer;
  }
  
  public void release()
  {
    super.release();
    if (this.videoRenderer != null) {
      this.videoRenderer.release();
    }
    if (this.videoSurface != null) {
      this.videoSurface.release();
    }
    this.videoRenderer = null;
  }
  
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    if (this.videoRenderer != null) {
      this.videoRenderer.release();
    }
    Object localObject = new CountDownLatch(1);
    this.videoRenderer = new VideoTextureRenderer((CountDownLatch)localObject, paramSurfaceTexture, paramInt1, paramInt2);
    paramSurfaceTexture = null;
    if (Build.VERSION.SDK_INT >= 14) {}
    for (;;)
    {
      try
      {
        ((CountDownLatch)localObject).await(800L, TimeUnit.MILLISECONDS);
        localObject = this.videoRenderer.getSurfaceTexture();
        paramSurfaceTexture = (SurfaceTexture)localObject;
        if (localObject != null)
        {
          this.videoSurface = new Surface((SurfaceTexture)localObject);
          this.mBackEndMediaPlayer.setSurface(this.videoSurface);
          paramSurfaceTexture = (SurfaceTexture)localObject;
        }
        if (paramSurfaceTexture != null) {
          break;
        }
        PlayerUtils.log(6, "GLTextureMediaPlayer", "SurfaceTexture is not available,timeout");
        throw new GLTextureMediaPlayer.GLTextureTimeoutException("init VideoTextureRenderer timeout");
      }
      catch (InterruptedException paramSurfaceTexture)
      {
        PlayerUtils.log(6, "GLTextureMediaPlayer", "SurfaceTexture is not available,interrupted");
        throw new GLTextureMediaPlayer.GLTextureTimeoutException("init VideoTextureRenderer timeout");
      }
      PlayerUtils.log(5, "GLTextureMediaPlayer", "SurfaceTexture is not supported");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.player.GLTextureMediaPlayer
 * JD-Core Version:    0.7.0.1
 */