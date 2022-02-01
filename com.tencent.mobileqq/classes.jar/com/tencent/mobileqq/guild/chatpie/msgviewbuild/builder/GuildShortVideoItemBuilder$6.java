package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.text.TextUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.MessageProgressView.AnimRunnableListener;

class GuildShortVideoItemBuilder$6
  implements MessageProgressView.AnimRunnableListener
{
  GuildShortVideoItemBuilder$6(GuildShortVideoItemBuilder paramGuildShortVideoItemBuilder, GuildShortVideoItemBuilder.Holder paramHolder) {}
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.q.frienduin);
      localStringBuilder.append(this.a.q.uniseq);
      if (paramString.equals(localStringBuilder.toString())) {
        this.a.b.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildShortVideoItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */