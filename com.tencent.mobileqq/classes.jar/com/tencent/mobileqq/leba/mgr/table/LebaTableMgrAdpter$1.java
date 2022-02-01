package com.tencent.mobileqq.leba.mgr.table;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.itemtouchhelper.ItemTouchHelper;

class LebaTableMgrAdpter$1
  implements View.OnLongClickListener
{
  LebaTableMgrAdpter$1(LebaTableMgrAdpter paramLebaTableMgrAdpter, LebaTableMgrAdpter.PluginViewHolder paramPluginViewHolder) {}
  
  public boolean onLongClick(View paramView)
  {
    if (LebaTableMgrAdpter.a(this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter) != null)
    {
      QLog.i("LebaTableMgrAdpter", 1, "startDrag");
      LebaTableMgrAdpter.a(this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter).startDrag(this.jdField_a_of_type_ComTencentMobileqqLebaMgrTableLebaTableMgrAdpter$PluginViewHolder);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.table.LebaTableMgrAdpter.1
 * JD-Core Version:    0.7.0.1
 */