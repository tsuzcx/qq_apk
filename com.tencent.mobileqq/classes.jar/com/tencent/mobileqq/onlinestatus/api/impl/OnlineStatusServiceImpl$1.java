package com.tencent.mobileqq.onlinestatus.api.impl;

import mqq.app.AppRuntime.Status;
import mqq.observer.AccountObserver;

class OnlineStatusServiceImpl$1
  extends AccountObserver
{
  OnlineStatusServiceImpl$1(OnlineStatusServiceImpl paramOnlineStatusServiceImpl) {}
  
  protected void onOnlineStatusChanged(boolean paramBoolean1, AppRuntime.Status paramStatus, long paramLong1, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4)
  {
    this.a.setOnlineStatus(paramStatus);
    this.a.setExtOnlineStatus(paramLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.api.impl.OnlineStatusServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */