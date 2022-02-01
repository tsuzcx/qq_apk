package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.widget.TextView;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.widget.MessageProgressView;

class GuildShortVideoItemBuilder$9$1
  implements Runnable
{
  GuildShortVideoItemBuilder$9$1(GuildShortVideoItemBuilder.9 param9) {}
  
  public void run()
  {
    if (this.a.c.progress <= 0) {
      this.a.c.progress = this.a.c.videoFileProgress;
    }
    if ((ShortVideoUtils.getDisplayProgress(this.a.c.videoFileProgress, 10) > 60) || (this.a.c.progress > 60))
    {
      this.a.b.b.setDrawStatus(1);
      MessageProgressView localMessageProgressView = this.a.b.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.c.frienduin);
      localStringBuilder.append(this.a.c.uniseq);
      localMessageProgressView.setAnimProgress(60, localStringBuilder.toString());
      this.a.b.b.setVisibility(0);
      this.a.b.c.setVisibility(8);
    }
    this.a.this$0.a(this.a.c, this.a.b, this.a.c.videoFileProgress, this.a.c.progress);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildShortVideoItemBuilder.9.1
 * JD-Core Version:    0.7.0.1
 */