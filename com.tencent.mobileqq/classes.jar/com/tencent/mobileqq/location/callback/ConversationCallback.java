package com.tencent.mobileqq.location.callback;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

public class ConversationCallback
  implements IShareLocationCallback
{
  private void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendEmptyMessage(1009);
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean) {}
  
  public void b(int paramInt, long paramLong)
  {
    a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.callback.ConversationCallback
 * JD-Core Version:    0.7.0.1
 */