package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DropdownView$1
  implements View.OnClickListener
{
  DropdownView$1(DropdownView paramDropdownView) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView$AutoCompleteView.clearFocus();
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView$AutoCompleteView.getWindowToken(), 0);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView$AutoCompleteView.getAdapter() != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView$AutoCompleteView.getAdapter().getCount() > 0)) {
      if ((((ImageView)paramView).getDrawable() == this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable) && (!this.a.jdField_a_of_type_Boolean))
      {
        DropdownView.a(this.a).postDelayed(new DropdownView.1.1(this, paramView), 250L);
        paramView.getContext();
      }
      else
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetDropdownView$AutoCompleteView.dismissDropDown();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DropdownView.1
 * JD-Core Version:    0.7.0.1
 */