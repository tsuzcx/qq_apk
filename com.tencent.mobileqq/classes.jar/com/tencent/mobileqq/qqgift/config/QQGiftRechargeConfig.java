package com.tencent.mobileqq.qqgift.config;

import java.io.Serializable;

public class QQGiftRechargeConfig
  implements Serializable
{
  public static final int BANNER_UN_SET_MATERIAL_ID = -99;
  public static final String P_S_KEY_URL_PREFIX = "https://ui.ptlogin2.qq.com/cgi-bin/login?pt_hide_ad=1&appid=549000929&daid=782&s_url={s_url}";
  public int bannerDefaultMaterialId = -99;
  public String ptLoginPrefix = "https://ui.ptlogin2.qq.com/cgi-bin/login?pt_hide_ad=1&appid=549000929&daid=782&s_url={s_url}";
  public String rechargeUrl = "https://qlive.qq.com/pages/charge.html?asyncMode=3&qq_gift_app_id={qq_gift_app_id}&source={source}";
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQGiftRechargeConfig{rechargeUrl='");
    localStringBuilder.append(this.rechargeUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.config.QQGiftRechargeConfig
 * JD-Core Version:    0.7.0.1
 */