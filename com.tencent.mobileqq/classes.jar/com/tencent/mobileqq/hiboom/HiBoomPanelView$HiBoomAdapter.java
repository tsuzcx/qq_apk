package com.tencent.mobileqq.hiboom;

import adxq;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XEditTextEx;
import java.util.List;

public class HiBoomPanelView$HiBoomAdapter
  extends RecyclerView.Adapter
{
  List jdField_a_of_type_JavaUtilList;
  
  public HiBoomPanelView$HiBoomAdapter(HiBoomPanelView paramHiBoomPanelView) {}
  
  public int a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return ((HiBoomItem)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
    }
    return -1;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    if (((HiBoomManager)this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(218)).b()) {
      return this.jdField_a_of_type_JavaUtilList.size() + 1;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    while (paramInt != this.jdField_a_of_type_JavaUtilList.size()) {
      return 1;
    }
    return 2;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    ((GridLayoutManager)paramRecyclerView.getLayoutManager()).setSpanSizeLookup(new adxq(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject;
    if ((paramViewHolder instanceof HiBoomPanelView.HiBoomViewHolder))
    {
      localObject = (HiBoomPanelView.HiBoomViewHolder)paramViewHolder;
      HiBoomItem localHiBoomItem = (HiBoomItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewHolder = ((HiBoomPanelView.HiBoomViewHolder)localObject).itemView.getLayoutParams();
      paramViewHolder.height = HiBoomPanelView.jdField_a_of_type_Int;
      paramViewHolder.width = HiBoomPanelView.b;
      ((HiBoomPanelView.HiBoomViewHolder)localObject).itemView.setPadding(0, 0, HiBoomPanelView.c, HiBoomPanelView.c);
      ((HiBoomPanelView.HiBoomViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setHiBoom(localHiBoomItem.jdField_a_of_type_Int, 1, HiBoomManager.a);
      paramViewHolder = HiBoomManager.a(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
      if (!TextUtils.isEmpty(paramViewHolder)) {
        break label213;
      }
      paramViewHolder = localHiBoomItem.jdField_a_of_type_JavaLangString;
    }
    label213:
    for (;;)
    {
      ((HiBoomPanelView.HiBoomViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView.setText(paramViewHolder);
      ((HiBoomPanelView.HiBoomViewHolder)localObject).jdField_a_of_type_Int = paramInt;
      do
      {
        return;
      } while (!(paramViewHolder instanceof HiBoomPanelView.HiBoomAuthorityTimeViewHolder));
      paramViewHolder = (HiBoomPanelView.HiBoomAuthorityTimeViewHolder)paramViewHolder;
      localObject = ((HiBoomManager)this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(218)).a();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        paramViewHolder.a.setVisibility(8);
        paramViewHolder.b.setVisibility(8);
        return;
      }
      paramViewHolder.a.setVisibility(0);
      paramViewHolder.b.setVisibility(0);
      paramViewHolder.a.setText((CharSequence)localObject);
      return;
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return new HiBoomPanelView.HiBoomViewHolder(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.getContext()).inflate(2130971749, paramViewGroup, false));
    }
    return new HiBoomPanelView.HiBoomAuthorityTimeViewHolder(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView, LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomPanelView.getContext()).inflate(2130971748, paramViewGroup, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomPanelView.HiBoomAdapter
 * JD-Core Version:    0.7.0.1
 */