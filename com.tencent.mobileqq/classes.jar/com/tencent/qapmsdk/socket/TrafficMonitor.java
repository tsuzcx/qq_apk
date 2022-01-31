package com.tencent.qapmsdk.socket;

import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.monitorplugin.QAPMMonitorPlugin;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.dns.HttpDns;
import com.tencent.qapmsdk.impl.util.TraceUtil;
import com.tencent.qapmsdk.socket.handler.FirstPackageInputFactory;
import com.tencent.qapmsdk.socket.handler.FirstPackageOutputFactory;
import com.tencent.qapmsdk.socket.util.HookUtils;

public class TrafficMonitor
  extends QAPMMonitorPlugin
{
  private static final String TAG = "QAPM_Socket_TrafficMonitor";
  private static FirstPackageInputFactory firstPackageInputFactory = new FirstPackageInputFactory();
  private static FirstPackageOutputFactory firstPackageOutputFactory = new FirstPackageOutputFactory();
  
  public static TrafficMonitor.TrafficConfig config()
  {
    return TrafficMonitor.TrafficConfig.access$000();
  }
  
  public void start()
  {
    Logger.INSTANCE.i(new String[] { "QAPM_Socket_TrafficMonitor", "install TrafficMonitor" });
    config().addInputStreamHandlerFactory(firstPackageInputFactory);
    config().addOutputStreamHandlerFactory(firstPackageOutputFactory);
    config().setConnectListener(new TrafficMonitor.1(this));
    HookUtils.hook();
    HttpDns.install(BaseInfo.app);
    TraceUtil.setCanMonitorHttp(true);
  }
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.TrafficMonitor
 * JD-Core Version:    0.7.0.1
 */