package com.tencent.qqmini.sdk.minigame.plugins;

import beka;
import beuh;
import bevb;
import bevc;
import bewt;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class SubpackageJsPlugin$1
  implements bevb
{
  private float lastProgress;
  
  SubpackageJsPlugin$1(SubpackageJsPlugin paramSubpackageJsPlugin, String paramString, int paramInt, beka parambeka) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    if (paramFloat - this.lastProgress > 0.01F)
    {
      this.lastProgress = paramFloat;
      paramMiniAppInfo = null;
      if ((SubpackageJsPlugin.access$200(this.this$0) instanceof beuh)) {
        paramMiniAppInfo = ((beuh)SubpackageJsPlugin.access$300(this.this$0)).a();
      }
      if (paramMiniAppInfo == null) {
        bewt.a().e("SubpackageJsPlugin", "loadSubPackage onInitGpkgInfo but ttEngine is null");
      }
    }
    else
    {
      return;
    }
    paramMiniAppInfo.getJsRuntime(1).runOnJsThread(new SubpackageJsPlugin.1.2(this, paramFloat, paramLong));
  }
  
  public void onInitGpkgInfo(int paramInt, bevc parambevc, String paramString)
  {
    String str = null;
    if ((SubpackageJsPlugin.access$000(this.this$0) instanceof beuh)) {}
    for (ITTEngine localITTEngine = ((beuh)SubpackageJsPlugin.access$100(this.this$0)).a();; localITTEngine = null)
    {
      if (localITTEngine == null)
      {
        bewt.a().e("SubpackageJsPlugin", "loadSubPackage onInitGpkgInfo but ttEngine is null");
        return;
      }
      bewt.a().i("SubpackageJsPlugin", "loadSubPackage callback onInitGpkgInfo, resCode:" + paramInt + ", error msg=" + paramString);
      IGameLauncher localIGameLauncher = localITTEngine.getGameLauncher();
      if (parambevc != null) {
        str = parambevc.c(this.val$subPackageName);
      }
      localITTEngine.getJsRuntime(1).runOnJsThread(new SubpackageJsPlugin.1.1(this, paramInt, str, paramString, localIGameLauncher));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.SubpackageJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */