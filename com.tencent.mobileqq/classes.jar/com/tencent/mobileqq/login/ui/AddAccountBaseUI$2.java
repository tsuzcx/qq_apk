package com.tencent.mobileqq.login.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddAccountBaseUI$2
  implements View.OnClickListener
{
  AddAccountBaseUI$2(AddAccountBaseUI paramAddAccountBaseUI) {}
  
  public void onClick(View paramView)
  {
    this.a.c();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.login.ui.AddAccountBaseUI.2
 * JD-Core Version:    0.7.0.1
 */