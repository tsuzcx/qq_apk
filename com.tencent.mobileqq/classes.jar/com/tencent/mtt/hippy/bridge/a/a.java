package com.tencent.mtt.hippy.bridge.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import com.tencent.mtt.hippy.adapter.soloader.HippySoLoaderAdapter;
import java.io.File;
import java.util.ArrayList;

public class a
{
  private static final ArrayList<String> a = new ArrayList();
  private static SharedPreferences b;
  private static String c;
  private static String d;
  private static ArrayList<String> e = new ArrayList();
  private static HippySoLoaderAdapter f;
  
  public static void a(Context paramContext, SharedPreferences paramSharedPreferences, HippySoLoaderAdapter paramHippySoLoaderAdapter)
  {
    try
    {
      b = paramSharedPreferences;
      f = paramHippySoLoaderAdapter;
      paramContext = paramContext.getApplicationInfo();
      c = paramContext.nativeLibraryDir;
      d = paramContext.dataDir + File.separator + "private_hy_libs";
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void a(String paramString)
  {
    try
    {
      paramString = b(paramString);
      a.contains(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static String b(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("nickname == null");
    }
    return "lib" + paramString + ".so";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.bridge.a.a
 * JD-Core Version:    0.7.0.1
 */