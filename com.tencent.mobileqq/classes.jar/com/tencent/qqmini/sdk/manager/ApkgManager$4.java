package com.tencent.qqmini.sdk.manager;

import android.text.TextUtils;
import bgpc;
import bgvi;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.MD5Utils;
import java.io.File;

public class ApkgManager$4
  implements Runnable
{
  public ApkgManager$4(bgvi parambgvi, MiniAppInfo paramMiniAppInfo, String paramString) {}
  
  public void run()
  {
    int i = 0;
    try
    {
      if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        String str1 = bgvi.b(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
        String str2 = MD5Utils.toMD5(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
        Object localObject = new File(str1);
        if (((File)localObject).isDirectory())
        {
          localObject = ((File)localObject).list();
          int j = localObject.length;
          while (i < j)
          {
            CharSequence localCharSequence = localObject[i];
            if ((!TextUtils.isEmpty(localCharSequence)) && (localCharSequence.startsWith(str2)) && (!this.jdField_a_of_type_JavaLangString.contains(localCharSequence)))
            {
              QMLog.d("ApkgManager", "delete pkg : " + localCharSequence);
              bgpc.a(str1 + localCharSequence, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.ApkgManager.4
 * JD-Core Version:    0.7.0.1
 */