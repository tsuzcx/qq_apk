package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import mqq.os.MqqHandler;

final class GuildReplyTextItemBuilder$5
  implements Runnable
{
  GuildReplyTextItemBuilder$5(QQAppInterface paramQQAppInterface, String paramString, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, TextView paramTextView) {}
  
  public void run()
  {
    ThreadManager.getUIHandler().post(new GuildReplyTextItemBuilder.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildReplyTextItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */