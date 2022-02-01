package com.tencent.mobileqq.filemanager.fileassistant.util;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.MessageHandler.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;

class FileResultWatchForObserver$1
  extends MessageObserver
{
  FileResultWatchForObserver$1(FileResultWatchForObserver paramFileResultWatchForObserver, QQAppInterface paramQQAppInterface) {}
  
  public void onSendResult(boolean paramBoolean, String paramString, long paramLong, MessageHandler.MsgSendCostParams paramMsgSendCostParams)
  {
    if ((!paramBoolean) || (!QFileAssistantUtils.a(paramString))) {}
    do
    {
      return;
      QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, "onSendResult isSuccess[" + paramBoolean + "], uin[" + paramString + "], uniseq[" + paramLong + "]");
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, paramMsgSendCostParams.a, paramLong);
      if (paramString == null)
      {
        QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, "onSendResult not find msg");
        return;
      }
      if ((paramString instanceof MessageForLongTextMsg))
      {
        ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(paramString.msg);
        QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, "onSendResult success longTextMsg");
        return;
      }
    } while (!(paramString instanceof MessageForText));
    ((DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(new QQText(paramString.msg, 13, 32, 0).toPlainText(true), 0);
    QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, "onSendResult success TextMsg");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.FileResultWatchForObserver.1
 * JD-Core Version:    0.7.0.1
 */