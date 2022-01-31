package com.tencent.qqmini.sdk.report;

import android.os.Bundle;
import bgpn;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public final class MiniAppReportManager2$1
  implements Runnable
{
  public MiniAppReportManager2$1(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("app_config", this.jdField_a_of_type_ComTencentQqminiSdkLauncherModelMiniAppInfo);
    localBundle.putString("action_type", "page_view");
    localBundle.putString("sub_action", this.jdField_a_of_type_JavaLangString);
    localBundle.putString("path", this.b);
    localBundle.putString("reserves", this.c);
    bgpn.a().a("launch_report2", localBundle, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniAppReportManager2.1
 * JD-Core Version:    0.7.0.1
 */