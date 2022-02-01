package com.tencent.mobileqq.config.business;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class ArkConfProcessor$ArkAIDictConfigProcessor
  extends ArkConfProcessor
{
  public ArkConfBean a(String paramString)
  {
    QLog.d("ArkAIDictConfigProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    try
    {
      ArkManageConfig.AIDictConfig localAIDictConfig = (ArkManageConfig.AIDictConfig)QStorage.a(paramString, ArkManageConfig.AIDictConfig.class);
      return new ArkConfBean.ArkAIDictConfBean(paramString, localAIDictConfig);
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      for (;;)
      {
        QLog.i("ArkAIDictConfigProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException);
        Object localObject = null;
      }
    }
  }
  
  public void a(ArkConfBean paramArkConfBean)
  {
    super.a(paramArkConfBean);
    if (paramArkConfBean == null) {
      QLog.i("ArkAIDictConfigProcessor", 1, "newConf is null");
    }
    do
    {
      do
      {
        do
        {
          return;
          QLog.d("ArkAIDictConfigProcessor", 1, "[onUpdate] type=" + type() + ", content = " + paramArkConfBean.a());
          paramArkConfBean = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        } while (paramArkConfBean == null);
        paramArkConfBean = (ArkAppCenter)paramArkConfBean.getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
      } while (paramArkConfBean == null);
      paramArkConfBean = paramArkConfBean.a();
    } while (paramArkConfBean == null);
    paramArkConfBean.a();
  }
  
  public int type()
  {
    return 170;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.ArkConfProcessor.ArkAIDictConfigProcessor
 * JD-Core Version:    0.7.0.1
 */