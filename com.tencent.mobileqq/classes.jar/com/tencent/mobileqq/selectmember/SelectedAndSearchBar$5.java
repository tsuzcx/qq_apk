package com.tencent.mobileqq.selectmember;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SelectedAndSearchBar$5
  implements View.OnClickListener
{
  SelectedAndSearchBar$5(SelectedAndSearchBar paramSelectedAndSearchBar, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    View.OnClickListener localOnClickListener = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectedAndSearchBar.5
 * JD-Core Version:    0.7.0.1
 */