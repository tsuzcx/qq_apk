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
    ((RelativeLayout.LayoutParams)this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.getLayoutParams()).topMargin = paramValueAnimator.intValue();
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.requestLayout();
    if (paramValueAnimator.intValue() <= -TroopOnlineMemberBar.jdField_a_of_type_Int + this.a.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(false);
      }
      this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetStoryHomeHorizontalListView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.TroopOnlineMemberBar.3
 * JD-Core Version:    0.7.0.1
 */