package com.tencent.mobileqq.qqexpand.chat.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;

final class ExpandChatUtil$5
  implements Runnable
{
  ExpandChatUtil$5(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    ExpandFriendData.setHasShowIcebreakerTopic(this.a, this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil.5
 * JD-Core Version:    0.7.0.1
 */