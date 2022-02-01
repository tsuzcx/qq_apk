package com.tencent.open.component.cache.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;

public class LocalConfig
{
  public static SharedPreferences a()
  {
    int i = Build.VERSION.SDK_INT;
    BaseApplication localBaseApplication = BaseApplication.getContext();
    if (i > 10) {
      i = 4;
    } else {
      i = 0;
    }
    return localBaseApplication.getSharedPreferences("OPENSDK_setting", i);
  }
  
  public static SharedPreferences a(long paramLong)
  {
    if (paramLong == 0L) {
      return a();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(MD5Utils.encodeHexStr(String.valueOf(paramLong)));
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append("preference");
    localObject = ((StringBuilder)localObject).toString();
    return BaseApplication.getContext().getSharedPreferences((String)localObject, 0);
  }
  
  public static void a(String paramString, int paramInt, long paramLong)
  {
    SharedPreferences.Editor localEditor = a(paramLong).edit();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
  }
  
  public static int b(String paramString, int paramInt, long paramLong)
  {
    return a(paramLong).getInt(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.component.cache.util.LocalConfig
 * JD-Core Version:    0.7.0.1
 */