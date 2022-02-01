package com.tencent.mobileqq.widget;

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
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.getAdapter() != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.getAdapter().getCount() > 0))
    {
      int i = this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.getAdapter().getCount();
      Object localObject2;
      if (i < 5)
      {
        localObject1 = this.a;
        int k = NewStyleDropdownView.a((NewStyleDropdownView)localObject1, 7.5F, ((NewStyleDropdownView)localObject1).getResources());
        localObject1 = this.a;
        int j = NewStyleDropdownView.a((NewStyleDropdownView)localObject1, 40.0F, ((NewStyleDropdownView)localObject1).getResources());
        k *= 2;
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.setDropDownHeight(k + i * (j + k));
      }
      else
      {
        localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView;
        localObject2 = this.a;
        ((NewStyleDropdownView.AutoCompleteView)localObject1).setDropDownHeight(NewStyleDropdownView.a((NewStyleDropdownView)localObject2, 251.5F, ((NewStyleDropdownView)localObject2).getResources()));
      }
      Object localObject1 = ((ImageView)paramView).getDrawable();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("arrow clicked, drawable is down=");
        boolean bool;
        if (localObject1 == this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable) {
          bool = true;
        } else {
          bool = false;
        }
        ((StringBuilder)localObject2).append(bool);
        ((StringBuilder)localObject2).append(", isLastDropDown=");
        ((StringBuilder)localObject2).append(this.a.jdField_a_of_type_Boolean);
        QLog.d("NewStyleDropdownView", 2, ((StringBuilder)localObject2).toString());
      }
      if ((localObject1 == this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable) && (!this.a.jdField_a_of_type_Boolean))
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$DropdownCallback != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$DropdownCallback.b(false);
        }
        NewStyleDropdownView.a(this.a).postDelayed(new NewStyleDropdownView.1.1(this, paramView), 500L);
        ReportController.a(null, "dc00898", "", "", "0X8007367", "0X8007367", 0, 0, "", "", "", "");
      }
      else
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$DropdownCallback != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$DropdownCallback.b(true);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$AutoCompleteView.dismissDropDown();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NewStyleDropdownView.1
 * JD-Core Version:    0.7.0.1
 */