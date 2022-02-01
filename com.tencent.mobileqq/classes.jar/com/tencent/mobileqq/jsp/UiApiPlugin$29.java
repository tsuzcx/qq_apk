package com.tencent.mobileqq.jsp;

import android.app.Activity;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

class UiApiPlugin$29
  extends DownloadListener
{
  UiApiPlugin$29(UiApiPlugin paramUiApiPlugin, String paramString, JSONObject paramJSONObject) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    Activity localActivity = this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    if (paramDownloadTask.a == 0)
    {
      paramDownloadTask = AbsDownloader.getFilePath(this.jdField_a_of_type_JavaLangString);
      if (new File(paramDownloadTask).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("UiApiPlugin", 2, "mergeTextToImage->downloadFile success: " + this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.a(this.jdField_a_of_type_OrgJsonJSONObject, paramDownloadTask, 0);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UiApiPlugin", 2, "mergeTextToImage->downloadFile failed: " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.a(this.jdField_a_of_type_OrgJsonJSONObject, null, -2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.29
 * JD-Core Version:    0.7.0.1
 */