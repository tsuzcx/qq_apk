package com.tencent.mobileqq.minigame.api;

import android.text.TextUtils;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.minigame.utils.GameLog;
import com.tencent.mobileqq.triton.sdk.ITSubPackage;

class APIProxyImpl$2$1
  implements Runnable
{
  APIProxyImpl$2$1(APIProxyImpl.2 param2, MiniGamePkg paramMiniGamePkg, int paramInt, String paramString) {}
  
  public void run()
  {
    String str = null;
    if (this.val$gamePkg != null) {
      str = this.val$gamePkg.getRootPath(this.this$1.val$subName);
    }
    GameLog.getInstance().i("subpackage", "loadSubPackage callback onInitGpkgInfo on JSThread, resCode:" + this.val$resCode + ", dirPath:" + str + ", error msg=" + this.val$errorMsg);
    if (this.this$1.val$subPackageInterface != null)
    {
      if ((this.val$resCode == 0) && (!TextUtils.isEmpty(str)))
      {
        this.this$1.val$subPackageInterface.loadFinish(this.this$1.val$object, str, true);
        GameLog.getInstance().e("subpackage", "loadSubpackage loadFinish true");
      }
    }
    else {
      return;
    }
    this.this$1.val$subPackageInterface.loadFinish(this.this$1.val$object, str, false);
    GameLog.getInstance().e("subpackage", "loadSubpackage loadFinish false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.api.APIProxyImpl.2.1
 * JD-Core Version:    0.7.0.1
 */