package com.tencent.mobileqq.guild.client;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientPresenceInfo;

public class GuildClientPresenceUtils
{
  public static String a(IGProClientPresenceInfo paramIGProClientPresenceInfo)
  {
    if (paramIGProClientPresenceInfo == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e(paramIGProClientPresenceInfo));
    localStringBuilder.append(c(paramIGProClientPresenceInfo));
    localStringBuilder.append(b(paramIGProClientPresenceInfo));
    return localStringBuilder.toString();
  }
  
  private static String b(IGProClientPresenceInfo paramIGProClientPresenceInfo)
  {
    if (!TextUtils.isEmpty(paramIGProClientPresenceInfo.h()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" | ");
      localStringBuilder.append(paramIGProClientPresenceInfo.h());
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private static String c(IGProClientPresenceInfo paramIGProClientPresenceInfo)
  {
    if (!TextUtils.isEmpty(paramIGProClientPresenceInfo.e()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" | ");
      localStringBuilder.append(paramIGProClientPresenceInfo.e());
      localStringBuilder.append(d(paramIGProClientPresenceInfo));
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private static String d(IGProClientPresenceInfo paramIGProClientPresenceInfo)
  {
    if ((paramIGProClientPresenceInfo.f() != 0L) && (paramIGProClientPresenceInfo.g() != 0L))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("(");
      localStringBuilder.append(paramIGProClientPresenceInfo.f());
      localStringBuilder.append("/");
      localStringBuilder.append(paramIGProClientPresenceInfo.g());
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private static String e(IGProClientPresenceInfo paramIGProClientPresenceInfo)
  {
    if ((!TextUtils.isEmpty(paramIGProClientPresenceInfo.d())) && (paramIGProClientPresenceInfo.i() != 0L))
    {
      long l = (System.currentTimeMillis() / 1000L - paramIGProClientPresenceInfo.i()) / 60L;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramIGProClientPresenceInfo.d());
      localStringBuilder.append(l);
      localStringBuilder.append("分钟");
      return localStringBuilder.toString();
    }
    return paramIGProClientPresenceInfo.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.client.GuildClientPresenceUtils
 * JD-Core Version:    0.7.0.1
 */