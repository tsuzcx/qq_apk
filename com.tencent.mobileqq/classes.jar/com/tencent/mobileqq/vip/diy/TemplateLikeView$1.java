package com.tencent.mobileqq.vip.diy;

import android.view.ViewGroup;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class TemplateLikeView$1
  implements URLDrawable.URLDrawableListener
{
  TemplateLikeView$1(TemplateLikeView paramTemplateLikeView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.a.invalidate();
    this.a.b.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vip.diy.TemplateLikeView.1
 * JD-Core Version:    0.7.0.1
 */