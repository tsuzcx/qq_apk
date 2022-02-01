package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;

class GuildMarketFaceItemBuilder$14
  implements DialogInterface.OnClickListener
{
  GuildMarketFaceItemBuilder$14(GuildMarketFaceItemBuilder paramGuildMarketFaceItemBuilder, GuildMarketFaceItemBuilder.Holder paramHolder) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityFacade.a(this.b.g, this.b.o, this.b.c, this.a.a.getEmoticon(), this.a.q.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMarketFaceItemBuilder.14
 * JD-Core Version:    0.7.0.1
 */