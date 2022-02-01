package com.tencent.mobileqq.picbrowser;

import com.tencent.image.URLDrawable;

class PicBrowserImage$3
  implements Runnable
{
  PicBrowserImage$3(PicBrowserImage paramPicBrowserImage, URLDrawable paramURLDrawable, PicBrowserImage.OnLoadListener paramOnLoadListener, int paramInt) {}
  
  public void run()
  {
    if ((this.a.getStatus() != 1) && (this.a.getStatus() != 2)) {
      this.b.a(this.c, this.a.getProgress());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.picbrowser.PicBrowserImage.3
 * JD-Core Version:    0.7.0.1
 */