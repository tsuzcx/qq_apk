package com.tencent.qqmini.sdk.minigame.plugins;

import bgok;
import bgxq;
import bgyt;
import bgyu;
import bhaj;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class SubpackageJsPlugin$1
  implements bgyt
{
  private float lastProgress;
  
  SubpackageJsPlugin$1(SubpackageJsPlugin paramSubpackageJsPlugin, String paramString, int paramInt, bgok parambgok) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    if (paramFloat - this.lastProgress > 0.01F)
    {
      this.lastProgress = paramFloat;
      paramMiniAppInfo = null;
      if ((SubpackageJsPlugin.access$200(this.this$0) instanceof bgxq)) {
        paramMiniAppInfo = ((bgxq)SubpackageJsPlugin.access$300(this.this$0)).a();
      }
      if (paramMiniAppInfo == null) {
        bhaj.a().e("SubpackageJsPlugin", "loadSubPackage onInitGpkgInfo but ttEngine is null");
      }
    }
    else
    {
      return;
    }
    paramMiniAppInfo.getJsRuntime(1).runOnJsThread(new SubpackageJsPlugin.1.2(this, paramFloat, paramLong));
  }
  
  public void onInitGpkgInfo(int paramInt, bgyu parambgyu, String paramString)
  {
    String str = null;
    if ((SubpackageJsPlugin.access$000(this.this$0) instanceof bgxq)) {}
    for (ITTEngine localITTEngine = ((bgxq)SubpackageJsPlugin.access$100(this.this$0)).a();; localITTEngine = null)
    {
      if (localITTEngine == null)
      {
        bhaj.a().e("SubpackageJsPlugin", "loadSubPackage onInitGpkgInfo but ttEngine is null");
        return;
      }
      bhaj.a().i("SubpackageJsPlugin", "loadSubPackage callback onInitGpkgInfo, resCode:" + paramInt + ", error msg=" + paramString);
      IGameLauncher localIGameLauncher = localITTEngine.getGameLauncher();
      if (parambgyu != null) {
        str = parambgyu.getRootPath(this.val$subPackageName);
      }
      localITTEngine.getJsRuntime(1).runOnJsThread(new SubpackageJsPlugin.1.1(this, paramInt, str, paramString, localIGameLauncher));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.SubpackageJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */