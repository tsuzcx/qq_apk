package com.tencent.mobileqq.nearby.profilecard.moment;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class NearbyMomentFragment$6
  implements URLDrawable.URLDrawableListener
{
  NearbyMomentFragment$6(NearbyMomentFragment paramNearbyMomentFragment) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.i("NearbyMomentFragment", 1, "onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (NearbyMomentFragment.a(this.a) == 1) {
      NearbyMomentFragment.a(this.a).setVisibility(8);
    }
    QLog.i("NearbyMomentFragment", 1, "onLoadFialed");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    QLog.i("NearbyMomentFragment", 1, "onLoadProgressed");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (NearbyMomentFragment.a(this.a) == 1)
    {
      NearbyMomentFragment.a(this.a).setImageDrawable(paramURLDrawable);
      NearbyMomentFragment.a(this.a).setVisibility(0);
    }
    QLog.i("NearbyMomentFragment", 1, "onLoadSuccessed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentFragment.6
 * JD-Core Version:    0.7.0.1
 */