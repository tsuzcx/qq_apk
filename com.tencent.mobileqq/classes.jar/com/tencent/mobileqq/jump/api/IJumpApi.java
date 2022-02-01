package com.tencent.mobileqq.jump.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IJumpApi
  extends QRouteApi
{
  public abstract void doJumpAction(Context paramContext, String paramString);
  
  public abstract String getJumpActionQCircle();
  
  public abstract Class getJumpActivityClass();
  
  public abstract String getQCircleSchemeFromJumpUtil(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jump.api.IJumpApi
 * JD-Core Version:    0.7.0.1
 */