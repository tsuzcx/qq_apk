package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import android.view.View;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.SourceMessagePulledCallBack;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;

final class GuildReplyTextItemBuilder$1
  implements ReplyTextItemBuilder.SourceMessagePulledCallBack
{
  GuildReplyTextItemBuilder$1(ETTextView paramETTextView1, ETTextView paramETTextView2, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, BubbleImageView paramBubbleImageView, int paramInt, String paramString, MessageRecord paramMessageRecord) {}
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, View paramView, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, String paramString)
  {
    if ((paramView instanceof ChatThumbView)) {
      if (paramMessageRecord2 != null)
      {
        if (((paramMessageRecord2 instanceof MessageForText)) && (((MessageForText)paramMessageRecord2).msg != null))
        {
          GuildReplyTextItemBuilder.a(this.a, this.b, 1, this.c.mSourceMsgText, paramMessageRecord2);
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("returned text msg error!");
            paramContext.append(this.c.mSourceMsgText);
            QLog.e("GuildReplyTextItemBuilder", 1, paramContext.toString());
          }
        }
        else
        {
          if ((paramMessageRecord1 instanceof MessageForReplyText))
          {
            paramView = (MessageForReplyText)paramMessageRecord1;
            if (paramView.getSourceMessage() != null) {
              paramView.setSourceMessageRecord(paramMessageRecord2);
            }
          }
          GuildReplyTextItemBuilder.a(paramMessageRecord2, this.c, this.d, this.a, this.b, this.e, this.f, this.g, paramContext, paramQQAppInterface, paramString);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.w("GuildReplyTextItemBuilder", 2, "processReplyMsg:source msg has been deleted.");
        }
        paramContext = this.d;
        if (paramContext != null)
        {
          paramContext.setVisibility(0);
          GuildReplyTextItemBuilder.a(this.a, this.b, 1, this.c.mSourceMsgText, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildReplyTextItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */