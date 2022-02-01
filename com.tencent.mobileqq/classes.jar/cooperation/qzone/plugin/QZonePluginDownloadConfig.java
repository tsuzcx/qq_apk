package cooperation.qzone.plugin;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.provider.ExtraConfig;
import com.tencent.component.network.module.base.inter.IDownloadConfig;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.UploadEnv;
import cooperation.qzone.thread.QzoneBaseThread;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.util.HashMap;
import java.util.Properties;
import mqq.app.AppRuntime;

class QZonePluginDownloadConfig
  implements IDownloadConfig
{
  private long lastTime = 0L;
  
  private boolean isEnaough()
  {
    if (this.lastTime == 0L)
    {
      this.lastTime = System.currentTimeMillis();
      return true;
    }
    if (System.currentTimeMillis() - this.lastTime > 60000L)
    {
      this.lastTime = System.currentTimeMillis();
      return true;
    }
    return false;
  }
  
  private boolean isVip()
  {
    return QzoneConfig.getInstance().getConfig("PhotoDownload", "EnableColor", -1) == 1;
  }
  
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
    return QzoneConfig.getInstance().getConfig(paramString1, paramString2, paramLong);
  }
  
  public long getCurrentUin()
  {
    try
    {
      long l = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
      return l;
    }
    catch (Exception localException)
    {
      QLog.w("QzonePluginDownloadConfig", 1, "", localException);
    }
    return 0L;
  }
  
  public long getDefaultHttp2LiveTime()
  {
    return 0L;
  }
  
  public int getDefaultHttp2ThreadPoolSize()
  {
    return 0;
  }
  
  public long getDefaultHttpLiveTime()
  {
    return 0L;
  }
  
  public int getDefaultThreadPoolSize()
  {
    return 0;
  }
  
  public int getNetworkStackType()
  {
    return UploadEnv.getIpStack(1);
  }
  
  public int getOperator()
  {
    int i = ExtraConfig.a();
    if (QLog.isColorLevel()) {
      QLog.i("QZonePluginDownloadConfig", 2, "QzoneDownloadConfig ():WiFiCrarryType=" + i);
    }
    return i;
  }
  
  public String getQUA()
  {
    return QUA.getQUA3();
  }
  
  public String getRefer()
  {
    return "mqq";
  }
  
  public int getReportPercent()
  {
    if (isVip()) {
      return 100;
    }
    return 5;
  }
  
  public String getTerminal()
  {
    return "Android-QZoneInQQ";
  }
  
  public String getUserAgent()
  {
    return "qzone";
  }
  
  public String getVersion()
  {
    return QUA.getVersionForPic();
  }
  
  public boolean isFromQzoneAlbum(String paramString)
  {
    return false;
  }
  
  public int photoDownloadKeepAliveConfig()
  {
    return QzoneConfig.getInstance().getConfig("PhotoDownload", "KeepAlive", 0);
  }
  
  public int photoDownloadKeepAliveProxyConfig()
  {
    return QzoneConfig.getInstance().getConfig("PhotoDownload", "KeepAliveProxy", 1);
  }
  
  public void reportToBeacon(String paramString, boolean paramBoolean, HashMap<String, String> paramHashMap, long paramLong) {}
  
  public void reportToLp(int paramInt1, boolean paramBoolean, String paramString1, int paramInt2, String paramString2) {}
  
  public void reportToMta(String paramString, Properties paramProperties)
  {
    QzoneHandlerThreadFactory.getHandlerThread("Report_HandlerThread").post(new QZonePluginDownloadConfig.1(this, paramProperties, paramString));
  }
  
  public boolean shouldUseHttp2(String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.plugin.QZonePluginDownloadConfig
 * JD-Core Version:    0.7.0.1
 */