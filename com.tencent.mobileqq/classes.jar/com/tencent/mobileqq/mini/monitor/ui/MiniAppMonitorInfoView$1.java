package com.tencent.mobileqq.mini.monitor.ui;

class MiniAppMonitorInfoView$1
  implements Runnable
{
  MiniAppMonitorInfoView$1(MiniAppMonitorInfoView paramMiniAppMonitorInfoView) {}
  
  public void run()
  {
    MiniAppMonitorInfoView.access$002(this.this$0, true);
    this.this$0.updateData();
    this.this$0.startRefreshMonitorUi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.monitor.ui.MiniAppMonitorInfoView.1
 * JD-Core Version:    0.7.0.1
 */