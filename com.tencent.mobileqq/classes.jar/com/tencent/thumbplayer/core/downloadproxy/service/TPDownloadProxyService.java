package com.tencent.thumbplayer.core.downloadproxy.service;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.thumbplayer.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl.Stub;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import java.util.Iterator;
import java.util.List;

public class TPDownloadProxyService
  extends Service
{
  private static final String FILE_NAME = "TPDownloadProxyService";
  private TPDownloadProxyFactoryAidl.Stub downloadProxyFactory = null;
  private int pid = -1;
  
  private boolean isExistMainProcess()
  {
    try
    {
      Iterator localIterator = ((ActivityManager)getSystemService("activity")).getRunningAppProcesses().iterator();
      while (localIterator.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
        String str = localRunningAppProcessInfo.processName;
        if ((!TextUtils.isEmpty(str)) && (str.equals(getPackageName())))
        {
          if ((this.pid != -1) && (this.pid != localRunningAppProcessInfo.pid))
          {
            this.pid = localRunningAppProcessInfo.pid;
            return false;
          }
          this.pid = localRunningAppProcessInfo.pid;
          TPDLProxyLog.i("TPDownloadProxyService", 0, "tpdlnative", "app main exist!");
          return true;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      TPDLProxyLog.i("TPDownloadProxyService", 0, "tpdlnative", "isExistMainProcess failed, error:" + localThrowable.toString());
    }
    return false;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (this.downloadProxyFactory == null) {
      this.downloadProxyFactory = new TPDownloadProxyService.DownloadProxyFactory(this, null);
    }
    isExistMainProcess();
    return this.downloadProxyFactory;
  }
  
  public void onRebind(Intent paramIntent)
  {
    TPDLProxyLog.i("TPDownloadProxyService", 0, "tpdlnative", "on rebind!");
    isExistMainProcess();
    super.onRebind(paramIntent);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    super.onStartCommand(paramIntent, paramInt1, paramInt2);
    return 2;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    TPDLProxyLog.i("TPDownloadProxyService", 0, "tpdlnative", "on unbind!");
    super.onUnbind(paramIntent);
    if (!isExistMainProcess()) {}
    try
    {
      TPDownloadProxyNative.getInstance().stopAllDownload(3);
      TPListenerManager.getInstance().removeAllPlayListener();
      TPListenerManager.getInstance().removeAllPreLoadListener();
      return true;
    }
    catch (Throwable paramIntent)
    {
      for (;;)
      {
        TPDLProxyLog.e("TPDownloadProxyService", 0, "tpdlnative", paramIntent.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.downloadproxy.service.TPDownloadProxyService
 * JD-Core Version:    0.7.0.1
 */