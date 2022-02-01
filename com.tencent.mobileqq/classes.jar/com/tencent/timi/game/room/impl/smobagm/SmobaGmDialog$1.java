package com.tencent.timi.game.room.impl.smobagm;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SmobaGmDialog$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.smobagm.SmobaGmDialog.1
 * JD-Core Version:    0.7.0.1
 */