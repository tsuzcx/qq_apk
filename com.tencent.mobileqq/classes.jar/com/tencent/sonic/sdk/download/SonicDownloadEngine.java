package com.tencent.sonic.sdk.download;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.sonic.sdk.SonicConfig;
import com.tencent.sonic.sdk.SonicEngine;
import com.tencent.sonic.sdk.SonicRuntime;
import com.tencent.sonic.sdk.SonicSession;
import com.tencent.sonic.sdk.SonicUtils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class SonicDownloadEngine
  implements Handler.Callback
{
  private static final int MSG_DEQUEUE = 1;
  private static final int MSG_ENQUEUE = 0;
  public static final String TAG = "SonicSdk_SonicDownloadEngine";
  private SonicDownloadCache mCache;
  private Handler mHandler;
  private AtomicInteger mNumOfDownloadingTask;
  private final SonicDownloadQueue mQueue = new SonicDownloadQueue(null);
  private ConcurrentMap<String, SonicDownloadClient.DownloadTask> resourceTasks = new ConcurrentHashMap();
  
  public SonicDownloadEngine(SonicDownloadCache paramSonicDownloadCache)
  {
    HandlerThread localHandlerThread = new HandlerThread("Download-Thread");
    localHandlerThread.start();
    this.mHandler = new Handler(localHandlerThread.getLooper(), this);
    this.mNumOfDownloadingTask = new AtomicInteger(0);
    this.mCache = paramSonicDownloadCache;
  }
  
  private void startDownload(final SonicDownloadClient.DownloadTask paramDownloadTask)
  {
    SonicEngine.getInstance().getRuntime().postTaskToSessionThread(new Runnable()
    {
      public void run()
      {
        SonicDownloadEngine.this.mNumOfDownloadingTask.incrementAndGet();
        paramDownloadTask.mState.set(2);
        new SonicDownloadClient(paramDownloadTask).download();
      }
    });
  }
  
  public void addSubResourcePreloadTask(List<String> paramList)
  {
    SonicRuntime localSonicRuntime = SonicEngine.getInstance().getRuntime();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      if (!this.resourceTasks.containsKey(str)) {
        this.resourceTasks.put(str, download(str, localSonicRuntime.getHostDirectAddress(str), localSonicRuntime.getCookie(str), new SonicDownloadClient.SubResourceDownloadCallback(str)));
      }
    }
  }
  
  public SonicDownloadClient.DownloadTask download(String paramString1, String paramString2, String paramString3, SonicDownloadCallback paramSonicDownloadCallback)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    synchronized (this.mQueue)
    {
      if (this.mQueue.containsKey(paramString1))
      {
        SonicUtils.log("SonicSdk_SonicDownloadEngine", 4, "sub resource download task has been in queue (" + paramString1 + ").");
        paramString1 = (SonicDownloadClient.DownloadTask)this.mQueue.get(paramString1);
        return paramString1;
      }
      ??? = new SonicDownloadClient.DownloadTask();
      ((SonicDownloadClient.DownloadTask)???).mResourceUrl = paramString1;
      ((SonicDownloadClient.DownloadTask)???).mCallbacks.add(paramSonicDownloadCallback);
      ((SonicDownloadClient.DownloadTask)???).mCallbacks.add(new SonicDownloadCallback.SimpleDownloadCallback()
      {
        public void onFinish()
        {
          this.val$task.mState.set(3);
          SonicDownloadEngine.this.mHandler.sendEmptyMessage(1);
        }
      });
      paramSonicDownloadCallback = this.mCache.getResourceCache(paramString1);
      if (paramSonicDownloadCallback != null)
      {
        ((SonicDownloadClient.DownloadTask)???).mInputStream = new ByteArrayInputStream(paramSonicDownloadCallback);
        ((SonicDownloadClient.DownloadTask)???).mRspHeaders = this.mCache.getResourceCacheHeader(paramString1);
        ((SonicDownloadClient.DownloadTask)???).mState.set(4);
        SonicUtils.log("SonicSdk_SonicDownloadEngine", 4, "load sub resource(" + paramString1 + ") from cache.");
        return ???;
      }
    }
    ((SonicDownloadClient.DownloadTask)???).mIpAddress = paramString2;
    ((SonicDownloadClient.DownloadTask)???).mCookie = paramString3;
    if (this.mNumOfDownloadingTask.get() < SonicEngine.getInstance().getConfig().SONIC_MAX_NUM_OF_DOWNLOADING_TASK)
    {
      startDownload((SonicDownloadClient.DownloadTask)???);
      return ???;
    }
    paramString1 = this.mHandler.obtainMessage(0, ???);
    this.mHandler.sendMessage(paramString1);
    return ???;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      paramMessage = (SonicDownloadClient.DownloadTask)paramMessage.obj;
      this.mQueue.enqueue(paramMessage);
      paramMessage.mState.set(1);
      SonicUtils.log("SonicSdk_SonicDownloadEngine", 4, "enqueue sub resource(" + paramMessage.mResourceUrl + ").");
      continue;
      if (!this.mQueue.isEmpty())
      {
        paramMessage = this.mQueue.dequeue();
        startDownload(paramMessage);
        SonicUtils.log("SonicSdk_SonicDownloadEngine", 4, "dequeue sub resource(" + paramMessage.mResourceUrl + ").");
      }
    }
  }
  
  public Object onRequestSubResource(String paramString, SonicSession paramSonicSession)
  {
    if (SonicUtils.shouldLog(4)) {
      SonicUtils.log("SonicSdk_SonicDownloadEngine", 4, "session onRequestSubResource: resource url(" + paramString + ").");
    }
    Object localObject2;
    if (this.resourceTasks.containsKey(paramString))
    {
      localObject2 = (SonicDownloadClient.DownloadTask)this.resourceTasks.get(paramString);
      ((SonicDownloadClient.DownloadTask)localObject2).mWasInterceptInvoked.set(true);
      if ((((SonicDownloadClient.DownloadTask)localObject2).mState.get() != 0) && (((SonicDownloadClient.DownloadTask)localObject2).mState.get() != 1)) {
        break label100;
      }
    }
    for (;;)
    {
      return null;
      label100:
      if (((SonicDownloadClient.DownloadTask)localObject2).mInputStream == null) {}
      synchronized (((SonicDownloadClient.DownloadTask)localObject2).mWasInterceptInvoked)
      {
        try
        {
          ((SonicDownloadClient.DownloadTask)localObject2).mWasInterceptInvoked.wait(3000L);
          if (((SonicDownloadClient.DownloadTask)localObject2).mInputStream != null)
          {
            ??? = ((SonicDownloadClient.DownloadTask)localObject2).mInputStream;
            localObject2 = ((SonicDownloadClient.DownloadTask)localObject2).mRspHeaders;
            if (!paramSonicSession.isDestroyedOrWaitingForDestroy())
            {
              paramString = SonicUtils.getMime(paramString);
              localObject2 = SonicUtils.getFilteredHeaders((Map)localObject2);
              return SonicEngine.getInstance().getRuntime().createWebResourceResponse(paramString, paramSonicSession.getCharsetFromHeaders((Map)localObject2), (InputStream)???, (Map)localObject2);
            }
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            SonicUtils.log("SonicSdk_SonicDownloadEngine", 6, "session onRequestSubResource error: " + localInterruptedException.getMessage());
          }
        }
      }
    }
    SonicUtils.log("SonicSdk_SonicDownloadEngine", 6, "session onRequestSubResource error: session is destroyed!");
    return null;
  }
  
  private static class SonicDownloadQueue
    extends LinkedHashMap<String, SonicDownloadClient.DownloadTask>
  {
    /* Error */
    SonicDownloadClient.DownloadTask dequeue()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokevirtual 21	com/tencent/sonic/sdk/download/SonicDownloadEngine$SonicDownloadQueue:values	()Ljava/util/Collection;
      //   6: invokeinterface 27 1 0
      //   11: invokeinterface 33 1 0
      //   16: ifeq +35 -> 51
      //   19: aload_0
      //   20: aload_0
      //   21: invokevirtual 21	com/tencent/sonic/sdk/download/SonicDownloadEngine$SonicDownloadQueue:values	()Ljava/util/Collection;
      //   24: invokeinterface 27 1 0
      //   29: invokeinterface 37 1 0
      //   34: checkcast 39	com/tencent/sonic/sdk/download/SonicDownloadClient$DownloadTask
      //   37: getfield 43	com/tencent/sonic/sdk/download/SonicDownloadClient$DownloadTask:mResourceUrl	Ljava/lang/String;
      //   40: invokevirtual 47	com/tencent/sonic/sdk/download/SonicDownloadEngine$SonicDownloadQueue:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   43: checkcast 39	com/tencent/sonic/sdk/download/SonicDownloadClient$DownloadTask
      //   46: astore_1
      //   47: aload_0
      //   48: monitorexit
      //   49: aload_1
      //   50: areturn
      //   51: aconst_null
      //   52: astore_1
      //   53: goto -6 -> 47
      //   56: astore_1
      //   57: aload_0
      //   58: monitorexit
      //   59: aload_1
      //   60: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	SonicDownloadQueue
      //   46	7	1	localDownloadTask	SonicDownloadClient.DownloadTask
      //   56	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	47	56	finally
    }
    
    void enqueue(SonicDownloadClient.DownloadTask paramDownloadTask)
    {
      if (paramDownloadTask != null) {}
      try
      {
        if (!TextUtils.isEmpty(paramDownloadTask.mResourceUrl)) {
          put(paramDownloadTask.mResourceUrl, paramDownloadTask);
        }
        return;
      }
      finally
      {
        paramDownloadTask = finally;
        throw paramDownloadTask;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sonic.sdk.download.SonicDownloadEngine
 * JD-Core Version:    0.7.0.1
 */