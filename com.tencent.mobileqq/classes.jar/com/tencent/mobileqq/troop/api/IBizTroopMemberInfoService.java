package com.tencent.mobileqq.troop.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IBizTroopMemberInfoService
  extends IRuntimeService
{
  public abstract boolean saveTroopMemberGlamourLevel(String paramString1, String paramString2, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService
 * JD-Core Version:    0.7.0.1
 */