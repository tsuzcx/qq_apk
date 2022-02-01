package com.tencent.mobileqq.multimsg;

import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;

public class LongArkMsgManager
  extends LongTextMsgManager
{
  public LongArkMsgManager(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public int a()
  {
    return 4;
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageForArkApp paramMessageForArkApp, boolean paramBoolean)
  {
    if (paramMessageForArkApp.istroop == 1) {
      AnonymousChatHelper.a().a(paramMessageForArkApp);
    }
    if (paramBoolean) {
      paramQQAppInterface.getMessageFacade().a(paramMessageForArkApp);
    }
    paramMessageForArkApp.mPendantAnimatable = true;
    byte[] arrayOfByte = paramQQAppInterface.getProxyManager().a().a(paramMessageForArkApp);
    if (arrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "step2: sendLongTextMsg pack failed! packData is null.............................");
      }
      paramMessageForArkApp.extraflag = 32768;
      paramQQAppInterface.getMsgCache().a(paramMessageForArkApp.frienduin, paramMessageForArkApp.istroop, paramMessageForArkApp.uniseq);
      String str = paramMessageForArkApp.frienduin;
      int i = paramMessageForArkApp.istroop;
      long l = paramMessageForArkApp.uniseq;
      ((MessageHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.a(paramMessageForArkApp.istroop), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
    }
    paramBoolean = ((LongTextMsgManager)paramQQAppInterface.getManager(QQManagerFactory.LONG_TEXT_MSG_MANAGER)).a(paramQQAppInterface, arrayOfByte, paramQQAppInterface.getCurrentAccountUin(), paramMessageForArkApp.frienduin, paramMessageForArkApp.frienduin, paramMessageForArkApp.istroop, paramMessageForArkApp.uniseq, 1035, new LongArkMsgManager.1(this, paramMessageForArkApp, paramQQAppInterface));
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("StructLongTextMsg", 2, "sendLongTextMsg successful, uploadLongTextMsgPkg start!");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StructLongTextMsg", 2, "sendLongTextMsg failed! isSuccess:" + paramBoolean);
    }
    LongTextMsgManager.a(paramQQAppInterface, paramMessageForArkApp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.LongArkMsgManager
 * JD-Core Version:    0.7.0.1
 */