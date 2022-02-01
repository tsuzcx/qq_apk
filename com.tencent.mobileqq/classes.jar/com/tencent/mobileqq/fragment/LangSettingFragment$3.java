package com.tencent.mobileqq.fragment;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import java.util.List;

class LangSettingFragment$3
  implements View.OnClickListener
{
  LangSettingFragment$3(LangSettingFragment paramLangSettingFragment, int paramInt) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_Int;
    if ((i >= 0) && (i < LangSettingFragment.a().size()))
    {
      LangSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentLangSettingFragment, this.jdField_a_of_type_Int);
      LangSettingFragment.c(this.jdField_a_of_type_ComTencentMobileqqFragmentLangSettingFragment, ((Integer)LangSettingFragment.a().get(this.jdField_a_of_type_Int)).intValue());
    }
    if ((LangSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentLangSettingFragment) != null) && (LangSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentLangSettingFragment).isShowing())) {
      LangSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentLangSettingFragment).dismiss();
    }
    if ((LangSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentLangSettingFragment) != null) && (LangSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentLangSettingFragment).isShowing())) {
      LangSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentLangSettingFragment).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.LangSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */