package com.tencent.mobileqq.profilecard.vas.view;

import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;

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
    if (VasProfileTagView.access$1500(this.this$0).allInOne.pa != 0) {
      this.val$tagView.setTagColor(this.this$0.getResources().getColor(2131166617), this.this$0.getResources().getColor(2131166615));
    }
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.6
 * JD-Core Version:    0.7.0.1
 */