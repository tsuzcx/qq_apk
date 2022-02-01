package com.tencent.mobileqq.persistence.service.impl;

import com.tencent.mobileqq.persistence.CommonFunctionPublishConfigProcessor;
import com.tencent.mobileqq.persistence.CommonFunctionPublishConfigProcessor.Config;
import com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService;
import com.tencent.qphone.base.util.QLog;

public class CommonFunctionPublishConfigServiceImpl
  implements ICommonFunctionPublishConfigService
{
  private static final String TAG = "CommonFunctionPublishConfigServiceImpl";
  
  public boolean isCopyDBCommandEnable()
  {
    boolean bool = CommonFunctionPublishConfigProcessor.a().f;
    if (QLog.isColorLevel()) {
      QLog.d("CommonFunctionPublishConfigServiceImpl", 2, new Object[] { "copyDBCommandEnable switch value: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public boolean isLocalized()
  {
    boolean bool = CommonFunctionPublishConfigProcessor.a().a;
    if (QLog.isColorLevel()) {
      QLog.d("CommonFunctionPublishConfigServiceImpl", 2, new Object[] { "isLocalized switch value: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public boolean isNewUnreadCountEnable()
  {
    boolean bool = CommonFunctionPublishConfigProcessor.a().c;
    if (QLog.isColorLevel()) {
      QLog.d("CommonFunctionPublishConfigServiceImpl", 2, new Object[] { "newUnreadCountEnable switch value: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public boolean isUseNewInvalidUnreadMarkThreshold()
  {
    boolean bool = CommonFunctionPublishConfigProcessor.a().d;
    if (QLog.isColorLevel()) {
      QLog.d("CommonFunctionPublishConfigServiceImpl", 2, new Object[] { "newInvalidUnreadMarkThreshold switch value: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public boolean isWalEnable()
  {
    boolean bool = CommonFunctionPublishConfigProcessor.a().b;
    if (QLog.isColorLevel()) {
      QLog.d("CommonFunctionPublishConfigServiceImpl", 2, new Object[] { "isWalEnable switch value: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.service.impl.CommonFunctionPublishConfigServiceImpl
 * JD-Core Version:    0.7.0.1
 */