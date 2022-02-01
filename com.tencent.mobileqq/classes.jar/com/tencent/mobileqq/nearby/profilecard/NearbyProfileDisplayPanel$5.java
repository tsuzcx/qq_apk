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
    if (paramAnimation == NearbyProfileDisplayPanel.e(this.a))
    {
      if (NearbyProfileDisplayPanel.d(this.a) != null)
      {
        NearbyProfileDisplayPanel.d(this.a).setVisibility(8);
        NearbyProfileDisplayPanel.d(this.a).clearAnimation();
      }
      this.a.i.setBackgroundResource(2130851108);
      this.a.i.setTextColor(this.a.e.getResources().getColor(2131167662));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == NearbyProfileDisplayPanel.c(this.a))
    {
      if (NearbyProfileDisplayPanel.d(this.a) != null) {
        NearbyProfileDisplayPanel.d(this.a).setVisibility(0);
      }
      this.a.i.setBackgroundResource(2130853297);
      this.a.i.setTextColor(this.a.e.getResources().getColor(2131167987));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayPanel.5
 * JD-Core Version:    0.7.0.1
 */