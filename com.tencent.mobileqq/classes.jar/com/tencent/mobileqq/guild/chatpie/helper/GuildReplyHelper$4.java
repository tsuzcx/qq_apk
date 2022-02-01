package com.tencent.mobileqq.guild.chatpie.helper;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;

class GuildReplyHelper$4
  implements View.OnClickListener
{
  GuildReplyHelper$4(GuildReplyHelper paramGuildReplyHelper) {}
  
  public void onClick(View paramView)
  {
    paramView = GuildReplyHelper.e(this.a).getMessageFacade().getLastMessage(GuildReplyHelper.d(this.a).b, GuildReplyHelper.d(this.a).a);
    GuildReplyHelper.a(this.a).e().d().a(22, GuildReplyHelper.f(this.a).mSourceMsgSeq, (int)(paramView.shmsgseq - GuildReplyHelper.g(this.a).mSourceMsgSeq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildReplyHelper.4
 * JD-Core Version:    0.7.0.1
 */