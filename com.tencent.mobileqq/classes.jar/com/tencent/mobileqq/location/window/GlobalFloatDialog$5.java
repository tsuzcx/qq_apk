package com.tencent.mobileqq.location.window;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GlobalFloatDialog$5
  implements View.OnClickListener
{
  GlobalFloatDialog$5(GlobalFloatDialog paramGlobalFloatDialog, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.a.onClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.GlobalFloatDialog.5
 * JD-Core Version:    0.7.0.1
 */