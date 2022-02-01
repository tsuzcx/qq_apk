package com.tencent.mobileqq.mqq.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAccountRuntime
  extends QRouteApi
{
  public abstract String getA2();
  
  public abstract String getAccount();
  
  public abstract Context getApplicationContext();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mqq.api.IAccountRuntime
 * JD-Core Version:    0.7.0.1
 */