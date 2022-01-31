package com.tencent.mobileqq.theme.diy;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.theme.ThemeDownloader;
import com.tencent.mobileqq.theme.ThemeDownloader.ThemeUnzipListener;
import com.tencent.qphone.base.util.QLog;

class ThemeDIYActivity$8
  implements ThemeDownloader.ThemeUnzipListener
{
  ThemeDIYActivity$8(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onUnzipCallback(Bundle paramBundle, int paramInt, ThemeDownloader paramThemeDownloader)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDIYActivity", 2, "mThemeDownloadListener onUnzipCallback stateCode:" + paramInt);
    }
    if ((paramInt == 1) || (paramInt == 3))
    {
      this.this$0.mStyleSaveStatus = 6;
      this.this$0.mHandler.removeMessages(22);
      this.this$0.mHandler.sendMessageDelayed(Message.obtain(this.this$0.mHandler, 22, null), 50L);
    }
    for (;;)
    {
      if (paramThemeDownloader != null) {
        paramThemeDownloader.a();
      }
      return;
      this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 25, "风格包解压失败:" + this.this$0.tryOnStyleRSD.id));
      QLog.e("ThemeDIYActivity", 2, "mThemeDownloadListener onDownloadCallback error:" + this.this$0.tryOnStyleRSD.id);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.8
 * JD-Core Version:    0.7.0.1
 */