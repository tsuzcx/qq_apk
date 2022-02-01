package com.tencent.mobileqq.nearby.profilecard;

import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.nearby.widget.AutoScrollImageView;

class NearbyProfileDisplayPanel$11
  implements URLDrawable.URLDrawableListener
{
  NearbyProfileDisplayPanel$11(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    if ((paramURLDrawable instanceof RegionDrawable))
    {
      paramURLDrawable = ((RegionDrawable)paramURLDrawable).getBitmap();
      NearbyProfileDisplayPanel.f(this.a).setImageBitmap(paramURLDrawable);
      NearbyProfileDisplayPanel.f(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.11
 * JD-Core Version:    0.7.0.1
 */