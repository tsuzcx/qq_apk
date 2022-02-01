package com.tencent.mobileqq.gamecenter.util;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GameMsgSendTimesRules
  extends GameMsgSayHelloRules
{
  public static final String a;
  private int d;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131692842);
  }
  
  public GameMsgSendTimesRules(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, List<ChatMessage> paramList)
  {
    super(paramQQAppInterface, paramString, paramInt1, paramInt2, null, paramList);
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int != 0) {}
    while ((!this.jdField_a_of_type_Boolean) || (this.d < this.jdField_b_of_type_Int)) {
      return true;
    }
    return false;
  }
  
  public boolean a(List<ChatMessage> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return false;
    }
    int j = paramList.size() - 1;
    int i = 0;
    if (j >= 0)
    {
      Object localObject = (ChatMessage)paramList.get(j);
      if ((localObject != null) && ((localObject instanceof MessageForUniteGrayTip)))
      {
        localObject = (MessageForUniteGrayTip)localObject;
        if ((localObject == null) || (((MessageForUniteGrayTip)localObject).tipParam == null) || (!jdField_a_of_type_JavaLangString.equals(((MessageForUniteGrayTip)localObject).tipParam.c))) {
          break label112;
        }
        i += 1;
      }
    }
    label112:
    for (;;)
    {
      j -= 1;
      break;
      return i >= 3;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int != 0) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_b_of_type_JavaLangString, 2, "sendTimes---[recordAction]");
    }
    this.d += 1;
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    int i = this.jdField_a_of_type_JavaUtilList.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label141;
      }
      ChatMessage localChatMessage = (ChatMessage)this.jdField_a_of_type_JavaUtilList.get(i);
      if ((localChatMessage != null) && (!(localChatMessage instanceof MessageForUniteGrayTip)))
      {
        if (!GameMsgUtil.a(1000L * localChatMessage.time)) {
          break;
        }
        if (localChatMessage.issend != 1)
        {
          this.jdField_a_of_type_Boolean = false;
          return;
        }
        this.d += 1;
        if (this.d > this.jdField_b_of_type_Int)
        {
          this.jdField_a_of_type_Boolean = false;
          return;
        }
      }
      i -= 1;
    }
    label141:
    QLog.i(jdField_b_of_type_JavaLangString, 1, "mCurSendMsgNum:" + this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.GameMsgSendTimesRules
 * JD-Core Version:    0.7.0.1
 */