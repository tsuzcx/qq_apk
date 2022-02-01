package com.tencent.qzonehub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQzoneEventApi
  extends QRouteApi
{
  public abstract ClassLoader getLoader();
  
  public abstract IQzoneEventApi.ExoticEventInterface obtain(int paramInt, String paramString, Object paramObject);
  
  public abstract boolean onEventReceived(IQzoneEventApi.ExoticEventInterface paramExoticEventInterface);
  
  public abstract IQzoneEventApi.ExoticEventInterface pollEvent();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.IQzoneEventApi
 * JD-Core Version:    0.7.0.1
 */