package com.tencent.mobileqq.onlinestatus.manager;

import mqq.app.AppRuntime.Status;

public abstract interface IOnlineStatusDataManager
  extends IStatusManager
{
  public abstract void a(long paramLong);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, AppRuntime.Status paramStatus);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusDataManager
 * JD-Core Version:    0.7.0.1
 */