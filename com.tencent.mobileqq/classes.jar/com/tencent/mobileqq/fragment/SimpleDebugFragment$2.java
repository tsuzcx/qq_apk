package com.tencent.mobileqq.fragment;

import android.view.View;
import android.widget.RadioGroup;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

class SimpleDebugFragment$2
  implements OnItemSelectListener
{
  SimpleDebugFragment$2(SimpleDebugFragment paramSimpleDebugFragment, RadioGroup paramRadioGroup) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (paramInt != 1) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId() != 2131367785) {}
    this.jdField_a_of_type_ComTencentMobileqqFragmentSimpleDebugFragment.getBaseActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.SimpleDebugFragment.2
 * JD-Core Version:    0.7.0.1
 */