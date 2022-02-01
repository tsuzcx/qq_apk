package com.tencent.mobileqq.troop.api.troopcreate;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface ITroopCreateForStructMsg
  extends QRouteApi
{
  public abstract boolean instanceofImgaeShare();
  
  public abstract void onDestroy();
  
  public abstract void sendStructingMsg(AppRuntime paramAppRuntime, String paramString, int paramInt, BusinessObserver paramBusinessObserver);
  
  public abstract void setAbsStructMsgFromByte(byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateForStructMsg
 * JD-Core Version:    0.7.0.1
 */