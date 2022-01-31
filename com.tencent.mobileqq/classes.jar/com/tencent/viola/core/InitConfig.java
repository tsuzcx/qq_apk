package com.tencent.viola.core;

import com.tencent.viola.adapter.IHttpAdapter;
import com.tencent.viola.adapter.ILogAdapter;
import com.tencent.viola.adapter.VComponentAdapter;
import com.tencent.viola.adapter.VWebSocketAdapter;
import com.tencent.viola.commons.IReportDelegate;

public class InitConfig
{
  private int businessId;
  private VComponentAdapter componentAdapter;
  private String framework;
  private String frameworkLoaclPath;
  private IHttpAdapter httpAdapter;
  private ILogAdapter logAdapter;
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
  
  public IReportDelegate getReportDelegate()
  {
    return this.reportDelegate;
  }
  
  public VWebSocketAdapter getWebsocketAdapter()
  {
    return this.webSocketAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.core.InitConfig
 * JD-Core Version:    0.7.0.1
 */