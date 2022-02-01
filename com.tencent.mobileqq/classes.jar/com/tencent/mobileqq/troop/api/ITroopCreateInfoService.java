package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.annotation.PluginInterface;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.data.TroopCreateInfo;
import mqq.app.api.IRuntimeService;

@Service(process={""})
@PluginInterface
public abstract interface ITroopCreateInfoService
  extends IRuntimeService
{
  public static final int CREATE_TYPE_ADVANCE = 1;
  public static final int CREATE_TYPE_DO_CREATE = 2;
  
  public abstract void clearTroopCreateInfo();
  
  public abstract void deleteInInviteList(String paramString1, String paramString2);
  
  public abstract TroopCreateInfo getTroopCreateInfo();
  
  public abstract boolean isInInviteList(String paramString1, String paramString2);
  
  public abstract void refreshCreateInfo(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.ITroopCreateInfoService
 * JD-Core Version:    0.7.0.1
 */