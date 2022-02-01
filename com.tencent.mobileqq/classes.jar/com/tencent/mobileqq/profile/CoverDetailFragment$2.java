package com.tencent.mobileqq.profile;

import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class CoverDetailFragment$2
  implements URLDrawable.URLDrawableListener
{
  CoverDetailFragment$2(CoverDetailFragment paramCoverDetailFragment) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    CoverDetailFragment.b(this.a).setImageDrawable(this.a.a(paramURLDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.CoverDetailFragment.2
 * JD-Core Version:    0.7.0.1
 */