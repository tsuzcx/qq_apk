package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

final class LeftSwipeReplyHelper$ItemTypeUtil
  extends ItemBuilderFactory
{
  private LeftSwipeReplyHelper$ItemTypeUtil(QQAppInterface paramQQAppInterface)
  {
    super(null, paramQQAppInterface, null, null, null);
  }
  
  private boolean a(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramChatMessage != null)
    {
      int i = a(this.b, paramChatMessage);
      if ((i != 81) && (i != 66) && (i != 42) && (i != 47))
      {
        bool1 = bool2;
        if (i != 89) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean a(ChatMessage paramChatMessage, MessageForArkApp paramMessageForArkApp)
  {
    if ((!paramMessageForArkApp.isMultiMsg) && (paramMessageForArkApp.istroop == 0))
    {
      if ((!paramChatMessage.senderuin.equals(this.b.getCurrentUin())) && (paramChatMessage.isSupportReply())) {
        return true;
      }
      if ((paramChatMessage.isSend()) && (paramChatMessage.isSupportReply()) && (paramChatMessage.extraflag != 32772) && (paramChatMessage.extraflag != 32768) && (paramChatMessage.istroop != 3000)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean b(ChatMessage paramChatMessage)
  {
    boolean bool = true;
    if (paramChatMessage != null)
    {
      int i = a(this.b, paramChatMessage);
      if (i == 81) {
        return c(paramChatMessage);
      }
      if ((i != 66) && (i != 42) && (i != 47) && (i != 89)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private boolean c(ChatMessage paramChatMessage)
  {
    boolean bool3 = paramChatMessage instanceof MessageForArkApp;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
      bool1 = bool2;
      if (a(paramChatMessage, localMessageForArkApp))
      {
        bool1 = bool2;
        if (localMessageForArkApp.msg != null) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.LeftSwipeReplyHelper.ItemTypeUtil
 * JD-Core Version:    0.7.0.1
 */