package com.tencent.mobileqq.profilecard.bussiness.anonymous.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IAnonymousService
  extends IRuntimeService
{
  public abstract boolean getSettingMeRedPointEnable();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.anonymous.api.IAnonymousService
 * JD-Core Version:    0.7.0.1
 */