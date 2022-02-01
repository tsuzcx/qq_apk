package com.tencent.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class SOPreLoader
{
  private static String a = "";
  private static String b;
  
  public static String a()
  {
    if (TextUtils.isEmpty(a))
    {
      Object localObject = BaseApplicationImpl.getContext();
      if (localObject != null)
      {
        localObject = ((Context)localObject).getFilesDir();
        if (TextUtils.isEmpty(a))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((File)localObject).getParent());
          localStringBuilder.append("/txlib/");
          localStringBuilder.append("cmshow/");
          a = localStringBuilder.toString();
        }
      }
      else
      {
        QLog.w("ApolloSoLoader_preLoader", 2, "getSoLibPath but context is null");
      }
    }
    return a;
  }
  
  public static void a(String paramString)
  {
    QLog.d("ApolloSoLoader_preLoader", 1, new Object[] { "setLibJscPath, libJscPath=", paramString });
    b = paramString;
    BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 4).edit().putString("apollo_sp_key_jsc_lib_path", paramString).commit();
  }
  
  public static String b()
  {
    if (TextUtils.isEmpty(b)) {
      b = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 4).getString("apollo_sp_key_jsc_lib_path", null);
    }
    QLog.d("ApolloSoLoader_preLoader", 1, new Object[] { "getLibJscPath, sLibJscPath=", b });
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.SOPreLoader
 * JD-Core Version:    0.7.0.1
 */