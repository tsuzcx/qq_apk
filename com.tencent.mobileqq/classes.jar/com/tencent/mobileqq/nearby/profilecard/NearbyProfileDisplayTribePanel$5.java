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
    if (paramAnimation == NearbyProfileDisplayTribePanel.b(this.a))
    {
      NearbyProfileDisplayTribePanel.a(this.a).setVisibility(8);
      NearbyProfileDisplayTribePanel.a(this.a).setVisibility(4);
      NearbyProfileDisplayTribePanel.a(this.a).clearAnimation();
      NearbyProfileDisplayTribePanel.a(this.a).clearAnimation();
      NearbyProfileDisplayTribePanel.a(this.a).setBackgroundResource(2130849538);
      NearbyProfileDisplayTribePanel.a(this.a).setTextColor(this.a.a.getResources().getColor(2131166726));
      NearbyProfileDisplayTribePanel.b(this.a).setTextColor(this.a.a.getResources().getColor(2131166726));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == NearbyProfileDisplayTribePanel.a(this.a))
    {
      NearbyProfileDisplayTribePanel.a(this.a).setVisibility(0);
      NearbyProfileDisplayTribePanel.a(this.a).setVisibility(0);
      NearbyProfileDisplayTribePanel.a(this.a).setBackgroundResource(2130851150);
      NearbyProfileDisplayTribePanel.a(this.a).setTextColor(this.a.a.getResources().getColor(2131167027));
      NearbyProfileDisplayTribePanel.b(this.a).setTextColor(this.a.a.getResources().getColor(2131167027));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.5
 * JD-Core Version:    0.7.0.1
 */