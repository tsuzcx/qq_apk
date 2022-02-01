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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("ChannedlIdMonitorAction>>checkByChannelId ");
    ((StringBuilder)localObject1).append(paramMonitorTask.appName);
    ((StringBuilder)localObject1).append(" task.cpChannelId = ");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append(" fileChannelId = ");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append(" filePath =");
    ((StringBuilder)localObject1).append(paramString1);
    ab.c("WashMonitor", ((StringBuilder)localObject1).toString());
    if (TextUtils.isEmpty(paramString1)) {
      return new MonitorResult(paramMonitorStep, 3, "通过渠道号检测时发现filePath为空", a());
    }
    if (!TextUtils.isEmpty(paramString2)) {
      try
      {
        localObject1 = a.a(paramString1);
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("ChannedlIdMonitorAction>>checkByChannelId ");
        ((StringBuilder)localObject2).append(paramMonitorTask.appName);
        ((StringBuilder)localObject2).append(" task.cpChannelId = ");
        ((StringBuilder)localObject2).append(paramMonitorTask.cpChannelId);
        ((StringBuilder)localObject2).append(" fileChannelId = ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ab.c("WashMonitor", ((StringBuilder)localObject2).toString());
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!paramString2.equals(localObject1)))
        {
          paramString2 = new MonitorResult(paramMonitorStep, 1, "通过渠道号检测发现洗包", a());
          localObject2 = new File(paramString1);
          long l = 0L;
          if (((File)localObject2).exists()) {
            l = ((File)localObject2).length();
          }
          paramString2.replaceChannelId = ((String)localObject1);
          paramString2.replacedFileSize = l;
          paramString2.replaceTime = ((File)localObject2).lastModified();
          paramString1 = q.b(paramString1);
          if ((paramMonitorStep == MonitorStep.INSTALLING) || (paramMonitorStep == MonitorStep.AFTER_INSTALL)) {
            paramString1 = q.c(paramMonitorTask.packageName);
          }
          if (paramString1 != null)
          {
            paramString2.replacedPkgName = paramString1.packageName;
            paramString2.replacedVersionCode = paramString1.versionCode;
            if ((paramMonitorStep == MonitorStep.INSTALLING) || (paramMonitorStep == MonitorStep.AFTER_INSTALL)) {
              paramString2.replaceTime = paramString1.lastUpdateTime;
            }
          }
          return paramString2;
        }
      }
      catch (IOException paramMonitorTask)
      {
        paramMonitorTask.printStackTrace();
        paramMonitorTask = new StringBuilder();
        paramMonitorTask.append(paramMonitorStep);
        paramMonitorTask.append("渠道号检测通过");
        return new MonitorResult(paramMonitorStep, 0, paramMonitorTask.toString(), a());
      }
    }
    paramMonitorTask = new StringBuilder();
    paramMonitorTask.append(paramMonitorStep);
    paramMonitorTask.append("task.cpChannelId为空");
    return new MonitorResult(paramMonitorStep, 0, paramMonitorTask.toString(), a());
  }
  
  public MonitorResult a(MonitorTask paramMonitorTask, MonitorStep paramMonitorStep)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChannedlIdMonitorAction>>");
    localStringBuilder.append(paramMonitorTask.appName);
    localStringBuilder.append("开始通过渠道号比较检测洗包 step = ");
    localStringBuilder.append(paramMonitorStep);
    ab.c("WashMonitor", localStringBuilder.toString());
    if (TextUtils.isEmpty(paramMonitorTask.cpChannelId)) {
      return new MonitorResult(paramMonitorStep, 0, "渠道号检测暂时不做, task.cpChannelId is empty", a());
    }
    if (paramMonitorTask.appType == 3)
    {
      int i = c.a[paramMonitorStep.ordinal()];
      if (i != 1)
      {
        if ((i == 2) || (i == 3)) {
          return a(paramMonitorTask, paramMonitorTask.installDir, paramMonitorTask.cpChannelId, paramMonitorStep);
        }
      }
      else {
        return a(paramMonitorTask, paramMonitorTask.filePath, paramMonitorTask.cpChannelId, paramMonitorStep);
      }
    }
    return new MonitorResult(paramMonitorStep, 0, "渠道号检测暂时不做", a());
  }
  
  public MonitorType a()
  {
    return MonitorType.BY_CHANNEL_ID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.replacemonitor.replace.a.b
 * JD-Core Version:    0.7.0.1
 */