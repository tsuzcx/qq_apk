package com.tencent.mobileqq.jsp;

import android.app.Activity;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class UiApiPlugin$28
  extends DownloadListener
{
  UiApiPlugin$28(UiApiPlugin paramUiApiPlugin, String paramString) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (paramDownloadTask.a == 0)
    {
      paramDownloadTask = new File(AbsDownloader.getFilePath(this.jdField_a_of_type_JavaLangString));
      if (paramDownloadTask.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "shareImageToAIO->downloadFile success: " + this.jdField_a_of_type_JavaLangString);
        }
        localActivity.runOnUiThread(new UiApiPlugin.28.1(this, paramDownloadTask));
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "shareImageToAIO->downloadFile failed: " + this.jdField_a_of_type_JavaLangString);
    }
    localActivity.runOnUiThread(new UiApiPlugin.28.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.28
 * JD-Core Version:    0.7.0.1
 */