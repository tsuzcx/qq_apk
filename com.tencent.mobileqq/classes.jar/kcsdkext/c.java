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
    Object localObject3;
    int j;
    int k;
    int i;
    int m;
    int n;
    for (;;)
    {
      try
      {
        localObject2 = PreferenceManager.getDefaultSharedPreferences(c);
        localObject3 = a;
        j = localObject3.length;
        k = 0;
        localObject1 = null;
        i = 0;
        if (i < j)
        {
          m = localObject3[i];
          if (localObject1 == null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(m);
            ((StringBuilder)localObject1).append("");
            localObject1 = ((StringBuilder)localObject1).toString();
            break label426;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(",");
          localStringBuilder.append(m);
          localObject1 = localStringBuilder.toString();
          break label426;
        }
        ((SharedPreferences)localObject2).edit().putString("kcsdk_vers", (String)localObject1).commit();
        m = ((SharedPreferences)localObject2).getInt("kcsdk_tar", 0);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("KEY_KC_target: ");
        ((StringBuilder)localObject1).append(m);
        Log.e("KcSdkShellManager", ((StringBuilder)localObject1).toString());
        if (m == 0) {
          return null;
        }
        localObject1 = a;
        n = localObject1.length;
        j = 0;
      }
      catch (Throwable localThrowable)
      {
        Object localObject2;
        Object localObject1;
        localThrowable.printStackTrace();
        return null;
      }
      if (i == 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("version match failed, cload: ");
        ((StringBuilder)localObject1).append(m);
        ((StringBuilder)localObject1).append(" - cur: ");
        ((StringBuilder)localObject1).append(2);
        Log.e("KcSdkShellManager", ((StringBuilder)localObject1).toString());
        return null;
      }
      localObject3 = ((SharedPreferences)localObject2).getString("kcsdk_file", null);
      if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (new File((String)localObject3).exists()))
      {
        if (!a((String)localObject3))
        {
          Log.e("KcSdkShellManager", "checkSign error");
          return null;
        }
        localObject1 = a.a(new File((String)localObject3));
        localObject2 = ((SharedPreferences)localObject2).getString("kcsdk_m5", "");
        if (((String)localObject2).equalsIgnoreCase((String)localObject1)) {
          break label461;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("fileMD5: ");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(" md5: ");
        ((StringBuilder)localObject3).append((String)localObject2);
        Log.e("KcSdkShellManager", ((StringBuilder)localObject3).toString());
        return null;
      }
      Log.e("KcSdkShellManager", "sdkFile not exists");
      return null;
      label426:
      i += 1;
    }
    for (;;)
    {
      i = k;
      if (j >= n) {
        break;
      }
      if (m == localThrowable[j])
      {
        i = 1;
        break;
      }
      j += 1;
    }
    label461:
    return localObject3;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kcsdkext.c
 * JD-Core Version:    0.7.0.1
 */