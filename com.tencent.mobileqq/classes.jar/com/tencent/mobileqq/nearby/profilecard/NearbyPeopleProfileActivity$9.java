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
    paramAnimation.mEnterEidtTimes += 1;
    if (NearbyPeopleProfileActivity.access$300(this.a) != null) {
      NearbyPeopleProfileActivity.access$300(this.a).a(this.a.mCard);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.9
 * JD-Core Version:    0.7.0.1
 */