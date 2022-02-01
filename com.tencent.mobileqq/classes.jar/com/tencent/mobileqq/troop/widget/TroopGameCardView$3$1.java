package com.tencent.mobileqq.troop.widget;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopGameCardView$3$1
  implements View.OnClickListener
{
  TroopGameCardView$3$1(TroopGameCardView.3 param3, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidAppDialog.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopGameCardView.3.1
 * JD-Core Version:    0.7.0.1
 */