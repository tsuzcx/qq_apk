package com.tencent.smtt.export.external;

import android.app.Service;
import android.util.Log;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.TimerTask;

final class DexClassLoaderProvider$2
  extends TimerTask
{
  DexClassLoaderProvider$2(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader, String paramString4) {}
  
  public void run()
  {
    boolean bool1 = true;
    try
    {
      Object localObject = new File(this.val$dexPath.replace(".jar", ".dex"));
      if ((((File)localObject).exists()) && (((File)localObject).length() != 0L)) {
        Log.d("dexloader", "" + localObject + " existed!");
      }
      for (;;)
      {
        localObject = new File(this.val$optimizedDirectory);
        File localFile = new File(this.val$dexPath);
        boolean bool2 = ((File)localObject).exists();
        boolean bool3 = ((File)localObject).isDirectory();
        boolean bool4 = localFile.exists();
        if ((bool2) && (bool3) && (bool4)) {
          break;
        }
        Log.d("dexloader", "dex loading exception(" + bool2 + ", " + bool3 + ", " + bool4 + ")");
        return;
        Log.d("dexloader", "" + localObject + " does not existed!");
        bool1 = false;
      }
      long l = System.currentTimeMillis();
      new DexClassLoader(this.val$dexPath, this.val$optimizedDirectory, this.val$libraryPath, this.val$parent);
      localObject = String.format("load_dex completed -- cl_cost: %d, existed: %b", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool1) });
      Log.d("dexloader", "" + (String)localObject);
      if ((DexClassLoaderProvider.access$100()) && ("tbs_jars_fusion_dex.jar".equals(this.val$dexName)))
      {
        Log.d("dexloader", "Stop provider service after loading " + this.val$dexName);
        if (DexClassLoaderProvider.mService != null)
        {
          Log.d("dexloader", "##Stop service##... ");
          DexClassLoaderProvider.mService.stopSelf();
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("dexloader", "@AsyncDexLoad task exception: " + localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexClassLoaderProvider.2
 * JD-Core Version:    0.7.0.1
 */