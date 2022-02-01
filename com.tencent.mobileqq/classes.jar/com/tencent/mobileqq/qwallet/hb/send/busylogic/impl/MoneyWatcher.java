package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import android.widget.EditText;

public class MoneyWatcher
  extends BaseWatcher
{
  private int b = 2;
  
  public MoneyWatcher(EditText paramEditText)
  {
    super(paramEditText);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    CharSequence localCharSequence = paramCharSequence;
    if (paramCharSequence.toString().contains("."))
    {
      localCharSequence = paramCharSequence;
      if (paramCharSequence.length() - 1 - paramCharSequence.toString().indexOf(".") > this.b)
      {
        localCharSequence = paramCharSequence.toString().subSequence(0, paramCharSequence.toString().indexOf(".") + this.b + 1);
        this.a.setText(localCharSequence);
        this.a.setSelection(localCharSequence.length());
      }
    }
    paramCharSequence = localCharSequence;
    if (localCharSequence.toString().trim().substring(0).equals("."))
    {
      paramCharSequence = new StringBuilder();
      paramCharSequence.append("0");
      paramCharSequence.append(localCharSequence);
      paramCharSequence = paramCharSequence.toString();
      this.a.setText(paramCharSequence);
      this.a.setSelection(2);
    }
    if ((paramCharSequence.toString().startsWith("0")) && (paramCharSequence.toString().trim().length() > 1) && (!paramCharSequence.toString().substring(1, 2).equals(".")))
    {
      this.a.setText(paramCharSequence.subSequence(0, 1));
      this.a.setSelection(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.MoneyWatcher
 * JD-Core Version:    0.7.0.1
 */