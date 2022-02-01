package com.tencent.timi.game.web.business.impl.common;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TimiBrowserActivity$2
  implements View.OnClickListener
{
  TimiBrowserActivity$2(TimiBrowserActivity paramTimiBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.e();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.web.business.impl.common.TimiBrowserActivity.2
 * JD-Core Version:    0.7.0.1
 */