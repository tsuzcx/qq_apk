package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import com.tencent.mobileqq.data.MessageForShortVideo;
import java.lang.ref.WeakReference;

class GuildShortVideoItemBuilder$1
  implements Runnable
{
  GuildShortVideoItemBuilder$1(GuildShortVideoItemBuilder paramGuildShortVideoItemBuilder, MessageForShortVideo paramMessageForShortVideo, WeakReference paramWeakReference) {}
  
  public void run()
  {
    if (this.a.progress <= 0)
    {
      localObject = this.a;
      ((MessageForShortVideo)localObject).progress = ((MessageForShortVideo)localObject).videoFileProgress;
    }
    Object localObject = this.b;
    if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
      this.this$0.a(this.a, (GuildShortVideoItemBuilder.Holder)this.b.get(), this.a.videoFileProgress, this.a.progress);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildShortVideoItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */