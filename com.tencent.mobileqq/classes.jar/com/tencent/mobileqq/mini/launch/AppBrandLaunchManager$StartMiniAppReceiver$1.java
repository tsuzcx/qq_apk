package com.tencent.mobileqq.mini.launch;

import android.content.Context;
import bgmg;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.cache.Storage;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class AppBrandLaunchManager$StartMiniAppReceiver$1
  implements Runnable
{
  AppBrandLaunchManager$StartMiniAppReceiver$1(AppBrandLaunchManager.StartMiniAppReceiver paramStartMiniAppReceiver, String paramString1, Context paramContext, String paramString2) {}
  
  public void run()
  {
    String str = AppLoaderFactory.PATH_WXAPKG_ROOT + this.val$appid + "_debug";
    if (new File(str).exists()) {
      bgmg.a(str, false);
    }
    str = MiniAppGlobal.getMiniCacheFilePath() + MD5.toMD5(this.val$appid);
    if (new File(str).exists()) {
      bgmg.a(str, false);
    }
    str = Storage.getCacheDir(this.val$context.getCacheDir().getAbsolutePath(), this.val$uin, this.val$appid);
    if (new File(str).exists()) {
      bgmg.a(str, false);
    }
    QLog.e("debug", 1, "clear miniapp");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.StartMiniAppReceiver.1
 * JD-Core Version:    0.7.0.1
 */