package com.tencent.replacemonitor.replace.a;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.dlsdk.yybutil.apkchannel.a;
import com.tencent.replacemonitor.MonitorResult;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.replacemonitor.MonitorType;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.q;
import java.io.File;
import java.io.IOException;

public class j
  implements i
{
  public MonitorResult a(MonitorTask paramMonitorTask, MonitorStep paramMonitorStep)
  {
    ab.c("WashMonitor", "VersionCodeMonitorAction>>" + paramMonitorTask.appName + "开始通过VersionCode比较检测洗包 step = " + paramMonitorStep);
    if ((paramMonitorStep == MonitorStep.INSTALLING) || (paramMonitorStep == MonitorStep.AFTER_INSTALL))
    {
      PackageInfo localPackageInfo = q.c(paramMonitorTask.packageName);
      if ((localPackageInfo != null) && (paramMonitorTask.versionCode > 0) && (paramMonitorTask.versionCode > localPackageInfo.versionCode))
      {
        paramMonitorStep = new MonitorResult(paramMonitorStep, 1, "通过版本号对比发现安装了版本号更低的包，确认洗包", a());
        paramMonitorStep.replaceTime = localPackageInfo.lastUpdateTime;
        paramMonitorStep.replacedPkgName = localPackageInfo.packageName;
        paramMonitorStep.replacedVersionCode = localPackageInfo.versionCode;
        if (!TextUtils.isEmpty(localPackageInfo.applicationInfo.sourceDir))
        {
          File localFile = new File(localPackageInfo.applicationInfo.sourceDir);
          if (localFile.exists()) {
            paramMonitorStep.replacedFileSize = localFile.length();
          }
        }
        if (paramMonitorTask.appType == 3) {}
        try
        {
          paramMonitorStep.replaceChannelId = a.a(localPackageInfo.applicationInfo.sourceDir);
          return paramMonitorStep;
        }
        catch (IOException paramMonitorTask)
        {
          paramMonitorTask.printStackTrace();
          return paramMonitorStep;
        }
      }
    }
    return new MonitorResult(paramMonitorStep, 0, "版本号洗包检测通过", a());
  }
  
  public MonitorType a()
  {
    return MonitorType.BY_VERSION_CODE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.a.j
 * JD-Core Version:    0.7.0.1
 */