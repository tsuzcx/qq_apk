package com.tencent.qapmsdk.socket;

import android.content.Context;
import com.tencent.qapmsdk.common.logger.LogState;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.socket.handler.HttpBodyLogInterceptor;
import com.tencent.qapmsdk.socket.handler.IHttpBodyLogInterceptor;
import com.tencent.qapmsdk.socket.handler.IPathResolver;
import com.tencent.qapmsdk.socket.handler.ITrafficInputStreamHandlerFactory;
import com.tencent.qapmsdk.socket.handler.ITrafficOutputStreamHandlerFactory;
import com.tencent.qapmsdk.socket.handler.PathResolver;
import com.tencent.qapmsdk.socket.handler.TrafficIOStreamHandlerManager;

public class TrafficMonitor$TrafficConfig
{
  private static final long CONFIG_PERIOD = 60000L;
  private static TrafficConfig instance = new TrafficConfig();
  private Context configContext;
  private boolean configVerbose = true;
  private boolean isEnableNetwork = true;
  
  public TrafficConfig addInputStreamHandlerFactory(ITrafficInputStreamHandlerFactory paramITrafficInputStreamHandlerFactory)
  {
    TrafficIOStreamHandlerManager.addInputStreamHandlerFactory(paramITrafficInputStreamHandlerFactory);
    return this;
  }
  
  public TrafficConfig addOutputStreamHandlerFactory(ITrafficOutputStreamHandlerFactory paramITrafficOutputStreamHandlerFactory)
  {
    TrafficIOStreamHandlerManager.addOutputStreamHandlerFactory(paramITrafficOutputStreamHandlerFactory);
    return this;
  }
  
  public TrafficConfig applicationContext(Context paramContext)
  {
    this.configContext = paramContext.getApplicationContext();
    return this;
  }
  
  public boolean canLog()
  {
    return Logger.INSTANCE.getLogLevel().getValue() >= LogState.DEBUG.getValue();
  }
  
  public TrafficConfig enableNetwork(boolean paramBoolean)
  {
    this.isEnableNetwork = paramBoolean;
    return this;
  }
  
  public Context getApplicationContext()
  {
    return this.configContext;
  }
  
  public long getPeriod()
  {
    return 60000L;
  }
  
  public boolean isEnableNetwork()
  {
    return this.isEnableNetwork;
  }
  
  public boolean isVerbose()
  {
    return this.configVerbose;
  }
  
  public TrafficConfig setConnectListener(TrafficConnectReporter.IConnectListener paramIConnectListener)
  {
    TrafficConnectReporter.setConnectListener(paramIConnectListener);
    return this;
  }
  
  public TrafficConfig setHttpBodyLogInterceptor(IHttpBodyLogInterceptor paramIHttpBodyLogInterceptor)
  {
    HttpBodyLogInterceptor.setInterceptor(paramIHttpBodyLogInterceptor);
    return this;
  }
  
  public TrafficConfig setPathResolver(IPathResolver paramIPathResolver)
  {
    PathResolver.setPathResolver(paramIPathResolver);
    return this;
  }
  
  public TrafficConfig verbose(boolean paramBoolean)
  {
    this.configVerbose = paramBoolean;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.TrafficMonitor.TrafficConfig
 * JD-Core Version:    0.7.0.1
 */