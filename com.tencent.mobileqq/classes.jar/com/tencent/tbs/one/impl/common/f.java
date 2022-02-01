package com.tencent.tbs.one.impl.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Base64;
import java.io.File;

public final class f
{
  public static File a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return new File(paramContext.getApplicationInfo().nativeLibraryDir);
    }
    if (Build.VERSION.SDK_INT > 4) {
      return new File(paramContext.getApplicationInfo().dataDir, "lib");
    }
    return new File(paramContext.getFilesDir().getParentFile(), "lib");
  }
  
  public static File a(Context paramContext1, Context paramContext2, String paramString1, String paramString2, int paramInt)
  {
    if (paramContext1 == paramContext2)
    {
      paramContext1 = paramContext1.getExternalFilesDir("tbs");
    }
    else
    {
      if (paramContext1.getPackageManager().checkPermission("android.permission.READ_EXTERNAL_STORAGE", paramContext1.getPackageName()) == 0)
      {
        paramContext1 = paramContext2.getPackageName();
        if (Environment.getExternalStorageState().equals("mounted"))
        {
          paramContext2 = Environment.getExternalStorageDirectory();
          StringBuilder localStringBuilder = new StringBuilder("Android/data/");
          localStringBuilder.append(paramContext1);
          localStringBuilder.append("/files/tbs");
          paramContext1 = new File(paramContext2, localStringBuilder.toString());
          break label96;
        }
      }
      paramContext1 = null;
    }
    label96:
    if (paramContext1 != null) {
      paramContext1 = new File(new File(paramContext1, paramString1), paramString2);
    } else {
      paramContext1 = null;
    }
    if (paramContext1 != null) {
      return new File(paramContext1, String.valueOf(paramInt));
    }
    return null;
  }
  
  public static File a(File paramFile)
  {
    return new File(paramFile, "home");
  }
  
  public static File a(File paramFile, int paramInt)
  {
    return new File(new File(paramFile, "proc"), String.valueOf(paramInt));
  }
  
  public static File a(File paramFile, String paramString)
  {
    return new File(a(paramFile), paramString);
  }
  
  public static File a(File paramFile, String paramString, int paramInt)
  {
    return new File(b(paramFile, paramString), String.valueOf(paramInt));
  }
  
  public static File a(File paramFile, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramString2);
    paramString1 = Base64.encodeToString(((StringBuilder)localObject).toString().getBytes(b.b), 2);
    localObject = new StringBuilder("libtbs=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(".so");
    String str1 = ((StringBuilder)localObject).toString();
    localObject = new File(paramFile, str1);
    paramString1 = (String)localObject;
    if (!((File)localObject).exists())
    {
      paramString1 = new StringBuilder("libtbs");
      paramString1.append(paramString2);
      paramString1.append(".so");
      String str2 = paramString1.toString();
      localObject = new File(paramFile, str2);
      paramString1 = (String)localObject;
      if (!((File)localObject).exists())
      {
        paramFile = new File(paramFile, paramString2);
        paramString1 = paramFile;
        if (!paramFile.exists())
        {
          com.tencent.tbs.one.impl.a.f.b("Failed to find component file %s or %s or %s in native library directory", new Object[] { paramFile.getAbsolutePath(), str2, str1 });
          paramString1 = paramFile;
        }
      }
    }
    return paramString1;
  }
  
  public static File b(Context paramContext)
  {
    return new File(paramContext.getDir("tbs", 0), "proc");
  }
  
  public static File b(File paramFile)
  {
    return new File(paramFile, "DEPS");
  }
  
  public static File b(File paramFile, String paramString)
  {
    return new File(d(paramFile), paramString);
  }
  
  public static File c(File paramFile)
  {
    return new File(paramFile, "DEPS.latest");
  }
  
  public static File c(File paramFile, String paramString)
  {
    Object localObject = new StringBuilder("libtbs");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("DEPS.so");
    String str = ((StringBuilder)localObject).toString();
    localObject = new File(paramFile, str);
    paramString = (String)localObject;
    if (!((File)localObject).exists())
    {
      paramFile = new File(paramFile, "libtbsDEPS.so");
      paramString = paramFile;
      if (!paramFile.exists())
      {
        com.tencent.tbs.one.impl.a.f.b("Failed to find DEPS file %s or %s in native library directory", new Object[] { paramFile.getAbsolutePath(), str });
        paramString = paramFile;
      }
    }
    return paramString;
  }
  
  public static File d(File paramFile)
  {
    return new File(paramFile, "components");
  }
  
  public static File d(File paramFile, String paramString)
  {
    return new File(paramFile, paramString);
  }
  
  public static File e(File paramFile, String paramString)
  {
    String str = paramFile.getParent();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile.getName());
    localStringBuilder.append(paramString);
    return new File(str, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.f
 * JD-Core Version:    0.7.0.1
 */