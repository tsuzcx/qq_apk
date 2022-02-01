package com.tencent.mobileqq.guild;

import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildPicBuilder.DrawURL;

public final class GuildAIOPicThumbDrawableObject$Builder
{
  MessageForPic a;
  ChatThumbView b;
  int[] c;
  BaseGuildPicBuilder.DrawURL d;
  
  public GuildAIOPicThumbDrawableObject$Builder(MessageForPic paramMessageForPic)
  {
    this.a = paramMessageForPic;
  }
  
  public Builder a(ChatThumbView paramChatThumbView)
  {
    this.b = paramChatThumbView;
    return this;
  }
  
  public Builder a(BaseGuildPicBuilder.DrawURL paramDrawURL)
  {
    this.d = paramDrawURL;
    return this;
  }
  
  public Builder a(int[] paramArrayOfInt)
  {
    this.c = paramArrayOfInt;
    return this;
  }
  
  public GuildAIOPicThumbDrawableObject a()
  {
    return new GuildAIOPicThumbDrawableObject(this, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.GuildAIOPicThumbDrawableObject.Builder
 * JD-Core Version:    0.7.0.1
 */