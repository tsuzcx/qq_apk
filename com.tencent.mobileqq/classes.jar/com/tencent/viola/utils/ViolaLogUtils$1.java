package com.tencent.viola.utils;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ViolaLogUtils$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    ViolaLogUtils.access$000().setVisibility(8);
    ViolaLogUtils.access$100().setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.utils.ViolaLogUtils.1
 * JD-Core Version:    0.7.0.1
 */