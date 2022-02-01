package com.tencent.mobileqq.qqgift.api.impl;

import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class QQGiftManagerImpl
  implements IQQGiftManager
{
  private static final String TAG = "QQGiftManagerImpl";
  private ConcurrentHashMap<Integer, IQQGiftSDK> mSdkImpls = new ConcurrentHashMap();
  
  public void destroy()
  {
    Iterator localIterator = this.mSdkImpls.values().iterator();
    while (localIterator.hasNext()) {
      ((IQQGiftSDK)localIterator.next()).j();
    }
    this.mSdkImpls.clear();
  }
  
  public void destroySDKImpl(int paramInt)
  {
    IQQGiftSDK localIQQGiftSDK = (IQQGiftSDK)this.mSdkImpls.remove(Integer.valueOf(paramInt));
    if (localIQQGiftSDK != null) {
      localIQQGiftSDK.j();
    }
  }
  
  public IQQGiftSDK getSDKImpl(int paramInt)
  {
    IQQGiftSDK localIQQGiftSDK = (IQQGiftSDK)this.mSdkImpls.get(Integer.valueOf(paramInt));
    Object localObject = localIQQGiftSDK;
    if (localIQQGiftSDK == null)
    {
      localObject = new QQGiftSDKImpl();
      this.mSdkImpls.put(Integer.valueOf(paramInt), localObject);
    }
    return localObject;
  }
  
  public IQQGiftSDK removeSDKImpl(int paramInt)
  {
    return (IQQGiftSDK)this.mSdkImpls.remove(Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.impl.QQGiftManagerImpl
 * JD-Core Version:    0.7.0.1
 */