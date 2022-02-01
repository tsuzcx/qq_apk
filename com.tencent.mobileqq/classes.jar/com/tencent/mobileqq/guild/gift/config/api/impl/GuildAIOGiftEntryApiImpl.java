package com.tencent.mobileqq.guild.gift.config.api.impl;

import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.guild.gift.config.GuildAIOGiftEntryConfig;
import com.tencent.mobileqq.guild.gift.config.api.IGuildAIOGiftEntryApi;

public class GuildAIOGiftEntryApiImpl
  implements IGuildAIOGiftEntryApi
{
  public boolean isShowEntry(String paramString)
  {
    GuildAIOGiftEntryConfig localGuildAIOGiftEntryConfig = (GuildAIOGiftEntryConfig)QConfigManager.b().b(764);
    if (localGuildAIOGiftEntryConfig == null) {
      return false;
    }
    return localGuildAIOGiftEntryConfig.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.gift.config.api.impl.GuildAIOGiftEntryApiImpl
 * JD-Core Version:    0.7.0.1
 */