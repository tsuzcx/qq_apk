package com.tencent.mobileqq.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipPubAccountConfig
{
  private static int jdField_a_of_type_Int = 1000;
  private static String jdField_a_of_type_JavaLangString = "https://club.vip.qq.com/official?_wv=16778247&_wwv=68&_nav_alpha=0&pay_src=10&_wvx=10&_proxy=1";
  private static String b = "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_alpha=0&pay_src=10&_wvx=10&_proxy=1";
  private static String c = "https://club.vip.qq.com/game?_proxy=1&_wv=16777221&_wvx=10&g_ch=gzh";
  private boolean jdField_a_of_type_Boolean = false;
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  @NonNull
  public static QVipPubAccountConfig a(String paramString)
  {
    QVipPubAccountConfig localQVipPubAccountConfig = new QVipPubAccountConfig();
    if (TextUtils.isEmpty(paramString))
    {
      localQVipPubAccountConfig.jdField_a_of_type_Boolean = false;
      return localQVipPubAccountConfig;
    }
    a(paramString);
    localQVipPubAccountConfig.jdField_a_of_type_Boolean = true;
    return localQVipPubAccountConfig;
  }
  
  public static String a()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  private static void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      jdField_a_of_type_JavaLangString = paramString.getString("qqvip_vip_account");
      b = paramString.getString("nativebar_url");
      c = paramString.getString("game_home_url");
      jdField_a_of_type_Int = paramString.getInt("ani_start_time");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static String b()
  {
    return b;
  }
  
  public static String c()
  {
    return c;
  }
  
  public Boolean a()
  {
    return Boolean.valueOf(this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipPubAccountConfig
 * JD-Core Version:    0.7.0.1
 */