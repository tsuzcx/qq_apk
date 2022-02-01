package com.tencent.mobileqq.qqexpand.match;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil;

class BaseStateHandler$1
  implements Runnable
{
  BaseStateHandler$1(BaseStateHandler paramBaseStateHandler, String paramString1, String paramString2) {}
  
  public void run()
  {
    ExpandChatUtil.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.match.BaseStateHandler.1
 * JD-Core Version:    0.7.0.1
 */