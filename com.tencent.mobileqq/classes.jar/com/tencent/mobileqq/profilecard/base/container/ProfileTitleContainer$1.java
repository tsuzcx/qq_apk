package com.tencent.mobileqq.profilecard.base.container;

import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.util.AnimateUtils.AnimationAdapter;
import com.tencent.widget.immersive.ImmersiveTitleBar2;

class ProfileTitleContainer$1
  extends AnimateUtils.AnimationAdapter
{
  ProfileTitleContainer$1(ProfileTitleContainer paramProfileTitleContainer) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (ProfileTitleContainer.access$000(this.this$0) != null)
    {
      if (paramAnimation == ProfileTitleContainer.access$300(this.this$0)) {
        ProfileTitleContainer.access$200(this.this$0, 1);
      }
      ProfileTitleContainer.access$000(this.this$0).clearAnimation();
      ProfileTitleContainer.access$400(this.this$0).clearAnimation();
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if ((ProfileTitleContainer.access$000(this.this$0) != null) && (paramAnimation == ProfileTitleContainer.access$100(this.this$0))) {
      ProfileTitleContainer.access$200(this.this$0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.container.ProfileTitleContainer.1
 * JD-Core Version:    0.7.0.1
 */