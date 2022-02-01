package com.tencent.mobileqq.guild.chatpie.clickprocessor;

public class GuildLiveChannelPieClickProcessor
  extends GuildPieClickProcessor
{
  public InputBarBtnClickCallback a()
  {
    if (this.a == null) {
      this.a = new LiveChannelInputBarBtnClickCallback();
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.clickprocessor.GuildLiveChannelPieClickProcessor
 * JD-Core Version:    0.7.0.1
 */