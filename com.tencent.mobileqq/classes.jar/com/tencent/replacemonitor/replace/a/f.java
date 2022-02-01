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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MD5MonitorAction>>checkMd5 ");
    ((StringBuilder)localObject).append(paramMonitorTask.appName);
    ((StringBuilder)localObject).append(" task.fileMD5 = ");
    ((StringBuilder)localObject).append(paramMonitorTask.fileMd5);
    ((StringBuilder)localObject).append(" filePath = ");
    ((StringBuilder)localObject).append(paramString);
    ab.c("WashMonitor", ((StringBuilder)localObject).toString());
    if ((paramMonitorTask.fileMd5 != null) && (!TextUtils.isEmpty(paramString)))
    {
      localObject = new File(paramString);
      if (((File)localObject).exists())
      {
        String str = n.b(paramString);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MD5MonitorAction>>checkMd5 ");
        localStringBuilder.append(paramMonitorTask.appName);
        localStringBuilder.append(" task.fileMD5 = ");
        localStringBuilder.append(paramMonitorTask.fileMd5);
        localStringBuilder.append(" file.md5() = ");
        localStringBuilder.append(str);
        ab.c("WashMonitor", localStringBuilder.toString());
        if (paramMonitorTask.fileMd5.equals(str))
        {
          paramMonitorResult.resultCode = 0;
          paramMonitorTask = new StringBuilder();
          paramMonitorTask.append(paramMonitorStep);
          paramMonitorTask.append(" MD5检测通过");
          paramMonitorResult.resultMsg = paramMonitorTask.toString();
          return;
        }
        paramMonitorResult.resultCode = 1;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMonitorStep);
        localStringBuilder.append(" 通过MD5检测发现洗包");
        paramMonitorResult.resultMsg = localStringBuilder.toString();
        paramMonitorResult.replaceTime = ((File)localObject).lastModified();
        paramMonitorResult.replacedFileSize = ((File)localObject).length();
        paramMonitorResult.replaceFileMD5 = str;
        if (paramMonitorTask.appType == 3) {
          try
          {
            paramMonitorResult.replaceChannelId = a.a(paramString);
          }
          catch (IOException paramString)
          {
            paramString.printStackTrace();
          }
        }
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
        }
      }
      else
      {
        paramMonitorTask = new StringBuilder();
        paramMonitorTask.append(paramMonitorStep);
        paramMonitorTask.append(" 执行MD5检测时发现文件不存在");
        paramMonitorResult.resultMsg = paramMonitorTask.toString();
      }
    }
    else
    {
      paramMonitorTask = new StringBuilder();
      paramMonitorTask.append(paramMonitorStep);
      paramMonitorTask.append(" 执行MD5检查时fileMD5为空或者filePath为空");
      paramMonitorResult.resultMsg = paramMonitorTask.toString();
    }
  }
  
  public MonitorResult a(MonitorTask paramMonitorTask, MonitorStep paramMonitorStep)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MD5MonitorAction>>");
    ((StringBuilder)localObject).append(paramMonitorTask.appName);
    ((StringBuilder)localObject).append("开始通过MD5比较检测洗包 step =");
    ((StringBuilder)localObject).append(paramMonitorStep);
    ab.c("WashMonitor", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramMonitorStep);
    ((StringBuilder)localObject).append(" MD5检测通过");
    localObject = new MonitorResult(paramMonitorStep, 0, ((StringBuilder)localObject).toString(), a());
    if ((!TextUtils.isEmpty(paramMonitorTask.fileMd5)) && (!TextUtils.isEmpty(paramMonitorTask.filePath)))
    {
      int i = g.a[paramMonitorStep.ordinal()];
      if ((i != 1) && (i != 2))
      {
        if ((i != 3) && (i != 4)) {
          return localObject;
        }
        a(paramMonitorTask, paramMonitorTask.installDir, (MonitorResult)localObject, paramMonitorStep);
        return localObject;
      }
      a(paramMonitorTask, paramMonitorTask.filePath, (MonitorResult)localObject, paramMonitorStep);
      return localObject;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMonitorStep);
    localStringBuilder.append(" MD5检测通过，因为task.fileMd5 或者 task.filePath为空， task.fileMd5 = ");
    localStringBuilder.append(paramMonitorTask.fileMd5);
    localStringBuilder.append(" task.filePath = ");
    localStringBuilder.append(paramMonitorTask.filePath);
    ((MonitorResult)localObject).resultMsg = localStringBuilder.toString();
    return localObject;
  }
  
  public MonitorType a()
  {
    return MonitorType.BY_FILE_MD5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.a.f
 * JD-Core Version:    0.7.0.1
 */