package com.tencent.mobileqq.nearby.profilecard.moment;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;

class NearbyMomentFragment$8
  implements URLDrawable.URLDrawableListener
{
  NearbyMomentFragment$8(NearbyMomentFragment paramNearbyMomentFragment) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (NearbyMomentFragment.d(this.a) == 2) {
      NearbyMomentFragment.e(this.a).setVisibility(8);
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (NearbyMomentFragment.d(this.a) == 2)
    {
      NearbyMomentFragment.e(this.a).setImageDrawable(paramURLDrawable);
      NearbyMomentFragment.e(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment.8
 * JD-Core Version:    0.7.0.1
 */