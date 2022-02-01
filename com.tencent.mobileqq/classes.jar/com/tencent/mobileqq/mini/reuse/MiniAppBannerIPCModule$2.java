package com.tencent.mobileqq.mini.reuse;

import android.os.Bundle;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;

final class MiniAppBannerIPCModule$2
  implements Runnable
{
  MiniAppBannerIPCModule$2(ApkgInfo paramApkgInfo, String paramString) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("appid", this.val$apkgInfo.appId);
    localBundle.putString("apkgName", this.val$apkgInfo.apkgName);
    localBundle.putString("iconUrl", this.val$apkgInfo.iconUrl);
    localBundle.putParcelable("appConfig", this.val$apkgInfo.appConfig);
    QIPCClientHelper.getInstance().callServer("MiniAppBannerIPCModule", this.val$action, localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniAppBannerIPCModule.2
 * JD-Core Version:    0.7.0.1
 */