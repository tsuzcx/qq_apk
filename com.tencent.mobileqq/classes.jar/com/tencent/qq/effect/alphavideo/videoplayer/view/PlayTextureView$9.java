package com.tencent.qq.effect.alphavideo.videoplayer.view;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;

class PlayTextureView$9
  implements SurfaceTexture.OnFrameAvailableListener
{
  PlayTextureView$9(PlayTextureView paramPlayTextureView) {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    this.this$0.requestRender();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView.9
 * JD-Core Version:    0.7.0.1
 */