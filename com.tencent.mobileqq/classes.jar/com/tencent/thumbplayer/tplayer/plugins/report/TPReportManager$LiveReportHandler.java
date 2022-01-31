package com.tencent.thumbplayer.tplayer.plugins.report;

import android.support.annotation.NonNull;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPProperties;

class TPReportManager$LiveReportHandler
  implements TPReportManager.IReportHandler
{
  TPReportManager$LiveReportHandler(TPReportManager paramTPReportManager) {}
  
  public void handleReportEvent(int paramInt, @NonNull ITPReportProperties paramITPReportProperties)
  {
    paramITPReportProperties = new TPProperties();
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt > 30)
    {
      bool1 = bool2;
      if (paramInt != 263) {
        bool1 = false;
      }
    }
    switch (paramInt)
    {
    default: 
      return;
    case 30: 
      paramInt = 205;
    }
    for (;;)
    {
      TPReportManager.access$3600(this.this$0, paramITPReportProperties, paramInt, bool1);
      TPReportManager.access$3900(this.this$0, paramITPReportProperties, bool1);
      if (paramInt != 205) {
        paramITPReportProperties.put("loadingtime", 0);
      }
      TPLogUtil.i("TPReportManager", "liveExParam.prePlayLengthInt: " + TPReportManager.access$4000(this.this$0).getLiveExParam().prePlayLengthInt);
      TPReportManager.access$3700(this.this$0, paramITPReportProperties);
      return;
      TPReportManager.access$3500(this.this$0).removeMessages(3000);
      paramInt = 263;
      continue;
      TPReportManager.access$3500(this.this$0).removeMessages(3000);
      continue;
      TPReportManager.access$3500(this.this$0).removeMessages(3000);
      TPReportManager.access$3500(this.this$0).sendEmptyMessageDelayed(3000, 60000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportManager.LiveReportHandler
 * JD-Core Version:    0.7.0.1
 */