package com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier;

import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildVideoFileBuilder;

public class GuildVideoFileSupplier
  extends GuildItemBuilderSupplier
{
  protected ChatItemBuilder a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return new GuildVideoFileBuilder(this.b, paramBaseAdapter, this.a, this.c, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildVideoFileSupplier
 * JD-Core Version:    0.7.0.1
 */