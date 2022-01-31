package com.tencent.tmdownloader;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.tmassistant.aidl.TMAssistantDownloadLogInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistant.aidl.d;
import com.tencent.tmassistant.aidl.e;
import com.tencent.tmassistantbase.util.h;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TMAssistantDownloadClient
  extends a
{
  protected static final String DOWNDLOADSDKSERVICENAME = "com.tencent.tmdownloader.TMAssistantDownloadService";
  protected static final String TAG = "TMAssistantDownloadSDKClient";
  protected ReferenceQueue<ITMAssistantDownloadClientListener> mListenerReferenceQueue;
  private h mLogListener = new r(this);
  ReferenceQueue<ITMAssistantDownloadLogListener> mLogListenerReferenceQueue;
  protected ArrayList<WeakReference<ITMAssistantDownloadClientListener>> mWeakListenerArrayList;
  ArrayList<WeakReference<ITMAssistantDownloadLogListener>> mWeakLogListenerArrayList;
  boolean registered = false;
  
  public TMAssistantDownloadClient(Context paramContext, String paramString)
  {
    super(paramContext, paramString, "com.tencent.tmdownloader.TMAssistantDownloadService");
    com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "enter");
    com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "context: " + paramContext + "; clientKey: " + paramString);
    this.mListenerReferenceQueue = new ReferenceQueue();
    this.mWeakListenerArrayList = new ArrayList();
    this.mServiceCallback = new q(this);
    com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "exit");
  }
  
  private ArrayList<TMAssistantDownloadLogInfo> convert2LogInfo(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        paramList = (String)localIterator.next();
        if (!TextUtils.isEmpty(paramList))
        {
          String[] arrayOfString = paramList.split("&");
          if (arrayOfString != null)
          {
            Object localObject1 = null;
            int j = arrayOfString.length;
            int i = 0;
            if (i < j)
            {
              Object localObject3 = arrayOfString[i].split("'");
              Object localObject2 = localObject1;
              if (localObject3 != null)
              {
                localObject2 = localObject1;
                if (localObject3.length == 2)
                {
                  paramList = localObject1;
                  if (localObject1 == null) {
                    paramList = new TMAssistantDownloadLogInfo();
                  }
                  localObject2 = paramList;
                  if (!TextUtils.isEmpty(localObject3[0]))
                  {
                    localObject1 = localObject3[0];
                    localObject3 = localObject3[1];
                    if (!localObject1.equals("LL")) {
                      break label198;
                    }
                    if (TextUtils.isEmpty((CharSequence)localObject3)) {
                      break label186;
                    }
                    paramList.logLevel = ((String)localObject3);
                    localObject2 = paramList;
                  }
                }
              }
              for (;;)
              {
                i += 1;
                localObject1 = localObject2;
                break;
                label186:
                paramList.logLevel = "D";
                localObject2 = paramList;
                continue;
                label198:
                if (localObject1.equals("LT"))
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject3))
                  {
                    paramList.logTag = ((String)localObject3);
                    localObject2 = paramList;
                  }
                  else
                  {
                    paramList.logTag = " TMAssistantDownloadSDK";
                    localObject2 = paramList;
                  }
                }
                else if (localObject1.equals("LTS"))
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject3))
                  {
                    paramList.logTime = Long.valueOf((String)localObject3).longValue();
                    localObject2 = paramList;
                  }
                  else
                  {
                    paramList.logTime = 0L;
                    localObject2 = paramList;
                  }
                }
                else if (localObject1.equals("LM"))
                {
                  if (!TextUtils.isEmpty((CharSequence)localObject3))
                  {
                    paramList.logMsg = ((String)localObject3);
                    localObject2 = paramList;
                  }
                  else
                  {
                    paramList.logMsg = " msg lost!!!";
                    localObject2 = paramList;
                  }
                }
                else
                {
                  localObject2 = paramList;
                  if (localObject1.equals("LW")) {
                    if (!TextUtils.isEmpty((CharSequence)localObject3))
                    {
                      paramList.logThrowableMsg = ((String)localObject3);
                      localObject2 = paramList;
                    }
                    else
                    {
                      paramList.logThrowableMsg = " log ThrowableMsg lost!!!";
                      localObject2 = paramList;
                    }
                  }
                }
              }
            }
            if (localObject1 != null) {
              localArrayList.add(localObject1);
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void cancelDownloadTask(String paramString)
  {
    try
    {
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "enter");
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "clientKey:" + this.mClientKey + ",url:" + paramString);
      if (paramString == null)
      {
        com.tencent.tmassistantbase.util.r.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
      }
    }
    finally {}
    d locald = (d)super.getServiceInterface();
    if (locald != null)
    {
      locald.c(this.mClientKey, paramString);
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "cancelDownloadTask");
    }
    for (;;)
    {
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "exit");
      return;
      super.initTMAssistantDownloadSDK();
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "initTMAssistantDownloadSDK");
    }
  }
  
  public void deleteDownloadTask(String paramString)
  {
    try
    {
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "deleteDownloadTask enter");
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "clientKey:" + this.mClientKey + ",url:" + paramString);
      if (paramString == null)
      {
        com.tencent.tmassistantbase.util.r.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
      }
    }
    finally {}
    d locald = (d)super.getServiceInterface();
    if (locald != null)
    {
      locald.d(this.mClientKey, paramString);
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "deleteDownloadTask");
    }
    for (;;)
    {
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "deleteDownloadTask exit");
      return;
      super.initTMAssistantDownloadSDK();
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "initTMAssistantDownloadSDK");
    }
  }
  
  protected Intent getBindServiceIntent()
  {
    return new Intent(this.mContext, Class.forName(this.mServiceName));
  }
  
  public List<TMAssistantDownloadTaskInfo> getDownloadTaskInfosByVia(String paramString)
  {
    try
    {
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "enter");
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "clientKey:" + this.mClientKey + ",mVia:" + paramString);
      if (paramString == null)
      {
        com.tencent.tmassistantbase.util.r.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
      }
    }
    finally {}
    d locald = (d)super.getServiceInterface();
    if (locald != null)
    {
      paramString = locald.a(paramString);
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "returnValue(taskInfo): " + paramString);
    }
    for (;;)
    {
      return paramString;
      super.initTMAssistantDownloadSDK();
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "returnValue: null");
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "exit");
      paramString = null;
    }
  }
  
  public TMAssistantDownloadTaskInfo getDownloadTaskState(String paramString)
  {
    try
    {
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "enter");
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "clientKey:" + this.mClientKey + ",url:" + paramString);
      if (paramString == null)
      {
        com.tencent.tmassistantbase.util.r.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
      }
    }
    finally {}
    d locald = (d)super.getServiceInterface();
    if (locald != null)
    {
      paramString = locald.a(this.mClientKey, paramString);
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "returnValue(taskInfo): " + paramString);
    }
    for (;;)
    {
      return paramString;
      super.initTMAssistantDownloadSDK();
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "returnValue: null");
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "exit");
      paramString = null;
    }
  }
  
  protected void onDownloadSDKServiceInvalid()
  {
    com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "enter");
    Iterator localIterator = this.mWeakListenerArrayList.iterator();
    while (localIterator.hasNext())
    {
      ITMAssistantDownloadClientListener localITMAssistantDownloadClientListener = (ITMAssistantDownloadClientListener)((WeakReference)localIterator.next()).get();
      s.a().a(this, localITMAssistantDownloadClientListener);
    }
    com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "exit");
  }
  
  public void pauseDownloadTask(String paramString)
  {
    try
    {
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "enter");
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "clientKey:" + this.mClientKey + ",url:" + paramString);
      if (paramString == null)
      {
        com.tencent.tmassistantbase.util.r.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
        throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
      }
    }
    finally {}
    d locald = (d)super.getServiceInterface();
    if (locald != null)
    {
      locald.b(this.mClientKey, paramString);
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "pauseDownloadTask");
    }
    for (;;)
    {
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "exit");
      return;
      super.initTMAssistantDownloadSDK();
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "initTMAssistantDownloadSDK");
    }
  }
  
  public boolean registerDownloadTaskListener(ITMAssistantDownloadClientListener paramITMAssistantDownloadClientListener)
  {
    for (;;)
    {
      Object localObject;
      try
      {
        com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "enter");
        if (paramITMAssistantDownloadClientListener == null)
        {
          com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "listener null");
          com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "returnValue: false");
          com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "exit");
          bool = false;
          return bool;
        }
        localObject = this.mListenerReferenceQueue.poll();
        if (localObject != null)
        {
          com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "registerDownloadTaskListener removed listener!!!!");
          this.mWeakListenerArrayList.remove(localObject);
          continue;
        }
        localObject = this.mWeakListenerArrayList.iterator();
      }
      finally {}
      for (;;)
      {
        if (((Iterator)localObject).hasNext()) {
          if ((ITMAssistantDownloadClientListener)((WeakReference)((Iterator)localObject).next()).get() == paramITMAssistantDownloadClientListener)
          {
            com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "returnValue: true");
            com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "exit");
            bool = true;
            break;
          }
        }
      }
      paramITMAssistantDownloadClientListener = new WeakReference(paramITMAssistantDownloadClientListener, this.mListenerReferenceQueue);
      this.mWeakListenerArrayList.add(paramITMAssistantDownloadClientListener);
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "returnValue: true");
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "exit");
      boolean bool = true;
    }
  }
  
  public boolean registerLogListener(ITMAssistantDownloadLogListener paramITMAssistantDownloadLogListener)
  {
    boolean bool;
    if (paramITMAssistantDownloadLogListener == null) {
      bool = false;
    }
    label221:
    for (;;)
    {
      return bool;
      try
      {
        if (this.mWeakLogListenerArrayList == null) {
          this.mWeakLogListenerArrayList = new ArrayList();
        }
        if (this.mLogListenerReferenceQueue == null) {
          this.mLogListenerReferenceQueue = new ReferenceQueue();
        }
        Object localObject;
        for (;;)
        {
          localObject = this.mLogListenerReferenceQueue.poll();
          if (localObject == null) {
            break;
          }
          com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "registerDownloadTaskListener removed listener!!!!");
          this.mWeakLogListenerArrayList.remove(localObject);
        }
        try
        {
          localObject = (d)super.getServiceInterface();
          if (localObject != null)
          {
            com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "openLogListener");
            ((d)localObject).c();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
          paramITMAssistantDownloadLogListener = new WeakReference(paramITMAssistantDownloadLogListener, this.mLogListenerReferenceQueue);
          this.mWeakLogListenerArrayList.add(paramITMAssistantDownloadLogListener);
          if (this.registered) {
            break label221;
          }
          this.registered = true;
          com.tencent.tmassistantbase.util.r.a(this.mLogListener);
          bool = true;
        }
      }
      finally {}
      for (;;)
      {
        localObject = this.mWeakLogListenerArrayList.iterator();
        ITMAssistantDownloadLogListener localITMAssistantDownloadLogListener;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localITMAssistantDownloadLogListener = (ITMAssistantDownloadLogListener)((WeakReference)((Iterator)localObject).next()).get();
        } while (localITMAssistantDownloadLogListener != paramITMAssistantDownloadLogListener);
        bool = true;
        break;
        super.initTMAssistantDownloadSDK();
        com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "initTMAssistantDownloadSDK");
      }
    }
  }
  
  protected void registerServiceCallback()
  {
    ((d)this.mServiceInterface).a(this.mClientKey, (com.tencent.tmassistant.aidl.a)this.mServiceCallback);
  }
  
  public int startDownloadTask(String paramString1, int paramInt, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    for (;;)
    {
      try
      {
        com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "enter");
        com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "clientKey:" + this.mClientKey + ",url:" + paramString1 + "; priority: " + paramInt + "; contentType: " + paramString2 + "; fileName ： " + paramString3);
        if (paramMap != null)
        {
          com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "params.size: " + paramMap.size());
          if (paramString1 != null) {
            break;
          }
          com.tencent.tmassistantbase.util.r.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
          throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
        }
      }
      finally {}
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "params: null");
    }
    if ((paramString2.equals("resource/tm.android.unknown")) && (TextUtils.isEmpty(paramString3)))
    {
      com.tencent.tmassistantbase.util.r.e("TMAssistantDownloadSDKClient", "exception: if contentType is others, filename shouldn't be null!");
      throw new IllegalArgumentException("if contentType is others, filename shouldn't be null!");
    }
    d locald = (d)super.getServiceInterface();
    if (locald != null)
    {
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "startDownloadTask");
      paramInt = locald.a(this.mClientKey, paramString1, 0, paramString2, paramString3, paramMap);
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "returnValue: " + paramInt);
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "exit");
    }
    for (;;)
    {
      return paramInt;
      super.initTMAssistantDownloadSDK();
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "super.initTMAssistantDownloadSDK");
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "returnValue: 0");
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "exit");
      paramInt = 0;
    }
  }
  
  public int startDownloadTask(String paramString1, String paramString2)
  {
    try
    {
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "enter");
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "url: " + paramString1 + "; contentType: " + paramString2);
      int i = startDownloadTask(paramString1, 0, paramString2, null, null);
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "returnValue: " + i);
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "exit");
      return i;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public int startDownloadTask(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "client is: " + this);
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "enter");
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "url: " + paramString1 + "; contentType: " + paramString2 + "; fileName: " + paramString3);
      int i = startDownloadTask(paramString1, 0, paramString2, paramString3, null);
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "returnValue: " + i);
      com.tencent.tmassistantbase.util.r.c("TMAssistantDownloadSDKClient", "exit");
      return i;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public int startDownloadTask(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 11
    //   4: ldc 41
    //   6: invokestatic 47	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: ldc 11
    //   11: new 49	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 375
    //   21: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc_w 343
    //   31: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: aload_2
    //   35: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 47	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_3
    //   45: ifnull +82 -> 127
    //   48: ldc 11
    //   50: new 49	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   57: ldc_w 347
    //   60: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: aload_3
    //   64: invokeinterface 353 1 0
    //   69: invokevirtual 341	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 47	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload_0
    //   79: aload_1
    //   80: iconst_0
    //   81: aload_2
    //   82: aconst_null
    //   83: aload_3
    //   84: invokevirtual 377	com/tencent/tmdownloader/TMAssistantDownloadClient:startDownloadTask	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)I
    //   87: istore 4
    //   89: ldc 11
    //   91: new 49	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 367
    //   101: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: iload 4
    //   106: invokevirtual 341	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 47	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: ldc 11
    //   117: ldc 86
    //   119: invokestatic 47	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_0
    //   123: monitorexit
    //   124: iload 4
    //   126: ireturn
    //   127: ldc 11
    //   129: ldc_w 355
    //   132: invokestatic 47	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: goto -57 -> 78
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	TMAssistantDownloadClient
    //   0	143	1	paramString1	String
    //   0	143	2	paramString2	String
    //   0	143	3	paramMap	Map<String, String>
    //   87	38	4	i	int
    // Exception table:
    //   from	to	target	type
    //   2	44	138	finally
    //   48	78	138	finally
    //   78	122	138	finally
    //   127	135	138	finally
  }
  
  protected void stubAsInterface(IBinder paramIBinder)
  {
    this.mServiceInterface = e.a(paramIBinder);
  }
  
  /* Error */
  public boolean unRegisterDownloadTaskListener(ITMAssistantDownloadClientListener paramITMAssistantDownloadClientListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 11
    //   4: ldc 41
    //   6: invokestatic 47	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_1
    //   10: ifnonnull +32 -> 42
    //   13: ldc 11
    //   15: ldc_w 289
    //   18: invokestatic 47	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc 11
    //   23: ldc_w 291
    //   26: invokestatic 47	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: ldc 11
    //   31: ldc 86
    //   33: invokestatic 47	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: iconst_0
    //   37: istore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: iload_2
    //   41: ireturn
    //   42: aload_0
    //   43: getfield 77	com/tencent/tmdownloader/TMAssistantDownloadClient:mWeakListenerArrayList	Ljava/util/ArrayList;
    //   46: invokevirtual 265	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   49: astore_3
    //   50: aload_3
    //   51: invokeinterface 105 1 0
    //   56: ifeq +56 -> 112
    //   59: aload_3
    //   60: invokeinterface 109 1 0
    //   65: checkcast 267	java/lang/ref/WeakReference
    //   68: astore 4
    //   70: aload 4
    //   72: invokevirtual 270	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   75: checkcast 272	com/tencent/tmdownloader/ITMAssistantDownloadClientListener
    //   78: aload_1
    //   79: if_acmpne -29 -> 50
    //   82: aload_0
    //   83: getfield 77	com/tencent/tmdownloader/TMAssistantDownloadClient:mWeakListenerArrayList	Ljava/util/ArrayList;
    //   86: aload 4
    //   88: invokevirtual 300	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   91: pop
    //   92: ldc 11
    //   94: ldc_w 302
    //   97: invokestatic 47	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: ldc 11
    //   102: ldc 86
    //   104: invokestatic 47	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: iconst_1
    //   108: istore_2
    //   109: goto -71 -> 38
    //   112: ldc 11
    //   114: ldc_w 291
    //   117: invokestatic 47	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: ldc 11
    //   122: ldc 86
    //   124: invokestatic 47	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: iconst_0
    //   128: istore_2
    //   129: goto -91 -> 38
    //   132: astore_1
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_1
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	TMAssistantDownloadClient
    //   0	137	1	paramITMAssistantDownloadClientListener	ITMAssistantDownloadClientListener
    //   37	92	2	bool	boolean
    //   49	11	3	localIterator	Iterator
    //   68	19	4	localWeakReference	WeakReference
    // Exception table:
    //   from	to	target	type
    //   2	9	132	finally
    //   13	36	132	finally
    //   42	50	132	finally
    //   50	107	132	finally
    //   112	127	132	finally
  }
  
  public boolean unRegisterLogListener(ITMAssistantDownloadLogListener paramITMAssistantDownloadLogListener)
  {
    if (paramITMAssistantDownloadLogListener == null) {}
    for (boolean bool = false;; bool = false) {
      for (;;)
      {
        return bool;
        try
        {
          Iterator localIterator = this.mWeakLogListenerArrayList.iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              WeakReference localWeakReference = (WeakReference)localIterator.next();
              if ((ITMAssistantDownloadLogListener)localWeakReference.get() == paramITMAssistantDownloadLogListener)
              {
                this.mWeakLogListenerArrayList.remove(localWeakReference);
                if (this.mWeakLogListenerArrayList.size() == 0) {
                  com.tencent.tmassistantbase.util.r.b(this.mLogListener);
                }
                try
                {
                  paramITMAssistantDownloadLogListener = (d)super.getServiceInterface();
                  if (paramITMAssistantDownloadLogListener != null) {
                    paramITMAssistantDownloadLogListener.d();
                  }
                }
                catch (Exception paramITMAssistantDownloadLogListener)
                {
                  for (;;)
                  {
                    paramITMAssistantDownloadLogListener.printStackTrace();
                  }
                }
                bool = true;
                break;
              }
            }
          }
        }
        finally {}
      }
    }
  }
  
  protected void unRegisterServiceCallback()
  {
    ((d)this.mServiceInterface).b(this.mClientKey, (com.tencent.tmassistant.aidl.a)this.mServiceCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.TMAssistantDownloadClient
 * JD-Core Version:    0.7.0.1
 */