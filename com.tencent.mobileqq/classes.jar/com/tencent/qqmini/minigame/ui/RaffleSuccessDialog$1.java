package com.tencent.qqmini.minigame.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.OnRaffleSuccessListener;

class RaffleSuccessDialog$1
  implements View.OnClickListener
{
  RaffleSuccessDialog$1(RaffleSuccessDialog paramRaffleSuccessDialog) {}
  
  public void onClick(View paramView)
  {
    if ((RaffleSuccessDialog.access$000(this.this$0) != null) && (RaffleSuccessDialog.access$000(this.this$0).onReceive()))
    {
      RaffleSuccessDialog.access$100(this.this$0);
      RaffleSuccessDialog.access$200(this.this$0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.RaffleSuccessDialog.1
 * JD-Core Version:    0.7.0.1
 */