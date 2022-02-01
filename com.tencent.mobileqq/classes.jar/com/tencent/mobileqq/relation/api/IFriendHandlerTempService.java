package com.tencent.mobileqq.relation.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IFriendHandlerTempService
  extends IRuntimeService
{
  public abstract void getFriendInfo(String paramString);
  
  public abstract void getFriendInfo(String paramString, boolean paramBoolean);
  
  public abstract void getOnlineInfo(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.IFriendHandlerTempService
 * JD-Core Version:    0.7.0.1
 */