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
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      try
      {
        paramContext = paramContext.getAssets();
        String[] arrayOfString = new String[2];
        arrayOfString[0] = "console.js";
        arrayOfString[1] = "timer.js";
        if (arrayOfString.length == 0) {
          return false;
        }
        Object localObject = new File(paramString2);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdir();
        }
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (!TextUtils.isEmpty(str))
          {
            localObject = new File(paramString2, str);
            if (!((File)localObject).exists()) {
              ((File)localObject).getParentFile().mkdirs();
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString1);
            localStringBuilder.append(File.separator);
            localStringBuilder.append(str);
            str = localStringBuilder.toString();
            localObject = ((File)localObject).getAbsolutePath();
            if (!AssetUtil.copyAssetToFile(paramContext, str, (String)localObject))
            {
              Logger.e("EnginePathProvider", String.format("copyAssetToFile from=%s, to=%s fail", new Object[] { str, localObject }));
              return false;
            }
          }
          i += 1;
        }
        return true;
      }
      catch (Throwable paramContext)
      {
        Logger.e("EnginePathProvider", String.format("copyFileOrDir assetsPath=%s, destPath=%s, exception", new Object[] { paramString1, paramString2 }), paramContext);
      }
    }
    try
    {
      paramContext = new File(paramString2);
      if (paramContext.exists()) {
        FileUtil.deleteFile(paramContext);
      }
      return false;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public void copyEngineAssets(String paramString, boolean paramBoolean)
  {
    File localFile;
    if (!TextUtils.isEmpty(paramString))
    {
      localFile = new File(getEngineJSDir(), ".timestamp");
      if ((localFile.exists()) && (!paramBoolean))
      {
        Logger.i("EnginePathProvider", "skip copy engine assets");
        return;
      }
      if (copyAssetsDir(this.ctx, paramString, getEngineJSDir())) {
        if (localFile.exists()) {
          localFile.delete();
        }
      }
    }
    try
    {
      localFile.createNewFile();
      return;
    }
    catch (Exception paramString)
    {
      label74:
      break label74;
    }
    Logger.e("EnginePathProvider", "create timestamp failed");
    return;
    Logger.e("EnginePathProvider", "copyEngineAssets failed");
    return;
    Logger.e("EnginePathProvider", "assetPath is empty");
  }
  
  public String getEngineJSDir()
  {
    if (this.rootDir == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.ctx.getFilesDir().getPath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("tv8rt");
      localStringBuilder.append(File.separator);
      localStringBuilder.append("engine");
      this.rootDir = new File(localStringBuilder.toString());
      this.jsDir = new File(this.rootDir, "js");
      if ((!this.jsDir.exists()) && (!this.jsDir.mkdirs()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("create dir failed ");
        localStringBuilder.append(this.jsDir.getAbsolutePath());
        Logger.e("EnginePathProvider", localStringBuilder.toString());
      }
    }
    return this.jsDir.getAbsolutePath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.EnginePathProvider
 * JD-Core Version:    0.7.0.1
 */