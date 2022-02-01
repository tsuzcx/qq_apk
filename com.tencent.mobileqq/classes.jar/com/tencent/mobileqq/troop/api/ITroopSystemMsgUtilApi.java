package com.tencent.mobileqq.troop.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITroopSystemMsgUtilApi
  extends QRouteApi
{
  public abstract long getTroopFlagExtFromSP(Context paramContext, String paramString);
  
  public abstract String getTroopNameFromSP(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi
 * JD-Core Version:    0.7.0.1
 */