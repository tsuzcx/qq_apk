package com.tencent.mobileqq.qqexpand.chat.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.qphone.base.util.QLog;

final class LimitChatUtil$4
  extends ExpandObserver
{
  LimitChatUtil$4(QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramObject != null))
    {
      ExpandChatUtil.a(this.a, this.b, this.c, paramObject);
      return;
    }
    QLog.w("LimitChatUtil", 1, "showIcebreakerTopic network error, data is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil.4
 * JD-Core Version:    0.7.0.1
 */