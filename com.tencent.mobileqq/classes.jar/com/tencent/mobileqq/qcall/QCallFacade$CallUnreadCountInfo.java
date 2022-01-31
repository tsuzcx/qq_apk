package com.tencent.mobileqq.qcall;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.qphone.base.util.QLog;

public class QCallFacade$CallUnreadCountInfo
{
  protected int a;
  protected QQAppInterface a;
  protected String a;
  protected int b;
  protected String b;
  protected int c;
  
  private QCallFacade$CallUnreadCountInfo(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, QQMessageFacade.Message paramMessage)
  {
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.c = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    QCallFacade localQCallFacade = (QCallFacade)paramQQAppInterface.getManager(37);
    boolean bool;
    if (localQCallFacade != null)
    {
      this.jdField_a_of_type_Int = localQCallFacade.b(paramString, paramInt1);
      if (this.jdField_a_of_type_Int > 0) {
        if ((paramMessage != null) && ((ActionMsgUtil.b(paramMessage.msgtype)) || (ActionMsgUtil.c(paramMessage.msgtype))))
        {
          bool = true;
          if (!bool) {}
        }
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("fetchUnReadCount", 4, String.format("CallUnreadCountInfo, isCallTabShow[%s], isConversationTabShow[%s], isInCallList[%s], uin[%s], type[%s], mUnreadMsgNum[%s], mMissCallCount[%s], mMsgExtroInfo[%s], isVideoMsg[%s]", new Object[] { Boolean.valueOf(paramQQAppInterface.n), Boolean.valueOf(paramQQAppInterface.o), Boolean.valueOf(paramQQAppInterface.p), paramString, Integer.valueOf(paramInt1), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, Boolean.valueOf(bool) }));
      }
      return;
      this.jdField_a_of_type_JavaLangString = "[有未接来电]";
      continue;
      bool = false;
      break;
      bool = false;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallFacade.CallUnreadCountInfo
 * JD-Core Version:    0.7.0.1
 */