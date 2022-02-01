package com.tencent.mobileqq.troop.api.impl;

import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;

public class TroopMemberApiClientApiImpl
  implements ITroopMemberApiClientApi
{
  private TroopMemberApiClient mClient = null;
  
  public void clearHomeworkTroopRedPoint(String paramString1, String paramString2)
  {
    this.mClient.h(paramString1, paramString2);
  }
  
  public void doBindService()
  {
    this.mClient.e();
  }
  
  public void doUnbindService()
  {
    this.mClient.e();
  }
  
  public void getTroopFileStatusInfo(long paramLong1, String paramString1, String paramString2, long paramLong2, int paramInt, ITroopMemberApiClientApi.Callback paramCallback)
  {
    this.mClient.a(paramLong1, paramString1, paramString2, paramLong2, paramInt, paramCallback);
  }
  
  public void openLocalFilePreview(String paramString1, String paramString2)
  {
    this.mClient.e(paramString1, paramString2);
  }
  
  public void studyRoomPicUpload(String paramString, ITroopMemberApiClientApi.Callback paramCallback)
  {
    this.mClient.e(paramString, paramCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopMemberApiClientApiImpl
 * JD-Core Version:    0.7.0.1
 */