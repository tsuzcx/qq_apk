package com.tencent.weiyun.transmission;

import android.app.Application;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import com.tencent.weiyun.transmission.db.OfflineFileHelper;
import com.tencent.weiyun.transmission.upload.UploadManager;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.uploader.xplatform.UploadNative;
import com.tencent.weiyun.utils.ILog;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class WeiyunTransmissionGlobal
{
  private static final Lock LOCK = new ReentrantLock();
  private static final String TAG = "WeiyunTransmissionGlobal";
  private static Singleton<WeiyunTransmissionGlobal, Void> sInstance = new WeiyunTransmissionGlobal.1();
  private WeiyunTransmissionGlobal.AppInfo mAppInfo;
  private Application mContext;
  private WeiyunTransmissionGlobal.HostInterface mHostInterface;
  private UploadManager mUploadManager;
  private PowerManager.WakeLock mWakeLock = null;
  private WifiManager.WifiLock mWifiLock = null;
  
  public static WeiyunTransmissionGlobal getInstance()
  {
    return (WeiyunTransmissionGlobal)sInstance.get(null);
  }
  
  public void acquireWakeLockIfNot()
  {
    synchronized (LOCK)
    {
      Object localObject1 = this.mWakeLock;
      int i = 1;
      if (localObject1 == null) {}
      try
      {
        this.mWakeLock = ((PowerManager)this.mContext.getSystemService("power")).newWakeLock(1, "WeiyunTransmissionGlobal");
      }
      catch (Throwable localThrowable1)
      {
        label42:
        break label42;
      }
      this.mWakeLock = null;
      TsLog.d("WeiyunTransmissionGlobal", "Wakelock new failed :(");
      if (this.mWakeLock != null)
      {
        this.mWakeLock.acquire();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Wakelock acquired :) held=");
        ((StringBuilder)localObject1).append(this.mWakeLock.isHeld());
        TsLog.d("WeiyunTransmissionGlobal", ((StringBuilder)localObject1).toString());
      }
      localObject1 = this.mWifiLock;
      if (localObject1 == null) {}
      try
      {
        localObject1 = (WifiManager)this.mContext.getSystemService("wifi");
        if (Build.VERSION.SDK_INT >= 12) {
          i = 3;
        }
        this.mWifiLock = ((WifiManager)localObject1).createWifiLock(i, "WeiyunTransmissionGlobal");
      }
      catch (Throwable localThrowable2)
      {
        label150:
        label217:
        break label150;
      }
      this.mWifiLock = null;
      TsLog.d("WeiyunTransmissionGlobal", "WifiLock new failed :(");
      localObject1 = this.mWifiLock;
      if (localObject1 != null) {}
      try
      {
        this.mWifiLock.acquire();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("WifiLock acquired :) held=");
        ((StringBuilder)localObject1).append(this.mWifiLock.isHeld());
        TsLog.d("WeiyunTransmissionGlobal", ((StringBuilder)localObject1).toString());
      }
      catch (Throwable localThrowable3)
      {
        break label217;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("WifiLock acquire failed :( held=");
      ((StringBuilder)localObject1).append(this.mWifiLock.isHeld());
      TsLog.d("WeiyunTransmissionGlobal", ((StringBuilder)localObject1).toString());
      return;
    }
  }
  
  public WeiyunTransmissionGlobal.AppInfo getAppInfo()
  {
    return this.mAppInfo;
  }
  
  public Application getApplication()
  {
    return this.mContext;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public WeiyunTransmissionGlobal.HostInterface getHostInterface()
  {
    return this.mHostInterface;
  }
  
  public List<String> getOfflinePath(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return OfflineFileHelper.getOfflineFilePath(paramString1, paramString2, paramString3);
    }
    return new ArrayList(0);
  }
  
  public UploadManager getUploadManager()
  {
    UploadManager localUploadManager = this.mUploadManager;
    if (localUploadManager != null) {
      return localUploadManager;
    }
    throw new IllegalStateException("Please call WeiyunLiteGlobal.initTransmission(...) in advance.");
  }
  
  public void initTransmission(WeiyunTransmissionGlobal.AppInfo paramAppInfo, Application paramApplication, WeiyunTransmissionGlobal.HostInterface paramHostInterface, ILog paramILog)
  {
    if ((paramAppInfo != null) && (paramApplication != null) && (paramHostInterface != null)) {}
    try
    {
      this.mAppInfo = paramAppInfo;
      this.mContext = paramApplication;
      this.mHostInterface = paramHostInterface;
      TsLog.setLog(paramILog);
      NetworkUtils.setNetworkInfoProvider(new WeiyunTransmissionGlobal.2(this));
      WeiyunTransmissionStatus.getInstance().initGlobalStatus(paramApplication);
      this.mUploadManager = UploadManager.getInstance();
      this.mUploadManager.init();
      return;
    }
    finally {}
    throw new IllegalArgumentException("The params appInfo, context and hostInterface should be no-null.");
  }
  
  public boolean isNativeUpload()
  {
    return UploadNative.getInstance().isLoaded();
  }
  
  public void releaseWakeLockIfExist()
  {
    synchronized (LOCK)
    {
      Object localObject1 = this.mWakeLock;
      if (localObject1 != null) {}
      try
      {
        this.mWakeLock.release();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Wakelock released :) held=");
        ((StringBuilder)localObject1).append(this.mWakeLock.isHeld());
        TsLog.d("WeiyunTransmissionGlobal", ((StringBuilder)localObject1).toString());
      }
      catch (Throwable localThrowable1)
      {
        label61:
        break label61;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Wakelock release failed :( held=");
      ((StringBuilder)localObject1).append(this.mWakeLock.isHeld());
      TsLog.d("WeiyunTransmissionGlobal", ((StringBuilder)localObject1).toString());
      localObject1 = this.mWifiLock;
      if (localObject1 != null) {}
      try
      {
        this.mWifiLock.release();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("WifiLock released :) held=");
        ((StringBuilder)localObject1).append(this.mWifiLock.isHeld());
        TsLog.d("WeiyunTransmissionGlobal", ((StringBuilder)localObject1).toString());
      }
      catch (Throwable localThrowable2)
      {
        label152:
        break label152;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("WifiLock release failed :( held=");
      ((StringBuilder)localObject1).append(this.mWifiLock.isHeld());
      TsLog.d("WeiyunTransmissionGlobal", ((StringBuilder)localObject1).toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.transmission.WeiyunTransmissionGlobal
 * JD-Core Version:    0.7.0.1
 */