package com.tencent.mobileqq.jsp;

import android.app.Activity;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

class UiApiPlugin$28
  extends DownloadListener
{
  UiApiPlugin$28(UiApiPlugin paramUiApiPlugin, String paramString, JSONObject paramJSONObject) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.mRuntime.a();
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      if (paramDownloadTask.a == 0)
      {
        paramDownloadTask = AbsDownloader.getFilePath(this.jdField_a_of_type_JavaLangString);
        if (new File(paramDownloadTask).exists())
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("mergeTextToImage->downloadFile success: ");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
            QLog.d("UiApiPlugin", 2, ((StringBuilder)localObject).toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.a(this.jdField_a_of_type_OrgJsonJSONObject, paramDownloadTask, 0);
          return;
        }
      }
      if (QLog.isColorLevel())
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append("mergeTextToImage->downloadFile failed: ");
        paramDownloadTask.append(this.jdField_a_of_type_JavaLangString);
        QLog.d("UiApiPlugin", 2, paramDownloadTask.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqJspUiApiPlugin.a(this.jdField_a_of_type_OrgJsonJSONObject, null, -2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.28
 * JD-Core Version:    0.7.0.1
 */