package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.FileExecutor;
import java.util.concurrent.Executor;

class QFileMsgForwardManager$BuddyUploadTaskExcuter
  extends QFileMsgForwardManager.TaskExcuter
{
  protected long a;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  protected String a;
  private long b;
  protected String b;
  
  public QFileMsgForwardManager$BuddyUploadTaskExcuter(QFileMsgForwardManager paramQFileMsgForwardManager, MessageRecord paramMessageRecord)
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
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFileType", "1");
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardReceiverUin", paramString);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFileName", this.jdField_a_of_type_JavaLangString);
    FileManagerUtil.FileExecutor.a().execute(new QFileMsgForwardManager.BuddyUploadTaskExcuter.1(this, paramString, paramOnUploadCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.BuddyUploadTaskExcuter
 * JD-Core Version:    0.7.0.1
 */