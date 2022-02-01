package com.tencent.mobileqq.location.window;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GlobalFloatDialog$1
  implements View.OnClickListener
{
  GlobalFloatDialog$1(GlobalFloatDialog paramGlobalFloatDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.GlobalFloatDialog.1
 * JD-Core Version:    0.7.0.1
 */