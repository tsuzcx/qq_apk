package com.tencent.mobileqq.troop.api.troopcreate;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopCreateConfig
  extends IRuntimeService
{
  public abstract boolean isShow3KTroopTips();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopcreate.ITroopCreateConfig
 * JD-Core Version:    0.7.0.1
 */