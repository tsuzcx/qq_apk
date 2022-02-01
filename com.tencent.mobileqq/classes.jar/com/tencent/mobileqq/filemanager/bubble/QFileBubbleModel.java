package com.tencent.mobileqq.filemanager.bubble;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.aioitem.QFileBubbleDownloadHandler;
import com.tencent.mobileqq.filemanager.aioitem.QFileBubblePauseHandler;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public abstract class QFileBubbleModel
{
  protected Context a;
  protected SessionInfo a;
  protected QQAppInterface a;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private MessageForFile jdField_a_of_type_ComTencentMobileqqDataMessageForFile;
  private MessageForTroopFile jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile;
  private ChatMessage b;
  protected boolean b;
  
  public QFileBubbleModel(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  private ChatMessage a(ChatMessage paramChatMessage)
  {
    int i = -2005;
    Object localObject = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileType");
    if ((paramChatMessage.isMultiMsg) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      QLog.i("QFileBubbleModel", 1, "getRealChatMessage log, fileType[" + (String)localObject + "]");
      int j = Integer.parseInt((String)localObject);
      if (j == 3)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile == null) {
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile = ((MessageForTroopFile)MessageRecordFactory.a(-2017));
        }
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile;
        ((ChatMessage)localObject).isMultiMsg = paramChatMessage.isMultiMsg;
        ((ChatMessage)localObject).frienduin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
        ((ChatMessage)localObject).senderuin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
        FileManagerUtil.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
        ((ChatMessage)localObject).istroop = 1;
        if ((j == 1) || (j == 2)) {
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ChatMessage)localObject).uniseq, ((ChatMessage)localObject).frienduin, ((ChatMessage)localObject).istroop, paramChatMessage);
        }
        return localObject;
      }
      if ((j == 1) || (j == 2))
      {
        if (j == 1) {}
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile == null) {
            this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile = ((MessageForFile)MessageRecordFactory.a(i));
          }
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile;
          ((ChatMessage)localObject).isMultiMsg = paramChatMessage.isMultiMsg;
          ((ChatMessage)localObject).frienduin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
          ((ChatMessage)localObject).senderuin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
          QFileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, paramChatMessage);
          FileManagerUtil.a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqDataMessageForFile);
          break;
          i = -2014;
        }
      }
      QLog.e("QFileBubbleModel", 1, "getRealChatMessage error, not support fileType. fileType[" + (String)localObject + "] extInfo[" + paramChatMessage.extStr + "]");
      return (ChatMessage)MessageRecordFactory.a(-2005);
    }
    QLog.e("QFileBubbleModel", 1, "getRealChatMessage error, not exist fileType. isMultiMsg[" + paramChatMessage.isMultiMsg + "] extInfo[" + paramChatMessage.extStr + "]");
    return (ChatMessage)MessageRecordFactory.a(-2005);
  }
  
  public abstract int a();
  
  public abstract long a();
  
  public ChatMessage a()
  {
    return this.jdField_b_of_type_ComTencentMobileqqDataChatMessage;
  }
  
  public abstract QFileBubbleDownloadHandler a();
  
  public abstract QFileBubblePauseHandler a();
  
  public abstract String a();
  
  public abstract List<Integer> a(int paramInt);
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public void a(int paramInt1, int paramInt2) {}
  
  public abstract void a(int paramInt, View paramView);
  
  protected abstract void a(ChatMessage paramChatMessage);
  
  public abstract boolean a();
  
  public abstract int b();
  
  public long b()
  {
    return 0L;
  }
  
  public abstract String b();
  
  public abstract List<Integer> b(int paramInt);
  
  public void b() {}
  
  public void b(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isMultiMsg) {}
    for (this.jdField_b_of_type_ComTencentMobileqqDataChatMessage = a(paramChatMessage);; this.jdField_b_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage)
    {
      a(this.jdField_b_of_type_ComTencentMobileqqDataChatMessage);
      return;
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public abstract int c();
  
  public String c()
  {
    return "";
  }
  
  public void c() {}
  
  protected void c(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramChatMessage.frienduin, paramChatMessage.istroop, paramChatMessage.uniseq);
    if (paramChatMessage.isSendFromLocal())
    {
      paramChatMessage = BaseTransFileController.makeKey(paramChatMessage.frienduin, paramChatMessage.uniseq);
      ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).removeProcessor(paramChatMessage);
    }
  }
  
  public boolean c()
  {
    return false;
  }
  
  public abstract int d();
  
  public String d()
  {
    return "";
  }
  
  public void d() {}
  
  public abstract int e();
  
  protected void e()
  {
    this.jdField_b_of_type_Boolean = false;
    ThreadManagerV2.getUIHandlerV2().postDelayed(new QFileBubbleModel.1(this), 1000L);
  }
  
  public int f()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.bubble.QFileBubbleModel
 * JD-Core Version:    0.7.0.1
 */