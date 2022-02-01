package com.tencent.qqmini.sdk.monitor.ui;

import com.tencent.qqmini.sdk.monitor.common.FPSCalculator.GetFPSListener;

class MiniAppMonitorInfoView$FpsListener
  implements FPSCalculator.GetFPSListener
{
  private MiniAppMonitorInfoView$FpsListener(MiniAppMonitorInfoView paramMiniAppMonitorInfoView) {}
  
  public void onInfo(long paramLong, double paramDouble)
  {
    MiniAppMonitorInfoView localMiniAppMonitorInfoView = this.this$0;
    localMiniAppMonitorInfoView.updateFPSText(MiniAppMonitorInfoView.access$200(localMiniAppMonitorInfoView), paramDouble);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.ui.MiniAppMonitorInfoView.FpsListener
 * JD-Core Version:    0.7.0.1
 */