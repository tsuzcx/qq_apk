package com.tencent.mobileqq.trooponline;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.common.config.AppSetting;

class TroopOnlineMemberBar$2
  implements ValueAnimator.AnimatorUpdateListener
{
  TroopOnlineMemberBar$2(TroopOnlineMemberBar paramTroopOnlineMemberBar) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    ((RelativeLayout.LayoutParams)this.a.d.getLayoutParams()).topMargin = paramValueAnimator.intValue();
    this.a.d.requestLayout();
    if ((paramValueAnimator.intValue() >= this.a.c.getResources().getDimensionPixelSize(2131299920)) && (AppSetting.e) && (this.a.d.getChildCount() > 0))
    {
      paramValueAnimator = this.a.d.getChildAt(0);
      if (paramValueAnimator != null) {
        paramValueAnimator.requestFocusFromTouch();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.TroopOnlineMemberBar.2
 * JD-Core Version:    0.7.0.1
 */