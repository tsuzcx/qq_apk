package com.tencent.mobileqq.kandian.biz.daily;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.qphone.base.util.QLog;

class DailyTipsFoldUtils$1$1
  implements ValueAnimator.AnimatorUpdateListener
{
  DailyTipsFoldUtils$1$1(DailyTipsFoldUtils.1 param1, View paramView, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F - f);
    int i = (int)(this.jdField_a_of_type_Int * f);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyDailyTipsFoldUtils$1.a.smoothScrollToPositionFromTop(this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyDailyTipsFoldUtils$1.a.getHeaderViewsCount(), -i, 0);
    if (QLog.isColorLevel())
    {
      paramValueAnimator = new StringBuilder();
      paramValueAnimator.append("percent = ");
      paramValueAnimator.append(f);
      paramValueAnimator.append(", scrollHeight = ");
      paramValueAnimator.append(i);
      QLog.d("DailyTipsFoldUtils", 2, paramValueAnimator.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.DailyTipsFoldUtils.1.1
 * JD-Core Version:    0.7.0.1
 */