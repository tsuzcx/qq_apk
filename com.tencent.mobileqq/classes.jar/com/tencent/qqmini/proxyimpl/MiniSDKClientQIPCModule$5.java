package com.tencent.qqmini.proxyimpl;

import bjei;
import bjeo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;

public class MiniSDKClientQIPCModule$5
  implements Runnable
{
  public MiniSDKClientQIPCModule$5(bjei parambjei, BaseRuntime paramBaseRuntime, String paramString) {}
  
  public void run()
  {
    MiniProgramLpReportDC04239.reportApiInvoke(bjeo.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime.getMiniAppInfo()), this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule.5
 * JD-Core Version:    0.7.0.1
 */