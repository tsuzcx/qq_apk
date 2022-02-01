package com.tencent.open.agent;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class OpenCardContainer$3
  implements View.OnClickListener
{
  OpenCardContainer$3(OpenCardContainer paramOpenCardContainer) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(true);
    this.a.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenCardContainer.3
 * JD-Core Version:    0.7.0.1
 */