package com.tencent.mobileqq.utils;

import android.text.Layout;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

class QQCustomDialog$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  QQCustomDialog$2(QQCustomDialog paramQQCustomDialog, int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.text.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.text.getLineCount() > this.jdField_a_of_type_Int)
    {
      i = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.text.getLayout().getLineEnd(this.jdField_a_of_type_Int - 1);
      if (this.jdField_a_of_type_JavaLangString != null) {
        break label122;
      }
    }
    for (;;)
    {
      if ((!this.jdField_a_of_type_Boolean) && (!this.b))
      {
        str = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.text.getText().subSequence(0, i - 3) + "...";
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.text.setText(str);
      }
      return;
      label122:
      String str = this.jdField_a_of_type_JavaLangString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialog.2
 * JD-Core Version:    0.7.0.1
 */