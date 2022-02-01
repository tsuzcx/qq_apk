package com.tencent.mobileqq.filemanager.fileassistant.util;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.MessageHandlerConstants.MsgSendCostParams;
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
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong, MessageHandlerConstants.MsgSendCostParams paramMsgSendCostParams)
  {
    if (paramBoolean)
    {
      if (!QFileAssistantUtils.a(paramString)) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSendResult isSuccess[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], uin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], uniseq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("]");
      QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, localStringBuilder.toString());
      paramString = this.a.getMessageFacade().a(paramString, paramMsgSendCostParams.f, paramLong);
      if (paramString == null)
      {
        QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, "onSendResult not find msg");
        return;
      }
      if ((paramString instanceof MessageForLongTextMsg))
      {
        ((DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).d(paramString.msg);
        QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, "onSendResult success longTextMsg");
        return;
      }
      if ((paramString instanceof MessageForText))
      {
        ((DataLineHandler)this.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(new QQText(paramString.msg, 13, 32, 0).toPlainText(true), 0);
        QLog.i("FileResultWatchForObserver<FileAssistant>NDL", 1, "onSendResult success TextMsg");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.util.FileResultWatchForObserver.1
 * JD-Core Version:    0.7.0.1
 */