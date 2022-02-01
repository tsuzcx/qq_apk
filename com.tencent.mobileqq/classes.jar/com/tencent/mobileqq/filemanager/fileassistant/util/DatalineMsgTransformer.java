package com.tencent.mobileqq.filemanager.fileassistant.util;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.QLog;

public class DatalineMsgTransformer
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DataLineMsgRecord jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord;
  private String jdField_a_of_type_JavaLangString;
  
  public DatalineMsgTransformer(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = "3636666661";
    }
  }
  
  private int a()
  {
    int k = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgtype;
    int j = -2005;
    int i = j;
    if (k != -2009)
    {
      i = j;
      if (k != -2000)
      {
        i = j;
        if (k != -2005)
        {
          if (k == -2009) {
            return -2005;
          }
          i = -1000;
        }
      }
    }
    return i;
  }
  
  private MessageForDLFile a()
  {
    MessageForDLFile localMessageForDLFile = (MessageForDLFile)MessageRecordFactory.a(-3017);
    localMessageForDLFile.uniseq = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid;
    localMessageForDLFile.msgseq = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgseq;
    localMessageForDLFile.shmsgseq = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.shmsgseq;
    localMessageForDLFile.fileName = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.filename;
    localMessageForDLFile.fileSize = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.filesize;
    localMessageForDLFile.associatedId = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid;
    localMessageForDLFile.deviceType = DataLineMsgRecord.getDevTypeBySeId(this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.sessionid);
    localMessageForDLFile.serial();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("transformForTextMessage: msg[");
    localStringBuilder.append(localMessageForDLFile.associatedId);
    localStringBuilder.append("] time[");
    localStringBuilder.append(localMessageForDLFile.time);
    localStringBuilder.append("]");
    QLog.i("DatalineMsgTransformer", 1, localStringBuilder.toString());
    return localMessageForDLFile;
  }
  
  private MessageForText a()
  {
    MessageForText localMessageForText = (MessageForText)MessageRecordFactory.a(-1000);
    localMessageForText.msg = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msg;
    localMessageForText.msgtype = -1000;
    localMessageForText.issend = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.issend;
    localMessageForText.isread = true;
    localMessageForText.time = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.time;
    if (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.msgtype != -1000) {
      localMessageForText.msg = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("transformForTextMessage: msg[");
    localStringBuilder.append(localMessageForText.msg);
    localStringBuilder.append("] time[");
    localStringBuilder.append(localMessageForText.time);
    localStringBuilder.append("]");
    QLog.i("DatalineMsgTransformer", 1, localStringBuilder.toString());
    return localMessageForText;
  }
  
  public ChatMessage a()
  {
    Object localObject = a();
    if (-2005 == a()) {
      localObject = a();
    }
    ((ChatMessage)localObject).selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    String str = this.jdField_a_of_type_JavaLangString;
    ((ChatMessage)localObject).frienduin = str;
    ((ChatMessage)localObject).senderuin = str;
    ((ChatMessage)localObject).msgUid = FileManagerUtil.b();
    ((ChatMessage)localObject).shmsgseq = FileManagerUtil.a();
    int j = this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.dataline_type;
    int i = 65793;
    if ((j != 0) && (this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord.dataline_type == 1)) {
      i = 68361;
    }
    QFileAssistantUtils.a((MessageRecord)localObject, i);
    ((ChatMessage)localObject).saveExtInfoToExtStr("dataline_old_msg", "1");
    return localObject;
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataDataLineMsgRecord = paramDataLineMsgRecord;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.DatalineMsgTransformer
 * JD-Core Version:    0.7.0.1
 */