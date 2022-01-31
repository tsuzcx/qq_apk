package cooperation.qzone;

import amdm;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;
import com.tencent.upload.uinterface.IUploadEnv;
import cooperation.qzone.util.NetworkState;

public final class UploadEnv
  implements IUploadEnv
{
  UploadSoDownloader jdField_a_of_type_CooperationQzoneUploadSoDownloader = new UploadSoDownloader();
  private volatile boolean jdField_a_of_type_Boolean = true;
  
  public UploadEnv()
  {
    this.jdField_a_of_type_CooperationQzoneUploadSoDownloader.a();
  }
  
  private static NetworkInfo a(Context paramContext)
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (localNetworkInfo == null) {}
      for (paramContext = "getActiveNetworkInfo null";; paramContext = localNetworkInfo.toString())
      {
        QLog.d("UploadEnv", 1, paramContext);
        return localNetworkInfo;
      }
      return null;
    }
    catch (Throwable paramContext)
    {
      QLog.d("UploadEnv", 1, "fail to get active network info " + paramContext.toString());
    }
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = a(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public String getApnName()
  {
    return NetworkState.getAPN();
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
    switch ()
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 4: 
      return 6;
    case 2: 
      return 2;
    }
    return 3;
  }
  
  public int getFileConcurrentCount()
  {
    return 3;
  }
  
  public int getMobileOperatorCategory()
  {
    switch ()
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    }
    return 3;
  }
  
  public String getProviderName()
  {
    return NetworkState.getProviderName();
  }
  
  public int getSocketCount()
  {
    return 2;
  }
  
  public int getUploadVersion()
  {
    return 2;
  }
  
  public boolean isAvailable()
  {
    boolean bool = NetworkState.isNetSupport();
    this.jdField_a_of_type_Boolean = a(BaseApplication.getContext());
    QLog.d("upload2:", 2, "msf network isAvailable:" + bool + " observer:" + this.jdField_a_of_type_Boolean);
    return (bool) && (this.jdField_a_of_type_Boolean);
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
    boolean bool = this.jdField_a_of_type_CooperationQzoneUploadSoDownloader.a(paramString);
    QLog.d("UploadEnv", 1, "useDownloadedSo " + bool);
    if (bool) {
      return true;
    }
    QLog.d("UploadEnv", 1, "loadLibrary " + paramString);
    return Native.a(paramString, BaseApplication.getContext());
  }
  
  public void registerNetworkStateObserver(UploadConfiguration.NetworkStateObserver paramNetworkStateObserver)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UploadEnv", 2, "registerNetworkStateObserver");
    }
    NetworkState.addListener(new amdm(this, paramNetworkStateObserver));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.UploadEnv
 * JD-Core Version:    0.7.0.1
 */