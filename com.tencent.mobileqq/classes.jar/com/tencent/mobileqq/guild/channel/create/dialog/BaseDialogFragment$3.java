package com.tencent.mobileqq.guild.channel.create.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseDialogFragment$3
  implements View.OnClickListener
{
  BaseDialogFragment$3(BaseDialogFragment paramBaseDialogFragment) {}
  
  public void onClick(View paramView)
  {
    if (BaseDialogFragment.d(this.a) != null) {
      BaseDialogFragment.d(this.a).onCloseAllEvent();
    }
    this.a.d();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment.3
 * JD-Core Version:    0.7.0.1
 */