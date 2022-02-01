package com.tencent.mobileqq.login.ui;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddAccountBaseUI$5
  implements TextView.OnEditorActionListener
{
  AddAccountBaseUI$5(AddAccountBaseUI paramAddAccountBaseUI) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (paramInt == 6)
    {
      if (this.a.o != null) {
        this.a.o.doLogin();
      }
      bool = true;
    }
    else
    {
      bool = false;
    }
    EventCollector.getInstance().onEditorAction(paramTextView, paramInt, paramKeyEvent);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.login.ui.AddAccountBaseUI.5
 * JD-Core Version:    0.7.0.1
 */