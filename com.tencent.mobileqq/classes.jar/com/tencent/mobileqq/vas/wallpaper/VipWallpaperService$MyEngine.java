package com.tencent.mobileqq.vas.wallpaper;

import android.app.WallpaperColors;
import android.service.wallpaper.WallpaperService.Engine;
import android.view.SurfaceHolder;

class VipWallpaperService$MyEngine
  extends WallpaperService.Engine
{
  private final WallpaperHelper b = new WallpaperHelper();
  
  private VipWallpaperService$MyEngine(VipWallpaperService paramVipWallpaperService)
  {
    super(paramVipWallpaperService);
  }
  
  public WallpaperColors onComputeColors()
  {
    return this.b.b();
  }
  
  public void onOffsetsChanged(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt1, int paramInt2)
  {
    super.onOffsetsChanged(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt1, paramInt2);
  }
  
  public void onSurfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onSurfaceChanged(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
    this.b.a(paramSurfaceHolder, paramInt1, paramInt2, paramInt3);
  }
  
  public void onSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    super.onSurfaceCreated(paramSurfaceHolder);
    this.b.a(this.a, paramSurfaceHolder);
  }
  
  public void onSurfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    super.onSurfaceDestroyed(paramSurfaceHolder);
    this.b.a();
  }
  
  public void onSurfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder)
  {
    super.onSurfaceRedrawNeeded(paramSurfaceHolder);
  }
  
  public void onVisibilityChanged(boolean paramBoolean)
  {
    super.onVisibilityChanged(paramBoolean);
    this.b.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.VipWallpaperService.MyEngine
 * JD-Core Version:    0.7.0.1
 */