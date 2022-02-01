package com.tencent.mobileqq.nearby.profilecard;

import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

class NearbyProfileDisplayTribePanel$5
  implements Animation.AnimationListener
{
  NearbyProfileDisplayTribePanel$5(NearbyProfileDisplayTribePanel paramNearbyProfileDisplayTribePanel) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == NearbyProfileDisplayTribePanel.i(this.a))
    {
      NearbyProfileDisplayTribePanel.e(this.a).setVisibility(8);
      NearbyProfileDisplayTribePanel.f(this.a).setVisibility(4);
      NearbyProfileDisplayTribePanel.e(this.a).clearAnimation();
      NearbyProfileDisplayTribePanel.f(this.a).clearAnimation();
      NearbyProfileDisplayTribePanel.g(this.a).setBackgroundResource(2130851108);
      NearbyProfileDisplayTribePanel.g(this.a).setTextColor(this.a.e.getResources().getColor(2131167662));
      NearbyProfileDisplayTribePanel.h(this.a).setTextColor(this.a.e.getResources().getColor(2131167662));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == NearbyProfileDisplayTribePanel.d(this.a))
    {
      NearbyProfileDisplayTribePanel.e(this.a).setVisibility(0);
      NearbyProfileDisplayTribePanel.f(this.a).setVisibility(0);
      NearbyProfileDisplayTribePanel.g(this.a).setBackgroundResource(2130853297);
      NearbyProfileDisplayTribePanel.g(this.a).setTextColor(this.a.e.getResources().getColor(2131167987));
      NearbyProfileDisplayTribePanel.h(this.a).setTextColor(this.a.e.getResources().getColor(2131167987));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.5
 * JD-Core Version:    0.7.0.1
 */