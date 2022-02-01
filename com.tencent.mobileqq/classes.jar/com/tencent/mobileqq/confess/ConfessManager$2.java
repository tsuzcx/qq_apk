package com.tencent.mobileqq.confess;

import android.text.TextUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.ContactUtils;

class ConfessManager$2
  implements Runnable
{
  ConfessManager$2(ConfessManager paramConfessManager, String paramString) {}
  
  public void run()
  {
    ConfessManager.FrdChatExtra localFrdChatExtra = this.this$0.g;
    if (localFrdChatExtra == null) {
      return;
    }
    if (TextUtils.isEmpty(localFrdChatExtra.g)) {
      localFrdChatExtra.g = ContactUtils.a(this.this$0.a, localFrdChatExtra.h);
    }
    if (localFrdChatExtra.m == 0) {
      localFrdChatExtra.m = this.this$0.a(this.a, localFrdChatExtra.h, localFrdChatExtra.i, localFrdChatExtra.a);
    }
    if (localFrdChatExtra.m == 1)
    {
      long l = MessageCache.c();
      this.this$0.a(this.a, localFrdChatExtra, l, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessManager.2
 * JD-Core Version:    0.7.0.1
 */