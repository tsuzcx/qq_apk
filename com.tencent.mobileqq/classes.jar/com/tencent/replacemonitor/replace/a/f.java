package com.tencent.replacemonitor.replace.a;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.dlsdk.yybutil.apkchannel.a;
import com.tencent.replacemonitor.MonitorResult;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.replacemonitor.MonitorType;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.n;
import com.tencent.tmassistantbase.util.q;
import java.io.File;
import java.io.IOException;

public class f
  implements i
{
  private void a(MonitorTask paramMonitorTask, String paramString, MonitorResult paramMonitorResult, MonitorStep paramMonitorStep)
  {
    ab.c("WashMonitor", "MD5MonitorAction>>checkMd5 " + paramMonitorTask.appName + " task.fileMD5 = " + paramMonitorTask.fileMd5 + " filePath = " + paramString);
    if ((paramMonitorTask.fileMd5 != null) && (!TextUtils.isEmpty(paramString)))
    {
      File localFile = new File(paramString);
      if (localFile.exists())
      {
        String str = n.b(paramString);
        ab.c("WashMonitor", "MD5MonitorAction>>checkMd5 " + paramMonitorTask.appName + " task.fileMD5 = " + paramMonitorTask.fileMd5 + " file.md5() = " + str);
        if (paramMonitorTask.fileMd5.equals(str))
        {
          paramMonitorResult.resultCode = 0;
          paramMonitorResult.resultMsg = (paramMonitorStep + " MD5检测通过");
        }
        for (;;)
        {
          return;
          paramMonitorResult.resultCode = 1;
          paramMonitorResult.resultMsg = (paramMonitorStep + " 通过MD5检测发现洗包");
          paramMonitorResult.replaceTime = localFile.lastModified();
          paramMonitorResult.replacedFileSize = localFile.length();
          paramMonitorResult.replaceFileMD5 = str;
          if (paramMonitorTask.appType == 3) {}
          try
          {
            paramMonitorResult.replaceChannelId = a.a(paramString);
            paramString = q.b(paramMonitorTask.filePath);
            if ((paramMonitorStep == MonitorStep.INSTALLING) || (paramMonitorStep == MonitorStep.AFTER_INSTALL))
            {
              paramMonitorTask = q.c(paramMonitorTask.packageName);
              paramString = paramMonitorTask;
              if (paramMonitorTask != null)
              {
                paramMonitorResult.replaceTime = paramMonitorTask.lastUpdateTime;
                paramString = paramMonitorTask;
              }
            }
            if (paramString != null)
            {
              paramMonitorResult.replacedPkgName = paramString.packageName;
              paramMonitorResult.replacedVersionCode = paramString.versionCode;
              return;
            }
          }
          catch (IOException paramString)
          {
            for (;;)
            {
              paramString.printStackTrace();
            }
          }
        }
      }
      paramMonitorResult.resultMsg = (paramMonitorStep + " 执行MD5检测时发现文件不存在");
      return;
    }
    paramMonitorResult.resultMsg = (paramMonitorStep + " 执行MD5检查时fileMD5为空或者filePath为空");
  }
  
  public MonitorResult a(MonitorTask paramMonitorTask, MonitorStep paramMonitorStep)
  {
    ab.c("WashMonitor", "MD5MonitorAction>>" + paramMonitorTask.appName + "开始通过MD5比较检测洗包 step =" + paramMonitorStep);
    MonitorResult localMonitorResult = new MonitorResult(paramMonitorStep, 0, paramMonitorStep + " MD5检测通过", a());
    if ((TextUtils.isEmpty(paramMonitorTask.fileMd5)) || (TextUtils.isEmpty(paramMonitorTask.filePath)))
    {
      localMonitorResult.resultMsg = (paramMonitorStep + " MD5检测通过，因为task.fileMd5 或者 task.filePath为空， task.fileMd5 = " + paramMonitorTask.fileMd5 + " task.filePath = " + paramMonitorTask.filePath);
      return localMonitorResult;
    }
    switch (g.a[paramMonitorStep.ordinal()])
    {
    default: 
      return localMonitorResult;
    case 1: 
    case 2: 
      a(paramMonitorTask, paramMonitorTask.filePath, localMonitorResult, paramMonitorStep);
      return localMonitorResult;
    }
    a(paramMonitorTask, paramMonitorTask.installDir, localMonitorResult, paramMonitorStep);
    return localMonitorResult;
  }
  
  public MonitorType a()
  {
    return MonitorType.BY_FILE_MD5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.a.f
 * JD-Core Version:    0.7.0.1
 */