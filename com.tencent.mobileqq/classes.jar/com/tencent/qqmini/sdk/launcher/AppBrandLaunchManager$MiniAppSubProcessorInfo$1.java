package com.tencent.qqmini.sdk.launcher;

import beqa;
import betc;
import com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo;

public class AppBrandLaunchManager$MiniAppSubProcessorInfo$1
  implements Runnable
{
  public AppBrandLaunchManager$MiniAppSubProcessorInfo$1(beqa parambeqa) {}
  
  public void run()
  {
    String str2 = null;
    if (this.a.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo != null) {}
    for (String str1 = this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.appId;; str1 = null)
    {
      if (this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo != null) {
        str2 = this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppBaseInfo.name;
      }
      betc.b("minisdk-start_AppBrandLaunchManager", "recycle process=" + this.a.jdField_a_of_type_JavaLangString + " appId=" + str1 + " appName=" + str2);
      this.a.jdField_a_of_type_ComTencentQqminiSdkLauncherAppBrandLaunchManager.forceKillProcess(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.AppBrandLaunchManager.MiniAppSubProcessorInfo.1
 * JD-Core Version:    0.7.0.1
 */