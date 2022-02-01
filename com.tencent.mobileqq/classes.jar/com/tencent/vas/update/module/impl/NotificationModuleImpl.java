package com.tencent.vas.update.module.impl;

import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import com.tencent.vas.update.module.api.INotificationModule;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class NotificationModuleImpl
  implements INotificationModule
{
  private final ConcurrentHashMap<Long, IBusinessCallback> a = new ConcurrentHashMap();
  private IBusinessCallback b;
  
  public IBusinessCallback a(long paramLong)
  {
    if (this.a.get(Long.valueOf(paramLong)) != null) {
      return (IBusinessCallback)this.a.get(Long.valueOf(paramLong));
    }
    return this.b;
  }
  
  public <T extends IBusinessCallback> T a(Class<T> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    Object localObject1 = this.b;
    if ((localObject1 != null) && (localObject1.getClass() == paramClass)) {
      return this.b;
    }
    localObject1 = this.a.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if (((Map.Entry)localObject2).getValue() != null)
      {
        localObject2 = (IBusinessCallback)((Map.Entry)localObject2).getValue();
        if (localObject2.getClass() == paramClass) {
          return localObject2;
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    this.a.clear();
    this.b = null;
  }
  
  public void a(long paramLong, IBusinessCallback paramIBusinessCallback)
  {
    if (paramIBusinessCallback != null)
    {
      this.a.put(Long.valueOf(paramLong), paramIBusinessCallback);
      return;
    }
    throw new NullPointerException();
  }
  
  public void a(IBusinessCallback paramIBusinessCallback)
  {
    try
    {
      this.b = paramIBusinessCallback;
      return;
    }
    finally
    {
      paramIBusinessCallback = finally;
      throw paramIBusinessCallback;
    }
  }
  
  public void a(@NonNull BusinessUpdateParams paramBusinessUpdateParams)
  {
    IBusinessCallback localIBusinessCallback = a(paramBusinessUpdateParams.mBid);
    if (localIBusinessCallback == null) {
      return;
    }
    UpdateListenerParams localUpdateListenerParams = new UpdateListenerParams();
    localUpdateListenerParams.mBusinessUpdateParams = paramBusinessUpdateParams;
    localIBusinessCallback.onLoadSuccess(localUpdateListenerParams);
  }
  
  public void a(@NonNull BusinessUpdateParams paramBusinessUpdateParams, int paramInt1, int paramInt2, String paramString)
  {
    IBusinessCallback localIBusinessCallback = a(paramBusinessUpdateParams.mBid);
    if (localIBusinessCallback == null) {
      return;
    }
    UpdateListenerParams localUpdateListenerParams = new UpdateListenerParams();
    localUpdateListenerParams.mBusinessUpdateParams = paramBusinessUpdateParams;
    localUpdateListenerParams.mErrorCode = paramInt1;
    localUpdateListenerParams.mErrorMessage = paramString;
    localUpdateListenerParams.mHttpCode = paramInt2;
    localIBusinessCallback.onLoadFail(localUpdateListenerParams);
  }
  
  public void a(@NonNull BusinessUpdateParams paramBusinessUpdateParams, long paramLong1, long paramLong2, int paramInt)
  {
    IBusinessCallback localIBusinessCallback = a(paramBusinessUpdateParams.mBid);
    if (localIBusinessCallback == null) {
      return;
    }
    UpdateListenerParams localUpdateListenerParams = new UpdateListenerParams();
    localUpdateListenerParams.mBusinessUpdateParams = paramBusinessUpdateParams;
    localUpdateListenerParams.mProgress = paramLong1;
    localUpdateListenerParams.mProgressMax = paramLong2;
    localUpdateListenerParams.mProgressRate = paramInt;
    localIBusinessCallback.onProgress(localUpdateListenerParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.module.impl.NotificationModuleImpl
 * JD-Core Version:    0.7.0.1
 */