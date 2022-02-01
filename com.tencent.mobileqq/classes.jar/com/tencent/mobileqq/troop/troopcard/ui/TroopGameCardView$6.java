package com.tencent.mobileqq.troop.troopcard.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopGameCardView$6
  implements View.OnClickListener
{
  TroopGameCardView$6(TroopGameCardView paramTroopGameCardView) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof Integer)))
    {
      Integer localInteger = (Integer)paramView.getTag();
      if (localInteger.compareTo(TroopGameCardView.b(this.a)) != 0) {
        TroopGameCardView.a(this.a, localInteger);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopGameCardView.6
 * JD-Core Version:    0.7.0.1
 */