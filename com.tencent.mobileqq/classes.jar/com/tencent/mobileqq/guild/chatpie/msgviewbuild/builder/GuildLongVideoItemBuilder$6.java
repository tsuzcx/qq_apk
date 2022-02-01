package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.text.TextUtils;
import com.tencent.mobileqq.customviews.VideoProgressView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.multimsg.save.FileSaveResult;
import com.tencent.mobileqq.multimsg.save.ISingleFileSaveCallBack;

class GuildLongVideoItemBuilder$6
  implements ISingleFileSaveCallBack
{
  GuildLongVideoItemBuilder$6(GuildLongVideoItemBuilder paramGuildLongVideoItemBuilder, String paramString, GuildLongVideoItemBuilder.Holder paramHolder) {}
  
  public void a()
  {
    if (!TextUtils.isEmpty(this.a))
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b.q.frienduin);
      localStringBuilder.append(this.b.q.uniseq);
      if (str.equals(localStringBuilder.toString())) {
        this.b.c.setVisibility(8);
      }
    }
  }
  
  public void a(FileSaveResult paramFileSaveResult)
  {
    GuildLongVideoItemBuilder.a(this.c, paramFileSaveResult, this.a, this.b, this);
  }
  
  public void a(FileSaveResult paramFileSaveResult, int paramInt)
  {
    this.c.a(this.b, paramInt, false);
  }
  
  public void b(FileSaveResult paramFileSaveResult) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildLongVideoItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */