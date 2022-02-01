package com.tencent.open.agent;

import android.view.View;
import com.tencent.open.agent.entity.VirtualAccountInfo;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.Iterator;
import java.util.List;

class OpenCardContainer$2
  implements AdapterView.OnItemClickListener
{
  OpenCardContainer$2(OpenCardContainer paramOpenCardContainer) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = OpenCardContainer.VirtualAccountAdapter.a(this.a.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter).iterator();
    while (paramAdapterView.hasNext()) {
      ((VirtualAccountInfo)paramAdapterView.next()).a = false;
    }
    paramAdapterView = new StringBuilder();
    paramAdapterView.append("onItemClick position=");
    paramAdapterView.append(paramInt);
    SSOLog.a("OpenCardContainer", new Object[] { paramAdapterView.toString() });
    ((VirtualAccountInfo)OpenCardContainer.VirtualAccountAdapter.a(this.a.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter).get(paramInt)).a = true;
    this.a.jdField_a_of_type_ComTencentOpenAgentOpenAuthorityAccountView.setMainAccountSelect(false);
    this.a.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$VirtualAccountAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenCardContainer.2
 * JD-Core Version:    0.7.0.1
 */