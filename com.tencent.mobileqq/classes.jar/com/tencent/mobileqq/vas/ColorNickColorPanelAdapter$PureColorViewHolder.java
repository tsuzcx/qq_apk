package com.tencent.mobileqq.vas;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;

public class ColorNickColorPanelAdapter$PureColorViewHolder
  extends RecyclerView.ViewHolder
  implements AdapterView.OnItemClickListener
{
  ColorNickColorPanelAdapter.OnColorSelectListener jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$OnColorSelectListener;
  ColorNickColorPanelAdapter.PureColorAdapter jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$PureColorAdapter;
  ColorNickColorPanelAdapter jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  
  public ColorNickColorPanelAdapter$PureColorViewHolder(View paramView, ColorNickColorPanelAdapter.OnColorSelectListener paramOnColorSelectListener, ColorNickColorPanelAdapter.PureColorAdapter paramPureColorAdapter, ColorNickColorPanelAdapter paramColorNickColorPanelAdapter)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)paramView.findViewById(2131364952));
    this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$PureColorAdapter = paramPureColorAdapter;
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$PureColorAdapter);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOnItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$OnColorSelectListener = paramOnColorSelectListener;
    this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter = paramColorNickColorPanelAdapter;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$PureColorAdapter.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter.a(-1);
    if (this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$OnColorSelectListener != null)
    {
      ColorNickColorPanelAdapter.ColorItem localColorItem = new ColorNickColorPanelAdapter.ColorItem(2, null, ((Integer)this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$PureColorAdapter.getItem(paramInt)).intValue(), null);
      this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$OnColorSelectListener.a(localColorItem);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickColorPanelAdapter.PureColorViewHolder
 * JD-Core Version:    0.7.0.1
 */