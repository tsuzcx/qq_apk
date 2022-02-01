package cooperation.qzone;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;
import com.tencent.upload.uinterface.IUploadEnv;
import com.tencent.upload.uinterface.IUploadSoLoader;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;

public final class UploadEnv
  implements IUploadEnv, IUploadSoLoader
{
  private static final String TAG = "UploadEnv";
  public static final int TYPE_DOWNLOAD = 1;
  public static final int TYPE_UPLOAD = 0;
  public static final int TYPE_VIDEO = 2;
  private volatile boolean hasNetwork = true;
  UploadSoDownloader mSoDownloader = new UploadSoDownloader();
  
  public UploadEnv()
  {
    this.mSoDownloader.downloadUploadSo();
  }
  
  public static boolean enableV6Switch(int paramInt)
  {
    int i = QzoneConfig.getInstance().getConfig("QzoneUploadSetting", "UploadEnableV6RouteForAll", 7);
    if (paramInt != 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enableV6Switch:");
      localStringBuilder.append(i >> paramInt & 0x1);
      localStringBuilder.append(" type:");
      localStringBuilder.append(paramInt);
      QZLog.d("UploadEnv", 1, localStringBuilder.toString());
    }
    return (i >> paramInt & 0x1) == 1;
  }
  
  private static NetworkInfo getActiveNetworkInfo(Context paramContext)
  {
    try
    {
      localObject = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject == null) {
        paramContext = "getActiveNetworkInfo null";
      } else {
        paramContext = ((NetworkInfo)localObject).toString();
      }
      QLog.d("UploadEnv", 1, paramContext);
      return localObject;
    }
    catch (Throwable paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fail to get active network info ");
      ((StringBuilder)localObject).append(paramContext.toString());
      QLog.d("UploadEnv", 1, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public static int getIpStack(int paramInt)
  {
    if (!enableV6Switch(paramInt)) {
      return 1;
    }
    try
    {
      paramInt = com.tencent.upload.network.NetworkState.getNetworkStackType();
      return paramInt;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      QZLog.e("UploadEnv", "getIpStack error", localUnsatisfiedLinkError);
    }
    return 1;
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = getActiveNetworkInfo(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public String getApnName()
  {
    return cooperation.qzone.util.NetworkState.getAPN();
  }
  
  public String getBSSID()
  {
    return DeviceInfoUtil.b(BaseApplication.getContext());
  }
  
  public int getBatchControlCount()
  {
    return 8;
  }
  
  public int getCurrentNetworkCategory()
  {
    int j = cooperation.qzone.util.NetworkState.getNetworkType();
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
    int j = cooperation.qzone.util.NetworkState.getApnValue();
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
    return cooperation.qzone.util.NetworkState.getProviderName();
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
    boolean bool = cooperation.qzone.util.NetworkState.isNetSupport();
    this.hasNetwork = isNetworkAvailable(BaseApplication.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("msf network isAvailable:");
    localStringBuilder.append(bool);
    localStringBuilder.append(" observer:");
    localStringBuilder.append(this.hasNetwork);
    QLog.d("upload2:", 2, localStringBuilder.toString());
    return (bool) && (this.hasNetwork);
  }
  
  public boolean isMobile()
  {
    return cooperation.qzone.util.NetworkState.isMobile();
  }
  
  public boolean isWap()
  {
    return cooperation.qzone.util.NetworkState.isWap();
  }
  
  public boolean isWifi()
  {
    return cooperation.qzone.util.NetworkState.isWifiConn();
  }
  
  public boolean loadLibrary(String paramString)
  {
    boolean bool = this.mSoDownloader.loadLibrary(paramString);
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("useDownloadedSo ");
    localStringBuilder1.append(bool);
    QLog.d("UploadEnv", 1, localStringBuilder1.toString());
    if (bool) {
      return true;
    }
    try
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("try to load library: ");
      localStringBuilder1.append(paramString);
      localStringBuilder1.append(" from system lib");
      QLog.d("UploadEnv", 1, localStringBuilder1.toString());
      System.loadLibrary(paramString);
      return true;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("cannot load library ");
      localStringBuilder2.append(paramString);
      localStringBuilder2.append(" from system lib");
      QLog.e("UploadEnv", 1, localStringBuilder2.toString(), localThrowable);
    }
    return false;
  }
  
  public void registerNetworkStateObserver(UploadConfiguration.NetworkStateObserver paramNetworkStateObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UploadEnv", 2, "registerNetworkStateObserver");
    }
    cooperation.qzone.util.NetworkState.addListener(new UploadEnv.1(this, paramNetworkStateObserver));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.UploadEnv
 * JD-Core Version:    0.7.0.1
 */