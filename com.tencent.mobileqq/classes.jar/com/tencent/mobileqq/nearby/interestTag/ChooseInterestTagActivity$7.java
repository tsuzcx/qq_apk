package com.tencent.mobileqq.nearby.interestTag;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.util.InputMethodUtil;

class ChooseInterestTagActivity$7
  implements AbsListView.OnScrollListener
{
  ChooseInterestTagActivity$7(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      InputMethodUtil.b(ChooseInterestTagActivity.access$2700(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity.7
 * JD-Core Version:    0.7.0.1
 */