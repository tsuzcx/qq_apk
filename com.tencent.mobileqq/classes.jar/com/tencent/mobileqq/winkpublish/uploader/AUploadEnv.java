package com.tencent.mobileqq.winkpublish.uploader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.IUploadSoLoader;
import cooperation.qqcircle.utils.NetworkState;
import java.io.File;

public class AUploadEnv
  implements IUploadEnv, IUploadSoLoader
{
  AUploadSoDownloader a = new AUploadSoDownloader();
  private volatile boolean b = true;
  
  public AUploadEnv()
  {
    this.a.a();
  }
  
  public static boolean a(int paramInt)
  {
    int i = QCircleConfigHelper.a("QzoneUploadSetting", "UploadEnableV6RouteForAll", Integer.valueOf(7)).intValue();
    if (paramInt != 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enableV6Switch:");
      localStringBuilder.append(i >> paramInt & 0x1);
      localStringBuilder.append(" type:");
      localStringBuilder.append(paramInt);
      QLog.d("[upload2]AUploadEnv", 1, localStringBuilder.toString());
    }
    return (i >> paramInt & 0x1) == 1;
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = b(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  private static NetworkInfo b(Context paramContext)
  {
    try
    {
      localObject = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject == null) {
        paramContext = "getActiveNetworkInfo null";
      } else {
        paramContext = ((NetworkInfo)localObject).toString();
      }
      QLog.d("[upload2]AUploadEnv", 1, paramContext);
      return localObject;
    }
    catch (Throwable paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fail to get active network info ");
      ((StringBuilder)localObject).append(paramContext.getMessage());
      QLog.d("[upload2]AUploadEnv", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public String getApnName()
  {
    return NetworkState.getAPN();
  }
  
  public String getBSSID()
  {
    return HostStaticInvokeHelper.getDeviceInfoBSSID();
  }
  
  public int getBatchControlCount()
  {
    return 8;
  }
  
  public int getCurrentNetworkCategory()
  {
    int j = NetworkState.getNetworkType();
    int i = 1;
    if (j != 1)
    {
      i = 3;
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4)
          {
            if (j != 5) {
              return 0;
            }
            return 7;
          }
          return 6;
        }
        return 2;
      }
    }
    return i;
  }
  
  public int getFileConcurrentCount()
  {
    return 3;
  }
  
  public int getMobileOperatorCategory()
  {
    int j = NetworkState.getApnValue();
    int i = 1;
    if (j != 1)
    {
      i = 2;
      if (j != 2)
      {
        i = 3;
        if (j != 3) {
          return 0;
        }
      }
    }
    return i;
  }
  
  public String getProviderName()
  {
    return NetworkState.getProviderName();
  }
  
  public String getSDKPrivatePath(String paramString)
  {
    return VFSAssistantUtils.getSDKPrivatePath(paramString);
  }
  
  public String getSoVersion()
  {
    return "v1.3";
  }
  
  public int getSocketCount()
  {
    return 2;
  }
  
  public boolean isAvailable()
  {
    boolean bool = NetworkState.isNetSupport();
    this.b = a(RFApplication.getApplication());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msf network isAvailable:");
    localStringBuilder.append(bool);
    localStringBuilder.append(" observer:");
    localStringBuilder.append(this.b);
    QLog.d("[upload2]AUploadEnv", 1, localStringBuilder.toString());
    return (bool) && (this.b);
  }
  
  public boolean isMobile()
  {
    return NetworkState.isMobile();
  }
  
  public boolean isWap()
  {
    return NetworkState.isWap();
  }
  
  public boolean isWifi()
  {
    return NetworkState.isWifiConn();
  }
  
  public boolean loadLibrary(String paramString)
  {
    boolean bool = this.a.a(paramString);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("useDownloadedSo ");
    ((StringBuilder)localObject).append(bool);
    QLog.d("[upload2]AUploadEnv", 1, ((StringBuilder)localObject).toString());
    if (bool) {
      return true;
    }
    try
    {
      localObject = HostUIHelper.getInstance().getHostApplicationContext().getDir("lib", 0).getParent();
      if (localObject == null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("cannot load library ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" from system lib rootPath:");
        QLog.e("[upload2]AUploadEnv", 1, new Object[] { localStringBuilder.toString(), localObject });
        return false;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("/lib/lib");
      localStringBuilder.append(paramString);
      localStringBuilder.append(".so");
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("try to load library: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" from system lib");
      QLog.d("[upload2]AUploadEnv", 1, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("so name:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" is file exit:");
      localStringBuilder.append(FileUtils.fileExists((String)localObject));
      QLog.d("[upload2]AUploadEnv", 1, localStringBuilder.toString());
      System.load((String)localObject);
      return true;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cannot load library ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" from system lib");
      QLog.e("[upload2]AUploadEnv", 1, localStringBuilder.toString(), localThrowable);
    }
    return false;
  }
  
  public void registerNetworkStateObserver(UploadConfiguration.NetworkStateObserver paramNetworkStateObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[upload2]AUploadEnv", 2, "registerNetworkStateObserver");
    }
    NetworkState.addListener(new AUploadEnv.1(this, paramNetworkStateObserver));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.uploader.AUploadEnv
 * JD-Core Version:    0.7.0.1
 */