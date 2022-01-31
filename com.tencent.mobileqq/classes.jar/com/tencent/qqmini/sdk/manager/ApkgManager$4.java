package com.tencent.qqmini.sdk.manager;

import android.text.TextUtils;
import belh;
import betc;
import betd;
import bfgt;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.io.File;

public class ApkgManager$4
  implements Runnable
{
  public void run()
  {
    int i = 0;
    try
    {
      if ((this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        String str1 = betd.b(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
        String str2 = bfgt.c(this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo.appId);
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
              betc.a("ApkgManager", "delete pkg : " + localCharSequence);
              belh.a(str1 + localCharSequence, false);
            }
            i += 1;
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      betc.d("ApkgManager", "deleteOldPkg error,", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.ApkgManager.4
 * JD-Core Version:    0.7.0.1
 */