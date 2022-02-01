package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.reflect.Field;

public class ReflectedMethods
{
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null) && (paramString.length() > 0)) {}
    try
    {
      Class localClass = Class.forName("android.content.Context");
      i = ((Integer)localClass.getField("MODE_MULTI_PROCESS").get(localClass)).intValue();
    }
    catch (ClassNotFoundException|NoSuchFieldException|IllegalArgumentException|IllegalAccessException|Exception localClassNotFoundException)
    {
      int i;
      label47:
      int j;
      break label47;
    }
    i = -1;
    j = i;
    if (i == -1) {
      j = 0;
    }
    return paramContext.getSharedPreferences(paramString, j);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.ReflectedMethods
 * JD-Core Version:    0.7.0.1
 */