package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.text.SpannableString;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.guild.chatpie.Util.GuildNameUtil;
import com.tencent.mobileqq.text.ColorNickText;

class GuildReplyTextItemBuilder$5$1
  implements Runnable
{
  final String a;
  final SpannableString b;
  
  GuildReplyTextItemBuilder$5$1(GuildReplyTextItemBuilder.5 param5)
  {
    param5 = this.this$0.a;
    String str = this.this$0.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.c.mSourceMsgSenderUin);
    localStringBuilder.append("");
    this.a = GuildNameUtil.a(param5, str, localStringBuilder.toString());
    this.b = new ColorNickText(this.a, 16).b();
  }
  
  public void run()
  {
    this.this$0.d.setTag(2131446809, this.a);
    this.this$0.d.setTag(2131446810, Long.valueOf(this.this$0.c.mSourceMsgSenderUin));
    this.this$0.d.setText(this.b);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2, 1.0F);
    localLayoutParams.gravity = 19;
    this.this$0.d.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildReplyTextItemBuilder.5.1
 * JD-Core Version:    0.7.0.1
 */