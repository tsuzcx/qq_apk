package com.tencent.mobileqq.kandian.biz.feeds.presenter;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyView;
import java.util.ArrayList;

class ReadInJoyHeaderPresenter$3
  implements Animation.AnimationListener
{
  ReadInJoyHeaderPresenter$3(ReadInJoyHeaderPresenter paramReadInJoyHeaderPresenter, ReadInJoyView paramReadInJoyView, ArrayList paramArrayList1, ArrayList paramArrayList2, int paramInt, Object paramObject) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyView.a().post(new ReadInJoyHeaderPresenter.3.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyHeaderPresenter.3
 * JD-Core Version:    0.7.0.1
 */