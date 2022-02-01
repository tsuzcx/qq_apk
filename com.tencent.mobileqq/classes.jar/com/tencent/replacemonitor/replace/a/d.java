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

public class d
  implements i
{
  private void a(MonitorTask paramMonitorTask, MonitorStep paramMonitorStep, MonitorResult paramMonitorResult, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("FileSizeMonitorAction>>commonFileSizeCheck ");
    ((StringBuilder)localObject).append(paramMonitorTask.appName);
    ((StringBuilder)localObject).append(" task.fileSize = ");
    ((StringBuilder)localObject).append(paramMonitorTask.fileSize);
    ((StringBuilder)localObject).append(" filePath = ");
    ((StringBuilder)localObject).append(paramString);
    ab.c("WashMonitor", ((StringBuilder)localObject).toString());
    if ((!TextUtils.isEmpty(paramString)) && (paramMonitorTask.fileSize > 0L))
    {
      localObject = new File(paramString);
      if (((File)localObject).exists())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("FileSizeMonitorAction>>commonFileSizeCheck ");
        localStringBuilder2.append(paramMonitorTask.appName);
        localStringBuilder2.append(" task.fileSize = ");
        localStringBuilder2.append(paramMonitorTask.fileSize);
        localStringBuilder2.append(" file.length() = ");
        localStringBuilder2.append(((File)localObject).length());
        ab.c("WashMonitor", localStringBuilder2.toString());
        if (((File)localObject).length() != paramMonitorTask.fileSize)
        {
          paramMonitorResult.resultCode = 1;
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(paramMonitorStep);
          localStringBuilder2.append("通过filesize检测到洗包");
          paramMonitorResult.resultMsg = localStringBuilder2.toString();
          paramMonitorResult.replaceTime = ((File)localObject).lastModified();
          paramMonitorResult.replacedFileSize = ((File)localObject).length();
          if (paramMonitorTask.appType == 3) {
            try
            {
              paramMonitorResult.replaceChannelId = a.a(paramString);
            }
            catch (IOException localIOException)
            {
              localIOException.printStackTrace();
            }
          }
          paramMonitorTask = q.c(paramMonitorTask.packageName);
          if ((paramMonitorStep == MonitorStep.DOWNLOADING) || (paramMonitorStep == MonitorStep.BEFORE_INSTALL)) {
            paramMonitorTask = q.b(paramString);
          }
          if (paramMonitorTask != null)
          {
            paramMonitorResult.replacedPkgName = paramMonitorTask.packageName;
            paramMonitorResult.replacedVersionCode = paramMonitorTask.versionCode;
            if ((paramMonitorStep == MonitorStep.INSTALLING) || (paramMonitorStep == MonitorStep.AFTER_INSTALL)) {
              paramMonitorResult.replaceTime = paramMonitorTask.lastUpdateTime;
            }
          }
        }
      }
      else
      {
        paramMonitorTask = new StringBuilder();
        paramMonitorTask.append(paramMonitorStep);
        paramMonitorTask.append(" FileSize检测未找到文件");
        paramMonitorResult.resultMsg = paramMonitorTask.toString();
      }
      return;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(paramMonitorStep);
    localStringBuilder1.append(" filePath is ");
    localStringBuilder1.append(paramString);
    localStringBuilder1.append(" fileSize is ");
    localStringBuilder1.append(paramMonitorTask.fileSize);
    paramMonitorResult.resultMsg = localStringBuilder1.toString();
  }
  
  public MonitorResult a(MonitorTask paramMonitorTask, MonitorStep paramMonitorStep)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("FileSizeMonitorAction>>");
    ((StringBuilder)localObject).append(paramMonitorTask.appName);
    ((StringBuilder)localObject).append("开始通过FileSize比较检测洗包 step = ");
    ((StringBuilder)localObject).append(paramMonitorStep);
    ab.c("WashMonitor", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramMonitorStep);
    ((StringBuilder)localObject).append("通过filesize检测通过");
    localObject = new MonitorResult(paramMonitorStep, 0, ((StringBuilder)localObject).toString(), a());
    if (TextUtils.isEmpty(paramMonitorTask.filePath))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMonitorStep);
      localStringBuilder.append(" 通过filesize检测通过，因为task.filePath为空， task.filePath = ");
      localStringBuilder.append(paramMonitorTask.filePath);
      ((MonitorResult)localObject).resultMsg = localStringBuilder.toString();
    }
    int i = e.a[paramMonitorStep.ordinal()];
    if ((i != 1) && (i != 2))
    {
      if ((i != 3) && (i != 4)) {
        return localObject;
      }
      a(paramMonitorTask, paramMonitorStep, (MonitorResult)localObject, paramMonitorTask.installDir);
      return localObject;
    }
    a(paramMonitorTask, paramMonitorStep, (MonitorResult)localObject, paramMonitorTask.filePath);
    return localObject;
  }
  
  public MonitorType a()
  {
    return MonitorType.BY_FILE_SIZE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.a.d
 * JD-Core Version:    0.7.0.1
 */