package com.tencent.qqmini.v8rt.engine;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

public class EnginePathProvider
{
  public static final String ENGINE_DIR = "engine";
  public static final String ENGINE_JS_DIR = "js";
  public static final String LOG_TAG = "EnginePathProvider";
  public static final String ROOT_DIR = "tv8rt";
  public static final String TIMESTAMP = ".timestamp";
  Context ctx;
  private File jsDir;
  private File rootDir;
  
  public EnginePathProvider(Context paramContext)
  {
    this.ctx = paramContext;
  }
  
  private static boolean copyAssetsDir(Context paramContext, String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = paramContext.getAssets();
        String[] arrayOfString = new String[2];
        arrayOfString[0] = "console.js";
        arrayOfString[1] = "timer.js";
        if ((arrayOfString != null) && (arrayOfString.length != 0))
        {
          Object localObject = new File(paramString2);
          if (!((File)localObject).exists()) {
            ((File)localObject).mkdir();
          }
          int j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            String str = arrayOfString[i];
            if (!TextUtils.isEmpty(str))
            {
              localObject = new File(paramString2, str);
              if (!((File)localObject).exists()) {
                ((File)localObject).getParentFile().mkdirs();
              }
              str = paramString1 + File.separator + str;
              localObject = ((File)localObject).getAbsolutePath();
              if (!AssetUtil.copyAssetToFile(paramContext, str, (String)localObject))
              {
                Logger.e("EnginePathProvider", String.format("copyAssetToFile from=%s, to=%s fail", new Object[] { str, localObject }));
                return false;
              }
            }
          }
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          int i;
          for (;;)
          {
            Logger.e("EnginePathProvider", String.format("copyFileOrDir assetsPath=%s, destPath=%s, exception", new Object[] { paramString1, paramString2 }), paramContext);
            try
            {
              paramContext = new File(paramString2);
              if (!paramContext.exists()) {
                break;
              }
              FileUtil.deleteFile(paramContext);
              return false;
            }
            catch (Throwable paramContext)
            {
              return false;
            }
          }
          i += 1;
        }
      }
    }
    return true;
  }
  
  public void copyEngineAssets(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      File localFile = new File(getEngineJSDir(), ".timestamp");
      if ((localFile.exists()) && (!paramBoolean))
      {
        Logger.i("EnginePathProvider", "skip copy engine assets");
        return;
      }
      if (copyAssetsDir(this.ctx, paramString, getEngineJSDir()))
      {
        if (localFile.exists()) {
          localFile.delete();
        }
        try
        {
          localFile.createNewFile();
          return;
        }
        catch (Exception paramString)
        {
          Logger.e("EnginePathProvider", "create timestamp failed");
          return;
        }
      }
      Logger.e("EnginePathProvider", "copyEngineAssets failed");
      return;
    }
    Logger.e("EnginePathProvider", "assetPath is empty");
  }
  
  public String getEngineJSDir()
  {
    if (this.rootDir == null)
    {
      this.rootDir = new File(this.ctx.getFilesDir().getPath() + File.separator + "tv8rt" + File.separator + "engine");
      this.jsDir = new File(this.rootDir, "js");
      if ((!this.jsDir.exists()) && (!this.jsDir.mkdirs())) {
        Logger.e("EnginePathProvider", "create dir failed " + this.jsDir.getAbsolutePath());
      }
    }
    return this.jsDir.getAbsolutePath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.EnginePathProvider
 * JD-Core Version:    0.7.0.1
 */