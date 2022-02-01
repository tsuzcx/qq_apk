package com.tencent.tbs.one.impl.c.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.m;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;

public final class c
{
  private static Boolean a;
  
  static File a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(".opt");
    return new File(paramString1, localStringBuilder.toString());
  }
  
  public static ClassLoader a(Context paramContext, File paramFile, String paramString1, String paramString2, ClassLoader paramClassLoader, boolean paramBoolean1, String[] paramArrayOfString, boolean paramBoolean2)
  {
    String str1 = paramFile.getAbsolutePath();
    int j = 1;
    f.a("Creating class loader from %s, optimizedDirectory: %s, librarySearchPath: %s, parent: %s, unsealedPackages: %s, isAsyncDexOptimizationEnabled: %b", new Object[] { str1, paramString1, paramString2, paramClassLoader, paramArrayOfString, Boolean.valueOf(paramBoolean2) });
    if (paramBoolean2)
    {
      int i;
      if (a == null)
      {
        i = Build.VERSION.SDK_INT;
        if ((i >= 21) && (i <= 25))
        {
          str1 = System.getProperty("java.vm.version");
          if ((str1 != null) && (str1.startsWith("2")))
          {
            f.a("API level %d and VM version %s supports dex optimization", new Object[] { Integer.valueOf(i), str1 });
            paramBoolean2 = true;
            break label173;
          }
          f.a("VM version %s does not support dex optimization", new Object[] { str1 });
        }
        else
        {
          f.a("API level %d does not support dex optimization", new Object[] { Integer.valueOf(i) });
        }
        paramBoolean2 = false;
        label173:
        a = Boolean.valueOf(paramBoolean2);
      }
      if (a.booleanValue())
      {
        String str2 = paramFile.getName();
        paramBoolean2 = a(paramString1, str2).exists();
        if (paramBoolean2) {
          str1 = "has";
        } else {
          str1 = "has not";
        }
        f.a("The dex %s %s optimized", new Object[] { str2, str1 });
        i = j;
        if (paramBoolean2)
        {
          i = j;
          if (b(paramString1, str2)) {
            i = 0;
          }
        }
        if (i != 0)
        {
          if (paramBoolean1) {
            paramClassLoader = new PathClassLoader(paramFile.getAbsolutePath(), paramString2, paramClassLoader);
          } else {
            paramClassLoader = new e(paramFile.getAbsolutePath(), null, paramString2, paramClassLoader, paramArrayOfString);
          }
          m.c(new c.1(paramFile, paramContext, paramString1, paramString2));
          return paramClassLoader;
        }
      }
    }
    if (paramBoolean1) {
      return new DexClassLoader(paramFile.getAbsolutePath(), paramString1, paramString2, paramClassLoader);
    }
    return new e(paramFile.getAbsolutePath(), paramString1, paramString2, paramClassLoader, paramArrayOfString);
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    Object localObject = new File(paramString2).getName();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      int i = ((String)localObject).lastIndexOf('.');
      if (i > 0)
      {
        paramString2 = new String[2];
        paramString2[0] = ((String)localObject).substring(0, i);
        paramString2[1] = ((String)localObject).substring(i + 1);
        break label70;
      }
    }
    paramString2 = new String[2];
    paramString2[0] = localObject;
    paramString2[1] = null;
    label70:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString2[0]);
    ((StringBuilder)localObject).append(".dex");
    paramString1 = new File(paramString1, ((StringBuilder)localObject).toString());
    if (!paramString1.exists())
    {
      f.a("The odex file %s does not exist", new Object[] { paramString1.getAbsolutePath() });
      return true;
    }
    if (d.a(paramString1)) {}
    try
    {
      new d(paramString1);
      f.a("The odex file %s is well-kept", new Object[] { paramString1.getAbsolutePath() });
      return true;
    }
    catch (IOException paramString2)
    {
      label165:
      break label165;
    }
    f.a("The odex file %s has broken", new Object[] { paramString1.getAbsolutePath() });
    return false;
    f.a("The odex file %s is not a elf file", new Object[] { paramString1.getAbsolutePath() });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.a.c
 * JD-Core Version:    0.7.0.1
 */