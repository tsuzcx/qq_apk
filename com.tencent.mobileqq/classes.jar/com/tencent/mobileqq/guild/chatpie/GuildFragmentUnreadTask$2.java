package com.tencent.mobileqq.guild.chatpie;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.IReadConfirmCallback;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MsgListRegister;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class GuildFragmentUnreadTask$2
  implements Runnable
{
  GuildFragmentUnreadTask$2(GuildFragmentUnreadTask paramGuildFragmentUnreadTask) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setReadedOnTimer. sendReadReport channelId:");
    ((StringBuilder)localObject).append(this.this$0.a.O().b);
    QLog.i("GuildFragmentUnreadTask", 1, ((StringBuilder)localObject).toString());
    GuildFragmentUnreadTask.a(this.this$0, 10);
    localObject = this.this$0.a.e().a().b().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IReadConfirmCallback)((Iterator)localObject).next()).b(this.this$0.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildFragmentUnreadTask.2
 * JD-Core Version:    0.7.0.1
 */