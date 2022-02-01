package com.tencent.mobileqq.winkpublish.service.video;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.winkpublish.IQueueTask;
import com.tencent.mobileqq.winkpublish.model.ShuoshuoVideoInfo;
import com.tencent.mobileqq.winkpublish.queue.AUploadTaskQueue;
import com.tencent.mobileqq.winkpublish.task.compress.VideoCompressEngine;
import com.tencent.mobileqq.winkpublish.task.compress.VideoCompressTask;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class RemoteVideoServiceHandler$1
  extends Handler
{
  RemoteVideoServiceHandler$1(RemoteVideoServiceHandler paramRemoteVideoServiceHandler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = RemoteVideoServiceHandler.g();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("RemoteVideoServiceHandler handleMessage, what=");
    ((StringBuilder)localObject2).append(paramMessage.what);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    int i = paramMessage.what;
    localObject1 = "";
    Object localObject5;
    Object localObject3;
    Object localObject4;
    switch (i)
    {
    default: 
    case 1003: 
      localObject2 = ((Intent)paramMessage.obj).getStringExtra("client_key");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject5 = VideoCompressEngine.a().a((String)localObject2);
        if (localObject5 != null)
        {
          localObject3 = RemoteVideoServiceHandler.g();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("RemoteVideoServiceHandler start compress video, video path:");
          paramMessage = (Message)localObject1;
          if (((VideoCompressTask)localObject5).a != null)
          {
            paramMessage = (Message)localObject1;
            if (((VideoCompressTask)localObject5).a.b != null) {
              paramMessage = ((VideoCompressTask)localObject5).a.b;
            }
          }
          ((StringBuilder)localObject4).append(paramMessage);
          QLog.i((String)localObject3, 1, ((StringBuilder)localObject4).toString());
          VideoCompressEngine.a().b((String)localObject2);
          return;
        }
      }
      break;
    case 1002: 
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Intent)))
      {
        paramMessage = (Intent)paramMessage.obj;
        RemoteVideoServiceHandler.a(this.a, paramMessage.getStringExtra("video_dest_file"));
        return;
      }
      QLog.w(RemoteVideoServiceHandler.g(), 1, "RemoteVideoServiceHandler handleMessage 1002, message.obj is not valid");
      return;
    case 1000: 
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Intent)))
      {
        RemoteVideoServiceHandler.a(this.a, null);
        localObject3 = (Intent)paramMessage.obj;
        localObject2 = ((Intent)localObject3).getStringExtra("client_key");
        paramMessage = RemoteVideoServiceHandler.g();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("clientKey=");
        ((StringBuilder)localObject4).append((String)localObject2);
        QLog.i(paramMessage, 1, ((StringBuilder)localObject4).toString());
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramMessage = AUploadTaskQueue.a().b((String)localObject2);
          localObject4 = VideoCompressEngine.a().a((String)localObject2);
          if ((paramMessage != null) && (RemoteVideoServiceHandler.a(this.a).contains(paramMessage.getCacheKey())))
          {
            this.a.b(paramMessage.getCacheKey());
            return;
          }
          if (localObject4 != null)
          {
            localObject5 = RemoteVideoServiceHandler.g();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("RemoteVideoServiceHandler compress video finish, video path:");
            paramMessage = (Message)localObject1;
            if (((VideoCompressTask)localObject4).a != null)
            {
              paramMessage = (Message)localObject1;
              if (((VideoCompressTask)localObject4).a.b != null) {
                paramMessage = ((VideoCompressTask)localObject4).a.b;
              }
            }
            localStringBuilder.append(paramMessage);
            QLog.i((String)localObject5, 1, localStringBuilder.toString());
            VideoCompressEngine.a().a((String)localObject2, (Intent)localObject3);
            return;
          }
          paramMessage = RemoteVideoServiceHandler.g();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("RemoteVideoServiceHandler handleMessage, clientkey not in sessions, clientkey=");
          ((StringBuilder)localObject1).append((String)localObject2);
          QLog.w(paramMessage, 1, ((StringBuilder)localObject1).toString());
          return;
        }
        paramMessage = RemoteVideoServiceHandler.g();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("RemoteVideoServiceHandler handleMessage, clientkey not in sessions, clientkey=");
        ((StringBuilder)localObject1).append((String)localObject2);
        QLog.w(paramMessage, 1, ((StringBuilder)localObject1).toString());
        return;
      }
      QLog.w(RemoteVideoServiceHandler.g(), 1, "RemoteVideoServiceHandler handleMessage 1000, message.obj is not valid");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.service.video.RemoteVideoServiceHandler.1
 * JD-Core Version:    0.7.0.1
 */