package com.tencent.mobileqq.vas.wallpaper.presenter;

import android.graphics.Rect;
import com.tencent.mobileqq.vas.wallpaper.contract.DrawWallpaperContract.Model;
import com.tencent.mobileqq.vas.wallpaper.contract.DrawWallpaperContract.Presenter;
import com.tencent.mobileqq.vas.wallpaper.contract.DrawWallpaperContract.View;

public class DrawWallpaperPresenter
  implements DrawWallpaperContract.Presenter
{
  private DrawWallpaperContract.Model a;
  private DrawWallpaperContract.View b;
  
  public DrawWallpaperPresenter(DrawWallpaperContract.Model paramModel, DrawWallpaperContract.View paramView)
  {
    this.a = paramModel;
    this.b = paramView;
  }
  
  public void a()
  {
    this.a.a(new DrawWallpaperPresenter.1(this));
    b();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.b.a(new Rect(0, 0, paramInt1, paramInt2));
  }
  
  public void b()
  {
    this.a.a();
  }
  
  public void c()
  {
    this.a.b();
  }
  
  public void d()
  {
    this.a.a(null);
    this.b.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.presenter.DrawWallpaperPresenter
 * JD-Core Version:    0.7.0.1
 */