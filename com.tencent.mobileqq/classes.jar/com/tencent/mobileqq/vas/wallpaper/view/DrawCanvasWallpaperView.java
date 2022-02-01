package com.tencent.mobileqq.vas.wallpaper.view;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class DrawCanvasWallpaperView
  extends AbstractDrawWallpaperView
{
  public DrawCanvasWallpaperView(SurfaceHolder paramSurfaceHolder)
  {
    super(paramSurfaceHolder);
  }
  
  Canvas a(SurfaceHolder paramSurfaceHolder)
  {
    return paramSurfaceHolder.lockCanvas();
  }
  
  public boolean a()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.view.DrawCanvasWallpaperView
 * JD-Core Version:    0.7.0.1
 */