package com.tencent.mobileqq.minigame.api;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager.OnInitGpkgListener;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.sdk.ITSubPackage;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;

class APIProxyImpl$2
  implements GpkgManager.OnInitGpkgListener
{
  private float lastProgress;
  
  APIProxyImpl$2(APIProxyImpl paramAPIProxyImpl, String paramString, ITSubPackage paramITSubPackage, long paramLong1, long paramLong2) {}
  
  public void onDownloadGpkgProgress(MiniAppInfo paramMiniAppInfo, float paramFloat, long paramLong)
  {
    if (paramFloat - this.lastProgress > 0.01F)
    {
      this.lastProgress = paramFloat;
      if (APIProxyImpl.access$000(this.this$0) == null) {
        GameLog.getInstance().e("subpackage", "loadSubPackage onInitGpkgInfo but mTTEngine is null");
      }
    }
    else
    {
      return;
    }
    APIProxyImpl.access$000(this.this$0).getJsRuntime(1).runOnJsThread(new APIProxyImpl.2.2(this, paramFloat, paramLong));
  }
  
  public void onInitGpkgInfo(int paramInt, MiniGamePkg paramMiniGamePkg, String paramString)
  {
    if (APIProxyImpl.access$000(this.this$0) == null)
    {
      GameLog.getInstance().e("subpackage", "loadSubPackage onInitGpkgInfo but mTTEngine is null");
      return;
    }
    GameLog.getInstance().i("subpackage", "loadSubPackage callback onInitGpkgInfo, resCode:" + paramInt + ", error msg=" + paramString);
    APIProxyImpl.access$000(this.this$0).getJsRuntime(1).runOnJsThread(new APIProxyImpl.2.1(this, paramMiniGamePkg, paramInt, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.APIProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */