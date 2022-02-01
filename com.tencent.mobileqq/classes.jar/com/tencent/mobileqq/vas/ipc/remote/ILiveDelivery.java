package com.tencent.mobileqq.vas.ipc.remote;

import eipc.EIPCModule;
import eipc.EIPCResultCallback;
import java.io.Serializable;
import java.util.HashMap;

public abstract interface ILiveDelivery
{
  public abstract void followUin(String paramString, EIPCModule paramEIPCModule, int paramInt, EIPCResultCallback paramEIPCResultCallback);
  
  public abstract long getAccount();
  
  public abstract boolean isFollowUin(String paramString);
  
  public abstract boolean isWxInstall();
  
  public abstract void openChargePage();
  
  public abstract void openQQBrowser(String paramString);
  
  public abstract void openSchema(String paramString);
  
  public abstract void reportAction(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt1, int paramInt2);
  
  public abstract void reportStatistic(String paramString, HashMap<String, String> paramHashMap, long paramLong);
  
  public abstract void reportTianshu(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract void reqPendantInfo(int paramInt1, int paramInt2, Serializable paramSerializable, EIPCModule paramEIPCModule, int paramInt3, EIPCResultCallback paramEIPCResultCallback);
  
  public abstract void requestPbMsfSSO(String paramString1, String paramString2, EIPCModule paramEIPCModule, int paramInt, EIPCResultCallback paramEIPCResultCallback);
  
  public abstract void requestPbVSBase(String paramString1, String paramString2, EIPCModule paramEIPCModule, int paramInt, EIPCResultCallback paramEIPCResultCallback);
  
  public abstract void setAnchorIsLive(boolean paramBoolean);
  
  public abstract void setAudienceIsLive(boolean paramBoolean);
  
  public abstract void unfollowUin(String paramString, EIPCModule paramEIPCModule, int paramInt, EIPCResultCallback paramEIPCResultCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ipc.remote.ILiveDelivery
 * JD-Core Version:    0.7.0.1
 */