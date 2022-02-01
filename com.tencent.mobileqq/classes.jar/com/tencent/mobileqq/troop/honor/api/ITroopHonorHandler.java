package com.tencent.mobileqq.troop.honor.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ITroopHonorHandler
  extends IRuntimeService
{
  public abstract void getHostTroopHonorList();
  
  public abstract void getHostTroopHonorList(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.api.ITroopHonorHandler
 * JD-Core Version:    0.7.0.1
 */