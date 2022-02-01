package com.tencent.qg.sdk.deubgger;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.io.File;

public class Debugger
{
  public static final String FILE_JS_DEBUG_MODE = "file_js_debug_mode";
  public static final String FILE_JS_START_WAIT = "file_js_start_wait";
  private Activity mContext;
  protected boolean mHasInit;
  
  public Debugger(Activity paramActivity)
  {
    this.mContext = paramActivity;
  }
  
  private native void attachNative();
  
  private static boolean createFile(File paramFile)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!paramFile.exists())
    {
      if ((paramFile.getParentFile() == null) || (paramFile.getParentFile().exists())) {
        break label47;
      }
      bool1 = bool2;
      if (paramFile.getParentFile().mkdirs()) {
        bool1 = paramFile.createNewFile();
      }
    }
    return bool1;
    label47:
    return paramFile.createNewFile();
  }
  
  public static boolean isJsDebugMode(Context paramContext)
  {
    return new File(paramContext.getFilesDir(), "file_js_debug_mode").exists();
  }
  
  public static boolean isStartWait(Context paramContext)
  {
    return new File(paramContext.getFilesDir(), "file_js_start_wait").exists();
  }
  
  private native void nativeStartDebugger();
  
  public static void setJsDebugMode(Context paramContext, boolean paramBoolean)
  {
    paramContext = new File(paramContext.getFilesDir(), "file_js_debug_mode");
    boolean bool = paramContext.exists();
    if ((!paramBoolean) && (bool)) {
      paramContext.delete();
    }
    while ((!paramBoolean) || (bool)) {
      return;
    }
    try
    {
      createFile(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void setStartWait(Context paramContext, boolean paramBoolean)
  {
    paramContext = new File(paramContext.getFilesDir(), "file_js_start_wait");
    boolean bool = paramContext.exists();
    if ((!paramBoolean) && (bool)) {
      paramContext.delete();
    }
    while ((!paramBoolean) || (bool)) {
      return;
    }
    try
    {
      createFile(paramContext);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void closeJsDebugMode()
  {
    setJsDebugMode(this.mContext, false);
  }
  
  public void init()
  {
    if (!this.mHasInit) {
      attachNative();
    }
    this.mHasInit = true;
  }
  
  public boolean isJsDebugMode()
  {
    return isJsDebugMode(this.mContext);
  }
  
  public boolean isStartWait()
  {
    return isStartWait(this.mContext);
  }
  
  public void nativeShowPromtDialog(String paramString1, String paramString2)
  {
    new Handler(Looper.getMainLooper()).post(new Debugger.2(this, paramString2, paramString1));
  }
  
  public void nativeStatePromt(String paramString)
  {
    new Handler(Looper.getMainLooper()).post(new Debugger.1(this, paramString));
  }
  
  public void openJsDebugMode()
  {
    setJsDebugMode(this.mContext, true);
  }
  
  public void startDebugger()
  {
    nativeStartDebugger();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qg.sdk.deubgger.Debugger
 * JD-Core Version:    0.7.0.1
 */