package com.tencent.mobileqq.troop.api.troopcreate;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IQQBase
  extends IRuntimeService
{
  public abstract String getAccountNickName(AppInterface paramAppInterface, String paramString);
  
  public abstract int getAnimationTypeR2L();
  
  public abstract int getBackButtonSideL();
  
  public abstract String getHeaderText(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopcreate.IQQBase
 * JD-Core Version:    0.7.0.1
 */