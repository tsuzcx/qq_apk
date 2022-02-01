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
  private MessageForDLFile d;
  
  public DatalineFileSaveModel(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    super(paramQQAppInterface, paramChatMessage);
    this.d = ((MessageForDLFile)paramChatMessage);
  }
  
  private DataLineMsgRecord h()
  {
    int i = this.d.deviceType;
    long l = this.d.associatedId;
    DataLineMsgRecord localDataLineMsgRecord = this.a.getMessageFacade().d(i).a(l);
    if (localDataLineMsgRecord == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSourceDatalineFile：do not find sessionId[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.i("DatalineFileSaveModel<QFile>", 1, localStringBuilder.toString());
    }
    return localDataLineMsgRecord;
  }
  
  public boolean a()
  {
    DataLineMsgRecord localDataLineMsgRecord = h();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    DataLineHandler localDataLineHandler = (DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(localDataLineMsgRecord.sessionid));
    localDataLineHandler.b(localArrayList);
    return true;
  }
  
  public boolean b()
  {
    DataLineMsgRecord localDataLineMsgRecord = h();
    if (localDataLineMsgRecord == null) {
      return false;
    }
    ((DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(localDataLineMsgRecord.groupId, localDataLineMsgRecord.sessionid, false);
    return true;
  }
  
  public String c()
  {
    DataLineMsgRecord localDataLineMsgRecord = h();
    if (localDataLineMsgRecord != null) {
      return localDataLineMsgRecord.path;
    }
    return "";
  }
  
  public boolean d()
  {
    DataLineMsgRecord localDataLineMsgRecord = h();
    if (localDataLineMsgRecord != null) {
      return localDataLineMsgRecord.bIsTransfering;
    }
    return false;
  }
  
  public QFileControlReq e()
  {
    DatalineFileControlReq localDatalineFileControlReq = new DatalineFileControlReq(h());
    localDatalineFileControlReq.a(new DatalineFileSaveModel.1(this));
    return localDatalineFileControlReq;
  }
  
  public String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d.frienduin);
    localStringBuilder.append(this.d.uniseq);
    return localStringBuilder.toString();
  }
  
  public long g()
  {
    DataLineMsgRecord localDataLineMsgRecord = h();
    if (localDataLineMsgRecord != null) {
      return localDataLineMsgRecord.filesize;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.multisave.DatalineFileSaveModel
 * JD-Core Version:    0.7.0.1
 */