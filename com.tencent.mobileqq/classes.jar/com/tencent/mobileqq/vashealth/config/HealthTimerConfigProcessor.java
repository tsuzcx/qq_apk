package com.tencent.mobileqq.vashealth.config;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vashealth/config/HealthTimerConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/vashealth/config/HealthTimerConfigBean;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "isNeedUpgradeReset", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/vashealth/config/HealthTimerConfigBean;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "health-impl_release"}, k=1, mv={1, 1, 16})
public final class HealthTimerConfigProcessor
  extends IQConfigProcessor<HealthTimerConfigBean>
{
  public static final HealthTimerConfigProcessor.Companion a = new HealthTimerConfigProcessor.Companion(null);
  
  @JvmStatic
  @NotNull
  public static final HealthTimerConfigBean a()
  {
    return a.a();
  }
  
  @NotNull
  public HealthTimerConfigBean a(int paramInt)
  {
    return new HealthTimerConfigBean(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, false, 16383, null);
  }
  
  @Nullable
  public HealthTimerConfigBean a(@Nullable QConfItem[] paramArrayOfQConfItem)
  {
    if (paramArrayOfQConfItem != null)
    {
      paramArrayOfQConfItem = (QConfItem)ArraysKt.firstOrNull(paramArrayOfQConfItem);
      if (paramArrayOfQConfItem != null)
      {
        paramArrayOfQConfItem = paramArrayOfQConfItem.b;
        if (paramArrayOfQConfItem != null) {
          return HealthTimerConfigBean.a.a(paramArrayOfQConfItem);
        }
      }
    }
    return null;
  }
  
  public void a(@Nullable HealthTimerConfigBean paramHealthTimerConfigBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate newConf:");
      localStringBuilder.append(paramHealthTimerConfigBean);
      QLog.d("HealthLegacyConfigProcessor", 2, localStringBuilder.toString());
    }
  }
  
  @NotNull
  public Class<HealthTimerConfigBean> clazz()
  {
    return HealthTimerConfigBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
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
    localStringBuilder.append("onReqFailed, failCode:");
    localStringBuilder.append(paramInt);
    QLog.w("HealthLegacyConfigProcessor", 2, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 267;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.config.HealthTimerConfigProcessor
 * JD-Core Version:    0.7.0.1
 */