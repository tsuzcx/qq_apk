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
import com.tencent.tmassistantbase.network.NetworkMonitorReceiver;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.f;
import com.tencent.tmassistantbase.util.h;
import com.tencent.tmassistantbase.util.m;
import com.tencent.tmassistantbase.util.r;
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
  protected final x downloadSDKServiceImpl = new x(this);
  protected final HashMap<com.tencent.tmassistant.aidl.a, String> mCallbackHashMap = new HashMap();
  protected final RemoteCallbackList<com.tencent.tmassistant.aidl.a> mCallbacks = new RemoteCallbackList();
  private Handler mHandler = new w(this);
  private h mLogListener = null;
  com.tencent.tmdownloader.internal.notification.a mNotificationManager = null;
  com.tencent.tmdownloader.internal.downloadservice.a.c mServiceDownloadTaskManager = null;
  private com.tencent.tmdownloader.internal.downloadclient.c yybManager = null;
  
  private boolean handlePush(NotifyParam paramNotifyParam)
  {
    switch (paramNotifyParam.notificationTypeId)
    {
    }
    for (;;)
    {
      return true;
      ApkDownloadManager.getInstance().pauseDownload(paramNotifyParam.url);
      continue;
      ApkDownloadManager.getInstance().continueDownload(paramNotifyParam.url);
      continue;
      paramNotifyParam = ApkDownloadManager.getInstance().queryDownloadInfo(paramNotifyParam.url);
      if (paramNotifyParam != null)
      {
        com.tencent.tmdownloader.internal.downloadservice.a.a(d.a(paramNotifyParam.j));
        com.tencent.tmdownloader.internal.notification.a.a().b(String.valueOf(paramNotifyParam.r));
        continue;
        ApkDownloadManager.getInstance().restartDownload(paramNotifyParam.url);
      }
    }
  }
  
  public void OnDownloadProgressChanged(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    label127:
    synchronized (this.mCallbacks)
    {
      try
      {
        int j = this.mCallbacks.beginBroadcast();
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label127;
          }
          try
          {
            com.tencent.tmassistant.aidl.a locala = (com.tencent.tmassistant.aidl.a)this.mCallbacks.getBroadcastItem(i);
            String str = (String)this.mCallbackHashMap.get(locala);
            if ((str != null) && (str.equals(paramString1) == true)) {
              locala.a(paramString1, paramString2, paramLong1, paramLong2);
            }
          }
          catch (RemoteException localRemoteException)
          {
            for (;;)
            {
              r.c("TMADownloadSDKService", "exception: ", localRemoteException);
            }
          }
          i += 1;
        }
        this.mCallbacks.finishBroadcast();
      }
      catch (Throwable paramString1)
      {
        Log.e("TMADownloadSDKService", "exception: ", paramString1);
        r.c("TMADownloadSDKService", "<OnDownloadProgressChanged>exit");
        return;
      }
    }
  }
  
  public void OnDownloadStateChanged(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    label129:
    synchronized (this.mCallbacks)
    {
      try
      {
        int j = this.mCallbacks.beginBroadcast();
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label129;
          }
          try
          {
            com.tencent.tmassistant.aidl.a locala = (com.tencent.tmassistant.aidl.a)this.mCallbacks.getBroadcastItem(i);
            String str = (String)this.mCallbackHashMap.get(locala);
            if ((str != null) && (str.equals(paramString1) == true)) {
              locala.a(paramString1, paramString2, paramInt1, paramInt2, paramString3);
            }
          }
          catch (RemoteException localRemoteException)
          {
            for (;;)
            {
              Log.e("TMADownloadSDKService", "exception: ", localRemoteException);
            }
          }
          i += 1;
        }
        this.mCallbacks.finishBroadcast();
      }
      catch (Throwable paramString1)
      {
        r.c("TMADownloadSDKService", "exception: ", paramString1);
        r.c("TMADownloadSDKService", "<OnDownloadStateChanged>exit");
        return;
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    r.c("TMADownloadSDKService", "<onBind>enter");
    r.c("TMADownloadSDKService", "<onBind>intent:" + paramIntent);
    r.c("TMADownloadSDKService", "<onBind>returnValue: " + this.downloadSDKServiceImpl);
    r.c("TMADownloadSDKService", "<onBind>exit");
    return this.downloadSDKServiceImpl;
  }
  
  public void onCreate()
  {
    r.c("TMADownloadSDKService", "<onCreate>enter");
    super.onCreate();
    GlobalUtil.getInstance().setContext(this);
    NetworkMonitorReceiver.a().b();
    m.d();
    try
    {
      MobileQQCloseServiceReceiver.a().a(this);
      label34:
      f.a().post(new u(this));
      new Thread(new v(this)).start();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label34;
    }
  }
  
  public void onDestroy()
  {
    r.c("TMADownloadSDKService", "<onDestroy>enter");
    super.onDestroy();
    ApkDownloadManager.getInstance().uninit();
    if (this.mServiceDownloadTaskManager != null)
    {
      this.mServiceDownloadTaskManager.b();
      this.mServiceDownloadTaskManager.a(null);
      this.mServiceDownloadTaskManager = null;
    }
    if (this.mNotificationManager != null)
    {
      this.mNotificationManager.c();
      this.mNotificationManager = null;
    }
    NetworkMonitorReceiver.a().c();
    GlobalUtil.getInstance().destroy();
    MobileQQCloseServiceReceiver.a().b(this);
    SystemClock.sleep(300L);
    r.c("TMADownloadSDKService", "<onDestroy>exit");
    Process.killProcess(Process.myPid());
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    r.c("TMADownloadSDKService", "onStartCommand......");
    if (paramIntent != null) {}
    for (;;)
    {
      try
      {
        localObject1 = paramIntent.getStringExtra("client_key");
      }
      catch (Exception localException)
      {
        try
        {
          Object localObject1;
          localNotifyParam = (NotifyParam)paramIntent.getParcelableExtra("notifyParam");
          paramIntent = (Intent)localObject1;
          if (localNotifyParam != null)
          {
            if (!TextUtils.isEmpty(localNotifyParam.url))
            {
              handlePush(localNotifyParam);
              paramIntent = (Intent)localObject1;
            }
          }
          else
          {
            r.c("TMADownloadSDKService", "onStartCommand......clientKey : " + paramIntent);
            localObject1 = new Message();
            ((Message)localObject1).what = 0;
            ((Message)localObject1).obj = paramIntent;
            this.mHandler.sendMessage((Message)localObject1);
          }
          return 2;
          localException = localException;
          localException.printStackTrace();
          Object localObject2 = null;
          continue;
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
          NotifyParam localNotifyParam = null;
          continue;
        }
      }
      paramIntent = null;
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    r.c("TMADownloadSDKService", "<onUnbind>enter");
    r.c("TMADownloadSDKService", "<onUnbind>intent:" + paramIntent);
    boolean bool = super.onUnbind(paramIntent);
    r.c("TMADownloadSDKService", "<onUnbind>returnValue: " + bool);
    r.c("TMADownloadSDKService", "<onUnbind>exit");
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.TMAssistantDownloadService
 * JD-Core Version:    0.7.0.1
 */