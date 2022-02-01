package com.tencent.mobileqq.profilecard.vas.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.VipTagView;

class VasProfileTagView$9
  extends AnimatorListenerAdapter
{
  VasProfileTagView$9(VasProfileTagView paramVasProfileTagView, boolean paramBoolean, VipTagView paramVipTagView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.val$needAddPraise) && (VasProfileTagView.access$1700(this.this$0).a.a != 0) && (this.val$tagView.getTag(2131375420) != null) && (this.val$tagView.getTag(2131375420).equals(Boolean.valueOf(true))))
    {
      this.val$tagView.setTag(2131375420, Boolean.valueOf(false));
      this.this$0.addLike(this.val$tagView, ((Long)this.val$tagView.getTag(2131375422)).longValue());
      return;
    }
    this.val$tagView.setShakingState(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.9
 * JD-Core Version:    0.7.0.1
 */