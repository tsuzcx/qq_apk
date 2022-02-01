package com.tencent.mobileqq.guild.chatpie;

import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.msglist.BaseMsgLoader;
import com.tencent.mobileqq.activity.aio.core.msglist.IReadConfirmCallback;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.MsgListRegister;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class GuildFragmentUnreadTask$1
  implements Runnable
{
  GuildFragmentUnreadTask$1(GuildFragmentUnreadTask paramGuildFragmentUnreadTask) {}
  
  public void run()
  {
    if (this.this$0.a.a() == null) {
      return;
    }
    Object localObject1 = this.this$0.a.e().a().b();
    Object localObject2 = this.this$0.a.e().c().a(this.this$0.a);
    Iterator localIterator = ((List)localObject1).iterator();
    while (localIterator.hasNext()) {
      ((IReadConfirmCallback)localIterator.next()).a(this.this$0.a, (List)localObject2, GuildFragmentUnreadTask.a(this.this$0));
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("setReadedOnOpen. sendReadReport channelId:");
    ((StringBuilder)localObject2).append(this.this$0.a.O().b);
    QLog.i("GuildFragmentUnreadTask", 1, ((StringBuilder)localObject2).toString());
    GuildFragmentUnreadTask.a(this.this$0, 4);
    GuildFragmentUnreadTask.b(this.this$0);
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((IReadConfirmCallback)((Iterator)localObject1).next()).a(this.this$0.a);
    }
    this.this$0.a.i();
    if (!this.this$0.a.g().hasMessages(16711698)) {
      this.this$0.a.g().sendEmptyMessageDelayed(16711698, 300000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildFragmentUnreadTask.1
 * JD-Core Version:    0.7.0.1
 */