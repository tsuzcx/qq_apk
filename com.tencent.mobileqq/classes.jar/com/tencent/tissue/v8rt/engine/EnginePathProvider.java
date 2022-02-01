package com.tencent.tissue.v8rt.engine;

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
      if (AssetUtil.copyAssetsDir(this.ctx, paramString, getEngineJSDir()))
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
 * Qualified Name:     com.tencent.tissue.v8rt.engine.EnginePathProvider
 * JD-Core Version:    0.7.0.1
 */