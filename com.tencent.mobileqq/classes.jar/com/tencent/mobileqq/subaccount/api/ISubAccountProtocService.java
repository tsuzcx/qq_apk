package com.tencent.mobileqq.subaccount.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface ISubAccountProtocService
  extends IRuntimeService
{
  public abstract void bindAccount(String paramString1, String paramString2, String paramString3);
  
  public abstract void getBindAccount();
  
  public abstract boolean getBindAccountFinish();
  
  public abstract void unBindAccount(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.api.ISubAccountProtocService
 * JD-Core Version:    0.7.0.1
 */