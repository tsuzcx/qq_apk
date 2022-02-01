package com.tencent.qqmini.minigame.manager;

import android.support.annotation.Nullable;
import com.tencent.qqmini.minigame.GameJsPluginEngine;
import com.tencent.qqmini.minigame.gpkg.GpkgManager.Info;
import com.tencent.qqmini.minigame.gpkg.GpkgManager.OnInitGpkgListener;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

final class JsApiUpdateManager$2
  implements GpkgManager.OnInitGpkgListener
{
  JsApiUpdateManager$2(GameJsPluginEngine paramGameJsPluginEngine) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong) {}
  
  public void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString, @Nullable GpkgManager.Info paramInfo)
  {
    if ((paramInt == 0) && (paramMiniGamePkg != null))
    {
      if ((this.val$gameJsPluginEngine != null) && (this.val$gameJsPluginEngine.getRuntime() != null)) {
        ((MiniAppFileManager)this.val$gameJsPluginEngine.getRuntime().getManager(MiniAppFileManager.class)).initFileManager(paramMiniGamePkg, true);
      }
      ThreadManager.executeOnDiskIOThreadPool(new JsApiUpdateManager.2.1(this));
      JsApiUpdateManager.access$200(this.val$gameJsPluginEngine, true);
      return;
    }
    JsApiUpdateManager.access$200(this.val$gameJsPluginEngine, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.manager.JsApiUpdateManager.2
 * JD-Core Version:    0.7.0.1
 */