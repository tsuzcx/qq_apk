package com.tencent.mobileqq.troop.adapter;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.troop.adapter.base.ViewHolder;

class QuickRecyclerAdapter$3
  implements View.OnLongClickListener
{
  QuickRecyclerAdapter$3(QuickRecyclerAdapter paramQuickRecyclerAdapter, ViewHolder paramViewHolder) {}
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopAdapterQuickRecyclerAdapter.a != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqTroopAdapterBaseViewHolder.getAdapterPosition();
      return this.jdField_a_of_type_ComTencentMobileqqTroopAdapterQuickRecyclerAdapter.a.a(paramView, this.jdField_a_of_type_ComTencentMobileqqTroopAdapterBaseViewHolder, i);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.adapter.QuickRecyclerAdapter.3
 * JD-Core Version:    0.7.0.1
 */