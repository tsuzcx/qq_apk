package com.tencent.tmdownloader;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tmassistant.aidl.TMAssistantDownloadLogInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistant.aidl.d;
import com.tencent.tmassistant.aidl.e;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmassistantbase.util.aa;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.m;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TMAssistantDownloadClient
  extends a
{
  protected static final String DOWNDLOADSDKSERVICENAME = "com.tencent.tmdownloader.TMAssistantDownloadService";
  protected static final String TAG = "TMAssistantDownloadSDKClient";
  protected ReferenceQueue<ITMAssistantDownloadClientListener> mListenerReferenceQueue;
  private m mLogListener = new s(this);
  ReferenceQueue<ITMAssistantDownloadLogListener> mLogListenerReferenceQueue;
  protected ArrayList<WeakReference<ITMAssistantDownloadClientListener>> mWeakListenerArrayList;
  ArrayList<WeakReference<ITMAssistantDownloadLogListener>> mWeakLogListenerArrayList;
  boolean registered = false;
  
  public TMAssistantDownloadClient(Context paramContext, String paramString)
  {
    super(paramContext, paramString, "com.tencent.tmdownloader.TMAssistantDownloadService");
    long l = System.currentTimeMillis();
    ab.c("TMAssistantDownloadSDKClient", "enter");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("context: ");
    localStringBuilder.append(paramContext);
    localStringBuilder.append("; clientKey: ");
    localStringBuilder.append(paramString);
    ab.c("TMAssistantDownloadSDKClient", localStringBuilder.toString());
    this.mListenerReferenceQueue = new ReferenceQueue();
    this.mWeakListenerArrayList = new ArrayList();
    this.mServiceCallback = new r(this);
    ab.c("TMAssistantDownloadSDKClient", "exit");
    paramContext = new StringBuilder();
    paramContext.append(this.mServiceName);
    paramContext.append("TMAssistantDownloadClient <init> end, timeCost = ");
    paramContext.append(System.currentTimeMillis() - l);
    aa.a(paramContext.toString());
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
            int j = arrayOfString.length;
            Object localObject1 = null;
            int i = 0;
            while (i < j)
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
                    if (localObject1.equals("LL"))
                    {
                      if (!TextUtils.isEmpty((CharSequence)localObject3))
                      {
                        paramList.logLevel = ((String)localObject3);
                        localObject2 = paramList;
                      }
                      else
                      {
                        paramList.logLevel = "D";
                        localObject2 = paramList;
                      }
                    }
                    else if (localObject1.equals("LT"))
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
              }
              i += 1;
              localObject1 = localObject2;
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
      ab.c("TMAssistantDownloadSDKClient", "enter");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clientKey:");
      ((StringBuilder)localObject).append(this.mClientKey);
      ((StringBuilder)localObject).append(",url:");
      ((StringBuilder)localObject).append(paramString);
      ab.c("TMAssistantDownloadSDKClient", ((StringBuilder)localObject).toString());
      if (paramString != null)
      {
        localObject = (d)super.getServiceInterface();
        if (localObject != null)
        {
          ((d)localObject).c(this.mClientKey, paramString);
          ab.c("TMAssistantDownloadSDKClient", "cancelDownloadTask");
        }
        else
        {
          super.initTMAssistantDownloadSDK();
          ab.c("TMAssistantDownloadSDKClient", "initTMAssistantDownloadSDK");
        }
        ab.c("TMAssistantDownloadSDKClient", "exit");
        return;
      }
      ab.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
      throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
    }
    finally {}
  }
  
  public void deleteDownloadTask(String paramString)
  {
    try
    {
      ab.c("TMAssistantDownloadSDKClient", "deleteDownloadTask enter");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clientKey:");
      ((StringBuilder)localObject).append(this.mClientKey);
      ((StringBuilder)localObject).append(",url:");
      ((StringBuilder)localObject).append(paramString);
      ab.c("TMAssistantDownloadSDKClient", ((StringBuilder)localObject).toString());
      if (paramString != null)
      {
        localObject = (d)super.getServiceInterface();
        if (localObject != null)
        {
          ((d)localObject).d(this.mClientKey, paramString);
          ab.c("TMAssistantDownloadSDKClient", "deleteDownloadTask");
        }
        else
        {
          super.initTMAssistantDownloadSDK();
          ab.c("TMAssistantDownloadSDKClient", "initTMAssistantDownloadSDK");
        }
        ab.c("TMAssistantDownloadSDKClient", "deleteDownloadTask exit");
        return;
      }
      ab.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
      throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
    }
    finally {}
  }
  
  protected Intent getBindServiceIntent()
  {
    return new Intent(this.mContext, Class.forName(this.mServiceName));
  }
  
  public List<TMAssistantDownloadTaskInfo> getDownloadTaskInfosByVia(String paramString)
  {
    try
    {
      ab.c("TMAssistantDownloadSDKClient", "enter");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clientKey:");
      ((StringBuilder)localObject).append(this.mClientKey);
      ((StringBuilder)localObject).append(",mVia:");
      ((StringBuilder)localObject).append(paramString);
      ab.c("TMAssistantDownloadSDKClient", ((StringBuilder)localObject).toString());
      if (paramString != null)
      {
        localObject = (d)super.getServiceInterface();
        if (localObject != null)
        {
          paramString = ((d)localObject).a(paramString);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("returnValue(taskInfo): ");
          ((StringBuilder)localObject).append(paramString);
          ab.c("TMAssistantDownloadSDKClient", ((StringBuilder)localObject).toString());
          return paramString;
        }
        super.initTMAssistantDownloadSDK();
        ab.c("TMAssistantDownloadSDKClient", "returnValue: null");
        ab.c("TMAssistantDownloadSDKClient", "exit");
        return null;
      }
      ab.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
      throw new IllegalArgumentException("TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
    }
    finally {}
  }
  
  public TMAssistantDownloadTaskInfo getDownloadTaskState(String paramString)
  {
    try
    {
      ab.c("TMAssistantDownloadSDKClient", "enter");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clientKey:");
      ((StringBuilder)localObject).append(this.mClientKey);
      ((StringBuilder)localObject).append(",url:");
      ((StringBuilder)localObject).append(paramString);
      ab.c("TMAssistantDownloadSDKClient", ((StringBuilder)localObject).toString());
      if (paramString != null)
      {
        localObject = (d)super.getServiceInterface();
        if (localObject != null)
        {
          paramString = ((d)localObject).a(this.mClientKey, paramString);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("returnValue(taskInfo): ");
          ((StringBuilder)localObject).append(paramString);
          ab.c("TMAssistantDownloadSDKClient", ((StringBuilder)localObject).toString());
          return paramString;
        }
        super.initTMAssistantDownloadSDK();
        ab.c("TMAssistantDownloadSDKClient", "returnValue: null");
        ab.c("TMAssistantDownloadSDKClient", "exit");
        return null;
      }
      ab.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
      throw new IllegalArgumentException("TMAssistantDownloadSDKClient.getDownloadTaskState url is null");
    }
    finally {}
  }
  
  public boolean initTMAssistantDownloadSDK()
  {
    long l = System.currentTimeMillis();
    boolean bool = super.initTMAssistantDownloadSDK();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mServiceName);
    localStringBuilder.append("TMAssistantDownloadClient initTMAssistantDownloadSDK end, timeCost = ");
    localStringBuilder.append(System.currentTimeMillis() - l);
    aa.a(localStringBuilder.toString());
    return bool;
  }
  
  protected void onDownloadSDKServiceInvalid()
  {
    ab.c("TMAssistantDownloadSDKClient", "enter");
    Iterator localIterator = this.mWeakListenerArrayList.iterator();
    while (localIterator.hasNext())
    {
      ITMAssistantDownloadClientListener localITMAssistantDownloadClientListener = (ITMAssistantDownloadClientListener)((WeakReference)localIterator.next()).get();
      t.a().a(this, localITMAssistantDownloadClientListener);
    }
    ab.c("TMAssistantDownloadSDKClient", "exit");
  }
  
  public void pauseDownloadTask(String paramString)
  {
    try
    {
      ab.c("TMAssistantDownloadSDKClient", "enter");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clientKey:");
      ((StringBuilder)localObject).append(this.mClientKey);
      ((StringBuilder)localObject).append(",url:");
      ((StringBuilder)localObject).append(paramString);
      ab.c("TMAssistantDownloadSDKClient", ((StringBuilder)localObject).toString());
      if (paramString != null)
      {
        localObject = (d)super.getServiceInterface();
        if (localObject != null)
        {
          ((d)localObject).b(this.mClientKey, paramString);
          ab.c("TMAssistantDownloadSDKClient", "pauseDownloadTask");
        }
        else
        {
          super.initTMAssistantDownloadSDK();
          ab.c("TMAssistantDownloadSDKClient", "initTMAssistantDownloadSDK");
        }
        ab.c("TMAssistantDownloadSDKClient", "exit");
        return;
      }
      ab.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
      throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
    }
    finally {}
  }
  
  public boolean registerDownloadTaskListener(ITMAssistantDownloadClientListener paramITMAssistantDownloadClientListener)
  {
    try
    {
      ab.c("TMAssistantDownloadSDKClient", "enter");
      if (paramITMAssistantDownloadClientListener == null)
      {
        ab.c("TMAssistantDownloadSDKClient", "listener null");
        ab.c("TMAssistantDownloadSDKClient", "returnValue: false");
        ab.c("TMAssistantDownloadSDKClient", "exit");
        return false;
      }
      for (;;)
      {
        localObject = this.mListenerReferenceQueue.poll();
        if (localObject == null) {
          break;
        }
        ab.c("TMAssistantDownloadSDKClient", "registerDownloadTaskListener removed listener!!!!");
        this.mWeakListenerArrayList.remove(localObject);
      }
      Object localObject = this.mWeakListenerArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if ((ITMAssistantDownloadClientListener)((WeakReference)((Iterator)localObject).next()).get() == paramITMAssistantDownloadClientListener)
        {
          ab.c("TMAssistantDownloadSDKClient", "returnValue: true");
          ab.c("TMAssistantDownloadSDKClient", "exit");
          return true;
        }
      }
      paramITMAssistantDownloadClientListener = new WeakReference(paramITMAssistantDownloadClientListener, this.mListenerReferenceQueue);
      this.mWeakListenerArrayList.add(paramITMAssistantDownloadClientListener);
      ab.c("TMAssistantDownloadSDKClient", "returnValue: true");
      ab.c("TMAssistantDownloadSDKClient", "exit");
      return true;
    }
    finally {}
    for (;;)
    {
      throw paramITMAssistantDownloadClientListener;
    }
  }
  
  public boolean registerLogListener(ITMAssistantDownloadLogListener paramITMAssistantDownloadLogListener)
  {
    if (paramITMAssistantDownloadLogListener == null) {
      return false;
    }
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
        ab.c("TMAssistantDownloadSDKClient", "registerDownloadTaskListener removed listener!!!!");
        this.mWeakLogListenerArrayList.remove(localObject);
      }
      try
      {
        localObject = (d)super.getServiceInterface();
        if (localObject != null)
        {
          ab.c("TMAssistantDownloadSDKClient", "openLogListener");
          ((d)localObject).c();
        }
        else
        {
          super.initTMAssistantDownloadSDK();
          ab.c("TMAssistantDownloadSDKClient", "initTMAssistantDownloadSDK");
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      Iterator localIterator = this.mWeakLogListenerArrayList.iterator();
      while (localIterator.hasNext())
      {
        ITMAssistantDownloadLogListener localITMAssistantDownloadLogListener = (ITMAssistantDownloadLogListener)((WeakReference)localIterator.next()).get();
        if (localITMAssistantDownloadLogListener == paramITMAssistantDownloadLogListener) {
          return true;
        }
      }
      paramITMAssistantDownloadLogListener = new WeakReference(paramITMAssistantDownloadLogListener, this.mLogListenerReferenceQueue);
      this.mWeakLogListenerArrayList.add(paramITMAssistantDownloadLogListener);
      if (!this.registered)
      {
        this.registered = true;
        ab.a(this.mLogListener);
      }
      return true;
    }
    finally {}
    for (;;)
    {
      throw paramITMAssistantDownloadLogListener;
    }
  }
  
  protected void registerServiceCallback()
  {
    ((d)this.mServiceInterface).a(this.mClientKey, (com.tencent.tmassistant.aidl.a)this.mServiceCallback);
  }
  
  public int startDownloadTask(String paramString1, int paramInt, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    try
    {
      ab.c("TMAssistantDownloadSDKClient", "enter");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clientKey:");
      ((StringBuilder)localObject).append(this.mClientKey);
      ((StringBuilder)localObject).append(",url:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append("; priority: ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("; contentType: ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("; fileName ： ");
      ((StringBuilder)localObject).append(paramString3);
      ab.c("TMAssistantDownloadSDKClient", ((StringBuilder)localObject).toString());
      if (paramMap != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("params.size: ");
        ((StringBuilder)localObject).append(paramMap.size());
        ab.c("TMAssistantDownloadSDKClient", ((StringBuilder)localObject).toString());
      }
      else
      {
        ab.c("TMAssistantDownloadSDKClient", "params: null");
      }
      if (paramString1 != null)
      {
        if ((paramString2.equals("resource/tm.android.unknown")) && (TextUtils.isEmpty(paramString3)))
        {
          ab.e("TMAssistantDownloadSDKClient", "exception: if contentType is others, filename shouldn't be null!");
          throw new IllegalArgumentException("if contentType is others, filename shouldn't be null!");
        }
        d locald = (d)super.getServiceInterface();
        if (locald != null)
        {
          ab.c("TMAssistantDownloadSDKClient", "startDownloadTask");
          localObject = paramMap;
          if (paramMap == null) {
            localObject = new HashMap();
          }
          ((Map)localObject).put(TMAssistantDownloadConst.PARAM_CALL_STACK, Log.getStackTraceString(new Throwable()));
          paramInt = locald.a(this.mClientKey, paramString1, 0, paramString2, paramString3, (Map)localObject);
          paramString1 = new StringBuilder();
          paramString1.append("returnValue: ");
          paramString1.append(paramInt);
          ab.c("TMAssistantDownloadSDKClient", paramString1.toString());
          ab.c("TMAssistantDownloadSDKClient", "exit");
          return paramInt;
        }
        super.initTMAssistantDownloadSDK();
        ab.c("TMAssistantDownloadSDKClient", "super.initTMAssistantDownloadSDK");
        ab.c("TMAssistantDownloadSDKClient", "returnValue: 0");
        ab.c("TMAssistantDownloadSDKClient", "exit");
        return 0;
      }
      ab.e("TMAssistantDownloadSDKClient", "exception: TMAssistantDownloadSDKClient.startDownloadTask url is null");
      throw new IllegalArgumentException("TMAssistantDownloadSDKClient.startDownloadTask url is null");
    }
    finally {}
  }
  
  public int startDownloadTask(String paramString1, String paramString2)
  {
    try
    {
      ab.c("TMAssistantDownloadSDKClient", "enter");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("; contentType: ");
      localStringBuilder.append(paramString2);
      ab.c("TMAssistantDownloadSDKClient", localStringBuilder.toString());
      int i = startDownloadTask(paramString1, 0, paramString2, null, null);
      paramString1 = new StringBuilder();
      paramString1.append("returnValue: ");
      paramString1.append(i);
      ab.c("TMAssistantDownloadSDKClient", paramString1.toString());
      ab.c("TMAssistantDownloadSDKClient", "exit");
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("client is: ");
      localStringBuilder.append(this);
      ab.c("TMAssistantDownloadSDKClient", localStringBuilder.toString());
      ab.c("TMAssistantDownloadSDKClient", "enter");
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("url: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("; contentType: ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("; fileName: ");
      localStringBuilder.append(paramString3);
      ab.c("TMAssistantDownloadSDKClient", localStringBuilder.toString());
      int i = startDownloadTask(paramString1, 0, paramString2, paramString3, null);
      paramString1 = new StringBuilder();
      paramString1.append("returnValue: ");
      paramString1.append(i);
      ab.c("TMAssistantDownloadSDKClient", paramString1.toString());
      ab.c("TMAssistantDownloadSDKClient", "exit");
      return i;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public int startDownloadTask(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    try
    {
      ab.c("TMAssistantDownloadSDKClient", "enter");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("; contentType: ");
      localStringBuilder.append(paramString2);
      ab.c("TMAssistantDownloadSDKClient", localStringBuilder.toString());
      if (paramMap != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("params.size: ");
        localStringBuilder.append(paramMap.size());
        ab.c("TMAssistantDownloadSDKClient", localStringBuilder.toString());
      }
      else
      {
        ab.c("TMAssistantDownloadSDKClient", "params: null");
      }
      int i = startDownloadTask(paramString1, 0, paramString2, null, paramMap);
      paramString1 = new StringBuilder();
      paramString1.append("returnValue: ");
      paramString1.append(i);
      ab.c("TMAssistantDownloadSDKClient", paramString1.toString());
      ab.c("TMAssistantDownloadSDKClient", "exit");
      return i;
    }
    finally {}
  }
  
  protected void stubAsInterface(IBinder paramIBinder)
  {
    this.mServiceInterface = e.a(paramIBinder);
  }
  
  public boolean unRegisterDownloadTaskListener(ITMAssistantDownloadClientListener paramITMAssistantDownloadClientListener)
  {
    try
    {
      ab.c("TMAssistantDownloadSDKClient", "enter");
      if (paramITMAssistantDownloadClientListener == null)
      {
        ab.c("TMAssistantDownloadSDKClient", "listener null");
        ab.c("TMAssistantDownloadSDKClient", "returnValue: false");
        ab.c("TMAssistantDownloadSDKClient", "exit");
        return false;
      }
      Iterator localIterator = this.mWeakListenerArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((ITMAssistantDownloadClientListener)localWeakReference.get() == paramITMAssistantDownloadClientListener)
        {
          this.mWeakListenerArrayList.remove(localWeakReference);
          ab.c("TMAssistantDownloadSDKClient", "returnValue: true");
          ab.c("TMAssistantDownloadSDKClient", "exit");
          return true;
        }
      }
      ab.c("TMAssistantDownloadSDKClient", "returnValue: false");
      ab.c("TMAssistantDownloadSDKClient", "exit");
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramITMAssistantDownloadClientListener;
    }
  }
  
  public boolean unRegisterLogListener(ITMAssistantDownloadLogListener paramITMAssistantDownloadLogListener)
  {
    if (paramITMAssistantDownloadLogListener == null) {
      return false;
    }
    try
    {
      Iterator localIterator = this.mWeakLogListenerArrayList.iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((ITMAssistantDownloadLogListener)localWeakReference.get() == paramITMAssistantDownloadLogListener)
        {
          this.mWeakLogListenerArrayList.remove(localWeakReference);
          if (this.mWeakLogListenerArrayList.size() == 0)
          {
            ab.b(this.mLogListener);
            try
            {
              paramITMAssistantDownloadLogListener = (d)super.getServiceInterface();
              if (paramITMAssistantDownloadLogListener != null) {
                paramITMAssistantDownloadLogListener.d();
              }
            }
            catch (Exception paramITMAssistantDownloadLogListener)
            {
              paramITMAssistantDownloadLogListener.printStackTrace();
            }
          }
          return true;
        }
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramITMAssistantDownloadLogListener;
    }
  }
  
  protected void unRegisterServiceCallback()
  {
    ((d)this.mServiceInterface).b(this.mClientKey, (com.tencent.tmassistant.aidl.a)this.mServiceCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.TMAssistantDownloadClient
 * JD-Core Version:    0.7.0.1
 */