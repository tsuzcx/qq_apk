package com.tencent.mobileqq.mini.reuse;

import android.text.TextUtils;
import bbdh;
import bhbo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.module.base.inter.IDownloadConfig;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import java.util.Properties;
import mqq.app.AppRuntime;

class MiniDownloadConfig
  implements IDownloadConfig
{
  private static final int DEFAULT_HTTP_LIVE_TIME = 60;
  private static final int DEFAULT_HTTP_THREAD_POOL_SIZE = 16;
  private static final String TAG = "MiniDownloadConfig";
  
  public boolean canRetCodeRetry(int paramInt)
  {
    return false;
  }
  
  public boolean enableDns114()
  {
    return true;
  }
  
  public long getConfig(String paramString1, String paramString2, long paramLong)
  {
    return 0L;
  }
  
  public long getCurrentUin()
  {
    long l = 0L;
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      l = Long.parseLong(str);
      return l;
    }
    catch (Throwable localThrowable) {}
    return 0L;
  }
  
  public long getDefaultHttp2LiveTime()
  {
    return getDefaultHttpLiveTime();
  }
  
  public int getDefaultHttp2ThreadPoolSize()
  {
    return getDefaultThreadPoolSize();
  }
  
  public long getDefaultHttpLiveTime()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_download_http_connect_live_time", 60);
  }
  
  public int getDefaultThreadPoolSize()
  {
    return QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_download_http_tp_size", 16);
  }
  
  public int getNetworkStackType()
  {
    return bhbo.a(1);
  }
  
  public int getOperator()
  {
    return 0;
  }
  
  public String getQUA()
  {
    return null;
  }
  
  public String getRefer()
  {
    return "miniApp";
  }
  
  public int getReportPercent()
  {
    return 0;
  }
  
  public String getTerminal()
  {
    return "Android-miniApp";
  }
  
  public String getUserAgent()
  {
    return "miniApp";
  }
  
  public String getVersion()
  {
    return bbdh.c();
  }
  
  public boolean isFromQzoneAlbum(String paramString)
  {
    return false;
  }
  
  public int photoDownloadKeepAliveConfig()
  {
    return 0;
  }
  
  public int photoDownloadKeepAliveProxyConfig()
  {
    return 0;
  }
  
  public void reportToBeacon(String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap, long paramLong) {}
  
  public void reportToLp(int paramInt1, boolean paramBoolean, String paramString1, int paramInt2, String paramString2) {}
  
  public void reportToMta(String paramString, Properties paramProperties) {}
  
  public boolean shouldUseHttp2(String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniDownloadConfig
 * JD-Core Version:    0.7.0.1
 */