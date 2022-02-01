package com.tencent.mobileqq.leba;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class Leba$4
  implements View.OnClickListener
{
  Leba$4(Leba paramLeba) {}
  
  public void onClick(View paramView)
  {
    Leba.a(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.Leba.4
 * JD-Core Version:    0.7.0.1
 */