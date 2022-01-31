package com.tencent.mobileqq.mini.entry.desktop.widget;

import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class DesktopDittoImageArea$2
  implements URLDrawable.URLDrawableListener
{
  DesktopDittoImageArea$2(DesktopDittoImageArea paramDesktopDittoImageArea) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable != null) {
      QLog.e("DesktopDittoImageArea", 1, "onLoadFialed. url = " + paramURLDrawable.getURL());
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && ((paramURLDrawable.getCurrDrawable() instanceof GifDrawable)))
    {
      AbstractGifImage.resumeAll();
      this.this$0.invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.desktop.widget.DesktopDittoImageArea.2
 * JD-Core Version:    0.7.0.1
 */