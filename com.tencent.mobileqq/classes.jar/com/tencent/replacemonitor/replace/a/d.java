package com.tencent.replacemonitor.replace.a;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.dlsdk.yybutil.apkchannel.a;
import com.tencent.replacemonitor.MonitorResult;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.replacemonitor.MonitorType;
import com.tencent.tmassistantbase.util.ac;
import com.tencent.tmassistantbase.util.r;
import java.io.File;
import java.io.IOException;

public class d
  implements i
{
  private void a(MonitorTask paramMonitorTask, MonitorStep paramMonitorStep, MonitorResult paramMonitorResult, String paramString)
  {
    ac.c("WashMonitor", "FileSizeMonitorAction>>commonFileSizeCheck " + paramMonitorTask.appName + " task.fileSize = " + paramMonitorTask.fileSize + " filePath = " + paramString);
    if ((TextUtils.isEmpty(paramString)) || (paramMonitorTask.fileSize <= 0L)) {
      paramMonitorResult.resultMsg = (paramMonitorStep + " filePath is " + paramString + " fileSize is " + paramMonitorTask.fileSize);
    }
    for (;;)
    {
      return;
      File localFile = new File(paramString);
      if (localFile.exists())
      {
        ac.c("WashMonitor", "FileSizeMonitorAction>>commonFileSizeCheck " + paramMonitorTask.appName + " task.fileSize = " + paramMonitorTask.fileSize + " file.length() = " + localFile.length());
        if (localFile.length() == paramMonitorTask.fileSize) {
          continue;
        }
        paramMonitorResult.resultCode = 1;
        paramMonitorResult.resultMsg = (paramMonitorStep + "通过filesize检测到洗包");
        paramMonitorResult.replaceTime = localFile.lastModified();
        paramMonitorResult.replacedFileSize = localFile.length();
        if (paramMonitorTask.appType == 3) {}
        try
        {
          paramMonitorResult.replaceChannelId = a.a(paramString);
          paramMonitorTask = r.c(paramMonitorTask.packageName);
          if ((paramMonitorStep == MonitorStep.DOWNLOADING) || (paramMonitorStep == MonitorStep.BEFORE_INSTALL)) {
            paramMonitorTask = r.b(paramString);
          }
          if (paramMonitorTask != null)
          {
            paramMonitorResult.replacedPkgName = paramMonitorTask.packageName;
            paramMonitorResult.replacedVersionCode = paramMonitorTask.versionCode;
            if ((paramMonitorStep == MonitorStep.INSTALLING) || (paramMonitorStep == MonitorStep.AFTER_INSTALL))
            {
              paramMonitorResult.replaceTime = paramMonitorTask.lastUpdateTime;
              return;
            }
          }
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
      }
    }
    paramMonitorResult.resultMsg = (paramMonitorStep + " FileSize检测未找到文件");
  }
  
  public MonitorResult a(MonitorTask paramMonitorTask, MonitorStep paramMonitorStep)
  {
    ac.c("WashMonitor", "FileSizeMonitorAction>>" + paramMonitorTask.appName + "开始通过FileSize比较检测洗包 step = " + paramMonitorStep);
    MonitorResult localMonitorResult = new MonitorResult(paramMonitorStep, 0, paramMonitorStep + "通过filesize检测通过", a());
    if (TextUtils.isEmpty(paramMonitorTask.filePath)) {
      localMonitorResult.resultMsg = (paramMonitorStep + " 通过filesize检测通过，因为task.filePath为空， task.filePath = " + paramMonitorTask.filePath);
    }
    switch (e.a[paramMonitorStep.ordinal()])
    {
    default: 
      return localMonitorResult;
    case 1: 
    case 2: 
      a(paramMonitorTask, paramMonitorStep, localMonitorResult, paramMonitorTask.filePath);
      return localMonitorResult;
    }
    a(paramMonitorTask, paramMonitorStep, localMonitorResult, paramMonitorTask.installDir);
    return localMonitorResult;
  }
  
  public MonitorType a()
  {
    return MonitorType.BY_FILE_SIZE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.a.d
 * JD-Core Version:    0.7.0.1
 */