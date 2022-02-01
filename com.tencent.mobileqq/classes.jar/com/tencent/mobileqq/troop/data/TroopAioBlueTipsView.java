package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class TroopAioBlueTipsView
  extends TroopAioAgent
  implements View.OnClickListener
{
  protected AIOTipsController a;
  protected String a;
  protected Context b;
  protected View b;
  protected String b;
  protected boolean b;
  
  public TroopAioBlueTipsView()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  boolean a()
  {
    return (this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() != 8);
  }
  
  protected void c()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  protected void d()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_AndroidContentContext = null;
    this.jdField_b_of_type_JavaLangString = null;
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a(null);
    }
  }
  
  public void onClick(View paramView)
  {
    if (!StringUtil.a(this.jdField_a_of_type_JavaLangString))
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("url", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      paramView.getContext().startActivity(localIntent);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController.a(null);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "sys_msg", "Clk_notice", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioBlueTipsView
 * JD-Core Version:    0.7.0.1
 */