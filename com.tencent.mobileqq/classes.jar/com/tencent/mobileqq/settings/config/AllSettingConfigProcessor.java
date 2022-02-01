package com.tencent.mobileqq.settings.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class AllSettingConfigProcessor
  extends IQConfigProcessor<AllSettingConfig>
{
  @NonNull
  public AllSettingConfig a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent, type: ");
    localStringBuilder.append(paramInt);
    QLog.d("AllSettingConfigProcessor", 2, localStringBuilder.toString());
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onUpdate, newConf = ");
    ((StringBuilder)localObject).append(paramAllSettingConfig);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.d("AllSettingConfigProcessor", 1, (String)localObject);
    localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      if (paramAllSettingConfig.a() != 1) {
        bool = false;
      }
      SettingsConfigHelper.a((QQAppInterface)localObject, bool);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReqFailed, failCode = ");
    localStringBuilder.append(paramInt);
    QLog.d("AllSettingConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 709;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.settings.config.AllSettingConfigProcessor
 * JD-Core Version:    0.7.0.1
 */