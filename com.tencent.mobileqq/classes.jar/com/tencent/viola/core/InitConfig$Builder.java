package com.tencent.viola.core;

import com.tencent.viola.adapter.IHttpAdapter;
import com.tencent.viola.adapter.ILogAdapter;
import com.tencent.viola.adapter.VComponentAdapter;
import com.tencent.viola.adapter.VWebSocketAdapter;
import com.tencent.viola.commons.IReportDelegate;

public class InitConfig$Builder
{
  int businessId;
  VComponentAdapter componentAdapter;
  String framework;
  String frameworkLoaclPath;
  IHttpAdapter httpAdapter;
  ILogAdapter logAdapter;
  IReportDelegate reportDelegate;
  VWebSocketAdapter webSocketAdapter;
  
  public InitConfig build()
  {
    InitConfig localInitConfig = new InitConfig(null);
    InitConfig.access$102(localInitConfig, this.httpAdapter);
    InitConfig.access$202(localInitConfig, this.componentAdapter);
    InitConfig.access$302(localInitConfig, this.framework);
    InitConfig.access$402(localInitConfig, this.frameworkLoaclPath);
    InitConfig.access$502(localInitConfig, this.reportDelegate);
    InitConfig.access$602(localInitConfig, this.businessId);
    InitConfig.access$702(localInitConfig, this.webSocketAdapter);
    InitConfig.access$802(localInitConfig, this.logAdapter);
    return localInitConfig;
  }
  
  public Builder setBusinessId(int paramInt)
  {
    this.businessId = paramInt;
    return this;
  }
  
  public Builder setComponentAdapter(VComponentAdapter paramVComponentAdapter)
  {
    this.componentAdapter = paramVComponentAdapter;
    return this;
  }
  
  public Builder setFramework(String paramString)
  {
    this.framework = paramString;
    return this;
  }
  
  public Builder setFrameworkLoaclPath(String paramString)
  {
    this.frameworkLoaclPath = paramString;
    return this;
  }
  
  public Builder setHttpAdapter(IHttpAdapter paramIHttpAdapter)
  {
    this.httpAdapter = paramIHttpAdapter;
    return this;
  }
  
  public Builder setLogAdapter(ILogAdapter paramILogAdapter)
  {
    this.logAdapter = paramILogAdapter;
    return this;
  }
  
  public Builder setReportDelegate(IReportDelegate paramIReportDelegate)
  {
    this.reportDelegate = paramIReportDelegate;
    return this;
  }
  
  public Builder setWebsocketAdapter(VWebSocketAdapter paramVWebSocketAdapter)
  {
    this.webSocketAdapter = paramVWebSocketAdapter;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.core.InitConfig.Builder
 * JD-Core Version:    0.7.0.1
 */