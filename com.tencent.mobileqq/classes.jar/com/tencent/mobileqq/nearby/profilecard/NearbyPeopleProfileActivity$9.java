package com.tencent.mobileqq.nearby.profilecard;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class NearbyPeopleProfileActivity$9
  implements Animation.AnimationListener
{
  NearbyPeopleProfileActivity$9(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.a;
    paramAnimation.k += 1;
    if (NearbyPeopleProfileActivity.a(this.a) != null) {
      NearbyPeopleProfileActivity.a(this.a).a(NearbyPeopleProfileActivity.a(this.a));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.9
 * JD-Core Version:    0.7.0.1
 */