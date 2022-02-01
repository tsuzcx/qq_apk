package com.tencent.mobileqq.profilecard.vas.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.PointF;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;
import java.util.List;

class VasProfileTagView$11
  extends AnimatorListenerAdapter
{
  VasProfileTagView$11(VasProfileTagView paramVasProfileTagView, View paramView, PointF paramPointF) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    VasProfileTagView.access$1806(this.this$0);
    paramAnimator = (RatioLayout.LayoutParams)this.val$child.getLayoutParams();
    if (paramAnimator != null)
    {
      if (this.val$child.getAnimation() != null) {
        this.val$child.clearAnimation();
      }
      if ((paramAnimator.a != this.val$pos.x) || (paramAnimator.b != this.val$pos.y))
      {
        paramAnimator.a = this.val$pos.x;
        paramAnimator.b = this.val$pos.y;
        this.val$child.setLayoutParams(paramAnimator);
        this.val$child.setTranslationX(0.0F);
        this.val$child.setTranslationY(0.0F);
        if ((this.val$child instanceof VipTagView)) {
          ((VipTagView)this.val$child).setShakingState(true);
        }
      }
      VasProfileTagView.access$402(this.this$0, false);
      if (VasProfileTagView.access$1800(this.this$0) == 0) {
        if (!this.this$0.checkTagUpdateFlag())
        {
          paramAnimator = VasProfileTagView.access$1900(this.this$0).a.getLabelList();
          if (paramAnimator != null)
          {
            if ((VasProfileTagView.access$500(this.this$0)[(VasProfileTagView.access$300().length - 1)] == null) || (paramAnimator.size() != 0)) {
              break label255;
            }
            VasProfileTagView.access$600(this.this$0).setVisibility(0);
          }
        }
      }
    }
    for (;;)
    {
      if (VasProfileTagView.access$2000(this.this$0))
      {
        this.this$0.updateJueban(VasProfileTagView.access$2100(this.this$0));
        VasProfileTagView.access$2002(this.this$0, false);
      }
      return;
      label255:
      VasProfileTagView.access$600(this.this$0).setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.11
 * JD-Core Version:    0.7.0.1
 */