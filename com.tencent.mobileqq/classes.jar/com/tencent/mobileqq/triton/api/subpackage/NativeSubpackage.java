package com.tencent.mobileqq.triton.api.subpackage;

import android.text.TextUtils;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.game.GameLauncher;
import com.tencent.mobileqq.triton.jni.TTNativeCall;
import com.tencent.mobileqq.triton.jni.TTNativeModule;
import com.tencent.mobileqq.triton.sdk.APIProxy;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import java.io.File;

@TTNativeModule(name="NativeSubpackage")
public class NativeSubpackage
{
  static final String NAME = "NativeSubpackage";
  private static final String TAG = "NativeSubpackage";
  private TTEngine mTritonEngine;
  
  public NativeSubpackage(TTEngine paramTTEngine)
  {
    this.mTritonEngine = paramTTEngine;
  }
  
  private static void callbackLoadFinish(long paramLong, boolean paramBoolean)
  {
    try
    {
      nativeCallbackLoadFinish(paramLong, paramBoolean);
      return;
    }
    catch (Throwable localThrowable)
    {
      TTLog.e("NativeSubpackage", "native CallbackLoadFinish fail ", localThrowable);
    }
  }
  
  private static void callbackProgress(long paramLong1, float paramFloat, long paramLong2, long paramLong3)
  {
    try
    {
      nativeCallbackProgress(paramLong1, paramFloat, paramLong2, paramLong3);
      return;
    }
    catch (Throwable localThrowable)
    {
      TTLog.e("NativeSubpackage", "native  CallbackProgress fail ", localThrowable);
    }
  }
  
  private void loadSubPackageEnter(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    label396:
    label422:
    label453:
    for (;;)
    {
      MiniGameInfo localMiniGameInfo;
      String str2;
      try
      {
        localMiniGameInfo = this.mTritonEngine.getMiniGameInfo();
        if (localMiniGameInfo == null) {
          break;
        }
        this.mTritonEngine.getQQEnv().reportDC04266(1009, null);
        if (paramString.endsWith(".js")) {
          break label453;
        }
        paramString = paramString + File.separator + "game.js";
        TTLog.i("NativeSubpackage", "try loadSubPackageEnter subPath:" + paramString);
        str2 = this.mTritonEngine.getQQEnv().getMiniGamePath(localMiniGameInfo) + File.separator + paramString;
        if (new File(str2).exists())
        {
          str1 = paramString;
          paramString = str2;
          if ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists())) {
            break label422;
          }
          paramString = new File(paramString);
          if (this.mTritonEngine.loadScriptPathWithCodeCache(1, paramString.getAbsolutePath(), ((GameLauncher)this.mTritonEngine.getGameLauncher()).getGameDebugPath(paramString.getAbsolutePath()), paramString.getAbsolutePath() + ".cc") == -1) {
            break label396;
          }
          this.mTritonEngine.getQQEnv().reportDC04266(1010, null);
          return;
        }
      }
      catch (Throwable paramString)
      {
        TTLog.e("NativeSubpackage", "加载分包的启动js失败: ", paramString);
        return;
      }
      String str1 = paramString;
      if (!str2.endsWith("game.js"))
      {
        paramString = paramString.substring(0, paramString.lastIndexOf("/") + 1) + "game.js";
        str2 = this.mTritonEngine.getQQEnv().getMiniGamePath(localMiniGameInfo) + File.separator + paramString;
        str1 = paramString;
        if (new File(str2).exists())
        {
          TTLog.w("NativeSubpackage", "config entry file not found, switch entryPath to:" + paramString);
          str1 = paramString;
          paramString = str2;
          continue;
          TTLog.e("NativeSubpackage", "加载分包的启动js失败, entryPath file empty:" + str1);
          return;
          TTLog.e("NativeSubpackage", "加载分包的启动js失败, entryPath file not found:" + str1);
          return;
        }
      }
      paramString = null;
    }
  }
  
  @TTNativeCall
  private void loadSubpackage(long paramLong1, long paramLong2, String paramString)
  {
    this.mTritonEngine.getApiProxy().loadSubPackage(paramLong1, paramLong2, paramString, new NativeSubpackage.1(this));
  }
  
  private static native void nativeCallbackLoadFinish(long paramLong, boolean paramBoolean);
  
  private static native void nativeCallbackProgress(long paramLong1, float paramFloat, long paramLong2, long paramLong3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.api.subpackage.NativeSubpackage
 * JD-Core Version:    0.7.0.1
 */