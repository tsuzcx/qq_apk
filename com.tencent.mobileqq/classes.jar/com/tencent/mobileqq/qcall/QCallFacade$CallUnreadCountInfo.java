package com.tencent.mobileqq.qcall;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
  
  private QCallFacade$CallUnreadCountInfo(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, Message paramMessage)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.c = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    boolean bool;
    try
    {
      QCallFacade localQCallFacade = (QCallFacade)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
      if (localQCallFacade != null)
      {
        this.jdField_a_of_type_Int = localQCallFacade.b(paramString, paramInt1);
        if (this.jdField_a_of_type_Int > 0)
        {
          if (paramMessage != null) {
            if (!ActionMsgUtil.b(paramMessage.msgtype))
            {
              bool = ActionMsgUtil.c(paramMessage.msgtype);
              if (!bool) {}
            }
            else
            {
              bool = true;
              break label115;
            }
          }
          bool = false;
          label115:
          if (bool) {
            break label161;
          }
          try
          {
            this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131709555);
          }
          catch (Exception paramMessage)
          {
            break label151;
          }
        }
      }
      bool = false;
    }
    catch (Exception paramMessage)
    {
      bool = false;
      label151:
      QLog.w("fetchUnReadCount", 1, "CallUnreadCountInfo , Exception", paramMessage);
    }
    label161:
    if (QLog.isDevelopLevel()) {
      QLog.d("fetchUnReadCount", 4, String.format("CallUnreadCountInfo, isCallTabShow[%s], isConversationTabShow[%s], isInCallList[%s], uin[%s], type[%s], mUnreadMsgNum[%s], mMissCallCount[%s], mMsgExtroInfo[%s], isVideoMsg[%s]", new Object[] { Boolean.valueOf(paramQQAppInterface.isCallTabShow), Boolean.valueOf(paramQQAppInterface.isConversationTabShow), Boolean.valueOf(paramQQAppInterface.isInCallList), paramString, Integer.valueOf(paramInt1), Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, Boolean.valueOf(bool) }));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallFacade.CallUnreadCountInfo
 * JD-Core Version:    0.7.0.1
 */