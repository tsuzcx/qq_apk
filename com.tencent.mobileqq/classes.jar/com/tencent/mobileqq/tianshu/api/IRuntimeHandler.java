package com.tencent.mobileqq.tianshu.api;

import mqq.app.api.IRuntimeService;

public abstract interface IRuntimeHandler
  extends IRuntimeService
{
  public abstract String getClassName();
  
  public abstract void notifyUI(int paramInt, boolean paramBoolean, Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.IRuntimeHandler
 * JD-Core Version:    0.7.0.1
 */