package com.tencent.mobileqq.theme.diy;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class ThemeDIYActivity$13
  extends DownloadListener
{
  ThemeDIYActivity$13(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if ((paramDownloadTask.a() == 3) && (paramDownloadTask.a == 0)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      paramDownloadTask = paramDownloadTask.a();
      j = paramDownloadTask.getInt("type");
      switch (j)
      {
      default: 
        return;
      }
    }
    this.this$0.loadResJson(j, true);
    return;
    ThemeDiyStyleLogic.StyleCallBack localStyleCallBack = this.this$0.saveStyleCallback;
    if (i != 0) {}
    for (i = 4;; i = 8)
    {
      localStyleCallBack.callback(13, i, paramDownloadTask, null);
      return;
    }
  }
  
  public void onNetMobile2None()
  {
    QLog.e("ThemeDIYActivity", 2, "DownloadListener onNetMobile2None...");
    this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 27, "网络异常"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.13
 * JD-Core Version:    0.7.0.1
 */