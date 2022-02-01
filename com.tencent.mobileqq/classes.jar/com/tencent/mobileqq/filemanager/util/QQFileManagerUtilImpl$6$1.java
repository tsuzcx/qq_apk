package com.tencent.mobileqq.filemanager.util;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class QQFileManagerUtilImpl$6$1
  implements FMDialogUtil.FMDialogInterface
{
  QQFileManagerUtilImpl$6$1(QQFileManagerUtilImpl.6 param6, Activity paramActivity) {}
  
  public void a()
  {
    ReportController.b(null, "dc00898", "", "", "0X800AE48", "0X800AE48", 0, 0, "", "", "", "");
    try
    {
      Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
      localIntent.putExtra("url", "https://upage.imtt.qq.com/m_imtt/qq_download_middle_page/real/qq_download_middle_page.html");
      this.a.startActivity(localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "startActivity error", localThrowable);
      }
    }
  }
  
  public void b()
  {
    ReportController.b(null, "dc00898", "", "", "0X800AE49", "0X800AE49", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.6.1
 * JD-Core Version:    0.7.0.1
 */