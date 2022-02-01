package com.tencent.qqmini.proxyimpl;

import bkyl;
import bkyr;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;

public class MiniSDKClientQIPCModule$4
  implements Runnable
{
  public MiniSDKClientQIPCModule$4(bkyl parambkyl, BaseRuntime paramBaseRuntime, String paramString) {}
  
  public void run()
  {
    MiniProgramLpReportDC04239.reportApiInvoke(bkyr.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime.getMiniAppInfo()), this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule.4
 * JD-Core Version:    0.7.0.1
 */