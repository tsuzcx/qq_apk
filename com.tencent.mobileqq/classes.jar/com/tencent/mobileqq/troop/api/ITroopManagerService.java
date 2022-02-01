package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopManagerService
  extends IRuntimeService
{
  public abstract void deleteTroop(String paramString);
  
  public abstract byte[] getTroopAppListData(String paramString);
  
  public abstract int getTroopMask(String paramString);
  
  public abstract void getTroopsMemberList();
  
  public abstract void handleTroopMemberNewLevelChange(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  public abstract void setTroopAppListData(String paramString, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopManagerService
 * JD-Core Version:    0.7.0.1
 */