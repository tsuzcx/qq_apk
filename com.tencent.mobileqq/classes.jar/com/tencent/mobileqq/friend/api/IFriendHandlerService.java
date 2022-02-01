package com.tencent.mobileqq.friend.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IFriendHandlerService
  extends IRuntimeService
{
  public abstract void addFriendGroup(byte paramByte, String paramString);
  
  public abstract void deleteFriendGroup(byte paramByte);
  
  public abstract boolean isRequestingFriendList();
  
  public abstract void renameFriendGroup(byte paramByte, String paramString);
  
  public abstract void requestFriendInfo(String paramString);
  
  public abstract void requestFriendList(boolean paramBoolean);
  
  public abstract void resortFriendGroup(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.friend.api.IFriendHandlerService
 * JD-Core Version:    0.7.0.1
 */