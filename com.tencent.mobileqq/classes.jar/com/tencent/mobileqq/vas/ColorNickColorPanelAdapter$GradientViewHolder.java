package com.tencent.mobileqq.vas;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ColorNickColorPanelAdapter$GradientViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  public int a;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ColorNickColorPanelAdapter.OnColorSelectListener jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$OnColorSelectListener;
  ColorNickColorPanelAdapter jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter;
  ImageView b;
  
  public ColorNickColorPanelAdapter$GradientViewHolder(View paramView, ColorNickColorPanelAdapter paramColorNickColorPanelAdapter, ColorNickColorPanelAdapter.OnColorSelectListener paramOnColorSelectListener)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter = paramColorNickColorPanelAdapter;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364822));
    this.b = ((ImageView)paramView.findViewById(2131364823));
    paramView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$OnColorSelectListener = paramOnColorSelectListener;
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter.a(this.jdField_a_of_type_Int);
    ColorNickColorPanelAdapter.OnColorSelectListener localOnColorSelectListener = this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter$OnColorSelectListener;
    if (localOnColorSelectListener != null) {
      localOnColorSelectListener.a(this.jdField_a_of_type_ComTencentMobileqqVasColorNickColorPanelAdapter.a(this.jdField_a_of_type_Int));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorNickColorPanelAdapter.GradientViewHolder
 * JD-Core Version:    0.7.0.1
 */