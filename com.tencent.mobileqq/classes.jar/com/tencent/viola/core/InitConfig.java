package com.tencent.viola.core;

import com.tencent.viola.adapter.IHttpAdapter;
import com.tencent.viola.adapter.ILogAdapter;
import com.tencent.viola.adapter.IMultiV8ViolaRuntimeAdapter;
import com.tencent.viola.adapter.VComponentAdapter;
import com.tencent.viola.adapter.VWebSocketAdapter;
import com.tencent.viola.commons.IReportDelegate;
import com.tencent.viola.experiment.IExperimentConfigManager;

public class InitConfig
{
  private int businessId;
  private VComponentAdapter componentAdapter;
  private IExperimentConfigManager configManager;
  private String framework;
  private String frameworkLoaclPath;
  private IHttpAdapter httpAdapter;
  private ILogAdapter logAdapter;
  private IMultiV8ViolaRuntimeAdapter multiV8ViolaRuntimeAdapter;
  private IReportDelegate reportDelegate;
  private VWebSocketAdapter webSocketAdapter;
  
  public int getBusinessId()
  {
    return this.businessId;
  }
  
  public VComponentAdapter getComponentAdapter()
  {
    return this.componentAdapter;
  }
  
  public IExperimentConfigManager getConfigManager()
  {
    return this.configManager;
  }
  
  public String getFramework()
  {
    return this.framework;
  }
  
  public String getFrameworkLoaclPath()
  {
    return this.frameworkLoaclPath;
  }
  
  public IHttpAdapter getHttpAdapter()
  {
    return this.httpAdapter;
  }
  
  public ILogAdapter getLogAdapter()
  {
    return this.logAdapter;
  }
  
  public IMultiV8ViolaRuntimeAdapter getMultiV8ViolaRuntimeAdapter()
  {
    return this.multiV8ViolaRuntimeAdapter;
  }
  
  public IReportDelegate getReportDelegate()
  {
    return this.reportDelegate;
  }
  
  public VWebSocketAdapter getWebsocketAdapter()
  {
    return this.webSocketAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.InitConfig
 * JD-Core Version:    0.7.0.1
 */