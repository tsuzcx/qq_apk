package com.tencent.mobileqq.guild.gift.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class GuildAIOGiftEntryConfig
{
  private boolean a = true;
  
  public static GuildAIOGiftEntryConfig a(String paramString)
  {
    GuildAIOGiftEntryConfig localGuildAIOGiftEntryConfig = new GuildAIOGiftEntryConfig();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("content : ");
      localStringBuilder.append(paramString);
      QLog.d("GuildAIOGiftEntryConfig", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return localGuildAIOGiftEntryConfig;
    }
    boolean bool = false;
    try
    {
      int i = new JSONObject(paramString).optInt("isAllOpen", 1);
      if (i != 0) {
        bool = true;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    localGuildAIOGiftEntryConfig.a = bool;
    return localGuildAIOGiftEntryConfig;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.gift.config.GuildAIOGiftEntryConfig
 * JD-Core Version:    0.7.0.1
 */