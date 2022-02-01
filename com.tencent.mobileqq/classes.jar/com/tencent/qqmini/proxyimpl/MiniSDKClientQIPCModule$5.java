package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;

class MiniSDKClientQIPCModule$5
  implements Runnable
{
  MiniSDKClientQIPCModule$5(MiniSDKClientQIPCModule paramMiniSDKClientQIPCModule, BaseRuntime paramBaseRuntime, String paramString) {}
  
  public void run()
  {
    MiniProgramLpReportDC04239.reportApiInvoke(MiniSdkUtil.b(this.a.getMiniAppInfo()), this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniSDKClientQIPCModule.5
 * JD-Core Version:    0.7.0.1
 */