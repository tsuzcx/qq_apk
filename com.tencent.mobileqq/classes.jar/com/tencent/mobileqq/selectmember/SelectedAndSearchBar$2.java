package com.tencent.mobileqq.selectmember;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

class SelectedAndSearchBar$2
  implements View.OnKeyListener
{
  SelectedAndSearchBar$2(SelectedAndSearchBar paramSelectedAndSearchBar) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 67) {
      if (paramKeyEvent.getAction() == 0)
      {
        paramView = this.a;
        SelectedAndSearchBar.a(paramView, TextUtils.isEmpty(SelectedAndSearchBar.a(paramView).getText()));
      }
      else if ((paramKeyEvent.getAction() == 1) && (SelectedAndSearchBar.a(this.a)))
      {
        SelectedAndSearchBar.a(this.a).a();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectedAndSearchBar.2
 * JD-Core Version:    0.7.0.1
 */