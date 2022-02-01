package com.tencent.mobileqq.leba.business.mgr;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class LebaDiyIconTableMgTitle$1
  implements View.OnClickListener
{
  LebaDiyIconTableMgTitle$1(LebaDiyIconTableMgTitle paramLebaDiyIconTableMgTitle, Context paramContext, AppRuntime paramAppRuntime) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaBusinessMgrLebaDiyIconTableMgTitle.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_MqqAppAppRuntime);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mgr.LebaDiyIconTableMgTitle.1
 * JD-Core Version:    0.7.0.1
 */