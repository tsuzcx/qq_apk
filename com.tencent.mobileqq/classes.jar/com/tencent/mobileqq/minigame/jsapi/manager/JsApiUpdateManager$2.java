package com.tencent.mobileqq.minigame.jsapi.manager;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager.OnInitGpkgListener;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.jsapi.GameJsPluginEngine;

final class JsApiUpdateManager$2
  implements GpkgManager.OnInitGpkgListener
{
  JsApiUpdateManager$2(GameJsPluginEngine paramGameJsPluginEngine) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong) {}
  
  public void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString)
  {
    if ((paramInt == 0) && (paramMiniGamePkg != null))
    {
      MiniAppFileManager.getInstance().initFileManager(paramMiniGamePkg, true);
      ThreadManagerV2.excute(new JsApiUpdateManager.2.1(this), 16, null, true);
      JsApiUpdateManager.access$200(this.val$gameJsPluginEngine, true);
      return;
    }
    JsApiUpdateManager.access$200(this.val$gameJsPluginEngine, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.manager.JsApiUpdateManager.2
 * JD-Core Version:    0.7.0.1
 */