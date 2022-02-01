package com.tencent.mobileqq.settings.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class AllSettingConfigProcessor
  extends IQConfigProcessor<AllSettingConfig>
{
  @NonNull
  public AllSettingConfig a(int paramInt)
  {
    QLog.d("AllSettingConfigProcessor", 2, "migrateOldOrDefaultContent, type: " + paramInt);
    return new AllSettingConfig();
  }
  
  @Nullable
  public AllSettingConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return AllSettingConfig.a(paramArrayOfQConfItem[0].a);
    }
    return new AllSettingConfig();
  }
  
  public void a(AllSettingConfig paramAllSettingConfig)
  {
    boolean bool = true;
    QLog.d("AllSettingConfigProcessor", 1, "onUpdate, newConf = " + paramAllSettingConfig);
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      if (paramAllSettingConfig.a() != 1) {
        break label58;
      }
    }
    for (;;)
    {
      SettingsConfigHelper.a((QQAppInterface)localAppRuntime, bool);
      return;
      label58:
      bool = false;
    }
  }
  
  public Class<AllSettingConfig> clazz()
  {
    return AllSettingConfig.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    QLog.d("AllSettingConfigProcessor", 1, "onReqFailed, failCode = " + paramInt);
  }
  
  public int type()
  {
    return 709;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.settings.config.AllSettingConfigProcessor
 * JD-Core Version:    0.7.0.1
 */