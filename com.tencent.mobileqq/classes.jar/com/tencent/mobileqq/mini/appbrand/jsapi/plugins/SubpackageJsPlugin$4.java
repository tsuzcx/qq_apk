package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager.Info;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager.OnInitGpkgListener;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

class SubpackageJsPlugin$4
  implements GpkgManager.OnInitGpkgListener
{
  private float lastProgress;
  
  SubpackageJsPlugin$4(SubpackageJsPlugin paramSubpackageJsPlugin, String paramString, WeakReference paramWeakReference, int paramInt1, GameRuntimeLoader paramGameRuntimeLoader, MiniGamePkg paramMiniGamePkg, int paramInt2) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    if (paramFloat - this.lastProgress > 0.01F)
    {
      this.lastProgress = paramFloat;
      if (this.val$webviewRef == null) {
        break label40;
      }
    }
    label40:
    for (paramMiniAppInfo = (JsRuntime)this.val$webviewRef.get(); paramMiniAppInfo == null; paramMiniAppInfo = null) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("taskId", this.val$taskId);
      localJSONObject.put("state", "progressUpdate");
      localJSONObject.put("progress", 100.0F * paramFloat);
      localJSONObject.put("totalBytesWritten", ((float)paramLong * paramFloat));
      localJSONObject.put("totalBytesExpectedToWrite", paramLong);
      paramMiniAppInfo.evaluateSubcribeJS("onLoadSubPackageTaskStateChange", localJSONObject.toString(), -1);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString, GpkgManager.Info paramInfo)
  {
    GameLog.getInstance().i("SubpackageJsPlugin", "loadSubPackage " + this.val$subPackageName + " callback onInitGpkgInfo, resCode:" + paramInt + ", error msg:" + paramString);
    if (paramInt != 0)
    {
      SubpackageJsPlugin.access$100(this.this$0, this.val$webviewRef, this.val$taskId, false);
      return;
    }
    paramString = this.val$currentLoader.getGameEngine();
    if (paramString == null)
    {
      GameLog.getInstance().e("SubpackageJsPlugin", "loadSubPackage onInitGpkgInfo but ttEngine is null");
      return;
    }
    paramInfo = paramString.getGameLauncher();
    if (paramMiniGamePkg != null) {}
    for (paramMiniGamePkg = paramMiniGamePkg.getRootPath(this.val$subPackageName);; paramMiniGamePkg = null)
    {
      paramString.getJsRuntime(1).runOnJsThread(new SubpackageJsPlugin.4.1(this, paramInfo, paramMiniGamePkg));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.SubpackageJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */