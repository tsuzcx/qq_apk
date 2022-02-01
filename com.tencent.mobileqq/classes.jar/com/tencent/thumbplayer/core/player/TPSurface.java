package com.tencent.thumbplayer.core.player;

import android.graphics.SurfaceTexture;
import android.view.Surface;

public class TPSurface
  extends Surface
{
  private int mHeight = -1;
  private TPSurface.TPVideoCropInfo mVideoCropInfo;
  private int mWidth = -1;
  
  public TPSurface(SurfaceTexture paramSurfaceTexture)
  {
    super(paramSurfaceTexture);
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public TPSurface.TPVideoCropInfo getVideoCropInfo()
  {
    return this.mVideoCropInfo;
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
  }
  
  public void setVideoCropInfo(TPSurface.TPVideoCropInfo paramTPVideoCropInfo)
  {
    this.mVideoCropInfo = paramTPVideoCropInfo;
  }
  
  public void setWidth(int paramInt)
  {
    this.mWidth = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.core.player.TPSurface
 * JD-Core Version:    0.7.0.1
 */