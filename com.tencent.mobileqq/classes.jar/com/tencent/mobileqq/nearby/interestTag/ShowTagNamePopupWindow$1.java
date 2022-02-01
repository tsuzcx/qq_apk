package com.tencent.mobileqq.nearby.interestTag;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ShowTagNamePopupWindow$1
  implements View.OnClickListener
{
  ShowTagNamePopupWindow$1(ShowTagNamePopupWindow paramShowTagNamePopupWindow) {}
  
  public void onClick(View paramView)
  {
    if (ShowTagNamePopupWindow.a(this.a) != null) {
      ShowTagNamePopupWindow.a(this.a).a(ShowTagNamePopupWindow.a(this.a));
    }
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ShowTagNamePopupWindow.1
 * JD-Core Version:    0.7.0.1
 */