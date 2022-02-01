package com.tencent.mobileqq.troop.fans.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.troop.fans.data.TroopFansInfo.IdolItem;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopFansService
  extends IRuntimeService
{
  public abstract TroopFansInfo.IdolItem getTroopIdolInfoDate(String paramString);
  
  public abstract void setTroopIdolInfoDate(String paramString, TroopFansInfo.IdolItem paramIdolItem);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.fans.api.ITroopFansService
 * JD-Core Version:    0.7.0.1
 */