package com.tencent.mobileqq.widget;

import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DraggableGridView$GridViewAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  
  public DraggableGridView$GridViewAdapter(DraggableGridView paramDraggableGridView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).a(this.jdField_a_of_type_Int);
  }
  
  public Object getItem(int paramInt)
  {
    return DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).a(this.jdField_a_of_type_Int, paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).a(LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView.getContext()), this.jdField_a_of_type_Int, paramInt, paramViewGroup);
    }
    for (;;)
    {
      DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).a(paramView, this.jdField_a_of_type_Int, paramInt);
      DraggableGridView.GridItemAction localGridItemAction = new DraggableGridView.GridItemAction(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView, this.jdField_a_of_type_Int, paramInt);
      paramView.setOnClickListener(localGridItemAction);
      paramView.setOnLongClickListener(localGridItemAction);
      if ((!DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView)) && ((DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).y != this.jdField_a_of_type_Int) || (DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).x != paramInt) || (!DraggableGridView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView)))) {
        paramView.setVisibility(0);
      }
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DraggableGridView.GridViewAdapter
 * JD-Core Version:    0.7.0.1
 */