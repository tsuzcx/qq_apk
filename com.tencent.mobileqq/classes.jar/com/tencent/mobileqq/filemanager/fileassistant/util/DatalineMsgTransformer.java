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
  private DataLineMsgRecord a;
  private QQAppInterface b;
  private String c;
  
  public DatalineMsgTransformer(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    if (TextUtils.isEmpty(this.c)) {
      this.c = "3636666661";
    }
  }
  
  private int b()
  {
    int k = this.a.msgtype;
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
  
  private MessageForText c()
  {
    MessageForText localMessageForText = (MessageForText)MessageRecordFactory.a(-1000);
    localMessageForText.msg = this.a.msg;
    localMessageForText.msgtype = -1000;
    localMessageForText.issend = this.a.issend;
    localMessageForText.isread = true;
    localMessageForText.time = this.a.time;
    if (this.a.msgtype != -1000) {
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
  
  private MessageForDLFile d()
  {
    MessageForDLFile localMessageForDLFile = (MessageForDLFile)MessageRecordFactory.a(-3017);
    localMessageForDLFile.uniseq = this.a.sessionid;
    localMessageForDLFile.msgseq = this.a.msgseq;
    localMessageForDLFile.shmsgseq = this.a.shmsgseq;
    localMessageForDLFile.fileName = this.a.filename;
    localMessageForDLFile.fileSize = this.a.filesize;
    localMessageForDLFile.associatedId = this.a.sessionid;
    localMessageForDLFile.deviceType = DataLineMsgRecord.getDevTypeBySeId(this.a.sessionid);
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
  
  public ChatMessage a()
  {
    Object localObject = c();
    if (-2005 == b()) {
      localObject = d();
    }
    ((ChatMessage)localObject).selfuin = this.b.getCurrentAccountUin();
    String str = this.c;
    ((ChatMessage)localObject).frienduin = str;
    ((ChatMessage)localObject).senderuin = str;
    ((ChatMessage)localObject).msgUid = FileManagerUtil.g();
    ((ChatMessage)localObject).shmsgseq = FileManagerUtil.f();
    int j = this.a.dataline_type;
    int i = 65793;
    if ((j != 0) && (this.a.dataline_type == 1)) {
      i = 68361;
    }
    QFileAssistantUtils.a((MessageRecord)localObject, i);
    ((ChatMessage)localObject).saveExtInfoToExtStr("dataline_old_msg", "1");
    return localObject;
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    this.a = paramDataLineMsgRecord;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.DatalineMsgTransformer
 * JD-Core Version:    0.7.0.1
 */