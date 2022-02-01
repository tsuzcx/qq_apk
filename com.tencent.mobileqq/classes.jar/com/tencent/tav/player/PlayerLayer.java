package com.tencent.tav.player;

import android.graphics.SurfaceTexture;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Surface;

public class PlayerLayer
{
  private boolean needReleaseSurface = false;
  @Nullable
  private Player player;
  @NonNull
  Surface surface;
  int surfaceHeight;
  int surfaceWidth;
  
  public PlayerLayer(@NonNull SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    this.surface = new Surface(paramSurfaceTexture);
    this.needReleaseSurface = true;
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
  }
  
  public PlayerLayer(@NonNull Surface paramSurface, int paramInt1, int paramInt2)
  {
    this.surface = paramSurface;
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
  }
  
  @Nullable
  public Player getPlayer()
  {
    return this.player;
  }
  
  @NonNull
  public Surface getSurface()
  {
    return this.surface;
  }
  
  void release()
  {
    if (this.needReleaseSurface) {
      this.surface.release();
    }
  }
  
  public void setPlayer(@Nullable Player paramPlayer)
  {
    this.player = paramPlayer;
    if (paramPlayer != null) {
      paramPlayer.bindLayer(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.player.PlayerLayer
 * JD-Core Version:    0.7.0.1
 */