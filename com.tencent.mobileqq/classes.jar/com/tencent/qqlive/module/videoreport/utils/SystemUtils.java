package com.tencent.qqlive.module.videoreport.utils;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SystemUtils
{
  private static final String TAG = "SystemUtils";
  private static volatile String sSystemUI;
  
  private static String getSystemProperty(String paramString)
  {
    try
    {
      localObject = Class.forName("android.os.SystemProperties");
      paramString = (String)((Class)localObject).getMethod("get", new Class[] { String.class, String.class }).invoke(localObject, new Object[] { paramString, null });
      return paramString;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSystemProperty ");
      ((StringBuilder)localObject).append(paramString);
      Log.e("SystemUtils", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public static String getSystemUI()
  {
    if (sSystemUI == null) {
      sSystemUI = getSystemUIVersion();
    }
    return sSystemUI;
  }
  
  private static String getSystemUIVersion()
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(new SystemUtils.MIUIVersionGetter());
    ((List)localObject).add(new SystemUtils.EMUIVersionGetter());
    ((List)localObject).add(new SystemUtils.DefaultVersionGetter());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = ((SystemUtils.IUIVersionGetter)((Iterator)localObject).next()).getUIVersion();
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.SystemUtils
 * JD-Core Version:    0.7.0.1
 */