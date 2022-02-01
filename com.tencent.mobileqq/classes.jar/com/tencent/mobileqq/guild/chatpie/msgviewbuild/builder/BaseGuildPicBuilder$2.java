package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;

class BaseGuildPicBuilder$2
  implements Runnable
{
  BaseGuildPicBuilder$2(BaseGuildPicBuilder paramBaseGuildPicBuilder, MessageForPic paramMessageForPic) {}
  
  public void run()
  {
    this.this$0.g.getMessageFacade().h(this.a.frienduin, this.a.istroop, this.a.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildPicBuilder.2
 * JD-Core Version:    0.7.0.1
 */