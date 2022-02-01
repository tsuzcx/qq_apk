package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.os.Handler;
import com.tencent.mobileqq.data.MessageForShortVideo;

class GuildShortVideoItemBuilder$9
  implements Runnable
{
  GuildShortVideoItemBuilder$9(GuildShortVideoItemBuilder paramGuildShortVideoItemBuilder, boolean paramBoolean1, GuildShortVideoItemBuilder.Holder paramHolder, MessageForShortVideo paramMessageForShortVideo, boolean paramBoolean2) {}
  
  public void run()
  {
    if ((this.a) && (this.b != null) && (this.c.progressTask == null))
    {
      this.c.progressTask = new GuildShortVideoItemBuilder.9.1(this);
      GuildShortVideoItemBuilder.a(this.this$0).removeCallbacks(this.c.progressTask);
      GuildShortVideoItemBuilder.a(this.this$0).post(this.c.progressTask);
    }
    if (this.d) {
      GuildShortVideoItemBuilder.c(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildShortVideoItemBuilder.9
 * JD-Core Version:    0.7.0.1
 */