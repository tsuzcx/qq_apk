package com.tencent.thumbplayer.tplayer.plugins.report;

import android.os.Message;
import com.tencent.thumbplayer.utils.TPGlobalEventNofication.OnGlobalEventChangeListener;
import com.tencent.thumbplayer.utils.TPLogUtil;

class TPReportManager$2
  implements TPGlobalEventNofication.OnGlobalEventChangeListener
{
  TPReportManager$2(TPReportManager paramTPReportManager) {}
  
  public void onEvent(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    paramObject = new StringBuilder();
    paramObject.append("OnGlobalEventChangeListener eventId: ");
    paramObject.append(paramInt1);
    TPLogUtil.i("TPReportManager", paramObject.toString());
    switch (paramInt1)
    {
    default: 
      return;
    case 100002: 
      paramInt1 = 2101;
      break;
    case 100001: 
      paramInt1 = 2100;
    }
    TPReportManager.access$3900(this.this$0).obtainMessage(paramInt1, null).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.report.TPReportManager.2
 * JD-Core Version:    0.7.0.1
 */