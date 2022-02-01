package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import android.widget.EditText;

public class MoneyWatcher
  extends BaseWatcher
{
  private int a;
  
  public MoneyWatcher(EditText paramEditText)
  {
    super(paramEditText);
    this.jdField_a_of_type_Int = 2;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    CharSequence localCharSequence = paramCharSequence;
    if (paramCharSequence.toString().contains("."))
    {
      localCharSequence = paramCharSequence;
      if (paramCharSequence.length() - 1 - paramCharSequence.toString().indexOf(".") > this.jdField_a_of_type_Int)
      {
        localCharSequence = paramCharSequence.toString().subSequence(0, paramCharSequence.toString().indexOf(".") + this.jdField_a_of_type_Int + 1);
        this.jdField_a_of_type_AndroidWidgetEditText.setText(localCharSequence);
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(localCharSequence.length());
      }
    }
    paramCharSequence = localCharSequence;
    if (localCharSequence.toString().trim().substring(0).equals("."))
    {
      paramCharSequence = new StringBuilder();
      paramCharSequence.append("0");
      paramCharSequence.append(localCharSequence);
      paramCharSequence = paramCharSequence.toString();
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramCharSequence);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(2);
    }
    if ((paramCharSequence.toString().startsWith("0")) && (paramCharSequence.toString().trim().length() > 1) && (!paramCharSequence.toString().substring(1, 2).equals(".")))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText(paramCharSequence.subSequence(0, 1));
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.MoneyWatcher
 * JD-Core Version:    0.7.0.1
 */