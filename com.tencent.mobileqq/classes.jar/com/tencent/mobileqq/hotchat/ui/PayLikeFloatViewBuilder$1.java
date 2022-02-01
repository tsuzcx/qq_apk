package com.tencent.mobileqq.hotchat.ui;

import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class PayLikeFloatViewBuilder$1
  extends DownloadListener
{
  PayLikeFloatViewBuilder$1(String paramString) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    PayLikeFloatViewBuilder.a(false);
    if (paramDownloadTask.c == 0)
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append(this.a);
      paramDownloadTask.append(".tmp");
      paramDownloadTask = new File(paramDownloadTask.toString());
      if (paramDownloadTask.exists()) {
        paramDownloadTask.renameTo(new File(this.a));
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("PayLikeFloatViewBuilder", 2, "getPayZanAnimBitmap download failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder.1
 * JD-Core Version:    0.7.0.1
 */