package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$DiscUploadTaskExcuter
  extends QFileMsgForwardManager.TaskExcuter
{
  protected long a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  protected String a;
  private long b;
  protected String b;
  
  QFileMsgForwardManager$DiscUploadTaskExcuter(QFileMsgForwardManager paramQFileMsgForwardManager, MessageRecord paramMessageRecord)
  {
    super(paramQFileMsgForwardManager);
    this.jdField_a_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
    this.jdField_a_of_type_Long = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
    this.jdField_b_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
    paramQFileMsgForwardManager = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardImgWidth", paramQFileMsgForwardManager);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardImgHeight", paramMessageRecord);
  }
  
  void a(String paramString, int paramInt) {}
  
  void a(String paramString, int paramInt, QFileMsgForwardManager.OnUploadCallback paramOnUploadCallback)
  {
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFileType", "2");
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardReceiverUin", paramString);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFileName", this.jdField_a_of_type_JavaLangString);
    String str1 = FileHttpUtils.a(FileManagerUtil.e(this.jdField_b_of_type_JavaLangString));
    String str2 = FileHttpUtils.a(FileManagerUtil.a(this.jdField_b_of_type_JavaLangString));
    this.jdField_a_of_type_Long = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardSize", this.jdField_a_of_type_Long + "");
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardMd5", str1);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardSha", str2);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardDeadTime", "0");
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start DiscUploadTaskExcuter:" + this.jdField_a_of_type_JavaLangString);
    }
    QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager).getFileTransferHandler().a(str1, str2, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, paramString, QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager).getCurrentAccountUin(), new QFileMsgForwardManager.DiscUploadTaskExcuter.1(this, paramOnUploadCallback, str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.DiscUploadTaskExcuter
 * JD-Core Version:    0.7.0.1
 */