package com.tencent.open.agent;

import android.view.View;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.Iterator;
import java.util.List;

class OpenCardContainer$4
  implements AdapterView.OnItemClickListener
{
  OpenCardContainer$4(OpenCardContainer paramOpenCardContainer) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = OpenCardContainer.VirtualAccountAdapter.a(this.a.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter).iterator();
    while (paramAdapterView.hasNext()) {
      ((OpenCardContainer.VirtualAccountInfo)paramAdapterView.next()).a = false;
    }
    ((OpenCardContainer.VirtualAccountInfo)OpenCardContainer.VirtualAccountAdapter.a(this.a.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter).get(paramInt)).a = true;
    this.a.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(false);
    this.a.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenCardContainer.4
 * JD-Core Version:    0.7.0.1
 */