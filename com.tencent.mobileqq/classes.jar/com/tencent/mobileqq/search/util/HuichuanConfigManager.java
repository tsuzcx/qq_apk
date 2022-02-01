package com.tencent.mobileqq.search.util;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import java.net.URLDecoder;

public class HuichuanConfigManager
{
  private final AladdinConfig a = Aladdin.getConfig(492);
  
  public static HuichuanConfigManager a()
  {
    return HuichuanConfigManager.Holder.a();
  }
  
  @NonNull
  private String b(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      str = URLDecoder.decode(paramString);
    }
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "";
    }
    return paramString;
  }
  
  @NonNull
  public String a(String paramString)
  {
    AladdinConfig localAladdinConfig = this.a;
    if (localAladdinConfig == null) {
      return "";
    }
    return localAladdinConfig.getString(paramString, "");
  }
  
  @NonNull
  public String b()
  {
    return b(a("search_url_prefix"));
  }
  
  @NonNull
  public String c()
  {
    return a("search_url_query_param_key");
  }
  
  @NonNull
  public String d()
  {
    return b(a("intercept_rule"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.util.HuichuanConfigManager
 * JD-Core Version:    0.7.0.1
 */