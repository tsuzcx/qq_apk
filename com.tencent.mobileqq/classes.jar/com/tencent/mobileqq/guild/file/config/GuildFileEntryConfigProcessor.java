package com.tencent.mobileqq.guild.file.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class GuildFileEntryConfigProcessor
  extends IQConfigProcessor<GuildFileEntryConfig>
{
  @NonNull
  public GuildFileEntryConfig a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent, type = ");
    localStringBuilder.append(paramInt);
    QLog.d("GuildFileEntryConfigProcessor", 2, localStringBuilder.toString());
    return new GuildFileEntryConfig();
  }
  
  @Nullable
  public GuildFileEntryConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildFileEntryConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return GuildFileEntryConfig.a(paramArrayOfQConfItem[0].b);
    }
    return null;
  }
  
  public void a(GuildFileEntryConfig paramGuildFileEntryConfig) {}
  
  public Class<GuildFileEntryConfig> clazz()
  {
    return GuildFileEntryConfig.class;
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
    QLog.d("GuildFileEntryConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 771;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.file.config.GuildFileEntryConfigProcessor
 * JD-Core Version:    0.7.0.1
 */