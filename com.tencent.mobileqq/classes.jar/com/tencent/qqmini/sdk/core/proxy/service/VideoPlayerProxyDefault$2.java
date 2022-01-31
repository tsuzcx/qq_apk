package com.tencent.qqmini.sdk.core.proxy.service;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;

class VideoPlayerProxyDefault$2
  implements TextureView.SurfaceTextureListener
{
  VideoPlayerProxyDefault$2(VideoPlayerProxyDefault paramVideoPlayerProxyDefault) {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    VideoPlayerProxyDefault.access$400(this.this$0).setSurface(new Surface(paramSurfaceTexture));
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerProxyDefault.2
 * JD-Core Version:    0.7.0.1
 */