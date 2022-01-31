package com.tencent.mobileqq.hotpic;

import adse;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;

public class RecyclerFooterWrapperAdapter
  extends RecyclerView.Adapter
{
  private RecyclerView.Adapter jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter;
  private RecyclerView.AdapterDataObserver jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver = new adse(this);
  HotPicFooterInterface jdField_a_of_type_ComTencentMobileqqHotpicHotPicFooterInterface;
  
  public RecyclerFooterWrapperAdapter(@NonNull RecyclerView.Adapter paramAdapter, HotPicFooterInterface paramHotPicFooterInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicFooterInterface = paramHotPicFooterInterface;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter = paramAdapter;
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.registerAdapterDataObserver(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$AdapterDataObserver);
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicFooterInterface == null) {
      return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount();
    }
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.getItemCount() + 1;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicFooterInterface != null) && (paramInt == getItemCount() - 1)) {
      return 2147483647;
    }
    return super.getItemViewType(paramInt);
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicFooterInterface != null) && (paramInt == getItemCount() - 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicFooterInterface.a(paramViewHolder, paramInt);
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onBindViewHolder(paramViewHolder, paramInt);
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicFooterInterface != null) && (2147483647 == paramInt)) {
      return this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicFooterInterface.a(paramViewGroup, paramInt);
    }
    return this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$Adapter.onCreateViewHolder(paramViewGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.RecyclerFooterWrapperAdapter
 * JD-Core Version:    0.7.0.1
 */