package com.tencent.mobileqq.gamecenter.util;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.gamecenter.protocol.GameCenterUnissoHandler;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GameMsgSayHelloRules
  extends GameMsgStrangerRules
{
  protected int a;
  private SessionInfo a;
  protected List<ChatMessage> a;
  private boolean b;
  
  public GameMsgSayHelloRules(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, SessionInfo paramSessionInfo, List<ChatMessage> paramList)
  {
    super(paramQQAppInterface, paramString, paramInt1);
    this.jdField_b_of_type_Boolean = false;
    QLog.i(jdField_b_of_type_JavaLangString, 1, "[GameMsgSayHelloRules]");
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    c();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (this.jdField_a_of_type_Int != 0) {}
    while ((paramMessageRecord instanceof MessageForUniteGrayTip)) {
      return;
    }
    if (paramMessageRecord.issend != 1)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    b();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int != 0) {}
    while (!this.jdField_a_of_type_Boolean) {
      return true;
    }
    return super.a();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int != 0) {}
    while (!this.jdField_a_of_type_Boolean) {
      return;
    }
    super.b();
    this.jdField_a_of_type_Boolean = false;
    d();
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Int != 0) {
      this.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break;
      }
      int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
      while (i >= 0)
      {
        ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localChatMessage != null) && (!(localChatMessage instanceof MessageForUniteGrayTip)) && (GameMsgUtil.a(localChatMessage.time * 1000L)))
        {
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        i -= 1;
      }
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
  }
  
  protected void d()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      QLog.i(jdField_b_of_type_JavaLangString, 1, "ask server to push hello tips");
      ((GameCenterUnissoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GAME_CENTER_UNISSO_HANDLER)).a(3, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b(), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.GameMsgSayHelloRules
 * JD-Core Version:    0.7.0.1
 */