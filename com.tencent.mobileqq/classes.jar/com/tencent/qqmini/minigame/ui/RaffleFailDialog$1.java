package com.tencent.qqmini.minigame.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.OnRaffleFailListener;

class RaffleFailDialog$1
  implements View.OnClickListener
{
  RaffleFailDialog$1(RaffleFailDialog paramRaffleFailDialog, TextView paramTextView) {}
  
  public void onClick(View paramView)
  {
    this.val$againText.setClickable(false);
    if (RaffleFailDialog.access$000(this.this$0) != null) {
      RaffleFailDialog.access$000(this.this$0).onAgain();
    }
    this.this$0.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.RaffleFailDialog.1
 * JD-Core Version:    0.7.0.1
 */