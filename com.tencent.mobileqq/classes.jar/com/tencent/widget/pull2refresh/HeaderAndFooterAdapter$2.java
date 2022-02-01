package com.tencent.widget.pull2refresh;

import android.view.View;
import android.view.View.OnLongClickListener;

class HeaderAndFooterAdapter$2
  implements View.OnLongClickListener
{
  HeaderAndFooterAdapter$2(HeaderAndFooterAdapter paramHeaderAndFooterAdapter, BaseViewHolder paramBaseViewHolder) {}
  
  public boolean onLongClick(View paramView)
  {
    int i = this.jdField_a_of_type_ComTencentWidgetPull2refreshBaseViewHolder.getPosition();
    if (i >= 0) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshHeaderAndFooterAdapter.a.a(this.jdField_a_of_type_ComTencentWidgetPull2refreshBaseViewHolder.itemView, i);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.HeaderAndFooterAdapter.2
 * JD-Core Version:    0.7.0.1
 */