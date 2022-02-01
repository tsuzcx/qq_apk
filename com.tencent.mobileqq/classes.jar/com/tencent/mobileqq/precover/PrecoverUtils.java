package com.tencent.mobileqq.precover;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.SystemUtil;
import java.io.File;

public class PrecoverUtils
{
  public static String a()
  {
    if (SystemUtil.a())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_PATH);
      localStringBuilder.append("pddata/prd/");
      localStringBuilder.append("res_precover");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir());
    localStringBuilder.append("/pddata/prd/");
    localStringBuilder.append("res_precover");
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a(paramString1));
      localStringBuilder.append(paramString2);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static void a(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("PRECOVER_SP_NAME", 0).edit().putLong(paramString, System.currentTimeMillis()).commit();
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    long l = System.currentTimeMillis();
    boolean bool = false;
    if (Math.abs(l - paramContext.getSharedPreferences("PRECOVER_SP_NAME", 0).getLong(paramString, -1L)) > 86400000L) {
      bool = true;
    }
    return bool;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (paramString.startsWith("http://hb.url.cn/")) {
      return paramString.substring(17);
    }
    String str = paramString;
    if (paramString.startsWith("http://")) {
      str = paramString.substring(7);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.precover.PrecoverUtils
 * JD-Core Version:    0.7.0.1
 */