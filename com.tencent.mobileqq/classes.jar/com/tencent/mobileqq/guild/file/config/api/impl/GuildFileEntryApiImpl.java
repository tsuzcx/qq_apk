package com.tencent.mobileqq.guild.file.config.api.impl;

import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.guild.file.config.GuildFileEntryConfig;
import com.tencent.mobileqq.guild.file.config.api.IGuildFileEntryApi;

public class GuildFileEntryApiImpl
  implements IGuildFileEntryApi
{
  public boolean isShowEntry()
  {
    GuildFileEntryConfig localGuildFileEntryConfig = (GuildFileEntryConfig)QConfigManager.b().b(771);
    if (localGuildFileEntryConfig == null) {
      return false;
    }
    return localGuildFileEntryConfig.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.file.config.api.impl.GuildFileEntryApiImpl
 * JD-Core Version:    0.7.0.1
 */