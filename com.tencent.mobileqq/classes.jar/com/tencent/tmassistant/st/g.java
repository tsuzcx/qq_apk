package com.tencent.tmassistant.st;

import android.os.Handler;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.o;
import com.tencent.tmdownloader.internal.downloadservice.b;

class g
  implements Runnable
{
  g(SDKReportManager2 paramSDKReportManager2) {}
  
  public void run()
  {
    ab.c("SDKReportManager2", ">>onNetworkChanged enter");
    if (SDKReportManager2.access$200(this.a) != null)
    {
      o.c();
      if (!b.b()) {
        break label67;
      }
      ab.c("SDKReportManager2", ">>onNetworkChanged connect");
      if (!SDKReportManager2.access$200(this.a).hasMessages(2)) {
        SDKReportManager2.access$200(this.a).sendEmptyMessage(2);
      }
    }
    for (;;)
    {
      ab.c("SDKReportManager2", ">>onNetworkChanged exit");
      return;
      label67:
      ab.c("SDKReportManager2", ">>onNetworkChanged unconnect");
      if (SDKReportManager2.access$200(this.a).hasMessages(2)) {
        SDKReportManager2.access$200(this.a).removeMessages(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.st.g
 * JD-Core Version:    0.7.0.1
 */