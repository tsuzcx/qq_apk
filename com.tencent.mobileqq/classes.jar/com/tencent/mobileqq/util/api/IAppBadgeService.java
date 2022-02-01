package com.tencent.mobileqq.util.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IAppBadgeService
  extends IRuntimeService
{
  public abstract void refreshAppBadge();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.api.IAppBadgeService
 * JD-Core Version:    0.7.0.1
 */