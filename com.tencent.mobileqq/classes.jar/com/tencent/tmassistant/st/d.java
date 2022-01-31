package com.tencent.tmassistant.st;

import android.os.Handler;
import com.tencent.tmassistantbase.util.j;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.downloadservice.b;

class d
  implements Runnable
{
  d(SDKReportManager2 paramSDKReportManager2) {}
  
  public void run()
  {
    r.c("SDKReportManager2", ">>onNetworkChanged enter");
    if (SDKReportManager2.access$200(this.a) != null)
    {
      j.c();
      if (!b.b()) {
        break label67;
      }
      r.c("SDKReportManager2", ">>onNetworkChanged connect");
      if (!SDKReportManager2.access$200(this.a).hasMessages(2)) {
        SDKReportManager2.access$200(this.a).sendEmptyMessage(2);
      }
    }
    for (;;)
    {
      r.c("SDKReportManager2", ">>onNetworkChanged exit");
      return;
      label67:
      r.c("SDKReportManager2", ">>onNetworkChanged unconnect");
      if (SDKReportManager2.access$200(this.a).hasMessages(2)) {
        SDKReportManager2.access$200(this.a).removeMessages(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmassistant.st.d
 * JD-Core Version:    0.7.0.1
 */