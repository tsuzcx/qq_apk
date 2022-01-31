package com.tencent.mobileqq.widget;

import android.view.View;
import android.widget.ImageView;
import bcnu;
import bcnw;
import com.tencent.qphone.base.util.QLog;

public class NewStyleDropdownView$2$1
  implements Runnable
{
  public NewStyleDropdownView$2$1(bcnu parambcnu, View paramView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewStyleDropdownView", 2, "arrow clicked and postDelayed 250 run, set icon up and isLastDropDown true");
    }
    ((ImageView)this.jdField_a_of_type_AndroidViewView).setImageDrawable(this.jdField_a_of_type_Bcnu.a.b);
    if (this.jdField_a_of_type_Bcnu.a.jdField_a_of_type_Bcnw != null) {
      this.jdField_a_of_type_Bcnu.a.jdField_a_of_type_Bcnw.b();
    }
    this.jdField_a_of_type_Bcnu.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NewStyleDropdownView.2.1
 * JD-Core Version:    0.7.0.1
 */