package com.tencent.tbs.one.impl.loader.dex;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.tbs.one.impl.base.FileUtils;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.one.impl.base.ThreadUtils;
import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.IOException;

public final class DexUtils
{
  private static Boolean sIsDexOptimizationSupported;
  
  public static ClassLoader createClassLoader(Context paramContext, File paramFile, String paramString1, String paramString2, ClassLoader paramClassLoader, String paramString3, boolean paramBoolean)
  {
    Logging.i("Creating class loader from %s, optimizedDirectory: %s, librarySearchPath: %s, parent: %s, sealedPackage: %s, isAsyncDexOptimizationEnabled: %b", new Object[] { paramFile.getAbsolutePath(), paramString1, paramString2, paramClassLoader, paramString3, Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (isDexOptimizationSupported()) && (needsOptimizeDex(paramString1, paramFile.getName())))
    {
      if (TextUtils.isEmpty(paramString3)) {}
      for (paramClassLoader = new PathClassLoader(paramFile.getAbsolutePath(), paramString2, paramClassLoader);; paramClassLoader = new SealedDexClassLoader(paramFile.getAbsolutePath(), null, paramString2, paramClassLoader, paramString3))
      {
        optimizeDexInBackground(paramContext, paramFile, paramString1, paramString2);
        return paramClassLoader;
      }
    }
    if (TextUtils.isEmpty(paramString3)) {
      return new DexClassLoader(paramFile.getAbsolutePath(), paramString1, paramString2, paramClassLoader);
    }
    return new SealedDexClassLoader(paramFile.getAbsolutePath(), paramString1, paramString2, paramClassLoader, paramString3);
  }
  
  private static File getOptimizedDexFlagFile(String paramString1, String paramString2)
  {
    return new File(paramString1, paramString2 + ".opt");
  }
  
  private static boolean isDexOptimizationSupported()
  {
    if (sIsDexOptimizationSupported == null) {
      sIsDexOptimizationSupported = Boolean.valueOf(isDexOptimizationSupportedInternal());
    }
    return sIsDexOptimizationSupported.booleanValue();
  }
  
  private static boolean isDexOptimizationSupportedInternal()
  {
    int i = Build.VERSION.SDK_INT;
    if ((i < 21) || (i > 25))
    {
      Logging.i("API level %d does not support dex optimization", new Object[] { Integer.valueOf(i) });
      return false;
    }
    String str = System.getProperty("java.vm.version");
    if ((str == null) || (!str.startsWith("2")))
    {
      Logging.i("VM version %s does not support dex optimization", new Object[] { str });
      return false;
    }
    Logging.i("API level %d and VM version %s supports dex optimization", new Object[] { Integer.valueOf(i), str });
    return true;
  }
  
  private static boolean isDexOptimized(String paramString1, String paramString2)
  {
    boolean bool = getOptimizedDexFlagFile(paramString1, paramString2).exists();
    if (bool) {}
    for (paramString1 = "has";; paramString1 = "has not")
    {
      Logging.i("The dex %s %s optimized", new Object[] { paramString2, paramString1 });
      return bool;
    }
  }
  
  private static boolean needsOptimizeDex(String paramString1, String paramString2)
  {
    return (!isDexOptimized(paramString1, paramString2)) || (!verifyOptimizedDex(paramString1, paramString2));
  }
  
  public static void optimizeDex(String paramString1, String paramString2, String paramString3, String paramString4, ClassLoader paramClassLoader)
  {
    try
    {
      new DexClassLoader(paramString2, paramString3, paramString4, paramClassLoader);
      FileUtils.createFileWithWarning(getOptimizedDexFlagFile(paramString3, paramString1));
      return;
    }
    catch (Exception paramString1)
    {
      Logging.e("Failed to optimize dex %s", new Object[] { paramString2, paramString1 });
    }
  }
  
  private static void optimizeDexInBackground(Context paramContext, File paramFile, String paramString1, String paramString2)
  {
    ThreadUtils.postOnCoreThreadDelayed(new DexUtils.1(paramFile, paramContext, paramString1, paramString2), 2000L);
  }
  
  private static boolean verifyOptimizedDex(String paramString1, String paramString2)
  {
    paramString2 = FileUtils.getNameAndExtension(paramString2);
    paramString1 = new File(paramString1, paramString2[0] + ".dex");
    if (!paramString1.exists())
    {
      Logging.i("The odex file %s does not exist", new Object[] { paramString1.getAbsolutePath() });
      return true;
    }
    if (Elf.isElf(paramString1)) {
      try
      {
        new Elf(paramString1);
        Logging.i("The odex file %s is well-kept", new Object[] { paramString1.getAbsolutePath() });
        return true;
      }
      catch (IOException paramString2)
      {
        Logging.i("The odex file %s has broken", new Object[] { paramString1.getAbsolutePath() });
        return false;
      }
    }
    Logging.i("The odex file %s is not a elf file", new Object[] { paramString1.getAbsolutePath() });
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.loader.dex.DexUtils
 * JD-Core Version:    0.7.0.1
 */