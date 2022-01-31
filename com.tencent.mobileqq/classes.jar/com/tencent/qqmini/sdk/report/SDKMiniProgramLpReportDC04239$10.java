package com.tencent.qqmini.sdk.report;

import android.os.Bundle;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public final class SDKMiniProgramLpReportDC04239$10
  implements Runnable
{
  public SDKMiniProgramLpReportDC04239$10(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("app_config", this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    localBundle.putString("actiontype", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("sub_action", this.b);
    localBundle.putString("path", this.c);
    localBundle.putString("reserves", this.d);
    localBundle.putString("reserves2", this.e);
    localBundle.putString("app_type", this.f);
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).callServer("MiniAppTransferModule", "launch_report_sdk_4239", localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.10
 * JD-Core Version:    0.7.0.1
 */