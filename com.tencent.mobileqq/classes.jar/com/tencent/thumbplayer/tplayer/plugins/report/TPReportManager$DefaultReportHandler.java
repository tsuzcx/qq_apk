package com.tencent.thumbplayer.tplayer.plugins.report;

import androidx.annotation.NonNull;

class TPReportManager$DefaultReportHandler
  implements TPReportManager.IReportHandler
{
  TPReportManager$DefaultReportHandler(TPReportManager paramTPReportManager) {}
  
  public void handleReportEvent(int paramInt, @NonNull ITPReportProperties paramITPReportProperties)
  {
    boolean bool = true;
    if (paramInt > 30) {
      bool = false;
    }
    TPReportManager.access$3800(this.this$0, paramITPReportProperties, paramInt, bool);
    TPReportManager.access$3900(this.this$0, paramITPReportProperties);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportManager.DefaultReportHandler
 * JD-Core Version:    0.7.0.1
 */