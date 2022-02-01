package com.tencent.mobileqq.guild.chatpie.manager;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMarketFaceItemBuilder.Holder;

class GuildPngFrameManager$1
  implements Runnable
{
  GuildPngFrameManager$1(GuildPngFrameManager paramGuildPngFrameManager, GuildPngFrameManager.RandomDrawableParam paramRandomDrawableParam) {}
  
  public void run()
  {
    if ((this.a.c.o.getVisibility() != 0) && (this.a.c.c.getVisibility() == 0)) {
      this.a.c.n.setOnClickListener(new GuildPngFrameManager.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.manager.GuildPngFrameManager.1
 * JD-Core Version:    0.7.0.1
 */