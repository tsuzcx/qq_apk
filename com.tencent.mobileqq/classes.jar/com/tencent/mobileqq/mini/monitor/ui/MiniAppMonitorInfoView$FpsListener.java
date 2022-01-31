package com.tencent.mobileqq.mini.monitor.ui;

import bcwm;

class MiniAppMonitorInfoView$FpsListener
  implements bcwm
{
  private MiniAppMonitorInfoView$FpsListener(MiniAppMonitorInfoView paramMiniAppMonitorInfoView) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    this.this$0.updateFPSText(paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.monitor.ui.MiniAppMonitorInfoView.FpsListener
 * JD-Core Version:    0.7.0.1
 */