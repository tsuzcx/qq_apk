package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$DiscUploadTaskExcuter$1
  extends FileTransferObserver
{
  QFileMsgForwardManager$DiscUploadTaskExcuter$1(QFileMsgForwardManager.DiscUploadTaskExcuter paramDiscUploadTaskExcuter, QFileMsgForwardManager.OnUploadCallback paramOnUploadCallback, String paramString) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, Bundle paramBundle)
  {
    super.a(paramBoolean, paramLong, paramString1, paramString2, paramString3, paramString4, paramInt, paramString5, paramString6, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter.jdField_a_of_type_JavaLangString + " start DiscUploadTaskExcuter isSuccess:" + paramBoolean + " retCode:" + paramLong + " retMsg:" + paramString6);
    }
    if (!paramBoolean)
    {
      if ((paramLong == -100001L) || (paramLong == -100002L))
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback.a(QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter.jdField_a_of_type_Long, false), true);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback.a(QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter.jdField_a_of_type_Long, false), false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter.jdField_a_of_type_JavaLangString + " start upload Discfile");
    }
    paramBoolean = ((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsUpload4Disc(QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager));
    paramString2 = "";
    int i = 0;
    paramString5 = "";
    if (paramBundle != null)
    {
      paramString2 = paramBundle.getString("strHttpsDomain");
      i = paramBundle.getShort("httpsPort");
      paramString5 = paramBundle.getString("strHttpsDomain");
    }
    paramString1 = new NewDiscFileUploader(QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager), paramString3, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter.jdField_a_of_type_Long, paramString4, paramInt, paramBoolean, paramString2, i, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter.b, paramString5, new QFileMsgForwardManager.DiscUploadTaskExcuter.1.1(this, paramString1));
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter.jdField_a_of_type_JavaLangString + " add to rsCenter");
    }
    QFileMsgForwardManager.DiscUploadTaskExcuter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter, FileManagerUtil.a().longValue());
    QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager).getFileManagerRSCenter().a(QFileMsgForwardManager.DiscUploadTaskExcuter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter), paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.DiscUploadTaskExcuter.1
 * JD-Core Version:    0.7.0.1
 */