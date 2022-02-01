package com.tencent.mobileqq.troop.homework.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class PublishHwkThirdPartyEntryConfigProcessor
  extends IQConfigProcessor<PublishHwkThirdPartyEntryConfig>
{
  @NonNull
  public PublishHwkThirdPartyEntryConfig a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent, type: ");
    localStringBuilder.append(paramInt);
    QLog.d("PublishHwkThirdPartyEntryConfig.config", 2, localStringBuilder.toString());
    return new PublishHwkThirdPartyEntryConfig();
  }
  
  @Nullable
  public PublishHwkThirdPartyEntryConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return PublishHwkThirdPartyEntryConfig.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(PublishHwkThirdPartyEntryConfig paramPublishHwkThirdPartyEntryConfig) {}
  
  public Class<PublishHwkThirdPartyEntryConfig> clazz()
  {
    return PublishHwkThirdPartyEntryConfig.class;
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
    QLog.d("PublishHwkThirdPartyEntryConfig.config", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 605;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.config.PublishHwkThirdPartyEntryConfigProcessor
 * JD-Core Version:    0.7.0.1
 */