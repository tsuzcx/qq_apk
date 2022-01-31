package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.IJsPlugin;
import com.tencent.mobileqq.mini.appbrand.utils.MiniLog;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameBrandRuntime;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;

public abstract class BaseJsPlugin
  implements IJsPlugin
{
  private String appId;
  protected boolean isDestroy;
  protected boolean isGameRuntime;
  public BaseJsPluginEngine jsPluginEngine;
  
  private void setAppId(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    if ((paramBaseJsPluginEngine != null) && (paramBaseJsPluginEngine.appBrandRuntime != null)) {
      this.appId = paramBaseJsPluginEngine.appBrandRuntime.appId;
    }
  }
  
  public String getAppId()
  {
    return this.appId;
  }
  
  protected GameBrandRuntime getGameBrandRuntime()
  {
    if ((this.jsPluginEngine != null) && ((this.jsPluginEngine.appBrandRuntime instanceof GameBrandRuntime))) {
      return (GameBrandRuntime)this.jsPluginEngine.appBrandRuntime;
    }
    return null;
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    return "";
  }
  
  protected boolean isColorLevel()
  {
    return MiniLog.isColorLevel(this.appId);
  }
  
  protected boolean isDevelopLevel()
  {
    return MiniLog.isDevelopLevel(this.appId);
  }
  
  protected boolean isMiniGameRuntime()
  {
    return (this.jsPluginEngine != null) && ((this.jsPluginEngine.appBrandRuntime instanceof GameBrandRuntime));
  }
  
  protected void miniLogD(String paramString1, int paramInt, String paramString2)
  {
    MiniLog.d(paramString1, paramInt, this.appId, paramString2);
  }
  
  protected void miniLogE(String paramString1, int paramInt, String paramString2)
  {
    MiniLog.e(paramString1, paramInt, this.appId, paramString2);
  }
  
  protected void miniLogE(String paramString1, int paramInt, String paramString2, Throwable paramThrowable)
  {
    MiniLog.e(paramString1, paramInt, this.appId, paramString2, paramThrowable);
  }
  
  protected void miniLogI(String paramString1, int paramInt, String paramString2)
  {
    MiniLog.i(paramString1, paramInt, this.appId, paramString2);
  }
  
  protected void miniLogW(String paramString1, int paramInt, String paramString2)
  {
    MiniLog.w(paramString1, paramInt, this.appId, paramString2);
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    this.jsPluginEngine = paramBaseJsPluginEngine;
    this.isGameRuntime = (paramBaseJsPluginEngine instanceof GameJsPluginEngine);
    setAppId(paramBaseJsPluginEngine);
  }
  
  public void onDestroy()
  {
    this.isDestroy = true;
  }
  
  public void onPause() {}
  
  public void onResume()
  {
    this.isDestroy = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPlugin
 * JD-Core Version:    0.7.0.1
 */