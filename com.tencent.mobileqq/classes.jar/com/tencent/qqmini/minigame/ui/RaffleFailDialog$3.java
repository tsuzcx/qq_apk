package com.tencent.qqmini.minigame.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.OnRaffleFailListener;

class RaffleFailDialog$3
  implements View.OnClickListener
{
  RaffleFailDialog$3(RaffleFailDialog paramRaffleFailDialog, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    RaffleFailDialog.access$100(this.this$0, this.val$imageView);
    if (RaffleFailDialog.access$000(this.this$0) != null) {
      RaffleFailDialog.access$000(this.this$0).onShare();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.RaffleFailDialog.3
 * JD-Core Version:    0.7.0.1
 */