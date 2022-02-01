package com.tencent.mobileqq.guild.live.widget;

import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.guild.util.urldrawable.GuildURLDrawableUtil;

class GuildLiveBlurURLImageView$2
  implements Runnable
{
  GuildLiveBlurURLImageView$2(GuildLiveBlurURLImageView paramGuildLiveBlurURLImageView, URLDrawable paramURLDrawable, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Drawable localDrawable = GuildURLDrawableUtil.a(this.this$0.getResources(), this.a, GuildLiveBlurURLImageView.a(), this.b);
    this.this$0.setImageDrawableOnUiThread(localDrawable, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.widget.GuildLiveBlurURLImageView.2
 * JD-Core Version:    0.7.0.1
 */