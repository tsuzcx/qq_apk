package com.tencent.mobileqq.winkpublish.service.video;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

final class PublishVideoPluginService$1
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleMessage, what=");
    ((StringBuilder)localObject).append(paramMessage.what);
    QLog.i("[upload2][compress]", 1, ((StringBuilder)localObject).toString());
    int i = paramMessage.what;
    if (i != 1006)
    {
      int j;
      switch (i)
      {
      default: 
        return;
      case 1003: 
        PublishVideoPluginService.b(true);
        i = QCircleHostQzoneThreadHelper.getVideoThreadId();
        if (Process.getThreadPriority(i) != 19) {
          Process.setThreadPriority(i, 19);
        }
        j = Process.getThreadPriority(i);
        if (!QLog.isColorLevel()) {
          break;
        }
        paramMessage = PublishVideoPluginService.c();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SPEED DOWN, tid=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", priority=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", TRIM_THREAD_PRORITY=");
        ((StringBuilder)localObject).append(TrimVideoThread.a);
        QLog.d(paramMessage, 2, ((StringBuilder)localObject).toString());
        return;
      case 1002: 
        PublishVideoPluginService.b(false);
        i = QCircleHostQzoneThreadHelper.getVideoThreadId();
        j = Process.getThreadPriority(i);
        if (j > TrimVideoThread.a) {
          if (PublishVideoPluginService.f() <= 80) {
            Process.setThreadPriority(i, TrimVideoThread.a);
          } else if (j > 10) {
            Process.setThreadPriority(i, 10);
          }
        }
        j = Process.getThreadPriority(i);
        if (!QLog.isColorLevel()) {
          break;
        }
        paramMessage = PublishVideoPluginService.c();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SPEED UP, tid=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", priority=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", TRIM_THREAD_PRORITY=");
        ((StringBuilder)localObject).append(TrimVideoThread.a);
        QLog.d(paramMessage, 2, ((StringBuilder)localObject).toString());
        return;
      case 1001: 
        if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Intent)))
        {
          if (!PublishVideoPluginService.d())
          {
            PublishVideoPluginService.a(true);
            PublishVideoPluginService.a(paramMessage);
            return;
          }
          QLog.i("[upload2][compress]", 1, "other video is processing, add to queue.");
          localObject = new Message();
          ((Message)localObject).obj = paramMessage.obj;
          PublishVideoPluginService.e().add(localObject);
          return;
        }
        QLog.e("[upload2][compress]", 1, "msg.obj is wrong");
        return;
      case 1000: 
        if (paramMessage.replyTo == null)
        {
          QLog.e(PublishVideoPluginService.c(), 1, "no client is wrong");
          return;
        }
        PublishVideoPluginService.a(paramMessage.replyTo);
        return;
      }
    }
    else
    {
      paramMessage = ((Intent)paramMessage.obj).getStringExtra("client_key");
      if (!TextUtils.isEmpty(paramMessage))
      {
        localObject = PublishVideoPluginService.e().iterator();
        while (((Iterator)localObject).hasNext()) {
          if (paramMessage.equals(((Intent)((Message)((Iterator)localObject).next()).obj).getStringExtra("client_key"))) {
            ((Iterator)localObject).remove();
          }
        }
        if (paramMessage.equals(PublishVideoPluginService.g())) {
          VideoTrimmer.a(paramMessage);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.service.video.PublishVideoPluginService.1
 * JD-Core Version:    0.7.0.1
 */