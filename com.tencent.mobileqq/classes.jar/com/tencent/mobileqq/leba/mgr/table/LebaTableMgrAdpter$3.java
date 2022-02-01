package com.tencent.mobileqq.leba.mgr.table;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.leba.entity.LebaMgrViewItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LebaTableMgrAdpter$3
  implements View.OnClickListener
{
  LebaTableMgrAdpter$3(LebaTableMgrAdpter paramLebaTableMgrAdpter, LebaMgrViewItem paramLebaMgrViewItem, LebaTableMgrAdpter.PluginViewHolder paramPluginViewHolder) {}
  
  public void onClick(View paramView)
  {
    LebaTableMgrAdpter.a(this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter).a(LebaTableMgrAdpter.a(this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter), this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter, this.jdField_a_of_type_ComTencentMobileqqLebaEntityLebaMgrViewItem, this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter$PluginViewHolder);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.table.LebaTableMgrAdpter.3
 * JD-Core Version:    0.7.0.1
 */