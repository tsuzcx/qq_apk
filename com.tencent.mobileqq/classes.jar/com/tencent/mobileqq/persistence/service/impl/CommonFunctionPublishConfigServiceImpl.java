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
    return CommonFunctionPublishConfigProcessor.a().f;
  }
  
  public boolean isIgnoreInvalidUnreadMark()
  {
    boolean bool = CommonFunctionPublishConfigProcessor.a().h;
    if (QLog.isColorLevel()) {
      QLog.d("CommonFunctionPublishConfigServiceImpl", 2, new Object[] { "isIgnoreInvalidUnreadMark switch value: ", Boolean.valueOf(bool) });
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
    return CommonFunctionPublishConfigProcessor.a().c;
  }
  
  public boolean isTuringRiskDetectEnable()
  {
    boolean bool = CommonFunctionPublishConfigProcessor.a().i;
    if (QLog.isColorLevel()) {
      QLog.d("CommonFunctionPublishConfigServiceImpl", 2, new Object[] { "isTuringRiskDetectEnable switch value: ", Boolean.valueOf(bool) });
    }
    return bool;
  }
  
  public boolean isUseNewInvalidUnreadMarkThreshold()
  {
    return CommonFunctionPublishConfigProcessor.a().d;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.service.impl.CommonFunctionPublishConfigServiceImpl
 * JD-Core Version:    0.7.0.1
 */