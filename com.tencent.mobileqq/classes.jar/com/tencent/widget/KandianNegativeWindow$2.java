package com.tencent.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class KandianNegativeWindow$2
  implements View.OnClickListener
{
  KandianNegativeWindow$2(KandianNegativeWindow paramKandianNegativeWindow) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      this.a.dismiss();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.a.jdField_a_of_type_JavaUtilArrayList, HardCodeUtil.a(2131705951), this.a.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow$iClickInterface);
      this.a.a(true);
      this.a.r = 1;
      this.a.c = HardCodeUtil.a(2131705956);
      KandianNegativeWindow.a(this.a, paramView.getTag(), false);
      continue;
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getParent();
      this.a.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.a.jdField_b_of_type_JavaUtilArrayList, HardCodeUtil.a(2131705950), this.a.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow$iClickInterface);
      this.a.a(true);
      this.a.r = 2;
      this.a.c = HardCodeUtil.a(2131705959);
      KandianNegativeWindow.a(this.a, paramView.getTag(), false);
      continue;
      this.a.c(paramView);
      this.a.c();
      this.a.r = 3;
      this.a.c = HardCodeUtil.a(2131705955);
      KandianNegativeWindow.a(this.a, paramView.getTag(), true);
      continue;
      this.a.c(paramView);
      this.a.c();
      this.a.r = 4;
      this.a.c = this.a.jdField_b_of_type_JavaLangString;
      KandianNegativeWindow.a(this.a, paramView.getTag(), false);
      continue;
      this.a.c(paramView);
      this.a.c();
      this.a.r = 5;
      this.a.c = BaseApplicationImpl.getContext().getString(2131718275);
      KandianNegativeWindow.a(this.a, paramView.getTag(), false);
      continue;
      this.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.KandianNegativeWindow.2
 * JD-Core Version:    0.7.0.1
 */