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
    View localView = this.jdField_b_of_type_AndroidViewView;
    return (localView != null) && (localView.getVisibility() != 8);
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
    AIOTipsController localAIOTipsController = this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController;
    if (localAIOTipsController != null) {
      localAIOTipsController.a(null);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (!StringUtil.a(this.jdField_a_of_type_JavaLangString))
    {
      localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString);
      ((Intent)localObject).putExtra("hide_operation_bar", true);
      ((Intent)localObject).putExtra("hide_more_button", true);
      paramView.getContext().startActivity((Intent)localObject);
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController;
      if (localObject != null) {
        ((AIOTipsController)localObject).a(null);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "sys_msg", "Clk_notice", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopAioBlueTipsView
 * JD-Core Version:    0.7.0.1
 */