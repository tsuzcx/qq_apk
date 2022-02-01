package com.tencent.tmdownloader;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tmassistant.common.PackageInstallReceiver;
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.aa;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.k;
import com.tencent.tmassistantbase.util.m;
import com.tencent.tmassistantbase.util.s;
import com.tencent.tmdownloader.internal.downloadclient.MobileQQCloseServiceReceiver;
import com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager;
import com.tencent.tmdownloader.internal.notification.NotifyParam;
import com.tencent.tmdownloader.internal.storage.d;
import java.util.HashMap;

public class TMAssistantDownloadService
  extends Service
  implements com.tencent.tmdownloader.internal.downloadservice.a.a
{
  private static final int MSG_HANDSHAKE_YYB = 1;
  private static final int MSG_INIT_YYBMG = 0;
  protected static final String TAG = "TMADownloadSDKService";
  protected final y downloadSDKServiceImpl = new y(this);
  protected final HashMap<com.tencent.tmassistant.aidl.a, String> mCallbackHashMap = new HashMap();
  protected final RemoteCallbackList<com.tencent.tmassistant.aidl.a> mCallbacks = new RemoteCallbackList();
  private Handler mHandler = new x(this);
  private m mLogListener = null;
  com.tencent.tmdownloader.internal.notification.a mNotificationManager = null;
  com.tencent.tmdownloader.internal.downloadservice.a.c mServiceDownloadTaskManager = null;
  private com.tencent.tmdownloader.internal.downloadclient.c yybManager = null;
  
  private boolean handlePush(NotifyParam paramNotifyParam)
  {
    switch (paramNotifyParam.notificationTypeId)
    {
    default: 
      break;
    case 105: 
      ApkDownloadManager.getInstance().restartDownload(paramNotifyParam.url);
      break;
    case 104: 
      paramNotifyParam = ApkDownloadManager.getInstance().queryDownloadInfo(paramNotifyParam.url);
      if (paramNotifyParam != null)
      {
        com.tencent.tmdownloader.internal.downloadservice.a.a(d.a(paramNotifyParam.j));
        com.tencent.tmdownloader.internal.notification.a.a().b(String.valueOf(paramNotifyParam.q));
      }
      break;
    case 103: 
      ApkDownloadManager.getInstance().continueDownload(paramNotifyParam.url);
      break;
    case 101: 
    case 102: 
      ApkDownloadManager.getInstance().pauseDownload(paramNotifyParam.url);
    }
    return true;
  }
  
  public void OnDownloadProgressChanged(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    for (;;)
    {
      int i;
      try
      {
        synchronized (this.mCallbacks)
        {
          int j = this.mCallbacks.beginBroadcast();
          i = 0;
          if (i < j) {
            try
            {
              com.tencent.tmassistant.aidl.a locala = (com.tencent.tmassistant.aidl.a)this.mCallbacks.getBroadcastItem(i);
              String str = (String)this.mCallbackHashMap.get(locala);
              if (str != null) {
                try
                {
                  if (str.equals(paramString1) != true) {
                    break label154;
                  }
                  locala.a(paramString1, paramString2, paramLong1, paramLong2);
                }
                catch (RemoteException localRemoteException1) {}
              }
            }
            catch (RemoteException localRemoteException2)
            {
              ab.c("TMADownloadSDKService", "exception: ", localRemoteException2);
            }
          }
          this.mCallbacks.finishBroadcast();
        }
      }
      catch (Throwable paramString1)
      {
        Log.e("TMADownloadSDKService", "exception: ", paramString1);
        ab.c("TMADownloadSDKService", "<OnDownloadProgressChanged>exit");
        return;
      }
      for (;;)
      {
        throw paramString1;
      }
      label154:
      i += 1;
    }
  }
  
  public void OnDownloadStateChanged(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    for (;;)
    {
      int i;
      try
      {
        synchronized (this.mCallbacks)
        {
          int j = this.mCallbacks.beginBroadcast();
          i = 0;
          if (i < j) {
            try
            {
              com.tencent.tmassistant.aidl.a locala = (com.tencent.tmassistant.aidl.a)this.mCallbacks.getBroadcastItem(i);
              String str = (String)this.mCallbackHashMap.get(locala);
              if ((str == null) || (str.equals(paramString1) != true)) {
                break label148;
              }
              locala.a(paramString1, paramString2, paramInt1, paramInt2, paramString3);
            }
            catch (RemoteException localRemoteException)
            {
              Log.e("TMADownloadSDKService", "exception: ", localRemoteException);
            }
          }
          this.mCallbacks.finishBroadcast();
        }
      }
      catch (Throwable paramString1)
      {
        ab.c("TMADownloadSDKService", "exception: ", paramString1);
        ab.c("TMADownloadSDKService", "<OnDownloadStateChanged>exit");
        return;
      }
      for (;;)
      {
        throw paramString1;
      }
      label148:
      i += 1;
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    ab.c("TMADownloadSDKService", "<onBind>enter");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<onBind>intent:");
    localStringBuilder.append(paramIntent);
    ab.c("TMADownloadSDKService", localStringBuilder.toString());
    paramIntent = new StringBuilder();
    paramIntent.append("<onBind>returnValue: ");
    paramIntent.append(this.downloadSDKServiceImpl);
    ab.c("TMADownloadSDKService", paramIntent.toString());
    ab.c("TMADownloadSDKService", "<onBind>exit");
    return this.downloadSDKServiceImpl;
  }
  
  public void onCreate()
  {
    long l = System.currentTimeMillis();
    ab.c("TMADownloadSDKService", "<onCreate>enter");
    super.onCreate();
    GlobalUtil.getInstance().setContext(this);
    NetworkMonitorReceiver.getInstance().registerReceiver();
    s.d();
    try
    {
      MobileQQCloseServiceReceiver.a().a(this);
      label38:
      k.a().post(new v(this));
      new Thread(new w(this)).start();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TMAssistantDownloadService.onCreate end, timeCost = ");
      localStringBuilder.append(System.currentTimeMillis() - l);
      aa.a(localStringBuilder.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      break label38;
    }
  }
  
  public void onDestroy()
  {
    ab.c("TMADownloadSDKService", "<onDestroy>enter");
    super.onDestroy();
    ApkDownloadManager.getInstance().uninit();
    Object localObject = this.mServiceDownloadTaskManager;
    if (localObject != null)
    {
      ((com.tencent.tmdownloader.internal.downloadservice.a.c)localObject).b();
      this.mServiceDownloadTaskManager.a(null);
      this.mServiceDownloadTaskManager = null;
    }
    localObject = this.mNotificationManager;
    if (localObject != null)
    {
      ((com.tencent.tmdownloader.internal.notification.a)localObject).c();
      this.mNotificationManager = null;
    }
    NetworkMonitorReceiver.getInstance().unregisterReceiver();
    GlobalUtil.getInstance().destroy();
    MobileQQCloseServiceReceiver.a().b(this);
    try
    {
      PackageInstallReceiver.a().b(this);
      label88:
      SystemClock.sleep(300L);
      ab.c("TMADownloadSDKService", "<onDestroy>exit");
      Process.killProcess(Process.myPid());
      return;
    }
    catch (Throwable localThrowable)
    {
      break label88;
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    ab.c("TMADownloadSDKService", "onStartCommand......");
    String str1 = null;
    String str2;
    if (paramIntent != null)
    {
      try
      {
        str1 = paramIntent.getStringExtra("client_key");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        str2 = null;
      }
      try
      {
        paramIntent = (NotifyParam)paramIntent.getParcelableExtra("notifyParam");
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        paramIntent = null;
      }
      if (paramIntent != null) {
        if (!TextUtils.isEmpty(paramIntent.url)) {
          handlePush(paramIntent);
        } else {
          return 2;
        }
      }
    }
    paramIntent = new StringBuilder();
    paramIntent.append("onStartCommand......clientKey : ");
    paramIntent.append(str2);
    ab.c("TMADownloadSDKService", paramIntent.toString());
    paramIntent = new Message();
    paramIntent.what = 0;
    paramIntent.obj = str2;
    this.mHandler.sendMessage(paramIntent);
    return 2;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    ab.c("TMADownloadSDKService", "<onUnbind>enter");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<onUnbind>intent:");
    localStringBuilder.append(paramIntent);
    ab.c("TMADownloadSDKService", localStringBuilder.toString());
    boolean bool = super.onUnbind(paramIntent);
    paramIntent = new StringBuilder();
    paramIntent.append("<onUnbind>returnValue: ");
    paramIntent.append(bool);
    ab.c("TMADownloadSDKService", paramIntent.toString());
    ab.c("TMADownloadSDKService", "<onUnbind>exit");
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.TMAssistantDownloadService
 * JD-Core Version:    0.7.0.1
 */