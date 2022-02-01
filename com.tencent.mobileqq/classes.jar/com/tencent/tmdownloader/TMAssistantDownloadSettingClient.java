package com.tencent.tmdownloader;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.tmassistant.aidl.d;
import com.tencent.tmassistant.aidl.e;
import com.tencent.tmassistantbase.util.ab;

public class TMAssistantDownloadSettingClient
  extends a
{
  protected static final String DOWNDLOADSDKSERVICENAME = "com.tencent.tmdownloader.TMAssistantDownloadService";
  protected static final String TAG = "TMAssistantDownloadSettingClient";
  
  public TMAssistantDownloadSettingClient(Context paramContext, String paramString)
  {
    super(paramContext, paramString, "com.tencent.tmdownloader.TMAssistantDownloadService");
  }
  
  protected Intent getBindServiceIntent()
  {
    return new Intent(this.mContext, Class.forName(this.mServiceName));
  }
  
  public int getVersion()
  {
    try
    {
      d locald = (d)super.getServiceInterface();
      if (locald != null)
      {
        int i = locald.a();
        return i;
      }
      super.initTMAssistantDownloadSDK();
      return 0;
    }
    finally {}
  }
  
  public boolean isAllDownloadFinished()
  {
    try
    {
      ab.c("TMAssistantDownloadSettingClient", "enter");
      boolean bool = false;
      Object localObject1 = (d)super.getServiceInterface();
      if (localObject1 != null)
      {
        bool = ((d)localObject1).b();
        ab.c("TMAssistantDownloadSettingClient", "isAllDownloadFinished");
      }
      else
      {
        super.initTMAssistantDownloadSDK();
        ab.c("TMAssistantDownloadSettingClient", "initTMAssistantDownloadSDK");
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isAllDownloadFinished ret:");
      ((StringBuilder)localObject1).append(bool);
      ab.c("TMAssistantDownloadSettingClient", ((StringBuilder)localObject1).toString());
      ab.c("TMAssistantDownloadSettingClient", "exit");
      return bool;
    }
    finally {}
  }
  
  protected void onDownloadSDKServiceInvalid() {}
  
  protected void registerServiceCallback()
  {
    ((d)this.mServiceInterface).a(this.mClientKey, (com.tencent.tmassistant.aidl.a)this.mServiceCallback);
  }
  
  public void setDownloadSDKMaxTaskNum(int paramInt)
  {
    try
    {
      ab.c("TMAssistantDownloadSettingClient", "enter");
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("maxTaskNum: ");
      ((StringBuilder)localObject1).append(paramInt);
      ab.c("TMAssistantDownloadSettingClient", ((StringBuilder)localObject1).toString());
      if ((paramInt >= 1) && (paramInt <= 10))
      {
        localObject1 = (d)super.getServiceInterface();
        if (localObject1 != null)
        {
          ((d)localObject1).a(paramInt);
          ab.c("TMAssistantDownloadSettingClient", "setServiceSetingMaxTaskNum");
        }
        else
        {
          super.initTMAssistantDownloadSDK();
          ab.c("TMAssistantDownloadSettingClient", "initTMAssistantDownloadSDK");
        }
        ab.c("TMAssistantDownloadSettingClient", "exit");
        return;
      }
      ab.c("TMAssistantDownloadSettingClient", "maxTaskNum < 1 || maxTaskNum > 10");
      ab.c("TMAssistantDownloadSettingClient", "exit");
      return;
    }
    finally {}
  }
  
  public void setDownloadSDKWifiOnly(boolean paramBoolean)
  {
    try
    {
      ab.c("TMAssistantDownloadSettingClient", "enter");
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isDownloadWifiOnly: ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ab.c("TMAssistantDownloadSettingClient", ((StringBuilder)localObject1).toString());
      localObject1 = (d)super.getServiceInterface();
      if (localObject1 != null)
      {
        ((d)localObject1).b(paramBoolean);
        ab.c("TMAssistantDownloadSettingClient", "setDownloadWifiOnly");
      }
      else
      {
        super.initTMAssistantDownloadSDK();
        ab.c("TMAssistantDownloadSettingClient", "initTMAssistantDownloadSDK");
      }
      ab.c("TMAssistantDownloadSettingClient", "exit");
      return;
    }
    finally {}
  }
  
  protected void stubAsInterface(IBinder paramIBinder)
  {
    this.mServiceInterface = e.a(paramIBinder);
  }
  
  protected void unRegisterServiceCallback()
  {
    ((d)this.mServiceInterface).b(this.mClientKey, (com.tencent.tmassistant.aidl.a)this.mServiceCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.TMAssistantDownloadSettingClient
 * JD-Core Version:    0.7.0.1
 */