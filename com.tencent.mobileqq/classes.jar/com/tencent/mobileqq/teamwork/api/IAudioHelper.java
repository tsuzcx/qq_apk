package com.tencent.mobileqq.teamwork.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IAudioHelper
  extends QRouteApi
{
  public static final int index_Show_Doc_Tip = 10;
  public static final int value_true = 1;
  
  public abstract int getDebugValue(int paramInt);
  
  public abstract boolean isDev();
  
  public abstract void writeTestLog(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.IAudioHelper
 * JD-Core Version:    0.7.0.1
 */