package com.tencent.mobileqq.vas.wallpaper.view;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class DrawHardwareWallpaperView
  extends AbstractDrawWallpaperView
{
  public DrawHardwareWallpaperView(SurfaceHolder paramSurfaceHolder)
  {
    super(paramSurfaceHolder);
  }
  
  Canvas a(SurfaceHolder paramSurfaceHolder)
  {
    return paramSurfaceHolder.lockHardwareCanvas();
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.view.DrawHardwareWallpaperView
 * JD-Core Version:    0.7.0.1
 */