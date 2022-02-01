package com.tencent.mobileqq.relation.api.impl;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.relation.api.IFriendHandlerTempService;
import mqq.app.AppRuntime;

public class FriendHandlerTempServiceImpl
  implements IFriendHandlerTempService
{
  private FriendListHandler mFriendListHandler;
  
  public void getFriendInfo(String paramString)
  {
    this.mFriendListHandler.getFriendInfo(paramString);
  }
  
  public void getFriendInfo(String paramString, boolean paramBoolean)
  {
    this.mFriendListHandler.getFriendInfo(paramString, paramBoolean);
  }
  
  public void getOnlineInfo(String paramString, boolean paramBoolean)
  {
    this.mFriendListHandler.getOnlineInfo(paramString, paramBoolean);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mFriendListHandler = ((FriendListHandler)((QQAppInterface)paramAppRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.impl.FriendHandlerTempServiceImpl
 * JD-Core Version:    0.7.0.1
 */