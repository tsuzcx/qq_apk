package com.tencent.open.agent;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class OpenCardContainer$VirtualAccountAdapter$1
  implements View.OnClickListener
{
  OpenCardContainer$VirtualAccountAdapter$1(OpenCardContainer.VirtualAccountAdapter paramVirtualAccountAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((OpenCardContainer.VirtualAccountAdapter.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter) == null) || (this.jdField_a_of_type_Int >= OpenCardContainer.VirtualAccountAdapter.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter).size()) || (this.jdField_a_of_type_Int < 0)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter.a.a != null) && (OpenCardContainer.VirtualAccountAdapter.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter).get(this.jdField_a_of_type_Int) != null) && (OpenCardContainer.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter.a) != null)) {
        OpenCardContainer.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter.a).a(((OpenCardContainer.VirtualAccountInfo)OpenCardContainer.VirtualAccountAdapter.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter).get(this.jdField_a_of_type_Int)).a);
      }
      OpenCardContainer.VirtualAccountAdapter.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter).remove(OpenCardContainer.VirtualAccountAdapter.a(this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter).get(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenCardContainer.VirtualAccountAdapter.1
 * JD-Core Version:    0.7.0.1
 */