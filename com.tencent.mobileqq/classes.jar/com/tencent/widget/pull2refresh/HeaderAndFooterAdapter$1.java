package com.tencent.widget.pull2refresh;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HeaderAndFooterAdapter$1
  implements View.OnClickListener
{
  HeaderAndFooterAdapter$1(HeaderAndFooterAdapter paramHeaderAndFooterAdapter, BaseViewHolder paramBaseViewHolder) {}
  
  public void onClick(View paramView)
  {
    int i = this.jdField_a_of_type_ComTencentWidgetPull2refreshBaseViewHolder.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshHeaderAndFooterAdapter.a.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshBaseViewHolder.itemView, i);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.HeaderAndFooterAdapter.1
 * JD-Core Version:    0.7.0.1
 */