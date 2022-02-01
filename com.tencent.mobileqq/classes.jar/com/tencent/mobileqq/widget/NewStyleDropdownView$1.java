package com.tencent.mobileqq.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NewStyleDropdownView$1
  implements View.OnClickListener
{
  NewStyleDropdownView$1(NewStyleDropdownView paramNewStyleDropdownView) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.clearFocus();
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.getWindowToken(), 0);
    boolean bool;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.getAdapter() != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.getAdapter().getCount() > 0))
    {
      int i = this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.getAdapter().getCount();
      if (i >= 5) {
        break label316;
      }
      int j = NewStyleDropdownView.a(this.a, 7.5F, this.a.getResources());
      int k = NewStyleDropdownView.a(this.a, 40.0F, this.a.getResources());
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.setDropDownHeight(i * (j * 2 + k) + j * 2);
      Drawable localDrawable = ((ImageView)paramView).getDrawable();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("arrow clicked, drawable is down=");
        if (localDrawable != this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable) {
          break label345;
        }
        bool = true;
        label185:
        QLog.d("NewStyleDropdownView", 2, bool + ", isLastDropDown=" + this.a.jdField_a_of_type_Boolean);
      }
      if ((localDrawable != this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable) || (this.a.jdField_a_of_type_Boolean)) {
        break label351;
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$DropdownCallback != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$DropdownCallback.c(false);
      }
      NewStyleDropdownView.a(this.a).postDelayed(new NewStyleDropdownView.1.1(this, paramView), 500L);
      ReportController.a(null, "dc00898", "", "", "0X8007367", "0X8007367", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label316:
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.setDropDownHeight(NewStyleDropdownView.a(this.a, 251.5F, this.a.getResources()));
      break;
      label345:
      bool = false;
      break label185;
      label351:
      if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$DropdownCallback != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$DropdownCallback.c(true);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.dismissDropDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NewStyleDropdownView.1
 * JD-Core Version:    0.7.0.1
 */