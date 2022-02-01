package com.tencent.mobileqq.vas.VasResEngine;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class VasResDrawable$1
  implements URLDrawable.URLDrawableListener
{
  VasResDrawable$1(VasResDrawable paramVasResDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null) {
      this.a.a = paramURLDrawable;
    }
    this.a.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasResEngine.VasResDrawable.1
 * JD-Core Version:    0.7.0.1
 */