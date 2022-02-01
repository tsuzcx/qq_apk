package com.tencent.mobileqq.guild.chatpie.manager;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildMarketFaceItemBuilder.Holder;

class GuildPngFrameManager$1$1
  implements View.OnClickListener
{
  GuildPngFrameManager$1$1(GuildPngFrameManager.1 param1) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.c.o.getVisibility() == 0) {
      return;
    }
    if (this.a.a.c.c.getVisibility() == 0)
    {
      this.a.a.f = true;
      this.a.a.c.o.setVisibility(0);
      this.a.this$0.e(this.a.a);
      if (this.a.a.g != null) {
        this.a.a.g.a(this.a.a.c);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.manager.GuildPngFrameManager.1.1
 * JD-Core Version:    0.7.0.1
 */