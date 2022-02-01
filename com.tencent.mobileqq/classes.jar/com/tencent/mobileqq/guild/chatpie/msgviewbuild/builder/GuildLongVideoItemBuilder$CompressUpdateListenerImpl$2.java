package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.MessageForShortVideo;

class GuildLongVideoItemBuilder$CompressUpdateListenerImpl$2
  implements Runnable
{
  GuildLongVideoItemBuilder$CompressUpdateListenerImpl$2(GuildLongVideoItemBuilder.CompressUpdateListenerImpl paramCompressUpdateListenerImpl, MessageForShortVideo paramMessageForShortVideo, int paramInt) {}
  
  public void run()
  {
    GuildLongVideoItemBuilder.Holder localHolder = GuildLongVideoItemBuilder.a(this.c.a, this.a);
    if (localHolder != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.frienduin);
      ((StringBuilder)localObject).append(this.a.uniseq);
      localObject = ((StringBuilder)localObject).toString();
      if (this.b == 1)
      {
        localHolder.c.a((String)localObject, 1.0F);
        localHolder.c.setAnimProgress(10, (String)localObject);
        localHolder.c.setVideoCompressStatus(false);
        return;
      }
      localHolder.c.setVideoCompressPercent((String)localObject, 0.0F);
      localHolder.c.setVideoCompressStatus(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildLongVideoItemBuilder.CompressUpdateListenerImpl.2
 * JD-Core Version:    0.7.0.1
 */