package com.tencent.tbs.one.impl.policy.auto;

import android.content.Context;
import com.tencent.tbs.one.impl.base.GlobalUtils;
import com.tencent.tbs.one.impl.common.PathService;
import com.tencent.tbs.one.impl.common.Statistics;
import com.tencent.tbs.one.impl.policy.InstallationResult;
import com.tencent.tbs.one.impl.policy.InstallationResult.Source;
import com.tencent.tbs.one.impl.policy.InstallationUtils;
import java.io.File;

class AutoComponentInstallationJob$2
  implements Runnable
{
  AutoComponentInstallationJob$2(AutoComponentInstallationJob paramAutoComponentInstallationJob, Context paramContext, File paramFile, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    if (AutoComponentInstallationJob.access$100(this.this$0))
    {
      this.this$0.finish(InstallationResult.make(InstallationResult.Source.SHARING, AutoComponentInstallationJob.access$200(this.this$0)));
      return;
    }
    if (AutoComponentInstallationJob.access$300(this.this$0))
    {
      this.this$0.finish(InstallationResult.make(InstallationResult.Source.SDCARD_FILE, AutoComponentInstallationJob.access$200(this.this$0)));
      return;
    }
    if ((!AutoComponentInstallationJob.access$400(this.this$0)) && (!GlobalUtils.isWifiConnected(this.val$callerContext)))
    {
      AutoComponentInstallationJob.access$501(this.this$0, 201, "current network is unavialable,no need sendrequest to server", null);
      return;
    }
    if (!AutoComponentInstallationJob.access$600(this.this$0))
    {
      long l = InstallationUtils.getLastFailedTimeMillis(this.val$outputDirectory);
      if (System.currentTimeMillis() - l < 86400000L)
      {
        AutoComponentInstallationJob.access$701(this.this$0, 214, "Too many component requests, last request time: " + GlobalUtils.formatDateTime(l), null);
        return;
      }
      InstallationUtils.clearLastFailedTimeMillis(this.val$outputDirectory);
    }
    if (AutoComponentInstallationJob.access$800(this.this$0)) {
      Statistics.reportAction(1013, AutoComponentInstallationJob.access$900(this.this$0));
    }
    for (;;)
    {
      int i = InstallationUtils.getLocalComponentVersion(PathService.getComponentDirectory(PathService.getCategoryDirectory(PathService.getDataRootDirectory(this.val$callerContext), this.val$category), this.val$name));
      AutoComponentInstallationJob.access$1100(this.this$0, this.val$callerContext, this.val$category, this.val$name, this.val$versionCode, AutoComponentInstallationJob.access$1000(this.this$0), i);
      return;
      Statistics.reportAction(1003, AutoComponentInstallationJob.access$900(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.policy.auto.AutoComponentInstallationJob.2
 * JD-Core Version:    0.7.0.1
 */