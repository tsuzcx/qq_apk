package com.tencent.mobileqq.reminder.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IQQActivateFriendService
  extends IRuntimeService
{
  public abstract boolean getSwitchValue(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.IQQActivateFriendService
 * JD-Core Version:    0.7.0.1
 */