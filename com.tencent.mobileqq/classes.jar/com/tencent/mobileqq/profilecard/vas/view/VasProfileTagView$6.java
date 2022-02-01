package com.tencent.mobileqq.profilecard.vas.view;

import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.VipTagView;

class VasProfileTagView$6
  implements Animation.AnimationListener
{
  VasProfileTagView$6(VasProfileTagView paramVasProfileTagView, VipTagView paramVipTagView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.doTagSpringBack(this.val$tagView, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (VasProfileTagView.access$1600(this.this$0).a.a != 0) {
      this.val$tagView.setTagColor(this.this$0.getResources().getColor(2131166602), this.this$0.getResources().getColor(2131166600));
    }
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.6
 * JD-Core Version:    0.7.0.1
 */