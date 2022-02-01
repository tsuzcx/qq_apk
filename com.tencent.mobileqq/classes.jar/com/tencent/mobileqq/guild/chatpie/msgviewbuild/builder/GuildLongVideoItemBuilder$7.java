package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.text.TextUtils;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.MessageProgressView.AnimRunnableListener;

class GuildLongVideoItemBuilder$7
  implements MessageProgressView.AnimRunnableListener
{
  GuildLongVideoItemBuilder$7(GuildLongVideoItemBuilder paramGuildLongVideoItemBuilder, GuildLongVideoItemBuilder.Holder paramHolder) {}
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.q.frienduin);
      localStringBuilder.append(this.a.q.uniseq);
      if (paramString.equals(localStringBuilder.toString())) {
        this.a.c.setDrawStatus(2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildLongVideoItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */