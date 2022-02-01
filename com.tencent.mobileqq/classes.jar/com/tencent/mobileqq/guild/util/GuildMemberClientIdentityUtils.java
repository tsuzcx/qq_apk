package com.tencent.mobileqq.guild.util;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;

public class GuildMemberClientIdentityUtils
{
  public static boolean a(IGProClientIdentityInfo paramIGProClientIdentityInfo)
  {
    return (paramIGProClientIdentityInfo != null) && (!TextUtils.equals("0", paramIGProClientIdentityInfo.a())) && (!TextUtils.isEmpty(paramIGProClientIdentityInfo.b()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.GuildMemberClientIdentityUtils
 * JD-Core Version:    0.7.0.1
 */