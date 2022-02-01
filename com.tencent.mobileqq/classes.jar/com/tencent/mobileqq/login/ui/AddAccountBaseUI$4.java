package com.tencent.mobileqq.login.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;

class AddAccountBaseUI$4
  implements View.OnFocusChangeListener
{
  AddAccountBaseUI$4(AddAccountBaseUI paramAddAccountBaseUI) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    paramView = this.a.e;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 4;
    }
    paramView.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.login.ui.AddAccountBaseUI.4
 * JD-Core Version:    0.7.0.1
 */