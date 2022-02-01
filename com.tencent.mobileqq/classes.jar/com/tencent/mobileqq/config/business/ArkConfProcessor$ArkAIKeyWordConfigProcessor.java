package com.tencent.mobileqq.config.business;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class ArkConfProcessor$ArkAIKeyWordConfigProcessor
  extends ArkConfProcessor
{
  public ArkConfBean a(String paramString)
  {
    QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    for (;;)
    {
      try
      {
        ArkManageConfig.AiKeywordConfig localAiKeywordConfig = (ArkManageConfig.AiKeywordConfig)QStorage.a(paramString, ArkManageConfig.AiKeywordConfig.class);
        ArkManageConfig.DialogConfig localDialogConfig;
        QLog.i("ArkAIKeyWordConfigProcessor", 1, "loadConfig:" + paramString + "fail", localQStorageInstantiateException1);
      }
      catch (QStorageInstantiateException localQStorageInstantiateException1)
      {
        try
        {
          localDialogConfig = (ArkManageConfig.DialogConfig)QStorage.a(paramString, ArkManageConfig.DialogConfig.class);
          return new ArkConfBean.ArkAIKeyWordConfBean(paramString, localAiKeywordConfig, localDialogConfig);
        }
        catch (QStorageInstantiateException localQStorageInstantiateException2)
        {
          Object localObject;
          break label71;
        }
        localQStorageInstantiateException1 = localQStorageInstantiateException1;
        localAiKeywordConfig = null;
      }
      label71:
      localObject = null;
    }
  }
  
  public void a(ArkConfBean paramArkConfBean)
  {
    super.a(paramArkConfBean);
    if (paramArkConfBean == null) {
      QLog.i("ArkAIKeyWordConfigProcessor", 1, "newConf is null");
    }
    ArkAiAppCenter localArkAiAppCenter;
    do
    {
      return;
      QLog.d("ArkAIKeyWordConfigProcessor", 1, "[onUpdate] type=" + type() + ", content = " + paramArkConfBean.a());
      localArkAiAppCenter = ((ArkAppCenter)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER)).a();
      paramArkConfBean = paramArkConfBean.a();
    } while (paramArkConfBean == null);
    localArkAiAppCenter.a(paramArkConfBean.a());
  }
  
  public int type()
  {
    return 186;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.ArkConfProcessor.ArkAIKeyWordConfigProcessor
 * JD-Core Version:    0.7.0.1
 */