package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class ArkConfProcessor$ArkAIKeyWordSDKShareConfigProcessor
  extends ArkConfProcessor
{
  public ArkConfBean a(String paramString)
  {
    QLog.d("ArkConfProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    try
    {
      ArkManageConfig.ArkAIKeyWordSDKShareConfig localArkAIKeyWordSDKShareConfig = (ArkManageConfig.ArkAIKeyWordSDKShareConfig)QStorage.a(paramString, ArkManageConfig.ArkAIKeyWordSDKShareConfig.class);
      return new ArkConfBean.ArkAIKeyWordSDKShareConfBean(paramString, localArkAIKeyWordSDKShareConfig);
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      for (;;)
      {
        QLog.i("ArkConfProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException);
        Object localObject = null;
      }
    }
  }
  
  public int type()
  {
    return 250;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.ArkConfProcessor.ArkAIKeyWordSDKShareConfigProcessor
 * JD-Core Version:    0.7.0.1
 */