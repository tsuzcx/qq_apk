package com.tencent.mobileqq.listentogether.fragment;

import android.view.View;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ListenTogetherOverlayFragment$6
  implements ActionSheet.OnButtonClickListener
{
  ListenTogetherOverlayFragment$6(ListenTogetherOverlayFragment paramListenTogetherOverlayFragment, ListenTogetherManager paramListenTogetherManager) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherManager.a(false);
      ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).dismiss();
      return;
    }
    ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment);
    ListenTogetherOverlayFragment.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment).dismiss();
    ListenTogetherOverlayFragment.b(this.jdField_a_of_type_ComTencentMobileqqListentogetherFragmentListenTogetherOverlayFragment, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment.6
 * JD-Core Version:    0.7.0.1
 */