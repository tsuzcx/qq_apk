package com.tencent.mobileqq.picbrowser;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;

class PicBrowserImage$2
  implements URLDrawableDownListener
{
  PicBrowserImage$2(PicBrowserImage paramPicBrowserImage, PicBrowserImage.OnLoadListener paramOnLoadListener, int paramInt) {}
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.a.a(this.b, false);
    this.a.a(this.b);
  }
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    if ((paramInt > 0) && (paramInt < 10000)) {
      this.a.b(this.b, paramInt / 100);
    }
  }
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    this.a.a(this.b, true);
    this.a.a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.picbrowser.PicBrowserImage.2
 * JD-Core Version:    0.7.0.1
 */