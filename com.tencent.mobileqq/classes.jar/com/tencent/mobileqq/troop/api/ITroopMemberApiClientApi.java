package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITroopMemberApiClientApi
  extends QRouteApi
{
  public abstract void clearHomeworkTroopRedPoint(String paramString1, String paramString2);
  
  public abstract void doBindService();
  
  public abstract void doUnbindService();
  
  public abstract void getTroopFileStatusInfo(long paramLong1, String paramString1, String paramString2, long paramLong2, int paramInt, ITroopMemberApiClientApi.Callback paramCallback);
  
  public abstract void openLocalFilePreview(String paramString1, String paramString2);
  
  public abstract void studyRoomPicUpload(String paramString, ITroopMemberApiClientApi.Callback paramCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi
 * JD-Core Version:    0.7.0.1
 */