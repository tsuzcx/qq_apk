package com.tencent.qcircle.weseevideo.model.utils;

import android.text.TextUtils;
import java.util.Locale;

public class LocaleUtils
{
  private static final String CHINA = "zh_CN";
  private static final String HONGKONG = "zh_HK";
  public static final String LANGUAGE_DEFAULT = "en";
  public static final String LANGUAGE_KEY = "language_key";
  public static final String L_ENGLISH = "en";
  public static final String L_JAPANESE = "ja";
  public static final String L_JAPANESE_2 = "ja_JP";
  public static final String L_KOREAN = "ko";
  public static final String L_KOREAN_2 = "ko_KR";
  public static final String L_SIMPLE_CHINESE = "zh-Hans";
  public static final String L_SIMPLE_CHINESE_2 = "zh_Hans";
  public static final String L_TRADITIONAL_CHINESE = "zh-Hant";
  private static final String TAIWAN = "zh_TW";
  public static String mCurrentAppLanguage;
  
  private static String filterLanguage(String paramString)
  {
    String str1 = Locale.getDefault().getLanguage().trim();
    if (str1.equals("en")) {
      return "en";
    }
    String str2 = getLanguageCountryLocale();
    if ((!str2.equals("zh_TW")) && (!str2.equals("zh_HK")))
    {
      if (str2.equals("zh_CN")) {
        return "zh-Hans";
      }
      if (str1.equals("ja")) {
        return "ja";
      }
      if (str1.equals("ko")) {
        return "ko";
      }
      return paramString;
    }
    return "zh-Hant";
  }
  
  public static String getApplicationLanguage()
  {
    if (!TextUtils.isEmpty(mCurrentAppLanguage)) {
      return mCurrentAppLanguage;
    }
    return filterLanguage("en");
  }
  
  private static String getLanguageCountryLocale()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Locale.getDefault().getLanguage().trim());
    localStringBuilder.append("_");
    localStringBuilder.append(Locale.getDefault().getCountry().trim());
    return localStringBuilder.toString();
  }
  
  public static Locale getLocale(String paramString)
  {
    if ((!"zh_CN".equals(paramString)) && (!"zh_Hans".equals(paramString)))
    {
      if ("zh_HK".equals(paramString)) {
        return Locale.TRADITIONAL_CHINESE;
      }
      if ("ja_JP".equals(paramString)) {
        return Locale.JAPAN;
      }
      if ("ko_KR".equals(paramString)) {
        return Locale.KOREA;
      }
      return Locale.US;
    }
    return Locale.SIMPLIFIED_CHINESE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weseevideo.model.utils.LocaleUtils
 * JD-Core Version:    0.7.0.1
 */