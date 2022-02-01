package com.tencent.qqmini.proxyimpl;

import bjxj;
import bjxn;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;

public class MiniSDKClientQIPCModule$2
  implements Runnable
{
  public MiniSDKClientQIPCModule$2(bjxj parambjxj, BaseRuntime paramBaseRuntime, String paramString) {}
  
  public void run()
  {
    MiniProgramLpReportDC04239.reportApiInvoke(bjxn.a(this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreBaseRuntime.getMiniAppInfo()), this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule.2
 * JD-Core Version:    0.7.0.1
 */