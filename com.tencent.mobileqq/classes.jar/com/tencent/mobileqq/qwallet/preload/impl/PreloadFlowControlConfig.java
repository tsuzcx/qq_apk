package com.tencent.mobileqq.qwallet.preload.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class PreloadFlowControlConfig
  implements Serializable
{
  public static final String CONFIG_NAME = "flow_config";
  private static Map<String, PreloadFlowControlConfig> a = new HashMap();
  private static final long serialVersionUID = 1L;
  private String mConfigPath;
  public int mDownloadStatus = -1;
  public long mNextCanReqTime;
  public long mNextRetryReqTime;
  public int mRetryDownloadTimes;
  public int mRetryReqTimes;
  public long mValidDownloadTime;
  
  public PreloadFlowControlConfig(String paramString)
  {
    this.mConfigPath = paramString;
  }
  
  public static String getConfigPath(String paramString, AppRuntime paramAppRuntime)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PreloadStaticApi.a(paramAppRuntime));
    localStringBuilder.append(paramString);
    localStringBuilder.append("flow_config");
    return localStringBuilder.toString();
  }
  
  public static PreloadFlowControlConfig getFlowControlConfig(String paramString, AppRuntime paramAppRuntime)
  {
    Object localObject;
    String str1;
    String str2;
    label72:
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(paramAppRuntime.getAccount());
      str1 = ((StringBuilder)localObject).toString();
      localObject = (PreloadFlowControlConfig)a.get(str1);
      if (localObject != null) {
        return localObject;
      }
      str2 = getConfigPath(paramString, paramAppRuntime);
    }
    finally {}
    try
    {
      paramString = (PreloadFlowControlConfig)QWalletTools.e(str2);
    }
    catch (Exception paramString)
    {
      break label72;
    }
    paramString = (String)localObject;
    paramAppRuntime = paramString;
    if (paramString == null) {
      paramAppRuntime = new PreloadFlowControlConfig(str2);
    }
    a.put(str1, paramAppRuntime);
    return paramAppRuntime;
  }
  
  public void saveConfig()
  {
    ThreadManager.getFileThreadHandler().post(new PreloadFlowControlConfig.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadFlowControlConfig
 * JD-Core Version:    0.7.0.1
 */