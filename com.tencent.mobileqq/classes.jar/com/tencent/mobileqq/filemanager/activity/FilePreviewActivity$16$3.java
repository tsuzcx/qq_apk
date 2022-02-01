package com.tencent.mobileqq.filemanager.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class FilePreviewActivity$16$3
  implements DialogInterface.OnClickListener
{
  FilePreviewActivity$16$3(FilePreviewActivity.16 param16, String paramString, IUniformDownloadMgr paramIUniformDownloadMgr, Bundle paramBundle) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = new StringBuilder();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$16.a.jdField_b_of_type_Boolean) {}
    for (paramDialogInterface = "https://";; paramDialogInterface = "http://")
    {
      String str = paramDialogInterface + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$16.a.g + ":" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$16.a.h + "/ftn_compress_getfile/rkey=" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$16.a.e + "&filetype=" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$16.a.jdField_b_of_type_Int + "&path=";
      if (QLog.isColorLevel()) {
        QLog.i("<FileAssistant>FilePreviewActivity", 1, str);
      }
      paramDialogInterface = this.jdField_a_of_type_JavaLangString;
      try
      {
        localObject = URLEncoder.encode(this.jdField_a_of_type_JavaLangString, "utf8");
        paramDialogInterface = (DialogInterface)localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
      paramDialogInterface = str + paramDialogInterface + "&";
      this.jdField_a_of_type_ComTencentMobileqqUniformdownloadApiIUniformDownloadMgr.startDownload(paramDialogInterface, this.jdField_a_of_type_AndroidOsBundle);
      FileManagerReporter.a("0X80052CE");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.16.3
 * JD-Core Version:    0.7.0.1
 */