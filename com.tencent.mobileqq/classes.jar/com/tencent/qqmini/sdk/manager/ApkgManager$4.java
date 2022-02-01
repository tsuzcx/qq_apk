package com.tencent.qqmini.sdk.manager;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import java.io.File;

class ApkgManager$4
  implements Runnable
{
  ApkgManager$4(ApkgManager paramApkgManager, MiniAppInfo paramMiniAppInfo, String paramString) {}
  
  public void run()
  {
    int i = 0;
    try
    {
      if ((this.val$miniAppInfo != null) && (!TextUtils.isEmpty(this.val$curPath)))
      {
        String str1 = ApkgManager.getPkgRoot(this.val$miniAppInfo);
        String str2 = MD5Utils.toMD5(this.val$miniAppInfo.appId);
        Object localObject = new File(str1);
        if (((File)localObject).isDirectory())
        {
          localObject = ((File)localObject).list();
          int j = localObject.length;
          while (i < j)
          {
            CharSequence localCharSequence = localObject[i];
            if ((!TextUtils.isEmpty(localCharSequence)) && (localCharSequence.startsWith(str2)) && (!this.val$curPath.contains(localCharSequence)))
            {
              QMLog.d("ApkgManager", "delete pkg : " + localCharSequence);
              FileUtils.delete(str1 + localCharSequence, false);
            }
            i += 1;
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("ApkgManager", "deleteOldPkg error,", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.ApkgManager.4
 * JD-Core Version:    0.7.0.1
 */