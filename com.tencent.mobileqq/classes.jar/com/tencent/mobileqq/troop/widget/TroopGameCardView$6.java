package com.tencent.mobileqq.troop.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopGameCardView$6
  implements View.OnClickListener
{
  TroopGameCardView$6(TroopGameCardView paramTroopGameCardView) {}
  
  public void onClick(View paramView)
  {
    Integer localInteger;
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof Integer)))
    {
      localInteger = (Integer)paramView.getTag();
      if (localInteger.compareTo(TroopGameCardView.a(this.a)) != 0) {
        break label47;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label47:
      TroopGameCardView.a(this.a, localInteger);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopGameCardView.6
 * JD-Core Version:    0.7.0.1
 */