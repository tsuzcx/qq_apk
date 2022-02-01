package com.tencent.qqmini.minigame.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.plugins.RaffleJsPlugin.OnRaffleFailListener;

class RaffleFailDialog$4
  implements View.OnClickListener
{
  RaffleFailDialog$4(RaffleFailDialog paramRaffleFailDialog, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    RaffleFailDialog.access$100(this.jdField_a_of_type_ComTencentQqminiMinigameUiRaffleFailDialog, this.jdField_a_of_type_AndroidWidgetImageView);
    if (RaffleFailDialog.access$000(this.jdField_a_of_type_ComTencentQqminiMinigameUiRaffleFailDialog) != null) {
      RaffleFailDialog.access$000(this.jdField_a_of_type_ComTencentQqminiMinigameUiRaffleFailDialog).onWatchAd();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.ui.RaffleFailDialog.4
 * JD-Core Version:    0.7.0.1
 */