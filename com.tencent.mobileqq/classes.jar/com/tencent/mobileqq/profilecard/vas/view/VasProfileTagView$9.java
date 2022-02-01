package com.tencent.mobileqq.profilecard.vas.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;

class VasProfileTagView$9
  extends AnimatorListenerAdapter
{
  VasProfileTagView$9(VasProfileTagView paramVasProfileTagView, boolean paramBoolean, VipTagView paramVipTagView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.val$needAddPraise) && (VasProfileTagView.access$1600(this.this$0).allInOne.pa != 0) && (this.val$tagView.getTag(2131374938) != null) && (this.val$tagView.getTag(2131374938).equals(Boolean.valueOf(true))))
    {
      this.val$tagView.setTag(2131374938, Boolean.valueOf(false));
      paramAnimator = this.this$0;
      VipTagView localVipTagView = this.val$tagView;
      paramAnimator.addLike(localVipTagView, ((Long)localVipTagView.getTag(2131374940)).longValue());
      return;
    }
    this.val$tagView.setShakingState(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.9
 * JD-Core Version:    0.7.0.1
 */