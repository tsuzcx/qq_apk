package com.tencent.mobileqq.utils.dialogutils;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TipsDialog$1
  implements View.OnClickListener
{
  TipsDialog$1(TipsDialog paramTipsDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.dialogutils.TipsDialog.1
 * JD-Core Version:    0.7.0.1
 */