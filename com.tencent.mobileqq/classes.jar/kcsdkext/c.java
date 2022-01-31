package kcsdkext;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;

public class c
{
  public static final int[] a = { 2 };
  private static final String[] b = { "B96D1D87399E009BC82C320D9F0D9332", "B96D1D87399E009BC82C320D9F0D9332" };
  private static Context c;
  
  public static String a()
  {
    int j;
    int i;
    int k;
    try
    {
      localObject2 = PreferenceManager.getDefaultSharedPreferences(c);
      localObject3 = a;
      j = localObject3.length;
      i = 0;
      localObject1 = null;
      if (i < j)
      {
        k = localObject3[i];
        if (localObject1 == null)
        {
          localObject1 = k + "";
          break label345;
        }
        localObject1 = (String)localObject1 + "," + k;
        break label345;
      }
      ((SharedPreferences)localObject2).edit().putString("kcsdk_vers", (String)localObject1).commit();
      j = ((SharedPreferences)localObject2).getInt("kcsdk_tar", 0);
      Log.e("KcSdkShellManager", "KEY_KC_target: " + j);
      if (j == 0) {
        return null;
      }
      localObject1 = a;
      k = localObject1.length;
      i = 0;
    }
    catch (Throwable localThrowable)
    {
      Object localObject2;
      Object localObject3;
      Object localObject1;
      label160:
      localThrowable.printStackTrace();
      return null;
    }
    if (i == 0)
    {
      Log.e("KcSdkShellManager", "version match failed, cload: " + j + " - cur: " + 2);
      return null;
    }
    localObject1 = ((SharedPreferences)localObject2).getString("kcsdk_file", null);
    if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!new File((String)localObject1).exists()))
    {
      Log.e("KcSdkShellManager", "sdkFile not exists");
      return null;
    }
    if (!a((String)localObject1))
    {
      Log.e("KcSdkShellManager", "checkSign error");
      return null;
    }
    localObject3 = a.a(new File((String)localObject1));
    localObject2 = ((SharedPreferences)localObject2).getString("kcsdk_m5", "");
    if (!((String)localObject2).equalsIgnoreCase((String)localObject3))
    {
      Log.e("KcSdkShellManager", "fileMD5: " + (String)localObject3 + " md5: " + (String)localObject2);
      return null;
    }
    label345:
    label376:
    for (;;)
    {
      i = 0;
      break label160;
      i += 1;
      break;
      return localThrowable;
      for (;;)
      {
        if (i >= k) {
          break label376;
        }
        if (j == localThrowable[i])
        {
          i = 1;
          break;
        }
        i += 1;
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    c = paramContext;
  }
  
  private static boolean a(String paramString)
  {
    paramString = b.a(paramString, "1");
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ("1".equals(paramString)) {
      return true;
    }
    String[] arrayOfString = b;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.compareToIgnoreCase(arrayOfString[i]) == 0) {
        return true;
      }
      i += 1;
    }
    Log.e("KcSdkShellManager", "Signature error");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     kcsdkext.c
 * JD-Core Version:    0.7.0.1
 */