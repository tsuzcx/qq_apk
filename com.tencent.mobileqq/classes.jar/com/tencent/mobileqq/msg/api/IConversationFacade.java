package com.tencent.mobileqq.msg.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IConversationFacade
  extends IRuntimeService
{
  public abstract int getReadUnreadMark(String paramString, int paramInt);
  
  public abstract int getUnreadCount(String paramString, int paramInt);
  
  public abstract void setUnreadMark(String paramString, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.IConversationFacade
 * JD-Core Version:    0.7.0.1
 */