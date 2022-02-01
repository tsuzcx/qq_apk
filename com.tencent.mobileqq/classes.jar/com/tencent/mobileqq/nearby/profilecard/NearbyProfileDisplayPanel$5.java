package com.tencent.mobileqq.nearby.profilecard;

import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

class NearbyProfileDisplayPanel$5
  implements Animation.AnimationListener
{
  NearbyProfileDisplayPanel$5(NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == NearbyProfileDisplayPanel.b(this.a))
    {
      NearbyProfileDisplayPanel.a(this.a).setVisibility(8);
      NearbyProfileDisplayPanel.a(this.a).clearAnimation();
      NearbyProfileDisplayPanel.a(this.a).setBackgroundResource(2130849538);
      NearbyProfileDisplayPanel.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166726));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == NearbyProfileDisplayPanel.a(this.a))
    {
      NearbyProfileDisplayPanel.a(this.a).setVisibility(0);
      NearbyProfileDisplayPanel.a(this.a).setBackgroundResource(2130851150);
      NearbyProfileDisplayPanel.a(this.a).setTextColor(this.a.a.getResources().getColor(2131167027));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.5
 * JD-Core Version:    0.7.0.1
 */