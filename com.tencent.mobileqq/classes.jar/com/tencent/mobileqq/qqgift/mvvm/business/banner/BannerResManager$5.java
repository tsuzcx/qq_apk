package com.tencent.mobileqq.qqgift.mvvm.business.banner;

import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class BannerResManager$5
  implements URLDrawable.URLDrawableListener
{
  BannerResManager$5(BannerResManager paramBannerResManager, URLDrawable paramURLDrawable, LoadHeadListener paramLoadHeadListener) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.b.a();
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = this.a.getCurrDrawable();
    if ((paramURLDrawable instanceof RegionDrawable))
    {
      paramURLDrawable = ((RegionDrawable)paramURLDrawable).getBitmap();
      BannerResManager.a(this.c, paramURLDrawable, this.b);
    }
    this.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.banner.BannerResManager.5
 * JD-Core Version:    0.7.0.1
 */