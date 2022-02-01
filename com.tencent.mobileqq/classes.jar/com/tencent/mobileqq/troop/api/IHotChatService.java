package com.tencent.mobileqq.troop.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IHotChatService
  extends IRuntimeService
{
  public abstract int getHotChatDrawableID(String paramString, AppInterface paramAppInterface);
  
  public abstract String getHotChatName(String paramString);
  
  public abstract boolean isHotChat(String paramString);
  
  public abstract boolean isRobotHotChat(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.IHotChatService
 * JD-Core Version:    0.7.0.1
 */