package com.tencent.qqmini.minigame.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.OnRaffleSuccessListener;

class RaffleSuccessDialog$2
  implements View.OnClickListener
{
  RaffleSuccessDialog$2(RaffleSuccessDialog paramRaffleSuccessDialog, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    if (RaffleSuccessDialog.access$000(this.this$0) != null) {
      RaffleSuccessDialog.access$000(this.this$0).onClose();
    }
    RaffleSuccessDialog.access$300(this.this$0, this.val$closeButton);
    RaffleSuccessDialog.access$400(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.RaffleSuccessDialog.2
 * JD-Core Version:    0.7.0.1
 */