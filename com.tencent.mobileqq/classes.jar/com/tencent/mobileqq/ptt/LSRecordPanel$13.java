package com.tencent.mobileqq.ptt;

import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelUtils;
import com.tencent.mobileqq.qroute.QRoute;

class LSRecordPanel$13
  implements Runnable
{
  LSRecordPanel$13(LSRecordPanel paramLSRecordPanel, int paramInt, double paramDouble) {}
  
  public void run()
  {
    int i = ((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getVolumeLevel(this.a);
    this.this$0.a(i);
    LSRecordPanel.a(this.this$0).setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.LSRecordPanel.13
 * JD-Core Version:    0.7.0.1
 */