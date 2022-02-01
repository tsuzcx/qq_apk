package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipPubAccountConfig
{
  private static String a = "https://club.vip.qq.com/official?_wv=16778247&_wwv=68&_nav_alpha=0&pay_src=10&_wvx=10&_proxy=1";
  private static String b = "https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_nav_alpha=0&pay_src=10&_wvx=10&_proxy=1";
  private static String c = "https://club.vip.qq.com/game?_proxy=1&_wv=16777221&_wvx=10&g_ch=gzh";
  private static int d = 1000;
  private boolean e = false;
  
  @NonNull
  public static QVipPubAccountConfig a(String paramString)
  {
    QVipPubAccountConfig localQVipPubAccountConfig = new QVipPubAccountConfig();
    if (TextUtils.isEmpty(paramString))
    {
      localQVipPubAccountConfig.e = false;
      return localQVipPubAccountConfig;
    }
    b(paramString);
    localQVipPubAccountConfig.e = true;
    return localQVipPubAccountConfig;
  }
  
  public static String a()
  {
    return a;
  }
  
  public static String b()
  {
    return b;
  }
  
  private static void b(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      a = paramString.getString("qqvip_vip_account");
      b = paramString.getString("nativebar_url");
      c = paramString.getString("game_home_url");
      d = paramString.getInt("ani_start_time");
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static String c()
  {
    return c;
  }
  
  public static int d()
  {
    return d;
  }
  
  public Boolean e()
  {
    return Boolean.valueOf(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipPubAccountConfig
 * JD-Core Version:    0.7.0.1
 */