package com.tencent.mobileqq.filemanager.app;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$Buddy2TroopTaskExcuter
  extends QFileMsgForwardManager.TaskExcuter
{
  protected long a;
  protected String a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  
  QFileMsgForwardManager$Buddy2TroopTaskExcuter(QFileMsgForwardManager paramQFileMsgForwardManager, MessageRecord paramMessageRecord)
  {
    super(paramQFileMsgForwardManager);
    this.jdField_a_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
    this.jdField_a_of_type_Long = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
    this.b = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
    this.c = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
    this.d = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
    this.e = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
    this.f = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
    this.g = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
  }
  
  void a(String paramString, int paramInt) {}
  
  void a(String paramString, int paramInt, QFileMsgForwardManager.OnUploadCallback paramOnUploadCallback)
  {
    if ("1".equals(this.g))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("start Buddy2TroopTaskExcuter:");
        paramString.append(this.jdField_a_of_type_JavaLangString);
        paramString.append(" faild, file is upload paused");
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
      }
      paramOnUploadCallback.a(QFileMsgForwardManager.a(this.jdField_a_of_type_Long, false), false);
      return;
    }
    String str = this.b;
    if ((str != null) && (str.length() != 0))
    {
      QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager).getFileManagerEngine().a().a(paramString, paramInt, this.b, this.c, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, 102, new QFileMsgForwardManager.Buddy2TroopTaskExcuter.1(this, paramString, paramOnUploadCallback));
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append(this.jdField_a_of_type_JavaLangString);
      paramString.append(" Buddy2TroopTaskExcuter faild uuid is null");
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
    }
    paramOnUploadCallback.a(QFileMsgForwardManager.a(this.jdField_a_of_type_Long, true), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.Buddy2TroopTaskExcuter
 * JD-Core Version:    0.7.0.1
 */