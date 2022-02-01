package com.tencent.qqperf.monitor.network;

import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.utils.MonitorHttpInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class NetworkMonitorIPCModule
  extends QIPCModule
{
  private static NetworkMonitorIPCModule a;
  
  private NetworkMonitorIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static NetworkMonitorIPCModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new NetworkMonitorIPCModule("NetworkMonitorIPCModule");
        }
      }
      finally {}
    }
    return a;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("NetworkMonitorIPCModule : ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramBundle.toString());
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(", ");
      localStringBuilder.append(paramInt);
      QLog.d("NetworkMonitorIPCModule", 2, new Object[] { localObject, localStringBuilder.toString() });
    }
    if ("ACTION_REPORT_DOWNLOAD_URL".equalsIgnoreCase(paramString))
    {
      paramString = paramBundle.getString("BUNDLE_KEY_REPORT_DOWNLOAD_URL_URL", "");
      NetworkMonitor.a().a(paramString);
    }
    else if ("ACTION_REPORT_HTTPINFO".equalsIgnoreCase(paramString))
    {
      try
      {
        paramString = (MonitorHttpInfo)paramBundle.getSerializable("BUNDLE_KEY_REPORT_HTTP_INFO_INFO");
        localObject = paramBundle.getString("BUNDLE_KEY_REPORT_DOWNLOAD_URL_PROCESS_NAME", "");
        paramBundle = paramBundle.getString("BUNDLE_KEY_REPORT_DOWNLOAD_URL_TOP_ACTIVITY", "");
        if (paramString == null) {}
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NetworkMonitorIPCModule", 2, new Object[] { "ClassCastException", paramString.toString() });
        }
      }
    }
    try
    {
      NetworkMonitor.a().a(paramString, (String)localObject, paramBundle);
    }
    catch (Throwable paramString)
    {
      break label231;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NetworkMonitorIPCModule", 2, "MonitorHttpInfo == null");
    }
    label231:
    return new EIPCResult();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.network.NetworkMonitorIPCModule
 * JD-Core Version:    0.7.0.1
 */