package com.tencent.mobileqq.filemanager.multisave;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class DatalineFileSaveModel
  extends QFileSaveModel
{
  private MessageForDLFile a;
  
  public DatalineFileSaveModel(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    super(paramQQAppInterface, paramChatMessage);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForDLFile = ((MessageForDLFile)paramChatMessage);
  }
  
  private DataLineMsgRecord a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqDataMessageForDLFile.deviceType;
    long l = this.jdField_a_of_type_ComTencentMobileqqDataMessageForDLFile.associatedId;
    DataLineMsgRecord localDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(i).a(l);
    if (localDataLineMsgRecord == null) {
      QLog.i("DatalineFileSaveModel<QFile>", 1, "getSourceDatalineFile：do not find sessionId[" + l + "]");
    }
    return localDataLineMsgRecord;
  }
  
  public long a()
  {
    DataLineMsgRecord localDataLineMsgRecord = a();
    if (localDataLineMsgRecord != null) {
      return localDataLineMsgRecord.filesize;
    }
    return 0L;
  }
  
  public QFileControlReq a()
  {
    DatalineFileControlReq localDatalineFileControlReq = new DatalineFileControlReq(a());
    localDatalineFileControlReq.a(new DatalineFileSaveModel.1(this));
    return localDatalineFileControlReq;
  }
  
  public String a()
  {
    DataLineMsgRecord localDataLineMsgRecord = a();
    if (localDataLineMsgRecord != null) {
      return localDataLineMsgRecord.path;
    }
    return "";
  }
  
  public boolean a()
  {
    DataLineMsgRecord localDataLineMsgRecord = a();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
    localDataLineHandler.a(localArrayList);
    return true;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForDLFile.frienduin + this.jdField_a_of_type_ComTencentMobileqqDataMessageForDLFile.uniseq;
  }
  
  public boolean b()
  {
    DataLineMsgRecord localDataLineMsgRecord = a();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, false);
    return true;
  }
  
  public boolean c()
  {
    DataLineMsgRecord localDataLineMsgRecord = a();
    if (localDataLineMsgRecord != null) {
      return localDataLineMsgRecord.bIsTransfering;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.DatalineFileSaveModel
 * JD-Core Version:    0.7.0.1
 */