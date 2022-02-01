package com.tencent.mobileqq.qqgift.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQGiftDataStore
  extends QRouteApi
{
  public abstract void clear();
  
  public abstract String getSceneId();
  
  public abstract void setSceneId(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.IQQGiftDataStore
 * JD-Core Version:    0.7.0.1
 */