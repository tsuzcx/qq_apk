package com.tencent.vas.update.module;

import androidx.annotation.NonNull;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.entity.UpdateListenerParams;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class NotificationModule
{
  private IBusinessCallback mDefaultBusinessCallback;
  private final ConcurrentHashMap<Long, IBusinessCallback> mObs = new ConcurrentHashMap();
  
  public void addObserver(Long paramLong, IBusinessCallback paramIBusinessCallback)
  {
    if (paramIBusinessCallback == null) {
      throw new NullPointerException();
    }
    this.mObs.put(paramLong, paramIBusinessCallback);
  }
  
  public void clearObservers()
  {
    this.mObs.clear();
    this.mDefaultBusinessCallback = null;
  }
  
  public void deleteObserver(Long paramLong)
  {
    this.mObs.remove(paramLong);
  }
  
  public <T extends IBusinessCallback> T getObserver(Class<T> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    if ((this.mDefaultBusinessCallback != null) && (this.mDefaultBusinessCallback.getClass() == paramClass)) {
      return this.mDefaultBusinessCallback;
    }
    Iterator localIterator = this.mObs.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (((Map.Entry)localObject).getValue() != null)
      {
        localObject = (IBusinessCallback)((Map.Entry)localObject).getValue();
        if (localObject.getClass() == paramClass) {
          return localObject;
        }
      }
    }
    return null;
  }
  
  public IBusinessCallback getObserver(Long paramLong)
  {
    if (this.mObs.get(paramLong) != null) {
      return (IBusinessCallback)this.mObs.get(paramLong);
    }
    return this.mDefaultBusinessCallback;
  }
  
  public void notifyFailure(@NonNull BusinessUpdateParams paramBusinessUpdateParams, int paramInt1, int paramInt2, String paramString)
  {
    IBusinessCallback localIBusinessCallback = getObserver(Long.valueOf(paramBusinessUpdateParams.mBid));
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
  
  public void notifyFailure(BusinessUpdateParams paramBusinessUpdateParams, int paramInt, String paramString)
  {
    notifyFailure(paramBusinessUpdateParams, paramInt, 0, paramString);
  }
  
  public void notifyProgress(@NonNull BusinessUpdateParams paramBusinessUpdateParams, long paramLong1, long paramLong2, int paramInt)
  {
    IBusinessCallback localIBusinessCallback = getObserver(Long.valueOf(paramBusinessUpdateParams.mBid));
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
  
  public void notifySuccess(@NonNull BusinessUpdateParams paramBusinessUpdateParams)
  {
    IBusinessCallback localIBusinessCallback = getObserver(Long.valueOf(paramBusinessUpdateParams.mBid));
    if (localIBusinessCallback == null) {
      return;
    }
    UpdateListenerParams localUpdateListenerParams = new UpdateListenerParams();
    localUpdateListenerParams.mBusinessUpdateParams = paramBusinessUpdateParams;
    localIBusinessCallback.onLoadSuccess(localUpdateListenerParams);
  }
  
  public void setDefaultCallback(IBusinessCallback paramIBusinessCallback)
  {
    try
    {
      this.mDefaultBusinessCallback = paramIBusinessCallback;
      return;
    }
    finally
    {
      paramIBusinessCallback = finally;
      throw paramIBusinessCallback;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.module.NotificationModule
 * JD-Core Version:    0.7.0.1
 */