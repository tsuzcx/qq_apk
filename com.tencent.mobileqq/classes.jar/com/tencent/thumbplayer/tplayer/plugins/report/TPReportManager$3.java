package com.tencent.thumbplayer.tplayer.plugins.report;

import android.os.Message;
import com.tencent.thumbplayer.utils.TPGlobalEventNofication.OnGlobalEventChangeListener;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPReportManager$3
  implements TPGlobalEventNofication.OnGlobalEventChangeListener
{
  TPReportManager$3(TPReportManager paramTPReportManager) {}
  
  public void onEvent(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    TPLogUtil.i("TPReportManager", "OnGlobalEventChangeListener eventId: " + paramInt1);
    switch (paramInt1)
    {
    default: 
      return;
    }
    for (paramInt1 = 2100;; paramInt1 = 2101)
    {
      TPReportManager.access$3700(this.this$0).obtainMessage(paramInt1, null).sendToTarget();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportManager.3
 * JD-Core Version:    0.7.0.1
 */