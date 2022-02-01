package com.tencent.mobileqq.vaswebviewplugin;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MQPSecJsPlugin$1
  implements View.OnClickListener
{
  MQPSecJsPlugin$1(MQPSecJsPlugin paramMQPSecJsPlugin) {}
  
  public void onClick(View paramView)
  {
    MQPSecJsPlugin.access$000(this.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */