package com.tencent.mobileqq.richstatus;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.util.InputMethodUtil;

class SignTextEditFragment$1
  implements TextView.OnEditorActionListener
{
  SignTextEditFragment$1(SignTextEditFragment paramSignTextEditFragment) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)) {
      InputMethodUtil.b(paramTextView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.SignTextEditFragment.1
 * JD-Core Version:    0.7.0.1
 */