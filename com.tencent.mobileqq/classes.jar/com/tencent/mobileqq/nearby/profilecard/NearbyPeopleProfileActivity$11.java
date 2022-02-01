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
    NearbyPeopleProfileActivity.access$700(this.a).removeView(NearbyPeopleProfileActivity.access$600(this.a));
    NearbyPeopleProfileActivity.access$400(this.a).a();
    NearbyPeopleProfileActivity.access$602(this.a, null);
    NearbyPeopleProfileActivity.access$402(this.a, null);
    if (NearbyPeopleProfileActivity.access$500(this.a) == null)
    {
      paramAnimation = this.a;
      NearbyPeopleProfileActivity.access$502(paramAnimation, paramAnimation.createNearbyDisplayPanel(paramAnimation.from));
      paramAnimation = this.a;
      NearbyPeopleProfileActivity.access$802(paramAnimation, NearbyPeopleProfileActivity.access$500(paramAnimation).a());
      NearbyPeopleProfileActivity.access$500(this.a).a();
      NearbyPeopleProfileActivity.access$700(this.a).addView(NearbyPeopleProfileActivity.access$800(this.a), new FrameLayout.LayoutParams(-1, -1));
    }
    NearbyPeopleProfileActivity.access$500(this.a).a(NearbyPeopleProfileActivity.access$300(this.a));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.11
 * JD-Core Version:    0.7.0.1
 */