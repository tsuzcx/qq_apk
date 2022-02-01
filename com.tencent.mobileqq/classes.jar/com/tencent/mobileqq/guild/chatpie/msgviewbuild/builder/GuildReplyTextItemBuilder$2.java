package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import android.view.View;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.SourceMessagePulledCallBack;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.BubbleImageView;

final class GuildReplyTextItemBuilder$2
  implements ReplyTextItemBuilder.SourceMessagePulledCallBack
{
  GuildReplyTextItemBuilder$2(MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, BubbleImageView paramBubbleImageView, ETTextView paramETTextView1, ETTextView paramETTextView2, int paramInt, String paramString, MessageRecord paramMessageRecord) {}
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, View paramView, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, String paramString)
  {
    if (GuildReplyTextItemBuilder.a(paramMessageRecord2))
    {
      if ((paramMessageRecord1 instanceof MessageForReplyText))
      {
        paramView = (MessageForReplyText)paramMessageRecord1;
        if (paramView.getSourceMessage() == null) {
          paramView.setSourceMessageRecord(paramMessageRecord2);
        }
      }
      GuildReplyTextItemBuilder.a(paramMessageRecord2, this.a, this.b, this.c, this.d, this.e, this.f, this.g, paramContext, paramQQAppInterface, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildReplyTextItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */