package com.tencent.mobileqq.qqexpand.chat.utils;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;

final class ExpandChatUtil$4
  implements Runnable
{
  ExpandChatUtil$4(BaseQQAppInterface paramBaseQQAppInterface, String paramString) {}
  
  public void run()
  {
    ExpandFriendData.setHasEnterAIO(this.a, this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.utils.ExpandChatUtil.4
 * JD-Core Version:    0.7.0.1
 */