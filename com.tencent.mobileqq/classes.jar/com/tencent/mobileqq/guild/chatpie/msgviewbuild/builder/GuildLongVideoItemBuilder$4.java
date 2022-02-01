package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageForShortVideo;

class GuildLongVideoItemBuilder$4
  implements Runnable
{
  GuildLongVideoItemBuilder$4(GuildLongVideoItemBuilder paramGuildLongVideoItemBuilder, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void run()
  {
    GuildLongVideoItemBuilder.Holder localHolder = GuildLongVideoItemBuilder.a(this.this$0, this.a.uniseq);
    if (localHolder != null)
    {
      localHolder.h.setVisibility(8);
      localHolder.i.setVisibility(8);
      GuildLongVideoItemBuilder.a(this.this$0, localHolder, 2131915835);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildLongVideoItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */