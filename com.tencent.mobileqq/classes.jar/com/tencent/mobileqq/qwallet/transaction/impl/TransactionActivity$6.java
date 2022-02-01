package com.tencent.mobileqq.qwallet.transaction.impl;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

class TransactionActivity$6
  implements TextView.OnEditorActionListener
{
  TransactionActivity$6(TransactionActivity paramTransactionActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) || ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)))
    {
      if (TransactionActivity.access$000(this.a).isEnabled()) {
        TransactionActivity.access$000(this.a).performClick();
      }
      if (TransactionActivity.access$1300(this.a) != null) {
        ((InputMethodManager)TransactionActivity.access$1300(this.a).getSystemService("input_method")).hideSoftInputFromWindow(TransactionActivity.access$1800(this.a).getWindowToken(), 0);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.TransactionActivity.6
 * JD-Core Version:    0.7.0.1
 */