package com.tencent.mobileqq.jsp;

import android.app.Activity;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class UiApiPlugin$27
  extends DownloadListener
{
  UiApiPlugin$27(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a();
    if (localActivity != null)
    {
      if (localActivity.isFinishing()) {
        return;
      }
      if (paramDownloadTask.a == 0)
      {
        paramDownloadTask = new File(AbsDownloader.getFilePath(this.jdField_a_of_type_JavaLangString));
        if (paramDownloadTask.exists())
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("shareImageToAIO->downloadFile success: ");
            localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
            QLog.d("UiApiPlugin", 2, localStringBuilder.toString());
          }
          localActivity.runOnUiThread(new UiApiPlugin.27.1(this, paramDownloadTask));
          return;
        }
      }
      if (QLog.isColorLevel())
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append("shareImageToAIO->downloadFile failed: ");
        paramDownloadTask.append(this.jdField_a_of_type_JavaLangString);
        QLog.d("UiApiPlugin", 2, paramDownloadTask.toString());
      }
      localActivity.runOnUiThread(new UiApiPlugin.27.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.27
 * JD-Core Version:    0.7.0.1
 */