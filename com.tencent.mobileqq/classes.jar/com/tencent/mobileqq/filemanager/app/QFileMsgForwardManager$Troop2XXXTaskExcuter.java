package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileReqCopyToObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;

class QFileMsgForwardManager$Troop2XXXTaskExcuter
  extends QFileMsgForwardManager.TaskExcuter
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private TroopFileReqCopyToObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqCopyToObserver = new QFileMsgForwardManager.Troop2XXXTaskExcuter.1(this);
  private QFileMsgForwardManager.OnUploadCallback jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  
  private QFileMsgForwardManager$Troop2XXXTaskExcuter(QFileMsgForwardManager paramQFileMsgForwardManager, MessageRecord paramMessageRecord, int paramInt)
  {
    super(paramQFileMsgForwardManager);
    this.jdField_a_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin");
    this.jdField_b_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSha");
    this.c = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
    this.d = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize");
    this.jdField_a_of_type_Long = Long.parseLong(this.d);
    this.e = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
    this.f = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
    this.g = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
    this.h = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardDuration");
    this.i = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardBusType");
    this.j = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
    this.k = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
    paramQFileMsgForwardManager = new StringBuilder();
    paramQFileMsgForwardManager.append("Troop2XXXTaskExcuter begin filename ");
    paramQFileMsgForwardManager.append(this.c);
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramQFileMsgForwardManager.toString());
    this.jdField_a_of_type_Int = paramInt;
  }
  
  void a(String paramString, int paramInt)
  {
    paramString = new StringBuilder();
    paramString.append("Troop2XXXTaskExcuter stopped filename ");
    paramString.append(this.c);
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
    this.jdField_a_of_type_Boolean = true;
  }
  
  void a(String paramString, int paramInt, QFileMsgForwardManager.OnUploadCallback paramOnUploadCallback)
  {
    if (paramOnUploadCallback == null)
    {
      paramString = new StringBuilder();
      paramString.append("Troop2XXXTaskExcuter run but callback is null filename ");
      paramString.append(this.c);
      QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Troop2XXXTaskExcuter run filename ");
    localStringBuilder.append(this.c);
    QLog.d("FileMultiMsgManager<FileAssistant>", 1, localStringBuilder.toString());
    if ("1".equals(this.k))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("start Troop2XXXTaskExcuter:");
        paramString.append(this.c);
        paramString.append(" faild, file is upload paused");
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
      }
      paramOnUploadCallback.a(QFileMsgForwardManager.a(this.jdField_a_of_type_Long, false), false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback = paramOnUploadCallback;
    this.jdField_b_of_type_Long = Long.parseLong(paramString);
    this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardReceiverUin", String.valueOf(this.jdField_b_of_type_Long));
    paramString = this.jdField_b_of_type_JavaLangString;
    if ((paramString != null) && (!paramString.isEmpty())) {
      this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardSha", this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFileName", this.c);
    this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardSize", this.d);
    if (FileManagerUtil.a(this.e)) {
      this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFilePath", this.e);
    }
    if (!this.f.isEmpty()) {
      this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardImgWidth", this.h);
    }
    if (!this.g.isEmpty()) {
      this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardImgHeight", this.h);
    }
    if (!this.h.isEmpty()) {
      this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardDuration", this.h);
    }
    if (paramInt == 0) {
      this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFileType", String.valueOf(1));
    } else if (paramInt == 3000) {
      this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFileType", String.valueOf(2));
    } else if (paramInt == 1) {
      this.jdField_a_of_type_AndroidOsBundle.putString("_m_ForwardFileType", String.valueOf(3));
    }
    try
    {
      l1 = Long.parseLong(this.jdField_a_of_type_JavaLangString);
      if (this.j.isEmpty())
      {
        paramString = new StringBuilder();
        paramString.append("Troop2XXXTaskExcuter run but mstrUrl is empty ");
        paramString.append(this.c);
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback.a(QFileMsgForwardManager.a(this.jdField_a_of_type_Long, true), false);
      }
    }
    catch (NumberFormatException paramString)
    {
      long l1;
      label567:
      break label633;
    }
    try
    {
      paramInt = Integer.parseInt(this.i);
      paramString = new StringBuilder();
      paramString.append("Troop2XXXTaskExcuter will call reqCopyto filename[");
      paramString.append(this.c);
      paramString.append("], fileuuid[");
      paramString.append(this.j);
      paramString.append("]");
      QLog.d("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
      TroopFileProtocol.a(QFileMsgForwardManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager), l1, paramInt, this.j, this.jdField_b_of_type_Long, this.jdField_a_of_type_Int, null, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqCopyToObserver);
      return;
    }
    catch (NumberFormatException paramString)
    {
      break label567;
    }
    paramString = new StringBuilder();
    paramString.append("Troop2XXXTaskExcuter run but nSrcBusId ");
    paramString.append(0);
    paramString.append(" is error filename ");
    paramString.append(this.c);
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback.a(QFileMsgForwardManager.a(this.jdField_a_of_type_Long, false), false);
    return;
    label633:
    paramString = new StringBuilder();
    paramString.append("Troop2XXXTaskExcuter run but TroopUin ");
    paramString.append(this.jdField_a_of_type_JavaLangString);
    paramString.append(" is error filename ");
    paramString.append(this.c);
    QLog.e("FileMultiMsgManager<FileAssistant>", 1, paramString.toString());
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileMsgForwardManager$OnUploadCallback.a(QFileMsgForwardManager.a(this.jdField_a_of_type_Long, false), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileMsgForwardManager.Troop2XXXTaskExcuter
 * JD-Core Version:    0.7.0.1
 */