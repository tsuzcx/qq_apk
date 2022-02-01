package com.tencent.mobileqq.listentogether.fragment;

import android.view.View;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ListenTogetherOverlayFragment$6
  implements ActionSheet.OnButtonClickListener
{
  ListenTogetherOverlayFragment$6(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, ListenTogetherManager paramListenTogetherManager) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      ListenTogetherOverlayFragment.c(this.b);
      ListenTogetherOverlayFragment.b(this.b).dismiss();
      ListenTogetherOverlayFragment.b(this.b, true);
      return;
    }
    this.a.a(false);
    ListenTogetherOverlayFragment.b(this.b).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment.6
 * JD-Core Version:    0.7.0.1
 */