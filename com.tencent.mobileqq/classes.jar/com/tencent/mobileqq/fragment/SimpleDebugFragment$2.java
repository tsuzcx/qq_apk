package com.tencent.mobileqq.fragment;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.RadioGroup;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

class SimpleDebugFragment$2
  implements OnItemSelectListener
{
  SimpleDebugFragment$2(SimpleDebugFragment paramSimpleDebugFragment, RadioGroup paramRadioGroup) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    switch (this.jdField_a_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId())
    {
    }
    this.jdField_a_of_type_ComTencentMobileqqFragmentSimpleDebugFragment.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.SimpleDebugFragment.2
 * JD-Core Version:    0.7.0.1
 */