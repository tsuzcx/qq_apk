package com.tencent.mobileqq.onlinestatus.manager;

import mqq.app.AppRuntime.Status;

public abstract interface IOnlineStatusDataManager
  extends IStatusManager
{
  public abstract void a(boolean paramBoolean, AppRuntime.Status paramStatus);
  
  public abstract void b(boolean paramBoolean);
  
  public abstract void d(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusDataManager
 * JD-Core Version:    0.7.0.1
 */