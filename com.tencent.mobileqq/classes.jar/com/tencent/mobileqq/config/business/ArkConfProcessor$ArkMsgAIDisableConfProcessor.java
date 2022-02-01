package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class ArkConfProcessor$ArkMsgAIDisableConfProcessor
  extends ArkConfProcessor
{
  public ArkConfBean a(String paramString)
  {
    QLog.d("ArkMsgAIDisableConfProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    try
    {
      ArkManageConfig.ArkMsgAIDisableConfig localArkMsgAIDisableConfig = (ArkManageConfig.ArkMsgAIDisableConfig)QStorage.a(paramString, ArkManageConfig.ArkMsgAIDisableConfig.class);
      return new ArkConfBean.ArkMsgAIDisableConfBean(paramString, localArkMsgAIDisableConfig);
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      for (;;)
      {
        QLog.i("ArkMsgAIDisableConfProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException);
        Object localObject = null;
      }
    }
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public int type()
  {
    return 159;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.ArkConfProcessor.ArkMsgAIDisableConfProcessor
 * JD-Core Version:    0.7.0.1
 */