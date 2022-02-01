package com.tencent.mobileqq.guild.chatpie.sender;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.BaseMessageSender;
import com.tencent.mobileqq.activity.aio.core.input.IMsgSendListener;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister;

public class GuildMessageSender
  extends BaseMessageSender
{
  public GuildMessageSender(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void a(AIOContext paramAIOContext)
  {
    super.a(paramAIOContext);
  }
  
  public void b()
  {
    IMsgSendListener localIMsgSendListener = this.a.p().c().a(7);
    if (localIMsgSendListener.a(this.a)) {
      return;
    }
    super.b();
    localIMsgSendListener.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.sender.GuildMessageSender
 * JD-Core Version:    0.7.0.1
 */