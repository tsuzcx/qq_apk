package com.tencent.qzonehub.api.impl;

import com.tencent.qzonehub.api.IQzoneEventApi;
import com.tencent.qzonehub.api.IQzoneEventApi.ExoticEventInterface;
import cooperation.qzone.event.ExoticEvent;
import cooperation.qzone.event.ExoticEventPool;

public class QzoneEventApiImpl
  implements IQzoneEventApi
{
  public ClassLoader getLoader()
  {
    return ExoticEvent.getLoader();
  }
  
  public IQzoneEventApi.ExoticEventInterface obtain(int paramInt, String paramString, Object paramObject)
  {
    return ExoticEvent.obtain(paramInt, paramString, paramObject);
  }
  
  public boolean onEventReceived(IQzoneEventApi.ExoticEventInterface paramExoticEventInterface)
  {
    return ExoticEventPool.getInstance().onEventReceived(paramExoticEventInterface);
  }
  
  public IQzoneEventApi.ExoticEventInterface pollEvent()
  {
    return ExoticEventPool.getInstance().pollEvent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzoneEventApiImpl
 * JD-Core Version:    0.7.0.1
 */