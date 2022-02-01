package com.tencent.mobileqq.winkpublish.service.video;

import android.os.Process;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper;
import com.tencent.qphone.base.util.QLog;

public class PublishVideoPluginService$CPUMonitorRunnable
  implements Runnable
{
  public void run()
  {
    int i = PublishVideoPluginService.b();
    int j = QCircleHostQzoneThreadHelper.getVideoThreadId();
    int k = Process.getThreadPriority(j);
    if (i > 80)
    {
      if (k < 10) {
        Process.setThreadPriority(j, 10);
      }
    }
    else if ((!PublishVideoPluginService.h()) && (k > TrimVideoThread.a)) {
      Process.setThreadPriority(j, TrimVideoThread.a);
    }
    j = Process.getThreadPriority(j);
    if (QLog.isColorLevel())
    {
      String str = PublishVideoPluginService.c();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("cpu usage=");
      localStringBuilder.append(i);
      localStringBuilder.append(", priority=");
      localStringBuilder.append(j);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (PublishVideoPluginService.a()) {
      QCircleHostQzoneThreadHelper.postBackGoundThreadDelayed(this, 5000L);
    }
    PublishVideoPluginService.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.service.video.PublishVideoPluginService.CPUMonitorRunnable
 * JD-Core Version:    0.7.0.1
 */