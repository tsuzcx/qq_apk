package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import com.tencent.mobileqq.data.MessageForShortVideo;
import java.lang.ref.WeakReference;

class GuildShortVideoItemBuilder$2
  implements Runnable
{
  GuildShortVideoItemBuilder$2(GuildShortVideoItemBuilder paramGuildShortVideoItemBuilder, WeakReference paramWeakReference, MessageForShortVideo paramMessageForShortVideo) {}
  
  public void run()
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      this.this$0.a(this.b, (GuildShortVideoItemBuilder.Holder)this.a.get(), this.b.videoFileProgress, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildShortVideoItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */