package com.tencent.tmdownloader;

import android.content.Context;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.a.h;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.s;
import com.tencent.tmdownloader.internal.downloadclient.MobileQQCloseServiceReceiver;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadManager
{
  protected static final String TAG = "TMAssistantDownloadManager";
  protected static TMAssistantDownloadManager mInstance;
  protected static ArrayList<TMAssistantDownloadClient> mSDKClientList = new ArrayList();
  protected static TMAssistantDownloadSettingClient mSDKSettingClient = null;
  protected Context mContext = null;
  
  protected TMAssistantDownloadManager(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static void closeAllService(Context paramContext)
  {
    try
    {
      ab.c("TMAssistantDownloadManager", "enter");
      if (paramContext == null)
      {
        ab.c("TMAssistantDownloadManager", "you must input an application or activity context!");
        ab.c("TMAssistantDownloadManager", "exit");
        return;
      }
      if (mInstance == null)
      {
        ab.c("TMAssistantDownloadManager", "manager minstance == null");
        ab.c("TMAssistantDownloadManager", "exit");
        return;
      }
      if ((mSDKClientList != null) && (mSDKClientList.size() > 0))
      {
        ab.c("TMAssistantDownloadManager", "mSDKClientList != null && mSDKClientList.size() > 0");
        Iterator localIterator = mSDKClientList.iterator();
        while (localIterator.hasNext())
        {
          TMAssistantDownloadClient localTMAssistantDownloadClient = (TMAssistantDownloadClient)localIterator.next();
          if (localTMAssistantDownloadClient != null) {
            localTMAssistantDownloadClient.unInitTMAssistantDownloadSDK();
          }
        }
        mSDKClientList.clear();
      }
      MobileQQCloseServiceReceiver.a().b(paramContext);
      if (mSDKSettingClient != null)
      {
        mSDKSettingClient.unInitTMAssistantDownloadSDK();
        mSDKSettingClient = null;
      }
      mInstance = null;
      ab.c("TMAssistantDownloadManager", "exit");
      return;
    }
    finally {}
    for (;;)
    {
      throw paramContext;
    }
  }
  
  /* Error */
  public static TMAssistantDownloadManager getInstance(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 48	com/tencent/tmdownloader/TMAssistantDownloadManager:mInstance	Lcom/tencent/tmdownloader/TMAssistantDownloadManager;
    //   6: ifnonnull +47 -> 53
    //   9: new 2	com/tencent/tmdownloader/TMAssistantDownloadManager
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 96	com/tencent/tmdownloader/TMAssistantDownloadManager:<init>	(Landroid/content/Context;)V
    //   17: putstatic 48	com/tencent/tmdownloader/TMAssistantDownloadManager:mInstance	Lcom/tencent/tmdownloader/TMAssistantDownloadManager;
    //   20: invokestatic 84	com/tencent/tmdownloader/internal/downloadclient/MobileQQCloseServiceReceiver:a	()Lcom/tencent/tmdownloader/internal/downloadclient/MobileQQCloseServiceReceiver;
    //   23: aload_0
    //   24: invokevirtual 98	com/tencent/tmdownloader/internal/downloadclient/MobileQQCloseServiceReceiver:a	(Landroid/content/Context;)V
    //   27: invokestatic 102	com/tencent/tmassistantbase/util/s:a	()Z
    //   30: ifne +23 -> 53
    //   33: invokestatic 107	com/tencent/tmassistantbase/util/GlobalUtil:getInstance	()Lcom/tencent/tmassistantbase/util/GlobalUtil;
    //   36: invokevirtual 111	com/tencent/tmassistantbase/util/GlobalUtil:getContext	()Landroid/content/Context;
    //   39: ifnonnull +10 -> 49
    //   42: invokestatic 107	com/tencent/tmassistantbase/util/GlobalUtil:getInstance	()Lcom/tencent/tmassistantbase/util/GlobalUtil;
    //   45: aload_0
    //   46: invokevirtual 114	com/tencent/tmassistantbase/util/GlobalUtil:setContext	(Landroid/content/Context;)V
    //   49: invokestatic 119	com/tencent/tmdownloader/f:a	()Lcom/tencent/tmdownloader/f;
    //   52: pop
    //   53: getstatic 48	com/tencent/tmdownloader/TMAssistantDownloadManager:mInstance	Lcom/tencent/tmdownloader/TMAssistantDownloadManager;
    //   56: astore_0
    //   57: ldc 2
    //   59: monitorexit
    //   60: aload_0
    //   61: areturn
    //   62: astore_0
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    //   68: astore_1
    //   69: goto -42 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	paramContext	Context
    //   68	1	1	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   3	20	62	finally
    //   20	27	62	finally
    //   27	49	62	finally
    //   49	53	62	finally
    //   53	57	62	finally
    //   20	27	68	java/lang/Throwable
  }
  
  public TMAssistantDownloadClient getDownloadSDKClient(String paramString)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<getDownloadSDKClient> clientKey = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",process Name:");
      ((StringBuilder)localObject).append(s.e());
      ab.c("TMAssistantDownloadManager", ((StringBuilder)localObject).toString());
      ab.c("TMAssistantDownloadManager", "enter");
      if ((paramString != null) && (paramString.length() > 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clientKey: ");
        ((StringBuilder)localObject).append(paramString);
        ab.c("TMAssistantDownloadManager", ((StringBuilder)localObject).toString());
        Iterator localIterator = mSDKClientList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (TMAssistantDownloadClient)localIterator.next();
          if (((TMAssistantDownloadClient)localObject).mClientKey.equals(paramString) == true)
          {
            ab.c("TMAssistantDownloadManager", "SDKClient exists");
            paramString = new StringBuilder();
            paramString.append("returnValue(clientItem): ");
            paramString.append(localObject);
            ab.c("TMAssistantDownloadManager", paramString.toString());
            ab.c("TMAssistantDownloadManager", "exit");
            return localObject;
          }
        }
        paramString = new TMAssistantDownloadClient(this.mContext, paramString);
        paramString.initTMAssistantDownloadSDK();
        mSDKClientList.add(paramString);
        ab.c("TMAssistantDownloadManager", "add new SDKClient");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("returnValue(client): ");
        ((StringBuilder)localObject).append(paramString);
        ab.c("TMAssistantDownloadManager", ((StringBuilder)localObject).toString());
        ab.c("TMAssistantDownloadManager", "exit");
        ab.c("TMAssistantDownloadManager", "TMAssistantDownloadClient PackageInstallReceiver register");
        if (this.mContext == null) {
          this.mContext = GlobalUtil.getInstance().getContext();
        }
        return paramString;
      }
      ab.c("TMAssistantDownloadManager", "clientKey == null || clientKey.length() <= 0");
      ab.c("TMAssistantDownloadManager", "exit");
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public TMAssistantDownloadSettingClient getDownloadSDKSettingClient()
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<getDownloadSDKSettingClient>  ,process Name:");
      ((StringBuilder)localObject1).append(s.e());
      ab.c("TMAssistantDownloadManager", ((StringBuilder)localObject1).toString());
      ab.c("TMAssistantDownloadManager", "enter");
      if (mSDKSettingClient == null)
      {
        ab.c("TMAssistantDownloadManager", "mSDKSettingClient is null create a new for TMAssistantDownloadSettingClient");
        mSDKSettingClient = new TMAssistantDownloadSettingClient(this.mContext, "TMAssistantDownloadSDKManager");
        mSDKSettingClient.initTMAssistantDownloadSDK();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("returnValue(settingclient): ");
      ((StringBuilder)localObject1).append(mSDKSettingClient);
      ab.c("TMAssistantDownloadManager", ((StringBuilder)localObject1).toString());
      ab.c("TMAssistantDownloadManager", "exit");
      localObject1 = mSDKSettingClient;
      return localObject1;
    }
    finally {}
  }
  
  public void hookAM4Install()
  {
    h.a().a(this.mContext);
  }
  
  public boolean releaseDownloadSDKClient(String paramString)
  {
    try
    {
      ab.c("TMAssistantDownloadManager", "enter");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clientKey:");
      ((StringBuilder)localObject).append(paramString);
      ab.c("TMAssistantDownloadManager", ((StringBuilder)localObject).toString());
      localObject = mSDKClientList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TMAssistantDownloadClient localTMAssistantDownloadClient = (TMAssistantDownloadClient)((Iterator)localObject).next();
        if ((localTMAssistantDownloadClient != null) && (localTMAssistantDownloadClient.mClientKey.equals(paramString) == true))
        {
          localTMAssistantDownloadClient.unInitTMAssistantDownloadSDK();
          ((Iterator)localObject).remove();
          ab.c("TMAssistantDownloadManager", "unInitTMAssistantDownloadSDK for TMAssistantDownloadClient");
          paramString = new StringBuilder();
          paramString.append("returnValue: ");
          paramString.append(true);
          ab.c("TMAssistantDownloadManager", paramString.toString());
          ab.c("TMAssistantDownloadManager", "exit");
          return true;
        }
      }
      if ((mSDKSettingClient != null) && (mSDKSettingClient.mClientKey.equals(paramString) == true))
      {
        mSDKSettingClient.unInitTMAssistantDownloadSDK();
        mSDKSettingClient = null;
        ab.c("TMAssistantDownloadManager", "unInitTMAssistantDownloadSDK for TMAssistantDownloadSettingClient");
        paramString = new StringBuilder();
        paramString.append("returnValue: ");
        paramString.append(true);
        ab.c("TMAssistantDownloadManager", paramString.toString());
        ab.c("TMAssistantDownloadManager", "exit");
        return true;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("no matched SDKClient for clientKey: ");
      ((StringBuilder)localObject).append(paramString);
      ab.c("TMAssistantDownloadManager", ((StringBuilder)localObject).toString());
      paramString = new StringBuilder();
      paramString.append("returnValue: ");
      paramString.append(false);
      ab.c("TMAssistantDownloadManager", paramString.toString());
      ab.c("TMAssistantDownloadManager", "exit");
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.TMAssistantDownloadManager
 * JD-Core Version:    0.7.0.1
 */