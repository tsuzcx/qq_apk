package com.tencent.mobileqq.confess;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;
import java.util.Random;

class ConfessManager$4
  implements Runnable
{
  ConfessManager$4(ConfessManager paramConfessManager, String paramString, ConfessManager.GroupChatExtra paramGroupChatExtra) {}
  
  public void run()
  {
    ConfessManager.GroupChatExtra localGroupChatExtra = this.this$0.k;
    if (localGroupChatExtra != null)
    {
      if (this.this$0.a == null) {
        return;
      }
      if (TextUtils.isEmpty(localGroupChatExtra.f)) {
        localGroupChatExtra.f = ContactUtils.b(this.this$0.a, this.a, this.b.h);
      }
      if (localGroupChatExtra.m == 0) {
        localGroupChatExtra.m = this.this$0.b(this.a, localGroupChatExtra.h, localGroupChatExtra.b, localGroupChatExtra.i, localGroupChatExtra.c);
      }
      if (localGroupChatExtra.m == 1)
      {
        long l2 = MessageCache.c();
        List localList = this.this$0.a.getMessageFacade().o(this.a, 1);
        long l1;
        if ((localList != null) && (!localList.isEmpty()))
        {
          l1 = ((ChatMessage)localList.get(localList.size() - 1)).shmsgseq + 1L;
        }
        else
        {
          l1 = Math.abs(new Random().nextInt());
          localGroupChatExtra.n = true;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("ConfessManager", 4, String.format(Locale.getDefault(), "enterGroupRecConfessChat shmsgseq: %s isRandomShmsgseq:%s", new Object[] { Long.valueOf(l1), Boolean.valueOf(localGroupChatExtra.n) }));
        }
        this.this$0.a(this.a, localGroupChatExtra, l2, l2, l1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessManager.4
 * JD-Core Version:    0.7.0.1
 */