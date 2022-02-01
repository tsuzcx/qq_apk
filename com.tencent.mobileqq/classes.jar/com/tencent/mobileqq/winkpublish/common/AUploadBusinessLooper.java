package com.tencent.mobileqq.winkpublish.common;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper;
import com.tencent.mobileqq.winkpublish.Singleton;
import com.tencent.mobileqq.winkpublish.request.AUploadRequest;
import com.tencent.mobileqq.winkpublish.task.AUploadTask;
import com.tencent.qphone.base.util.QLog;

public class AUploadBusinessLooper
  implements Handler.Callback
{
  static final String a;
  private static final Singleton<AUploadBusinessLooper, Void> c = new AUploadBusinessLooper.1();
  public Handler b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("AUploadBusinessLooper");
    a = localStringBuilder.toString();
  }
  
  public static AUploadBusinessLooper a()
  {
    return (AUploadBusinessLooper)c.get(null);
  }
  
  public void a(AUploadTask paramAUploadTask)
  {
    if (this.b == null) {
      this.b = new Handler(QCircleHostQzoneThreadHelper.getBusinessThreadLooper(), this);
    }
    Message localMessage = Message.obtain();
    localMessage.what = 0;
    localMessage.obj = paramAUploadTask;
    this.b.sendMessage(localMessage);
  }
  
  public void b(AUploadTask paramAUploadTask)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramAUploadTask;
    this.b.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    String str1 = "mRequest is null";
    String str2;
    StringBuilder localStringBuilder;
    if (i != 0)
    {
      if (i == 1)
      {
        paramMessage = (AUploadTask)paramMessage.obj;
        str2 = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("completeTask resultCode:");
        localStringBuilder.append(paramMessage.af);
        localStringBuilder.append(", cmd=");
        if (paramMessage.ai != null) {
          str1 = paramMessage.ai.d();
        }
        localStringBuilder.append(str1);
        QLog.i(str2, 1, localStringBuilder.toString());
        if (paramMessage.ad != null) {
          try
          {
            paramMessage.ad.a(paramMessage);
          }
          catch (Exception paramMessage)
          {
            QLog.w(a, 1, paramMessage.getMessage());
          }
        }
      }
    }
    else
    {
      paramMessage = (AUploadTask)paramMessage.obj;
      str2 = a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("runTask cmd=");
      if (paramMessage.ai != null) {
        str1 = paramMessage.ai.d();
      }
      localStringBuilder.append(str1);
      QLog.i(str2, 1, localStringBuilder.toString());
      paramMessage.n();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.common.AUploadBusinessLooper
 * JD-Core Version:    0.7.0.1
 */