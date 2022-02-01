package com.tencent.mobileqq.guild.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Locale;
import mqq.app.MobileQQ;

public class QQGuildSPUtils
{
  private static final Context a = MobileQQ.sMobileQQ.getApplicationContext();
  
  public static void a(int paramInt)
  {
    d().edit().putInt("SP_KEY_GRAY_USER_TYPE", paramInt).apply();
  }
  
  public static void a(boolean paramBoolean)
  {
    a.getSharedPreferences(g("QQGuild"), 0).edit().putBoolean("SP_KEY_SHOW_GUILD_TAB", paramBoolean).apply();
  }
  
  public static boolean a()
  {
    return a.getSharedPreferences(g("QQGuild"), 0).getBoolean("SP_KEY_SHOW_GUILD_TAB", false);
  }
  
  public static boolean a(String paramString)
  {
    SharedPreferences localSharedPreferences = a.getSharedPreferences(g("QQGuild"), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SP_APP_AUTH_FLAG");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public static int b()
  {
    return d().getInt("SP_KEY_GRAY_USER_TYPE", 0);
  }
  
  public static void b(String paramString)
  {
    SharedPreferences.Editor localEditor = a.getSharedPreferences(g("QQGuild"), 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SP_APP_AUTH_FLAG");
    localStringBuilder.append(paramString);
    localEditor.putBoolean(localStringBuilder.toString(), true).apply();
  }
  
  public static void b(boolean paramBoolean)
  {
    a.getSharedPreferences(g("QQGuild"), 0).edit().putBoolean("SP_KEY_SHOW_NOTICE_ICON", paramBoolean).apply();
  }
  
  public static boolean c()
  {
    return a.getSharedPreferences(g("QQGuild"), 0).getBoolean("SP_KEY_SHOW_NOTICE_ICON", false);
  }
  
  public static boolean c(String paramString)
  {
    SharedPreferences localSharedPreferences = a.getSharedPreferences(g("QQGuild"), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("HAS_ENTERED_TEXT_CHANNEL");
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  private static SharedPreferences d()
  {
    return a.getSharedPreferences(g("QQGuild"), 0);
  }
  
  public static void d(String paramString)
  {
    SharedPreferences.Editor localEditor = a.getSharedPreferences(g("QQGuild"), 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("HAS_ENTERED_TEXT_CHANNEL");
    localEditor.putBoolean(localStringBuilder.toString(), true).apply();
  }
  
  public static void e(String paramString)
  {
    SharedPreferences.Editor localEditor = a.getSharedPreferences(g("QQGuild"), 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SP_KEY_CLIENT_AUTHORIZATION_FLAG");
    localStringBuilder.append(paramString);
    localEditor.putBoolean(localStringBuilder.toString(), true).apply();
  }
  
  public static boolean f(String paramString)
  {
    SharedPreferences localSharedPreferences = a.getSharedPreferences(g("QQGuild"), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SP_KEY_CLIENT_AUTHORIZATION_FLAG");
    localStringBuilder.append(paramString);
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  private static String g(String paramString)
  {
    String str = QQGuildUtil.f();
    return String.format(Locale.getDefault(), "%s_%s", new Object[] { paramString, str });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQGuildSPUtils
 * JD-Core Version:    0.7.0.1
 */