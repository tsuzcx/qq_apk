package com.tencent.mobileqq.troop.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITroopSystemMsgUtilApi
  extends QRouteApi
{
  public abstract String getTroopAnswerFromSP(Context paramContext, String paramString);
  
  public abstract long getTroopFlagExtFromSP(Context paramContext, String paramString);
  
  public abstract String getTroopNameFromSP(Context paramContext, String paramString);
  
  public abstract String getTroopQuestionFromSP(Context paramContext, String paramString);
  
  public abstract void saveTroopAnswerToSP(Context paramContext, String paramString1, String paramString2);
  
  public abstract void saveTroopFlagExToSP(Context paramContext, String paramString, long paramLong);
  
  public abstract void saveTroopNameToSP(Context paramContext, String paramString1, String paramString2);
  
  public abstract void saveTroopOptionToSP(Context paramContext, String paramString, int paramInt);
  
  public abstract void saveTroopQuestionToSP(Context paramContext, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi
 * JD-Core Version:    0.7.0.1
 */