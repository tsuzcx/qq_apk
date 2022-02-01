package com.tencent.replacemonitor.replace.a;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.replacemonitor.MonitorResult;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.replacemonitor.MonitorType;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.d;
import com.tencent.tmassistantbase.util.q;
import java.io.File;
import java.util.List;

public class a
  implements i
{
  public MonitorResult a(MonitorTask paramMonitorTask, MonitorStep paramMonitorStep)
  {
    ab.c("WashMonitor", "AppNameMonitorAction>>" + paramMonitorTask.appName + "开始通过AppName比较检测洗包 step = " + paramMonitorStep);
    if (paramMonitorTask.appType != 2) {
      return new MonitorResult(paramMonitorStep, 0, paramMonitorStep + "非联运游戏不需要做应用名检测", a());
    }
    if (((paramMonitorStep == MonitorStep.AFTER_INSTALL) || (paramMonitorStep == MonitorStep.INSTALLING)) && (!q.a(paramMonitorTask.packageName, paramMonitorTask.versionCode)))
    {
      Object localObject = q.d(paramMonitorTask.appName);
      if (!d.a((List)localObject))
      {
        paramMonitorStep = new MonitorResult(paramMonitorStep, 1, paramMonitorStep + "通过应用名称比对发现洗包", a());
        localObject = (PackageInfo)((List)localObject).get(0);
        paramMonitorStep.replacedPkgName = ((PackageInfo)localObject).packageName;
        paramMonitorStep.replacedVersionCode = ((PackageInfo)localObject).versionCode;
        paramMonitorStep.replaceTime = ((PackageInfo)localObject).lastUpdateTime;
        paramMonitorTask.installDir = ((PackageInfo)localObject).applicationInfo.sourceDir;
        if (!TextUtils.isEmpty(paramMonitorTask.installDir))
        {
          paramMonitorTask = new File(paramMonitorTask.installDir);
          if (paramMonitorTask.exists()) {
            paramMonitorStep.replacedFileSize = paramMonitorTask.length();
          }
        }
        return paramMonitorStep;
      }
    }
    return new MonitorResult(paramMonitorStep, 0, paramMonitorStep + "通过应用名称检测通过", a());
  }
  
  public MonitorType a()
  {
    return MonitorType.BY_APP_NAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.a.a
 * JD-Core Version:    0.7.0.1
 */