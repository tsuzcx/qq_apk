package com.tencent.weiyun.uploader;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.weiyun.uploader.module.SpeedFilter;
import com.tencent.weiyun.uploader.module.XpConfig;
import com.tencent.weiyun.uploader.module.XpLog;
import com.tencent.weiyun.uploader.xplatform.UploadNative;
import com.tencent.weiyun.uploader.xplatform.UploadNative.CanceledFlag;
import com.tencent.weiyun.uploader.xplatform.UploadSDKContext;
import com.tencent.weiyun.uploader.xplatform.UploadSDKContext.IUploadSDKCallback;
import com.tencent.weiyun.utils.DualHashMap;
import com.tencent.weiyun.utils.ILog;
import com.tencent.weiyun.utils.MultiHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Uploader
  implements IUploader, Handler.Callback, UploadSDKContext.IUploadSDKCallback
{
  private static final int MSG_NATIVE_START = 2020;
  private static final int MSG_NATIVE_STOP = 2021;
  private static final int MSG_NATIVE_STOP_ALL = 2022;
  private final MultiHashMap<String, UploadRequest> mPendingRequests = new MultiHashMap();
  private final Map<String, SpeedFilter> mSpeedFilters = new HashMap();
  private final Handler mStartHandler;
  private final Handler mStopHandler;
  private final DualHashMap<String, String> mTasks = new DualHashMap();
  private final UploadContext mUploadContext;
  
  public Uploader(Context paramContext, String paramString, IReporter paramIReporter)
  {
    UploadNative localUploadNative = UploadNative.getInstance();
    localUploadNative.init(XpConfig.getCachePath(), "Android", Integer.toString(Build.VERSION.SDK_INT), XpConfig.getVersion(), XpConfig.getQUA(), XpConfig.isRdm(), new UploadSDKContext(this));
    this.mUploadContext = new UploadContext(paramContext, paramString, localUploadNative, paramIReporter);
    paramContext = new HandlerThread(paramString + "_start");
    paramContext.start();
    this.mStartHandler = new Handler(paramContext.getLooper(), this);
    paramContext = new HandlerThread(paramString + "_stop");
    paramContext.start();
    this.mStopHandler = new Handler(paramContext.getLooper(), this);
  }
  
  private boolean addPendingRequest(String paramString, UploadRequest paramUploadRequest)
  {
    boolean bool = false;
    if ((TextUtils.isEmpty(paramString)) || (paramUploadRequest == null)) {
      return false;
    }
    for (;;)
    {
      synchronized (this.mPendingRequests)
      {
        Collection localCollection = (Collection)this.mPendingRequests.get(paramString);
        if ((localCollection != null) && (localCollection.size() > 0))
        {
          i = 1;
          this.mPendingRequests.add(paramString, paramUploadRequest);
          if (i == 0) {
            bool = true;
          }
          return bool;
        }
      }
      int i = 0;
    }
  }
  
  private Collection<UploadRequest> collectPendingRequest(String paramString, boolean paramBoolean)
  {
    HashSet localHashSet = new HashSet();
    if (TextUtils.isEmpty(paramString)) {
      return localHashSet;
    }
    MultiHashMap localMultiHashMap = this.mPendingRequests;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramString = (HashSet)this.mPendingRequests.remove(paramString);
        if (paramString != null) {
          localHashSet.addAll(paramString);
        }
        return localHashSet;
      }
      finally {}
      paramString = (HashSet)this.mPendingRequests.get(paramString);
    }
  }
  
  private Collection<UploadRequest> collectPendingRequest(boolean paramBoolean)
  {
    HashSet localHashSet = new HashSet();
    synchronized (this.mPendingRequests)
    {
      Iterator localIterator = this.mPendingRequests.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Collection localCollection1 = (Collection)((Map.Entry)localIterator.next()).getValue();
        if (localCollection1 != null) {
          localHashSet.addAll(localCollection1);
        }
        if (paramBoolean) {
          localIterator.remove();
        }
      }
    }
    return localCollection;
  }
  
  public static void init(IConfig paramIConfig, ILog paramILog)
  {
    XpConfig.setConfig(paramIConfig);
    XpLog.setLog(paramILog);
  }
  
  private void notifyCanceled(Collection<UploadRequest> paramCollection)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        UploadRequest localUploadRequest = (UploadRequest)paramCollection.next();
        if ((localUploadRequest != null) && (localUploadRequest.listener() != null)) {
          localUploadRequest.listener().onUploadCanceled(localUploadRequest);
        }
      }
    }
  }
  
  private void notifyFinished(Collection<UploadRequest> paramCollection, int paramInt, String paramString)
  {
    if (paramCollection == null) {
      return;
    }
    paramCollection = paramCollection.iterator();
    label12:
    UploadRequest localUploadRequest;
    while (paramCollection.hasNext())
    {
      localUploadRequest = (UploadRequest)paramCollection.next();
      if ((localUploadRequest != null) && (localUploadRequest.listener() != null)) {
        if (paramInt != 0) {
          break label96;
        }
      }
    }
    label96:
    for (boolean bool = true;; bool = false)
    {
      UploadResponse localUploadResponse = new UploadResponse.Builder().request(localUploadRequest).code(paramInt).errMsg(paramString).build();
      localUploadRequest.listener().onUploadFinished(localUploadRequest, bool, localUploadResponse);
      break label12;
      break;
    }
  }
  
  private void notifyProgress(Collection<UploadRequest> paramCollection, long paramLong1, float paramFloat, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramCollection == null) {}
    for (;;)
    {
      return;
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        UploadRequest localUploadRequest = (UploadRequest)paramCollection.next();
        if ((localUploadRequest != null) && (localUploadRequest.listener() != null)) {
          localUploadRequest.listener().onUploadProgress(localUploadRequest, paramLong1, paramFloat, paramLong2, paramLong3, paramLong4);
        }
      }
    }
  }
  
  private boolean removePendingRequest(String paramString, UploadRequest paramUploadRequest, Collection<UploadRequest> paramCollection)
  {
    boolean bool = false;
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    MultiHashMap localMultiHashMap = this.mPendingRequests;
    if (paramUploadRequest != null) {}
    for (;;)
    {
      int i;
      try
      {
        if ((this.mPendingRequests.remove(paramString, paramUploadRequest)) && (paramCollection != null))
        {
          paramCollection.clear();
          paramCollection.add(paramUploadRequest);
        }
        paramString = (Collection)this.mPendingRequests.get(paramString);
        if ((paramString == null) || (paramString.size() <= 0)) {
          break label135;
        }
        i = 1;
      }
      finally {}
      return bool;
      paramUploadRequest = (Collection)this.mPendingRequests.remove(paramString);
      if ((paramUploadRequest != null) && (paramCollection != null))
      {
        paramCollection.clear();
        paramCollection.addAll(paramUploadRequest);
        continue;
        label135:
        i = 0;
        if (i == 0) {
          bool = true;
        }
      }
    }
  }
  
  public String[] calSliceSha1(String paramString, UploadNative.CanceledFlag paramCanceledFlag)
  {
    return this.mUploadContext.xpUploader().calSliceSha1(paramString, paramCanceledFlag);
  }
  
  public final void cancel(UploadRequest paramUploadRequest)
  {
    if (paramUploadRequest == null) {
      return;
    }
    XpLog.i("prepare to cancel:" + paramUploadRequest.path() + ", requestKey=" + paramUploadRequest.requestKey() + ", listener=" + paramUploadRequest.listener());
    Message.obtain(this.mStopHandler, 2021, paramUploadRequest).sendToTarget();
  }
  
  public final void cancelAll()
  {
    XpLog.i("prepare to cancel all from uploader-" + this.mUploadContext.tag());
    Message.obtain(this.mStopHandler, 2022).sendToTarget();
  }
  
  public boolean handleMessage(Message arg1)
  {
    Object localObject5;
    if (???.what == 2020)
    {
      ??? = ???.obj;
      if ((??? instanceof UploadRequest))
      {
        ??? = (UploadRequest)???;
        localObject5 = ((UploadRequest)???).requestKey();
        Collection localCollection = collectPendingRequest((String)localObject5, false);
        if (!localCollection.isEmpty())
        {
          ??? = (Message)???;
          if (!localCollection.contains(???)) {
            ??? = (UploadRequest)localCollection.iterator().next();
          }
          if (??? != null) {
            synchronized (this.mTasks)
            {
              boolean bool = this.mTasks.containsKey(localObject5);
              if (!bool)
              {
                ??? = this.mUploadContext.xpUploader().createUploadTask(???.uin(), ???.path(), ???.size(), ???.checkKey(), ???.serverName(), ???.serverIp(), ???.serverPort(), ???.channelCount(), ???.sliceSha(), ???.statisticTimes());
                XpLog.i("createUploadTask: path=" + ???.path() + ", size=" + ???.size() + ", sha=" + ???.sha());
                if ((!collectPendingRequest((String)localObject5, false).isEmpty()) && (!TextUtils.isEmpty((CharSequence)???))) {
                  synchronized (this.mTasks)
                  {
                    this.mTasks.put(localObject5, ???);
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      synchronized (this.mSpeedFilters)
      {
        this.mSpeedFilters.put(???, new SpeedFilter());
        this.mUploadContext.xpUploader().startTask((String)???);
        return true;
        ??? = finally;
        throw ???;
        localObject2 = finally;
        throw localObject2;
      }
      if (???.what == 2021)
      {
        ??? = ???.obj;
        if (!(??? instanceof UploadRequest)) {
          continue;
        }
        localObject5 = (UploadRequest)???;
        ??? = new ArrayList();
        if (removePendingRequest(((UploadRequest)localObject5).requestKey(), (UploadRequest)localObject5, ???)) {
          synchronized (this.mTasks)
          {
            localObject5 = (String)this.mTasks.removeByKey(((UploadRequest)localObject5).requestKey());
            if (localObject5 != null) {
              this.mUploadContext.xpUploader().stopTask((String)localObject5);
            }
          }
        }
        synchronized (this.mSpeedFilters)
        {
          this.mSpeedFilters.remove(localObject5);
          notifyCanceled(???);
          continue;
          ??? = finally;
          throw ???;
        }
      }
      if (???.what != 2022) {
        continue;
      }
      ??? = collectPendingRequest(true);
      synchronized (this.mTasks)
      {
        localObject5 = new ArrayList(this.mTasks.values());
        this.mTasks.clear();
        ??? = ((ArrayList)localObject5).iterator();
        if (((Iterator)???).hasNext())
        {
          localObject5 = (String)((Iterator)???).next();
          this.mUploadContext.xpUploader().stopTask((String)localObject5);
        }
      }
      synchronized (this.mSpeedFilters)
      {
        this.mSpeedFilters.clear();
        notifyCanceled(???);
      }
    }
  }
  
  public void reportError(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, boolean paramBoolean1, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean2, int paramInt2)
  {
    this.mUploadContext.xpUploader().reportError(paramLong1, paramString1, paramString2, paramString3, paramInt1, paramBoolean1, paramLong2, paramLong3, paramLong4, paramBoolean2, paramInt2);
  }
  
  public void setHttpProxy(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.mUploadContext.xpUploader().setHttpProxy(paramString1, paramInt, paramString2, paramString3);
  }
  
  public void setIpConfig(String paramString1, String paramString2)
  {
    this.mUploadContext.xpUploader().setIpConfig(paramString1, paramString2);
  }
  
  public void setNetType(int paramInt)
  {
    this.mUploadContext.xpUploader().setNetType(paramInt);
  }
  
  public void setReporter(IReporter paramIReporter) {}
  
  public void speedDown()
  {
    this.mUploadContext.xpUploader().speedDown();
  }
  
  public void trialSpeedUp(int paramInt)
  {
    this.mUploadContext.xpUploader().trialSpeedUp(paramInt);
  }
  
  public final boolean upload(UploadRequest paramUploadRequest)
  {
    if (paramUploadRequest == null)
    {
      XpLog.w("Unsupported request.");
      return false;
    }
    XpLog.i("prepare to upload:" + paramUploadRequest.path() + ", requestKey=" + paramUploadRequest.requestKey() + ", listener=" + paramUploadRequest.listener());
    if (addPendingRequest(paramUploadRequest.requestKey(), paramUploadRequest)) {
      Message.obtain(this.mStartHandler, 2020, paramUploadRequest).sendToTarget();
    }
    return true;
  }
  
  public void uploadCancelled(String paramString) {}
  
  public void uploadFinish(String paramString1, int paramInt, String paramString2)
  {
    String str;
    synchronized (this.mTasks)
    {
      str = (String)this.mTasks.removeByValue(paramString1);
    }
    synchronized (this.mSpeedFilters)
    {
      this.mSpeedFilters.remove(paramString1);
      if (str != null)
      {
        paramString1 = collectPendingRequest(str, true);
        ??? = this.mUploadContext.reporter();
        if ((??? != null) && (!paramString1.isEmpty())) {
          ((IReporter)???).handleReport(new UploadResponse.Builder().request((UploadRequest)paramString1.iterator().next()).code(paramInt).errMsg(paramString2).build());
        }
        notifyFinished(paramString1, paramInt, paramString2);
      }
      return;
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void uploadProgress(String paramString, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    synchronized (this.mSpeedFilters)
    {
      ??? = (SpeedFilter)this.mSpeedFilters.get(paramString);
      if (??? == null)
      {
        ??? = new long[3];
        ???[0] = paramLong3;
        ???[1] = paramLong4;
        ???[2] = paramLong5;
      }
    }
    for (;;)
    {
      synchronized (this.mTasks)
      {
        paramString = (String)this.mTasks.getByValue(paramString);
        if (paramString != null)
        {
          paramString = collectPendingRequest(paramString, false);
          if (paramLong1 == 0L)
          {
            f = 1.0F;
            notifyProgress(paramString, paramLong1, f, ???[0], ???[1], ???[2]);
          }
        }
        else
        {
          return;
          paramString = finally;
          throw paramString;
          ??? = ((SpeedFilter)???).updateSpeed(paramLong3, paramLong4, paramLong5);
        }
      }
      float f = (float)paramLong2 / (float)paramLong1;
    }
  }
  
  public void vipSpeedUp()
  {
    this.mUploadContext.xpUploader().vipSpeedUp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.uploader.Uploader
 * JD-Core Version:    0.7.0.1
 */