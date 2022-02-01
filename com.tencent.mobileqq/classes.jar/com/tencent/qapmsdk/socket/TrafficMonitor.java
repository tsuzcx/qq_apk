package com.tencent.qapmsdk.socket;

import android.support.annotation.NonNull;
import com.tencent.qapmsdk.base.listener.IBaseListener;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.monitorplugin.QAPMMonitorPlugin;
import com.tencent.qapmsdk.common.logger.Logger;

public class TrafficMonitor
  extends QAPMMonitorPlugin
{
  private static com.tencent.qapmsdk.socket.a.a a = new com.tencent.qapmsdk.socket.a.a();
  private static com.tencent.qapmsdk.socket.a.b b = new com.tencent.qapmsdk.socket.a.b();
  
  public static TrafficMonitor.a a()
  {
    return TrafficMonitor.a.e();
  }
  
  public void setListener(@NonNull IBaseListener paramIBaseListener) {}
  
  public void start()
  {
    Logger.INSTANCE.i(new String[] { "QAPM_Socket_TrafficMonitor", "install TrafficMonitor" });
    a().a(a);
    a().a(b);
    a().a(new TrafficMonitor.1(this));
    com.tencent.qapmsdk.socket.d.b.a();
    com.tencent.qapmsdk.dns.a.a(BaseInfo.app);
    com.tencent.qapmsdk.impl.g.b.a(true);
  }
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.TrafficMonitor
 * JD-Core Version:    0.7.0.1
 */