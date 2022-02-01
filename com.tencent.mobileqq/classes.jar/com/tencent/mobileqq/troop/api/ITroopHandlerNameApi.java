package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITroopHandlerNameApi
  extends QRouteApi
{
  public abstract String getTroopEssenceHandlerName();
  
  public abstract String getTroopGameHandlerName();
  
  public abstract String getTroopHonorHandlerName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopHandlerNameApi
 * JD-Core Version:    0.7.0.1
 */