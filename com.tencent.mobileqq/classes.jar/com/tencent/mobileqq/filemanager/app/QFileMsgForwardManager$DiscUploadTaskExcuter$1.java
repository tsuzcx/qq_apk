package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.filemanager.uftwrapper.QFileDiscTransferWrapper.IDiscMultiFwdCallback;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$DiscUploadTaskExcuter$1
  implements QFileDiscTransferWrapper.IDiscMultiFwdCallback
{
  QFileMsgForwardManager$DiscUploadTaskExcuter$1(QFileMsgForwardManager.DiscUploadTaskExcuter paramDiscUploadTaskExcuter, QFileMsgForwardManager.OnUploadCallback paramOnUploadCallback) {}
  
  public void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      paramBundle = new StringBuilder();
      paramBundle.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter.jdField_a_of_type_JavaLangString);
      paramBundle.append(" sendDiscFile faild");
      QLog.e("FileMultiMsg", 1, paramBundle.toString());
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback.a(QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter.jdField_a_of_type_Long, false), paramBoolean);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(" start upload Discfile success");
    QLog.i("FileMultiMsgManager<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    localObject = paramBundle.getString("strFileId");
    String str = paramBundle.getString("str10MMd5");
    paramBundle = paramBundle.getString("strSha");
    Bundle localBundle = QFileMsgForwardManager.DiscUploadTaskExcuter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter.jdField_a_of_type_Long);
    localStringBuilder.append("");
    localBundle.putString("_m_ForwardSize", localStringBuilder.toString());
    QFileMsgForwardManager.DiscUploadTaskExcuter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter).putString("_m_ForwardMd5", str);
    QFileMsgForwardManager.DiscUploadTaskExcuter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter).putString("_m_ForwardSha", paramBundle);
    QFileMsgForwardManager.DiscUploadTaskExcuter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter).putString("_m_ForwardDeadTime", "0");
    QFileMsgForwardManager.DiscUploadTaskExcuter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter).putString("_m_ForwardUuid", (String)localObject);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback.a((String)localObject, QFileMsgForwardManager.DiscUploadTaskExcuter.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$DiscUploadTaskExcuter));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.DiscUploadTaskExcuter.1
 * JD-Core Version:    0.7.0.1
 */