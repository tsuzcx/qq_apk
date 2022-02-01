package com.tencent.tav.player;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Surface;

public class PlayerLayer
{
  private boolean needReleaseSurface = false;
  @Nullable
  private Player player;
  private boolean readyForDisplay;
  private PlayerLayer.PlayerLayerReadyListener readyListener = null;
  @NonNull
  Surface surface;
  int surfaceHeight;
  int surfaceWidth;
  private int videoGravity;
  private Rect videoRect;
  
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
  
  public int getSurfaceHeight()
  {
    return this.surfaceHeight;
  }
  
  public int getSurfaceWidth()
  {
    return this.surfaceWidth;
  }
  
  public int getVideoGravity()
  {
    return this.videoGravity;
  }
  
  public Rect getVideoRect()
  {
    return this.videoRect;
  }
  
  public boolean isReadyForDisplay()
  {
    return this.readyForDisplay;
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
  
  public void setReadyForDisplay(PlayerLayer.PlayerLayerReadyListener paramPlayerLayerReadyListener)
  {
    this.readyListener = paramPlayerLayerReadyListener;
  }
  
  public void setVideoGravity(int paramInt)
  {
    this.videoGravity = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tav.player.PlayerLayer
 * JD-Core Version:    0.7.0.1
 */