package com.tencent.pts.utils;

import android.os.HandlerThread;

public class PTSConfig$PTSConfigBuilder
{
  private PTSConfig ptsConfig = new PTSConfig();
  
  public PTSConfig build()
  {
    return this.ptsConfig;
  }
  
  public PTSConfigBuilder withHandlerThread(HandlerThread paramHandlerThread)
  {
    PTSConfig.access$002(this.ptsConfig, paramHandlerThread);
    return this;
  }
  
  public PTSConfigBuilder withLogger(PTSLogger paramPTSLogger)
  {
    PTSConfig.access$102(this.ptsConfig, paramPTSLogger);
    return this;
  }
  
  public PTSConfigBuilder withOnBindNodeInfo(PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo paramINodeVirtualOnBindNodeInfo)
  {
    PTSConfig.access$302(this.ptsConfig, paramINodeVirtualOnBindNodeInfo);
    return this;
  }
  
  public PTSConfigBuilder withOnViewClick(PTSNodeVirtualUtil.INodeVirtualOnViewClick paramINodeVirtualOnViewClick)
  {
    PTSConfig.access$402(this.ptsConfig, paramINodeVirtualOnViewClick);
    return this;
  }
  
  public PTSConfigBuilder withPtsReport(PTSReportUtil.IPTSReport paramIPTSReport)
  {
    PTSConfig.access$202(this.ptsConfig, paramIPTSReport);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.utils.PTSConfig.PTSConfigBuilder
 * JD-Core Version:    0.7.0.1
 */