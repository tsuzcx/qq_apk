package com.tencent.mobileqq.guild.gift.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class GuildAIOGiftEntryConfigProcessor
  extends IQConfigProcessor<GuildAIOGiftEntryConfig>
{
  @NonNull
  public GuildAIOGiftEntryConfig a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent, type = ");
    localStringBuilder.append(paramInt);
    QLog.d("GuildAIOGiftEntryConfigProcessor", 2, localStringBuilder.toString());
    return new GuildAIOGiftEntryConfig();
  }
  
  @Nullable
  public GuildAIOGiftEntryConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildAIOGiftEntryConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return GuildAIOGiftEntryConfig.a(paramArrayOfQConfItem[0].b);
    }
    return null;
  }
  
  public void a(GuildAIOGiftEntryConfig paramGuildAIOGiftEntryConfig) {}
  
  public Class<GuildAIOGiftEntryConfig> clazz()
  {
    return GuildAIOGiftEntryConfig.class;
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
    QLog.d("GuildAIOGiftEntryConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 764;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.gift.config.GuildAIOGiftEntryConfigProcessor
 * JD-Core Version:    0.7.0.1
 */