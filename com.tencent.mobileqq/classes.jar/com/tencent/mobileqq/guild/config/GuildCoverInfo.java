package com.tencent.mobileqq.guild.config;

import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.util.QQGuildUtil;

public class GuildCoverInfo
{
  private String a = "";
  private String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private String g = "";
  
  public GuildCoverInfo(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.f = paramString6;
    this.g = paramString7;
  }
  
  public static GuildCoverInfo a(String paramString)
  {
    return QQGuildUtil.c().a(paramString);
  }
  
  public static int b(String paramString)
  {
    try
    {
      paramString = a(paramString).c();
      if (!TextUtils.isEmpty(paramString))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("#");
        localStringBuilder.append(paramString);
        int i = Color.parseColor(localStringBuilder.toString());
        return i;
      }
    }
    catch (IllegalArgumentException paramString)
    {
      label46:
      break label46;
    }
    return Color.argb(255, 34, 34, 34);
  }
  
  public String a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public String g()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.config.GuildCoverInfo
 * JD-Core Version:    0.7.0.1
 */