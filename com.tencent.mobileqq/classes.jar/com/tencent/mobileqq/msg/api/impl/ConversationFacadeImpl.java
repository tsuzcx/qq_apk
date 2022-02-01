package com.tencent.mobileqq.msg.api.impl;

import com.tencent.imcore.message.ConversationFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ConversationFacadeImpl
  implements IConversationFacade
{
  public static final String TAG = "ConversationFacadeImpl";
  private QQAppInterface mApp;
  
  public int getReadUnreadMark(String paramString, int paramInt)
  {
    return this.mApp.getConversationFacade().d(paramString, paramInt);
  }
  
  public int getUnreadCount(String paramString, int paramInt)
  {
    return this.mApp.getConversationFacade().a(paramString, paramInt);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    boolean bool1 = true;
    boolean bool2;
    if (QLog.isColorLevel())
    {
      bool2 = paramAppRuntime instanceof QQAppInterface;
      if (paramAppRuntime != null) {
        break label67;
      }
    }
    for (;;)
    {
      QLog.d("ConversationFacadeImpl", 2, new Object[] { "MessageFacadeImpl onCreate: app instanceOf QQApp: ", Boolean.valueOf(bool2), "app is null: ", Boolean.valueOf(bool1) });
      if ((paramAppRuntime instanceof QQAppInterface)) {
        this.mApp = ((QQAppInterface)paramAppRuntime);
      }
      return;
      label67:
      bool1 = false;
    }
  }
  
  public void onDestroy() {}
  
  public void setUnreadMark(String paramString, int paramInt1, int paramInt2)
  {
    this.mApp.getConversationFacade().a(paramString, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.msg.api.impl.ConversationFacadeImpl
 * JD-Core Version:    0.7.0.1
 */