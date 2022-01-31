package com.tencent.tmassistant.st;

import android.os.Handler;
import com.tencent.tmassistantbase.util.ac;
import com.tencent.tmassistantbase.util.p;
import com.tencent.tmdownloader.internal.downloadservice.b;

class g
  implements Runnable
{
  g(SDKReportManager2 paramSDKReportManager2) {}
  
  public void run()
  {
    ac.c("SDKReportManager2", ">>onNetworkChanged enter");
    if (SDKReportManager2.access$200(this.a) != null)
    {
      p.c();
      if (!b.b()) {
        break label67;
      }
      ac.c("SDKReportManager2", ">>onNetworkChanged connect");
      if (!SDKReportManager2.access$200(this.a).hasMessages(2)) {
        SDKReportManager2.access$200(this.a).sendEmptyMessage(2);
      }
    }
    for (;;)
    {
      ac.c("SDKReportManager2", ">>onNetworkChanged exit");
      return;
      label67:
      ac.c("SDKReportManager2", ">>onNetworkChanged unconnect");
      if (SDKReportManager2.access$200(this.a).hasMessages(2)) {
        SDKReportManager2.access$200(this.a).removeMessages(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistant.st.g
 * JD-Core Version:    0.7.0.1
 */