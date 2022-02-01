package com.tencent.mobileqq.troop.troopcreate.ui;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

class NewTroopContactView$7
  implements View.OnKeyListener
{
  NewTroopContactView$7(NewTroopContactView paramNewTroopContactView) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 67) {
      if (paramKeyEvent.getAction() == 0)
      {
        paramView = this.a;
        paramView.g = TextUtils.isEmpty(paramView.f.getText());
      }
      else if ((paramKeyEvent.getAction() == 1) && (this.a.g))
      {
        this.a.p.a();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.NewTroopContactView.7
 * JD-Core Version:    0.7.0.1
 */