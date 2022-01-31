package com.tencent.tmdownloader;

import android.content.Context;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.a.h;
import com.tencent.tmassistantbase.util.ac;
import com.tencent.tmassistantbase.util.t;
import com.tencent.tmdownloader.internal.downloadclient.MobileQQCloseServiceReceiver;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadManager
{
  protected static final String TAG = "TMAssistantDownloadManager";
  protected static TMAssistantDownloadManager mInstance = null;
  protected static ArrayList<TMAssistantDownloadClient> mSDKClientList = new ArrayList();
  protected static TMAssistantDownloadSettingClient mSDKSettingClient = null;
  protected Context mContext = null;
  
  protected TMAssistantDownloadManager(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static void closeAllService(Context paramContext)
  {
    for (;;)
    {
      try
      {
        ac.c("TMAssistantDownloadManager", "enter");
        if (paramContext == null)
        {
          ac.c("TMAssistantDownloadManager", "you must input an application or activity context!");
          ac.c("TMAssistantDownloadManager", "exit");
          return;
        }
        if (mInstance == null)
        {
          ac.c("TMAssistantDownloadManager", "manager minstance == null");
          ac.c("TMAssistantDownloadManager", "exit");
          continue;
        }
        if (mSDKClientList == null) {
          break label126;
        }
      }
      finally {}
      if (mSDKClientList.size() > 0)
      {
        ac.c("TMAssistantDownloadManager", "mSDKClientList != null && mSDKClientList.size() > 0");
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
      label126:
      MobileQQCloseServiceReceiver.a().b(paramContext);
      if (mSDKSettingClient != null)
      {
        mSDKSettingClient.unInitTMAssistantDownloadSDK();
        mSDKSettingClient = null;
      }
      mInstance = null;
      ac.c("TMAssistantDownloadManager", "exit");
    }
  }
  
  /* Error */
  public static TMAssistantDownloadManager getInstance(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 21	com/tencent/tmdownloader/TMAssistantDownloadManager:mInstance	Lcom/tencent/tmdownloader/TMAssistantDownloadManager;
    //   6: ifnonnull +47 -> 53
    //   9: new 2	com/tencent/tmdownloader/TMAssistantDownloadManager
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 96	com/tencent/tmdownloader/TMAssistantDownloadManager:<init>	(Landroid/content/Context;)V
    //   17: putstatic 21	com/tencent/tmdownloader/TMAssistantDownloadManager:mInstance	Lcom/tencent/tmdownloader/TMAssistantDownloadManager;
    //   20: invokestatic 84	com/tencent/tmdownloader/internal/downloadclient/MobileQQCloseServiceReceiver:a	()Lcom/tencent/tmdownloader/internal/downloadclient/MobileQQCloseServiceReceiver;
    //   23: aload_0
    //   24: invokevirtual 98	com/tencent/tmdownloader/internal/downloadclient/MobileQQCloseServiceReceiver:a	(Landroid/content/Context;)V
    //   27: invokestatic 102	com/tencent/tmassistantbase/util/t:a	()Z
    //   30: ifne +23 -> 53
    //   33: invokestatic 107	com/tencent/tmassistantbase/util/GlobalUtil:getInstance	()Lcom/tencent/tmassistantbase/util/GlobalUtil;
    //   36: invokevirtual 111	com/tencent/tmassistantbase/util/GlobalUtil:getContext	()Landroid/content/Context;
    //   39: ifnonnull +10 -> 49
    //   42: invokestatic 107	com/tencent/tmassistantbase/util/GlobalUtil:getInstance	()Lcom/tencent/tmassistantbase/util/GlobalUtil;
    //   45: aload_0
    //   46: invokevirtual 114	com/tencent/tmassistantbase/util/GlobalUtil:setContext	(Landroid/content/Context;)V
    //   49: invokestatic 119	com/tencent/tmdownloader/f:a	()Lcom/tencent/tmdownloader/f;
    //   52: pop
    //   53: getstatic 21	com/tencent/tmdownloader/TMAssistantDownloadManager:mInstance	Lcom/tencent/tmdownloader/TMAssistantDownloadManager;
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
    for (;;)
    {
      TMAssistantDownloadClient localTMAssistantDownloadClient;
      try
      {
        ac.c("TMAssistantDownloadManager", "<getDownloadSDKClient> clientKey = " + paramString + ",process Name:" + t.e());
        ac.c("TMAssistantDownloadManager", "enter");
        if ((paramString == null) || (paramString.length() <= 0))
        {
          ac.c("TMAssistantDownloadManager", "clientKey == null || clientKey.length() <= 0");
          ac.c("TMAssistantDownloadManager", "exit");
          paramString = null;
          return paramString;
        }
        ac.c("TMAssistantDownloadManager", "clientKey: " + paramString);
        Iterator localIterator = mSDKClientList.iterator();
        if (localIterator.hasNext())
        {
          localTMAssistantDownloadClient = (TMAssistantDownloadClient)localIterator.next();
          if (localTMAssistantDownloadClient.mClientKey.equals(paramString) != true) {
            continue;
          }
          ac.c("TMAssistantDownloadManager", "SDKClient exists");
          ac.c("TMAssistantDownloadManager", "returnValue(clientItem): " + localTMAssistantDownloadClient);
          ac.c("TMAssistantDownloadManager", "exit");
          paramString = localTMAssistantDownloadClient;
          continue;
        }
        localTMAssistantDownloadClient = new TMAssistantDownloadClient(this.mContext, paramString);
      }
      finally {}
      localTMAssistantDownloadClient.initTMAssistantDownloadSDK();
      mSDKClientList.add(localTMAssistantDownloadClient);
      ac.c("TMAssistantDownloadManager", "add new SDKClient");
      ac.c("TMAssistantDownloadManager", "returnValue(client): " + localTMAssistantDownloadClient);
      ac.c("TMAssistantDownloadManager", "exit");
      ac.c("TMAssistantDownloadManager", "TMAssistantDownloadClient PackageInstallReceiver register");
      paramString = localTMAssistantDownloadClient;
      if (this.mContext == null)
      {
        this.mContext = GlobalUtil.getInstance().getContext();
        paramString = localTMAssistantDownloadClient;
      }
    }
  }
  
  public TMAssistantDownloadSettingClient getDownloadSDKSettingClient()
  {
    try
    {
      ac.c("TMAssistantDownloadManager", "<getDownloadSDKSettingClient>  ,process Name:" + t.e());
      ac.c("TMAssistantDownloadManager", "enter");
      if (mSDKSettingClient == null)
      {
        ac.c("TMAssistantDownloadManager", "mSDKSettingClient is null create a new for TMAssistantDownloadSettingClient");
        mSDKSettingClient = new TMAssistantDownloadSettingClient(this.mContext, "TMAssistantDownloadSDKManager");
        mSDKSettingClient.initTMAssistantDownloadSDK();
      }
      ac.c("TMAssistantDownloadManager", "returnValue(settingclient): " + mSDKSettingClient);
      ac.c("TMAssistantDownloadManager", "exit");
      TMAssistantDownloadSettingClient localTMAssistantDownloadSettingClient = mSDKSettingClient;
      return localTMAssistantDownloadSettingClient;
    }
    finally {}
  }
  
  public void hookAM4Install()
  {
    h.a().a(this.mContext);
  }
  
  /* Error */
  public boolean releaseDownloadSDKClient(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 8
    //   4: ldc 38
    //   6: invokestatic 44	com/tencent/tmassistantbase/util/ac:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: ldc 8
    //   11: new 123	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   18: ldc 200
    //   20: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_1
    //   24: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 44	com/tencent/tmassistantbase/util/ac:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: getstatic 28	com/tencent/tmdownloader/TMAssistantDownloadManager:mSDKClientList	Ljava/util/ArrayList;
    //   36: invokevirtual 60	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   39: astore_3
    //   40: aload_3
    //   41: invokeinterface 66 1 0
    //   46: ifeq +87 -> 133
    //   49: aload_3
    //   50: invokeinterface 70 1 0
    //   55: checkcast 72	com/tencent/tmdownloader/TMAssistantDownloadClient
    //   58: astore 4
    //   60: aload 4
    //   62: ifnull -22 -> 40
    //   65: aload 4
    //   67: getfield 151	com/tencent/tmdownloader/TMAssistantDownloadClient:mClientKey	Ljava/lang/String;
    //   70: aload_1
    //   71: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   74: iconst_1
    //   75: if_icmpne -35 -> 40
    //   78: aload 4
    //   80: invokevirtual 75	com/tencent/tmdownloader/TMAssistantDownloadClient:unInitTMAssistantDownloadSDK	()V
    //   83: aload_3
    //   84: invokeinterface 203 1 0
    //   89: ldc 8
    //   91: ldc 205
    //   93: invokestatic 44	com/tencent/tmassistantbase/util/ac:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: ldc 8
    //   98: new 123	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   105: ldc 207
    //   107: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: iconst_1
    //   111: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   114: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 44	com/tencent/tmassistantbase/util/ac:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: ldc 8
    //   122: ldc 48
    //   124: invokestatic 44	com/tencent/tmassistantbase/util/ac:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: iconst_1
    //   128: istore_2
    //   129: aload_0
    //   130: monitorexit
    //   131: iload_2
    //   132: ireturn
    //   133: getstatic 30	com/tencent/tmdownloader/TMAssistantDownloadManager:mSDKSettingClient	Lcom/tencent/tmdownloader/TMAssistantDownloadSettingClient;
    //   136: ifnull +70 -> 206
    //   139: getstatic 30	com/tencent/tmdownloader/TMAssistantDownloadManager:mSDKSettingClient	Lcom/tencent/tmdownloader/TMAssistantDownloadSettingClient;
    //   142: getfield 211	com/tencent/tmdownloader/TMAssistantDownloadSettingClient:mClientKey	Ljava/lang/String;
    //   145: aload_1
    //   146: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   149: iconst_1
    //   150: if_icmpne +56 -> 206
    //   153: getstatic 30	com/tencent/tmdownloader/TMAssistantDownloadManager:mSDKSettingClient	Lcom/tencent/tmdownloader/TMAssistantDownloadSettingClient;
    //   156: invokevirtual 90	com/tencent/tmdownloader/TMAssistantDownloadSettingClient:unInitTMAssistantDownloadSDK	()V
    //   159: aconst_null
    //   160: putstatic 30	com/tencent/tmdownloader/TMAssistantDownloadManager:mSDKSettingClient	Lcom/tencent/tmdownloader/TMAssistantDownloadSettingClient;
    //   163: ldc 8
    //   165: ldc 213
    //   167: invokestatic 44	com/tencent/tmassistantbase/util/ac:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: ldc 8
    //   172: new 123	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   179: ldc 207
    //   181: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: iconst_1
    //   185: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   188: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 44	com/tencent/tmassistantbase/util/ac:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: ldc 8
    //   196: ldc 48
    //   198: invokestatic 44	com/tencent/tmassistantbase/util/ac:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: iconst_1
    //   202: istore_2
    //   203: goto -74 -> 129
    //   206: ldc 8
    //   208: new 123	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   215: ldc 215
    //   217: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_1
    //   221: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 44	com/tencent/tmassistantbase/util/ac:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: ldc 8
    //   232: new 123	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   239: ldc 207
    //   241: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: iconst_0
    //   245: invokevirtual 210	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   248: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: invokestatic 44	com/tencent/tmassistantbase/util/ac:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: ldc 8
    //   256: ldc 48
    //   258: invokestatic 44	com/tencent/tmassistantbase/util/ac:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: iconst_0
    //   262: istore_2
    //   263: goto -134 -> 129
    //   266: astore_1
    //   267: aload_0
    //   268: monitorexit
    //   269: aload_1
    //   270: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	TMAssistantDownloadManager
    //   0	271	1	paramString	String
    //   128	135	2	bool	boolean
    //   39	45	3	localIterator	Iterator
    //   58	21	4	localTMAssistantDownloadClient	TMAssistantDownloadClient
    // Exception table:
    //   from	to	target	type
    //   2	40	266	finally
    //   40	60	266	finally
    //   65	127	266	finally
    //   133	201	266	finally
    //   206	261	266	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmdownloader.TMAssistantDownloadManager
 * JD-Core Version:    0.7.0.1
 */