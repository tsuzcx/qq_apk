package com.tencent.mobileqq.widget;

import android.view.View;
import android.widget.ImageView;
import bbkh;
import bbkj;
import com.tencent.qphone.base.util.QLog;

public class NewStyleDropdownView$2$1
  implements Runnable
{
  public NewStyleDropdownView$2$1(bbkh parambbkh, View paramView) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewStyleDropdownView", 2, "arrow clicked and postDelayed 250 run, set icon up and isLastDropDown true");
    }
    ((ImageView)this.jdField_a_of_type_AndroidViewView).setImageDrawable(this.jdField_a_of_type_Bbkh.a.b);
    if (this.jdField_a_of_type_Bbkh.a.jdField_a_of_type_Bbkj != null) {
      this.jdField_a_of_type_Bbkh.a.jdField_a_of_type_Bbkj.b();
    }
    this.jdField_a_of_type_Bbkh.a.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NewStyleDropdownView.2.1
 * JD-Core Version:    0.7.0.1
 */