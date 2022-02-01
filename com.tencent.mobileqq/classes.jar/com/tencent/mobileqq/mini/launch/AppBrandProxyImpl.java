package com.tencent.mobileqq.mini.launch;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppBrandProxyImpl
{
  public static final int PROCESS_STATUS_BACKGROUND = 3;
  public static final int PROCESS_STATUS_FOREGROUND = 2;
  public static final int PROCESS_STATUS_START = 1;
  public static final int PROCESS_STATUS_STOP = 4;
  private static final String TAG = "miniapp-process_AppBrandProxy";
  private static byte[] lock = new byte[0];
  private boolean isConnecting = false;
  private MiniAppConfig mAppConfig;
  private ServiceConnection mConnection = new AppBrandProxyImpl.1(this);
  private Context mContext;
  private int mMiniAppStatus;
  private boolean mNeedSyncStatus = false;
  private IAppBrandService mService;
  private Bundle mStartBundle;
  private List<Runnable> mTaskAfterConnected = new ArrayList();
  
  public AppBrandProxyImpl(Context paramContext)
  {
    this.mContext = paramContext;
    ensureService();
  }
  
  private void doAfterServiceConnected()
  {
    try
    {
      Object localObject = new ArrayList(this.mTaskAfterConnected);
      this.mTaskAfterConnected.clear();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Runnable localRunnable = (Runnable)((Iterator)localObject).next();
        if (localRunnable != null) {
          localRunnable.run();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("miniapp-process_AppBrandProxy", 1, "doAfterServiceConnected exception!", localThrowable);
    }
  }
  
  private void doStartMiniApp(Activity paramActivity, MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver) {}
  
  private boolean ensureService()
  {
    try
    {
      boolean bool = isMainProcess();
      if (bool) {
        return false;
      }
      Object localObject1 = this.mService;
      if (localObject1 != null) {
        return true;
      }
      bool = this.isConnecting;
      if (bool) {
        return false;
      }
      if (this.mService == null)
      {
        QLog.w("miniapp-process_AppBrandProxy", 1, "mService is null! Begin Bind Service!");
        localObject1 = new Intent();
        ((Intent)localObject1).setComponent(new ComponentName(this.mContext, "com.tencent.mobileqq.mini.launch.AppBrandMainService"));
        ((Intent)localObject1).putExtra("mini_process_name", BaseApplicationImpl.getApplication().getQQProcessName());
        this.isConnecting = true;
        try
        {
          this.mContext.bindService((Intent)localObject1, this.mConnection, 1);
        }
        catch (Throwable localThrowable)
        {
          QLog.w("miniapp-process_AppBrandProxy", 1, "exception when bind lbs service!!!", localThrowable);
        }
      }
      return false;
    }
    finally {}
  }
  
  private boolean isMainProcess()
  {
    return "com.tencent.mobileqq".equals(BaseApplicationImpl.getApplication().getQQProcessName());
  }
  
  private void notifyToService()
  {
    try
    {
      boolean bool = this.mNeedSyncStatus;
      if (!bool) {
        return;
      }
      this.mNeedSyncStatus = false;
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Sync Process Status=");
        ((StringBuilder)localObject1).append(this.mMiniAppStatus);
        QLog.w("miniapp-process_AppBrandProxy", 1, ((StringBuilder)localObject1).toString());
        localObject1 = BaseApplicationImpl.getApplication().getQQProcessName();
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains(":mini")))
        {
          this.mService.onAppStart((String)localObject1, this.mAppConfig, this.mStartBundle);
          if (this.mMiniAppStatus == 3) {
            this.mService.onAppBackground((String)localObject1, this.mAppConfig, null);
          } else if (this.mMiniAppStatus == 2) {
            this.mService.onAppForeground((String)localObject1, this.mAppConfig, null);
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("miniapp-process_AppBrandProxy", 1, "onAppStart exception.", localThrowable);
      }
      return;
    }
    finally {}
  }
  
  private void performStartMiniApp(Activity paramActivity, MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver)
  {
    try
    {
      this.mService.startMiniApp(paramMiniAppConfig, new AppBrandProxyImpl.3(this, new Handler(Looper.getMainLooper()), paramResultReceiver, paramActivity, paramMiniAppConfig));
      return;
    }
    catch (Throwable paramActivity)
    {
      QLog.e("miniapp-process_AppBrandProxy", 1, "startMiniApp exception.", paramActivity);
    }
  }
  
  public IAppBrandService getService()
  {
    try
    {
      if (this.mService != null)
      {
        localIAppBrandService = this.mService;
        return localIAppBrandService;
      }
      ensureService();
      IAppBrandService localIAppBrandService = this.mService;
      return localIAppBrandService;
    }
    finally {}
  }
  
  public void onAppBackground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    try
    {
      this.mMiniAppStatus = 3;
      if (getService() == null)
      {
        QLog.e("miniapp-process_AppBrandProxy", 1, "onAppBackground IAppBrandService Connection is Null.");
        return;
      }
      try
      {
        QLog.e("miniapp-process_AppBrandProxy", 1, "notify onAppBackground");
        this.mService.onAppBackground(paramString, paramMiniAppConfig, paramBundle);
      }
      catch (Throwable paramString)
      {
        QLog.e("miniapp-process_AppBrandProxy", 1, "onAppBackground exception.", paramString);
      }
      return;
    }
    finally {}
  }
  
  public void onAppForeground(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    try
    {
      this.mMiniAppStatus = 2;
      IAppBrandService localIAppBrandService = getService();
      this.mAppConfig = paramMiniAppConfig;
      if (localIAppBrandService == null)
      {
        this.mNeedSyncStatus = true;
        QLog.e("miniapp-process_AppBrandProxy", 1, "onAppForeground IAppBrandService Connection is Null.");
        return;
      }
      try
      {
        QLog.e("miniapp-process_AppBrandProxy", 1, "notify onAppForeground");
        this.mService.onAppForeground(paramString, paramMiniAppConfig, paramBundle);
      }
      catch (Throwable paramString)
      {
        QLog.e("miniapp-process_AppBrandProxy", 1, "onAppForeground exception.", paramString);
      }
      return;
    }
    finally {}
  }
  
  public void onAppStart(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    try
    {
      if (this.mMiniAppStatus < 1) {
        this.mMiniAppStatus = 1;
      }
      if (getService() == null)
      {
        this.mNeedSyncStatus = true;
        this.mStartBundle = paramBundle;
        QLog.e("miniapp-process_AppBrandProxy", 1, "onAppStart IAppBrandService Connection is Null.");
        return;
      }
      try
      {
        QLog.e("miniapp-process_AppBrandProxy", 1, "notify onAppStart");
        this.mService.onAppStart(paramString, paramMiniAppConfig, paramBundle);
        if (paramMiniAppConfig != null)
        {
          QLog.e("miniapp-process_AppBrandProxy", 1, "notify onAppForeground after onAppStart");
          this.mService.onAppForeground(paramString, paramMiniAppConfig, paramBundle);
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("miniapp-process_AppBrandProxy", 1, "onAppStart exception.", paramString);
      }
      return;
    }
    finally {}
  }
  
  public void onAppStop(String paramString, MiniAppConfig paramMiniAppConfig, Bundle paramBundle)
  {
    try
    {
      this.mMiniAppStatus = 4;
      if (getService() == null)
      {
        QLog.e("miniapp-process_AppBrandProxy", 1, "onAppStop IAppBrandService Connection is Null.");
        return;
      }
      try
      {
        QLog.e("miniapp-process_AppBrandProxy", 1, "notify onAppStop");
        this.mService.onAppStop(paramString, paramMiniAppConfig, paramBundle);
        releaseService();
      }
      catch (Throwable paramString)
      {
        QLog.e("miniapp-process_AppBrandProxy", 1, "onAppStop exception.", paramString);
      }
      return;
    }
    finally {}
  }
  
  public void preloadPackage(@NonNull MiniAppInfo paramMiniAppInfo)
  {
    IAppBrandService localIAppBrandService = getService();
    paramMiniAppInfo = new AppBrandProxyImpl.4(this, localIAppBrandService, paramMiniAppInfo);
    if (localIAppBrandService != null)
    {
      paramMiniAppInfo.run();
      return;
    }
    this.mTaskAfterConnected.add(paramMiniAppInfo);
  }
  
  protected void releaseService()
  {
    QLog.w("miniapp-process_AppBrandProxy", 1, "releaseService.");
    try
    {
      if (this.mService == null) {
        break label42;
      }
      this.mContext.unbindService(this.mConnection);
      this.mService = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      label33:
      label42:
      break label33;
    }
    QLog.w("miniapp-process_AppBrandProxy", 1, "exception when releaseService.");
  }
  
  public void sendCmd(String paramString, Bundle paramBundle, CmdCallback paramCmdCallback)
  {
    if (getService() == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendCmd IAppBrandService Connection is Null. cmd=");
      localStringBuilder.append(paramString);
      QLog.e("miniapp-process_AppBrandProxy", 1, localStringBuilder.toString());
      this.mTaskAfterConnected.add(new AppBrandProxyImpl.5(this, paramString, paramCmdCallback, paramBundle));
      return;
    }
    try
    {
      this.mService.sendCmd(paramString, paramBundle, paramCmdCallback);
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("miniapp-process_AppBrandProxy", 1, "sendCmd exception.", paramString);
    }
  }
  
  public void startMiniApp(Activity paramActivity, MiniAppConfig paramMiniAppConfig, ResultReceiver paramResultReceiver)
  {
    if (getService() == null)
    {
      QLog.e("miniapp-process_AppBrandProxy", 1, "startMiniApp IAppBrandService Connection is Null.");
      this.mTaskAfterConnected.add(new AppBrandProxyImpl.2(this, paramActivity, paramMiniAppConfig, paramResultReceiver));
      return;
    }
    performStartMiniApp(paramActivity, paramMiniAppConfig, paramResultReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandProxyImpl
 * JD-Core Version:    0.7.0.1
 */