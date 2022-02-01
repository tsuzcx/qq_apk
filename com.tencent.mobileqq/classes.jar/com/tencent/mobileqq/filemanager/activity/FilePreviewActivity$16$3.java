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
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$16.a.jdField_b_of_type_Boolean) {
      paramDialogInterface = "https://";
    } else {
      paramDialogInterface = "http://";
    }
    ((StringBuilder)localObject).append(paramDialogInterface);
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$16.a.g);
    ((StringBuilder)localObject).append(":");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$16.a.h);
    ((StringBuilder)localObject).append("/ftn_compress_getfile/rkey=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$16.a.e);
    ((StringBuilder)localObject).append("&filetype=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity$16.a.jdField_b_of_type_Int);
    ((StringBuilder)localObject).append("&path=");
    String str = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel()) {
      QLog.i("<FileAssistant>FilePreviewActivity", 1, str);
    }
    paramDialogInterface = this.jdField_a_of_type_JavaLangString;
    try
    {
      localObject = URLEncoder.encode(paramDialogInterface, "utf8");
      paramDialogInterface = (DialogInterface)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramDialogInterface);
    localStringBuilder.append("&");
    paramDialogInterface = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentMobileqqUniformdownloadApiIUniformDownloadMgr.startDownload(paramDialogInterface, this.jdField_a_of_type_AndroidOsBundle);
    FileManagerReporter.a("0X80052CE");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FilePreviewActivity.16.3
 * JD-Core Version:    0.7.0.1
 */