package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.transfile.AbsDownloader;

class GuildMixedMsgItemBuilder$2
  implements Runnable
{
  GuildMixedMsgItemBuilder$2(GuildMixedMsgItemBuilder paramGuildMixedMsgItemBuilder, String paramString, URLDrawable paramURLDrawable) {}
  
  public void run()
  {
    if (AbsDownloader.hasFile(this.a)) {}
    try
    {
      this.b.startDownload();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMixedMsgItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */