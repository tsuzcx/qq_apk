package com.tencent.replacemonitor.replace.a;

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

public class b
  implements i
{
  private MonitorResult a(MonitorTask paramMonitorTask, String paramString1, String paramString2, MonitorStep paramMonitorStep)
  {
    ab.c("WashMonitor", "ChannedlIdMonitorAction>>checkByChannelId " + paramMonitorTask.appName + " task.cpChannelId = " + paramString2 + " fileChannelId = " + paramString2 + " filePath =" + paramString1);
    if (TextUtils.isEmpty(paramString1)) {
      paramMonitorTask = new MonitorResult(paramMonitorStep, 3, "通过渠道号检测时发现filePath为空", a());
    }
    for (;;)
    {
      return paramMonitorTask;
      if (TextUtils.isEmpty(paramString2)) {
        break label345;
      }
      try
      {
        String str = a.a(paramString1);
        ab.c("WashMonitor", "ChannedlIdMonitorAction>>checkByChannelId " + paramMonitorTask.appName + " task.cpChannelId = " + paramMonitorTask.cpChannelId + " fileChannelId = " + str);
        if ((!TextUtils.isEmpty(str)) && (!paramString2.equals(str)))
        {
          paramString2 = new MonitorResult(paramMonitorStep, 1, "通过渠道号检测发现洗包", a());
          File localFile = new File(paramString1);
          long l = 0L;
          if (localFile.exists()) {
            l = localFile.length();
          }
          paramString2.replaceChannelId = str;
          paramString2.replacedFileSize = l;
          paramString2.replaceTime = localFile.lastModified();
          paramString1 = q.b(paramString1);
          if ((paramMonitorStep == MonitorStep.INSTALLING) || (paramMonitorStep == MonitorStep.AFTER_INSTALL)) {
            paramString1 = q.c(paramMonitorTask.packageName);
          }
          paramMonitorTask = paramString2;
          if (paramString1 == null) {
            continue;
          }
          paramString2.replacedPkgName = paramString1.packageName;
          paramString2.replacedVersionCode = paramString1.versionCode;
          if (paramMonitorStep != MonitorStep.INSTALLING)
          {
            paramMonitorTask = paramString2;
            if (paramMonitorStep != MonitorStep.AFTER_INSTALL) {
              continue;
            }
          }
          paramString2.replaceTime = paramString1.lastUpdateTime;
          return paramString2;
        }
      }
      catch (IOException paramMonitorTask)
      {
        paramMonitorTask.printStackTrace();
      }
    }
    return new MonitorResult(paramMonitorStep, 0, paramMonitorStep + "渠道号检测通过", a());
    label345:
    return new MonitorResult(paramMonitorStep, 0, paramMonitorStep + "task.cpChannelId为空", a());
  }
  
  public MonitorResult a(MonitorTask paramMonitorTask, MonitorStep paramMonitorStep)
  {
    ab.c("WashMonitor", "ChannedlIdMonitorAction>>" + paramMonitorTask.appName + "开始通过渠道号比较检测洗包 step = " + paramMonitorStep);
    if (TextUtils.isEmpty(paramMonitorTask.cpChannelId)) {
      return new MonitorResult(paramMonitorStep, 0, "渠道号检测暂时不做, task.cpChannelId is empty", a());
    }
    if (paramMonitorTask.appType == 3) {}
    switch (c.a[paramMonitorStep.ordinal()])
    {
    default: 
      return new MonitorResult(paramMonitorStep, 0, "渠道号检测暂时不做", a());
    case 1: 
      return a(paramMonitorTask, paramMonitorTask.filePath, paramMonitorTask.cpChannelId, paramMonitorStep);
    }
    return a(paramMonitorTask, paramMonitorTask.installDir, paramMonitorTask.cpChannelId, paramMonitorStep);
  }
  
  public MonitorType a()
  {
    return MonitorType.BY_CHANNEL_ID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.a.b
 * JD-Core Version:    0.7.0.1
 */