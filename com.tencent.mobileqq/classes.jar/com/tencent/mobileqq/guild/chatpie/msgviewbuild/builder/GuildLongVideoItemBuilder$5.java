package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

class GuildLongVideoItemBuilder$5
  implements Runnable
{
  GuildLongVideoItemBuilder$5(GuildLongVideoItemBuilder paramGuildLongVideoItemBuilder, boolean paramBoolean, GuildLongVideoItemBuilder.Holder paramHolder) {}
  
  public void run()
  {
    if (this.a) {
      this.b.i.setVisibility(8);
    } else {
      this.b.i.setVisibility(0);
    }
    this.this$0.a(this.b);
    this.b.h.setVisibility(0);
    this.b.d.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildLongVideoItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */