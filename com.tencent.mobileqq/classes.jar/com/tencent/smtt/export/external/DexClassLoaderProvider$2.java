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
    try
    {
      Object localObject1 = new File(this.val$dexPath.replace(".jar", ".dex"));
      boolean bool1 = ((File)localObject1).exists();
      if ((bool1) && (((File)localObject1).length() != 0L))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(" existed!");
        Log.d("dexloader", ((StringBuilder)localObject2).toString());
        bool1 = true;
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(" does not existed!");
        Log.d("dexloader", ((StringBuilder)localObject2).toString());
        bool1 = false;
      }
      localObject1 = new File(this.val$optimizedDirectory);
      localObject2 = new File(this.val$dexPath);
      boolean bool2 = ((File)localObject1).exists();
      boolean bool3 = ((File)localObject1).isDirectory();
      boolean bool4 = ((File)localObject2).exists();
      if ((bool2) && (bool3) && (bool4))
      {
        long l = System.currentTimeMillis();
        new DexClassLoader(this.val$dexPath, this.val$optimizedDirectory, this.val$libraryPath, this.val$parent);
        localObject1 = String.format("load_dex completed -- cl_cost: %d, existed: %b", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool1) });
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append((String)localObject1);
        Log.d("dexloader", ((StringBuilder)localObject2).toString());
        if ((DexClassLoaderProvider.access$100()) && ("tbs_jars_fusion_dex.jar".equals(this.val$dexName)))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Stop provider service after loading ");
          ((StringBuilder)localObject1).append(this.val$dexName);
          Log.d("dexloader", ((StringBuilder)localObject1).toString());
          if (DexClassLoaderProvider.mService != null)
          {
            Log.d("dexloader", "##Stop service##... ");
            DexClassLoaderProvider.mService.stopSelf();
          }
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("dex loading exception(");
        ((StringBuilder)localObject1).append(bool2);
        ((StringBuilder)localObject1).append(", ");
        ((StringBuilder)localObject1).append(bool3);
        ((StringBuilder)localObject1).append(", ");
        ((StringBuilder)localObject1).append(bool4);
        ((StringBuilder)localObject1).append(")");
        Log.d("dexloader", ((StringBuilder)localObject1).toString());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("@AsyncDexLoad task exception: ");
      ((StringBuilder)localObject2).append(localThrowable);
      Log.e("dexloader", ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.smtt.export.external.DexClassLoaderProvider.2
 * JD-Core Version:    0.7.0.1
 */