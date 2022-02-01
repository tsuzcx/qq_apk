package com.tencent.qqmini.minigame.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.OnRaffleSuccessListener;

class RaffleSuccessDialog$3
  implements View.OnClickListener
{
  RaffleSuccessDialog$3(RaffleSuccessDialog paramRaffleSuccessDialog) {}
  
  public void onClick(View paramView)
  {
    this.this$0.dismiss();
    if (RaffleSuccessDialog.access$000(this.this$0) != null) {
      RaffleSuccessDialog.access$000(this.this$0).onGoBackMain();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.RaffleSuccessDialog.3
 * JD-Core Version:    0.7.0.1
 */