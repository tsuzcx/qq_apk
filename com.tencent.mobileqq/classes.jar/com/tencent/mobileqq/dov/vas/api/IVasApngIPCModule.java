package com.tencent.mobileqq.dov.vas.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IVasApngIPCModule
  extends QRouteApi
{
  public abstract void download();
  
  public abstract boolean loadSoLib();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dov.vas.api.IVasApngIPCModule
 * JD-Core Version:    0.7.0.1
 */