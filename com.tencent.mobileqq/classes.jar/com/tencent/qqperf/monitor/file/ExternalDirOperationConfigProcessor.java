package com.tencent.qqperf.monitor.file;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class ExternalDirOperationConfigProcessor
  extends IQConfigProcessor<ExternalDirOperationConfig>
{
  @NonNull
  public static ExternalDirOperationConfig a()
  {
    ExternalDirOperationConfig localExternalDirOperationConfig2 = (ExternalDirOperationConfig)QConfigManager.a().a(736);
    ExternalDirOperationConfig localExternalDirOperationConfig1 = localExternalDirOperationConfig2;
    if (localExternalDirOperationConfig2 == null) {
      localExternalDirOperationConfig1 = ExternalDirOperationConfig.a();
    }
    return localExternalDirOperationConfig1;
  }
  
  @NonNull
  public ExternalDirOperationConfig a(int paramInt)
  {
    return ExternalDirOperationConfig.a();
  }
  
  @Nullable
  public ExternalDirOperationConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onParsed:");
      localStringBuilder.append(paramArrayOfQConfItem[0].a);
      QLog.d("ExternalDirOperationConfigProcessor", 1, localStringBuilder.toString());
    }
    return ExternalDirOperationConfig.a(paramArrayOfQConfItem[0].a);
  }
  
  public void a(ExternalDirOperationConfig paramExternalDirOperationConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUpdate:");
    localStringBuilder.append(paramExternalDirOperationConfig);
    QLog.d("ExternalDirOperationConfigProcessor", 1, localStringBuilder.toString());
    ExternalDirOperationConfig.a(MobileQQ.getContext(), paramExternalDirOperationConfig.a);
  }
  
  public Class<ExternalDirOperationConfig> clazz()
  {
    return ExternalDirOperationConfig.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReqFailed:");
    localStringBuilder.append(paramInt);
    QLog.d("ExternalDirOperationConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 736;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.file.ExternalDirOperationConfigProcessor
 * JD-Core Version:    0.7.0.1
 */