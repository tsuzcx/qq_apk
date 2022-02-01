package com.tencent.pts.utils;

import android.os.HandlerThread;
import com.tencent.pts.core.PTSThreadUtil;

public class PTSConfig
{
  public static final String TAG = "PTSConfig";
  private PTSLogger logger;
  private PTSNodeVirtualUtil.INodeVirtualOnBindNodeInfo onBindNodeInfo;
  private PTSNodeVirtualUtil.INodeVirtualOnViewClick onViewClick;
  private PTSReportUtil.IPTSReport ptsReport;
  private HandlerThread subHandlerThread;
  
  public static void init(PTSConfig paramPTSConfig)
  {
    if (paramPTSConfig == null) {
      return;
    }
    PTSThreadUtil.registerSubHandlerThread(paramPTSConfig.subHandlerThread);
    PTSLog.registerLogger(paramPTSConfig.logger);
    PTSReportUtil.registerPtsReport(paramPTSConfig.ptsReport);
    PTSNodeVirtualUtil.register(paramPTSConfig.onBindNodeInfo, paramPTSConfig.onViewClick);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.utils.PTSConfig
 * JD-Core Version:    0.7.0.1
 */