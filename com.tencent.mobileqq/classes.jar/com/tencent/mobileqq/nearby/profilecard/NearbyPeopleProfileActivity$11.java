package com.tencent.mobileqq.nearby.profilecard;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;

class NearbyPeopleProfileActivity$11
  implements Animation.AnimationListener
{
  NearbyPeopleProfileActivity$11(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    NearbyPeopleProfileActivity.a(this.a).removeView(NearbyPeopleProfileActivity.a(this.a));
    NearbyPeopleProfileActivity.a(this.a).a();
    NearbyPeopleProfileActivity.a(this.a, null);
    NearbyPeopleProfileActivity.a(this.a, null);
    if (NearbyPeopleProfileActivity.a(this.a) == null)
    {
      NearbyPeopleProfileActivity.a(this.a, this.a.a(this.a.j));
      NearbyPeopleProfileActivity.b(this.a, NearbyPeopleProfileActivity.a(this.a).a());
      NearbyPeopleProfileActivity.a(this.a).a();
      NearbyPeopleProfileActivity.a(this.a).addView(NearbyPeopleProfileActivity.b(this.a), new FrameLayout.LayoutParams(-1, -1));
    }
    NearbyPeopleProfileActivity.a(this.a).a(NearbyPeopleProfileActivity.a(this.a));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.11
 * JD-Core Version:    0.7.0.1
 */