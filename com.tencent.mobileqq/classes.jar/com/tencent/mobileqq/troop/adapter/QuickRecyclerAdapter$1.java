package com.tencent.mobileqq.troop.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;

class QuickRecyclerAdapter$1
  extends GridLayoutManager.SpanSizeLookup
{
  QuickRecyclerAdapter$1(QuickRecyclerAdapter paramQuickRecyclerAdapter, GridLayoutManager paramGridLayoutManager) {}
  
  public int getSpanSize(int paramInt)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqTroopAdapterQuickRecyclerAdapter.a(paramInt)) && (!this.jdField_a_of_type_ComTencentMobileqqTroopAdapterQuickRecyclerAdapter.b(paramInt)) && (!this.jdField_a_of_type_ComTencentMobileqqTroopAdapterQuickRecyclerAdapter.c(paramInt)) && (!this.jdField_a_of_type_ComTencentMobileqqTroopAdapterQuickRecyclerAdapter.b())) {
      return 1;
    }
    return this.jdField_a_of_type_AndroidSupportV7WidgetGridLayoutManager.getSpanCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.adapter.QuickRecyclerAdapter.1
 * JD-Core Version:    0.7.0.1
 */