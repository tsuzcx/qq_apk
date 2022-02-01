package com.tencent.mobileqq.trooponline;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.mobileqq.troop.data.TroopAioTips;

class TroopOnlineMemberBar$3
  implements ValueAnimator.AnimatorUpdateListener
{
  TroopOnlineMemberBar$3(TroopOnlineMemberBar paramTroopOnlineMemberBar) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    ((RelativeLayout.LayoutParams)this.a.d.getLayoutParams()).topMargin = paramValueAnimator.intValue();
    this.a.d.requestLayout();
    if (paramValueAnimator.intValue() <= -TroopOnlineMemberBar.a + this.a.c.getResources().getDimensionPixelSize(2131299920))
    {
      if (this.a.m != null) {
        this.a.m.a(false);
      }
      this.a.d.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.TroopOnlineMemberBar.3
 * JD-Core Version:    0.7.0.1
 */