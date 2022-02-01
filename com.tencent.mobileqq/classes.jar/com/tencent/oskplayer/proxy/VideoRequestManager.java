package com.tencent.oskplayer.proxy;

import android.text.TextUtils;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class VideoRequestManager
{
  private static final String TAG = "RequestManager";
  private ArrayList<VideoRequestManager.RequestListener> mListeners = new ArrayList();
  private final Object mLock = new Object();
  private final LinkedHashMap<String, ArrayList<VideoRequest>> requestMap = new LinkedHashMap(8, 0.75F);
  
  private void cancelRequest(VideoRequest paramVideoRequest, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start cancel request=");
    localStringBuilder.append(paramVideoRequest);
    PlayerUtils.log(4, "RequestManager", localStringBuilder.toString());
    paramVideoRequest.cancel(paramBoolean);
  }
  
  private void cancelVideoRequestByUuid(String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = getVideoRequestByUuid(paramString).iterator();
      while (paramString.hasNext()) {
        cancelRequest((VideoRequest)paramString.next(), paramBoolean);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void addRequest(String paramString, VideoRequest paramVideoRequest)
  {
    try
    {
      Object localObject2 = (ArrayList)this.requestMap.get(paramString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ArrayList();
        this.requestMap.put(paramString, localObject1);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("init requestMap for url ");
        ((StringBuilder)localObject2).append(paramString);
        PlayerUtils.log(3, "RequestManager", ((StringBuilder)localObject2).toString());
      }
      ((ArrayList)localObject1).add(paramVideoRequest);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void addRequestListener(VideoRequestManager.RequestListener paramRequestListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	com/tencent/oskplayer/proxy/VideoRequestManager:mLock	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_2
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 25	com/tencent/oskplayer/proxy/VideoRequestManager:mListeners	Ljava/util/ArrayList;
    //   18: aload_1
    //   19: invokevirtual 104	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   22: pop
    //   23: aload_2
    //   24: monitorexit
    //   25: return
    //   26: astore_1
    //   27: aload_2
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	VideoRequestManager
    //   0	31	1	paramRequestListener	VideoRequestManager.RequestListener
    //   4	24	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	13	26	finally
    //   14	25	26	finally
    //   27	29	26	finally
  }
  
  public void cancelAllPreloadRequestAsync(boolean paramBoolean)
  {
    try
    {
      Iterator localIterator = this.requestMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (ArrayList)((Map.Entry)localIterator.next()).getValue();
        if (localObject2 != null)
        {
          localObject2 = ((ArrayList)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            VideoRequest localVideoRequest = (VideoRequest)((Iterator)localObject2).next();
            if (localVideoRequest.getPrority() <= 10)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("preload cancel url ");
              localStringBuilder.append(localVideoRequest);
              PlayerUtils.log(4, "RequestManager", localStringBuilder.toString());
              cancelRequest(localVideoRequest, paramBoolean);
              ((Iterator)localObject2).remove();
            }
          }
        }
        else
        {
          PlayerUtils.log(4, "RequestManager", "cancel url fail, associate request not found, mediaplayer is dead?");
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public void cancelPreloadRequestByRequest(VideoRequest paramVideoRequest, boolean paramBoolean)
  {
    if (paramVideoRequest != null) {}
    try
    {
      paramVideoRequest.cancel(paramBoolean);
    }
    finally {}
  }
  
  public void cancelVideoRequestByUuid(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString)) {
        cancelVideoRequestByUuid(paramString, true);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public ArrayList<VideoRequest> getActiveVideoRequest()
  {
    try
    {
      ArrayList localArrayList1 = new ArrayList();
      Iterator localIterator = this.requestMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ArrayList localArrayList2 = (ArrayList)((Map.Entry)localIterator.next()).getValue();
        if (localArrayList2.size() > 0) {
          localArrayList1.addAll(localArrayList2);
        }
      }
      return localArrayList1;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public ArrayList<VideoRequest> getPriorityRequest(int paramInt)
  {
    try
    {
      ArrayList localArrayList1 = new ArrayList();
      Iterator localIterator = this.requestMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ArrayList localArrayList2 = (ArrayList)((Map.Entry)localIterator.next()).getValue();
        if ((localArrayList2.size() > 0) && (paramInt == ((VideoRequest)localArrayList2.get(0)).getPrority())) {
          localArrayList1.addAll(localArrayList2);
        }
      }
      return localArrayList1;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public ArrayList<VideoRequest> getVideoRequestByUuid(String paramString)
  {
    try
    {
      paramString = getVideoRequestByUuid(paramString, -1);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public ArrayList<VideoRequest> getVideoRequestByUuid(String paramString, int paramInt)
  {
    try
    {
      ArrayList localArrayList1 = new ArrayList();
      Iterator localIterator = this.requestMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ArrayList localArrayList2 = (ArrayList)((Map.Entry)localIterator.next()).getValue();
        if (localArrayList2.size() > 0)
        {
          VideoRequest localVideoRequest = (VideoRequest)localArrayList2.get(0);
          if (paramString.equals(localVideoRequest.getUuid())) {
            if (paramInt != -1)
            {
              if (paramInt == localVideoRequest.getPrority()) {
                localArrayList1.addAll(localArrayList2);
              }
            }
            else {
              localArrayList1.addAll(localArrayList2);
            }
          }
        }
      }
      return localArrayList1;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public ArrayList<VideoRequest> getVideoRequestByVideoKey(String paramString, int paramInt)
  {
    try
    {
      ArrayList localArrayList1 = new ArrayList();
      Iterator localIterator = this.requestMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ArrayList localArrayList2 = (ArrayList)((Map.Entry)localIterator.next()).getValue();
        if (localArrayList2.size() > 0)
        {
          VideoRequest localVideoRequest = (VideoRequest)localArrayList2.get(0);
          if (paramString.equals(localVideoRequest.getVideoKey())) {
            if (paramInt != -1)
            {
              if (paramInt == localVideoRequest.getPrority()) {
                localArrayList1.addAll(localArrayList2);
              }
            }
            else {
              localArrayList1.addAll(localArrayList2);
            }
          }
        }
      }
      return localArrayList1;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void removeRequest(VideoRequest paramVideoRequest)
  {
    try
    {
      Object localObject1 = (ArrayList)this.requestMap.get(paramVideoRequest.getSourceUrl());
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          if (paramVideoRequest.equals((VideoRequest)((Iterator)localObject1).next()))
          {
            if (PlayerConfig.g().isDebugVersion())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("remove request ");
              ((StringBuilder)localObject2).append(paramVideoRequest);
              PlayerUtils.log(3, "RequestManager", ((StringBuilder)localObject2).toString());
            }
            Object localObject2 = this.mListeners.iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((VideoRequestManager.RequestListener)((Iterator)localObject2).next()).onBeforeRequestRemove(paramVideoRequest);
            }
            ((Iterator)localObject1).remove();
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramVideoRequest;
    }
  }
  
  /* Error */
  public void removeRequestListener(VideoRequestManager.RequestListener paramRequestListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	com/tencent/oskplayer/proxy/VideoRequestManager:mLock	Ljava/lang/Object;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_2
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 25	com/tencent/oskplayer/proxy/VideoRequestManager:mListeners	Ljava/util/ArrayList;
    //   18: aload_1
    //   19: invokevirtual 199	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   22: pop
    //   23: aload_2
    //   24: monitorexit
    //   25: return
    //   26: astore_1
    //   27: aload_2
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	VideoRequestManager
    //   0	31	1	paramRequestListener	VideoRequestManager.RequestListener
    //   4	24	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	13	26	finally
    //   14	25	26	finally
    //   27	29	26	finally
  }
  
  public String toString()
  {
    try
    {
      Object localObject1 = super.toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("[");
      localObject3 = ((StringBuilder)localObject3).toString();
      Iterator localIterator1 = this.requestMap.entrySet().iterator();
      if (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)((Map.Entry)localIterator1.next()).getValue()).iterator();
        for (localObject1 = localObject3;; localObject1 = ((StringBuilder)localObject3).toString())
        {
          localObject3 = localObject1;
          if (!localIterator2.hasNext()) {
            break;
          }
          localObject3 = (VideoRequest)localIterator2.next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(((VideoRequest)localObject3).toString());
          localObject1 = localStringBuilder.toString();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject1);
          ((StringBuilder)localObject3).append(",\n");
        }
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject3);
      ((StringBuilder)localObject1).append("]");
      localObject1 = ((StringBuilder)localObject1).toString();
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.VideoRequestManager
 * JD-Core Version:    0.7.0.1
 */