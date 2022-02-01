package com.tencent.mobileqq.enterpriseqq.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IEnterpriseQQService
  extends IRuntimeService
{
  public abstract void getMenuFromNet(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.enterpriseqq.api.IEnterpriseQQService
 * JD-Core Version:    0.7.0.1
 */