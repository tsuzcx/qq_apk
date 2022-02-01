package com.tencent.mobileqq.guild.file.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class GuildFileEntryConfig
{
  private boolean a = false;
  
  public static GuildFileEntryConfig a(String paramString)
  {
    GuildFileEntryConfig localGuildFileEntryConfig = new GuildFileEntryConfig();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("content : ");
      localStringBuilder.append(paramString);
      QLog.d("GuildFileEntryConfig", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return localGuildFileEntryConfig;
    }
    boolean bool = false;
    try
    {
      int i = new JSONObject(paramString).optInt("isFileEntranceOpen", 0);
      if (i != 0) {
        bool = true;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    localGuildFileEntryConfig.a = bool;
    return localGuildFileEntryConfig;
  }
  
  public boolean a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.file.config.GuildFileEntryConfig
 * JD-Core Version:    0.7.0.1
 */