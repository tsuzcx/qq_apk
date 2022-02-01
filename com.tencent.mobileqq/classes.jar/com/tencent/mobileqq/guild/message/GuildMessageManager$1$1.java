package com.tencent.mobileqq.guild.message;

import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import java.util.Map;

class GuildMessageManager$1$1
  implements Runnable
{
  GuildMessageManager$1$1(GuildMessageManager.1 param1) {}
  
  public void run()
  {
    if (this.a.this$0.b.getRefreshActionMap().containsKey(UinTypeUtil.a(this.a.b, this.a.c))) {
      this.a.this$0.b.getRefreshActionMap().remove(UinTypeUtil.a(this.a.b, this.a.c));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.GuildMessageManager.1.1
 * JD-Core Version:    0.7.0.1
 */