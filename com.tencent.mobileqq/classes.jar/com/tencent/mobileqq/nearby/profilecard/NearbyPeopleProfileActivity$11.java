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
    NearbyPeopleProfileActivity.access$600(this.a).removeView(NearbyPeopleProfileActivity.access$500(this.a));
    if ((NearbyPeopleProfileActivity.access$300(this.a) != null) && (NearbyPeopleProfileActivity.access$300(this.a).h())) {
      this.a.updateProfile();
    }
    NearbyPeopleProfileActivity.access$300(this.a).c();
    NearbyPeopleProfileActivity.access$502(this.a, null);
    NearbyPeopleProfileActivity.access$302(this.a, null);
    if (NearbyPeopleProfileActivity.access$400(this.a) == null)
    {
      paramAnimation = this.a;
      NearbyPeopleProfileActivity.access$402(paramAnimation, paramAnimation.createNearbyDisplayPanel(paramAnimation.from));
      paramAnimation = this.a;
      NearbyPeopleProfileActivity.access$702(paramAnimation, NearbyPeopleProfileActivity.access$400(paramAnimation).a());
      NearbyPeopleProfileActivity.access$400(this.a).c();
      NearbyPeopleProfileActivity.access$600(this.a).addView(NearbyPeopleProfileActivity.access$700(this.a), new FrameLayout.LayoutParams(-1, -1));
    }
    NearbyPeopleProfileActivity.access$400(this.a).a(this.a.mCard);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity.11
 * JD-Core Version:    0.7.0.1
 */