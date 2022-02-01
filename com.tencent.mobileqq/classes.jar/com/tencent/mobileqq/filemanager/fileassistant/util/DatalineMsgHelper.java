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
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  
  public DatalineMsgHelper(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = "3636666661";
    }
  }
  
  private void a(MessageForDLFile paramMessageForDLFile)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMessageForDLFile);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false, QFileAssistantUtils.a());
  }
  
  private void a(MessageForText paramMessageForText)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMessageForText);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false, QFileAssistantUtils.a());
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.DatalineMsgHelper
 * JD-Core Version:    0.7.0.1
 */