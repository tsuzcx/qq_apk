package com.tencent.mobileqq.imaxad;

import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;

public class ImaxAppInterface
  extends BaseToolAppInterface
{
  public ImaxAppInterface(MobileQQ paramMobileQQ, String paramString)
  {
    super(paramMobileQQ, paramString);
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAppInterface
 * JD-Core Version:    0.7.0.1
 */