package com.tencent.mobileqq.login.ui;

import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;

class AddAccountBaseUI$SetHelpLayoutRunnable
  implements Runnable
{
  int a;
  
  AddAccountBaseUI$SetHelpLayoutRunnable(AddAccountBaseUI paramAddAccountBaseUI, int paramInt)
  {
    this.a = paramInt;
  }
  
  public void run()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.this$0.i.getLayoutParams();
    int i = localLayoutParams.bottomMargin;
    int j = this.a;
    if (i == j) {
      return;
    }
    localLayoutParams.bottomMargin = j;
    this.this$0.i.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.login.ui.AddAccountBaseUI.SetHelpLayoutRunnable
 * JD-Core Version:    0.7.0.1
 */