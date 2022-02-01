package com.tencent.mobileqq.leba.business.mgr;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class LebaDiyIconTableMgTitle$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    this.c.a(this.a, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.mgr.LebaDiyIconTableMgTitle.1
 * JD-Core Version:    0.7.0.1
 */