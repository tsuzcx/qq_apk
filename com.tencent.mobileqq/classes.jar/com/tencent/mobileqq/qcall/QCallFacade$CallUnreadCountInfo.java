package com.tencent.mobileqq.qcall;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.qphone.base.util.QLog;

public class QCallFacade$CallUnreadCountInfo
{
  protected int a = 0;
  protected int b = 0;
  protected String c = null;
  protected String d;
  protected int e;
  protected QQAppInterface f;
  
  private QCallFacade$CallUnreadCountInfo(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, Message paramMessage)
  {
    this.b = paramInt2;
    this.d = paramString;
    this.e = paramInt1;
    this.f = paramQQAppInterface;
    boolean bool;
    try
    {
      QCallFacade localQCallFacade = (QCallFacade)paramQQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
      if (localQCallFacade != null)
      {
        this.a = localQCallFacade.e(paramString, paramInt1);
        if (this.a > 0)
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
            this.c = HardCodeUtil.a(2131907285);
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
      QLog.d("fetchUnReadCount", 4, String.format("CallUnreadCountInfo, isCallTabShow[%s], isConversationTabShow[%s], isInCallList[%s], uin[%s], type[%s], mUnreadMsgNum[%s], mMissCallCount[%s], mMsgExtroInfo[%s], isVideoMsg[%s]", new Object[] { Boolean.valueOf(paramQQAppInterface.isCallTabShow), Boolean.valueOf(paramQQAppInterface.isConversationTabShow), Boolean.valueOf(paramQQAppInterface.isInCallList), paramString, Integer.valueOf(paramInt1), Integer.valueOf(this.b), Integer.valueOf(this.a), this.c, Boolean.valueOf(bool) }));
    }
  }
  
  public int a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.QCallFacade.CallUnreadCountInfo
 * JD-Core Version:    0.7.0.1
 */