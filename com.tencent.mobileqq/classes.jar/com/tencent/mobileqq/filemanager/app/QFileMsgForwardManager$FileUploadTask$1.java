package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$FileUploadTask$1
  implements QFileMsgForwardManager.OnUploadCallback
{
  QFileMsgForwardManager$FileUploadTask$1(QFileMsgForwardManager.FileUploadTask paramFileUploadTask, QFileMsgForwardManager paramQFileMsgForwardManager, MessageRecord paramMessageRecord) {}
  
  public void a(String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FileUploadTask success, multiUniseq[ ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$FileUploadTask.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("] uuid[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("] fileMrUniseq[");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
      localStringBuilder.append("]");
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, localStringBuilder.toString());
    }
    paramString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$FileUploadTask;
    paramString.b = 2;
    QFileMsgForwardManager.a(paramString.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramBundle);
    QFileMsgForwardManager.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$FileUploadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$FileUploadTask.jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FileUploadTask fail, multiUniseq[ ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$FileUploadTask.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("] fileMrUniseq[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
      ((StringBuilder)localObject).append("] canResume[");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("] retMsg[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$FileUploadTask.b = 4;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131709665));
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName"));
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("\n");
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.saveExtInfoToExtStr("_m_ForwardFaildReason", paramString);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.saveExtInfoToExtStr("_m_ForwardFileStatus", "2");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$FileUploadTask.b = 3;
    }
    QFileMsgForwardManager.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$FileUploadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$FileUploadTask.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.FileUploadTask.1
 * JD-Core Version:    0.7.0.1
 */