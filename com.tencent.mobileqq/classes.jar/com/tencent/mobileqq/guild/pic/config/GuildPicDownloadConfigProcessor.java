package com.tencent.mobileqq.guild.pic.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class GuildPicDownloadConfigProcessor
  extends IQConfigProcessor<GuildPicDownloadConfig>
{
  @NonNull
  public GuildPicDownloadConfig a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent, type = ");
    localStringBuilder.append(paramInt);
    QLog.d("GuildPicDownloadConfigProcessor", 2, localStringBuilder.toString());
    return new GuildPicDownloadConfig();
  }
  
  @Nullable
  public GuildPicDownloadConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildPicDownloadConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return GuildPicDownloadConfig.a(paramArrayOfQConfItem[0].b);
    }
    return null;
  }
  
  public void a(GuildPicDownloadConfig paramGuildPicDownloadConfig) {}
  
  public Class<GuildPicDownloadConfig> clazz()
  {
    return GuildPicDownloadConfig.class;
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
    QLog.d("GuildPicDownloadConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 772;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.pic.config.GuildPicDownloadConfigProcessor
 * JD-Core Version:    0.7.0.1
 */