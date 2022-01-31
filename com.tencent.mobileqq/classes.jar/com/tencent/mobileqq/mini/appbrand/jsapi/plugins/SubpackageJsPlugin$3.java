package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager.OnInitGpkgListener;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import java.lang.ref.WeakReference;

class SubpackageJsPlugin$3
  implements GpkgManager.OnInitGpkgListener
{
  private float lastProgress;
  
  SubpackageJsPlugin$3(SubpackageJsPlugin paramSubpackageJsPlugin, GameRuntimeLoader paramGameRuntimeLoader, String paramString, WeakReference paramWeakReference, int paramInt) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    if (paramFloat - this.lastProgress > 0.01F)
    {
      this.lastProgress = paramFloat;
      paramMiniAppInfo = GameRuntimeLoaderManager.g().getBindRuntimeLoader(this.this$0.jsPluginEngine.appBrandRuntime.activity).getGameEngine();
      if (paramMiniAppInfo == null) {
        GameLog.getInstance().e("SubpackageJsPlugin", "loadSubPackage onInitGpkgInfo but ttEngine is null");
      }
    }
    else
    {
      return;
    }
    paramMiniAppInfo.getJsRuntime(1).runOnJsThread(new SubpackageJsPlugin.3.2(this, paramFloat, paramLong));
  }
  
  public void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString)
  {
    ITTEngine localITTEngine = this.val$currentLoader.getGameEngine();
    if (localITTEngine == null)
    {
      GameLog.getInstance().e("SubpackageJsPlugin", "loadSubPackage onInitGpkgInfo but ttEngine is null");
      return;
    }
    GameLog.getInstance().i("SubpackageJsPlugin", "loadSubPackage callback onInitGpkgInfo, resCode:" + paramInt + ", error msg=" + paramString);
    IGameLauncher localIGameLauncher = localITTEngine.getGameLauncher();
    if (paramMiniGamePkg != null) {}
    for (paramMiniGamePkg = paramMiniGamePkg.getRootPath(this.val$subPackageName);; paramMiniGamePkg = null)
    {
      localITTEngine.getJsRuntime(1).runOnJsThread(new SubpackageJsPlugin.3.1(this, paramInt, paramMiniGamePkg, paramString, localIGameLauncher));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SubpackageJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */