package com.tencent.mobileqq.widget;

import android.view.View;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class NewStyleDropdownView$1$1
  implements Runnable
{
  NewStyleDropdownView$1$1(NewStyleDropdownView.1 param1, View paramView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewStyleDropdownView", 2, "arrow clicked and postDelayed 250 run, set icon up and isLastDropDown true");
    }
    ((ImageView)this.jdField_a_of_type_AndroidViewView).setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$1.a.b);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$1.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$DropdownCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$1.a.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$DropdownCallback.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView$1.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NewStyleDropdownView.1.1
 * JD-Core Version:    0.7.0.1
 */