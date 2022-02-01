package com.tencent.mobileqq.filemanager.fileassistant.util;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.List;

public class DatalineMsgHelper
{
  private QQAppInterface a;
  private String b;
  
  public DatalineMsgHelper(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    if (TextUtils.isEmpty(this.b)) {
      this.b = "3636666661";
    }
  }
  
  private void a(MessageForDLFile paramMessageForDLFile)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMessageForDLFile);
    this.a.getMessageFacade().a(localArrayList, this.a.getCurrentAccountUin(), false, QFileAssistantUtils.b());
  }
  
  private void a(MessageForText paramMessageForText)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMessageForText);
    this.a.getMessageFacade().a(localArrayList, this.a.getCurrentAccountUin(), false, QFileAssistantUtils.b());
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -1000)
    {
      a((MessageForText)paramMessageRecord);
      return;
    }
    if (paramMessageRecord.msgtype == -3017) {
      a((MessageForDLFile)paramMessageRecord);
    }
  }
  
  public void a(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.a.getMessageFacade().a(paramList, this.a.getCurrentAccountUin(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.DatalineMsgHelper
 * JD-Core Version:    0.7.0.1
 */