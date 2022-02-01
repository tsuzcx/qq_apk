package com.tencent.mobileqq.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LangSettingFragment$LocaleListAdapter$1
  implements View.OnClickListener
{
  LangSettingFragment$LocaleListAdapter$1(LangSettingFragment.LocaleListAdapter paramLocaleListAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (LangSettingFragment.LocaleListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqFragmentLangSettingFragment$LocaleListAdapter, this.jdField_a_of_type_Int))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null) {
        ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A612", "0X800A612", 0, 0, "", "", "", "");
      }
    }
    if (LangSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentLangSettingFragment$LocaleListAdapter.a) != ((Integer)paramView.getTag()).intValue()) {
      LangSettingFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentLangSettingFragment$LocaleListAdapter.a, ((Integer)paramView.getTag()).intValue());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.LangSettingFragment.LocaleListAdapter.1
 * JD-Core Version:    0.7.0.1
 */