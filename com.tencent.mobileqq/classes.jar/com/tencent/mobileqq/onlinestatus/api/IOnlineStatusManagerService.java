package com.tencent.mobileqq.onlinestatus.api;

import com.tencent.mobileqq.onlinestatus.manager.IStatusManager;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={""})
public abstract interface IOnlineStatusManagerService
  extends IRuntimeService
{
  public abstract <T extends IStatusManager> T getManager(Class<T> paramClass);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService
 * JD-Core Version:    0.7.0.1
 */