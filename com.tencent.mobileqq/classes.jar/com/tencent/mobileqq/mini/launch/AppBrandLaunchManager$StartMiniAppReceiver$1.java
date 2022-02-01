package com.tencent.mobileqq.mini.launch;

import android.content.Context;
import com.tencent.mobileqq.mini.app.AppLoaderFactory;
import com.tencent.mobileqq.mini.cache.Storage;
import com.tencent.mobileqq.mini.utils.MiniAppGlobal;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class AppBrandLaunchManager$StartMiniAppReceiver$1
  implements Runnable
{
  AppBrandLaunchManager$StartMiniAppReceiver$1(AppBrandLaunchManager.StartMiniAppReceiver paramStartMiniAppReceiver, String paramString1, Context paramContext, String paramString2) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppLoaderFactory.PATH_WXAPKG_ROOT);
    ((StringBuilder)localObject).append(this.val$appid);
    ((StringBuilder)localObject).append("_debug");
    localObject = ((StringBuilder)localObject).toString();
    if (new File((String)localObject).exists()) {
      FileUtils.delete((String)localObject, false);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(MiniAppGlobal.getMiniCacheFilePath());
    ((StringBuilder)localObject).append(MD5.toMD5(this.val$appid));
    localObject = ((StringBuilder)localObject).toString();
    if (new File((String)localObject).exists()) {
      FileUtils.delete((String)localObject, false);
    }
    localObject = Storage.getCacheDir(this.val$context.getCacheDir().getAbsolutePath(), this.val$uin, this.val$appid);
    if ((localObject != null) && (new File((String)localObject).exists())) {
      FileUtils.delete((String)localObject, false);
    }
    QLog.e("debug", 1, "clear miniapp");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.StartMiniAppReceiver.1
 * JD-Core Version:    0.7.0.1
 */