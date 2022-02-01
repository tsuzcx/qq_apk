package com.tencent.mobileqq.config.business;

import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.mobileqq.ark.ArkAppCrashProtect;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class ArkConfProcessor$ArkPlatformConfProcessor
  extends ArkConfProcessor
{
  public ArkConfBean a(String paramString)
  {
    QLog.d("ArkPlatformConfProcessor", 1, "[onParsed] type=" + type() + ", content = " + paramString);
    try
    {
      ArkManageConfig.ArkPlatformConfig localArkPlatformConfig = (ArkManageConfig.ArkPlatformConfig)QStorage.a(paramString, ArkManageConfig.ArkPlatformConfig.class);
      return new ArkConfBean.ArkPlatformConfigBean(paramString, localArkPlatformConfig);
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      for (;;)
      {
        QLog.i("ArkPlatformConfProcessor", 1, "readJsonOrXml:" + paramString + "fail", localQStorageInstantiateException);
        Object localObject = null;
      }
    }
  }
  
  public void a(ArkConfBean paramArkConfBean)
  {
    super.a(paramArkConfBean);
    if (paramArkConfBean == null) {
      QLog.i("ArkPlatformConfProcessor", 1, "newConf is null");
    }
    do
    {
      return;
      QLog.d("ArkPlatformConfProcessor", 1, "[onUpdate] type=" + type() + ", content = " + paramArkConfBean.a());
      paramArkConfBean = paramArkConfBean.a();
      ArkAppCrashProtect.a();
    } while ((paramArkConfBean == null) || (paramArkConfBean.a() == null));
    paramArkConfBean = paramArkConfBean.a();
    if (paramArkConfBean == null)
    {
      QLog.i("ArkPlatformConfProcessor", 2, "ArkSafe.updateUrlCheckAndCleanAppUpdateTime error config is null");
      return;
    }
    ArkAppConfigMgr.getInstance().updateUrlCheckAndCleanAppUpdateTime(paramArkConfBean.jdField_a_of_type_Boolean, paramArkConfBean.b, paramArkConfBean.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public int type()
  {
    return 380;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.ArkConfProcessor.ArkPlatformConfProcessor
 * JD-Core Version:    0.7.0.1
 */