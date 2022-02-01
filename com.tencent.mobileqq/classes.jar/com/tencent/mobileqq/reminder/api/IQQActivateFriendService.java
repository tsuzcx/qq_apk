package com.tencent.mobileqq.reminder.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IQQActivateFriendService
  extends IRuntimeService
{
  public abstract boolean getSwitchValue(boolean paramBoolean);
  
  public abstract void setSwtichValue(boolean paramBoolean1, boolean paramBoolean2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.IQQActivateFriendService
 * JD-Core Version:    0.7.0.1
 */