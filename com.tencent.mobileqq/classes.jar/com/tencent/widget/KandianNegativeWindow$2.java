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
    KandianNegativeWindow localKandianNegativeWindow;
    switch (paramView.getId())
    {
    default: 
      this.a.dismiss();
      break;
    case 2131371757: 
      this.a.c(paramView);
      this.a.c();
      localKandianNegativeWindow = this.a;
      localKandianNegativeWindow.r = 3;
      localKandianNegativeWindow.c = HardCodeUtil.a(2131706007);
      KandianNegativeWindow.a(this.a, paramView.getTag(), true);
      break;
    case 2131371755: 
      this.a.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.a.jdField_a_of_type_JavaUtilArrayList, HardCodeUtil.a(2131706003), this.a.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow$iClickInterface);
      this.a.a(true);
      localKandianNegativeWindow = this.a;
      localKandianNegativeWindow.r = 1;
      localKandianNegativeWindow.c = HardCodeUtil.a(2131706008);
      KandianNegativeWindow.a(this.a, paramView.getTag(), false);
      break;
    case 2131371754: 
      this.a.c(paramView);
      this.a.c();
      localKandianNegativeWindow = this.a;
      localKandianNegativeWindow.r = 4;
      localKandianNegativeWindow.c = localKandianNegativeWindow.jdField_b_of_type_JavaLangString;
      KandianNegativeWindow.a(this.a, paramView.getTag(), false);
      break;
    case 2131371753: 
      this.a.c(paramView);
      this.a.c();
      localKandianNegativeWindow = this.a;
      localKandianNegativeWindow.r = 5;
      localKandianNegativeWindow.c = BaseApplicationImpl.getContext().getString(2131717940);
      KandianNegativeWindow.a(this.a, paramView.getTag(), false);
      break;
    case 2131371751: 
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getParent();
      this.a.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.a.jdField_b_of_type_JavaUtilArrayList, HardCodeUtil.a(2131706002), this.a.jdField_a_of_type_ComTencentWidgetKandianNegativeWindow$iClickInterface);
      this.a.a(true);
      localKandianNegativeWindow = this.a;
      localKandianNegativeWindow.r = 2;
      localKandianNegativeWindow.c = HardCodeUtil.a(2131706011);
      KandianNegativeWindow.a(this.a, paramView.getTag(), false);
      break;
    case 2131369933: 
      this.a.a(false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.KandianNegativeWindow.2
 * JD-Core Version:    0.7.0.1
 */