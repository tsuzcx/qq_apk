package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.ChatMessage;

public class GuildMsgItemLayout$AvatarViewInfo
{
  public boolean a = true;
  public String b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h = 0;
  public int i = 0;
  public int j = 0;
  public int k = 0;
  public int l = 0;
  
  public GuildMsgItemLayout$AvatarViewInfo(GuildMsgItemLayout paramGuildMsgItemLayout, String paramString, ChatMessage paramChatMessage)
  {
    this.b = paramString;
    this.c = GuildMsgItemLayout.i;
    this.d = GuildMsgItemLayout.i;
    this.e = GuildMsgItemLayout.j;
    this.f = 0;
    float f1;
    if (paramChatMessage.mNeedTimeStamp) {
      f1 = 52.0F;
    } else {
      f1 = 25.333334F;
    }
    this.g = AIOUtils.b(f1, paramGuildMsgItemLayout.getResources());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildMsgItemLayout.AvatarViewInfo
 * JD-Core Version:    0.7.0.1
 */