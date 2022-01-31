package com.tencent.mobileqq.theme.diy;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.theme.ThemeDownloader;
import com.tencent.mobileqq.theme.ThemeDownloader.ThemeDownloadListener;
import com.tencent.qphone.base.util.QLog;

class ThemeDIYActivity$7
  implements ThemeDownloader.ThemeDownloadListener
{
  ThemeDIYActivity$7(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onDownloadCallback(Bundle paramBundle, int paramInt1, int paramInt2, int paramInt3, ThemeDownloader paramThemeDownloader)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDIYActivity", 2, "mThemeDownloadListener onDownloadCallback stateCode:" + paramInt1);
    }
    if (paramInt1 == 4) {}
    for (;;)
    {
      return;
      if (paramInt1 == 2)
      {
        paramThemeDownloader.a(this.this$0.mContext, paramBundle, this.this$0.mThemeUnzipListener);
        return;
      }
      if (paramInt1 >= 0)
      {
        this.this$0.mStyleSaveStatus = 6;
        this.this$0.mHandler.removeMessages(22);
        this.this$0.mHandler.sendMessageDelayed(Message.obtain(this.this$0.mHandler, 22, null), 50L);
      }
      while (paramThemeDownloader != null)
      {
        paramThemeDownloader.a();
        return;
        this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 25, "风格包下载失败:" + this.this$0.tryOnStyleRSD.id));
        QLog.e("ThemeDIYActivity", 2, "mThemeDownloadListener onDownloadCallback error:" + this.this$0.tryOnStyleRSD.id);
      }
    }
  }
  
  public void onDownloadProgress(Bundle paramBundle, int paramInt, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDIYActivity", 2, "mThemeDownloadListener onDownloadProgress readSize:" + paramLong1 + ", dwProgressMax" + paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.7
 * JD-Core Version:    0.7.0.1
 */