package com.tencent.mobileqq.troop.activity;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TroopCreateBaseActivity$TopBarBtnClickListener
  implements View.OnClickListener
{
  int jdField_a_of_type_Int = 0;
  TroopCreateBaseActivity jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity = null;
  String jdField_a_of_type_JavaLangString;
  
  public TroopCreateBaseActivity$TopBarBtnClickListener(TroopCreateBaseActivity paramTroopCreateBaseActivity, int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity = paramTroopCreateBaseActivity;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity != null)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        int i = this.jdField_a_of_type_Int;
        if (i == 0) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity.b();
        } else if (i == 1) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity.c();
        } else if (i == 2) {
          this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity.d();
        }
      }
      else
      {
        CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity.a;
        if (localCustomWebView != null) {
          localCustomWebView.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "" });
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopCreateBaseActivity.a(this.jdField_a_of_type_Int);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopCreateBaseActivity.TopBarBtnClickListener
 * JD-Core Version:    0.7.0.1
 */