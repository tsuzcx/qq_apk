package com.tencent.mobileqq.location.window;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GlobalFloatDialog$3
  implements View.OnClickListener
{
  GlobalFloatDialog$3(GlobalFloatDialog paramGlobalFloatDialog, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    View.OnClickListener localOnClickListener = this.a;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(paramView);
    }
    this.b.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.GlobalFloatDialog.3
 * JD-Core Version:    0.7.0.1
 */