package com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier;

import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildLiveChannelTextItemBuild;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildTextItemBuild;

public class GuildTextSupplier
  extends GuildItemBuilderSupplier
{
  protected ChatItemBuilder a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    if (b()) {
      return new GuildLiveChannelTextItemBuild(this.b, paramBaseAdapter, this.a, this.c, this.e);
    }
    return new GuildTextItemBuild(this.b, paramBaseAdapter, this.a, this.c, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildTextSupplier
 * JD-Core Version:    0.7.0.1
 */