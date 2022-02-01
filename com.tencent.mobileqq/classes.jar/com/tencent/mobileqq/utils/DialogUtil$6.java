package com.tencent.mobileqq.utils;

import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class DialogUtil$6
  implements View.OnClickListener
{
  DialogUtil$6(DialogInterface.OnClickListener paramOnClickListener, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.onClick(this.b, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.DialogUtil.6
 * JD-Core Version:    0.7.0.1
 */