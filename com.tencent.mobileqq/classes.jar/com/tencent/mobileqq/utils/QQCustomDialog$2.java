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
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.text.getLineCount() > this.jdField_a_of_type_Int)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.text.getLayout().getLineEnd(this.jdField_a_of_type_Int - 1);
      Object localObject = this.jdField_a_of_type_JavaLangString;
      if ((!this.jdField_a_of_type_Boolean) && (!this.b))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.text.getText().subSequence(0, i - 3));
        ((StringBuilder)localObject).append("...");
        localObject = ((StringBuilder)localObject).toString();
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.text.setText((CharSequence)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialog.2
 * JD-Core Version:    0.7.0.1
 */