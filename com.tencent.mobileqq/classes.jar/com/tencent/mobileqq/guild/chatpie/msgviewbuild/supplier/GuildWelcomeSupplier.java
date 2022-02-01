package com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier;

import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildLiveChannelSecurityItemBuild;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildWelcomeItemBuild;

public class GuildWelcomeSupplier
  extends GuildItemBuilderSupplier
{
  protected ChatItemBuilder a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    if (b()) {
      return new GuildLiveChannelSecurityItemBuild(this.b, paramBaseAdapter, this.a, this.c, this.e);
    }
    return new GuildWelcomeItemBuild(this.b, paramBaseAdapter, this.a, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildWelcomeSupplier
 * JD-Core Version:    0.7.0.1
 */