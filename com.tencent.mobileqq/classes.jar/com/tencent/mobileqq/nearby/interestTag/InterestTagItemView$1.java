package com.tencent.mobileqq.nearby.interestTag;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class InterestTagItemView$1
  implements View.OnClickListener
{
  InterestTagItemView$1(InterestTagItemView paramInterestTagItemView) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == InterestTagItemView.a(this.a)) || (paramView == this.a))
    {
      InterestTagItemView.a(this.a).a(InterestTagItemView.a(this.a));
      this.a.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.InterestTagItemView.1
 * JD-Core Version:    0.7.0.1
 */