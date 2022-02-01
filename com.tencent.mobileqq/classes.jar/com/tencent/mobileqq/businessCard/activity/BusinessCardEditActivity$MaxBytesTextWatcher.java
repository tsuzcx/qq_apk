package com.tencent.mobileqq.businessCard.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mobileqq.businessCard.views.ClearEllipsisEditText;

class BusinessCardEditActivity$MaxBytesTextWatcher
  implements TextWatcher
{
  int jdField_a_of_type_Int;
  EditText jdField_a_of_type_AndroidWidgetEditText;
  String jdField_a_of_type_JavaLangString = "";
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  
  public BusinessCardEditActivity$MaxBytesTextWatcher(BusinessCardEditActivity paramBusinessCardEditActivity, int paramInt, EditText paramEditText)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_b_of_type_Int = 0;
  }
  
  public BusinessCardEditActivity$MaxBytesTextWatcher(BusinessCardEditActivity paramBusinessCardEditActivity, int paramInt1, EditText paramEditText, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((this.jdField_b_of_type_Int == 1) && (!this.jdField_a_of_type_JavaLangString.equals(paramEditable.toString())))
    {
      boolean bool;
      if (this.jdField_a_of_type_Boolean) {
        bool = this.jdField_b_of_type_Boolean;
      } else {
        bool = true;
      }
      this.jdField_b_of_type_Boolean = bool;
    }
    this.jdField_a_of_type_Boolean = false;
    paramEditable = this.jdField_a_of_type_AndroidWidgetEditText;
    if ((paramEditable instanceof ClearEllipsisEditText)) {
      paramEditable = ((ClearEllipsisEditText)paramEditable).a();
    } else {
      paramEditable = paramEditable.getText().toString();
    }
    int i = paramEditable.length();
    int j;
    if ((this.jdField_a_of_type_AndroidWidgetEditText.getTag() != null) && (((String)this.jdField_a_of_type_AndroidWidgetEditText.getTag()).equals("name")))
    {
      i = paramEditable.getBytes().length;
      j = 1;
    }
    else
    {
      j = 0;
    }
    if (i > this.jdField_a_of_type_Int)
    {
      while (i > this.jdField_a_of_type_Int)
      {
        paramEditable = paramEditable.substring(0, paramEditable.length() - 1);
        if (j != 0) {
          i = paramEditable.getBytes().length;
        } else {
          i = paramEditable.length();
        }
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramEditable);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(paramEditable.length());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaLangString = paramCharSequence.toString();
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.activity.BusinessCardEditActivity.MaxBytesTextWatcher
 * JD-Core Version:    0.7.0.1
 */