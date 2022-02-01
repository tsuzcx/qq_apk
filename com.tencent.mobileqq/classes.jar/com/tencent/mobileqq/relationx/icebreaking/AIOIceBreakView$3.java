package com.tencent.mobileqq.relationx.icebreaking;

import android.view.View;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;

class AIOIceBreakView$3
  implements Runnable
{
  AIOIceBreakView$3(AIOIceBreakView paramAIOIceBreakView, String paramString, View paramView, Map paramMap) {}
  
  public void run()
  {
    VideoReport.reportEvent(this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView.3
 * JD-Core Version:    0.7.0.1
 */