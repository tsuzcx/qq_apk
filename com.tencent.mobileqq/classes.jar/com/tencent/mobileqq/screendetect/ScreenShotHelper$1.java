package com.tencent.mobileqq.screendetect;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class ScreenShotHelper$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    ScreenShotHelper.a(paramView.getContext(), (String)paramView.getTag(), false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.screendetect.ScreenShotHelper.1
 * JD-Core Version:    0.7.0.1
 */