package com.tencent.mobileqq.guild.pic.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class GuildPicDownloadConfig
{
  private boolean a = true;
  private boolean b = true;
  
  public static GuildPicDownloadConfig a(String paramString)
  {
    GuildPicDownloadConfig localGuildPicDownloadConfig = new GuildPicDownloadConfig();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("content : ");
      localStringBuilder1.append(paramString);
      QLog.d("GuildPicDownloadConfig", 2, localStringBuilder1.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return localGuildPicDownloadConfig;
    }
    for (;;)
    {
      try
      {
        int i = new JSONObject(paramString).optInt("PreThumbPreBig", 11);
        boolean bool2 = false;
        if ((i & 0x1) != 1) {
          break label207;
        }
        bool1 = true;
        localGuildPicDownloadConfig.a = bool1;
        bool1 = bool2;
        if ((i >> 1 & 0x1) == 1) {
          bool1 = true;
        }
        localGuildPicDownloadConfig.b = bool1;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("content : ");
        localStringBuilder2.append(paramString);
        localStringBuilder2.append(" preBig:");
        localStringBuilder2.append(localGuildPicDownloadConfig.a);
        localStringBuilder2.append(" preThumb");
        localStringBuilder2.append(localGuildPicDownloadConfig.b);
        QLog.d("GuildPicDownloadConfig", 2, localStringBuilder2.toString());
      }
      return localGuildPicDownloadConfig;
      label207:
      boolean bool1 = false;
    }
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.pic.config.GuildPicDownloadConfig
 * JD-Core Version:    0.7.0.1
 */