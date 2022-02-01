package com.tencent.mobileqq.troop.api.troopcreate;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopCreateGrayMsg
  extends IRuntimeService
{
  public abstract void addCreateNewTroopGrayTips(String paramString1, boolean paramBoolean, String paramString2);
  
  public abstract void addTroopCreatedGrayTipsMr(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateGrayMsg
 * JD-Core Version:    0.7.0.1
 */