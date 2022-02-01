package com.tencent.thumbplayer.tplayer.plugins.report;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPProperties;

class TPReportManager$LiveReportHandler
  implements TPReportManager.IReportHandler
{
  TPReportManager$LiveReportHandler(TPReportManager paramTPReportManager) {}
  
  public void handleReportEvent(int paramInt, @NonNull ITPReportProperties paramITPReportProperties)
  {
    paramITPReportProperties = new TPProperties();
    boolean bool;
    if ((paramInt > 30) && (paramInt != 263)) {
      bool = false;
    } else {
      bool = true;
    }
    if (paramInt != 30)
    {
      if (paramInt != 50)
      {
        if (paramInt != 150)
        {
          if (paramInt != 263) {
            return;
          }
          TPReportManager.access$3900(this.this$0).removeMessages(3000);
          TPReportManager.access$3900(this.this$0).sendEmptyMessageDelayed(3000, 60000L);
        }
        else
        {
          TPReportManager.access$3900(this.this$0).removeMessages(3000);
        }
      }
      else
      {
        TPReportManager.access$3900(this.this$0).removeMessages(3000);
        paramInt = 263;
      }
    }
    else {
      paramInt = 205;
    }
    TPReportManager.access$4000(this.this$0, paramITPReportProperties, paramInt, bool);
    TPReportManager.access$4300(this.this$0, paramITPReportProperties, bool);
    if (paramInt != 205) {
      paramITPReportProperties.put("loadingtime", 0);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("liveExParam.prePlayLengthInt: ");
    localStringBuilder.append(TPReportManager.access$4400(this.this$0).getLiveExParam().prePlayLengthInt);
    TPLogUtil.i("TPReportManager", localStringBuilder.toString());
    TPReportManager.access$4100(this.this$0, paramITPReportProperties);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportManager.LiveReportHandler
 * JD-Core Version:    0.7.0.1
 */