package com.tencent.tbs.one.impl.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Base64;
import com.tencent.tbs.one.impl.base.Logging;
import java.io.File;

public final class PathService
{
  private static final String HOME_DIRECTORY_NAME = "home";
  private static final String LOCK_FILENAME_SUFFIX = ".lock";
  private static final String PROC_DIRECTORY_NAME = "proc";
  private static final String TBS_DIRECTORY_NAME = "tbs";
  
  public static File getCategoryDirectory(File paramFile, String paramString)
  {
    return new File(getHomeDirectory(paramFile), paramString);
  }
  
  public static File getComponentDirectory(File paramFile, String paramString)
  {
    return new File(getComponentsDirectory(paramFile), paramString);
  }
  
  public static File getComponentFileInNativeLibraryDirectory(File paramFile, String paramString1, String paramString2)
  {
    paramString1 = Base64.encodeToString((paramString1 + File.separator + paramString2).getBytes(Constants.UTF8_CHARSET), 2);
    String str1 = "libtbs=" + paramString1 + ".so";
    File localFile = new File(paramFile, str1);
    paramString1 = localFile;
    if (!localFile.exists())
    {
      String str2 = "libtbs" + paramString2 + ".so";
      localFile = new File(paramFile, str2);
      paramString1 = localFile;
      if (!localFile.exists())
      {
        paramFile = new File(paramFile, paramString2);
        paramString1 = paramFile;
        if (!paramFile.exists())
        {
          Logging.w("Failed to find component file %s or %s or %s in native library directory", new Object[] { paramFile.getAbsolutePath(), str2, str1 });
          paramString1 = paramFile;
        }
      }
    }
    return paramString1;
  }
  
  public static File getComponentInstallationDirectory(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    return new File(getComponentDirectory(getCategoryDirectory(getDataRootDirectory(paramContext), paramString1), paramString2), String.valueOf(paramInt));
  }
  
  public static File getComponentInstallationDirectory(File paramFile, String paramString, int paramInt)
  {
    return new File(getComponentDirectory(paramFile, paramString), String.valueOf(paramInt));
  }
  
  public static File getComponentsDirectory(File paramFile)
  {
    return new File(paramFile, "components");
  }
  
  public static File getDEPSFile(File paramFile)
  {
    return new File(paramFile, "DEPS");
  }
  
  public static File getDEPSFileInNativeLibraryDirectory(File paramFile, String paramString)
  {
    String str = "libtbs" + paramString + "DEPS" + ".so";
    File localFile = new File(paramFile, str);
    paramString = localFile;
    if (!localFile.exists())
    {
      paramFile = new File(paramFile, "libtbsDEPS.so");
      paramString = paramFile;
      if (!paramFile.exists())
      {
        Logging.w("Failed to find DEPS file %s or %s in native library directory", new Object[] { paramFile.getAbsolutePath(), str });
        paramString = paramFile;
      }
    }
    return paramString;
  }
  
  public static File getDataRootDirectory(Context paramContext)
  {
    return paramContext.getDir("tbs", 0);
  }
  
  public static File getHomeDirectory(File paramFile)
  {
    return new File(paramFile, "home");
  }
  
  public static File getInUseCategoryFlagFile(File paramFile, String paramString)
  {
    return new File(paramFile, paramString);
  }
  
  public static File getLatestDEPSFile(File paramFile)
  {
    return new File(paramFile, "DEPS.latest");
  }
  
  public static File getNativeLibraryDirectory(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return new File(paramContext.getApplicationInfo().nativeLibraryDir);
    }
    if (Build.VERSION.SDK_INT > 4) {
      return new File(paramContext.getApplicationInfo().dataDir, "lib");
    }
    return new File(paramContext.getFilesDir().getParentFile(), "lib");
  }
  
  public static File getProcDirectory(Context paramContext)
  {
    return new File(getDataRootDirectory(paramContext), "proc");
  }
  
  public static File getProcDirectory(File paramFile)
  {
    return new File(paramFile, "proc");
  }
  
  public static File getProcessDirectory(File paramFile, int paramInt)
  {
    return new File(getProcDirectory(paramFile), String.valueOf(paramInt));
  }
  
  public static File getProcessLockFile(File paramFile)
  {
    return getSuffixedFile(paramFile, ".lock");
  }
  
  public static File getSdcardBackupComponentDirectory(Context paramContext1, Context paramContext2, String paramString1, String paramString2)
  {
    paramContext1 = getSdcardBackupDirectory(paramContext1, paramContext2);
    if (paramContext1 != null) {
      return new File(new File(paramContext1, paramString1), paramString2);
    }
    return null;
  }
  
  public static File getSdcardBackupDirectory(Context paramContext1, Context paramContext2)
  {
    if (paramContext1 == paramContext2) {
      return paramContext1.getExternalFilesDir("tbs");
    }
    if (paramContext1.getPackageManager().checkPermission("android.permission.READ_EXTERNAL_STORAGE", paramContext1.getPackageName()) == 0)
    {
      paramContext1 = paramContext2.getPackageName();
      if (Environment.getExternalStorageState().equals("mounted")) {
        return new File(Environment.getExternalStorageDirectory(), "Android/data/" + paramContext1 + "/files/tbs");
      }
    }
    return null;
  }
  
  public static File getSdcardBackupDirectory(Context paramContext1, Context paramContext2, String paramString1, String paramString2, int paramInt)
  {
    paramContext1 = getSdcardBackupComponentDirectory(paramContext1, paramContext2, paramString1, paramString2);
    if (paramContext1 != null) {
      return new File(paramContext1, String.valueOf(paramInt));
    }
    return null;
  }
  
  public static File getSourceDirectory(Context paramContext)
  {
    return new File(paramContext.getApplicationInfo().sourceDir);
  }
  
  public static File getSuffixedFile(File paramFile, String paramString)
  {
    return new File(paramFile.getParent(), paramFile.getName() + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.PathService
 * JD-Core Version:    0.7.0.1
 */