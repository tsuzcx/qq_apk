package com.tencent.mobileqq.minigame.jsapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.OnLoadServiceWebvieJsListener;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandServiceEventInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.PluginLogger;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.smtt.sdk.ValueCallback;

public class GameJsRuntime
  implements JsRuntime
{
  private Argument arguments;
  private PluginLogger logger;
  
  public GameJsRuntime(@NonNull Argument paramArgument, @NonNull PluginLogger paramPluginLogger)
  {
    this.arguments = paramArgument;
    this.logger = paramPluginLogger;
  }
  
  public void clearUp() {}
  
  public int createNativeBuffer(byte[] paramArrayOfByte, long paramLong1, long paramLong2)
  {
    return this.arguments.createBuffer(paramArrayOfByte, paramLong1, paramLong2);
  }
  
  public void evaluateCallbackJs(int paramInt, @Nullable String paramString)
  {
    this.logger.printEndLog(paramInt, paramString);
    this.arguments.callback(paramString);
  }
  
  public void evaluateSubcribeJS(@NonNull String paramString1, @Nullable String paramString2, int paramInt)
  {
    this.logger.printEndLog(paramString1, paramString2);
    this.arguments.subscribe(paramString1, paramString2);
  }
  
  public ApkgInfo getApkgInfo()
  {
    return null;
  }
  
  public Context getContextEx()
  {
    return BaseApplication.getContext().getApplicationContext();
  }
  
  public byte[] getNativeBuffer(int paramInt)
  {
    return this.arguments.getBuffer(paramInt);
  }
  
  public int getPageWebViewId()
  {
    return 0;
  }
  
  public ScriptContextType getTargetContextType()
  {
    return this.arguments.getContextType();
  }
  
  public void initService(ApkgInfo paramApkgInfo, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener) {}
  
  public void initService(ApkgInfo paramApkgInfo, String paramString, AppBrandRuntime.OnLoadServiceWebvieJsListener paramOnLoadServiceWebvieJsListener) {}
  
  public void initWAServiceJS(String paramString) {}
  
  public boolean isDestroyed()
  {
    return false;
  }
  
  public void loadAppServiceJs(String paramString) {}
  
  public void postMessageToMainThread(String paramString) {}
  
  public void setApkgInfo(ApkgInfo paramApkgInfo) {}
  
  public void setAppBrandEventInterface(AppBrandServiceEventInterface paramAppBrandServiceEventInterface) {}
  
  public void setAppServiceJsCallback(ValueCallback paramValueCallback) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.GameJsRuntime
 * JD-Core Version:    0.7.0.1
 */