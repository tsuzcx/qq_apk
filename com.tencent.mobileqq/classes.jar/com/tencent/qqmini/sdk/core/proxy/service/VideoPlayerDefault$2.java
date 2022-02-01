package com.tencent.qqmini.sdk.core.proxy.service;

import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;

class VideoPlayerDefault$2
  implements TextureView.SurfaceTextureListener
{
  VideoPlayerDefault$2(VideoPlayerDefault paramVideoPlayerDefault) {}
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    VideoPlayerDefault.access$400(this.this$0).setSurface(new Surface(paramSurfaceTexture));
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2) {}
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.VideoPlayerDefault.2
 * JD-Core Version:    0.7.0.1
 */